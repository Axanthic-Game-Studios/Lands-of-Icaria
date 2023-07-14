package com.axanthic.icaria.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSandBlock extends Block {
	public IcariaSandBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		var plantType = pPlantable.getPlantType(pLevel, pPos.relative(pDirection));
		if (plantType == PlantType.BEACH) {
			boolean water = false;
			for (var direction : Direction.Plane.HORIZONTAL) {
				var directionPos = pPos.relative(direction);
				water = pLevel.getBlockState(directionPos).is(Blocks.FROSTED_ICE);
				water |= pLevel.getFluidState(directionPos).is(FluidTags.WATER);
				if (water) {
					break;
				}
			}

			return water;
		} else {
			return plantType == PlantType.CAVE || plantType == PlantType.DESERT;
		}
	}
}
