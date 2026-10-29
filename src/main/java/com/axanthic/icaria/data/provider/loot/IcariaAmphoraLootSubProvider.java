package com.axanthic.icaria.data.provider.loot;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaLootTableIds;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaAmphoraLootSubProvider(Context context) implements LootTableSubProvider {

	@Override
	public void run() {
		this.context().accept(IcariaLootTableIds.AMPHORA, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.FERMENTED_FISH.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
				.add(LootItem.lootTableItem(IcariaItems.FERMENTED_SNULL_CREAM.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
			)
		);
	}
}
