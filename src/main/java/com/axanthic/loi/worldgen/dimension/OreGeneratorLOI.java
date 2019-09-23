package com.axanthic.loi.worldgen.dimension;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;
import com.axanthic.loi.Resources;
import com.axanthic.loi.utils.PerlinNoise;
import com.google.common.base.Predicate;

public class OreGeneratorLOI {
	private static final LOIOregen ligniteGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(0), new RockPredicate(0), -0.1F, 0.1F, 0.5F);
	private static final LOIOregen chalkosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(1), new RockPredicate(0), -0.2F, 0.2F, 1.0F);
	private static final LOIOregen kassiterosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(2), new RockPredicate(1), -0.2F, 0.2F, 0.5F);
	private static final LOIOregen dolomiteGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(3), new RockPredicate(1), -0.2F, 0.2F, 0.75F);
	private static final LOIOregen molibosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(4), new RockPredicate(1), -0.2F, 0.2F, 1.0F);
	private static final LOIOregen vanadiumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(5), new RockPredicate(2), -0.2F, 0.2F, 0.5F);
	private static final LOIOregen sliverGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(6), new RockPredicate(2), -0.2F, 0.2F, 1.0F);
	private static final LOIOregen siderosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(7), new RockPredicate(3), -0.2F, 0.2F, 0.5F);
	private static final LOIOregen anthraciteGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(8), new RockPredicate(3), -0.2F, 0.2F, 0.75F);
	private static final LOIOregen molybdenumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(9), new RockPredicate(3), -0.2F, 0.2F, 1.0F);
	private static final LOIOregen bluridiumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(10), new RockPredicate(4), -0.2F, 0.2F, 0.5F);
	private static final LOIOregen hyliastrumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(11), new RockPredicate(4), -0.2F, 0.2F, 0.75F);
	private static final LOIOregen abyssalEssenceGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(12), new RockPredicate(4), -0.2F, 0.2F, 1.0F);

	private final PerlinNoise oreNoise;

	public OreGeneratorLOI(PerlinNoise noise) {
		this.oreNoise = noise;
	}

	public void generate(final int x, final int z, final int wx, final int wz, final ChunkPrimer primer) {
		generateOre(ligniteGenerator, x, z, wx, wz, primer);
		generateOre(chalkosGenerator, x, z, wx, wz, primer);
		generateOre(kassiterosGenerator, x, z, wx, wz, primer);
		generateOre(dolomiteGenerator, x, z, wx, wz, primer);
		generateOre(molibosGenerator, x, z, wx, wz, primer);
		generateOre(vanadiumGenerator, x, z, wx, wz, primer);
		generateOre(sliverGenerator, x, z, wx, wz, primer);
		generateOre(anthraciteGenerator, x, z, wx, wz, primer);
		generateOre(siderosGenerator, x, z, wx, wz, primer);
		generateOre(molybdenumGenerator, x, z, wx, wz, primer);
		generateOre(bluridiumGenerator, x, z, wx, wz, primer);
		generateOre(hyliastrumGenerator, x, z, wx, wz, primer);
		generateOre(abyssalEssenceGenerator, x, z, wx, wz, primer);
	}

	private void generateOre(LOIOregen oreGen, final int x, final int z, final int wx, final int wz, final ChunkPrimer primer) {
		double value = this.oreNoise.noise((wx + 2221D) / (100D * oreGen.noiseSize), (wz + 2221D) / (100D * oreGen.noiseSize));
		System.out.println("value is: " + value);
		if (value > oreGen.indexBegin && value < oreGen.indexEnd) {
			for(int y = ChunkGeneratorLOI.CHUNK_HEIGHT; y > 1; y--) {
				IBlockState b = primer.getBlockState(x, y, z);
				final IBlockState upper = primer.getBlockState(x, y + 1, z);
				if(b.getBlock() != Blocks.AIR && upper.getBlock() == Blocks.AIR) {
					for(int gy = 1; gy < y; gy++) {
						b = primer.getBlockState(x, y - gy, z);
						if(b.getBlock() == Blocks.AIR) {
							break;
						}
						if (oreGen.rock.apply(primer.getBlockState(x, y - gy, z))) {
							primer.setBlockState(x, y - gy, z, oreGen.ore);
						}
					}
				}
			}
		}
	}

	static class RockPredicate implements Predicate<IBlockState> {
		int variant;

		private RockPredicate(int variant) {
			this.variant = variant;
		}

		public boolean apply(IBlockState state) {
			if (state != null && state.getBlock() == Resources.rock.getBlock()) {
				return Resources.rock.getBlock().getMetaFromState(state) == variant;
			} else {
				return false;
			}
		}
	}

	public static class LOIOregen {

		public IBlockState ore;
		public RockPredicate rock;
		public Float indexBegin;
		public Float indexEnd;
		public Float noiseSize;

		public LOIOregen (IBlockState ore, RockPredicate rock, Float indexBegin, Float indexEnd, Float noiseSize) {
			this.ore = ore;
			this.rock = rock;
			this.indexBegin = indexBegin;
			this.indexEnd = indexEnd;
			this.noiseSize = noiseSize;
		}
	}
}