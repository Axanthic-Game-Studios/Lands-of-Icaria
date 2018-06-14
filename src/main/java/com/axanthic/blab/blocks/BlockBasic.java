package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block {

	public BlockBasic(Material material, float hardness, String name) {
		super(material);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setRegistryName("blab", name);
	}
}
