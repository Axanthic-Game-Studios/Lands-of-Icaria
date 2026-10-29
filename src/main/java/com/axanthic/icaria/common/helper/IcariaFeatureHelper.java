package com.axanthic.icaria.common.helper;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.enums.Olives;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFeatureHelper {

	public static void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			IcariaFeatureHelper.placeDead(pWorldGenLevel, pBlockPos, pBlockState, pAxis);
		}
	}

	public static void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() || pWorldGenLevel.getBlockState(pBlockPos).is(BlockItemTags.LEAVES.block())) {
			pWorldGenLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public static void placeFallenPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pChance) {
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.north(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.north(1).east(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.north(2), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.north(2).east(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.north(2).west(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.east(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.east(1).south(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.east(2), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.east(2).north(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.east(2).south(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.south(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.south(1).west(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.south(2), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.south(2).east(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.south(2).west(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.west(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.west(1).north(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.west(2), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.west(2).north(1), pBlockState, 1, pChance);
		IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.west(2).south(1), pBlockState, 1, pChance);
	}

	public static void placeFallen(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pHeight, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos, pBlockState, pHeight);
		}
	}

	public static void placeFallen(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pHeight) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			pWorldGenLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.LAYERS, pHeight));
		}
	}

	public static void placeLeaves(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState);
		}
	}

	public static void placeLeaves(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			pWorldGenLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.DISTANCE, 1));
		}
	}

	public static void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos, pBlockState, pAxis);
		}
	}

	public static void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() || pWorldGenLevel.getBlockState(pBlockPos).is(BlockItemTags.LEAVES.block())) {
			pWorldGenLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public static void placeOlives(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pChance) {
		if (pWorldGenLevel.getRandom().nextBoolean()) {
			if (pWorldGenLevel.getRandom().nextInt(2) == 0) {
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.BLACK), pChance);
			} else if (pWorldGenLevel.getRandom().nextInt(2) == 1) {
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.GREEN), pChance);
			} else {
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE), pChance);
			}
		} else {
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.LEAVES), pChance);
		}
	}

	public static void placeOlives(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getRandom().nextBoolean()) {
			if (pWorldGenLevel.getRandom().nextInt(2) == 0) {
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.BLACK));
			} else if (pWorldGenLevel.getRandom().nextInt(2) == 1) {
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.GREEN));
			} else {
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE));
			}
		} else {
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.OLIVES, Olives.LEAVES));
		}
	}

	public static void placeShroomsPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pChance) {
		IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.north().above(), pBlockState, Direction.NORTH, pChance);
		IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.east().above(), pBlockState, Direction.EAST, pChance);
		IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.south().above(), pBlockState, Direction.SOUTH, pChance);
		IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.west().above(), pBlockState, Direction.WEST, pChance);
	}

	public static void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos, pBlockState, pDirection);
		}
	}

	public static void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection.getOpposite())).is(BlockItemTags.LOGS.block())) {
			pWorldGenLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
		}
	}

	public static void placeTwigsPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pChance) {
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.north(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.north(1).east(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.north(2), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.north(2).east(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.north(2).west(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.east(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.east(1).south(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.east(2), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.east(2).north(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.east(2).south(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.south(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.south(1).west(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.south(2), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.south(2).east(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.south(2).west(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.west(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.west(1).north(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.west(2), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.west(2).north(1), pBlockState, pChance);
		IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos.west(2).south(1), pBlockState, pChance);
	}

	public static void placeTwigs(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			IcariaFeatureHelper.placeTwigs(pWorldGenLevel, pBlockPos, pBlockState);
		}
	}

	public static void placeTwigs(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			pWorldGenLevel.setBlockAndUpdate(pBlockPos, pBlockState);
		}
	}

	public static AABB aabb(BlockPos pBlockPos, Direction pDirection, int pLength, int pOffset, int pWidth) {
		return new AABB(
			pBlockPos.below().relative(pDirection.getClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection).getX(),
			pBlockPos.below().relative(pDirection.getClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection).getY(),
			pBlockPos.below().relative(pDirection.getClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection).getZ(),
			pBlockPos.below().relative(pDirection.getCounterClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection, pLength).getX(),
			pBlockPos.below().relative(pDirection.getCounterClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection, pLength).getY(),
			pBlockPos.below().relative(pDirection.getCounterClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection, pLength).getZ()
		);
	}

	public static AABB aabb(BlockPos pBlockPos) {
		return new AABB(
			pBlockPos.below().north().east().getX(),
			pBlockPos.below().north().east().getY(),
			pBlockPos.below().north().east().getZ(),
			pBlockPos.below().south().west().getX(),
			pBlockPos.below().south().west().getY(),
			pBlockPos.below().south().west().getZ()
		);
	}
}
