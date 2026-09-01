package com.axanthic.icaria.common.shapes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PotVoxelShapes {
	public static final VoxelShape NORTH = Stream.of(Block.box(12.0D, 3.0D, 6.0D, 13.0D, 4.0D, 6.5D), Block.box(13.0D, 3.0D, 6.0D, 13.5D, 4.0D, 10.0D), Block.box(12.0D, 3.0D, 9.5D, 13.0D, 4.0D, 10.0D), Block.box(5.0D, 0.0D, 4.0D, 11.0D, 5.0D, 5.0D), Block.box(11.0D, 0.0D, 4.0D, 12.0D, 5.0D, 12.0D), Block.box(5.0D, 0.0D, 11.0D, 11.0D, 5.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 5.0D, 5.0D, 12.0D), Block.box(3.0D, 3.0D, 6.0D, 4.0D, 4.0D, 6.5D), Block.box(2.5D, 3.0D, 6.0D, 3.0D, 4.0D, 10.0D), Block.box(3.0D, 3.0D, 9.5D, 4.0D, 4.0D, 10.0D), Block.box(5.0D, 0.0D, 5.0D, 11.0D, 1.0D, 11.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape EAST = Stream.of(Block.box(9.5D, 3.0D, 12.0D, 10.0D, 4.0D, 13.0D), Block.box(6.0D, 3.0D, 13.0D, 10.0D, 4.0D, 13.5D), Block.box(6.0D, 3.0D, 12.0D, 6.5D, 4.0D, 13.0D), Block.box(11.0D, 0.0D, 5.0D, 12.0D, 5.0D, 11.0D), Block.box(4.0D, 0.0D, 11.0D, 12.0D, 5.0D, 12.0D), Block.box(4.0D, 0.0D, 5.0D, 5.0D, 5.0D, 11.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 5.0D, 5.0D), Block.box(9.5D, 3.0D, 3.0D, 10.0D, 4.0D, 4.0D), Block.box(6.0D, 3.0D, 2.5D, 10.0D, 4.0D, 3.0D), Block.box(6.0D, 3.0D, 3.0D, 6.5D, 4.0D, 4.0D), Block.box(5.0D, 0.0D, 5.0D, 11.0D, 1.0D, 11.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape SOUTH = Stream.of(Block.box(3.0D, 3.0D, 9.5D, 4.0D, 4.0D, 10.0D), Block.box(2.5D, 3.0D, 6.0D, 3.0D, 4.0D, 10.0D), Block.box(3.0D, 3.0D, 6.0D, 4.0D, 4.0D, 6.5D), Block.box(5.0D, 0.0D, 11.0D, 11.0D, 5.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 5.0D, 5.0D, 12.0D), Block.box(5.0D, 0.0D, 4.0D, 11.0D, 5.0D, 5.0D), Block.box(11.0D, 0.0D, 4.0D, 12.0D, 5.0D, 12.0D), Block.box(12.0D, 3.0D, 9.5D, 13.0D, 4.0D, 10.0D), Block.box(13.0D, 3.0D, 6.0D, 13.5D, 4.0D, 10.0D), Block.box(12.0D, 3.0D, 6.0D, 13.0D, 4.0D, 6.5D), Block.box(5.0D, 0.0D, 5.0D, 11.0D, 1.0D, 11.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape WEST = Stream.of(Block.box(6.0D, 3.0D, 3.0D, 6.5D, 4.0D, 4.0D), Block.box(6.0D, 3.0D, 2.5D, 10.0D, 4.0D, 3.0D), Block.box(9.5D, 3.0D, 3.0D, 10.0D, 4.0D, 4.0D), Block.box(4.0D, 0.0D, 5.0D, 5.0D, 5.0D, 11.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 5.0D, 5.0D), Block.box(11.0D, 0.0D, 5.0D, 12.0D, 5.0D, 11.0D), Block.box(4.0D, 0.0D, 11.0D, 12.0D, 5.0D, 12.0D), Block.box(6.0D, 3.0D, 12.0D, 6.5D, 4.0D, 13.0D), Block.box(6.0D, 3.0D, 13.0D, 10.0D, 4.0D, 13.5D), Block.box(9.5D, 3.0D, 12.0D, 10.0D, 4.0D, 13.0D), Block.box(5.0D, 0.0D, 5.0D, 11.0D, 1.0D, 11.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
