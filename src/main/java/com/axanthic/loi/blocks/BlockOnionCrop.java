package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemFoods;
import com.axanthic.loi.items.ItemResources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOnionCrop extends BlockCustomCrop {
	private static final AxisAlignedBB[] CROP_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D),
	};

	public BlockOnionCrop(String name) {
		super(name);
	}

	@Override
	protected Item getSeed() {
		return Resources.onion;
	}

	@Override
	protected int getCropMeta() {
		return ItemFoods.FoodType.GARLIC.ordinal();
	}

	@Override
	protected int getNumSeedsWhenGrown(Random rand, int fortune) {
		return 2 + rand.nextInt(3 + fortune);
	}

	@Override
	protected int getNumCropsWhenGrown(Random rand, int fortune) {
		return rand.nextInt(50) == 0 ? 1 : 0;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROP_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}
}
