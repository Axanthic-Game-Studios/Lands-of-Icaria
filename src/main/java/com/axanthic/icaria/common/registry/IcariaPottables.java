package com.axanthic.icaria.common.registry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class IcariaPottables {
	public static void setup() {
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(IcariaBlocks.CYPRESS_SAPLING.getId(), IcariaBlocks.POTTED_CYPRESS_SAPLING);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(IcariaBlocks.DROUGHTROOT_SAPLING.getId(), IcariaBlocks.POTTED_DROUGHTROOT_SAPLING);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(IcariaBlocks.FIR_SAPLING.getId(), IcariaBlocks.POTTED_FIR_SAPLING);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(IcariaBlocks.LAUREL_SAPLING.getId(), IcariaBlocks.POTTED_LAUREL_SAPLING);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(IcariaBlocks.OLIVE_SAPLING.getId(), IcariaBlocks.POTTED_OLIVE_SAPLING);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(IcariaBlocks.PLANE_SAPLING.getId(), IcariaBlocks.POTTED_PLANE_SAPLING);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(IcariaBlocks.POPULUS_SAPLING.getId(), IcariaBlocks.POTTED_POPULUS_SAPLING);
	}
}
