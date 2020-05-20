package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemCustomSeeds extends ItemSeeds {
	public ItemCustomSeeds(String name, Block crops) {
		super(crops, Blocks.FARMLAND);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setRegistryName(ModInformation.ID, name);
		this.setUnlocalizedName(name);
	}
}
