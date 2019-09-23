/*package com.axanthic.loi.worldgen.feature;

import java.util.Random;

import com.axanthic.loi.blocks.BlocksLOI;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBlockBlobLOI extends WorldGenerator
{
	private final Block block;
	private final int startRadius;

	public WorldGenBlockBlobLOI(final Block blockIn, final int startRadiusIn)
	{
		super(false);
		this.block = blockIn;
		this.startRadius = startRadiusIn;
	}

	@Override
	public boolean generate(final World worldIn, final Random rand, BlockPos position)
	{
		while (true)
		{
			label50:
			{
			if (position.getY() > 3)
			{
				if (worldIn.isAirBlock(position.down()))
				{
					break label50;
				}

				final Block block = worldIn.getBlockState(position.down()).getBlock();

				if ((block != BlocksLOI.MARLGRASS)
						&& (block != BlocksLOI.LOAM.getBlock())
						&& (block != BlocksLOI.YELLOWSTONE.getBlock()))
				{
					break label50;
				}
			}

			if (position.getY() <= 3)
			{
				return false;
			}

			final int i1 = this.startRadius;

			for (int i = 0; (i1 >= 0) && (i < 3); ++i)
			{
				final int j = i1 + rand.nextInt(2);
				final int k = i1 + rand.nextInt(2);
				final int l = i1 + rand.nextInt(2);
				final float f = ((j + k + l) * 0.333F) + 0.5F;

				for (final BlockPos blockpos : BlockPos.getAllInBox(position.add(-j, -k, -l), position.add(j, k, l)))
				{
					if (blockpos.distanceSq(position) <= (f * f))
					{
						worldIn.setBlockState(blockpos, this.block.getDefaultState(), 4);
					}
				}

				position = position.add(-(i1 + 1) + rand.nextInt(2 + (i1 * 2)), 0 - rand.nextInt(2), -(i1 + 1) + rand.nextInt(2 + (i1 * 2)));
			}

			return true;
			}
		position = position.down();
		}
	}
}*/