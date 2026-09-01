package com.axanthic.icaria.common.world.feature.tree.fallen;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FallenPlaneTreeFeature extends FallenTreeFeature {
	public FallenPlaneTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), IcariaBlocks.PLANE_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var widthClockWise = 0;
		var widthCounterClockWise = 0;
		var offset = random.nextIntBetweenInclusive(1, 2);
		var lengthTrunk = random.nextIntBetweenInclusive(0, 2);
		var lengthCrownClockWise = random.nextIntBetweenInclusive(2, 4);
		var lengthCrownCounterClockWise = random.nextIntBetweenInclusive(2, 4);
		var lengthTotal = Math.max(lengthCrownClockWise, lengthCrownCounterClockWise) + lengthTrunk + 2;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var aabb = this.aabb(origin, direction, lengthTotal, offset, 5);

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

			var lengthClockWise = offset;

			for (var i = 1; i <= lengthCrownClockWise; i++) {
				lengthClockWise++;
				widthClockWise++;
				this.placeLog(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise), direction.getClockWise().getAxis());
			}

			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).above());
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction));
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()));
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()));
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getOpposite()));
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getOpposite()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()).relative(direction), 2);
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()).relative(direction.getOpposite()), 2);
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()).relative(direction), 2);
			this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()).relative(direction.getOpposite()), 2);

			var lengthCounterClockWise = offset;

			for (var i = 1; i <= lengthCrownCounterClockWise; i++) {
				lengthCounterClockWise++;
				widthCounterClockWise++;
				this.placeLog(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise), direction.getCounterClockWise().getAxis());
			}

			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).above());
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction));
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()));
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()));
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getOpposite()));
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getOpposite()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()).relative(direction), 2);
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()).relative(direction.getOpposite()), 2);
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()).relative(direction), 2);
			this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()).relative(direction.getOpposite()), 2);

			this.placeTwigsPatch(level, origin, 4);

			return true;
		} else {
			return false;
		}
	}
}
