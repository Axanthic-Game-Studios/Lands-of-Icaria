package com.axanthic.icaria.data.provider.loot;

import com.axanthic.icaria.data.registry.IcariaLootTables;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaAmphoraLootSubProvider(HolderLookup.Provider pProvider) implements LootTableSubProvider {

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pBiConsumer) {
		pBiConsumer.accept(IcariaLootTables.SINGLE_AMPHORA, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
				.add(LootItem.lootTableItem(Items.FERMENTED_SPIDER_EYE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
			)
		);

		pBiConsumer.accept(IcariaLootTables.DOUBLE_AMPHORA, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
				.add(LootItem.lootTableItem(Items.FERMENTED_SPIDER_EYE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
			)
		);

		pBiConsumer.accept(IcariaLootTables.TRIPLE_AMPHORA, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
				.add(LootItem.lootTableItem(Items.FERMENTED_SPIDER_EYE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
			)
		);
	}
}
