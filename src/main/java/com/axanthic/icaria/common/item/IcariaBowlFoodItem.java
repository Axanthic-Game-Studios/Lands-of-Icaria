package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBowlFoodItem extends Item {
	public IcariaBowlFoodItem(Properties pProperties) {
		super(pProperties.usingConvertsTo(IcariaItems.LOAM_BOWL.get()));
	}
}
