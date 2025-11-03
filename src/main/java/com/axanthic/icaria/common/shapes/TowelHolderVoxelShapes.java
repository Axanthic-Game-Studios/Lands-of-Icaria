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

public class TowelHolderVoxelShapes {
	public static final VoxelShape NORTH = Stream.of(Block.box(0.0F, 8.0F, 15.0F, 16.0F, 12.0F, 16.0F), Block.box(12.0F, 9.0F, 12.0F, 14.0F, 11.0F, 15.0F), Block.box(4.0F, 9.5F, 12.5F, 12.0F, 10.5F, 13.5F), Block.box(4.5F, 10.5F, 12.25F, 11.5F, 10.75F, 13.75F), Block.box(4.5F, 4.75F, 12.25F, 11.5F, 10.5F, 12.5F), Block.box(4.5F, 1.75F, 13.5F, 11.5F, 10.5F, 13.75F), Block.box(2.0F, 9.0F, 12.0F, 4.0F, 11.0F, 15.0F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape EAST = Stream.of(Block.box(0.0F, 8.0F, 0.0F, 1.0F, 12.0F, 16.0F), Block.box(1.0F, 9.0F, 12.0F, 4.0F, 11.0F, 14.0F), Block.box(2.5F, 9.5F, 4.0F, 3.5F, 10.5F, 12.0F), Block.box(2.25F, 10.5F, 4.5F, 3.75F, 10.75F, 11.5F), Block.box(3.5F, 4.75F, 4.5F, 3.75F, 10.5F, 11.5F), Block.box(2.25F, 1.75F, 4.5F, 2.5F, 10.5F, 11.5F), Block.box(1.0F, 9.0F, 2.0F, 4.0F, 11.0F, 4.0F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape SOUTH = Stream.of(Block.box(0.0F, 8.0F, 0.0F, 16.0F, 12.0F, 1.0F), Block.box(2.0F, 9.0F, 1.0F, 4.0F, 11.0F, 4.0F), Block.box(4.0F, 9.5F, 2.5F, 12.0F, 10.5F, 3.5F), Block.box(4.5F, 10.5F, 2.25F, 11.5F, 10.75F, 3.75F), Block.box(4.5F, 4.75F, 3.5F, 11.5F, 10.5F, 3.75F), Block.box(4.5F, 1.75F, 2.25F, 11.5F, 10.5F, 2.5F), Block.box(12.0F, 9.0F, 1.0F, 14.0F, 11.0F, 4.0F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
	public static final VoxelShape WEST = Stream.of(Block.box(15.0F, 8.0F, 0.0F, 16.0F, 12.0F, 16.0F), Block.box(12.0F, 9.0F, 2.0F, 15.0F, 11.0F, 4.0F), Block.box(12.5F, 9.5F, 4.0F, 13.5F, 10.5F, 12.0F), Block.box(12.25F, 10.5F, 4.5F, 13.75F, 10.75F, 11.5F), Block.box(12.25F, 4.75F, 4.5F, 12.5F, 10.5F, 11.5F), Block.box(13.5F, 1.75F, 4.5F, 13.75F, 10.5F, 11.5F), Block.box(12.0F, 9.0F, 12.0F, 15.0F, 11.0F, 14.0F)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
