package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.CrystalBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.DirectionVoxelShapes;

import com.mojang.serialization.MapCodec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalBlock extends DirectionalBlock implements EntityBlock, MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public static final MapCodec<CrystalBlock> CODEC = Block.simpleCodec(CrystalBlock::new);

	public CrystalBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.FACING, Direction.DOWN).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		return pLevelReader.getBlockState(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.FACING).getOpposite())).isSolidRender();
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pBlockState) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.FACING)) {
			case NORTH -> new CrystalBlockEntity(pBlockPos, pBlockState, 0.5D, 0.5D, 1.0D);
			case EAST -> new CrystalBlockEntity(pBlockPos, pBlockState, 0.0D, 0.5D, 0.5D);
			case SOUTH -> new CrystalBlockEntity(pBlockPos, pBlockState, 0.5D, 0.5D, 0.0D);
			case WEST -> new CrystalBlockEntity(pBlockPos, pBlockState, 1.0D, 0.5D, 0.5D);
			case UP -> new CrystalBlockEntity(pBlockPos, pBlockState, 0.5D, 0.0D, 0.5D);
			case DOWN -> new CrystalBlockEntity(pBlockPos, pBlockState, 0.5D, 1.0D, 0.5D);
		};
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(BlockStateProperties.FACING, pBlockPlaceContext.getClickedFace()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
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
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.canSurvive(pLevelReader, pBlockPos) ? super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource) : Blocks.AIR.defaultBlockState();
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public MapCodec<? extends DirectionalBlock> codec() {
		return CrystalBlock.CODEC;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.FACING)) {
			case NORTH -> DirectionVoxelShapes.NORTH;
			case EAST -> DirectionVoxelShapes.EAST;
			case SOUTH -> DirectionVoxelShapes.SOUTH;
			case WEST -> DirectionVoxelShapes.WEST;
			case UP -> DirectionVoxelShapes.UP;
			case DOWN -> DirectionVoxelShapes.DOWN;
		};
	}
}
