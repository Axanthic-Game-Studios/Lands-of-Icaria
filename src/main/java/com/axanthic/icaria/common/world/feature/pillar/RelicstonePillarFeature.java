package com.axanthic.icaria.common.world.feature.pillar;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaLootTableIds;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.tags.IcariaBlockTags;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RelicstonePillarFeature implements Feature {
	public static final MapCodec<RelicstonePillarFeature> CODEC = MapCodec.unit(RelicstonePillarFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var offset = 0;
		var height = pRandomSource.nextIntBetweenInclusive(1, 3);

		this.placeHead(pWorldGenLevel, pBlockPos, Direction.UP);

		for (var i = 1; i <= height; i++) {
			offset++;
			this.placePillar(pWorldGenLevel, pBlockPos.above(offset), Direction.UP);
		}

		offset++;
		this.placeHead(pWorldGenLevel, pBlockPos.above(offset), Direction.DOWN);

		this.placeSuspiciousPatch(pWorldGenLevel, pBlockPos, 64);

		return true;
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeHead(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTags.SOILS) || pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.RELICSTONE_PILLAR.get()))) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, pDirection));
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placePillar(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.RELICSTONE_PILLAR.get()) || pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get()))) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, pDirection.getAxis()));
		}
	}

	public void placeSuspiciousPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		this.placeSuspicious(pWorldGenLevel, pBlockPos, 1);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.north(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.north(1).east(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.north(2), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.north(2).east(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.north(2).west(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.east(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.east(1).south(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.east(2), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.east(2).north(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.east(2).south(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.south(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.south(1).west(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.south(2), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.south(2).east(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.south(2).west(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.west(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.west(1).north(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.west(2), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.west(2).north(1), pChance);
		this.placeSuspicious(pWorldGenLevel, pBlockPos.west(2).south(1), pChance);
	}

	public void placeSuspicious(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeSuspicious(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeSuspicious(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.GRAINEL.get())) {
			pWorldGenLevel.setBlock(pBlockPos.below(), IcariaBlocks.SUSPICIOUS_GRAINEL.get().defaultBlockState(), Block.UPDATE_ALL);
			pWorldGenLevel.getBlockEntity(pBlockPos.below(), BlockEntityTypes.BRUSHABLE_BLOCK).ifPresent(brushableBlockEntity -> brushableBlockEntity.setLootTable(IcariaLootTableIds.SUSPICIOUS_SAND, pBlockPos.below().asLong()));
		} else if (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.SILKSAND.get())) {
			pWorldGenLevel.setBlock(pBlockPos.below(), IcariaBlocks.SUSPICIOUS_SILKSAND.get().defaultBlockState(), Block.UPDATE_ALL);
			pWorldGenLevel.getBlockEntity(pBlockPos.below(), BlockEntityTypes.BRUSHABLE_BLOCK).ifPresent(brushableBlockEntity -> brushableBlockEntity.setLootTable(IcariaLootTableIds.SUSPICIOUS_SAND, pBlockPos.below().asLong()));
		}
	}

	@Override
	public MapCodec<RelicstonePillarFeature> codec() {
		return RelicstonePillarFeature.CODEC;
	}
}
