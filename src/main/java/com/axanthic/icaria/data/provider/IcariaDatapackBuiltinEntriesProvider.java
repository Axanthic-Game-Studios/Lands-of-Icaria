package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.data.IcariaRegistrySetBuilder;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
	public IcariaDatapackBuiltinEntriesProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, new IcariaRegistrySetBuilder(), Set.of(pId));
	}
}
