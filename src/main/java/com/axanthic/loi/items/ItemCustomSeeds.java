package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemCustomSeeds extends ItemSeeds {
	public ItemCustomSeeds(String name, Block crops) {
		super(crops, Blocks.FARMLAND);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
}
