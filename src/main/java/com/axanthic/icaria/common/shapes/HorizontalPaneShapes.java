package com.axanthic.icaria.common.shapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HorizontalPaneShapes {
	public static final VoxelShape HORIZONTAL_PANE = Block.box(0.0D, 7.0D, 0.0D, 16.0D, 9.0D, 16.0D);
}
