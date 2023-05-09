package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.Sets;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class IcariaLoot extends LootTableProvider {
    public static final Set<ResourceLocation> INTERN_TABLES = Sets.newHashSet();

    public IcariaLoot(PackOutput pOutput) {
        super(pOutput, IcariaLoot.internTables(), List.of(new LootTableProvider.SubProviderEntry(IcariaBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(IcariaEntityLoot::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(IcariaVaseLoot::new, LootContextParamSets.CHEST)));
    }

    public static ResourceLocation register(ResourceLocation pId) {
        if (IcariaLoot.INTERN_TABLES.add(pId)) {
            return pId;
        } else {
            throw new IllegalArgumentException(pId + " is already a registered built-in loot table");
        }
    }

    public static ResourceLocation register(String pId) {
        var resourceLocation = new ResourceLocation(IcariaInfo.ID, pId);
        return register(resourceLocation);
    }

    public static Set<ResourceLocation> internTables() {
        return Collections.unmodifiableSet(IcariaLoot.INTERN_TABLES);
    }
}
