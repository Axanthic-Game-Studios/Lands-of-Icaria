package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFyshVariantIds;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.variant.FyshVariant;

import net.minecraft.core.ClientAsset;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFyshVariants {
	public static void bootstrap(BootstrapContext<FyshVariant> pBootstrapContext) {
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariantIds.BLUE, IcariaItems.RAW_BLUE_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariantIds.BLUE_PURPLE, IcariaItems.RAW_BLUE_PURPLE_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariantIds.GRAY, IcariaItems.RAW_GRAY_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariantIds.RAINBOW, IcariaItems.RAW_RAINBOW_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariantIds.RED, IcariaItems.RAW_RED_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariantIds.RED_YELLOW, IcariaItems.RAW_RED_YELLOW_FYSH.get(), 1);
	}

	public static void register(BootstrapContext<FyshVariant> pBootstrapContext, ResourceKey<FyshVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FyshVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity" + "/" + "fysh" + "/" + pVariant.identifier().getPath())), new ItemStackTemplate(pItem, pCount)));
	}
}
