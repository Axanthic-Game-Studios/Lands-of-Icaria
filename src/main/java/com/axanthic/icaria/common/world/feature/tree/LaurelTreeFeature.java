package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LaurelTreeFeature extends IcariaTreeFeature {
	public LaurelTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.LAUREL_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
		List<Direction> directions = new ArrayList<>();

		var level = pContext.level();
		var origin = pContext.origin();
		var random = pContext.random();

		int branchCount = random.nextIntBetweenInclusive(2, 3);
		int heightTrunk = random.nextIntBetweenInclusive(1, 4);
		int heightLimit = heightTrunk + 4;
		int heightAxisY = heightLimit + origin.getY();

		if (heightAxisY < level.getMaxBuildHeight() && level.getBlockState(origin.atY(heightAxisY)).canBeReplaced()) {
			for (var direction : Direction.Plane.HORIZONTAL) {
				directions.add(direction);
			}

			for (int i = 1; i <= heightTrunk; ++i) {
				this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
			}

			for (int i = 1; i <= branchCount; ++i) {
				var direction = directions.get(random.nextInt(directions.size()));
				var clockWise = direction.getClockWise();
				var blockPos = new BlockPos(origin.below().above(heightTrunk));

				int length = random.nextIntBetweenInclusive(4, 6);

				directions.remove(direction);

				for (int j = 1; j <= length; ++j) {
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

			this.placeTwigsPatch(level, origin, random.nextIntBetweenInclusive(8, 16));
			this.placeFallenPatch(level, origin, random.nextIntBetweenInclusive(8, 16));
			this.placeShroomsPatch(level, origin, random.nextIntBetweenInclusive(8, 16));

			return true;
		} else {
			return false;
		}
	}
}
