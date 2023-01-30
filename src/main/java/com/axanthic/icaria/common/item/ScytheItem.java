package com.axanthic.icaria.common.item;

import com.axanthic.icaria.data.tags.IcariaBlockTags;
import com.axanthic.icaria.common.util.IcariaTier;

import com.google.common.collect.Sets;

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

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class ScytheItem extends HoeItem {
	public static final TagKey<Block> BLOCKS = IcariaBlockTags.MINEABLE_WITH_SCYTHE;

	public Tier equivalentTier;

	public static final Set<ToolAction> SCYTHE_ACTIONS = Stream.of(ToolActions.HOE_TILL, ToolActions.SWORD_SWEEP).collect(Collectors.toCollection(Sets::newIdentityHashSet));

	public ScytheItem(IcariaTier pTier, int pDamage, float pAttackSpeed, Properties pProperties) {
		super(pTier, pDamage, pAttackSpeed, pProperties);
		this.equivalentTier = pTier.vanillaEquivalent;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack pStack, Enchantment pEnchantment) {
		return pEnchantment.category == EnchantmentCategory.WEAPON || pEnchantment.category.canEnchant(pStack.getItem());
	}

	@Override
	public boolean canPerformAction(ItemStack pStack, ToolAction pAction) {
		return SCYTHE_ACTIONS.contains(pAction);
	}

	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		pStack.hurtAndBreak(1, pAttacker, (pLivingEntity) -> pLivingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pState) {
		return pState.is(BLOCKS) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : this.equivalentTier, pState);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pStack, BlockState pState) {
		return pState.is(BLOCKS) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : this.equivalentTier, pState);
	}

	@Override
	public boolean onBlockStartBreak(ItemStack pStack, BlockPos pPos, Player pPlayer) {
		Level level = pPlayer.getLevel();
		if (this.isCorrectToolForDrops(level.getBlockState(pPos))) {
			for (BlockPos blockPos : BlockPos.withinManhattan(pPos, 1, 1, 1)) {
				if (!blockPos.equals(pPos) && this.isCorrectToolForDrops(level.getBlockState(blockPos)))
					level.destroyBlock(blockPos, true, pPlayer);
			}
		}

		return false;
	}

	@Override
	public @Nonnull AABB getSweepHitBox(ItemStack pStack, Player pPlayer, Entity pTarget) {
		return pTarget.getBoundingBox().inflate(1.4D, 0.25D, 1.4D);
	}
}
