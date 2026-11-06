package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SmithingHeftMenu extends AnvilMenu {
	public Block block;

	public ContainerLevelAccess containerLevelAccess;

	public SmithingHeftMenu(int pId, Inventory pInventory, ContainerLevelAccess pContainerLevelAccess, Block pBlock) {
		super(pId, pInventory, pContainerLevelAccess);
		this.block = pBlock;
		this.containerLevelAccess = pContainerLevelAccess;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return AbstractContainerMenu.stillValid(this.containerLevelAccess, pPlayer, this.block);
	}
}
