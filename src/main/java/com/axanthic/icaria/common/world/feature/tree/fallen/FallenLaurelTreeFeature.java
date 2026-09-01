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

public class FallenLaurelTreeFeature extends FallenTreeFeature {
	public FallenLaurelTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaBlocks.LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.LAUREL_TWIGS.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var widthClockWise = 1;
		var widthCounterClockWise = 1;
		var offset = random.nextIntBetweenInclusive(1, 2);
		var lengthTrunk = random.nextIntBetweenInclusive(0, 2);
		var lengthCrownClockWise = random.nextIntBetweenInclusive(4, 6);
		var lengthCrownCounterClockWise = random.nextIntBetweenInclusive(4, 6);
		var lengthTotal = Math.max(lengthCrownClockWise, lengthCrownCounterClockWise) + lengthTrunk + 2;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var aabb = this.aabb(origin, direction, lengthTotal, offset, 7);

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
				this.placeLog(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise), direction.getAxis());
				this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).above());
				this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()));
				this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()));
				this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction.getOpposite()).relative(direction.getClockWise(), widthClockWise));
				this.placeLeaves(level, origin.relative(direction, lengthClockWise).relative(direction).relative(direction.getClockWise(), widthClockWise));
				widthClockWise = random.fork().nextInt(4) == 0 ? widthClockWise + 1 : widthClockWise;
			}

			var lengthCounterClockWise = offset;

			for (var i = 1; i <= lengthCrownCounterClockWise; i++) {
				lengthCounterClockWise++;
				this.placeLog(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise), direction.getAxis());
				this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).above());
				this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()));
				this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()));
				this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction.getOpposite()).relative(direction.getCounterClockWise(), widthCounterClockWise));
				this.placeLeaves(level, origin.relative(direction, lengthCounterClockWise).relative(direction).relative(direction.getCounterClockWise(), widthCounterClockWise));
				widthCounterClockWise = random.fork().nextInt(4) == 0 ? widthCounterClockWise + 1 : widthCounterClockWise;
			}

			this.placeTwigsPatch(level, origin, 4);

			return true;
		} else {
			return false;
		}
	}
}
