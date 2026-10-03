package com.axanthic.icaria.data.provider.advancement;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAdvancementProvider extends AdvancementProvider {
	public IcariaAdvancementProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
		super(pPackOutput, pProvider, List.of(new IcariaAdvancementSubProvider()));
	}
}
