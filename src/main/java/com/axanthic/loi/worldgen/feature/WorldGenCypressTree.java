package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import com.axanthic.loi.Resources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenCypressTree extends WorldGenLOITree {

	public WorldGenCypressTree(boolean notify) {
		super(notify);
	}

	public WorldGenCypressTree init() {
		this.TRUNK = Resources.cypress.log.getBlock().getDefaultState();
		this.LEAF = Resources.cypress.leaf.getBlock().getDefaultState();
		this.WOODTYPE = Resources.cypress;
		return this;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int heightTrunk = rand.nextInt(2) + 1;
		int heightMiddle = rand.nextInt(4);
		int heightTotal = heightTrunk + heightMiddle + 4;
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

					for (int i = 0; i <= heightMiddle; ++i) {
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
					this.placeLeafAt(worldIn, down.up(height));
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
