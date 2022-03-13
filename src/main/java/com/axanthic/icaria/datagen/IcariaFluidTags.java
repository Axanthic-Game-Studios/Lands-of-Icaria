package com.axanthic.icaria.datagen;

import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.util.IcariaInfo;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;

import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaFluidTags extends FluidTagsProvider {
	public IcariaFluidTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, IcariaInfo.MODID, existingFileHelper);
	}

	@Override
	public void addTags() {
		this.tag(FluidTags.LAVA)
			.add(IcariaFluids.HYLIASTRUM_FLUID_SOURCE.get())
			.add(IcariaFluids.HYLIASTRUM_FLUID_FLOWING.get());

		this.tag(FluidTags.WATER)
			.add(IcariaFluids.MEDITERRANEAN_WATER_SOURCE.get())
			.add(IcariaFluids.MEDITERRANEAN_WATER_FLOWING.get())
			.add(IcariaFluids.UPWARDS_FLUID_SOURCE.get())
			.add(IcariaFluids.UPWARDS_FLUID_FLOWING.get());
	}
}
