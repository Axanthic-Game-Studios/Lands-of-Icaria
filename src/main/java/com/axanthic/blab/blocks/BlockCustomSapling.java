package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockCustomSapling extends BlockSapling {

	BlockPlanks.WoodTypes type;

	public BlockCustomSapling(BlockPlanks.WoodTypes type) {
		super();
		this.setCreativeTab(Blab.modTab);
		this.type = type;
		this.setUnlocalizedName("sapling");
		this.setRegistryName(ModInformation.ID, "sapling_" + type.unlocalizedName);
	}
}
