package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.data.IcariaAdvancementGenerator;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAdvancementProvider extends AdvancementProvider {
	public IcariaAdvancementProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, ExistingFileHelper pExistingFileHelper) {
		super(pPackOutput, pProvider, pExistingFileHelper, List.of(new IcariaAdvancementGenerator()));
	}
}
