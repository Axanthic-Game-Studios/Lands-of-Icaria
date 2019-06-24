package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import com.axanthic.blab.Resources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenDroughtrootTree extends WorldGenLOITree {

	public WorldGenDroughtrootTree(boolean notify) {
		super(notify);
	}

	public WorldGenDroughtrootTree init() {
		this.TRUNK = Resources.droughtroot.log.getBlock().getDefaultState();
		this.LEAF = Resources.droughtroot.leaf.getBlock().getDefaultState();
		return this;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int heightTrunk = rand.nextInt(2) + 2;
		int heightLayer1 = rand.nextInt(3) + 1;
		int heightLayer2 = rand.nextInt(3) + 1;
		int heightLayer3 = rand.nextInt(3) + 1;
		int heightTotal = heightTrunk + heightLayer1 + heightLayer2 + heightLayer3 + 1;
		EnumFacing direction = EnumFacing.getHorizontal(rand.nextInt(EnumFacing.HORIZONTALS.length));
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
					for (int layer1Level = 1; layer1Level <= heightLayer1; ++layer1Level) {
						int height = heightTrunk + layer1Level;
						direction = direction.getOpposite();
						this.placeLogAt(worldIn, down.up(height));
						this.placeLogAt(worldIn, down.up(height).offset(direction), direction.getAxis());
						this.placeLeafAt(worldIn, down.up(height - 1).offset(direction));
						this.placeLeafAt(worldIn, down.up(height).offset(direction.rotateY()));
						this.placeLeafAt(worldIn, down.up(height).offset(direction.rotateYCCW()));
						this.placeLeafAt(worldIn, down.up(height).offset(direction.rotateY()).offset(direction));
						this.placeLeafAt(worldIn, down.up(height).offset(direction.rotateYCCW()).offset(direction));
						this.placeLeafAt(worldIn, down.up(height).offset(direction, 2));
					}
					for (int layer2Level = 1; layer2Level <= heightLayer2; ++layer2Level) {
						int height = heightTrunk + heightLayer1 + layer2Level;
						direction = direction.getOpposite();
						this.placeLogAt(worldIn, down.up(height));
						this.placeLeafAt(worldIn, down.up(height).offset(direction));
						this.placeLeafAt(worldIn, down.up(height).offset(direction.rotateY()));
						this.placeLeafAt(worldIn, down.up(height).offset(direction.rotateYCCW()));
					}
					for (int layer3Level = 1; layer3Level <= heightLayer3; ++layer3Level) {
						int height = heightTrunk + heightLayer1 + heightLayer2 + layer3Level;
						direction = direction.getOpposite();
						this.placeLeafAt(worldIn, down.up(height));
						this.placeLeafAt(worldIn, down.up(height).offset(direction));
					}
					this.placeLeafAt(worldIn, down.up(heightTotal));

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
