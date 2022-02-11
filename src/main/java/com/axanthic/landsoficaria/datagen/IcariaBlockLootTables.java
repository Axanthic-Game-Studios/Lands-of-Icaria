package com.axanthic.landsoficaria.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaBlocks;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems.DecoItemBlockCombination;
import com.google.common.collect.Sets;

import net.minecraft.core.Registry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaBlockLootTables extends BlockLoot {

	@Nonnull
	@Override
	protected Iterable<Block> getKnownBlocks() {
		List<Block> blocks = new ArrayList<Block>();
		for (RegistryObject<? extends Block> basicBlock : LandsOfIcariaBlocks.BASIC_BLOCKS) {
			blocks.add(basicBlock.get());
		}
		for (DecoItemBlockCombination deco : LandsOfIcariaItems.DECO_BLOCKS) {
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
		for (RegistryObject<? extends Block> basicBlock : LandsOfIcariaBlocks.BASIC_BLOCKS) {
			dropSelf(basicBlock.get());
		}
		for (DecoItemBlockCombination deco : LandsOfIcariaItems.DECO_BLOCKS) {
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

	@Override
	public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_124179_) {
		try {
			super.accept(p_124179_);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
