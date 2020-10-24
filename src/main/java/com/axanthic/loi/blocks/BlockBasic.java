package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasic extends Block {

	public BlockRenderLayer renderLayer = BlockRenderLayer.SOLID;

	public BlockBasic(Material material, float hardness, String name, MapColor color) {
		super(material, color);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
	}

	@Override
	public BlockBasic setSoundType(SoundType sound) {
		super.setSoundType(sound);
		return this;
	}

	public BlockBasic setTranslucent(BlockRenderLayer layer) {
		this.translucent = true;
		this.renderLayer = layer;
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return this.renderLayer;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return !this.translucent;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return this.translucent && blockAccess.getBlockState(pos.offset(side)).equals(blockState) ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
