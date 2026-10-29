package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import com.mojang.serialization.MapCodec;

import java.util.ArrayList;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RuinFeature implements Feature {
	public ArrayList<EntityType<?>> mobs = new ArrayList<>();

	public static final MapCodec<RuinFeature> CODEC = MapCodec.unit(RuinFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		this.setMobs();

		for (var x = 0; x < 16; x++) {
			var pX = pBlockPos.getX() + x;
			for (var z = 0; z < 16; z++) {
				var pZ = pBlockPos.getZ() + z;
				for (var y = 40; y < 48; y++) {
					var blockPos = new BlockPos(pX, y, pZ);
					var belowPos = new BlockPos(pX, y, pZ).below();
					var oldState = pWorldGenLevel.getBlockState(belowPos);
					var newState = oldState.is(IcariaBlocks.MARL.get()) ? IcariaBlocks.GRASSY_MARL.get().defaultBlockState() : oldState;

					this.replaceRelicstone(pWorldGenLevel, blockPos, newState, 10);

					this.setMobsForSpawners(pWorldGenLevel, blockPos, pRandomSource);
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
		if (pWorldGenLevel.getBlockEntity(pBlockPos) instanceof SpawnerBlockEntity blockEntity) {
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

	@Override
	public MapCodec<RuinFeature> codec() {
		return RuinFeature.CODEC;
	}
}
