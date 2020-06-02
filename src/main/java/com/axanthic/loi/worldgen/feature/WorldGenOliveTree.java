package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import com.axanthic.loi.Resources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenOliveTree extends WorldGenLOITree {

	public IBlockState LEAF_GREEN;
	public IBlockState LEAF_BLACK;
	public boolean color = false;

	public WorldGenOliveTree(boolean notify) {
		super(notify);
	}

	public WorldGenOliveTree init() {
		this.TRUNK = Resources.olive.log.getBlock().getDefaultState();
		this.LEAF = Resources.olive.leaf.getBlock().getDefaultState();
		this.LEAF_GREEN = Resources.oliveLeaves.getBlock().getDefaultState();
		this.LEAF_BLACK = Resources.oliveLeaves.getBlock().getStateFromMeta(1);
		return this;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int heightTrunk = rand.nextInt(3) + 2;
		int heightTotal = heightTrunk + 4;
		EnumFacing offset = EnumFacing.getHorizontal(rand.nextInt(EnumFacing.HORIZONTALS.length));
		boolean flag = true;
		color = rand.nextBoolean();

		if (position.getY() >= 1 && position.getY() + heightTotal + 1 <= 256) {
			for (int j = position.getY(); j <= position.getY() + 1 + heightTotal; ++j) {
				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
				if (j >= 0 && j < worldIn.getHeight()) {
					if (!this.canGrowThrough(worldIn, blockpos$mutableblockpos.setPos(position.getX(), j, position.getZ()))) {
						flag = false;
					}
				} else {
					flag = false;
				}
			}
			if (!flag) {
				return false;
			} else {
				BlockPos down = position.down();
				IBlockState state = worldIn.getBlockState(down);
				boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING);

				if (isSoil && position.getY() < worldIn.getHeight() - heightTotal - 1) {
					state.getBlock().onPlantGrow(state, worldIn, down, position);

					for (int trunkLevel = 1; trunkLevel <= heightTrunk; ++trunkLevel) {
						this.placeLogAt(worldIn, down.up(trunkLevel));
					}
					int height = heightTrunk + 1;
					this.placeLogAt(worldIn, down.up(height));
					this.placeLeafAt(worldIn, down.up(height).north());
					this.placeLeafAt(worldIn, down.up(height).east());
					this.placeLeafAt(worldIn, down.up(height).south());
					this.placeLeafAt(worldIn, down.up(height).west());
					this.placeLeafAt(worldIn, down.up(height).north(2));
					this.placeLeafAt(worldIn, down.up(height).east(2));
					this.placeLeafAt(worldIn, down.up(height).south(2));
					this.placeLeafAt(worldIn, down.up(height).west(2));
					this.placeLeafAt(worldIn, down.up(height).north().east());
					this.placeLeafAt(worldIn, down.up(height).east().south());
					this.placeLeafAt(worldIn, down.up(height).south().west());
					this.placeLeafAt(worldIn, down.up(height).west().north());
					this.placeLeafAtChance(worldIn, down.up(height).north(2).east(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east(2).south(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south(2).west(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west(2).north(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).north(2).west(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east(2).north(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south(2).east(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west(2).south(), 2);

					++height;
					this.placeLogAt(worldIn, down.up(height));
					this.placeLeafAt(worldIn, down.up(height).north());
					this.placeLeafAt(worldIn, down.up(height).east());
					this.placeLeafAt(worldIn, down.up(height).south());
					this.placeLeafAt(worldIn, down.up(height).west());
					this.placeLeafAt(worldIn, down.up(height).north(2));
					this.placeLeafAt(worldIn, down.up(height).east(2));
					this.placeLeafAt(worldIn, down.up(height).south(2));
					this.placeLeafAt(worldIn, down.up(height).west(2));
					this.placeLeafAt(worldIn, down.up(height).north(3));
					this.placeLeafAt(worldIn, down.up(height).east(3));
					this.placeLeafAt(worldIn, down.up(height).south(3));
					this.placeLeafAt(worldIn, down.up(height).west(3));
					this.placeLeafAt(worldIn, down.up(height).north().east());
					this.placeLeafAt(worldIn, down.up(height).east().south());
					this.placeLeafAt(worldIn, down.up(height).south().west());
					this.placeLeafAt(worldIn, down.up(height).west().north());
					this.placeLeafAt(worldIn, down.up(height).north(2).east());
					this.placeLeafAt(worldIn, down.up(height).east(2).south());
					this.placeLeafAt(worldIn, down.up(height).south(2).west());
					this.placeLeafAt(worldIn, down.up(height).west(2).north());
					this.placeLeafAt(worldIn, down.up(height).north(2).west());
					this.placeLeafAt(worldIn, down.up(height).east(2).north());
					this.placeLeafAt(worldIn, down.up(height).south(2).east());
					this.placeLeafAt(worldIn, down.up(height).west(2).south());
					this.placeLeafAtChance(worldIn, down.up(height).north(3).east(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east(3).south(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south(3).west(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west(3).north(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).north(3).west(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east(3).north(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south(3).east(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west(3).south(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).north(2).west(2), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east(2).north(2), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south(2).east(2), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west(2).south(2), 2);

					BlockPos offPos = down.offset(offset);

					++height;
					this.placeLogAt(worldIn, offPos.up(height));
					this.placeLeafAt(worldIn, offPos.up(height).north());
					this.placeLeafAt(worldIn, offPos.up(height).east());
					this.placeLeafAt(worldIn, offPos.up(height).south());
					this.placeLeafAt(worldIn, offPos.up(height).west());
					this.placeLeafAt(worldIn, offPos.up(height).north(2));
					this.placeLeafAt(worldIn, offPos.up(height).east(2));
					this.placeLeafAt(worldIn, offPos.up(height).south(2));
					this.placeLeafAt(worldIn, offPos.up(height).west(2));
					this.placeLeafAt(worldIn, offPos.up(height).north(3));
					this.placeLeafAt(worldIn, offPos.up(height).east(3));
					this.placeLeafAt(worldIn, offPos.up(height).south(3));
					this.placeLeafAt(worldIn, offPos.up(height).west(3));
					this.placeLeafAt(worldIn, offPos.up(height).north().east());
					this.placeLeafAt(worldIn, offPos.up(height).east().south());
					this.placeLeafAt(worldIn, offPos.up(height).south().west());
					this.placeLeafAt(worldIn, offPos.up(height).west().north());
					this.placeLeafAt(worldIn, offPos.up(height).north(2).east());
					this.placeLeafAt(worldIn, offPos.up(height).east(2).south());
					this.placeLeafAt(worldIn, offPos.up(height).south(2).west());
					this.placeLeafAt(worldIn, offPos.up(height).west(2).north());
					this.placeLeafAt(worldIn, offPos.up(height).north(2).west());
					this.placeLeafAt(worldIn, offPos.up(height).east(2).north());
					this.placeLeafAt(worldIn, offPos.up(height).south(2).east());
					this.placeLeafAt(worldIn, offPos.up(height).west(2).south());
					this.placeLeafAt(worldIn, offPos.up(height).north(3).east());
					this.placeLeafAt(worldIn, offPos.up(height).east(3).south());
					this.placeLeafAt(worldIn, offPos.up(height).south(3).west());
					this.placeLeafAt(worldIn, offPos.up(height).west(3).north());
					this.placeLeafAt(worldIn, offPos.up(height).north(3).west());
					this.placeLeafAt(worldIn, offPos.up(height).east(3).north());
					this.placeLeafAt(worldIn, offPos.up(height).south(3).east());
					this.placeLeafAt(worldIn, offPos.up(height).west(3).south());
					this.placeLeafAt(worldIn, offPos.up(height).north(2).west(2));
					this.placeLeafAt(worldIn, offPos.up(height).east(2).north(2));
					this.placeLeafAt(worldIn, offPos.up(height).south(2).east(2));
					this.placeLeafAt(worldIn, offPos.up(height).west(2).south(2));

					++height;
					this.placeLogAt(worldIn, offPos.up(height));
					this.placeLeafAt(worldIn, offPos.up(height).north());
					this.placeLeafAt(worldIn, offPos.up(height).east());
					this.placeLeafAt(worldIn, offPos.up(height).south());
					this.placeLeafAt(worldIn, offPos.up(height).west());
					this.placeLeafAt(worldIn, offPos.up(height).north(2));
					this.placeLeafAt(worldIn, offPos.up(height).east(2));
					this.placeLeafAt(worldIn, offPos.up(height).south(2));
					this.placeLeafAt(worldIn, offPos.up(height).west(2));
					this.placeLeafAt(worldIn, offPos.up(height).north(3));
					this.placeLeafAt(worldIn, offPos.up(height).east(3));
					this.placeLeafAt(worldIn, offPos.up(height).south(3));
					this.placeLeafAt(worldIn, offPos.up(height).west(3));
					this.placeLeafAt(worldIn, offPos.up(height).north().east());
					this.placeLeafAt(worldIn, offPos.up(height).east().south());
					this.placeLeafAt(worldIn, offPos.up(height).south().west());
					this.placeLeafAt(worldIn, offPos.up(height).west().north());
					this.placeLeafAt(worldIn, offPos.up(height).north(2).east());
					this.placeLeafAt(worldIn, offPos.up(height).east(2).south());
					this.placeLeafAt(worldIn, offPos.up(height).south(2).west());
					this.placeLeafAt(worldIn, offPos.up(height).west(2).north());
					this.placeLeafAt(worldIn, offPos.up(height).north(2).west());
					this.placeLeafAt(worldIn, offPos.up(height).east(2).north());
					this.placeLeafAt(worldIn, offPos.up(height).south(2).east());
					this.placeLeafAt(worldIn, offPos.up(height).west(2).south());
					this.placeLeafAtChance(worldIn, offPos.up(height).north(3).east(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).east(3).south(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).south(3).west(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).west(3).north(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).north(3).west(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).east(3).north(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).south(3).east(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).west(3).south(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).north(2).west(2), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).east(2).north(2), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).south(2).east(2), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).west(2).south(2), 2);

					++height;
					this.placeLeafAt(worldIn, offPos.up(height));
					this.placeLeafAt(worldIn, offPos.up(height).north());
					this.placeLeafAt(worldIn, offPos.up(height).east());
					this.placeLeafAt(worldIn, offPos.up(height).south());
					this.placeLeafAt(worldIn, offPos.up(height).west());
					this.placeLeafAt(worldIn, offPos.up(height).north(2));
					this.placeLeafAt(worldIn, offPos.up(height).east(2));
					this.placeLeafAt(worldIn, offPos.up(height).south(2));
					this.placeLeafAt(worldIn, offPos.up(height).west(2));
					this.placeLeafAt(worldIn, offPos.up(height).north().east());
					this.placeLeafAt(worldIn, offPos.up(height).east().south());
					this.placeLeafAt(worldIn, offPos.up(height).south().west());
					this.placeLeafAt(worldIn, offPos.up(height).west().north());
					this.placeLeafAtChance(worldIn, offPos.up(height).north(2).east(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).east(2).south(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).south(2).west(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).west(2).north(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).north(2).west(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).east(2).north(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).south(2).east(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).west(2).south(), 2);

					++height;
					this.placeLeafAt(worldIn, offPos.up(height));
					this.placeLeafAtChance(worldIn, offPos.up(height).north(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).east(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).south(), 2);
					this.placeLeafAtChance(worldIn, offPos.up(height).west(), 2);

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
	public void placeLeafAt(World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		if (state.getBlock().isAir(state, worldIn, pos) || (state.getBlock().isLeaves(state, worldIn, pos) && worldIn.rand.nextInt(2) == 0)) {
			if (worldIn.rand.nextInt(10) == 0) {
				if (color)
					this.setBlockAndNotifyAdequately(worldIn, pos, LEAF_GREEN);
				else
					this.setBlockAndNotifyAdequately(worldIn, pos, LEAF_BLACK);
			} else
				this.setBlockAndNotifyAdequately(worldIn, pos, LEAF);
		}
	}
}
