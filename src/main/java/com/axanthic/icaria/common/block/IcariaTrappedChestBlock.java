package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaTrappedChestBlockEntity;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTrappedChestBlock extends IcariaChestBlock {
	public IcariaTrappedChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> pBlockEntityType, Properties pProperties) {
		super(pBlockEntityType, pProperties);
	}

	@Override
	public boolean isSignalSource(BlockState pBlockState) {
		return true;
	}

	@Override
	public int getDirectSignal(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Direction pDirection) {
		return pDirection == Direction.UP ? pBlockState.getSignal(pBlockGetter, pBlockPos, pDirection) : 0;
	}

	@Override
	public int getSignal(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Direction pDirection) {
		return Mth.clamp(ChestBlockEntity.getOpenCount(pBlockGetter, pBlockPos), 0, 15);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaTrappedChestBlockEntity(pBlockPos, pBlockState);
	}

	@Override
	public Stat<ResourceLocation> getOpenChestStat() {
		return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
	}
}
