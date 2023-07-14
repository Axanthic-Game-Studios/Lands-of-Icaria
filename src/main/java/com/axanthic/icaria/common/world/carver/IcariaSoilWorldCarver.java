package com.axanthic.icaria.common.world.carver;

import com.axanthic.icaria.common.world.carver.configuration.IcariaSoilCarverConfiguration;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

import java.util.function.Function;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSoilWorldCarver extends WorldCarver<IcariaSoilCarverConfiguration> {
	public IcariaSoilWorldCarver(Codec<IcariaSoilCarverConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean canReplaceBlock(IcariaSoilCarverConfiguration configuration, BlockState state) {
		return true;
	}

	@Override
	public boolean carve(CarvingContext pContext, IcariaSoilCarverConfiguration pConfig, ChunkAccess pChunk, Function<BlockPos, Holder<Biome>> pBiomeAccessor, RandomSource pRandom, Aquifer pAquifer, ChunkPos pChunkPos, CarvingMask pCarvingMask) {
		return false;
	}

	@Override
	public boolean isStartChunk(IcariaSoilCarverConfiguration pConfig, RandomSource pRandom) {
		return false;
	}
}
