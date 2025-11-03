package com.axanthic.icaria.common.shapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StoolVoxelShapes {
	public static final VoxelShape STOOL = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
}
