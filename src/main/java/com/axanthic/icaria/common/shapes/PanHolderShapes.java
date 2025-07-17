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

public class PanHolderShapes {
	public static final VoxelShape NORTH = Stream.of(Block.box(0.0F, 8.0F, 15.0F, 16.0F, 12.0F, 16.0F), Block.box(5.5F, 11.0F, 13.0F, 10.5F, 11.5F, 14.0F), Block.box(10.0F, 9.5F, 13.0F, 10.5F, 11.0F, 14.0F), Block.box(5.5F, 9.5F, 13.0F, 6.0F, 11.0F, 14.0F), Block.box(5.5F, 0.5F, 13.0F, 10.5F, 1.0F, 14.0F), Block.box(10.0F, 1.0F, 13.0F, 10.5F, 2.5F, 14.0F), Block.box(5.5F, 1.0F, 13.0F, 6.0F, 2.5F, 14.0F), Block.box(4.5F, 8.5F, 12.5F, 11.5F, 9.5F, 14.5F), Block.box(4.5F, 2.5F, 12.5F, 11.5F, 3.5F, 14.5F), Block.box(10.5F, 3.5F, 12.5F, 11.5F, 8.5F, 14.5F), Block.box(4.5F, 3.5F, 12.5F, 5.5F, 8.5F, 14.5F), Block.box(5.5F, 3.5F, 13.5F, 10.5F, 8.5F, 14.5F), Block.box(9.375F, 10.0F, 12.0F, 9.625F, 12.0F, 13.0F), Block.box(9.375F, 10.0F, 13.0F, 9.625F, 11.0F, 15.0F), Block.box(6.375F, 10.0F, 13.0F, 6.625F, 11.0F, 15.0F), Block.box(6.375F, 10.0F, 12.0F, 6.625F, 12.0F, 13.0F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape EAST = Stream.of(Block.box(0.0F, 8.0F, 0.0F, 1.0F, 12.0F, 16.0F), Block.box(2.0F, 11.0F, 5.5F, 3.0F, 11.5F, 10.5F), Block.box(2.0F, 9.5F, 10.0F, 3.0F, 11.0F, 10.5F), Block.box(2.0F, 9.5F, 5.5F, 3.0F, 11.0F, 6.0F), Block.box(2.0F, 0.5F, 5.5F, 3.0F, 1.0F, 10.5F), Block.box(2.0F, 1.0F, 10.0F, 3.0F, 2.5F, 10.5F), Block.box(2.0F, 1.0F, 5.5F, 3.0F, 2.5F, 6.0F), Block.box(1.5F, 8.5F, 4.5F, 3.5F, 9.5F, 11.5F), Block.box(1.5F, 2.5F, 4.5F, 3.5F, 3.5F, 11.5F), Block.box(1.5F, 3.5F, 10.5F, 3.5F, 8.5F, 11.5F), Block.box(1.5F, 3.5F, 4.5F, 3.5F, 8.5F, 5.5F), Block.box(1.5F, 3.5F, 5.5F, 2.5F, 8.5F, 10.5F), Block.box(3.0F, 10.0F, 9.375F, 4.0F, 12.0F, 9.625F), Block.box(1.0F, 10.0F, 9.375F, 3.0F, 11.0F, 9.625F), Block.box(1.0F, 10.0F, 6.375F, 3.0F, 11.0F, 6.625F), Block.box(3.0F, 10.0F, 6.375F, 4.0F, 12.0F, 6.625F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape SOUTH = Stream.of(Block.box(0.0F, 8.0F, 0.0F, 16.0F, 12.0F, 1.0F), Block.box(5.5F, 11.0F, 2.0F, 10.5F, 11.5F, 3.0F), Block.box(5.5F, 9.5F, 2.0F, 6.0F, 11.0F, 3.0F), Block.box(10.0F, 9.5F, 2.0F, 10.5F, 11.0F, 3.0F), Block.box(5.5F, 0.5F, 2.0F, 10.5F, 1.0F, 3.0F), Block.box(5.5F, 1.0F, 2.0F, 6.0F, 2.5F, 3.0F), Block.box(10.0F, 1.0F, 2.0F, 10.5F, 2.5F, 3.0F), Block.box(4.5F, 8.5F, 1.5F, 11.5F, 9.5F, 3.5F), Block.box(4.5F, 2.5F, 1.5F, 11.5F, 3.5F, 3.5F), Block.box(4.5F, 3.5F, 1.5F, 5.5F, 8.5F, 3.5F), Block.box(10.5F, 3.5F, 1.5F, 11.5F, 8.5F, 3.5F), Block.box(5.5F, 3.5F, 1.5F, 10.5F, 8.5F, 2.5F), Block.box(6.375F, 10.0F, 3.0F, 6.625F, 12.0F, 4.0F), Block.box(6.375F, 10.0F, 1.0F, 6.625F, 11.0F, 3.0F), Block.box(9.375F, 10.0F, 1.0F, 9.625F, 11.0F, 3.0F), Block.box(9.375F, 10.0F, 3.0F, 9.625F, 12.0F, 4.0F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape WEST = Stream.of(Block.box(15.0F, 8.0F, 0.0F, 16.0F, 12.0F, 16.0F), Block.box(13.0F, 11.0F, 5.5F, 14.0F, 11.5F, 10.5F), Block.box(13.0F, 9.5F, 5.5F, 14.0F, 11.0F, 6.0F), Block.box(13.0F, 9.5F, 10.0F, 14.0F, 11.0F, 10.5F), Block.box(13.0F, 0.5F, 5.5F, 14.0F, 1.0F, 10.5F), Block.box(13.0F, 1.0F, 5.5F, 14.0F, 2.5F, 6.0F), Block.box(13.0F, 1.0F, 10.0F, 14.0F, 2.5F, 10.5F), Block.box(12.5F, 8.5F, 4.5F, 14.5F, 9.5F, 11.5F), Block.box(12.5F, 2.5F, 4.5F, 14.5F, 3.5F, 11.5F), Block.box(12.5F, 3.5F, 4.5F, 14.5F, 8.5F, 5.5F), Block.box(12.5F, 3.5F, 10.5F, 14.5F, 8.5F, 11.5F), Block.box(13.5F, 3.5F, 5.5F, 14.5F, 8.5F, 10.5F), Block.box(12.0F, 10.0F, 6.375F, 13.0F, 12.0F, 6.625F), Block.box(13.0F, 10.0F, 6.375F, 15.0F, 11.0F, 6.625F), Block.box(13.0F, 10.0F, 9.375F, 15.0F, 11.0F, 9.625F), Block.box(12.0F, 10.0F, 9.375F, 13.0F, 12.0F, 9.625F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
