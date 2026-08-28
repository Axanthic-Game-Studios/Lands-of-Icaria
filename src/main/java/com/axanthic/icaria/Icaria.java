package com.axanthic.icaria;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.payload.*;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.types.SkullBlockTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@Mod(IcariaIdents.ID)
public class Icaria {
	public Icaria(IEventBus pBus) {
		Icaria.addListeners(pBus);
		Icaria.registerConfigs(pBus);
		Icaria.registerRegistries(pBus);
	}

	public static void addListeners(IEventBus pBus) {
		pBus.addListener(Icaria::onFMLClientSetup);
		pBus.addListener(Icaria::onFMLCommonSetup);
		pBus.addListener(Icaria::onRegisterPayloadHandlers);
	}

	public static void onFMLClientSetup(FMLClientSetupEvent pEvent) {
		Icaria.registerExtensionPoint(pEvent);
		Icaria.registerSkullTypes(pEvent);
		Icaria.registerWoodTypes(pEvent);
	}

	public static void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		Icaria.registerSetups(pEvent);
	}

	public static void onRegisterPayloadHandlers(RegisterPayloadHandlersEvent pEvent) {
		Icaria.registerPayloadHandlers(pEvent);
	}

	public static void registerConfigs(IEventBus pBus) {
		IcariaConfig.registerClientConfig();
		IcariaConfig.registerCommonConfig();
		IcariaConfig.registerServerConfig();
	}

	public static void registerRegistries(IEventBus pBus) {
		IcariaAttachmentTypes.ATTACHMENT_TYPES.register(pBus);
		IcariaBlocks.BLOCKS.register(pBus);
		IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register(pBus);
		IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register(pBus);
		IcariaDataComponents.DATA_COMPONENT_TYPES.register(pBus);
		IcariaEntityDataSerializers.ENTITY_DATA_SERIALIZERS.register(pBus);
		IcariaEntityTypes.ENTITY_TYPES.register(pBus);
		IcariaFeatures.FEATURES.register(pBus);
		IcariaFluids.FLUIDS.register(pBus);
		IcariaFluidTypes.FLUID_TYPES.register(pBus);
		IcariaItems.ITEMS.register(pBus);
		IcariaMenus.MENUS.register(pBus);
		IcariaMobEffects.MOB_EFFECTS.register(pBus);
		IcariaParticleTypes.PARTICLE_TYPES.register(pBus);
		IcariaPoiTypes.POI_TYPES.register(pBus);
		IcariaPotions.POTIONS.register(pBus);
		IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register(pBus);
		IcariaRecipeDisplays.RECIPE_DISPLAYS.register(pBus);
		IcariaRecipeSerializers.RECIPE_SERIALIZERS.register(pBus);
		IcariaRecipeTypes.RECIPE_TYPES.register(pBus);
		IcariaSlotDisplayTypes.SLOT_DISPLAY_TYPES.register(pBus);
		IcariaStructureTypes.STRUCTURE_TYPES.register(pBus);
	}

	public static void registerExtensionPoint(FMLClientSetupEvent pEvent) {
		ModLoadingContext.get().getActiveContainer().registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
	}

	public static void registerSkullTypes(FMLClientSetupEvent pEvent) {
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.AETERNAE, IcariaResourceLocations.AETERNAE));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.ARGAN_HOUND, IcariaResourceLocations.ARGAN_HOUND));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.CAPELLA, IcariaResourceLocations.CAPELLA));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.CATOBLEPAS, IcariaResourceLocations.CATOBLEPAS));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.CERVER, IcariaResourceLocations.CERVER));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.CROCOTTA, IcariaResourceLocations.CROCOTTA));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.CYPRESS_FOREST_HAG, IcariaResourceLocations.CYPRESS_FOREST_HAG));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.DROUGHTROOT_FOREST_HAG, IcariaResourceLocations.DROUGHTROOT_FOREST_HAG));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.FIR_FOREST_HAG, IcariaResourceLocations.FIR_FOREST_HAG));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.LAUREL_FOREST_HAG, IcariaResourceLocations.LAUREL_FOREST_HAG));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.OLIVE_FOREST_HAG, IcariaResourceLocations.OLIVE_FOREST_HAG));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.PLANE_FOREST_HAG, IcariaResourceLocations.PLANE_FOREST_HAG));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.POPULUS_FOREST_HAG, IcariaResourceLocations.POPULUS_FOREST_HAG));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.REVENANT, IcariaResourceLocations.CAPTAIN_REVENANT));
		pEvent.enqueueWork(() -> SkullBlockRenderer.SKIN_BY_TYPE.put(SkullBlockTypes.THOG, IcariaResourceLocations.THOG));
	}

	public static void registerWoodTypes(FMLClientSetupEvent pEvent) {
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.CYPRESS));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.DROUGHTROOT));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.FIR));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.LAUREL));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.OLIVE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.PLANE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.POPULUS));
	}

	public static void registerSetups(FMLCommonSetupEvent pEvent) {
		pEvent.enqueueWork(IcariaFlammables::setup);
		pEvent.enqueueWork(IcariaPottables::setup);
		pEvent.enqueueWork(IcariaWoodTypes::setup);
	}

	public static void registerPayloadHandlers(RegisterPayloadHandlersEvent pEvent) {
		pEvent.registrar(IcariaIdents.ID).playToClient(BarrelPayload.TYPE, BarrelPayload.STREAM_CODEC, BarrelPayload::handle);
		pEvent.registrar(IcariaIdents.ID).playToServer(ChestLabelPayload.TYPE, ChestLabelPayload.STREAM_CODEC, ChestLabelPayload::handle);
		pEvent.registrar(IcariaIdents.ID).playToClient(GrinderPayload.TYPE, GrinderPayload.STREAM_CODEC, GrinderPayload::handle);
		pEvent.registrar(IcariaIdents.ID).playToClient(LootVasePayload.TYPE, LootVasePayload.STREAM_CODEC, LootVasePayload::handle);
		pEvent.registrar(IcariaIdents.ID).playToClient(TotemPayload.TYPE, TotemPayload.STREAM_CODEC, TotemPayload::handle);
	}
}
