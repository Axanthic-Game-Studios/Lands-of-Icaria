package com.axanthic.blab.proxy;

import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockLeaf;
import com.axanthic.blab.blocks.BlockLog;
import com.axanthic.blab.blocks.BlockSapling;
import com.axanthic.blab.blocks.IBlockMeta;
import com.axanthic.blab.entity.EntityBident;
import com.axanthic.blab.entity.RenderBident;
import com.axanthic.blab.items.ItemBlockMeta;
import com.axanthic.blab.items.ItemMeta;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityBident.class, RenderBident::new);
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
			if (block instanceof ItemBlockMeta) {
				ModelLoader.setCustomMeshDefinition(block, new ItemMeshDefinition() {
					@Override
					public ModelResourceLocation getModelLocation(ItemStack stack) {
						return new ModelResourceLocation(block.getRegistryName(), "type=" + ((IBlockMeta) block.getBlock()).getNameForMeta(stack.getMetadata()));
					}});
			} else if (block.getBlock() instanceof BlockSapling || block.getBlock() instanceof BlockLeaf) {
				String[] path = block.getRegistryName().getResourcePath().split("_");
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), path[0]));
				ModelLoader.setCustomStateMapper(block.getBlock(), new StateMapperBase() {
					@Override
					public ModelResourceLocation getModelResourceLocation(IBlockState state) {
						return new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]), path[0]);
					}});
			} else if (block.getBlock() instanceof BlockLog) {
				String[] path = block.getRegistryName().getResourcePath().split("_");
				ResourceLocation loc = new ResourceLocation(block.getRegistryName().getResourceDomain(), "wood_" + path[1]);
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(loc, path[0] + "_y"));
				ModelLoader.setCustomStateMapper(block.getBlock(), new StateMapperBase() {
					@Override
					public ModelResourceLocation getModelResourceLocation(IBlockState state) {
						String axis = "bark";
						int meta = ((BlockLog) block.getBlock()).getMetaFromState(state);
						if (meta == 0) {
							axis = "y";
						} else if (meta == 4) {
							axis = "x";
						} else if (meta == 8) {
							axis = "z";
						}
						return new ModelResourceLocation(loc, path[0] + "_" + axis);
					}});
			} else
				ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}

		for (Item item : Resources.items) {
			if (item instanceof ItemMeta) {
				for (int i = 0; i < ((ItemMeta) item).names.length; i++) {
					ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), "type=" + ((ItemMeta) item).names[i]));
				}
			} else if (item instanceof ItemTool || item instanceof ItemSword) {
				String[] path = item.getRegistryName().getResourcePath().split("_");
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "tool_" + path[1]), path[0]));
			} else
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
}
