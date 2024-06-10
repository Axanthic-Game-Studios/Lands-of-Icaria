package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.util.IcariaTier;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.common.TierSortingRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@ParametersAreNonnullByDefault

public class IcariaAxeItem extends AxeItem {
	public Tier vanillaEquivalent;

	public IcariaAxeItem(IcariaTier pTier, int pDamage, float pAttackSpeed, Properties pProperties) {
		super(pTier, pDamage, pAttackSpeed, pProperties);
		this.vanillaEquivalent = pTier.vanillaEquivalent;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pBlock) {
		return pBlock.is(BlockTags.MINEABLE_WITH_AXE) && TierSortingRegistry.isCorrectTierForDrops(pBlock.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : this.vanillaEquivalent, pBlock);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pStack, BlockState pState) {
		return pState.is(BlockTags.MINEABLE_WITH_AXE) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : this.vanillaEquivalent, pState);
	}
}
