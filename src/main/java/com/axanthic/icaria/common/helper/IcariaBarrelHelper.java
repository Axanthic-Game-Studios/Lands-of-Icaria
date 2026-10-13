package com.axanthic.icaria.common.helper;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.tags.IcariaBlockTags;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBarrelHelper {

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
			if (pBlockState.is(IcariaBlockTags.BARRELS_LOADED)) {
				IcariaBarrelHelper.loaded(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
			} else if (pBlockState.is(IcariaBlockTags.BARRELS_TAPPED)) {
				IcariaBarrelHelper.tapped(pBlockPos, pLevel);
			}
		}
	}

	public static void loadedOrTappedRack(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (!pLevel.isClientSide()) {
			if (pBlockState.getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
				IcariaBarrelHelper.loaded(pBlockPos, null, Level.ExplosionInteraction.BLOCK, pLevel, 2, 10);
			} else if (pBlockState.getValue(IcariaBlockStateProperties.TAPPED_BARREL)) {
				IcariaBarrelHelper.tapped(pBlockPos, pLevel);
			}
		}
	}
}
