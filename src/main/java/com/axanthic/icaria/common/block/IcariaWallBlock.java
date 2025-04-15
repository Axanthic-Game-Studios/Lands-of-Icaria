package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallBlock extends WallBlock implements MediterraneanWaterloggedBlock {
	public Map<BlockState, VoxelShape> collisionShape;
	public Map<BlockState, VoxelShape> shape;

	public IcariaWallBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.NORTH_WALL, WallSide.NONE).setValue(BlockStateProperties.EAST_WALL, WallSide.NONE).setValue(BlockStateProperties.SOUTH_WALL, WallSide.NONE).setValue(BlockStateProperties.WEST_WALL, WallSide.NONE).setValue(BlockStateProperties.UP, true).setValue(BlockStateProperties.WATERLOGGED, false));
		this.collisionShape = this.makeShapes(3.0D, 24.0D, 0.0D, 24.0D, 24.0D, 4.0D);
		this.shape = this.makeShapes(3.0D, 14.0D, 0.0D, 16.0D, 16.0D, 4.0D);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.NORTH_WALL, BlockStateProperties.EAST_WALL, BlockStateProperties.SOUTH_WALL, BlockStateProperties.WEST_WALL, BlockStateProperties.UP, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return super.getStateForPlacement(pBlockPlaceContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType() == IcariaFluids.MEDITERRANEAN_WATER.get());
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pBlockState);
	}

	public Map<BlockState, VoxelShape> makeShapes(double pDepth, double pWall, double pWallBase, double pWallPost, double pWallTall, double pWidth) {
		var d = 8.0D + pDepth;
		var e = 8.0D - pDepth;
		var f = 8.0D + pWidth;
		var g = 8.0D - pWidth;
		var builder = new ImmutableMap.Builder<BlockState, VoxelShape>();
		for (var north : BlockStateProperties.NORTH_WALL.getPossibleValues()) {
			for (var east : BlockStateProperties.EAST_WALL.getPossibleValues()) {
				for (var south : BlockStateProperties.SOUTH_WALL.getPossibleValues()) {
					for (var west : BlockStateProperties.WEST_WALL.getPossibleValues()) {
						for (var up : BlockStateProperties.UP.getPossibleValues()) {
							var blockState = this.defaultBlockState().setValue(BlockStateProperties.NORTH_WALL, north).setValue(BlockStateProperties.EAST_WALL, east).setValue(BlockStateProperties.SOUTH_WALL, south).setValue(BlockStateProperties.WEST_WALL, west).setValue(BlockStateProperties.UP, up);
							var voxelShape = Shapes.empty();
							voxelShape = this.applyShape(Block.box(e, pWallBase, 0.0D, d, pWall, d), voxelShape, Block.box(e, pWallBase, 0.0D, d, pWallTall, d), north);
							voxelShape = this.applyShape(Block.box(e, pWallBase, e, 16.0D, pWall, d), voxelShape, Block.box(e, pWallBase, e, 16.0D, pWallTall, d), east);
							voxelShape = this.applyShape(Block.box(e, pWallBase, e, d, pWall, 16.0D), voxelShape, Block.box(e, pWallBase, e, d, pWallTall, 16.0D), south);
							voxelShape = this.applyShape(Block.box(0.0D, pWallBase, e, d, pWall, d), voxelShape, Block.box(0.0D, pWallBase, e, d, pWallTall, d), west);

							if (up) {
								voxelShape = Shapes.or(voxelShape, Block.box(g, 0.0D, g, f, pWallPost, f));
							}

							builder.put(blockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false), voxelShape);
							builder.put(blockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, true), voxelShape);
							builder.put(blockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, true).setValue(BlockStateProperties.WATERLOGGED, false), voxelShape);
							builder.put(blockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, true).setValue(BlockStateProperties.WATERLOGGED, true), voxelShape);
						}
					}
				}
			}
		}

		return builder.build();
	}

	public VoxelShape applyShape(VoxelShape pVoxelShapeWall, VoxelShape pVoxelShapeWallBase, VoxelShape pVoxelShapeWallTall, WallSide pWallSide) {
		return pWallSide == WallSide.TALL ? Shapes.or(pVoxelShapeWallBase, pVoxelShapeWallTall) : pWallSide == WallSide.LOW ? Shapes.or(pVoxelShapeWallBase, pVoxelShapeWall) : pVoxelShapeWallBase;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return this.collisionShape.get(pBlockState);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return this.shape.get(pBlockState);
	}
}
