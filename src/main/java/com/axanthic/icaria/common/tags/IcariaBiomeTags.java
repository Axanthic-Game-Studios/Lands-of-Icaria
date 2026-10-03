package com.axanthic.icaria.common.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeTags {
	public static final TagKey<Biome> HAS_PORTAL = IcariaBiomeTags.creatIcaria("has_portal");

	public static final TagKey<Biome> IS_FOREST = IcariaBiomeTags.creatIcaria("is_forest");
	public static final TagKey<Biome> IS_SCRUBLAND = IcariaBiomeTags.creatIcaria("is_scrubland");
	public static final TagKey<Biome> IS_STEPPE = IcariaBiomeTags.creatIcaria("is_steppe");
	public static final TagKey<Biome> IS_DESERT = IcariaBiomeTags.creatIcaria("is_desert");

	public static final TagKey<Biome> IS_SURFACE = IcariaBiomeTags.creatIcaria("is_surface");
	public static final TagKey<Biome> IS_LUSH = IcariaBiomeTags.creatIcaria("is_lush");
	public static final TagKey<Biome> IS_LOST = IcariaBiomeTags.creatIcaria("is_lost");
	public static final TagKey<Biome> IS_DEEP = IcariaBiomeTags.creatIcaria("is_deep");

	public static TagKey<Biome> create(String pName) {
		return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(IcariaIds.C, pName));
	}

	public static TagKey<Biome> creatIcaria(String pName) {
		return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
