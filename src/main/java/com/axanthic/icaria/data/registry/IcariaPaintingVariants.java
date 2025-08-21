package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdents;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariants {
	public static final ResourceKey<PaintingVariant> BRIDGE = IcariaPaintingVariants.createKey("bridge");
	public static final ResourceKey<PaintingVariant> CACTUS = IcariaPaintingVariants.createKey("cactus");
	public static final ResourceKey<PaintingVariant> ENDER_JELLYFISH = IcariaPaintingVariants.createKey("ender_jellyfish");
	public static final ResourceKey<PaintingVariant> MOONS = IcariaPaintingVariants.createKey("moons");
	public static final ResourceKey<PaintingVariant> PERFECTION = IcariaPaintingVariants.createKey("perfection");
	public static final ResourceKey<PaintingVariant> PORTAL = IcariaPaintingVariants.createKey("portal");
	public static final ResourceKey<PaintingVariant> PYRO = IcariaPaintingVariants.createKey("pyro");
	public static final ResourceKey<PaintingVariant> WINDOW = IcariaPaintingVariants.createKey("window");

	public static final ResourceKey<PaintingVariant> BROWN_RUG_1_X_2 = IcariaPaintingVariants.createKey("brown_rug_1_x_2");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_1_X_3 = IcariaPaintingVariants.createKey("brown_rug_1_x_3");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_1_X_4 = IcariaPaintingVariants.createKey("brown_rug_1_x_4");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_2_X_2 = IcariaPaintingVariants.createKey("brown_rug_2_x_2");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_2_X_3 = IcariaPaintingVariants.createKey("brown_rug_2_x_3");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_2_X_4 = IcariaPaintingVariants.createKey("brown_rug_2_x_4");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_3_X_3 = IcariaPaintingVariants.createKey("brown_rug_3_x_3");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_3_X_4 = IcariaPaintingVariants.createKey("brown_rug_3_x_4");

	public static final ResourceKey<PaintingVariant> GREEN_RUG_1_X_2 = IcariaPaintingVariants.createKey("green_rug_1_x_2");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_1_X_3 = IcariaPaintingVariants.createKey("green_rug_1_x_3");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_1_X_4 = IcariaPaintingVariants.createKey("green_rug_1_x_4");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_2_X_2 = IcariaPaintingVariants.createKey("green_rug_2_x_2");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_2_X_3 = IcariaPaintingVariants.createKey("green_rug_2_x_3");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_2_X_4 = IcariaPaintingVariants.createKey("green_rug_2_x_4");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_3_X_3 = IcariaPaintingVariants.createKey("green_rug_3_x_3");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_3_X_4 = IcariaPaintingVariants.createKey("green_rug_3_x_4");

	public static final ResourceKey<PaintingVariant> ORANGE_RUG_1_X_2 = IcariaPaintingVariants.createKey("orange_rug_1_x_2");
	public static final ResourceKey<PaintingVariant> ORANGE_RUG_1_X_3 = IcariaPaintingVariants.createKey("orange_rug_1_x_3");
	public static final ResourceKey<PaintingVariant> ORANGE_RUG_1_X_4 = IcariaPaintingVariants.createKey("orange_rug_1_x_4");
	public static final ResourceKey<PaintingVariant> ORANGE_RUG_2_X_2 = IcariaPaintingVariants.createKey("orange_rug_2_x_2");
	public static final ResourceKey<PaintingVariant> ORANGE_RUG_2_X_3 = IcariaPaintingVariants.createKey("orange_rug_2_x_3");
	public static final ResourceKey<PaintingVariant> ORANGE_RUG_2_X_4 = IcariaPaintingVariants.createKey("orange_rug_2_x_4");
	public static final ResourceKey<PaintingVariant> ORANGE_RUG_3_X_3 = IcariaPaintingVariants.createKey("orange_rug_3_x_3");
	public static final ResourceKey<PaintingVariant> ORANGE_RUG_3_X_4 = IcariaPaintingVariants.createKey("orange_rug_3_x_4");

	public static void bootstrap(BootstrapContext<PaintingVariant> pBootstrapContext) {
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BRIDGE, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.CACTUS, 1, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ENDER_JELLYFISH, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.MOONS, 1, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.PERFECTION, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.PORTAL, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.PYRO, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.WINDOW, 1, 2);

		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_1_X_2, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_1_X_3, 3, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_1_X_4, 4, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_2_X_2, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_2_X_3, 3, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_2_X_4, 4, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_3_X_3, 3, 3);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.BROWN_RUG_3_X_4, 4, 3);

		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_1_X_2, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_1_X_3, 3, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_1_X_4, 4, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_2_X_2, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_2_X_3, 3, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_2_X_4, 4, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_3_X_3, 3, 3);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.GREEN_RUG_3_X_4, 4, 3);

		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_1_X_2, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_1_X_3, 3, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_1_X_4, 4, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_2_X_2, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_2_X_3, 3, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_2_X_4, 4, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_3_X_3, 3, 3);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariants.ORANGE_RUG_3_X_4, 4, 3);
	}

	public static void register(BootstrapContext<PaintingVariant> pBootstrapContext, ResourceKey<PaintingVariant> pPaintingVariants, int pHeight, int pWidth) {
		pBootstrapContext.register(pPaintingVariants, new PaintingVariant(pWidth, pHeight, pPaintingVariants.location(), Optional.of(Component.translatable(pPaintingVariants.location().toLanguageKey("painting", "title"))), Optional.of(Component.translatable(pPaintingVariants.location().toLanguageKey("painting", "author")))));
	}

	public static ResourceKey<PaintingVariant> createKey(String pName) {
		return ResourceKey.create(Registries.PAINTING_VARIANT, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
