package com.axanthic.landsoficaria.common.items;

import com.axanthic.landsoficaria.datagen.IcariaBlockTags;
import com.axanthic.landsoficaria.util.IcariaTier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;

public class IcariaShovelItem extends ShovelItem {

	private final Tag<Block> blocks = BlockTags.MINEABLE_WITH_SHOVEL;
	private final Tier equivalentTier;

	public IcariaShovelItem(IcariaTier tier, float damage, float attackSpeed, Properties prop) {
		super(tier, damage, attackSpeed, prop);
		this.equivalentTier = tier.vanillaEquivalent;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		return state.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(state.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, state);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
		return state.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(state.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, state);
	}
}
