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
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaLootVaseLootSubProvider(HolderLookup.Provider provider) implements LootTableSubProvider {

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pBiConsumer) {
		pBiConsumer.accept(IcariaLootTables.RED_LOOT_VASE, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 5.0F))
				.add(LootItem.lootTableItem(IcariaItems.LOAM_LUMP.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ARACHNE_STRING.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.VINE_REED.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ROTTEN_BONES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.LIGNITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.RAW_CHALKOS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.RAW_KASSITEROS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.DOLOMITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ORICHALCUM_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUM_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_SWORD.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_SHOVEL.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_PICKAXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_AXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_SCYTHE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHERT_BIDENT.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_SWORD.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_SHOVEL.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_PICKAXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_AXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_SCYTHE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_BIDENT.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.ANTI_GRAVITY_SPELL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.FORTIFYING_SPELL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.FREEZING_SPELL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
			)
		);

		pBiConsumer.accept(IcariaLootTables.LOST_LOOT_VASE, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 5.0F))
				.add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_CHAIN.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.BONE_REMAINS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.CALCITE_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.HALITE_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.JASPER_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ZIRCON_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.DOLOMITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(24.0F, 56.0F))))
				.add(LootItem.lootTableItem(IcariaItems.RAW_SIDEROS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ANTHRACITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ORICHALCUM_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_SWORD.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_SHOVEL.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_PICKAXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_AXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_SCYTHE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_BIDENT.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.SIDEROS_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_HELMET.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_CHESTPLATE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_LEGGINGS.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_BOOTS.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.GREEK_FIRE_GRENADE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.BUBBLE_SPELL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ANTI_GRAVITY_FLASK.get()))
				.add(LootItem.lootTableItem(IcariaItems.FORTIFYING_FLASK.get()))
				.add(LootItem.lootTableItem(IcariaItems.HEALING_FLASK.get()))
				.add(LootItem.lootTableItem(IcariaItems.CHEST_LABEL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.LOAM_GEAR.get()))
				.add(LootItem.lootTableItem(IcariaItems.BLUE_GEARFRAGMENT.get()))
				.add(LootItem.lootTableItem(IcariaItems.GREEN_GEARFRAGMENT.get()))
				.add(LootItem.lootTableItem(IcariaItems.YELLOW_GEARFRAGMENT.get()))
			)
		);

		pBiConsumer.accept(IcariaLootTables.CYAN_LOOT_VASE, LootTable.lootTable()
			.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 5.0F))
				.add(LootItem.lootTableItem(IcariaItems.BONE_REMAINS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.CALCITE_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.HALITE_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.JASPER_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ZIRCON_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.DOLOMITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.RAW_VANADIUM.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.ANTHRACITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.VANADIUMSTEEL_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.SIDEROS_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.CHALKOS_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_SWORD.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_SHOVEL.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_PICKAXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_AXE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_SCYTHE.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.KASSITEROS_BIDENT.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.ORICHALCUM_DAGGER.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
				.add(LootItem.lootTableItem(IcariaItems.HEALING_SPELL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.BUBBLE_SPELL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.MAGIC_MISSILE_SPELL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
				.add(LootItem.lootTableItem(IcariaItems.BLUE_GEARFRAGMENT.get()))
				.add(LootItem.lootTableItem(IcariaItems.GREEN_GEARFRAGMENT.get()))
				.add(LootItem.lootTableItem(IcariaItems.YELLOW_GEARFRAGMENT.get())))
			.withPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.1F))
				.add(LootItem.lootTableItem(IcariaItems.ANTI_GRAVITY_SCROLL.get()))
				.add(LootItem.lootTableItem(IcariaItems.FORTIFYING_SCROLL.get()))
				.add(LootItem.lootTableItem(IcariaItems.HEALING_SCROLL.get()))
				.add(LootItem.lootTableItem(IcariaItems.BUBBLE_SCROLL.get()))
				.add(LootItem.lootTableItem(IcariaItems.FREEZING_SCROLL.get()))
				.add(LootItem.lootTableItem(IcariaItems.MAGIC_MISSILE_SCROLL.get()))
			)
		);
	}
}
