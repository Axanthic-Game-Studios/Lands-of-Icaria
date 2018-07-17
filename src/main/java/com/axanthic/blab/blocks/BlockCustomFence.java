package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.BlockFence;
import net.minecraft.block.state.IBlockState;

public class BlockCustomFence extends BlockFence implements IBlockMaterial{

	public String name;

	public BlockCustomFence(IBlockState modelState, String name) {
		super(modelState.getBlock().getMaterial(modelState), modelState.getBlock().getMapColor(modelState, null, null));
		this.name = name;
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("fence");
		this.setHardness(modelState.getBlock().getBlockHardness(modelState, null, null));
		this.setResistance(modelState.getBlock().getExplosionResistance(null));
		this.setSoundType(modelState.getBlock().getSoundType());
		if (name.contains(".")) {
			this.setRegistryName(ModInformation.ID, "fence_" + name.substring(name.lastIndexOf(".") + 1));
		} else {
			this.setRegistryName(ModInformation.ID, "fence_" + name);
		}
	}

	@Override
	public String getName() {
		return name;
	}
}
