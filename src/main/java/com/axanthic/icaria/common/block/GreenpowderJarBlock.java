package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import org.jspecify.annotations.Nullable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreenpowderJarBlock extends JarBlock {
	public GreenpowderJarBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
		if (!pServerLevel.isClientSide()) {
			IcariaCommonHelper.explosion(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pServerLevel, 2);
			IcariaCommonHelper.fire(pBlockPos, pServerLevel, 2, 10);
		}
	}

	@Override
	public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pBlockPos, BlockState pBlockState, @Nullable BlockEntity pBlockEntity, ItemStack pItemStack) {
		super.playerDestroy(pLevel, pPlayer, pBlockPos, pBlockState, pBlockEntity, pItemStack);
		if (!pLevel.isClientSide()) {
			IcariaCommonHelper.explosion(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2);
			IcariaCommonHelper.fire(pBlockPos, pLevel, 2, 10);
		}
	}
}
