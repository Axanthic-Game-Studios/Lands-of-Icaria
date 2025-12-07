package com.axanthic.icaria.common.shapes;

import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CountertopVoxelShapes {
	public static final VoxelShape NORTH = Stream.of(Block.box(0.0D, 0.0D, 3.0D, 16.0D, 3.0D, 4.0D), Block.box(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 16.0D), Block.box(0.0D, 3.0D, 15.0D, 16.0D, 6.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape EAST = Stream.of(Block.box(12.0D, 0.0D, 0.0D, 13.0D, 3.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 12.0D, 3.0D, 16.0D), Block.box(0.0D, 3.0D, 0.0D, 1.0D, 6.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape SOUTH = Stream.of(Block.box(0.0D, 0.0D, 12.0D, 16.0D, 3.0D, 13.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 12.0D), Block.box(0.0D, 3.0D, 0.0D, 16.0D, 6.0D, 1.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape WEST = Stream.of(Block.box(3.0D, 0.0D, 0.0D, 4.0D, 3.0D, 16.0D), Block.box(4.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), Block.box(15.0D, 3.0D, 0.0D, 16.0D, 6.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
