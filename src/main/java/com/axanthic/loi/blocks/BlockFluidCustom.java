package com.axanthic.loi.blocks;

import com.axanthic.loi.ModInformation;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidCustom extends BlockFluidClassic {

	public BlockFluidCustom(Fluid fluid, Material material) {
		super(fluid, material);
		//this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setUnlocalizedName(fluid.getName());
		this.setRegistryName(ModInformation.ID, fluid.getName());
	}

	public BlockFluidCustom(Fluid fluid, Material material, MapColor mapColor) {
		super(fluid, material, mapColor);
		//this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setUnlocalizedName(fluid.getName());
		this.setRegistryName(ModInformation.ID, fluid.getName());
	}

	public BlockFluidCustom canCreateSources(boolean canIt) {
		canCreateSources = canIt;
		return this;
	}
}
