package com.axanthic.icaria.data.provider.loot;

import com.axanthic.icaria.common.properties.Olives;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaBlockInteractLootSubProvider(HolderLookup.Provider provider) implements LootTableSubProvider {

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pBiConsumer) {
		pBiConsumer.accept(IcariaLootTables.OLIVE_LEAVES, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.BLACK_OLIVES.get()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(IcariaBlocks.OLIVE_LEAVES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.BLACK))))
				.add(LootItem.lootTableItem(IcariaItems.GREEN_OLIVES.get()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(IcariaBlocks.OLIVE_LEAVES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.GREEN))))
			)
		);

		pBiConsumer.accept(IcariaLootTables.STRAWBERRY_BUSH, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.STRAWBERRIES.get()))
			)
		);

		pBiConsumer.accept(IcariaLootTables.BLOOMY_VINE, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.VINEBERRIES.get()))
			)
		);

		pBiConsumer.accept(IcariaLootTables.BRUSHY_VINE, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.VINE_SPROUT.get()))
			)
		);
	}
}
