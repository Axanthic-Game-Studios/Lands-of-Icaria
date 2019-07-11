package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.entity.EntityArachne;
import com.axanthic.blab.entity.EntityArachneDrone;
import com.axanthic.blab.entity.EntityMyrmeke;
import com.axanthic.blab.entity.EntityRevenant;
import com.axanthic.loi.worldgen.feature.WorldGenDroughtrootTree;

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

public class BiomeDesert extends BiomeLOI {

	public BiomeDesert() {
		super(new BiomeProperties("blab:desert").setRainDisabled().setTemperature(2.0F));
		this.setRegistryName("blab:desert");

		topBlockPrimary = Resources.grainelSand.getBlock().getDefaultState();
		fillerBlockPrimary = Resources.grainelSand.getBlock().getDefaultState();
		topBlockSecondary = Resources.silkstoneSand.getBlock().getDefaultState();
		fillerBlockSecondary = Resources.silkstoneSand.getBlock().getDefaultState();

		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenant.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachneDrone.class, 200, 2, 5));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachne.class, 50, 1, 1));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityMyrmeke.class, 200, 2, 5));

		flowers.clear();
		addFlower(Resources.flower.getBlock().getStateFromMeta(15), 20);
		addFlower(Resources.flower2.getBlock().getStateFromMeta(0), 20);
		addFlower(Resources.herb.getBlock().getStateFromMeta(5), 10);
		addFlower(Resources.herb.getBlock().getStateFromMeta(8), 10);
	}

	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		return 0xB2B755;
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator();

		biomeDecorator.treesPerChunk = 0;
		biomeDecorator.extraTreeChance = 0.2F;
		biomeDecorator.extraTreeAmount = 6;
		biomeDecorator.flowersPerChunk = 4;
		biomeDecorator.cactiPerChunk = 20;
		biomeDecorator.grassPerChunk = 0;
		biomeDecorator.treeGenerators.add(new WorldGenDroughtrootTree(false).init());
		biomeDecorator.vines = new IBlockState[] {
				Resources.vineDry.getBlock().getDefaultState()
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
