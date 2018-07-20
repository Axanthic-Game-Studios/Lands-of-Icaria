package com.axanthic.blab.proxy;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Recipes;
import com.axanthic.blab.Resources;
import com.axanthic.blab.entity.EntityBident;
import com.axanthic.blab.entity.EntityFallingVase;
import com.axanthic.blab.gui.GuiHandlerBlab;
import com.axanthic.blab.gui.GuiHandlerRegistry;
import com.axanthic.blab.utils.TileEntityVase;
import com.axanthic.loi.worldgen.dimension.WorldProviderLOI;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(Blab.instance);
		Resources.registerBlocks();
		Resources.registerItems();
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "bident"), EntityBident.class, "bident", 0, ModInformation.ID, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "fallingVase"), EntityFallingVase.class, "fallingVase", 1, ModInformation.ID, 160, 20, true);

		GameRegistry.registerTileEntity(TileEntityVase.class, new ResourceLocation(ModInformation.ID, "storage_vase"));

		NetworkRegistry.INSTANCE.registerGuiHandler(Blab.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerBlab(), GuiHandlerBlab.getGuiID());
	}

	public void init(FMLInitializationEvent event) {
		/******** Dimension initialisation ********/
		Blab.dimensionId = DimensionManager.getNextFreeDimId();
		Blab.dimensionTypeLoi = DimensionType.register("loi", "_loi", Blab.dimensionId, WorldProviderLOI.class, false);
		DimensionManager.registerDimension(Blab.dimensionId, Blab.dimensionTypeLoi);
		/******************************************/
		Blab.modTabBlocks.setTabIconItem(new ItemStack(Resources.grass));
		Blab.modTabFlora.setTabIconItem(new ItemStack(Resources.tallGrass, 1, 2));
		Blab.modTabItems.setTabIconItem(new ItemStack(Resources.orichalcum.pickaxe));
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

		Recipes.registerOredict();
		Recipes.registerRecipes();
	}

	public void registerBlockColors(ColorHandlerEvent.Block event) {
		
	}

	public void registerItemColors(ColorHandlerEvent.Item event) {
		
	}
}
