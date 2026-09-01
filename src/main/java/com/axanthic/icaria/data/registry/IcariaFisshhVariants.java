package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.variant.FisshhVariant;

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

public class IcariaFisshhVariants {
	public static final ResourceKey<FisshhVariant> BLUE_BROWN = IcariaFisshhVariants.createKey("blue_brown");
	public static final ResourceKey<FisshhVariant> BLUE_RED = IcariaFisshhVariants.createKey("blue_red");
	public static final ResourceKey<FisshhVariant> BLUE_YELLOW = IcariaFisshhVariants.createKey("blue_yellow");
	public static final ResourceKey<FisshhVariant> BROWN = IcariaFisshhVariants.createKey("brown");
	public static final ResourceKey<FisshhVariant> GREEN_MAGENTA = IcariaFisshhVariants.createKey("green_magenta");
	public static final ResourceKey<FisshhVariant> PURPLE_YELLOW = IcariaFisshhVariants.createKey("purple_yellow");

	public static void bootstrap(BootstrapContext<FisshhVariant> pBootstrapContext) {
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariants.BLUE_BROWN, IcariaItems.RAW_BLUE_BROWN_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariants.BLUE_RED, IcariaItems.RAW_BLUE_RED_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariants.BLUE_YELLOW, IcariaItems.RAW_BLUE_YELLOW_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariants.BROWN, IcariaItems.RAW_BROWN_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariants.GREEN_MAGENTA, IcariaItems.RAW_GREEN_MAGENTA_FISSHH.get(), 1);
		IcariaFisshhVariants.register(pBootstrapContext, IcariaFisshhVariants.PURPLE_YELLOW, IcariaItems.RAW_PURPLE_YELLOW_FISSHH.get(), 1);
	}

	public static void register(BootstrapContext<FisshhVariant> pBootstrapContext, ResourceKey<FisshhVariant> pVariant, Item pItem, int pCount) {
		pBootstrapContext.register(pVariant, new FisshhVariant(new ClientAsset.ResourceTexture(Identifier.fromNamespaceAndPath(IcariaKeys.ID, "entity" + "/" + "fisshh" + "/" + pVariant.identifier().getPath())), new ItemStack(pItem, pCount)));
	}

	public static ResourceKey<FisshhVariant> createKey(String pName) {
		return ResourceKey.create(IcariaRegistries.FISSHH_VARIANT, Identifier.fromNamespaceAndPath(IcariaKeys.ID, pName));
	}
}
