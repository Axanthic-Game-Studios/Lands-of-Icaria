package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaBreedGoal;
import com.axanthic.icaria.common.goal.IcariaFollowParentGoal;
import com.axanthic.icaria.common.goal.IcariaPanicGoal;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasEntity extends IcariaAnimalEntity {
    public AnimationState attackAnimationState = new AnimationState();

    public CatoblepasEntity(EntityType<? extends IcariaAnimalEntity> pType, Level pLevel) {
        super(pType, pLevel, 0.25F, 0.3F, 0.25F);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        this.level.broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(pEntity);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(IcariaItems.SPELT.get());
    }

    @Override
    public void dropCustomDeathLoot(DamageSource pDamageSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pDamageSource, pLooting, pRecentlyHit);
        if (!this.isBaby()) {
            if (pDamageSource.getEntity() instanceof Creeper creeper) {
                if (creeper.isPowered()) {
                    if (creeper.canDropMobsSkull()) {
                        creeper.increaseDroppedSkulls();
                        this.spawnAtLocation(IcariaItems.CATOBLEPAS_SKULL.get());
                    }
                }
            }
        }
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
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.COW_STEP, 0.1F, 1.0F);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new IcariaPanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new IcariaBreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, Ingredient.of(IcariaItems.SPELT.get()), true));
        this.goalSelector.addGoal(6, new IcariaFollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new CatoblepasHurtByOtherGoal(this, 1.5D)).setAlertOthers());
    }

    @Override
    public void setSize(int pSize) {
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(size);
        Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_KNOCKBACK)).setBaseValue(size * 0.5D);
        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(size * size);
        super.setSize(pSize);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.ATTACK_KNOCKBACK, 2.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public CatoblepasEntity getBreedOffspring(ServerLevel pLevel, IcariaAnimalEntity pEntity) {
        return IcariaEntities.CATOBLEPAS.get().create(pLevel);
    }

    @Override
    public @Nonnull InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (!this.isBaby()) {
            if (itemStack.is(Items.BUCKET)) {
                ItemStack filledResult = ItemUtils.createFilledResult(itemStack, pPlayer, Items.MILK_BUCKET.getDefaultInstance());
                pPlayer.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
                pPlayer.setItemInHand(pHand, filledResult);
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }
        }

        return super.mobInteract(pPlayer, pHand);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.COW_HURT;
    }

    public static class CatoblepasHurtByOtherGoal extends HurtByTargetGoal {
        public double speedModifier;

        CatoblepasHurtByOtherGoal(CatoblepasEntity pMob, double pSpeedModifier) {
            super(pMob);
            this.speedModifier = pSpeedModifier;
        }

        @Override
        public void alertOther(Mob pMob, LivingEntity pEntity) {
            if (pMob instanceof CatoblepasEntity) {
                double randomSource = RandomSource.create().nextInt(8, 16);
                pMob.getNavigation().moveTo(pEntity.getX() + randomSource, 0.0D, pEntity.getX() + randomSource, speedModifier);
            }
        }
    }
}