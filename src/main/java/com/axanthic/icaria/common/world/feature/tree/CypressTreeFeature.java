package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaFeatureHelper;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record CypressTreeFeature(BlockState fallen, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<CypressTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("fallen").forGetter(CypressTreeFeature::fallen),
			BlockState.CODEC.fieldOf("leaves").forGetter(CypressTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(CypressTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(CypressTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(CypressTreeFeature::twigs)
		).apply(instance, CypressTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var heightTrunk = 0;
		var heightCrown = pRandomSource.nextIntBetweenInclusive(1, 4);
		var heightTotal = pBlockPos.below().getY() + heightCrown + 8;

		if (heightTotal < pWorldGenLevel.getMaxY() && pWorldGenLevel.getBlockState(pBlockPos.atY(heightTotal)).canBeReplaced()) {
			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves(), 2);

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves(), 2);

			for (var i = 1; i <= heightCrown; i++) {
				heightTrunk++;
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves());
			}

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves(), 2);

			heightTrunk++;
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());

			heightTrunk++;
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves(), 2);

			heightTrunk++;
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.leaves());

			IcariaFeatureHelper.placeTwigsPatch(pWorldGenLevel, pBlockPos, this.twigs(), 4);
			IcariaFeatureHelper.placeFallenPatch(pWorldGenLevel, pBlockPos, this.fallen(), 4);
			IcariaFeatureHelper.placeShroomsPatch(pWorldGenLevel, pBlockPos, this.shrooms(), 4);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<CypressTreeFeature> codec() {
		return CypressTreeFeature.CODEC;
	}
}
