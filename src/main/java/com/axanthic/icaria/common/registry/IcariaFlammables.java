package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.mixin.FireBlockMixin;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFlammables {

	public static void setup() {
		IcariaFlammables.set(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.SPELT_BALE_BLOCK.get(), 60, 20);
		IcariaFlammables.set(IcariaBlocks.VINE_REED_BLOCK.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_TWIGS.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DEAD_CYPRESS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_PLANKS.get(), 5 ,20);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_DECO.slab.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_DECO.stairs.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_DECO.fence.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.CYPRESS_DECO.gate.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_TWIGS.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_PLANKS.get(), 5 ,20);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_DECO.slab.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_DECO.stairs.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_DECO.fence.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.DROUGHTROOT_DECO.gate.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.FIR_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FALLEN_FIR_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FIR_TWIGS.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FIR_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_FIR_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.FIR_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_FIR_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DEAD_FIR_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.FIR_PLANKS.get(), 5 ,20);
		IcariaFlammables.set(IcariaBlocks.FIR_DECO.slab.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.FIR_DECO.stairs.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.FIR_DECO.fence.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.FIR_DECO.gate.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.LAUREL_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.LAUREL_TWIGS.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.LAUREL_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.LAUREL_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DEAD_LAUREL_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.LAUREL_PLANKS.get(), 5 ,20);
		IcariaFlammables.set(IcariaBlocks.LAUREL_DECO.slab.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.LAUREL_DECO.stairs.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.LAUREL_DECO.fence.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.LAUREL_DECO.gate.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.OLIVE_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.OLIVE_TWIGS.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.OLIVE_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.OLIVE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DEAD_OLIVE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.OLIVE_PLANKS.get(), 5 ,20);
		IcariaFlammables.set(IcariaBlocks.OLIVE_DECO.slab.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.OLIVE_DECO.stairs.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.OLIVE_DECO.fence.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.OLIVE_DECO.gate.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.PLANE_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.PLANE_TWIGS.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.PLANE_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.PLANE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_PLANE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DEAD_PLANE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.PLANE_PLANKS.get(), 5 ,20);
		IcariaFlammables.set(IcariaBlocks.PLANE_DECO.slab.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.PLANE_DECO.stairs.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.PLANE_DECO.fence.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.PLANE_DECO.gate.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.POPULUS_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.POPULUS_TWIGS.get(), 30, 60);
		IcariaFlammables.set(IcariaBlocks.POPULUS_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.POPULUS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.DEAD_POPULUS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), 5 ,5);
		IcariaFlammables.set(IcariaBlocks.POPULUS_PLANKS.get(), 5 ,20);
		IcariaFlammables.set(IcariaBlocks.POPULUS_DECO.slab.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.POPULUS_DECO.stairs.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.POPULUS_DECO.fence.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.POPULUS_DECO.gate.get(), 5, 20);
		IcariaFlammables.set(IcariaBlocks.BLOOMY_VINE.get(), 15, 100);
		IcariaFlammables.set(IcariaBlocks.BRANCHY_VINE.get(), 15, 100);
		IcariaFlammables.set(IcariaBlocks.BRUSHY_VINE.get(), 15, 100);
		IcariaFlammables.set(IcariaBlocks.DRY_VINE.get(), 15, 100);
		IcariaFlammables.set(IcariaBlocks.REEDY_VINE.get(), 15, 100);
		IcariaFlammables.set(IcariaBlocks.SWIRLY_VINE.get(), 15, 100);
		IcariaFlammables.set(IcariaBlocks.THORNY_VINE.get(), 15, 100);
		IcariaFlammables.set(IcariaBlocks.FERN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.SMALL_GRASS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.MEDIUM_GRASS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.LARGE_GRASS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.SMALL_MIXED_GRAIN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.MEDIUM_MIXED_GRAIN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.MEDIUM_BROWN_GRAIN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.MEDIUM_WHITE_GRAIN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.LARGE_BROWN_GRAIN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.BLINDWEED.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.CHAMEOMILE.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.CHARMONDER.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.CLOVER.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.FIREHILT.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.BLUE_HYDRACINTH.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PURPLE_HYDRACINTH.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.LIONFANGS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.SPEARDROPS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PURPLE_STAGHORN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.YELLOW_STAGHORN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.BLUE_STORMCOTTON.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PINK_STORMCOTTON.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PURPLE_STORMCOTTON.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.SUNKETTLE.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.SUNSPONGE.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.VOIDLILY.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.BOLBOS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.DATHULLA.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.MONDANOS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.MOTH_AGARIC.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.NAMDRAKE.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PSILOCYBOS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.ROWAN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.WILTED_ELM.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PINK_GROUND_FLOWERS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.RED_GROUND_FLOWERS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PALM_FERN.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.WHITE_BROMELIA.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.ORANGE_BROMELIA.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PINK_BROMELIA.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.PURPLE_BROMELIA.get(), 60, 100);
		IcariaFlammables.set(IcariaBlocks.STRAWBERRY_BUSH.get(), 60, 100);
	}

	public static void set(Block pBlock, int pEncouragement, int pFlammability) {
		if (Blocks.FIRE instanceof FireBlock fireBlock) {
			if (fireBlock instanceof FireBlockMixin fireBlockMixin) {
				fireBlockMixin.setIcariaFlammables(pBlock, pEncouragement, pFlammability);
			}
		}
	}
}
