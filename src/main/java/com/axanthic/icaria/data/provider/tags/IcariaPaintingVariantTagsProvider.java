package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.data.registry.IcariaPaintingVariants;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariantTagsProvider extends PaintingVariantTagsProvider {
	public static final TagKey<PaintingVariant> PAINTINGS = IcariaPaintingVariantTagsProvider.icariaKey("paintings");
	public static final TagKey<PaintingVariant> BROWN_RUGS = IcariaPaintingVariantTagsProvider.icariaKey("brown_rugs");
	public static final TagKey<PaintingVariant> GREEN_RUGS = IcariaPaintingVariantTagsProvider.icariaKey("green_rugs");
	public static final TagKey<PaintingVariant> RED_RUGS = IcariaPaintingVariantTagsProvider.icariaKey("red_rugs");

	public IcariaPaintingVariantTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaPaintingVariantTagsProvider.PAINTINGS)
			.add(IcariaPaintingVariants.BRIDGE)
			.add(IcariaPaintingVariants.CACTUS)
			.add(IcariaPaintingVariants.ENDER_JELLYFISH)
			.add(IcariaPaintingVariants.MOONS)
			.add(IcariaPaintingVariants.PERFECTION)
			.add(IcariaPaintingVariants.PORTAL)
			.add(IcariaPaintingVariants.PYRO)
			.add(IcariaPaintingVariants.WINDOW);

		this.tag(IcariaPaintingVariantTagsProvider.BROWN_RUGS)
			.add(IcariaPaintingVariants.BROWN_RUG_1_X_2)
			.add(IcariaPaintingVariants.BROWN_RUG_1_X_3)
			.add(IcariaPaintingVariants.BROWN_RUG_1_X_4)
			.add(IcariaPaintingVariants.BROWN_RUG_2_X_2)
			.add(IcariaPaintingVariants.BROWN_RUG_2_X_3)
			.add(IcariaPaintingVariants.BROWN_RUG_2_X_4)
			.add(IcariaPaintingVariants.BROWN_RUG_3_X_3)
			.add(IcariaPaintingVariants.BROWN_RUG_3_X_4);

		this.tag(IcariaPaintingVariantTagsProvider.GREEN_RUGS)
			.add(IcariaPaintingVariants.GREEN_RUG_1_X_2)
			.add(IcariaPaintingVariants.GREEN_RUG_1_X_3)
			.add(IcariaPaintingVariants.GREEN_RUG_1_X_4)
			.add(IcariaPaintingVariants.GREEN_RUG_2_X_2)
			.add(IcariaPaintingVariants.GREEN_RUG_2_X_3)
			.add(IcariaPaintingVariants.GREEN_RUG_2_X_4)
			.add(IcariaPaintingVariants.GREEN_RUG_3_X_3)
			.add(IcariaPaintingVariants.GREEN_RUG_3_X_4);

		this.tag(IcariaPaintingVariantTagsProvider.RED_RUGS)
			.add(IcariaPaintingVariants.RED_RUG_1_X_2)
			.add(IcariaPaintingVariants.RED_RUG_1_X_3)
			.add(IcariaPaintingVariants.RED_RUG_1_X_4)
			.add(IcariaPaintingVariants.RED_RUG_2_X_2)
			.add(IcariaPaintingVariants.RED_RUG_2_X_3)
			.add(IcariaPaintingVariants.RED_RUG_2_X_4)
			.add(IcariaPaintingVariants.RED_RUG_3_X_3)
			.add(IcariaPaintingVariants.RED_RUG_3_X_4);
	}

	@Override
	public String getName() {
		return "Painting Variant Tags";
	}

	public static TagKey<PaintingVariant> cKey(String pName) {
		return IcariaPaintingVariantTagsProvider.createKey(IcariaKeys.C + ":" + pName);
	}

	public static TagKey<PaintingVariant> icariaKey(String pName) {
		return IcariaPaintingVariantTagsProvider.createKey(IcariaKeys.ID + ":" + pName);
	}

	public static TagKey<PaintingVariant> createKey(String pName) {
		return TagKey.create(Registries.PAINTING_VARIANT, Identifier.parse(pName));
	}
}
