package com.axanthic.icaria.common.world.feature.tree.fallen;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FallenDroughtrootTreeFeature extends FallenTreeFeature {
	public FallenDroughtrootTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), IcariaBlocks.DROUGHTROOT_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var offset = random.nextIntBetweenInclusive(1, 2);
		var lengthTrunk = random.nextIntBetweenInclusive(0, 2);
		var lengthLower = random.nextIntBetweenInclusive(1, 4);
		var lengthInner = random.nextIntBetweenInclusive(1, 4);
		var lengthUpper = random.nextIntBetweenInclusive(1, 4);
		var lengthTotal = lengthTrunk + lengthLower + lengthInner + lengthUpper + 1;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
		var orthogonal = direction.getClockWise();

		var aabb = this.aabb(origin, direction, lengthTotal, offset, 1);

		if (level.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && level.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeDead(level, origin, Direction.Axis.Y);

			offset++;
			this.placeDead(level, origin.relative(direction, offset), direction.getAxis());
			this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getClockWise()), direction.getClockWise(), 4);
			this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()), direction.getCounterClockWise(), 4);

			for (var i = 1; i <= lengthTrunk; i++) {
				offset++;
				this.placeLog(level, origin.relative(direction, offset), direction.getAxis());
			}

			for (var i = 1; i <= lengthLower; i++) {
				offset++;
				orthogonal = orthogonal.getOpposite();
				this.placeLog(level, origin.relative(direction, offset), direction.getAxis());
				this.placeLog(level, origin.relative(direction, offset).relative(orthogonal), orthogonal.getAxis());
				this.placeLeaves(level, origin.relative(direction, offset).above());
				this.placeLeaves(level, origin.relative(direction, offset).relative(orthogonal).above());
			}

			for (var i = 1; i <= lengthInner; i++) {
				offset++;
				orthogonal = orthogonal.getOpposite();
				this.placeLog(level, origin.relative(direction, offset), direction.getAxis());
				this.placeLeaves(level, origin.relative(direction, offset).above());
				this.placeLeaves(level, origin.relative(direction, offset).relative(orthogonal));
			}

			for (var i = 1; i <= lengthUpper; i++) {
				offset++;
				orthogonal = orthogonal.getOpposite();
				this.placeLeaves(level, origin.relative(direction, offset));
				this.placeLeaves(level, origin.relative(direction, offset).relative(orthogonal));
			}

			this.placeTwigsPatch(level, origin, 4);

			return true;
		} else {
			return false;
		}
	}
}
