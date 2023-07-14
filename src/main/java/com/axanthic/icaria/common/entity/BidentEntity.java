package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentEntity extends AbstractArrow {
	public boolean dealtDamage;

	public static final EntityDataAccessor<ItemStack> ITEM_STACK = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.ITEM_STACK);

	public ItemStack stack = new ItemStack(IcariaItems.CHALKOS_TOOLS.bident.get());

	public BidentEntity(EntityType<? extends BidentEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	public BidentEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
		super(IcariaEntityTypes.BIDENT.get(), pEntity, pLevel);
		this.stack = pStack.copy();
		this.entityData.set(BidentEntity.ITEM_STACK, this.stack);
	}

	@Override
	public boolean tryPickup(Player pPlayer) {
		return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		var itemStack = this.getRawItem();
		pCompound.putBoolean("DealtDamage", this.dealtDamage);
		if (!itemStack.isEmpty()) {
			pCompound.put("Bident", itemStack.save(new CompoundTag()));
		}
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(BidentEntity.ITEM_STACK, ItemStack.EMPTY);
	}

	@Override
	public void onHitEntity(EntityHitResult pResult) {
		float damage = ((BidentItem) this.stack.getItem()).attackDamage;

		var owner = this.getOwner();
		var target = pResult.getEntity();

		if (target instanceof LivingEntity livingEntity) {
			damage += EnchantmentHelper.getDamageBonus(this.stack, livingEntity.getMobType());
		}

		if (target.hurt(this.damageSources().trident(this, owner == null ? this : owner), damage)) {
			if (target.getType() == EntityType.ENDERMAN) {
				return;
			}
		}

		this.dealtDamage = true;
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
		this.setItem(ItemStack.of(pCompound.getCompound("Bident")));
		pCompound.putBoolean("DealtDamage", this.dealtDamage);
	}

	public void setItem(ItemStack pStack) {
		if (!pStack.is(this.getDefaultItem()) || pStack.hasTag()) {
			this.getEntityData().set(BidentEntity.ITEM_STACK, Util.make(pStack.copy(), (pItemStack) -> pItemStack.setCount(1)));
		}
	}

	@Override
	public void tickDespawn() {
		if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
			super.tickDespawn();
		}
	}

	@Override
	public EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
		return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
	}

	public Item getDefaultItem() {
		return this.stack.getItem();
	}

	public ItemStack getItem() {
		var itemStack = this.getRawItem();
		return itemStack.isEmpty() ? new ItemStack(this.getDefaultItem()) : itemStack;
	}

	@Override
	public ItemStack getPickupItem() {
		return this.stack.copy();
	}

	public ItemStack getRawItem() {
		return this.getEntityData().get(BidentEntity.ITEM_STACK);
	}

	@Override
	public SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.TRIDENT_HIT_GROUND;
	}
}
