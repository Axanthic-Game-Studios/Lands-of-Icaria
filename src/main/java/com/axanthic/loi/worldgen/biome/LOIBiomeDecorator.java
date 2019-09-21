package com.axanthic.loi.worldgen.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockCardonCactus;
import com.axanthic.blab.blocks.BlockGem;
import com.axanthic.blab.blocks.BlockRock;
import com.axanthic.blab.blocks.BlockTallGrass;
import com.axanthic.loi.worldgen.dimension.OreGeneratorLOI;
import com.axanthic.loi.worldgen.feature.WorldGenLOITree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class LOIBiomeDecorator extends BiomeDecorator {

	public boolean generateBoulders = false;
	public boolean generateSpikes = false;
	public boolean generateFerns = false;
	public int extraTreeAmount = 1;
	public List<WorldGenLOITree> treeGenerators = new ArrayList<WorldGenLOITree>();
	public IBlockState[] vines = new IBlockState[] {
			Resources.vineBloomy.getBlock().getDefaultState(),
			Resources.vineBranch.getBlock().getDefaultState(),
			Resources.vineBrushy.getBlock().getDefaultState(),
			Resources.vineDry.getBlock().getDefaultState(),
			Resources.vineReedy.getBlock().getDefaultState(),
			Resources.vineSwirly.getBlock().getDefaultState(),
			Resources.vineThorny.getBlock().getDefaultState()
	};

	public OreGeneratorLOI oreGen = new OreGeneratorLOI();

	@Override
	public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
		if (this.decorating) {
			throw new RuntimeException("Already decorating");
		} else {
			this.chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(worldIn.getWorldInfo().getGeneratorOptions()).build();
			this.chunkPos = pos;

			ChunkPos forgeChunkPos = new ChunkPos(chunkPos); // actual ChunkPos instead of BlockPos
			MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldIn, random, forgeChunkPos));

			this.generateAristone(worldIn, random, biome, pos);
			this.generateBoulders(worldIn, random, biome, pos);
			this.generateSpikes(worldIn, random, biome, pos);
			this.generateFlowers(worldIn, random, biome, pos);
			this.generateGrass(worldIn, random, biome, pos);
			this.generateCactus(worldIn, random, biome, pos);
			this.generateTrees(worldIn, random, biome, pos);
			this.generateVines(worldIn, random, biome, pos);
			this.generateCrystals(worldIn, random, biome, pos);
			oreGen.generate(random, forgeChunkPos.x, forgeChunkPos.z, worldIn, null, worldIn.getChunkProvider());

			this.decorating = false;
		}
	}

	public void generateFlowers(World worldIn, Random random, Biome biome, BlockPos pos) {
		for (int l2 = 0; l2 < this.flowersPerChunk; ++l2) {
			int i7 = random.nextInt(16) + 8;
			int l10 = random.nextInt(16) + 8;
			int j14 = worldIn.getHeight(pos.add(i7, 0, l10)).getY() + 32;

			if (j14 > 0) {
				int k17 = random.nextInt(j14);
				BlockPos blockpos1 = pos.add(i7, k17, l10);

				for (int i = 0; i < 64; ++i) {
					BlockPos blockpos = blockpos1.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
					if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255))
						biome.plantFlower(worldIn, random, blockpos);
				}
			}
		}
	}

	public void generateGrass(World worldIn, Random random, Biome biome, BlockPos pos) {
		for (int i3 = 0; i3 < this.grassPerChunk; ++i3) {
			int j7 = random.nextInt(16) + 8;
			int i11 = random.nextInt(16) + 8;
			int k14 = worldIn.getHeight(pos.add(j7, 0, i11)).getY() * 2;

			if (k14 > 0) {
				int l17 = random.nextInt(k14);

				BlockPos position = pos.add(j7, l17, i11);

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
	}

	public void generateAristone(World worldIn, Random random, Biome biome, BlockPos pos) {
		int e = random.nextInt(5) + 4;

		for (int a = 0; a < e; ++a) {
			int g = random.nextInt(14) + 10;
			int h = random.nextInt(14) + 10;
			BlockPos position = worldIn.getHeight(pos.add(g, 0, h));
			BlockPos positionBase = new BlockPos(position);
			EnumFacing facing = EnumFacing.Plane.HORIZONTAL.random(random);

			while (true) {
				label50: {
				if (position.getY() > 3) {
					if (worldIn.isAirBlock(position.offset(facing)) || !worldIn.isAirBlock(position) || !worldIn.getBlockState(position.offset(facing)).getMaterial().equals(Material.ROCK)) {
						break label50;
					}
				}
				if (position.getY() <= 3) {
					break;
				}
				int i1 = 4;

				for (int i = 0; i1 >= 0 && i < 3; ++i) {
					int j = i1 + random.nextInt(4);
					float f = (float)j * 3 * 0.333F + 0.5F;

					for (BlockPos blockpos : BlockPos.getAllInBox(position.add(-j, 2, -j), position.add(j, random.nextInt(2) + 2, j))) {
						if (worldIn.isAirBlock(blockpos) || worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos))
							if (blockpos.distanceSq(position) <= (double)(f * f) - 2) {
								worldIn.setBlockState(blockpos, Resources.aristone.getBlock().getDefaultState(), 4);
							} else if (blockpos.distanceSq(position) <= (double)(f * f) - 1 && (random.nextBoolean() || random.nextBoolean())) {
								worldIn.setBlockState(blockpos, Resources.aristone.getBlock().getDefaultState(), 4);
							} else if (blockpos.distanceSq(position) <= (double)(f * f) && random.nextBoolean()) {
								worldIn.setBlockState(blockpos, Resources.aristone.getBlock().getDefaultState(), 4);
							}
					}
					position = position.add(-(i1 + 1) + random.nextInt(2 + i1 * 2), 0 - random.nextInt(2), -(i1 + 1) + random.nextInt(2 + i1 * 2));
					if (positionBase.getDistance(position.getX(), position.getY(), position.getZ()) > 6)
						break;
				}
				break;
			}
			position = position.down();
			}
		}
	}

	public void generateBoulders(World worldIn, Random random, Biome biome, BlockPos pos) {
		if (generateBoulders) {
			int e = random.nextInt(6) - 3;

			for (int a = 0; a < e; ++a) {
				int g = random.nextInt(14) + 10;
				int h = random.nextInt(14) + 10;
				BlockPos position = worldIn.getHeight(pos.add(g, 0, h));
				BlockPos positionBase = new BlockPos(position);

				while (true) {
					label50: {
					if (position.getY() > 3) {
						if (worldIn.isAirBlock(position.down()) || (!worldIn.getBlockState(position.down()).getMaterial().equals(Material.GRASS) && !worldIn.getBlockState(position.down()).getMaterial().equals(Material.GROUND)) || !worldIn.getBlockState(position.down(2)).getMaterial().equals(Material.GROUND) || !worldIn.getBlockState(position.down(3)).getMaterial().equals(Material.GROUND) || !worldIn.getBlockState(position.down(4)).getMaterial().equals(Material.GROUND)) {
							break label50;
						}
					}
					if (position.getY() <= 3)
						break;

					if (random.nextInt(3) != 0)
						break label50;

					int baseSize = 1;

					for (int i = 0; baseSize >= 0 && i < 16; ++i) {
						int j = baseSize + random.nextInt(2);
						float f = (float)j * 3 * 0.333F + 0.5F;

						for (BlockPos blockpos : BlockPos.getAllInBox(position.add(-j, -j, -j), position.add(j, j, j))) {
							if (blockpos.getY() < positionBase.getY() - 2 || (blockpos.getY() < positionBase.getY() - 1 && !random.nextBoolean()))
								continue;

							if (blockpos.distanceSq(position) <= (double)(f * f) - 1) {
								worldIn.setBlockState(blockpos, Resources.rock.getBlock().getDefaultState(), 4);
							} else if (blockpos.distanceSq(position) <= (double)(f * f) && random.nextBoolean()) {
								worldIn.setBlockState(blockpos, Resources.rock.getBlock().getDefaultState(), 4);
							}
						}
						position = position.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
						if (position.getY() <= positionBase.getY() && random.nextBoolean())
							position = position.up();
						if (position.getY() >= positionBase.getY() && random.nextBoolean())
							position = position.down();

						if (positionBase.getDistance(position.getX(), position.getY(), position.getZ()) > 6)
							break;
					}
					break;
				}
				position = position.down();
				}
			}
		}
	}

	public void generateSpikes(World worldIn, Random rand, Biome biome, BlockPos pos) {
		if (generateSpikes) {
			int e = rand.nextInt(4) - 2;

			for (int a = 0; a < e; ++a) {
				int g = rand.nextInt(14) + 10;
				int h = rand.nextInt(14) + 10;
				BlockPos position = worldIn.getHeight(pos.add(g, 0, h));
				int minY = position.getY() - 1;

				while (worldIn.isAirBlock(position) && position.getY() > 2) {
					position = position.down();
				}

				if (!worldIn.getBlockState(position).getMaterial().equals(Material.SAND) || !worldIn.getBlockState(position.down()).getMaterial().equals(Material.SAND) || !worldIn.getBlockState(position.down(2)).getMaterial().equals(Material.SAND) || !worldIn.getBlockState(position.down(3)).getMaterial().equals(Material.SAND)) {
					return;
				} else {
					position = position.up(rand.nextInt(4));
					int i = rand.nextInt(4) + 7;
					int j = i / 4 + rand.nextInt(2);

					for (int k = 0; k < i; ++k) {
						float f = (1.0F - (float)k / (float)i) * (float)j;
						int l = MathHelper.ceil(f);

						for (int i1 = -l; i1 <= l; ++i1) {
							float f1 = (float)MathHelper.abs(i1) - 0.25F;

							for (int j1 = -l; j1 <= l; ++j1) {
								float f2 = (float)MathHelper.abs(j1) - 0.25F;

								if ((i1 == 0 && j1 == 0 || f1 * f1 + f2 * f2 <= f * f) && (i1 != -l && i1 != l && j1 != -l && j1 != l || rand.nextFloat() <= 0.75F)) {
									if (position.add(i1, k, j1).getY() >= minY)
										worldIn.setBlockState(position.add(i1, k, j1), Resources.grainelStone.getBlock().getDefaultState(), 4);

									if (k != 0 && l > 1 && position.add(i1, -k, j1).getY() >= minY) {
										worldIn.setBlockState(position.add(i1, -k, j1), Resources.grainelStone.getBlock().getDefaultState(), 4);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void generateCactus(World worldIn, Random random, Biome biome, BlockPos pos) {
		for (int j5 = 0; j5 < this.cactiPerChunk; ++j5) {
			int l9 = random.nextInt(16) + 8;
			int k13 = random.nextInt(16) + 8;
			int l16 = worldIn.getHeight(pos.add(l9, 0, k13)).getY() * 2;

			if (l16 > 0) {
				int j19 = random.nextInt(l16);

				BlockPos position = pos.add(l9, j19, k13);

				for (int i = 0; i < 10; ++i) {
					BlockPos blockpos = position.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

					if (worldIn.isAirBlock(blockpos) && !worldIn.isAirBlock(blockpos.down()) && !(worldIn.getBlockState(blockpos.down()).getBlock() instanceof BlockCardonCactus) && ((BlockCardonCactus) Resources.cardon.getBlock()).canSurviveAt(worldIn, blockpos)) {
						int level = 0;
						while (true) {
							if (level > 4)
								break;
							if (level == 1 || level == 2) {
								for (EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
									if (random.nextInt(4) == 0 && worldIn.isAirBlock(blockpos.up(level).offset(facing)) && worldIn.isAirBlock(blockpos.up(level - 1).offset(facing))) {
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
	}

	public void generateTrees(World worldIn, Random random, Biome biome, BlockPos pos) {
		int k1 = this.treesPerChunk;
		if (random.nextFloat() < this.extraTreeChance) {
			k1 += extraTreeAmount;
		}
		for (int j2 = 0; j2 < k1; ++j2) {
			int k6 = random.nextInt(14) + 10;
			int l = random.nextInt(14) + 10;
			WorldGenLOITree generator = treeGenerators.get(random.nextInt(treeGenerators.size()));
			generator.setDecorationDefaults();
			BlockPos.MutableBlockPos mut = new BlockPos.MutableBlockPos(pos.add(k6, 3, l));
			while (random.nextInt(3) != 0) {
				if (mut.getY() > 150)
					return;
				mut.move(EnumFacing.UP);
				while (!(!worldIn.isBlockFullCube(mut.up()) && worldIn.isBlockFullCube(mut))) {
					if (mut.getY() > 150)
						return;
					mut.move(EnumFacing.UP);
				}
			}
			if (!generator.generate(worldIn, random, mut))
				if (!generator.generate(worldIn, random, mut))
					if (!generator.generate(worldIn, random, mut))
						generator.generate(worldIn, random, mut); //just keep trying lol
		}
	}

	public void generateVines(World worldIn, Random random, Biome biome, BlockPos pos) {
		for (int j5 = 0; j5 < 40; ++j5) {
			int l9 = random.nextInt(14) + 10;
			int k13 = random.nextInt(14) + 10;
			int l16 = worldIn.getHeight(pos.add(l9, 0, k13)).getY() * 2;

			if (l16 > 0) {
				int j19 = random.nextInt(l16);

				BlockPos position = pos.add(l9, j19, k13);

				for (int i = 0; i < 30; ++i) {
					BlockPos blockpos = position.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

					if (worldIn.isBlockFullCube(blockpos) && (/*worldIn.getBlockState(blockpos).getMaterial().equals(Material.GROUND) ||*/ worldIn.getBlockState(blockpos).getMaterial().equals(Material.ROCK))) {
						EnumFacing direction = EnumFacing.getHorizontal(random.nextInt(EnumFacing.HORIZONTALS.length));

						if (!worldIn.isAirBlock(blockpos.offset(direction)))
							continue;

						IBlockState vineState = vines[random.nextInt(vines.length)].withProperty(BlockVine.ALL_FACES[direction.getOpposite().getIndex() - 1], true);

						for (int l = 0; l < random.nextInt(20) + 5; ++l) {
							if (!worldIn.isAirBlock(blockpos.offset(direction).down(l)))
								break;

							worldIn.setBlockState(blockpos.offset(direction).down(l), vineState, 2);
						}
						continue;
					}
				}
			}
		}
	}

	public void generateCrystals(World worldIn, Random random, Biome biome, BlockPos pos) {
		for (int j5 = 0; j5 < 40; ++j5) {
			int l9 = random.nextInt(16) + 8;
			int k13 = random.nextInt(16) + 8;
			int l16 = worldIn.getHeight(pos.add(l9, 0, k13)).getY() * 2;

			if (l16 > 0) {
				int j19 = random.nextInt(l16);

				BlockPos position = pos.add(l9, j19, k13);

				for (int i = 0; i < 30; ++i) {
					BlockPos blockpos = position.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

					if (worldIn.getBlockState(blockpos).getBlock() instanceof BlockRock) {
						EnumFacing direction = EnumFacing.getFront(random.nextInt(EnumFacing.VALUES.length));

						if (!worldIn.isAirBlock(blockpos.offset(direction)))
							continue;

						if (Resources.rock.getBlock().getMetaFromState(worldIn.getBlockState(blockpos)) == 0)
							worldIn.setBlockState(blockpos.offset(direction), getCrystalForTier(random, 0).withProperty(BlockGem.FACING, direction), 2);
						else if (Resources.rock.getBlock().getMetaFromState(worldIn.getBlockState(blockpos)) == 1)
							worldIn.setBlockState(blockpos.offset(direction), getCrystalForTier(random, 1).withProperty(BlockGem.FACING, direction), 2);
						else if (Resources.rock.getBlock().getMetaFromState(worldIn.getBlockState(blockpos)) == 2)
							worldIn.setBlockState(blockpos.offset(direction), getCrystalForTier(random, 2).withProperty(BlockGem.FACING, direction), 2);
						else if (Resources.rock.getBlock().getMetaFromState(worldIn.getBlockState(blockpos)) == 3)
							worldIn.setBlockState(blockpos.offset(direction), getCrystalForTier(random, 3).withProperty(BlockGem.FACING, direction), 2);
						else if (Resources.rock.getBlock().getMetaFromState(worldIn.getBlockState(blockpos)) == 4)
							worldIn.setBlockState(blockpos.offset(direction), getCrystalForTier(random, 4).withProperty(BlockGem.FACING, direction), 2);

						continue;
					}
				}
			}
		}
	}

	public static void growCactus(World worldIn, BlockPos blockpos) {
		if (worldIn.isAirBlock(blockpos)) {
			worldIn.setBlockState(blockpos, Resources.cardon.getBlock().getDefaultState(), 2);
		}
	}

	public static IBlockState[][] crystalTiers = new IBlockState[][] {
		new IBlockState[] {Resources.calcite.getBlock().getDefaultState()},
		new IBlockState[] {Resources.calcite.getBlock().getDefaultState()},
		new IBlockState[] {Resources.calcite.getBlock().getDefaultState()},
		new IBlockState[] {Resources.calcite.getBlock().getDefaultState(), Resources.jasper.getBlock().getDefaultState()},
		new IBlockState[] {Resources.calcite.getBlock().getDefaultState(), Resources.jasper.getBlock().getDefaultState(), Resources.zircon.getBlock().getDefaultState()}
	};

	public static IBlockState getCrystalForTier(Random rand, int tier) {
		return crystalTiers[tier][rand.nextInt(crystalTiers[tier].length)];
	}
}
