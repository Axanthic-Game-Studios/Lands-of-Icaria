package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class DirtTypeBlock extends Block {
	public DirtTypeBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		PlantType plantType = pPlantable.getPlantType(pLevel, pPos.relative(pDirection));
		BlockState plant = pPlantable.getPlant(pLevel, pPos.relative(pDirection));
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
			return plantType == PlantType.CAVE || plantType == PlantType.PLAINS || plant.is(Blocks.DEAD_BUSH);
		}
	}

	@Override
	public BlockState getToolModifiedState(BlockState pState, UseOnContext pContext, ToolAction pAction, boolean pSimulate) {
		if (pAction.equals(ToolActions.HOE_TILL) && pContext.getLevel().getBlockState(pContext.getClickedPos().above()).isAir()) {
			return IcariaBlocks.FARMLAND.get().defaultBlockState();
		}

		return null;
	}
}
