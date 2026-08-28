package com.axanthic.icaria.common.world.feature.tree.small;

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

public class SmallPlaneTreeFeature extends SmallTreeFeature {
	public SmallPlaneTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_PLANE_LEAVES.get(), IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_LOG.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var aabb = this.aabb(origin);

		if (level.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && level.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeLog(level, origin, Direction.Axis.Y);

			this.placeLeaves(level, origin.relative(direction));
			this.placeLeaves(level, origin.relative(direction.getClockWise()));
			this.placeLeaves(level, origin.relative(direction.getCounterClockWise()));
			this.placeLeaves(level, origin.relative(direction.getOpposite()));

			this.placeLeaves(level, origin.relative(direction).relative(direction.getClockWise()));
			this.placeLeaves(level, origin.relative(direction.getOpposite()).relative(direction.getCounterClockWise()));

			this.placeFallen(level, origin.above(), random.nextIntBetweenInclusive(4, 8));

			return true;
		} else {
			return false;
		}
	}
}
