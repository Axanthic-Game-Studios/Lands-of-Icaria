package com.axanthic.icaria.common.block;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.MapCodec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault

public class PillarHeadBlock extends DirectionalBlock {
	public static final MapCodec<PillarHeadBlock> CODEC = Block.simpleCodec(PillarHeadBlock::new);

	public PillarHeadBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.FACING, Direction.NORTH));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var direction = pBlockPlaceContext.getNearestLookingDirection();
		return this.defaultBlockState().setValue(BlockStateProperties.FACING, direction);
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.FACING)));
	}

	@Override
	public MapCodec<? extends DirectionalBlock> codec() {
		return PillarHeadBlock.CODEC;
	}
}
