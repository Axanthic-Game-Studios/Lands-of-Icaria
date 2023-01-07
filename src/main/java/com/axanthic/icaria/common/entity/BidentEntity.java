package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentEntity extends AbstractArrow {
	public static final EntityDataAccessor<ItemStack> ITEM = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.ITEM_STACK);
	public ItemStack stack = new ItemStack(IcariaItems.CHALKOS_TOOLS.bident.get());

	public BidentEntity(EntityType<? extends BidentEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	public BidentEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
		super(IcariaEntities.BIDENT.get(), pEntity, pLevel);
		this.stack = pStack.copy();
		this.entityData.set(ITEM, this.stack);
	}

	@Override
	public boolean shouldRender(double pX, double pY, double pZ) {
		return true;
	}

	@Override
	public boolean tryPickup(Player pPlayer) {
		return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
	}

	@Override
	public float getWaterInertia() {
		return 0.99F;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.put("Bident", this.stack.save(new CompoundTag()));
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ITEM, this.stack);
	}

	@Override
	public void onHitEntity(EntityHitResult pResult) {
		float damage = ((BidentItem) this.stack.getItem()).attackDamage;

		Entity owner = this.getOwner();
		Entity target = pResult.getEntity();

		if (target instanceof LivingEntity livingEntity) {
			damage += EnchantmentHelper.getDamageBonus(this.stack, livingEntity.getMobType());
		}

		if (target.hurt(DamageSource.trident(this, owner == null ? this : owner), damage)) {
			if (target.getType() == EntityType.ENDERMAN) {
				return;
			}
		}

		this.playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);
		this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
	}

	@Override
	public void playerTouch(Player pEntity) {
		if (this.ownedBy(pEntity) || this.getOwner() == null) {
			super.playerTouch(pEntity);
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.entityData.set(ITEM, this.stack);
		if (pCompound.contains("Bident", 10)) {
			this.stack = ItemStack.of(pCompound.getCompound("Bident"));
		}
	}

	@Override
	public void tickDespawn() {
		if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
			super.tickDespawn();
		}
	}

	public ItemStack getItem() {
		return this.entityData.get(ITEM);
	}

	@Override
	public ItemStack getPickupItem() {
		return this.stack.copy();
	}

	@Override
	public SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.TRIDENT_HIT_GROUND;
	}
}
