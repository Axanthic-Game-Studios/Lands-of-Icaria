package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.feature.*;
import com.axanthic.icaria.common.world.feature.dead.*;
import com.axanthic.icaria.common.world.feature.shrooms.BrownGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.shrooms.GreenGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.shrooms.LargeBrownGroundShroomsFeature;
import com.axanthic.icaria.common.world.feature.tree.*;
import com.axanthic.icaria.common.world.feature.hidden.GrainelChertFeature;
import com.axanthic.icaria.common.world.feature.hidden.MarlBonesFeature;
import com.axanthic.icaria.common.world.feature.hidden.MarlChertFeature;
import com.axanthic.icaria.common.world.feature.vine.*;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, IcariaInfo.ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MARL_CHERT = IcariaFeatures.FEATURES.register("marl_chert", () -> new MarlChertFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MARL_BONES = IcariaFeatures.FEATURES.register("marl_bones", () -> new MarlBonesFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GRAINEL_CHERT = IcariaFeatures.FEATURES.register("grainel_chert", () -> new GrainelChertFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GRAINITE_SPIKE = IcariaFeatures.FEATURES.register("grainite_spike", () -> new GrainiteSpikeFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> YELLOWSTONE_BOULDER = IcariaFeatures.FEATURES.register("yellowstone_boulder", () -> new YellowstoneBoulderFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FALLEN_RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("fallen_relicstone_pillar", () -> new FallenRelicstonePillarFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> HORIZONTAL_RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("horizontal_relicstone_pillar", () -> new HorizontalRelicstonePillarFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> VERTICAL_RELICSTONE_PILLAR = IcariaFeatures.FEATURES.register("vertical_relicstone_pillar", () -> new VerticalRelicstonePillarFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CYPRESS_TREE = IcariaFeatures.FEATURES.register("cypress_tree", () -> new CypressTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("droughtroot_tree", () -> new DroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FIR_TREE = IcariaFeatures.FEATURES.register("fir_tree", () -> new FirTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LAUREL_TREE = IcariaFeatures.FEATURES.register("laurel_tree", () -> new LaurelTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> OLIVE_TREE = IcariaFeatures.FEATURES.register("olive_tree", () -> new OliveTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PLANE_TREE = IcariaFeatures.FEATURES.register("plane_tree", () -> new PlaneTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> POPULUS_TREE = IcariaFeatures.FEATURES.register("populus_tree", () -> new PopulusTreeFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DEAD_CYPRESS_TREE = IcariaFeatures.FEATURES.register("dead_cypress_tree", () -> new DeadCypressTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DEAD_DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("dead_droughtroot_tree", () -> new DeadDroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DEAD_FIR_TREE = IcariaFeatures.FEATURES.register("dead_fir_tree", () -> new DeadFirTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DEAD_LAUREL_TREE = IcariaFeatures.FEATURES.register("dead_laurel_tree", () -> new DeadLaurelTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DEAD_OLIVE_TREE = IcariaFeatures.FEATURES.register("dead_olive_tree", () -> new DeadOliveTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DEAD_PLANE_TREE = IcariaFeatures.FEATURES.register("dead_plane_tree", () -> new DeadPlaneTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DEAD_POPULUS_TREE = IcariaFeatures.FEATURES.register("dead_populus_tree", () -> new DeadPopulusTreeFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BLOOMY_VINE = IcariaFeatures.FEATURES.register("bloomy_vine", () -> new BloomyVineFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BRANCHY_VINE = IcariaFeatures.FEATURES.register("branchy_vine", () -> new BranchyVineFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BRUSHY_VINE = IcariaFeatures.FEATURES.register("brushy_vine", () -> new BrushyVineFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DRY_VINE = IcariaFeatures.FEATURES.register("dry_vine", () -> new DryVineFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> REEDY_VINE = IcariaFeatures.FEATURES.register("reedy_vine", () -> new ReedyVineFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SWIRLY_VINE = IcariaFeatures.FEATURES.register("swirly_vine", () -> new SwirlyVineFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> THORNY_VINE = IcariaFeatures.FEATURES.register("thorny_vine", () -> new ThornyVineFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MONDANOS = IcariaFeatures.FEATURES.register("mondanos", () -> new MondanosFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> NAMDRAKE = IcariaFeatures.FEATURES.register("namdrake", () -> new NamdrakeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PSILOCYBOS = IcariaFeatures.FEATURES.register("psilocybos", () -> new PsilocybosFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ROWAN = IcariaFeatures.FEATURES.register("rowan", () -> new RowanFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILTED_ELM = IcariaFeatures.FEATURES.register("wilted_elm", () -> new WiltedElmFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GREEN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("green_ground_shrooms", () -> new GreenGroundShroomsFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BROWN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("brown_ground_shrooms", () -> new BrownGroundShroomsFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LARGE_BROWN_GROUND_SHROOMS = IcariaFeatures.FEATURES.register("large_brown_ground_shrooms", () -> new LargeBrownGroundShroomsFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CARDON_CACTUS = IcariaFeatures.FEATURES.register("cardon_cactus", () -> new CardonCactusFeature(NoneFeatureConfiguration.CODEC));
}
