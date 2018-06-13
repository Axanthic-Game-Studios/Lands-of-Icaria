package com.axanthic.blab.proxy;

import com.axanthic.blab.Blab;
import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockPillar;
import com.axanthic.blab.blocks.BlockPillarHead;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(Blab.instance);
		Resources.registerBlocks();
		Resources.registerItems();
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}

	public void registerBlocks(RegistryEvent.Register<Block> event) {
		for (ItemBlock block : Resources.blocks)
			event.getRegistry().register(block.getBlock());
	}

	public void registerItems(RegistryEvent.Register<Item> event) {
		for (ItemBlock block : Resources.blocks)
			event.getRegistry().register(block);
		for (Item item : Resources.items)
			event.getRegistry().register(item);
	}
}
