package com.axanthic.icaria.common.blocks;

import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;

public class JellyfishJellyBlock extends SlimeBlock {
	public JellyfishJellyBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean isStickyBlock(BlockState state) {
		return true;
	}
}
