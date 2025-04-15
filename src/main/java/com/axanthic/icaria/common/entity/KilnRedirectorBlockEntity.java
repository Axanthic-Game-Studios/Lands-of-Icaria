package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import net.neoforged.neoforge.items.IItemHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnRedirectorBlockEntity extends BlockEntity {
	public KilnRedirectorBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.KILN_REDIRECTOR.get(), pBlockPos, pBlockState);
	}

	@Nullable
	public static IItemHandler getCapability(KilnRedirectorBlockEntity pBlockEntity, Direction pDirection) {
		var blockPos = pBlockEntity.getBlockPos();
		var level = pBlockEntity.getLevel();
		if (level != null) {
			if (level.getBlockEntity(blockPos.below()) instanceof KilnBlockEntity kilnBlockEntity) {
				if (level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING).getClockWise() == pDirection) {
					if (level.getBlockState(blockPos).getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER) {
						return kilnBlockEntity.inputHandler;
					}
				}
			}
		}

		return null;
	}
}
