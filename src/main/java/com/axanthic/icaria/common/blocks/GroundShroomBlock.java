package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class GroundShroomBlock extends BushTypeBlock implements IPlantable {
	public GroundShroomBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return this.mayPlaceOn(pLevel.getBlockState(pPos.below()), pLevel, pPos);
	}

	public boolean mayPlaceOn(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		if (pState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else {
			return pLevel.getRawBrightness(pPos, 0) < 13 && pState.canSustainPlant(pLevel, pPos, Direction.UP, this);
		}
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
		if (pRandom.nextInt(25) == 0) {
			int i = 5;

			for(BlockPos posOne : BlockPos.betweenClosed(pPos.offset(-4, -1, -4), pPos.offset(4, 1, 4))) {
				if (pLevel.getBlockState(posOne).is(this)) {
					--i;
					if (i <= 0) {
						return;
					}
				}
			}

			BlockPos posTwo = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);

			for(int k = 0; k < 4; ++k) {
				if (pLevel.isEmptyBlock(posTwo) && pState.canSurvive(pLevel, posTwo)) {
					pPos = posTwo;
				}

				posTwo = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
			}

			if (pLevel.isEmptyBlock(posTwo) && pState.canSurvive(pLevel, posTwo)) {
				pLevel.setBlock(posTwo, pState, 2);
			}
		}
	}

	@Override
	public BlockState getPlant(BlockGetter level, BlockPos pos) {
		return level.getBlockState(pos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.CAVE;
	}
}
