package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemItem extends Item {
	public TotemItem(Properties pProperties) {
		super(pProperties.repairable(IcariaItems.BLURIDIUM_NUGGET.get()));
	}
}
