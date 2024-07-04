package com.axanthic.icaria.data.loot;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLoot extends LootTableProvider {
    public IcariaLoot(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
        super(pOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(IcariaBarrelLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(IcariaBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(IcariaChestLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(IcariaEntityLoot::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(IcariaLootVaseLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(IcariaStorageVaseLoot::new, LootContextParamSets.CHEST)), pProvider);
    }
}
