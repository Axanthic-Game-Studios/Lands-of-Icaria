package com.axanthic.landsoficaria;

import com.axanthic.landsoficaria.common.blocks.IcariaBlocks;
import com.axanthic.landsoficaria.common.items.IcariaItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LandsOfIcariaInfo.MODID)
public class LandsOfIcaria
{
    public LandsOfIcaria() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        IcariaItems.ITEMS.register(bus);
        IcariaBlocks.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
