package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class DroughtrootTreeFeature extends IcariaTreeFeature {
    public DroughtrootTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), IcariaBlocks.DROUGHTROOT_TWIGS.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int heightTrunk = random.nextIntBetweenInclusive(2, 4);
        int heightLower = random.nextIntBetweenInclusive(1, 4);
        int heightInner = random.nextIntBetweenInclusive(1, 4);
        int heightUpper = random.nextIntBetweenInclusive(1, 4);
        int heightTotal = heightTrunk + heightLower + heightInner + heightUpper;
        int heightAxisY = heightTotal + origin.getY();

        if (heightAxisY < level.getMaxBuildHeight()) {
            for (int i = 1; i <= heightTrunk; ++i) {
                this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
            }

            for (int i = 1; i <= heightLower; ++i) {
                ++heightTrunk;
                direction = direction.getOpposite();
                this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
                this.placeLog(level, origin.below().above(heightTrunk).relative(direction), direction.getAxis());
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction), 2);
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getClockWise()));
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getCounterClockWise()));
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction).relative(direction.getClockWise()));
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction).relative(direction.getCounterClockWise()));
            }

            for (int i = 1; i <= heightInner; ++i) {
                ++heightTrunk;
                direction = direction.getOpposite();
                this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction));
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getClockWise()));
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getCounterClockWise()));
            }

            for (int i = 1; i <= heightUpper; ++i) {
                ++heightTrunk;
                direction = direction.getOpposite();
                this.placeLeaves(level, origin.below().above(heightTrunk));
                this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction));
            }

            this.placeTwigsPatch(level, origin, random.nextIntBetweenInclusive(8, 16));
            this.placeFallenPatch(level, origin, random.nextIntBetweenInclusive(8, 16));
            this.placeShroomsPatch(level, origin, random.nextIntBetweenInclusive(8, 16));

            return true;
        } else {
            return false;
        }
    }
}
