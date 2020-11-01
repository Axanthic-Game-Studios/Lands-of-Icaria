package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemResources;

import net.minecraft.item.Item;

public class BlockSpeltCrop extends BlockCustomCrop {

	public BlockSpeltCrop(String name) {
		super(name);
	}

	@Override
	protected Item getSeed() {
		return Resources.seedsSpelt;
	}

	@Override
	protected Item getCrop() {
		return Resources.resource;
	}

	@Override
	protected int getCropMeta() {
		return ItemResources.ResourceType.SPELT.ordinal();
	}

	@Override
	protected int getNumSeedsWhenGrown(Random rand, int fortune) {
		return rand.nextInt(4 + fortune);
	}

	@Override
	protected int getNumCropsWhenGrown(Random rand, int fortune) {
		return 1;
	}
}
