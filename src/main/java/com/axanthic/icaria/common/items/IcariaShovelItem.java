package com.axanthic.icaria.common.items;

import com.axanthic.icaria.data.IcariaBlockTags;
import com.axanthic.icaria.common.util.IcariaTier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.TierSortingRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class IcariaShovelItem extends ShovelItem {
	public final TagKey<Block> blocks = BlockTags.MINEABLE_WITH_SHOVEL;
	public final Tier equivalentTier;

	public IcariaShovelItem(IcariaTier pTier, float pDamage, float pAttackSpeed, Properties pProperties) {
		super(pTier, pDamage, pAttackSpeed, pProperties);
		this.equivalentTier = pTier.vanillaEquivalent;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pState) {
		return pState.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pState);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pStack, BlockState pState) {
		return pState.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pState);
	}
}
