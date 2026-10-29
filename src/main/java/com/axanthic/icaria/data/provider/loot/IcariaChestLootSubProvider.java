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
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaChestLootSubProvider(Context context) implements LootTableSubProvider {

	@Override
	public void run() {
		this.context().accept(IcariaLootTableIds.CHEST, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(ContextIntProviders.between(1, 3))
				.add(LootItem.lootTableItem(IcariaItems.ARACHNE_STRING.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_HELMET.get()).apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_CHESTPLATE.get()).apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_LEGGINGS.get()).apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_BOOTS.get()).apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
			)
		);
	}
}
