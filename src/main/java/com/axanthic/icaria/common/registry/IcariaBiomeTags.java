package com.axanthic.icaria.common.registry;

import java.util.concurrent.CompletableFuture;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaBiomeTags extends BiomeTagsProvider {

	public static final TagKey<Biome> IS_VOID = TagKey.create(Registries.BIOME,
			new ResourceLocation(IcariaInfo.ID, "is_void"));

	public IcariaBiomeTags(final PackOutput output, final CompletableFuture<HolderLookup.Provider> provider,
			final ExistingFileHelper helper) {
		super(output, provider, IcariaInfo.ID, helper);
	}

	@Override
	protected void addTags(final HolderLookup.Provider provider) {
		tag(IS_VOID).add(IcariaBiomes.VOID);
	}

	@Override
	public String getName() {
		return "Icaria Biome Tags";
	}
}