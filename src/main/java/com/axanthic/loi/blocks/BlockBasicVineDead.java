package com.axanthic.loi.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockBasicVineDead extends BlockBasicVineGrowing {

	public BlockBasicVineGrowing baseVine;

	public BlockBasicVineDead(String name, boolean damage) {
		super(name + "_dead", damage);
		this.setTickRandomly(false);
	}

	public BlockBasicVineDead(String name) {
		super(name + "_dead");
		this.setTickRandomly(false);
	}

	public BlockBasicVineGrowing setGrowingVine(ItemBlock vine) {
		BlockBasicVineGrowing growingVine = (BlockBasicVineGrowing) vine.getBlock();
		this.baseVine = growingVine;
		growingVine.deadVine = this;
		return this;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote && !this.recheckGrownSides(worldIn, pos, state)) {
			baseVine.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(StatList.getBlockStats(baseVine));
			spawnAsEntity(worldIn, pos, new ItemStack(baseVine, 1, 0));
		} else {
			baseVine.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(baseVine, 1, this.damageDropped(state));
	}
}
