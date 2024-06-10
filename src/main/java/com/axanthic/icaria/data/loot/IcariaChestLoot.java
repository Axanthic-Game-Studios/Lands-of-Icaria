package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaChestLoot implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pConsumer) {
        pConsumer.accept(IcariaResourceLocations.CHEST_LOOT, LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                .add(LootItem.lootTableItem(IcariaItems.ARACHNE_STRING.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(IcariaItems.CHERT_TOOLS.dagger.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                .add(LootItem.lootTableItem(IcariaItems.CHALKOS_ARMOR.boots.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
            )
        );
    }
}
