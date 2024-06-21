package com.axanthic.icaria.common.block;

import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class JellyfishJellyBlock extends SlimeBlock {
	public JellyfishJellyBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean isStickyBlock(BlockState pState) {
		return true;
	}
}
