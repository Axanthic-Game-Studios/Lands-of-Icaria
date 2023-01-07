package com.axanthic.icaria.common.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaCraftingMenu extends CraftingMenu {
	public Block block;
	public ContainerLevelAccess access;

	public IcariaCraftingMenu(int pId, Inventory pInventory, ContainerLevelAccess pAccess, Block pBlock) {
		super(pId, pInventory, pAccess);
		this.block = pBlock;
		this.access = pAccess;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return stillValid(this.access, pPlayer, this.block);
	}
}
