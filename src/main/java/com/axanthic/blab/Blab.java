package com.axanthic.blab;

import com.axanthic.blab.proxy.CommonProxy;
import com.axanthic.blab.utils.CreativeTab;
import com.axanthic.loi.worldgen.dimension.WorldProviderLOI;
import com.axanthic.loi.worldgen.dimension.WorldTypeLOI;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND)
public class Blab {

	@SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
	public static CommonProxy proxy;

	public static CreativeTab modTab = new CreativeTab(ModInformation.ID + ".creativeTab", new ItemStack(Items.BUCKET));

	// Dimension stuff
	public static int dimensionId;
	public static DimensionType dimensionTypeLoi;
	public static final WorldType LOI_WORLD_TYPE = new WorldTypeLOI(); // although instance isn't used, must create the instance to register the WorldType

	@Mod.Instance
	public static Blab instance;

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {

		/******** Dimension initialisation ********/
		Blab.dimensionId = DimensionManager.getNextFreeDimId();
		Blab.dimensionTypeLoi = DimensionType.register("Lands of Icar???", "_loi", Blab.dimensionId, WorldProviderLOI.class, false);
		DimensionManager.registerDimension(Blab.dimensionId, Blab.dimensionTypeLoi);
		/******************************************/

		Blab.proxy.preInit(event);
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		Blab.proxy.init(event);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		Blab.proxy.postInit(event);
	}

	@SubscribeEvent
	public void blockRegistry(final RegistryEvent.Register<Block> event) {
		Blab.proxy.registerBlocks(event);
	}

	@SubscribeEvent
	public void itemRegistry(final RegistryEvent.Register<Item> event) {
		Blab.proxy.registerItems(event);
	}
}
