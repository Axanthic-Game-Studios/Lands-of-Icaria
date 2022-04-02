package com.axanthic.icaria;

import com.axanthic.icaria.client.proxy.ClientProxy;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.data.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

@Mod(IcariaInfo.MODID)
public class Icaria {
	public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public Icaria() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetupEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetupEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onLoadComplete);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);

		IcariaConfig.register();

		IcariaBlocks.BLOCKS.register(bus);
		IcariaFluids.FLUIDS.register(bus);
		IcariaItems.ITEMS.register(bus);
		IcariaEntities.ENTITIES.register(bus);
		IcariaEntities.BLOCK_ENTITIES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onClientSetupEvent(FMLClientSetupEvent event) {
		proxy.setup();
		event.enqueueWork(() -> {
			Sheets.addWoodType(IcariaWoodTypes.CYPRESS);
			Sheets.addWoodType(IcariaWoodTypes.DROUGHTROOT);
			Sheets.addWoodType(IcariaWoodTypes.FIR);
			Sheets.addWoodType(IcariaWoodTypes.LAUREL);
			Sheets.addWoodType(IcariaWoodTypes.OLIVE);
			Sheets.addWoodType(IcariaWoodTypes.PLANE);
			Sheets.addWoodType(IcariaWoodTypes.POPULUS);
		});
	}

	public void onCommonSetupEvent(FMLCommonSetupEvent event) {
		proxy.setup();
		event.enqueueWork(IcariaCompostables::setup);
		event.enqueueWork(IcariaFlammables::setup);
		event.enqueueWork(IcariaPottables::setup);
		event.enqueueWork(IcariaStrippables::setup);
		event.enqueueWork(IcariaTillables::setup);
		event.enqueueWork(IcariaWoodTypes::setup);
	}

	public void onLoadComplete(FMLLoadCompleteEvent event) {
		proxy.loadComplete();
	}

	public void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		if (event.includeClient()) {
			generator.addProvider(new IcariaLang(generator));
			generator.addProvider(new IcariaItemModels(generator, helper));
			generator.addProvider(new IcariaBlockStates(generator, helper));
		}
		if (event.includeServer()) {
			generator.addProvider(new IcariaLootTables(generator));
			generator.addProvider(new IcariaRecipes(generator));
			BlockTagsProvider tags = new IcariaBlockTags(generator, helper);
			generator.addProvider(tags);
			generator.addProvider(new IcariaItemTags(generator, tags, helper));
			generator.addProvider(new IcariaFluidTags(generator, helper));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		Player player = event.player;
		if (player.level.dimension() == Level.NETHER) { // TODO replace with Icaria dimension
			for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
				ItemStack stack = player.getInventory().getItem(slot);
				if (stack.getItem().equals(Items.TORCH)) {
					int size = stack.getCount();
					player.getInventory().removeItem(stack);
					player.getInventory().add(slot, new ItemStack(IcariaItems.DIM_TORCH.get(), size));
				}
			}
		} else {
			for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
				ItemStack stack = player.getInventory().getItem(slot);
				if (stack.getItem().equals(IcariaItems.DIM_TORCH.get())) {
					int size = stack.getCount();
					player.getInventory().removeItem(stack);
					player.getInventory().add(slot, new ItemStack(Items.TORCH, size));
				}
			}
		}
	}
}
