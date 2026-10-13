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

public class DeadLogVoxelShapes {
	public static final VoxelShape X = Stream.of(Block.box(0.0D, 0.0D, 2.0D, 16.0D, 2.0D, 14.0D), Block.box(0.0D, 14.0D, 2.0D, 16.0D, 16.0D, 14.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D), Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 2.0D, 2.0D, 16.0D, 3.0D, 5.0D), Block.box(0.0D, 3.0D, 2.0D, 16.0D, 5.0D, 3.0D), Block.box(0.0D, 2.0D, 11.0D, 16.0D, 3.0D, 14.0D), Block.box(0.0D, 3.0D, 13.0D, 16.0D, 5.0D, 14.0D), Block.box(0.0D, 13.0D, 2.0D, 16.0D, 14.0D, 5.0D), Block.box(0.0D, 11.0D, 2.0D, 16.0D, 13.0D, 3.0D), Block.box(0.0D, 13.0D, 11.0D, 16.0D, 14.0D, 14.0D), Block.box(0.0D, 11.0D, 13.0D, 16.0D, 13.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape Y = Stream.of(Block.box(0.0D, 8.0D, 14.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 2.0D, 2.0D, 16.0D, 14.0D), Block.box(14.0D, 8.0D, 2.0D, 16.0D, 16.0D, 14.0D), Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 2.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape Z = Stream.of(Block.box(2.0D, 0.0D, 0.0D, 14.0D, 2.0D, 16.0D), Block.box(2.0D, 14.0D, 0.0D, 14.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D), Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(2.0D, 2.0D, 0.0D, 5.0D, 3.0D, 16.0D), Block.box(2.0D, 3.0D, 0.0D, 3.0D, 5.0D, 16.0D), Block.box(11.0D, 2.0D, 0.0D, 14.0D, 3.0D, 16.0D), Block.box(13.0D, 3.0D, 0.0D, 14.0D, 5.0D, 16.0D), Block.box(2.0D, 13.0D, 0.0D, 5.0D, 14.0D, 16.0D), Block.box(2.0D, 11.0D, 0.0D, 3.0D, 13.0D, 16.0D), Block.box(11.0D, 13.0D, 0.0D, 14.0D, 14.0D, 16.0D), Block.box(13.0D, 11.0D, 0.0D, 14.0D, 13.0D, 16.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
