package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.variant.FicheVariant;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFicheVariantIds {
	public static final ResourceKey<FicheVariant> BLUE_RED = IcariaFicheVariantIds.create("blue_red");
	public static final ResourceKey<FicheVariant> BROWN_CYAN = IcariaFicheVariantIds.create("brown_cyan");
	public static final ResourceKey<FicheVariant> GRAY = IcariaFicheVariantIds.create("gray");
	public static final ResourceKey<FicheVariant> GREEN_MAGENTA = IcariaFicheVariantIds.create("green_magenta");
	public static final ResourceKey<FicheVariant> RED = IcariaFicheVariantIds.create("red");
	public static final ResourceKey<FicheVariant> WHITE_YELLOW = IcariaFicheVariantIds.create("white_yellow");

	public static ResourceKey<FicheVariant> create(String pName) {
		return ResourceKey.create(IcariaRegistryIds.FICHE_VARIANT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
