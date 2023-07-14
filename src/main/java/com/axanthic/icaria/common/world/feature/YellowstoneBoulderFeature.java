package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

public class YellowstoneBoulderFeature extends Feature<NoneFeatureConfiguration> {
    public YellowstoneBoulderFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();

        for (int l = 0; l < 3; ++l) {
            int x = random.nextIntBetweenInclusive(2, 3);
            int y = random.nextIntBetweenInclusive(2, 3);
            int z = random.nextIntBetweenInclusive(2, 3);

            float f = (x + y + z) * 0.333F + 0.5F;

            for (var blockPos : BlockPos.betweenClosed(origin.offset(-x, -y, -z), origin.offset(x, y, z))) {
                if (blockPos.distSqr(origin) <= (f * f)) {
                    level.setBlock(blockPos, IcariaBlocks.YELLOWSTONE.get().defaultBlockState(), 3);
                }
            }

            origin = origin.offset(random.nextIntBetweenInclusive(-1, 0), random.nextIntBetweenInclusive(-1, 0), random.nextIntBetweenInclusive(-1, 0));
        }

        return true;
    }

    public void placeStone(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeStone(pLevel, pPos);
        }
    }

    public void placeStone(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir()) {
            this.setBlock(pLevel, pPos, IcariaBlocks.YELLOWSTONE.get().defaultBlockState());
        }
    }
}
