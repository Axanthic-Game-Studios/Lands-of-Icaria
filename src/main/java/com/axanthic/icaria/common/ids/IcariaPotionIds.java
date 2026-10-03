package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.alchemy.Potion;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPotionIds {
	public static final ResourceKey<Potion> BLINDNESS = IcariaPotionIds.create("blindness");
	public static final ResourceKey<Potion> NAUSEA = IcariaPotionIds.create("nausea");
	public static final ResourceKey<Potion> WITHER = IcariaPotionIds.create("wither");

	public static ResourceKey<Potion> create(String pName) {
		return ResourceKey.create(Registries.POTION, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
