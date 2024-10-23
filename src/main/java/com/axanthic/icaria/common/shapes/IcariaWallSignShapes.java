package com.axanthic.icaria.common.shapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallSignShapes {
	public static final VoxelShape CEILING_NORTH = Block.box(0.0D, 14.0D, 4.5D, 16.0D, 16.0D, 12.5D);
	public static final VoxelShape CEILING_EAST = Block.box(3.5D, 14.0D, 0.0D, 11.5D, 16.0D, 16.0D);
	public static final VoxelShape CEILING_SOUTH = Block.box(0.0D, 14.0D, 3.5D, 16.0D, 16.0D, 11.5D);
	public static final VoxelShape CEILING_WEST = Block.box(4.5D, 14.0D, 0.0D, 12.5D, 16.0D, 16.0D);

	public static final VoxelShape FLOOR_NORTH = Block.box(0.0D, 0.0D, 3.5D, 16.0D, 2.0D, 11.5D);
	public static final VoxelShape FLOOR_EAST = Block.box(4.5D, 0.0D, 0.0D, 12.5D, 2.0D, 16.0D);
	public static final VoxelShape FLOOR_SOUTH = Block.box(0.0D, 0.0D, 4.5D, 16.0D, 2.0D, 12.5D);
	public static final VoxelShape FLOOR_WEST = Block.box(3.5D, 0.0D, 0.0D, 11.5D, 2.0D, 16.0D);

	public static final VoxelShape WALL_NORTH = Block.box(0.0D, 4.5D, 14.0D, 16.0D, 12.5D, 16.0D);
	public static final VoxelShape WALL_EAST = Block.box(0.0D, 4.5D, 0.0D, 2.0D, 12.5D, 16.0D);
	public static final VoxelShape WALL_SOUTH = Block.box(0.0D, 4.5D, 0.0D, 16.0D, 12.5D, 2.0D);
	public static final VoxelShape WALL_WEST = Block.box(14.0D, 4.5D, 0.0D, 16.0D, 12.5D, 16.0D);
}
