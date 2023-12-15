package com.axanthic.icaria;

import com.axanthic.icaria.client.effects.IcariaSpecialEffects;
import com.axanthic.icaria.client.proxy.ClientProxy;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")

@Mod(IcariaInfo.ID)
@Mod.EventBusSubscriber(modid = IcariaInfo.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Icaria {
	public CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public Icaria() {
		var eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		IcariaConfig.registerClientConfig();
		IcariaConfig.registerCommonConfig();
		IcariaConfig.registerServerConfig();

		eventBus.addListener(this::onCreativeModeTabRegistration);
		eventBus.addListener(this::onEntityAttributeCreation);
		eventBus.addListener(this::onFMLClientSetup);
		eventBus.addListener(this::onFMLCommonSetup);
		eventBus.addListener(this::onFMLLoadComplete);
		eventBus.addListener(this::onGatherData);
		eventBus.addListener(this::onRegisterLayerDefinitions);
		eventBus.addListener(this::onSpawnPlacementRegister);

		IcariaBlocks.BLOCKS.register(eventBus);
		IcariaStoneDecoBlocks.BLOCKS.register(eventBus);
		IcariaWoodDecoBlocks.BLOCKS.register(eventBus);
		IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
		IcariaCarvers.CARVERS.register(eventBus);
		IcariaChunkGenerators.CHUNK_GENERATORS.register(eventBus);
		IcariaCreativeModeTabs.CREATIVE_MODE_TABS.register(eventBus);
		IcariaEntityTypes.ENTITY_TYPES.register(eventBus);
		IcariaFeatures.FEATURES.register(eventBus);
		IcariaFluids.FLUIDS.register(eventBus);
		IcariaFluidTypes.FLUID_TYPES.register(eventBus);
		IcariaItems.ITEMS.register(eventBus);
		IcariaArmorItems.ITEMS.register(eventBus);
		IcariaStoneDecoItems.ITEMS.register(eventBus);
		IcariaToolItems.ITEMS.register(eventBus);
		IcariaWoodDecoItems.ITEMS.register(eventBus);
		IcariaMenus.MENUS.register(eventBus);
		IcariaMobEffects.MOB_EFFECTS.register(eventBus);
		IcariaPoiTypes.POI_TYPES.register(eventBus);
		IcariaPotions.POTIONS.register(eventBus);
		IcariaRecipeSerializers.RECIPE_SERIALIZERS.register(eventBus);
		IcariaRecipeTypes.RECIPE_TYPES.register(eventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onCreativeModeTabRegistration(BuildCreativeModeTabContentsEvent pEvent) {
		this.proxy.onCreativeModeTabRegistration(pEvent);
	}

	public void onEntityAttributeCreation(EntityAttributeCreationEvent pEvent) {
		this.proxy.onEntityAttributeCreation(pEvent);
	}

	public void onFMLClientSetup(FMLClientSetupEvent pEvent) {
		this.proxy.onFMLClientSetup(pEvent);
	}

	public void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		this.proxy.onFMLCommonSetup(pEvent);
	}

	public void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
		this.proxy.onFMLLoadComplete(pEvent);
	}

	public void onGatherData(GatherDataEvent pEvent) {
		this.proxy.onGatherData(pEvent);
	}

	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
		this.proxy.onRegisterLayerDefinitions(pEvent);
	}

	public void onSpawnPlacementRegister(SpawnPlacementRegisterEvent pEvent) {
		this.proxy.onSpawnPlacementRegister(pEvent);
	}

	@SubscribeEvent
	public void onEntityAttributeModification(EntityAttributeModificationEvent pEvent) {
		this.proxy.onEntityAttributeModification(pEvent);
	}

	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent pEvent) {
		this.proxy.onLivingAttack(pEvent);
	}

	@SubscribeEvent
	public void onMobEffectApplicable(MobEffectEvent.Applicable pEvent) {
		this.proxy.onMobEffectApplicable(pEvent);
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent pEvent) {
		this.proxy.onPlayerInteract(pEvent);
	}

	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract pEvent) {
		this.proxy.onEntityInteract(pEvent);
	}

	@SubscribeEvent
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock pEvent) {
		this.proxy.onLeftClickBlock(pEvent);
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock pEvent) {
		this.proxy.onRightClickBlock(pEvent);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onRegisterDimensionSpecialEffects(@Nonnull RegisterDimensionSpecialEffectsEvent pEvent) {
		pEvent.register(IcariaResourceLocations.ICARIA, new IcariaSpecialEffects());
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> pEvent) {
		this.proxy.onRenderLivingPre(pEvent);
	}
}
