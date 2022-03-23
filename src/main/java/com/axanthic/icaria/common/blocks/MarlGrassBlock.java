package com.axanthic.icaria.common.blocks;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LayerLightEngine;

import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.List;
import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MarlGrassBlock extends Block implements BonemealableBlock {
	public static final BooleanProperty MOSSY_0 = BooleanProperty.create("mossy_0");
	public static final BooleanProperty MOSSY_1 = BooleanProperty.create("mossy_1");
	public static final BooleanProperty MOSSY_2 = BooleanProperty.create("mossy_2");

	public MarlGrassBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(MOSSY_0, Boolean.FALSE).setValue(MOSSY_1, Boolean.FALSE).setValue(MOSSY_2, Boolean.FALSE));
	}

	public static boolean canBeGrass(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockPos pos = pPos.above();
		BlockState state = pLevel.getBlockState(pos);
		if ((state.is(IcariaBlocks.MOSS_0.get()) || state.is(IcariaBlocks.MOSS_1.get()) || state.is(IcariaBlocks.MOSS_2.get())) && state.getValue(LayerBlock.LAYERS) == 1) {
			return true;
		} else if (state.getFluidState().getAmount() == 8) {
			return false;
		} else {
			int i = LayerLightEngine.getLightBlockInto(pLevel, pState, pPos, state, pos, Direction.UP, state.getLightBlock(pLevel, pos));
			return i < pLevel.getMaxLightLevel();
		}
	}

	public static boolean canPropagate(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return canBeGrass(pState, pLevel, pPos) && !pLevel.getFluidState(pPos.above()).is(FluidTags.WATER);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pFacing, IPlantable pPlantable) {
		PlantType type = pPlantable.getPlantType(pLevel, pPos.relative(pFacing));
		BlockState plant = pPlantable.getPlant(pLevel, pPos.relative(pFacing));
		if (type == PlantType.BEACH) {
			boolean water = false;
			for (Direction direction : Direction.Plane.HORIZONTAL) {
				BlockState blockState = pLevel.getBlockState(pPos.relative(direction));
				FluidState fluidState = pLevel.getFluidState(pPos.relative(direction));
				water |= blockState.is(Blocks.FROSTED_ICE);
				water |= fluidState.is(FluidTags.WATER);
				if (water) {
					break;
				}
			}
			return water;
		} else {
			return type == PlantType.CAVE || type == PlantType.PLAINS || plant.is(Blocks.DEAD_BUSH);
		}
	}

	@Override
	public boolean isBonemealSuccess(Level pLevel, Random pRandom, BlockPos pPos, BlockState pState) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
		return pLevel.getBlockState(pPos.above()).isAir();
	}

	@Override
	public void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(MOSSY_0).add(MOSSY_1).add(MOSSY_2);
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, Random pRand, BlockPos pPos, BlockState pState) {
		BlockPos posOne = pPos.above();
		BlockState stateOne = IcariaBlocks.MARL_GRASS.get().defaultBlockState();

		label46:
		for(int i = 0; i < 128; ++i) {
			BlockPos posTwo = posOne;

			for(int j = 0; j < i / 16; ++j) {
				posTwo = posTwo.offset(pRand.nextInt(3) - 1, (pRand.nextInt(3) - 1) * pRand.nextInt(3) / 2, pRand.nextInt(3) - 1);
				if (!pLevel.getBlockState(posTwo.below()).is(this) || pLevel.getBlockState(posTwo).isCollisionShapeFullBlock(pLevel, posTwo)) {
					continue label46;
				}
			}

			BlockState stateTwo = pLevel.getBlockState(posTwo);
			if (stateTwo.is(stateOne.getBlock()) && pRand.nextInt(10) == 0) {
				((BonemealableBlock)stateOne.getBlock()).performBonemeal(pLevel, pRand, posTwo, stateTwo);
			}

			if (stateTwo.isAir()) {
				Holder<PlacedFeature> holder;
				if (pRand.nextInt(8) == 0) {
					List<ConfiguredFeature<?, ?>> list = pLevel.getBiome(posTwo).value().getGenerationSettings().getFlowerFeatures();
					if (list.isEmpty()) {
						continue;
					}

					holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
				} else {
					holder = VegetationPlacements.GRASS_BONEMEAL;
				}

				holder.value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRand, posTwo);
			}
		}
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
		if (!canBeGrass(pState, pLevel, pPos)) {
			if (!pLevel.isAreaLoaded(pPos, 1))
				return;
			pLevel.setBlockAndUpdate(pPos, IcariaBlocks.MARL.get().defaultBlockState());
		} else {
			if (!pLevel.isAreaLoaded(pPos, 3))
				return;
			if (pLevel.getMaxLocalRawBrightness(pPos.above()) >= 9) {
				BlockState state = this.defaultBlockState();
				for (int i = 0; i < 4; ++i) {
					BlockPos pos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
					if (pLevel.getBlockState(pos).is(IcariaBlocks.MARL.get()) && canPropagate(state, pLevel, pos)) {
						pLevel.setBlockAndUpdate(pos, state.setValue(MOSSY_0, pLevel.getBlockState(pos.above()).is(IcariaBlocks.MOSS_0.get())).setValue(MOSSY_1, pLevel.getBlockState(pos.above()).is(IcariaBlocks.MOSS_1.get())).setValue(MOSSY_2, pLevel.getBlockState(pos.above()).is(IcariaBlocks.MOSS_2.get())));
					}
				}
			}
		}
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == Direction.UP ? pState.setValue(MOSSY_0, pNeighborState.is(IcariaBlocks.MOSS_0.get())).setValue(MOSSY_1, pNeighborState.is(IcariaBlocks.MOSS_1.get())).setValue(MOSSY_2, pNeighborState.is(IcariaBlocks.MOSS_2.get())) : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}
}
