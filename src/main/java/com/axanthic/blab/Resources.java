package com.axanthic.blab;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.blab.blocks.*;
import com.axanthic.blab.items.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Resources {

	public static List<Item> items = new ArrayList<Item>();
	public static List<ItemBlock> blocks = new ArrayList<ItemBlock>();
	
	public static Item stickWimba = new ItemBasic("wimba_stick");

	public static ItemBlockMeta stone = new ItemBlockMeta(new BlockStone());
	public static ItemBlock pillar = new ItemBlock(new BlockPillar());
	public static ItemBlock pillarHead = new ItemBlock(new BlockPillarHead());
	
	public static void registerItems() {
		items.add(stickWimba);
	}
	
	public static void registerBlocks() {
		registerBlock(stone);
		registerBlock(pillar);
		registerBlock(pillarHead);
	}

	public static void registerBlock(ItemBlock block) {
		blocks.add((ItemBlock) block.setRegistryName(block.getBlock().getRegistryName()));
	}
}
