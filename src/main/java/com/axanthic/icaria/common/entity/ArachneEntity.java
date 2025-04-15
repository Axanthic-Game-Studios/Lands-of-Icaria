package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.ArachneHurtByTargetGoal;
import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneEntity extends IcariaArachnidEntity {
	public AnimationState attackAnimationState = new AnimationState();

	public ArachneEntity(EntityType<? extends ArachneEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean doHurtTarget(ServerLevel pServerLevel, Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		return super.doHurtTarget(pServerLevel, pEntity);
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
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.ARACHNE_STEP, 0.1F, 1.0F);
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
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.FOLLOW_RANGE, 64.0D).add(Attributes.MAX_HEALTH, 128.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (itemStack.is(IcariaItems.EMPTY_VIAL.get())) {
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.EMPTY_VIAL.get()));
			pPlayer.playSound(IcariaSoundEvents.VIAL_FILL);
			pPlayer.setItemInHand(pInteractionHand, ItemUtils.createFilledResult(itemStack, pPlayer, new ItemStack(IcariaItems.ARACHNE_VENOM_VIAL.get())));
			this.setTarget(pPlayer);
			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(pPlayer, pInteractionHand);
		}
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.ARACHNE_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.ARACHNE_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.ARACHNE_HURT;
	}
}
