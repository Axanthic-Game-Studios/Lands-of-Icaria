package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaLootTables;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStorageVaseLoot implements LootTableSubProvider {
    public IcariaStorageVaseLoot(HolderLookup.Provider pProvider) {

    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pConsumer) {
        pConsumer.accept(IcariaLootTables.RED_STORAGE_VASE_LOOT, LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 5.0F))
                .add(LootItem.lootTableItem(IcariaItems.ENDER_JELLYFISH_JELLY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.FIRE_JELLYFISH_JELLY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.NATURE_JELLYFISH_JELLY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.VOID_JELLYFISH_JELLY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.WATER_JELLYFISH_JELLY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.SPELT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.HALITE_DUST.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.CHERT_TOOLS.dagger.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                .add(LootItem.lootTableItem(IcariaItems.SPELT_FLOUR.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.GARLIC.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.SNULL_CREAM.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.UNFIRED_LOAM_BOWL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.LOAM_BOWL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.SPELT_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.STRAWBERRY_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.PHYSALIS_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
            )
        );

        pConsumer.accept(IcariaLootTables.CYAN_STORAGE_VASE_LOOT, LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 5.0F))
                .add(LootItem.lootTableItem(IcariaItems.SPELT_BREAD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.VINE_SPROUT.get()))
                .add(LootItem.lootTableItem(IcariaItems.VINEBERRIES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.STRAWBERRIES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.PHYSALIS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.LAUREL_CHERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.BLACK_OLIVES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.GREEN_OLIVES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.ONION.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))))
            .withPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.1F))
                .add(LootItem.lootTableItem(IcariaItems.LAUREL_CHERRY_CAKE.get()))
                .add(LootItem.lootTableItem(IcariaItems.STRAWBERRY_CAKE.get()))
                .add(LootItem.lootTableItem(IcariaItems.PHYSALIS_CAKE.get()))
                .add(LootItem.lootTableItem(IcariaItems.VINE_BERRY_CAKE.get()))
                .add(LootItem.lootTableItem(IcariaItems.VINE_SPROUT_CAKE.get()))
                .add(LootItem.lootTableItem(IcariaItems.FRUIT_SALAD.get()))
                .add(LootItem.lootTableItem(IcariaItems.ONION_SOUP.get()))
                .add(LootItem.lootTableItem(IcariaItems.AETERNAE_STEW.get()))
                .add(LootItem.lootTableItem(IcariaItems.CATOBLEPAS_STEW.get()))
                .add(LootItem.lootTableItem(IcariaItems.CERVER_STEW.get()))
                .add(LootItem.lootTableItem(IcariaItems.SOW_STEW.get()))
            )
        );
    }
}
