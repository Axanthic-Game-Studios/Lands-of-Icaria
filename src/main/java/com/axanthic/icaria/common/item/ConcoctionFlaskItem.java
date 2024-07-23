package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctionFlaskItem extends Item {
	public int duration;

	public Holder<MobEffect> effect;

	public ConcoctionFlaskItem(Properties pProperties, Holder<MobEffect> pEffect, int pDuration) {
		super(pProperties);
		this.duration = pDuration;
		this.effect = pEffect;
	}

	@Override
	public int getUseDuration(ItemStack pStack, LivingEntity pLivingEntity) {
		return 32;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
		pPlayer.startUsingItem(pHand);
		return InteractionResultHolder.consume(pPlayer.getItemInHand(pHand));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
		var effect = new MobEffectInstance(this.effect, this.duration);
		if (pLivingEntity instanceof Player player) {
			player.addEffect(effect);
			player.awardStat(Stats.ITEM_USED.get(this));
			if (player.isCreative()) {
				return pStack;
			}
		}

		return new ItemStack(IcariaItems.EMPTY_FLASK.get());
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.DRINK;
	}
}
