package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArachnidEntity extends Monster {
	public IcariaArachnidEntity(EntityType<? extends IcariaArachnidEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean canBeAffected(MobEffectInstance pMobEffectInstance) {
		return super.canBeAffected(pMobEffectInstance) && !pMobEffectInstance.is(MobEffects.POISON);
	}

	public static boolean checkAnyLightArachnidSpawnRules(EntityType<? extends IcariaArachnidEntity> pEntityType, LevelAccessor pLevelAccessor, EntitySpawnReason pEntitySpawnReason, BlockPos pBlockPos, RandomSource pRandomSource) {
		return pLevelAccessor.getDifficulty() != Difficulty.PEACEFUL && IcariaConfig.SPAWN_ARACHNIDS.get() && Mob.checkMobSpawnRules(pEntityType, pLevelAccessor, pEntitySpawnReason, pBlockPos, pRandomSource);
	}

	@Override
	public void makeStuckInBlock(BlockState pBlockState, Vec3 pVec3) {
		if (!pBlockState.is(Blocks.COBWEB) && !pBlockState.is(IcariaBlocks.COBWEB)) {
			super.makeStuckInBlock(pBlockState, pVec3);
		}
	}
}
