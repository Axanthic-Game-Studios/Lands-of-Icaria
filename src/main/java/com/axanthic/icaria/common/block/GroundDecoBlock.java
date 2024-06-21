package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaFluids;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GroundDecoBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);

	public GroundDecoBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		return true;
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var belowPos = pPos.below();
		return Block.isFaceFull(pLevel.getBlockState(belowPos).getCollisionShape(pLevel, belowPos), Direction.UP);
	}

	@Override
	public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pLevel.isClientSide()) {
			if (pState.is(IcariaBlocks.SURFACE_LIGNITE.get()) && !pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pState.getValue(BlockStateProperties.WATERLOGGED)) {
				if (pRandom.nextInt(10) == 0) {
					pLevel.addParticle(ParticleTypes.LAVA, pPos.getX() + pRandom.nextDouble(), pPos.getY(), pPos.getZ() + pRandom.nextDouble(), 0.0D, 0.0D, 0.0D);
				} else {
					pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + pRandom.nextDouble(), pPos.getY(), pPos.getZ() + pRandom.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if (pState.is(IcariaBlocks.SURFACE_LIGNITE.get()) && !pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pState.getValue(BlockStateProperties.WATERLOGGED)) {
			pEntity.hurt(pLevel.damageSources().inFire(), 1.0F);
		}
	}

	@Override
	public PathType getBlockPathType(BlockState pState, BlockGetter pLevel, BlockPos pPos, @Nullable Mob pMob) {
		return pState.is(IcariaBlocks.SURFACE_LIGNITE.get()) && !pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pState.getValue(BlockStateProperties.WATERLOGGED) ? PathType.DAMAGE_OTHER : super.getBlockPathType(pState, pLevel, pPos, pMob);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var fluid = pContext.getLevel().getFluidState(pContext.getClickedPos()).getType();
		return super.getStateForPlacement(pContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return GroundDecoBlock.SHAPE;
	}
}
