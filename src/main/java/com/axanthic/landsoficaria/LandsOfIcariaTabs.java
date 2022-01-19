package com.axanthic.landsoficaria;

import com.axanthic.landsoficaria.common.items.IcariaItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LandsOfIcariaTabs {

    public static final CreativeModeTab creativeBlocks = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".blocks") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(IcariaItems.EXAMPLE.get());
        }
    };

    public static final CreativeModeTab creativeFlora = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".flora") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(IcariaItems.EXAMPLE.get());
        }
    };

    public static final CreativeModeTab creativeItems = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".items") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(IcariaItems.EXAMPLE.get());
        }
    };
}
