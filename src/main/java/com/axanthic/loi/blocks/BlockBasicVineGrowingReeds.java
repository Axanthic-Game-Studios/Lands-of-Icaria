package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemResources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

	@Override
	@SuppressWarnings("deprecation")
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(this);
	}
}
