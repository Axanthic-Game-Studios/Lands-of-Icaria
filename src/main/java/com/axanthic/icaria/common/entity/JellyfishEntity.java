package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.JellyfishFleeGoal;
import com.axanthic.icaria.common.goal.JellyfishRandomMovementGoal;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.registry.IcariaValues;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("deprecation, unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public abstract class JellyfishEntity extends IcariaPathfinderMobEntity {
	public float tentacleAngle;
	public float tentacleAngleOld;
	public float tentacleMovement;
	public float tentacleMovementOld;
	public float xBodyRot;
	public float xBodyRotOld;
	public float zBodyRot;
	public float zBodyRotOld;

	public Vec3 movementVector;

	public JellyfishEntity(EntityType<? extends JellyfishEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel, 0.25F, 0.25F, 0.15F);
		this.setMovementVector();
		this.setSeed();
	}

	public static boolean checkMobSpawnRules(EntityType<? extends Mob> pEntityType, LevelAccessor pLevelAccessor, EntitySpawnReason pEntitySpawnReason, BlockPos pBlockPos, RandomSource pRandomSource) {
		return true;
	}

	@Override
	public void aiStep() {
		super.aiStep();

		var vec3 = this.getDeltaMovement();

		this.tentacleAngleOld = this.tentacleAngle;
		this.tentacleMovementOld = this.tentacleMovement;
		this.xBodyRotOld = this.xBodyRot;
		this.zBodyRotOld = this.zBodyRot;

		this.setDeltaMovement();
		this.setTentacleAngle();
		this.setTentacleMovement();
		this.setXBodyRot(vec3);
		this.setXRot(this.xBodyRot);
		this.setYBodyRot(vec3);
		this.setYRot(this.yBodyRot);
		this.setZBodyRot();
	}

	@Override
	public void playerTouch(Player pPlayer) {
		IcariaCommonHelper.hurt(this.damageSources().mobAttack(this), pPlayer, this.getSize());
		if (!pPlayer.isCreative()) {
			this.touch(pPlayer);
		}
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new JellyfishRandomMovementGoal(this));
		this.goalSelector.addGoal(2, new JellyfishFleeGoal(this));
	}

	public void setDeltaMovement() {
		if (this.tentacleMovement < Mth.PI) {
			this.setDeltaMovement(0.5D);
		} else {
			this.setDeltaMovement(1.0F);
		}
	}

	public void setDeltaMovement(double pScale) {
		if (this.isLocalInstanceAuthoritative()) {
			this.setDeltaMovement(this.movementVector.scale(pScale));
		}
	}

	public void setMovementVector() {
		this.movementVector = new Vec3(0.0D, 0.0D, 0.0D);
	}

	public void setSeed() {
		this.getRandom().fork().setSeed(this.getId());
	}

	@Override
	public void setSize(int pSize) {
		super.setSize(pSize);
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(pSize);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(pSize * pSize);
	}

	public void setTentacleAngle() {
		this.tentacleAngle = Mth.sin(this.tentacleMovement) * 0.5F;
	}

	public void setTentacleMovement() {
		if (this.tentacleMovement > Mth.PI * 2.0F) {
			this.tentacleMovement = 0.0F;
		} else {
			this.tentacleMovement = 0.1F + this.tentacleMovement;
		}
	}

	public void setXBodyRot(Vec3 pVec3) {
		this.xBodyRot += (float) (Mth.atan2(pVec3.horizontalDistance(), pVec3.y) / -IcariaValues.DEG_2_RAD - this.xBodyRot) * 0.1F;
	}

	public void setYBodyRot(Vec3 pVec3) {
		this.yBodyRot += (float) (Mth.atan2(pVec3.x, pVec3.z) / -IcariaValues.DEG_2_RAD - this.yBodyRot) * 0.1F;
	}

	public void setZBodyRot() {
		if (this.tentacleMovement < Mth.PI) {
			this.setZBodyRot(2.5F);
		} else {
			this.setZBodyRot(5.0F);
		}
	}

	public void setZBodyRot(float pRot) {
		this.zBodyRot += pRot;
	}

	@Override
	public void travel(Vec3 pVec3) {
		if (this.isLocalInstanceAuthoritative()) {
			this.move(MoverType.SELF, this.getDeltaMovement());
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.FLYING_SPEED, 0.4F).add(Attributes.GRAVITY, 0.0F).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
	}

	@Override
	public Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.EVENTS;
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new FlyingPathNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.JELLYFISH_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.JELLYFISH_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.JELLYFISH_HURT;
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setSize(this.getRandom().nextIntBetweenInclusive(this.minSize, this.maxSize));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}

	public abstract void touch(Player pPlayer);
}
