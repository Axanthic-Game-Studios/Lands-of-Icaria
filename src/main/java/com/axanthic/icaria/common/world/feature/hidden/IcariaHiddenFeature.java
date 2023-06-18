package com.axanthic.icaria.common.world.feature.hidden;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaHiddenFeature extends Feature<NoneFeatureConfiguration> {
    public Block hidden;
    public Block surface;

    public IcariaHiddenFeature(Codec<NoneFeatureConfiguration> pCodec, Block pHidden, Block pSurface) {
        super(pCodec);
        this.hidden = pHidden;
        this.surface = pSurface;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();

        this.setBlock(level, origin, this.surface.defaultBlockState());
        this.setBlock(level, origin.below(2), this.hidden.defaultBlockState());

        return true;
    }
}
