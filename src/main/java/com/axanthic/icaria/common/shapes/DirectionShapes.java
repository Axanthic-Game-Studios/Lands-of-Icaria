package com.axanthic.icaria.common.shapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DirectionShapes {
	public static final VoxelShape NORTH = Block.box(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D);
	public static final VoxelShape EAST = Block.box(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D);
	public static final VoxelShape SOUTH = Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D);
	public static final VoxelShape WEST = Block.box(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	public static final VoxelShape UP = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
	public static final VoxelShape DOWN = Block.box(4.0D, 8.0D, 4.0D, 12.0D, 16.0D, 12.0D);
}
