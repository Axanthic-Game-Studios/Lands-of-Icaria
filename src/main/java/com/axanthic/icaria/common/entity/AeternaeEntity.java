package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.*;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeEntity extends IcariaAnimalEntity {
	public int eatAnimationTick;

	public AnimationState attackAnimationState = new AnimationState();
	public AnimationState eatingAnimationState = new AnimationState();

	public IcariaEatBlockGoal eatBlockGoal;

	public AeternaeEntity(EntityType<? extends AeternaeEntity> pType, Level pLevel) {
		super(pType, pLevel, 0.25F, 0.25F, 0.15F, 0.75F, 0.25F);
	}

	@Override
	public boolean doHurtTarget(Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		return super.doHurtTarget(pEntity);
	}

	@Override
	public boolean isFood(ItemStack pStack) {
		return pStack.is(IcariaItems.SPELT.get());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.level().isClientSide()) {
			this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
		}
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
	}

	@Override
	public void handleEntityEvent(byte pId) {
		if (pId == 4) {
			this.attackAnimationState.start(this.tickCount);
		} else if (pId == 10) {
			this.eatAnimationTick = 40;
			this.eatingAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(pId);
		}
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(IcariaSoundEvents.AETERNAE_STEP, 0.1F, 1.0F);
	}

	@Override
	public void registerGoals() {
		this.eatBlockGoal = new IcariaEatBlockGoal(this);
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new IcariaPanicGoal(this, 1.5D));
		this.goalSelector.addGoal(3, new IcariaBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, Ingredient.of(IcariaItems.SPELT.get()), false));
		this.goalSelector.addGoal(6, new IcariaFollowParentGoal(this, 1.0D));
		this.goalSelector.addGoal(7, this.eatBlockGoal);
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new IcariaAnimalHurtByTargetGoal(this, 1.5D).setAlertOthers());
	}

	@Override
	public void setSize(int pSize) {
		super.setSize(pSize);
		int size = Mth.clamp(pSize, this.minSize, this.maxSize);
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(size);
		this.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(size * 0.5D);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.ATTACK_KNOCKBACK, 2.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public AeternaeEntity getBreedOffspring(ServerLevel pLevel, IcariaAnimalEntity pEntity) {
		return IcariaEntityTypes.AETERNAE.get().create(pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.AETERNAE_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.AETERNAE_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.AETERNAE_HURT;
	}
}
