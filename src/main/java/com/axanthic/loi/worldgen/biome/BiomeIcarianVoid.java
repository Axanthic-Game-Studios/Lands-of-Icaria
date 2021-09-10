package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.loi.ModInformation;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeVoidDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeIcarianVoid extends BiomeLOI {

	public BiomeIcarianVoid() {
		super(new BiomeProperties(ModInformation.ID + ":void").setRainDisabled().setTemperature(0F), 1d, 1d);
		this.setRegistryName(ModInformation.ID + ":void");

		this.upperBlockPrimary = null;
		this.topBlockSecondary = null;
		this.fillerBlockSecondary = null;
		this.topBlockTertiary = null;
		this.fillerBlockTertiary = null;

		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

		this.flowers.clear();
	}

	@Override
	public void genTerrainBlocks(final World worldIn, final Random rand, final ChunkPrimer chunkPrimerIn, final int x, final int z, final double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeVoidDecorator();
	}

	@Override
	public boolean isVoid() {
		return true;
	}
}
