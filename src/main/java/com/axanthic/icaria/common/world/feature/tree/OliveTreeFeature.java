package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class OliveTreeFeature extends IcariaTreeFeature {
    public OliveTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_SAPLING.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.OLIVE_TWIGS.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int heightTrunk = random.nextIntBetweenInclusive(1, 2);
        int heightLimit = heightTrunk + 4;
        int heightAxisY = heightLimit + origin.getY();

        if (heightAxisY < level.getMaxBuildHeight()) {
            for (int i = 1; i <= heightTrunk; ++i) {
                this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
            }

            ++heightTrunk;
            this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
            this.placeLeaves(level, origin.below().above(heightTrunk).north());
            this.placeLeaves(level, origin.below().above(heightTrunk).east());
            this.placeLeaves(level, origin.below().above(heightTrunk).south());
            this.placeLeaves(level, origin.below().above(heightTrunk).west());
            this.placeLeaves(level, origin.below().above(heightTrunk).north(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).east(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).south(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).west(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).north().east());
            this.placeLeaves(level, origin.below().above(heightTrunk).east().south());
            this.placeLeaves(level, origin.below().above(heightTrunk).south().west());
            this.placeLeaves(level, origin.below().above(heightTrunk).west().north());
            this.placeLeaves(level, origin.below().above(heightTrunk).north(2).east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east(2).south(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south(2).west(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west(2).north(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south(), 2);

            ++heightTrunk;
            this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
            this.placeLeaves(level, origin.below().above(heightTrunk).north());
            this.placeLeaves(level, origin.below().above(heightTrunk).east());
            this.placeLeaves(level, origin.below().above(heightTrunk).south());
            this.placeLeaves(level, origin.below().above(heightTrunk).west());
            this.placeLeaves(level, origin.below().above(heightTrunk).north(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).east(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).south(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).west(2));
            this.placeLeaves(level, origin.below().above(heightTrunk).north(3));
            this.placeLeaves(level, origin.below().above(heightTrunk).east(3));
            this.placeLeaves(level, origin.below().above(heightTrunk).south(3));
            this.placeLeaves(level, origin.below().above(heightTrunk).west(3));
            this.placeLeaves(level, origin.below().above(heightTrunk).north().east());
            this.placeLeaves(level, origin.below().above(heightTrunk).east().south());
            this.placeLeaves(level, origin.below().above(heightTrunk).south().west());
            this.placeLeaves(level, origin.below().above(heightTrunk).west().north());
            this.placeLeaves(level, origin.below().above(heightTrunk).north(2).east());
            this.placeLeaves(level, origin.below().above(heightTrunk).east(2).south());
            this.placeLeaves(level, origin.below().above(heightTrunk).south(2).west());
            this.placeLeaves(level, origin.below().above(heightTrunk).west(2).north());
            this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west());
            this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north());
            this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east());
            this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south());
            this.placeLeaves(level, origin.below().above(heightTrunk).north(3).east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east(3).south(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south(3).west(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west(3).north(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).north(3).west(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east(3).north(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south(3).east(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west(3).south(), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west(2), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north(2), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east(2), 2);
            this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south(2), 2);

            ++heightTrunk;
            this.placeLog(level, origin.relative(direction).below().above(heightTrunk), Direction.Axis.Y);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north().east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east().south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south().west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west().north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(3).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(3).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(3).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(3).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(3).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(3).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(3).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(3).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).west(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).north(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).east(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).south(2));

            ++heightTrunk;
            this.placeLog(level, origin.relative(direction).below().above(heightTrunk), Direction.Axis.Y);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(3));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north().east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east().south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south().west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west().north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(3).east(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(3).south(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(3).west(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(3).north(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(3).west(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(3).north(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(3).east(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(3).south(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).west(2), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).north(2), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).east(2), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).south(2), 2);

            ++heightTrunk;
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north().east());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east().south());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south().west());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west().north());
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).east(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).south(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).west(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).north(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(2).west(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(2).north(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(2).east(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(2).south(), 2);

            ++heightTrunk;
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk));
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).north(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).east(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).south(), 2);
            this.placeLeaves(level, origin.relative(direction).below().above(heightTrunk).west(), 2);

            return true;
        } else {
            return false;
        }
    }
}
