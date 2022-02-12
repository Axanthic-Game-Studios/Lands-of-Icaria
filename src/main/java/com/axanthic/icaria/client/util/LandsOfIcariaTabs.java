package com.axanthic.icaria.client.util;

import com.axanthic.icaria.LandsOfIcariaInfo;
import com.axanthic.icaria.common.registry.LandsOfIcariaBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LandsOfIcariaTabs {
	public static final CreativeModeTab creativeBlocks = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".blocks") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(LandsOfIcariaBlocks.MARL_GRASS.get());
		}
	};

	public static final CreativeModeTab creativeFlora = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".flora") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(LandsOfIcariaBlocks.MARL_GRASS.get());
		}
	};

	public static final CreativeModeTab creativeItems = new CreativeModeTab(LandsOfIcariaInfo.MODID + ".items") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(LandsOfIcariaBlocks.MARL_GRASS.get());
		}
	};
}
