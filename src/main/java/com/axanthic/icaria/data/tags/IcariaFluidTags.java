package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaFluids;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;

import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaFluidTags extends FluidTagsProvider {
	public IcariaFluidTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(FluidTags.WATER)
			.add(IcariaFluids.MEDITERRANEAN_WATER_FLOWING.get())
			.add(IcariaFluids.MEDITERRANEAN_WATER_SOURCE.get());
	}
}
