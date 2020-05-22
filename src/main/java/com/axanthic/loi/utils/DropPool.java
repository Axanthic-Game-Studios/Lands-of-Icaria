package com.axanthic.loi.utils;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class DropPool {
	private final Random rand;
	private final int numRolls;
	private final int fortune;
	private final PriorityQueue<DropEntry> entries;
	private int weightTotal;
	
	public DropPool(Random rand, int maxStacks, int fortune) {
		this.rand = rand;
		this.numRolls = maxStacks;
		this.fortune = fortune;
		this.entries = new PriorityQueue<DropEntry>();
		this.weightTotal = 0;
	}
	
	public static int getNumDrops(Random rand, int min, int max, int fortune) {
		return min + rand.nextInt(max - min + 1) + rand.nextInt(fortune + 1);
	}
	
	public void addEntry(int weight, Item item, int meta, int min, int max) {
		this.entries.add(
				new DropEntry(
						new ItemStack(item, DropPool.getNumDrops(this.rand, min, max, this.fortune), meta),
						weight
				)
		);
		this.weightTotal += weight;
	}
	
	public void getDrops(NonNullList<ItemStack> drops) {
		for (int i = 0; i < this.numRolls; i++) {
			double roll = this.rand.nextDouble() * (double)this.weightTotal;
			Iterator<DropEntry> it = this.entries.iterator();
			double runningSum = 0;
			
			while (it.hasNext()) {
				DropEntry entry = it.next();
				runningSum += (double)entry.weight;
				if (roll < runningSum) {
					if (!drops.contains(entry.stack)) {
						drops.add(entry.stack);
					}
					break;
				}
			}
		}
	}
	
	private class DropEntry implements Comparable<DropEntry> {
		private final ItemStack stack;
		private final int weight;
		
		DropEntry(ItemStack stack, int weight) {
			this.stack = stack;
			this.weight = weight;
		}
		
		public int compareTo(DropEntry other) {
			return ((Integer)other.weight).compareTo((Integer)this.weight);
		}
	}
}
