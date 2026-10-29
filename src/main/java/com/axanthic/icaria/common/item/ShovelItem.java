package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ShovelItem extends Item {
	public ShovelItem(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackSpeed, Properties pProperties) {
		super(pProperties.shovel(pToolMaterial, pAttackDamage, pAttackSpeed));
	}
}
