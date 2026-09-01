package com.axanthic.icaria.common.shapes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StoolVoxelShapes {
	public static final VoxelShape STOOL = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
}
