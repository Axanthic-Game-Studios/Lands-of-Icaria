package com.axanthic.loi.worldgen.dimension;

import java.util.Random;

import com.axanthic.loi.Resources;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenBase;

public class MapGenRoads extends MapGenBase {

	protected static final IBlockState BLK_ROAD = Resources.rock.getBlock().getStateFromMeta(5);
	protected static final IBlockState BLK_AIR = Blocks.AIR.getDefaultState();

	MapGenRoads() {
		this.range = 14;
	}

	protected void addRoom(long seed, int x, int z, ChunkPrimer chunkPrimer, double placeX, double placeZ, float size) {
		this.addTunnel(seed, x, z, chunkPrimer, placeX, placeZ, size, 0.0F, 0.0F, -1, -1);
	}

	protected void addTunnel(long seed, int x, int z, ChunkPrimer chunkPrimer, double placeX, double placeZ, float width, float direction, float p_180702_14_, int length, int p_180702_16_) {
		double d0 = (double)(x * 16 + 8);
		double d1 = (double)(z * 16 + 8);
		float f = 0.0F;
		float f1 = 0.0F;
		Random random = new Random(seed);

		if (p_180702_16_ <= 0) {
			int i = this.range * 16 - 16;
			p_180702_16_ = i - random.nextInt(i / 4);
		}

		boolean flag2 = false;

		if (length == -1) {
			length = p_180702_16_ / 2;
			flag2 = true;
		}

		int j = -random.nextInt(Math.abs(length) + 2) - length / 4;

		for (boolean flag = random.nextInt(6) == 0; length < p_180702_16_; ++length) {
			double d2 = 1.5D + (double)(MathHelper.sin((float)length * (float)Math.PI / (float)p_180702_16_) * width);
			float f2 = MathHelper.cos(p_180702_14_);
			float f3 = MathHelper.sin(p_180702_14_);
			placeX += (double)(MathHelper.cos(direction / 3.0F) * f2);
			//placeY += (double)f3;
			placeZ += (double)(MathHelper.sin(direction / 3.0F) * f2);

			if (flag) {
				p_180702_14_ = p_180702_14_ * 0.92F;
			} else {
				p_180702_14_ = p_180702_14_ * 0.7F;
			}

			p_180702_14_ = p_180702_14_ + f1 * 0.1F;
			direction += f * 0.1F;
			f1 = f1 * 0.9F;
			f = f * 0.75F;
			f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
			f = f + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;

			if (!flag2 && length == j && width > 1.0F && p_180702_16_ > 0 && random.nextInt(3) == 0) {
				this.addTunnel(random.nextLong(), x, z, chunkPrimer, placeX, placeZ, width, direction - ((float)Math.PI / 2F), p_180702_14_ / 3.0F, length, p_180702_16_);
				this.addTunnel(random.nextLong(), x, z, chunkPrimer, placeX, placeZ, width, direction + ((float)Math.PI / 2F), p_180702_14_ / 3.0F, length, p_180702_16_);
				return;
			}

			if (flag2 || random.nextInt(4) != 0) {
				double d4 = placeX - d0;
				double d5 = placeZ - d1;
				double d6 = (double)(p_180702_16_ - length);
				double d7 = (double)(width + 2.0F + 16.0F);

				if (d4 * d4 + d5 * d5 - d6 * d6 > d7 * d7) {
					return;
				}

				if (placeX >= d0 - 16.0D - d2 * 2.0D && placeZ >= d1 - 16.0D - d2 * 2.0D && placeX <= d0 + 16.0D + d2 * 2.0D && placeZ <= d1 + 16.0D + d2 * 2.0D) {
					int k2 = MathHelper.floor(placeX - d2) - x * 16 - 1;
					int k = MathHelper.floor(placeX + d2) - x * 16 + 1;
					//int l2 = MathHelper.floor(placeY - d3) - 1;
					//int l = (int) placeY;//MathHelper.floor(placeY + d3) + 1;
					int i3 = MathHelper.floor(placeZ - d2) - z * 16 - 1;
					int i1 = MathHelper.floor(placeZ + d2) - z * 16 + 1;

					if (k2 < 0) {
						k2 = 0;
					}

					if (k > 16) {
						k = 16;
					}

					/*if (l2 < 1)
					{
						l2 = 1;
					}

					if (l > 248)
					{
						l = 248;
					}*/

					if (i3 < 0) {
						i3 = 0;
					}

					if (i1 > 16) {
						i1 = 16;
					}

					/*for (int j1 = k2; j1 < k; ++j1) {
						for (int k1 = i3; k1 < i1; ++k1) {
							for (int l1 = l + 1; l1 >= l2 - 1; --l1) {
								if (l1 >= 0 && l1 < 256) {
									if (l1 != l2 - 1 && j1 != k2 && j1 != k - 1 && k1 != i3 && k1 != i1 - 1) {
										l1 = l2;
									}
								}
							}
						}
					}*/

					BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

					for (int j3 = k2; j3 < k; ++j3) {
						double d10 = ((double)(j3 + x * 16) + 0.5D - placeX) / d2;
						for (int i2 = i3; i2 < i1; ++i2) {
							double d8 = ((double)(i2 + z * 16) + 0.5D - placeZ) / d2;
							if (d10 * d10 + d8 * d8 < 1.0D) {
								//int j2 = (int) placeY;
								//for (int j2 = l; j2 > l2; --j2) {
								//double d9 = ((double)(j2 - 1) + 0.5D - placeY) / d3;

								//if (d9 > -0.7D && d10 * d10 + d9 * d9 + d8 * d8 < 1.0D) {
								//IBlockState iblockstate1 = chunkPrimer.getBlockState(j3, j2, i2);
								//IBlockState iblockstate2 = (IBlockState)MoreObjects.firstNonNull(chunkPrimer.getBlockState(j3, j2 + 1, i2), BLK_AIR);

								placeBlock(chunkPrimer, j3, i2, x, z);
								//}
								//}
							}
						}
					}
					if (flag2) {
						break;
					}
				}
			}
		}
	}

