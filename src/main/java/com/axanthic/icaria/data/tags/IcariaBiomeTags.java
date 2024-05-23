package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaBiomes;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.util.IcariaRegistrySetBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeTags extends BiomeTagsProvider {
	public static final TagKey<Biome> FOREST_PLATEAU = IcariaBiomeTags.icariaTag("forest_plateau");
	public static final TagKey<Biome> SCRUBLAND_PLATEAU = IcariaBiomeTags.icariaTag("scrubland_plateau");
	public static final TagKey<Biome> STEPPE_PLATEAU = IcariaBiomeTags.icariaTag("steppe_plateau");
	public static final TagKey<Biome> DESERT_PLATEAU = IcariaBiomeTags.icariaTag("desert_plateau");

	public IcariaBiomeTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, IcariaRegistrySetBuilder pBuilder, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider.thenApply(provider -> IcariaBiomeTags.append(provider, pBuilder)), pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(BiomeTags.SNOW_GOLEM_MELTS)
			.add(IcariaBiomes.DESERT)
			.add(IcariaBiomes.DESERT_PLATEAU);

		this.tag(IcariaBiomeTags.FOREST_PLATEAU)
			.add(IcariaBiomes.FOREST_PLATEAU);

		this.tag(IcariaBiomeTags.SCRUBLAND_PLATEAU)
			.add(IcariaBiomes.SCRUBLAND_PLATEAU);

		this.tag(IcariaBiomeTags.STEPPE_PLATEAU)
			.add(IcariaBiomes.STEPPE_PLATEAU);

		this.tag(IcariaBiomeTags.DESERT_PLATEAU)
			.add(IcariaBiomes.DESERT_PLATEAU);
	}

	public static HolderLookup.Provider append(HolderLookup.Provider pProvider, RegistrySetBuilder pBuilder) {
		return pBuilder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), pProvider);
	}

	public static TagKey<Biome> bind(String pName) {
		return TagKey.create(Registries.BIOME, new ResourceLocation(pName));
	}

	public static TagKey<Biome> forgeTag(String pName) {
		return IcariaBiomeTags.bind(IcariaInfo.FORGE + ":" + pName);
	}

	public static TagKey<Biome> icariaTag(String pName) {
		return IcariaBiomeTags.bind(IcariaInfo.ID + ":" + pName);
	}
}
