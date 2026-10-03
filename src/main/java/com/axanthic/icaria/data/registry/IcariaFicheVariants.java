package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFicheVariantIds;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.variant.FicheVariant;

import net.minecraft.core.ClientAsset;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFicheVariants {
	public static void bootstrap(BootstrapContext<FicheVariant> pBootstrapContext) {
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariantIds.BLUE_RED, IcariaItems.RAW_BLUE_RED_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariantIds.BROWN_CYAN, IcariaItems.RAW_BROWN_CYAN_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariantIds.GRAY, IcariaItems.RAW_GRAY_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariantIds.GREEN_MAGENTA, IcariaItems.RAW_GREEN_MAGENTA_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariantIds.RED, IcariaItems.RAW_RED_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariantIds.WHITE_YELLOW, IcariaItems.RAW_WHITE_YELLOW_FICHE.get(), 1);
	}

	public static void register(BootstrapContext<FicheVariant> pBootstrapContext, ResourceKey<FicheVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FicheVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity" + "/" + "fiche" + "/" + pVariant.identifier().getPath())), new ItemStackTemplate(pItem, pCount)));
	}
}
