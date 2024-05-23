package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.config.IcariaConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaArachnidEntity extends Monster {
    public IcariaArachnidEntity(EntityType<? extends IcariaArachnidEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static boolean checkAnyLightArachnidSpawnRules(EntityType<? extends IcariaArachnidEntity> pType, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pLevel.getDifficulty() != Difficulty.PEACEFUL && IcariaConfig.SPAWN_ARACHNIDS.get() && Mob.checkMobSpawnRules(pType, pLevel, pSpawnType, pPos, pRandom);
    }
}
