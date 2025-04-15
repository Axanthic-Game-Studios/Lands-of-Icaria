package com.axanthic.icaria.common.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault

public class VineSproutItem extends Item {
	public VineSproutItem(Properties pProperties) {
		super(pProperties);
	}

	public void handleAction(ItemStack pItemStack, Level pLevel, LivingEntity pLivingEntity) {
		var type = pItemStack.get(DataComponents.FOOD);
		if (type != null) {
			var food = new FoodProperties(type.nutrition(), type.saturation(), type.canAlwaysEat());
			if (pLivingEntity instanceof Player player) {
				player.getFoodData().eat(food);
				if (!pLevel.isClientSide()) {
					player.getCooldowns().addCooldown(pItemStack, 400);
					pItemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
				}
			}
		}
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pItemStack, Level pLevel, LivingEntity pLivingEntity) {
		this.handleAction(pItemStack, pLevel, pLivingEntity);
		return pItemStack;
	}

	@Override
	public SoundEvent getBreakingSound() {
		return SoundEvents.EMPTY;
	}
}
