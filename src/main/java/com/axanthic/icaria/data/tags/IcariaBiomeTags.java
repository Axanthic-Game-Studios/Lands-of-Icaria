package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaBiomes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeTags extends BiomeTagsProvider {
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
	}
}
