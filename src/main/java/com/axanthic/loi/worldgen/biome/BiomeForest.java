package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.entity.EntityAeternae;
import com.axanthic.blab.entity.EntityForestHag;
import com.axanthic.blab.entity.EntityRevenant;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeForest extends BiomeLOI {

	public BiomeForest() {
		super(new BiomeProperties("blab:forest").setRainDisabled().setTemperature(0.5F));
		this.setRegistryName("blab:forest");

		upperBlockPrimary = Resources.moss.getBlock().getDefaultState();
		topBlockSecondary = Resources.grass.getBlock().getDefaultState();
		fillerBlockSecondary = Resources.soil.getBlock().getDefaultState();
		topBlockTertiary = Resources.soil.getBlock().getStateFromMeta(1);
		fillerBlockTertiary = Resources.soil.getBlock().getStateFromMeta(1);

		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityAeternae.class, 50, 2, 4));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForestHag.class, 100, 1, 2));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenant.class, 200, 1, 4));

		flowers.clear();
		addFlower(Resources.flower.getBlock().getStateFromMeta(3), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(6), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(9), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(10), 20);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(0), 5);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(1), 5);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(2), 5);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(3), 5);
		addFlower(Resources.herb.getBlock().getStateFromMeta(0), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(1), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(2), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(3), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(4), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(5), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(6), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(7), 1);
		addFlower(Resources.herb.getBlock().getStateFromMeta(8), 1);
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator();

		biomeDecorator.treesPerChunk = 4;
		biomeDecorator.extraTreeChance = 0.1F;
		biomeDecorator.flowersPerChunk = 5;
		biomeDecorator.grassPerChunk = 7;

		return biomeDecorator;
	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return (WorldGenAbstractTree)(rand.nextInt(10) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE);
	}

	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}

	@Override
	public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos) {
		return rand.nextInt(3) > 0 ? BlockFlower.EnumFlowerType.DANDELION : BlockFlower.EnumFlowerType.POPPY;
	}
}
