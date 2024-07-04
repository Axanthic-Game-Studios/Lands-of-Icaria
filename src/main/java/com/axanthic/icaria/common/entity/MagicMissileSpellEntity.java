package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MagicMissileSpellEntity extends SpellEntity {
    public MagicMissileSpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        var level = this.level();
        var blockPos = pResult.getBlockPos();
        if (level.getBlockState(blockPos).getDestroySpeed(level, blockPos) > 0) {
            level.destroyBlock(blockPos, false);
        }
    }

    @Override
    public void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            livingEntity.hurt(this.damageSources().magic(), 8.0F);
        }
    }
}
