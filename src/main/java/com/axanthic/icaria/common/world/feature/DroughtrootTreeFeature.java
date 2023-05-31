package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class DroughtrootTreeFeature extends IcariaTreeFeature {
    public DroughtrootTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_SAPLING.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var origin = pContext.origin();
        var random = pContext.random();

        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int heightTrunk = random.nextIntBetweenInclusive(2, 4);
        int heightLower = random.nextIntBetweenInclusive(1, 4);
        int heightInner = random.nextIntBetweenInclusive(1, 4);
        int heightUpper = random.nextIntBetweenInclusive(1, 4);
        int heightTotal = heightTrunk + heightLower + heightInner + heightUpper;
        int heightAxisY = heightTotal + origin.getY();

        var below = origin.below();

        boolean grow = heightAxisY < pContext.level().getMaxBuildHeight();

        if (this.isSoil(pContext) && grow) {
            for (int i = 1; i <= heightTrunk; ++i) {
                this.placeLog(pContext, below.above(i));
            }

            for (int i = 1; i <= heightLower; ++i) {
                ++heightTrunk;
                direction = direction.getOpposite();
                this.placeLog(pContext, below.above(heightTrunk));
                this.placeLog(pContext, below.above(heightTrunk).relative(direction), direction.getAxis());
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction), 2);
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction.getClockWise()));
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction.getCounterClockWise()));
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction).relative(direction.getClockWise()));
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction).relative(direction.getCounterClockWise()));

            }

            for (int i = 1; i <= heightInner; ++i) {
                ++heightTrunk;
                direction = direction.getOpposite();
                this.placeLog(pContext, below.above(heightTrunk));
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction));
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction.getClockWise()));
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction.getCounterClockWise()));
            }

            for (int i = 1; i <= heightUpper; ++i) {
                ++heightTrunk;
                direction = direction.getOpposite();
                this.placeLeaves(pContext, below.above(heightTrunk));
                this.placeLeaves(pContext, below.above(heightTrunk).relative(direction));
            }

            return true;
        } else {
            return false;
        }
    }
}
