package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.feature.*;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, IcariaInfo.ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CYPRESS_TREE = IcariaFeatures.FEATURES.register("cypress_tree", () -> new CypressTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DROUGHTROOT_TREE = IcariaFeatures.FEATURES.register("droughtroot_tree", () -> new DroughtrootTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FIR_TREE = IcariaFeatures.FEATURES.register("fir_tree", () -> new FirTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LAUREL_TREE = IcariaFeatures.FEATURES.register("laurel_tree", () -> new LaurelTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> OLIVE_TREE = IcariaFeatures.FEATURES.register("olive_tree", () -> new OliveTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PLANE_TREE = IcariaFeatures.FEATURES.register("plane_tree", () -> new PlaneTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> POPULUS_TREE = IcariaFeatures.FEATURES.register("populus_tree", () -> new PopulusTreeFeature(NoneFeatureConfiguration.CODEC));
}
