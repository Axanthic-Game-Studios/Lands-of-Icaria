package com.axanthic.icaria.common.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault

public class VineSproutItem extends Item {
	public VineSproutItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean isEnchantable(ItemStack pStack) {
		return false;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
		var stack = new ItemStack(this);
		if (pLivingEntity instanceof Player player) {
			player.eat(pLevel, stack);
			if (!pLevel.isClientSide()) {
				player.getCooldowns().addCooldown(this, 400);
				if (!player.isCreative()) {
					pStack.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
				}
			}
		}

		return pStack;
	}
}
