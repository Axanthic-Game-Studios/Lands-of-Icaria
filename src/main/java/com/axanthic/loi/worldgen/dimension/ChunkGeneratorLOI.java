package com.axanthic.loi.worldgen.dimension;

import java.util.List;
import java.util.Random;

import com.axanthic.loi.blocks.BlocksLOI;
import com.axanthic.loi.utils.PerlinNoise;
import com.axanthic.loi.worldgen.biome.BiomeLOI;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public class ChunkGeneratorLOI implements IChunkGenerator {

	/*****************************************************************/
	/// CONSTANTS
	/*****************************************************************/

	protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	protected static final IBlockState MAIN_BLOCK = BlocksLOI.BAETYL;

	protected static final IBlockState YELLOWSTONE = BlocksLOI.YELLOWSTONE;
	protected static final IBlockState SILKSTONE = BlocksLOI.SILKSTONE;
	protected static final IBlockState SUNSTONE = BlocksLOI.SUNSTONE;
	protected static final IBlockState VOIDSHALE = BlocksLOI.VOIDSHALE;
	protected static final IBlockState BAETYL = BlocksLOI.BAETYL;

	protected static final IBlockState MARLGRASS = BlocksLOI.MARLGRASS.getDefaultState();
	protected static final IBlockState LOAM = BlocksLOI.LOAM;
	protected static final IBlockState MARL = BlocksLOI.MARL;
	protected static final IBlockState MARLCOURSE = BlocksLOI.MARLCOURSE;

	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	protected static final IBlockState GRASS = Blocks.GRASS.getDefaultState();
	protected static final IBlockState DIRT = Blocks.DIRT.getDefaultState();
	protected static final IBlockState GRAVEL = Blocks.GRAVEL.getDefaultState();

	private final IBlockState oceanBlock = Blocks.WATER.getDefaultState();

	private static final int CHUNK_WIDTH = 16;
	public static final int CHUNK_HEIGHT = 256;

	/*****************************************************************/
	/// REFERENCES
	/*****************************************************************/

	private final World _world;
	private final Random _rand;
	private final PerlinNoise perlin;
	private final NoiseGeneratorOctaves octaveNoise;
	private final NoiseGeneratorPerlin surfaceNoise;
	private final OreGeneratorLOI oreGen;

	/*****************************************************************/
	/// PRIVATE VARIABLES
	/*****************************************************************/

	private Biome[] biomesForGeneration;
	private final double[] heightMap;
	private final float[] biomeWeights;
	private double[] buffer;
	private double[] depthBuffer = new double[256];
	private double[] loamNoise = new double[256];
	private double[] marlNoise = new double[256];
    private MapGenBase roadGenerator = new MapGenRoads();

	double[] mainNoise;

	public ChunkGeneratorLOI(final World worldIn, final long seed, final boolean mapFeaturesEnabledIn)
	{
		this._world = worldIn;
		this._rand = new Random(seed);
		//this.cell = new CellNoise(seed, (short) 0);
		//this.cell.setUseDistance(true);
		this.perlin = new PerlinNoise(seed);
		this.oreGen = new OreGeneratorLOI(perlin);


		this.heightMap = new double[825];
		this.biomeWeights = new float[25];

		//this.lperlinNoise1 = new NoiseGeneratorOctaves(this._rand, 16);
		this.octaveNoise = new NoiseGeneratorOctaves(this._rand, 16);
		//this.perlinNoise1 = new NoiseGeneratorOctaves(this._rand, 8);
		//this.exculsivityNoiseGen = new NoiseGeneratorOctaves(this._rand, 4);
		//this.loamMarlNoiseGen = new NoiseGeneratorOctaves(this._rand, 4);
		//this.scaleNoise = new NoiseGeneratorOctaves(this._rand, 10);
		//this.depthNoise = new NoiseGeneratorOctaves(this._rand, 16);
		this.surfaceNoise = new NoiseGeneratorPerlin(this._rand, 4);
		worldIn.setSeaLevel(63);
	}

	/**
	 * Called for every chunk, basically where you handle the generation.
	 */
	@Override
	public Chunk generateChunk(final int x, final int z)
	{
		this._rand.setSeed((x * 341873128712L) + (z * 132897987541L));

		final ChunkPrimer chunkprimer = new ChunkPrimer();
		this.prepareHeights(x, z, chunkprimer);
		//this.buildSurfaces(x, z, chunkprimer);
		this.setBlocksInChunk(x, z, chunkprimer);
		//this.setBlocksInChunk(x, z, chunkprimer);
		//this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);

		//        this.topBlock = Blocks.GRASS.getDefaultState();
		//        this.fillerBlock = Blocks.DIRT.getDefaultState();
		//
		//        if (noiseVal > 1.75D)
		//        {
		//            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
		//        }
		//        else if (noiseVal > -0.95D)
		//        {
		//            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
		//        }
		this.roadGenerator.generate(this._world, x, z, chunkprimer);

		final Chunk chunk = new Chunk(this._world, chunkprimer, x, z);
		//final Biome[] abiome = _world.getBiomeProvider().getBiomes((Biome[])null, x * 16, z * 16, 16, 16);
		final byte[] abyte = chunk.getBiomeArray();

		for (int i = 0; i < abyte.length; ++i)
		{
			abyte[i] = (byte)Biome.getIdForBiome(biomesForGeneration[i]);
		}

		//chunk.setBiomeArray(abyte);
		chunk.generateSkylightMap();
		return chunk;
	}

	public void prepareHeights(final int x, final int z, final ChunkPrimer primer)
	{
		final int seaLevel = (this._world.getSeaLevel() / 2) + 1;

		//primer.

		final int subChunkWidth = 4;

		final int sizeX = subChunkWidth + 1;
		final int sizeY = 17;
		final int sizeZ = subChunkWidth + 1;

		final double heightCoeff = 0.125d; // (sizeY - 1.0) / (ChunkGeneratorLOI.CHUNK_HEIGHT / 2.0)
		final double widthCoeff = 0.25d; // subChunkWidth / ChunkGeneratorLOI.CHUNK_WIDTH

		this.buffer = this.getHeights(this.buffer, x * 4, 0, z * 4, sizeX, sizeY, sizeZ);

		for (int subChunkX = 0; subChunkX < subChunkWidth; ++subChunkX)
		{
			for (int subChunkZ = 0; subChunkZ < subChunkWidth; ++subChunkZ)
			{
				for (int subChunkY = 0; subChunkY < (sizeY - 1); ++subChunkY)
				{
					double valueOrigin = this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 0];
					double valueSouth = this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 0];
					double valueEast = this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 0];
					double valueSouthEast = this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 0];
					final double valueUp = (this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 1] - valueOrigin) * heightCoeff;
					final double valueUpSouth = (this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 1] - valueSouth) * heightCoeff;
					final double valueUpEast = (this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 1] - valueEast) * heightCoeff;
					final double valueUpSouthEast = (this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 1] - valueSouthEast) * heightCoeff;

					for (int subY = 0; subY < 8; ++subY)
					{
						double valueSmoothX = valueOrigin;
						double valueSmoothZ = valueSouth;
						final double proportionX = (valueEast - valueOrigin) * widthCoeff;
						final double proportionXZ = (valueSouthEast - valueSouth) * widthCoeff;

						for (int subX = 0; subX < 4; ++subX)
						{
							double valueSmoothed = valueSmoothX;
							final double proportionZ = (valueSmoothZ - valueSmoothX) * widthCoeff;

							for (int subZ = 0; subZ < 4; ++subZ)
							{
								IBlockState block = null;

								if (valueSmoothed < 0.0D)
								{
									block = ChunkGeneratorLOI.MAIN_BLOCK;
								}

								final int cx = subX + (subChunkX * 4);
								final int cy = subY + (subChunkY * 8);
								final int cz = subZ + (subChunkZ * 4);
								primer.setBlockState(cx, cy, cz, block);
								valueSmoothed += proportionZ;
							}

							valueSmoothX += proportionX;
							valueSmoothZ += proportionXZ;
						}

						valueOrigin += valueUp;
						valueSouth += valueUpSouth;
						valueEast += valueUpEast;
						valueSouthEast += valueUpSouthEast;
					}
				}
			}
		}
	}

	private double[] getHeights(double[] buffer, final int wx, final int wy, final int wz, final int sizeX, final int sizeY, final int sizeZ)
	{
		if (buffer == null)
		{
			buffer = new double[sizeX * sizeY * sizeZ];
		}

		//bigger scale value = smaller scale :S
		int horizontalScale = 250;
		int verticalScale = 500;

		this.mainNoise = this.octaveNoise.generateNoiseOctaves(this.mainNoise, wx, wy, wz, sizeX, sizeY, sizeZ, horizontalScale, verticalScale, horizontalScale);

		int topSmooth = 5;
		int bottomSmooth = 3;
		float offsetStrength = 3.0F;
		float layerWidth = 60.0F;

		int index = 0;
		for (int x = 0; x < sizeX; ++x)
		{
			for (int z = 0; z < sizeZ; ++z)
			{
				float layerOffset = this.perlin.noise2((wx + x) / 20F, (wz + z) / 20F) * offsetStrength;
				for (int y = 0; y < sizeY; ++y)
				{
					//thinness value, less than 0 = terrain, greater than 0 = air
					double value = this.mainNoise[index] / 1000.0D;

					//value for smooth top and bottom of terrain
					double smoothing = 1;

					if (y > sizeY - topSmooth) {
						smoothing = (sizeY - topSmooth - y) * 16;
					} else if (y < bottomSmooth) {
						smoothing = (y - bottomSmooth) * 9;
					}

					//decrease the amount of terrain
					value += 15.0D;

					//smooth off top and bottom of terrain
					value -= smoothing;
					
					//amplify terrain contrast
					value = value * 6.0D;

					//sinewave for layered terrain
					value -= Math.sin(layerOffset / (y / 2.0D + 1.0D) + y * Math.PI / 1.4D) * layerWidth * Math.max(smoothing, 0);

					buffer[index] = value;
					++index;
				}
			}
		}
		return buffer;
	}

	//commented this method out because it seemed useless

	//Someday, people will be looking at my petrified corpse in a museum, and they will wonder:
	//"what horrible monster caused this man so much frustration?" 
	/*public void buildSurfaces(final int wcx, final int wcz, final ChunkPrimer primer)
	{
		final int sea_level = this._world.getSeaLevel() + 1;
		final double impact = 0.03125D;
		this.loamNoise = this.loamMarlNoiseGen.generateNoiseOctaves(this.loamNoise, wcx * 16, wcz * 16, 0, 16, 16, 1, 0.03125D, 0.03125D, 1.0D);
		this.marlNoise = this.loamMarlNoiseGen.generateNoiseOctaves(this.marlNoise, wcx * 16, 109, wcz * 16, 16, 1, 16, 0.03125D, 1.0D, 0.03125D);
		this.depthBuffer = this.exculsivityNoiseGen.generateNoiseOctaves(this.depthBuffer, wcx * 16, wcz * 16, 0, 16, 16, 1, impact * 2D, impact * 2D, impact * 2D);

		for (int cx = 0; cx < 16; ++cx)
		{
			for (int cz = 0; cz < 16; ++cz)
			{
				final boolean loamFlag = (this.loamNoise[cx + (cz * 16)] + (this._rand.nextDouble() * 0.2D)) > 0.0D;
				final boolean marlFlag = (this.marlNoise[cx + (cz * 16)] + (this._rand.nextDouble() * 0.2D)) > 0.0D;
				final int exculsivity = (int)((this.depthBuffer[cx + (cz * 16)] / 3.0D) + 3.0D + (this._rand.nextDouble() * 0.25D));
				int tmp_exculsivity = -1;
				IBlockState primaryBlockToSet = ChunkGeneratorLOI.MAIN_BLOCK;
				IBlockState secondaryBlockToSet = ChunkGeneratorLOI.MAIN_BLOCK;

				for (int cy = 127; cy >= 0; --cy)
				{
					final IBlockState blockAtPos = primer.getBlockState(cz, cy, cx);

					if ((blockAtPos.getBlock() != null) && (blockAtPos.getMaterial() != Material.AIR))
					{
						if (blockAtPos.getBlock() == BlocksLOI.STONE_LOI)
						{
							if (tmp_exculsivity == -1)
							{
								if (exculsivity <= 0)
								{
									primaryBlockToSet = ChunkGeneratorLOI.AIR;
									secondaryBlockToSet = ChunkGeneratorLOI.MAIN_BLOCK;
								}
								else if ((cy >= (sea_level - 4)) && (cy <= (sea_level + 1)))
								{
									primaryBlockToSet = ChunkGeneratorLOI.MAIN_BLOCK;
									secondaryBlockToSet = ChunkGeneratorLOI.MAIN_BLOCK;

									if (marlFlag)
									{
										primaryBlockToSet = ChunkGeneratorLOI.MARLCOURSE;
										secondaryBlockToSet = ChunkGeneratorLOI.MAIN_BLOCK;
									}

									if (loamFlag)
									{
										primaryBlockToSet = ChunkGeneratorLOI.MARLGRASS;
										secondaryBlockToSet = ChunkGeneratorLOI.MARLGRASS;
									}
								}

								//								if ((cy < sea_level) && ((primaryBlockToSet == null) || (primaryBlockToSet.getMaterial() == Material.AIR)))
								//								{
								//									primaryBlockToSet = ChunkGeneratorLOI.MAIN_BLOCK;
								//								}

								tmp_exculsivity = exculsivity;

								if (cy >= (sea_level - 1))
								{
									primer.setBlockState(cz, cy, cx, primaryBlockToSet);
								}
								else
								{
									primer.setBlockState(cz, cy, cx, secondaryBlockToSet);
								}
							}
							else if (tmp_exculsivity > 0)
							{
								--tmp_exculsivity;
								primer.setBlockState(cz, cy, cx, secondaryBlockToSet);
							}
						}
					}
					else
					{
						tmp_exculsivity = -1;
					}
				}
			}
		}
		//Therapist: On a scale of 1-10, how much do you want to smash something?
		//Me: [profusely sweating] Is 10 a limit or a guideline?
	}*/

	/**
	 * This is what places the blocks INTO the surfaces generated above
	 */
	public void setBlocksInChunk(final int x, final int z, final ChunkPrimer primer)
	{
		this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, x * 16, z * 16, 16, 16, 0.0625D, 0.0625D, 1.0D);
		this.biomesForGeneration = _world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 16, z * 16, 16, 16);

		@SuppressWarnings("unused")
		int wx, wz;
		final float noiseLoam;
		float noiseYellowstone, noiseSilkstone, noiseSunstone, noiseVoidshale;
		final int loam_density;
		int yellowstone_density, silkstone_density, sunstone_density, voidshale_density;

		for(int cx = 0; cx < ChunkGeneratorLOI.CHUNK_WIDTH; cx++)
		{
			wx = (x * ChunkGeneratorLOI.CHUNK_WIDTH) + cx;
			for(int cz = 0; cz < ChunkGeneratorLOI.CHUNK_WIDTH; cz++)
			{
				Biome biome = biomesForGeneration[cx + cz * 16];
				IBlockState upperBlockPrimary = null;
				IBlockState topBlockPrimary = ChunkGeneratorLOI.GRASS;
				IBlockState fillerBlockPrimary = ChunkGeneratorLOI.DIRT;
				IBlockState upperBlockSecondary = null;
				IBlockState topBlockSecondary = ChunkGeneratorLOI.MARLCOURSE;
				IBlockState fillerBlockSecondary = ChunkGeneratorLOI.MARLCOURSE;
				IBlockState upperBlockTertiary = null;
				IBlockState topBlockTertiary = ChunkGeneratorLOI.LOAM;
				IBlockState fillerBlockTertiary = ChunkGeneratorLOI.LOAM;

				BiomeLOI biomeLOI = null;
				if (biome instanceof BiomeLOI) {
					biomeLOI = (BiomeLOI) biome;
					upperBlockPrimary = biomeLOI.upperBlockPrimary;
					topBlockPrimary = biomeLOI.topBlockPrimary;
					fillerBlockPrimary = biomeLOI.fillerBlockPrimary;
					upperBlockSecondary = biomeLOI.upperBlockSecondary;
					topBlockSecondary = biomeLOI.topBlockSecondary;
					fillerBlockSecondary = biomeLOI.fillerBlockSecondary;
					upperBlockTertiary = biomeLOI.upperBlockTertiary;
					topBlockTertiary = biomeLOI.topBlockTertiary;
					fillerBlockTertiary = biomeLOI.fillerBlockTertiary;
				}

				wz = (z * ChunkGeneratorLOI.CHUNK_WIDTH) + cz;

				final double noiseValue = this.depthBuffer[cx + (cz * 16)];
				final int fillerBlockDensity = (int)((noiseValue / 3.0D) + 3.0D + (this._rand.nextDouble() * 0.25D));
				IBlockState upperBlock = upperBlockPrimary;
				IBlockState topBlock = topBlockPrimary;
				IBlockState fillerBlock = fillerBlockPrimary;

				if (noiseValue > 1.75D)
				{
					upperBlock = upperBlockTertiary;
					topBlock = topBlockTertiary;
					fillerBlock = fillerBlockTertiary;
				}
				else if (noiseValue > 0.0D)
				{
					upperBlock = upperBlockSecondary;
					topBlock = topBlockSecondary;
					fillerBlock = fillerBlockSecondary;
				}

				noiseYellowstone = this.perlin.noise2((wx + 2221f) / 95f, (wz + 2221f) / 95f);
				noiseSilkstone = this.perlin.noise2((wx + 7542f) / 75f, (wz + 7542f) / 75f);
				noiseSunstone = this.perlin.noise2((wx + 5517f) / 65f, (wz + 5517f) / 65f);
				noiseVoidshale = this.perlin.noise2((wx + 9784f) / 85f, (wz + 9784f) / 85f);

				yellowstone_density = (noiseYellowstone <= 0f) ? fillerBlockDensity : (int) (noiseYellowstone * 3f) + fillerBlockDensity;
				silkstone_density = (noiseSilkstone <= 0f) ? yellowstone_density : (int) (noiseSilkstone * 4f) + yellowstone_density;
				sunstone_density = (noiseSunstone <= 0f) ? silkstone_density : (int) (noiseSunstone * 4f) + silkstone_density;
				voidshale_density = (noiseVoidshale <= 0f) ? sunstone_density : (int) (noiseVoidshale * 5f) + sunstone_density;

				for(int cy = ChunkGeneratorLOI.CHUNK_HEIGHT; cy > 1; cy--)
				{
					IBlockState b = primer.getBlockState(cx, cy, cz);
					final IBlockState upper = primer.getBlockState(cx, cy + 1, cz);
					if((b.getBlock() != Blocks.AIR) && (upper.getBlock() == Blocks.AIR))
					{
						primer.setBlockState(cx, cy, cz, topBlock);
						if (upperBlock != null)
							primer.setBlockState(cx, cy + 1, cz, upperBlock);
						for(int gy = 1; gy < cy; gy++)
						{
							b = primer.getBlockState(cx, cy - gy, cz);
							if(b.getBlock() == Blocks.AIR) {
								break;
							}

							// /.\ Spaghetti code warning /.\
							if(gy < (3 + fillerBlockDensity)) {
								primer.setBlockState(cx, cy - gy, cz, fillerBlock);
							} else if((cy - gy) > (84 - yellowstone_density)) {
								primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.YELLOWSTONE);
							} else if((cy - gy) > (64 - silkstone_density)) {
								primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.SILKSTONE);
							} else if((cy - gy) > (52 - sunstone_density)) {
								primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.SUNSTONE);
							} else if((cy - gy) > (38 - voidshale_density)) {
								primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.VOIDSHALE);
							} else {
								primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.BAETYL);
							}
							// /.\ End warning /.\
						}
					}
				}
				this.oreGen.generate(cx, cz, wx, wz, primer);
			}
		}
	}

	/**
	 * Used to generate decorations. It is called after terrain generation.
	 */
	@Override
	public void populate(final int x, final int z)
	{
		BlockFalling.fallInstantly = true;
		net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this._world, this._rand, x, z, false);
		final int i = x * 16;
		final int j = z * 16;
		final BlockPos blockpos = new BlockPos(i, 0, j);
		final Biome biome = this._world.getBiome(blockpos.add(16, 0, 16));
		final ChunkPos chunkpos = new ChunkPos(x, z);

		// GENERATE DECORATIONS HERE.
		biome.decorate(this._world, this._rand, new BlockPos(i, 0, j));

		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(this._world, this._rand, blockpos));

		BlockFalling.fallInstantly = false;
	}

	@Override
	public boolean generateStructures(final Chunk chunkIn, final int x, final int z)
	{
		return false;
	}

	/**
	 * Create a list of the possible creatures to spawn in this dimension.
	 */
	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType creatureType, final BlockPos pos)
	{
		final Biome biome = this._world.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}

	@Override
	public void recreateStructures(final Chunk chunkIn, final int x, final int z) {}

	@Override
	public BlockPos getNearestStructurePos(final World worldIn, final String structureName, final BlockPos position,
			final boolean findUnexplored) {
		return null;
	}

	@Override
	public boolean isInsideStructure(final World worldIn, final String structureName, final BlockPos pos) {
		return false;
	}
}
