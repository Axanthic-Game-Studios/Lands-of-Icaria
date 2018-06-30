package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLog extends BlockRotatedPillar {

	BlockPlanks.WoodTypes type;

	public BlockLog(BlockPlanks.WoodTypes type, MapColor color) {
		super(Material.WOOD, color);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(2.0F);
		this.type = type;
		if (type.mapColor.equals(color)) {
			this.setUnlocalizedName("log_stripped");
			this.setRegistryName(ModInformation.ID, "log_stripped_" + type.unlocalizedName);
		} else {
			this.setUnlocalizedName("log");
			this.setRegistryName(ModInformation.ID, "log_" + type.unlocalizedName);
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5)))
		{
			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4)))
			{
				IBlockState iblockstate = worldIn.getBlockState(blockpos);

				if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
				{
					iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
				}
			}
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		if (((EnumFacing.Axis)state.getValue(AXIS)).equals(EnumFacing.Axis.Y) || state.getBlock().getUnlocalizedName().equals("tile.log_stripped"))
			return type.mapColor;
		return type.logColor;
	}
}
