package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.variant.FyshVariant;

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

public class IcariaFyshVariants {
	public static final ResourceKey<FyshVariant> BLUE = IcariaFyshVariants.createKey("blue");
	public static final ResourceKey<FyshVariant> BLUE_PURPLE = IcariaFyshVariants.createKey("blue_purple");
	public static final ResourceKey<FyshVariant> GRAY = IcariaFyshVariants.createKey("gray");
	public static final ResourceKey<FyshVariant> RAINBOW = IcariaFyshVariants.createKey("rainbow");
	public static final ResourceKey<FyshVariant> RED = IcariaFyshVariants.createKey("red");
	public static final ResourceKey<FyshVariant> RED_YELLOW = IcariaFyshVariants.createKey("red_yellow");

	public static void bootstrap(BootstrapContext<FyshVariant> pBootstrapContext) {
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariants.BLUE, IcariaItems.RAW_BLUE_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariants.BLUE_PURPLE, IcariaItems.RAW_BLUE_PURPLE_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariants.GRAY, IcariaItems.RAW_GRAY_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariants.RAINBOW, IcariaItems.RAW_RAINBOW_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariants.RED, IcariaItems.RAW_RED_FYSH.get(), 1);
		IcariaFyshVariants.register(pBootstrapContext, IcariaFyshVariants.RED_YELLOW, IcariaItems.RAW_RED_YELLOW_FYSH.get(), 1);
	}

	public static void register(BootstrapContext<FyshVariant> pBootstrapContext, ResourceKey<FyshVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FyshVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaKeys.ID, "entity" + "/" + "fysh" + "/" + pVariant.identifier().getPath())), new ItemStack(pItem, pCount)));
	}

	public static ResourceKey<FyshVariant> createKey(String pName) {
		return ResourceKey.create(IcariaRegistries.FYSH_VARIANT, Identifier.fromNamespaceAndPath(IcariaKeys.ID, pName));
	}
}
