package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.world.feature.*;
import com.axanthic.icaria.common.world.feature.herb.*;
import com.axanthic.icaria.common.world.feature.hidden.HiddenGrainelChertFeature;
import com.axanthic.icaria.common.world.feature.hidden.HiddenMarlBonesFeature;
import com.axanthic.icaria.common.world.feature.hidden.HiddenMarlChertFeature;
import com.axanthic.icaria.common.world.feature.hidden.HiddenMarlLigniteFeature;
import com.axanthic.icaria.common.world.feature.lake.DryLakeFeature;
import com.axanthic.icaria.common.world.feature.lake.MediterraneanWaterLakeFeature;
import com.axanthic.icaria.common.world.feature.pillar.FallenRelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.pillar.RelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.shrooms.BrownGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.shrooms.GreenGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.shrooms.LargeBrownGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.tree.*;
import com.axanthic.icaria.common.world.feature.tree.dead.*;
import com.axanthic.icaria.common.world.feature.tree.fallen.*;
import com.axanthic.icaria.common.world.feature.tree.small.*;
import com.axanthic.icaria.common.world.feature.vine.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, IcariaIdents.ID);

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MARL_CHERT = IcariaFeatures.FEATURES.register("marl_chert", () -> new HiddenMarlChertFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MARL_BONES = IcariaFeatures.FEATURES.register("marl_bones", () -> new HiddenMarlBonesFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MARL_LIGNITE = IcariaFeatures.FEATURES.register("marl_lignite", () -> new HiddenMarlLigniteFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> GRAINEL_CHERT = IcariaFeatures.FEATURES.register("grainel_chert", () -> new HiddenGrainelChertFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> GRAINITE_SPIKE = IcariaFeatures.FEATURES.register("grainite_spike", () -> new GrainiteSpikeFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> YELLOWSTONE_BOULDER = IcariaFeatures.FEATURES.register("yellowstone_boulder", () -> new YellowstoneBoulderFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("fallen_relicstone_pillar", () -> new FallenRelicstonePillarFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("relicstone_pillar", () -> new RelicstonePillarFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> CYPRESS_TREE = IcariaFeatures.FEATURES.register("cypress_tree", () -> new CypressTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("droughtroot_tree", () -> new DroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FIR_TREE = IcariaFeatures.FEATURES.register("fir_tree", () -> new FirTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> LAUREL_TREE = IcariaFeatures.FEATURES.register("laurel_tree", () -> new LaurelTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> OLIVE_TREE = IcariaFeatures.FEATURES.register("olive_tree", () -> new OliveTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> PLANE_TREE = IcariaFeatures.FEATURES.register("plane_tree", () -> new PlaneTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> POPULUS_TREE = IcariaFeatures.FEATURES.register("populus_tree", () -> new PopulusTreeFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DEAD_CYPRESS_TREE = IcariaFeatures.FEATURES.register("dead_cypress_tree", () -> new DeadCypressTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DEAD_DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("dead_droughtroot_tree", () -> new DeadDroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DEAD_FIR_TREE = IcariaFeatures.FEATURES.register("dead_fir_tree", () -> new DeadFirTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DEAD_LAUREL_TREE = IcariaFeatures.FEATURES.register("dead_laurel_tree", () -> new DeadLaurelTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DEAD_OLIVE_TREE = IcariaFeatures.FEATURES.register("dead_olive_tree", () -> new DeadOliveTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DEAD_PLANE_TREE = IcariaFeatures.FEATURES.register("dead_plane_tree", () -> new DeadPlaneTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DEAD_POPULUS_TREE = IcariaFeatures.FEATURES.register("dead_populus_tree", () -> new DeadPopulusTreeFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_CYPRESS_TREE = IcariaFeatures.FEATURES.register("fallen_cypress_tree", () -> new FallenCypressTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("fallen_droughtroot_tree", () -> new FallenDroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_FIR_TREE = IcariaFeatures.FEATURES.register("fallen_fir_tree", () -> new FallenFirTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_LAUREL_TREE = IcariaFeatures.FEATURES.register("fallen_laurel_tree", () -> new FallenLaurelTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_OLIVE_TREE = IcariaFeatures.FEATURES.register("fallen_olive_tree", () -> new FallenOliveTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_PLANE_TREE = IcariaFeatures.FEATURES.register("fallen_plane_tree", () -> new FallenPlaneTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FALLEN_POPULUS_TREE = IcariaFeatures.FEATURES.register("fallen_populus_tree", () -> new FallenPopulusTreeFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SMALL_CYPRESS_TREE = IcariaFeatures.FEATURES.register("small_cypress_tree", () -> new SmallCypressTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SMALL_DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("small_droughtroot_tree", () -> new SmallDroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SMALL_FIR_TREE = IcariaFeatures.FEATURES.register("small_fir_tree", () -> new SmallFirTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SMALL_LAUREL_TREE = IcariaFeatures.FEATURES.register("small_laurel_tree", () -> new SmallLaurelTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SMALL_OLIVE_TREE = IcariaFeatures.FEATURES.register("small_olive_tree", () -> new SmallOliveTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SMALL_PLANE_TREE = IcariaFeatures.FEATURES.register("small_plane_tree", () -> new SmallPlaneTreeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SMALL_POPULUS_TREE = IcariaFeatures.FEATURES.register("small_populus_tree", () -> new SmallPopulusTreeFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BLOOMY_VINE = IcariaFeatures.FEATURES.register("bloomy_vine", () -> new BloomyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BRANCHY_VINE = IcariaFeatures.FEATURES.register("branchy_vine", () -> new BranchyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BRUSHY_VINE = IcariaFeatures.FEATURES.register("brushy_vine", () -> new BrushyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DRY_VINE = IcariaFeatures.FEATURES.register("dry_vine", () -> new DryVineFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> REEDY_VINE = IcariaFeatures.FEATURES.register("reedy_vine", () -> new ReedyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SWIRLY_VINE = IcariaFeatures.FEATURES.register("swirly_vine", () -> new SwirlyVineFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> THORNY_VINE = IcariaFeatures.FEATURES.register("thorny_vine", () -> new ThornyVineFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> VOIDLILY = IcariaFeatures.FEATURES.register("voidlily", () -> new VoidlilyFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BOLBOS = IcariaFeatures.FEATURES.register("bolbos", () -> new BolbosFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DATHULLA = IcariaFeatures.FEATURES.register("dathulla", () -> new DathullaFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MONDANOS = IcariaFeatures.FEATURES.register("mondanos", () -> new MondanosFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MOTH_AGARIC = IcariaFeatures.FEATURES.register("moth_agaric", () -> new MothAgaricFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> NAMDRAKE = IcariaFeatures.FEATURES.register("namdrake", () -> new NamdrakeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> PSILOCYBOS = IcariaFeatures.FEATURES.register("psilocybos", () -> new PsilocybosFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> ROWAN = IcariaFeatures.FEATURES.register("rowan", () -> new RowanFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> WILTED_ELM = IcariaFeatures.FEATURES.register("wilted_elm", () -> new WiltedElmFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> GREEN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("green_ground_shrooms", () -> new GreenGroundShroomsFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BROWN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("brown_ground_shrooms", () -> new BrownGroundShroomsFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> LARGE_BROWN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("large_brown_ground_shrooms", () -> new LargeBrownGroundShroomsFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> CARDON_CACTUS = IcariaFeatures.FEATURES.register("cardon_cactus", () -> new CardonCactusFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> STRAWBERRY_BUSH = IcariaFeatures.FEATURES.register("strawberry_bush", () -> new StrawberryBushFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DRY_LAKE = IcariaFeatures.FEATURES.register("dry_lake", () -> new DryLakeFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MEDITERRANEAN_WATER_LAKE = IcariaFeatures.FEATURES.register("mediterranean_water_lake", () -> new MediterraneanWaterLakeFeature(NoneFeatureConfiguration.CODEC));

	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> RUIN = IcariaFeatures.FEATURES.register("ruin", () -> new RuinFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> VILLAGE = IcariaFeatures.FEATURES.register("village", () -> new VillageFeature(NoneFeatureConfiguration.CODEC));
}
