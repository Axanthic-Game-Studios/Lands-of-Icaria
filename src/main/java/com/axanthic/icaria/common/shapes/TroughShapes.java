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

public class TroughShapes {
	public static final VoxelShape NORTH = Stream.of(Block.box(1.0D, 4.0D, 8.0D, 15.0D, 5.0D, 9.0D), Block.box(15.0D, 4.0D, 8.0D, 16.0D, 5.0D, 16.0D), Block.box(1.0D, 4.0D, 15.0D, 15.0D, 5.0D, 16.0D), Block.box(0.0D, 4.0D, 8.0D, 1.0D, 5.0D, 16.0D), Block.box(1.0D, 1.0D, 8.0D, 15.0D, 4.0D, 9.0D), Block.box(15.0D, 1.0D, 8.0D, 16.0D, 4.0D, 16.0D), Block.box(1.0D, 1.0D, 15.0D, 15.0D, 4.0D, 16.0D), Block.box(0.0D, 1.0D, 8.0D, 1.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 16.0D, 1.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape EAST = Stream.of(Block.box(7.0D, 4.0D, 1.0D, 8.0D, 5.0D, 15.0D), Block.box(0.0D, 4.0D, 15.0D, 8.0D, 5.0D, 16.0D), Block.box(0.0D, 4.0D, 1.0D, 1.0D, 5.0D, 15.0D), Block.box(0.0D, 4.0D, 0.0D, 8.0D, 5.0D, 1.0D), Block.box(7.0D, 1.0D, 1.0D, 8.0D, 4.0D, 15.0D), Block.box(0.0D, 1.0D, 15.0D, 8.0D, 4.0D, 16.0D), Block.box(0.0D, 1.0D, 1.0D, 1.0D, 4.0D, 15.0D), Block.box(0.0D, 1.0D, 0.0D, 8.0D, 4.0D, 1.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 1.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape SOUTH = Stream.of(Block.box(1.0D, 4.0D, 7.0D, 15.0D, 5.0D, 8.0D), Block.box(0.0D, 4.0D, 0.0D, 1.0D, 5.0D, 8.0D), Block.box(1.0D, 4.0D, 0.0D, 15.0D, 5.0D, 1.0D), Block.box(15.0D, 4.0D, 0.0D, 16.0D, 5.0D, 8.0D), Block.box(1.0D, 1.0D, 7.0D, 15.0D, 4.0D, 8.0D), Block.box(0.0D, 1.0D, 0.0D, 1.0D, 4.0D, 8.0D), Block.box(1.0D, 1.0D, 0.0D, 15.0D, 4.0D, 1.0D), Block.box(15.0D, 1.0D, 0.0D, 16.0D, 4.0D, 8.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 8.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape WEST = Stream.of(Block.box(8.0D, 4.0D, 1.0D, 9.0D, 5.0D, 15.0D), Block.box(8.0D, 4.0D, 0.0D, 16.0D, 5.0D, 1.0D), Block.box(15.0D, 4.0D, 1.0D, 16.0D, 5.0D, 15.0D), Block.box(8.0D, 4.0D, 15.0D, 16.0D, 5.0D, 16.0D), Block.box(8.0D, 1.0D, 1.0D, 9.0D, 4.0D, 15.0D), Block.box(8.0D, 1.0D, 0.0D, 16.0D, 4.0D, 1.0D), Block.box(15.0D, 1.0D, 1.0D, 16.0D, 4.0D, 15.0D), Block.box(8.0D, 1.0D, 15.0D, 16.0D, 4.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
