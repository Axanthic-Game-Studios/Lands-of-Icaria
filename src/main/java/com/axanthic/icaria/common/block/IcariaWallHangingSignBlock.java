package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.block.entity.IcariaHangingSignBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallHangingSignBlock extends WallHangingSignBlock implements MediterraneanWaterloggedBlock {
    public IcariaWallHangingSignBlock(WoodType pType, Properties pProperties) {
        super(pType, pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new IcariaHangingSignBlockEntity(pPos, pState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        var blockState = this.defaultBlockState();
        var blockPos = pContext.getClickedPos();
        var level = pContext.getLevel();
        var fluidState = level.getFluidState(blockPos);

        for (var direction : pContext.getNearestLookingDirections()) {
            var axis = direction.getAxis();
            if (axis.isHorizontal()) {
                if (!axis.test(pContext.getClickedFace())) {
                    blockState = blockState.setValue(BlockStateProperties.HORIZONTAL_FACING, direction.getOpposite());
                    if (blockState.canSurvive(level, blockPos)) {
                        if (this.canPlace(blockState, level, blockPos)) {
                            return blockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluidState.getType() == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluidState.getType() == Fluids.WATER);
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pState);
    }
}
