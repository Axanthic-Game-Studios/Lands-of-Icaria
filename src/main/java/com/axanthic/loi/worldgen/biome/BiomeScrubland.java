package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.loi.LOIVines;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.entity.*;
import com.axanthic.loi.worldgen.feature.WorldGenLaurelTree;
import com.axanthic.loi.worldgen.feature.WorldGenPlaneTree;

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

public class BiomeScrubland extends BiomeLOI {

	public BiomeScrubland() {
		super(new BiomeProperties(ModInformation.ID + ":scrubland").setRainDisabled().setTemperature(1.2F));
		this.setRegistryName(ModInformation.ID + ":scrubland");

		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityAeternae.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCatoblepas.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySow.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySnull.class, 50, 2, 6));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityJellyfish.class, 100, 1, 2));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForestHagPlane.class, 5, 1, 1));
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForestHagLaurel.class, 5, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCivilian.class, 75, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantSoldier.class, 75, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCaptain.class, 75, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantPyromancer.class, 75, 1, 2));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCrawler.class, 75, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantOvergrown.class, 50, 1, 2));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachneDrone.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachne.class, 50, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityMyrmeke.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCerver.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArganHound.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySolifugae.class, 25, 1, 2));

		flowers.clear();
		addFlower(Resources.flower.getBlock().getStateFromMeta(0), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(1), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(5), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(12), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(13), 20);
		addFlower(Resources.flower.getBlock().getStateFromMeta(14), 20);
		addFlower(Resources.blueGroundFlowers.getBlock().getDefaultState(), 20);
		addFlower(Resources.purpleGroundFlowers.getBlock().getDefaultState(), 20);
		//addFlower(Resources.herb.getBlock().getStateFromMeta(0), 10);
		//addFlower(Resources.herb.getBlock().getStateFromMeta(6), 10);
		addFlower(Resources.palmFern.getBlock().getDefaultState(), 20);
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

		biomeDecorator.treesPerChunk = 8;
		biomeDecorator.extraTreeChance = 0.2F;
		biomeDecorator.flowersPerChunk = 5;
		biomeDecorator.grassPerChunk = 7;
		biomeDecorator.lakeChance = 5;
		biomeDecorator.generateBoulders = true;
		biomeDecorator.treeGenerators.add(new WorldGenPlaneTree(false).init());
		biomeDecorator.treeGenerators.add(new WorldGenLaurelTree(false).init());
		biomeDecorator.woodTypes.add(Resources.plane);
		biomeDecorator.woodTypes.add(Resources.laurel);
		biomeDecorator.vines = new IBlockState[] {
				LOIVines.vineReedy.getDefaultState(),
				LOIVines.vineSwirly.getDefaultState()
		};
		biomeDecorator.extraRubble = new IBlockState[] {
				Resources.relicstoneRubble.getBlock().getDefaultState(),
				Resources.yellowstoneRubble.getBlock().getDefaultState()
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
