package com.axanthic.icaria.datagen;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.DecoItemBlockCombination;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class IcariaBlockLootTables extends BlockLoot {

	@Nonnull
	@Override
	protected Iterable<Block> getKnownBlocks() {
		List<Block> blocks = new ArrayList<Block>();
		for (RegistryObject<? extends Block> basicBlock : IcariaBlocks.BASIC_BLOCKS) {
			blocks.add(basicBlock.get());
		}
		for (DecoItemBlockCombination deco : IcariaItems.DECO_BLOCKS) {
			if (deco.SLAB != null) {
				blocks.add(deco.block.SLAB.get());
			}
			if (deco.STAIRS != null) {
				blocks.add(deco.block.STAIRS.get());
			}
			if (deco.WALL != null) {
				blocks.add(deco.block.WALL.get());
			}
		}
		return blocks;
		//return ForgeRegistries.BLOCKS.getValues().stream().filter((block) -> LandsOfIcariaInfo.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace())).collect(Collectors.toList());
	}

	@Override
	protected void addTables() {
		for (RegistryObject<? extends Block> basicBlock : IcariaBlocks.BASIC_BLOCKS) {
			dropSelf(basicBlock.get());
		}
		for (DecoItemBlockCombination deco : IcariaItems.DECO_BLOCKS) {
			if (deco.SLAB != null) {
				add(deco.block.SLAB.get(), BlockLoot::createSlabItemTable);
			}
			if (deco.STAIRS != null) {
				dropSelf(deco.block.STAIRS.get());
			}
			if (deco.WALL != null) {
				dropSelf(deco.block.WALL.get());
			}
		}

		/*add(LandsOfIcariaBlocks.MARL_GRASS.get(), (p_124191_) -> {
			return createSingleItemTableWithSilkTouch(p_124191_, LandsOfIcariaItems.MARL.get());
		});*/
	}
}
