package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaBiomeIds;
import com.axanthic.icaria.common.tags.IcariaBiomeTags;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeTagsProvider extends BiomeTagsProvider {
	public IcariaBiomeTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaBiomeTags.HAS_PORTAL)
			.add(Biomes.CRIMSON_FOREST)
			.add(Biomes.NETHER_WASTES)
			.add(Biomes.SOUL_SAND_VALLEY)
			.add(Biomes.WARPED_FOREST);

		this.tag(IcariaBiomeTags.IS_FOREST)
			.add(IcariaBiomeIds.FOREST)
			.add(IcariaBiomeIds.LUSH_FOREST)
			.add(IcariaBiomeIds.LOST_FOREST)
			.add(IcariaBiomeIds.DEEP_FOREST);

		this.tag(IcariaBiomeTags.IS_SCRUBLAND)
			.add(IcariaBiomeIds.SCRUBLAND)
			.add(IcariaBiomeIds.LUSH_SCRUBLAND)
			.add(IcariaBiomeIds.LOST_SCRUBLAND)
			.add(IcariaBiomeIds.DEEP_SCRUBLAND);

		this.tag(IcariaBiomeTags.IS_STEPPE)
			.add(IcariaBiomeIds.STEPPE)
			.add(IcariaBiomeIds.LUSH_STEPPE)
			.add(IcariaBiomeIds.LOST_STEPPE)
			.add(IcariaBiomeIds.DEEP_STEPPE);

		this.tag(IcariaBiomeTags.IS_DESERT)
			.add(IcariaBiomeIds.DESERT)
			.add(IcariaBiomeIds.LUSH_DESERT)
			.add(IcariaBiomeIds.LOST_DESERT)
			.add(IcariaBiomeIds.DEEP_DESERT);

		this.tag(IcariaBiomeTags.IS_SURFACE)
			.add(IcariaBiomeIds.FOREST)
			.add(IcariaBiomeIds.SCRUBLAND)
			.add(IcariaBiomeIds.STEPPE)
			.add(IcariaBiomeIds.DESERT);

		this.tag(IcariaBiomeTags.IS_LUSH)
			.add(IcariaBiomeIds.LUSH_FOREST)
			.add(IcariaBiomeIds.LUSH_SCRUBLAND)
			.add(IcariaBiomeIds.LUSH_STEPPE)
			.add(IcariaBiomeIds.LUSH_DESERT);

		this.tag(IcariaBiomeTags.IS_LOST)
			.add(IcariaBiomeIds.LOST_FOREST)
			.add(IcariaBiomeIds.LOST_SCRUBLAND)
			.add(IcariaBiomeIds.LOST_STEPPE)
			.add(IcariaBiomeIds.LOST_DESERT);

		this.tag(IcariaBiomeTags.IS_DEEP)
			.add(IcariaBiomeIds.DEEP_FOREST)
			.add(IcariaBiomeIds.DEEP_SCRUBLAND)
			.add(IcariaBiomeIds.DEEP_STEPPE)
			.add(IcariaBiomeIds.DEEP_DESERT);
	}

	@Override
	public String getName() {
		return "Biome Tags";
	}
}
