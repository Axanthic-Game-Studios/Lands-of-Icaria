package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFeeshVariantIds;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.variant.FeeshVariant;

import net.minecraft.core.ClientAsset;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFeeshVariants {
	public static void bootstrap(BootstrapContext<FeeshVariant> pBootstrapContext) {
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariantIds.BLUE_GRAY, IcariaItems.RAW_BLUE_GRAY_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariantIds.BROWN, IcariaItems.RAW_BROWN_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariantIds.BROWN_ORANGE, IcariaItems.RAW_BROWN_ORANGE_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariantIds.PINK_RED, IcariaItems.RAW_PINK_RED_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariantIds.PURPLE, IcariaItems.RAW_PURPLE_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariantIds.RED, IcariaItems.RAW_RED_FEESH.get(), 1);
	}

	public static void register(BootstrapContext<FeeshVariant> pBootstrapContext, ResourceKey<FeeshVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FeeshVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity" + "/" + "feesh" + "/" + pVariant.identifier().getPath())), new ItemStackTemplate(pItem, pCount)));
	}
}
