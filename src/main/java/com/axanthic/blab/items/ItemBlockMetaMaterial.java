package com.axanthic.blab.items;

import com.axanthic.blab.blocks.BlockMeta;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemBlockMetaMaterial extends ItemBlockMeta {

	public ItemBlockMetaMaterial(BlockMeta block) {
		super(block);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + ((BlockMeta) this.block).getNames()[stack.getItemDamage()] + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}
}
