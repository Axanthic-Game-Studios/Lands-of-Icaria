package com.axanthic.loi.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;

public class LOIBiomes {

	public static Biome scrubland = new BiomeScrubland(1.0d, 4.5d);
	public static Biome desert = new BiomeDesert(4d, 12.5d);
	public static Biome forest = new BiomeForest(-0.5d, 1.0d);
	public static Biome steppe = new BiomeSteppe(1.0d, 1.0d);
	public static Biome voidBiome = new BiomeIcarianVoid();

	public static Biome[] biomes = { LOIBiomes.scrubland, LOIBiomes.desert, LOIBiomes.forest, LOIBiomes.steppe };

	public static void init() {
		// BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(scrubland, 10));
		// BiomeManager.addSpawnBiome(scrubland);
		BiomeDictionary.addTypes(LOIBiomes.scrubland, BiomeDictionary.Type.DRY);

		// BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(desert, 10));
		// BiomeManager.addSpawnBiome(desert);
		BiomeDictionary.addTypes(LOIBiomes.desert, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY);

		// BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(forest, 10));
		// BiomeManager.addSpawnBiome(forest);
		BiomeDictionary.addTypes(LOIBiomes.forest, BiomeDictionary.Type.FOREST);

		// BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(forest, 10));
		// BiomeManager.addSpawnBiome(forest);
		BiomeDictionary.addTypes(LOIBiomes.steppe, BiomeDictionary.Type.PLAINS);

		BiomeDictionary.addTypes(LOIBiomes.voidBiome, BiomeDictionary.Type.OCEAN);
//		BiomeManager.oceanBiomes.add(LOIBiomes.voidBiome);
	}

	public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
		for (final Biome biome : LOIBiomes.biomes) {
			event.getRegistry().register(biome);
		}
		event.getRegistry().register(LOIBiomes.voidBiome);
	}
}
