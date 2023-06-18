package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, IcariaInfo.ID);

	public static final ResourceKey<PlacedFeature> MARL_CHERT = IcariaPlacedFeatures.registerKey("marl_chert");
	public static final ResourceKey<PlacedFeature> MARL_BONES = IcariaPlacedFeatures.registerKey("marl_bones");
	public static final ResourceKey<PlacedFeature> MARL_LIGNITE = IcariaPlacedFeatures.registerKey("marl_lignite");
	public static final ResourceKey<PlacedFeature> GRAINEL_CHERT = IcariaPlacedFeatures.registerKey("grainel_chert");

	public static final ResourceKey<PlacedFeature> GRAINITE_SPIKE = IcariaPlacedFeatures.registerKey("grainite_spike");

	public static final ResourceKey<PlacedFeature> YELLOWSTONE_BOULDER = IcariaPlacedFeatures.registerKey("yellowstone_boulder");

	public static final ResourceKey<PlacedFeature> GRAINITE_RUBBLE = IcariaPlacedFeatures.registerKey("grainite_rubble");
	public static final ResourceKey<PlacedFeature> DESERT_SILKSTONE_RUBBLE = IcariaPlacedFeatures.registerKey("desert_silkstone_rubble");
	public static final ResourceKey<PlacedFeature> YELLOWSTONE_RUBBLE = IcariaPlacedFeatures.registerKey("yellowstone_rubble");
	public static final ResourceKey<PlacedFeature> SILKSTONE_RUBBLE = IcariaPlacedFeatures.registerKey("silkstone_rubble");
	public static final ResourceKey<PlacedFeature> SUNSTONE_RUBBLE = IcariaPlacedFeatures.registerKey("sunstone_rubble");
	public static final ResourceKey<PlacedFeature> VOIDSHALE_RUBBLE = IcariaPlacedFeatures.registerKey("voidshale_rubble");
	public static final ResourceKey<PlacedFeature> BAETYL_RUBBLE = IcariaPlacedFeatures.registerKey("baetyl_rubble");
	public static final ResourceKey<PlacedFeature> RELICSTONE_RUBBLE = IcariaPlacedFeatures.registerKey("relicstone_rubble");

	public static final ResourceKey<PlacedFeature> FALLEN_RELICSTONE_PILLAR = IcariaPlacedFeatures.registerKey("fallen_relicstone_pillar");
	public static final ResourceKey<PlacedFeature> HORIZONTAL_RELICSTONE_PILLAR = IcariaPlacedFeatures.registerKey("horizontal_relicstone_pillar");
	public static final ResourceKey<PlacedFeature> VERTICAL_RELICSTONE_PILLAR = IcariaPlacedFeatures.registerKey("vertical_relicstone_pillar");

	public static final ResourceKey<PlacedFeature> LIGNITE_ORE = IcariaPlacedFeatures.registerKey("lignite_ore");
	public static final ResourceKey<PlacedFeature> CHALKOS_ORE = IcariaPlacedFeatures.registerKey("chalkos_ore");
	public static final ResourceKey<PlacedFeature> KASSITEROS_ORE = IcariaPlacedFeatures.registerKey("kassiteros_ore");
	public static final ResourceKey<PlacedFeature> DOLOMITE_ORE = IcariaPlacedFeatures.registerKey("dolomite_ore");
	public static final ResourceKey<PlacedFeature> VANADIUM_ORE = IcariaPlacedFeatures.registerKey("vanadium_ore");
	public static final ResourceKey<PlacedFeature> SLIVER_ORE = IcariaPlacedFeatures.registerKey("sliver_ore");
	public static final ResourceKey<PlacedFeature> SIDEROS_ORE = IcariaPlacedFeatures.registerKey("sideros_ore");
	public static final ResourceKey<PlacedFeature> ANTHRACITE_ORE = IcariaPlacedFeatures.registerKey("anthracite_ore");
	public static final ResourceKey<PlacedFeature> MOLYBDENUM_ORE = IcariaPlacedFeatures.registerKey("molybdenum_ore");
	public static final ResourceKey<PlacedFeature> HYLIASTRUM_ORE = IcariaPlacedFeatures.registerKey("hyliastrum_ore");

	public static final ResourceKey<PlacedFeature> CALCITE_CRYSTAL = IcariaPlacedFeatures.registerKey("calcite_crystal");
	public static final ResourceKey<PlacedFeature> HALITE_CRYSTAL = IcariaPlacedFeatures.registerKey("halite_crystal");
	public static final ResourceKey<PlacedFeature> JASPER_CRYSTAL = IcariaPlacedFeatures.registerKey("jasper_crystal");
	public static final ResourceKey<PlacedFeature> ZIRCON_CRYSTAL = IcariaPlacedFeatures.registerKey("zircon_crystal");

	public static final ResourceKey<PlacedFeature> CYPRESS_TREE = IcariaPlacedFeatures.registerKey("cypress_tree");
	public static final ResourceKey<PlacedFeature> DROUGHTROOT_TREE = IcariaPlacedFeatures.registerKey("droughtroot_tree");
	public static final ResourceKey<PlacedFeature> FIR_TREE = IcariaPlacedFeatures.registerKey("fir_tree");
	public static final ResourceKey<PlacedFeature> LAUREL_TREE = IcariaPlacedFeatures.registerKey("laurel_tree");
	public static final ResourceKey<PlacedFeature> OLIVE_TREE = IcariaPlacedFeatures.registerKey("olive_tree");
	public static final ResourceKey<PlacedFeature> PLANE_TREE = IcariaPlacedFeatures.registerKey("plane_tree");
	public static final ResourceKey<PlacedFeature> POPULUS_TREE = IcariaPlacedFeatures.registerKey("populus_tree");

	public static final ResourceKey<PlacedFeature> DEAD_CYPRESS_TREE = IcariaPlacedFeatures.registerKey("dead_cypress_tree");
	public static final ResourceKey<PlacedFeature> DEAD_DROUGHTROOT_TREE = IcariaPlacedFeatures.registerKey("dead_droughtroot_tree");
	public static final ResourceKey<PlacedFeature> DEAD_FIR_TREE = IcariaPlacedFeatures.registerKey("dead_fir_tree");
	public static final ResourceKey<PlacedFeature> DEAD_LAUREL_TREE = IcariaPlacedFeatures.registerKey("dead_laurel_tree");
	public static final ResourceKey<PlacedFeature> DEAD_OLIVE_TREE = IcariaPlacedFeatures.registerKey("dead_olive_tree");
	public static final ResourceKey<PlacedFeature> DEAD_PLANE_TREE = IcariaPlacedFeatures.registerKey("dead_plane_tree");
	public static final ResourceKey<PlacedFeature> DEAD_POPULUS_TREE = IcariaPlacedFeatures.registerKey("dead_populus_tree");

	public static final ResourceKey<PlacedFeature> BLOOMY_VINE = IcariaPlacedFeatures.registerKey("bloomy_vine");
	public static final ResourceKey<PlacedFeature> BRANCHY_VINE = IcariaPlacedFeatures.registerKey("branchy_vine");
	public static final ResourceKey<PlacedFeature> BRUSHY_VINE = IcariaPlacedFeatures.registerKey("brushy_vine");
	public static final ResourceKey<PlacedFeature> DRY_VINE = IcariaPlacedFeatures.registerKey("dry_vine");
	public static final ResourceKey<PlacedFeature> REEDY_VINE = IcariaPlacedFeatures.registerKey("reedy_vine");
	public static final ResourceKey<PlacedFeature> SWIRLY_VINE = IcariaPlacedFeatures.registerKey("swirly_vine");
	public static final ResourceKey<PlacedFeature> THORNY_VINE = IcariaPlacedFeatures.registerKey("thorny_vine");

	public static final ResourceKey<PlacedFeature> FERN = IcariaPlacedFeatures.registerKey("fern");
	public static final ResourceKey<PlacedFeature> GRASS = IcariaPlacedFeatures.registerKey("grass");
	public static final ResourceKey<PlacedFeature> GRAIN = IcariaPlacedFeatures.registerKey("grain");

	public static final ResourceKey<PlacedFeature> ICARIA_BONEMEAL = IcariaPlacedFeatures.registerKey("icaria_bonemeal");

	public static final ResourceKey<PlacedFeature> BLINDWEED = IcariaPlacedFeatures.registerKey("blindweed");
	public static final ResourceKey<PlacedFeature> CHAMEOMILE = IcariaPlacedFeatures.registerKey("chameomile");
	public static final ResourceKey<PlacedFeature> CHARMONDER = IcariaPlacedFeatures.registerKey("charmonder");
	public static final ResourceKey<PlacedFeature> CLOVER = IcariaPlacedFeatures.registerKey("clover");
	public static final ResourceKey<PlacedFeature> FIREHILT = IcariaPlacedFeatures.registerKey("firehilt");
	public static final ResourceKey<PlacedFeature> BLUE_HYDRACINTH = IcariaPlacedFeatures.registerKey("blue_hydracinth");
	public static final ResourceKey<PlacedFeature> PURPLE_HYDRACINTH = IcariaPlacedFeatures.registerKey("purple_hydracinth");
	public static final ResourceKey<PlacedFeature> LIONFANGS = IcariaPlacedFeatures.registerKey("lionfangs");
	public static final ResourceKey<PlacedFeature> SPEARDROPS = IcariaPlacedFeatures.registerKey("speardrops");
	public static final ResourceKey<PlacedFeature> PURPLE_STAGHORN = IcariaPlacedFeatures.registerKey("purple_staghorn");
	public static final ResourceKey<PlacedFeature> YELLOW_STAGHORN = IcariaPlacedFeatures.registerKey("yellow_staghorn");
	public static final ResourceKey<PlacedFeature> BLUE_STORMCOTTON = IcariaPlacedFeatures.registerKey("blue_stormcotton");
	public static final ResourceKey<PlacedFeature> PINK_STORMCOTTON = IcariaPlacedFeatures.registerKey("pink_stormcotton");
	public static final ResourceKey<PlacedFeature> PURPLE_STORMCOTTON = IcariaPlacedFeatures.registerKey("purple_stormcotton");
	public static final ResourceKey<PlacedFeature> SUNKETTLE = IcariaPlacedFeatures.registerKey("sunkettle");
	public static final ResourceKey<PlacedFeature> SUNSPONGE = IcariaPlacedFeatures.registerKey("sunsponge");
	public static final ResourceKey<PlacedFeature> VOIDLILY = IcariaPlacedFeatures.registerKey("voidlily");

	public static final ResourceKey<PlacedFeature> MONDANOS = IcariaPlacedFeatures.registerKey("mondanos");
	public static final ResourceKey<PlacedFeature> NAMDRAKE = IcariaPlacedFeatures.registerKey("namdrake");
	public static final ResourceKey<PlacedFeature> PSILOCYBOS = IcariaPlacedFeatures.registerKey("psilocybos");
	public static final ResourceKey<PlacedFeature> ROWAN = IcariaPlacedFeatures.registerKey("rowan");
	public static final ResourceKey<PlacedFeature> WILTED_ELM = IcariaPlacedFeatures.registerKey("wilted_elm");

	public static final ResourceKey<PlacedFeature> BLUE_GROUND_FLOWERS = IcariaPlacedFeatures.registerKey("blue_ground_flowers");
	public static final ResourceKey<PlacedFeature> CYAN_GROUND_FLOWERS = IcariaPlacedFeatures.registerKey("cyan_ground_flowers");
	public static final ResourceKey<PlacedFeature> PINK_GROUND_FLOWERS = IcariaPlacedFeatures.registerKey("pink_ground_flowers");
	public static final ResourceKey<PlacedFeature> PURPLE_GROUND_FLOWERS = IcariaPlacedFeatures.registerKey("purple_ground_flowers");
	public static final ResourceKey<PlacedFeature> RED_GROUND_FLOWERS = IcariaPlacedFeatures.registerKey("red_ground_flowers");
	public static final ResourceKey<PlacedFeature> WHITE_GROUND_FLOWERS = IcariaPlacedFeatures.registerKey("white_ground_flowers");

	public static final ResourceKey<PlacedFeature> PALM_FERN = IcariaPlacedFeatures.registerKey("palm_fern");

	public static final ResourceKey<PlacedFeature> GREEN_GROUND_SHROOMS = IcariaPlacedFeatures.registerKey("green_ground_shrooms");
	public static final ResourceKey<PlacedFeature> BROWN_GROUND_SHROOMS = IcariaPlacedFeatures.registerKey("brown_ground_shrooms");
	public static final ResourceKey<PlacedFeature> LARGE_BROWN_GROUND_SHROOMS = IcariaPlacedFeatures.registerKey("large_brown_ground_shrooms");

	public static final ResourceKey<PlacedFeature> CARDON_CACTUS = IcariaPlacedFeatures.registerKey("cardon_cactus");

	public static final ResourceKey<PlacedFeature> LAKE = IcariaPlacedFeatures.registerKey("lake");
	public static final ResourceKey<PlacedFeature> DRY_LAKE = IcariaPlacedFeatures.registerKey("dry_lake");

	public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> pContext) {
		var configuredFeatures = pContext.lookup(Registries.CONFIGURED_FEATURE);

		pContext.register(IcariaPlacedFeatures.MARL_CHERT, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.MARL_CHERT), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.MARL_BONES, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.MARL_BONES), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.MARL_LIGNITE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.MARL_LIGNITE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.GRAINEL_CHERT, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRAINEL_CHERT), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRAINEL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.GRAINITE_SPIKE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRAINITE_SPIKE), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRAINEL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.YELLOWSTONE_BOULDER, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.YELLOWSTONE_BOULDER), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.GRAINITE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRAINITE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DESERT_SILKSTONE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DESERT_SILKSTONE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.YELLOWSTONE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.YELLOWSTONE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SILKSTONE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SILKSTONE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SUNSTONE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SUNSTONE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.VOIDSHALE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.VOIDSHALE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BAETYL_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BAETYL_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(32)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.RELICSTONE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.RELICSTONE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.FALLEN_RELICSTONE_PILLAR), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.HORIZONTAL_RELICSTONE_PILLAR), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.VERTICAL_RELICSTONE_PILLAR), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.LIGNITE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LIGNITE_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.CHALKOS_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CHALKOS_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.KASSITEROS_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.KASSITEROS_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DOLOMITE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DOLOMITE_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.VANADIUM_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.VANADIUM_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SLIVER_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SLIVER_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SIDEROS_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SIDEROS_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.ANTHRACITE_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.ANTHRACITE_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.MOLYBDENUM_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.MOLYBDENUM_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.HYLIASTRUM_ORE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.HYLIASTRUM_ORE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.CALCITE_CRYSTAL, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CALCITE_CRYSTAL), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(96)), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.HALITE_CRYSTAL, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.HALITE_CRYSTAL), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(96)), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.JASPER_CRYSTAL, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.JASPER_CRYSTAL), List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.ZIRCON_CRYSTAL, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.ZIRCON_CRYSTAL), List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(32)), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.CYPRESS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CYPRESS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DROUGHTROOT_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DROUGHTROOT_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.FIR_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.FIR_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.LAUREL_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LAUREL_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.OLIVE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.OLIVE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PLANE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PLANE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.POPULUS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.POPULUS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.DEAD_CYPRESS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_CYPRESS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_DROUGHTROOT_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_DROUGHTROOT_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_FIR_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_FIR_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_LAUREL_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_LAUREL_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_OLIVE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_OLIVE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_PLANE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_PLANE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_POPULUS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_POPULUS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable()), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.BLOOMY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BLOOMY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BRANCHY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BRANCHY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BRUSHY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BRUSHY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DRY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DRY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.REEDY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.REEDY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SWIRLY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SWIRLY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.THORNY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.THORNY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.FERN, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.FERN), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.GRASS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRASS), List.of(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.GRAIN, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRAIN), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.ICARIA_BONEMEAL, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.ICARIA_BONEMEAL), List.of(PlacementUtils.isEmpty())));

		pContext.register(IcariaPlacedFeatures.BLINDWEED, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BLINDWEED), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.CHAMEOMILE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CHAMEOMILE), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.CHARMONDER, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CHARMONDER), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.CLOVER, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CLOVER), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.FIREHILT, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.FIREHILT), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BLUE_HYDRACINTH, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BLUE_HYDRACINTH), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PURPLE_HYDRACINTH, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PURPLE_HYDRACINTH), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.LIONFANGS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LIONFANGS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SPEARDROPS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SPEARDROPS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PURPLE_STAGHORN, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PURPLE_STAGHORN), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.YELLOW_STAGHORN, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.YELLOW_STAGHORN), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BLUE_STORMCOTTON, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BLUE_STORMCOTTON), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PINK_STORMCOTTON, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PINK_STORMCOTTON), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PURPLE_STORMCOTTON, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PURPLE_STORMCOTTON), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SUNKETTLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SUNKETTLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SUNSPONGE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SUNSPONGE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.VOIDLILY, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.VOIDLILY), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.MONDANOS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.MONDANOS), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.SAND), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.NAMDRAKE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.NAMDRAKE), List.of(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PSILOCYBOS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PSILOCYBOS), List.of(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.ROWAN, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.ROWAN), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.WILTED_ELM, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.WILTED_ELM), List.of(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.BLUE_GROUND_FLOWERS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BLUE_GROUND_FLOWERS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.CYAN_GROUND_FLOWERS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CYAN_GROUND_FLOWERS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PINK_GROUND_FLOWERS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PINK_GROUND_FLOWERS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PURPLE_GROUND_FLOWERS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.RED_GROUND_FLOWERS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.RED_GROUND_FLOWERS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.WHITE_GROUND_FLOWERS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.WHITE_GROUND_FLOWERS), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.PALM_FERN, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PALM_FERN), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.GREEN_GROUND_SHROOMS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GREEN_GROUND_SHROOMS), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BROWN_GROUND_SHROOMS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BROWN_GROUND_SHROOMS), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LARGE_BROWN_GROUND_SHROOMS), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.CARDON_CACTUS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CARDON_CACTUS), List.of(CountPlacement.of(8), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.SAND), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.LAKE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LAKE), List.of(CountPlacement.of(8), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DRY_LAKE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DRY_LAKE), List.of(CountPlacement.of(8), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.COARSE_MARL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
	}

	public static ResourceKey<PlacedFeature> registerKey(String pName) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
