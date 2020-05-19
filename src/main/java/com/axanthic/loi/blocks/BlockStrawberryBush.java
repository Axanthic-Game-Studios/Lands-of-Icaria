package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.Resources;
import com.axanthic.loi.utils.EnumFood;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStrawberryBush extends BlockBush {
	private static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.2D, -0.0625D, 0.2D, 0.8D, 0.4D, 0.8D);
	
	public BlockStrawberryBush(String name) {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setSoundType(SoundType.PLANT);
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		drops.add(new ItemStack(Resources.food, 2 + rand.nextInt(3) + rand.nextInt(fortune + 1), EnumFood.STRAWBERRY.ordinal()));
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 60;
	}
	
	@Override
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XZ;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BUSH_AABB.offset(state.getOffset(source, pos));
	}
}
