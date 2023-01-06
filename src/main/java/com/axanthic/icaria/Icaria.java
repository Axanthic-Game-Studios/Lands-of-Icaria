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

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

@Mod(IcariaInfo.MODID)
public class Icaria {
	public CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public Icaria() {
		IcariaConfig.register();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onEntityAttributeCreation);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLClientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLLoadComplete);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterLayerDefinitions);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		IcariaBlocks.BLOCKS.register(bus);
		IcariaBlockEntities.BLOCK_ENTITY_TYPES.register(bus);
		IcariaMenus.MENU_TYPES.register(bus);
		IcariaEffects.EFFECTS.register(bus);
		IcariaEntities.ENTITY_TYPES.register(bus);
		IcariaFluids.FLUIDS.register(bus);
		IcariaFluids.FLUID_TYPES.register(bus);
		IcariaItems.ITEMS.register(bus);
		IcariaPOIs.POIS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
		this.proxy.onEntityAttributeCreation(event);
	}

	public void onFMLClientSetup(FMLClientSetupEvent event) {
		this.proxy.onFMLClientSetup(event);
	}

	public void onFMLCommonSetup(FMLCommonSetupEvent event) {
		this.proxy.onFMLCommonSetup(event);
	}

	public void onFMLLoadComplete(FMLLoadCompleteEvent event) {
		this.proxy.onFMLLoadComplete();
	}

	public void onGatherData(GatherDataEvent event) {
		this.proxy.onGatherData(event);
	}

	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		this.proxy.onRegisterLayerDefinitions(event);
	}

	@SubscribeEvent
	public void onEntityAttributeModification(EntityAttributeModificationEvent event) {
		this.proxy.onEntityAttributeModification(event);
	}

	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event) {
		this.proxy.onLivingAttack(event);
	}

	@SubscribeEvent
	public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
		this.proxy.onMobEffectApplicable(event);
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event) {
		this.proxy.onPlayerInteract(event);
	}

	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		this.proxy.onEntityInteract(event);
	}

	@SubscribeEvent
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		this.proxy.onLeftClickBlock(event);
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		this.proxy.onRightClickBlock(event);
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		this.proxy.onPlayerTick(event);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
		this.proxy.onRenderLivingPre(event);
	}
}
