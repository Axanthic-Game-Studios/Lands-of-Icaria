package com.axanthic.blab.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockMeta extends Block {

	public BlockMeta(Material material) {
		super(material);
	}
	
	public abstract String getNameForMeta(int meta);
	
	public abstract String[] getNames();
}
