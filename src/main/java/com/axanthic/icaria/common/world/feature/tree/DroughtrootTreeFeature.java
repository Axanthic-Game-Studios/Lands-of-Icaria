package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DroughtrootTreeFeature extends IcariaTreeFeature {
	public DroughtrootTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), IcariaBlocks.DROUGHTROOT_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var heightTrunk = random.nextIntBetweenInclusive(2, 4);
		var heightLower = random.nextIntBetweenInclusive(1, 4);
		var heightInner = random.nextIntBetweenInclusive(1, 4);
		var heightUpper = random.nextIntBetweenInclusive(1, 4);
		var heightTotal = origin.below().getY() + heightTrunk + heightLower + heightInner + heightUpper;

		if (heightTotal < level.getMaxY() && level.getBlockState(origin.atY(heightTotal)).canBeReplaced()) {
			for (var i = 1; i <= heightTrunk; i++) {
				this.placeLog(level, origin.below().above(i), Direction.Axis.Y);
			}

			for (var i = 1; i <= heightLower; i++) {
				heightTrunk++;
				direction = direction.getOpposite();
				this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
				this.placeLog(level, origin.below().above(heightTrunk).relative(direction), direction.getAxis());
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getClockWise()));
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getCounterClockWise()));
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction).relative(direction.getClockWise()));
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction).relative(direction.getCounterClockWise()));
			}

			for (var i = 1; i <= heightInner; i++) {
				heightTrunk++;
				direction = direction.getOpposite();
				this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction));
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getClockWise()));
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction.getCounterClockWise()));
			}

			for (var i = 1; i <= heightUpper; i++) {
				heightTrunk++;
				direction = direction.getOpposite();
				this.placeLeaves(level, origin.below().above(heightTrunk));
				this.placeLeaves(level, origin.below().above(heightTrunk).relative(direction));
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
