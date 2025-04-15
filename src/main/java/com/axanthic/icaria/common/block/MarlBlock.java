package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MarlBlock extends Block {
	public MarlBlock(Properties pProperties) {
		super(pProperties);
	}

	@Nullable
	@Override
	public BlockState getToolModifiedState(BlockState pBlockState, UseOnContext pUseOnContext, ItemAbility pItemAbility, boolean pSimulate) {
		var blockPos = pUseOnContext.getClickedPos();
		var level = pUseOnContext.getLevel();
		if (level.getBlockState(blockPos.above()).isAir() && pItemAbility == ItemAbilities.HOE_TILL) {
			return this.getToolModifiedState(level.getBlockState(blockPos));
		} else {
			return null;
		}
	}

	public BlockState getToolModifiedState(BlockState pBlockState) {
		if (pBlockState.is(IcariaBlocks.DRY_LAKE_BED.get())) {
			return IcariaBlocks.COARSE_MARL.get().defaultBlockState();
		} else if (pBlockState.is(IcariaBlocks.COARSE_MARL.get())) {
			return IcariaBlocks.MARL.get().defaultBlockState();
		} else {
			return IcariaBlocks.FARMLAND.get().defaultBlockState();
		}
	}
}
