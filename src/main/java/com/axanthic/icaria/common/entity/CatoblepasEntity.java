package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaPanicGoal;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasEntity extends Animal {
    public CatoblepasEntity(EntityType<? extends Animal> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(IcariaItems.SPELT.get());
    }

    @Override
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return this.isBaby() ? 0.6F : 1.2F;
    }

    @Override
    public float getVoicePitch() {
        return this.isBaby() ? 1.25F : 0.75F;
    }

    @Override
    public void dropCustomDeathLoot(DamageSource pDamageSource, int i, boolean b) {
        super.dropCustomDeathLoot(pDamageSource, i, b);
        if (pDamageSource.getEntity() instanceof Creeper creeper) {
            if (creeper.isPowered() && creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(IcariaItems.CATOBLEPAS_SKULL.get());
            }
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
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, Ingredient.of(IcariaItems.SPELT.get()), true));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new CatoblepasHurtByOtherGoal(this, 1.5D)).setAlertOthers());
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.is(Items.BUCKET) && !this.isBaby()) {
            ItemStack filledResult = ItemUtils.createFilledResult(itemStack, pPlayer, Items.MILK_BUCKET.getDefaultInstance());
            pPlayer.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            pPlayer.setItemInHand(pHand, filledResult);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
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

    @Override
    public CatoblepasEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pMob) {
        return IcariaEntities.CATOBLEPAS.get().create(pLevel);
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
