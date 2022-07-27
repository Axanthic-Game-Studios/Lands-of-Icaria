package com.axanthic.icaria;

import com.axanthic.icaria.client.layer.OrichalcumHelmetLayer;
import com.axanthic.icaria.client.proxy.ClientProxy;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.TickEvent;
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

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(OrichalcumHelmetLayer::onEntityRenderers));
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(OrichalcumHelmetLayer::register));

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLClientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onFMLCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onLoadComplete);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		IcariaBlocks.BLOCKS.register(bus);
		IcariaBlockEntities.BLOCK_ENTITY_TYPES.register(bus);
		IcariaContainers.MENU_TYPES.register(bus);
		IcariaEffects.EFFECTS.register(bus);
		IcariaEntities.ENTITY_TYPES.register(bus);
		IcariaFluids.FLUIDS.register(bus);
		IcariaFluids.FLUID_TYPES.register(bus);
		IcariaItems.ITEMS.register(bus);
		IcariaPOIs.POIS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onFMLClientSetup(FMLClientSetupEvent event) {
		proxy.onFMLClientSetup(event);
	}

	public void onFMLCommonSetup(FMLCommonSetupEvent event) {
		proxy.onFMLCommonSetup(event);
	}

	public void onGatherData(GatherDataEvent event) {
		proxy.onGatherData(event);
	}

	public void onLoadComplete(FMLLoadCompleteEvent event) {
		proxy.loadComplete();
	}

	@SubscribeEvent
	public void onEntityAttributeModification(EntityAttributeModificationEvent event) {
		proxy.onEntityAttributeModification(event);
	}

	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event) {
		proxy.onLivingAttack(event);
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event) {
		proxy.onPlayerInteract(event);
	}

	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		proxy.onEntityInteract(event);
	}

	@SubscribeEvent
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		proxy.onLeftClickBlock(event);
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		proxy.onRightClickBlock(event);
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		proxy.onPlayerTick(event);
	}

	@SubscribeEvent
	public void onPotionApplicable(MobEffectEvent.Applicable event) {
		proxy.onPotionApplicable(event);
	}
}
