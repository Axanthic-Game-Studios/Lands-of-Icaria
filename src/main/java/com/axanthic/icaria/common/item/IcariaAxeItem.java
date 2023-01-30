package com.axanthic.icaria.common.item;

import com.axanthic.icaria.data.tags.IcariaBlockTags;
import com.axanthic.icaria.common.util.IcariaTier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.TierSortingRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class IcariaAxeItem extends AxeItem {
	public static final TagKey<Block> BLOCKS = BlockTags.MINEABLE_WITH_AXE;

	public Tier equivalentTier;

	public IcariaAxeItem(IcariaTier pTier, int pDamage, float pAttackSpeed, Properties pProperties) {
		super(pTier, pDamage, pAttackSpeed, pProperties);
		this.equivalentTier = pTier.vanillaEquivalent;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pBlock) {
		return pBlock.is(BLOCKS) && TierSortingRegistry.isCorrectTierForDrops(pBlock.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : this.equivalentTier, pBlock);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pStack, BlockState pState) {
		return pState.is(BLOCKS) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : this.equivalentTier, pState);
	}
}
