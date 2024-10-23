package com.axanthic.icaria.common.shapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TripleBarrelRackShapes {
	public static final VoxelShape BOTTOM_LEFT_NORTH = Stream.of(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(-16.0D, 0.0D, 0.0D, 0.0D, 16.0D, 16.0D), Block.box(-8.0D, 16.0D, 0.0D, 8.0D, 29.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BOTTOM_LEFT_EAST = Stream.of(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, -16.0D, 16.0D, 16.0D, 0.0D), Block.box(0.0D, 16.0D, -8.0D, 16.0D, 29.0D, 8.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BOTTOM_LEFT_SOUTH = Stream.of(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(16.0D, 0.0D, 0.0D, 32.0D, 16.0D, 16.0D), Block.box(8.0D, 16.0D, 0.0D, 24.0D, 29.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BOTTOM_LEFT_WEST = Stream.of(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 16.0D, 16.0D, 16.0D, 32.0D), Block.box(0.0D, 16.0D, 8.0D, 16.0D, 29.0D, 24.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();

	public static final VoxelShape BOTTOM_RIGHT_NORTH = Stream.of(Block.box(16.0D, 0.0D, 0.0D, 32.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 16.0D, 0.0D, 24.0D, 29.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BOTTOM_RIGHT_EAST = Stream.of(Block.box(0.0D, 0.0D, 16.0D, 16.0D, 16.0D, 32.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 16.0D, 8.0D, 16.0D, 29.0D, 24.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BOTTOM_RIGHT_SOUTH = Stream.of(Block.box(-16.0D, 0.0D, 0.0D, 0.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(-8.0D, 16.0D, 0.0D, 8.0D, 29.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BOTTOM_RIGHT_WEST = Stream.of(Block.box(0.0D, 0.0D, -16.0D, 16.0D, 16.0D, 0.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 16.0D, -8.0D, 16.0D, 29.0D, 8.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();

	public static final VoxelShape TOP_LEFT_NORTH = Stream.of(Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(-16.0D, -16.0D, 0.0D, 0.0D, 0.0D, 16.0D), Block.box(-8.0D, 0.0D, 0.0D, 8.0D, 13.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape TOP_LEFT_EAST = Stream.of(Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, -16.0D, -16.0D, 16.0D, 0.0D, 0.0D), Block.box(0.0D, 0.0D, -8.0D, 16.0D, 13.0D, 8.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape TOP_LEFT_SOUTH = Stream.of(Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(16.0D, -16.0D, 0.0D, 32.0D, 0.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 24.0D, 13.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape TOP_LEFT_WEST = Stream.of(Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, -16.0D, 16.0D, 16.0D, 0.0D, 32.0D), Block.box(0.0D, 0.0D, 8.0D, 16.0D, 13.0D, 24.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();

	public static final VoxelShape TOP_RIGHT_NORTH = Stream.of(Block.box(16.0D, -16.0D, 0.0D, 32.0D, 0.0D, 16.0D), Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 24.0D, 13.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape TOP_RIGHT_EAST = Stream.of(Block.box(0.0D, -16.0D, 16.0D, 16.0D, 0.0D, 32.0D), Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 16.0D, 13.0D, 24.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape TOP_RIGHT_SOUTH = Stream.of(Block.box(-16.0D, -16.0D, 0.0D, 0.0D, 0.0D, 16.0D), Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(-8.0D, 0.0D, 0.0D, 8.0D, 13.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape TOP_RIGHT_WEST = Stream.of(Block.box(0.0D, -16.0D, -16.0D, 16.0D, 0.0D, 0.0D), Block.box(0.0D, -16.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, -8.0D, 16.0D, 13.0D, 8.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
