package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FlaskItem extends Item {
	public FlaskItem(Properties pProperties) {
		super(pProperties.craftRemainder(IcariaItems.EMPTY_FLASK.get()).usingConvertsTo(IcariaItems.EMPTY_FLASK.get()));
	}
}
