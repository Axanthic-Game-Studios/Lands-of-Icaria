package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentEntity extends AbstractArrow {
	public static final EntityDataAccessor<Boolean> DEALT = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<ItemStack> STACK = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.ITEM_STACK);

	public BidentEntity(EntityType<? extends BidentEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	public BidentEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
		super(IcariaEntityTypes.BIDENT.get(), pEntity, pLevel, pStack, null);
		this.setDealt(false);
		this.setStack(pStack);
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
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putBoolean("Dealt", this.getDealt());
		pCompound.put("Stack", this.getStack().save(this.registryAccess()));
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(BidentEntity.DEALT, false);
		pBuilder.define(BidentEntity.STACK, new ItemStack(this.getDefaultPickupItem().getItem()));
	}

	@Override
	public void onHitEntity(EntityHitResult pResult) {
		float damage = 1.0F;

		var item = this.getStack();
		var owner = this.getOwner();

		var target = pResult.getEntity();

		if (item.getItem() instanceof BidentItem bidentItem) {
			damage += bidentItem.getTier().getAttackDamageBonus() + 3.5F;
		}

		if (target.hurt(this.damageSources().trident(this, owner == null ? this : owner), damage)) {
			if (target.getType() == EntityType.ENDERMAN) {
				return;
			}
		}

		this.playSound(SoundEvents.TRIDENT_HIT, 0.1F, 1.0F);
		this.setDealt(true);
		this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
	}

	@Override
	public void playerTouch(Player pEntity) {
		if (this.getOwner() == null || this.ownedBy(pEntity)) {
			super.playerTouch(pEntity);
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setDealt(pCompound.getBoolean("Dealt"));
		ItemStack.parse(this.registryAccess(), pCompound.getCompound("Stack")).ifPresent(this::setStack);
	}

	public void setDealt(boolean pDealt) {
		this.getEntityData().set(BidentEntity.DEALT, pDealt);
	}

	public void setStack(ItemStack pStack) {
		this.getEntityData().set(BidentEntity.STACK, pStack.copy());
	}

	@Override
	public void tickDespawn() {
		if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
			super.tickDespawn();
		}
	}

	@Override
	public EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
		return this.getDealt() ? null : super.findHitEntity(pStartVec, pEndVec);
	}

	public ItemStack getStack() {
		return this.getEntityData().get(BidentEntity.STACK);
	}

	@Override
	public ItemStack getDefaultPickupItem() {
		return new ItemStack(IcariaItems.CHERT_TOOLS.bident.get());
	}

	@Override
	public SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.TRIDENT_HIT_GROUND;
	}
}
