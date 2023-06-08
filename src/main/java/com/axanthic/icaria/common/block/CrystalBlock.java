package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.CrystalBlockEntity;

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
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalBlock extends DirectionalBlock implements EntityBlock, SimpleWaterloggedBlock {
	public float r;
	public float g;
	public float b;

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public static final VoxelShape SHAPE_NORTH = Block.box(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D);
	public static final VoxelShape SHAPE_EAST = Block.box(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D);
	public static final VoxelShape SHAPE_SOUTH = Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D);
	public static final VoxelShape SHAPE_WEST = Block.box(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	public static final VoxelShape SHAPE_UP = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
	public static final VoxelShape SHAPE_DOWN = Block.box(4.0D, 8.0D, 4.0D, 12.0D, 16.0D, 12.0D);

	public CrystalBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.DOWN).setValue(WATERLOGGED, false));
	}

	public CrystalBlock(Properties pProperties, float pRed, float pGreen, float pBlue) {
		this(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.DOWN).setValue(WATERLOGGED, false));
		this.r = pRed;
		this.g = pGreen;
		this.b = pBlue;
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockPos blockPos = pPos.relative(pState.getValue(FACING).getOpposite());
		return pLevel.getBlockState(blockPos).isSolidRender(pLevel, blockPos);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING, WATERLOGGED);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
		if (!pLevel.isClientSide) {
			BlockPos blockPos = pHit.getBlockPos();
			pLevel.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS, 1.0F, 0.5F + pLevel.random.nextFloat() * 1.2F);
			pLevel.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 0.5F + pLevel.random.nextFloat() * 1.2F);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return switch (pState.getValue(FACING)) {
			case NORTH -> new CrystalBlockEntity(pPos, pState, 0.5D, 0.5D, 1.0D, this.r, this.g, this.b);
			case EAST -> new CrystalBlockEntity(pPos, pState, 0.0D, 0.5D, 0.5D, this.r, this.g, this.b);
			case SOUTH -> new CrystalBlockEntity(pPos, pState, 0.5D, 0.5D, 0.0D, this.r, this.g, this.b);
			case WEST -> new CrystalBlockEntity(pPos, pState, 1.0D, 0.5D, 0.5D, this.r, this.g, this.b);
			case UP -> new CrystalBlockEntity(pPos, pState, 0.5D, 0.0D, 0.5D, this.r, this.g, this.b);
			case DOWN -> new CrystalBlockEntity(pPos, pState, 0.5D, 1.0D, 0.5D, this.r, this.g, this.b);
		};
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getClickedFace()).setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == pState.getValue(FACING).getOpposite() && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return switch (pState.getValue(FACING)) {
			case NORTH -> SHAPE_NORTH;
			case EAST -> SHAPE_EAST;
			case SOUTH -> SHAPE_SOUTH;
			case WEST -> SHAPE_WEST;
			case UP -> SHAPE_UP;
			case DOWN -> SHAPE_DOWN;
		};
	}
}
