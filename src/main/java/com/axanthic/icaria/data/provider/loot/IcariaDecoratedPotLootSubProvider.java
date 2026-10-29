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

public record IcariaDecoratedPotLootSubProvider(Context context) implements LootTableSubProvider {

	@Override
	public void run() {
		this.context().accept(IcariaLootTableIds.DECORATED_POT, LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(IcariaItems.LOAM_LUMP.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
			)
		);
	}
}
