package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.GreekFireGrenadeEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeItem extends Item {
	public GreekFireGrenadeItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public int getUseDuration(ItemStack pStack, LivingEntity pLivingEntity) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
		if (pLivingEntity instanceof Player player && this.getUseDuration(pStack, pLivingEntity) - pTimeCharged >= 10) {
			player.playSound(SoundEvents.ARROW_SHOOT);
			if (!pLevel.isClientSide()) {
				var entity = new GreekFireGrenadeEntity(pLevel, player, pStack);
				entity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F, 1.0F);
				player.awardStat(Stats.ITEM_USED.get(this));
				pLevel.addFreshEntity(entity);
				if (!player.isCreative()) {
					pStack.shrink(1);
				}
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
