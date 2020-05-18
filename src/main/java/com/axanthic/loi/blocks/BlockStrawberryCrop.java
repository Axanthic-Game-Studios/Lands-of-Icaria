package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;

import net.minecraft.item.Item;

public class BlockStrawberryCrop extends BlockCustomCrop {
	public BlockStrawberryCrop(String name) {
		super(name);
	}
	
	@Override
	protected Item getSeed( ) {
		return Resources.seedsStrawberry;
	}
	
	@Override
	protected int getCropMeta( ) {
		return 5; // Strawberry.
	}
	
	@Override
	protected int getNumSeedsWhenGrown(Random rand, int fortune) {
		return 0;
	}
	
	@Override
	protected int getNumCropsWhenGrown(Random rand, int fortune) {
		int numDrops = 2 + rand.nextInt(2);
		if (fortune > 0)
			numDrops += rand.nextInt(fortune);
		
		return numDrops;
	}
}
