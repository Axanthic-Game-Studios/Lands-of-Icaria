package com.axanthic.icaria.datagen;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.axanthic.icaria.IcariaInfo;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class IcariaLootTables extends LootTableProvider {

	private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> lootTables = ImmutableList.of(Pair.of(IcariaBlockLootTables::new, LootContextParamSets.BLOCK));

	public IcariaLootTables(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
		return lootTables;
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
		map.forEach((loc, table) -> LootTables.validate(validationtracker, loc, table));
		// Remove vanilla's tables, which we also loaded so we can redirect stuff to them.
		// This ensures the remaining generator logic doesn't write those to files.
		map.keySet().removeIf((loc) -> !loc.getNamespace().equals(IcariaInfo.MODID));
	}

	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public String getName() {
		return IcariaInfo.MODID + " LootTables";
	}
}
