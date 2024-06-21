package com.axanthic.icaria.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class IcariaBuiltinEntries extends DatapackBuiltinEntriesProvider {
    public IcariaBuiltinEntries(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
        super(pOutput, pProvider, new IcariaRegistrySetBuilder(), Set.of(pId));
    }
}
