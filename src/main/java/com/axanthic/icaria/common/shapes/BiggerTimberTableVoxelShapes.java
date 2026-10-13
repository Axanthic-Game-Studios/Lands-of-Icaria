package com.axanthic.icaria.common.shapes;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BiggerTimberTableVoxelShapes {
	public static final VoxelShape FRONT_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 48.0D);
	public static final VoxelShape FRONT_EAST = Block.box(-32.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape FRONT_SOUTH = Block.box(0.0D, 0.0D, -32.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape FRONT_WEST = Block.box(0.0D, 0.0D, 0.0D, 48.0D, 16.0D, 16.0D);

	public static final VoxelShape CENTER_NORTH = Block.box(0.0D, 0.0D, -16.0D, 16.0D, 16.0D, 32.0D);
	public static final VoxelShape CENTER_EAST = Block.box(-16.0D, 0.0D, 0.0D, 32.0D, 16.0D, 16.0D);
	public static final VoxelShape CENTER_SOUTH = Block.box(0.0D, 0.0D, -16.0D, 16.0D, 16.0D, 32.0D);
	public static final VoxelShape CENTER_WEST = Block.box(-16.0D, 0.0D, 0.0D, 32.0D, 16.0D, 16.0D);

	public static final VoxelShape BACK_NORTH = Block.box(0.0D, 0.0D, -32.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape BACK_EAST = Block.box(0.0D, 0.0D, 0.0D, 48.0D, 16.0D, 16.0D);
	public static final VoxelShape BACK_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 48.0D);
	public static final VoxelShape BACK_WEST = Block.box(-32.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
}
