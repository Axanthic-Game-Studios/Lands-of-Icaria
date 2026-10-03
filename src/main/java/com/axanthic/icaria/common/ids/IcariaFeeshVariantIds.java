package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.variant.FeeshVariant;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFeeshVariantIds {
	public static final ResourceKey<FeeshVariant> BLUE_GRAY = IcariaFeeshVariantIds.create("blue_gray");
	public static final ResourceKey<FeeshVariant> BROWN = IcariaFeeshVariantIds.create("brown");
	public static final ResourceKey<FeeshVariant> BROWN_ORANGE = IcariaFeeshVariantIds.create("brown_orange");
	public static final ResourceKey<FeeshVariant> PINK_RED = IcariaFeeshVariantIds.create("pink_red");
	public static final ResourceKey<FeeshVariant> PURPLE = IcariaFeeshVariantIds.create("purple");
	public static final ResourceKey<FeeshVariant> RED = IcariaFeeshVariantIds.create("red");

	public static ResourceKey<FeeshVariant> create(String pName) {
		return ResourceKey.create(IcariaRegistryIds.FEESH_VARIANT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
