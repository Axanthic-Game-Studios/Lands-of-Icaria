package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.entity.GrinderRedirectorBlockEntity;
import com.axanthic.icaria.common.menu.provider.GrinderMenuProvider;
import com.axanthic.icaria.common.properties.Side;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaShapes;

import com.mojang.serialization.MapCodec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlock extends BaseEntityBlock {
	public static final MapCodec<GrinderBlock> CODEC = Block.simpleCodec(GrinderBlock::new);

	public GrinderBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.GRINDER_GRINDING, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.SIDE, Side.LEFT));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pState, BlockGetter pLevel, BlockPos pPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pState) {
		return true;
	}

	public double getX(BlockState pState) {
		return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case EAST -> 1.25D;
			case WEST -> -0.25D;
			default -> 0.5D;
		};
	}

	public double getZ(BlockState pState) {
		return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> -0.25D;
			case SOUTH -> 1.25D;
			default -> 0.5D;
		};
	}

	public double getSpeedX(BlockState pState) {
		return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case EAST -> 0.25D;
			case WEST -> -0.25D;
			default -> 0.0D;
		};
	}

	public double getSpeedZ(BlockState pState) {
		return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> -0.25D;
			case SOUTH -> 0.25D;
			default -> 0.0D;
		};
	}

	@Override
	public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
		return pLevel.getBlockEntity(GrinderBlock.getBlockEntityPosition(pState, pPos)) instanceof GrinderBlockEntity blockEntity ? blockEntity.getComparatorInput() : 0;
	}

	@Override
	public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pState.getValue(IcariaBlockStateProperties.GRINDER_GRINDING)) {
			if (pLevel.getBlockEntity(pPos) instanceof GrinderBlockEntity blockEntity) {
				var itemStack = blockEntity.inputHandler.getStackInSlot(0);
				if (!itemStack.isEmpty()) {
					pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemStack), pPos.getX() + 0.5D, pPos.getY() + 1.0D, pPos.getZ() + 0.5D, 0.0D, 0.25D, 0.0D);
					pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemStack), pPos.getX() + this.getX(pState), pPos.getY() + 0.25D, pPos.getZ() + this.getZ(pState), this.getSpeedX(pState), -0.25D, this.getSpeedZ(pState));
				}
			}
		}
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.GRINDER_GRINDING, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.SIDE);
	}

	@Override
	public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
		var blockPos = GrinderBlock.getBlockEntityPosition(pState, pPos);
		var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(blockPos.offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
		super.onBlockExploded(pState, pLevel, pPos, pExplosion);
	}

	@Override
	public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
		if (pState.getBlock() != pNewState.getBlock()) {
			if (pLevel.getBlockEntity(pPos) instanceof GrinderBlockEntity blockEntity) {
				if (pLevel instanceof ServerLevel serverLevel) {
					blockEntity.drops(serverLevel);
					blockEntity.getRecipesToAwardAndPopExperience(serverLevel, Vec3.atCenterOf(pPos));
					Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.GRINDER.get()));
				}
			}
		}

		super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
		var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pLevel.setBlock(pPos.offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.SIDE, Side.RIGHT), 3);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		if (pState.getValue(IcariaBlockStateProperties.SIDE) == Side.LEFT) {
			return new GrinderBlockEntity(pPos, pState);
		} else {
			return new GrinderRedirectorBlockEntity(pPos, pState);
		}
	}

	public static BlockPos getBlockEntityPosition(BlockState pState, BlockPos pPos) {
		var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (pState.getValue(IcariaBlockStateProperties.SIDE) == Side.LEFT) {
			return pPos;
		} else {
			return pPos.offset(facing.getClockWise().getNormal());
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var blockPos = pContext.getClickedPos();
		var facing = pContext.getHorizontalDirection().getOpposite();
		var level = pContext.getLevel();
		if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.offset(facing.getCounterClockWise().getNormal())).canBeReplaced(pContext)) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		var state = pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
		return pMirror == Mirror.NONE ? state : state.setValue(IcariaBlockStateProperties.SIDE, state.getValue(IcariaBlockStateProperties.SIDE).getOpposite());
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
		var blockPos = GrinderBlock.getBlockEntityPosition(pState, pPos);
		var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(blockPos.offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
		return super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pResult) {
		var blockEntityPosition = GrinderBlock.getBlockEntityPosition(pState, pPos);
		var blockEntity = pLevel.getBlockEntity(blockEntityPosition);
		if (!pLevel.isClientSide()) {
			if (pPlayer instanceof ServerPlayer serverPlayer) {
				if (blockEntity instanceof GrinderBlockEntity || blockEntity instanceof GrinderRedirectorBlockEntity) {
					serverPlayer.openMenu(new GrinderMenuProvider(blockEntityPosition), blockEntityPosition);
				}
			}
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return GrinderBlock.CODEC;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return switch (pState.getValue(IcariaBlockStateProperties.SIDE)) {
			case LEFT -> switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
				case NORTH -> IcariaShapes.GrinderShapes.LEFT_NORTH;
				case EAST -> IcariaShapes.GrinderShapes.LEFT_EAST;
				case SOUTH -> IcariaShapes.GrinderShapes.LEFT_SOUTH;
				default -> IcariaShapes.GrinderShapes.LEFT_WEST;
			};

			case RIGHT -> switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
				case NORTH -> IcariaShapes.GrinderShapes.RIGHT_NORTH;
				case EAST -> IcariaShapes.GrinderShapes.RIGHT_EAST;
				case SOUTH -> IcariaShapes.GrinderShapes.RIGHT_SOUTH;
				default -> IcariaShapes.GrinderShapes.RIGHT_WEST;
			};
		};
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
		return !pLevel.isClientSide() ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockEntity::tick) : null;
	}
}
