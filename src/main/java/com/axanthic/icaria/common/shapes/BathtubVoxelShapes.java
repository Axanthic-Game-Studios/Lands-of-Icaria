package com.axanthic.icaria.common.shapes;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import java.util.stream.Stream;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BathtubVoxelShapes {
	public static final VoxelShape FRONT_NORTH = Stream.of(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 31.0D), Block.box(14.0D, 1.0D, 1.0D, 15.0D, 14.0D, 31.0D), Block.box(1.0D, 1.0D, 1.0D, 2.0D, 14.0D, 31.0D), Block.box(2.0D, 1.0D, 1.0D, 14.0D, 14.0D, 2.0D), Block.box(2.0D, 1.0D, 30.0D, 14.0D, 14.0D, 31.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape FRONT_EAST = Stream.of(Block.box(-15.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(-15.0D, 1.0D, 14.0D, 15.0D, 14.0D, 15.0D), Block.box(-15.0D, 1.0D, 1.0D, 15.0D, 14.0D, 2.0D), Block.box(14.0D, 1.0D, 2.0D, 15.0D, 14.0D, 14.0D), Block.box(-15.0D, 1.0D, 2.0D, -14.0D, 14.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape FRONT_SOUTH = Stream.of(Block.box(1.0D, 0.0D, -15.0D, 15.0D, 1.0D, 15.0D), Block.box(14.0D, 1.0D, -15.0D, 15.0D, 14.0D, 15.0D), Block.box(1.0D, 1.0D, -15.0D, 2.0D, 14.0D, 15.0D), Block.box(2.0D, 1.0D, -15.0D, 14.0D, 14.0D, -14.0D), Block.box(2.0D, 1.0D, 14.0D, 14.0D, 14.0D, 15.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape FRONT_WEST = Stream.of(Block.box(1.0D, 0.0D, 1.0D, 31.0D, 1.0D, 15.0D), Block.box(1.0D, 1.0D, 14.0D, 31.0D, 14.0D, 15.0D), Block.box(1.0D, 1.0D, 1.0D, 31.0D, 14.0D, 2.0D), Block.box(30.0D, 1.0D, 2.0D, 31.0D, 14.0D, 14.0D), Block.box(1.0D, 1.0D, 2.0D, 2.0D, 14.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();

	public static final VoxelShape BACK_NORTH = Stream.of(Block.box(1.0D, 0.0D, -15.0D, 15.0D, 1.0D, 15.0D), Block.box(14.0D, 1.0D, -15.0D, 15.0D, 14.0D, 15.0D), Block.box(1.0D, 1.0D, -15.0D, 2.0D, 14.0D, 15.0D), Block.box(2.0D, 1.0D, -15.0D, 14.0D, 14.0D, -14.0D), Block.box(2.0D, 1.0D, 14.0D, 14.0D, 14.0D, 15.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BACK_EAST = Stream.of(Block.box(1.0D, 0.0D, 1.0D, 31.0D, 1.0D, 15.0D), Block.box(1.0D, 1.0D, 14.0D, 31.0D, 14.0D, 15.0D), Block.box(1.0D, 1.0D, 1.0D, 31.0D, 14.0D, 2.0D), Block.box(30.0D, 1.0D, 2.0D, 31.0D, 14.0D, 14.0D), Block.box(1.0D, 1.0D, 2.0D, 2.0D, 14.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BACK_SOUTH = Stream.of(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 31.0D), Block.box(14.0D, 1.0D, 1.0D, 15.0D, 14.0D, 31.0D), Block.box(1.0D, 1.0D, 1.0D, 2.0D, 14.0D, 31.0D), Block.box(2.0D, 1.0D, 1.0D, 14.0D, 14.0D, 2.0D), Block.box(2.0D, 1.0D, 30.0D, 14.0D, 14.0D, 31.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BACK_WEST = Stream.of(Block.box(-15.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(-15.0D, 1.0D, 14.0D, 15.0D, 14.0D, 15.0D), Block.box(-15.0D, 1.0D, 1.0D, 15.0D, 14.0D, 2.0D), Block.box(14.0D, 1.0D, 2.0D, 15.0D, 14.0D, 14.0D), Block.box(-15.0D, 1.0D, 2.0D, -14.0D, 14.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
