package com.axanthic.icaria.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class SandTypeBlock extends Block {
	public SandTypeBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		PlantType plantType = pPlantable.getPlantType(pLevel, pPos.relative(pDirection));
		if (plantType == PlantType.BEACH) {
			boolean water = false;
			for (Direction direction : Direction.Plane.HORIZONTAL) {
				BlockState blockState = pLevel.getBlockState(pPos.relative(direction));
				FluidState fluidState = pLevel.getFluidState(pPos.relative(direction));
				water |= blockState.is(Blocks.FROSTED_ICE);
				water |= fluidState.is(FluidTags.WATER);
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
