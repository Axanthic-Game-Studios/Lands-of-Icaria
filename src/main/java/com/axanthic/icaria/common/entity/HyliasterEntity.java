package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterEntity extends Monster {
	public int maxSize = 4;
	public int minSize = 1;

	public float aabbMult = 0.2F;
	public float renderMult = 0.25F;
	public float shadowMult = 0.15F;
	public float sizeMult = 0.75F;
	public float sizeMultInverted = 0.25F;

	public AnimationState moveAnimationState = new AnimationState();

	public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(HyliasterEntity.class, EntityDataSerializers.INT);

	public HyliasterEntity(EntityType<? extends HyliasterEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	@Override
	public boolean isBaby() {
		return this.getSize() < this.maxSize;
	}

	public boolean isMovingOnLand() {
		return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 0;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	public float getSizeInverted() {
		return this.getSize() * -1.0F + 5.0F;
	}

	public float getScaleForRender() {
		return this.getScaleFromSize() * this.renderMult;
	}

	public float getScaleForShadow() {
		return this.getScaleFromSize() * this.shadowMult;
	}

	public float getScaleFromSize() {
		return this.getSizeWithMultInverted() + this.getSizeWithMult();
	}

	public float getSizeWithMult() {
		return this.getSize() * this.sizeMult;
	}

	public float getSizeWithMultInverted() {
		return this.getSizeInverted() * this.sizeMultInverted;
	}

	@Override
	public float getVoicePitch() {
		return this.getSizeWithMultInverted() + 0.75F;
	}

	public int getSize() {
		return this.entityData.get(HyliasterEntity.SIZE);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putInt("Size", this.getSize());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAlive()) {
			this.setSize(this.getSize());
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(HyliasterEntity.SIZE, this.minSize);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
		super.onSyncedDataUpdated(pKey);
		if (HyliasterEntity.SIZE.equals(pKey)) {
			this.refreshDimensions();
		}
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(IcariaSoundEvents.HYLIASTER_SQUISH, 0.1F, 1.0F);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setSize(pCompound.getInt("Size"));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
	}

	public void remove() {
		if (this.getSize() == this.minSize) {
			this.remove(RemovalReason.KILLED);
		}
	}

	@Override
	public void remove(Entity.RemovalReason pReason) {
		super.remove(pReason);
		if (!this.level().isClientSide()) {
			int size = this.getSize();
			if (size > this.minSize) {
				if (this.isDeadOrDying()) {
					for (int l = 0; l < size; ++l) {
						float xOffset = ((float) (l % 2) - 0.5F) * size * 0.05F;
						float zOffset = ((float) (l / 2) - 0.5F) * size * 0.05F;
						var entity = IcariaEntityTypes.HYLIASTER.get().create(this.level());
						if (entity != null) {
							entity.moveTo(this.getX() + xOffset, this.getY() + 0.5D, this.getZ() + zOffset, this.random.nextFloat() * 360.0F, 0.0F);
							entity.setCustomName(this.getCustomName());
							entity.setSize(this.minSize);
							this.level().addFreshEntity(entity);
						}
					}
				}
			}
		}
	}

	public void setSize(int pSize) {
		int size = Mth.clamp(pSize, this.minSize, this.maxSize);
		this.refreshDimensions();
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(size);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((size * 0.04D) + 0.1D);
		this.entityData.set(HyliasterEntity.SIZE, size);
		this.xpReward = size + 1;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			if (this.isMovingOnLand()) {
				this.moveAnimationState.startIfStopped(this.tickCount);
			} else {
				this.moveAnimationState.stop();
			}
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pPose) {
		float scale = this.getScaleFromSize() * this.aabbMult;
		return this.getType().getDimensions().scale(scale);
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
		var itemStack = pPlayer.getItemInHand(pHand);
		if (itemStack.is(IcariaItems.EMPTY_VIAL.get())) {
			var filledResult = ItemUtils.createFilledResult(itemStack, pPlayer, IcariaItems.HYLIASTRUM_VIAL.get().getDefaultInstance());
			this.remove();
			this.setSize(this.getSize() - 1);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.EMPTY_VIAL.get()));
			pPlayer.playSound(IcariaSoundEvents.VIAL_FILL);
			pPlayer.setItemInHand(pHand, filledResult);
			return InteractionResult.sidedSuccess(this.level().isClientSide());
		}

		return super.mobInteract(pPlayer, pHand);
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.HYLIASTER_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.HYLIASTER_HURT;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
		this.setSize(this.random.nextIntBetweenInclusive(1, 4));
		return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
	}
}
