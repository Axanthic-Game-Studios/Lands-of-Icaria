package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.CrystalBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaShapes;

import com.mojang.serialization.MapCodec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalBlock extends DirectionalBlock implements EntityBlock, MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public static final MapCodec<CrystalBlock> CODEC = Block.simpleCodec(CrystalBlock::new);

	public CrystalBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.FACING, Direction.DOWN).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var relativePos = pPos.relative(pState.getValue(BlockStateProperties.FACING).getOpposite());
		return pLevel.getBlockState(relativePos).isSolidRender(pLevel, relativePos);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
		if (!pLevel.isClientSide()) {
			var blockPos = pHit.getBlockPos();
			pLevel.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS);
			pLevel.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return switch (pState.getValue(BlockStateProperties.FACING)) {
			case NORTH -> new CrystalBlockEntity(pPos, pState, 0.5D, 0.5D, 1.0D);
			case EAST -> new CrystalBlockEntity(pPos, pState, 0.0D, 0.5D, 0.5D);
			case SOUTH -> new CrystalBlockEntity(pPos, pState, 0.5D, 0.5D, 0.0D);
			case WEST -> new CrystalBlockEntity(pPos, pState, 1.0D, 0.5D, 0.5D);
			case UP -> new CrystalBlockEntity(pPos, pState, 0.5D, 0.0D, 0.5D);
			case DOWN -> new CrystalBlockEntity(pPos, pState, 0.5D, 1.0D, 0.5D);
		};
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var fluid = pContext.getLevel().getFluidState(pContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(BlockStateProperties.FACING, pContext.getClickedFace()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.setValue(BlockStateProperties.FACING, pMirror.mirror(pState.getValue(BlockStateProperties.FACING)));
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(BlockStateProperties.FACING, pRotation.rotate(pState.getValue(BlockStateProperties.FACING)));
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == pState.getValue(BlockStateProperties.FACING).getOpposite() && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
	}

	@Override
	public MapCodec<? extends DirectionalBlock> codec() {
		return CrystalBlock.CODEC;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return switch (pState.getValue(BlockStateProperties.FACING)) {
			case NORTH -> IcariaShapes.NORTH;
			case EAST -> IcariaShapes.EAST;
			case SOUTH -> IcariaShapes.SOUTH;
			case WEST -> IcariaShapes.WEST;
			case UP -> IcariaShapes.UP;
			case DOWN -> IcariaShapes.DOWN;
		};
	}
}
