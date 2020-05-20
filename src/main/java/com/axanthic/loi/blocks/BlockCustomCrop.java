package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemFoods;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public abstract class BlockCustomCrop extends BlockCrops {
	public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, 7);
	
	public BlockCustomCrop(String name) {
		super();
		this.setRegistryName(ModInformation.ID, name);
		this.setUnlocalizedName(name);
	}
	
	/*
	 * Return the EnumFood to use for this crop's food item.
	 */
	protected abstract ItemFoods.FoodType getFood();
	
	/*
	 * Return the number of seeds to drop when fully grown.
	 */
	protected abstract int getNumSeedsWhenGrown(Random rand, int fortune);
	
	/*
	 * Return the number of crops to drop when fully grown. 
	 */
	protected abstract int getNumCropsWhenGrown(Random rand, int fortune);
	
	@Override
	protected Item getCrop( ) {
		return Resources.food;
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		if (isMaxAge(state)) {
			// Fully grown drops.
			Random rand = world instanceof World ? ((World)world).rand : new Random();
			int numSeedDrops = this.getNumSeedsWhenGrown(rand, fortune);
			drops.add(new ItemStack(this.getSeed(), numSeedDrops));
			int numCropDrops = this.getNumCropsWhenGrown(rand, fortune);
			drops.add(new ItemStack(this.getCrop(), numCropDrops, this.getFood().ordinal()));
		} else {
			// Non-fully grown drops.
			drops.add(new ItemStack(this.getSeed(), 1));
		}
	}
	
	@Override
	protected PropertyInteger getAgeProperty() {
		return CROP_AGE;
	}
	
	@Override
	public int getMaxAge() {
		return 7;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {CROP_AGE});
	}
}
