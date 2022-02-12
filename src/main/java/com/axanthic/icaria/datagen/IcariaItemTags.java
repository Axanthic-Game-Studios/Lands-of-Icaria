package com.axanthic.icaria.datagen;

import com.axanthic.icaria.LandsOfIcariaInfo;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaItemTags extends ItemTagsProvider {

	public IcariaItemTags(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
		super(gen, blockTags, LandsOfIcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {

	}

	@SafeVarargs
	public final void addAllTags(Item item, Named<Item>... tags) {
		for (Named<Item> tag : tags) {
			tag(tag).add(item);
		}
	}
}
