package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.KilnBlockEntity;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnHandler extends ItemStacksResourceHandler {
	public KilnBlockEntity blockEntity;

	public KilnHandler(KilnBlockEntity pBlockEntity) {
		super(pBlockEntity.getSize());
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isValid(int pIndex, ItemResource pItemResource) {
		return switch (pIndex) {
			case 0 -> this.blockEntity.getLevel() instanceof ServerLevel serverLevel && pItemResource.toStack().getBurnTime(IcariaRecipeTypes.FIRING.get(), serverLevel.fuelValues()) > 0;
			case 1 -> true;
			default -> false;
		};
	}

	@Override
	public void onContentsChanged(int pIndex, ItemStack pItemStack) {
		this.blockEntity.setChanged();
	}
}
