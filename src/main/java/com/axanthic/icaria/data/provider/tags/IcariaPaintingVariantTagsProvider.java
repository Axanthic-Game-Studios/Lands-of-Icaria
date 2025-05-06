package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.data.registry.IcariaPaintingVariants;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariantTagsProvider extends PaintingVariantTagsProvider {
	public static final TagKey<PaintingVariant> PLACEABLE = IcariaPaintingVariantTagsProvider.icariaKey("placeable");

	public IcariaPaintingVariantTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaPaintingVariantTagsProvider.PLACEABLE)
			.add(IcariaPaintingVariants.BRIDGE)
			.add(IcariaPaintingVariants.CACTUS)
			.add(IcariaPaintingVariants.ENDER_JELLYFISH)
			.add(IcariaPaintingVariants.MOONS)
			.add(IcariaPaintingVariants.PERFECTION)
			.add(IcariaPaintingVariants.PORTAL)
			.add(IcariaPaintingVariants.PYRO)
			.add(IcariaPaintingVariants.WINDOW);
	}

	@Override
	public String getName() {
		return "Painting Variant Tags";
	}

	public static TagKey<PaintingVariant> cKey(String pName) {
		return IcariaPaintingVariantTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<PaintingVariant> icariaKey(String pName) {
		return IcariaPaintingVariantTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<PaintingVariant> createKey(String pName) {
		return TagKey.create(Registries.PAINTING_VARIANT, ResourceLocation.parse(pName));
	}
}
