package com.axanthic.icaria.common.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GearItem extends Item {
	public GearItem(TagKey<Item> pTagKey, Properties pProperties) {
		super(pProperties.repairable(pTagKey));
	}
}
