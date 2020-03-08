package com.axanthic.loi.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockMobHeadHag extends BlockMobHead {

	protected static final AxisAlignedBB DEFAULT_AABB = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.5D, 0.6875D);
	protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.3125D, 0.25D, 0.625D, 0.6875D, 0.75D, 1.0D);
	protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.3125D, 0.25D, 0.0D, 0.6875D, 0.75D, 0.375D);
	protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.625D, 0.25D, 0.3125D, 1.0D, 0.75D, 0.6875D);
	protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.25D, 0.3125D, 0.375D, 0.75D, 0.6875D);

	public BlockMobHeadHag(String mobName) {
		super(mobName);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch ((EnumFacing)state.getValue(FACING)) {
		case UP:
		default:
			return DEFAULT_AABB;
		case NORTH:
			return NORTH_AABB;
		case SOUTH:
			return SOUTH_AABB;
		case WEST:
			return WEST_AABB;
		case EAST:
			return EAST_AABB;
		}
	}
}
