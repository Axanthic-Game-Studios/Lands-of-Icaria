package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockCardonCactus;
import com.axanthic.blab.blocks.BlockTallGrass;
import com.axanthic.loi.worldgen.dimension.OreGeneratorLOI;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class LOIBiomeDecorator extends BiomeDecorator {

	public boolean generateBoulders = false;
	public boolean generateFerns = false;

	public OreGeneratorLOI oreGen = new OreGeneratorLOI();

	@Override
	public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
		if (this.decorating) {
			throw new RuntimeException("Already decorating");
		} else {
			this.chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(worldIn.getWorldInfo().getGeneratorOptions()).build();
			this.chunkPos = pos;

			ChunkPos forgeChunkPos = new ChunkPos(chunkPos); // actual ChunkPos instead of BlockPos, used for events
			MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldIn, random, forgeChunkPos));

			//flower and herb generation
			for (int l2 = 0; l2 < this.flowersPerChunk; ++l2) {
				int i7 = random.nextInt(16) + 8;
				int l10 = random.nextInt(16) + 8;
				int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

				if (j14 > 0) {
					int k17 = random.nextInt(j14);
					BlockPos blockpos1 = this.chunkPos.add(i7, k17, l10);

					for (int i = 0; i < 64; ++i) {
						BlockPos blockpos = blockpos1.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
						if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255))
							biome.plantFlower(worldIn, random, blockpos);
					}
				}
			}

			//tall grass generation
			for (int i3 = 0; i3 < this.grassPerChunk; ++i3) {
				int j7 = random.nextInt(16) + 8;
				int i11 = random.nextInt(16) + 8;
				int k14 = worldIn.getHeight(this.chunkPos.add(j7, 0, i11)).getY() * 2;

				if (k14 > 0) {
					int l17 = random.nextInt(k14);

					BlockPos position = this.chunkPos.add(j7, l17, i11);

					for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position)) {
						position = position.down();
					}

					for (int i = 0; i < 128; ++i) {
						BlockPos blockpos = position.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
						IBlockState iblockstate2 = Resources.tallGrass.getBlock().getStateFromMeta(random.nextInt(BlockTallGrass.GrassTypes.values().length - (generateFerns ? 0 : 1)));

						if (worldIn.isAirBlock(blockpos) && ((BlockTallGrass) Resources.tallGrass.getBlock()).canBlockStay(worldIn, blockpos, iblockstate2)) {
							worldIn.setBlockState(blockpos, iblockstate2, 2);
						}
					}
				}
			}

			//yellowstone boulder generation
			if (generateBoulders) {
				int e = random.nextInt(5) - 3;

				for (int a = 0; a < e; ++a) {
					int g = random.nextInt(16) + 8;
					int h = random.nextInt(16) + 8;
					BlockPos position = worldIn.getHeight(pos.add(g, 0, h));

					while (true) {
						label50: {
						if (position.getY() > 3) {
							if (worldIn.isAirBlock(position.down())) {
								break label50;
							}
						}
						if (position.getY() <= 3) {
							break;
						}
						int i1 = 2;

						for (int i = 0; i1 >= 0 && i < 3; ++i) {
							int j = i1 + random.nextInt(4);
							int k = i1 + random.nextInt(4);
							int l = i1 + random.nextInt(4);
							float f = (float)(j + k + l) * 0.333F + 0.5F;

							for (BlockPos blockpos : BlockPos.getAllInBox(position.add(-j, -k, -l), position.add(j, k, l))) {
								if (blockpos.distanceSq(position) <= (double)(f * f)) {
									worldIn.setBlockState(blockpos, Resources.rock.getBlock().getStateFromMeta(0), 4);
								}
							}
							position = position.add(-(i1 + 1) + random.nextInt(2 + i1 * 2), 0 - random.nextInt(2), -(i1 + 1) + random.nextInt(2 + i1 * 2));
						}
						break;
					}
					position = position.down();
					}
				}
			}

			//cactus generation
			for (int j5 = 0; j5 < this.cactiPerChunk; ++j5) {
				int l9 = random.nextInt(16) + 8;
				int k13 = random.nextInt(16) + 8;
				int l16 = worldIn.getHeight(this.chunkPos.add(l9, 0, k13)).getY() * 2;

				if (l16 > 0) {
					int j19 = random.nextInt(l16);

					BlockPos position = this.chunkPos.add(l9, j19, k13);

					for (int i = 0; i < 10; ++i) {
						BlockPos blockpos = position.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
						
						if (worldIn.isAirBlock(blockpos) && !worldIn.isAirBlock(blockpos.down()) && !(worldIn.getBlockState(blockpos.down()).getBlock() instanceof BlockCardonCactus) && ((BlockCardonCactus) Resources.cardon.getBlock()).canSurviveAt(worldIn, blockpos)) {
							int level = 0;
							while (true) {
								if (level > 4)
									break;
								if (level == 1 || level == 2) {
									for (EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
										if (random.nextInt(4) == 0 && worldIn.isAirBlock(blockpos.up(level).offset(facing))) {
											growCactus(worldIn, blockpos.up(level).offset(facing));
											growCactus(worldIn, blockpos.up(level + 1).offset(facing));
											continue;
										}
									}
								}
								growCactus(worldIn, blockpos.up(level));
								++level;
							}
							continue;
						}
					}
				}
			}

			oreGen.generate(random, forgeChunkPos.x, forgeChunkPos.z, worldIn, null, worldIn.getChunkProvider());

			this.decorating = false;
		}
	}

	public static void growCactus(World worldIn, BlockPos blockpos) {
		if (worldIn.isAirBlock(blockpos)) {
			worldIn.setBlockState(blockpos, Resources.cardon.getBlock().getDefaultState(), 2);
		}
	}
}
