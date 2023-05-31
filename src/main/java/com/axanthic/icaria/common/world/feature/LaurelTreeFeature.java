package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class LaurelTreeFeature extends IcariaTreeFeature {
    public LaurelTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_SAPLING.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        List<Direction> directions = new ArrayList<>();

        var origin = pContext.origin();
        var random = pContext.random();

        int branchCount = random.nextIntBetweenInclusive(2, 3);
        int heightTrunk = random.nextIntBetweenInclusive(1, 4);
        int heightLimit = heightTrunk + 4;
        int heightAxisY = heightLimit + origin.getY();

        var below = origin.below();
        var above = below.above(heightTrunk);

        boolean grow = heightAxisY < pContext.level().getMaxBuildHeight();

        if (this.isSoil(pContext) && grow) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                directions.add(direction);
            }

            for (int i = 1; i <= heightTrunk; ++i) {
                this.placeLog(pContext, below.above(i));
            }

            for (int i = 1; i <= branchCount; ++i) {
                var direction = directions.get(random.nextInt(directions.size()));
                var clockWise = direction.getClockWise();
                var pos = new BlockPos(above);
                int length = random.nextIntBetweenInclusive(4, 6);
                directions.remove(direction);
                for (int j = 1; j <= length; ++j) {
                    pos = pos.above();
                    if (random.nextInt(j * 2 + 1) == 0) {
                        pos = pos.relative(direction);
                    }

                    if (random.nextInt(j * 2 + 3) == 0) {
                        pos = pos.relative(clockWise);
                    }

                    this.placeLog(pContext, pos);
                    this.placeLeaves(pContext, pos.above());
                    this.placeLeaves(pContext, pos.north());
                    this.placeLeaves(pContext, pos.east());
                    this.placeLeaves(pContext, pos.south());
                    this.placeLeaves(pContext, pos.west());
                    this.placeLeaves(pContext, pos.below());
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
