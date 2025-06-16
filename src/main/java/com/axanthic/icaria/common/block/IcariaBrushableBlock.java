package com.axanthic.icaria.common.block;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBrushableBlock extends BrushableBlock {
	public IcariaBrushableBlock(Block pTurnsInto, SoundEvent pBrushSound, SoundEvent pBrushCompleteSound, Properties pProperties) {
		super(pTurnsInto, pBrushSound, pBrushCompleteSound, pProperties);
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pServerLevel.getBlockEntity(pBlockPos) instanceof BrushableBlockEntity brushableBlockEntity) {
			brushableBlockEntity.checkReset(pServerLevel);
		}
	}
}
