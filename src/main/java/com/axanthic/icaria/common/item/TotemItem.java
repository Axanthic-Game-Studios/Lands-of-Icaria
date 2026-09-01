package com.axanthic.icaria.common.item;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemItem extends Item {
	public TotemItem(TagKey<Item> pTagKey, Properties pProperties) {
		super(pProperties.repairable(pTagKey));
	}
}
