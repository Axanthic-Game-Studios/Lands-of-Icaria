package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.minecraft.world.level.material.FluidState;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.List;

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

	public boolean canBeGrass(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockPos blockPos = pPos.above();
		BlockState blockState = pLevel.getBlockState(blockPos);
		if ((blockState.is(IcariaBlocks.MOSS_0.get()) || blockState.is(IcariaBlocks.MOSS_1.get()) || blockState.is(IcariaBlocks.MOSS_2.get())) && blockState.getValue(LayerBlock.LAYERS) == 1) {
			return true;
		} else if (blockState.getFluidState().getAmount() == 8) {
			return false;
		} else {
			int i = LayerLightEngine.getLightBlockInto(pLevel, pState, pPos, blockState, blockPos, Direction.UP, blockState.getLightBlock(pLevel, blockPos));
			return i < pLevel.getMaxLightLevel();
		}
	}

	public boolean canPropagate(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return this.canBeGrass(pState, pLevel, pPos) && !pLevel.getFluidState(pPos.above()).is(FluidTags.WATER);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		PlantType plantType = pPlantable.getPlantType(pLevel, pPos.relative(pDirection));
		BlockState plant = pPlantable.getPlant(pLevel, pPos.relative(pDirection));
		if (plantType == PlantType.BEACH) {
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
			return plantType == PlantType.CAVE || plantType == PlantType.PLAINS || plant.is(Blocks.DEAD_BUSH);
		}
	}

	@Override
	public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
		return pLevel.getBlockState(pPos.above()).isAir();
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(MOSSY_0).add(MOSSY_1).add(MOSSY_2);
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, RandomSource pRand, BlockPos pPos, BlockState pState) {
		BlockPos posAbove = pPos.above();
		BlockState blockState = IcariaBlocks.MARL_GRASS.get().defaultBlockState();
		label46:
		for (int i = 0; i < 128; ++i) {
			BlockPos blockPos = posAbove;
			for (int j = 0; j < i / 16; ++j) {
				blockPos = blockPos.offset(pRand.nextInt(3) - 1, (pRand.nextInt(3) - 1) * pRand.nextInt(3) / 2, pRand.nextInt(3) - 1);
				if (!pLevel.getBlockState(blockPos.below()).is(this) || pLevel.getBlockState(blockPos).isCollisionShapeFullBlock(pLevel, blockPos)) {
					continue label46;
				}
			}

			BlockState stateAbove = pLevel.getBlockState(blockPos);
			if (stateAbove.is(blockState.getBlock()) && pRand.nextInt(10) == 0) {
				((BonemealableBlock) blockState.getBlock()).performBonemeal(pLevel, pRand, blockPos, stateAbove);
			}

			if (stateAbove.isAir()) {
				Holder<PlacedFeature> holder;
				if (pRand.nextInt(8) == 0) {
					List<ConfiguredFeature<?, ?>> list = pLevel.getBiome(blockPos).value().getGenerationSettings().getFlowerFeatures();
					if (list.isEmpty()) {
						continue;
					}

					holder = ((RandomPatchConfiguration) list.get(0).config()).feature();
				} else {
					holder = VegetationPlacements.GRASS_BONEMEAL;
				}

				holder.value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRand, blockPos);
			}
		}
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (!this.canBeGrass(pState, pLevel, pPos)) {
			if (!pLevel.isAreaLoaded(pPos, 1)) {
				return;
			}

			pLevel.setBlockAndUpdate(pPos, IcariaBlocks.MARL.get().defaultBlockState());
		} else {
			if (!pLevel.isAreaLoaded(pPos, 3)) {
				return;
			}

			if (pLevel.getMaxLocalRawBrightness(pPos.above()) >= 9) {
				BlockState blockState = this.defaultBlockState();
				for (int i = 0; i < 4; ++i) {
					BlockPos blockPos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
					if (pLevel.getBlockState(blockPos).is(IcariaBlocks.MARL.get()) && this.canPropagate(blockState, pLevel, blockPos)) {
						pLevel.setBlockAndUpdate(blockPos, blockState.setValue(MOSSY_0, pLevel.getBlockState(blockPos.above()).is(IcariaBlocks.MOSS_0.get())).setValue(MOSSY_1, pLevel.getBlockState(blockPos.above()).is(IcariaBlocks.MOSS_1.get())).setValue(MOSSY_2, pLevel.getBlockState(blockPos.above()).is(IcariaBlocks.MOSS_2.get())));
					}
				}
			}
		}
	}

	@Override
	public BlockState getToolModifiedState(BlockState pState, UseOnContext pContext, ToolAction pAction, boolean pSimulate) {
		if (pAction.equals(ToolActions.HOE_TILL) && pContext.getLevel().getBlockState(pContext.getClickedPos().above()).isAir()) {
			return IcariaBlocks.FARMLAND.get().defaultBlockState();
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == Direction.UP ? pState.setValue(MOSSY_0, pNeighborState.is(IcariaBlocks.MOSS_0.get())).setValue(MOSSY_1, pNeighborState.is(IcariaBlocks.MOSS_1.get())).setValue(MOSSY_2, pNeighborState.is(IcariaBlocks.MOSS_2.get())) : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}
}
