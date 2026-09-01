package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.registry.IcariaPlacedFeatures;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.lighting.LightEngine;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrassyMarlBlock extends Block implements BonemealableBlock {
	public GrassyMarlBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.MOSS, Moss.NONE));
	}

	public boolean canRemain(BlockPos pBlockPos, BlockState pBlockState, LevelReader pLevelReader) {
		var blockState = pLevelReader.getBlockState(pBlockPos.above());
		if (blockState.is(IcariaBlocks.FOREST_MOSS.get()) || blockState.is(IcariaBlocks.SCRUBLAND_MOSS.get()) || blockState.is(IcariaBlocks.STEPPE_MOSS.get())) {
			return true;
		} else if (blockState.getFluidState().getAmount() == 8) {
			return false;
		} else {
			return LightEngine.getLightBlockInto(pBlockState, blockState, Direction.UP, blockState.getLightBlock()) < 15;
		}
	}

	public boolean canSpread(BlockPos pBlockPos, BlockState pBlockState, LevelReader pLevelReader) {
		return this.canRemain(pBlockPos, pBlockState, pLevelReader) && !pLevelReader.getFluidState(pBlockPos.above()).is(FluidTags.WATER);
	}

	@Override
	public boolean isBonemealSuccess(Level pLevel, RandomSource pRandomSource, BlockPos pBlockPos, BlockState pBlockState) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader pLevelReader, BlockPos pBlockPos, BlockState pBlockState) {
		return pLevelReader.getBlockState(pBlockPos.above()).isAir();
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MOSS);
	}

	@Override
	public void performBonemeal(ServerLevel pServerLevel, RandomSource pRandomSource, BlockPos pBlockPos, BlockState pBlockState) {
		for (var i = 0; i < 64; ++i) {
			var blockPos = pBlockPos.offset(pRandomSource.nextInt(3) - 1, pRandomSource.nextInt(3) - 1, pRandomSource.nextInt(3) - 1);
			if (pServerLevel.getBlockState(blockPos).is(this)) {
				var blockPosAbove = blockPos.above();
				if (pServerLevel.getBlockState(blockPosAbove).isAir()) {
					pServerLevel.registryAccess().lookupOrThrow(Registries.PLACED_FEATURE).get(IcariaPlacedFeatures.CALCITE_DUST).ifPresent(reference -> reference.value().place(pServerLevel, pServerLevel.getChunkSource().getGenerator(), pRandomSource, blockPosAbove));
				}
			}
		}
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pServerLevel.isAreaLoaded(pBlockPos, 1)) {
			if (this.canRemain(pBlockPos, pBlockState, pServerLevel)) {
				this.spreadRandom(pBlockPos, pRandomSource, pServerLevel);
			} else {
				pServerLevel.setBlockAndUpdate(pBlockPos, IcariaBlocks.MARL.get().defaultBlockState());
			}
		}
	}

	public void spread(BlockPos pBlockPos, ServerLevel pServerLevel) {
		if (this.canSpread(pBlockPos, this.defaultBlockState(), pServerLevel) && pServerLevel.getBlockState(pBlockPos).is(IcariaBlocks.MARL.get())) {
			if (pServerLevel.getBlockState(pBlockPos.above()).is(IcariaBlocks.FOREST_MOSS.get())) {
				pServerLevel.setBlockAndUpdate(pBlockPos, this.defaultBlockState().setValue(IcariaBlockStateProperties.MOSS, Moss.FOREST));
			} else if (pServerLevel.getBlockState(pBlockPos.above()).is(IcariaBlocks.SCRUBLAND_MOSS.get())) {
				pServerLevel.setBlockAndUpdate(pBlockPos, this.defaultBlockState().setValue(IcariaBlockStateProperties.MOSS, Moss.SCRUBLAND));
			} else if (pServerLevel.getBlockState(pBlockPos.above()).is(IcariaBlocks.STEPPE_MOSS.get())) {
				pServerLevel.setBlockAndUpdate(pBlockPos, this.defaultBlockState().setValue(IcariaBlockStateProperties.MOSS, Moss.STEPPE));
			} else {
				pServerLevel.setBlockAndUpdate(pBlockPos, this.defaultBlockState().setValue(IcariaBlockStateProperties.MOSS, Moss.NONE));
			}
		}
	}

	public void spreadRandom(BlockPos pBlockPos, RandomSource pRandomSource, ServerLevel pServerLevel) {
		for (var i = 0; i < 4; ++i) {
			this.spread(pBlockPos.offset(pRandomSource.nextInt(3) - 1, pRandomSource.nextInt(5) - 3, pRandomSource.nextInt(3) - 1), pServerLevel);
		}
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pDirection == Direction.UP ? pBlockState.setValue(IcariaBlockStateProperties.MOSS, this.moss(pBlockStateFaced)) : super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	public Moss moss(BlockState pBlockState) {
		if (pBlockState.is(IcariaBlocks.FOREST_MOSS.get())) {
			return Moss.FOREST;
		} else if (pBlockState.is(IcariaBlocks.SCRUBLAND_MOSS.get())) {
			return Moss.SCRUBLAND;
		} else if (pBlockState.is(IcariaBlocks.STEPPE_MOSS.get())) {
			return Moss.STEPPE;
		} else {
			return Moss.NONE;
		}
	}
}
