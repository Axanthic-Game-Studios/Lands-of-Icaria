package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFisshhVariantIds;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.variant.FisshhVariant;

import net.minecraft.core.ClientAsset;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFisshhVariants {
	public static void bootstrap(BootstrapContext<FisshhVariant> pBootstrapContext) {
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariantIds.BLUE_BROWN, IcariaItems.RAW_BLUE_BROWN_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariantIds.BLUE_RED, IcariaItems.RAW_BLUE_RED_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariantIds.BLUE_YELLOW, IcariaItems.RAW_BLUE_YELLOW_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariantIds.BROWN, IcariaItems.RAW_BROWN_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariantIds.GREEN_MAGENTA, IcariaItems.RAW_GREEN_MAGENTA_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariantIds.PURPLE_YELLOW, IcariaItems.RAW_PURPLE_YELLOW_FISSHH.get(), 1);
	}

	public static void register(BootstrapContext<FisshhVariant> pBootstrapContext, ResourceKey<FisshhVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FisshhVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity" + "/" + "fisshh" + "/" + pVariant.identifier().getPath())), new ItemStackTemplate(pItem, pCount)));
	}
}
