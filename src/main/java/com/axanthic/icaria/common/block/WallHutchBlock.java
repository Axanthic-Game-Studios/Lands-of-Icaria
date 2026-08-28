package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.WallHutchVoxelShapes;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WallHutchBlock extends HutchBlock implements EntityBlock {
	public WallHutchBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var blockPos = pBlockPos.relative(direction.getOpposite());
		return direction.getAxis().isHorizontal() && pLevelReader.getBlockState(blockPos).isFaceSturdy(pLevelReader, blockPos, direction);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockState = this.defaultBlockState();

		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();

		var fluidState = level.getFluidState(blockPos);
		var fluid = fluidState.getType();

		for (var direction : pBlockPlaceContext.getNearestLookingDirections()) {
			if (direction.getAxis().isHorizontal()) {
				blockState = blockState.setValue(BlockStateProperties.HORIZONTAL_FACING, direction.getOpposite());
				if (blockState.canSurvive(level, blockPos)) {
					return blockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(IcariaBlockStateProperties.MULTI_HUTCH, this.hasHutchBelow(blockPos, level)).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
				}
			}
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.canSurvive(pLevelReader, pBlockPos) ? pBlockState.setValue(IcariaBlockStateProperties.MULTI_HUTCH, this.hasHutchBelow(pBlockPos, pLevelReader)) : Blocks.AIR.defaultBlockState();
	}

	public VoxelShape getMulti(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> WallHutchVoxelShapes.MULTI_NORTH;
			case EAST -> WallHutchVoxelShapes.MULTI_EAST;
			case SOUTH -> WallHutchVoxelShapes.MULTI_SOUTH;
			default -> WallHutchVoxelShapes.MULTI_WEST;
		};
	}

	public VoxelShape getShape(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> WallHutchVoxelShapes.NORTH;
			case EAST -> WallHutchVoxelShapes.EAST;
			case SOUTH -> WallHutchVoxelShapes.SOUTH;
			default -> WallHutchVoxelShapes.WEST;
		};
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return pBlockState.getValue(IcariaBlockStateProperties.MULTI_HUTCH) ? this.getMulti(pBlockState) : this.getShape(pBlockState);
	}
}
