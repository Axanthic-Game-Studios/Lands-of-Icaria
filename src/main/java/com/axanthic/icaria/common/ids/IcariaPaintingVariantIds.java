package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariantIds {
	public static final ResourceKey<PaintingVariant> BRIDGE = IcariaPaintingVariantIds.create("bridge");
	public static final ResourceKey<PaintingVariant> CACTUS = IcariaPaintingVariantIds.create("cactus");
	public static final ResourceKey<PaintingVariant> ENDER_JELLYFISH = IcariaPaintingVariantIds.create("ender_jellyfish");
	public static final ResourceKey<PaintingVariant> MOONS = IcariaPaintingVariantIds.create("moons");
	public static final ResourceKey<PaintingVariant> PERFECTION = IcariaPaintingVariantIds.create("perfection");
	public static final ResourceKey<PaintingVariant> PORTAL = IcariaPaintingVariantIds.create("portal");
	public static final ResourceKey<PaintingVariant> PYRO = IcariaPaintingVariantIds.create("pyro");
	public static final ResourceKey<PaintingVariant> WINDOW = IcariaPaintingVariantIds.create("window");

	public static final ResourceKey<PaintingVariant> BROWN_RUG_1_X_2 = IcariaPaintingVariantIds.create("brown_rug_1_x_2");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_1_X_3 = IcariaPaintingVariantIds.create("brown_rug_1_x_3");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_1_X_4 = IcariaPaintingVariantIds.create("brown_rug_1_x_4");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_2_X_2 = IcariaPaintingVariantIds.create("brown_rug_2_x_2");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_2_X_3 = IcariaPaintingVariantIds.create("brown_rug_2_x_3");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_2_X_4 = IcariaPaintingVariantIds.create("brown_rug_2_x_4");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_3_X_3 = IcariaPaintingVariantIds.create("brown_rug_3_x_3");
	public static final ResourceKey<PaintingVariant> BROWN_RUG_3_X_4 = IcariaPaintingVariantIds.create("brown_rug_3_x_4");

	public static final ResourceKey<PaintingVariant> GREEN_RUG_1_X_2 = IcariaPaintingVariantIds.create("green_rug_1_x_2");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_1_X_3 = IcariaPaintingVariantIds.create("green_rug_1_x_3");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_1_X_4 = IcariaPaintingVariantIds.create("green_rug_1_x_4");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_2_X_2 = IcariaPaintingVariantIds.create("green_rug_2_x_2");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_2_X_3 = IcariaPaintingVariantIds.create("green_rug_2_x_3");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_2_X_4 = IcariaPaintingVariantIds.create("green_rug_2_x_4");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_3_X_3 = IcariaPaintingVariantIds.create("green_rug_3_x_3");
	public static final ResourceKey<PaintingVariant> GREEN_RUG_3_X_4 = IcariaPaintingVariantIds.create("green_rug_3_x_4");

	public static final ResourceKey<PaintingVariant> RED_RUG_1_X_2 = IcariaPaintingVariantIds.create("red_rug_1_x_2");
	public static final ResourceKey<PaintingVariant> RED_RUG_1_X_3 = IcariaPaintingVariantIds.create("red_rug_1_x_3");
	public static final ResourceKey<PaintingVariant> RED_RUG_1_X_4 = IcariaPaintingVariantIds.create("red_rug_1_x_4");
	public static final ResourceKey<PaintingVariant> RED_RUG_2_X_2 = IcariaPaintingVariantIds.create("red_rug_2_x_2");
	public static final ResourceKey<PaintingVariant> RED_RUG_2_X_3 = IcariaPaintingVariantIds.create("red_rug_2_x_3");
	public static final ResourceKey<PaintingVariant> RED_RUG_2_X_4 = IcariaPaintingVariantIds.create("red_rug_2_x_4");
	public static final ResourceKey<PaintingVariant> RED_RUG_3_X_3 = IcariaPaintingVariantIds.create("red_rug_3_x_3");
	public static final ResourceKey<PaintingVariant> RED_RUG_3_X_4 = IcariaPaintingVariantIds.create("red_rug_3_x_4");

	public static ResourceKey<PaintingVariant> create(String pName) {
		return ResourceKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
