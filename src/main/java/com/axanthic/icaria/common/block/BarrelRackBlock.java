package com.axanthic.icaria.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BarrelRackBlock extends GrinderBlock {
    public static final VoxelShape SHAPE_NORTH = Block.box(0.0D, 0.0D, 0.0D, 32.0D, 32.0D, 16.0D);
    public static final VoxelShape SHAPE_EAST = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 32.0D);
    public static final VoxelShape SHAPE_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 32.0D, 32.0D, 16.0D);
    public static final VoxelShape SHAPE_WEST = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 32.0D);

    public BarrelRackBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        return switch (direction) {
            default -> SHAPE_NORTH;
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
        };
    }
}
