package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockPillarHead extends BlockSixDirectional {

	public BlockPillarHead() {
		super(Material.ROCK, MapColor.WOOD);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		this.setUnlocalizedName("pillar_head_relicstone");
		this.setRegistryName(ModInformation.ID, "pillar_head_relicstone");
		this.setSoundType(SoundType.STONE);
	}
}
