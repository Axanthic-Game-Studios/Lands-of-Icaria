package com.axanthic.icaria.common.menu.provider;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderMenuProvider implements MenuProvider {
	public GrinderBlockEntity blockEntity;

	public GrinderMenuProvider(GrinderBlockEntity pBlockEntity) {
		this.blockEntity = pBlockEntity;
	}

	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
		return new GrinderMenu(pContainerId, pInventory, this.blockEntity.getData(), this.blockEntity.fuelHandler, this.blockEntity.gearHandler, this.blockEntity.inputHandler, this.blockEntity.outputHandler, this.blockEntity, pPlayer);
	}

	@Override
	public Component getDisplayName() {
		return Component.translatable("menu" + "." + IcariaIdents.ID + "." + "grinder");
	}
}
