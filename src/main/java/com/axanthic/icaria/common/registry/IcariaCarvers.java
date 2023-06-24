package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.carver.TopBlockWorldCarver;
import com.axanthic.icaria.common.world.carver.configuration.TopBlockCarverConfiguration;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;
import java.util.function.Supplier;

public class IcariaCarvers {
	public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(Registries.CARVER, IcariaInfo.ID);

	/***********************************************************************************************/
	// REGISTER
	/***********************************************************************************************/

	public static final RegistryObject<WorldCarver<TopBlockCarverConfiguration>> VOID_TB = register("void_top_blocks",
			() -> new TopBlockWorldCarver(TopBlockCarverConfiguration.CODEC));

	public static final RegistryObject<WorldCarver<TopBlockCarverConfiguration>> SCRUBLAND_TB = register(
			"scrubland_top_blocks", () -> new TopBlockWorldCarver(TopBlockCarverConfiguration.CODEC));

	public static final RegistryObject<WorldCarver<TopBlockCarverConfiguration>> DESERT_TB = register(
			"desert_top_blocks", () -> new TopBlockWorldCarver(TopBlockCarverConfiguration.CODEC));

	public static final RegistryObject<WorldCarver<TopBlockCarverConfiguration>> FOREST_TB = register(
			"forest_top_blocks", () -> new TopBlockWorldCarver(TopBlockCarverConfiguration.CODEC));

	public static final RegistryObject<WorldCarver<TopBlockCarverConfiguration>> STEPPE_TB = register(
			"steppe_top_blocks", () -> new TopBlockWorldCarver(TopBlockCarverConfiguration.CODEC));

	private static <C extends CarverConfiguration, F extends WorldCarver<C>> RegistryObject<F> register(
			final String key, final Supplier<F> carverSupplier) {
		return CARVERS.register(key, carverSupplier);
	}

	/***********************************************************************************************/
	// KEY
	/***********************************************************************************************/

	public static final ResourceKey<ConfiguredWorldCarver<?>> VOID_TB_KEY = createKey("void_top_blocks");
	public static final ResourceKey<ConfiguredWorldCarver<?>> SCRUBLAND_TB_KEY = createKey("scrubland_top_blocks");
	public static final ResourceKey<ConfiguredWorldCarver<?>> DESERT_TB_KEY = createKey("desert_top_blocks");
	public static final ResourceKey<ConfiguredWorldCarver<?>> FOREST_TB_KEY = createKey("forest_top_blocks");
	public static final ResourceKey<ConfiguredWorldCarver<?>> STEPPE_TB_KEY = createKey("steppe_top_blocks");

