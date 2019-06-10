package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.entity.EntityAeternae;
import com.axanthic.blab.entity.EntityCatoblepas;
import com.axanthic.blab.entity.EntityRevenant;
import com.axanthic.blab.entity.EntitySnull;
import com.axanthic.loi.worldgen.feature.WorldGenLaurelTree;
import com.axanthic.loi.worldgen.feature.WorldGenPlaneTree;

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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeScrubland extends BiomeLOI {

	public BiomeScrubland() {
		super(new BiomeProperties("blab:scrubland").setRainDisabled().setTemperature(1.2F));
		this.setRegistryName("blab:scrubland");

		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityAeternae.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCatoblepas.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySnull.class, 50, 2, 6));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenant.class, 200, 2, 5));

		flowers.clear();
		addFlower(Resources.flower.getBlock().getStateFromMeta(0), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(1), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(5), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(12), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(13), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(14), 20);
		addFlower(Resources.herb.getBlock().getStateFromMeta(0), 10);
		addFlower(Resources.herb.getBlock().getStateFromMeta(6), 10);
	}

	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		return 0x70B263;
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator();

		biomeDecorator.treesPerChunk = 2;
		biomeDecorator.extraTreeChance = 0.2F;
		biomeDecorator.flowersPerChunk = 5;
		biomeDecorator.grassPerChunk = 7;
		biomeDecorator.generateBoulders = true;
		biomeDecorator.treeGenerators.add(new WorldGenPlaneTree(false).init());
		biomeDecorator.treeGenerators.add(new WorldGenLaurelTree(false).init());

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
