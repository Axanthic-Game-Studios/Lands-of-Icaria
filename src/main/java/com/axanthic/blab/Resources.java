package com.axanthic.blab;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.blab.blocks.*;
import com.axanthic.blab.items.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class Resources {

	public static List<Item> items = new ArrayList<Item>();
	public static List<Block> blocks = new ArrayList<Block>();

	public static BlockPillar pillar = new BlockPillar();
	public static BlockPillarHead pillarHead = new BlockPillarHead();
	
	public static void registerItems() {
		
	}
	
	public static void registerBlocks() {
		blocks.add(pillar);
		blocks.add(pillarHead);
	}
}
