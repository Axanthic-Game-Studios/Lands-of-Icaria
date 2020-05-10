package com.axanthic.loi.blocks;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCustomStraightPane extends BlockCustomPane {

	public BlockCustomStraightPane(Material material, float hardness, String name, boolean drops) {
		super(material, hardness, name, drops);
	}

	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		if (placer.getHorizontalFacing().getAxis().equals(Axis.X))
			return this.getDefaultState().withProperty(NORTH, true).withProperty(SOUTH, true);
		return this.getDefaultState().withProperty(EAST, true).withProperty(WEST, true);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta == 0)
			return this.getDefaultState().withProperty(NORTH, true).withProperty(SOUTH, true);
		return this.getDefaultState().withProperty(EAST, true).withProperty(WEST, true);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (state.getValue(NORTH))
			return 0;
		return 1;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		if (rot.equals(Rotation.CLOCKWISE_90) || rot.equals(Rotation.COUNTERCLOCKWISE_90)) {
			if (state.getValue(NORTH))
				return getStateFromMeta(1);
			return getStateFromMeta(0);
		}
		return state;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		IBlockState connectedBlock = blockAccess.getBlockState(pos.offset(side));
		if (connectedBlock.getBlock() instanceof BlockPane) {
			if (blockState.getValue(NORTH))
				return !(connectedBlock.getValue(SOUTH) || connectedBlock.getValue(NORTH));
			return !(connectedBlock.getValue(EAST) || connectedBlock.getValue(WEST));
		}
		return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
