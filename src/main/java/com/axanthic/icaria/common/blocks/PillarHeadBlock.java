package com.axanthic.icaria.common.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class PillarHeadBlock extends DirectionalBlock {
	public PillarHeadBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		if (!Objects.requireNonNull(pContext.getPlayer()).isShiftKeyDown()) {
			return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
		}

		return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection());
	}
}
