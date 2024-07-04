package com.axanthic.icaria.common.menu.provider;

import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.registry.IcariaIdents;

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

public class GrinderMenuProvider implements MenuProvider {
    public BlockPos pos;

    public GrinderMenuProvider(BlockPos pPos) {
        this.pos = pPos;
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new GrinderMenu(pContainerId, this.pos, pInventory, pPlayer);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menu" + "." + IcariaIdents.ID + "." + "grinder");
    }
}
