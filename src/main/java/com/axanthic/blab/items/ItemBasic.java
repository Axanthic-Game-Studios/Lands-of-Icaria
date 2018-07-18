package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.item.Item;

public class ItemBasic extends Item {

	public ItemBasic(String name) {
		super();
		this.setCreativeTab(Blab.modTabItems);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
	}
}
