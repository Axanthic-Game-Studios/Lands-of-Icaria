package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;

import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaBiomeModifier {
    public static final ResourceKey<BiomeModifier> ADD_NETHER_PYROMANCER_REVENANT = ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(IcariaInfo.ID, "add_nether_pyromancer_revenant"));

    public static void bootstrap(BootstapContext<BiomeModifier> pContext) {
        pContext.register(IcariaBiomeModifier.ADD_NETHER_PYROMANCER_REVENANT, ForgeBiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(pContext.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_NETHER), new MobSpawnSettings.SpawnerData(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), 100, 1, 3)));
    }
}
