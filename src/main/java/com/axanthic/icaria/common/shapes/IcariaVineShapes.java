package com.axanthic.icaria.common.shapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaVineShapes {
	public static final VoxelShape NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	public static final VoxelShape EAST = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SOUTH = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape WEST = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
}
