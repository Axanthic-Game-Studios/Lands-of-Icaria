package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.mixin.FireBlockAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class IcariaFlammables {
	public static void flammableBlock(Block block, int flameOdds, int burnOdds) {
		FireBlock fireBlock = (FireBlock) Blocks.FIRE;
		((FireBlockAccess) fireBlock).accessableFlammable(block, flameOdds, burnOdds);
	}

	public static void setup() {
		flammableBlock(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), 30, 60);
		flammableBlock(IcariaBlocks.SPELT_BALE_BLOCK.get(), 60, 20);
		flammableBlock(IcariaBlocks.VINE_REED_BLOCK.get(), 5, 20);
		flammableBlock(IcariaBlocks.VINE_SPROUT_BLOCK.get(), 5, 20);
	}
}
