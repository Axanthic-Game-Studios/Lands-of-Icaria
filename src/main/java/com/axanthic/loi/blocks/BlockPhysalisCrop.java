package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;

import net.minecraft.item.Item;

public class BlockPhysalisCrop extends BlockCustomCrop {
	public BlockPhysalisCrop(String name) {
		super(name);
	}
	
	@Override
	protected Item getSeed( ) {
		return Resources.seedsPhysalis;
	}
	
	@Override
	protected int getCropMeta( ) {
		return 6; // Physalis.
	}
	
	@Override
	protected int getNumSeedsWhenGrown(Random rand, int fortune) {
		int numDrops = 1 + rand.nextInt(1);
		if (fortune > 0)
			numDrops += rand.nextInt(fortune);
		
		return numDrops;
	}
	
	@Override
	protected int getNumCropsWhenGrown(Random rand, int fortune) {
		int numDrops = 1 + rand.nextInt(2);
		if (fortune > 0)
			numDrops += rand.nextInt(fortune);
		
		return numDrops;
	}
}
