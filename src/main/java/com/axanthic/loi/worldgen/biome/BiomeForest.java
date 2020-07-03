package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.entity.*;
import com.axanthic.loi.worldgen.feature.WorldGenFirTree;
import com.axanthic.loi.worldgen.feature.WorldGenPopulusTree;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
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

public class BiomeForest extends BiomeLOI {

	public BiomeForest() {
		super(new BiomeProperties(ModInformation.ID + ":forest").setRainDisabled().setTemperature(0.5F));
		this.setRegistryName(ModInformation.ID + ":forest");

		upperBlockPrimary = Resources.moss.getBlock().getDefaultState();
		topBlockSecondary = Resources.grass.getBlock().getDefaultState();
		fillerBlockSecondary = Resources.soil.getBlock().getDefaultState();
		topBlockTertiary = Resources.soil.getBlock().getStateFromMeta(1);
		fillerBlockTertiary = Resources.soil.getBlock().getStateFromMeta(1);

		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityVinegaroon.class, 60, 1, 1));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityAeternae.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCatoblepas.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySnull.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySow.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityJellyfish.class, 100, 1, 2));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCivilian.class, 75, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantSoldier.class, 75, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCaptain.class, 75, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantPyromancer.class, 75, 1, 2));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCrawler.class, 75, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantOvergrown.class, 50, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachneDrone.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachne.class, 50, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityMyrmeke.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCerver.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArganHound.class, 200, 2, 5));

		flowers.clear();
		addFlower(Resources.flower.getBlock().getStateFromMeta(3), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(6), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(9), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(10), 20);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(0), 10);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(1), 10);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(2), 10);
		addFlower(Resources.bromelia.getBlock().getStateFromMeta(3), 10);
		addFlower(Resources.herb.getBlock().getStateFromMeta(1), 10);
		addFlower(Resources.herb.getBlock().getStateFromMeta(4), 10);
		addFlower(Resources.herb.getBlock().getStateFromMeta(7), 10);
		addFlower(Resources.bushStrawberry.getBlock().getDefaultState(), 10);
	}

	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		return 0x728B4D;
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator();

		biomeDecorator.treesPerChunk = 16;
		biomeDecorator.extraTreeChance = 0.1F;
		biomeDecorator.flowersPerChunk = 5;
		biomeDecorator.grassPerChunk = 8;
		biomeDecorator.lakeChance = 3;
		biomeDecorator.generateFerns = true;
		biomeDecorator.treeGenerators.add(new WorldGenFirTree(false).init());
		biomeDecorator.treeGenerators.add(new WorldGenPopulusTree(false).init());
		biomeDecorator.vines = new IBlockState[] {
				Resources.vineBloomyDead.getBlock().getDefaultState(),
				Resources.vineBrushyDead.getBlock().getDefaultState()
		};

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
