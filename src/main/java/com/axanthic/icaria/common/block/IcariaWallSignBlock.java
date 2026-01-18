package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSignBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.IcariaWallSignVoxelShapes;

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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallSignBlock extends WallSignBlock implements EntityBlock, MediterraneanWaterloggedBlock {
	public IcariaWallSignBlock(WoodType pWoodType, Properties pProperties) {
		super(pWoodType, pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var direction = this.getConnectedDirection(pBlockState).getOpposite();
		return pLevelReader.getBlockState(pBlockPos.relative(direction)).isSolid();
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaSignBlockEntity(pBlockPos, pBlockState);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();

		var fluidState = level.getFluidState(blockPos);
		var fluid = fluidState.getType();

		for (var direction : pBlockPlaceContext.getNearestLookingDirections()) {
			var blockState = this.placeState(pBlockPlaceContext, direction, fluid);
			if (blockState.canSurvive(level, blockPos)) {
				return blockState;
			}
		}

		return null;
	}

	public BlockState placeState(BlockPlaceContext pBlockPlaceContext, Direction pDirection, Fluid pFluid) {
		if (pDirection.getAxis() == Direction.Axis.Y) {
			return this.defaultBlockState().setValue(BlockStateProperties.ATTACH_FACE, pDirection == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pFluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, pFluid == Fluids.WATER);
		} else {
			return this.defaultBlockState().setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pFluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, pFluid == Fluids.WATER);
		}
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return this.getConnectedDirection(pBlockState).getOpposite() == pDirection && !pBlockState.canSurvive(pLevelReader, pBlockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	public Direction getConnectedDirection(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.ATTACH_FACE)) {
			case CEILING -> Direction.DOWN;
			case FLOOR -> Direction.UP;
			case WALL -> pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		};
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.ATTACH_FACE)) {
			case CEILING -> this.getCeiling(pBlockState);
			case FLOOR -> this.getFloor(pBlockState);
			case WALL -> this.getWall(pBlockState);
		};
	}

	public VoxelShape getCeiling(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> IcariaWallSignVoxelShapes.CEILING_NORTH;
			case EAST -> IcariaWallSignVoxelShapes.CEILING_EAST;
			case SOUTH -> IcariaWallSignVoxelShapes.CEILING_SOUTH;
			default -> IcariaWallSignVoxelShapes.CEILING_WEST;
		};
	}

	public VoxelShape getFloor(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> IcariaWallSignVoxelShapes.FLOOR_NORTH;
			case EAST -> IcariaWallSignVoxelShapes.FLOOR_EAST;
			case SOUTH -> IcariaWallSignVoxelShapes.FLOOR_SOUTH;
			default -> IcariaWallSignVoxelShapes.FLOOR_WEST;
		};
	}

	public VoxelShape getWall(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> IcariaWallSignVoxelShapes.WALL_NORTH;
			case EAST -> IcariaWallSignVoxelShapes.WALL_EAST;
			case SOUTH -> IcariaWallSignVoxelShapes.WALL_SOUTH;
			default -> IcariaWallSignVoxelShapes.WALL_WEST;
		};
	}
}
