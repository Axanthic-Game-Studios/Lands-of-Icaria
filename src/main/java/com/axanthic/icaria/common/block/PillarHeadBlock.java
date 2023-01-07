package com.axanthic.icaria.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class PillarHeadBlock extends DirectionalBlock {
	public PillarHeadBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		if (pContext.getPlayer() != null) {
			if (!pContext.getPlayer().isShiftKeyDown()) {
				return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection());
			}
		}

		return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
	}
}
