package com.axanthic.loi.worldgen.dimension;

import java.util.List;
import java.util.Random;

import com.axanthic.loi.blocks.BlocksLOI;
import com.axanthic.loi.utils.CellNoise;
import com.axanthic.loi.utils.PerlinNoise;
import com.axanthic.loi.worldgen.biome.BiomeLOI;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
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
	private final CellNoise cell;
	private final NoiseGeneratorOctaves octaveNoise;
	private final NoiseGeneratorOctaves lperlinNoise1;
	private final NoiseGeneratorOctaves lperlinNoise2;
	private final NoiseGeneratorPerlin surfaceNoise;
	// private final BigVeinOreGeneratorLOI oreGen;

	/*****************************************************************/
	/// PRIVATE VARIABLES
	/*****************************************************************/

	private Biome[] biomesForGeneration;
	private Biome[] biomesForHeights;
	private final double[] heightMap;
	private final float[] biomeWeights;
	private double[] buffer;
	private double[] depthBuffer = new double[256];
	private final double[] loamNoise = new double[256];
	private final double[] marlNoise = new double[256];
	private final MapGenBase roadGenerator = new MapGenRoads();

	double[] mainNoise;
	double[] roughShapeNoise1;
	double[] roughShapeNoise2;

	public ChunkGeneratorLOI(final World worldIn, final long seed, final boolean mapFeaturesEnabledIn) {
		this._world = worldIn;
		this._rand = new Random(seed);
		this.cell = new CellNoise(seed, (short) 0);
		this.cell.setUseDistance(true);
		this.perlin = new PerlinNoise(seed);
		// this.oreGen = new BigVeinOreGeneratorLOI(perlin);

		this.heightMap = new double[825];
		this.biomeWeights = new float[25];

		this.lperlinNoise1 = new NoiseGeneratorOctaves(this._rand, 12);
		this.lperlinNoise2 = new NoiseGeneratorOctaves(this._rand, 12);
		this.octaveNoise = new NoiseGeneratorOctaves(this._rand, 8);
		this.surfaceNoise = new NoiseGeneratorPerlin(this._rand, 4);
		worldIn.setSeaLevel(63);
	}

	/**
	 * Called for every chunk, basically where you handle the generation.
	 */
	@Override
	public Chunk generateChunk(final int x, final int z) {
		this._rand.setSeed((x * 341873128712L) + (z * 132897987541L));

		final ChunkPrimer chunkprimer = new ChunkPrimer();
		this.biomesForHeights = this._world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, (x * 16) - 2, (z * 16) - 2, 20, 20);
		this.calculateBiomesForGeneration();

		this.prepareHeights(x, z, chunkprimer);
		// this.buildSurfaces(x, z, chunkprimer);
		this.setBlocksInChunk(x, z, chunkprimer);
		// this.setBlocksInChunk(x, z, chunkprimer);
		// this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);

		// this.topBlock = Blocks.GRASS.getDefaultState();
		// this.fillerBlock = Blocks.DIRT.getDefaultState();
		//
		// if (noiseVal > 1.75D)
		// {
		// this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
		// }
		// else if (noiseVal > -0.95D)
		// {
		// this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
		// }
		this.roadGenerator.generate(this._world, x, z, chunkprimer);

		final Chunk chunk = new Chunk(this._world, chunkprimer, x, z);
		// final Biome[] abiome = _world.getBiomeProvider().getBiomes((Biome[])null, x * 16, z * 16, 16, 16);
		final byte[] abyte = chunk.getBiomeArray();

		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
		}

		// chunk.setBiomeArray(abyte);
		chunk.generateSkylightMap();
		return chunk;
	}

	/**
	 * This just fills the "biomesForGeneration" array of the chunk from the other bigger array instead of recalculating it (basically an optimization).
	 */
	private void calculateBiomesForGeneration() {
		this.biomesForGeneration = new Biome[16 * 16];
		for (int cx = 2; cx < 18; cx++) {
			for (int cz = 2; cz < 18; cz++) {
				final int biomeIndex = (cx - 2) + ((cz - 2) << 4);
				this.biomesForGeneration[biomeIndex] = this.biomesForHeights[cx + cz * 20];
			}
		}
	}

	public void prepareHeights(final int x, final int z, final ChunkPrimer primer) {
		final int seaLevel = (this._world.getSeaLevel() / 2) + 1;

		// primer.

		final int subChunkWidth = 4;

		final int sizeX = subChunkWidth + 1;
		final int sizeY = 17;
		final int sizeZ = subChunkWidth + 1;

		final double heightCoeff = 0.125d; // (sizeY - 1.0) / (ChunkGeneratorLOI.CHUNK_HEIGHT / 2.0)
		final double widthCoeff = 0.25d; // subChunkWidth / ChunkGeneratorLOI.CHUNK_WIDTH
		final double bottomSmoothValue = 1d;

		this.buffer = this.getHeights(this.buffer, x * subChunkWidth, 0, z * subChunkWidth, sizeX, sizeY, sizeZ);

		for (int subChunkX = 0; subChunkX < subChunkWidth; ++subChunkX) {
			for (int subChunkZ = 0; subChunkZ < subChunkWidth; ++subChunkZ) {
				for (int subChunkY = 0; subChunkY < (sizeY - 1); ++subChunkY) {
					double valueOrigin = this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 0] * bottomSmoothValue;
					double valueSouth = this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 0] * bottomSmoothValue;
					double valueEast = this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 0] * bottomSmoothValue;
					double valueSouthEast = this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 0] * bottomSmoothValue;
					final double valueUp = (this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 1] - valueOrigin) * heightCoeff;
					final double valueUpSouth = (this.buffer[((((subChunkX + 0) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 1] - valueSouth) * heightCoeff;
					final double valueUpEast = (this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 0) * sizeY) + subChunkY + 1] - valueEast) * heightCoeff;
					final double valueUpSouthEast = (this.buffer[((((subChunkX + 1) * sizeZ) + subChunkZ + 1) * sizeY) + subChunkY + 1] - valueSouthEast)
							* heightCoeff;

					for (int subY = 0; subY < 8; ++subY) {
						double valueSmoothX = valueOrigin;
						double valueSmoothZ = valueSouth;
						final double proportionX = (valueEast - valueOrigin) * widthCoeff;
						final double proportionXZ = (valueSouthEast - valueSouth) * widthCoeff;

						for (int subX = 0; subX < 4; ++subX) {
							double valueSmoothed = valueSmoothX;
							final double proportionZ = (valueSmoothZ - valueSmoothX) * widthCoeff;

							for (int subZ = 0; subZ < 4; ++subZ) {
								IBlockState block = null;

								if (valueSmoothed < 0.0D) {
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

	/**
	 * @param subchunkX, chunkPosX * 4
	 * @param subchunkY, 0
	 * @param subchunkZ, chunkPosZ * 4
	 * @param sizeX,     5
	 * @param sizeY,     17
	 * @param sizeZ,     5
	 */
	private double[] getHeights(double[] buffer, final int subchunkX, final int subchunkY, final int subchunkZ, final int sizeX, final int sizeY,
			final int sizeZ) {
		if (buffer == null) {
			buffer = new double[sizeX * sizeY * sizeZ];
		}

		// If you want to change the gen, modify these three values.
		// Horizontal & vertical scale correspond to the frequency of the noise (roughly the shape of the islands)
		// The third value is the scale down on the noise, the higher the more squished the islands will get.
		final double horizontalScale = 45D; // multiply by 4 for the numbers of blocks
		final double verticalScale = 11D; // multiply by 8 for the number of blocks
		final double roughValueScaleDown = 100.0D;
		final double decal = 0.0D;

		// Note: noise values goes from -2^octaves to 2^octaves (aka 256 & 65536) though it is very unlikely to go past 32000 even.
		this.mainNoise = this.octaveNoise.generateNoiseOctaves(this.mainNoise, subchunkX, subchunkY, subchunkZ, sizeX, sizeY, sizeZ, 8.555150000000001D,
				34.2206D, 8.555150000000001D);
		this.roughShapeNoise1 = this.lperlinNoise1.generateNoiseOctaves(this.roughShapeNoise1, subchunkX, subchunkY, subchunkZ, sizeX, sizeY, sizeZ,
				horizontalScale, verticalScale, horizontalScale);
		this.roughShapeNoise2 = this.lperlinNoise2.generateNoiseOctaves(this.roughShapeNoise2, subchunkX, subchunkY, subchunkZ, sizeX, sizeY, sizeZ,
				horizontalScale, verticalScale, horizontalScale);

		// This bit of code serves to generate less on the top/bottom, more on the middle.
//		final double[] bufferY = new double[sizeY];
//		for (int y = 0; y < sizeY; ++y) {
//			bufferY[y] = Math.cos((y * Math.PI * 11.7) / sizeY) * 3.0D;
//			int distanceFromTop = y;
//
//			if (y > (sizeY / 2)) {
//				distanceFromTop = sizeY - 1 - y;
//			}
//
//			if (distanceFromTop < 4) {
//				distanceFromTop = 4 - distanceFromTop;
//				bufferY[y] -= distanceFromTop * distanceFromTop * distanceFromTop * 5;
//			}
//		}
		final double[] bufferY = { -317.0, -136.67246831802865, -41.135233150126936, -3.5617706971959024, -2.1408304632352535, -1.5512485534497107,
				2.755460957237769, -1.9210322149136752, 0.05543671487737954, 2.459221448721669, -1.797416688213068, 0.6598390735189857, 2.0617100579077876,
				-4.958602242060207, -38.7629310475783, -133.42070351136792, -322.9979511804291 };

		int index = 0;
		for (int x = 0; x < sizeX; ++x) {
			for (int z = 0; z < sizeZ; ++z) {
				final int cx = (subchunkX & 0xF) + x;
				final int cz = (subchunkZ & 0xF) + z;
				final int biomeIndex = (cx + cz << 4) & 0xFF;
				final double addedValue = this.generateValueForSubpos(x, z);
				final double bufferModificationTop = this.generateBufferModificationForSubpos(x, z);
				System.out.println(bufferModificationTop);
				for (int y = 0; y < sizeY; ++y) {
					final double roughValue1 = (this.roughShapeNoise1[index] / roughValueScaleDown) + decal;
					final double roughValue2 = (this.roughShapeNoise2[index] / roughValueScaleDown) + decal;
					final double switchValue = ((this.mainNoise[index] / 10.0D) + 1.0D) / 2.0D;
					double value;

					if (switchValue < 0.0D) {
						value = roughValue1;
					} else if (switchValue > 1.0D) {
						value = roughValue2;
					} else {
						value = roughValue1 + ((roughValue2 - roughValue1) * switchValue);
					}

					// Calculate top value.
					double valueToRemove = bufferY[y];
					int distanceFromTop = y;
					if (y > (sizeY / 2)) {
						distanceFromTop = sizeY - 1 - y;
					}
					if (distanceFromTop < 4) {
						valueToRemove = valueToRemove * bufferModificationTop;
					}

					value = value - valueToRemove;

					buffer[index] = value + addedValue;
					++index;
				}
			}
		}
		return buffer;
	}

	private double generateBufferModificationForSubpos(final int x, final int z) {
		double value = 0;
		for (int subX = 0; subX < 4; ++subX) {
			final int cx = (x << 2) + subX;
			for (int subZ = 0; subZ < 4; ++subZ) {
				final int cz = (z << 2) + subZ;

				final int biomeIndex = cx + (cz * 20);
				final Biome biome = this.biomesForHeights[biomeIndex];

				// Well tbh, no reason NOT to be a BiomeLOI.
				if (biome instanceof BiomeLOI) {
					final BiomeLOI biomeLoi = (BiomeLOI) biome;
					final double topCrazyness = biomeLoi.getTopCrazyness();
					value += (1 / topCrazyness) / (4 * 4);
				}
			}
		}
		return value;
	}

	private double generateValueForSubpos(final int x, final int z) {
		double value = 0;
		for (int subX = 0; subX < 4; ++subX) {
			final int cx = (x << 2) + subX;
			for (int subZ = 0; subZ < 4; ++subZ) {
				final int cz = (z << 2) + subZ;

				final int biomeIndex = cx + (cz * 20);
				final Biome biome = this.biomesForHeights[biomeIndex];

				// Well tbh, no reason NOT to be a BiomeLOI.
				if (biome instanceof BiomeLOI) {
					final BiomeLOI biomeLoi = (BiomeLOI) biome;
					if (biomeLoi.isVoid()) {
						value += 0.375d; // Note: the higher this value, the more rough the change between land & void.
					} else {
						final double density = biomeLoi.getDensity();
						value += (1 - density) / (4 * 4);
					}
				}
			}
		}
		return value;
	}

	/**
	 * This is what places the blocks INTO the surfaces generated above
	 */
	public void setBlocksInChunk(final int x, final int z, final ChunkPrimer primer) {
		this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, x * 16, z * 16, 16, 16, 0.0625D, 0.0625D, 1.0D);

		@SuppressWarnings("unused")
		int wx, wz;
		final float noiseLoam;
		float noiseYellowstone, noiseSilkstone, noiseSunstone, noiseVoidshale;
		final int loam_density;
		int yellowstone_density, silkstone_density, sunstone_density, voidshale_density;

		for (int cx = 0; cx < ChunkGeneratorLOI.CHUNK_WIDTH; cx++) {
			wx = (x * ChunkGeneratorLOI.CHUNK_WIDTH) + cx;
			for (int cz = 0; cz < ChunkGeneratorLOI.CHUNK_WIDTH; cz++) {
				final Biome biome = this.biomesForGeneration[cx + cz * 16];
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
				final int fillerBlockDensity = (int) ((noiseValue / 3.0D) + 3.0D + (this._rand.nextDouble() * 0.25D));
				IBlockState upperBlock = upperBlockPrimary;
				IBlockState topBlock = topBlockPrimary;
				IBlockState fillerBlock = fillerBlockPrimary;

				if (noiseValue > 1.75D) {
					upperBlock = upperBlockTertiary;
					topBlock = topBlockTertiary;
					fillerBlock = fillerBlockTertiary;
				} else if (noiseValue > 0.0D) {
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

				for (int cy = ChunkGeneratorLOI.CHUNK_HEIGHT; cy > 1; cy--) {
					IBlockState b = primer.getBlockState(cx, cy, cz);
					final IBlockState upper = primer.getBlockState(cx, cy + 1, cz);
					if ((b.getBlock() != Blocks.AIR) && (upper.getBlock() == Blocks.AIR)) {
						primer.setBlockState(cx, cy, cz, topBlock);
						if (upperBlock != null) {
							primer.setBlockState(cx, cy + 1, cz, upperBlock);
						}
						for (int gy = 1; gy < cy; gy++) {
							b = primer.getBlockState(cx, cy - gy, cz);
							if (b.getBlock() == Blocks.AIR) {
								break;
							}

							// /.\ Spaghetti code warning /.\
							if (gy < (3 + fillerBlockDensity)) {
								primer.setBlockState(cx, cy - gy, cz, fillerBlock);
							} else if ((cy - gy) > (84 - yellowstone_density)) {
								if (!this.placeExtraRock(cx, cz, wx, wz, cy - gy, primer, this.extraRocks0)) {
									primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.YELLOWSTONE);
								}
							} else if ((cy - gy) > (64 - silkstone_density)) {
								if (!this.placeExtraRock(cx, cz, wx, wz, cy - gy, primer, this.extraRocks1)) {
									primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.SILKSTONE);
								}
							} else if ((cy - gy) > (52 - sunstone_density)) {
								if (!this.placeExtraRock(cx, cz, wx, wz, cy - gy, primer, this.extraRocks2)) {
									primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.SUNSTONE);
								}
							} else if ((cy - gy) > (38 - voidshale_density)) {
								if (!this.placeExtraRock(cx, cz, wx, wz, cy - gy, primer, this.extraRocks3)) {
									primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.VOIDSHALE);
								}
							} else {
								if (!this.placeExtraRock(cx, cz, wx, wz, cy - gy, primer, this.extraRocks4)) {
									primer.setBlockState(cx, cy - gy, cz, ChunkGeneratorLOI.BAETYL);
								}
							}
							// /.\ End warning /.\
						}
					}
				}
				// this.oreGen.generate(cx, cz, wx, wz, primer);
			}
		}
	}

	float extraRockDesity = 0.5f;
	float extraRockWidth = 50.0f;
	float extraRockHeight = 10.0f;

	public IBlockState[] extraRocks0 = new IBlockState[] { ChunkGeneratorLOI.SILKSTONE, ChunkGeneratorLOI.SILKSTONE, ChunkGeneratorLOI.SILKSTONE,
			ChunkGeneratorLOI.SILKSTONE };
	public IBlockState[] extraRocks1 = new IBlockState[] { ChunkGeneratorLOI.SUNSTONE, ChunkGeneratorLOI.SUNSTONE, ChunkGeneratorLOI.YELLOWSTONE,
			ChunkGeneratorLOI.YELLOWSTONE };
	public IBlockState[] extraRocks2 = new IBlockState[] { ChunkGeneratorLOI.VOIDSHALE, ChunkGeneratorLOI.SILKSTONE, ChunkGeneratorLOI.SILKSTONE,
			ChunkGeneratorLOI.YELLOWSTONE };
	public IBlockState[] extraRocks3 = new IBlockState[] { ChunkGeneratorLOI.BAETYL, ChunkGeneratorLOI.SUNSTONE, ChunkGeneratorLOI.SILKSTONE,
			ChunkGeneratorLOI.YELLOWSTONE };
	public IBlockState[] extraRocks4 = new IBlockState[] { ChunkGeneratorLOI.VOIDSHALE, ChunkGeneratorLOI.SUNSTONE, ChunkGeneratorLOI.SILKSTONE,
			ChunkGeneratorLOI.YELLOWSTONE };

	public boolean placeExtraRock(final int x, final int z, final int wx, final int wz, final int y, final ChunkPrimer primer, final IBlockState[] extraRocks) {
		if (this.perlin.noise3((wx + 3000) / this.extraRockWidth, (y + 3000) / this.extraRockHeight,
				(wz + 3000) / this.extraRockWidth) > this.extraRockDesity) {
			primer.setBlockState(x, y, z, extraRocks[0]);
			return true;
		}
		if (this.perlin.noise3((wx + 2000) / this.extraRockWidth, (y + 2000) / this.extraRockHeight,
				(wz + 2000) / this.extraRockWidth) > this.extraRockDesity) {
			primer.setBlockState(x, y, z, extraRocks[1]);
			return true;
		}
		if (this.perlin.noise3((wx + 1000) / this.extraRockWidth, (y + 1000) / this.extraRockHeight,
				(wz + 1000) / this.extraRockWidth) > this.extraRockDesity) {
			primer.setBlockState(x, y, z, extraRocks[2]);
			return true;
		}
		if (this.perlin.noise3(wx / this.extraRockWidth, y / this.extraRockHeight, wz / this.extraRockWidth) > this.extraRockDesity) {
			primer.setBlockState(x, y, z, extraRocks[3]);
			return true;
		}
		return false;
	}

	/**
	 * Used to generate decorations. It is called after terrain generation.
	 */
	@Override
	public void populate(final int x, final int z) {
		BlockFalling.fallInstantly = true;
		net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this._world, this._rand, x, z, false);
		final int i = x * 16;
		final int j = z * 16;
		final BlockPos blockpos = new BlockPos(i, 0, j);
		final Biome biome = this._world.getBiome(blockpos.add(16, 0, 16));
		final ChunkPos chunkpos = new ChunkPos(x, z);

		// GENERATE DECORATIONS HERE.
		biome.decorate(this._world, this._rand, new BlockPos(i, 0, j));

		net.minecraftforge.common.MinecraftForge.EVENT_BUS
				.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(this._world, this._rand, blockpos));

		WorldEntitySpawner.performWorldGenSpawning(this._world, biome, i + 8, j + 8, 16, 16, this._rand);

		BlockFalling.fallInstantly = false;
	}

	@Override
	public boolean generateStructures(final Chunk chunkIn, final int x, final int z) {
		return false;
	}

	/**
	 * Create a list of the possible creatures to spawn in this dimension.
	 */
	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType creatureType, final BlockPos pos) {
		final Biome biome = this._world.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}

	@Override
	public void recreateStructures(final Chunk chunkIn, final int x, final int z) {
	}

	@Override
	public BlockPos getNearestStructurePos(final World worldIn, final String structureName, final BlockPos position, final boolean findUnexplored) {
		return null;
	}

	@Override
	public boolean isInsideStructure(final World worldIn, final String structureName, final BlockPos pos) {
		return false;
	}
}
