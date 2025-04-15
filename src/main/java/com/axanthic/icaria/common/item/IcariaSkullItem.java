package com.axanthic.icaria.common.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullItem extends StandingAndWallBlockItem {
	public IcariaSkullItem(Block pBlockStanding, Block pBlockWall, Direction pDirection, Properties pProperties) {
		super(pBlockStanding, pBlockWall, pDirection, pProperties);
	}
}
