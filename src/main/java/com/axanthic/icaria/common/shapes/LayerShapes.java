package com.axanthic.icaria.common.shapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LayerShapes {
	public static final VoxelShape Y_01 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	public static final VoxelShape Y_02 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	public static final VoxelShape Y_03 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
	public static final VoxelShape Y_04 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
	public static final VoxelShape Y_05 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D);
	public static final VoxelShape Y_06 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
	public static final VoxelShape Y_07 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
	public static final VoxelShape Y_08 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	public static final VoxelShape Y_09 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);
	public static final VoxelShape Y_10 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);
	public static final VoxelShape Y_11 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D);
	public static final VoxelShape Y_12 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
	public static final VoxelShape Y_13 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
	public static final VoxelShape Y_14 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);
	public static final VoxelShape Y_15 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
	public static final VoxelShape Y_16 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public static final VoxelShape[] SHAPES = new VoxelShape[]{
		LayerShapes.Y_02, LayerShapes.Y_04, LayerShapes.Y_06, LayerShapes.Y_08, LayerShapes.Y_10, LayerShapes.Y_12, LayerShapes.Y_14, LayerShapes.Y_16
	};
}
