package com.axanthic.icaria.common.world.gen;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.StreamSupport;

import com.axanthic.icaria.data.tags.IcariaBiomeTags;
import com.axanthic.icaria.common.registry.IcariaBiomes;
import com.axanthic.icaria.common.registry.IcariaBiomes.BiomeConfiguration;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.world.carver.configuration.TopBlockCarverConfiguration;
import com.axanthic.icaria.common.world.noise.CellNoise;
import com.axanthic.icaria.common.world.noise.NoiseGeneratorOctaves;
import com.axanthic.icaria.common.world.noise.NoiseGeneratorPerlin;
import com.axanthic.icaria.common.world.noise.PerlinNoise;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.RandomSupport;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;

public class IcariaChunkGenerator extends NoiseBasedChunkGenerator {

	/*****************************************************************/
	/// CODECS
	/*****************************************************************/

	// TODO: use to add custom settings
	private static final Codec<IcariaGeneratorSettings> SETTINGS_CODEC = RecordCodecBuilder.create(instance -> instance
			.group(Codec.INT.fieldOf("base").forGetter(IcariaGeneratorSettings::baseHeight),
					Codec.FLOAT.fieldOf("verticalvariance").forGetter(IcariaGeneratorSettings::verticalVariance),
					Codec.FLOAT.fieldOf("horizontalvariance").forGetter(IcariaGeneratorSettings::horizontalVariance))
			.apply(instance, IcariaGeneratorSettings::new));

