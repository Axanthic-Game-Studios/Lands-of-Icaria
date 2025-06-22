package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.entity.GrinderRedirectorBlockEntity;
import com.axanthic.icaria.common.menu.provider.GrinderMenuProvider;
import com.axanthic.icaria.common.properties.Side;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.GrinderShapes;

import com.mojang.serialization.MapCodec;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlock extends BaseEntityBlock {
	public static final MapCodec<GrinderBlock> CODEC = Block.simpleCodec(GrinderBlock::new);

	public GrinderBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.GRINDER_GRINDING, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.SIDE, Side.LEFT));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	public double getX(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case EAST -> 1.25D;
			case WEST -> -0.25D;
			default -> 0.5D;
		};
	}

	public double getXSpeed(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case EAST -> 0.25D;
			case WEST -> -0.25D;
			default -> 0.0D;
		};
	}

	public double getZ(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> -0.25D;
			case SOUTH -> 1.25D;
			default -> 0.5D;
		};
	}

	public double getZSpeed(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> -0.25D;
			case SOUTH -> 0.25D;
			default -> 0.0D;
		};
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pLevel.getBlockEntity(GrinderBlock.getBlockEntityPosition(pBlockPos, pBlockState)) instanceof GrinderBlockEntity blockEntity ? blockEntity.getRedstoneStrength() : 0;
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pBlockState.getValue(IcariaBlockStateProperties.GRINDER_GRINDING) && pLevel.getBlockEntity(pBlockPos) instanceof GrinderBlockEntity blockEntity) {
			var itemStack = blockEntity.inputHandler.getStackInSlot(0);
			if (blockEntity.tickClient && !itemStack.isEmpty()) {
				pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemStack), pBlockPos.getX() + 0.5D, pBlockPos.getY() + 1.0D, pBlockPos.getZ() + 0.5D, 0.0D, 0.25D, 0.0D);
				pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemStack), this.getX(pBlockState) + pBlockPos.getX(), pBlockPos.getY() + 0.25D, this.getZ(pBlockState) + pBlockPos.getZ(), this.getXSpeed(pBlockState), -0.25D, this.getZSpeed(pBlockState));
			}
		}
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.GRINDER_GRINDING, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.SIDE);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.removeMultiBlock(GrinderBlock.getBlockEntityPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlock(pBlockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.SIDE, Side.LEFT), 3);
		pLevel.setBlock(pBlockPos.offset(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.SIDE, Side.RIGHT), 3);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.SIDE) == Side.LEFT) {
			return new GrinderBlockEntity(pBlockPos, pBlockState);
		} else {
			return new GrinderRedirectorBlockEntity(pBlockPos, pBlockState);
		}
	}

	public static BlockPos getBlockEntityPosition(BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.SIDE) == Side.LEFT) {
			return pBlockPos;
		} else {
			return pBlockPos.offset(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getClockWise().getUnitVec3i());
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos.offset(pBlockPlaceContext.getHorizontalDirection().getOpposite().getCounterClockWise().getUnitVec3i())).canBeReplaced(pBlockPlaceContext)) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		var blockState = pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
		return pMirror == Mirror.NONE ? blockState : blockState.setValue(IcariaBlockStateProperties.SIDE, blockState.getValue(IcariaBlockStateProperties.SIDE).getOpposite());
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.removeMultiBlock(GrinderBlock.getBlockEntityPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		var blockPos = GrinderBlock.getBlockEntityPosition(pBlockPos, pBlockState);
		if (pLevel instanceof ServerLevel serverLevel && serverLevel.getBlockEntity(blockPos) instanceof GrinderBlockEntity blockEntity) {
			pPlayer.openMenu(new GrinderMenuProvider(blockEntity));
			return InteractionResult.SUCCESS_SERVER;
		} else {
			return InteractionResult.SUCCESS;
		}
	}

	@Override
	public MapCodec<? extends BaseEntityBlock> codec() {
		return GrinderBlock.CODEC;
	}

	@Override
	public RenderShape getRenderShape(BlockState pBlockState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pLevel, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.SIDE)) {
			case LEFT -> this.getLeft(pBlockState);
			case RIGHT -> this.getRight(pBlockState);
		};
	}

	public VoxelShape getLeft(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> GrinderShapes.LEFT_NORTH;
			case EAST -> GrinderShapes.LEFT_EAST;
			case SOUTH -> GrinderShapes.LEFT_SOUTH;
			default -> GrinderShapes.LEFT_WEST;
		};
	}

	public VoxelShape getRight(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> GrinderShapes.RIGHT_NORTH;
			case EAST -> GrinderShapes.RIGHT_EAST;
			case SOUTH -> GrinderShapes.RIGHT_SOUTH;
			default -> GrinderShapes.RIGHT_WEST;
		};
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pBlockState, BlockEntityType<T> pBlockEntityType) {
		return pLevel instanceof ServerLevel serverlevel ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.GRINDER.get(), (level, blockPos, blockState, blockEntity) -> GrinderBlockEntity.tick(blockEntity, blockPos, blockState, serverlevel)) : null;
	}
}
