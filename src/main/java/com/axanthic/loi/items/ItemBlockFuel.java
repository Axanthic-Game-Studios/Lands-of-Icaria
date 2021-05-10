package com.axanthic.loi.items;

import com.axanthic.loi.blocks.IBlockMaterial;
import com.axanthic.loi.items.ItemResources.ResourceType;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemBlockFuel extends ItemBlock{
	
	private int burnTime;
	
	public ItemBlockFuel(Block block, int burnTime) {
		super((Block) block);
		this.burnTime = burnTime;
	}

	@Override
	public String getUnlocalizedName() {
		return "tile.generic." + block.getUnlocalizedName().substring(5);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal(((IBlockMaterial) this.block).getName()));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}
	
	@Override
	public int getItemBurnTime(ItemStack stack) {
		return this.burnTime;
	}
}
