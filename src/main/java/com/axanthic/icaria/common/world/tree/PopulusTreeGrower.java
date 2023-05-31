package com.axanthic.icaria.common.world.tree;

import com.axanthic.icaria.common.registry.IcariaConfiguredFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class PopulusTreeGrower extends AbstractTreeGrower {
    @Override
    public ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return IcariaConfiguredFeatures.POPULUS_TREE;
    }
}
