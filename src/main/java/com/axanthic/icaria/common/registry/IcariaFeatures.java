package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.world.feature.*;
import com.axanthic.icaria.common.world.feature.dead.*;
import com.axanthic.icaria.common.world.feature.herb.*;
import com.axanthic.icaria.common.world.feature.hidden.GrainelChertHiddenFeature;
import com.axanthic.icaria.common.world.feature.hidden.MarlBonesHiddenFeature;
import com.axanthic.icaria.common.world.feature.hidden.MarlChertHiddenFeature;
import com.axanthic.icaria.common.world.feature.hidden.MarlLigniteHiddenFeature;
import com.axanthic.icaria.common.world.feature.lake.DryLakeFeature;
import com.axanthic.icaria.common.world.feature.lake.MediterraneanWaterLakeFeature;
import com.axanthic.icaria.common.world.feature.pillar.FallenRelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.pillar.HorizontalRelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.pillar.VerticalRelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.shrooms.BrownGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.shrooms.GreenGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.shrooms.LargeBrownGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.tree.*;
import com.axanthic.icaria.common.world.feature.vine.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, IcariaIdents.ID);

	public static final Supplier<Feature<NoneFeatureConfiguration>> MARL_CHERT = IcariaFeatures.FEATURES.register("marl_chert", () -> new MarlChertHiddenFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> MARL_BONES = IcariaFeatures.FEATURES.register("marl_bones", () -> new MarlBonesHiddenFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> MARL_LIGNITE = IcariaFeatures.FEATURES.register("marl_lignite", () -> new MarlLigniteHiddenFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> GRAINEL_CHERT = IcariaFeatures.FEATURES.register("grainel_chert", () -> new GrainelChertHiddenFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> GRAINITE_SPIKE = IcariaFeatures.FEATURES.register("grainite_spike", () -> new GrainiteSpikeFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> YELLOWSTONE_BOULDER = IcariaFeatures.FEATURES.register("yellowstone_boulder", () -> new YellowstoneBoulderFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> FALLEN_RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("fallen_relicstone_pillar", () -> new FallenRelicstonePillarFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> HORIZONTAL_RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("horizontal_relicstone_pillar", () -> new HorizontalRelicstonePillarFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> VERTICAL_RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("vertical_relicstone_pillar", () -> new VerticalRelicstonePillarFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> CYPRESS_TREE = IcariaFeatures.FEATURES.register("cypress_tree", () -> new CypressTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("droughtroot_tree", () -> new DroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> FIR_TREE = IcariaFeatures.FEATURES.register("fir_tree", () -> new FirTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> LAUREL_TREE = IcariaFeatures.FEATURES.register("laurel_tree", () -> new LaurelTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> OLIVE_TREE = IcariaFeatures.FEATURES.register("olive_tree", () -> new OliveTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> PLANE_TREE = IcariaFeatures.FEATURES.register("plane_tree", () -> new PlaneTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> POPULUS_TREE = IcariaFeatures.FEATURES.register("populus_tree", () -> new PopulusTreeFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> DEAD_CYPRESS_TREE = IcariaFeatures.FEATURES.register("dead_cypress_tree", () -> new DeadCypressTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DEAD_DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("dead_droughtroot_tree", () -> new DeadDroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DEAD_FIR_TREE = IcariaFeatures.FEATURES.register("dead_fir_tree", () -> new DeadFirTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DEAD_LAUREL_TREE = IcariaFeatures.FEATURES.register("dead_laurel_tree", () -> new DeadLaurelTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DEAD_OLIVE_TREE = IcariaFeatures.FEATURES.register("dead_olive_tree", () -> new DeadOliveTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DEAD_PLANE_TREE = IcariaFeatures.FEATURES.register("dead_plane_tree", () -> new DeadPlaneTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DEAD_POPULUS_TREE = IcariaFeatures.FEATURES.register("dead_populus_tree", () -> new DeadPopulusTreeFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> BLOOMY_VINE = IcariaFeatures.FEATURES.register("bloomy_vine", () -> new BloomyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> BRANCHY_VINE = IcariaFeatures.FEATURES.register("branchy_vine", () -> new BranchyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> BRUSHY_VINE = IcariaFeatures.FEATURES.register("brushy_vine", () -> new BrushyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DRY_VINE = IcariaFeatures.FEATURES.register("dry_vine", () -> new DryVineFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> REEDY_VINE = IcariaFeatures.FEATURES.register("reedy_vine", () -> new ReedyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> SWIRLY_VINE = IcariaFeatures.FEATURES.register("swirly_vine", () -> new SwirlyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> THORNY_VINE = IcariaFeatures.FEATURES.register("thorny_vine", () -> new ThornyVineFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> VOIDLILY = IcariaFeatures.FEATURES.register("voidlily", () -> new VoidlilyFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> BOLBOS = IcariaFeatures.FEATURES.register("bolbos", () -> new BolbosFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> DATHULLA = IcariaFeatures.FEATURES.register("dathulla", () -> new DathullaFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> MONDANOS = IcariaFeatures.FEATURES.register("mondanos", () -> new MondanosFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> MOTH_AGARIC = IcariaFeatures.FEATURES.register("moth_agaric", () -> new MothAgaricFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> NAMDRAKE = IcariaFeatures.FEATURES.register("namdrake", () -> new NamdrakeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> PSILOCYBOS = IcariaFeatures.FEATURES.register("psilocybos", () -> new PsilocybosFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> ROWAN = IcariaFeatures.FEATURES.register("rowan", () -> new RowanFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> WILTED_ELM = IcariaFeatures.FEATURES.register("wilted_elm", () -> new WiltedElmFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> GREEN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("green_ground_shrooms", () -> new GreenGroundShroomsFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> BROWN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("brown_ground_shrooms", () -> new BrownGroundShroomsFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> LARGE_BROWN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("large_brown_ground_shrooms", () -> new LargeBrownGroundShroomsFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> CARDON_CACTUS = IcariaFeatures.FEATURES.register("cardon_cactus", () -> new CardonCactusFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> STRAWBERRY_BUSH = IcariaFeatures.FEATURES.register("strawberry_bush", () -> new StrawberryBushFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> DRY_LAKE = IcariaFeatures.FEATURES.register("dry_lake", () -> new DryLakeFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> MEDITERRANEAN_WATER_LAKE = IcariaFeatures.FEATURES.register("mediterranean_water_lake", () -> new MediterraneanWaterLakeFeature(NoneFeatureConfiguration.CODEC));

	public static final Supplier<Feature<NoneFeatureConfiguration>> RUIN = IcariaFeatures.FEATURES.register("ruin", () -> new RuinFeature(NoneFeatureConfiguration.CODEC));
	public static final Supplier<Feature<NoneFeatureConfiguration>> VILLAGE = IcariaFeatures.FEATURES.register("village", () -> new VillageFeature(NoneFeatureConfiguration.CODEC));
}
