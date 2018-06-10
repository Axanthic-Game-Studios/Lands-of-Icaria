package com.axanthic.blab.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.blab.Blab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockStone extends Block {

	public static final PropertyInteger[] levelsArray = {
			PropertyInteger.create("level", 0, 1)
	};

	static int maxCompression = 10;
	Float miningSpeed = 3.0F;
	String basicBlock;
	public static final PropertyInteger LEVELS = levelsArray[maxCompression - 2];

	public BlockStone() {
		super(Material.ROCK);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		setUnlocalizedName("compressed.");
		setRegistryName("_compressed");
		setDefaultState(blockState.getBaseState().withProperty(LEVELS, 0));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(LEVELS);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(LEVELS, meta);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{LEVELS});
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
		return 3.0F * (getMetaFromState(state) + 2);
	}

	/*@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < maxCompression; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}*/
}
