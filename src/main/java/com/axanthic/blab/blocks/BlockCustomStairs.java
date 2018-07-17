package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockCustomStairs extends BlockStairs implements IBlockMaterial{

	public String name;

	public BlockCustomStairs(IBlockState modelState, String name) {
		super(modelState);
		this.name = name;
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("stairs");
		String[] splitName = name.split(".");
		if (name.contains(".")) {
			this.setRegistryName(ModInformation.ID, "stairs_" + name.substring(name.lastIndexOf(".") + 1));
		} else {
			this.setRegistryName(ModInformation.ID, "stairs_" + name);
		}
	}

	@Override
	public String getName() {
		return name;
	}
}
