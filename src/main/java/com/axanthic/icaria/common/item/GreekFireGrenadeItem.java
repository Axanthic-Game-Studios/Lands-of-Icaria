package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.GreekFireGrenadeEntity;
import com.axanthic.icaria.common.util.IcariaTier;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeItem extends TieredItem implements Vanishable {
    public GreekFireGrenadeItem(IcariaTier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        if (pLivingEntity instanceof Player player) {
            int i = this.getUseDuration(pStack) - pTimeCharged;
            if (i >= 10) {
                if (!pLevel.isClientSide) {
                    GreekFireGrenadeEntity greekFireGrenadeEntity = new GreekFireGrenadeEntity(pLevel, player, pStack);
                    greekFireGrenadeEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F, 1.0F);
                    pLevel.addFreshEntity(greekFireGrenadeEntity);
                    pLevel.playSound(null, greekFireGrenadeEntity, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);
                    if (!player.isCreative()) {
                        pStack.shrink(1);
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }
}
