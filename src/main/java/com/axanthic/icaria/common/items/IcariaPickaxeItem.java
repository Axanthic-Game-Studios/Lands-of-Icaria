package com.axanthic.icaria.common.items;

import com.axanthic.icaria.datagen.IcariaBlockTags;
import com.axanthic.icaria.util.IcariaTier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.TierSortingRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class IcariaPickaxeItem extends PickaxeItem {
	private final TagKey<Block> blocks = BlockTags.MINEABLE_WITH_PICKAXE;
	private final Tier equivalentTier;

	public IcariaPickaxeItem(IcariaTier tier, int damage, float attackSpeed, Properties properties) {
		super(tier, damage, attackSpeed, properties);
		this.equivalentTier = tier.vanillaEquivalent;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pBlock) {
		return pBlock.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pBlock.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pBlock);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
		return state.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(state.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, state);
	}
}
