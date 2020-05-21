package com.axanthic.loi;

import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.CreativeTab;
import com.axanthic.loi.worldgen.dimension.WorldTypeLOI;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod.EventBusSubscriber
@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND)
public class LandsOfIcaria {

	@SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
	public static CommonProxy proxy;
	public static Logger logger;

	public static CreativeTab modTabBlocks = new CreativeTab(ModInformation.ID + ".blocks.creativeTab");
	public static CreativeTab modTabFlora = new CreativeTab(ModInformation.ID + ".flora.creativeTab");
	public static CreativeTab modTabItems = new CreativeTab(ModInformation.ID + ".items.creativeTab");

	// Dimension stuff
	public static int dimensionId;
	public static DimensionType dimensionTypeLoi;
	public static final WorldType LOI_WORLD_TYPE = new WorldTypeLOI(); // although instance isn't used, must create the instance to register the WorldType

	@Mod.Instance
	public static LandsOfIcaria instance;

	public static SimpleNetworkWrapper network;

	public static final IAttribute ATTACK_RANGE = new RangedAttribute((IAttribute)null, "generic.attackRange", 5.0D, 0.0D, 2048.0D);
	public static final UUID ATTACK_RANGE_MODIFIER = UUID.fromString("971104f5-17b7-48d9-b16c-1109f0536884");

	static { //static calls
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		LandsOfIcaria.proxy.preInit(event);
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		LandsOfIcaria.proxy.init(event);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		LandsOfIcaria.proxy.postInit(event);
	}

	@SubscribeEvent
	public void onConfigChangedEvent(OnConfigChangedEvent event) {
		LandsOfIcaria.proxy.ConfigChanged(event);
	}

	@SubscribeEvent
	public void blockRegistry(final RegistryEvent.Register<Block> event) {
		LandsOfIcaria.proxy.registerBlocks(event);
	}

	@SubscribeEvent
	public void itemRegistry(final RegistryEvent.Register<Item> event) {
		LandsOfIcaria.proxy.registerItems(event);
	}

	@SubscribeEvent
	public void biomeRegistry(final RegistryEvent.Register<Biome> event) {
		LandsOfIcaria.proxy.registerBiomes(event);
	}

	@SubscribeEvent
	public void modelRegistry(ModelRegistryEvent event) {
		LandsOfIcaria.proxy.registerModels(event);
	}

	@SubscribeEvent
	public void modelBake(ModelBakeEvent event) {
		LandsOfIcaria.proxy.onModelBake(event);
	}

	@SubscribeEvent
	public void blockColorRegistry(final ColorHandlerEvent.Block event) {
		LandsOfIcaria.proxy.registerBlockColors(event);
	}

	@SubscribeEvent
	public void ItemColorRegistry(final ColorHandlerEvent.Item event) {
		LandsOfIcaria.proxy.registerItemColors(event);
	}

	@SubscribeEvent
	public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {	
		LandsOfIcaria.proxy.registerSounds(event);
	}

	@SubscribeEvent
	public static void registerRegistry(RegistryEvent.NewRegistry event) {	
		LandsOfIcaria.proxy.registerRegistry(event);
	}

	@SubscribeEvent
	public static void worldLoad(WorldEvent.Load event) {	
		LandsOfIcaria.proxy.onWorldLoad(event);
	}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onMouseEvent(MouseEvent event) {
		LandsOfIcaria.proxy.onMouseEvent(event);
	}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onAttackEntity(AttackEntityEvent event) {
		LandsOfIcaria.proxy.onAttackEntityEvent(event);
	}

	/*private static final ResourceLocation motionblur = new ResourceLocation("shaders/post/phosphor.json");

	@SubscribeEvent
	public void onHUDrender(RenderGameOverlayEvent.Post render) {
		Minecraft.getMinecraft().addScheduledTask(new Runnable() {
			@Override
			public void run() {
				if (Minecraft.getMinecraft().player != null) {
					EntityPlayerSP player = Minecraft.getMinecraft().player;
					if (Minecraft.getMinecraft().entityRenderer.isShaderActive()) {
						if (TempStorage.instance.getMyScreen()) {
							Minecraft.getMinecraft().entityRenderer.stopUseShader();
							TempStorage.instance.setMyScreen(false);
						}
					} else if (TempStorage.instance.getFreezeKeyBoard()) {
						if (TempStorage.instance.getFreezeKeyBoard()) {
							Minecraft.getMinecraft().entityRenderer.loadShader(motionblur);
							TempStorage.instance.setMyScreen(true);
						}
					}
				}
			}
		});

		//Minecraft.getMinecraft().entityRenderer.loadShader(motionblur);
	}*/
}
