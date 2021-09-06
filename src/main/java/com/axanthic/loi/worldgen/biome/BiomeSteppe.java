package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.loi.LOIVines;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.entity.EntityAeternae;
import com.axanthic.loi.entity.EntityArachne;
import com.axanthic.loi.entity.EntityArachneDrone;
import com.axanthic.loi.entity.EntityArganHound;
import com.axanthic.loi.entity.EntityCatoblepas;
import com.axanthic.loi.entity.EntityCerver;
import com.axanthic.loi.entity.EntityForestHagCypress;
import com.axanthic.loi.entity.EntityForestHagOlive;
import com.axanthic.loi.entity.EntityJellyfish;
import com.axanthic.loi.entity.EntityMyrmeke;
import com.axanthic.loi.entity.EntityRevenantCaptain;
import com.axanthic.loi.entity.EntityRevenantCivilian;
import com.axanthic.loi.entity.EntityRevenantCrawler;
import com.axanthic.loi.entity.EntityRevenantOvergrown;
import com.axanthic.loi.entity.EntityRevenantPyromancer;
import com.axanthic.loi.entity.EntityRevenantSoldier;
import com.axanthic.loi.entity.EntitySnull;
import com.axanthic.loi.entity.EntitySow;
import com.axanthic.loi.entity.EntityVinegaroon;
import com.axanthic.loi.worldgen.feature.WorldGenCypressTree;
import com.axanthic.loi.worldgen.feature.WorldGenOliveTree;

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

public class BiomeSteppe extends BiomeLOI {

	public BiomeSteppe(final double density, final double topCrazyness) {
		super(new BiomeProperties(ModInformation.ID + ":steppe").setRainDisabled().setTemperature(1.6F), density, topCrazyness);
		this.setRegistryName(ModInformation.ID + ":steppe");

		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityAeternae.class, 50, 2, 6));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCatoblepas.class, 50, 2, 6));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySow.class, 50, 2, 6));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySnull.class, 50, 2, 6));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityJellyfish.class, 100, 1, 2));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForestHagCypress.class, 5, 1, 1));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForestHagOlive.class, 5, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCivilian.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantSoldier.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCaptain.class, 75, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantPyromancer.class, 75, 1, 2));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCrawler.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantOvergrown.class, 50, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachneDrone.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachne.class, 50, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityMyrmeke.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCerver.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArganHound.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityVinegaroon.class, 30, 1, 1));

		this.flowers.clear();
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(2), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(4), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(7), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(8), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(11), 20);
		this.addFlower(Resources.cyanGroundFlowers.getBlock().getDefaultState(), 20);
		this.addFlower(Resources.pinkGroundFlowers.getBlock().getDefaultState(), 20);
		// addFlower(Resources.herb.getBlock().getStateFromMeta(2), 10);
		// addFlower(Resources.herb.getBlock().getStateFromMeta(3), 10);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(final BlockPos pos) {
		return 0x97C15F;
	}

	@Override
	public void genTerrainBlocks(final World worldIn, final Random rand, final ChunkPrimer chunkPrimerIn, final int x, final int z, final double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		final LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator();

		biomeDecorator.treesPerChunk = 4;
		biomeDecorator.extraTreeChance = 0.2F;
		biomeDecorator.flowersPerChunk = 5;
		biomeDecorator.grassPerChunk = 6;
		biomeDecorator.lakeChance = 7;
		biomeDecorator.treeGenerators.add(new WorldGenCypressTree(false).init());
		biomeDecorator.treeGenerators.add(new WorldGenOliveTree(false).init());
		biomeDecorator.woodTypes.add(Resources.cypress);
		biomeDecorator.woodTypes.add(Resources.olive);
		biomeDecorator.vines = new IBlockState[] { LOIVines.vineBranch.getDefaultState(), LOIVines.vineThorny.getDefaultState() };

		return biomeDecorator;
	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(final Random rand) {
		return rand.nextInt(10) == 0 ? Biome.BIG_TREE_FEATURE : Biome.TREE_FEATURE;
	}

	@Override
	public WorldGenerator getRandomWorldGenForGrass(final Random rand) {
		return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}

	@Override
	public BlockFlower.EnumFlowerType pickRandomFlower(final Random rand, final BlockPos pos) {
		return rand.nextInt(3) > 0 ? BlockFlower.EnumFlowerType.DANDELION : BlockFlower.EnumFlowerType.POPPY;
	}
}
