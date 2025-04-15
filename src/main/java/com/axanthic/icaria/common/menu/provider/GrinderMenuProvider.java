package com.axanthic.icaria.common.menu.provider;

import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderMenuProvider implements MenuProvider {
	public BlockPos blockPos;

	public GrinderMenuProvider(BlockPos pBlockPos) {
		this.blockPos = pBlockPos;
	}

	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
		return new GrinderMenu(pContainerId, this.blockPos, pInventory, pPlayer);
	}

	@Override
	public Component getDisplayName() {
		return Component.translatable("menu" + "." + IcariaIdents.ID + "." + "grinder");
	}
}
