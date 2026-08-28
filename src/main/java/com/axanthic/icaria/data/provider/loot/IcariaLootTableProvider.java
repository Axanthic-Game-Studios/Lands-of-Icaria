package com.axanthic.icaria.data.provider.loot;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLootTableProvider extends LootTableProvider {
	public IcariaLootTableProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
		super(pPackOutput, Set.of(), List.of(
			new LootTableProvider.SubProviderEntry(IcariaAmphoraLootSubProvider::new, LootContextParamSets.CHEST),
			new LootTableProvider.SubProviderEntry(IcariaBarrelLootSubProvider::new, LootContextParamSets.CHEST),
			new LootTableProvider.SubProviderEntry(IcariaBlockInteractLootSubProvider::new, LootContextParamSets.BLOCK_INTERACT),
			new LootTableProvider.SubProviderEntry(IcariaBlockLootSubProvider::new, LootContextParamSets.BLOCK),
			new LootTableProvider.SubProviderEntry(IcariaChestLootSubProvider::new, LootContextParamSets.CHEST),
			new LootTableProvider.SubProviderEntry(IcariaDecoratedPotLootSubProvider::new, LootContextParamSets.CHEST),
			new LootTableProvider.SubProviderEntry(IcariaEntityLootSubProvider::new, LootContextParamSets.ENTITY),
			new LootTableProvider.SubProviderEntry(IcariaLootVaseLootSubProvider::new, LootContextParamSets.CHEST),
			new LootTableProvider.SubProviderEntry(IcariaStorageVaseLootSubProvider::new, LootContextParamSets.CHEST),
			new LootTableProvider.SubProviderEntry(IcariaSuspiciousSandLootSubProvider::new, LootContextParamSets.ARCHAEOLOGY),
			new LootTableProvider.SubProviderEntry(IcariaVaseLootSubProvider::new, LootContextParamSets.CHEST)
		), pProvider);
	}
}
