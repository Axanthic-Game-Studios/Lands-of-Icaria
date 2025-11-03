package com.axanthic.icaria.common.shapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AmphoraVoxelShapes {
	public static final VoxelShape AMPHORA = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);
}
