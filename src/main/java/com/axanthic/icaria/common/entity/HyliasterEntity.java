package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterEntity extends Monster {
	public float hitboxMult = 0.25F;
	public float renderMult = 0.25F;
	public float shadowMult = 0.15F;

	public int maxSize = 4;
	public int minSize = 1;

	public AnimationState moveAnimationState = new AnimationState();

	public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(HyliasterEntity.class, EntityDataSerializers.INT);

	public HyliasterEntity(EntityType<? extends HyliasterEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean isBaby() {
		return this.getSize() < this.maxSize;
	}

	public boolean isMovement() {
		return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 0;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	public float getSizeForHitbox() {
		return this.getSize() * this.hitboxMult;
	}

	public float getSizeForRender() {
		return this.getSize() * this.renderMult;
	}

	public float getSizeForShadow() {
		return this.getSize() * this.shadowMult;
	}

	public int getSize() {
		return this.getEntityData().get(HyliasterEntity.SIZE);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putInt("Size", this.getSize());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(HyliasterEntity.SIZE, this.minSize);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pEntityDataAccessor) {
		super.onSyncedDataUpdated(pEntityDataAccessor);
		this.refreshDimensions();
	}

	@Override
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.HYLIASTER_SQUISH, 0.1F, 1.0F);
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setSize(pValueInput.getIntOr("Size", 0));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
	}

	@Override
	public void remove(Entity.RemovalReason pRemovalReason) {
		super.remove(pRemovalReason);
		var size = this.getSize();
		if (size > this.minSize) {
			if (this.isDeadOrDying()) {
				if (!this.level().isClientSide()) {
					for (var i = 0; i < size; ++i) {
						var xOffset = ((float) (i % 2) - 0.5F) * 0.05F * size;
						var zOffset = ((float) (i / 2) - 0.5F) * 0.05F * size;
						var entity = IcariaEntityTypes.HYLIASTER.get().create(this.level(), EntitySpawnReason.TRIGGERED);
						if (entity != null) {
							entity.snapTo(this.getX() + xOffset, this.getY() + 0.5D, this.getZ() + zOffset, 0.0F, 0.0F);
							entity.setSize(this.minSize);
							this.level().addFreshEntity(entity);
						}
					}
				}
			}
		}
	}

	public void setSize(int pSize) {
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(pSize);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(pSize * pSize);
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(pSize * 0.05D + 0.1D);
		this.getEntityData().set(HyliasterEntity.SIZE, pSize);
		this.xpReward = pSize;
	}

	public void shrinkOrRemove() {
		if (this.getSize() == this.minSize) {
			this.remove(RemovalReason.KILLED);
		} else {
			this.setSize(this.getSize() - 1);
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.tickMove();
		}
	}

	public void tickMove() {
		if (this.isMovement()) {
			this.moveAnimationState.startIfStopped(this.tickCount);
		} else {
			this.moveAnimationState.stop();
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.3D);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pPose) {
		return this.getType().getDimensions().scale(this.getSizeForHitbox());
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (itemStack.is(IcariaItems.EMPTY_VIAL.get())) {
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.EMPTY_VIAL.get()));
			pPlayer.playSound(IcariaSoundEvents.VIAL_FILL);
			pPlayer.setItemInHand(pInteractionHand, ItemUtils.createFilledResult(itemStack, pPlayer, new ItemStack(IcariaItems.HYLIASTRUM_VIAL.get())));
			this.shrinkOrRemove();
			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(pPlayer, pInteractionHand);
		}
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.HYLIASTER_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.HYLIASTER_HURT;
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setSize(this.getRandom().nextIntBetweenInclusive(this.minSize, this.maxSize));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
