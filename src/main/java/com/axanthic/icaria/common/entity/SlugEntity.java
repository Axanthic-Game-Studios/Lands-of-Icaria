package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SlugEntity extends SizedPathfinderMobEntity {
	public float red;
	public float green;
	public float blue;

	public int maxCooldown = 400;
	public int minCooldown = 0;
	public int maxHide = 80;
	public int minHide = 0;
	public int maxShow = 80;
	public int minShow = 0;

	public AnimationState hideAnimationState = new AnimationState();
	public AnimationState hurtAnimationState = new AnimationState();
	public AnimationState moveAnimationState = new AnimationState();
	public AnimationState showAnimationState = new AnimationState();

	public static final EntityDataAccessor<Boolean> CLIMBING = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> HIDE = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> SHOW = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.INT);

	public SlugEntity(EntityType<? extends SlugEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel, 0.25F, 0.25F, 0.15F);
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		this.hide();
		return super.hurtServer(pServerLevel, pDamageSource, pAmount);
	}

	public boolean isMovement() {
		return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 0;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	public boolean onClimbable() {
		return this.getClimbing();
	}

	public boolean onCooldown() {
		return this.getCooldown() > this.minCooldown;
	}

	public boolean onHide() {
		return this.getHide() > this.minHide;
	}

	public boolean onShow() {
		return this.getShow() > this.minShow;
	}

	public boolean getClimbing() {
		return this.getEntityData().get(SlugEntity.CLIMBING);
	}

	public int getCooldown() {
		return this.getEntityData().get(SlugEntity.COOLDOWN);
	}

	public int getHide() {
		return this.getEntityData().get(SlugEntity.HIDE);
	}

	public int getShow() {
		return this.getEntityData().get(SlugEntity.SHOW);
	}

	public float getShadowStrength() {
		if (this.onHide()) {
			return this.getHide() / (float) this.maxHide;
		} else if (this.onCooldown()) {
			return 0.0F;
		} else if (this.onShow()) {
			return 1.0F - (this.getShow() / (float) this.maxShow);
		} else {
			return 1.0F;
		}
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putBoolean("Climbing", this.getClimbing());
		pValueOutput.putInt("Cooldown", this.getCooldown());
		pValueOutput.putInt("Hide", this.getHide());
		pValueOutput.putInt("Show", this.getShow());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.onHide()) {
			var hide = this.getHide();
			if (hide > this.minHide) {
				--hide;
				this.setHide(hide);
				this.setCooldown(this.maxCooldown);
			}
		} else if (this.onCooldown()) {
			var cooldown = this.getCooldown();
			if (cooldown > this.minCooldown) {
				--cooldown;
				this.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, cooldown, 3, false, false));
				this.setCooldown(cooldown);
				this.setShow(this.maxShow);
			}
		} else if (this.onShow()) {
			var show = this.getShow();
			if (show > this.minShow) {
				--show;
				this.setShow(show);
			}
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(SlugEntity.CLIMBING, false);
		pBuilder.define(SlugEntity.COOLDOWN, this.minCooldown);
		pBuilder.define(SlugEntity.HIDE, this.minHide);
		pBuilder.define(SlugEntity.SHOW, this.minShow);
	}

	public void hide() {
		if (!this.onClimbable() && !this.onCooldown() && !this.onHide() && !this.onShow() && this.getBlockStateOn().is(BlockTags.DIRT)) {
			this.setHide(this.maxHide);
		}
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setClimbing(pValueInput.getBooleanOr("Climbing", false));
		this.setCooldown(pValueInput.getIntOr("Cooldown", 0));
		this.setHide(pValueInput.getIntOr("Hide", 0));
		this.setShow(pValueInput.getIntOr("Show", 0));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
	}

	public void setClimbing(boolean pClimbing) {
		this.getEntityData().set(SlugEntity.CLIMBING, pClimbing);
	}

	public void setCooldown(int pCooldown) {
		this.getEntityData().set(SlugEntity.COOLDOWN, pCooldown);
	}

	public void setHide(int pHide) {
		this.getEntityData().set(SlugEntity.HIDE, pHide);
	}

	public void setShow(int pShow) {
		this.getEntityData().set(SlugEntity.SHOW, pShow);
	}

	public void setMovement() {
		if (this.onHide() || this.onCooldown() || this.onShow()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1D);
		}
	}

	@Override
	public void setSize(int pSize) {
		super.setSize(pSize);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(pSize * pSize);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.tickHide();
			this.tickHurt();
			this.tickMove();
			this.tickShow();
			this.tickParticlePlusSounds();
			this.tickRegisterRaysValues();
		} else {
			this.setClimbing(this.horizontalCollision);
			this.setMovement();
		}
	}

	public void tickHide() {
		if (this.onHide() || this.onCooldown()) {
			this.hideAnimationState.startIfStopped(this.tickCount);
		} else {
			this.hideAnimationState.stop();
		}
	}

	public void tickHurt() {
		if (this.hurtTime > 0) {
			this.hurtAnimationState.startIfStopped(this.tickCount);
		} else {
			this.hurtAnimationState.stop();
		}
	}

	public void tickMove() {
		if (this.getClimbing() || this.isMovement()) {
			this.moveAnimationState.startIfStopped(this.tickCount);
		} else {
			this.moveAnimationState.stop();
		}
	}

	public void tickShow() {
		if (!this.onCooldown() && !this.onHide()) {
			this.showAnimationState.startIfStopped(this.tickCount);
		} else {
			this.showAnimationState.stop();
		}
	}

	public void tickParticlePlusSounds() {
		if ((this.onHide() && this.getHide() < 40) || (this.onShow() && this.getShow() > 40) && !this.onCooldown()) {
			this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getBlockStateOn().getSoundType(this.level(), this.blockPosition(), this).getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
			for (var i = 0; i < 15; ++i) {
				var x = this.getX() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				var y = this.getY();
				var z = this.getZ() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				var blockParticleOption = new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn());
				this.level().addParticle(blockParticleOption, x, y, z, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	public void tickRegisterRaysValues() {
		if (this.tickCount <= 1) {
			this.red = IcariaClientHelper.getRed(this);
			this.green = IcariaClientHelper.getGreen(this);
			this.blue = IcariaClientHelper.getBlue(this);
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (itemStack.getItem() == IcariaItems.HALITE_DUST.get()) {
			itemStack.consume(1, pPlayer);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.HALITE_DUST.get()));
			IcariaCommonHelper.hurt(this.damageSources().generic(), this, 1.0F);
			this.hide();
			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(pPlayer, pInteractionHand);
		}
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new WallClimberNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.SLUG_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.SLUG_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.SLUG_HURT;
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setSize(this.getRandom().nextIntBetweenInclusive(this.minSize, this.maxSize));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
