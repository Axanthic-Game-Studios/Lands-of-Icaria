package com.axanthic.loi.worldgen.biome;

import com.axanthic.loi.utils.PerlinNoise;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerLOIVoid extends GenLayer {

	private final PerlinNoise perlinNoise;

	public GenLayerLOIVoid(final long l, final GenLayer genlayer) {
		super(l);
		this.parent = genlayer;
		this.perlinNoise = new PerlinNoise(l);
	}

	public GenLayerLOIVoid(final long seed) {
		super(seed);
		this.perlinNoise = new PerlinNoise(seed);
	}

	@Override
	public int[] getInts(final int x, final int z, final int width, final int depth) {
		final int src[] = this.parent.getInts(x, z, width, depth);
		final int dest[] = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				final double size = 125d; // Note: roughly the size of the "patches" of void.
				final double noise = this.perlinNoise.noise((x + dx) / size, (z + dz) / size);
				if (noise > 0d) {
					dest[dx + dz * width] = Biome.getIdForBiome(LOIBiomes.voidBiome);
				} else {
					dest[dx + dz * width] = src[dx + dz * width];
				}
			}
		}

		return dest;
	}

	/**
	 * Determine which map "region" the specified points are in. Assign the 0-3 of the index to the key biomes based on that region.
	 */
	private int getBiomeAt(final int mapX, final int mapZ, final int index) {

		final int regionX = (mapX + 4) >> 3;
		final int regionZ = (mapZ + 4) >> 3;

		this.initChunkSeed(regionX, regionZ);
		final int offset = this.nextInt(4);

		return Biome.getIdForBiome(LOIBiomes.biomes[(index + offset) % LOIBiomes.biomes.length]);
	}
}