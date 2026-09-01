package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.variant.FicheVariant;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.ClientAsset;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFicheVariants {
	public static final ResourceKey<FicheVariant> BLUE_RED = IcariaFicheVariants.createKey("blue_red");
	public static final ResourceKey<FicheVariant> BROWN_CYAN = IcariaFicheVariants.createKey("brown_cyan");
	public static final ResourceKey<FicheVariant> GRAY = IcariaFicheVariants.createKey("gray");
	public static final ResourceKey<FicheVariant> GREEN_MAGENTA = IcariaFicheVariants.createKey("green_magenta");
	public static final ResourceKey<FicheVariant> RED = IcariaFicheVariants.createKey("red");
	public static final ResourceKey<FicheVariant> WHITE_YELLOW = IcariaFicheVariants.createKey("white_yellow");

	public static void bootstrap(BootstrapContext<FicheVariant> pBootstrapContext) {
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariants.BLUE_RED, IcariaItems.RAW_BLUE_RED_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariants.BROWN_CYAN, IcariaItems.RAW_BROWN_CYAN_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariants.GRAY, IcariaItems.RAW_GRAY_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariants.GREEN_MAGENTA, IcariaItems.RAW_GREEN_MAGENTA_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariants.RED, IcariaItems.RAW_RED_FICHE.get(), 1);
		IcariaFicheVariants.register(pBootstrapContext, IcariaFicheVariants.WHITE_YELLOW, IcariaItems.RAW_WHITE_YELLOW_FICHE.get(), 1);
	}

	public static void register(BootstrapContext<FicheVariant> pBootstrapContext, ResourceKey<FicheVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FicheVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaKeys.ID, "entity" + "/" + "fiche" + "/" + pVariant.identifier().getPath())), new ItemStack(pItem, pCount)));
	}

	public static ResourceKey<FicheVariant> createKey(String pName) {
		return ResourceKey.create(IcariaRegistries.FICHE_VARIANT, Identifier.fromNamespaceAndPath(IcariaKeys.ID, pName));
	}
}
