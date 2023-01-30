package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkHooks;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty GRINDING = BooleanProperty.create("grinding");
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public static final DirectionProperty FACING = BlockStateProperties.FACING;

	public static final IntegerProperty ROTATION = IntegerProperty.create("rotation", 0, 90);

	public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);

	public GrinderBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(GRINDING, false).setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH).setValue(ROTATION, 0));
	}

	@Override
	public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
		if (IcariaConfig.RENDER_GEARS.get()) {
			if (pState.getValue(GRINDING)) {
				GrinderBlockEntity blockEntity = (GrinderBlockEntity) pLevel.getBlockEntity(pPos);
				if (blockEntity != null) {
					ItemStack itemStack = blockEntity.itemStackHandler.getStackInSlot(0);
					if (!itemStack.isEmpty()) {
						if (pLevel.isClientSide) {
							pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemStack), pPos.getX() + 0.5D, pPos.getY() + 1.0D, pPos.getZ() + 0.5D, 0.0D, 0.25D, 0.0D);
						}
					}
				}
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(GRINDING, WATERLOGGED, FACING, ROTATION);
	}

	@Override
	public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
		if (!pState.is(pNewState.getBlock())) {
			BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
			if (blockEntity instanceof GrinderBlockEntity) {
				Objects.requireNonNull(pLevel.getBlockEntity(pPos)).getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(pItemHandler -> {
					for (int i = 0; i < pItemHandler.getSlots(); i++) {
						ItemStack itemStack = pItemHandler.getStackInSlot(i);
						Containers.dropItemStack(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), itemStack);
					}
				});

				pLevel.updateNeighbourForOutputSignal(pPos, this);
			}

			super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new GrinderBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection()).setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (!pLevel.isClientSide) {
			BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
			if (blockEntity instanceof GrinderBlockEntity) {
				MenuProvider menuProvider = new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.translatable("menu." + IcariaInfo.MODID + ".grinder");
					}

					@Override
					public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
						return new GrinderMenu(pContainerId, pPos, pInventory, pPlayer);
					}
				};

				NetworkHooks.openScreen((ServerPlayer) pPlayer, menuProvider, blockEntity.getBlockPos());
			}
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
		return !pLevel.isClientSide ? createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockEntity::tick) : null;
	}
}
