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

	public IcariaCraftingMenu(int id, Inventory inventory, ContainerLevelAccess access, Block block) {
		super(id, inventory, access);
		this.block = block;
		this.access = access;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return stillValid(this.access, pPlayer, this.block);
	}
}
