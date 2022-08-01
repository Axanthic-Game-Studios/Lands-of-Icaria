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
import com.axanthic.loi.entity.EntityForestHagDroughtroot;
import com.axanthic.loi.entity.EntityForestHagOlive;
import com.axanthic.loi.entity.EntityJellyfish;
import com.axanthic.loi.entity.EntityMyrmeke;
import com.axanthic.loi.entity.EntityRevenantCaptain;
import com.axanthic.loi.entity.EntityRevenantCivilian;
import com.axanthic.loi.entity.EntityRevenantCrawler;
import com.axanthic.loi.entity.EntityRevenantOvergrown;
import com.axanthic.loi.entity.EntityRevenantPyromancer;
import com.axanthic.loi.entity.EntityRevenantSoldier;
import com.axanthic.loi.entity.EntityScorpion;
import com.axanthic.loi.entity.EntitySnull;
import com.axanthic.loi.entity.EntitySolifugae;
import com.axanthic.loi.entity.EntitySow;
import com.axanthic.loi.entity.EntityVinegaroon;
import com.axanthic.loi.worldgen.feature.WorldGenCypressTree;
import com.axanthic.loi.worldgen.feature.WorldGenOliveTree;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeVoidDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeIcarianVoid extends BiomeLOI {

	public BiomeIcarianVoid() {
		super(new BiomeProperties(ModInformation.ID + ":void").setRainDisabled().setTemperature(1.1F), 1d, 1d);
		this.setRegistryName(ModInformation.ID + ":void");

		//this.upperBlockPrimary = null;
		//this.topBlockSecondary = null;
		//this.fillerBlockSecondary = null;
		//this.topBlockTertiary = null;
		//this.fillerBlockTertiary = null;

		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySnull.class, 50, 2, 6));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityJellyfish.class, 100, 1, 2));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCivilian.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantSoldier.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCaptain.class, 75, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantPyromancer.class, 75, 1, 2));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCrawler.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantOvergrown.class, 50, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachneDrone.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachne.class, 50, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCerver.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArganHound.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityVinegaroon.class, 30, 1, 1));

		this.flowers.clear();
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(0), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(4), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(9), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(7), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(12), 20);
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(14), 20);
		this.addFlower(Resources.cyanGroundFlowers.getBlock().getDefaultState(), 20);
		this.addFlower(Resources.purpleGroundFlowers.getBlock().getDefaultState(), 20);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(final BlockPos pos) {
		return 0x70C474;
	}

	@Override
	public void genTerrainBlocks(final World worldIn, final Random rand, final ChunkPrimer chunkPrimerIn, final int x, final int z, final double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		final LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator() {
			public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
				super.decorate(worldIn, random, biome, pos);
				BlockPos blockpos = worldIn.getSpawnPoint();
				int i = 16;
				double d0 = blockpos.distanceSq(pos.add(8, blockpos.getY(), 8));

				if (d0 <= 1024.0D) {
					BlockPos blockpos1 = new BlockPos(blockpos.getX() - 16, blockpos.getY() - 1, blockpos.getZ() - 16);
					BlockPos blockpos2 = new BlockPos(blockpos.getX() + 16, blockpos.getY() - 1, blockpos.getZ() + 16);
					BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(blockpos1);

					for (int j = pos.getZ(); j < pos.getZ() + 16; ++j) {
						for (int k = pos.getX(); k < pos.getX() + 16; ++k) {
							if (j >= blockpos1.getZ() && j <= blockpos2.getZ() && k >= blockpos1.getX() && k <= blockpos2.getX()) {
								blockpos$mutableblockpos.setPos(k, blockpos$mutableblockpos.getY(), j);

								if (blockpos.getX() == k && blockpos.getZ() == j) {
									worldIn.setBlockState(blockpos$mutableblockpos, Blocks.COBBLESTONE.getDefaultState(), 2);
								} else {
									worldIn.setBlockState(blockpos$mutableblockpos, Blocks.STONE.getDefaultState(), 2);
								}
							}
						}
					}
				}
			}
		};

		biomeDecorator.treesPerChunk = 0;
		biomeDecorator.extraTreeChance = 0F;
		biomeDecorator.flowersPerChunk = 5;
		biomeDecorator.grassPerChunk = 6;
		biomeDecorator.lakeChance = 7;
		biomeDecorator.vines = new IBlockState[] { LOIVines.vineBranch.getDefaultState(), LOIVines.vineSwirly.getDefaultState() };

		return biomeDecorator;
	}

	@Override
	public boolean isVoid() {
		return true;
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
