package com.axanthic.icaria;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.network.TotemPacket;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

@Mod(IcariaInfo.ID)
public class Icaria {
	public Icaria(IEventBus pBus) {
		pBus.addListener(this::onFMLClientSetup);
		pBus.addListener(this::onFMLCommonSetup);
		pBus.addListener(this::onRegisterPayloadHandlers);

		IcariaConfig.registerClientConfig();
		IcariaConfig.registerCommonConfig();
		IcariaConfig.registerServerConfig();

		IcariaArmorMaterials.ARMOR_MATERIALS.register(pBus);
		IcariaBlocks.BLOCKS.register(pBus);
		IcariaStoneDecoBlocks.BLOCKS.register(pBus);
		IcariaWoodDecoBlocks.BLOCKS.register(pBus);
		IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register(pBus);
		IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register(pBus);
		IcariaEntityTypes.ENTITY_TYPES.register(pBus);
		IcariaFeatures.FEATURES.register(pBus);
		IcariaFluids.FLUIDS.register(pBus);
		IcariaFluidTypes.FLUID_TYPES.register(pBus);
		IcariaItems.ITEMS.register(pBus);
		IcariaArmorItems.ITEMS.register(pBus);
		IcariaStoneDecoItems.ITEMS.register(pBus);
		IcariaToolItems.ITEMS.register(pBus);
		IcariaWoodDecoItems.ITEMS.register(pBus);
		IcariaMenus.MENUS.register(pBus);
		IcariaMobEffects.MOB_EFFECTS.register(pBus);
		IcariaPoiTypes.POI_TYPES.register(pBus);
		IcariaPotions.POTIONS.register(pBus);
		IcariaRecipeSerializers.RECIPE_SERIALIZERS.register(pBus);
		IcariaRecipeTypes.RECIPE_TYPES.register(pBus);
		IcariaStructureTypes.STRUCTURE_TYPES.register(pBus);
	}

	public void onFMLClientSetup(FMLClientSetupEvent pEvent) {
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.CYPRESS));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.DROUGHTROOT));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.FIR));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.LAUREL));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.OLIVE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.PLANE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.POPULUS));
		pEvent.enqueueWork(() -> Sheets.translucentCullBlockSheet());

		this.registerProperty(IcariaItems.CHERT_TOOLS.bident.get());
		this.registerProperty(IcariaItems.CHALKOS_TOOLS.bident.get());
		this.registerProperty(IcariaItems.KASSITEROS_TOOLS.bident.get());
		this.registerProperty(IcariaItems.ORICHALCUM_TOOLS.bident.get());
		this.registerProperty(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get());
		this.registerProperty(IcariaItems.SIDEROS_TOOLS.bident.get());
		this.registerProperty(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());
		this.registerProperty(IcariaItems.GREEK_FIRE_GRENADE.get());
	}

	public void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		pEvent.enqueueWork(IcariaFlammables::setup);
		pEvent.enqueueWork(IcariaPottables::setup);
		pEvent.enqueueWork(IcariaStrippables::setup);
		pEvent.enqueueWork(IcariaWoodTypes::setup);
	}

	public void onRegisterPayloadHandlers(RegisterPayloadHandlersEvent pEvent) {
		var registrar = pEvent.registrar(IcariaInfo.ID);
		registrar.playToClient(TotemPacket.TYPE, TotemPacket.STREAM_CODEC, TotemPacket::handler);
	}

	public void registerProperty(Item pItem) {
		ItemProperties.register(pItem, IcariaResourceLocations.THROWING, (pItemStack, pClientLevel, pLivingEntity, pId) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
	}
}
