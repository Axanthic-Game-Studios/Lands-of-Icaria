package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block {

	public BlockBasic(Material material, float hardness, String name, MapColor color) {
		super(material, color);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
	}

	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}
}
