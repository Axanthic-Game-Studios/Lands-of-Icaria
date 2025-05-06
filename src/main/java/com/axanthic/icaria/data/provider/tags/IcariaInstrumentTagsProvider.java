package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.data.registry.IcariaInstruments;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.InstrumentTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaInstrumentTagsProvider extends InstrumentTagsProvider {
	public static final TagKey<Instrument> CAPELLA_HORNS = IcariaInstrumentTagsProvider.icariaKey("capella_horns");

	public IcariaInstrumentTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaInstrumentTagsProvider.CAPELLA_HORNS)
			.add(IcariaInstruments.FAIL_CAPELLA_HORN);
	}

	@Override
	public String getName() {
		return "Instrument Tags";
	}

	public static TagKey<Instrument> cKey(String pName) {
		return IcariaInstrumentTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Instrument> icariaKey(String pName) {
		return IcariaInstrumentTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<Instrument> createKey(String pName) {
		return TagKey.create(Registries.INSTRUMENT, ResourceLocation.parse(pName));
	}
}
