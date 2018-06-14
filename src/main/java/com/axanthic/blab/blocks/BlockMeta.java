package com.axanthic.blab.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMeta extends Block {

	public BlockMeta(Material material) {
		super(material);
	}
	
	public String getNameForMeta(int meta) {
		return "";
	}
	
	public String[] getNames() {
		return new String[1];
	}
}
