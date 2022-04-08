package com.axanthic.icaria.common.blocks;

import com.axanthic.icaria.common.menu.IcariaCraftingMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaCraftingTableBlock extends CraftingTableBlock {
	public IcariaCraftingTableBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
		return new SimpleMenuProvider((id, inventory, player) -> new IcariaCraftingMenu(id, inventory, ContainerLevelAccess.create(pLevel, pPos), this), new TranslatableComponent("container.crafting"));
	}
}