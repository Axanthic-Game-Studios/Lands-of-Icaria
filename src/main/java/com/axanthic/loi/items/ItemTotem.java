package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.item.Item;

public class ItemTotem extends Item{
	private int func;
	private String[] TotemFunc = new String[] {"UNDYING", "STUFFING", "UNSINKING", "UNDROWNING", "UNBLINDING", "UNSHATTERING", "PREVENTATION"};
	
	public ItemTotem(String name, int function) {
		this.func = function;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		
	}
	
	public String getTotemFunc() {
		return this.TotemFunc[this.func];
	}
}


/*
if(target instanceof EntityPlayer) {
EntityPlayer player = (EntityPlayer)target;
if(player.getActiveItemStack().getItem() instanceof ItemTotem) {
	if(((ItemTotem)player.getActiveItemStack().getItem()).getTotemFunc().equalsIgnoreCase("UNDYING")) {
		
	}
}
}
*/