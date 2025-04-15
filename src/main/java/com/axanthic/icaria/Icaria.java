package com.axanthic.icaria;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.network.packet.ChestLabelPacket;
import com.axanthic.icaria.common.network.packet.IcariaTotemPacket;
import com.axanthic.icaria.common.registry.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.item.ItemProperties;

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
		Icaria.registerItemProperties(pEvent);
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
		IcariaBlocks.BLOCKS.register(pBus);
		IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register(pBus);
		IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register(pBus);
		IcariaDataComponents.DATA_COMPONENT_TYPES.register(pBus);
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
		IcariaRecipeSerializers.RECIPE_SERIALIZERS.register(pBus);
		IcariaRecipeTypes.RECIPE_TYPES.register(pBus);
		IcariaStructureTypes.STRUCTURE_TYPES.register(pBus);
	}

	public static void registerExtensionPoint(FMLClientSetupEvent pEvent) {
		ModLoadingContext.get().getActiveContainer().registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
	}

	public static void registerItemProperties(FMLClientSetupEvent pEvent) {
		ItemProperties.register(IcariaItems.CHERT_BIDENT.get(), IcariaResourceLocations.THROWING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.CHALKOS_BIDENT.get(), IcariaResourceLocations.THROWING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.KASSITEROS_BIDENT.get(), IcariaResourceLocations.THROWING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.ORICHALCUM_BIDENT.get(), IcariaResourceLocations.THROWING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.VANADIUMSTEEL_BIDENT.get(), IcariaResourceLocations.THROWING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.SIDEROS_BIDENT.get(), IcariaResourceLocations.THROWING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get(), IcariaResourceLocations.THROWING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.CAPELLA_HORN.get(), IcariaResourceLocations.TOOTING, (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.getUseItem() == itemStack && livingEntity.isUsingItem() ? 1.0F : 0.0F);
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
		pEvent.enqueueWork(IcariaStrippables::setup);
		pEvent.enqueueWork(IcariaWoodTypes::setup);
	}

	public static void registerPayloadHandlers(RegisterPayloadHandlersEvent pEvent) {
		pEvent.registrar(IcariaIdents.ID).playToClient(IcariaTotemPacket.TYPE, IcariaTotemPacket.STREAM_CODEC, IcariaTotemPacket::handler);
		pEvent.registrar(IcariaIdents.ID).playToServer(ChestLabelPacket.TYPE, ChestLabelPacket.STREAM_CODEC, ChestLabelPacket::handler);
	}
}
