package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.common.properties.Olives;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveTreeFeature extends TreeFeature {
	public OliveTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), IcariaBlocks.OLIVE_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();

		var heightTrunk = 0;
		var heightTotal = origin.below().getY() + 8;

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
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3).east(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3).south(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3).west(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3).north(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3).west(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3).north(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3).east(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3).south(), 2);

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
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west(2));
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north(2));
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east(2));
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south(2));
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3).south());

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
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west());
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north());
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east());
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south());
			this.placeLeaves(level, origin.below().above(heightTrunk).north(2).west(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(2).north(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(2).east(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(2).south(2), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3));
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3).east(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3).south(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3).west(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3).north(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).north(3).west(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(3).north(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(3).east(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(3).south(), 2);

			heightTrunk++;
			this.placeLeaves(level, origin.below().above(heightTrunk));
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

			heightTrunk++;
			this.placeLeaves(level, origin.below().above(heightTrunk));
			this.placeLeaves(level, origin.below().above(heightTrunk).north(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).east(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).south(), 2);
			this.placeLeaves(level, origin.below().above(heightTrunk).west(), 2);

			this.placeTwigsPatch(level, origin, 4);
			this.placeFallenPatch(level, origin, 4);
			this.placeShroomsPatch(level, origin, 4);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void placeLeaves(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			if (pWorldGenLevel.getRandom().nextBoolean()) {
				if (pWorldGenLevel.getRandom().nextInt(2) == 0) {
					this.setBlock(pWorldGenLevel, pBlockPos, this.leaves.defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(IcariaBlockStateProperties.OLIVES, Olives.BLACK));
				} else if (pWorldGenLevel.getRandom().nextInt(2) == 1) {
					this.setBlock(pWorldGenLevel, pBlockPos, this.leaves.defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(IcariaBlockStateProperties.OLIVES, Olives.GREEN));
				} else {
					this.setBlock(pWorldGenLevel, pBlockPos, this.leaves.defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(IcariaBlockStateProperties.OLIVES, Olives.NONE));
				}
			} else {
				this.setBlock(pWorldGenLevel, pBlockPos, this.leaves.defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1).setValue(IcariaBlockStateProperties.OLIVES, Olives.LEAVES));
			}
		}
	}
}
