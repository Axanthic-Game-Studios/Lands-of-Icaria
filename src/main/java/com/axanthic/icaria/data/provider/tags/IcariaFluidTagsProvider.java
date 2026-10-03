package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFluidIds;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;

import net.neoforged.neoforge.common.Tags;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFluidTagsProvider extends FluidTagsProvider {
	public IcariaFluidTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(FluidTags.SUPPORTS_FROGSPAWN)
			.add(IcariaFluidIds.MEDITERRANEAN_WATER);

		this.tag(FluidTags.SUPPORTS_LILY_PAD)
			.add(IcariaFluidIds.MEDITERRANEAN_WATER);

		this.tag(FluidTags.WATER)
			.add(IcariaFluidIds.FLOWING_MEDITERRANEAN_WATER)
			.add(IcariaFluidIds.MEDITERRANEAN_WATER);

		this.tag(Tags.Fluids.WATER)
			.add(IcariaFluidIds.FLOWING_MEDITERRANEAN_WATER)
			.add(IcariaFluidIds.MEDITERRANEAN_WATER);
	}

	@Override
	public String getName() {
		return "Fluid Tags";
	}
}
