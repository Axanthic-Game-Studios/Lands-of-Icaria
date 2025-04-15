package com.axanthic.icaria.common.item;

import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScytheItem extends HoeItem {
	public ScytheItem(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackSpeed, Properties pProperties) {
		super(pToolMaterial, pAttackDamage, pAttackSpeed, pProperties);
	}

	@Override
	public boolean canPerformAction(ItemStack pItemStack, ItemAbility pItemAbility) {
		return pItemAbility == ItemAbilities.HOE_DIG || pItemAbility == ItemAbilities.HOE_TILL || pItemAbility == ItemAbilities.SWORD_SWEEP;
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack pItemStack, BlockState pBlockState) {
		return pBlockState.is(IcariaBlockTagsProvider.MINEABLE_WITH_SCYTHE);
	}

	@Override
	public AABB getSweepHitBox(ItemStack pItemStack, Player pPlayer, Entity pEntity) {
		return pEntity.getBoundingBox().inflate(2.5D, 0.25D, 2.5D);
	}
}
