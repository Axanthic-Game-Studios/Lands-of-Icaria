package com.axanthic.icaria.common.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingTags {
	public static final TagKey<PaintingVariant> PAINTINGS = IcariaPaintingTags.creatIcaria("paintings");
	public static final TagKey<PaintingVariant> BROWN_RUGS = IcariaPaintingTags.creatIcaria("brown_rugs");
	public static final TagKey<PaintingVariant> GREEN_RUGS = IcariaPaintingTags.creatIcaria("green_rugs");
	public static final TagKey<PaintingVariant> RED_RUGS = IcariaPaintingTags.creatIcaria("red_rugs");

	public static TagKey<PaintingVariant> create(String pName) {
		return TagKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(IcariaIds.C, pName));
	}

	public static TagKey<PaintingVariant> creatIcaria(String pName) {
		return TagKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
