package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SurfaceLigniteBlock extends FloorDecorationBlock {
	public SurfaceLigniteBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void animateTick(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (!pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			this.particlesLava(pBlockPos, pLevel, pRandomSource);
			this.particlesSmoke(pBlockPos, pLevel, pRandomSource);
		}
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity, InsideBlockEffectApplier pInsideBlockEffectApplier) {
		if (!pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			IcariaCommonHelper.hurt(pLevel.damageSources().inFire(), pEntity, 1.5F);
		}
	}

	public void particlesLava(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		if (pRandomSource.nextDouble() < 0.1D) {
			pLevel.addParticle(ParticleTypes.LAVA, pBlockPos.getX() + pRandomSource.nextDouble(), pBlockPos.getY(), pBlockPos.getZ() + pRandomSource.nextDouble(), 0.0D, 0.0D, 0.0D);
			pLevel.playLocalSound(pBlockPos, IcariaSoundEvents.LIGNITE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	public void particlesSmoke(BlockPos pBlockPos, Level pLevel, RandomSource pRandomSource) {
		pLevel.addParticle(ParticleTypes.SMOKE, pBlockPos.getX() + pRandomSource.nextDouble(), pBlockPos.getY(), pBlockPos.getZ() + pRandomSource.nextDouble(), 0.0D, 0.0D, 0.0D);
	}

	@Nullable
	@Override
	public PathType getBlockPathType(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, @Nullable Mob pMob) {
		return !pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && !pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? PathType.DAMAGE_OTHER : super.getBlockPathType(pBlockState, pBlockGetter, pBlockPos, pMob);
	}
}