	private static ResourceKey<ConfiguredWorldCarver<?>> createKey(final String name) {
		return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(IcariaInfo.ID, name));
	}

	/**
	 * Carver configuration is useless anyway for custom ones (yet)...
	 *
	 * @param context
	 * @return
	 */
	protected static CarverConfiguration defaultConfiguration(final BootstapContext<ConfiguredWorldCarver<?>> context) {
		final HolderGetter<Block> blockGetter = context.lookup(Registries.BLOCK);
		final HeightProvider height = UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(67));
		final CarverDebugSettings debug = CarverDebugSettings.of(false, Blocks.WARPED_BUTTON.defaultBlockState());
		return new CarverConfiguration(0, height, ConstantFloat.of(0.0F), VerticalAnchor.aboveBottom(8), debug,
				blockGetter.getOrThrow(BlockTags.OVERWORLD_CARVER_REPLACEABLES));
	}

	/***********************************************************************************************/
	// BOOTSTRAP
	/***********************************************************************************************/

	public static void bootstrap(final BootstapContext<ConfiguredWorldCarver<?>> context) {
		registerVoidTopBlocksCarver(context);
		registerScrublandTopBlocksCarver(context);
		registerDesertTopBlocksCarver(context);
		registerForestTopBlocksCarver(context);
		registerSteppeTopBlocksCarver(context);
	}

	protected static void registerVoidTopBlocksCarver(final BootstapContext<ConfiguredWorldCarver<?>> context) {
		final HolderGetter<Block> blockGetter = context.lookup(Registries.BLOCK);

		final CarverConfiguration configuration = defaultConfiguration(context);
		final BlockState topBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
		final BlockState topBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();

		final Optional<BlockState> upperBlockPrimary = Optional.empty();
		final Optional<BlockState> upperBlockSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
		final Optional<BlockState> upperBlockTertiary = Optional.empty();
		final BlockState topBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		final BlockState fillerBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		context.register(VOID_TB_KEY,
				VOID_TB.get()
						.configured(new TopBlockCarverConfiguration(configuration, topBlockPrimary, fillerBlockPrimary,
								topBlockSecondary, fillerBlockSecondary, upperBlockPrimary, upperBlockSecondary,
								upperBlockTertiary, topBlockTertiary, fillerBlockTertiary)));
	}

	protected static void registerScrublandTopBlocksCarver(final BootstapContext<ConfiguredWorldCarver<?>> context) {
		final HolderGetter<Block> blockGetter = context.lookup(Registries.BLOCK);

		final CarverConfiguration configuration = defaultConfiguration(context);
		final BlockState topBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
		final BlockState topBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();

		final Optional<BlockState> upperBlockPrimary = Optional.empty();
		final Optional<BlockState> upperBlockSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
		final Optional<BlockState> upperBlockTertiary = Optional.empty();
		final BlockState topBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		final BlockState fillerBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		context.register(SCRUBLAND_TB_KEY,
				SCRUBLAND_TB.get()
						.configured(new TopBlockCarverConfiguration(configuration, topBlockPrimary, fillerBlockPrimary,
								topBlockSecondary, fillerBlockSecondary, upperBlockPrimary, upperBlockSecondary,
								upperBlockTertiary, topBlockTertiary, fillerBlockTertiary)));
	}

	protected static void registerDesertTopBlocksCarver(final BootstapContext<ConfiguredWorldCarver<?>> context) {
		final HolderGetter<Block> blockGetter = context.lookup(Registries.BLOCK);

		final CarverConfiguration configuration = defaultConfiguration(context);
		final BlockState topBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.GRAINEL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.GRAINEL.getKey()).get().defaultBlockState();
		final BlockState topBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.SILKSAND.getKey()).get().defaultBlockState();
		final BlockState fillerBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.SILKSAND.getKey()).get().defaultBlockState();

		final Optional<BlockState> upperBlockPrimary = Optional.empty();
		final Optional<BlockState> upperBlockSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
		final Optional<BlockState> upperBlockTertiary = Optional.empty();
		final BlockState topBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		final BlockState fillerBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		context.register(DESERT_TB_KEY,
				DESERT_TB.get()
						.configured(new TopBlockCarverConfiguration(configuration, topBlockPrimary, fillerBlockPrimary,
								topBlockSecondary, fillerBlockSecondary, upperBlockPrimary, upperBlockSecondary,
								upperBlockTertiary, topBlockTertiary, fillerBlockTertiary)));
	}

	protected static void registerForestTopBlocksCarver(final BootstapContext<ConfiguredWorldCarver<?>> context) {
		final HolderGetter<Block> blockGetter = context.lookup(Registries.BLOCK);

		final CarverConfiguration configuration = defaultConfiguration(context);
		final BlockState topBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
		final BlockState topBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();

		final Optional<BlockState> upperBlockPrimary = Optional.empty();
		final Optional<BlockState> upperBlockSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
		final Optional<BlockState> upperBlockTertiary = Optional.empty();
		final BlockState topBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
		context.register(FOREST_TB_KEY, FOREST_TB.get()
						.configured(new TopBlockCarverConfiguration(configuration, topBlockPrimary, fillerBlockPrimary,
								topBlockSecondary, fillerBlockSecondary, upperBlockPrimary, upperBlockSecondary,
								upperBlockTertiary, topBlockTertiary, fillerBlockTertiary)));
	}

	protected static void registerSteppeTopBlocksCarver(final BootstapContext<ConfiguredWorldCarver<?>> context) {
		final HolderGetter<Block> blockGetter = context.lookup(Registries.BLOCK);

		final CarverConfiguration configuration = defaultConfiguration(context);
		final BlockState topBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockPrimary = blockGetter.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
		final BlockState topBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
		final BlockState fillerBlockSecondary = blockGetter.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();

		final Optional<BlockState> upperBlockPrimary = Optional.empty();
		final Optional<BlockState> upperBlockSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
		final Optional<BlockState> upperBlockTertiary = Optional.empty();
		final BlockState topBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		final BlockState fillerBlockTertiary = blockGetter.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();
		context.register(STEPPE_TB_KEY,
				STEPPE_TB.get()
						.configured(new TopBlockCarverConfiguration(configuration, topBlockPrimary, fillerBlockPrimary,
								topBlockSecondary, fillerBlockSecondary, upperBlockPrimary, upperBlockSecondary,
								upperBlockTertiary, topBlockTertiary, fillerBlockTertiary)));
	}
}
