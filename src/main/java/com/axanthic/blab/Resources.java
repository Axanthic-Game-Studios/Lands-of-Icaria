package com.axanthic.blab;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.blab.blocks.*;
import com.axanthic.blab.items.*;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Resources {

    public static final SoundType SILENCE = new SoundType(-10.0F, 1.0F, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL);

	public static List<Item> items = new ArrayList<Item>();
	public static List<ItemBlock> blocks = new ArrayList<ItemBlock>();

	public static Item stickWimba = new ItemBasic("wimba_stick");
	public static ItemMeta ingot = new ItemMeta("ingot", new String[]{"cooper", "tan", "vanadium", "slither", "molybdenum", "green_gold"});

	public static ItemBlockMeta rock = new ItemBlockMeta(new BlockRock());
	public static ItemBlock pillar = new ItemBlock(new BlockPillar());
	public static ItemBlock pillarHead = new ItemBlock(new BlockPillarHead());
	public static ItemBlock black = new ItemBlock(new BlockBasic(Material.ROCK, 10, "black", MapColor.BLACK).setSoundType(SILENCE));
	
	public static void registerItems() {
		items.add(stickWimba);
		items.add(ingot);
	}
	
	public static void registerBlocks() {
		registerBlock(rock);
		registerBlock(pillar);
		registerBlock(pillarHead);
		registerBlock(black);
	}

	public static void registerBlock(ItemBlock block) {
		blocks.add((ItemBlock) block.setRegistryName(block.getBlock().getRegistryName()));
	}
}
