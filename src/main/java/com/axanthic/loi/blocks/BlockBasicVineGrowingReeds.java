package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemResources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockBasicVineGrowingReeds extends BlockBasicVineGrowing {

	public BlockBasicVineGrowingReeds(String name, boolean damage) {
		super(name, damage);
	}

	public BlockBasicVineGrowingReeds(String name) {
		super(name);
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.resource;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ItemResources.ResourceType.VINEREEDS.toMeta();
	}
}
