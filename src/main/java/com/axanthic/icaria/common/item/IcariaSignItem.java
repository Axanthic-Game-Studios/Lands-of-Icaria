package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSignItem extends StandingAndWallBlockItem {
	public Block block;

	public IcariaSignItem(Block pBlock, Block pWallBlock, Direction pDirection, Properties pProperties) {
		super(pBlock, pWallBlock, pDirection, pProperties);
		this.block = pBlock;
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
			return this.block.getStateForPlacement(pBlockPlaceContext);
		}
	}
}
