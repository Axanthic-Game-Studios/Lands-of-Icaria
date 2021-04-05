package com.axanthic.loi.blocks;

import javax.annotation.Nullable;

import com.axanthic.loi.utils.IcariaSounds;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAristone extends BlockBasic {

	public BlockAristone(String name) {
		super(Material.ICE, 1.2F, name, MapColor.GREEN_STAINED_HARDENED_CLAY);
		this.setSoundType(IcariaSounds.SLICK);
		this.slipperiness = 1.06F;
	}

	@Override
	@Nullable
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockAccess.getBlockState(pos.offset(side)).getBlock().equals(this) ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
