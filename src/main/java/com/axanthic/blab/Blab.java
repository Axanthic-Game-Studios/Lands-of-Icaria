package com.axanthic.blab;

import com.axanthic.blab.proxy.CommonProxy;
import com.axanthic.blab.utils.CreativeTab;
import com.axanthic.loi.worldgen.dimension.WorldTypeLOI;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ColorHandlerEvent;
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

	public static CreativeTab modTabBlocks = new CreativeTab(ModInformation.ID + ".blocks.creativeTab");
	public static CreativeTab modTabFlora = new CreativeTab(ModInformation.ID + ".flora.creativeTab");
	public static CreativeTab modTabItems = new CreativeTab(ModInformation.ID + ".items.creativeTab");

	// Dimension stuff
	public static int dimensionId;
	public static DimensionType dimensionTypeLoi;
	public static final WorldType LOI_WORLD_TYPE = new WorldTypeLOI(); // although instance isn't used, must create the instance to register the WorldType

	@Mod.Instance
	public static Blab instance;

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
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

	@SubscribeEvent
	public void blockColorRegistry(final ColorHandlerEvent.Block event) {
		Blab.proxy.registerBlockColors(event);
	}

	@SubscribeEvent
	public void ItemColorRegistry(final ColorHandlerEvent.Item event) {
		Blab.proxy.registerItemColors(event);
	}
}
