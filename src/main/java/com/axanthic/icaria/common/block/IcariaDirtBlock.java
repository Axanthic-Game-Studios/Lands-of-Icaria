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

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaDirtBlock extends Block {
	public IcariaDirtBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		var relativePos = pPos.relative(pDirection);
		var plantType = pPlantable.getPlantType(pLevel, relativePos);
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
			return plantType == PlantType.CAVE || plantType == PlantType.PLAINS || pPlantable.getPlant(pLevel, relativePos).is(Blocks.DEAD_BUSH);
		}
	}

	@Override
	public BlockState getToolModifiedState(BlockState pState, UseOnContext pContext, ToolAction pToolAction, boolean pSimulate) {
		if (pContext.getLevel().getBlockState(pContext.getClickedPos().above()).isAir()) {
			if (pToolAction.equals(ToolActions.HOE_TILL)) {
				return IcariaBlocks.FARMLAND.get().defaultBlockState();
			}
		}

		return null;
	}
}
