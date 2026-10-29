package com.axanthic.icaria.data.provider.loot;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.enums.Olives;
import com.axanthic.icaria.common.ids.IcariaLootTableIds;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaBlockInteractLootSubProvider(Context context) implements LootTableSubProvider {

	@Override
	public void run() {
		this.context().accept(IcariaLootTableIds.OLIVE_LEAVES, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.BLACK_OLIVES.get()).when(MatchBlock.blockMatches(this.context().lookup(Registries.BLOCK), IcariaBlocks.OLIVE_LEAVES.get(), StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.BLACK))))
				.add(LootItem.lootTableItem(IcariaItems.GREEN_OLIVES.get()).when(MatchBlock.blockMatches(this.context().lookup(Registries.BLOCK), IcariaBlocks.OLIVE_LEAVES.get(), StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.GREEN))))
			)
		);

		this.context().accept(IcariaLootTableIds.STRAWBERRY_BUSH, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.STRAWBERRIES.get()))
			)
		);

		this.context().accept(IcariaLootTableIds.BLOOMY_VINE, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.VINEBERRIES.get()))
			)
		);

		this.context().accept(IcariaLootTableIds.BRUSHY_VINE, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.VINE_SPROUT.get()))
			)
		);
	}
}
