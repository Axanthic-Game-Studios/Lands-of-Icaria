package com.axanthic.loi.worldgen.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.Resources;
import com.axanthic.loi.LOIConfig.CategoryWorldgen.OreSettings;
import com.axanthic.loi.blocks.BlockOre;
import com.axanthic.loi.blocks.BlockSoil;
import com.axanthic.loi.utils.PerlinNoise;
import com.google.common.base.Predicate;

public class BigVeinOreGeneratorLOI {

	/*private static final LOIOregen ligniteGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(0), new RockPredicate(0), LOIConfig.world.lignite);
	private static final LOIOregen chalkosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(1), new RockPredicate(0), LOIConfig.world.chalkos);
	private static final LOIOregen dolomiteGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(3), new RockPredicate(1), LOIConfig.world.dolomite);
	private static final LOIOregen kassiterosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(2), new RockPredicate(1), LOIConfig.world.kassiteros);
	private static final LOIOregen molibosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(4), new RockPredicate(1), LOIConfig.world.molibos);
	private static final LOIOregen sliverGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(6), new RockPredicate(2), LOIConfig.world.sliver);
	private static final LOIOregen vanadiumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(5), new RockPredicate(2), LOIConfig.world.vanadium);
	private static final LOIOregen anthraciteGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(8), new RockPredicate(3), LOIConfig.world.anthracite);
	private static final LOIOregen siderosGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(7), new RockPredicate(3), LOIConfig.world.sideros);
	private static final LOIOregen molybdenumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(9), new RockPredicate(3), LOIConfig.world.molybdenum);
	private static final LOIOregen hyliastrumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(11), new RockPredicate(4), LOIConfig.world.hyliastrum);
	private static final LOIOregen abyssalEssenceGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(12), new RockPredicate(4), LOIConfig.world.abyssalEssence);
	private static final LOIOregen bluridiumGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(10), new RockPredicate(4), LOIConfig.world.bluridium);
	private static final LOIOregen rottenBonesGenerator = new LOIOregen(Resources.ore.getBlock().getStateFromMeta(BlockOre.OreTypes.ROTTEN_BONES.getMeta()), new MarlPredicate(), LOIConfig.world.rottenBones);
*/
	private static final List<LOIOregen> customGenerators = new ArrayList<LOIOregen>();

	private final PerlinNoise oreNoise;

	public BigVeinOreGeneratorLOI(PerlinNoise noise) {
		this.oreNoise = noise;

		/*for (String ore : LOIConfig.world.custom) {
			String[] entries = ore.split(":");

			String modID = entries[0];
			String blockID = entries[1];
			int meta = Integer.parseInt(entries[2]);
			RockPredicate rock = new RockPredicate(Integer.parseInt(entries[3]));
			Float indexBegin = Float.parseFloat(entries[4]);
			Float indexEnd = Float.parseFloat(entries[5]);
			Float noiseSize = Float.parseFloat(entries[6]);
			int offset = Integer.parseInt(entries[7]);

			customGenerators.add(new LOIOregen(Block.REGISTRY.getObject(new ResourceLocation(modID, blockID)).getStateFromMeta(meta), rock, true, indexBegin, indexEnd, noiseSize, offset));
		}*/
	}

	public void generate(final int x, final int z, final int wx, final int wz, final ChunkPrimer primer) {
		//generateOre(chalkosGenerator, x, z, wx, wz, primer);
		//generateOre(ligniteGenerator, x, z, wx, wz, primer);
		//generateOre(molibosGenerator, x, z, wx, wz, primer);
		//generateOre(kassiterosGenerator, x, z, wx, wz, primer);
		//generateOre(dolomiteGenerator, x, z, wx, wz, primer);
		//generateOre(vanadiumGenerator, x, z, wx, wz, primer);
		//generateOre(sliverGenerator, x, z, wx, wz, primer);
		//generateOre(molybdenumGenerator, x, z, wx, wz, primer);
		//generateOre(siderosGenerator, x, z, wx, wz, primer);
		//generateOre(anthraciteGenerator, x, z, wx, wz, primer);
		//generateOre(bluridiumGenerator, x, z, wx, wz, primer);
		//generateOre(abyssalEssenceGenerator, x, z, wx, wz, primer);
		//generateOre(hyliastrumGenerator, x, z, wx, wz, primer);
		//generateOre(rottenBonesGenerator, x, z, wx, wz, primer);
		for (LOIOregen generator : customGenerators)
			generateOre(generator, x, z, wx, wz, primer);
	}

	private void generateOre(LOIOregen oreGen, final int x, final int z, final int wx, final int wz, final ChunkPrimer primer) {
		if (!oreGen.enabled)
			return;
		float offset = this.oreNoise.noise2((wx + oreGen.offset) / (70F * oreGen.noiseSize), (wz + oreGen.offset) / (70F * oreGen.noiseSize)) * 0.25F;
		float thinnness = Math.max(0.0F, this.oreNoise.noise2((wx + oreGen.offset) / (40F * oreGen.noiseSize), (wz + oreGen.offset) / (40F * oreGen.noiseSize)) * (oreGen.indexBegin - oreGen.indexEnd) * 1.5F);
		for(int y = ChunkGeneratorLOI.CHUNK_HEIGHT; y > 1; y--) {
			IBlockState b = primer.getBlockState(x, y, z);
			final IBlockState upper = primer.getBlockState(x, y + 1, z);
			if(b.getBlock() != Blocks.AIR && upper.getBlock() == Blocks.AIR) {
				for(int gy = 1; gy < y; gy++) {
					float value = this.oreNoise.noise3((wx + oreGen.offset) / (400F * oreGen.noiseSize), (y - gy) / 500F, (wz + oreGen.offset) / (400F * oreGen.noiseSize)) + offset;
					if (value > oreGen.indexBegin + thinnness && value < oreGen.indexEnd - thinnness) {
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
	
	static abstract class CustomPredicate implements Predicate<IBlockState> {
		public abstract boolean apply(IBlockState state);
	}

	static class RockPredicate extends CustomPredicate {
		int variant;

		private RockPredicate(int variant) {
			super();
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
	
	static class MarlPredicate extends CustomPredicate {
		private MarlPredicate() {
			super();
		}

		public boolean apply(IBlockState state) {
			if (state != null) {
				Block block = state.getBlock();
				if (block == Resources.soil.getBlock()) {
					int meta = block.getMetaFromState(state);
					return meta == BlockSoil.SoilTypes.MARL.getMeta()
							|| meta == BlockSoil.SoilTypes.MARLCOURSE.getMeta();
				} else if (block == Resources.grass.getBlock()) {
					return true;
				}
			}
			
			return false;
		}
	}

	public static class LOIOregen {

		public IBlockState ore;
		public CustomPredicate rock;
		public boolean enabled;
		public Float indexBegin;
		public Float indexEnd;
		public Float noiseSize;
		public int offset;

		/*public LOIOregen (IBlockState ore, CustomPredicate rock, OreSettings settings) {
			this(ore, rock, settings.enabled, settings.indexBegin.floatValue(), settings.indexEnd.floatValue(), settings.noiseSize.floatValue(), settings.offset);
		}*/

		public LOIOregen (IBlockState ore, CustomPredicate rock, boolean enabled, Float indexBegin, Float indexEnd, Float noiseSize, int offset) {
			this.ore = ore;
			this.rock = rock;
			this.enabled = enabled;
			this.indexBegin = indexBegin;
			this.indexEnd = indexEnd;
			this.noiseSize = noiseSize;
			this.offset = offset;
		}
	}
}