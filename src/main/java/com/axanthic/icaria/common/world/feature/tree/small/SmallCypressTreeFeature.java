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

public class SmallCypressTreeFeature extends SmallIcariaTreeFeature {
	public SmallCypressTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_LOG.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var aabb = this.aabb(origin);

		if (level.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && level.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.placeLog(level, origin, Direction.Axis.Y);

			this.placeLeaves(level, origin.above());

			this.placeLeaves(level, origin.north());
			this.placeLeaves(level, origin.east());
			this.placeLeaves(level, origin.south());
			this.placeLeaves(level, origin.west());

			this.placeFallen(level, origin.above().above(), random.nextIntBetweenInclusive(4, 8));

			this.placeFallen(level, origin.north().above(), random.nextIntBetweenInclusive(4, 8), 2);
			this.placeFallen(level, origin.east().above(), random.nextIntBetweenInclusive(4, 8), 2);
			this.placeFallen(level, origin.south().above(), random.nextIntBetweenInclusive(4, 8), 2);
			this.placeFallen(level, origin.west().above(), random.nextIntBetweenInclusive(4, 8), 2);

			return true;
		} else {
			return false;
		}
	}
}
