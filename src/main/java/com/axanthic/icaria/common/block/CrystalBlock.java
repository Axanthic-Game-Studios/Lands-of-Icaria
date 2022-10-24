package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.blockentity.CrystalBlockEntity;

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
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public static final VoxelShape NORTH_AABB = Block.box(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D);
	public static final VoxelShape EAST_AABB = Block.box(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D);
	public static final VoxelShape SOUTH_AABB = Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D);
	public static final VoxelShape WEST_AABB = Block.box(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	public static final VoxelShape UP_AABB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
	public static final VoxelShape DOWN_AABB = Block.box(4.0D, 8.0D, 4.0D, 12.0D, 16.0D, 12.0D);

	public int r;
	public int g;
	public int b;

	public CrystalBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
	}

	public CrystalBlock(Properties pProperties, int r, int g, int b) {
		this(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		Direction direction = pState.getValue(FACING);
		BlockPos pos = pPos.relative(direction.getOpposite());
		return pLevel.getBlockState(pos).isSolidRender(pLevel, pos);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pReader, BlockPos pPos) {
		return true;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING, WATERLOGGED);
	}

	@Override
	public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pResult, Projectile pProjectile) {
		if (!pLevel.isClientSide) {
			BlockPos blockpos = pResult.getBlockPos();
			pLevel.playSound(null, blockpos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS, 1.0F, 0.5F + pLevel.random.nextFloat() * 1.2F);
			pLevel.playSound(null, blockpos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 0.5F + pLevel.random.nextFloat() * 1.2F);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		switch(pState.getValue(FACING)) {
			case NORTH:
			default:
				return new CrystalBlockEntity(pPos, pState, 0.5D, 0.5D, 1.0D, r, g, b);
			case EAST:
				return new CrystalBlockEntity(pPos, pState, 0.0D, 0.5D, 0.5D, r, g, b);
			case SOUTH:
				return new CrystalBlockEntity(pPos, pState, 0.5D, 0.5D, 0.0D, r, g, b);
			case WEST:
				return new CrystalBlockEntity(pPos, pState, 1.0D, 0.5D, 0.5D, r, g, b);
			case UP:
				return new CrystalBlockEntity(pPos, pState, 0.5D, 0.0D, 0.5D, r, g, b);
			case DOWN:
				return new CrystalBlockEntity(pPos, pState, 0.5D, 1.0D, 0.5D, r, g, b);
		}
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
		switch(pState.getValue(FACING)) {
			case NORTH:
			default:
				return NORTH_AABB;
			case EAST:
				return EAST_AABB;
			case SOUTH:
				return SOUTH_AABB;
			case WEST:
				return WEST_AABB;
			case UP:
				return UP_AABB;
			case DOWN:
				return DOWN_AABB;
		}
	}
}
