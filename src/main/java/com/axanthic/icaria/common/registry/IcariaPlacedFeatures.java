package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
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

	public static final ResourceKey<PlacedFeature> MARL_LIGNITE = IcariaPlacedFeatures.registerKey("marl_lignite");

	public static final ResourceKey<PlacedFeature> GRAINEL_CHERT = IcariaPlacedFeatures.registerKey("grainel_chert");

	public static final ResourceKey<PlacedFeature> GRAINITE_SPIKE = IcariaPlacedFeatures.registerKey("grainite_spike");

	public static final ResourceKey<PlacedFeature> GRAINITE_RUBBLE = IcariaPlacedFeatures.registerKey("grainite_rubble");
	public static final ResourceKey<PlacedFeature> SILKSTONE_RUBBLE = IcariaPlacedFeatures.registerKey("silkstone_rubble");
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

	public static final ResourceKey<PlacedFeature> SUNKETTLE_PATCH = IcariaPlacedFeatures.registerKey("sunkettle_patch");
	public static final ResourceKey<PlacedFeature> SUNSPONGE_PATCH = IcariaPlacedFeatures.registerKey("sunsponge_patch");

	public static final ResourceKey<PlacedFeature> MONDANOS = IcariaPlacedFeatures.registerKey("mondanos");

	public static final ResourceKey<PlacedFeature> GREEN_GROUND_SHROOMS = IcariaPlacedFeatures.registerKey("green_ground_shrooms");
	public static final ResourceKey<PlacedFeature> BROWN_GROUND_SHROOMS = IcariaPlacedFeatures.registerKey("brown_ground_shrooms");
	public static final ResourceKey<PlacedFeature> LARGE_BROWN_GROUND_SHROOMS = IcariaPlacedFeatures.registerKey("large_brown_ground_shrooms");

	public static final ResourceKey<PlacedFeature> CARDON_CACTUS = IcariaPlacedFeatures.registerKey("cardon_cactus");

	public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> pContext) {
		var configuredFeatures = pContext.lookup(Registries.CONFIGURED_FEATURE);

		pContext.register(IcariaPlacedFeatures.MARL_LIGNITE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.MARL_LIGNITE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.GRAINEL_CHERT, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRAINEL_CHERT), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRAINEL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.GRAINITE_SPIKE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRAINITE_SPIKE), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(IcariaBlocks.GRAINEL.get()), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.GRAINITE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GRAINITE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SILKSTONE_RUBBLE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SILKSTONE_RUBBLE), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
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

		pContext.register(IcariaPlacedFeatures.CYPRESS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CYPRESS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DROUGHTROOT_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DROUGHTROOT_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.FIR_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.FIR_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.LAUREL_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LAUREL_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.OLIVE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.OLIVE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.PLANE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PLANE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.POPULUS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.POPULUS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.DEAD_CYPRESS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_CYPRESS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_DROUGHTROOT_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_DROUGHTROOT_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_FIR_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_FIR_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_LAUREL_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_LAUREL_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_OLIVE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_OLIVE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_PLANE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_PLANE_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DEAD_POPULUS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DEAD_POPULUS_TREE), List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.DIRT), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.BLOOMY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BLOOMY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BRANCHY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BRANCHY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BRUSHY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BRUSHY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.DRY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DRY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.REEDY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.REEDY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SWIRLY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SWIRLY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.THORNY_VINE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.THORNY_VINE), List.of(CountPlacement.of(64), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.SUNKETTLE_PATCH, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SUNKETTLE_PATCH), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.SUNSPONGE_PATCH, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.SUNSPONGE_PATCH), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.MONDANOS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.MONDANOS), List.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.SAND), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.GREEN_GROUND_SHROOMS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.GREEN_GROUND_SHROOMS), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.BROWN_GROUND_SHROOMS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.BROWN_GROUND_SHROOMS), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
		pContext.register(IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LARGE_BROWN_GROUND_SHROOMS), List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));

		pContext.register(IcariaPlacedFeatures.CARDON_CACTUS, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CARDON_CACTUS), List.of(CountPlacement.of(8), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(96), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(BlockTags.SAND), BlockPredicate.replaceable(), 16), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome())));
	}

	public static ResourceKey<PlacedFeature> registerKey(String pName) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
