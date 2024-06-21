package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;

import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ENDER_JELLYFISH = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(IcariaInfo.ID, "add_ender_jellyfish"));
    public static final ResourceKey<BiomeModifier> ADD_FIRE_JELLYFISH = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(IcariaInfo.ID, "add_fire_jellyfish"));
    public static final ResourceKey<BiomeModifier> ADD_NETHER_PYROMANCER_REVENANT = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(IcariaInfo.ID, "add_nether_pyromancer_revenant"));

    public static void bootstrap(BootstrapContext<BiomeModifier> pContext) {
        pContext.register(IcariaBiomeModifiers.ADD_ENDER_JELLYFISH, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(pContext.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_END), new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ENDER_JELLYFISH.get(), 100, 3, 5)));
        pContext.register(IcariaBiomeModifiers.ADD_FIRE_JELLYFISH, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(pContext.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_NETHER), new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIRE_JELLYFISH.get(), 100, 3, 5)));
        pContext.register(IcariaBiomeModifiers.ADD_NETHER_PYROMANCER_REVENANT, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(pContext.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_NETHER), new MobSpawnSettings.SpawnerData(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 100, 1, 1)));
    }
}
