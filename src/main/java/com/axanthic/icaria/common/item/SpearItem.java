package com.axanthic.icaria.common.item;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpearItem extends Item {
	public SpearItem(ToolMaterial pToolMaterial, float pSwingDuration, float pDamageMultiplier, float pDelay, float pDismountMaxDuration, float pDismountMinSpeed, float pKnockbackMaxDuration, float pKnockbackMinSpeed, float pDamageMaxDuration, float pDamageMinSpeed, Properties pProperties) {
		super(pProperties.spear(pToolMaterial, pSwingDuration, pDamageMultiplier, pDelay, pDismountMaxDuration, pDismountMinSpeed, pKnockbackMaxDuration, pKnockbackMinSpeed, pDamageMaxDuration, pDamageMinSpeed));
	}
}
