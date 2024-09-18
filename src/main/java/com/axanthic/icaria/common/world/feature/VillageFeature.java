package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;
import com.axanthic.icaria.common.entity.StorageVaseBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaLootTables;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VillageFeature extends Feature<NoneFeatureConfiguration> {
	public ArrayList<EntityType<?>> mobs = new ArrayList<>();

	public VillageFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
		var level = pContext.level();
		var origin = pContext.origin();
		var random = pContext.random();

		this.placeWalk(level, origin);

		this.setMobs();

		for (int x = 0; x < 16; x++) {
			int pX = origin.getX() + x;
			for (int z = 0; z < 16; z++) {
				int pZ = origin.getZ() + z;
				for (int y = 8; y < 84; y++) {
					var blockPos = new BlockPos(pX, y, pZ);
					var belowPos = new BlockPos(pX, y, pZ).below();
					var oldState = level.getBlockState(belowPos);
					var newState = oldState.is(IcariaBlocks.MARL.get()) ? IcariaBlocks.GRASSY_MARL.get().defaultBlockState() : oldState;

					this.replace(level, blockPos, newState);
				}

				for (int y = 84; y < 112; y++) {
					var blockPos = new BlockPos(pX, y, pZ);
					var belowPos = new BlockPos(pX, y, pZ).below();
					var oldState = level.getBlockState(belowPos);
					var newState = oldState.is(IcariaBlocks.MARL.get()) ? IcariaBlocks.GRASSY_MARL.get().defaultBlockState() : oldState;

					this.replaceBlocks(level, blockPos, newState);
					this.replaceRuined(level, blockPos);

					this.setLootForChest(level, blockPos, random);
					this.setLootForVases(level, blockPos, random);
					this.setMobsForSpawners(level, blockPos, random);
				}
			}
		}

		return true;
	}

	public void replace(WorldGenLevel pLevel, BlockPos pPos, BlockState pState) {
		if (pLevel.getBlockState(pPos).is(Blocks.CYAN_CONCRETE) || pLevel.getBlockState(pPos).is(Blocks.LIME_CONCRETE) || pLevel.getBlockState(pPos).is(Blocks.BLUE_CONCRETE) || pLevel.getBlockState(pPos).is(Blocks.PINK_CONCRETE) || pLevel.getBlockState(pPos).is(IcariaBlocks.RELICSTONE.get()) || pLevel.getBlockState(pPos).is(IcariaBlocks.SMOOTH_RELICSTONE.get())) {
			this.place(pLevel, pPos, pState);
		} else if (pLevel.getBlockState(pPos).is(IcariaBlockTags.VILLAGE_REPLACE_BLOCKS)) {
			this.place(pLevel, pPos, Blocks.AIR.defaultBlockState());
		}
	}

	public void replaceBlocks(WorldGenLevel pLevel, BlockPos pPos, BlockState pState) {
		if (pLevel.getBlockState(pPos).is(Blocks.CYAN_CONCRETE)) {
			this.place(pLevel, pPos, pState);
		} else if (pLevel.getBlockState(pPos).is(Blocks.LIME_CONCRETE)) {
			this.placeGrainel(pLevel, pPos, pState);
		} else if (pLevel.getBlockState(pPos).is(Blocks.BLUE_CONCRETE)) {
			this.placeRelicstone(pLevel, pPos, pState);
		} else if (pLevel.getBlockState(pPos).is(Blocks.PINK_CONCRETE) || pLevel.getBlockState(pPos).is(Blocks.GRAY_CONCRETE)) {
			this.place(pLevel, pPos, IcariaBlocks.MARL_LIGNITE.get().defaultBlockState());
		}
	}

	public void replaceRuined(WorldGenLevel pLevel, BlockPos pPos) {
		if (pLevel.getBlockState(pPos.below()).isAir() || pLevel.getBlockState(pPos.below()).is(Blocks.COBWEB)) {
			if (pLevel.getBlockState(pPos).is(IcariaBlockTags.RUINED_VILLAGE_REPLACE_BLOCKS)) {
				this.place(pLevel, pPos, Blocks.AIR.defaultBlockState());
			}
		}
	}

	public void place(WorldGenLevel pLevel, BlockPos pPos, BlockState pState) {
		this.setBlock(pLevel, pPos, pState);
	}

	public void placeGrainel(WorldGenLevel pLevel, BlockPos pPos, BlockState pState) {
		if (pLevel.getRandom().nextInt(10) == 0) {
			this.place(pLevel, pPos, pState);
		} else {
			this.place(pLevel, pPos, IcariaBlocks.GRAINEL.get().defaultBlockState());
		}
	}

	public void placeRelicstone(WorldGenLevel pLevel, BlockPos pPos, BlockState pState) {
		if (pLevel.getRandom().nextInt(10) == 0) {
			this.place(pLevel, pPos, pState);
		} else {
			this.place(pLevel, pPos, IcariaBlocks.RELICSTONE.get().defaultBlockState());
		}
	}

	public void placeWalk(WorldGenLevel pLevel, BlockPos pPos) {
		for (int i = 0; i < 6; i++) {
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					for (int y = 84; y < 96; y++) {
						for (int h = -1; h < 1; h++) {
							for (var direction : Direction.Plane.HORIZONTAL) {
								var blockPos = new BlockPos(pPos.getX() + x, y, pPos.getZ() + z);
								if (pLevel.getBlockState(blockPos).is(IcariaBlocks.RELICSTONE.get())) {
									var relative = blockPos.offset(0, h, 0).relative(direction);
									if (pLevel.getBlockState(relative).is(Blocks.CYAN_CONCRETE)) {
										this.place(pLevel, relative, IcariaBlocks.RELICSTONE.get().defaultBlockState());
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void setLootForChest(WorldGenLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pLevel.getBlockEntity(pPos) instanceof IcariaChestBlockEntity blockEntity) {
			blockEntity.setLootTable(IcariaLootTables.CHEST_LOOT, pRandom.nextLong());
		}
	}

	public void setLootForVases(WorldGenLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pLevel.getBlockEntity(pPos) instanceof StorageVaseBlockEntity blockEntity) {
			if (pLevel.getBlockState(pPos).is(IcariaBlocks.RED_STORAGE_VASE.get())) {
				blockEntity.setLootTable(IcariaLootTables.RED_STORAGE_VASE_LOOT, pRandom.nextLong());
			} else if (pLevel.getBlockState(pPos).is(IcariaBlocks.CYAN_STORAGE_VASE.get())) {
				blockEntity.setLootTable(IcariaLootTables.CYAN_LOOT_VASE_LOOT, pRandom.nextLong());
			}
		}
	}

	public void setMobsForSpawners(WorldGenLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pLevel.getBlockEntity(pPos) instanceof IcariaSpawnerBlockEntity blockEntity) {
			if (pLevel.getBlockState(pPos).is(IcariaBlocks.ARACHNE_SPAWNER.get())) {
				blockEntity.setEntityId(IcariaEntityTypes.ARACHNE_DRONE.get(), pRandom);
			} else if (pLevel.getBlockState(pPos).is(IcariaBlocks.REVENANT_SPAWNER.get())) {
				blockEntity.setEntityId(this.getMob(pRandom), pRandom);
			}
		}
	}

	public void setMobs() {
		this.mobs.add(IcariaEntityTypes.CIVILIAN_REVENANT.get());
		this.mobs.add(IcariaEntityTypes.PYROMANCER_REVENANT.get());
		this.mobs.add(IcariaEntityTypes.SOLDIER_REVENANT.get());
	}

	public EntityType<?> getMob(RandomSource pRandom) {
		return this.mobs.get(pRandom.nextInt(this.mobs.size()));
	}
}
