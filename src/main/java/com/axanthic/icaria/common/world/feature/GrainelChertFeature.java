package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class GrainelChertFeature extends Feature<NoneFeatureConfiguration> {
    public GrainelChertFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();

        if (level.getBlockState(origin).canBeReplaced() && level.getBlockState(origin.below()).is(IcariaBlocks.GRAINEL.get())) {
            this.setBlock(level, origin, IcariaBlocks.SURFACE_CHERT.get().defaultBlockState());
            this.setBlock(level, origin.below(2), IcariaBlocks.GRAINEL_CHERT.get().defaultBlockState());

            return true;
        } else {
            return false;
        }
    }
}
