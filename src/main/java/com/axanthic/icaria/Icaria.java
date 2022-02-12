package com.axanthic.icaria;

import com.axanthic.icaria.client.ClientProxy;
import com.axanthic.icaria.common.CommonProxy;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.datagen.IcariaBlockStates;
import com.axanthic.icaria.datagen.IcariaBlockTags;
import com.axanthic.icaria.datagen.IcariaFluidTags;
import com.axanthic.icaria.datagen.IcariaItemModels;
import com.axanthic.icaria.datagen.IcariaItemTags;
import com.axanthic.icaria.datagen.IcariaLang;
import com.axanthic.icaria.datagen.IcariaLootTables;
import com.axanthic.icaria.datagen.IcariaRecipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
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
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);

		IcariaBlocks.BLOCKS.register(bus);
		IcariaItems.ITEMS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onCommonSetupEvent(FMLCommonSetupEvent event) {
		ComposterBlock.COMPOSTABLES.put(IcariaItems.MOSS_0.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.MOSS_1.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.MOSS_2.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.SPELT_BALE_BLOCK.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_REED_BLOCK.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_SPROUT_BLOCK.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.SPELT.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_REED.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_SPROUT.get(), 0.3F);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		proxy.init();
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
