package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenLOITree extends WorldGenAbstractTree {

	public IBlockState TRUNK;
	public IBlockState LEAF;

	public WorldGenLOITree(boolean notify) {
		super(notify);
	}

	public abstract WorldGenLOITree init();

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int i = rand.nextInt(3) + 5;

		boolean flag = true;

		if (position.getY() >= 1 && position.getY() + i + 1 <= 256) {
			for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
				int k = 1;

				if (j == position.getY()) {
					k = 0;
				}

				if (j >= position.getY() + 1 + i - 2) {
					k = 2;
				}

				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

				for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
					for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
						if (j >= 0 && j < worldIn.getHeight()) {
							if (!this.canGrowThrough(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}
			if (!flag) {
				return false;
			} else {
				BlockPos down = position.down();
				IBlockState state = worldIn.getBlockState(down);
				boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING);

				if (isSoil && position.getY() < worldIn.getHeight() - i - 1) {
					state.getBlock().onPlantGrow(state, worldIn, down, position);

					for (int i2 = position.getY() - 3 + i; i2 <= position.getY() + i; ++i2) {
						int k2 = i2 - (position.getY() + i);
						int l2 = 1 - k2 / 2;

						for (int i3 = position.getX() - l2; i3 <= position.getX() + l2; ++i3) {
							int j1 = i3 - position.getX();

							for (int k1 = position.getZ() - l2; k1 <= position.getZ() + l2; ++k1) {
								int l1 = k1 - position.getZ();

								if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0) {
									BlockPos blockpos = new BlockPos(i3, i2, k1);
									this.placeLeafAt(worldIn, blockpos);
								}
							}
						}
					}
					for (int j2 = 0; j2 < i; ++j2) {
						BlockPos upN = position.up(j2);
						IBlockState state2 = worldIn.getBlockState(upN);

						this.placeLogAt(worldIn, upN);
					}
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

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
