package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaHangingSignBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCeilingHangingSignBlock extends CeilingHangingSignBlock implements MediterraneanWaterloggedBlock {
    public IcariaCeilingHangingSignBlock(WoodType pType, Properties pProperties) {
        super(pType, pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.ATTACHED, false).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.ROTATION_16, 0).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.ATTACHED, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.ROTATION_16, BlockStateProperties.WATERLOGGED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new IcariaHangingSignBlockEntity(pPos, pState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == IcariaFluids.MEDITERRANEAN_WATER.get());
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pState);
    }
}
