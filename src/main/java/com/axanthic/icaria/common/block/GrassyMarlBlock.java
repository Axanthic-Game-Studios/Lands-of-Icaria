package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Moss;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.lighting.BlockLightEngine;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrassyMarlBlock extends Block implements BonemealableBlock {
	public GrassyMarlBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.MOSS, Moss.NONE));
	}

	public boolean canBeGrass(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var abovePos = pPos.above();
		var aboveState = pLevel.getBlockState(abovePos);
		if (aboveState.is(IcariaBlocks.FOREST_MOSS.get()) || aboveState.is(IcariaBlocks.SCRUBLAND_MOSS.get()) || aboveState.is(IcariaBlocks.STEPPE_MOSS.get())) {
			return true;
		} else if (aboveState.getFluidState().getAmount() == 8) {
			return false;
		} else {
			return BlockLightEngine.getLightBlockInto(pLevel, pState, pPos, aboveState, abovePos, Direction.UP, aboveState.getLightBlock(pLevel, abovePos)) < pLevel.getMaxLightLevel();
		}
	}

	public boolean canPropagate(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return this.canBeGrass(pState, pLevel, pPos) && !pLevel.getFluidState(pPos.above()).is(FluidTags.WATER);
	}

	@Override
	public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState) {
		return pLevel.getBlockState(pPos.above()).isAir();
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MOSS);
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		var block = IcariaBlocks.GRASSY_MARL.get().defaultBlockState().getBlock();
		var abovePos = pPos.above();
		var optional = pLevel.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(IcariaPlacedFeatures.ICARIA_BONEMEAL);
		var aboveState = pLevel.getBlockState(abovePos);
		label46:
		for (int i = 0; i < 128; ++i) {
			for (int j = 0; j < i / 16; ++j) {
				abovePos = abovePos.offset(pRandom.nextInt(3) - 1, (pRandom.nextInt(3) - 1) * pRandom.nextInt(3) / 2, pRandom.nextInt(3) - 1);
				if (!pLevel.getBlockState(abovePos.below()).is(this) || pLevel.getBlockState(abovePos).isCollisionShapeFullBlock(pLevel, abovePos)) {
					continue label46;
				}
			}

			if (aboveState.is(block)) {
				if (pRandom.nextInt(10) == 0) {
					if (block instanceof BonemealableBlock bonemealableBlock) {
						bonemealableBlock.performBonemeal(pLevel, pRandom, abovePos, aboveState);
					}
				}
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
		if (this.canBeGrass(pState, pLevel, pPos)) {
			if (pLevel.isAreaLoaded(pPos, 3)) {
				for (int i = 0; i < 4; ++i) {
					var blockState = this.defaultBlockState();
					var blockPos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
					var abovePos = blockPos.above();
					if (this.canPropagate(blockState, pLevel, blockPos)) {
						if (pLevel.getBlockState(blockPos).is(IcariaBlocks.MARL.get())) {
							if (pLevel.getBlockState(abovePos).is(IcariaBlocks.FOREST_MOSS.get())) {
								pLevel.setBlockAndUpdate(blockPos, blockState.setValue(IcariaBlockStateProperties.MOSS, Moss.FOREST));
							} else if (pLevel.getBlockState(abovePos).is(IcariaBlocks.SCRUBLAND_MOSS.get())) {
								pLevel.setBlockAndUpdate(blockPos, blockState.setValue(IcariaBlockStateProperties.MOSS, Moss.SCRUBLAND));
							} else if (pLevel.getBlockState(abovePos).is(IcariaBlocks.STEPPE_MOSS.get())) {
								pLevel.setBlockAndUpdate(blockPos, blockState.setValue(IcariaBlockStateProperties.MOSS, Moss.STEPPE));
							} else {
								pLevel.setBlockAndUpdate(blockPos, blockState.setValue(IcariaBlockStateProperties.MOSS, Moss.NONE));
							}
						}
					}
				}
			}
		} else {
			if (pLevel.isAreaLoaded(pPos, 1)) {
				pLevel.setBlockAndUpdate(pPos, IcariaBlocks.MARL.get().defaultBlockState());
			}
		}
	}

	@Override
	public BlockState getToolModifiedState(BlockState pState, UseOnContext pContext, ItemAbility pToolAction, boolean pSimulate) {
		if (pToolAction.equals(ItemAbilities.HOE_TILL) && pContext.getLevel().getBlockState(pContext.getClickedPos().above()).isAir()) {
			return IcariaBlocks.FARMLAND.get().defaultBlockState();
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		if (pDirection == Direction.UP) {
			if (pNeighborState.is(IcariaBlocks.FOREST_MOSS.get())) {
				pLevel.setBlock(pCurrentPos, pState.setValue(IcariaBlockStateProperties.MOSS, Moss.FOREST), 3);
			} else if (pNeighborState.is(IcariaBlocks.SCRUBLAND_MOSS.get())) {
				pLevel.setBlock(pCurrentPos, pState.setValue(IcariaBlockStateProperties.MOSS, Moss.SCRUBLAND), 3);
			} else if (pNeighborState.is(IcariaBlocks.STEPPE_MOSS.get())) {
				pLevel.setBlock(pCurrentPos, pState.setValue(IcariaBlockStateProperties.MOSS, Moss.STEPPE), 3);
			} else {
				pLevel.setBlock(pCurrentPos, pState.setValue(IcariaBlockStateProperties.MOSS, Moss.NONE), 3);
			}
		}

		return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}
}
