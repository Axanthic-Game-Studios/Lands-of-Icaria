package com.axanthic.icaria.common.world.feature.tree.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.AABB;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadTreeFeature extends Feature<NoneFeatureConfiguration> {
	public int min;
	public int max;

	public Block dead;
	public Block log;
	public Block moss;
	public Block shrooms;
	public Block twigs;

	public Moss property;

	public DeadTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pDead, Block pLog, Block pMoss, Block pShrooms, Block pTwigs, Moss pProperty, int pMin, int pMax) {
		super(pCodec);
		this.dead = pDead;
		this.log = pLog;
		this.moss = pMoss;
		this.shrooms = pShrooms;
		this.twigs = pTwigs;
		this.property = pProperty;
		this.min = pMin;
		this.max = pMax;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var offset = random.nextIntBetweenInclusive(1, 2);
		var length = random.nextIntBetweenInclusive(this.min, this.max);

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var relative = origin.below().relative(direction, offset);

		var aabb = this.aabb(relative, direction, length);

		if (level.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && level.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeDead(level, origin, Direction.Axis.Y);

			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);

			for (var i = 1; i <= length; i++) {
				offset++;
				this.placeDead(level, origin.relative(direction, offset), direction.getAxis());
				this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), direction.getClockWise(), 4);
				this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), direction.getCounterClockWise(), 4);
				this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 1, 4);
				this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
				this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 1, 4);
				this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);
			}

			offset++;
			this.placeMoss(level, origin.relative(direction, offset), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);

			offset++;
			this.placeMoss(level, origin.relative(direction, offset), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 1, 4);

			this.placeTwigsPatch(level, origin, 4);
			this.placeMossPatch(level, origin, 4);

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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.dead.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeLog(pWorldGenLevel, pBlockPos, pAxis);
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.log.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT) && this.moss.defaultBlockState().hasProperty(BlockStateProperties.LAYERS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.moss.defaultBlockState().setValue(BlockStateProperties.LAYERS, pHeight));
			if (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.GRASSY_MARL.get())) {
				this.setBlock(pWorldGenLevel, pBlockPos.below(), IcariaBlocks.GRASSY_MARL.get().defaultBlockState().setValue(IcariaBlockStateProperties.MOSS, this.property));
			}
		}
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeShrooms(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection.getOpposite())).is(BlockTags.LOGS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.shrooms.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.twigs.defaultBlockState());
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
