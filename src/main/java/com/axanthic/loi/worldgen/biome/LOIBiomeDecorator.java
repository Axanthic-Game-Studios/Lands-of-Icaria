package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockFlower;
import com.axanthic.blab.blocks.BlockFlower2;
import com.axanthic.blab.blocks.BlockTallGrass;
import com.axanthic.loi.worldgen.dimension.OreGeneratorLOI;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class LOIBiomeDecorator extends BiomeDecorator {

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

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, forgeChunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS))
				for (int l2 = 0; l2 < this.flowersPerChunk; ++l2)
				{
					int i7 = random.nextInt(16) + 8;
					int l10 = random.nextInt(16) + 8;
					int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

					if (j14 > 0)
					{
						int k17 = random.nextInt(j14);
						BlockPos blockpos1 = this.chunkPos.add(i7, k17, l10);

						IBlockState iblockstate1;

						int meta = random.nextInt(BlockFlower.FlowerTypes.values().length + BlockFlower2.FlowerTypes2.values().length);
						if (meta < 16)
							iblockstate1 = Resources.flower.getBlock().getStateFromMeta(meta);
						else
							iblockstate1 = Resources.flower2.getBlock().getStateFromMeta(meta - 16);

						for (int i = 0; i < 64; ++i)
						{
							BlockPos blockpos = blockpos1.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

							if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && ((BlockFlower) Resources.flower.getBlock()).canBlockStay(worldIn, blockpos, iblockstate1))
							{
								worldIn.setBlockState(blockpos, iblockstate1, 2);
							}
						}
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, forgeChunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i3 = 0; i3 < this.grassPerChunk; ++i3)
				{
					int j7 = random.nextInt(16) + 8;
					int i11 = random.nextInt(16) + 8;
					int k14 = worldIn.getHeight(this.chunkPos.add(j7, 0, i11)).getY() * 2;

					if (k14 > 0)
					{
						int l17 = random.nextInt(k14);

						BlockPos position = this.chunkPos.add(j7, l17, i11);

						for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position))
						{
							position = position.down();
						}

						for (int i = 0; i < 128; ++i)
						{
							BlockPos blockpos = position.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
							IBlockState iblockstate2 = Resources.tallGrass.getBlock().getStateFromMeta(random.nextInt(BlockTallGrass.GrassTypes.values().length));

							if (worldIn.isAirBlock(blockpos) && ((BlockTallGrass) Resources.tallGrass.getBlock()).canBlockStay(worldIn, blockpos, iblockstate2))
							{
								worldIn.setBlockState(blockpos, iblockstate2, 2);
							}
						}


					}
				}



			oreGen.generate(random, forgeChunkPos.x, forgeChunkPos.z, worldIn, null, worldIn.getChunkProvider());

			this.decorating = false;
		}
	}
}
