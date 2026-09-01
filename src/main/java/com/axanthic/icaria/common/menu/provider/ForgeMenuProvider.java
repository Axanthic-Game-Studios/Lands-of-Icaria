package com.axanthic.icaria.common.menu.provider;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.menu.ForgeMenu;
import com.axanthic.icaria.common.registry.IcariaKeys;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeMenuProvider implements MenuProvider {
	public ForgeBlockEntity blockEntity;

	public ForgeMenuProvider(ForgeBlockEntity pBlockEntity) {
		this.blockEntity = pBlockEntity;
	}

	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
		return new ForgeMenu(pContainerId, this.blockEntity, pPlayer, this.blockEntity.data, pInventory, this.blockEntity.handler);
	}

	@Override
	public Component getDisplayName() {
		return Component.translatable("menu" + "." + IcariaKeys.ID + "." + "forge");
	}
}
