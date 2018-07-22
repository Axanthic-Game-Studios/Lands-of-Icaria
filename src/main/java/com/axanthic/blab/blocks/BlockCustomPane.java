package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCustomPane extends BlockPane {

	public BlockCustomPane(Material material, float hardness, String name, boolean drops) {
		super(material, drops);
		this.setCreativeTab(Blab.modTabBlocks);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
	}

	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}
}
