package com.axanthic.icaria.common.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeHideBootsItem extends ArmorItem {
	public AeternaeHideBootsItem(ArmorMaterial pArmorMaterial, ArmorType pArmorType, Properties pProperties) {
		super(pArmorMaterial, pArmorType, pProperties);
	}

	@Override
	public boolean canWalkOnPowderedSnow(ItemStack pItemStack, LivingEntity pLivingEntity) {
		return true;
	}
}
