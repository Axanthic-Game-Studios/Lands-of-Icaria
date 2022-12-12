package com.axanthic.icaria.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class HyliastrumOreBlock extends Block {
	public HyliastrumOreBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
		super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
		if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
			Slime slime = EntityType.SLIME.create(pLevel); // TODO: replace with Icaria slime
			if (slime != null) {
				slime.moveTo((double)pPos.getX() + 0.5D, pPos.getY(), (double)pPos.getZ() + 0.5D, 0.0F, 0.0F);
				pLevel.addFreshEntity(slime);
				slime.setSize(1, true);
				slime.spawnAnim();
			}
		}
	}
}
