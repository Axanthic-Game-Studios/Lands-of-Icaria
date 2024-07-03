package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class CypressTreeFeature extends IcariaTreeFeature {
    public CypressTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.CYPRESS_TWIGS.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();

        int heightTrunk = random.nextIntBetweenInclusive(1, 2);
        int heightCrown = random.nextIntBetweenInclusive(1, 4);
        int heightTotal = heightTrunk + heightCrown;
        int heightLimit = heightTotal + 6;
        int heightAxisY = heightLimit + origin.getY();

        if (heightAxisY < level.getMaxBuildHeight()) {
            for (int i = 1; i <= heightTrunk; ++i) {
                this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
            }

            ++heightTrunk;
            this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
            this.placeLeaves(level, origin.below().above(heightTrunk).north(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west(), 2);

            ++heightTrunk;
            this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
            this.placeLeaves(level, origin.below().above(heightTrunk).north());
            this.placeLeaves(level, origin.below().above(heightTrunk).east());
            this.placeLeaves(level, origin.below().above(heightTrunk).south());
            this.placeLeaves(level, origin.below().above(heightTrunk).west());
            this.placeLeaves(level, origin.below().above(heightTrunk).north().east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east().south(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south().west(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west().north(), 2);

            for (int i = 1; i <= heightCrown; ++i) {
                ++heightTrunk;
                this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
                this.placeLeaves(level, origin.below().above(heightTrunk).north());
                this.placeLeaves(level, origin.below().above(heightTrunk).east());
                this.placeLeaves(level, origin.below().above(heightTrunk).south());
                this.placeLeaves(level, origin.below().above(heightTrunk).west());
                this.placeLeaves(level, origin.below().above(heightTrunk).north().east());
                this.placeLeaves(level, origin.below().above(heightTrunk).east().south());
                this.placeLeaves(level, origin.below().above(heightTrunk).south().west());
                this.placeLeaves(level, origin.below().above(heightTrunk).west().north());
            }

            ++heightTrunk;
            this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
            this.placeLeaves(level, origin.below().above(heightTrunk).north());
            this.placeLeaves(level, origin.below().above(heightTrunk).east());
            this.placeLeaves(level, origin.below().above(heightTrunk).south());
            this.placeLeaves(level, origin.below().above(heightTrunk).west());
            this.placeLeaves(level, origin.below().above(heightTrunk).north().east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east().south(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south().west(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west().north(), 2);

            ++heightTrunk;
            this.placeLeaves(level, origin.below().above(heightTrunk));
            this.placeLeaves(level, origin.below().above(heightTrunk).north());
            this.placeLeaves(level, origin.below().above(heightTrunk).east());
            this.placeLeaves(level, origin.below().above(heightTrunk).south());
            this.placeLeaves(level, origin.below().above(heightTrunk).west());

            ++heightTrunk;
            this.placeLeaves(level, origin.below().above(heightTrunk));
            this.placeLeaves(level, origin.below().above(heightTrunk).north(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west(), 2);

            ++heightTrunk;
            this.placeLeaves(level, origin.below().above(heightTrunk));

            this.placeTwigsPatch(level, origin, random.nextIntBetweenInclusive(8, 16));
            this.placeFallenPatch(level, origin, random.nextIntBetweenInclusive(8, 16));
            this.placeShroomsPatch(level, origin, random.nextIntBetweenInclusive(8, 16));

            return true;
        } else {
            return false;
        }
    }
}
