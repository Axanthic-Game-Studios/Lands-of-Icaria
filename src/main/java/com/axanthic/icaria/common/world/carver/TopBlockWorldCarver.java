package com.axanthic.icaria.common.world.carver;

import java.util.function.Function;

import com.axanthic.icaria.common.world.carver.configuration.TopBlockCarverConfiguration;
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

public class TopBlockWorldCarver extends WorldCarver<TopBlockCarverConfiguration> {

	public TopBlockWorldCarver(final Codec<TopBlockCarverConfiguration> p_i231917_1_) {
		super(p_i231917_1_);
	}

	@Override
	public boolean carve(final CarvingContext pContext, final TopBlockCarverConfiguration pConfig,
			final ChunkAccess pChunk, final Function<BlockPos, Holder<Biome>> pBiomeAccessor,
			final RandomSource pRandom, final Aquifer pAquifer, final ChunkPos pChunkPos,
			final CarvingMask pCarvingMask) {
		// TODO: replace top blocks here instead of directly inside chunk generator (or
		// use SurfaceRules.RuleSource)
		return false;
	}

	@Override
	public boolean isStartChunk(final TopBlockCarverConfiguration pConfig, final RandomSource pRandom) {
		return false;
	}

	@Override
	protected boolean canReplaceBlock(final TopBlockCarverConfiguration configuration, final BlockState state) {
		return true;
	}
}
