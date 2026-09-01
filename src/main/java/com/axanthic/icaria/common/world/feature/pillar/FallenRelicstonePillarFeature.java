package com.axanthic.icaria.common.world.feature.pillar;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.AABB;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FallenRelicstonePillarFeature extends Feature<NoneFeatureConfiguration> {
	public FallenRelicstonePillarFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var offset = random.nextIntBetweenInclusive(1, 2);
		var length = random.nextIntBetweenInclusive(1, 3);
		var lengthTotal = length + 1;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var relative = origin.below().relative(direction, offset);

		var aabb = this.aabb(relative, direction, lengthTotal);

		if (level.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && level.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeHead(level, origin, Direction.UP);

			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);

			for (var i = 1; i <= length; i++) {
				offset++;
				this.placePillar(level, origin.relative(direction, offset), direction);
				this.placeSuspicious(level, origin.relative(direction, offset), 64);
				this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
				this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
				this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);
				this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);
			}

			offset++;
			this.placeHead(level, origin.relative(direction, offset), direction.getOpposite());
			this.placeSuspicious(level, origin.relative(direction, offset), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);

			offset++;
			this.placeSuspicious(level, origin.relative(direction, offset), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 64);

			offset++;
			this.placeSuspicious(level, origin.relative(direction, offset), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 64);
			this.placeSuspicious(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 64);

			this.placeSuspiciousPatch(level, origin, 64);
			this.placeRubblePatch(level, origin, 4);

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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, pDirection));
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placePillar(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS)) {
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS)) {
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
			pWorldGenLevel.getBlockEntity(pBlockPos.below(), BlockEntityType.BRUSHABLE_BLOCK).ifPresent(brushableBlockEntity -> brushableBlockEntity.setLootTable(IcariaLootTables.SUSPICIOUS_SAND, pBlockPos.below().asLong()));
		} else if (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.SILKSAND.get())) {
			pWorldGenLevel.setBlock(pBlockPos.below(), IcariaBlocks.SUSPICIOUS_SILKSAND.get().defaultBlockState(), Block.UPDATE_ALL);
			pWorldGenLevel.getBlockEntity(pBlockPos.below(), BlockEntityType.BRUSHABLE_BLOCK).ifPresent(brushableBlockEntity -> brushableBlockEntity.setLootTable(IcariaLootTables.SUSPICIOUS_SAND, pBlockPos.below().asLong()));
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
}
