package com.axanthic.icaria.data.provider.loot;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaSuspiciousSandLootSubProvider(HolderLookup.Provider provider) implements LootTableSubProvider {

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pBiConsumer) {
		pBiConsumer.accept(IcariaLootTables.SUSPICIOUS_SAND, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
				.add(LootItem.lootTableItem(Items.BONE))
				.add(LootItem.lootTableItem(Items.LEAD))
				.add(LootItem.lootTableItem(IcariaItems.GRAINGLASS_PANE.get()))
				.add(LootItem.lootTableItem(IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get()))
				.add(LootItem.lootTableItem(IcariaItems.SILKGLASS_PANE.get()))
				.add(LootItem.lootTableItem(IcariaItems.HORIZONTAL_SILKGLASS_PANE.get()))
				.add(LootItem.lootTableItem(IcariaItems.LOAM_BRICK.get()))
				.add(LootItem.lootTableItem(IcariaItems.ARACHNE_STRING.get()))
				.add(LootItem.lootTableItem(IcariaItems.SPELT.get()))
				.add(LootItem.lootTableItem(IcariaItems.VINE_REED.get()))
				.add(LootItem.lootTableItem(IcariaItems.ROTTEN_BONES.get()))
				.add(LootItem.lootTableItem(IcariaItems.GREENPOWDER.get()))
				.add(LootItem.lootTableItem(IcariaItems.LIGNITE.get()))
				.add(LootItem.lootTableItem(IcariaItems.GREEK_FIRE_GRENADE.get()))
				.add(LootItem.lootTableItem(IcariaItems.EMPTY_FLASK.get()))
				.add(LootItem.lootTableItem(IcariaItems.EMPTY_VIAL.get()))
				.add(LootItem.lootTableItem(IcariaItems.LOAM_GEAR.get()))
				.add(LootItem.lootTableItem(IcariaItems.LOAM_BOWL.get()))
				.add(LootItem.lootTableItem(IcariaItems.SPELT_SEEDS.get()))
				.add(LootItem.lootTableItem(IcariaItems.STRAWBERRY_SEEDS.get()))
				.add(LootItem.lootTableItem(IcariaItems.PHYSALIS_SEEDS.get()))
			)
		);
	}
}
