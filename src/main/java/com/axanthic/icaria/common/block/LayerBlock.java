package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LayerBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public static final VoxelShape[] SHAPES = new VoxelShape[] {
		Shapes.empty(), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
	};

	public LayerBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.LAYERS, 1).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		int i = pState.getValue(BlockStateProperties.LAYERS);
		if (pUseContext.getItemInHand().is(this.asItem()) && i < 8) {
			if (pUseContext.replacingClickedOnBlock()) {
				return pUseContext.getClickedFace() == Direction.UP;
			} else {
				return true;
			}
		} else {
			return i == 1;
		}
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var belowState = pLevel.getBlockState(pPos.below());
		return Block.isFaceFull(belowState.getCollisionShape(pLevel, pPos.below()), Direction.UP) || belowState.is(this) && belowState.getValue(BlockStateProperties.LAYERS) == 8;
	}

	@Override
	public boolean isPathfindable(BlockState pState, PathComputationType pType) {
		if (pType == PathComputationType.LAND) {
			return pState.getValue(BlockStateProperties.LAYERS) < 5;
		}

		return false;
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.LAYERS, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var clickedPos = pContext.getClickedPos();
		var level = pContext.getLevel();
		var clickedState = level.getBlockState(clickedPos);
		var fluid = level.getFluidState(clickedPos).getType();
		if (clickedState.is(this)) {
			return clickedState.setValue(BlockStateProperties.LAYERS, Math.min(8, clickedState.getValue(BlockStateProperties.LAYERS) + 1));
		} else {
			return super.getStateForPlacement(pContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
		}
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
		return LayerBlock.SHAPES[pState.getValue(BlockStateProperties.LAYERS)];
	}

	@Override
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return LayerBlock.SHAPES[pState.getValue(BlockStateProperties.LAYERS) - 1];
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return LayerBlock.SHAPES[pState.getValue(BlockStateProperties.LAYERS)];
	}

	@Override
	public VoxelShape getVisualShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return LayerBlock.SHAPES[pState.getValue(BlockStateProperties.LAYERS)];
	}
}
