package com.axanthic.icaria.client.util;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault

public class IcariaTabs {
	public static final CreativeModeTab BLOCKS = new CreativeModeTab(IcariaInfo.MODID + ".blocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(IcariaItems.MARL_GRASS.get());
		}
	};

	public static final CreativeModeTab FLORA = new CreativeModeTab(IcariaInfo.MODID + ".flora") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(IcariaItems.LARGE_GRASS.get());
		}
	};

	public static final CreativeModeTab ITEMS = new CreativeModeTab(IcariaInfo.MODID + ".items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get());
		}
	};
}
