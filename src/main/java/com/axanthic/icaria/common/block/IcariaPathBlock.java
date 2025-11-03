package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.LayerVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPathBlock extends Block {
	public Block block;

	public IcariaPathBlock(Block pBlock, Properties pProperties) {
		super(pProperties);
		this.block = pBlock;
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var blockState = pLevelReader.getBlockState(pBlockPos.above());
		return !blockState.isSolid() || blockState.getBlock() instanceof FenceGateBlock;
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pBlockState) {
		return true;
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (!pBlockState.canSurvive(pServerLevel, pBlockPos)) {
			this.turnToBase(pBlockPos, pBlockState, pServerLevel);
		}
	}

	public void turnToBase(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		pLevel.setBlockAndUpdate(pBlockPos, Block.pushEntitiesUp(pBlockState, this.block.defaultBlockState(), pLevel, pBlockPos));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return this.defaultBlockState().canSurvive(pBlockPlaceContext.getLevel(), pBlockPlaceContext.getClickedPos()) ? this.defaultBlockState() : this.block.defaultBlockState();
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		pScheduledTickAccess.scheduleTick(pBlockPos, this, 0);
		return super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return LayerVoxelShapes.Y_15;
	}
}
