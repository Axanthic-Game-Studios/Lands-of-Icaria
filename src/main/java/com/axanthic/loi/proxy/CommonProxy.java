package com.axanthic.loi.proxy;

import java.util.Collection;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.LOIFluids;
import com.axanthic.loi.LOISigns;
import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Recipes;
import com.axanthic.loi.Resources;
import com.axanthic.loi.entity.EntityAeternae;
import com.axanthic.loi.entity.EntityArachne;
import com.axanthic.loi.entity.EntityArachneDrone;
import com.axanthic.loi.entity.EntityArganHound;
import com.axanthic.loi.entity.EntityBident;
import com.axanthic.loi.entity.EntityCatoblepas;
import com.axanthic.loi.entity.EntityCerver;
import com.axanthic.loi.entity.EntityFallingVase;
import com.axanthic.loi.entity.EntityFloatingBlock;
import com.axanthic.loi.entity.EntityForestHagCypress;
import com.axanthic.loi.entity.EntityForestHagDroughtroot;
import com.axanthic.loi.entity.EntityForestHagFir;
import com.axanthic.loi.entity.EntityForestHagLaurel;
import com.axanthic.loi.entity.EntityForestHagOlive;
import com.axanthic.loi.entity.EntityForestHagPlane;
import com.axanthic.loi.entity.EntityForestHagPopulus;
import com.axanthic.loi.entity.EntityGrenade;
import com.axanthic.loi.entity.EntityJellyfish;
import com.axanthic.loi.entity.EntityLight;
import com.axanthic.loi.entity.EntityMyrmeke;
import com.axanthic.loi.entity.EntityRevenantCaptain;
import com.axanthic.loi.entity.EntityRevenantCivilian;
import com.axanthic.loi.entity.EntityRevenantCrawler;
import com.axanthic.loi.entity.EntityRevenantOvergrown;
import com.axanthic.loi.entity.EntityRevenantPyromancer;
import com.axanthic.loi.entity.EntityRevenantPyromancerNether;
import com.axanthic.loi.entity.EntityRevenantSoldier;
import com.axanthic.loi.entity.EntityScorpion;
import com.axanthic.loi.entity.EntitySiren;
import com.axanthic.loi.entity.EntitySnull;
import com.axanthic.loi.entity.EntitySolifugae;
import com.axanthic.loi.entity.EntitySow;
import com.axanthic.loi.entity.EntitySpellBubble;
import com.axanthic.loi.entity.EntitySpellWisp;
import com.axanthic.loi.entity.EntityVinegar;
import com.axanthic.loi.entity.EntityVinegaroon;
import com.axanthic.loi.entity.EntityWhipSpider;
import com.axanthic.loi.gui.GuiHandlerLOI;
import com.axanthic.loi.gui.GuiHandlerRegistry;
import com.axanthic.loi.items.IItemCustomReach;
import com.axanthic.loi.tileentity.TESignCypress;
import com.axanthic.loi.tileentity.TESignDroughtroot;
import com.axanthic.loi.tileentity.TESignFir;
import com.axanthic.loi.tileentity.TESignLaurel;
import com.axanthic.loi.tileentity.TESignOlive;
import com.axanthic.loi.tileentity.TESignPlane;
import com.axanthic.loi.tileentity.TESignPopulus;
import com.axanthic.loi.tileentity.TileEntityColoredLight;
import com.axanthic.loi.tileentity.TileEntityForge;
import com.axanthic.loi.tileentity.TileEntityForgeRedirector;
import com.axanthic.loi.tileentity.TileEntityGrinder;
import com.axanthic.loi.tileentity.TileEntityIcariaChest;
import com.axanthic.loi.tileentity.TileEntityKettle;
import com.axanthic.loi.tileentity.TileEntityKiln;
import com.axanthic.loi.tileentity.TileEntityMobHead;
import com.axanthic.loi.tileentity.TileEntityVase;
import com.axanthic.loi.utils.ForgeRecipe;
import com.axanthic.loi.utils.GrinderFuel;
import com.axanthic.loi.utils.GrinderRecipe;
import com.axanthic.loi.utils.KettleRecipe;
import com.axanthic.loi.utils.MessageCustomReachAttack;
import com.axanthic.loi.utils.VanillaHandler;
import com.axanthic.loi.worldgen.biome.LOIBiomes;
import com.axanthic.loi.worldgen.dimension.OreGeneratorLOI;
import com.axanthic.loi.worldgen.dimension.WorldProviderLOI;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;

