package com.axanthic.icaria.common.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestItem extends BlockItem {
	public IcariaChestItem(Block pBlock, Properties pProperties) {
		super(pBlock, pProperties);
	}
}
