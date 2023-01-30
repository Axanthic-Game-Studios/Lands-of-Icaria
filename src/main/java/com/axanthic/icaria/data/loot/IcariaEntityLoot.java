package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.stream.Stream;

@MethodsReturnNonnullByDefault

public class IcariaEntityLoot extends EntityLootSubProvider {
    public IcariaEntityLoot() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.dropItemPlusMeat(IcariaEntityTypes.AETERNAE.get(), IcariaItems.AETERNAE_HIDE.get(), IcariaItems.RAW_AETERNAE_MEAT.get());

        this.dropItem(IcariaEntityTypes.ARACHNE.get(), IcariaItems.ARACHNE_STRING.get());
        this.dropItem(IcariaEntityTypes.ARACHNE_DRONE.get(), IcariaItems.ARACHNE_STRING.get());

        this.dropNone(IcariaEntityTypes.ARGAN_HOUND.get());
        this.dropNone(IcariaEntityTypes.HYLIASTER.get());
        this.dropNone(IcariaEntityTypes.MYRMEKE_DRONE.get());
        this.dropNone(IcariaEntityTypes.MYRMEKE_SOLDIER.get());
        this.dropNone(IcariaEntityTypes.MYRMEKE_QUEEN.get());

        this.dropMeat(IcariaEntityTypes.CATOBLEPAS.get(), IcariaItems.RAW_CATOBLEPAS_MEAT.get());
        this.dropMeat(IcariaEntityTypes.CERVER.get(), IcariaItems.RAW_CERVER_MEAT.get());
        this.dropMeat(IcariaEntityTypes.SOW.get(), IcariaItems.RAW_SOW_MEAT.get());
    }

    public void dropItemPlusMeat(EntityType<?> pEntity, Item pItem, Item pMeat) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pMeat).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    public void dropItem(EntityType<?> pEntity, Item pItem) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    public void dropMeat(EntityType<?> pEntity, Item pMeat) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pMeat).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    public void dropNone(EntityType<?> pEntity) {
        this.add(pEntity, LootTable.lootTable());
    }

    @Override
    public Stream<EntityType<?>> getKnownEntityTypes() {
        return ForgeRegistries.ENTITY_TYPES.getValues().stream().filter(pEntityType -> Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(pEntityType)).getNamespace().equals(IcariaInfo.MODID));
    }
}
