package com.axanthic.landsoficaria.common.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VineSproutItem extends Item {
	public VineSproutItem(Properties properties) {
		super(properties);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		Player player = (Player)entity;

		if (!level.isClientSide) {
			player.getCooldowns().addCooldown(this, 400);
			if (!player.isCreative()) {
				stack.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
			}
		}

		return stack;
	}

	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
		Player player = (Player)entity;
		ItemStack itemStack = stack.copy();

		itemStack.setCount(1);

		if(stack.getCount() > 1) {
			if(player.addItem(itemStack)) {
				stack.shrink(1);
				player.addItem(itemStack);
			} else {
				stack.shrink(1);
				player.drop(stack, true);
			}
		}
	}
}
