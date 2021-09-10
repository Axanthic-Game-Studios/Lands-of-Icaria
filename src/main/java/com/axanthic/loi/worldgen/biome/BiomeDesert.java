package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.loi.LOIVines;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.entity.EntityArachne;
import com.axanthic.loi.entity.EntityArachneDrone;
import com.axanthic.loi.entity.EntityArganHound;
import com.axanthic.loi.entity.EntityCerver;
import com.axanthic.loi.entity.EntityForestHagDroughtroot;
import com.axanthic.loi.entity.EntityJellyfish;
import com.axanthic.loi.entity.EntityMyrmeke;
import com.axanthic.loi.entity.EntityRevenantCaptain;
import com.axanthic.loi.entity.EntityRevenantCivilian;
import com.axanthic.loi.entity.EntityRevenantCrawler;
import com.axanthic.loi.entity.EntityRevenantOvergrown;
import com.axanthic.loi.entity.EntityRevenantPyromancer;
import com.axanthic.loi.entity.EntityRevenantSoldier;
import com.axanthic.loi.entity.EntityScorpion;
import com.axanthic.loi.entity.EntitySolifugae;
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

	public BiomeDesert(final double density, final double topCrazyness) {
		super(new BiomeProperties(ModInformation.ID + ":desert").setRainDisabled().setTemperature(2.0F), density, topCrazyness);
		this.setRegistryName(ModInformation.ID + ":desert");

		this.topBlockPrimary = Resources.grainelSand.getBlock().getDefaultState();
		this.fillerBlockPrimary = Resources.grainelSand.getBlock().getDefaultState();
		this.topBlockSecondary = Resources.silkstoneSand.getBlock().getDefaultState();
		this.fillerBlockSecondary = Resources.silkstoneSand.getBlock().getDefaultState();

		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityJellyfish.class, 100, 1, 2));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForestHagDroughtroot.class, 10, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCivilian.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantSoldier.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCaptain.class, 75, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantPyromancer.class, 75, 1, 2));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantCrawler.class, 75, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenantOvergrown.class, 50, 1, 2));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachneDrone.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArachne.class, 50, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityMyrmeke.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCerver.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArganHound.class, 200, 2, 5));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityScorpion.class, 35, 1, 3));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySolifugae.class, 25, 1, 2));

		this.flowers.clear();
		this.addFlower(Resources.flower.getBlock().getStateFromMeta(15), 20);
		this.addFlower(Resources.flower2.getBlock().getStateFromMeta(0), 20);
		this.addFlower(Resources.redGroundFlowers.getBlock().getDefaultState(), 20);
		this.addFlower(Resources.whiteGroundFlowers.getBlock().getDefaultState(), 20);
		// addFlower(Resources.herb.getBlock().getStateFromMeta(5), 10);
		// addFlower(Resources.herb.getBlock().getStateFromMeta(8), 10);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(final BlockPos pos) {
		return 0xB2B755;
	}

	@Override
	public void genTerrainBlocks(final World worldIn, final Random rand, final ChunkPrimer chunkPrimerIn, final int x, final int z, final double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		final LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator();

		biomeDecorator.treesPerChunk = 0;
		biomeDecorator.extraTreeChance = 0.4F;
		biomeDecorator.extraTreeAmount = 24;
		biomeDecorator.flowersPerChunk = 4;
		biomeDecorator.cactiPerChunk = 20;
		biomeDecorator.grassPerChunk = 0;
		biomeDecorator.lakeChance = 10;
		biomeDecorator.generateSpikes = true;
		biomeDecorator.treeGenerators.add(new WorldGenDroughtrootTree(false).init());
		biomeDecorator.woodTypes.add(Resources.droughtroot);
		biomeDecorator.vines = new IBlockState[] { LOIVines.vineDry.getDefaultState() };
		biomeDecorator.extraRubble = new IBlockState[] { Resources.relicstoneRubble.getBlock().getDefaultState(),
				Resources.grainelRubble.getBlock().getDefaultState() };

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
