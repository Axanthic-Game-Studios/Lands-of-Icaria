package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHorizontalPane extends Block {

	public static final AxisAlignedBB CEILING_PANE_AABB = new AxisAlignedBB(0.0D, 0.4375D, 0.0D, 1.0D, 0.5625D, 1.0D);
	public final boolean canDrop;

	public BlockHorizontalPane(Material material, float hardness, String name, boolean drops) {
		super(material);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
		this.canDrop = drops;
	}

	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CEILING_PANE_AABB;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return !this.canDrop ? Items.AIR : super.getItemDropped(state, rand, fortune);
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}

	protected boolean canSilkHarvest() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return face == EnumFacing.UP || face == EnumFacing.DOWN ? BlockFaceShape.UNDEFINED : BlockFaceShape.MIDDLE_POLE_THIN;
	}
}
