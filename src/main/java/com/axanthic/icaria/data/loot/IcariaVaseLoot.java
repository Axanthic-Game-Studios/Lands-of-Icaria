package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaVaseLoot implements LootTableSubProvider {
    public static final ResourceLocation LOOT_VASE = new ResourceLocation(IcariaInfo.ID, "vases/loot_vase");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pConsumer) {
        pConsumer.accept(IcariaVaseLoot.LOOT_VASE, LootTable.lootTable()
            .withPool(LootPool.lootPool()
                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                    .add(LootItem.lootTableItem(IcariaItems.BONE_REMAINS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.ARACHNE_STRING.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.SPELT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.VINE_REED.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.VINE_SPROUT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.ROTTEN_BONES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.CALCITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.HALITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.CALCITE_DUST.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.HALITE_DUST.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.LIGNITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.RAW_CHALKOS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.RAW_KASSITEROS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.DOLOMITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.SLIVER.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.ANTHRACITE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.CHALKOS_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.KASSITEROS_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.CHALKOS_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.KASSITEROS_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.ONION.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.SPELT_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.STRAWBERRY_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                    .add(LootItem.lootTableItem(IcariaItems.PHYSALIS_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))))
            .withPool(LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(0.1F))
                    .add(LootItem.lootTableItem(IcariaItems.CHALKOS_TOOLS.dagger.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.CHALKOS_TOOLS.shovel.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.KASSITEROS_TOOLS.sword.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.KASSITEROS_TOOLS.dagger.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.KASSITEROS_TOOLS.axe.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.KASSITEROS_TOOLS.bident.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get()).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1F, 0.9F))))
                    .add(LootItem.lootTableItem(IcariaItems.LAUREL_WREATH.get()))
                    .add(LootItem.lootTableItem(IcariaItems.GREEK_FIRE_GRENADE.get()))
                    // TODO: .add(LootItem.lootTableItem(IcariaItems.ANTI_GRAVITY_SCROLL.get()))
                    // TODO: .add(LootItem.lootTableItem(IcariaItems.BUBBLE_SCROLL.get()))
                    // TODO: .add(LootItem.lootTableItem(IcariaItems.FORTIFYING_SCROLL.get()))
                    // TODO: .add(LootItem.lootTableItem(IcariaItems.FREEZING_SCROLL.get()))
                    // TODO: .add(LootItem.lootTableItem(IcariaItems.HEALING_SCROLL.get()))
                    // TODO: .add(LootItem.lootTableItem(IcariaItems.MAGIC_MISSILE_SCROLL.get()))
                    .add(LootItem.lootTableItem(IcariaItems.BLUE_GEARFRAGMENT.get()))
                    .add(LootItem.lootTableItem(IcariaItems.GREEN_GEARFRAGMENT.get()))
                    .add(LootItem.lootTableItem(IcariaItems.YELLOW_GEARFRAGMENT.get()))));
    }
}
