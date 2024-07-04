package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.menu.IcariaCraftingMenu;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaCraftingTableBlock extends CraftingTableBlock {
	public IcariaCraftingTableBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
		return new SimpleMenuProvider((pId, pInventory, pPlayer) -> new IcariaCraftingMenu(pId, pInventory, ContainerLevelAccess.create(pLevel, pPos), this), Component.translatable("container.crafting"));
	}
}
