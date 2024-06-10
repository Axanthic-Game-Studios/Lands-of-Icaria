package com.axanthic.icaria;

import com.axanthic.icaria.client.screen.ForgeScreen;
import com.axanthic.icaria.client.screen.GrinderScreen;
import com.axanthic.icaria.client.screen.KilnScreen;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.brewing.BrewingRecipeRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

@Mod(IcariaInfo.ID)
public class Icaria {
	public Icaria(IEventBus pBus) {
		IcariaConfig.registerClientConfig();
		IcariaConfig.registerCommonConfig();
		IcariaConfig.registerServerConfig();

		pBus.addListener(this::onFMLClientSetup);
		pBus.addListener(this::onFMLCommonSetup);

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
		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenus.FORGE.get(), ForgeScreen::new));
		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenus.GRINDER.get(), GrinderScreen::new));
		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenus.KILN.get(), KilnScreen::new));
		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenus.STORAGE_VASE.get(), StorageVaseScreen::new));

		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.CYPRESS));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.DROUGHTROOT));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.FIR));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.LAUREL));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.OLIVE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.PLANE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.POPULUS));

		pEvent.enqueueWork(Sheets::translucentCullBlockSheet);

		ItemProperties.register(IcariaItems.GREEK_FIRE_GRENADE.get(), IcariaResourceLocations.THROWING, (pItemStack, pClientLevel, pLivingEntity, pId) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.VINEGAR.get(), IcariaResourceLocations.THROWING, (pItemStack, pClientLevel, pLivingEntity, pId) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);

		for (var items : IcariaToolItems.TOOL_ITEMS) {
			ItemProperties.register(items.bident.get(), IcariaResourceLocations.THROWING, (pItemStack, pClientLevel, pLivingEntity, pId) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
		}
	}

	public void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		pEvent.enqueueWork(IcariaCompostables::setup);
		pEvent.enqueueWork(IcariaFlammables::setup);
		pEvent.enqueueWork(IcariaPottables::setup);
		pEvent.enqueueWork(IcariaStrippables::setup);
		pEvent.enqueueWork(IcariaWoodTypes::setup);

		pEvent.enqueueWork(() -> this.setupBrewing(IcariaItems.BLINDWEED.get(), Potions.AWKWARD, IcariaPotions.BLINDNESS.get()));
		pEvent.enqueueWork(() -> this.setupBrewing(IcariaItems.SNULL_CREAM.get(), Potions.AWKWARD, IcariaPotions.NAUSEA.get()));
		pEvent.enqueueWork(() -> this.setupBrewing(Items.WITHER_ROSE, Potions.AWKWARD, IcariaPotions.WITHER.get()));
	}

	public void setupBrewing(Item pItem, Potion pPotion, Potion pResult) {
		var potion = new ItemStack(Items.POTION);
		BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(potion.copy(), pPotion)), Ingredient.of(pItem), PotionUtils.setPotion(potion.copy(), pResult));
	}
}
