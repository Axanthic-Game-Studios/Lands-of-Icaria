package com.axanthic.landsoficaria.datagen;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaBlockTags extends BlockTagsProvider {

	public IcariaBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, LandsOfIcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {

	}
}
