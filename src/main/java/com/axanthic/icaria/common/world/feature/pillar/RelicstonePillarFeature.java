package com.axanthic.icaria.common.world.feature.pillar;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RelicstonePillarFeature extends Feature<NoneFeatureConfiguration> {
	public RelicstonePillarFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var offset = 0;
		var height = random.nextIntBetweenInclusive(1, 3);

		this.placeHead(level, origin, Direction.UP);

		for (var i = 1; i <= height; i++) {
			offset++;
			this.placePillar(level, origin.above(offset), Direction.UP);
		}

		offset++;
		this.placeHead(level, origin.above(offset), Direction.DOWN);

		this.placeSuspiciousPatch(level, origin, 64);

		return true;
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeHead(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS) || pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.RELICSTONE_PILLAR.get()))) {
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
			pWorldGenLevel.setBlock(pBlockPos.below(), IcariaBlocks.SUSPICIOUS_GRAINEL.get().defaultBlockState(), 3);
			pWorldGenLevel.getBlockEntity(pBlockPos.below(), BlockEntityType.BRUSHABLE_BLOCK).ifPresent(brushableBlockEntity -> brushableBlockEntity.setLootTable(IcariaLootTables.SUSPICIOUS_SAND, pBlockPos.below().asLong()));
		} else if (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.SILKSAND.get())) {
			pWorldGenLevel.setBlock(pBlockPos.below(), IcariaBlocks.SUSPICIOUS_SILKSAND.get().defaultBlockState(), 3);
			pWorldGenLevel.getBlockEntity(pBlockPos.below(), BlockEntityType.BRUSHABLE_BLOCK).ifPresent(brushableBlockEntity -> brushableBlockEntity.setLootTable(IcariaLootTables.SUSPICIOUS_SAND, pBlockPos.below().asLong()));
		}
	}
}
