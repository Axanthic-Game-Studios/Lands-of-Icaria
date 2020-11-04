package com.axanthic.loi.worldgen.feature;

import com.axanthic.loi.Resources.WoodSet;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenLOITree extends WorldGenAbstractTree {

	public IBlockState TRUNK;
	public IBlockState LEAF;
	public WoodSet WOODTYPE;

	public WorldGenLOITree(boolean notify) {
		super(notify);
	}

	public abstract WorldGenLOITree init();

	@Override
	public boolean isReplaceable(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		Material material = state.getMaterial();
		return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos) || material.equals(Material.VINE) || state.getBlock() instanceof BlockBush || state.getBlock().canBeReplacedByLeaves(state, world, pos) || state.getBlock().isReplaceable(world, pos);
	}

	public boolean canGrowThrough(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		Material material = state.getMaterial();
		return material.equals(Material.WOOD) || material.equals(Material.GRASS) || material.equals(Material.GROUND) || this.isReplaceable(world, pos);
	}

	public void placeLogAt(World worldIn, BlockPos pos) {
		this.placeLogAt(worldIn, pos, EnumFacing.Axis.Y);
	}

	public void placeLogAt(World worldIn, BlockPos pos, EnumFacing.Axis direction) {
		IBlockState state = worldIn.getBlockState(pos);
		if (this.isReplaceable(worldIn, pos)) {
			this.setBlockAndNotifyAdequately(worldIn, pos, TRUNK.withProperty(BlockRotatedPillar.AXIS, direction));
		}
	}

	public void placeLeafAt(World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		if (state.getBlock().isAir(state, worldIn, pos) || (state.getBlock().isLeaves(state, worldIn, pos) && worldIn.rand.nextInt(2) == 0)) {
			this.setBlockAndNotifyAdequately(worldIn, pos, LEAF);
		}
	}

	public void placeLeafAtChance(World worldIn, BlockPos pos, int chance) {
		if (worldIn.rand.nextInt(chance) == 0)
			return;
		this.placeLeafAt(worldIn, pos);
	}
}
