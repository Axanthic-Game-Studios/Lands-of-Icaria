package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;

import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeModifiers {
	public static final ResourceKey<BiomeModifier> ADD_ENDER_JELLYFISH_TO_THE_END = IcariaBiomeModifiers.createKey("add_ender_jellyfish_to_the_end");
	public static final ResourceKey<BiomeModifier> ADD_ENDER_JELLYFISH_TO_END_HIGHLANDS = IcariaBiomeModifiers.createKey("add_ender_jellyfish_to_end_highlands");
	public static final ResourceKey<BiomeModifier> ADD_ENDER_JELLYFISH_TO_END_MIDLANDS = IcariaBiomeModifiers.createKey("add_ender_jellyfish_to_end_midlands");
	public static final ResourceKey<BiomeModifier> ADD_ENDER_JELLYFISH_TO_SMALL_END_ISLANDS = IcariaBiomeModifiers.createKey("add_ender_jellyfish_to_small_end_islands");
	public static final ResourceKey<BiomeModifier> ADD_ENDER_JELLYFISH_TO_END_BARRENS = IcariaBiomeModifiers.createKey("add_ender_jellyfish_to_end_barrens");

	public static final ResourceKey<BiomeModifier> ADD_FIRE_JELLYFISH_TO_NETHER_WASTES = IcariaBiomeModifiers.createKey("add_fire_jellyfish_to_nether_wastes");
	public static final ResourceKey<BiomeModifier> ADD_FIRE_JELLYFISH_TO_WARPED_FOREST = IcariaBiomeModifiers.createKey("add_fire_jellyfish_to_warped_forest");
	public static final ResourceKey<BiomeModifier> ADD_FIRE_JELLYFISH_TO_CRIMSON_FOREST = IcariaBiomeModifiers.createKey("add_fire_jellyfish_to_crimson_forest");
	public static final ResourceKey<BiomeModifier> ADD_FIRE_JELLYFISH_TO_SOUL_SAND_VALLEY = IcariaBiomeModifiers.createKey("add_fire_jellyfish_to_soul_sand_valley");
	public static final ResourceKey<BiomeModifier> ADD_FIRE_JELLYFISH_TO_BASALT_DELTAS = IcariaBiomeModifiers.createKey("add_fire_jellyfish_to_basalt_deltas");

	public static final ResourceKey<BiomeModifier> ADD_NETHER_PYROMANCER_REVENANT_TO_NETHER_WASTES = IcariaBiomeModifiers.createKey("add_nether_pyromancer_revenant_to_nether_wastes");
	public static final ResourceKey<BiomeModifier> ADD_NETHER_PYROMANCER_REVENANT_TO_WARPED_FOREST = IcariaBiomeModifiers.createKey("add_nether_pyromancer_revenant_to_warped_forest");
	public static final ResourceKey<BiomeModifier> ADD_NETHER_PYROMANCER_REVENANT_TO_CRIMSON_FOREST = IcariaBiomeModifiers.createKey("add_nether_pyromancer_revenant_to_crimson_forest");
	public static final ResourceKey<BiomeModifier> ADD_NETHER_PYROMANCER_REVENANT_TO_SOUL_SAND_VALLEY = IcariaBiomeModifiers.createKey("add_nether_pyromancer_revenant_to_soul_sand_valley");
	public static final ResourceKey<BiomeModifier> ADD_NETHER_PYROMANCER_REVENANT_TO_BASALT_DELTAS = IcariaBiomeModifiers.createKey("add_nether_pyromancer_revenant_to_basalt_deltas");

	public static void bootstrap(BootstrapContext<BiomeModifier> pContext) {
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_ENDER_JELLYFISH_TO_THE_END, Biomes.THE_END, IcariaEntityTypes.ENDER_JELLYFISH.get(), 10, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_ENDER_JELLYFISH_TO_END_HIGHLANDS, Biomes.END_HIGHLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 10, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_ENDER_JELLYFISH_TO_END_MIDLANDS, Biomes.END_MIDLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 10, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_ENDER_JELLYFISH_TO_SMALL_END_ISLANDS, Biomes.SMALL_END_ISLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 10, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_ENDER_JELLYFISH_TO_END_BARRENS, Biomes.END_BARRENS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 10, 1, 1);

		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_FIRE_JELLYFISH_TO_NETHER_WASTES, Biomes.NETHER_WASTES, IcariaEntityTypes.FIRE_JELLYFISH.get(), 100, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_FIRE_JELLYFISH_TO_WARPED_FOREST, Biomes.WARPED_FOREST, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_FIRE_JELLYFISH_TO_CRIMSON_FOREST, Biomes.CRIMSON_FOREST, IcariaEntityTypes.FIRE_JELLYFISH.get(), 5, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_FIRE_JELLYFISH_TO_SOUL_SAND_VALLEY, Biomes.SOUL_SAND_VALLEY, IcariaEntityTypes.FIRE_JELLYFISH.get(), 20, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_FIRE_JELLYFISH_TO_BASALT_DELTAS, Biomes.BASALT_DELTAS, IcariaEntityTypes.FIRE_JELLYFISH.get(), 100, 1, 1);

		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_NETHER_PYROMANCER_REVENANT_TO_NETHER_WASTES, Biomes.NETHER_WASTES, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 100, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_NETHER_PYROMANCER_REVENANT_TO_WARPED_FOREST, Biomes.WARPED_FOREST, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_NETHER_PYROMANCER_REVENANT_TO_CRIMSON_FOREST, Biomes.CRIMSON_FOREST, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 5, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_NETHER_PYROMANCER_REVENANT_TO_SOUL_SAND_VALLEY, Biomes.SOUL_SAND_VALLEY, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 20, 1, 1);
		IcariaBiomeModifiers.register(pContext, IcariaBiomeModifiers.ADD_NETHER_PYROMANCER_REVENANT_TO_BASALT_DELTAS, Biomes.BASALT_DELTAS, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 100, 1, 1);
	}

	public static Holder.Reference<BiomeModifier> register(BootstrapContext<BiomeModifier> pContext, ResourceKey<BiomeModifier> pModifier, ResourceKey<Biome> pBiome, EntityType<?> pType, int pWeight, int pMinCount, int pMaxCount) {
		return pContext.register(pModifier, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(HolderSet.direct(pContext.lookup(Registries.BIOME).getOrThrow(pBiome)), new MobSpawnSettings.SpawnerData(pType, pWeight, pMinCount, pMaxCount)));
	}

	public static ResourceKey<BiomeModifier> createKey(String pName) {
		return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
