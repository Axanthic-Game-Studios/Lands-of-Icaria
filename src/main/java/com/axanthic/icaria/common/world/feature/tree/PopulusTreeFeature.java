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

public class PopulusTreeFeature extends IcariaTreeFeature {
	public PopulusTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), IcariaBlocks.POPULUS_LEAVES.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), IcariaBlocks.POPULUS_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var heightTrunk = 0;
		var heightCrown = random.nextIntBetweenInclusive(1, 2);
		var heightTotal = origin.below().getY() + heightCrown + heightCrown + 9;

		if (heightTotal < level.getMaxY() && level.getBlockState(origin.atY(heightTotal)).canBeReplaced()) {
			heightTrunk++;
			this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);

			heightTrunk++;
			this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);

			heightTrunk++;
			this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
			this.placeLeaves(level, origin.below().above(heightTrunk).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).north().east());
			this.placeLeaves(level, origin.below().above(heightTrunk).east().south());
			this.placeLeaves(level, origin.below().above(heightTrunk).south().west());
			this.placeLeaves(level, origin.below().above(heightTrunk).west().north());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2), 2);

			for (var i = 1; i <= heightCrown; i++) {
				heightTrunk++;
				this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
				this.placeLeaves(level, origin.below().above(heightTrunk).north());
				this.placeLeaves(level, origin.below().above(heightTrunk).east());
				this.placeLeaves(level, origin.below().above(heightTrunk).south());
				this.placeLeaves(level, origin.below().above(heightTrunk).west());
				this.placeLeaves(level, origin.below().above(heightTrunk).north().east());
				this.placeLeaves(level, origin.below().above(heightTrunk).east().south());
				this.placeLeaves(level, origin.below().above(heightTrunk).south().west());
				this.placeLeaves(level, origin.below().above(heightTrunk).west().north());
				this.placeLeaves(level, origin.below().above(heightTrunk).north(2));
				this.placeLeaves(level, origin.below().above(heightTrunk).east(2));
				this.placeLeaves(level, origin.below().above(heightTrunk).south(2));
				this.placeLeaves(level, origin.below().above(heightTrunk).west(2));
				this.placeLeaves(level, origin.below().above(heightTrunk).north(2).east(), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).east(2).south(), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).south(2).west(), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).west(2).north(), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west(), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north(), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east(), 2);
				this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south(), 2);
			}

			heightTrunk++;
			this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
			this.placeLeaves(level, origin.below().above(heightTrunk).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).north().east());
			this.placeLeaves(level, origin.below().above(heightTrunk).east().south());
			this.placeLeaves(level, origin.below().above(heightTrunk).south().west());
			this.placeLeaves(level, origin.below().above(heightTrunk).west().north());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2), 2);

			for (var i = 1; i <= heightCrown; i++) {
				heightTrunk++;
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

			heightTrunk++;
			this.placeLog(level, origin.below().above(heightTrunk), Direction.Axis.Y);
			this.placeLeaves(level, origin.below().above(heightTrunk).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).north().east(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east().south(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south().west(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west().north(), 2);

			heightTrunk++;
			this.placeLeaves(level, origin.below().above(heightTrunk));
			this.placeLeaves(level, origin.below().above(heightTrunk).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).west());

			heightTrunk++;
			this.placeLeaves(level, origin.below().above(heightTrunk));
			this.placeLeaves(level, origin.below().above(heightTrunk).north(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(), 2);

			heightTrunk++;
			this.placeLeaves(level, origin.below().above(heightTrunk));

			heightTrunk++;
			this.placeLeaves(level, origin.below().above(heightTrunk));

			this.placeTwigsPatch(level, origin, 4);
			this.placeFallenPatch(level, origin, 4);
			this.placeShroomsPatch(level, origin, 4);

			return true;
		} else {
			return false;
		}
	}
}
