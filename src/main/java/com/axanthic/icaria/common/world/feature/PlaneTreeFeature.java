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

public class PlaneTreeFeature extends IcariaTreeFeature {
    public PlaneTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_SAPLING.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        List<Direction> directions = new ArrayList<>();

        var origin = pContext.origin();
        var random = pContext.random();

        int branchCount = random.nextIntBetweenInclusive(2 ,3);
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
                var front = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                var right = front.getClockWise();
                var back = front.getOpposite();
                var left = front.getCounterClockWise();
                var direction = directions.get(random.nextInt(directions.size()));
                var clockWise = direction.getClockWise();
                var pos = new BlockPos(above);
                int length = random.nextIntBetweenInclusive(2, 4);
                directions.remove(direction);
                for (int j = 1; j <= length; ++j) {
                    pos = pos.relative(direction);
                    if (random.nextInt(3) == 0) {
                        pos = pos.relative(clockWise);
                    }

                    if (random.nextInt(3) != 0) {
                        pos = pos.above();
                    }

                    this.placeLog(pContext, pos, direction.getAxis());
                }

                this.placeLeaves(pContext, pos.relative(front).relative(right), 2);
                this.placeLeaves(pContext, pos.relative(back).relative(left), 2);
                this.placeLeaves(pContext, pos.north());
                this.placeLeaves(pContext, pos.east());
                this.placeLeaves(pContext, pos.south());
                this.placeLeaves(pContext, pos.west());
                this.placeLeaves(pContext, pos.above());
                this.placeLeaves(pContext, pos.above().relative(front), 2);
                this.placeLeaves(pContext, pos.above().relative(front).relative(right), 4);
                this.placeLeaves(pContext, pos.above().relative(right), 2);
                this.placeLeaves(pContext, pos.below());
                this.placeLeaves(pContext, pos.below().relative(back), 2);
                this.placeLeaves(pContext, pos.below().relative(back).relative(left), 4);
                this.placeLeaves(pContext, pos.below().relative(left), 2);
            }

            return true;
        } else {
            return false;
        }
    }
}
