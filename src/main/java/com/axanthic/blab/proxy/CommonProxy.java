package com.axanthic.blab.proxy;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Recipes;
import com.axanthic.blab.Resources;
import com.axanthic.blab.entity.EntityAeternae;
import com.axanthic.blab.entity.EntityArachne;
import com.axanthic.blab.entity.EntityArachneDrone;
import com.axanthic.blab.entity.EntityArganHound;
import com.axanthic.blab.entity.EntityBident;
import com.axanthic.blab.entity.EntityCatoblepas;
import com.axanthic.blab.entity.EntityCerver;
import com.axanthic.blab.entity.EntityFallingVase;
import com.axanthic.blab.entity.EntityForestHag;
import com.axanthic.blab.entity.EntityJellyfish;
import com.axanthic.blab.entity.EntityMyrmeke;
import com.axanthic.blab.entity.EntityRevenant;
import com.axanthic.blab.entity.EntitySnull;
import com.axanthic.blab.entity.EntitySow;
import com.axanthic.blab.gui.GuiHandlerBlab;
import com.axanthic.blab.gui.GuiHandlerRegistry;
import com.axanthic.blab.items.IItemCustomReach;
import com.axanthic.blab.utils.MessageCustomReachAttack;
import com.axanthic.blab.utils.TileEntityForge;
import com.axanthic.blab.utils.TileEntityForgeRedirector;
import com.axanthic.blab.utils.TileEntityGrinder;
import com.axanthic.blab.utils.TileEntityKiln;
import com.axanthic.blab.utils.TileEntityMobHead;
import com.axanthic.blab.utils.TileEntityVase;
import com.axanthic.loi.worldgen.biome.LOIBiomes;
import com.axanthic.loi.worldgen.dimension.WorldProviderLOI;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(Blab.instance);
		Resources.registerBlocks();
		Resources.registerItems();
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "bident"), EntityBident.class, "bident", 0, ModInformation.ID, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "fallingVase"), EntityFallingVase.class, "fallingVase", 1, ModInformation.ID, 160, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "aeternae"), EntityAeternae.class, "aeternae", 30, ModInformation.ID, 80, 3, true, 0xE27E1E, 0xF9BC0B);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "catoblepas"), EntityCatoblepas.class, "catoblepas", 31, ModInformation.ID, 80, 3, true, 0x615238, 0xDACCB7);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "snull"), EntitySnull.class, "snull", 32, ModInformation.ID, 80, 3, true, 0x654E3F, 0x747673);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "sow"), EntitySow.class, "sow", 33, ModInformation.ID, 80, 3, true, 0x625242, 0x27201A);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "jellyfish"), EntityJellyfish.class, "jellyfish", 34, ModInformation.ID, 64, 3, true, 0x750800, 0xB6897D);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forestHag"), EntityForestHag.class, "forestHag", 60, ModInformation.ID, 80, 3, true, 0x554937, 0x4D7F2F);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant"), EntityRevenant.class, "revenant", 61, ModInformation.ID, 80, 3, true, 0x292929, 0xA3A3A3);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "arachne_drone"), EntityArachneDrone.class, "arachne_drone", 62, ModInformation.ID, 80, 3, true, 0x56422A, 0x80AFBF);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "arachne"), EntityArachne.class, "arachne", 63, ModInformation.ID, 80, 3, true, 0x7B6147, 0x80AFBF);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "myrmeke"), EntityMyrmeke.class, "myrmeke", 64, ModInformation.ID, 80, 3, true, 0x472317, 0x26120C);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "cerver"), EntityCerver.class, "cerver", 65, ModInformation.ID, 80, 3, true, 0x362923, 0x211916);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "argan_hound"), EntityArganHound.class, "argan_hound", 66, ModInformation.ID, 80, 3, true, 0x4A3721, 0x211406);

		//EntityRegistry.addSpawn(EntityAeternae.class, 6, 1, 5, EnumCreatureType.CREATURE, Biomes.PLAINS);
		//EntityRegistry.addSpawn(EntityRevenant.class, 6, 1, 5, EnumCreatureType.MONSTER, Biomes.PLAINS);

		GameRegistry.registerTileEntity(TileEntityVase.class, new ResourceLocation(ModInformation.ID, "storage_vase"));
		GameRegistry.registerTileEntity(TileEntityKiln.class, new ResourceLocation(ModInformation.ID, "crafting_kiln"));
		GameRegistry.registerTileEntity(TileEntityGrinder.class, new ResourceLocation(ModInformation.ID, "crafting_grinder"));
		GameRegistry.registerTileEntity(TileEntityForge.class, new ResourceLocation(ModInformation.ID, "crafting_forge"));
		GameRegistry.registerTileEntity(TileEntityForgeRedirector.class, new ResourceLocation(ModInformation.ID, "crafting_forge_redirector"));
		GameRegistry.registerTileEntity(TileEntityMobHead.class, new ResourceLocation(ModInformation.ID, "mob_head"));

		NetworkRegistry.INSTANCE.registerGuiHandler(Blab.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerBlab(), GuiHandlerBlab.getGuiID());
	}

	public void init(FMLInitializationEvent event) {
		/******** Dimension initialisation ********/
		LOIBiomes.init();
		Recipes.registerLateRecipes();
		Blab.dimensionId = DimensionManager.getNextFreeDimId();
		Blab.dimensionTypeLoi = DimensionType.register("loi", "_loi", Blab.dimensionId, WorldProviderLOI.class, false);
		//GameRegistry.registerWorldGenerator(new OreGeneratorLOI(), 0);
		DimensionManager.registerDimension(Blab.dimensionId, Blab.dimensionTypeLoi);
		/******************************************/
		Blab.modTabBlocks.setTabIconItem(new ItemStack(Resources.grass));
		Blab.modTabFlora.setTabIconItem(new ItemStack(Resources.tallGrass, 1, 2));
		Blab.modTabItems.setTabIconItem(new ItemStack(Resources.orichalcum.pickaxe));

		Blab.network = NetworkRegistry.INSTANCE.newSimpleChannel(ModInformation.NETWORK_CHANNEL_NAME);
		int packetId = 0;
		Blab.network.registerMessage(MessageCustomReachAttack.Handler.class, MessageCustomReachAttack.class, packetId++, Side.SERVER);
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

	public void registerBiomes(RegistryEvent.Register<Biome> event) {
		LOIBiomes.registerBiomes(event);
	}

	public void registerModels(ModelRegistryEvent event) {
		
	}

	public void registerBlockColors(ColorHandlerEvent.Block event) {
		
	}

	public void registerItemColors(ColorHandlerEvent.Item event) {
		
	}

	public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		
	}

	public void onMouseEvent(MouseEvent event) {
		
	}

	public void onAttackEntityEvent(AttackEntityEvent event) {
		Entity attacker = event.getEntity();
		if (attacker != null && attacker instanceof EntityPlayer) {
			ItemStack weapon = ((EntityPlayer) attacker).getHeldItemMainhand();
			if (weapon != null && weapon.getItem() instanceof IItemCustomReach) {
				if (attacker.getDistance(event.getTarget()) > ((IItemCustomReach) weapon.getItem()).getReach()) {
					event.setResult(Result.DENY);
					event.setCanceled(true);
				}
			}
		}
	}
}
