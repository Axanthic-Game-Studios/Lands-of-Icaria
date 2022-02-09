package com.axanthic.landsoficaria;

import com.axanthic.landsoficaria.client.ClientProxy;
import com.axanthic.landsoficaria.common.CommonProxy;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaBlocks;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems;

import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LandsOfIcariaInfo.MODID)
public class LandsOfIcaria
{
    public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public LandsOfIcaria() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetupEvent);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

        LandsOfIcariaBlocks.BLOCKS.register(bus);
        LandsOfIcariaItems.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onCommonSetupEvent(FMLCommonSetupEvent event) {
        ComposterBlock.COMPOSTABLES.put(LandsOfIcariaItems.MOSS_0.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(LandsOfIcariaItems.MOSS_1.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(LandsOfIcariaItems.MOSS_2.get(), 0.3F);
    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
        proxy.init();
    }
}
