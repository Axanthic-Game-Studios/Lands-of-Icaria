package com.axanthic.landsoficaria.common.items;

import com.axanthic.landsoficaria.datagen.IcariaBlockTags;
import com.axanthic.landsoficaria.util.IcariaTier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class IcariaPickaxeItem extends PickaxeItem {

	private final Tag<Block> blocks = BlockTags.MINEABLE_WITH_PICKAXE;
	private final Tier equivalentTier;

	public IcariaPickaxeItem(IcariaTier tier, int damage, float attackSpeed, Properties prop) {
		super(tier, damage, attackSpeed, prop);
		this.equivalentTier = tier.vanillaEquivalent;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		Tier tier = state.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier;
		if (net.minecraftforge.common.TierSortingRegistry.isTierSorted(tier)) {
			return net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(tier, state) && state.is(this.blocks);
		}
		int i = tier.getLevel();
		if (i < 3 && state.is(BlockTags.NEEDS_DIAMOND_TOOL)) {
			return false;
		} else if (i < 2 && state.is(BlockTags.NEEDS_IRON_TOOL)) {
			return false;
		} else {
			return i < 1 && state.is(BlockTags.NEEDS_STONE_TOOL) ? false : state.is(this.blocks);
		}
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
		return state.is(blocks) && net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(state.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, state);
	}
}
