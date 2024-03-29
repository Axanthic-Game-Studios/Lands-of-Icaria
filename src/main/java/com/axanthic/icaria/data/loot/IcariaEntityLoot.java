package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

import java.util.stream.Stream;

@MethodsReturnNonnullByDefault

public class IcariaEntityLoot extends EntityLootSubProvider {
    public IcariaEntityLoot() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.dropItemPlusMeat(IcariaEntityTypes.AETERNAE.get(), IcariaItems.AETERNAE_HIDE.get(), IcariaItems.RAW_AETERNAE_MEAT.get());
        this.dropItemPlusMeat(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), IcariaItems.CYPRESS_SAPLING.get(), IcariaItems.CYPRESS_LOG.get());
        this.dropItemPlusMeat(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), IcariaItems.DROUGHTROOT_SAPLING.get(), IcariaItems.DROUGHTROOT_LOG.get());
        this.dropItemPlusMeat(IcariaEntityTypes.FIR_FOREST_HAG.get(), IcariaItems.FIR_SAPLING.get(), IcariaItems.FIR_LOG.get());
        this.dropItemPlusMeat(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), IcariaItems.LAUREL_SAPLING.get(), IcariaItems.LAUREL_LOG.get());
        this.dropItemPlusMeat(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), IcariaItems.OLIVE_SAPLING.get(), IcariaItems.OLIVE_LOG.get());
        this.dropItemPlusMeat(IcariaEntityTypes.PLANE_FOREST_HAG.get(), IcariaItems.PLANE_SAPLING.get(), IcariaItems.PLANE_LOG.get());
        this.dropItemPlusMeat(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), IcariaItems.POPULUS_SAPLING.get(), IcariaItems.POPULUS_LOG.get());

        this.dropItem(IcariaEntityTypes.ARACHNE.get(), IcariaItems.ARACHNE_STRING.get());
        this.dropItem(IcariaEntityTypes.ARACHNE_DRONE.get(), IcariaItems.ARACHNE_STRING.get());
        this.dropItem(IcariaEntityTypes.FIRE_JELLYFISH.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get());
        this.dropItem(IcariaEntityTypes.NATURE_JELLYFISH.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get());
        this.dropItem(IcariaEntityTypes.VOID_JELLYFISH.get(), IcariaItems.VOID_JELLYFISH_JELLY.get());
        this.dropItem(IcariaEntityTypes.WATER_JELLYFISH.get(), IcariaItems.WATER_JELLYFISH_JELLY.get());
        this.dropItem(IcariaEntityTypes.MYRMEKE_DRONE.get(), IcariaItems.MYRMEKE_SCALES.get());
        this.dropItem(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), IcariaItems.MYRMEKE_SCALES.get());
        this.dropItem(IcariaEntityTypes.MYRMEKE_QUEEN.get(), IcariaItems.MYRMEKE_SCALES.get());
        this.dropItem(IcariaEntityTypes.CAPTAIN_REVENANT.get(), Items.BONE);
        this.dropItem(IcariaEntityTypes.CIVILIAN_REVENANT.get(), Items.BONE);
        this.dropItem(IcariaEntityTypes.CRAWLER_REVENANT.get(), Items.BONE);
        this.dropItem(IcariaEntityTypes.SOLDIER_REVENANT.get(), Items.BONE);
        this.dropItem(IcariaEntityTypes.FOREST_SNULL.get(), IcariaItems.SNULL_CREAM.get());
        this.dropItem(IcariaEntityTypes.SNULL.get(), IcariaItems.SNULL_CREAM.get());

        this.dropNone(IcariaEntityTypes.ARGAN_HOUND.get());
        this.dropNone(IcariaEntityTypes.HYLIASTER.get());
        this.dropNone(IcariaEntityTypes.SCORPION.get());
        this.dropNone(IcariaEntityTypes.SOLIFUGAE.get());
        this.dropNone(IcariaEntityTypes.VINEGAROON.get());

        this.dropMeat(IcariaEntityTypes.CATOBLEPAS.get(), IcariaItems.RAW_CATOBLEPAS_MEAT.get());
        this.dropMeat(IcariaEntityTypes.CERVER.get(), IcariaItems.RAW_CERVER_MEAT.get());
        this.dropMeat(IcariaEntityTypes.SOW.get(), IcariaItems.RAW_SOW_MEAT.get());

        this.dropItemPlusThrd(IcariaEntityTypes.CRYSTAL_SLUG.get(), IcariaItems.SNULL_CREAM.get(), IcariaItems.SLUG_SCALES.get(), IcariaItems.JASPER_SHARD.get());
        this.dropItemPlusThrd(IcariaEntityTypes.PYROMANCER_REVENANT.get(), IcariaItems.GREENPOWDER.get(), IcariaItems.GREEK_FIRE_GRENADE.get(), Items.BONE);
        this.dropItemPlusThrd(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), IcariaItems.GREENPOWDER.get(), IcariaItems.GREEK_FIRE_GRENADE.get(), Items.BONE);

        this.dropItemPlusScnd(IcariaEntityTypes.ENDER_JELLYFISH.get(), IcariaItems.ENDER_JELLYFISH_JELLY.get(), Items.ENDER_PEARL);
        this.dropItemPlusScnd(IcariaEntityTypes.OVERGROWN_REVENANT.get(), IcariaItems.CALCITE_SHARD.get(), Items.BONE);
    }

    public void dropItemPlusMeat(EntityType<?> pEntity, Item pItem, Item pMeat) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pMeat).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityLootSubProvider.ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    public void dropItem(EntityType<?> pEntity, Item pItem) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    public void dropNone(EntityType<?> pEntity) {
        this.add(pEntity, LootTable.lootTable());
    }

    public void dropMeat(EntityType<?> pEntity, Item pMeat) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pMeat).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityLootSubProvider.ENTITY_ON_FIRE))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    public void dropItemPlusThrd(EntityType<?> pEntity, Item pItem, Item pScnd, Item pThrd) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pScnd).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pThrd).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    public void dropItemPlusScnd(EntityType<?> pEntity, Item pItem, Item pScnd) {
        this.add(pEntity, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pScnd).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
    }

    @Override
    public Stream<EntityType<?>> getKnownEntityTypes() {
        return ForgeRegistries.ENTITY_TYPES.getValues().stream().filter(pEntityType -> ForgeRegistries.ENTITY_TYPES.getKey(pEntityType).getNamespace().equals(IcariaInfo.ID));
    }
}
