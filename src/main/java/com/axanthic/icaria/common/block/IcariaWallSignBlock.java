package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.block.entity.IcariaSignBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaShapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallSignBlock extends WallSignBlock implements EntityBlock, MediterraneanWaterloggedBlock {
	public IcariaWallSignBlock(WoodType pWoodType, Properties pProperties) {
		super(pWoodType, pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var direction = this.getConnectedDirection(pState);
		var relativePos = pPos.relative(direction.getOpposite());
		return pLevel.getBlockState(relativePos).isFaceSturdy(pLevel, relativePos, direction);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new IcariaSignBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var clickedPos = pContext.getClickedPos();
		var level = pContext.getLevel();
		for (var direction : pContext.getNearestLookingDirections()) {
			BlockState blockState;
			if (direction.getAxis() == Direction.Axis.Y) {
				blockState = this.defaultBlockState().setValue(BlockStateProperties.ATTACH_FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, level.getFluidState(clickedPos).getType() == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, level.getFluidState(clickedPos).getType() == Fluids.WATER);
			} else {
				blockState = this.defaultBlockState().setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).setValue(BlockStateProperties.HORIZONTAL_FACING, direction.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, level.getFluidState(clickedPos).getType() == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, level.getFluidState(clickedPos).getType() == Fluids.WATER);
			}

			if (blockState.canSurvive(pContext.getLevel(), pContext.getClickedPos())) {
				return blockState;
			}
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
		return this.getConnectedDirection(pState).getOpposite() == pFacing && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}

	public Direction getConnectedDirection(BlockState pState) {
		return switch (pState.getValue(BlockStateProperties.ATTACH_FACE)) {
			case CEILING -> Direction.DOWN;
			case FLOOR -> Direction.UP;
			default -> pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		};
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pState);
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return switch (pState.getValue(BlockStateProperties.ATTACH_FACE)) {
			case FLOOR -> switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
				case NORTH -> IcariaShapes.WallSignShapes.FLOOR_NORTH;
				case EAST -> IcariaShapes.WallSignShapes.FLOOR_EAST;
				case SOUTH -> IcariaShapes.WallSignShapes.FLOOR_SOUTH;
				default -> IcariaShapes.WallSignShapes.FLOOR_WEST;
			};

			case WALL -> switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
				case NORTH -> IcariaShapes.WallSignShapes.WALL_NORTH;
				case EAST -> IcariaShapes.WallSignShapes.WALL_EAST;
				case SOUTH -> IcariaShapes.WallSignShapes.WALL_SOUTH;
				default -> IcariaShapes.WallSignShapes.WALL_WEST;
			};

			default -> switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
				case NORTH -> IcariaShapes.WallSignShapes.CEILING_NORTH;
				case EAST -> IcariaShapes.WallSignShapes.CEILING_EAST;
				case SOUTH -> IcariaShapes.WallSignShapes.CEILING_SOUTH;
				default -> IcariaShapes.WallSignShapes.CEILING_WEST;
			};
		};
	}
}
