package com.axanthic.icaria.common.menu.provider;

import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseMenuProvider implements MenuProvider {
    public BlockPos pos;

    public StorageVaseMenuProvider(BlockPos pPos) {
        this.pos = pPos;
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new StorageVaseMenu(pContainerId, this.pos, pPlayerInventory, pPlayer);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menu" + "." + IcariaInfo.ID + "." + "storage_vase");
    }
}
