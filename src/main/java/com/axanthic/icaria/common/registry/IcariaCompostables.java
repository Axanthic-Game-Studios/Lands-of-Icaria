package com.axanthic.icaria.common.registry;

import net.minecraft.world.level.block.ComposterBlock;

public class IcariaCompostables {
	public static void setup() {
		ComposterBlock.COMPOSTABLES.put(IcariaItems.MOSS_0.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.MOSS_1.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.MOSS_2.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.SPELT_BALE_BLOCK.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_REED_BLOCK.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_SPROUT_BLOCK.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.SPELT.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.SPELT_BREAD.get(), 0.85F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_REED.get(), 0.5F);
		ComposterBlock.COMPOSTABLES.put(IcariaItems.VINE_SPROUT.get(), 0.3F);
	}
}
