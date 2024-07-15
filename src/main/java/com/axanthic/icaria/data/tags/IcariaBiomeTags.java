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
	public static final TagKey<Biome> FOREST = IcariaBiomeTags.icariaTag("forest");
	public static final TagKey<Biome> SCRUBLAND = IcariaBiomeTags.icariaTag("scrubland");
	public static final TagKey<Biome> STEPPE = IcariaBiomeTags.icariaTag("steppe");
	public static final TagKey<Biome> DESERT = IcariaBiomeTags.icariaTag("desert");

	public static final TagKey<Biome> PEAK = IcariaBiomeTags.icariaTag("peak");
	public static final TagKey<Biome> LUSH = IcariaBiomeTags.icariaTag("lush");
	public static final TagKey<Biome> LOST = IcariaBiomeTags.icariaTag("lost");
	public static final TagKey<Biome> DEEP = IcariaBiomeTags.icariaTag("deep");

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

		this.tag(IcariaBiomeTags.FOREST)
			.add(IcariaBiomes.FOREST_PEAK)
			.add(IcariaBiomes.FOREST)
			.add(IcariaBiomes.LUSH_FOREST)
			.add(IcariaBiomes.LOST_FOREST)
			.add(IcariaBiomes.DEEP_FOREST);

		this.tag(IcariaBiomeTags.SCRUBLAND)
			.add(IcariaBiomes.SCRUBLAND_PEAK)
			.add(IcariaBiomes.SCRUBLAND)
			.add(IcariaBiomes.LUSH_SCRUBLAND)
			.add(IcariaBiomes.LOST_SCRUBLAND)
			.add(IcariaBiomes.DEEP_SCRUBLAND);

		this.tag(IcariaBiomeTags.STEPPE)
			.add(IcariaBiomes.STEPPE_PEAK)
			.add(IcariaBiomes.STEPPE)
			.add(IcariaBiomes.LUSH_STEPPE)
			.add(IcariaBiomes.LOST_STEPPE)
			.add(IcariaBiomes.DEEP_STEPPE);

		this.tag(IcariaBiomeTags.DESERT)
			.add(IcariaBiomes.DESERT_PEAK)
			.add(IcariaBiomes.DESERT)
			.add(IcariaBiomes.LUSH_DESERT)
			.add(IcariaBiomes.LOST_DESERT)
			.add(IcariaBiomes.DEEP_DESERT);

		this.tag(IcariaBiomeTags.PEAK)
			.add(IcariaBiomes.FOREST_PEAK)
			.add(IcariaBiomes.SCRUBLAND_PEAK)
			.add(IcariaBiomes.STEPPE_PEAK)
			.add(IcariaBiomes.DESERT_PEAK);

		this.tag(IcariaBiomeTags.LUSH)
			.add(IcariaBiomes.LUSH_FOREST)
			.add(IcariaBiomes.LUSH_SCRUBLAND)
			.add(IcariaBiomes.LUSH_STEPPE)
			.add(IcariaBiomes.LUSH_DESERT);

		this.tag(IcariaBiomeTags.LOST)
			.add(IcariaBiomes.LOST_FOREST)
			.add(IcariaBiomes.LOST_SCRUBLAND)
			.add(IcariaBiomes.LOST_STEPPE)
			.add(IcariaBiomes.LOST_DESERT);

		this.tag(IcariaBiomeTags.DEEP)
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
