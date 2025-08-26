package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaAnimalHurtByTargetGoal;
import com.axanthic.icaria.common.goal.IcariaBreedGoal;
import com.axanthic.icaria.common.goal.IcariaEatGoal;
import com.axanthic.icaria.common.goal.IcariaFollowParentGoal;
import com.axanthic.icaria.common.properties.Trough;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@SuppressWarnings("deprecation, unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public abstract class IcariaAnimalEntity extends SizedPathfinderMobEntity {
	public int maxCooldown = 16000;
	public int minCooldown = 0;
	public int maxDuration = 1200;
	public int minDuration = 0;
	public int maxTick = 64000;
	public int minTick = 0;

	public AnimationState attackAnimationState = new AnimationState();
	public AnimationState eatingAnimationState = new AnimationState();

	public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);

	public IcariaAnimalEntity(EntityType<? extends IcariaAnimalEntity> pEntityType, Level pLevel, float pHitboxMult, float pRenderMult, float pShadowMult) {
		super(pEntityType, pLevel, pHitboxMult, pRenderMult, pShadowMult);
		this.setPathfindingMalus(PathType.DAMAGE_FIRE, -1.0F);
		this.setPathfindingMalus(PathType.DANGER_FIRE, 16.0F);
	}

	public boolean canMate(IcariaAnimalEntity pEntity) {
		if (this == pEntity || this.getClass() != pEntity.getClass()) {
			return false;
		} else {
			return this.onDuration() && pEntity.onDuration();
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
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		this.setDuration(this.minDuration);
		return super.hurtServer(pServerLevel, pDamageSource, pAmount);
	}

	public boolean onCooldown() {
		return this.getCooldown() > this.minCooldown;
	}

	public boolean onDuration() {
		return this.getDuration() > this.minDuration;
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return false;
	}

	@Override
	public boolean shouldDropExperience() {
		return this.getSize() == this.maxSize;
	}

	@Override
	public boolean shouldDropLoot() {
		return this.getSize() == this.maxSize;
	}

	public int age(int pAge) {
		if (this.getTick() < 16000) {
			return Math.min(this.getTick() + pAge, 16000);
		} else if (this.getTick() < 32000) {
			return Math.min(this.getTick() + pAge, 32000);
		} else if (this.getTick() < 48000) {
			return Math.min(this.getTick() + pAge, 48000);
		} else {
			return Math.min(this.getTick() + pAge, 64000);
		}
	}

	@Override
	public int getAmbientSoundInterval() {
		return 120;
	}

	public int getCooldown() {
		return this.getEntityData().get(IcariaAnimalEntity.COOLDOWN);
	}

	public int getDuration() {
		return this.getEntityData().get(IcariaAnimalEntity.DURATION);
	}

	public int getTick() {
		return this.getEntityData().get(IcariaAnimalEntity.TICK);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putInt("Cooldown", this.getCooldown());
		pValueOutput.putInt("Duration", this.getDuration());
		pValueOutput.putInt("Tick", this.getTick());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.tickCooldown();
		this.tickDuration();
		this.tickTick();
	}

	@Override
	public void ate() {
		super.ate();
		if (this.isBaby()) {
			this.setTick(this.age(1200));
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(IcariaAnimalEntity.COOLDOWN, this.minCooldown);
		pBuilder.define(IcariaAnimalEntity.DURATION, this.minDuration);
		pBuilder.define(IcariaAnimalEntity.TICK, this.minTick);
	}

	@Override
	public void handleEntityEvent(byte pId) {
		if (pId == 4) {
			this.attackAnimationState.start(this.tickCount);
		} else if (pId == 10) {
			this.eatingAnimationState.start(this.tickCount);
		} else if (pId == 18) {
			this.spawnHeart();
		} else {
			super.handleEntityEvent(pId);
		}
	}

	public void heal(int pTick) {
		if (this.getTick() == pTick) {
			this.setHealth(this.getMaxHealth());
		}
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setCooldown(pValueInput.getIntOr("Cooldown", 0));
		this.setDuration(pValueInput.getIntOr("Duration", 0));
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

	public void setCooldown(int pCooldown) {
		this.getEntityData().set(IcariaAnimalEntity.COOLDOWN, pCooldown);
	}

	public void setDuration(int pDuration) {
		this.getEntityData().set(IcariaAnimalEntity.DURATION, pDuration);
	}

	@Override
	public void setSize(int pSize) {
		super.setSize(pSize);
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(pSize);
		this.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(pSize);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(pSize * pSize);
	}

	public void setTick(int pTick) {
		this.getEntityData().set(IcariaAnimalEntity.TICK, pTick);
	}

	public void spawnChildFromBreeding(IcariaAnimalEntity pEntity, ServerLevel pServerLevel) {
		var entity = this.getBreedOffspring(pServerLevel);
		if (entity != null) {
			entity.snapTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
			entity.setTick(this.minTick);
			pEntity.setCooldown(this.maxCooldown);
			this.setCooldown(this.maxCooldown);
			pEntity.setDuration(this.minDuration);
			this.setDuration(this.minDuration);
			pServerLevel.addFreshEntityWithPassengers(entity);
			pServerLevel.broadcastEntityEvent(this, (byte) 18);
			if (pServerLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				var experienceOrb = new ExperienceOrb(pServerLevel, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1);
				pServerLevel.addFreshEntity(experienceOrb);
			}
		}
	}

	public void spawnHeart() {
		for (var i = 0; i < 7; i++) {
			var d = this.getRandom().nextGaussian() * 0.02D;
			var e = this.getRandom().nextGaussian() * 0.02D;
			var f = this.getRandom().nextGaussian() * 0.02D;
			this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d, e, f);
		}
	}

	public void tickCooldown() {
		var cooldown = this.getCooldown();
		if (cooldown > this.minCooldown) {
			--cooldown;
			this.setCooldown(cooldown);
		}
	}

	public void tickDuration() {
		var duration = this.getDuration();
		if (duration > this.minDuration) {
			--duration;
			this.setDuration(duration);
		}
	}

	public void tickTick() {
		var tick = this.getTick();
		if (tick < 16000) {
			++tick;
			this.setSize(1);
			this.setTick(tick);
		} else if (tick < 32000) {
			++tick;
			this.setSize(2);
			this.heal(16000);
			this.setTick(tick);
		} else if (tick < 48000) {
			++tick;
			this.setSize(3);
			this.heal(32000);
			this.setTick(tick);
		} else if (tick < 64000) {
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
		if (this.getFood() == itemStack.getItem()) {
			return this.mobInteractWithFood(itemStack, pPlayer);
		} else {
			return super.mobInteract(pPlayer, pInteractionHand);
		}
	}

	public InteractionResult mobInteractWithFood(ItemStack pItemStack, Player pPlayer) {
		if (this.isBaby()) {
			pItemStack.consume(1, pPlayer);
			this.level().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
			this.setTick(this.age(1200));
			return InteractionResult.SUCCESS;
		} else if (!this.onCooldown() && !this.onDuration() && !this.level().isClientSide()) {
			pItemStack.consume(1, pPlayer);
			pPlayer.awardStat(Stats.ANIMALS_BRED);
			this.level().broadcastEntityEvent(this, (byte) 18);
			this.setDuration(this.maxDuration);
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
