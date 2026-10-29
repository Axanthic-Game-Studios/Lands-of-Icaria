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

public record OliveTreeFeature(BlockState fallen, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<OliveTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("fallen").forGetter(OliveTreeFeature::fallen),
			BlockState.CODEC.fieldOf("leaves").forGetter(OliveTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(OliveTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(OliveTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(OliveTreeFeature::twigs)
		).apply(instance, OliveTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var heightTrunk = 0;
		var heightTotal = pBlockPos.below().getY() + 8;

		if (heightTotal < pWorldGenLevel.getMaxY() && pWorldGenLevel.getBlockState(pBlockPos.atY(heightTotal)).canBeReplaced()) {
			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).south(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(), this.leaves(), 2);

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3).south(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3).south(), this.leaves(), 2);

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3).south(), this.leaves());

			heightTrunk++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(2), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3).south(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(3).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(3).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(3).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(3).south(), this.leaves(), 2);

			heightTrunk++;
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north().east(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east().south(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south().west(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west().north(), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).south(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(2).west(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(2).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(2).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(2).south(), this.leaves(), 2);

			heightTrunk++;
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.leaves());
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).north(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).east(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).south(), this.leaves(), 2);
			IcariaFeatureHelper.placeOlives(pWorldGenLevel, pBlockPos.below().above(heightTrunk).west(), this.leaves(), 2);

			IcariaFeatureHelper.placeTwigsPatch(pWorldGenLevel, pBlockPos, this.twigs(), 4);
			IcariaFeatureHelper.placeFallenPatch(pWorldGenLevel, pBlockPos, this.fallen(), 4);
			IcariaFeatureHelper.placeShroomsPatch(pWorldGenLevel, pBlockPos, this.shrooms(), 4);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<OliveTreeFeature> codec() {
		return OliveTreeFeature.CODEC;
	}
}
