package com.axanthic.icaria;

import com.axanthic.icaria.client.proxy.ClientProxy;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")

@Mod(IcariaInfo.ID)
public class Icaria {
	public CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public Icaria() {
		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

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

		IcariaBiomes.BIOMES.register(eventBus);
		IcariaBlocks.BLOCKS.register(eventBus);
		IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
		IcariaCarvers.CARVERS.register(eventBus);
		IcariaDimensions.CHUNK_GENERATORS.register(eventBus);
		IcariaEntityTypes.ENTITY_TYPES.register(eventBus);
		IcariaFeatures.FEATURE_REGISTER.register(eventBus);
		IcariaFluids.FLUIDS.register(eventBus);
		IcariaFluidTypes.FLUID_TYPES.register(eventBus);
		IcariaItems.ITEMS.register(eventBus);
		IcariaMenuTypes.MENU_TYPES.register(eventBus);
		IcariaMobEffects.MOB_EFFECTS.register(eventBus);
		IcariaPlacements.PLACED_FEATURE_REGISTER.register(eventBus);
		IcariaPoiTypes.POI_TYPES.register(eventBus);
		IcariaRecipeTypes.RECIPE_TYPES.register(eventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onCreativeModeTabRegistration(final CreativeModeTabEvent.Register pEvent) {
		this.proxy.onCreativeModeTabRegistration(pEvent);
	}

	public void onEntityAttributeCreation(final EntityAttributeCreationEvent pEvent) {
		this.proxy.onEntityAttributeCreation(pEvent);
	}

	public void onFMLClientSetup(final FMLClientSetupEvent pEvent) {
		this.proxy.onFMLClientSetup(pEvent);
	}

	public void onFMLCommonSetup(final FMLCommonSetupEvent pEvent) {
		this.proxy.onFMLCommonSetup(pEvent);
	}

	public void onFMLLoadComplete(final FMLLoadCompleteEvent pEvent) {
		this.proxy.onFMLLoadComplete(pEvent);
	}

	public void onGatherData(final GatherDataEvent pEvent) {
		this.proxy.onGatherData(pEvent);
	}

	public void onRegisterLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
		this.proxy.onRegisterLayerDefinitions(pEvent);
	}

	@SubscribeEvent
	public void onEntityAttributeModification(final EntityAttributeModificationEvent pEvent) {
		this.proxy.onEntityAttributeModification(pEvent);
	}

	@SubscribeEvent
	public void onLivingAttack(final LivingAttackEvent pEvent) {
		this.proxy.onLivingAttack(pEvent);
	}

	@SubscribeEvent
	public void onMobEffectApplicable(final MobEffectEvent.Applicable pEvent) {
		this.proxy.onMobEffectApplicable(pEvent);
	}

	@SubscribeEvent
	public void onPlayerInteract(final PlayerInteractEvent pEvent) {
		this.proxy.onPlayerInteract(pEvent);
	}

	@SubscribeEvent
	public void onEntityInteract(final PlayerInteractEvent.EntityInteract pEvent) {
		this.proxy.onEntityInteract(pEvent);
	}

	@SubscribeEvent
	public void onLeftClickBlock(final PlayerInteractEvent.LeftClickBlock pEvent) {
		this.proxy.onLeftClickBlock(pEvent);
	}

	@SubscribeEvent
	public void onRightClickBlock(final PlayerInteractEvent.RightClickBlock pEvent) {
		this.proxy.onRightClickBlock(pEvent);
	}

	@SubscribeEvent
	public void onPlayerTick(final TickEvent.PlayerTickEvent pEvent) {
		this.proxy.onPlayerTick(pEvent);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onRenderLivingPre(final RenderLivingEvent.Pre<?, ?> pEvent) {
		this.proxy.onRenderLivingPre(pEvent);
	}
}
