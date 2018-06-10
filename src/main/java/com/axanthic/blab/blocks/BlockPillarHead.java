package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;

import net.minecraft.block.material.Material;

public class BlockPillarHead extends BlockSixDirectional {

	public BlockPillarHead(){
		super(Material.ROCK);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		this.setUnlocalizedName("pillar_head");
		this.setRegistryName("pillar_head");
	}
}
