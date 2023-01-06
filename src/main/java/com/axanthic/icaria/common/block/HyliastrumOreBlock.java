package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.HyliasterEntity;
import com.axanthic.icaria.common.registry.IcariaEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
			HyliasterEntity entity = IcariaEntities.HYLIASTER.get().create(pLevel);
			if (entity != null) {
				entity.moveTo(pPos.getX() + 0.5D, pPos.getY(), pPos.getZ() + 0.5D, 0.0F, 0.0F);
				entity.setTick(48000);
				entity.spawnAnim();
				pLevel.addFreshEntity(entity);
				pLevel.playSound(null, pPos, SoundEvents.SLIME_SQUISH, SoundSource.NEUTRAL, 1.0F, 1.0F);
			}
		}
	}
}
