package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LoamBowlItem extends Item {
	public LoamBowlItem(Properties pProperties) {
		super(pProperties.craftRemainder(IcariaItems.LOAM_BOWL.get()).usingConvertsTo(IcariaItems.LOAM_BOWL.get()));
	}
}
