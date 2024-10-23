package com.axanthic.icaria.common.shapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseShapes {
	public static final VoxelShape STORAGE_VASE = Stream.of(Block.box(4.0D, 0.0D, 4.0D, 12.0D, 2.0D, 12.0D), Block.box(5.0D, 2.0D, 5.0D, 11.0D, 3.0D, 11.0D), Block.box(6.0D, 3.0D, 6.0D, 10.0D, 4.0D, 10.0D), Block.box(5.0D, 4.0D, 5.0D, 11.0D, 5.0D, 11.0D), Block.box(3.0D, 5.0D, 3.0D, 13.0D, 7.0D, 13.0D), Block.box(2.0D, 6.0D, 2.0D, 14.0D, 7.0D, 14.0D), Block.box(1.0D, 7.0D, 1.0D, 15.0D, 11.0D, 15.0D), Block.box(5.0D, 11.0D, 5.0D, 11.0D, 12.0D, 11.0D), Block.box(6.0D, 12.0D, 6.0D, 10.0D, 14.0D, 7.0D), Block.box(6.0D, 12.0D, 9.0D, 10.0D, 14.0D, 10.0D), Block.box(6.0D, 12.0D, 7.0D, 7.0D, 14.0D, 9.0D), Block.box(9.0D, 12.0D, 7.0D, 10.0D, 14.0D, 9.0D), Block.box(5.0D, 14.0D, 5.0D, 7.0D, 16.0D, 11.0D), Block.box(9.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.box(7.0D, 14.0D, 5.0D, 9.0D, 16.0D, 7.0D), Block.box(7.0D, 14.0D, 9.0D, 9.0D, 16.0D, 11.0D)).reduce((a, b) -> Shapes.join(a, b, BooleanOp.OR)).get();
}
