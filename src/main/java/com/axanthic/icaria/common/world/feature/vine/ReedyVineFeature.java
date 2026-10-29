package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.block.IcariaVineBlock;
import com.axanthic.icaria.common.enums.Vine;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ReedyVineFeature(BlockState vine) implements Feature {
	public static final MapCodec<ReedyVineFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("block").forGetter(ReedyVineFeature::vine)
		).apply(instance, ReedyVineFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		Direction.Plane.HORIZONTAL.forEach(direction -> this.placeVine(pWorldGenLevel, pBlockPos, direction));
		return true;
	}

	public void placeVine(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeVine(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeVine(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection)).is(BlockItemTags.LEAVES.block()) || pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection)).isSolidRender()) && IcariaVineBlock.isAcceptableNeighbour(pWorldGenLevel, pBlockPos.relative(pDirection), pDirection)) {
			if (pWorldGenLevel.getRandom().nextBoolean()) {
				this.setBlock(pWorldGenLevel, pBlockPos, this.vine().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
			} else {
				this.setBlock(pWorldGenLevel, pBlockPos, this.vine().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.VINE));
			}
		}
	}

	@Override
	public MapCodec<ReedyVineFeature> codec() {
		return ReedyVineFeature.CODEC;
	}

}
