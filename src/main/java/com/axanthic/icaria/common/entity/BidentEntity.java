package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentEntity extends AbstractArrow {
	public static EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.BYTE);
	public static EntityDataAccessor<ItemStack> ID_BIDENT_ITEM = SynchedEntityData.defineId(BidentEntity.class, EntityDataSerializers.ITEM_STACK);
	public ItemStack bidentItem = new ItemStack(IcariaItems.CHALKOS_TOOLS.BIDENT.get());
	public boolean dealtDamage;
	public int clientSideReturnTridentTickCount;

	public BidentEntity(EntityType<? extends BidentEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	public BidentEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
		super(IcariaEntities.BIDENT.get(), pEntity, pLevel);

		this.bidentItem = pStack.copy();
		this.entityData.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(pStack));
		this.entityData.set(ID_BIDENT_ITEM, this.bidentItem);
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ID_LOYALTY, (byte) 0);
		this.entityData.define(ID_BIDENT_ITEM, bidentItem);
	}

	@Override
	public void tick() {
		if (this.inGroundTime > 4) {
			this.dealtDamage = true;
		}

		Entity entity = this.getOwner();
		int i = this.entityData.get(ID_LOYALTY);
		if (i > 0 && (this.dealtDamage || this.isNoPhysics()) && entity != null) {
			if (!this.isAcceptableReturnOwner()) {
				if (!this.level.isClientSide && this.pickup == AbstractArrow.Pickup.ALLOWED) {
					this.spawnAtLocation(this.getPickupItem(), 0.1F);
				}

				this.discard();
			} else {
				this.setNoPhysics(true);
				Vec3 vec3 = entity.getEyePosition().subtract(this.position());
				this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015D * (double)i, this.getZ());
				if (this.level.isClientSide) {
					this.yOld = this.getY();
				}

				double d = 0.05D * (double)i;
				this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3.normalize().scale(d)));
				if (this.clientSideReturnTridentTickCount == 0) {
					this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
				}

				++this.clientSideReturnTridentTickCount;
			}
		}

		super.tick();
	}

	public boolean isAcceptableReturnOwner() {
		Entity entity = this.getOwner();
		if (entity != null && entity.isAlive()) {
			return !(entity instanceof ServerPlayer) || !entity.isSpectator();
		} else {
			return false;
		}
	}

	@Override
	public ItemStack getPickupItem() {
		return this.bidentItem.copy();
	}

	public ItemStack getContainedItem() {
		return this.entityData.get(ID_BIDENT_ITEM);
	}

	@Override
	public EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
		return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
	}

	@Override
	public void onHitEntity(EntityHitResult pResult) {
		Entity entityOne = pResult.getEntity();
		float f1 = 1.0F;
		if (this.bidentItem.getItem() instanceof BidentItem)
			f1 = ((BidentItem) this.bidentItem.getItem()).attackDamage - 1.0F;
		if (entityOne instanceof LivingEntity livingEntityOne) {
			f1 += EnchantmentHelper.getDamageBonus(this.bidentItem, livingEntityOne.getMobType());
		}

		Entity entityTwo = this.getOwner();
		DamageSource source = DamageSource.trident(this, entityTwo == null ? this : entityTwo);
		this.dealtDamage = true;
		SoundEvent event = SoundEvents.TRIDENT_HIT;
		if (entityOne.hurt(source, f1)) {
			if (entityOne.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entityOne instanceof LivingEntity livingEntityTwo) {
				if (entityTwo instanceof LivingEntity) {
					EnchantmentHelper.doPostHurtEffects(livingEntityTwo, entityTwo);
					EnchantmentHelper.doPostDamageEffects((LivingEntity)entityTwo, livingEntityTwo);
				}

				this.doPostHurtEffects(livingEntityTwo);
			}
		}

		this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
		float f2 = 1.0F;
		if (this.level instanceof ServerLevel && this.level.isThundering() && this.isChanneling()) {
			BlockPos blockpos = entityOne.blockPosition();
			if (this.level.canSeeSky(blockpos)) {
				LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(this.level);
				Objects.requireNonNull(bolt).moveTo(Vec3.atBottomCenterOf(blockpos));
				bolt.setCause(entityTwo instanceof ServerPlayer ? (ServerPlayer)entityTwo : null);
				this.level.addFreshEntity(bolt);
				event = SoundEvents.TRIDENT_THUNDER;
				f2 = 5.0F;
			}
		}

		this.playSound(event, f2, 1.0F);
	}

	public boolean isChanneling() {
		return EnchantmentHelper.hasChanneling(this.bidentItem);
	}

	@Override
	public boolean tryPickup(Player pPlayer) {
		return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
	}

	@Override
	public SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.TRIDENT_HIT_GROUND;
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
		this.dealtDamage = pCompound.getBoolean("DealtDamage");
		this.entityData.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(this.bidentItem));
		this.entityData.set(ID_BIDENT_ITEM, this.bidentItem);
		if (pCompound.contains("Bident", 10)) {
			this.bidentItem = ItemStack.of(pCompound.getCompound("Bident"));
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.put("Bident", this.bidentItem.save(new CompoundTag()));
		pCompound.putBoolean("DealtDamage", this.dealtDamage);
	}

	@Override
	public void tickDespawn() {
		int i = this.entityData.get(ID_LOYALTY);
		if (this.pickup != Pickup.ALLOWED || i <= 0) {
			super.tickDespawn();
		}
	}

	@Override
	public float getWaterInertia() {
		return 0.99F;
	}

	@Override
	public boolean shouldRender(double pX, double pY, double pZ) {
		return true;
	}
}
