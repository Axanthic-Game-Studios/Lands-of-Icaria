package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;
import com.axanthic.icaria.common.entity.StorageVaseBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import com.mojang.serialization.Codec;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VillageFeature extends Feature<NoneFeatureConfiguration> {
	public ArrayList<EntityType<?>> mobs = new ArrayList<>();

	public VillageFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		this.placeWalk(level, origin);

		this.setMobs();

		for (var x = 0; x < 16; x++) {
			var pX = origin.getX() + x;
			for (var z = 0; z < 16; z++) {
				var pZ = origin.getZ() + z;
				for (var y = 8; y < 84; y++) {
					var blockPos = new BlockPos(pX, y, pZ);
					var belowPos = new BlockPos(pX, y, pZ).below();
					var oldState = level.getBlockState(belowPos);
					var newState = oldState.is(IcariaBlocks.MARL.get()) ? IcariaBlocks.GRASSY_MARL.get().defaultBlockState() : oldState;

					this.replace(level, blockPos, newState);
				}

				for (var y = 84; y < 112; y++) {
					var blockPos = new BlockPos(pX, y, pZ);
					var belowPos = new BlockPos(pX, y, pZ).below();
					var oldState = level.getBlockState(belowPos);
					var newState = oldState.is(IcariaBlocks.MARL.get()) ? IcariaBlocks.GRASSY_MARL.get().defaultBlockState() : oldState;

					this.replaceBlocks(level, blockPos, newState);
					this.replaceRuined(level, blockPos);

					this.setLootForChests(level, blockPos, random);
					this.setLootForDecoratedPots(level, blockPos, random);
					this.setLootForStorageVases(level, blockPos, random);
					this.setMobsForSpawners(level, blockPos, random);
				}
			}
		}

		return true;
	}

	public void replace(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.CYAN_CONCRETE) || pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.LIME_CONCRETE) || pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.BLUE_CONCRETE) || pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.PINK_CONCRETE) || pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlocks.RELICSTONE.get()) || pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlocks.SMOOTH_RELICSTONE.get())) {
			this.place(pWorldGenLevel, pBlockPos, pBlockState);
		} else if (pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlockTagsProvider.REPLACE_BLOCKS_ERODED_VILLAGE)) {
			this.place(pWorldGenLevel, pBlockPos, Blocks.AIR.defaultBlockState());
		}
	}

	public void replaceBlocks(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.CYAN_CONCRETE)) {
			this.place(pWorldGenLevel, pBlockPos, pBlockState);
		} else if (pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.LIME_CONCRETE)) {
			this.placeGrainel(pWorldGenLevel, pBlockPos, pBlockState);
		} else if (pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.BLUE_CONCRETE)) {
			this.placeRelicstone(pWorldGenLevel, pBlockPos, pBlockState);
		} else if (pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.PINK_CONCRETE) || pWorldGenLevel.getBlockState(pBlockPos).is(Blocks.GRAY_CONCRETE)) {
			this.place(pWorldGenLevel, pBlockPos, IcariaBlocks.MARL_LIGNITE.get().defaultBlockState());
		}
	}

	public void replaceRuined(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos.below()).isAir() || pWorldGenLevel.getBlockState(pBlockPos.below()).is(Blocks.COBWEB)) { // TODO replace with Icaria Cobweb
			if (pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlockTagsProvider.REPLACE_BLOCKS_RUINED_VILLAGE)) {
				this.place(pWorldGenLevel, pBlockPos, Blocks.AIR.defaultBlockState());
			}
		}
	}

	public void place(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		this.setBlock(pWorldGenLevel, pBlockPos, pBlockState);
	}

	public void placeGrainel(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getRandom().nextInt(10) == 0) {
			this.place(pWorldGenLevel, pBlockPos, pBlockState);
		} else {
			this.place(pWorldGenLevel, pBlockPos, IcariaBlocks.GRAINEL.get().defaultBlockState());
		}
	}

	public void placeRelicstone(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pBlockState) {
		if (pWorldGenLevel.getRandom().nextInt(10) == 0) {
			this.place(pWorldGenLevel, pBlockPos, pBlockState);
		} else {
			this.place(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE.get().defaultBlockState());
		}
	}

	public void placeWalk(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		for (var x = 0; x < 16; x++) {
			for (var z = 0; z < 16; z++) {
				for (var y = 84; y < 96; y++) {
					for (var h = -1; h < 1; h++) {
						for (var direction : Direction.Plane.HORIZONTAL) {
							var blockPos = new BlockPos(pBlockPos.getX() + x, y, pBlockPos.getZ() + z);
							if (pWorldGenLevel.getBlockState(blockPos).is(IcariaBlocks.RELICSTONE.get())) {
								var relative = blockPos.offset(0, h, 0).relative(direction);
								if (pWorldGenLevel.getBlockState(relative).is(Blocks.CYAN_CONCRETE)) {
									this.place(pWorldGenLevel, relative, IcariaBlocks.RELICSTONE.get().defaultBlockState());
								}
							}
						}
					}
				}
			}
		}
	}

	public void setLootForChests(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pWorldGenLevel.getBlockEntity(pBlockPos) instanceof IcariaChestBlockEntity blockEntity) {
			blockEntity.setLootTable(IcariaLootTables.CHEST, pRandomSource.nextLong());
		}
	}

	public void setLootForDecoratedPots(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pWorldGenLevel.getBlockEntity(pBlockPos) instanceof DecoratedPotBlockEntity blockEntity) {
			blockEntity.setLootTable(IcariaLootTables.DECORATED_POT, pRandomSource.nextLong());
		}
	}

	public void setLootForStorageVases(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pWorldGenLevel.getBlockEntity(pBlockPos) instanceof StorageVaseBlockEntity blockEntity) {
			if (pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlocks.RED_STORAGE_VASE.get())) {
				blockEntity.setLootTable(IcariaLootTables.RED_STORAGE_VASE, pRandomSource.nextLong());
			} else if (pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlocks.CYAN_STORAGE_VASE.get())) {
				blockEntity.setLootTable(IcariaLootTables.CYAN_LOOT_VASE, pRandomSource.nextLong());
			}
		}
	}

	public void setMobsForSpawners(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pWorldGenLevel.getBlockEntity(pBlockPos) instanceof IcariaSpawnerBlockEntity blockEntity) {
			if (pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlocks.ARACHNE_SPAWNER.get())) {
				blockEntity.setEntityId(IcariaEntityTypes.ARACHNE_DRONE.get(), pRandomSource);
			} else if (pWorldGenLevel.getBlockState(pBlockPos).is(IcariaBlocks.REVENANT_SPAWNER.get())) {
				blockEntity.setEntityId(this.getMob(pRandomSource), pRandomSource);
			}
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
