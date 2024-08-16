package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.ArachneHurtByTargetGoal;
import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneEntity extends IcariaArachnidEntity {
	public AnimationState attackAnimationState = new AnimationState();

	public ArachneEntity(EntityType<? extends ArachneEntity> pType, Level pLevel) {
		super(pType, pLevel);
		this.xpReward = 10;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance pEffectInstance) {
		return super.canBeAffected(pEffectInstance) && !pEffectInstance.is(MobEffects.POISON);
	}

	@Override
	public boolean doHurtTarget(Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		return super.doHurtTarget(pEntity);
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return false;
	}

	@Override
	public void handleEntityEvent(byte pId) {
		if (pId == 4) {
			this.attackAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(pId);
		}
	}

	@Override
	public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
		if (!pState.is(IcariaBlockTags.ICARIA_COBWEB_BLOCKS)) {
			super.makeStuckInBlock(pState, pMotionMultiplier);
		}
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(SoundEvents.SPIDER_STEP, 0.1F, 1.0F);
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new ArachneHurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new IcariaArachnidTargetGoal<>(this, Player.class, true, true));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.FOLLOW_RANGE, 64.0D).add(Attributes.MAX_HEALTH, 128.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
		var itemStack = pPlayer.getItemInHand(pHand);
		if (this.getType() == IcariaEntityTypes.ARACHNE.get()) {
			if (itemStack.is(IcariaItems.EMPTY_VIAL.get())) {
				var filledResult = ItemUtils.createFilledResult(itemStack, pPlayer, IcariaItems.ARACHNE_VENOM_VIAL.get().getDefaultInstance());
				this.setTarget(pPlayer);
				pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.EMPTY_VIAL.get()));
				pPlayer.playSound(SoundEvents.BOTTLE_FILL);
				pPlayer.setItemInHand(pHand, filledResult);
				return InteractionResult.sidedSuccess(this.level().isClientSide());
			}
		}

		return super.mobInteract(pPlayer, pHand);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return SoundEvents.SPIDER_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.SPIDER_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return SoundEvents.SPIDER_HURT;
	}
}
