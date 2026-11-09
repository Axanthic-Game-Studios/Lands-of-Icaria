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

public class LootVaseVoxelShapes {
	public static final VoxelShape V0 = Stream.of(Block.box(6.0D, 15.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(3.0D, 14.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(1.0D, 12.0D, 1.0D, 15.0D, 14.0D, 15.0D), Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(1.0D, 4.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.box(4.0D, 2.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V1 = Stream.of(Block.box(6.0D, 14.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(4.0D, 13.0D, 4.0D, 12.0D, 14.0D, 12.0D), Block.box(2.0D, 11.0D, 2.0D, 14.0D, 13.0D, 14.0D), Block.box(0.0D, 6.0D, 0.0D, 16.0D, 11.0D, 16.0D), Block.box(2.0D, 4.0D, 2.0D, 14.0D, 6.0D, 14.0D), Block.box(4.0D, 2.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V2 = Stream.of(Block.box(6.0D, 14.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(3.0D, 13.0D, 3.0D, 13.0D, 14.0D, 13.0D), Block.box(1.0D, 12.0D, 1.0D, 15.0D, 13.0D, 15.0D), Block.box(0.0D, 4.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(1.0D, 2.0D, 1.0D, 15.0D, 4.0D, 15.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V3 = Stream.of(Block.box(6.0D, 15.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(3.0D, 14.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(0.0D, 7.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(2.0D, 5.0D, 2.0D, 14.0D, 7.0D, 14.0D), Block.box(3.0D, 4.0D, 3.0D, 13.0D, 5.0D, 13.0D), Block.box(4.0D, 2.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V4 = Stream.of(Block.box(6.0D, 14.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(4.0D, 13.0D, 4.0D, 12.0D, 14.0D, 12.0D), Block.box(2.0D, 11.0D, 2.0D, 14.0D, 13.0D, 14.0D), Block.box(0.0D, 5.0D, 0.0D, 16.0D, 11.0D, 16.0D), Block.box(1.0D, 2.0D, 1.0D, 15.0D, 5.0D, 15.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V5 = Stream.of(Block.box(6.0D, 15.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(3.0D, 14.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(1.0D, 12.0D, 1.0D, 15.0D, 14.0D, 15.0D), Block.box(0.0D, 4.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(1.0D, 2.0D, 1.0D, 15.0D, 4.0D, 15.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V6 = Stream.of(Block.box(6.0D, 15.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(3.0D, 14.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(1.0D, 12.0D, 1.0D, 15.0D, 14.0D, 15.0D), Block.box(0.0D, 4.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(1.0D, 2.0D, 1.0D, 15.0D, 4.0D, 15.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V7 = Stream.of(Block.box(6.0D, 15.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(3.0D, 14.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(0.0D, 7.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(1.0D, 5.0D, 1.0D, 15.0D, 7.0D, 15.0D), Block.box(3.0D, 4.0D, 3.0D, 13.0D, 5.0D, 13.0D), Block.box(4.0D, 2.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V8 = Stream.of(Block.box(6.0D, 15.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(3.0D, 14.0D, 3.0D, 13.0D, 15.0D, 13.0D), Block.box(1.0D, 12.0D, 1.0D, 15.0D, 14.0D, 15.0D), Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(1.0D, 4.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.box(4.0D, 2.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape V9 = Stream.of(Block.box(6.0D, 14.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.box(4.0D, 12.0D, 4.0D, 12.0D, 14.0D, 12.0D), Block.box(2.0D, 10.0D, 2.0D, 14.0D, 12.0D, 14.0D), Block.box(0.0D, 6.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(2.0D, 4.0D, 2.0D, 14.0D, 6.0D, 14.0D), Block.box(4.0D, 2.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
