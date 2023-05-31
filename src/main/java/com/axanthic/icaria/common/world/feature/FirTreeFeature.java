package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class FirTreeFeature extends IcariaTreeFeature {
    public FirTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.FIR_LEAVES.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_SAPLING.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var origin = pContext.origin();
        var random = pContext.random();

        int heightTrunk = random.nextIntBetweenInclusive(1, 2);
        int heightCrown = random.nextIntBetweenInclusive(1, 2);
        int heightTotal = heightTrunk + heightCrown * 2;
        int heightLimit = heightTotal + 8;
        int heightAxisY = heightLimit + origin.getY();

        var below = origin.below();

        boolean grow = heightAxisY < pContext.level().getMaxBuildHeight();

        if (this.isSoil(pContext) && grow) {
            for (int i = 1; i <= heightTrunk; ++i) {
                this.placeLog(pContext, below.above(i));
            }

            ++heightTrunk;
            this.placeLog(pContext, below.above(heightTrunk));
            this.placeLeaves(pContext, below.above(heightTrunk).north(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).east(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).south(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).west(), 2);

            for (int i = 1; i <= heightCrown; ++i) {
                ++heightTrunk;
                this.placeLog(pContext, below.above(heightTrunk));
                this.placeLeaves(pContext, below.above(heightTrunk).north());
                this.placeLeaves(pContext, below.above(heightTrunk).east());
                this.placeLeaves(pContext, below.above(heightTrunk).south());
                this.placeLeaves(pContext, below.above(heightTrunk).west());
                this.placeLeaves(pContext, below.above(heightTrunk).north(2));
                this.placeLeaves(pContext, below.above(heightTrunk).east(2));
                this.placeLeaves(pContext, below.above(heightTrunk).south(2));
                this.placeLeaves(pContext, below.above(heightTrunk).west(2));
                this.placeLeaves(pContext, below.above(heightTrunk).north().east());
                this.placeLeaves(pContext, below.above(heightTrunk).east().south());
                this.placeLeaves(pContext, below.above(heightTrunk).south().west());
                this.placeLeaves(pContext, below.above(heightTrunk).west().north());
                this.placeLeaves(pContext, below.above(heightTrunk).north(2).east());
                this.placeLeaves(pContext, below.above(heightTrunk).east(2).south());
                this.placeLeaves(pContext, below.above(heightTrunk).south(2).west());
                this.placeLeaves(pContext, below.above(heightTrunk).west(2).north());
                this.placeLeaves(pContext, below.above(heightTrunk).north(2).west());
                this.placeLeaves(pContext, below.above(heightTrunk).east(2).north());
                this.placeLeaves(pContext, below.above(heightTrunk).south(2).east());
                this.placeLeaves(pContext, below.above(heightTrunk).west(2).south());
            }

            ++heightTrunk;
            this.placeLog(pContext, below.above(heightTrunk));
            this.placeLeaves(pContext, below.above(heightTrunk).north());
            this.placeLeaves(pContext, below.above(heightTrunk).east());
            this.placeLeaves(pContext, below.above(heightTrunk).south());
            this.placeLeaves(pContext, below.above(heightTrunk).west());
            this.placeLeaves(pContext, below.above(heightTrunk).north(2));
            this.placeLeaves(pContext, below.above(heightTrunk).east(2));
            this.placeLeaves(pContext, below.above(heightTrunk).south(2));
            this.placeLeaves(pContext, below.above(heightTrunk).west(2));
            this.placeLeaves(pContext, below.above(heightTrunk).north().east());
            this.placeLeaves(pContext, below.above(heightTrunk).east().south());
            this.placeLeaves(pContext, below.above(heightTrunk).south().west());
            this.placeLeaves(pContext, below.above(heightTrunk).west().north());
            this.placeLeaves(pContext, below.above(heightTrunk).north(2).east(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).east(2).south(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).south(2).west(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).west(2).north(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).north(2).west(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).east(2).north(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).south(2).east(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).west(2).south(), 2);

            ++heightTrunk;
            this.placeLog(pContext, below.above(heightTrunk));
            this.placeLeaves(pContext, below.above(heightTrunk).north());
            this.placeLeaves(pContext, below.above(heightTrunk).east());
            this.placeLeaves(pContext, below.above(heightTrunk).south());
            this.placeLeaves(pContext, below.above(heightTrunk).west());
            this.placeLeaves(pContext, below.above(heightTrunk).north(2));
            this.placeLeaves(pContext, below.above(heightTrunk).east(2));
            this.placeLeaves(pContext, below.above(heightTrunk).south(2));
            this.placeLeaves(pContext, below.above(heightTrunk).west(2));
            this.placeLeaves(pContext, below.above(heightTrunk).north().east());
            this.placeLeaves(pContext, below.above(heightTrunk).east().south());
            this.placeLeaves(pContext, below.above(heightTrunk).south().west());
            this.placeLeaves(pContext, below.above(heightTrunk).west().north());

            for (int i = 1; i <= heightCrown; ++i) {
                ++heightTrunk;
                this.placeLog(pContext, below.above(heightTrunk));
                this.placeLeaves(pContext, below.above(heightTrunk).north());
                this.placeLeaves(pContext, below.above(heightTrunk).east());
                this.placeLeaves(pContext, below.above(heightTrunk).south());
                this.placeLeaves(pContext, below.above(heightTrunk).west());
                this.placeLeaves(pContext, below.above(heightTrunk).north().east());
                this.placeLeaves(pContext, below.above(heightTrunk).east().south());
                this.placeLeaves(pContext, below.above(heightTrunk).south().west());
                this.placeLeaves(pContext, below.above(heightTrunk).west().north());
            }

            ++heightTrunk;
            this.placeLog(pContext, below.above(heightTrunk));
            this.placeLeaves(pContext, below.above(heightTrunk).north());
            this.placeLeaves(pContext, below.above(heightTrunk).east());
            this.placeLeaves(pContext, below.above(heightTrunk).south());
            this.placeLeaves(pContext, below.above(heightTrunk).west());
            this.placeLeaves(pContext, below.above(heightTrunk).north().east(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).east().south(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).south().west(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).west().north(), 2);

            ++heightTrunk;
            this.placeLog(pContext, below.above(heightTrunk));
            this.placeLeaves(pContext, below.above(heightTrunk).north());
            this.placeLeaves(pContext, below.above(heightTrunk).east());
            this.placeLeaves(pContext, below.above(heightTrunk).south());
            this.placeLeaves(pContext, below.above(heightTrunk).west());

            ++heightTrunk;
            this.placeLeaves(pContext, below.above(heightTrunk));
            this.placeLeaves(pContext, below.above(heightTrunk).north(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).east(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).south(), 2);
            this.placeLeaves(pContext, below.above(heightTrunk).west(), 2);

            ++heightTrunk;
            this.placeLeaves(pContext, below.above(heightTrunk));

            ++heightTrunk;
            this.placeLeaves(pContext, below.above(heightTrunk), 2);

            return true;
        } else {
            return false;
        }
    }
}
