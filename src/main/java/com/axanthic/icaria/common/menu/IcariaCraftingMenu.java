package com.axanthic.icaria.common.menu;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCraftingMenu extends CraftingMenu {
	public Block block;

	public ContainerLevelAccess containerLevelAccess;

	public IcariaCraftingMenu(int pId, Inventory pInventory, ContainerLevelAccess pContainerLevelAccess, Block pBlock) {
		super(pId, pInventory, pContainerLevelAccess);
		this.block = pBlock;
		this.containerLevelAccess = pContainerLevelAccess;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return AbstractContainerMenu.stillValid(this.containerLevelAccess, pPlayer, this.block);
	}
}
