package com.axanthic.icaria.common.helper;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCommonHelper {

	public static void explosion(BlockPos pBlockPos, @Nullable Entity pEntity, Level.ExplosionInteraction pExplosionInteraction, Level pLevel, int pRadius) {
		pLevel.explode(pEntity, pBlockPos.getX(), pBlockPos.getY(), pBlockPos.getZ(), pRadius, pExplosionInteraction);
	}

	public static void fire(BlockPos pBlockPos, Level pLevel, int pRadius, int pChance) {
		for (var i = -pRadius; i <= pRadius; i++) {
			var blockPosMin = BlockPos.containing(pBlockPos.getX() - i, pBlockPos.getY() - i, pBlockPos.getZ() - i);
			var blockPosMax = BlockPos.containing(pBlockPos.getX() + i, pBlockPos.getY() + i, pBlockPos.getZ() + i);
			for (var blockPos : BlockPos.betweenClosed(blockPosMin, blockPosMax)) {
				var blockState = pLevel.getBlockState(blockPos);
				var fluidState = pLevel.getFluidState(blockPos);
				if (pLevel.getBlockState(blockPos.below()).isSolidRender() && pLevel.getRandom().nextInt(pChance) == 0) {
					if (fluidState.is(IcariaFluids.MEDITERRANEAN_WATER.get())) {
						pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, true));
					} else if (fluidState.is(Fluids.WATER)) {
						pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true));
					} else if (blockState.isAir()) {
						pLevel.setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
					}
				}
			}
		}
	}

	public static void hurt(DamageSource pDamageSource, Entity pEntity, float pAmount) {
		if (pEntity.level() instanceof ServerLevel serverLevel) {
			pEntity.hurtServer(serverLevel, pDamageSource, pAmount);
		}
	}

	public static void loaded(BlockPos pBlockPos, @Nullable Entity pEntity, Level.ExplosionInteraction pExplosionInteraction, Level pLevel, int pRadius, int pChance) {
		IcariaCommonHelper.explosion(pBlockPos, pEntity, pExplosionInteraction, pLevel, pRadius);
		IcariaCommonHelper.fire(pBlockPos, pLevel, pRadius, pChance);
	}

	public static void tapped(BlockPos pBlockPos, Level pLevel) {
		if (pLevel.getBlockState(pBlockPos).isAir() && pLevel.getBlockState(pBlockPos.below()).isSolidRender()) {
			pLevel.setBlockAndUpdate(pBlockPos, IcariaBlocks.MEDITERRANEAN_WATER.get().defaultBlockState());
		}
	}

	public static void loadedOrTappedBarrel(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (!pLevel.isClientSide()) {
			if (pBlockState.is(IcariaBlockTagsProvider.BARRELS_LOADED)) {
				IcariaCommonHelper.loaded(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
			} else if (pBlockState.is(IcariaBlockTagsProvider.BARRELS_TAPPED)) {
				IcariaCommonHelper.tapped(pBlockPos, pLevel);
			}
		}
	}

	public static void loadedOrTappedRack(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (!pLevel.isClientSide()) {
			if (pBlockState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
				IcariaCommonHelper.loaded(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
			} else if (pBlockState.getValue(IcariaBlockStateProperties.TAPPED_BARREL)) {
				IcariaCommonHelper.tapped(pBlockPos, pLevel);
			}
		}
	}

	public static void setItemInHand(InteractionHand pInteractionHand, ItemStack pItemStack, Player pPlayer) {
		if (!pPlayer.isCreative()) {
			pPlayer.setItemInHand(pInteractionHand, pItemStack);
		}
	}
}
