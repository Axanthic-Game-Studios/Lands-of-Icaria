package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.LayerVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LayerBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public LayerBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.LAYERS, 1).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canBeReplaced(BlockState pBlockState, BlockPlaceContext pBlockPlaceContext) {
		int i = pBlockState.getValue(BlockStateProperties.LAYERS);
		if (pBlockPlaceContext.getItemInHand().is(this.asItem()) && i < 8) {
			if (pBlockPlaceContext.replacingClickedOnBlock()) {
				return pBlockPlaceContext.getClickedFace() == Direction.UP;
			} else {
				return true;
			}
		} else {
			return i == 1;
		}
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var blockPos = pBlockPos.below();
		var blockState = pLevelReader.getBlockState(blockPos);
		return Block.isFaceFull(blockState.getCollisionShape(pLevelReader, blockPos), Direction.UP) || blockState.is(this) && blockState.getValue(BlockStateProperties.LAYERS) == 8;
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return pPathComputationType == PathComputationType.LAND && pBlockState.getValue(BlockStateProperties.LAYERS) <= 4;
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pBlockState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.LAYERS, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		var blockState = level.getBlockState(blockPos);
		var fluid = level.getFluidState(blockPos).getType();
		if (blockState.is(this)) {
			return blockState.setValue(BlockStateProperties.LAYERS, Math.min(blockState.getValue(BlockStateProperties.LAYERS) + 1, 8));
		} else {
			return this.defaultBlockState().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
		}
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.canSurvive(pLevelReader, pBlockPos) ? super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource) : Blocks.AIR.defaultBlockState();
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return LayerVoxelShapes.SHAPES.get(pBlockState.getValue(BlockStateProperties.LAYERS) - 1);
	}
}
