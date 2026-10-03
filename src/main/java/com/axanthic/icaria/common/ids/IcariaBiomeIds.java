package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeIds {
	public static final ResourceKey<Biome> FOREST = IcariaBiomeIds.create("forest");
	public static final ResourceKey<Biome> LUSH_FOREST = IcariaBiomeIds.create("lush_forest");
	public static final ResourceKey<Biome> LOST_FOREST = IcariaBiomeIds.create("lost_forest");
	public static final ResourceKey<Biome> DEEP_FOREST = IcariaBiomeIds.create("deep_forest");

	public static final ResourceKey<Biome> SCRUBLAND = IcariaBiomeIds.create("scrubland");
	public static final ResourceKey<Biome> LUSH_SCRUBLAND = IcariaBiomeIds.create("lush_scrubland");
	public static final ResourceKey<Biome> LOST_SCRUBLAND = IcariaBiomeIds.create("lost_scrubland");
	public static final ResourceKey<Biome> DEEP_SCRUBLAND = IcariaBiomeIds.create("deep_scrubland");

	public static final ResourceKey<Biome> STEPPE = IcariaBiomeIds.create("steppe");
	public static final ResourceKey<Biome> LUSH_STEPPE = IcariaBiomeIds.create("lush_steppe");
	public static final ResourceKey<Biome> LOST_STEPPE = IcariaBiomeIds.create("lost_steppe");
	public static final ResourceKey<Biome> DEEP_STEPPE = IcariaBiomeIds.create("deep_steppe");

	public static final ResourceKey<Biome> DESERT = IcariaBiomeIds.create("desert");
	public static final ResourceKey<Biome> LUSH_DESERT = IcariaBiomeIds.create("lush_desert");
	public static final ResourceKey<Biome> LOST_DESERT = IcariaBiomeIds.create("lost_desert");
	public static final ResourceKey<Biome> DEEP_DESERT = IcariaBiomeIds.create("deep_desert");

	public static final ResourceKey<Biome> VOID = IcariaBiomeIds.create("void");

	public static ResourceKey<Biome> create(String pName) {
		return ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
