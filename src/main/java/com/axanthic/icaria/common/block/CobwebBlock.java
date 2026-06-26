package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Connection;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.CobwebVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CobwebBlock extends WebBlock {
	public CobwebBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.defaultBlockState().setValue(IcariaBlockStateProperties.CONNECTION_NORTH, Connection.NONE).setValue(IcariaBlockStateProperties.CONNECTION_EAST, Connection.NONE).setValue(IcariaBlockStateProperties.CONNECTION_SOUTH, Connection.NONE).setValue(IcariaBlockStateProperties.CONNECTION_WEST, Connection.NONE).setValue(IcariaBlockStateProperties.CONNECTION_UP, Connection.NONE).setValue(IcariaBlockStateProperties.CONNECTION_DOWN, Connection.NONE));
	}

	public boolean hasShape(BlockPos pBlockPos, BlockState pBlockState, LevelReader pLevelReader) {
		return pBlockState.getShape(pLevelReader, pBlockPos) == Shapes.block();
	}

	public int getConnectionCount(BlockState pBlockState) {
		var count = 0;

		for (var direction : Direction.values()) {
			count += pBlockState.getValue(this.getEnum(direction)) != Connection.NONE ? 1 : 0;
		}

		return count;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CONNECTION_NORTH, IcariaBlockStateProperties.CONNECTION_EAST, IcariaBlockStateProperties.CONNECTION_SOUTH, IcariaBlockStateProperties.CONNECTION_WEST, IcariaBlockStateProperties.CONNECTION_UP, IcariaBlockStateProperties.CONNECTION_DOWN);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var level = pBlockPlaceContext.getLevel();
		var blockPos = pBlockPlaceContext.getClickedPos();

		for (var direction : Direction.values()) {
			var neighborPos = blockPos.relative(direction);
			var neighborState = level.getBlockState(neighborPos);

			if (this.hasShape(neighborPos, neighborState, level)) {
				return this.update(blockPos, level);
			}
		}

		return Blocks.AIR.defaultBlockState();
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pNeighborPos, BlockState pNeighborState, RandomSource pRandomSource) {
		for (var direction : Direction.values()) {
			var neighborPos = pBlockPos.relative(direction);
			var neighborState = pLevelReader.getBlockState(neighborPos);

			if (this.hasShape(neighborPos, neighborState, pLevelReader)) {
				return this.update(pBlockPos, pLevelReader);
			}
		}

		return Blocks.AIR.defaultBlockState();
	}

	public BlockState update(BlockPos pBlockPos, LevelReader pLevelReader) {
		var blockState = this.defaultBlockState();

		for (var direction : Direction.values()) {
			var neighborPos = pBlockPos.relative(direction);
			var neighborState = pLevelReader.getBlockState(neighborPos);
			blockState = blockState.setValue(this.getEnum(direction), this.getConnection(neighborPos, neighborState, pLevelReader));
		}

		return blockState;
	}

	public Connection getConnection(BlockPos pBlockPos, BlockState pBlockState, LevelReader pLevelReader) {
		if (this.equals(pBlockState.getBlock())) {
			return Connection.SELF;
		} else if (this.hasShape(pBlockPos, pBlockState, pLevelReader)) {
			return Connection.OTHER;
		} else {
			return Connection.NONE;
		}
	}

	public EnumProperty<Connection> getEnum(Direction pDirection) {
		return switch (pDirection) {
			case NORTH -> IcariaBlockStateProperties.CONNECTION_NORTH;
			case EAST -> IcariaBlockStateProperties.CONNECTION_EAST;
			case SOUTH -> IcariaBlockStateProperties.CONNECTION_SOUTH;
			case WEST -> IcariaBlockStateProperties.CONNECTION_WEST;
			case UP -> IcariaBlockStateProperties.CONNECTION_UP;
			case DOWN -> IcariaBlockStateProperties.CONNECTION_DOWN;
		};
	}

	public VoxelShape getShape(BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.CONNECTION_NORTH) == Connection.OTHER) {
			return CobwebVoxelShapes.NORTH;
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CONNECTION_EAST) == Connection.OTHER) {
			return CobwebVoxelShapes.EAST;
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CONNECTION_SOUTH) == Connection.OTHER) {
			return CobwebVoxelShapes.SOUTH;
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CONNECTION_WEST) == Connection.OTHER) {
			return CobwebVoxelShapes.WEST;
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CONNECTION_UP) != Connection.NONE) {
			return CobwebVoxelShapes.UP;
		} else if (pBlockState.getValue(IcariaBlockStateProperties.CONNECTION_DOWN) != Connection.NONE) {
			return CobwebVoxelShapes.DOWN;
		} else {
			return Shapes.block();
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return this.getConnectionCount(pBlockState) == 1 ? this.getShape(pBlockState) : Shapes.block();
	}
}
