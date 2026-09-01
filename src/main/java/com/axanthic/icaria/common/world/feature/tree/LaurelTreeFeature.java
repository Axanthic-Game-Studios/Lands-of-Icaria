package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LaurelTreeFeature extends TreeFeature {
	public LaurelTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.LAUREL_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var directions = new ArrayList<Direction>();

		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var countBranch = random.nextIntBetweenInclusive(2, 3);
		var heightTrunk = random.nextIntBetweenInclusive(2, 4);
		var heightTotal = origin.below().getY() + heightTrunk + 7;

		if (heightTotal < level.getMaxY() && level.getBlockState(origin.atY(heightTotal)).canBeReplaced()) {
			for (var direction : Direction.Plane.HORIZONTAL) {
				directions.add(direction);
			}

			for (var i = 1; i <= heightTrunk; i++) {
				this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
			}

			for (var i = 1; i <= countBranch; i++) {
				var direction = directions.get(random.nextInt(directions.size()));
				var clockWise = direction.getClockWise();
				var blockPos = new BlockPos(origin.below().above(heightTrunk));

				var heightBranch = random.nextIntBetweenInclusive(4, 6);

				directions.remove(direction);

				for (var j = 1; j <= heightBranch; j++) {
					blockPos = blockPos.above();
					if (random.nextInt(j * 2 + 1) == 0) {
						blockPos = blockPos.relative(direction);
					}

					if (random.nextInt(j * 2 + 3) == 0) {
						blockPos = blockPos.relative(clockWise);
					}

					this.placeLog(level, blockPos, Direction.Axis.Y);
					this.placeLeaves(level, blockPos.above());
					this.placeLeaves(level, blockPos.north());
					this.placeLeaves(level, blockPos.east());
					this.placeLeaves(level, blockPos.south());
					this.placeLeaves(level, blockPos.west());
					this.placeLeaves(level, blockPos.below());
				}
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
