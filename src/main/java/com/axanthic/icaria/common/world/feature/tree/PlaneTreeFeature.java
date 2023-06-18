package com.axanthic.icaria.common.world.feature.tree;

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
        super(pCodec, IcariaBlocks.FALLEN_PLANE_LEAVES.get(), IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_SAPLING.get(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), IcariaBlocks.PLANE_TWIGS.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        List<Direction> directions = new ArrayList<>();

        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();

        int branchCount = random.nextIntBetweenInclusive(2 ,3);
        int heightTrunk = random.nextIntBetweenInclusive(1, 4);
        int heightLimit = heightTrunk + 4;
        int heightAxisY = heightLimit + origin.getY();

        if (heightAxisY < level.getMaxBuildHeight()) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                directions.add(direction);
            }

            for (int i = 1; i <= heightTrunk; ++i) {
                this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
            }

            for (int i = 1; i <= branchCount; ++i) {
                var front = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                var right = front.getClockWise();
                var back = front.getOpposite();
                var left = front.getCounterClockWise();
                var direction = directions.get(random.nextInt(directions.size()));
                var clockWise = direction.getClockWise();
                var pos = new BlockPos(origin.below().above(heightTrunk));
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

                    this.placeLog(level, pos, direction.getAxis());
                }

                this.placeLeaves(level, pos.relative(front).relative(right), 2);
                this.placeLeaves(level, pos.relative(back).relative(left), 2);
                this.placeLeaves(level, pos.north());
                this.placeLeaves(level, pos.east());
                this.placeLeaves(level, pos.south());
                this.placeLeaves(level, pos.west());
                this.placeLeaves(level, pos.above());
                this.placeLeaves(level, pos.above().relative(front), 2);
                this.placeLeaves(level, pos.above().relative(front).relative(right), 4);
                this.placeLeaves(level, pos.above().relative(right), 2);
                this.placeLeaves(level, pos.below());
                this.placeLeaves(level, pos.below().relative(back), 2);
                this.placeLeaves(level, pos.below().relative(back).relative(left), 4);
                this.placeLeaves(level, pos.below().relative(left), 2);
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
