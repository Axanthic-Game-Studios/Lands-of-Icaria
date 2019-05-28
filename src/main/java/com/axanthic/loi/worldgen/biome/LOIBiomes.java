package com.axanthic.loi.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;

public class LOIBiomes {

	public static Biome scrubland = new BiomeScrubland();

	public static void init() {
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(scrubland, 10));
		BiomeManager.addSpawnBiome(scrubland);
		BiomeDictionary.addTypes(scrubland, BiomeDictionary.Type.DRY);
	}

	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().register(scrubland);
	}

}
