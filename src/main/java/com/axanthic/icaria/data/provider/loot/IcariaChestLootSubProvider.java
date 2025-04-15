package com.axanthic.icaria.data.provider.loot;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaChestLootSubProvider(HolderLookup.Provider pProvider) implements LootTableSubProvider {

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pBiConsumer) {
		pBiConsumer.accept(IcariaLootTables.CHEST_LOOT, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
				.add(LootItem.lootTableItem(IcariaItems.ARACHNE_STRING.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_HELMET.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_CHESTPLATE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_LEGGINGS.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_BOOTS.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_BOOTS.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
			)
		);
	}
}
