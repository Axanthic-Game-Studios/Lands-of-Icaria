package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class HyliastrumOreBlock extends Block {
	public HyliastrumOreBlock(Properties properties) {
		super(properties);
	}

	public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pTe, ItemStack pStack) {
		super.playerDestroy(pLevel, pPlayer, pPos, pState, pTe, pStack);
		if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
			pLevel.removeBlock(pPos, false);
			pLevel.setBlockAndUpdate(pPos, Blocks.WATER.defaultBlockState().setValue(LiquidBlock.LEVEL, 1)); //TODO replace with hyliastrum fluid
		}
	}
}
