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

public class ChimneyGrateCrownVoxelShapes {
	public static final VoxelShape COLLISION_SHAPE = Stream.of(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 12.0D, 3.0D), Block.box(13.0D, 8.0D, 3.0D, 16.0D, 12.0D, 13.0D), Block.box(0.0D, 8.0D, 13.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 8.0D, 3.0D, 3.0D, 12.0D, 13.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 2.0D), Block.box(14.0D, 0.0D, 2.0D, 16.0D, 8.0D, 14.0D), Block.box(0.0D, 0.0D, 14.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 2.0D, 2.0D, 8.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape SHAPE = Stream.of(Block.box(0.0D, 11.0D, 0.0D, 16.0D, 12.0D, 3.0D), Block.box(13.0D, 11.0D, 3.0D, 16.0D, 12.0D, 13.0D), Block.box(0.0D, 11.0D, 13.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 11.0D, 3.0D, 3.0D, 12.0D, 13.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 3.0D), Block.box(13.0D, 0.0D, 3.0D, 16.0D, 8.0D, 13.0D), Block.box(0.0D, 0.0D, 13.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 3.0D, 3.0D, 8.0D, 13.0D), Block.box(1.0D, 8.0D, 1.0D, 2.0D, 11.0D, 2.0D), Block.box(14.0D, 8.0D, 1.0D, 15.0D, 11.0D, 2.0D), Block.box(14.0D, 8.0D, 14.0D, 15.0D, 11.0D, 15.0D), Block.box(1.0D, 8.0D, 14.0D, 2.0D, 11.0D, 15.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
