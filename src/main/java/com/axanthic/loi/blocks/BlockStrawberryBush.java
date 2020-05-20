package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemFoods;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStrawberryBush extends BlockCustomBush {
	private static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.2D, -0.0625D, 0.2D, 0.8D, 0.4D, 0.8D);
	
	public BlockStrawberryBush(String name) {
		super(name);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.food;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return ItemFoods.FoodType.STRAWBERRY.toMeta();
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random rand) {
		return 2 + rand.nextInt(3) + rand.nextInt(fortune + 1);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BUSH_AABB.offset(state.getOffset(source, pos));
	}
}
