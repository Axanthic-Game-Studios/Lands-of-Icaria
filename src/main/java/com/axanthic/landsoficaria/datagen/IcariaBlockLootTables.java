package com.axanthic.landsoficaria.datagen;

import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class IcariaBlockLootTables extends BlockLoot {

	@Nonnull
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream()
				.filter((block) -> LandsOfIcariaInfo.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
				.collect(Collectors.toList());
	}

	@Override
	protected void addTables() {

	}
}
