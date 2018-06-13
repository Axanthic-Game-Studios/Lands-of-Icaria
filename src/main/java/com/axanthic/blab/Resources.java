package com.axanthic.blab;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.blab.blocks.*;
import com.axanthic.blab.blocks.BlockStone.StoneTypes;
import com.axanthic.blab.items.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class Resources {

	public static List<Item> items = new ArrayList<Item>();
	public static List<ItemBlock> blocks = new ArrayList<ItemBlock>();
	
	public static Item stickWimba = new ItemBasic("wimba_stick");

	public static ItemMultiTexture stone = new ItemMultiTexture(new BlockStone(), null, StoneTypes.getNames());
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
