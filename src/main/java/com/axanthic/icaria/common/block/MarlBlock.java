package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class MarlBlock extends Block {
	public MarlBlock(Properties pProperties) {
		super(pProperties);
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
