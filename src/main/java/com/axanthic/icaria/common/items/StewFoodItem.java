package com.axanthic.icaria.common.items;

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

public class StewFoodItem extends Item {
	public StewFoodItem(Properties pProperties) {
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
