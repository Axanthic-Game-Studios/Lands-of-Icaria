package com.axanthic.loi.worldgen.dimension;

import java.util.List;

import com.axanthic.loi.worldgen.biome.GenLayerLOI;
import com.axanthic.loi.worldgen.biome.GenLayerLOIBiomes;
import com.axanthic.loi.worldgen.biome.GenLayerLOIVoid;
import com.axanthic.loi.worldgen.biome.LOIBiomes;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.storage.WorldInfo;

public class BiomeProviderLOI extends BiomeProvider {

	ChunkGeneratorSettings settings;
	WorldType type;

	public BiomeProviderLOI(final WorldInfo info) {
		super(info);

		this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(info.getGeneratorOptions()).build();
		this.type = info.getTerrainType();

		BiomeProvider.allowedBiomes.clear();
		BiomeProvider.allowedBiomes.add(LOIBiomes.scrubland);
		BiomeProvider.allowedBiomes.add(LOIBiomes.desert);
		BiomeProvider.allowedBiomes.add(LOIBiomes.forest);
		BiomeProvider.allowedBiomes.add(LOIBiomes.steppe);
	}

	@Override
	public List<Biome> getBiomesToSpawnIn() {
		return BiomeProvider.allowedBiomes;
	}

	@Override
	public GenLayer[] getModdedBiomeGenerators(final WorldType worldType, final long seed, final GenLayer[] original) {
		GenLayer biomes = new GenLayerLOI(seed);

		biomes = new GenLayerLOIBiomes(1000, biomes);
		biomes = new GenLayerZoom(1001, biomes);
		biomes = new GenLayerZoom(1002, biomes);
		biomes = new GenLayerZoom(1003, biomes);
		biomes = new GenLayerZoom(1004, biomes);
		biomes = new GenLayerZoom(1005, biomes);
		biomes = new GenLayerZoom(1006, biomes);
		biomes = GenLayerZoom.magnify(1007L, biomes, 2);
		biomes = new GenLayerLOIVoid(seed, biomes);

		final GenLayer biomeIndexLayer = new GenLayerVoronoiZoom(10L, biomes);
		biomeIndexLayer.initWorldGenSeed(seed);

		return new GenLayer[] { biomes, biomeIndexLayer };
	}
}
