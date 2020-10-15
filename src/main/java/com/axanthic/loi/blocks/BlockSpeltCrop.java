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
