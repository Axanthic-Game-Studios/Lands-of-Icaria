package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaConfiguredFeatureIds;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaFeatures;
import com.axanthic.icaria.common.tags.IcariaBlockItemTags;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfiguredFeatures {
	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pBootstrapContext) {
		pBootstrapContext.register(IcariaConfiguredFeatureIds.MARL_CHERT, new ConfiguredFeature<>(IcariaFeatures.MARL_CHERT.get(), FeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.MARL_BONES, new ConfiguredFeature<>(IcariaFeatures.MARL_BONES.get(), FeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.MARL_LIGNITE, new ConfiguredFeature<>(IcariaFeatures.MARL_LIGNITE.get(), FeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.GRAINEL_CHERT, new ConfiguredFeature<>(IcariaFeatures.GRAINEL_CHERT.get(), FeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.GRAINITE_SPIKE, new ConfiguredFeature<>(IcariaFeatures.GRAINITE_SPIKE.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.YELLOWSTONE_BOULDER, new ConfiguredFeature<>(IcariaFeatures.YELLOWSTONE_BOULDER.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.GRAINITE_RUBBLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.GRAINITE_RUBBLE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.YELLOWSTONE_RUBBLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.YELLOWSTONE_RUBBLE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SILKSTONE_RUBBLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SILKSTONE_RUBBLE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SUNSTONE_RUBBLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNSTONE_RUBBLE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.VOIDSHALE_RUBBLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.VOIDSHALE_RUBBLE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.BAETYL_RUBBLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BAETYL_RUBBLE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.RELICSTONE_RUBBLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.RELICSTONE_RUBBLE.get()))));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.FALLEN_RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.LIGNITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_YELLOWSTONE.block()), IcariaBlocks.LIGNITE_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.CHALKOS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_YELLOWSTONE.block()), IcariaBlocks.CHALKOS_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.KASSITEROS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SILKSTONE.block()), IcariaBlocks.KASSITEROS_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DOLOMITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SILKSTONE.block()), IcariaBlocks.DOLOMITE_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.VANADIUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SUNSTONE.block()), IcariaBlocks.VANADIUM_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SLIVER_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SUNSTONE.block()), IcariaBlocks.SLIVER_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SIDEROS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_VOIDSHALE.block()), IcariaBlocks.SIDEROS_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.ANTHRACITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_VOIDSHALE.block()), IcariaBlocks.ANTHRACITE_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.MOLYBDENUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_BAETYL.block()), IcariaBlocks.MOLYBDENUM_ORE.get().defaultBlockState(), 9)));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.HYLIASTRUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_BAETYL.block()), IcariaBlocks.HYLIASTRUM_ORE.get().defaultBlockState(), 9)));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.CALCITE_CLUSTER, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CALCITE_CLUSTER.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.HALITE_CLUSTER, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.HALITE_CLUSTER.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.JASPER_CLUSTER, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.JASPER_CLUSTER.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.ZIRCON_CLUSTER, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.ZIRCON_CLUSTER.get()))));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.CYPRESS_TREE, new ConfiguredFeature<>(IcariaFeatures.CYPRESS_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DROUGHTROOT_TREE, new ConfiguredFeature<>(IcariaFeatures.DROUGHTROOT_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FIR_TREE, new ConfiguredFeature<>(IcariaFeatures.FIR_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.LAUREL_TREE, new ConfiguredFeature<>(IcariaFeatures.LAUREL_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.OLIVE_TREE, new ConfiguredFeature<>(IcariaFeatures.OLIVE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PLANE_TREE, new ConfiguredFeature<>(IcariaFeatures.PLANE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.POPULUS_TREE, new ConfiguredFeature<>(IcariaFeatures.POPULUS_TREE.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.DEAD_CYPRESS_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_CYPRESS_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DEAD_DROUGHTROOT_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_DROUGHTROOT_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DEAD_FIR_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_FIR_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DEAD_LAUREL_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_LAUREL_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DEAD_OLIVE_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_OLIVE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DEAD_PLANE_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_PLANE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DEAD_POPULUS_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_POPULUS_TREE.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_CYPRESS_TREE, new ConfiguredFeature<>(IcariaFeatures.FALLEN_CYPRESS_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_DROUGHTROOT_TREE, new ConfiguredFeature<>(IcariaFeatures.FALLEN_DROUGHTROOT_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_FIR_TREE, new ConfiguredFeature<>(IcariaFeatures.FALLEN_FIR_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_LAUREL_TREE, new ConfiguredFeature<>(IcariaFeatures.FALLEN_LAUREL_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_OLIVE_TREE, new ConfiguredFeature<>(IcariaFeatures.FALLEN_OLIVE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_PLANE_TREE, new ConfiguredFeature<>(IcariaFeatures.FALLEN_PLANE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FALLEN_POPULUS_TREE, new ConfiguredFeature<>(IcariaFeatures.FALLEN_POPULUS_TREE.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.SMALL_CYPRESS_TREE, new ConfiguredFeature<>(IcariaFeatures.SMALL_CYPRESS_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SMALL_DROUGHTROOT_TREE, new ConfiguredFeature<>(IcariaFeatures.SMALL_DROUGHTROOT_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SMALL_FIR_TREE, new ConfiguredFeature<>(IcariaFeatures.SMALL_FIR_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SMALL_LAUREL_TREE, new ConfiguredFeature<>(IcariaFeatures.SMALL_LAUREL_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SMALL_OLIVE_TREE, new ConfiguredFeature<>(IcariaFeatures.SMALL_OLIVE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SMALL_PLANE_TREE, new ConfiguredFeature<>(IcariaFeatures.SMALL_PLANE_TREE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SMALL_POPULUS_TREE, new ConfiguredFeature<>(IcariaFeatures.SMALL_POPULUS_TREE.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.BLOOMY_VINE, new ConfiguredFeature<>(IcariaFeatures.BLOOMY_VINE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.BRANCHY_VINE, new ConfiguredFeature<>(IcariaFeatures.BRANCHY_VINE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.BRUSHY_VINE, new ConfiguredFeature<>(IcariaFeatures.BRUSHY_VINE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DRY_VINE, new ConfiguredFeature<>(IcariaFeatures.DRY_VINE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.REEDY_VINE, new ConfiguredFeature<>(IcariaFeatures.REEDY_VINE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SWIRLY_VINE, new ConfiguredFeature<>(IcariaFeatures.SWIRLY_VINE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.THORNY_VINE, new ConfiguredFeature<>(IcariaFeatures.THORNY_VINE.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.GRASS, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(WeightedList.<BlockState>builder().add(IcariaBlocks.SMALL_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_GRASS.get().defaultBlockState(), 1)))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.GRAIN, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(WeightedList.<BlockState>builder().add(IcariaBlocks.SMALL_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_BROWN_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_WHITE_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_BROWN_GRAIN.get().defaultBlockState(), 1)))));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.CALCITE_DUST, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(WeightedList.<BlockState>builder().add(IcariaBlocks.SMALL_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.SMALL_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_BROWN_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_WHITE_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_BROWN_GRAIN.get().defaultBlockState(), 1)))));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.BLINDWEED, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BLINDWEED.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.CHAMEOMILE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CHAMEOMILE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.CHARMONDER, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CHARMONDER.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.CLOVER, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CLOVER.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.FIREHILT, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.FIREHILT.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.BLUE_HYDRACINTH, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BLUE_HYDRACINTH.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PURPLE_HYDRACINTH, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_HYDRACINTH.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.LIONFANGS, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.LIONFANGS.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SPEARDROPS, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SPEARDROPS.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PURPLE_STAGHORN, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_STAGHORN.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.YELLOW_STAGHORN, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.YELLOW_STAGHORN.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.BLUE_STORMCOTTON, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BLUE_STORMCOTTON.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PINK_STORMCOTTON, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PINK_STORMCOTTON.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PURPLE_STORMCOTTON, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_STORMCOTTON.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SUNKETTLE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNKETTLE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.SUNSPONGE, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNSPONGE.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.VOIDLILY, new ConfiguredFeature<>(IcariaFeatures.VOIDLILY.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.BOLBOS, new ConfiguredFeature<>(IcariaFeatures.BOLBOS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.DATHULLA, new ConfiguredFeature<>(IcariaFeatures.DATHULLA.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.MONDANOS, new ConfiguredFeature<>(IcariaFeatures.MONDANOS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.MOTH_AGARIC, new ConfiguredFeature<>(IcariaFeatures.MOTH_AGARIC.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.NAMDRAKE, new ConfiguredFeature<>(IcariaFeatures.NAMDRAKE.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PSILOCYBOS, new ConfiguredFeature<>(IcariaFeatures.PSILOCYBOS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.ROWAN, new ConfiguredFeature<>(IcariaFeatures.ROWAN.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.WILTED_ELM, new ConfiguredFeature<>(IcariaFeatures.WILTED_ELM.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.BLUE_GROUND_FLOWERS, new ConfiguredFeature<>(IcariaFeatures.BLUE_GROUND_FLOWERS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.CYAN_GROUND_FLOWERS, new ConfiguredFeature<>(IcariaFeatures.CYAN_GROUND_FLOWERS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PINK_GROUND_FLOWERS, new ConfiguredFeature<>(IcariaFeatures.PINK_GROUND_FLOWERS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PURPLE_GROUND_FLOWERS, new ConfiguredFeature<>(IcariaFeatures.PURPLE_GROUND_FLOWERS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.RED_GROUND_FLOWERS, new ConfiguredFeature<>(IcariaFeatures.RED_GROUND_FLOWERS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.WHITE_GROUND_FLOWERS, new ConfiguredFeature<>(IcariaFeatures.WHITE_GROUND_FLOWERS.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.PALM_FERN, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PALM_FERN.get()))));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.WHITE_BROMELIA, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.WHITE_BROMELIA.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.ORANGE_BROMELIA, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.ORANGE_BROMELIA.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PINK_BROMELIA, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PINK_BROMELIA.get()))));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.PURPLE_BROMELIA, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_BROMELIA.get()))));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.GREEN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.GREEN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.BROWN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.BROWN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.LARGE_BROWN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.LARGE_BROWN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.CARDON_CACTUS, new ConfiguredFeature<>(IcariaFeatures.CARDON_CACTUS.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.STRAWBERRY_BUSH, new ConfiguredFeature<>(IcariaFeatures.STRAWBERRY_BUSH.get(), NoneFeatureConfiguration.NONE));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.DRY_LAKE, new ConfiguredFeature<>(Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(IcariaBlocks.DRY_LAKE_BED.get()), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue())));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.MEDITERRANEAN_WATER_LAKE, new ConfiguredFeature<>(Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(IcariaBlocks.MEDITERRANEAN_WATER.get()), BlockStateProvider.simple(IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue())));

		pBootstrapContext.register(IcariaConfiguredFeatureIds.RUIN, new ConfiguredFeature<>(IcariaFeatures.RUIN.get(), NoneFeatureConfiguration.NONE));
		pBootstrapContext.register(IcariaConfiguredFeatureIds.VILLAGE, new ConfiguredFeature<>(IcariaFeatures.VILLAGE.get(), NoneFeatureConfiguration.NONE));
	}
}
