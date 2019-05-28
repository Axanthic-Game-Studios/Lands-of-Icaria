package com.axanthic.loi.worldgen.dimension;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.apache.commons.lang3.Validate;

import com.axanthic.blab.Blab;
import com.axanthic.blab.Resources;
import com.google.common.base.Predicate;

import java.util.Random;

public class OreGeneratorLOI implements IWorldGenerator {
	private final WorldGenMinable ligniteGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(0), 19, new RockPredicate(0));
	private final WorldGenMinable chalkosGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(1), 11, new RockPredicate(0));
	private final WorldGenMinable kassiterosGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(2), 11, new RockPredicate(1));
	private final WorldGenMinable dolomiteGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(3), 16, new RockPredicate(1));
	//private final WorldGenMinable molibosGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(4), 6, new RockPredicate(1));
	private final WorldGenMinable vanadiumGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(5), 11, new RockPredicate(2));
	//private final WorldGenMinable sliverGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(6), 6, new RockPredicate(2));
	private final WorldGenMinable siderosGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(7), 11, new RockPredicate(3));
	private final WorldGenMinable anthraciteGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(8), 10, new RockPredicate(3));
	private final WorldGenMinable molybdenumGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(9), 10, new RockPredicate(3));
	//private final WorldGenMinable bluridiumGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(10), 6, new RockPredicate(4));
	//private final WorldGenMinable hyliastrumGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(11), 6, new RockPredicate(4));
	//private final WorldGenMinable abyssalEssenceGenerator = new WorldGenMinable(Resources.ore.getBlock().getStateFromMeta(12), 6, new RockPredicate(4));

	public OreGeneratorLOI() {
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider) {
		generate(ligniteGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		generate(chalkosGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		generate(kassiterosGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		generate(dolomiteGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		//generate(molibosGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		generate(vanadiumGenerator, random, chunkX, chunkZ, world, 2, 0, 120);
		//generate(sliverGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		generate(siderosGenerator, random, chunkX, chunkZ, world, 2, 0, 120);
		generate(anthraciteGenerator, random, chunkX, chunkZ, world, 8, 0, 120);
		generate(molybdenumGenerator, random, chunkX, chunkZ, world, 1, 0, 120);
		//generate(bluridiumGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		//generate(hyliastrumGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
		//generate(abyssalEssenceGenerator, random, chunkX, chunkZ, world, 20, 0, 120);
	}

	private void generate(WorldGenerator generator, Random random, int chunkX, int chunkZ, World world, int spawnTries, int minHeight, int maxHeight) {
		Validate.isTrue(minHeight >= 0 && maxHeight <= 256);

		for (int i = 0; i < spawnTries; i++) {
			int x = chunkX * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(maxHeight - minHeight + 1);
			int z = chunkZ * 16 + random.nextInt(16);

			generator.generate(world, random, new BlockPos(x, y, z));
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
}