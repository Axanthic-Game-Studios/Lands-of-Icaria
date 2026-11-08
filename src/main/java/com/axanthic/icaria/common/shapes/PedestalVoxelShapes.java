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

public class PedestalVoxelShapes {
	public static final VoxelShape SINGLE = Stream.of(Block.box(1.0D, 11.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(2.0D, 10.0D, 2.0D, 14.0D, 11.0D, 14.0D), Block.box(3.0D, 6.0D, 3.0D, 13.0D, 10.0D, 13.0D), Block.box(2.0D, 5.0D, 2.0D, 14.0D, 6.0D, 14.0D), Block.box(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape BOTTOM = Stream.of(Block.box(2.0D, 15.0D, 2.0D, 14.0D, 16.0D, 14.0D), Block.box(3.0D, 6.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(2.0D, 5.0D, 2.0D, 14.0D, 6.0D, 14.0D), Block.box(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape CENTER = Stream.of(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(3.0D, 1.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(2.0D, 15.0D, 2.0D, 14.0D, 16.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape TOP = Stream.of(Block.box(1.0D, 11.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(2.0D, 10.0D, 2.0D, 14.0D, 11.0D, 14.0D), Block.box(3.0D, 1.0D, 3.0D, 13.0D, 10.0D, 13.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
