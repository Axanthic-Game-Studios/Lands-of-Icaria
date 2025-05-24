package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.Weighted;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;

import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeModifiers {
	public static final ResourceKey<BiomeModifier> THE_END_ENDER_JELLYFISH = IcariaBiomeModifiers.createKey("the_end_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> END_HIGHLANDS_ENDER_JELLYFISH = IcariaBiomeModifiers.createKey("end_highlands_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> END_MIDLANDS_ENDER_JELLYFISH = IcariaBiomeModifiers.createKey("end_midlands_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> SMALL_END_ISLANDS_ENDER_JELLYFISH = IcariaBiomeModifiers.createKey("small_end_islands_ender_jellyfish");
	public static final ResourceKey<BiomeModifier> END_BARRENS_ENDER_JELLYFISH = IcariaBiomeModifiers.createKey("end_barrens_ender_jellyfish");

	public static final ResourceKey<BiomeModifier> NETHER_WASTES_FIRE_JELLYFISH = IcariaBiomeModifiers.createKey("nether_wastes_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> WARPED_FOREST_FIRE_JELLYFISH = IcariaBiomeModifiers.createKey("warped_forest_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> CRIMSON_FOREST_FIRE_JELLYFISH = IcariaBiomeModifiers.createKey("crimson_forest_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> SOUL_SAND_VALLEY_FIRE_JELLYFISH = IcariaBiomeModifiers.createKey("soul_sand_valley_fire_jellyfish");
	public static final ResourceKey<BiomeModifier> BASALT_DELTAS_FIRE_JELLYFISH = IcariaBiomeModifiers.createKey("basalt_deltas_fire_jellyfish");

	public static final ResourceKey<BiomeModifier> NETHER_WASTES_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifiers.createKey("nether_wastes_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> WARPED_FOREST_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifiers.createKey("warped_forest_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> CRIMSON_FOREST_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifiers.createKey("crimson_forest_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> SOUL_SAND_VALLEY_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifiers.createKey("soul_sand_valley_nether_pyromancer_revenant");
	public static final ResourceKey<BiomeModifier> BASALT_DELTAS_NETHER_PYROMANCER_REVENANT = IcariaBiomeModifiers.createKey("basalt_deltas_nether_pyromancer_revenant");

	public static void bootstrap(BootstrapContext<BiomeModifier> pBootstrapContext) {
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.THE_END_ENDER_JELLYFISH, Biomes.THE_END, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.END_HIGHLANDS_ENDER_JELLYFISH, Biomes.END_HIGHLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.END_MIDLANDS_ENDER_JELLYFISH, Biomes.END_MIDLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.SMALL_END_ISLANDS_ENDER_JELLYFISH, Biomes.SMALL_END_ISLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.END_BARRENS_ENDER_JELLYFISH, Biomes.END_BARRENS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);

		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.NETHER_WASTES_FIRE_JELLYFISH, Biomes.NETHER_WASTES, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 100);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.WARPED_FOREST_FIRE_JELLYFISH, Biomes.WARPED_FOREST, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 1);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.CRIMSON_FOREST_FIRE_JELLYFISH, Biomes.CRIMSON_FOREST, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 5);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.SOUL_SAND_VALLEY_FIRE_JELLYFISH, Biomes.SOUL_SAND_VALLEY, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 20);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.BASALT_DELTAS_FIRE_JELLYFISH, Biomes.BASALT_DELTAS, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 100);

		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.NETHER_WASTES_NETHER_PYROMANCER_REVENANT, Biomes.NETHER_WASTES, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 100);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.WARPED_FOREST_NETHER_PYROMANCER_REVENANT, Biomes.WARPED_FOREST, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 1);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.CRIMSON_FOREST_NETHER_PYROMANCER_REVENANT, Biomes.CRIMSON_FOREST, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 5);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.SOUL_SAND_VALLEY_NETHER_PYROMANCER_REVENANT, Biomes.SOUL_SAND_VALLEY, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 20);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifiers.BASALT_DELTAS_NETHER_PYROMANCER_REVENANT, Biomes.BASALT_DELTAS, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 100);
	}

	public static Holder.Reference<BiomeModifier> register(BootstrapContext<BiomeModifier> pBootstrapContext, ResourceKey<BiomeModifier> pBiomeModifier, ResourceKey<Biome> pBiome, EntityType<?> pEntityType, int pMinCount, int pMaxCount, int pWeight) {
		return pBootstrapContext.register(pBiomeModifier, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(HolderSet.direct(pBootstrapContext.lookup(Registries.BIOME).getOrThrow(pBiome)), new Weighted<>(new MobSpawnSettings.SpawnerData(pEntityType, pMinCount, pMaxCount), pWeight)));
	}

	public static ResourceKey<BiomeModifier> createKey(String pName) {
		return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
