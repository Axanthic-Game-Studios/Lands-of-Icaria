package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeEntity extends AbstractArrow {
    public static EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(GreekFireGrenadeEntity.class, EntityDataSerializers.BYTE);
    public static EntityDataAccessor<ItemStack> ID_ITEM = SynchedEntityData.defineId(GreekFireGrenadeEntity.class, EntityDataSerializers.ITEM_STACK);
    public ItemStack itemStack = new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get());

    public GreekFireGrenadeEntity(EntityType<? extends GreekFireGrenadeEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public GreekFireGrenadeEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
        super(IcariaEntities.GREEK_FIRE_GRENADE.get(), pEntity, pLevel);
        this.itemStack = pStack.copy();
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(pStack));
        this.entityData.set(ID_ITEM, this.itemStack);
    }

    @Override
    public boolean shouldRender(double pX, double pY, double pZ) {
        return true;
    }

    @Override
    public float getWaterInertia() {
        return 0.99F;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("Grenade", this.itemStack.save(new CompoundTag()));
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_LOYALTY, (byte) 0);
        this.entityData.define(ID_ITEM, itemStack);
    }

    @Override
    public void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level.isClientSide) {
            this.level.explode(null, this.getX(), this.getY(), this.getZ(), 1.5F, false, Explosion.BlockInteraction.NONE);
            for (int i = -2; i <= 2; i++) {
                BlockPos posNeg = new BlockPos(this.getX() - i, this.getY() - i, this.getZ() - i);
                BlockPos posPos = new BlockPos(this.getX() + i, this.getY() + i, this.getZ() + i);
                for (BlockPos blockpos : BlockPos.betweenClosed(posNeg, posPos)) {
                    if (this.random.nextInt(10) == 0 && this.level.getBlockState(blockpos).isAir() && this.level.getBlockState(blockpos.below()).isSolidRender(this.level, blockpos.below())) {
                        this.level.setBlockAndUpdate(blockpos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                    }
                }
            }

            this.discard();
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(this.itemStack));
        this.entityData.set(ID_ITEM, this.itemStack);
        if (pCompound.contains("Grenade", 10)) {
            this.itemStack = ItemStack.of(pCompound.getCompound("Grenade"));
        }
    }

    @Override
    public ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    public ItemStack getContainedItem() {
        return this.entityData.get(ID_ITEM);
    }

    @Override
    public SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.GENERIC_EXPLODE;
    }
}
