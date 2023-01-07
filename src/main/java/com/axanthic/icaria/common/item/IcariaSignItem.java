package com.axanthic.icaria.common.item;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSignItem extends SignItem {
	public Block standingBlock;

	public IcariaSignItem(Properties pProperties, Block pStandingBlock, Block pWallBlock) {
		super(pProperties, pStandingBlock, pWallBlock);
		this.standingBlock = pStandingBlock;
	}

	@Override
	public BlockState getPlacementState(BlockPlaceContext pContext) {
		BlockState standingBlock = this.standingBlock.getStateForPlacement(pContext);
		BlockState wallBlock = this.wallBlock.getStateForPlacement(pContext);
		Player player = pContext.getPlayer();
		if (pContext.getClickedFace() != Direction.UP) {
			return wallBlock;
		}

		if (pContext.getClickedFace() == Direction.UP) {
			if (player != null) {
				if (player.isShiftKeyDown()) {
					return wallBlock;
				}
			}
		}

		return standingBlock;
	}
}
