package com.axanthic.icaria.common.menu;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CraftingTableMenu extends CraftingMenu {
	public Block block;

	public ContainerLevelAccess containerLevelAccess;

	public CraftingTableMenu(int pId, Inventory pInventory, ContainerLevelAccess pContainerLevelAccess, Block pBlock) {
		super(pId, pInventory, pContainerLevelAccess);
		this.block = pBlock;
		this.containerLevelAccess = pContainerLevelAccess;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return AbstractContainerMenu.stillValid(this.containerLevelAccess, pPlayer, this.block);
	}
}
