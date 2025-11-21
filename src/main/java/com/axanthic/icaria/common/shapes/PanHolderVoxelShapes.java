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

public class PanHolderVoxelShapes {
	public static final VoxelShape NORTH = Stream.of(Block.box(0.0D, 8.0D, 15.0D, 16.0D, 12.0D, 16.0D), Block.box(9.375D, 10.0D, 12.0D, 9.625D, 11.0D, 15.0D), Block.box(9.375D, 10.0D, 11.0D, 9.625D, 12.0D, 12.0D), Block.box(6.375D, 10.0D, 12.0D, 6.625D, 11.0D, 15.0D), Block.box(6.375D, 10.0D, 11.0D, 6.625D, 12.0D, 12.0D), Block.box(6.0D, 11.0D, 13.0D, 10.0D, 11.5D, 14.0D), Block.box(10.0D, 9.5D, 13.0D, 10.5D, 11.5D, 14.0D), Block.box(5.5D, 9.5D, 13.0D, 6.0D, 11.5D, 14.0D), Block.box(6.0D, 0.5D, 13.0D, 10.0D, 1.0D, 14.0D), Block.box(10.0D, 0.5D, 13.0D, 10.5D, 2.5D, 14.0D), Block.box(5.5D, 0.5D, 13.0D, 6.0D, 2.5D, 14.0D), Block.box(4.5D, 8.5D, 12.5D, 11.5D, 9.5D, 14.5D), Block.box(4.5D, 2.5D, 12.5D, 11.5D, 3.5D, 14.5D), Block.box(10.5D, 3.5D, 12.5D, 11.5D, 8.5D, 14.5D), Block.box(4.5D, 3.5D, 12.5D, 5.5D, 8.5D, 14.5D), Block.box(5.5D, 3.5D, 13.5D, 10.5D, 8.5D, 14.5D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape EAST = Stream.of(Block.box(0.0D, 8.0D, 0.0D, 1.0D, 12.0D, 16.0D), Block.box(1.0D, 10.0D, 9.375D, 4.0D, 11.0D, 9.625D), Block.box(4.0D, 10.0D, 9.375D, 5.0D, 12.0D, 9.625D), Block.box(1.0D, 10.0D, 6.375D, 4.0D, 11.0D, 6.625D), Block.box(4.0D, 10.0D, 6.375D, 5.0D, 12.0D, 6.625D), Block.box(2.0D, 11.0D, 6.0D, 3.0D, 11.5D, 10.0D), Block.box(2.0D, 9.5D, 10.0D, 3.0D, 11.5D, 10.5D), Block.box(2.0D, 9.5D, 5.5D, 3.0D, 11.5D, 6.0D), Block.box(2.0D, 0.5D, 6.0D, 3.0D, 1.0D, 10.0D), Block.box(2.0D, 0.5D, 10.0D, 3.0D, 2.5D, 10.5D), Block.box(2.0D, 0.5D, 5.5D, 3.0D, 2.5D, 6.0D), Block.box(1.5D, 8.5D, 4.5D, 3.5D, 9.5D, 11.5D), Block.box(1.5D, 2.5D, 4.5D, 3.5D, 3.5D, 11.5D), Block.box(1.5D, 3.5D, 10.5D, 3.5D, 8.5D, 11.5D), Block.box(1.5D, 3.5D, 4.5D, 3.5D, 8.5D, 5.5D), Block.box(1.5D, 3.5D, 5.5D, 2.5D, 8.5D, 10.5D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape SOUTH = Stream.of(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 12.0D, 1.0D), Block.box(6.375D, 10.0D, 1.0D, 6.625D, 11.0D, 4.0D), Block.box(6.375D, 10.0D, 4.0D, 6.625D, 12.0D, 5.0D), Block.box(9.375D, 10.0D, 1.0D, 9.625D, 11.0D, 4.0D), Block.box(9.375D, 10.0D, 4.0D, 9.625D, 12.0D, 5.0D), Block.box(6.0D, 11.0D, 2.0D, 10.0D, 11.5D, 3.0D), Block.box(5.5D, 9.5D, 2.0D, 6.0D, 11.5D, 3.0D), Block.box(10.0D, 9.5D, 2.0D, 10.5D, 11.5D, 3.0D), Block.box(6.0D, 0.5D, 2.0D, 10.0D, 1.0D, 3.0D), Block.box(5.5D, 0.5D, 2.0D, 6.0D, 2.5D, 3.0D), Block.box(10.0D, 0.5D, 2.0D, 10.5D, 2.5D, 3.0D), Block.box(4.5D, 8.5D, 1.5D, 11.5D, 9.5D, 3.5D), Block.box(4.5D, 2.5D, 1.5D, 11.5D, 3.5D, 3.5D), Block.box(4.5D, 3.5D, 1.5D, 5.5D, 8.5D, 3.5D), Block.box(10.5D, 3.5D, 1.5D, 11.5D, 8.5D, 3.5D), Block.box(5.5D, 3.5D, 1.5D, 10.5D, 8.5D, 2.5D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape WEST = Stream.of(Block.box(15.0D, 8.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(12.0D, 10.0D, 6.375D, 15.0D, 11.0D, 6.625D), Block.box(11.0D, 10.0D, 6.375D, 12.0D, 12.0D, 6.625D), Block.box(12.0D, 10.0D, 9.375D, 15.0D, 11.0D, 9.625D), Block.box(11.0D, 10.0D, 9.375D, 12.0D, 12.0D, 9.625D), Block.box(13.0D, 11.0D, 6.0D, 14.0D, 11.5D, 10.0D), Block.box(13.0D, 9.5D, 5.5D, 14.0D, 11.5D, 6.0D), Block.box(13.0D, 9.5D, 10.0D, 14.0D, 11.5D, 10.5D), Block.box(13.0D, 0.5D, 6.0D, 14.0D, 1.0D, 10.0D), Block.box(13.0D, 0.5D, 5.5D, 14.0D, 2.5D, 6.0D), Block.box(13.0D, 0.5D, 10.0D, 14.0D, 2.5D, 10.5D), Block.box(12.5D, 8.5D, 4.5D, 14.5D, 9.5D, 11.5D), Block.box(12.5D, 2.5D, 4.5D, 14.5D, 3.5D, 11.5D), Block.box(12.5D, 3.5D, 4.5D, 14.5D, 8.5D, 5.5D), Block.box(12.5D, 3.5D, 10.5D, 14.5D, 8.5D, 11.5D), Block.box(13.5D, 3.5D, 5.5D, 14.5D, 8.5D, 10.5D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
