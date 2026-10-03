package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.variant.FyshVariant;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFyshVariantIds {
	public static final ResourceKey<FyshVariant> BLUE = IcariaFyshVariantIds.create("blue");
	public static final ResourceKey<FyshVariant> BLUE_PURPLE = IcariaFyshVariantIds.create("blue_purple");
	public static final ResourceKey<FyshVariant> GRAY = IcariaFyshVariantIds.create("gray");
	public static final ResourceKey<FyshVariant> RAINBOW = IcariaFyshVariantIds.create("rainbow");
	public static final ResourceKey<FyshVariant> RED = IcariaFyshVariantIds.create("red");
	public static final ResourceKey<FyshVariant> RED_YELLOW = IcariaFyshVariantIds.create("red_yellow");

	public static ResourceKey<FyshVariant> create(String pName) {
		return ResourceKey.create(IcariaRegistryIds.FYSH_VARIANT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
