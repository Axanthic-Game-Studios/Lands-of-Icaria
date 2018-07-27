package com.axanthic.blab.items;

import com.axanthic.blab.blocks.IBlockMaterial;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemBlockMaterial extends ItemBlock {

	public ItemBlockMaterial(IBlockMaterial block) {
		super((Block) block);
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
}
