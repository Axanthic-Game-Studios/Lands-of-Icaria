package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaInstrumentIds;
import com.axanthic.icaria.common.tags.IcariaInstrumentTags;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.InstrumentTagsProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaInstrumentTagsProvider extends InstrumentTagsProvider {
	public IcariaInstrumentTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaInstrumentTags.CAPELLA_HORNS)
			.add(IcariaInstrumentIds.FAIL_CAPELLA_HORN);
	}

	@Override
	public String getName() {
		return "Instrument Tags";
	}
}