import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionAddedEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class CommonProxy {

	public static IForgeRegistry grinderRecipeRegistry;
	public static IForgeRegistry grinderFuelRegistry;
	public static IForgeRegistry forgeRecipeRegistry;
	public static IForgeRegistry kettleRecipeRegistry;

	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(LandsOfIcaria.instance);
		MinecraftForge.EVENT_BUS.register(new VanillaHandler());

		LandsOfIcaria.logger = event.getModLog();

		Resources.registerBlocks();
		Resources.registerItems();
		LOIFluids.registerFluids();
		LOISigns.registerSigns();

		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "bident"), EntityBident.class, "icaria.bident", 0, ModInformation.ID, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "falling_vase"), EntityFallingVase.class, "icaria.falling_vase", 1, ModInformation.ID, 160, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "greek_fire_grenade"), EntityGrenade.class, "icaria.greek_fire_grenade", 2, ModInformation.ID, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "spell_wisp"), EntitySpellWisp.class, "icaria.spell_wisp", 3, ModInformation.ID, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "spell_bubble"), EntitySpellBubble.class, "icaria.spell_bubble", 4, ModInformation.ID, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "floating_block"), EntityFloatingBlock.class, "icaria.floating_block", 5, ModInformation.ID, 160, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "aeternae"), EntityAeternae.class, "icaria.aeternae", 30, ModInformation.ID, 80, 3, true, 0xE27E1E, 0xF9BC0B);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "catoblepas"), EntityCatoblepas.class, "icaria.catoblepas", 31, ModInformation.ID, 80, 3, true, 0x615238, 0xDACCB7);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "snull"), EntitySnull.class, "icaria.snull", 32, ModInformation.ID, 80, 3, true, 0x654E3F, 0x747673);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "sow"), EntitySow.class, "icaria.sow", 33, ModInformation.ID, 80, 3, true, 0x625242, 0x27201A);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "jellyfish"), EntityJellyfish.class, "icaria.jellyfish", 34, ModInformation.ID, 80, 6, true, 0x750800, 0xB6897D);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "light"), EntityLight.class, "icaria.light", 35, ModInformation.ID, 80, 6, true, 0xABFFED, 0xFFABAB);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "arachne_drone"), EntityArachneDrone.class, "icaria.arachne_drone", 62, ModInformation.ID, 80, 3, true, 0x56422A, 0x80AFBF);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "arachne"), EntityArachne.class, "icaria.arachne", 63, ModInformation.ID, 80, 3, true, 0x7B6147, 0x80AFBF);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "myrmeke"), EntityMyrmeke.class, "icaria.myrmeke", 64, ModInformation.ID, 80, 3, true, 0x472317, 0x26120C);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "cerver"), EntityCerver.class, "icaria.cerver", 65, ModInformation.ID, 80, 3, true, 0x362923, 0x211916);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "argan_hound"), EntityArganHound.class, "icaria.argan_hound", 66, ModInformation.ID, 80, 3, true, 0x4A3721, 0x211406);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant_civilian"), EntityRevenantCivilian.class, "icaria.revenant_civilian", 67, ModInformation.ID, 80, 3, true, 0xB6B6B6, 0x868686);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant_soldier"), EntityRevenantSoldier.class, "icaria.revenant_soldier", 68, ModInformation.ID, 80, 3, true, 0x836A6A, 0x868686);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant_captain"), EntityRevenantCaptain.class, "icaria.revenant_captain", 69, ModInformation.ID, 80, 3, true, 0xFFDC39, 0x868686);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant_pyromancer"), EntityRevenantPyromancer.class, "icaria.revenant_pyromancer", 70, ModInformation.ID, 80, 3, true, 0x7DB544, 0x868686);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant_pyromancer_nether"), EntityRevenantPyromancerNether.class, "icaria.revenant_pyromancer_nether", 71, ModInformation.ID, 80, 3, true, 0xB55D44, 0x868686);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant_crawler"), EntityRevenantCrawler.class, "icaria.revenant_crawler", 72, ModInformation.ID, 80, 3, true, 0x2C2E12, 0x868686);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "revenant_overgrown"), EntityRevenantOvergrown.class, "icaria.revenant_overgrown", 73, ModInformation.ID, 80, 3, true, 0x5B6905, 0x868686);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forest_hag_plane"), EntityForestHagPlane.class, "icaria.forest_hag_plane", 75, ModInformation.ID, 80, 3, true, 0x7A7B77, 0x8DC270);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forest_hag_populus"), EntityForestHagPopulus.class, "icaria.forest_hag_populus", 76, ModInformation.ID, 80, 3, true, 0xD9D5D4, 0x7ABC96);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forest_hag_cypress"), EntityForestHagCypress.class, "icaria.forest_hag_cypress", 77, ModInformation.ID, 80, 3, true, 0x7C6F66, 0x667715);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forest_hag_fir"), EntityForestHagFir.class, "icaria.forest_hag_fir", 78, ModInformation.ID, 80, 3, true, 0x887558, 0x40774F);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forest_hag_olive"), EntityForestHagOlive.class, "icaria.forest_hag_olive", 79, ModInformation.ID, 80, 3, true, 0x969E8F, 0xAFA731);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forest_hag_laurel"), EntityForestHagLaurel.class, "icaria.forest_hag_laurel", 80, ModInformation.ID, 80, 3, true, 0x523A2A, 0x55661A);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "forest_hag_droughtroot"), EntityForestHagDroughtroot.class, "icaria.forest_hag_droughtroot", 81, ModInformation.ID, 80, 3, true, 0x524A4B, 0x879117);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "siren"), EntitySiren.class, "icaria.siren", 85, ModInformation.ID, 80, 3, true, 0x5C463B, 0xBB8E85);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "scorpion"), EntityScorpion.class, "icaria.scorpion", 86, ModInformation.ID, 80, 3, true, 0xC18743, 0x7F5E39);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "solifugae"), EntitySolifugae.class, "icaria.solifugae", 87, ModInformation.ID, 80, 3, true, 0xD3C1B1, 0xAF7D4D);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "vinegaroon"), EntityVinegaroon.class, "icaria.vinegaroon", 88, ModInformation.ID, 80, 3, true, 0x4C3722, 0xC99559);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "vinegar"), EntityVinegar.class, "icaria.vinegar", 89, ModInformation.ID, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(ModInformation.ID, "whip_spider"), EntityWhipSpider.class, "icaria.whip_spider", 90, ModInformation.ID, 80, 3, true, 0xC18743, 0x7F5E39);

		EntityRegistry.addSpawn(EntityRevenantPyromancerNether.class, 30, 1, 2, EnumCreatureType.MONSTER, Biomes.HELL);

		GameRegistry.registerTileEntity(TileEntityVase.class, new ResourceLocation(ModInformation.ID, "storage_vase"));
		GameRegistry.registerTileEntity(TileEntityKiln.class, new ResourceLocation(ModInformation.ID, "crafting_kiln"));
		GameRegistry.registerTileEntity(TileEntityGrinder.class, new ResourceLocation(ModInformation.ID, "crafting_grinder"));
		GameRegistry.registerTileEntity(TileEntityForge.class, new ResourceLocation(ModInformation.ID, "crafting_forge"));
		GameRegistry.registerTileEntity(TileEntityForgeRedirector.class, new ResourceLocation(ModInformation.ID, "crafting_forge_redirector"));
		GameRegistry.registerTileEntity(TileEntityKettle.class, new ResourceLocation(ModInformation.ID, "crafting_kettle"));
		GameRegistry.registerTileEntity(TileEntityMobHead.class, new ResourceLocation(ModInformation.ID, "mob_head"));
		//if (LOIConfig.compat.albedo && Loader.isModLoaded("albedo"))
		GameRegistry.registerTileEntity(TileEntityColoredLight.class, new ResourceLocation(ModInformation.ID, "colored_light"));

		//signs
		GameRegistry.registerTileEntity(TESignPlane.class, new ResourceLocation(ModInformation.ID, "sign_plane"));
		GameRegistry.registerTileEntity(TESignPopulus.class, new ResourceLocation(ModInformation.ID, "sign_populus"));
		GameRegistry.registerTileEntity(TESignCypress.class, new ResourceLocation(ModInformation.ID, "sign_cypress"));
		GameRegistry.registerTileEntity(TESignFir.class, new ResourceLocation(ModInformation.ID, "sign_fir"));
		GameRegistry.registerTileEntity(TESignOlive.class, new ResourceLocation(ModInformation.ID, "sign_olive"));
		GameRegistry.registerTileEntity(TESignLaurel.class, new ResourceLocation(ModInformation.ID, "sign_laurel"));
		GameRegistry.registerTileEntity(TESignDroughtroot.class, new ResourceLocation(ModInformation.ID, "sign_droughtroot"));

		//chests
		GameRegistry.registerTileEntity(TileEntityIcariaChest.class, new ResourceLocation(ModInformation.ID, "icaria_chest"));

		NetworkRegistry.INSTANCE.registerGuiHandler(LandsOfIcaria.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerLOI(), GuiHandlerLOI.getGuiID());
	}

	public void init(FMLInitializationEvent event) {
		/******** Dimension initialisation ********/
		LOIBiomes.init();
		Resources.init();
		Recipes.registerLateRecipes();
		LandsOfIcaria.dimensionId = LOIConfig.misc.dimensionID;
		LandsOfIcaria.dimensionTypeLoi = DimensionType.register("loi", "_loi", LandsOfIcaria.dimensionId, WorldProviderLOI.class, false);
		GameRegistry.registerWorldGenerator(new OreGeneratorLOI(), 0);
		DimensionManager.registerDimension(LandsOfIcaria.dimensionId, LandsOfIcaria.dimensionTypeLoi);
		/******************************************/
		LandsOfIcaria.modTabBlocks.setTabIconItem(new ItemStack(Resources.grass));
		LandsOfIcaria.modTabFlora.setTabIconItem(new ItemStack(Resources.tallGrass, 1, 2));
		LandsOfIcaria.modTabItems.setTabIconItem(new ItemStack(Resources.orichalcum.pickaxe));

		LandsOfIcaria.network = NetworkRegistry.INSTANCE.newSimpleChannel(ModInformation.NETWORK_CHANNEL_NAME);
		int packetId = 0;
		LandsOfIcaria.network.registerMessage(MessageCustomReachAttack.Handler.class, MessageCustomReachAttack.class, packetId++, Side.SERVER);
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

	public void ConfigChanged(OnConfigChangedEvent event) {
		if (event.getModID().equals(ModInformation.ID)) {
			ConfigManager.sync(ModInformation.ID, Type.INSTANCE);
		}
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

	public void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(Resources.frozenEffect);
		event.getRegistry().register(Resources.slowFalling);
	}

	public void registerRegistry(RegistryEvent.NewRegistry event) {
		RegistryBuilder grinderRegistryBuilder = new RegistryBuilder();
		grinderRegistryBuilder.setName(new ResourceLocation(ModInformation.ID, "grinder_recipes"));
		grinderRegistryBuilder.setType(GrinderRecipe.class);
		grinderRegistryBuilder.allowModification();
		grinderRegistryBuilder.disableSaving();
		grinderRecipeRegistry = grinderRegistryBuilder.create();

		RegistryBuilder grinderFuelRegistryBuilder = new RegistryBuilder();
		grinderFuelRegistryBuilder.setName(new ResourceLocation(ModInformation.ID, "grinder_fuel"));
		grinderFuelRegistryBuilder.setType(GrinderFuel.class);
		grinderFuelRegistryBuilder.allowModification();
		grinderFuelRegistryBuilder.disableSaving();
		grinderFuelRegistry = grinderFuelRegistryBuilder.create();

		RegistryBuilder forgeRegistryBuilder = new RegistryBuilder();
		forgeRegistryBuilder.setName(new ResourceLocation(ModInformation.ID, "forge_recipes"));
		forgeRegistryBuilder.setType(ForgeRecipe.class);
		forgeRegistryBuilder.allowModification();
		forgeRegistryBuilder.disableSaving();
		forgeRecipeRegistry = forgeRegistryBuilder.create();

		RegistryBuilder kettleRegistryBuilder = new RegistryBuilder();
		kettleRegistryBuilder.setName(new ResourceLocation(ModInformation.ID, "kettle_recipes"));
		kettleRegistryBuilder.setType(KettleRecipe.class);
		kettleRegistryBuilder.allowModification();
		kettleRegistryBuilder.disableSaving();
		kettleRecipeRegistry = kettleRegistryBuilder.create();
	}

	public void onWorldLoad(WorldEvent.Load event) {
		if (!event.getWorld().isRemote && event.getWorld().provider.getDimension() == 0) {
			long seed = event.getWorld().getSeed();
			for (KettleRecipe recipe : (Collection<KettleRecipe>) CommonProxy.kettleRecipeRegistry.getValuesCollection()) {
				recipe.generateOrder(seed);
			}
		}
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

	public void onArmorBreaks(LivingAttackEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			for (int slot = 0; slot < 9; slot++) {
				ItemStack totem = player.inventory.getStackInSlot(slot);

				if (totem.getItem().equals(Resources.totem_unshattering)) {

					for (int armorslot = 36; armorslot < 40; armorslot++) {
						ItemStack tools = player.inventory.getStackInSlot(armorslot);

						if (tools.getItem() instanceof ItemArmor) {

							if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
								tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
								totem.shrink(1);
							}
						}
					}
				}
			}

			ItemStack totem = player.inventory.getStackInSlot(40);

			if (totem.getItem().equals(Resources.totem_unshattering)) {

				for (int armorslot = 36; armorslot < 40; armorslot++) {
					ItemStack tools = player.inventory.getStackInSlot(armorslot);

					if (tools.getItem() instanceof ItemArmor) {

						if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
							tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
							totem.shrink(1);
						}
					}
				}
			}
		}
	}

	public void onWeaponBreaks(LivingAttackEvent event) {
		DamageSource source = event.getSource();

		if (source instanceof EntityDamageSource) {
			EntityDamageSource damageSource = (EntityDamageSource) source;
			Entity entitySource = damageSource.getTrueSource();

			if (entitySource instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entitySource;

				for (int slot = 0; slot < 9; slot++) {
					ItemStack totem = player.inventory.getStackInSlot(slot);

					if (totem.getItem().equals(Resources.totem_unshattering)) {
						ItemStack tools = player.getHeldItemMainhand();

						if (tools.getItem() instanceof ItemTool ||
								tools.getItem() instanceof ItemHoe ||
								tools.getItem() instanceof ItemSword) {

							if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
								tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
								totem.shrink(1);
							}
						}
					}
				}

				ItemStack totem = player.inventory.getStackInSlot(40);

				if (totem.getItem().equals(Resources.totem_unshattering)) {
					ItemStack tools = player.getHeldItemMainhand();

					if (tools.getItem() instanceof ItemTool ||
							tools.getItem() instanceof ItemHoe ||
							tools.getItem() instanceof ItemSword) {

						if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
							tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
							totem.shrink(1);
						}
					}
				}
			}
		}
	}

	public void onToolBreaksMainhand(PlayerInteractEvent event) {
		EntityPlayer player = event.getEntityPlayer();

		for (int slot = 0; slot < 9; slot++) {
			ItemStack totem = player.inventory.getStackInSlot(slot);

			if (totem.getItem().equals(Resources.totem_unshattering)) {
				ItemStack tools = player.getHeldItemMainhand();

				if (tools.getItem() instanceof ItemTool ||
						tools.getItem() instanceof ItemHoe ||
						tools.getItem() instanceof ItemSword ||
						tools.getItem() instanceof ItemBow ||
						tools.getItem() instanceof ItemFishingRod ||
						tools.getItem() instanceof ItemFlintAndSteel ||
						tools.getItem() instanceof ItemShears ||
						tools.getItem() instanceof ItemShield) {

					if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
						tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
						totem.shrink(1);
					}
				}
			}
		}

		ItemStack totem = player.inventory.getStackInSlot(40);

		if (totem.getItem().equals(Resources.totem_unshattering)) {
			ItemStack tools = player.getHeldItemMainhand();

			if (tools.getItem() instanceof ItemTool ||
					tools.getItem() instanceof ItemHoe ||
					tools.getItem() instanceof ItemSword ||
					tools.getItem() instanceof ItemBow ||
					tools.getItem() instanceof ItemFishingRod ||
					tools.getItem() instanceof ItemFlintAndSteel ||
					tools.getItem() instanceof ItemShears ||
					tools.getItem() instanceof ItemShield) {

				if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
					tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
					totem.shrink(1);
				}
			}
		}
	}


	public void onToolBreaksOffhand(PlayerInteractEvent event) {
		EntityPlayer player = event.getEntityPlayer();

		for (int slot = 0; slot < 9; slot++) {
			ItemStack totem = player.inventory.getStackInSlot(slot);

			if (totem.getItem().equals(Resources.totem_unshattering)) {
				ItemStack tools = player.getHeldItemOffhand();

				if (tools.getItem() instanceof ItemTool ||
						tools.getItem() instanceof ItemHoe ||
						tools.getItem() instanceof ItemSword ||
						tools.getItem() instanceof ItemBow ||
						tools.getItem() instanceof ItemFishingRod ||
						tools.getItem() instanceof ItemFlintAndSteel ||
						tools.getItem() instanceof ItemShield) {

					if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
						tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
						totem.shrink(1);
					}
				}
			}
		}
	}

	public void onShearsBreaksOffhand(PlayerInteractEvent.EntityInteract event) {
		EntityPlayer player = event.getEntityPlayer();

		for (int slot = 0; slot < 9; slot++) {
			ItemStack totem = player.inventory.getStackInSlot(slot);

			if (totem.getItem().equals(Resources.totem_unshattering)) {
				ItemStack tools = player.getHeldItemOffhand();

				if (tools.getItem() instanceof ItemShears) {

					if (tools.getItem().getMaxDamage(tools) - tools.getItem().getDamage(tools) < tools.getItem().getMaxDamage(tools) * 0.1) {
						tools.setItemDamage((int) (tools.getItem().getMaxDamage(tools) * 0.1));
						totem.shrink(1);
					}
				}
			}
		}
	}

	public void onPlayerDrowns(LivingAttackEvent event) {
		Entity entity = event.getEntity();
		float damage = event.getAmount();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			for (int slot = 0; slot < 9; slot++) {
				ItemStack totem = player.inventory.getStackInSlot(slot);

				if (totem.getItem().equals(Resources.totem_undrowning)) {

					if (player.getAir() <= 300 / 10) {
						player.setAir(300);
						player.heal(damage);
						player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 800));
						totem.shrink(1);
					}
				}
			}

			ItemStack totem = player.inventory.getStackInSlot(40);

			if (totem.getItem().equals(Resources.totem_undrowning)) {

				if (player.getAir() <= 300 / 10) {
					player.setAir(300);
					player.heal(damage);
					player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 800));
					totem.shrink(1);
				}
			}
		}
	}

	public void onPlayerFalls(LivingAttackEvent event) {
		float damage = event.getAmount();
		Entity entity = event.getEntity();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			for (int slot = 0; slot < 9; slot++) {
				ItemStack totem = player.inventory.getStackInSlot(slot);

				if (totem.getItem().equals(Resources.totem_unsinking)) {

					if (player.posY <= 0) {
						player.setPositionAndUpdate(player.posX, 255, player.posZ);
						player.addPotionEffect(new PotionEffect(Resources.slowFalling, 800));
					}

					if (player.posY >= 255) {
						player.heal(damage);
						totem.shrink(1);
					}
				}
			}

			ItemStack totem = player.inventory.getStackInSlot(40);

			if (totem.getItem().equals(Resources.totem_unsinking)) {

				if (player.posY <= 0) {
					player.setPositionAndUpdate(player.posX, 255, player.posZ);
					player.addPotionEffect(new PotionEffect(Resources.slowFalling, 800));
				}

				if (player.posY >= 255) {
					player.heal(damage);
					totem.shrink(1);
				}
			}
		}
	}

	public void onPlayerStarves(LivingAttackEvent event) {
		float damage = event.getAmount();
		Entity entity = event.getEntity();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			for (int slot = 0; slot < 9; slot++) {
				ItemStack totem = player.inventory.getStackInSlot(slot);

				if (totem.getItem().equals(Resources.totem_stuffing)) {

					if (player.getFoodStats().getFoodLevel() == 0) {
						player.getFoodStats().setFoodLevel(20);
						player.heal(damage);
						player.removePotionEffect(MobEffects.HUNGER);
						player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 100));
						totem.shrink(1);
					}
				}
			}

			ItemStack totem = player.inventory.getStackInSlot(40);

			if (totem.getItem().equals(Resources.totem_stuffing)) {

				if (player.getFoodStats().getFoodLevel() == 0) {
					player.getFoodStats().setFoodLevel(20);
					player.heal(damage);
					player.removePotionEffect(MobEffects.HUNGER);
					player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 100));
					totem.shrink(1);
				}
			}
		}
	}

	public void onPlayerDies(LivingAttackEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			for (int slot = 0; slot < 9; slot++) {
				ItemStack totem = player.inventory.getStackInSlot(slot);

				if (totem.getItem().equals(Resources.totem_undying)) {

					if (event.getAmount() >= player.getHealth()) {
						event.setCanceled(true);
						player.setHealth(1.0F);
						player.clearActivePotions();
						player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 100));
						player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 900));
						totem.shrink(1);
					}
				}
			}

			ItemStack totem = player.inventory.getStackInSlot(40);

			if (totem.getItem().equals(Resources.totem_undying)) {

				if (event.getAmount() >= player.getHealth()) {
					event.setCanceled(true);
					player.setHealth(1.0F);
					player.clearActivePotions();
					player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 100));
					player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 900));
					totem.shrink(1);
				}
			}
		}
	}

	public void onPlayerBlinded(PotionAddedEvent event) {
		Entity entity = event.getEntity();
		PotionEffect effect = event.getPotionEffect();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			for (int slot = 0; slot < 9; slot++) {
				ItemStack totem = player.inventory.getStackInSlot(slot);

				if (totem.getItem().equals(Resources.totem_unblinding)) {

					if (effect.getEffectName().equalsIgnoreCase("effect.blindness")) {
						player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 800));
						player.addPotionEffect(new PotionEffect(Resources.blindnessImmunity, 800));
						totem.shrink(1);
					}
				}
			}

			ItemStack totem = player.inventory.getStackInSlot(40);

			if (totem.getItem().equals(Resources.totem_unblinding)) {

				if (effect.getEffectName().equalsIgnoreCase("effect.blindness")) {
					player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 800));
					player.addPotionEffect(new PotionEffect(Resources.blindnessImmunity, 800));
					totem.shrink(1);
				}
			}
		}
	}
}