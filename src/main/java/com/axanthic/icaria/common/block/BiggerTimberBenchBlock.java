package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.BenchEntity;
import com.axanthic.icaria.common.enums.DepthSpan;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.shapes.BiggerTimberBenchVoxelShapes;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BiggerTimberBenchBlock extends Block {
	public BiggerTimberBenchBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.BENCH_TAKEN, false).setValue(IcariaBlockStateProperties.DEPTH_SPAN, DepthSpan.FRONT).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Direction pDirection) {
		return pBlockState.getValue(IcariaBlockStateProperties.BENCH_TAKEN) ? 15 : 0;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.BENCH_TAKEN, IcariaBlockStateProperties.DEPTH_SPAN, BlockStateProperties.HORIZONTAL_FACING);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(BiggerTimberBenchBlock.getMultiBlockPos(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlockAndUpdate(pBlockPos, Blocks.AIR.defaultBlockState());
		pLevel.setBlockAndUpdate(pBlockPos.relative(pDirection.getOpposite(), 1), Blocks.AIR.defaultBlockState());
		pLevel.setBlockAndUpdate(pBlockPos.relative(pDirection.getOpposite(), 2), Blocks.AIR.defaultBlockState());
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.DEPTH_SPAN, DepthSpan.FRONT));
		pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite(), 1), pBlockState.setValue(IcariaBlockStateProperties.DEPTH_SPAN, DepthSpan.CENTER));
		pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite(), 2), pBlockState.setValue(IcariaBlockStateProperties.DEPTH_SPAN, DepthSpan.BACK));
	}

	public static BlockPos getMultiBlockPos(BlockPos pBlockPos, BlockState pBlockState) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (pBlockState.getValue(IcariaBlockStateProperties.DEPTH_SPAN) == DepthSpan.FRONT) {
			return pBlockPos;
		} else if (pBlockState.getValue(IcariaBlockStateProperties.DEPTH_SPAN) == DepthSpan.CENTER) {
			return pBlockPos.relative(direction, 1);
		} else {
			return pBlockPos.relative(direction, 2);
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		if (level.getBlockState(blockPos).canBeReplaced() && level.getBlockState(blockPos.relative(pBlockPlaceContext.getHorizontalDirection(), 1)).canBeReplaced() && level.getBlockState(blockPos.relative(pBlockPlaceContext.getHorizontalDirection(), 2)).canBeReplaced()) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.drop(pBlockPos, pBlockState, pLevel);
		this.removeMultiBlock(BiggerTimberBenchBlock.getMultiBlockPos(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (!pBlockState.getValue(IcariaBlockStateProperties.BENCH_TAKEN)) {
			var bench = new BenchEntity(IcariaEntityTypes.BENCH.get(), pLevel);
			bench.snapTo(pBlockPos.getX() + 0.5D, pBlockPos.getY(), pBlockPos.getZ() + 0.5D);
			pLevel.addFreshEntity(bench);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.BENCH_TAKEN, true));
			pPlayer.startRiding(bench);
			return InteractionResult.CONSUME;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.DEPTH_SPAN)) {
			case FRONT -> this.getFront(pBlockState);
			case CENTER -> this.getCenter(pBlockState);
			case BACK -> this.getBack(pBlockState);
		};
	}

	public VoxelShape getFront(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> BiggerTimberBenchVoxelShapes.FRONT_NORTH;
			case EAST -> BiggerTimberBenchVoxelShapes.FRONT_EAST;
			case SOUTH -> BiggerTimberBenchVoxelShapes.FRONT_SOUTH;
			default -> BiggerTimberBenchVoxelShapes.FRONT_WEST;
		};
	}

	public VoxelShape getCenter(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> BiggerTimberBenchVoxelShapes.CENTER_NORTH;
			case EAST -> BiggerTimberBenchVoxelShapes.CENTER_EAST;
			case SOUTH -> BiggerTimberBenchVoxelShapes.CENTER_SOUTH;
			default -> BiggerTimberBenchVoxelShapes.CENTER_WEST;
		};
	}

	public VoxelShape getBack(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> BiggerTimberBenchVoxelShapes.BACK_NORTH;
			case EAST -> BiggerTimberBenchVoxelShapes.BACK_EAST;
			case SOUTH -> BiggerTimberBenchVoxelShapes.BACK_SOUTH;
			default -> BiggerTimberBenchVoxelShapes.BACK_WEST;
		};
	}
}
