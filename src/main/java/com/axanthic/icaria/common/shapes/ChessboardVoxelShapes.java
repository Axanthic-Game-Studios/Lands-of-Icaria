package com.axanthic.icaria.common.shapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChessboardVoxelShapes {
	public static final VoxelShape CHESSBOARD = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 1.0D, 13.0D);
}
