package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.item.Item;

public class ItemBasic extends Item {

	public ItemBasic(String name) {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
	}
}
