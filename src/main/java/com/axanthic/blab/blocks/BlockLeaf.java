package com.axanthic.blab.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLeaf extends BlockLeaves {

	BlockPlanks.WoodTypes type;
	Item sapling;

	public BlockLeaf(BlockPlanks.WoodTypes type, Item sapling) {
		super();
		this.setCreativeTab(Blab.modTab);
		this.type = type;
		this.sapling = sapling;
		this.setUnlocalizedName("leaf");
		this.setRegistryName(ModInformation.ID, "leaf_" + type.unlocalizedName);
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return type.leafColor;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return sapling;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return Arrays.asList(new ItemStack(this, 1, 0));
	}

	@Override
	public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
}
