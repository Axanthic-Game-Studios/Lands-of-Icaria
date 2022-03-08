package com.axanthic.icaria;

import javax.annotation.Nullable;

import com.axanthic.icaria.client.proxy.ClientProxy;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.registry.IcariaItems.ToolCombination;
import com.axanthic.icaria.datagen.IcariaBlockStates;
import com.axanthic.icaria.datagen.IcariaBlockTags;
import com.axanthic.icaria.datagen.IcariaFluidTags;
import com.axanthic.icaria.datagen.IcariaItemModels;
import com.axanthic.icaria.datagen.IcariaItemTags;
import com.axanthic.icaria.datagen.IcariaLang;
import com.axanthic.icaria.datagen.IcariaLootTables;
import com.axanthic.icaria.datagen.IcariaRecipes;

import com.axanthic.icaria.util.IcariaInfo;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod(IcariaInfo.MODID)
public class Icaria {
	public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public Icaria() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetupEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetupEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);

		IcariaBlocks.BLOCKS.register(bus);
		IcariaItems.ITEMS.register(bus);
		IcariaEntities.ENTITIES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onCommonSetupEvent(FMLCommonSetupEvent event) {
		proxy.setup();
		event.enqueueWork(IcariaCompostables::setup);
		event.enqueueWork(IcariaFlammables::setup);
	}

	public void onClientSetupEvent(FMLClientSetupEvent event) {
		for (ToolCombination tools : IcariaItems.TOOLS) {
			ItemProperties.register(tools.BIDENT.get(), new ResourceLocation(IcariaInfo.MODID, "throwing"), new ClampedItemPropertyFunction() {
				public float unclampedCall(ItemStack stack, @Nullable ClientLevel world, @Nullable LivingEntity entity, int id) {
					return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
				}
			});
		}
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		proxy.loadComplete();
	}

	public void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeClient()) {
			gen.addProvider(new IcariaLang(gen));
			gen.addProvider(new IcariaItemModels(gen, existingFileHelper));
			gen.addProvider(new IcariaBlockStates(gen, existingFileHelper));
		}
		if (event.includeServer()) {
			gen.addProvider(new IcariaLootTables(gen));
			gen.addProvider(new IcariaRecipes(gen));
			BlockTagsProvider blockTags = new IcariaBlockTags(gen, existingFileHelper);
			gen.addProvider(blockTags);
			gen.addProvider(new IcariaItemTags(gen, blockTags, existingFileHelper));
			gen.addProvider(new IcariaFluidTags(gen, existingFileHelper));
		}
	}
}
