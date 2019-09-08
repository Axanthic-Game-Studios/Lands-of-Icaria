package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import com.axanthic.blab.Resources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenFirTree extends WorldGenLOITree {

	public WorldGenFirTree(boolean notify) {
		super(notify);
	}

	public WorldGenFirTree init() {
		this.TRUNK = Resources.fir.log.getBlock().getDefaultState();
		this.LEAF = Resources.fir.leaf.getBlock().getDefaultState();
		return this;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int heightTrunk = rand.nextInt(2) + 1;
		int heightBottom = rand.nextInt(2) + 2;
		int heightMiddle = rand.nextInt(2);
		int heightTotal = heightTrunk + heightBottom + heightMiddle + 5;
		boolean flag = true;

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
					this.placeLeafAtChance(worldIn, down.up(height).north(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west(), 2);

					for (int i = 0; i < heightBottom; ++i) {
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
					}

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
					this.placeLeafAt(worldIn, down.up(height).north().east());
					this.placeLeafAt(worldIn, down.up(height).east().south());
					this.placeLeafAt(worldIn, down.up(height).south().west());
					this.placeLeafAt(worldIn, down.up(height).west().north());

					for (int i = 0; i < heightMiddle; ++i) {
						++height;
						this.placeLogAt(worldIn, down.up(height));
						this.placeLeafAt(worldIn, down.up(height).north());
						this.placeLeafAt(worldIn, down.up(height).east());
						this.placeLeafAt(worldIn, down.up(height).south());
						this.placeLeafAt(worldIn, down.up(height).west());
						this.placeLeafAt(worldIn, down.up(height).north().east());
						this.placeLeafAt(worldIn, down.up(height).east().south());
						this.placeLeafAt(worldIn, down.up(height).south().west());
						this.placeLeafAt(worldIn, down.up(height).west().north());
					}

					++height;
					this.placeLogAt(worldIn, down.up(height));
					this.placeLeafAt(worldIn, down.up(height).north());
					this.placeLeafAt(worldIn, down.up(height).east());
					this.placeLeafAt(worldIn, down.up(height).south());
					this.placeLeafAt(worldIn, down.up(height).west());
					this.placeLeafAtChance(worldIn, down.up(height).north().east(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east().south(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south().west(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west().north(), 2);

					++height;
					this.placeLogAt(worldIn, down.up(height));
					this.placeLeafAt(worldIn, down.up(height).north());
					this.placeLeafAt(worldIn, down.up(height).east());
					this.placeLeafAt(worldIn, down.up(height).south());
					this.placeLeafAt(worldIn, down.up(height).west());

					++height;
					this.placeLeafAt(worldIn, down.up(height));
					this.placeLeafAtChance(worldIn, down.up(height).north(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).east(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).south(), 2);
					this.placeLeafAtChance(worldIn, down.up(height).west(), 2);

					++height;
					this.placeLeafAt(worldIn, down.up(height));

					++height;
					this.placeLeafAtChance(worldIn, down.up(height), 2);

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
}
