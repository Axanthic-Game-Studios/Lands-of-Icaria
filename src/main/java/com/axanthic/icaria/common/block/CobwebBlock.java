package com.axanthic.icaria.common.block;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CobwebBlock extends WebBlock {
	public CobwebBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(BlockStateProperties.UP, false).setValue(BlockStateProperties.DOWN, false));
	}

	public boolean connects(BlockState pBlockState) {
		return pBlockState.isSolid() || pBlockState.getBlock() == this;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, BlockStateProperties.UP, BlockStateProperties.DOWN);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return this.update(pBlockPlaceContext.getClickedPos(), pBlockPlaceContext.getLevel());
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.setValue(this.getProperty(pDirection), this.connects(pBlockStateFaced));
	}

	public BlockState update(BlockPos pBlockPos, LevelAccessor pLevelAccessor) {
		var blockState = this.defaultBlockState();

		for (var direction : Direction.values()) {
			blockState = blockState.setValue(this.getProperty(direction), this.connects(pLevelAccessor.getBlockState(pBlockPos.relative(direction))));
		}

		return blockState;
	}

	public BooleanProperty getProperty(Direction pDirection) {
		return switch (pDirection) {
			case NORTH -> BlockStateProperties.NORTH;
			case EAST -> BlockStateProperties.EAST;
			case SOUTH -> BlockStateProperties.SOUTH;
			case WEST -> BlockStateProperties.WEST;
			case UP -> BlockStateProperties.UP;
			case DOWN -> BlockStateProperties.DOWN;
		};
	}
}
