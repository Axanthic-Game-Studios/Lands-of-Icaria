package com.axanthic.icaria.common.shapes;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCakeShapes {
	public static final VoxelShape CANDLE_CAKE = Stream.of(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();

	public static final List<VoxelShape> CAKE_SHAPES = List.of(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Shapes.or(Block.box(1.0D, 0.0D, 8.0D, 15.0D, 8.0D, 15.0D), Block.box(8.0D, 0.0D, 1.0D, 15.0D, 8.0D, 8.0D)), Block.box(1.0D, 0.0D, 8.0D, 15.0D, 8.0D, 15.0D), Block.box(1.0D, 0.0D, 8.0D, 8.0D, 8.0D, 15.0D));
}
