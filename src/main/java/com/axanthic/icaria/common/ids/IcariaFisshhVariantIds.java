package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.variant.FisshhVariant;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFisshhVariantIds {
	public static final ResourceKey<FisshhVariant> BLUE_BROWN = IcariaFisshhVariantIds.create("blue_brown");
	public static final ResourceKey<FisshhVariant> BLUE_RED = IcariaFisshhVariantIds.create("blue_red");
	public static final ResourceKey<FisshhVariant> BLUE_YELLOW = IcariaFisshhVariantIds.create("blue_yellow");
	public static final ResourceKey<FisshhVariant> BROWN = IcariaFisshhVariantIds.create("brown");
	public static final ResourceKey<FisshhVariant> GREEN_MAGENTA = IcariaFisshhVariantIds.create("green_magenta");
	public static final ResourceKey<FisshhVariant> PURPLE_YELLOW = IcariaFisshhVariantIds.create("purple_yellow");

	public static ResourceKey<FisshhVariant> create(String pName) {
		return ResourceKey.create(IcariaRegistryIds.FISSHH_VARIANT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
