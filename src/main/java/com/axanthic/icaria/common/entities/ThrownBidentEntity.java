package com.axanthic.icaria.common.entities;

import com.axanthic.icaria.common.items.IcariaBidentItem;
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

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ThrownBidentEntity extends AbstractArrow {
	private static final EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(ThrownBidentEntity.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<ItemStack> ID_BIDENT_ITEM = SynchedEntityData.defineId(ThrownBidentEntity.class, EntityDataSerializers.ITEM_STACK);
	private ItemStack bidentItem = new ItemStack(IcariaItems.CHALKOS_TOOLS.BIDENT.get());
	private boolean dealtDamage;
	public int clientSideReturnTridentTickCount;

	public ThrownBidentEntity(EntityType<? extends ThrownBidentEntity> p_37561_, Level world) {
		super(p_37561_, world);
	}

	public ThrownBidentEntity(Level world, LivingEntity bident, ItemStack stack) {
		super(IcariaEntities.BIDENT.get(), bident, world);

		this.bidentItem = stack.copy();
		this.entityData.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(stack));
		this.entityData.set(ID_BIDENT_ITEM, this.bidentItem);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ID_LOYALTY, (byte)0);
		this.entityData.define(ID_BIDENT_ITEM, bidentItem);
	}

	public void tick() {
		if (this.inGroundTime > 4) {
			this.dealtDamage = true;
		}

		Entity entity = this.getOwner();
		int i = this.entityData.get(ID_LOYALTY);
		if (i > 0 && (this.dealtDamage || this.isNoPhysics()) && entity != null) {
			if (!this.isAcceptibleReturnOwner()) {
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

				double d0 = 0.05D * (double)i;
				this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3.normalize().scale(d0)));
				if (this.clientSideReturnTridentTickCount == 0) {
					this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
				}

				++this.clientSideReturnTridentTickCount;
			}
		}

		super.tick();
	}

	private boolean isAcceptibleReturnOwner() {
		Entity entity = this.getOwner();
		if (entity != null && entity.isAlive()) {
			return !(entity instanceof ServerPlayer) || !entity.isSpectator();
		} else {
			return false;
		}
	}

	public ItemStack getPickupItem() {
		return this.bidentItem.copy();
	}

	public ItemStack getContainedItem() {
		return this.entityData.get(ID_BIDENT_ITEM);
	}

	protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
		return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
	}

	protected void onHitEntity(EntityHitResult pResult) {
		Entity entity = pResult.getEntity();
		float f = 1.0F;
		if (this.bidentItem.getItem() instanceof IcariaBidentItem)
			f = ((IcariaBidentItem) this.bidentItem.getItem()).attackDamage - 1.0F;
		if (entity instanceof LivingEntity livingentity) {
			f += EnchantmentHelper.getDamageBonus(this.bidentItem, livingentity.getMobType());
		}

		Entity entity1 = this.getOwner();
		DamageSource damagesource = DamageSource.trident(this, entity1 == null ? this : entity1);
		this.dealtDamage = true;
		SoundEvent soundevent = SoundEvents.TRIDENT_HIT;
		if (entity.hurt(damagesource, f)) {
			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity instanceof LivingEntity livingentity1) {
				if (entity1 instanceof LivingEntity) {
					EnchantmentHelper.doPostHurtEffects(livingentity1, entity1);
					EnchantmentHelper.doPostDamageEffects((LivingEntity)entity1, livingentity1);
				}

				this.doPostHurtEffects(livingentity1);
			}
		}

		this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
		float f1 = 1.0F;
		if (this.level instanceof ServerLevel && this.level.isThundering() && this.isChanneling()) {
			BlockPos blockpos = entity.blockPosition();
			if (this.level.canSeeSky(blockpos)) {
				LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level);
				Objects.requireNonNull(lightningbolt).moveTo(Vec3.atBottomCenterOf(blockpos));
				lightningbolt.setCause(entity1 instanceof ServerPlayer ? (ServerPlayer)entity1 : null);
				this.level.addFreshEntity(lightningbolt);
				soundevent = SoundEvents.TRIDENT_THUNDER;
				f1 = 5.0F;
			}
		}

		this.playSound(soundevent, f1, 1.0F);
	}

	public boolean isChanneling() {
		return EnchantmentHelper.hasChanneling(this.bidentItem);
	}

	protected boolean tryPickup(Player p_150196_) {
		return super.tryPickup(p_150196_) || this.isNoPhysics() && this.ownedBy(p_150196_) && p_150196_.getInventory().add(this.getPickupItem());
	}

	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.TRIDENT_HIT_GROUND;
	}

	public void playerTouch(Player pEntity) {
		if (this.ownedBy(pEntity) || this.getOwner() == null) {
			super.playerTouch(pEntity);
		}
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		if (pCompound.contains("Bident", 10)) {
			this.bidentItem = ItemStack.of(pCompound.getCompound("Bident"));
		}

		this.dealtDamage = pCompound.getBoolean("DealtDamage");
		this.entityData.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(this.bidentItem));
		this.entityData.set(ID_BIDENT_ITEM, this.bidentItem);
	}

	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.put("Bident", this.bidentItem.save(new CompoundTag()));
		pCompound.putBoolean("DealtDamage", this.dealtDamage);
	}

	public void tickDespawn() {
		int i = this.entityData.get(ID_LOYALTY);
		if (this.pickup != Pickup.ALLOWED || i <= 0) {
			super.tickDespawn();
		}
	}

	protected float getWaterInertia() {
		return 0.99F;
	}

	public boolean shouldRender(double pX, double pY, double pZ) {
		return true;
	}
}