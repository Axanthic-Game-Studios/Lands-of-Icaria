package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RevenantEntity extends Monster {
	public RevenantEntity(EntityType<? extends RevenantEntity> pType, Level pLevel) {
		super(pType, pLevel);
		this.xpReward = 10;
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(IcariaSoundEvents.REVENANT_STEP, 0.1F, 1.0F);
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new MoveTowardsRestrictionGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.REVENANT_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.REVENANT_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.REVENANT_HURT;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
		var randomSource = pLevel.getRandom();
		this.populateDefaultEquipmentEnchantments(pLevel, randomSource, pDifficulty);
		this.populateDefaultEquipmentSlots(randomSource, pDifficulty);
		this.setCanPickUpLoot(true);
		return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
	}
}
