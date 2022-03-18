package com.axanthic.icaria.common.items;

import com.axanthic.icaria.datagen.IcariaBlockTags;
import com.axanthic.icaria.util.IcariaTier;

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
	public final TagKey<Block> blocks = BlockTags.MINEABLE_WITH_AXE;
	public final Tier equivalentTier;

	public IcariaAxeItem(IcariaTier pTier, float pDamage, float pAttackSpeed, Properties pProperties) {
		super(pTier, pDamage, pAttackSpeed, pProperties);
		this.equivalentTier = pTier.vanillaEquivalent;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pBlock) {
		return pBlock.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pBlock.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pBlock);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pStack, BlockState pState) {
		return pState.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pState);
	}
}
