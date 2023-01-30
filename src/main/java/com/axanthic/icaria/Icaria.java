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

@Mod(IcariaInfo.MODID)
public class Icaria {
	public CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public Icaria() {
		IcariaConfig.register();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCreativeModeTabRegistration);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onEntityAttributeCreation);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLClientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLLoadComplete);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterLayerDefinitions);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		IcariaBlocks.BLOCKS.register(bus);
		IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
		IcariaMenuTypes.MENU_TYPES.register(bus);
		IcariaEffects.EFFECTS.register(bus);
		IcariaEntityTypes.ENTITY_TYPES.register(bus);
		IcariaFluids.FLUIDS.register(bus);
		IcariaFluidTypes.FLUID_TYPES.register(bus);
		IcariaItems.ITEMS.register(bus);
		IcariaPoiTypes.POI_TYPES.register(bus);
		IcariaRecipeTypes.RECIPE_TYPES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onCreativeModeTabRegistration(CreativeModeTabEvent.Register pEvent) {
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
		this.proxy.onFMLLoadComplete();
	}

	public void onGatherData(GatherDataEvent pEvent) {
		this.proxy.onGatherData(pEvent);
	}

	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
		this.proxy.onRegisterLayerDefinitions(pEvent);
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

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent pEvent) {
		this.proxy.onPlayerTick(pEvent);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> pEvent) {
		this.proxy.onRenderLivingPre(pEvent);
	}
}
