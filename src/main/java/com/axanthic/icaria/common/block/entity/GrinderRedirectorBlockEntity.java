package com.axanthic.icaria.common.block.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import net.neoforged.neoforge.items.IItemHandler;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderRedirectorBlockEntity extends BlockEntity {
	public GrinderRedirectorBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.GRINDER_REDIRECTOR.get(), pPos, pState);
	}

	public static @Nullable IItemHandler getCapability(GrinderRedirectorBlockEntity pBlockEntity, Direction pDirection) {
		var blockPos = pBlockEntity.getBlockPos();
		var level = pBlockEntity.getLevel();
		if (level != null) {
			if (level.getBlockEntity(blockPos.relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING).getClockWise())) instanceof GrinderBlockEntity grinderBlockEntity) {
				if (level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite() == pDirection) {
					return grinderBlockEntity.fuelHandler;
				} else if (pDirection == Direction.UP) {
					return grinderBlockEntity.inputHandler;
				} else if (pDirection == Direction.DOWN) {
					return grinderBlockEntity.outputHandler;
				}
			}
		}

		return null;
	}
}
