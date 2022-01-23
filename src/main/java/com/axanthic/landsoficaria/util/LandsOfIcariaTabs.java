package com.axanthic.landsoficaria.util;

import com.axanthic.landsoficaria.common.blocks.IcariaBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LandsOfIcariaTabs {

    public static final CreativeModeTab creativeBlocks = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".blocks") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(IcariaBlocks.MARL_GRASS.get());
        }
    };

    public static final CreativeModeTab creativeFlora = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".flora") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(IcariaBlocks.MARL_GRASS.get());
        }
    };

    public static final CreativeModeTab creativeItems = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".items") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(IcariaBlocks.MARL_GRASS.get());
        }
    };
}
