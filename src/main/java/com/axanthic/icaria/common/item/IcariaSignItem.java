package com.axanthic.icaria.common.item;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSignItem extends SignItem {
	public Block blockStanding;

	public IcariaSignItem(Block pBlockStanding, Block pBlockWall, Properties pProperties) {
		super(pBlockStanding, pBlockWall, pProperties);
		this.blockStanding = pBlockStanding;
	}

	@Nullable
	@Override
	public BlockState getPlacementState(BlockPlaceContext pBlockPlaceContext) {
		var player = pBlockPlaceContext.getPlayer();
		if (pBlockPlaceContext.getClickedFace() != Direction.UP) {
			return this.wallBlock.getStateForPlacement(pBlockPlaceContext);
		} else if (player != null && player.isShiftKeyDown()) {
			return this.wallBlock.getStateForPlacement(pBlockPlaceContext);
		} else {
			return this.blockStanding.getStateForPlacement(pBlockPlaceContext);
		}
	}
}
