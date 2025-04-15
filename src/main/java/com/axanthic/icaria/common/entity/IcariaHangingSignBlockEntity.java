package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaHangingSignBlockEntity extends SignBlockEntity {
	public IcariaHangingSignBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.HANGING_SIGN.get(), pBlockPos, pBlockState);
	}

	@Override
	public int getMaxTextLineWidth() {
		return 60;
	}

	@Override
	public int getTextLineHeight() {
		return 9;
	}

	@Override
	public SoundEvent getSignInteractionFailedSoundEvent() {
		return SoundEvents.WAXED_HANGING_SIGN_INTERACT_FAIL;
	}
}
