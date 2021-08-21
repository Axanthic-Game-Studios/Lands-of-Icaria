package com.axanthic.loi.items;

import com.axanthic.loi.blocks.IBlockMeta;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemBlockMetaMaterial extends ItemBlockMeta {

	public ItemBlockMetaMaterial(IBlockMeta block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName() {
		return "tile.generic." + block.getUnlocalizedName().substring(5);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (I18n.canTranslate("tile." + this.block.getRegistryName().getResourcePath() + "." + getNameForMeta(stack.getItemDamage()) + ".name"))
			return I18n.translateToLocal("tile." + this.block.getRegistryName().getResourcePath() + "." + getNameForMeta(stack.getItemDamage()) + ".name");
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + getNameForMeta(stack.getItemDamage()) + ".name"));
		} catch (Exception e) {
			return I18n.translateToLocal("tile." + this.block.getRegistryName().getResourcePath() + "." + getNameForMeta(stack.getItemDamage()) + ".name");
		}
	}

	public String getNameForMeta(int meta) {
		return ((IBlockMeta) this.block).getNames()[meta % ((IBlockMeta) this.block).getNames().length];
	}
}
