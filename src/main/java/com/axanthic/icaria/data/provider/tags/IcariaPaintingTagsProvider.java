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

import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingTagsProvider extends PaintingVariantTagsProvider {
	public static final TagKey<PaintingVariant> PLACEABLE = IcariaPaintingTagsProvider.icariaKey("placeable");

	public IcariaPaintingTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pExistingFileHelper) {
		super(pPackOutput, pProvider, pId, pExistingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaPaintingTagsProvider.PLACEABLE)
			.add(IcariaPaintingVariants.BRIDGE)
			.add(IcariaPaintingVariants.CACTUS)
			.add(IcariaPaintingVariants.ENDER_JELLYFISH)
			.add(IcariaPaintingVariants.MOONS)
			.add(IcariaPaintingVariants.PERFECTION)
			.add(IcariaPaintingVariants.PORTAL)
			.add(IcariaPaintingVariants.PYRO)
			.add(IcariaPaintingVariants.WINDOW);
	}

	public static TagKey<PaintingVariant> cKey(String pName) {
		return IcariaPaintingTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<PaintingVariant> icariaKey(String pName) {
		return IcariaPaintingTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<PaintingVariant> createKey(String pName) {
		return TagKey.create(Registries.PAINTING_VARIANT, ResourceLocation.parse(pName));
	}
}
