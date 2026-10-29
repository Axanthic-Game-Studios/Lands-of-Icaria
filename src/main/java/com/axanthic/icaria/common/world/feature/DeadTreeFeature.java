package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.phys.AABB;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record DeadTreeFeature(BlockState deadLog, BlockState log, BlockState moss, BlockState treeShrooms, BlockState twigs, int min, int max) implements Feature {
	public static final MapCodec<DeadTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("deadLog").forGetter(DeadTreeFeature::deadLog),
			BlockState.CODEC.fieldOf("log").forGetter(DeadTreeFeature::log),
			BlockState.CODEC.fieldOf("moss").forGetter(DeadTreeFeature::moss),
			BlockState.CODEC.fieldOf("treeShrooms").forGetter(DeadTreeFeature::treeShrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(DeadTreeFeature::twigs),
			Codec.INT.fieldOf("min").forGetter(DeadTreeFeature::min),
			Codec.INT.fieldOf("max").forGetter(DeadTreeFeature::max)
		).apply(instance, DeadTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var offset = pRandomSource.nextIntBetweenInclusive(1, 2);
		var length = pRandomSource.nextIntBetweenInclusive(this.min(), this.max());

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var relative = pBlockPos.below().relative(direction, offset);

		var aabb = this.aabb(relative, direction, length);

		if (pWorldGenLevel.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && pWorldGenLevel.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeDead(pWorldGenLevel, pBlockPos, Direction.Axis.Y);

			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);

			for (var i = 1; i <= length; i++) {
				offset++;
				this.placeDead(pWorldGenLevel, pBlockPos.relative(direction, offset), direction.getAxis());
				this.placeShrooms(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), direction.getClockWise(), 4);
				this.placeShrooms(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), direction.getCounterClockWise(), 4);
				this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), 1, 4);
				this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
				this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 1, 4);
				this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);
			}

			offset++;
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset), 1, 4);
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), 1, 4);
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 1, 4);
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);

			offset++;
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset), 1, 4);
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 1), 1, 4);
			this.placeMoss(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 1, 4);

			this.placeTwigsPatch(pWorldGenLevel, pBlockPos, 4);
			this.placeMossPatch(pWorldGenLevel, pBlockPos, 4);

			return true;
		} else {
			return false;
		}
	}

	public void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeDead(pWorldGenLevel, pBlockPos, pAxis);
		}
	}

	public void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.deadLog().setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeLog(pWorldGenLevel, pBlockPos, pAxis);
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.deadLog().setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public void placeMossPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		this.placeMoss(pWorldGenLevel, pBlockPos.north(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.north(1).east(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.north(2), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.north(2).east(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.north(2).west(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.east(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.east(1).south(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.east(2), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.east(2).north(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.east(2).south(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.south(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.south(1).west(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.south(2), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.south(2).east(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.south(2).west(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.west(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.west(1).north(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.west(2), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.west(2).north(1), 1, pChance);
		this.placeMoss(pWorldGenLevel, pBlockPos.west(2).south(1), 1, pChance);
	}

	public void placeMoss(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeMoss(pWorldGenLevel, pBlockPos, pHeight);
		}
	}

	public void placeMoss(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD) && this.moss().hasProperty(BlockStateProperties.LAYERS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.moss().setValue(BlockStateProperties.LAYERS, pHeight));
			pWorldGenLevel.getChunk(pBlockPos.below()).markPosForPostProcessing(pBlockPos.below());
			if (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.GRASSY_MARL.get())) {
				pWorldGenLevel.getChunk(pBlockPos.below()).markPosForPostProcessing(pBlockPos.below());
			}
		}
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeShrooms(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection.getOpposite())).is(BlockItemTags.LOGS.block())) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.treeShrooms().setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
		}
	}

	public void placeTwigsPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(1).east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(2).east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(2).west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(1).south(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(2).north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(2).south(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(1).west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(2).east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(2).west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(1).north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(2).north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(2).south(1), pChance);
	}

	public void placeTwigs(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeTwigs(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeTwigs(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.twigs());
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
	public MapCodec<DeadTreeFeature> codec() {
		return DeadTreeFeature.CODEC;
	}
}
