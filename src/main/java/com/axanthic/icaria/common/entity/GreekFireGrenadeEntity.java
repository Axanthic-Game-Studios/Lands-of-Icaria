package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.IcariaPortalBlock;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeEntity extends AbstractArrow {
    public ItemStack stack = new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get());

    public GreekFireGrenadeEntity(EntityType<? extends GreekFireGrenadeEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public GreekFireGrenadeEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
        super(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), pEntity, pLevel);
        this.stack = pStack.copy();
    }

    @Override
    public void onHit(HitResult pResult) {
        var thisPos = BlockPos.containing(this.getX(), this.getY(), this.getZ());
        if (((IcariaPortalBlock) IcariaBlocks.ICARIA_PORTAL.get()).spawnPortal(this.level(), thisPos)) {
            this.discard();
            return;
        }

        if (!this.level().isClientSide) {
            this.level().explode(null, this.getX(), this.getY(), this.getZ(), 1.5F, false, Level.ExplosionInteraction.NONE);
            this.discard();
            for (int i = -2; i <= 2; i++) {
                var negPos = BlockPos.containing(this.getX() - i, this.getY() - i, this.getZ() - i);
                var posPos = BlockPos.containing(this.getX() + i, this.getY() + i, this.getZ() + i);
                for (BlockPos blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                    if (this.random.nextInt(10) == 0) {
                        if (this.level().getBlockState(blockPos).isAir()) {
                            if (this.level().getBlockState(blockPos.below()).isSolidRender(this.level(), blockPos.below())) {
                                this.level().setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                            }
                        }
                    }
                }
            }
        }
    }

    public ItemStack getItem() {
        return this.stack;
    }

    @Override
    public ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.GENERIC_EXPLODE;
    }
}
