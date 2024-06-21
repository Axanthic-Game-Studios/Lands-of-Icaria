package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBowlFoodItem extends Item {
	public IcariaBowlFoodItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public int getUseDuration(ItemStack pStack) {
		return 2;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
		if (pLivingEntity instanceof Player player) {
			player.eat(pLevel, pStack);
			if (player.isCreative()) {
				return pStack;
			}
		}

		return new ItemStack(IcariaItems.LOAM_BOWL.get());
	}
}
