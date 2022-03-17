package com.axanthic.icaria.common.items;

import com.axanthic.icaria.datagen.IcariaBlockTags;
import com.axanthic.icaria.util.IcariaTier;

import com.google.common.collect.Sets;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaScytheItem extends HoeItem {
	private final TagKey<Block> blocks = IcariaBlockTags.MINEABLE_WITH_SCYTHE;
	private final Tier equivalentTier;
	public static final Set<ToolAction> SCYTHE_ACTIONS = Stream.of(ToolActions.HOE_DIG, ToolActions.SWORD_SWEEP /* TODO: , ToolActions.HOE_TILL */).collect(Collectors.toCollection(Sets::newIdentityHashSet));

	public IcariaScytheItem(IcariaTier tier, int damage, float attackSpeed, Properties prop) {
		super(tier, damage, attackSpeed, prop);
		this.equivalentTier = tier.vanillaEquivalent;
	}

	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		pStack.hurtAndBreak(1, pAttacker, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, Player player) {
		Level world = player.getLevel();
		if (isCorrectToolForDrops(world.getBlockState(pos))) {
			for (BlockPos pos2 : BlockPos.withinManhattan(pos, 1, 1, 1)) {
				if (!pos2.equals(pos) && isCorrectToolForDrops(world.getBlockState(pos2)))
					world.destroyBlock(pos2, true, player);
			}
		}

		return false;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category.canEnchant(stack.getItem());
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pBlock) {
		return pBlock.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pBlock.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pBlock);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
		return state.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(state.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, state);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction action) {
		return SCYTHE_ACTIONS.contains(action);
	}

	@Override
	public AABB getSweepHitBox(ItemStack stack, Player player, Entity target) {
		return target.getBoundingBox().inflate(1.4D, 0.25D, 1.4D);
	}
}
