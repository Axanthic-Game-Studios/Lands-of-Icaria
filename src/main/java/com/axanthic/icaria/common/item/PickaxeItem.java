package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PickaxeItem extends Item {
	public PickaxeItem(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackSpeed, Properties pProperties) {
		super(pProperties.pickaxe(pToolMaterial, pAttackDamage, pAttackSpeed));
	}
}
