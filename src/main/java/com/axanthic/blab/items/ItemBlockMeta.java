package com.axanthic.blab.items;

import com.axanthic.blab.blocks.BlockMeta;

import net.minecraft.item.ItemMultiTexture;

public class ItemBlockMeta extends ItemMultiTexture {

	public ItemBlockMeta(BlockMeta block) {
		super(block, null, block.getNames());
	}
}
