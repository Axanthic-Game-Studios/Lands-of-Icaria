package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VinegarEntity extends AbstractArrow {
    public ItemStack stack = new ItemStack(IcariaItems.VINEGAR.get());

    public VinegarEntity(EntityType<? extends VinegarEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public VinegarEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
        super(IcariaEntityTypes.VINEGAR.get(), pEntity, pLevel);
        this.stack = pStack.copy();
    }

    @Override
    public void onHit(HitResult pResult) {
        this.discard();
    }

    @Override
    public void playerTouch(Player pEntity) {
        pEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 0), this);
        pEntity.hurt(this.damageSources().mobProjectile(this, pEntity), 1.0F);
    }

    public ItemStack getItem() {
        return this.stack;
    }

    @Override
    public ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
