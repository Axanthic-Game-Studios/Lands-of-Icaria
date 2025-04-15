package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import com.mojang.serialization.Codec;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RuinFeature extends Feature<NoneFeatureConfiguration> {
	public ArrayList<EntityType<?>> mobs = new ArrayList<>();

	public RuinFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		this.setMobs();

		for (var x = 0; x < 16; x++) {
			var pX = origin.getX() + x;
			for (var z = 0; z < 16; z++) {
				var pZ = origin.getZ() + z;
				for (var y = 40; y < 48; y++) {
					var blockPos = new BlockPos(pX, y, pZ);
					var belowPos = new BlockPos(pX, y, pZ).below();
					var oldState = level.getBlockState(belowPos);
					var newState = oldState.is(IcariaBlocks.MARL.get()) ? IcariaBlocks.GRASSY_MARL.get().defaultBlockState() : oldState;

					this.replaceRelicstone(level, blockPos, newState, 10);

					this.setMobsForSpawners(level, blockPos, random);
				}
			}
		}

		return true;
	}

	public void replaceRelicstone(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.replaceRelicstone(pWorldGenLevel, pBlockPos, pBlockState);
		}
	}

	public void replaceRelicstone(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlocks.RELICSTONE.get())) {
			this.setBlock(pWorldGenLevel, pBlockPos, pBlockState);
		}
	}

	public void setMobsForSpawners(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pWorldGenLevel.getBlockEntity(pBlockPos) instanceof IcariaSpawnerBlockEntity blockEntity) {
			blockEntity.setEntityId(this.getMob(pRandomSource), pRandomSource);
		}
	}

	public void setMobs() {
		this.mobs.add(IcariaEntityTypes.CIVILIAN_REVENANT.get());
		this.mobs.add(IcariaEntityTypes.PYROMANCER_REVENANT.get());
		this.mobs.add(IcariaEntityTypes.SOLDIER_REVENANT.get());
	}

	public EntityType<?> getMob(RandomSource pRandomSource) {
		return this.mobs.get(pRandomSource.nextInt(this.mobs.size()));
	}
}
