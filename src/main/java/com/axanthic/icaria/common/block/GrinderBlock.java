package com.axanthic.icaria.common.block;

import java.util.Objects;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.registry.IcariaBlockEntities;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkHooks;

public class GrinderBlock extends BaseEntityBlock {

	public static final VoxelShape GRINDER_AABB = Block.box(1D, 0.0D, 1D, 15D, 14D, 15D);
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final BooleanProperty BURNING = BooleanProperty.create("burning");

	public GrinderBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BURNING, false));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING, BURNING);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new GrinderBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
	}

	@Override
	public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
		if (!pState.is(pNewState.getBlock())) {
			BlockEntity entity = pLevel.getBlockEntity(pPos);
			if (entity instanceof GrinderBlockEntity) {
				Objects.requireNonNull(pLevel.getBlockEntity(pPos)).getCapability(ForgeCapabilities.ITEM_HANDLER)
						.ifPresent(handler -> {
							for (int i = 0; i < handler.getSlots(); i++) {
								ItemStack stack = handler.getStackInSlot(i);
								Containers.dropItemStack(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), stack);
							}
						});

				pLevel.updateNeighbourForOutputSignal(pPos, this);
			}

			super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
		}
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pTrace) {
		if (!pLevel.isClientSide) {
			BlockEntity entity = pLevel.getBlockEntity(pPos);
			if (entity instanceof GrinderBlockEntity) {
				MenuProvider provider = new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.translatable("menu." + IcariaInfo.MODID + ".crafting.grinder");
					}

					@Override
					public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
						return new GrinderMenu(pContainerId, pPos, pInventory, pPlayer);
					}
				};

				NetworkHooks.openScreen((ServerPlayer) pPlayer, provider, entity.getBlockPos());
			}
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return GRINDER_AABB;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		if (!pLevel.isClientSide) {
			return createTickerHelper(pBlockEntityType, IcariaBlockEntities.GRINDER.get(),
					GrinderBlockEntity::tick);
		}
		return null;
	}
}
