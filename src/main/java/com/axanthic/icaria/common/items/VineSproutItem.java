package com.axanthic.icaria.common.items;

import net.minecraft.MethodsReturnNonnullByDefault;
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
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
		Player player = (Player)pEntityLiving;
		if (!pLevel.isClientSide) {
			player.getCooldowns().addCooldown(this, 400);
			if (!player.isCreative()) {
				pStack.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
			}
		}

		return pStack;
	}

	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pInventorySlot, boolean pIsCurrentItem) {
		Player player = (Player)pEntity;
		ItemStack itemStack = pStack.copy();
		itemStack.setCount(1);
		if(pStack.getCount() > 1) {
			if(player.addItem(itemStack)) {
				pStack.shrink(1);
				player.addItem(itemStack);
			} else {
				pStack.shrink(1);
				player.drop(pStack, true);
			}
		}
	}
}
