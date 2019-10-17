package com.axanthic.loi.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class GrinderFuel extends IForgeRegistryEntry.Impl<GrinderFuel> {

	public static Map<ItemStack, Integer> burnTimeList = new HashMap<ItemStack, Integer>();

	public ItemStack fuelItem;
	public int burnTime;

	public GrinderFuel(ResourceLocation name, ItemStack fuel, int time) {
		this.setRegistryName(name);
		this.fuelItem = fuel;
		this.burnTime = time;
		burnTimeList.put(fuel, time);
	}

	public GrinderFuel(String name, ItemStack fuel, int time) {
		this.setRegistryName(name);
		this.fuelItem = fuel;
		this.burnTime = time;
		burnTimeList.put(fuel, time);
	}

	public ItemStack getFuel() {
		return this.fuelItem;
	}

	public int getBurnTime(ItemStack ingredient) {
		return this.burnTime;
	}

	public static int getItemBurnTime(ItemStack stack) {
		for (Entry<ItemStack, Integer> entry : burnTimeList.entrySet()) {
			if (ItemStack.areItemsEqual(stack, entry.getKey())) {
				return entry.getValue().intValue();
			}
		}
		return 0;
	}
}
