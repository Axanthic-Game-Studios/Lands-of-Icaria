package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeModifierIds {
	public static final ResourceKey<BiomeModifier> THE_END_ENDER_JELLYFISH = IcariaBiomeModifierIds.create("the_end_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> END_HIGHLANDS_ENDER_JELLYFISH = IcariaBiomeModifierIds.create("end_highlands_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> END_MIDLANDS_ENDER_JELLYFISH = IcariaBiomeModifierIds.create("end_midlands_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> SMALL_END_ISLANDS_ENDER_JELLYFISH = IcariaBiomeModifierIds.create("small_end_islands_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> END_BARRENS_ENDER_JELLYFISH = IcariaBiomeModifierIds.create("end_barrens_ender_jellyfish");

	public static final ResourceKey<BiomeModifier> NETHER_WASTES_FIRE_JELLYFISH = IcariaBiomeModifierIds.create("nether_wastes_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> WARPED_FOREST_FIRE_JELLYFISH = IcariaBiomeModifierIds.create("warped_forest_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> CRIMSON_FOREST_FIRE_JELLYFISH = IcariaBiomeModifierIds.create("crimson_forest_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> SOUL_SAND_VALLEY_FIRE_JELLYFISH = IcariaBiomeModifierIds.create("soul_sand_valley_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> BASALT_DELTAS_FIRE_JELLYFISH = IcariaBiomeModifierIds.create("basalt_deltas_fire_jellyfish");

	public static final ResourceKey<BiomeModifier> NETHER_WASTES_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifierIds.create("nether_wastes_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> WARPED_FOREST_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifierIds.create("warped_forest_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> CRIMSON_FOREST_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifierIds.create("crimson_forest_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> SOUL_SAND_VALLEY_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifierIds.create("soul_sand_valley_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> BASALT_DELTAS_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifierIds.create("basalt_deltas_nether_pyromancer_revenant");

	public static ResourceKey<BiomeModifier> create(String pName) {
		return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
