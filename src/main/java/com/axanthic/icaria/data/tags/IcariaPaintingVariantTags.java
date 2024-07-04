package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaPaintingVariants;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariantTags extends PaintingVariantTagsProvider {
	public static final TagKey<PaintingVariant> PLACEABLE = IcariaPaintingVariantTags.icariaTag("placeable");

	public IcariaPaintingVariantTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pId, pHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaPaintingVariantTags.PLACEABLE)
			.add(IcariaPaintingVariants.BRIDGE)
			.add(IcariaPaintingVariants.CACTUS)
			.add(IcariaPaintingVariants.MOONS)
			.add(IcariaPaintingVariants.PERFECTION)
			.add(IcariaPaintingVariants.PORTAL)
			.add(IcariaPaintingVariants.PYRO);
	}

	public static TagKey<PaintingVariant> bind(String pName) {
		return TagKey.create(Registries.PAINTING_VARIANT, ResourceLocation.parse(pName));
	}

	public static TagKey<PaintingVariant> cTag(String pName) {
		return IcariaPaintingVariantTags.bind(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<PaintingVariant> icariaTag(String pName) {
		return IcariaPaintingVariantTags.bind(IcariaIdents.ID + ":" + pName);
	}
}
