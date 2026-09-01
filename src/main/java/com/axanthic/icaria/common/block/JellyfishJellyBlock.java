package com.axanthic.icaria.common.block;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class JellyfishJellyBlock extends SlimeBlock {
	public JellyfishJellyBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean isStickyBlock(BlockState pBlockState) {
		return true;
	}
}
