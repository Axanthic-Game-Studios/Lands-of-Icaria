package com.axanthic.icaria.common.blocks;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class HyliastrumOreBlock extends Block {
	public HyliastrumOreBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void playerDestroy(@Nonnull Level pLevel, @Nonnull Player pPlayer, @Nonnull BlockPos pPos, @Nonnull BlockState pState, BlockEntity pTe, @Nonnull ItemStack pStack) {
		super.playerDestroy(pLevel, pPlayer, pPos, pState, pTe, pStack);
		if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
			pLevel.removeBlock(pPos, false);
			pLevel.setBlockAndUpdate(pPos, IcariaBlocks.HYLIASTRUM_FLUID.get().defaultBlockState().setValue(LiquidBlock.LEVEL, 1));
		}
	}
}
