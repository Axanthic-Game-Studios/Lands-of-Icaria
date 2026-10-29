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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.phys.AABB;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FallenRelicstonePillarFeature implements Feature {
	public static final MapCodec<FallenRelicstonePillarFeature> CODEC = MapCodec.unit(FallenRelicstonePillarFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var offset = pRandomSource.nextIntBetweenInclusive(1, 2);
		var length = pRandomSource.nextIntBetweenInclusive(1, 3);
		var lengthTotal = length + 1;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var relative = pBlockPos.below().relative(direction, offset);

		var aabb = this.aabb(relative, direction, lengthTotal);

		if (pWorldGenLevel.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && pWorldGenLevel.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeHead(pWorldGenLevel, pBlockPos, Direction.UP);

			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);

			for (var i = 1; i <= length; i++) {
				offset++;
				this.placePillar(pWorldGenLevel, pBlockPos.relative(direction, offset), direction);
				this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset), 64);
				this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
				this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
				this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);
				this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);
			}

			offset++;
			this.placeHead(pWorldGenLevel, pBlockPos.relative(direction, offset), direction.getOpposite());
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);

			offset++;
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);

			offset++;
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
			this.placeSuspicious(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);

			this.placeSuspiciousPatch(pWorldGenLevel, pBlockPos, 64);
			this.placeRubblePatch(pWorldGenLevel, pBlockPos, 4);

			return true;
		} else {
			return false;
		}
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeHead(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTags.SOILS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, pDirection));
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placePillar(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTags.SOILS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, pDirection.getAxis()));
		}
	}

	public void placeRubblePatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		this.placeRubble(pWorldGenLevel, pBlockPos.north(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.north(1).east(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.north(2), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.north(2).east(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.north(2).west(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.east(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.east(1).south(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.east(2), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.east(2).north(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.east(2).south(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.south(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.south(1).west(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.south(2), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.south(2).east(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.south(2).west(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.west(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.west(1).north(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.west(2), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.west(2).north(1), pChance);
		this.placeRubble(pWorldGenLevel, pBlockPos.west(2).south(1), pChance);
	}

	public void placeRubble(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeRubble(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeRubble(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTags.SOILS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_RUBBLE.get().defaultBlockState());
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

	public AABB aabb(BlockPos pBlockPos, Direction pDirection, int pLength) {
		return new AABB(
			pBlockPos.relative(pDirection).getX(),
			pBlockPos.relative(pDirection).getY(),
			pBlockPos.relative(pDirection).getZ(),
			pBlockPos.relative(pDirection, pLength).getX(),
			pBlockPos.relative(pDirection, pLength).getY(),
			pBlockPos.relative(pDirection, pLength).getZ()
		);
	}

	@Override
	public MapCodec<FallenRelicstonePillarFeature> codec() {
		return FallenRelicstonePillarFeature.CODEC;
	}
}
