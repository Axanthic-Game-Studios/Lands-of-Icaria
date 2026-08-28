package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeHandler extends ItemStacksResourceHandler {
	public ForgeBlockEntity blockEntity;

	public ForgeHandler(ForgeBlockEntity pBlockEntity) {
		super(pBlockEntity.getSize());
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isValid(int pIndex, ItemResource pItemResource) {
		return switch (pIndex) {
			case 0 -> this.blockEntity.getLevel() instanceof ServerLevel serverLevel && pItemResource.toStack().getBurnTime(IcariaRecipeTypes.FORGING.get(), serverLevel.fuelValues()) > 0;
			case 1, 2, 3 -> true;
			default -> false;
		};
	}

	@Override
	public void onContentsChanged(int pIndex, ItemStack pItemStack) {
		this.blockEntity.setChanged();
	}
}
