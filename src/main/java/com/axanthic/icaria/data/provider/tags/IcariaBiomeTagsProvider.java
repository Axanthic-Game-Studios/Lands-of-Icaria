package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.data.registry.IcariaBiomes;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeTagsProvider extends BiomeTagsProvider {
	public static final TagKey<Biome> HAS_PORTAL = IcariaBiomeTagsProvider.icariaKey("has_portal");

	public static final TagKey<Biome> IS_FOREST = IcariaBiomeTagsProvider.icariaKey("is_forest");
	public static final TagKey<Biome> IS_SCRUBLAND = IcariaBiomeTagsProvider.icariaKey("is_scrubland");
	public static final TagKey<Biome> IS_STEPPE = IcariaBiomeTagsProvider.icariaKey("is_steppe");
	public static final TagKey<Biome> IS_DESERT = IcariaBiomeTagsProvider.icariaKey("is_desert");

	public static final TagKey<Biome> IS_SURFACE = IcariaBiomeTagsProvider.icariaKey("is_surface");
	public static final TagKey<Biome> IS_LUSH = IcariaBiomeTagsProvider.icariaKey("is_lush");
	public static final TagKey<Biome> IS_LOST = IcariaBiomeTagsProvider.icariaKey("is_lost");
	public static final TagKey<Biome> IS_DEEP = IcariaBiomeTagsProvider.icariaKey("is_deep");

	public IcariaBiomeTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pExistingFileHelper) {
		super(pPackOutput, pProvider, pId, pExistingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(BiomeTags.SNOW_GOLEM_MELTS)
			.add(IcariaBiomes.DESERT)
			.add(IcariaBiomes.LUSH_DESERT)
			.add(IcariaBiomes.LOST_DESERT)
			.add(IcariaBiomes.DEEP_DESERT);

		this.tag(IcariaBiomeTagsProvider.HAS_PORTAL)
			.add(Biomes.CRIMSON_FOREST)
			.add(Biomes.NETHER_WASTES)
			.add(Biomes.SOUL_SAND_VALLEY)
			.add(Biomes.WARPED_FOREST);

		this.tag(IcariaBiomeTagsProvider.IS_FOREST)
			.add(IcariaBiomes.FOREST)
			.add(IcariaBiomes.LUSH_FOREST)
			.add(IcariaBiomes.LOST_FOREST)
			.add(IcariaBiomes.DEEP_FOREST);

		this.tag(IcariaBiomeTagsProvider.IS_SCRUBLAND)
			.add(IcariaBiomes.SCRUBLAND)
			.add(IcariaBiomes.LUSH_SCRUBLAND)
			.add(IcariaBiomes.LOST_SCRUBLAND)
			.add(IcariaBiomes.DEEP_SCRUBLAND);

		this.tag(IcariaBiomeTagsProvider.IS_STEPPE)
			.add(IcariaBiomes.STEPPE)
			.add(IcariaBiomes.LUSH_STEPPE)
			.add(IcariaBiomes.LOST_STEPPE)
			.add(IcariaBiomes.DEEP_STEPPE);

		this.tag(IcariaBiomeTagsProvider.IS_DESERT)
			.add(IcariaBiomes.DESERT)
			.add(IcariaBiomes.LUSH_DESERT)
			.add(IcariaBiomes.LOST_DESERT)
			.add(IcariaBiomes.DEEP_DESERT);

		this.tag(IcariaBiomeTagsProvider.IS_SURFACE)
			.add(IcariaBiomes.FOREST)
			.add(IcariaBiomes.SCRUBLAND)
			.add(IcariaBiomes.STEPPE)
			.add(IcariaBiomes.DESERT);

		this.tag(IcariaBiomeTagsProvider.IS_LUSH)
			.add(IcariaBiomes.LUSH_FOREST)
			.add(IcariaBiomes.LUSH_SCRUBLAND)
			.add(IcariaBiomes.LUSH_STEPPE)
			.add(IcariaBiomes.LUSH_DESERT);

		this.tag(IcariaBiomeTagsProvider.IS_LOST)
			.add(IcariaBiomes.LOST_FOREST)
			.add(IcariaBiomes.LOST_SCRUBLAND)
			.add(IcariaBiomes.LOST_STEPPE)
			.add(IcariaBiomes.LOST_DESERT);

		this.tag(IcariaBiomeTagsProvider.IS_DEEP)
			.add(IcariaBiomes.DEEP_FOREST)
			.add(IcariaBiomes.DEEP_SCRUBLAND)
			.add(IcariaBiomes.DEEP_STEPPE)
			.add(IcariaBiomes.DEEP_DESERT);
	}

	public static TagKey<Biome> cKey(String pName) {
		return IcariaBiomeTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Biome> icariaKey(String pName) {
		return IcariaBiomeTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<Biome> createKey(String pName) {
		return TagKey.create(Registries.BIOME, ResourceLocation.parse(pName));
	}
}
