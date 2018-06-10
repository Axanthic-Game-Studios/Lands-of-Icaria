package com.axanthic.blab.proxy;

import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockPillar;
import com.axanthic.blab.blocks.BlockPillarHead;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}

	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(Resources.pillar);
		event.getRegistry().register(Resources.pillarHead);
	}

	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemBlock(Resources.pillar));
		event.getRegistry().register(new ItemBlock(Resources.pillarHead));
	}
}
