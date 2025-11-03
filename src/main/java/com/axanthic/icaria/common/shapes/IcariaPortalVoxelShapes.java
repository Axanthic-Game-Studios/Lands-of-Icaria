package com.axanthic.icaria.common.shapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalVoxelShapes {
	public static final VoxelShape X = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	public static final VoxelShape Z = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
}
