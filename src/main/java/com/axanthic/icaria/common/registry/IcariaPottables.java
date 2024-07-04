package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPottables {

	public static void setup() {
		IcariaPottables.set(IcariaBlocks.CYPRESS_SAPLING.get(), IcariaBlocks.POTTED_CYPRESS_SAPLING);
		IcariaPottables.set(IcariaBlocks.DROUGHTROOT_SAPLING.get(), IcariaBlocks.POTTED_DROUGHTROOT_SAPLING);
		IcariaPottables.set(IcariaBlocks.FIR_SAPLING.get(), IcariaBlocks.POTTED_FIR_SAPLING);
		IcariaPottables.set(IcariaBlocks.LAUREL_SAPLING.get(), IcariaBlocks.POTTED_LAUREL_SAPLING);
		IcariaPottables.set(IcariaBlocks.OLIVE_SAPLING.get(), IcariaBlocks.POTTED_OLIVE_SAPLING);
		IcariaPottables.set(IcariaBlocks.PLANE_SAPLING.get(), IcariaBlocks.POTTED_PLANE_SAPLING);
		IcariaPottables.set(IcariaBlocks.POPULUS_SAPLING.get(), IcariaBlocks.POTTED_POPULUS_SAPLING);
		IcariaPottables.set(IcariaBlocks.FERN.get(), IcariaBlocks.POTTED_FERN);
		IcariaPottables.set(IcariaBlocks.BLINDWEED.get(), IcariaBlocks.POTTED_BLINDWEED);
		IcariaPottables.set(IcariaBlocks.CHAMEOMILE.get(), IcariaBlocks.POTTED_CHAMEOMILE);
		IcariaPottables.set(IcariaBlocks.CHARMONDER.get(), IcariaBlocks.POTTED_CHARMONDER);
		IcariaPottables.set(IcariaBlocks.CLOVER.get(), IcariaBlocks.POTTED_CLOVER);
		IcariaPottables.set(IcariaBlocks.FIREHILT.get(), IcariaBlocks.POTTED_FIREHILT);
		IcariaPottables.set(IcariaBlocks.BLUE_HYDRACINTH.get(), IcariaBlocks.POTTED_BLUE_HYDRACINTH);
		IcariaPottables.set(IcariaBlocks.PURPLE_HYDRACINTH.get(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH);
		IcariaPottables.set(IcariaBlocks.LIONFANGS.get(), IcariaBlocks.POTTED_LIONFANGS);
		IcariaPottables.set(IcariaBlocks.SPEARDROPS.get(), IcariaBlocks.POTTED_SPEARDROPS);
		IcariaPottables.set(IcariaBlocks.PURPLE_STAGHORN.get(), IcariaBlocks.POTTED_PURPLE_STAGHORN);
		IcariaPottables.set(IcariaBlocks.YELLOW_STAGHORN.get(), IcariaBlocks.POTTED_YELLOW_STAGHORN);
		IcariaPottables.set(IcariaBlocks.BLUE_STORMCOTTON.get(), IcariaBlocks.POTTED_BLUE_STORMCOTTON);
		IcariaPottables.set(IcariaBlocks.PINK_STORMCOTTON.get(), IcariaBlocks.POTTED_PINK_STORMCOTTON);
		IcariaPottables.set(IcariaBlocks.PURPLE_STORMCOTTON.get(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON);
		IcariaPottables.set(IcariaBlocks.SUNKETTLE.get(), IcariaBlocks.POTTED_SUNKETTLE);
		IcariaPottables.set(IcariaBlocks.SUNSPONGE.get(), IcariaBlocks.POTTED_SUNSPONGE);
		IcariaPottables.set(IcariaBlocks.VOIDLILY.get(), IcariaBlocks.POTTED_VOIDLILY);
		IcariaPottables.set(IcariaBlocks.PALM_FERN.get(), IcariaBlocks.POTTED_PALM_FERN);
		IcariaPottables.set(IcariaBlocks.WHITE_BROMELIA.get(), IcariaBlocks.POTTED_WHITE_BROMELIA);
		IcariaPottables.set(IcariaBlocks.ORANGE_BROMELIA.get(), IcariaBlocks.POTTED_ORANGE_BROMELIA);
		IcariaPottables.set(IcariaBlocks.PINK_BROMELIA.get(), IcariaBlocks.POTTED_PINK_BROMELIA);
		IcariaPottables.set(IcariaBlocks.PURPLE_BROMELIA.get(), IcariaBlocks.POTTED_PURPLE_BROMELIA);
		IcariaPottables.set(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS);
		IcariaPottables.set(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS);
		IcariaPottables.set(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS);
		IcariaPottables.set(IcariaBlocks.CARDON_CACTUS.get(), IcariaBlocks.POTTED_CARDON_CACTUS);
	}

	public static void set(Block pBlock, Supplier<? extends Block> pSupplier) {
		if (Blocks.FLOWER_POT instanceof FlowerPotBlock flowerPotBlock) {
			flowerPotBlock.addPlant(BuiltInRegistries.BLOCK.getKey(pBlock), pSupplier);
		}
	}
}