	// TODO: Somehow the settings are not accepted by compiler
	// SETTINGS_CODEC.fieldOf("settings").forGetter(c -> c.settings))
	public static final Codec<IcariaChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(BiomeSource.CODEC.fieldOf("biome_source").forGetter(c -> c.biomeSource),
					NoiseGeneratorSettings.CODEC.fieldOf("noiseSettings").forGetter(c -> c.noiseSettings))
			.apply(instance, instance.stable(IcariaChunkGenerator::new)));

	/*****************************************************************/
	/// CONSTANTS
	/*****************************************************************/

	protected static final BlockState AIR = Blocks.AIR.defaultBlockState();
	protected static final BlockState MAIN_BLOCK = IcariaBlocks.BAETYL.get().defaultBlockState();

	protected static final BlockState YELLOWSTONE = IcariaBlocks.YELLOWSTONE.get().defaultBlockState();
	protected static final BlockState SILKSTONE = IcariaBlocks.SILKSTONE.get().defaultBlockState();
	protected static final BlockState SUNSTONE = IcariaBlocks.SUNSTONE.get().defaultBlockState();
	protected static final BlockState VOIDSHALE = IcariaBlocks.VOIDSHALE.get().defaultBlockState();
	protected static final BlockState BAETYL = IcariaBlocks.BAETYL.get().defaultBlockState();

	protected static final BlockState MARLGRASS = IcariaBlocks.GRASSY_MARL.get().defaultBlockState();
	protected static final BlockState LOAM = IcariaBlocks.LOAM.get().defaultBlockState();
	protected static final BlockState MARL = IcariaBlocks.MARL.get().defaultBlockState();
	protected static final BlockState MARL_COARSE = IcariaBlocks.COARSE_MARL.get().defaultBlockState();

	protected static final BlockState BEDROCK = Blocks.BEDROCK.defaultBlockState();

	protected static float extraRockDensity = 0.5f;
	protected static float extraRockWidth = 50.0f;
	protected static float extraRockHeight = 10.0f;
	protected static BlockState[] extraRocks0 = new BlockState[] { SILKSTONE, SILKSTONE, SILKSTONE, SILKSTONE };
	protected static BlockState[] extraRocks1 = new BlockState[] { SUNSTONE, SUNSTONE, YELLOWSTONE, YELLOWSTONE };
	protected static BlockState[] extraRocks2 = new BlockState[] { VOIDSHALE, SILKSTONE, SILKSTONE, YELLOWSTONE };
	protected static BlockState[] extraRocks3 = new BlockState[] { BAETYL, SUNSTONE, SILKSTONE, YELLOWSTONE };
	protected static BlockState[] extraRocks4 = new BlockState[] { VOIDSHALE, SUNSTONE, SILKSTONE, YELLOWSTONE };

	private static final int CHUNK_WIDTH = 16;
	public static final int CHUNK_HEIGHT = 256;

	/*****************************************************************/
	/// REFERENCES
	/*****************************************************************/

	private Random _rand;
	private PerlinNoise perlin;
	private CellNoise cell;
	private NoiseGeneratorOctaves octaveNoise;
	private NoiseGeneratorOctaves lperlinNoise1;
	private NoiseGeneratorOctaves lperlinNoise2;
	private NoiseGeneratorPerlin surfaceNoise;

	/*****************************************************************/
	/// PRIVATE VARIABLES
	/*****************************************************************/

	private final Holder<IcariaGeneratorSettings> settings;
	private final Holder<NoiseGeneratorSettings> noiseSettings;

	private TopBlockCarverConfiguration[] topBlockConfigurations;
	private BiomeConfiguration[] biomeConfiguration;
	private Holder<Biome>[] biomesForGeneration;
	private Holder<Biome>[] biomesForHeights;
	private double[] buffer;
	private double[] depthBuffer = new double[256];
	private double[] mainNoise;
	private double[] roughShapeNoise1;
	private double[] roughShapeNoise2;

	// TODO: final Holder<IcariaGeneratorSettings> settings
	public IcariaChunkGenerator(final BiomeSource biomeSource, final Holder<NoiseGeneratorSettings> noiseSettings) {
		super(biomeSource, noiseSettings); // , settings, new StructureSettings(false)
		this.settings = null; // settings
		this.noiseSettings = noiseSettings;
	}

	@Override
	public int getMinY() {
		return 0;
	}

	@Override
	public int getGenDepth() {
		return 256;
	}

	@Override
	public int getSeaLevel() {
		return 63;
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		return IcariaChunkGenerator.CODEC;
	}

	@Override
	public CompletableFuture<ChunkAccess> fillFromNoise(final Executor executor, final Blender blender,
			final RandomState random, final StructureManager structureManager, final ChunkAccess chunkAccess) {
		return CompletableFuture.completedFuture(chunkAccess);
	}

	// Used by structures and features
	// TODO: implement correctly.
	@Override
	public int getBaseHeight(final int x, final int z, final Heightmap.Types types,
			final LevelHeightAccessor levelHeightAccessor, final RandomState random) {
		return this.getSeaLevel();
	}

	// Used by structures and features
	// TODO: implement correctly.
	@Override
	public NoiseColumn getBaseColumn(final int x, final int z, final LevelHeightAccessor levelHeightAccessor,
			final RandomState random) {
		final int y = this.getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, levelHeightAccessor, random);
		final BlockState stone = Blocks.STONE.defaultBlockState();
		final BlockState[] states = new BlockState[y];
		states[0] = Blocks.BEDROCK.defaultBlockState();
		for (int i = 1; i < y; i++) {
			states[i] = stone;
		}
		return new NoiseColumn(levelHeightAccessor.getMinBuildHeight(), states);
	}

	@Override
	public void applyCarvers(final WorldGenRegion level, final long seed, final RandomState random,
			final BiomeManager biomeManager, final StructureManager structureManager, final ChunkAccess chunkAccess,
			final GenerationStep.Carving carving) {
		// Used with NoiseBasedChunkGenerator, keep empty (probably used for caves).
	}

	// This makes sure passive mob spawning works for generated chunks. i.e. mobs
	// that spawn during the creation of chunks themselves
	@Override
	public void spawnOriginalMobs(final WorldGenRegion level) {
		final ChunkPos chunkpos = level.getCenter();
		final Holder<Biome> biome = level.getBiome(chunkpos.getWorldPosition().atY(level.getMaxBuildHeight() - 1));
		final WorldgenRandom worldgenRandom = new WorldgenRandom(
				new LegacyRandomSource(RandomSupport.generateUniqueSeed()));
		worldgenRandom.setDecorationSeed(level.getSeed(), chunkpos.getMinBlockX(), chunkpos.getMinBlockZ());
		NaturalSpawner.spawnMobsForChunkGeneration(level, biome, chunkpos, worldgenRandom);
	}

	@Override
	public void addDebugScreenInfo(final List<String> pInfo, final RandomState pRandom, final BlockPos pPos) {
		// Probably used for debugging
	}

	@Override
	public void buildSurface(final WorldGenRegion region, final StructureManager featureManager,
			final RandomState random, final ChunkAccess chunk) {
		final long seed = region.getSeed();

		// Init random.
		this._rand = new Random(seed);

		// Init noise generators
		this.lperlinNoise1 = new NoiseGeneratorOctaves(this._rand, 12);
		this.lperlinNoise2 = new NoiseGeneratorOctaves(this._rand, 12);
		this.octaveNoise = new NoiseGeneratorOctaves(this._rand, 8);
		this.surfaceNoise = new NoiseGeneratorPerlin(this._rand, 4);

		// Init perlin and cell noise
		this.cell = new CellNoise(seed, (short) 0);
		this.cell.setUseDistance(true);
		this.perlin = new PerlinNoise(seed);

		// Get pos
		final ChunkPos chunkpos = chunk.getPos();
		final int x = chunkpos.x;
		final int z = chunkpos.z;

		// Set rand seed.
		this._rand.setSeed(x * 341873128712L + z * 132897987541L);

		// Compute biomes
		final BiomeManager biomemanager = region.getBiomeManager()
				.withDifferentSource((bx, by, bz) -> this.biomeSource.getNoiseBiome(bx, by, bz, random.sampler()));
		this.calculateBiomesForGeneration(region.getBiomeManager(), chunkpos.getMinBlockX() - 2,
				chunkpos.getMinBlockZ() - 2, 20, 20);
		this.calculateBiomesForGeneration();

		// Prepare heights.
		this.prepareHeights(x, z, chunk);

		// Set blocks.
		this.setBlocksInChunk(x, z, chunk);
	}

	private void calculateBiomesForGeneration(final BiomeManager manager, final int wx, final int wz, final int sizeX,
			final int sizeZ) {
		this.biomesForHeights = new Holder[sizeX * sizeZ];
		this.biomeConfiguration = new BiomeConfiguration[sizeX * sizeZ];
		final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		for (int cx = 0; cx < sizeX; cx++) {
			for (int cz = 0; cz < sizeZ; cz++) {
				final int biomeIndex = cx + cz * sizeZ;

				final Holder<Biome> biome = manager.getBiome(pos.set(wx + cx, 0, wz + cz));
				this.biomesForHeights[biomeIndex] = biome;
				this.biomeConfiguration[biomeIndex] = IcariaBiomes.configurations.get(biome.unwrapKey().get());
			}
		}
	}

	/**
	 * This just fills the "biomesForGeneration" array of the chunk from the other
	 * bigger array instead of recalculating it (basically an optimization).
	 */
	private void calculateBiomesForGeneration() {
		this.biomesForGeneration = new Holder[CHUNK_WIDTH * CHUNK_WIDTH];
		this.topBlockConfigurations = new TopBlockCarverConfiguration[CHUNK_WIDTH * CHUNK_WIDTH];
		for (int cx = 2; cx < 18; cx++) {
			for (int cz = 2; cz < 18; cz++) {
				final int biomeIndex = cx - 2 + (cz - 2 << 4);

				final Holder<Biome> biome = this.biomesForHeights[cx + cz * 20];
				this.biomesForGeneration[biomeIndex] = biome;
				this.topBlockConfigurations[biomeIndex] = StreamSupport
						.stream(biome.get().getGenerationSettings().getCarvers(GenerationStep.Carving.AIR)
								.spliterator(), false)
						.map(Holder::get).map(ConfiguredWorldCarver::config)
						.filter(config -> config instanceof TopBlockCarverConfiguration)
						.map(c -> (TopBlockCarverConfiguration) c).findFirst()
						.orElseThrow(() -> new IllegalArgumentException("Please add a carver for the biome: " + biome));
			}
		}
	}

	private void prepareHeights(final int x, final int z, final ChunkAccess chunk) {
		final int seaLevel = this.getSeaLevel() / 2 + 1;

		final int subChunkWidth = 4;

		final int sizeX = subChunkWidth + 1;
		final int sizeY = 17;
		final int sizeZ = subChunkWidth + 1;

		final double heightCoeff = 0.125d; // (sizeY - 1.0) / (ChunkGeneratorLOI.CHUNK_HEIGHT / 2.0)
		final double widthCoeff = 0.25d; // subChunkWidth / ChunkGeneratorLOI.CHUNK_WIDTH
		final double bottomSmoothValue = 1d;

		this.buffer = this.getHeights(this.buffer, x * subChunkWidth, 0, z * subChunkWidth, sizeX, sizeY, sizeZ);

		final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		for (int subChunkX = 0; subChunkX < subChunkWidth; ++subChunkX) {
			for (int subChunkZ = 0; subChunkZ < subChunkWidth; ++subChunkZ) {
				for (int subChunkY = 0; subChunkY < sizeY - 1; ++subChunkY) {
					double valueOrigin = this.buffer[((subChunkX + 0) * sizeZ + subChunkZ + 0) * sizeY + subChunkY + 0]
							* bottomSmoothValue;
					double valueSouth = this.buffer[((subChunkX + 0) * sizeZ + subChunkZ + 1) * sizeY + subChunkY + 0]
							* bottomSmoothValue;
					double valueEast = this.buffer[((subChunkX + 1) * sizeZ + subChunkZ + 0) * sizeY + subChunkY + 0]
							* bottomSmoothValue;
					double valueSouthEast = this.buffer[((subChunkX + 1) * sizeZ + subChunkZ + 1) * sizeY + subChunkY
							+ 0] * bottomSmoothValue;
					final double valueUp = (this.buffer[((subChunkX + 0) * sizeZ + subChunkZ + 0) * sizeY + subChunkY
							+ 1] - valueOrigin) * heightCoeff;
					final double valueUpSouth = (this.buffer[((subChunkX + 0) * sizeZ + subChunkZ + 1) * sizeY
							+ subChunkY + 1] - valueSouth) * heightCoeff;
					final double valueUpEast = (this.buffer[((subChunkX + 1) * sizeZ + subChunkZ + 0) * sizeY
							+ subChunkY + 1] - valueEast) * heightCoeff;
					final double valueUpSouthEast = (this.buffer[((subChunkX + 1) * sizeZ + subChunkZ + 1) * sizeY
							+ subChunkY + 1] - valueSouthEast) * heightCoeff;

					for (int subY = 0; subY < 8; ++subY) {
						double valueSmoothX = valueOrigin;
						double valueSmoothZ = valueSouth;
						final double proportionX = (valueEast - valueOrigin) * widthCoeff;
						final double proportionXZ = (valueSouthEast - valueSouth) * widthCoeff;

						for (int subX = 0; subX < 4; ++subX) {
							double valueSmoothed = valueSmoothX;
							final double proportionZ = (valueSmoothZ - valueSmoothX) * widthCoeff;

							for (int subZ = 0; subZ < 4; ++subZ) {
								BlockState block = AIR;

								if (valueSmoothed < 0.0D) {
									block = MAIN_BLOCK;
								}

								final int cx = subX + subChunkX * 4;
								final int cy = subY + subChunkY * 8;
								final int cz = subZ + subChunkZ * 4;
								chunk.setBlockState(pos.set(cx, cy, cz), block, false);
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
	private double[] getHeights(double[] buffer, final int subchunkX, final int subchunkY, final int subchunkZ,
			final int sizeX, final int sizeY, final int sizeZ) {
		if (buffer == null) {
			buffer = new double[sizeX * sizeY * sizeZ];
		}

		// If you want to change the gen, modify these three values.
		// Horizontal & vertical scale correspond to the frequency of the noise (roughly
		// the shape of the islands)
		// The third value is the scale down on the noise, the higher the more squished
		// the islands will get.
		final double horizontalScale = 45D; // multiply by 4 for the numbers of blocks
		final double verticalScale = 11D; // multiply by 8 for the number of blocks
		final double roughValueScaleDown = 100.0D;
		final double decal = 0.0D;

		// Note: noise values goes from -2^octaves to 2^octaves (aka 256 & 65536) though
		// it is very unlikely to go past 32000 even.
		this.mainNoise = this.octaveNoise.generateNoiseOctaves(this.mainNoise, subchunkX, subchunkY, subchunkZ, sizeX,
				sizeY, sizeZ, 8.555150000000001D, 34.2206D, 8.555150000000001D);
		this.roughShapeNoise1 = this.lperlinNoise1.generateNoiseOctaves(this.roughShapeNoise1, subchunkX, subchunkY,
				subchunkZ, sizeX, sizeY, sizeZ, horizontalScale, verticalScale, horizontalScale);
		this.roughShapeNoise2 = this.lperlinNoise2.generateNoiseOctaves(this.roughShapeNoise2, subchunkX, subchunkY,
				subchunkZ, sizeX, sizeY, sizeZ, horizontalScale, verticalScale, horizontalScale);

		// This bit of code serves to generate less on the top/bottom, more on the
		// middle.
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
		final double[] bufferY = { -317.0, -136.67246831802865, -41.135233150126936, -3.5617706971959024,
				-2.1408304632352535, -1.5512485534497107, 2.755460957237769, -1.9210322149136752, 0.05543671487737954,
				2.459221448721669, -1.797416688213068, 0.6598390735189857, 2.0617100579077876, -4.958602242060207,
				-38.7629310475783, -133.42070351136792, -322.9979511804291 };

		int index = 0;
		for (int x = 0; x < sizeX; ++x) {
			for (int z = 0; z < sizeZ; ++z) {
				final int cx = (subchunkX & 0xF) + x;
				final int cz = (subchunkZ & 0xF) + z;
				final int biomeIndex = cx + cz << 4 & 0xFF;
				final double addedValue = this.generateValueForSubpos(x, z);
				final double bufferModificationTop = this.generateBufferModificationForSubpos(x, z);
				for (int y = 0; y < sizeY; ++y) {
					final double roughValue1 = this.roughShapeNoise1[index] / roughValueScaleDown + decal;
					final double roughValue2 = this.roughShapeNoise2[index] / roughValueScaleDown + decal;
					final double switchValue = (this.mainNoise[index] / 10.0D + 1.0D) / 2.0D;
					double value;

					if (switchValue < 0.0D) {
						value = roughValue1;
					} else if (switchValue > 1.0D) {
						value = roughValue2;
					} else {
						value = roughValue1 + (roughValue2 - roughValue1) * switchValue;
					}

					// Calculate top value.
					double valueToRemove = bufferY[y];
					int distanceFromTop = y;
					if (y > sizeY / 2) {
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

	private double generateValueForSubpos(final int x, final int z) {
		double value = 0;
		for (int subX = 0; subX < 4; ++subX) {
			final int cx = (x << 2) + subX;
			for (int subZ = 0; subZ < 4; ++subZ) {
				final int cz = (z << 2) + subZ;

				final int biomeIndex = cx + cz * 20;
				final Holder<Biome> biome = this.biomesForHeights[biomeIndex];
				final BiomeConfiguration configuration = this.biomeConfiguration[biomeIndex];

				if (biome.containsTag(IcariaBiomeTags.IS_VOID)) {
					value += 0.375d; // Note: the higher this value, the more rough the change between land & void.
				} else {
					final double density = configuration.pDensity();
					value += (1 - density) / (4 * 4);
				}

			}
		}
		return value;
	}

	private double generateBufferModificationForSubpos(final int x, final int z) {
		double value = 0;
		for (int subX = 0; subX < 4; ++subX) {
			final int cx = (x << 2) + subX;
			for (int subZ = 0; subZ < 4; ++subZ) {
				final int cz = (z << 2) + subZ;
				final int biomeIndex = cx + cz * 20;
				final BiomeConfiguration configuration = this.biomeConfiguration[biomeIndex];
				final double topCrazyness = configuration.pCraziness();
				value += 1 / topCrazyness / (4 * 4);
			}
		}
		return value;
	}

	/**
	 * This is what places the blocks INTO the surfaces generated above
	 */
	private void setBlocksInChunk(final int x, final int z, final ChunkAccess chunk) {
		this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, x * 16, z * 16, 16, 16, 0.0625D, 0.0625D,
				1.0D);

		@SuppressWarnings("unused")
		int wx;
		@SuppressWarnings("unused")
		int wz;
		final float noiseLoam;
		float noiseYellowstone, noiseSilkstone, noiseSunstone, noiseVoidshale;
		final int loam_density;
		int yellowstone_density, silkstone_density, sunstone_density, voidshale_density;

		final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		for (int cx = 0; cx < CHUNK_WIDTH; cx++) {
			wx = x * CHUNK_WIDTH + cx;
			for (int cz = 0; cz < CHUNK_WIDTH; cz++) {
				final TopBlockCarverConfiguration config = this.topBlockConfigurations[cx + cz * 16];
				final BlockState upperBlockPrimary = config.upperBlockPrimary.orElse(null);
				final BlockState upperBlockSecondary = config.upperBlockSecondary.orElse(null);
				final BlockState upperBlockTertiary = config.upperBlockTertiary.orElse(null);
				final BlockState topBlockPrimary = config.topBlockPrimary;
				final BlockState topBlockSecondary = config.topBlockSecondary;
				final BlockState topBlockTertiary = config.topBlockTertiary;
				final BlockState fillerBlockPrimary = config.fillerBlockPrimary;
				final BlockState fillerBlockSecondary = config.fillerBlockSecondary;
				final BlockState fillerBlockTertiary = config.fillerBlockTertiary;

				wz = z * CHUNK_WIDTH + cz;

				final double noiseValue = this.depthBuffer[cx + cz * 16];
				final int fillerBlockDensity = (int) (noiseValue / 3.0D + 3.0D + this._rand.nextDouble() * 0.25D);
				BlockState upperBlock = upperBlockPrimary;
				BlockState topBlock = topBlockPrimary;
				BlockState fillerBlock = fillerBlockPrimary;

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

				yellowstone_density = noiseYellowstone <= 0f ? fillerBlockDensity
						: (int) (noiseYellowstone * 3f) + fillerBlockDensity;
				silkstone_density = noiseSilkstone <= 0f ? yellowstone_density
						: (int) (noiseSilkstone * 4f) + yellowstone_density;
				sunstone_density = noiseSunstone <= 0f ? silkstone_density
						: (int) (noiseSunstone * 4f) + silkstone_density;
				voidshale_density = noiseVoidshale <= 0f ? sunstone_density
						: (int) (noiseVoidshale * 5f) + sunstone_density;

				for (int cy = CHUNK_HEIGHT; cy > 1; cy--) {
					BlockState b = chunk.getBlockState(pos.set(cx, cy, cz));
					final BlockState upper = chunk.getBlockState(pos.set(cx, cy + 1, cz));
					if (b.getBlock() != Blocks.AIR && upper.getBlock() == Blocks.AIR) {
						chunk.setBlockState(pos.set(cx, cy, cz), topBlock, false);
						if (upperBlock != null) {
							chunk.setBlockState(pos.set(cx, cy + 1, cz), upperBlock, false);
						}
						for (int gy = 1; gy < cy; gy++) {
							b = chunk.getBlockState(pos.set(cx, cy - gy, cz));
							if (b.getBlock() == Blocks.AIR) {
								break;
							}

							// /.\ Spaghetti code warning /.\
							if (gy < 3 + fillerBlockDensity) {
								chunk.setBlockState(pos.set(cx, cy - gy, cz), fillerBlock, false);
							} else if (cy - gy > 84 - yellowstone_density) {
								if (!this.placeExtraRock(pos, cx, cz, wx, wz, cy - gy, chunk, extraRocks0)) {
									chunk.setBlockState(pos.set(cx, cy - gy, cz), YELLOWSTONE, false);
								}
							} else if (cy - gy > 64 - silkstone_density) {
								if (!this.placeExtraRock(pos, cx, cz, wx, wz, cy - gy, chunk, extraRocks1)) {
									chunk.setBlockState(pos.set(cx, cy - gy, cz), SILKSTONE, false);
								}
							} else if (cy - gy > 52 - sunstone_density) {
								if (!this.placeExtraRock(pos, cx, cz, wx, wz, cy - gy, chunk, extraRocks2)) {
									chunk.setBlockState(pos.set(cx, cy - gy, cz), SUNSTONE, false);
								}
							} else if (cy - gy > 38 - voidshale_density) {
								if (!this.placeExtraRock(pos, cx, cz, wx, wz, cy - gy, chunk, extraRocks3)) {
									chunk.setBlockState(pos.set(cx, cy - gy, cz), VOIDSHALE, false);
								}
							} else if (!this.placeExtraRock(pos, cx, cz, wx, wz, cy - gy, chunk, extraRocks4)) {
								chunk.setBlockState(pos.set(cx, cy - gy, cz), BAETYL, false);
							}
						}
					}
				}
				// this.oreGen.generate(cx, cz, wx, wz, primer);
			}
		}
	}

	private boolean placeExtraRock(final BlockPos.MutableBlockPos pos, final int x, final int z, final int wx,
			final int wz, final int y, final ChunkAccess chunk, final BlockState[] extraRocks) {
		if (this.perlin.noise3((wx + 3000) / extraRockWidth, (y + 3000) / extraRockHeight,
				(wz + 3000) / extraRockWidth) > extraRockDensity) {
			chunk.setBlockState(pos.set(x, y, z), extraRocks[0], false);
			return true;
		}
		if (this.perlin.noise3((wx + 2000) / extraRockWidth, (y + 2000) / extraRockHeight,
				(wz + 2000) / extraRockWidth) > extraRockDensity) {
			chunk.setBlockState(pos.set(x, y, z), extraRocks[1], false);
			return true;
		}
		if (this.perlin.noise3((wx + 1000) / extraRockWidth, (y + 1000) / extraRockHeight,
				(wz + 1000) / extraRockWidth) > extraRockDensity) {
			chunk.setBlockState(pos.set(x, y, z), extraRocks[2], false);
			return true;
		}
		if (this.perlin.noise3(wx / extraRockWidth, y / this.extraRockHeight, wz / extraRockWidth) > extraRockDensity) {
			chunk.setBlockState(pos.set(x, y, z), extraRocks[3], false);
			return true;
		}
		return false;
	}
}