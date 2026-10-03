package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SwordItem extends Item {
	public SwordItem(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackSpeed, Properties pProperties) {
		super(pProperties.sword(pToolMaterial, pAttackDamage, pAttackSpeed));
	}
}
