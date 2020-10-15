package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemFoods;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStrawberryCrop extends BlockCustomCrop {
	private static final AxisAlignedBB[] CROP_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.35D, -0.0625D, 0.35D, 0.65D, 0.25D, 0.65D),
			
			new AxisAlignedBB(0.3D, -0.0625D, 0.3D, 0.7D, 0.3D, 0.7D),
			new AxisAlignedBB(0.3D, -0.0625D, 0.3D, 0.7D, 0.3D, 0.7D),
			
			new AxisAlignedBB(0.25D, -0.0625D, 0.25D, 0.75D, 0.35D, 0.75D),
			new AxisAlignedBB(0.25D, -0.0625D, 0.25D, 0.75D, 0.35D, 0.75D),
			
			new AxisAlignedBB(0.2D, -0.0625D, 0.2D, 0.8D, 0.4D, 0.8D),
			new AxisAlignedBB(0.2D, -0.0625D, 0.2D, 0.8D, 0.4D, 0.8D),
			
			new AxisAlignedBB(0.2D, -0.0625D, 0.2D, 0.8D, 0.4D, 0.8D),
	};
	
	public BlockStrawberryCrop(String name) {
		super(name);
	}
	
	@Override
	protected Item getSeed( ) {
		return Resources.seedsStrawberry;
	}
	
	@Override
	protected int getCropMeta( ) {
		return ItemFoods.FoodType.STRAWBERRY.ordinal();
	}
	
	@Override
	protected int getNumSeedsWhenGrown(Random rand, int fortune) {
		return 0;
	}
	
	@Override
	protected int getNumCropsWhenGrown(Random rand, int fortune) {
		int numDrops = 2 + rand.nextInt(3) + rand.nextInt(fortune + 1);
		
		return numDrops;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Resources.bushStrawberry, 1);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROP_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}
}
