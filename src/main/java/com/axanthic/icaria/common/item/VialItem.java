package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VialItem extends Item {
	public VialItem(Properties pProperties) {
		super(pProperties.craftRemainder(IcariaItems.EMPTY_VIAL.get()));
	}
}
