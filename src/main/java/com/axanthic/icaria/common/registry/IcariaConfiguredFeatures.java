package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> MARL_CHERT = IcariaConfiguredFeatures.createKey("marl_chert");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MARL_BONES = IcariaConfiguredFeatures.createKey("marl_bones");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MARL_LIGNITE = IcariaConfiguredFeatures.createKey("marl_lignite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GRAINEL_CHERT = IcariaConfiguredFeatures.createKey("grainel_chert");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GRAINITE_SPIKE = IcariaConfiguredFeatures.createKey("grainite_spike");

	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOWSTONE_BOULDER = IcariaConfiguredFeatures.createKey("yellowstone_boulder");

	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOWSTONE_RUBBLE = IcariaConfiguredFeatures.createKey("yellowstone_rubble");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SILKSTONE_RUBBLE = IcariaConfiguredFeatures.createKey("silkstone_rubble");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SUNSTONE_RUBBLE = IcariaConfiguredFeatures.createKey("sunstone_rubble");
	public static final ResourceKey<ConfiguredFeature<?, ?>> VOIDSHALE_RUBBLE = IcariaConfiguredFeatures.createKey("voidshale_rubble");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BAETYL_RUBBLE = IcariaConfiguredFeatures.createKey("baetyl_rubble");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RELICSTONE_RUBBLE = IcariaConfiguredFeatures.createKey("relicstone_rubble");

	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_RELICSTONE_PILLAR = IcariaConfiguredFeatures.createKey("fallen_relicstone_pillar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HORIZONTAL_RELICSTONE_PILLAR = IcariaConfiguredFeatures.createKey("horizontal_relicstone_pillar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> VERTICAL_RELICSTONE_PILLAR = IcariaConfiguredFeatures.createKey("vertical_relicstone_pillar");

	public static final ResourceKey<ConfiguredFeature<?, ?>> LIGNITE_ORE = IcariaConfiguredFeatures.createKey("lignite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHALKOS_ORE = IcariaConfiguredFeatures.createKey("chalkos_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> KASSITEROS_ORE = IcariaConfiguredFeatures.createKey("kassiteros_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DOLOMITE_ORE = IcariaConfiguredFeatures.createKey("dolomite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> VANADIUM_ORE = IcariaConfiguredFeatures.createKey("vanadium_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SLIVER_ORE = IcariaConfiguredFeatures.createKey("sliver_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SIDEROS_ORE = IcariaConfiguredFeatures.createKey("sideros_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ANTHRACITE_ORE = IcariaConfiguredFeatures.createKey("anthracite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MOLYBDENUM_ORE = IcariaConfiguredFeatures.createKey("molybdenum_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HYLIASTRUM_ORE = IcariaConfiguredFeatures.createKey("hyliastrum_ore");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE_CRYSTAL = IcariaConfiguredFeatures.createKey("calcite_crystal");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HALITE_CRYSTAL = IcariaConfiguredFeatures.createKey("halite_crystal");
	public static final ResourceKey<ConfiguredFeature<?, ?>> JASPER_CRYSTAL = IcariaConfiguredFeatures.createKey("jasper_crystal");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCON_CRYSTAL = IcariaConfiguredFeatures.createKey("zircon_crystal");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE = IcariaConfiguredFeatures.createKey("cypress_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DROUGHTROOT_TREE = IcariaConfiguredFeatures.createKey("droughtroot_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_TREE = IcariaConfiguredFeatures.createKey("fir_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LAUREL_TREE = IcariaConfiguredFeatures.createKey("laurel_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE_TREE = IcariaConfiguredFeatures.createKey("olive_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PLANE_TREE = IcariaConfiguredFeatures.createKey("plane_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> POPULUS_TREE = IcariaConfiguredFeatures.createKey("populus_tree");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CYPRESS_TREE = IcariaConfiguredFeatures.createKey("dead_cypress_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_DROUGHTROOT_TREE = IcariaConfiguredFeatures.createKey("dead_droughtroot_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_FIR_TREE = IcariaConfiguredFeatures.createKey("dead_fir_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_LAUREL_TREE = IcariaConfiguredFeatures.createKey("dead_laurel_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_OLIVE_TREE = IcariaConfiguredFeatures.createKey("dead_olive_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PLANE_TREE = IcariaConfiguredFeatures.createKey("dead_plane_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_POPULUS_TREE = IcariaConfiguredFeatures.createKey("dead_populus_tree");

	public static final ResourceKey<ConfiguredFeature<?, ?>> BLOOMY_VINE = IcariaConfiguredFeatures.createKey("bloomy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRANCHY_VINE = IcariaConfiguredFeatures.createKey("branchy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRUSHY_VINE = IcariaConfiguredFeatures.createKey("brushy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRY_VINE = IcariaConfiguredFeatures.createKey("dry_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> REEDY_VINE = IcariaConfiguredFeatures.createKey("reedy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SWIRLY_VINE = IcariaConfiguredFeatures.createKey("swirly_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> THORNY_VINE = IcariaConfiguredFeatures.createKey("thorny_vine");

	public static final ResourceKey<ConfiguredFeature<?, ?>> FERN = IcariaConfiguredFeatures.createKey("fern");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS = IcariaConfiguredFeatures.createKey("grass");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GRAIN = IcariaConfiguredFeatures.createKey("grain");

	public static final ResourceKey<ConfiguredFeature<?, ?>> ICARIA_BONEMEAL = IcariaConfiguredFeatures.createKey("icaria_bonemeal");

	public static final ResourceKey<ConfiguredFeature<?, ?>> BLINDWEED = IcariaConfiguredFeatures.createKey("blindweed");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHAMEOMILE = IcariaConfiguredFeatures.createKey("chameomile");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHARMONDER = IcariaConfiguredFeatures.createKey("charmonder");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CLOVER = IcariaConfiguredFeatures.createKey("clover");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FIREHILT = IcariaConfiguredFeatures.createKey("firehilt");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_HYDRACINTH = IcariaConfiguredFeatures.createKey("blue_hydracinth");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_HYDRACINTH = IcariaConfiguredFeatures.createKey("purple_hydracinth");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIONFANGS = IcariaConfiguredFeatures.createKey("lionfangs");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SPEARDROPS = IcariaConfiguredFeatures.createKey("speardrops");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_STAGHORN = IcariaConfiguredFeatures.createKey("purple_staghorn");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_STAGHORN = IcariaConfiguredFeatures.createKey("yellow_staghorn");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_STORMCOTTON = IcariaConfiguredFeatures.createKey("blue_stormcotton");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_STORMCOTTON = IcariaConfiguredFeatures.createKey("pink_stormcotton");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_STORMCOTTON = IcariaConfiguredFeatures.createKey("purple_stormcotton");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SUNKETTLE = IcariaConfiguredFeatures.createKey("sunkettle");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SUNSPONGE = IcariaConfiguredFeatures.createKey("sunsponge");
	public static final ResourceKey<ConfiguredFeature<?, ?>> VOIDLILY = IcariaConfiguredFeatures.createKey("voidlily");

	public static final ResourceKey<ConfiguredFeature<?, ?>> BOLBOS = IcariaConfiguredFeatures.createKey("bolbos");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DATHULLA = IcariaConfiguredFeatures.createKey("dathulla");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MONDANOS = IcariaConfiguredFeatures.createKey("mondanos");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MOTH_AGARIC = IcariaConfiguredFeatures.createKey("moth_agaric");
	public static final ResourceKey<ConfiguredFeature<?, ?>> NAMDRAKE = IcariaConfiguredFeatures.createKey("namdrake");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PSILOCYBOS = IcariaConfiguredFeatures.createKey("psilocybos");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ROWAN = IcariaConfiguredFeatures.createKey("rowan");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILTED_ELM = IcariaConfiguredFeatures.createKey("wilted_elm");

	public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_GROUND_FLOWERS = IcariaConfiguredFeatures.createKey("blue_ground_flowers");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CYAN_GROUND_FLOWERS = IcariaConfiguredFeatures.createKey("cyan_ground_flowers");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_GROUND_FLOWERS = IcariaConfiguredFeatures.createKey("pink_ground_flowers");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_GROUND_FLOWERS = IcariaConfiguredFeatures.createKey("purple_ground_flowers");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_GROUND_FLOWERS = IcariaConfiguredFeatures.createKey("red_ground_flowers");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_GROUND_FLOWERS = IcariaConfiguredFeatures.createKey("white_ground_flowers");

	public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_FERN = IcariaConfiguredFeatures.createKey("palm_fern");

	public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_BROMELIA = IcariaConfiguredFeatures.createKey("white_bromelia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_BROMELIA = IcariaConfiguredFeatures.createKey("orange_bromelia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_BROMELIA = IcariaConfiguredFeatures.createKey("pink_bromelia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BROMELIA = IcariaConfiguredFeatures.createKey("purple_bromelia");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_GROUND_SHROOMS = IcariaConfiguredFeatures.createKey("green_ground_shrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_GROUND_SHROOMS = IcariaConfiguredFeatures.createKey("brown_ground_shrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BROWN_GROUND_SHROOMS = IcariaConfiguredFeatures.createKey("large_brown_ground_shrooms");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CARDON_CACTUS = IcariaConfiguredFeatures.createKey("cardon_cactus");

	public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH = IcariaConfiguredFeatures.createKey("strawberry_bush");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DRY_LAKE = IcariaConfiguredFeatures.createKey("dry_lake");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MEDITERRANEAN_WATER_LAKE = IcariaConfiguredFeatures.createKey("mediterranean_water_lake");

	public static final ResourceKey<ConfiguredFeature<?, ?>> STRUCTURE = IcariaConfiguredFeatures.createKey("structure");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext) {
		pContext.register(IcariaConfiguredFeatures.MARL_CHERT, new ConfiguredFeature<>(IcariaFeatures.MARL_CHERT.get(), FeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.MARL_BONES, new ConfiguredFeature<>(IcariaFeatures.MARL_BONES.get(), FeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.MARL_LIGNITE, new ConfiguredFeature<>(IcariaFeatures.MARL_LIGNITE.get(), FeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.GRAINEL_CHERT, new ConfiguredFeature<>(IcariaFeatures.GRAINEL_CHERT.get(), FeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.GRAINITE_SPIKE, new ConfiguredFeature<>(IcariaFeatures.GRAINITE_SPIKE.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.YELLOWSTONE_BOULDER, new ConfiguredFeature<>(IcariaFeatures.YELLOWSTONE_BOULDER.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.YELLOWSTONE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.YELLOWSTONE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), IcariaBlockTags.RUBBLE_SPAWNS_ON), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.SILKSTONE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SILKSTONE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), IcariaBlockTags.RUBBLE_SPAWNS_ON), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.SUNSTONE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNSTONE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), IcariaBlockTags.RUBBLE_SPAWNS_ON), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.VOIDSHALE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.VOIDSHALE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), IcariaBlockTags.RUBBLE_SPAWNS_ON), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.BAETYL_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BAETYL_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), IcariaBlockTags.RUBBLE_SPAWNS_ON), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.RELICSTONE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.RELICSTONE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), IcariaBlockTags.RELICSTONE_RUBBLE_SPAWNS_ON), BlockPredicate.matchesBlocks(Blocks.AIR))))));

		pContext.register(IcariaConfiguredFeatures.FALLEN_RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.FALLEN_RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.HORIZONTAL_RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.HORIZONTAL_RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.VERTICAL_RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.VERTICAL_RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.LIGNITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_YELLOWSTONE), IcariaBlocks.LIGNITE_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.CHALKOS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_YELLOWSTONE), IcariaBlocks.CHALKOS_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.KASSITEROS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_SILKSTONE), IcariaBlocks.KASSITEROS_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.DOLOMITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_SILKSTONE), IcariaBlocks.DOLOMITE_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.VANADIUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_SUNSTONE), IcariaBlocks.VANADIUM_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.SLIVER_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_SUNSTONE), IcariaBlocks.SLIVER_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.SIDEROS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_VOIDSHALE), IcariaBlocks.SIDEROS_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.ANTHRACITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_VOIDSHALE), IcariaBlocks.ANTHRACITE_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.MOLYBDENUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_BAETYL), IcariaBlocks.MOLYBDENUM_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.HYLIASTRUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_BAETYL), IcariaBlocks.HYLIASTRUM_ORE.get().defaultBlockState(), 9)));

		pContext.register(IcariaConfiguredFeatures.CALCITE_CRYSTAL, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CALCITE_CRYSTAL.get().defaultBlockState()))));
		pContext.register(IcariaConfiguredFeatures.HALITE_CRYSTAL, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.HALITE_CRYSTAL.get().defaultBlockState()))));
		pContext.register(IcariaConfiguredFeatures.JASPER_CRYSTAL, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.JASPER_CRYSTAL.get().defaultBlockState()))));
		pContext.register(IcariaConfiguredFeatures.ZIRCON_CRYSTAL, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.ZIRCON_CRYSTAL.get().defaultBlockState()))));

		pContext.register(IcariaConfiguredFeatures.CYPRESS_TREE, new ConfiguredFeature<>(IcariaFeatures.CYPRESS_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DROUGHTROOT_TREE, new ConfiguredFeature<>(IcariaFeatures.DROUGHTROOT_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.FIR_TREE, new ConfiguredFeature<>(IcariaFeatures.FIR_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.LAUREL_TREE, new ConfiguredFeature<>(IcariaFeatures.LAUREL_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.OLIVE_TREE, new ConfiguredFeature<>(IcariaFeatures.OLIVE_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.PLANE_TREE, new ConfiguredFeature<>(IcariaFeatures.PLANE_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.POPULUS_TREE, new ConfiguredFeature<>(IcariaFeatures.POPULUS_TREE.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.DEAD_CYPRESS_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_CYPRESS_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DEAD_DROUGHTROOT_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_DROUGHTROOT_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DEAD_FIR_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_FIR_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DEAD_LAUREL_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_LAUREL_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DEAD_OLIVE_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_OLIVE_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DEAD_PLANE_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_PLANE_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DEAD_POPULUS_TREE, new ConfiguredFeature<>(IcariaFeatures.DEAD_POPULUS_TREE.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.BLOOMY_VINE, new ConfiguredFeature<>(IcariaFeatures.BLOOMY_VINE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.BRANCHY_VINE, new ConfiguredFeature<>(IcariaFeatures.BRANCHY_VINE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.BRUSHY_VINE, new ConfiguredFeature<>(IcariaFeatures.BRUSHY_VINE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DRY_VINE, new ConfiguredFeature<>(IcariaFeatures.DRY_VINE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.REEDY_VINE, new ConfiguredFeature<>(IcariaFeatures.REEDY_VINE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.SWIRLY_VINE, new ConfiguredFeature<>(IcariaFeatures.SWIRLY_VINE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.THORNY_VINE, new ConfiguredFeature<>(IcariaFeatures.THORNY_VINE.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.FERN, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.FERN.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.GRASS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.5F, List.of(IcariaBlocks.SMALL_GRASS.get().defaultBlockState(), IcariaBlocks.MEDIUM_GRASS.get().defaultBlockState(), IcariaBlocks.LARGE_GRASS.get().defaultBlockState()))), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.GRAIN, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.5F, List.of(IcariaBlocks.SMALL_MIXED_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_MIXED_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_BROWN_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_WHITE_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_YELLOW_GRAIN.get().defaultBlockState(), IcariaBlocks.LARGE_BROWN_GRAIN.get().defaultBlockState()))), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));

		pContext.register(IcariaConfiguredFeatures.ICARIA_BONEMEAL, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.5F, List.of(IcariaBlocks.FERN.get().defaultBlockState(), IcariaBlocks.SMALL_GRASS.get().defaultBlockState(), IcariaBlocks.MEDIUM_GRASS.get().defaultBlockState(), IcariaBlocks.LARGE_GRASS.get().defaultBlockState(), IcariaBlocks.SMALL_MIXED_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_MIXED_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_BROWN_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_WHITE_GRAIN.get().defaultBlockState(), IcariaBlocks.MEDIUM_YELLOW_GRAIN.get().defaultBlockState(), IcariaBlocks.LARGE_BROWN_GRAIN.get().defaultBlockState()))), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));

		pContext.register(IcariaConfiguredFeatures.BLINDWEED, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BLINDWEED.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.CHAMEOMILE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CHAMEOMILE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.CHARMONDER, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CHARMONDER.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.CLOVER, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CLOVER.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.FIREHILT, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.FIREHILT.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.BLUE_HYDRACINTH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BLUE_HYDRACINTH.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PURPLE_HYDRACINTH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_HYDRACINTH.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.LIONFANGS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.LIONFANGS.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.SPEARDROPS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SPEARDROPS.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PURPLE_STAGHORN, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_STAGHORN.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.YELLOW_STAGHORN, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.YELLOW_STAGHORN.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.BLUE_STORMCOTTON, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BLUE_STORMCOTTON.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PINK_STORMCOTTON, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PINK_STORMCOTTON.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PURPLE_STORMCOTTON, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_STORMCOTTON.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.SUNKETTLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNKETTLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.SUNSPONGE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNSPONGE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.VOIDLILY, new ConfiguredFeature<>(IcariaFeatures.VOIDLILY.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.BOLBOS, new ConfiguredFeature<>(IcariaFeatures.BOLBOS.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DATHULLA, new ConfiguredFeature<>(IcariaFeatures.DATHULLA.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.MONDANOS, new ConfiguredFeature<>(IcariaFeatures.MONDANOS.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.MOTH_AGARIC, new ConfiguredFeature<>(IcariaFeatures.MOTH_AGARIC.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.NAMDRAKE, new ConfiguredFeature<>(IcariaFeatures.NAMDRAKE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.PSILOCYBOS, new ConfiguredFeature<>(IcariaFeatures.PSILOCYBOS.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.ROWAN, new ConfiguredFeature<>(IcariaFeatures.ROWAN.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.WILTED_ELM, new ConfiguredFeature<>(IcariaFeatures.WILTED_ELM.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.BLUE_GROUND_FLOWERS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.BLUE_GROUND_FLOWERS.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.CYAN_GROUND_FLOWERS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.CYAN_GROUND_FLOWERS.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PINK_GROUND_FLOWERS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PINK_GROUND_FLOWERS.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PURPLE_GROUND_FLOWERS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_GROUND_FLOWERS.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.RED_GROUND_FLOWERS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.RED_GROUND_FLOWERS.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.WHITE_GROUND_FLOWERS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.WHITE_GROUND_FLOWERS.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.matchesBlocks(Blocks.AIR))))));

		pContext.register(IcariaConfiguredFeatures.PALM_FERN, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PALM_FERN.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));

		pContext.register(IcariaConfiguredFeatures.WHITE_BROMELIA, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.WHITE_BROMELIA.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.ORANGE_BROMELIA, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.ORANGE_BROMELIA.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PINK_BROMELIA, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PINK_BROMELIA.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));
		pContext.register(IcariaConfiguredFeatures.PURPLE_BROMELIA, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 8, 8, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.PURPLE_BROMELIA.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesBlocks(Blocks.AIR))))));

		pContext.register(IcariaConfiguredFeatures.GREEN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.GREEN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.BROWN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.BROWN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.LARGE_BROWN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.LARGE_BROWN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.CARDON_CACTUS, new ConfiguredFeature<>(IcariaFeatures.CARDON_CACTUS.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.STRAWBERRY_BUSH, new ConfiguredFeature<>(IcariaFeatures.STRAWBERRY_BUSH.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.DRY_LAKE, new ConfiguredFeature<>(IcariaFeatures.DRY_LAKE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.MEDITERRANEAN_WATER_LAKE, new ConfiguredFeature<>(IcariaFeatures.MEDITERRANEAN_WATER_LAKE.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.STRUCTURE, new ConfiguredFeature<>(IcariaFeatures.STRUCTURE.get(), NoneFeatureConfiguration.NONE));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
