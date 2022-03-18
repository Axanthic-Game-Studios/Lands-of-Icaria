package com.axanthic.icaria.common.items;

import com.axanthic.icaria.datagen.IcariaBlockTags;
import com.axanthic.icaria.util.IcariaTier;

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

public class IcariaScytheItem extends HoeItem {
	public final TagKey<Block> blocks = IcariaBlockTags.MINEABLE_WITH_SCYTHE;
	public final Tier equivalentTier;
	public static final Set<ToolAction> SCYTHE_ACTIONS = Stream.of(ToolActions.HOE_DIG, ToolActions.SWORD_SWEEP).collect(Collectors.toCollection(Sets::newIdentityHashSet));

	public IcariaScytheItem(IcariaTier pTier, int pDamage, float pAttackSpeed, Properties pProperties) {
		super(pTier, pDamage, pAttackSpeed, pProperties);
		this.equivalentTier = pTier.vanillaEquivalent;
	}

	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pEntity, LivingEntity pPlayer) {
		pStack.hurtAndBreak(1, pPlayer, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack pStack, BlockPos pPos, Player pPlayer) {
		Level world = pPlayer.getLevel();
		if (isCorrectToolForDrops(world.getBlockState(pPos))) {
			for (BlockPos pos2 : BlockPos.withinManhattan(pPos, 1, 1, 1)) {
				if (!pos2.equals(pPos) && isCorrectToolForDrops(world.getBlockState(pos2)))
					world.destroyBlock(pos2, true, pPlayer);
			}
		}

		return false;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack pStack, Enchantment pEnchantment) {
		return pEnchantment.category == EnchantmentCategory.WEAPON || pEnchantment.category.canEnchant(pStack.getItem());
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState pState) {
		return pState.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pState);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pStack, BlockState pState) {
		return pState.is(blocks) && TierSortingRegistry.isCorrectTierForDrops(pState.is(IcariaBlockTags.ICARIA_TIER) ? getTier() : equivalentTier, pState);
	}

	@Override
	public boolean canPerformAction(ItemStack pStack, ToolAction pAction) {
		return SCYTHE_ACTIONS.contains(pAction);
	}

	@Override
	public @Nonnull AABB getSweepHitBox(ItemStack pStack, Player pPlayer, Entity pTarget) {
		return pTarget.getBoundingBox().inflate(1.4D, 0.25D, 1.4D);
	}
}
