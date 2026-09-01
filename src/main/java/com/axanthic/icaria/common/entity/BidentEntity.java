package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentEntity extends AbstractArrow {
	public static final EntityDataAccessor<Boolean> DEALT = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<ItemStack> STACK = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.ITEM_STACK);

	public BidentEntity(EntityType<? extends BidentEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public BidentEntity(Level pLevel, LivingEntity pLivingEntity, ItemStack pItemStack) {
		super(IcariaEntityTypes.BIDENT.get(), pLivingEntity, pLevel, pItemStack, null);
		this.setDealt(false);
		this.setStack(pItemStack);
	}

	public BidentEntity(Level pLevel, double pX, double pY, double pZ, ItemStack pItemStack) {
		super(IcariaEntityTypes.BIDENT.get(), pX, pY, pZ, pLevel, pItemStack, pItemStack);
		this.setDealt(false);
		this.setStack(pItemStack);
	}

	public boolean getDealt() {
		return this.getEntityData().get(BidentEntity.DEALT);
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
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putBoolean("Dealt", this.getDealt());
		pValueOutput.store("Stack", ItemStack.CODEC, this.getStack());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(BidentEntity.DEALT, false);
		pBuilder.define(BidentEntity.STACK, new ItemStack(this.getDefaultPickupItem().getItem()));
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		var vec3 = this.getDeltaMovement().multiply(0.02, 0.2, 0.02);
		var owner = this.getOwner();
		var damageSource = this.damageSources().trident(this, owner == null ? this : owner);
		var entity = pEntityHitResult.getEntity();
		if (this.getStack().getItem() instanceof BidentItem bidentItem) {
			if (this.level() instanceof ServerLevel serverLevel) {
				if (entity instanceof LivingEntity livingEntity) {
					if (entity.hurtServer(serverLevel, damageSource, bidentItem.getAttackDamage())) {
						if (livingEntity.getType() != EntityType.ENDERMAN) {
							this.deflect(ProjectileDeflection.REVERSE, entity, EntityReference.of(owner), false);
							this.doKnockback(livingEntity, damageSource);
							this.setDealt(true);
							this.setDeltaMovement(vec3);
							this.playSound(IcariaSoundEvents.BIDENT_HIT);
						}
					}
				}
			}
		}
	}

	@Override
	public void playerTouch(Player pPlayer) {
		if (this.getOwner() == null || this.ownedBy(pPlayer)) {
			super.playerTouch(pPlayer);
		}
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setDealt(pValueInput.getBooleanOr("Dealt", false));
		this.setStack(pValueInput.read("Stack", ItemStack.CODEC).orElse(ItemStack.EMPTY));
	}

	public void setDealt(boolean pDealt) {
		this.getEntityData().set(BidentEntity.DEALT, pDealt);
	}

	public void setStack(ItemStack pItemStack) {
		this.getEntityData().set(BidentEntity.STACK, pItemStack);
	}

	@Override
	public void tickDespawn() {
		if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
			super.tickDespawn();
		}
	}

	@Nullable
	@Override
	public EntityHitResult findHitEntity(Vec3 pVec3Start, Vec3 pVec3End) {
		return this.getDealt() ? null : super.findHitEntity(pVec3Start, pVec3End);
	}

	public ItemStack getStack() {
		return this.getEntityData().get(BidentEntity.STACK);
	}

	@Override
	public ItemStack getDefaultPickupItem() {
		return new ItemStack(IcariaItems.CHERT_BIDENT.get());
	}

	@Override
	public SoundEvent getDefaultHitGroundSoundEvent() {
		return IcariaSoundEvents.BIDENT_HIT_GROUND;
	}
}