	/**
	 * Recursively called by generate()
	 */
	protected void recursiveGenerate(World worldIn, int chunkX, int chunkZ, int originalX, int originalZ, ChunkPrimer chunkPrimerIn) {
		int i = 0;//this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(5) + 1) + 1);

		if (chunkX % 3 == 0 && chunkZ % 3 == 0 && this.rand.nextInt(47) == 0) {
			i = 1;
		}

		for (int j = 0; j < i; ++j) {
			double startX = (double)(chunkX * 16 + this.rand.nextInt(16));
			//double d1 = 120;//(double)this.rand.nextInt(this.rand.nextInt(120) + 8);
			double startZ = (double)(chunkZ * 16 + this.rand.nextInt(16));
			//int k = 1;

			//if (this.rand.nextInt(1) == 0) {
			int k = this.rand.nextInt(2) + this.rand.nextInt(2) + 3;
			this.addRoom(this.rand.nextLong(), originalX, originalZ, chunkPrimerIn, startX, startZ, 1.0F + k);
			//}

			float directionBase = (float) Math.PI * 6.0F * this.rand.nextFloat();
			for (int l = 0; l < k; ++l) {
				float direction = directionBase + (float) Math.PI * 6.0F * (float) l / (float) k;
				float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 1.0F;
				float width = 3.0F;//this.rand.nextFloat() * 2.0F + this.rand.nextFloat();

				/*if (this.rand.nextInt(10) == 0)
				{
					width *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
				}*/

				this.addTunnel(this.rand.nextLong(), originalX, originalZ, chunkPrimerIn, startX, startZ, width, direction, f1, -200, 1);
			}
		}
	}

	protected void placeBlock(ChunkPrimer data, int x, int z, int chunkX, int chunkZ) {
		for (int y = 108; y >= 88; --y) {
			if (data.getBlockState(x, y, z).isTopSolid()) {
				if(data.getBlockState(x, y, z).getBlock() != Resources.rock.getBlock()) {
					data.setBlockState(x, y, z, BLK_ROAD);
					if (data.getBlockState(x, y + 1, z).getBlock() != Blocks.AIR)
						data.setBlockState(x, y + 1, z, BLK_AIR);
				}
				break;
			}
		}
	}
}