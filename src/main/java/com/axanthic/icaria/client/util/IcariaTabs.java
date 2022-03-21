package com.axanthic.icaria.client.util;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@MethodsReturnNonnullByDefault

public class IcariaTabs {
	public static final CreativeModeTab creativeBlocks = new CreativeModeTab(IcariaInfo.MODID + ".blocks") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(IcariaItems.MARL_GRASS.get());
		}
	};

	public static final CreativeModeTab creativeFlora = new CreativeModeTab(IcariaInfo.MODID + ".flora") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(IcariaItems.LARGE_GRASS.get());
		}
	};

	public static final CreativeModeTab creativeItems = new CreativeModeTab(IcariaInfo.MODID + ".items") {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(IcariaItems.ORICHALCUM_TOOLS.PICKAXE.get());
		}
	};
}
