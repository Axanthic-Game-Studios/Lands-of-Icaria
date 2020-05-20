package com.axanthic.loi.blocks;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockPalmFern extends BlockCustomBush {
	public BlockPalmFern(String name) {
		super(name);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
}
