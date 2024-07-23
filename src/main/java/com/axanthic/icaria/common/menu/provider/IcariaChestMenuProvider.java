package com.axanthic.icaria.common.menu.provider;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestMenuProvider implements MenuProvider {
	public ChestBlockEntity first;
	public ChestBlockEntity second;

	public Container container;

	public IcariaChestMenuProvider(ChestBlockEntity pFirst, ChestBlockEntity pSecond, Container pContainer) {
		this.first = pFirst;
		this.second = pSecond;
		this.container = pContainer;
	}

	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
		if (this.first.canOpen(pPlayer) && this.second.canOpen(pPlayer)) {
			this.first.unpackLootTable(pPlayerInventory.player);
			this.second.unpackLootTable(pPlayerInventory.player);
			return new ChestMenu(MenuType.GENERIC_9x4, pContainerId, pPlayerInventory, this.container, 4);
		} else {
			return null;
		}
	}

	@Override
	public Component getDisplayName() {
		return this.first.hasCustomName() ? this.first.getDisplayName() : this.second.hasCustomName() ? this.second.getDisplayName() : Component.translatable("container.chestDouble");
	}
}
