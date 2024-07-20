package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaBiomes;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeTags extends BiomeTagsProvider {
	public static final TagKey<Biome> IS_FOREST = IcariaBiomeTags.icariaTag("is_forest");
	public static final TagKey<Biome> IS_SCRUBLAND = IcariaBiomeTags.icariaTag("is_scrubland");
	public static final TagKey<Biome> IS_STEPPE = IcariaBiomeTags.icariaTag("is_steppe");
	public static final TagKey<Biome> IS_DESERT = IcariaBiomeTags.icariaTag("is_desert");

	public static final TagKey<Biome> IS_PEAK = IcariaBiomeTags.icariaTag("is_peak");
	public static final TagKey<Biome> IS_LUSH = IcariaBiomeTags.icariaTag("is_lush");
	public static final TagKey<Biome> IS_LOST = IcariaBiomeTags.icariaTag("is_lost");
	public static final TagKey<Biome> IS_DEEP = IcariaBiomeTags.icariaTag("is_deep");

	public IcariaBiomeTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(BiomeTags.SNOW_GOLEM_MELTS)
			.add(IcariaBiomes.DESERT_PEAK)
			.add(IcariaBiomes.DESERT)
			.add(IcariaBiomes.LUSH_DESERT)
			.add(IcariaBiomes.LOST_DESERT)
			.add(IcariaBiomes.DEEP_DESERT);

		this.tag(IcariaBiomeTags.IS_FOREST)
			.add(IcariaBiomes.FOREST_PEAK)
			.add(IcariaBiomes.FOREST)
			.add(IcariaBiomes.LUSH_FOREST)
			.add(IcariaBiomes.LOST_FOREST)
			.add(IcariaBiomes.DEEP_FOREST);

		this.tag(IcariaBiomeTags.IS_SCRUBLAND)
			.add(IcariaBiomes.SCRUBLAND_PEAK)
			.add(IcariaBiomes.SCRUBLAND)
			.add(IcariaBiomes.LUSH_SCRUBLAND)
			.add(IcariaBiomes.LOST_SCRUBLAND)
			.add(IcariaBiomes.DEEP_SCRUBLAND);

		this.tag(IcariaBiomeTags.IS_STEPPE)
			.add(IcariaBiomes.STEPPE_PEAK)
			.add(IcariaBiomes.STEPPE)
			.add(IcariaBiomes.LUSH_STEPPE)
			.add(IcariaBiomes.LOST_STEPPE)
			.add(IcariaBiomes.DEEP_STEPPE);

		this.tag(IcariaBiomeTags.IS_DESERT)
			.add(IcariaBiomes.DESERT_PEAK)
			.add(IcariaBiomes.DESERT)
			.add(IcariaBiomes.LUSH_DESERT)
			.add(IcariaBiomes.LOST_DESERT)
			.add(IcariaBiomes.DEEP_DESERT);

		this.tag(IcariaBiomeTags.IS_PEAK)
			.add(IcariaBiomes.FOREST_PEAK)
			.add(IcariaBiomes.SCRUBLAND_PEAK)
			.add(IcariaBiomes.STEPPE_PEAK)
			.add(IcariaBiomes.DESERT_PEAK);

		this.tag(IcariaBiomeTags.IS_LUSH)
			.add(IcariaBiomes.LUSH_FOREST)
			.add(IcariaBiomes.LUSH_SCRUBLAND)
			.add(IcariaBiomes.LUSH_STEPPE)
			.add(IcariaBiomes.LUSH_DESERT);

		this.tag(IcariaBiomeTags.IS_LOST)
			.add(IcariaBiomes.LOST_FOREST)
			.add(IcariaBiomes.LOST_SCRUBLAND)
			.add(IcariaBiomes.LOST_STEPPE)
			.add(IcariaBiomes.LOST_DESERT);

		this.tag(IcariaBiomeTags.IS_DEEP)
			.add(IcariaBiomes.DEEP_FOREST)
			.add(IcariaBiomes.DEEP_SCRUBLAND)
			.add(IcariaBiomes.DEEP_STEPPE)
			.add(IcariaBiomes.DEEP_DESERT);
	}

	public static TagKey<Biome> bind(String pName) {
		return TagKey.create(Registries.BIOME, ResourceLocation.parse(pName));
	}

	public static TagKey<Biome> cTag(String pName) {
		return IcariaBiomeTags.bind(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Biome> icariaTag(String pName) {
		return IcariaBiomeTags.bind(IcariaIdents.ID + ":" + pName);
	}
}
