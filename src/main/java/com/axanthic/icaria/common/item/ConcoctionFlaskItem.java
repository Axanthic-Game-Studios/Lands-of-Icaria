package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctionFlaskItem extends Item {
	public ConcoctionFlaskItem(Properties pProperties) {
		super(pProperties.usingConvertsTo(IcariaItems.EMPTY_FLASK.get()));
	}
}
