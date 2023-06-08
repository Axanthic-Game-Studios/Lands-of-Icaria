package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import net.minecraftforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfiguredFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, IcariaInfo.ID);

	public static final ResourceKey<ConfiguredFeature<?, ?>> MARL_LIGNITE = IcariaConfiguredFeatures.registerKey("marl_lignite");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GRAINEL_CHERT = IcariaConfiguredFeatures.registerKey("grainel_chert");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GRAINITE_SPIKE = IcariaConfiguredFeatures.registerKey("grainite_spike");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GRAINITE_RUBBLE = IcariaConfiguredFeatures.registerKey("grainite_rubble");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SILKSTONE_RUBBLE = IcariaConfiguredFeatures.registerKey("silkstone_rubble");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RELICSTONE_RUBBLE = IcariaConfiguredFeatures.registerKey("relicstone_rubble");

	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_RELICSTONE_PILLAR = IcariaConfiguredFeatures.registerKey("fallen_relicstone_pillar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HORIZONTAL_RELICSTONE_PILLAR = IcariaConfiguredFeatures.registerKey("horizontal_relicstone_pillar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> VERTICAL_RELICSTONE_PILLAR = IcariaConfiguredFeatures.registerKey("vertical_relicstone_pillar");

	public static final ResourceKey<ConfiguredFeature<?, ?>> LIGNITE_ORE = IcariaConfiguredFeatures.registerKey("lignite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHALKOS_ORE = IcariaConfiguredFeatures.registerKey("chalkos_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> KASSITEROS_ORE = IcariaConfiguredFeatures.registerKey("kassiteros_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DOLOMITE_ORE = IcariaConfiguredFeatures.registerKey("dolomite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> VANADIUM_ORE = IcariaConfiguredFeatures.registerKey("vanadium_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SLIVER_ORE = IcariaConfiguredFeatures.registerKey("sliver_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SIDEROS_ORE = IcariaConfiguredFeatures.registerKey("sideros_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ANTHRACITE_ORE = IcariaConfiguredFeatures.registerKey("anthracite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MOLYBDENUM_ORE = IcariaConfiguredFeatures.registerKey("molybdenum_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HYLIASTRUM_ORE = IcariaConfiguredFeatures.registerKey("hyliastrum_ore");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE_CRYSTAL = IcariaConfiguredFeatures.registerKey("calcite_crystal");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HALITE_CRYSTAL = IcariaConfiguredFeatures.registerKey("halite_crystal");
	public static final ResourceKey<ConfiguredFeature<?, ?>> JASPER_CRYSTAL = IcariaConfiguredFeatures.registerKey("jasper_crystal");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCON_CRYSTAL = IcariaConfiguredFeatures.registerKey("zircon_crystal");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE = IcariaConfiguredFeatures.registerKey("cypress_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DROUGHTROOT_TREE = IcariaConfiguredFeatures.registerKey("droughtroot_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_TREE = IcariaConfiguredFeatures.registerKey("fir_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LAUREL_TREE = IcariaConfiguredFeatures.registerKey("laurel_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE_TREE = IcariaConfiguredFeatures.registerKey("olive_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PLANE_TREE = IcariaConfiguredFeatures.registerKey("plane_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> POPULUS_TREE = IcariaConfiguredFeatures.registerKey("populus_tree");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CYPRESS_TREE = IcariaConfiguredFeatures.registerKey("dead_cypress_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_DROUGHTROOT_TREE = IcariaConfiguredFeatures.registerKey("dead_droughtroot_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_FIR_TREE = IcariaConfiguredFeatures.registerKey("dead_fir_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_LAUREL_TREE = IcariaConfiguredFeatures.registerKey("dead_laurel_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_OLIVE_TREE = IcariaConfiguredFeatures.registerKey("dead_olive_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PLANE_TREE = IcariaConfiguredFeatures.registerKey("dead_plane_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_POPULUS_TREE = IcariaConfiguredFeatures.registerKey("dead_populus_tree");

	public static final ResourceKey<ConfiguredFeature<?, ?>> BLOOMY_VINE = IcariaConfiguredFeatures.registerKey("bloomy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRANCHY_VINE = IcariaConfiguredFeatures.registerKey("branchy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRUSHY_VINE = IcariaConfiguredFeatures.registerKey("brushy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRY_VINE = IcariaConfiguredFeatures.registerKey("dry_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> REEDY_VINE = IcariaConfiguredFeatures.registerKey("reedy_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SWIRLY_VINE = IcariaConfiguredFeatures.registerKey("swirly_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> THORNY_VINE = IcariaConfiguredFeatures.registerKey("thorny_vine");

	public static final ResourceKey<ConfiguredFeature<?, ?>> SUNKETTLE_PATCH = IcariaConfiguredFeatures.registerKey("sunkettle_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SUNSPONGE_PATCH = IcariaConfiguredFeatures.registerKey("sunsponge_patch");

	public static final ResourceKey<ConfiguredFeature<?, ?>> MONDANOS = IcariaConfiguredFeatures.registerKey("mondanos");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_GROUND_SHROOMS = IcariaConfiguredFeatures.registerKey("green_ground_shrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_GROUND_SHROOMS = IcariaConfiguredFeatures.registerKey("brown_ground_shrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BROWN_GROUND_SHROOMS = IcariaConfiguredFeatures.registerKey("large_brown_ground_shrooms");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CARDON_CACTUS = IcariaConfiguredFeatures.registerKey("cardon_cactus");

	public static void bootstrapConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
		var marl = new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_MARL);
		var yellowstone = new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_YELLOWSTONE);
		var silkstone = new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_SILKSTONE);
		var sunstone = new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_SUNSTONE);
		var voidshale = new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_VOIDSHALE);
		var baetyl = new TagMatchTest(IcariaBlockTags.ORE_BEARING_GROUND_BAETYL);

		pContext.register(IcariaConfiguredFeatures.MARL_LIGNITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(marl, IcariaBlocks.MARL_LIGNITE.get().defaultBlockState(), 9)));

		pContext.register(IcariaConfiguredFeatures.GRAINEL_CHERT, new ConfiguredFeature<>(IcariaFeatures.GRAINEL_CHERT.get(), FeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.GRAINITE_SPIKE, new ConfiguredFeature<>(IcariaFeatures.GRAINITE_SPIKE.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.GRAINITE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.GRAINITE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.GRAINEL.get()), BlockPredicate.noFluid(), BlockPredicate.replaceable())))));
		pContext.register(IcariaConfiguredFeatures.SILKSTONE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SILKSTONE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), IcariaBlocks.SILKSAND.get()), BlockPredicate.noFluid(), BlockPredicate.replaceable())))));
		pContext.register(IcariaConfiguredFeatures.RELICSTONE_RUBBLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.RELICSTONE_RUBBLE.get())), BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.replaceable(), BlockPredicate.solid(Direction.DOWN.getNormal()))))));

		pContext.register(IcariaConfiguredFeatures.FALLEN_RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.FALLEN_RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.HORIZONTAL_RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.HORIZONTAL_RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.VERTICAL_RELICSTONE_PILLAR, new ConfiguredFeature<>(IcariaFeatures.VERTICAL_RELICSTONE_PILLAR.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.LIGNITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(yellowstone, IcariaBlocks.LIGNITE_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.CHALKOS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(yellowstone, IcariaBlocks.CHALKOS_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.KASSITEROS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(silkstone, IcariaBlocks.KASSITEROS_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.DOLOMITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(silkstone, IcariaBlocks.DOLOMITE_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.VANADIUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sunstone, IcariaBlocks.VANADIUM_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.SLIVER_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sunstone, IcariaBlocks.SLIVER_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.SIDEROS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(voidshale, IcariaBlocks.SIDEROS_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.ANTHRACITE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(voidshale, IcariaBlocks.ANTHRACITE_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.MOLYBDENUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(baetyl, IcariaBlocks.MOLYBDENUM_ORE.get().defaultBlockState(), 9)));
		pContext.register(IcariaConfiguredFeatures.HYLIASTRUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(baetyl, IcariaBlocks.HYLIASTRUM_ORE.get().defaultBlockState(), 9)));

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

		pContext.register(IcariaConfiguredFeatures.SUNKETTLE_PATCH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNKETTLE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.noFluid(), BlockPredicate.replaceable())))));
		pContext.register(IcariaConfiguredFeatures.SUNSPONGE_PATCH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 4, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(IcariaBlocks.SUNSPONGE.get())), BlockPredicate.allOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.noFluid(), BlockPredicate.replaceable())))));

		pContext.register(IcariaConfiguredFeatures.MONDANOS, new ConfiguredFeature<>(IcariaFeatures.MONDANOS.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.GREEN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.GREEN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.BROWN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.BROWN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.LARGE_BROWN_GROUND_SHROOMS, new ConfiguredFeature<>(IcariaFeatures.LARGE_BROWN_GROUND_SHROOMS.get(), NoneFeatureConfiguration.NONE));

		pContext.register(IcariaConfiguredFeatures.CARDON_CACTUS, new ConfiguredFeature<>(IcariaFeatures.CARDON_CACTUS.get(), NoneFeatureConfiguration.NONE));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String pName) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
