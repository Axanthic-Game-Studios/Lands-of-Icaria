package com.axanthic.loi.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerLOI extends GenLayer {
    private Biome[] biomes = new Biome[]{
            LOIBiomes.desert,
            LOIBiomes.scrubland,
            LOIBiomes.forest
    };

    public GenLayerLOI(long seed, GenLayer parent) {
        super(seed);
        this.parent = parent;
    }

    public GenLayerLOI(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int y, int width, int depth) {
        int dest[] = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + y);
                dest[dx + dz * depth] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);

            }


        }
        return dest;
    }
}