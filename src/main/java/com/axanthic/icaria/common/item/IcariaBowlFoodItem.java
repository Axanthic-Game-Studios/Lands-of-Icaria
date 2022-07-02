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
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
		ItemStack stack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
		return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? stack : new ItemStack(IcariaItems.LOAM_BOWL.get());
	}
}
