package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaPlacedFeatures;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.lighting.LayerLightEngine;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrassyMarlBlock extends Block implements BonemealableBlock {
	public GrassyMarlBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.FOREST_MOSS, false).setValue(IcariaBlockStateProperties.SCRUBLAND_MOSS, false).setValue(IcariaBlockStateProperties.STEPPE_MOSS, false));
	}

	public boolean canBeGrass(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var abovePos = pPos.above();
		var aboveState = pLevel.getBlockState(abovePos);
		if ((aboveState.is(IcariaBlocks.FOREST_MOSS.get()) || aboveState.is(IcariaBlocks.SCRUBLAND_MOSS.get()) || aboveState.is(IcariaBlocks.STEPPE_MOSS.get())) && aboveState.getValue(BlockStateProperties.LAYERS) == 1) {
			return true;
		} else if (aboveState.getFluidState().getAmount() == 8) {
			return false;
		} else {
			return LayerLightEngine.getLightBlockInto(pLevel, pState, pPos, aboveState, abovePos, Direction.UP, aboveState.getLightBlock(pLevel, abovePos)) < pLevel.getMaxLightLevel();
		}
	}

	public boolean canPropagate(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return this.canBeGrass(pState, pLevel, pPos) && !pLevel.getFluidState(pPos.above()).is(FluidTags.WATER);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		var relativePos = pPos.relative(pDirection);
		var plantType = pPlantable.getPlantType(pLevel, relativePos);
		if (plantType == PlantType.BEACH) {
			boolean water = false;
			for (Direction direction : Direction.Plane.HORIZONTAL) {
				var directionPos = pPos.relative(direction);
				water = pLevel.getBlockState(directionPos).is(Blocks.FROSTED_ICE);
				water |= pLevel.getFluidState(directionPos).is(FluidTags.WATER);
				if (water) {
					break;
				}
			}

			return water;
		} else {
			return plantType == PlantType.CAVE || plantType == PlantType.PLAINS || pPlantable.getPlant(pLevel, relativePos).is(Blocks.DEAD_BUSH);
		}
	}

	@Override
	public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
		return pLevel.getBlockState(pPos.above()).isAir();
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.FOREST_MOSS, IcariaBlockStateProperties.SCRUBLAND_MOSS, IcariaBlockStateProperties.STEPPE_MOSS);
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		var blockState = IcariaBlocks.GRASSY_MARL.get().defaultBlockState();
		var optional = pLevel.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(IcariaPlacedFeatures.ICARIA_BONEMEAL);
		label46:
		for (int i = 0; i < 128; ++i) {
			var abovePos = pPos.above();
			for (int j = 0; j < i / 16; ++j) {
				abovePos = abovePos.offset(pRandom.nextInt(3) - 1, (pRandom.nextInt(3) - 1) * pRandom.nextInt(3) / 2, pRandom.nextInt(3) - 1);
				if (!pLevel.getBlockState(abovePos.below()).is(this) || pLevel.getBlockState(abovePos).isCollisionShapeFullBlock(pLevel, abovePos)) {
					continue label46;
				}
			}

			var aboveState = pLevel.getBlockState(abovePos);
			if (aboveState.is(blockState.getBlock()) && pRandom.nextInt(10) == 0) {
				((BonemealableBlock) blockState.getBlock()).performBonemeal(pLevel, pRandom, abovePos, aboveState);
			}

			if (aboveState.isAir()) {
				if (optional.isEmpty()) {
					continue;
				}

				optional.get().value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, abovePos);
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
				var blockState = this.defaultBlockState();
				for (int i = 0; i < 4; ++i) {
					var blockPos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
					if (pLevel.getBlockState(blockPos).is(IcariaBlocks.MARL.get()) && this.canPropagate(blockState, pLevel, blockPos)) {
						pLevel.setBlockAndUpdate(blockPos, blockState.setValue(IcariaBlockStateProperties.FOREST_MOSS, pLevel.getBlockState(blockPos.above()).is(IcariaBlocks.FOREST_MOSS.get())).setValue(IcariaBlockStateProperties.SCRUBLAND_MOSS, pLevel.getBlockState(blockPos.above()).is(IcariaBlocks.SCRUBLAND_MOSS.get())).setValue(IcariaBlockStateProperties.STEPPE_MOSS, pLevel.getBlockState(blockPos.above()).is(IcariaBlocks.STEPPE_MOSS.get())));
					}
				}
			}
		}
	}

	@Override
	public BlockState getToolModifiedState(BlockState pState, UseOnContext pContext, ToolAction pToolAction, boolean pSimulate) {
		if (pToolAction.equals(ToolActions.HOE_TILL) && pContext.getLevel().getBlockState(pContext.getClickedPos().above()).isAir()) {
			return IcariaBlocks.FARMLAND.get().defaultBlockState();
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return pDirection == Direction.UP ? pState.setValue(IcariaBlockStateProperties.FOREST_MOSS, pNeighborState.is(IcariaBlocks.FOREST_MOSS.get())).setValue(IcariaBlockStateProperties.SCRUBLAND_MOSS, pNeighborState.is(IcariaBlocks.SCRUBLAND_MOSS.get())).setValue(IcariaBlockStateProperties.STEPPE_MOSS, pNeighborState.is(IcariaBlocks.STEPPE_MOSS.get())) : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}
}
