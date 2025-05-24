package com.axanthic.icaria.common.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArmorItem extends Item {
	public boolean walkablePowderedSnow;

	public IcariaArmorItem(ArmorMaterial pArmorMaterial, ArmorType pArmorType, boolean pWalkablePowderedSnow, int pDurabilityMultiplier, Properties pProperties) {
		super(pProperties.durability(pArmorType.getDurability(pDurabilityMultiplier)).humanoidArmor(pArmorMaterial, pArmorType));
		this.walkablePowderedSnow = pWalkablePowderedSnow;
	}

	public IcariaArmorItem(ArmorMaterial pArmorMaterial, ArmorType pArmorType, boolean pWalkablePowderedSnow, Properties pProperties) {
		super(pProperties.humanoidArmor(pArmorMaterial, pArmorType));
		this.walkablePowderedSnow = pWalkablePowderedSnow;
	}

	@Override
	public boolean canWalkOnPowderedSnow(ItemStack pItemStack, LivingEntity pLivingEntity) {
		return this.walkablePowderedSnow;
	}
}
