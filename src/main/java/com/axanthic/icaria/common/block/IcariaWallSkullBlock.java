package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.DirectionShapes;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallSkullBlock extends IcariaAbstractSkullBlock {
	public IcariaWallSkullBlock(float pOffset, IcariaSkullBlockType pType, Properties pProperties) {
		super(pOffset, pType, pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		for (var direction : pBlockPlaceContext.getNearestLookingDirections()) {
			if (direction.getAxis().isHorizontal()) {
				if (!pBlockPlaceContext.getLevel().getBlockState(pBlockPlaceContext.getClickedPos().relative(direction)).canBeReplaced(pBlockPlaceContext)) {
					return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction.getOpposite());
				}
			}
		}

		return null;
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> DirectionShapes.NORTH;
			case EAST -> DirectionShapes.EAST;
			case SOUTH -> DirectionShapes.SOUTH;
			default -> DirectionShapes.WEST;
		};
	}
}
