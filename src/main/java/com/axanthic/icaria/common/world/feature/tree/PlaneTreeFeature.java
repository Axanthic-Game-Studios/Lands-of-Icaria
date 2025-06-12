package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PlaneTreeFeature extends IcariaTreeFeature {
	public PlaneTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_PLANE_LEAVES.get(), IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), IcariaBlocks.PLANE_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var directions = new ArrayList<Direction>();

		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var countBranch = random.nextIntBetweenInclusive(2, 3);
		var heightTrunk = random.nextIntBetweenInclusive(2, 4);
		var heightTotal = origin.below().getY() + heightTrunk + 5;

		if (heightTotal < level.getMaxY() && level.getBlockState(origin.atY(heightTotal)).canBeReplaced()) {
			for (var direction : Direction.Plane.HORIZONTAL) {
				directions.add(direction);
			}

			for (var i = 1; i <= heightTrunk; i++) {
				this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
			}

			for (var i = 1; i <= countBranch; i++) {
				var front = Direction.Plane.HORIZONTAL.getRandomDirection(random);
				var right = front.getClockWise();
				var back = front.getOpposite();
				var left = front.getCounterClockWise();
				var direction = directions.get(random.nextInt(directions.size()));
				var clockWise = direction.getClockWise();
				var blockPos = new BlockPos(origin.below().above(heightTrunk));

				var heightBranch = random.nextIntBetweenInclusive(2, 4);

				directions.remove(direction);

				for (var j = 1; j <= heightBranch; j++) {
					blockPos = blockPos.above().relative(direction);
					if (random.nextInt(3) == 0) {
						blockPos = blockPos.relative(clockWise);
					}

					this.placeLog(level, blockPos, direction.getAxis());
				}

				this.placeLeaves(level, blockPos.relative(front).relative(right), 2);
				this.placeLeaves(level, blockPos.relative(back).relative(left), 2);
				this.placeLeaves(level, blockPos.north());
				this.placeLeaves(level, blockPos.east());
				this.placeLeaves(level, blockPos.south());
				this.placeLeaves(level, blockPos.west());
				this.placeLeaves(level, blockPos.above());
				this.placeLeaves(level, blockPos.above().relative(front), 2);
				this.placeLeaves(level, blockPos.above().relative(front).relative(right), 2);
				this.placeLeaves(level, blockPos.above().relative(right), 2);
				this.placeLeaves(level, blockPos.below());
				this.placeLeaves(level, blockPos.below().relative(back), 2);
				this.placeLeaves(level, blockPos.below().relative(back).relative(left), 2);
				this.placeLeaves(level, blockPos.below().relative(left), 2);
			}

			this.placeTwigsPatch(level, origin, 4);
			this.placeFallenPatch(level, origin, 4);
			this.placeShroomsPatch(level, origin, 4);

			return true;
		} else {
			return false;
		}
	}
}
