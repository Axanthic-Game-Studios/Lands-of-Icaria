package com.axanthic.loi.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;

public class LOIBiomes {

	public static Biome scrubland = new BiomeScrubland();
	public static Biome desert = new BiomeDesert();
	public static Biome forest = new BiomeForest();
	public static Biome steppe = new BiomeSteppe();

	public static Biome[] biomes = {
			scrubland,
			desert,
			forest,
			steppe
	};

	public static void init() {
		//BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(scrubland, 10));
		//BiomeManager.addSpawnBiome(scrubland);
		BiomeDictionary.addTypes(scrubland, BiomeDictionary.Type.DRY);

		//BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(desert, 10));
		//BiomeManager.addSpawnBiome(desert);
		BiomeDictionary.addTypes(desert, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY);

		//BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(forest, 10));
		//BiomeManager.addSpawnBiome(forest);
		BiomeDictionary.addTypes(forest, BiomeDictionary.Type.FOREST);

		//BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(forest, 10));
		//BiomeManager.addSpawnBiome(forest);
		BiomeDictionary.addTypes(steppe, BiomeDictionary.Type.PLAINS);
	}

	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		for (Biome biome : biomes) {
			event.getRegistry().register(biome);
		}
	}
}
