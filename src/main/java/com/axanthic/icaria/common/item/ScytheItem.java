package com.axanthic.icaria.common.item;

import com.axanthic.icaria.data.tags.IcariaBlockTags;

import com.google.common.collect.Sets;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScytheItem extends HoeItem {
	public static final Set<ItemAbility> SCYTHE_ACTIONS = Stream.of(ItemAbilities.HOE_TILL, ItemAbilities.SWORD_SWEEP).collect(Collectors.toCollection(Sets::newIdentityHashSet));

	public ScytheItem(SimpleTier pTier, Properties pProperties) {
		super(pTier, pProperties);
	}

	@Override
	public boolean canPerformAction(ItemStack pStack, ItemAbility pAction) {
		return ScytheItem.SCYTHE_ACTIONS.contains(pAction);
	}

	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		pStack.hurtAndBreak(1, pAttacker, LivingEntity.getSlotForHand(InteractionHand.MAIN_HAND));
		return true;
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pStack, BlockState pState) {
		return pState.is(IcariaBlockTags.MINEABLE_WITH_SCYTHE);
	}

	@Override
	public AABB getSweepHitBox(ItemStack pStack, Player pPlayer, Entity pTarget) {
		return pTarget.getBoundingBox().inflate(1.4D, 0.25D, 1.4D);
	}
}
