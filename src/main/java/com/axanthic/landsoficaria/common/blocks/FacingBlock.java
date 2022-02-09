package com.axanthic.landsoficaria.common.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class FacingBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.FACING;

	public FacingBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		if (!context.getPlayer().isShiftKeyDown()) {
			return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
		}

		return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection());
	}
}
