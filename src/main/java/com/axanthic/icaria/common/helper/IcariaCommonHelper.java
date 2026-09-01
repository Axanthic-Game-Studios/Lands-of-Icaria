package com.axanthic.icaria.common.helper;

import com.axanthic.icaria.common.properties.Carpet;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCommonHelper {

	public static boolean hasRigidBlockBelow(BlockPos pBlockPos, LevelReader pLevelReader) {
		return pLevelReader.getBlockState(pBlockPos.below()).isFaceSturdy(pLevelReader, pBlockPos.below(), Direction.UP, SupportType.RIGID);
	}

	public static boolean hasWrongCarrySetup(Player pPlayer) {
		return pPlayer.isCrouching() || pPlayer.isDeadOrDying() || pPlayer.isFallFlying() || pPlayer.isSleeping() || pPlayer.isVehicle() || pPlayer.isVisuallyCrawling() || pPlayer.isVisuallySwimming();
	}

	public static void explosion(BlockPos pBlockPos, @Nullable Entity pEntity, Level.ExplosionInteraction pExplosionInteraction, Level pLevel, int pRadius) {
		pLevel.explode(pEntity, pBlockPos.getX(), pBlockPos.getY(), pBlockPos.getZ(), pRadius, pExplosionInteraction);
	}

	public static void fire(BlockPos pBlockPos, Level pLevel, int pRadius, int pChance) {
		for (var i = -pRadius; i <= pRadius; i++) {
			var blockPosMin = new BlockPos(pBlockPos.getX() - i, pBlockPos.getY() - i, pBlockPos.getZ() - i);
			var blockPosMax = new BlockPos(pBlockPos.getX() + i, pBlockPos.getY() + i, pBlockPos.getZ() + i);
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

	public static void setAttribute(Holder<Attribute> pHolder, LivingEntity pLivingEntity, double pValue) {
		var attributeInstance = pLivingEntity.getAttribute(pHolder);
		if (attributeInstance != null) {
			attributeInstance.setBaseValue(pValue);
		}
	}

	public static void setItemInHand(InteractionHand pInteractionHand, ItemStack pItemStack, Player pPlayer) {
		if (!pPlayer.isCreative()) {
			pPlayer.setItemInHand(pInteractionHand, pItemStack);
		}
	}

	public static Item getItemByCarpet(Carpet pCarpet) {
		return switch (pCarpet) {
			case Carpet.ARACHNE_STRING_CARPET -> IcariaItems.ARACHNE_STRING_CARPET.get();
			case Carpet.WHITE_ARACHNE_STRING_CARPET -> IcariaItems.WHITE_ARACHNE_STRING_CARPET.get();
			case Carpet.LIGHT_GRAY_ARACHNE_STRING_CARPET -> IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get();
			case Carpet.GRAY_ARACHNE_STRING_CARPET -> IcariaItems.GRAY_ARACHNE_STRING_CARPET.get();
			case Carpet.BLACK_ARACHNE_STRING_CARPET -> IcariaItems.BLACK_ARACHNE_STRING_CARPET.get();
			case Carpet.BROWN_ARACHNE_STRING_CARPET -> IcariaItems.BROWN_ARACHNE_STRING_CARPET.get();
			case Carpet.RED_ARACHNE_STRING_CARPET -> IcariaItems.RED_ARACHNE_STRING_CARPET.get();
			case Carpet.ORANGE_ARACHNE_STRING_CARPET -> IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get();
			case Carpet.YELLOW_ARACHNE_STRING_CARPET -> IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get();
			case Carpet.LIME_ARACHNE_STRING_CARPET -> IcariaItems.LIME_ARACHNE_STRING_CARPET.get();
			case Carpet.GREEN_ARACHNE_STRING_CARPET -> IcariaItems.GREEN_ARACHNE_STRING_CARPET.get();
			case Carpet.CYAN_ARACHNE_STRING_CARPET -> IcariaItems.CYAN_ARACHNE_STRING_CARPET.get();
			case Carpet.LIGHT_BLUE_ARACHNE_STRING_CARPET -> IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get();
			case Carpet.BLUE_ARACHNE_STRING_CARPET -> IcariaItems.BLUE_ARACHNE_STRING_CARPET.get();
			case Carpet.PURPLE_ARACHNE_STRING_CARPET -> IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get();
			case Carpet.MAGENTA_ARACHNE_STRING_CARPET -> IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get();
			case Carpet.PINK_ARACHNE_STRING_CARPET -> IcariaItems.PINK_ARACHNE_STRING_CARPET.get();
		};
	}
}
