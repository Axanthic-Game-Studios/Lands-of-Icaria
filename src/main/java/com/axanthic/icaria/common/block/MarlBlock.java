package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class MarlBlock extends Block {
	public MarlBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public BlockState getToolModifiedState(BlockState pState, UseOnContext pContext, ItemAbility pToolAction, boolean pSimulate) {
		var blockPos = pContext.getClickedPos();
		var level = pContext.getLevel();
		if (pToolAction.equals(ItemAbilities.HOE_TILL)) {
			if (level.getBlockState(blockPos.above()).isAir()) {
				if (level.getBlockState(blockPos).is(IcariaBlocks.COARSE_MARL.get())) {
					return IcariaBlocks.MARL.get().defaultBlockState();
				} else {
					return IcariaBlocks.FARMLAND.get().defaultBlockState();
				}
			}
		}

		return null;
	}
}
