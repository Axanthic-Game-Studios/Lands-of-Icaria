package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFeatureIds;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.tags.IcariaBlockItemTags;
import com.axanthic.icaria.common.world.feature.*;
import com.axanthic.icaria.common.world.feature.herb.*;
import com.axanthic.icaria.common.world.feature.pillar.FallenRelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.pillar.RelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.tree.*;
import com.axanthic.icaria.common.world.feature.tree.fallen.*;
import com.axanthic.icaria.common.world.feature.tree.small.*;
import com.axanthic.icaria.common.world.feature.vine.*;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFeatures {
	public static void bootstrap(BootstrapContext<Feature> pBootstrapContext) {
		pBootstrapContext.register(IcariaFeatureIds.MARL_CHERT, new HiddenFeature(IcariaBlocks.MARL_CHERT_ORE.get().defaultBlockState(), IcariaBlocks.CHERT_RUBBLE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.MARL_BONES, new HiddenFeature(IcariaBlocks.MARL_BONES.get().defaultBlockState(), IcariaBlocks.BONES.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.MARL_LIGNITE, new HiddenFeature(IcariaBlocks.MARL_LIGNITE_ORE.get().defaultBlockState(), IcariaBlocks.LIGNITE_RUBBLE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.GRAINEL_CHERT, new HiddenFeature(IcariaBlocks.CHERT_ORE.get().defaultBlockState(), IcariaBlocks.CHERT_RUBBLE.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.GRAINITE_SPIKE, new SpikeFeature(IcariaBlocks.GRAINITE.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.YELLOWSTONE_BOULDER, new BoulderFeature(IcariaBlocks.YELLOWSTONE.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.GRAINITE_RUBBLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.GRAINITE_RUBBLE.get())));
		pBootstrapContext.register(IcariaFeatureIds.YELLOWSTONE_RUBBLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.YELLOWSTONE_RUBBLE.get())));
		pBootstrapContext.register(IcariaFeatureIds.SILKSTONE_RUBBLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.SILKSTONE_RUBBLE.get())));
		pBootstrapContext.register(IcariaFeatureIds.SUNSTONE_RUBBLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.SUNSTONE_RUBBLE.get())));
		pBootstrapContext.register(IcariaFeatureIds.VOIDSHALE_RUBBLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.VOIDSHALE_RUBBLE.get())));
		pBootstrapContext.register(IcariaFeatureIds.BAETYL_RUBBLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.BAETYL_RUBBLE.get())));
		pBootstrapContext.register(IcariaFeatureIds.RELICSTONE_RUBBLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.RELICSTONE_RUBBLE.get())));

		pBootstrapContext.register(IcariaFeatureIds.FALLEN_RELICSTONE_PILLAR, new FallenRelicstonePillarFeature());
		pBootstrapContext.register(IcariaFeatureIds.RELICSTONE_PILLAR, new RelicstonePillarFeature());

		pBootstrapContext.register(IcariaFeatureIds.LIGNITE_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_YELLOWSTONE.block()), IcariaBlocks.LIGNITE_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.CHALKOS_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_YELLOWSTONE.block()), IcariaBlocks.CHALKOS_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.KASSITEROS_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SILKSTONE.block()), IcariaBlocks.KASSITEROS_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.DOLOMITE_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SILKSTONE.block()), IcariaBlocks.DOLOMITE_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.VANADIUM_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SUNSTONE.block()), IcariaBlocks.VANADIUM_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.SLIVER_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_SUNSTONE.block()), IcariaBlocks.SLIVER_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.SIDEROS_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_VOIDSHALE.block()), IcariaBlocks.SIDEROS_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.ANTHRACITE_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_VOIDSHALE.block()), IcariaBlocks.ANTHRACITE_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.MOLYBDENUM_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_BAETYL.block()), IcariaBlocks.MOLYBDENUM_ORE.get().defaultBlockState(), 9));
		pBootstrapContext.register(IcariaFeatureIds.HYLIASTRUM_ORE, new OreFeature(new TagMatchTest(IcariaBlockItemTags.ORE_BEARING_GROUND_BAETYL.block()), IcariaBlocks.HYLIASTRUM_ORE.get().defaultBlockState(), 9));

		pBootstrapContext.register(IcariaFeatureIds.CALCITE_CLUSTER, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.CALCITE_CLUSTER.get())));
		pBootstrapContext.register(IcariaFeatureIds.HALITE_CLUSTER, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.HALITE_CLUSTER.get())));
		pBootstrapContext.register(IcariaFeatureIds.JASPER_CLUSTER, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.JASPER_CLUSTER.get())));
		pBootstrapContext.register(IcariaFeatureIds.ZIRCON_CLUSTER, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.ZIRCON_CLUSTER.get())));

		pBootstrapContext.register(IcariaFeatureIds.CYPRESS_TREE, new CypressTreeFeature(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get().defaultBlockState(), IcariaBlocks.CYPRESS_LEAVES.get().defaultBlockState(), IcariaBlocks.CYPRESS_LOG.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.CYPRESS_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.DROUGHTROOT_TREE, new DroughtrootTreeFeature(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_LEAVES.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_LOG.get().defaultBlockState(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.FIR_TREE, new FirTreeFeature(IcariaBlocks.FALLEN_FIR_LEAVES.get().defaultBlockState(), IcariaBlocks.FIR_LEAVES.get().defaultBlockState(), IcariaBlocks.FIR_LOG.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.FIR_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.LAUREL_TREE, new LaurelTreeFeature(IcariaBlocks.FALLEN_LAUREL_LEAVES.get().defaultBlockState(), IcariaBlocks.LAUREL_LEAVES.get().defaultBlockState(), IcariaBlocks.LAUREL_LOG.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.LAUREL_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.OLIVE_TREE, new OliveTreeFeature(IcariaBlocks.FALLEN_OLIVE_LEAVES.get().defaultBlockState(), IcariaBlocks.OLIVE_LEAVES.get().defaultBlockState(), IcariaBlocks.OLIVE_LOG.get().defaultBlockState(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.OLIVE_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.PLANE_TREE, new PlaneTreeFeature(IcariaBlocks.FALLEN_PLANE_LEAVES.get().defaultBlockState(), IcariaBlocks.PLANE_LEAVES.get().defaultBlockState(), IcariaBlocks.PLANE_LOG.get().defaultBlockState(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.PLANE_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.POPULUS_TREE, new PopulusTreeFeature(IcariaBlocks.FALLEN_POPULUS_LEAVES.get().defaultBlockState(), IcariaBlocks.POPULUS_LEAVES.get().defaultBlockState(), IcariaBlocks.POPULUS_LOG.get().defaultBlockState(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.POPULUS_TWIGS.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.DEAD_CYPRESS_TREE, new DeadTreeFeature(IcariaBlocks.DEAD_CYPRESS_LOG.get().defaultBlockState(), IcariaBlocks.CYPRESS_LOG.get().defaultBlockState(), IcariaBlocks.STEPPE_MOSS.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.CYPRESS_TWIGS.get().defaultBlockState(), 5, 8));
		pBootstrapContext.register(IcariaFeatureIds.DEAD_DROUGHTROOT_TREE, new DeadTreeFeature(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_LOG.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_TWIGS.get().defaultBlockState(), 3, 11));
		pBootstrapContext.register(IcariaFeatureIds.DEAD_FIR_TREE, new DeadTreeFeature(IcariaBlocks.DEAD_FIR_LOG.get().defaultBlockState(), IcariaBlocks.FIR_LOG.get().defaultBlockState(), IcariaBlocks.FOREST_MOSS.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.FIR_TWIGS.get().defaultBlockState(), 8, 10));
		pBootstrapContext.register(IcariaFeatureIds.DEAD_LAUREL_TREE, new DeadTreeFeature(IcariaBlocks.DEAD_LAUREL_LOG.get().defaultBlockState(), IcariaBlocks.LAUREL_LOG.get().defaultBlockState(), IcariaBlocks.SCRUBLAND_MOSS.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.LAUREL_TWIGS.get().defaultBlockState(), 1, 3));
		pBootstrapContext.register(IcariaFeatureIds.DEAD_OLIVE_TREE, new DeadTreeFeature(IcariaBlocks.DEAD_OLIVE_LOG.get().defaultBlockState(), IcariaBlocks.OLIVE_LOG.get().defaultBlockState(), IcariaBlocks.STEPPE_MOSS.get().defaultBlockState(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.OLIVE_TWIGS.get().defaultBlockState(), 5, 5));
		pBootstrapContext.register(IcariaFeatureIds.DEAD_PLANE_TREE, new DeadTreeFeature(IcariaBlocks.DEAD_PLANE_LOG.get().defaultBlockState(), IcariaBlocks.PLANE_LOG.get().defaultBlockState(), IcariaBlocks.SCRUBLAND_MOSS.get().defaultBlockState(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.PLANE_TWIGS.get().defaultBlockState(), 1, 3));
		pBootstrapContext.register(IcariaFeatureIds.DEAD_POPULUS_TREE, new DeadTreeFeature(IcariaBlocks.DEAD_POPULUS_LOG.get().defaultBlockState(), IcariaBlocks.POPULUS_LOG.get().defaultBlockState(), IcariaBlocks.FOREST_MOSS.get().defaultBlockState(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.POPULUS_TWIGS.get().defaultBlockState(), 6, 8));

		pBootstrapContext.register(IcariaFeatureIds.FALLEN_CYPRESS_TREE, new FallenCypressTreeFeature(IcariaBlocks.DEAD_CYPRESS_LOG.get().defaultBlockState(), IcariaBlocks.CYPRESS_LEAVES.get().defaultBlockState(), IcariaBlocks.CYPRESS_LOG.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.CYPRESS_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.FALLEN_DROUGHTROOT_TREE, new FallenDroughtrootTreeFeature(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_LEAVES.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_LOG.get().defaultBlockState(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.FALLEN_FIR_TREE, new FallenFirTreeFeature(IcariaBlocks.DEAD_FIR_LOG.get().defaultBlockState(), IcariaBlocks.FIR_LEAVES.get().defaultBlockState(), IcariaBlocks.FIR_LOG.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.FIR_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.FALLEN_LAUREL_TREE, new FallenLaurelTreeFeature(IcariaBlocks.DEAD_LAUREL_LOG.get().defaultBlockState(), IcariaBlocks.LAUREL_LEAVES.get().defaultBlockState(), IcariaBlocks.LAUREL_LOG.get().defaultBlockState(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.LAUREL_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.FALLEN_OLIVE_TREE, new FallenOliveTreeFeature(IcariaBlocks.DEAD_OLIVE_LOG.get().defaultBlockState(), IcariaBlocks.OLIVE_LEAVES.get().defaultBlockState(), IcariaBlocks.OLIVE_LOG.get().defaultBlockState(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.OLIVE_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.FALLEN_PLANE_TREE, new FallenPlaneTreeFeature(IcariaBlocks.DEAD_PLANE_LOG.get().defaultBlockState(), IcariaBlocks.PLANE_LEAVES.get().defaultBlockState(), IcariaBlocks.PLANE_LOG.get().defaultBlockState(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.PLANE_TWIGS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.FALLEN_POPULUS_TREE, new FallenPopulusTreeFeature(IcariaBlocks.DEAD_POPULUS_LOG.get().defaultBlockState(), IcariaBlocks.POPULUS_LEAVES.get().defaultBlockState(), IcariaBlocks.POPULUS_LOG.get().defaultBlockState(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get().defaultBlockState(), IcariaBlocks.POPULUS_TWIGS.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.SMALL_CYPRESS_TREE, new SmallCypressTreeFeature(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get().defaultBlockState(), IcariaBlocks.CYPRESS_LEAVES.get().defaultBlockState(), IcariaBlocks.CYPRESS_LOG.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.SMALL_DROUGHTROOT_TREE, new SmallDroughtrootTreeFeature(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_LEAVES.get().defaultBlockState(), IcariaBlocks.DROUGHTROOT_LOG.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.SMALL_FIR_TREE, new SmallFirTreeFeature(IcariaBlocks.FALLEN_FIR_LEAVES.get().defaultBlockState(), IcariaBlocks.FIR_LEAVES.get().defaultBlockState(), IcariaBlocks.FIR_LOG.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.SMALL_LAUREL_TREE, new SmallLaurelTreeFeature(IcariaBlocks.FALLEN_LAUREL_LEAVES.get().defaultBlockState(), IcariaBlocks.LAUREL_LEAVES.get().defaultBlockState(), IcariaBlocks.LAUREL_LOG.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.SMALL_OLIVE_TREE, new SmallOliveTreeFeature(IcariaBlocks.FALLEN_OLIVE_LEAVES.get().defaultBlockState(), IcariaBlocks.OLIVE_LEAVES.get().defaultBlockState(), IcariaBlocks.OLIVE_LOG.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.SMALL_PLANE_TREE, new SmallPlaneTreeFeature(IcariaBlocks.FALLEN_PLANE_LEAVES.get().defaultBlockState(), IcariaBlocks.PLANE_LEAVES.get().defaultBlockState(), IcariaBlocks.PLANE_LOG.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.SMALL_POPULUS_TREE, new SmallPopulusTreeFeature(IcariaBlocks.FALLEN_POPULUS_LEAVES.get().defaultBlockState(), IcariaBlocks.POPULUS_LEAVES.get().defaultBlockState(), IcariaBlocks.POPULUS_LOG.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.BLOOMY_VINE, new BloomyVineFeature(IcariaBlocks.BLOOMY_VINE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.BRANCHY_VINE, new BranchyVineFeature(IcariaBlocks.BRANCHY_VINE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.BRUSHY_VINE, new BrushyVineFeature(IcariaBlocks.BRUSHY_VINE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.DRY_VINE, new DryVineFeature(IcariaBlocks.DRY_VINE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.REEDY_VINE, new ReedyVineFeature(IcariaBlocks.REEDY_VINE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.SWIRLY_VINE, new SwirlyVineFeature(IcariaBlocks.SWIRLY_VINE.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.THORNY_VINE, new ThornyVineFeature(IcariaBlocks.THORNY_VINE.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.GRASS, new SimpleBlockFeature(new WeightedStateProvider(WeightedList.<BlockState>builder().add(IcariaBlocks.SMALL_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_GRASS.get().defaultBlockState(), 1))));
		pBootstrapContext.register(IcariaFeatureIds.GRAIN, new SimpleBlockFeature(new WeightedStateProvider(WeightedList.<BlockState>builder().add(IcariaBlocks.SMALL_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_BROWN_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_WHITE_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_BROWN_GRAIN.get().defaultBlockState(), 1))));

		pBootstrapContext.register(IcariaFeatureIds.CALCITE_DUST, new SimpleBlockFeature(new WeightedStateProvider(WeightedList.<BlockState>builder().add(IcariaBlocks.SMALL_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_GRASS.get().defaultBlockState(), 1).add(IcariaBlocks.SMALL_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_MIXED_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_BROWN_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_WHITE_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get().defaultBlockState(), 1).add(IcariaBlocks.LARGE_BROWN_GRAIN.get().defaultBlockState(), 1))));

		pBootstrapContext.register(IcariaFeatureIds.BLINDWEED, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.BLINDWEED.get())));
		pBootstrapContext.register(IcariaFeatureIds.CHAMEOMILE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.CHAMEOMILE.get())));
		pBootstrapContext.register(IcariaFeatureIds.CHARMONDER, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.CHARMONDER.get())));
		pBootstrapContext.register(IcariaFeatureIds.CLOVER, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.CLOVER.get())));
		pBootstrapContext.register(IcariaFeatureIds.FIREHILT, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.FIREHILT.get())));
		pBootstrapContext.register(IcariaFeatureIds.BLUE_HYDRACINTH, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.BLUE_HYDRACINTH.get())));
		pBootstrapContext.register(IcariaFeatureIds.PURPLE_HYDRACINTH, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.PURPLE_HYDRACINTH.get())));
		pBootstrapContext.register(IcariaFeatureIds.LIONFANGS, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.LIONFANGS.get())));
		pBootstrapContext.register(IcariaFeatureIds.SPEARDROPS, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.SPEARDROPS.get())));
		pBootstrapContext.register(IcariaFeatureIds.PURPLE_STAGHORN, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.PURPLE_STAGHORN.get())));
		pBootstrapContext.register(IcariaFeatureIds.YELLOW_STAGHORN, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.YELLOW_STAGHORN.get())));
		pBootstrapContext.register(IcariaFeatureIds.BLUE_STORMCOTTON, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.BLUE_STORMCOTTON.get())));
		pBootstrapContext.register(IcariaFeatureIds.PINK_STORMCOTTON, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.PINK_STORMCOTTON.get())));
		pBootstrapContext.register(IcariaFeatureIds.PURPLE_STORMCOTTON, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.PURPLE_STORMCOTTON.get())));
		pBootstrapContext.register(IcariaFeatureIds.SUNKETTLE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.SUNKETTLE.get())));
		pBootstrapContext.register(IcariaFeatureIds.SUNSPONGE, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.SUNSPONGE.get())));
		pBootstrapContext.register(IcariaFeatureIds.VOIDLILY, new VoidlilyFeature());

		pBootstrapContext.register(IcariaFeatureIds.BOLBOS, new BolbosFeature());
		pBootstrapContext.register(IcariaFeatureIds.DATHULLA, new DathullaFeature());
		pBootstrapContext.register(IcariaFeatureIds.MONDANOS, new MondanosFeature());
		pBootstrapContext.register(IcariaFeatureIds.MOTH_AGARIC, new MothAgaricFeature());
		pBootstrapContext.register(IcariaFeatureIds.NAMDRAKE, new NamdrakeFeature());
		pBootstrapContext.register(IcariaFeatureIds.PSILOCYBOS, new PsilocybosFeature());
		pBootstrapContext.register(IcariaFeatureIds.ROWAN, new RowanFeature());
		pBootstrapContext.register(IcariaFeatureIds.WILTED_ELM, new WiltedElmFeature());

		pBootstrapContext.register(IcariaFeatureIds.BLUE_GROUND_FLOWERS, new GroundFlowersFeature(IcariaBlocks.BLUE_GROUND_FLOWERS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.CYAN_GROUND_FLOWERS, new GroundFlowersFeature(IcariaBlocks.CYAN_GROUND_FLOWERS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.PINK_GROUND_FLOWERS, new GroundFlowersFeature(IcariaBlocks.PINK_GROUND_FLOWERS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.PURPLE_GROUND_FLOWERS, new GroundFlowersFeature(IcariaBlocks.PURPLE_GROUND_FLOWERS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.RED_GROUND_FLOWERS, new GroundFlowersFeature(IcariaBlocks.RED_GROUND_FLOWERS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.WHITE_GROUND_FLOWERS, new GroundFlowersFeature(IcariaBlocks.WHITE_GROUND_FLOWERS.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.PALM_FERN, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.PALM_FERN.get())));

		pBootstrapContext.register(IcariaFeatureIds.WHITE_BROMELIA, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.WHITE_BROMELIA.get())));
		pBootstrapContext.register(IcariaFeatureIds.ORANGE_BROMELIA, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.ORANGE_BROMELIA.get())));
		pBootstrapContext.register(IcariaFeatureIds.PINK_BROMELIA, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.PINK_BROMELIA.get())));
		pBootstrapContext.register(IcariaFeatureIds.PURPLE_BROMELIA, new SimpleBlockFeature(BlockStateProvider.holderOf(IcariaBlocks.PURPLE_BROMELIA.get())));

		pBootstrapContext.register(IcariaFeatureIds.GREEN_GROUND_SHROOMS, new GroundShroomsFeature(IcariaBlocks.GREEN_GROUND_SHROOMS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.BROWN_GROUND_SHROOMS, new GroundShroomsFeature(IcariaBlocks.BROWN_GROUND_SHROOMS.get().defaultBlockState()));
		pBootstrapContext.register(IcariaFeatureIds.LARGE_BROWN_GROUND_SHROOMS, new GroundShroomsFeature(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get().defaultBlockState()));

		pBootstrapContext.register(IcariaFeatureIds.CARDON_CACTUS, new CardonCactusFeature());

		pBootstrapContext.register(IcariaFeatureIds.STRAWBERRY_BUSH, new StrawberryBushFeature());

		pBootstrapContext.register(IcariaFeatureIds.DRY_LAKE, new LakeFeature(BlockStateProvider.holderOf(Blocks.AIR), BlockStateProvider.holderOf(IcariaBlocks.DRY_LAKE_BED.get()), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue()));
		pBootstrapContext.register(IcariaFeatureIds.MEDITERRANEAN_WATER_LAKE, new LakeFeature(BlockStateProvider.holderOf(IcariaBlocks.MEDITERRANEAN_WATER.get()), BlockStateProvider.holderOf(IcariaBlocks.GRASSY_MARL.get()), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue(), BlockPredicate.alwaysTrue()));

		pBootstrapContext.register(IcariaFeatureIds.RUIN, new RuinFeature());
		pBootstrapContext.register(IcariaFeatureIds.VILLAGE, new VillageFeature());
	}
}
