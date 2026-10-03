package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaBiomeModifierIds;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.Weighted;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;

import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomeModifiers {
	public static void bootstrap(BootstrapContext<BiomeModifier> pBootstrapContext) {
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.THE_END_ENDER_JELLYFISH, Biomes.THE_END, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.END_HIGHLANDS_ENDER_JELLYFISH, Biomes.END_HIGHLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.END_MIDLANDS_ENDER_JELLYFISH, Biomes.END_MIDLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.SMALL_END_ISLANDS_ENDER_JELLYFISH, Biomes.SMALL_END_ISLANDS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.END_BARRENS_ENDER_JELLYFISH, Biomes.END_BARRENS, IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3, 10);

		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.NETHER_WASTES_FIRE_JELLYFISH, Biomes.NETHER_WASTES, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 100);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.WARPED_FOREST_FIRE_JELLYFISH, Biomes.WARPED_FOREST, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 1);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.CRIMSON_FOREST_FIRE_JELLYFISH, Biomes.CRIMSON_FOREST, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 5);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.SOUL_SAND_VALLEY_FIRE_JELLYFISH, Biomes.SOUL_SAND_VALLEY, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 20);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.BASALT_DELTAS_FIRE_JELLYFISH, Biomes.BASALT_DELTAS, IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3, 100);

		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.NETHER_WASTES_NETHER_PYROMANCER_REVENANT, Biomes.NETHER_WASTES, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 100);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.WARPED_FOREST_NETHER_PYROMANCER_REVENANT, Biomes.WARPED_FOREST, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 1);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.CRIMSON_FOREST_NETHER_PYROMANCER_REVENANT, Biomes.CRIMSON_FOREST, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 5);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.SOUL_SAND_VALLEY_NETHER_PYROMANCER_REVENANT, Biomes.SOUL_SAND_VALLEY, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 20);
		IcariaBiomeModifiers.register(pBootstrapContext, IcariaBiomeModifierIds.BASALT_DELTAS_NETHER_PYROMANCER_REVENANT, Biomes.BASALT_DELTAS, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 1, 1, 100);
	}

	public static Holder.Reference<BiomeModifier> register(BootstrapContext<BiomeModifier> pBootstrapContext, ResourceKey<BiomeModifier> pBiomeModifier, ResourceKey<Biome> pBiome, EntityType<?> pEntityType, int pMin, int pMax, int pWeight) {
		return pBootstrapContext.register(pBiomeModifier, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(HolderSet.direct(pBootstrapContext.lookup(Registries.BIOME).getOrThrow(pBiome)), new Weighted<>(new MobSpawnSettings.SpawnerData(pEntityType, pMin, pMax), pWeight)));
	}
}
