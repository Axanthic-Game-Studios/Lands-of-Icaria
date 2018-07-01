package com.axanthic.blab.items;

import com.axanthic.blab.blocks.IBlockMeta;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockMeta extends ItemMultiTexture {

	public ItemBlockMeta(IBlockMeta block) {
		super((Block) block, null, block.getNames());
	}
}
