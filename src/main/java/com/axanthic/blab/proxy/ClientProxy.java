package com.axanthic.blab.proxy;

import javax.annotation.Nonnull;

import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockMeta.StoneTypes;
import com.axanthic.blab.blocks.BlockPillar;
import com.axanthic.blab.blocks.BlockPillarHead;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
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

	public void registerItems(RegistryEvent.Register<Item> event) {
		super.registerItems(event);
		
		for (ItemBlock block : Resources.blocks) {
			if (block instanceof ItemMultiTexture) {
				ModelLoader.setCustomMeshDefinition(block, new ItemMeshDefinition() {
					@Override
					public ModelResourceLocation getModelLocation(ItemStack stack) {
						//block.getBlock().getStateFromMeta(stack.getMetadata());
						return new ModelResourceLocation(block.getRegistryName(), "type=" + StoneTypes.byMetadata(stack.getMetadata()).getName());
					}});
			} else
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
		for (Item item : Resources.items)
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
