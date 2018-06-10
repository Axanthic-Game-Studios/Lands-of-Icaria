package com.axanthic.blab.proxy;

import com.axanthic.blab.blocks.BlockPillar;
import com.axanthic.blab.blocks.BlockPillarHead;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		super.registerBlocks(event);
	}
}
