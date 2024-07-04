package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadCypressTreeFeature extends IcariaDeadTreeFeature {
    public DeadCypressTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.STEPPE_MOSS.get(), IcariaBlocks.CYPRESS_TWIGS.get(), Moss.STEPPE);
    }
}
