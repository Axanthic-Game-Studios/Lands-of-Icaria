package com.axanthic.icaria.common.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
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
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pInventorySlot, boolean pIsCurrentItem) {
		Player player = (Player)pEntity;
		ItemStack stack = pStack.copy();
		stack.setCount(1);
		if(pStack.getCount() > 1) {
			if(player.addItem(stack)) {
				pStack.shrink(1);
				player.addItem(stack);
			} else {
				pStack.shrink(1);
				player.drop(pStack, true);
			}
		}
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
		Player player = (Player)pEntityLiving;
		player.awardStat(Stats.ITEM_USED.get(this));
		if (!pLevel.isClientSide) {
			player.getCooldowns().addCooldown(this, 400);
			if (!player.isCreative()) {
				pStack.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
			}
		}

		return pStack;
	}
}