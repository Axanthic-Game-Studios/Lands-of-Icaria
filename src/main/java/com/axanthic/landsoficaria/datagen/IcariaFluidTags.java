package com.axanthic.landsoficaria.datagen;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaFluidTags extends FluidTagsProvider {

	public IcariaFluidTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, LandsOfIcariaInfo.MODID, existingFileHelper);
	}

	@Override
	public void addTags() {

	}
}
