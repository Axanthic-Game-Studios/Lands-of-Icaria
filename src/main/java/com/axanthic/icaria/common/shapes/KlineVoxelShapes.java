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

public class KlineVoxelShapes {
	public static final VoxelShape HEAD_NORTH = Stream.of(Block.box(0.5D, 0.0D, -15.5D, 15.5D, 6.5D, 15.5D), Block.box(0.0D, 6.5D, -16.0D, 16.0D, 8.5D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape HEAD_EAST = Stream.of(Block.box(0.5D, 0.0D, 0.5D, 31.5D, 6.5D, 15.5D), Block.box(0.0D, 6.5D, 0.0D, 32.0D, 8.5D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape HEAD_SOUTH = Stream.of(Block.box(0.5D, 0.0D, 0.5D, 15.5D, 6.5D, 31.5D), Block.box(0.0D, 6.5D, 0.0D, 16.0D, 8.5D, 32.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape HEAD_WEST = Stream.of(Block.box(-15.5D, 0.0D, 0.5D, 15.5D, 6.5D, 15.5D), Block.box(-16.0D, 6.5D, 0.0D, 16.0D, 8.5D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();

	public static final VoxelShape FOOT_NORTH = Stream.of(Block.box(0.5D, 0.0D, 0.5D, 15.5D, 6.5D, 31.5D), Block.box(0.0D, 6.5D, 0.0D, 16.0D, 8.5D, 32.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape FOOT_EAST = Stream.of(Block.box(-15.5D, 0.0D, 0.5D, 15.5D, 6.5D, 15.5D), Block.box(-16.0D, 6.5D, 0.0D, 16.0D, 8.5D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape FOOT_SOUTH = Stream.of(Block.box(0.5D, 0.0D, -15.5D, 15.5D, 6.5D, 15.5D), Block.box(0.0D, 6.5D, -16.0D, 16.0D, 8.5D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape FOOT_WEST = Stream.of(Block.box(0.5D, 0.0D, 0.5D, 31.5D, 6.5D, 15.5D), Block.box(0.0D, 6.5D, 0.0D, 32.0D, 8.5D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
