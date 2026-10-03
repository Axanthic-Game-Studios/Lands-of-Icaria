package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaPaintingVariantIds;

import java.util.Optional;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariants {
	public static void bootstrap(BootstrapContext<PaintingVariant> pBootstrapContext) {
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BRIDGE, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.CACTUS, 1, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.ENDER_JELLYFISH, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.MOONS, 1, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.PERFECTION, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.PORTAL, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.PYRO, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.WINDOW, 1, 2);

		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_1_X_2, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_1_X_3, 3, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_1_X_4, 4, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_2_X_2, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_2_X_3, 3, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_2_X_4, 4, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_3_X_3, 3, 3);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.BROWN_RUG_3_X_4, 4, 3);

		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_1_X_2, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_1_X_3, 3, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_1_X_4, 4, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_2_X_2, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_2_X_3, 3, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_2_X_4, 4, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_3_X_3, 3, 3);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.GREEN_RUG_3_X_4, 4, 3);

		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_1_X_2, 2, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_1_X_3, 3, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_1_X_4, 4, 1);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_2_X_2, 2, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_2_X_3, 3, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_2_X_4, 4, 2);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_3_X_3, 3, 3);
		IcariaPaintingVariants.register(pBootstrapContext, IcariaPaintingVariantIds.RED_RUG_3_X_4, 4, 3);
	}

	public static void register(BootstrapContext<PaintingVariant> pBootstrapContext, ResourceKey<PaintingVariant> pVariant, int pHeight, int pWidth) {
		pBootstrapContext.register(pVariant, new PaintingVariant(pWidth, pHeight, pVariant.identifier(), Optional.of(Component.translatable(pVariant.identifier().toLanguageKey("painting", "title"))), Optional.of(Component.translatable(pVariant.identifier().toLanguageKey("painting", "author")))));
	}
}
