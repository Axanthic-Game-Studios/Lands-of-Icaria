package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliastrumOreBlock extends Block {
	public HyliastrumOreBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void spawnAfterBreak(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, ItemStack pItemStack, boolean pDropExperience) {
		var entity = IcariaEntityTypes.HYLIASTER.get().create(pServerLevel, EntitySpawnReason.TRIGGERED);
		if (pServerLevel.getGameRules().get(GameRules.BLOCK_DROPS)) {
			if (pItemStack.getEnchantmentLevel(pServerLevel.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH)) == 0) {
				if (entity != null) {
					entity.snapTo(pBlockPos.getX() + 0.5D, pBlockPos.getY(), pBlockPos.getZ() + 0.5D, 0.0F, 0.0F);
					entity.setSize(4);
					entity.spawnAnim();
					pServerLevel.addFreshEntity(entity);
				}
			}
		}
	}
}
