package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.variant.FeeshVariant;

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

public class IcariaFeeshVariants {
	public static final ResourceKey<FeeshVariant> BLUE_GRAY = IcariaFeeshVariants.createKey("blue_gray");
	public static final ResourceKey<FeeshVariant> BROWN = IcariaFeeshVariants.createKey("brown");
	public static final ResourceKey<FeeshVariant> BROWN_ORANGE = IcariaFeeshVariants.createKey("brown_orange");
	public static final ResourceKey<FeeshVariant> PINK_RED = IcariaFeeshVariants.createKey("pink_red");
	public static final ResourceKey<FeeshVariant> PURPLE = IcariaFeeshVariants.createKey("purple");
	public static final ResourceKey<FeeshVariant> RED = IcariaFeeshVariants.createKey("red");

	public static void bootstrap(BootstrapContext<FeeshVariant> pBootstrapContext) {
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariants.BLUE_GRAY, IcariaItems.RAW_BLUE_GRAY_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariants.BROWN, IcariaItems.RAW_BROWN_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariants.BROWN_ORANGE, IcariaItems.RAW_BROWN_ORANGE_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariants.PINK_RED, IcariaItems.RAW_PINK_RED_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariants.PURPLE, IcariaItems.RAW_PURPLE_FEESH.get(), 1);
		IcariaFeeshVariants.register(pBootstrapContext, IcariaFeeshVariants.RED, IcariaItems.RAW_RED_FEESH.get(), 1);
	}

	public static void register(BootstrapContext<FeeshVariant> pBootstrapContext, ResourceKey<FeeshVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FeeshVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaKeys.ID, "entity" + "/" + "feesh" + "/" + pVariant.identifier().getPath())), new ItemStack(pItem, pCount)));
	}

	public static ResourceKey<FeeshVariant> createKey(String pName) {
		return ResourceKey.create(IcariaRegistries.FEESH_VARIANT, Identifier.fromNamespaceAndPath(IcariaKeys.ID, pName));
	}
}
