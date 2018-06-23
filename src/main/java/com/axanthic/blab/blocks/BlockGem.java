package com.axanthic.blab.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGem extends BlockSixDirectional {

	private String unlocalizedName;
	public static final AxisAlignedBB NOTHING_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

	public BlockGem(String name) {
		super(Material.GLASS, MapColor.AIR);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		this.fullBlock = false;
		this.setLightOpacity(0);
		this.setUnlocalizedName(name);
		unlocalizedName = name;
		this.setRegistryName(ModInformation.ID, name);
	}

	@Override
	public String getUnlocalizedName() {
		return "material." + unlocalizedName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return NOTHING_AABB;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.resource;
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (unlocalizedName.equals("jasper")) {
			return 8;
		} else if (unlocalizedName.equals("zircon")) {
			return 7;
		} else {
			return 6;
		}
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		for (EnumFacing enumfacing : FACING.getAllowedValues()) {
			if (this.canPlaceAt(worldIn, pos, enumfacing)) {
				return true;
			}
		}
		return false;
	}

	public boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing) {
		BlockPos blockpos = pos.offset(facing.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		Block block = iblockstate.getBlock();
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, blockpos, facing);

		return !isExceptBlockForAttachWithPiston(block) && blockfaceshape == BlockFaceShape.SOLID;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.checkForDrop(worldIn, pos, state);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!this.checkForDrop(worldIn, pos, state))
			return;
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		EnumFacing.Axis enumfacing$axis = enumfacing.getAxis();
		EnumFacing enumfacing1 = enumfacing.getOpposite();
		BlockPos blockpos = pos.offset(enumfacing1);
		boolean flag = false;

		if (enumfacing$axis.isHorizontal() && worldIn.getBlockState(blockpos).getBlockFaceShape(worldIn, blockpos, enumfacing) != BlockFaceShape.SOLID) {
			flag = true;
		} else if (enumfacing$axis.isVertical() && !this.canPlaceAt(worldIn, blockpos, enumfacing1)) {
			flag = true;
		}
		if (flag) {
			worldIn.destroyBlock(pos, true);
		}
	}

	public boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state) {
		if (state.getBlock() == this && this.canPlaceAt(worldIn, pos, (EnumFacing)state.getValue(FACING))) {
			return true;
		}
		if (worldIn.getBlockState(pos).getBlock() == this) {
			worldIn.destroyBlock(pos, true);
		}
		return false;
	}
}
