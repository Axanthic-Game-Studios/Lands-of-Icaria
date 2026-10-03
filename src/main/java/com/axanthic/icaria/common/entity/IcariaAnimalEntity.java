package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.goal.IcariaAnimalHurtByTargetGoal;
import com.axanthic.icaria.common.goal.IcariaBreedGoal;
import com.axanthic.icaria.common.goal.IcariaEatGoal;
import com.axanthic.icaria.common.goal.IcariaFollowParentGoal;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Trough;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@SuppressWarnings("deprecation, unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public abstract class IcariaAnimalEntity extends IcariaPathfinderMobEntity {
	public int maxLockCooldown = 40;
	public int minLockCooldown = 0;
	public int maxLoveCooldown = 16000;
	public int minLoveCooldown = 0;
	public int maxLoveDuration = 1200;
	public int minLoveDuration = 0;
	public int maxTick = 64000;
	public int minTick = 0;

	public AnimationState attackAnimationState = new AnimationState();
	public AnimationState eatingAnimationState = new AnimationState();

	public static final EntityDataAccessor<Boolean> LOCK = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> LOCK_COOLDOWN = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> LOVE_COOLDOWN = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> LOVE_DURATION = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);

	public IcariaAnimalEntity(EntityType<? extends IcariaAnimalEntity> pEntityType, Level pLevel, float pHitboxMult, float pRenderMult, float pShadowMult) {
		super(pEntityType, pLevel, pHitboxMult, pRenderMult, pShadowMult);
		this.setPathfindingMalus(PathType.FIRE_IN_NEIGHBOR, 16.0F);
		this.setPathfindingMalus(PathType.FIRE, -1.0F);
	}

	public boolean canMate(IcariaAnimalEntity pEntity) {
		if (this == pEntity || this.getClass() != pEntity.getClass()) {
			return false;
		} else {
			return this.onLoveDuration() && pEntity.onLoveDuration();
		}
	}

	public static boolean checkAnimalSpawnRules(EntityType<? extends IcariaAnimalEntity> pEntityType, LevelAccessor pLevelAccessor, EntitySpawnReason pEntitySpawnReason, BlockPos pBlockPos, RandomSource pRandomSource) {
		return pLevelAccessor.getRawBrightness(pBlockPos, 0) > 8;
	}

	@Override
	public boolean doHurtTarget(ServerLevel pServerLevel, Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		return super.doHurtTarget(pServerLevel, pEntity);
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pDamage) {
		this.setLoveDuration(this.minLoveDuration);
		return super.hurtServer(pServerLevel, pDamageSource, pDamage);
	}

	public boolean onLockCooldown() {
		return this.getLockCooldown() > this.minLockCooldown;
	}

	public boolean onLoveCooldown() {
		return this.getLoveCooldown() > this.minLoveCooldown;
	}

	public boolean onLoveDuration() {
		return this.getLoveDuration() > this.minLoveDuration;
	}

	@Override
	public boolean removeWhenFarAway(double pDistSqr) {
		return false;
	}

	@Override
	public boolean shouldDropExperience() {
		return this.getSize() == this.maxSize;
	}

	@Override
	public boolean shouldDropLoot(ServerLevel pServerLevel) {
		return this.getSize() == this.maxSize;
	}

	public int age(int pAge) {
		var tick = this.getTick();
		if (tick < 16000) {
			return Math.min(tick + pAge, 16000);
		} else if (tick < 32000) {
			return Math.min(tick + pAge, 32000);
		} else if (tick < 48000) {
			return Math.min(tick + pAge, 48000);
		} else {
			return Math.min(tick + pAge, 64000);
		}
	}

	@Override
	public int getAmbientSoundInterval() {
		return 120;
	}

	public boolean getLock() {
		return this.getEntityData().get(IcariaAnimalEntity.LOCK);
	}

	public int getLockCooldown() {
		return this.getEntityData().get(IcariaAnimalEntity.LOCK_COOLDOWN);
	}

	public int getLoveCooldown() {
		return this.getEntityData().get(IcariaAnimalEntity.LOVE_COOLDOWN);
	}

	public int getLoveDuration() {
		return this.getEntityData().get(IcariaAnimalEntity.LOVE_DURATION);
	}

	public int getTick() {
		return this.getEntityData().get(IcariaAnimalEntity.TICK);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putBoolean("Lock", this.getLock());
		pValueOutput.putInt("LockCooldown", this.getLockCooldown());
		pValueOutput.putInt("LoveCooldown", this.getLoveCooldown());
		pValueOutput.putInt("LoveDuration", this.getLoveDuration());
		pValueOutput.putInt("Tick", this.getTick());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.tickLockCooldown();
		this.tickLoveCooldown();
		this.tickLoveDuration();
		this.tickTick();
	}

	@Override
	public void ate() {
		super.ate();
		if (!this.getLock() && this.isBaby()) {
			var age = this.age(1200);
			this.setTick(age);
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(IcariaAnimalEntity.LOCK, false);
		pBuilder.define(IcariaAnimalEntity.LOCK_COOLDOWN, this.minLockCooldown);
		pBuilder.define(IcariaAnimalEntity.LOVE_COOLDOWN, this.minLoveCooldown);
		pBuilder.define(IcariaAnimalEntity.LOVE_DURATION, this.minLoveDuration);
		pBuilder.define(IcariaAnimalEntity.TICK, this.minTick);
	}

	@Override
	public void handleEntityEvent(byte pId) {
		if (pId == 4) {
			this.attackAnimationState.start(this.tickCount);
		} else if (pId == 10) {
			this.eatingAnimationState.start(this.tickCount);
		} else if (pId == 18) {
			this.particle(ParticleTypes.HEART);
		} else {
			super.handleEntityEvent(pId);
		}
	}

	public void heal(int pTick) {
		if (this.getTick() == pTick) {
			this.setHealth(this.getMaxHealth());
		}
	}

	public void particle(SimpleParticleType pSimpleParticleType) {
		for (var i = 0; i < 7; i++) {
			var d = this.getRandom().nextGaussian() * 0.02D;
			var e = this.getRandom().nextGaussian() * 0.02D;
			var f = this.getRandom().nextGaussian() * 0.02D;
			this.level().addParticle(pSimpleParticleType, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d, e, f);
		}
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setLock(pValueInput.getBooleanOr("Lock", false));
		this.setLockCooldown(pValueInput.getIntOr("LockCooldown", 0));
		this.setLoveCooldown(pValueInput.getIntOr("LoveCooldown", 0));
		this.setLoveDuration(pValueInput.getIntOr("LoveDuration", 0));
		this.setTick(pValueInput.getIntOr("Tick", 0));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.5D));
		this.goalSelector.addGoal(3, new IcariaBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, Ingredient.of(this.getFood()), false));
		this.goalSelector.addGoal(6, new IcariaFollowParentGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new IcariaEatGoal(this, this.getTrough()));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new IcariaAnimalHurtByTargetGoal(this, 1.5D).setAlertOthers());
	}

	public void setLock(boolean pLock) {
		this.getEntityData().set(IcariaAnimalEntity.LOCK, pLock);
	}

	public void setLockCooldown(int pLockCooldown) {
		this.getEntityData().set(IcariaAnimalEntity.LOCK_COOLDOWN, pLockCooldown);
	}

	public void setLoveCooldown(int pLoveCooldown) {
		this.getEntityData().set(IcariaAnimalEntity.LOVE_COOLDOWN, pLoveCooldown);
	}

	public void setLoveDuration(int pLoveDuration) {
		this.getEntityData().set(IcariaAnimalEntity.LOVE_DURATION, pLoveDuration);
	}

	public void setTick(int pTick) {
		this.getEntityData().set(IcariaAnimalEntity.TICK, pTick);
	}

	@Override
	public void setSize(int pSize) {
		super.setSize(pSize);
		IcariaCommonHelper.setAttribute(Attributes.ATTACK_DAMAGE, this, pSize);
		IcariaCommonHelper.setAttribute(Attributes.ATTACK_KNOCKBACK, this, pSize);
		IcariaCommonHelper.setAttribute(Attributes.MAX_HEALTH, this, pSize * pSize);
	}

	public void spawnChildFromBreeding(IcariaAnimalEntity pEntity, ServerLevel pServerLevel) {
		var entity = this.getBreedOffspring(pServerLevel);
		if (entity != null) {
			entity.snapTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
			entity.setTick(this.minTick);
			pEntity.setLoveCooldown(this.maxLoveCooldown);
			this.setLoveCooldown(this.maxLoveCooldown);
			pEntity.setLoveDuration(this.minLoveDuration);
			this.setLoveDuration(this.minLoveDuration);
			pServerLevel.addFreshEntityWithPassengers(entity);
			pServerLevel.broadcastEntityEvent(this, (byte) 18);
			if (pServerLevel.getGameRules().get(GameRules.MOB_DROPS)) {
				var experienceOrb = new ExperienceOrb(pServerLevel, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1);
				pServerLevel.addFreshEntity(experienceOrb);
			}
		}
	}

	public void tickLockCooldown() {
		var lockCooldown = this.getLockCooldown();
		if (lockCooldown > this.minLockCooldown) {
			--lockCooldown;
			this.setLockCooldown(lockCooldown);
		}
	}

	public void tickLoveCooldown() {
		var loveCooldown = this.getLoveCooldown();
		if (loveCooldown > this.minLoveCooldown) {
			--loveCooldown;
			this.setLoveCooldown(loveCooldown);
		}
	}

	public void tickLoveDuration() {
		var loveDuration = this.getLoveDuration();
		if (loveDuration > this.minLoveDuration) {
			--loveDuration;
			this.setLoveDuration(loveDuration);
		}
	}

	public void tickTick() {
		var lock = this.getLock();
		var tick = this.getTick();
		if (!lock & tick < 16000) {
			++tick;
			this.setSize(1);
			this.setTick(tick);
		} else if (!lock & tick < 32000) {
			++tick;
			this.setSize(2);
			this.heal(16000);
			this.setTick(tick);
		} else if (!lock & tick < 48000) {
			++tick;
			this.setSize(3);
			this.heal(32000);
			this.setTick(tick);
		} else if (!lock & tick < 64000) {
			++tick;
			this.setSize(4);
			this.heal(48000);
			this.setTick(tick);
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.ATTACK_KNOCKBACK, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.TEMPT_RANGE, 10.0D);
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (itemStack.getItem() == Items.GOLDEN_DANDELION) {
			return this.goldenDandelion(itemStack, pPlayer);
		} else if (itemStack.getItem() == this.getFood()) {
			return this.food(itemStack, pPlayer);
		} else {
			return super.mobInteract(pPlayer, pInteractionHand);
		}
	}

	public InteractionResult goldenDandelion(ItemStack pItemStack, Player pPlayer) {
		if (this.isBaby() && !this.getLock() && !this.onLockCooldown() && !this.is(EntityTypeTags.CANNOT_BE_AGE_LOCKED)) {
			pItemStack.consume(1, pPlayer);
			this.setLock(true);
			this.setLockCooldown(this.maxLockCooldown);
			this.particle(ParticleTypes.PAUSE_MOB_GROWTH);
			this.level().playSound(null, this.blockPosition(), SoundEvents.GOLDEN_DANDELION_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS_SERVER;
		} else if (this.isBaby() && this.getLock() && !this.onLockCooldown() && !this.is(EntityTypeTags.CANNOT_BE_AGE_LOCKED)) {
			pItemStack.consume(1, pPlayer);
			this.setLock(false);
			this.setLockCooldown(this.maxLockCooldown);
			this.particle(ParticleTypes.RESET_MOB_GROWTH);
			this.level().playSound(null, this.blockPosition(), SoundEvents.GOLDEN_DANDELION_UNUSE, SoundSource.PLAYERS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS_SERVER;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public InteractionResult food(ItemStack pItemStack, Player pPlayer) {
		if (this.isBaby() && !this.getLock()) {
			var age = this.age(1200);
			pItemStack.consume(1, pPlayer);
			this.particle(ParticleTypes.HAPPY_VILLAGER);
			this.setTick(age);
			return InteractionResult.SUCCESS;
		} else if (!this.getLock() && !this.level().isClientSide() && !this.onLoveCooldown() && !this.onLoveDuration()) {
			pItemStack.consume(1, pPlayer);
			pPlayer.awardStat(Stats.ANIMALS_BRED);
			this.level().broadcastEntityEvent(this, (byte) 18);
			this.setLoveDuration(this.maxLoveDuration);
			return InteractionResult.SUCCESS_SERVER;
		} else {
			return InteractionResult.FAIL;
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setTick(this.getRandom().nextIntBetweenInclusive(this.minTick, this.maxTick));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}

	@Nullable
	public abstract IcariaAnimalEntity getBreedOffspring(ServerLevel pServerLevel);

	public abstract Item getFood();

	public abstract Trough getTrough();
}
