package com.axanthic.icaria.common.shapes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CuttingBoardVoxelShapes {
	public static final VoxelShape NORTH = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 1.0D, 9.0D);
	public static final VoxelShape EAST = Block.box(7.0D, 0.0D, 3.0D, 13.0D, 1.0D, 13.0D);
	public static final VoxelShape SOUTH = Block.box(3.0D, 0.0D, 7.0D, 13.0D, 1.0D, 13.0D);
	public static final VoxelShape WEST = Block.box(3.0D, 0.0D, 3.0D, 9.0D, 1.0D, 13.0D);
}
