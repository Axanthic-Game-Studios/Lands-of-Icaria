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

public class FallenCypressTreeFeature extends FallenTreeFeature {
	public FallenCypressTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.CYPRESS_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var offset = random.nextIntBetweenInclusive(1, 2);
		var lengthCrown = random.nextIntBetweenInclusive(1, 4);
		var lengthTotal = lengthCrown + 7;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var aabb = this.aabb(origin, direction, lengthTotal, offset, 1);

		if (level.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && level.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeDead(level, origin, Direction.Axis.Y);

			offset++;
			this.placeDead(level, origin.relative(direction, offset), direction.getAxis());
			this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getClockWise()), direction.getClockWise(), 4);
			this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()), direction.getCounterClockWise(), 4);

			offset++;
			this.placeLog(level, origin.relative(direction, offset), direction.getAxis());
			this.placeLeaves(level, origin.relative(direction, offset).above(), 2);
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()), 2);
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()), 2);

			offset++;
			this.placeLog(level, origin.relative(direction, offset), direction.getAxis());
			this.placeLeaves(level, origin.relative(direction, offset).above());
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()));
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()));
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()).above(), 2);

			for (var i = 1; i <= lengthCrown; i++) {
				offset++;
				this.placeLog(level, origin.relative(direction, offset), direction.getAxis());
				this.placeLeaves(level, origin.relative(direction, offset).above());
				this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()));
				this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()));
				this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()).above());
				this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()).above());
			}

			offset++;
			this.placeLog(level, origin.relative(direction, offset), direction.getAxis());
			this.placeLeaves(level, origin.relative(direction, offset).above());
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()));
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()));
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()).above(), 2);
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()).above(), 2);

			offset++;
			this.placeLeaves(level, origin.relative(direction, offset));
			this.placeLeaves(level, origin.relative(direction, offset).above());
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()));
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()));

			offset++;
			this.placeLeaves(level, origin.relative(direction, offset));
			this.placeLeaves(level, origin.relative(direction, offset).above(), 2);
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getClockWise()), 2);
			this.placeLeaves(level, origin.relative(direction, offset).relative(direction.getCounterClockWise()), 2);

			offset++;
			this.placeLeaves(level, origin.relative(direction, offset));

			this.placeTwigsPatch(level, origin, 4);

			return true;
		} else {
			return false;
		}
	}
}
