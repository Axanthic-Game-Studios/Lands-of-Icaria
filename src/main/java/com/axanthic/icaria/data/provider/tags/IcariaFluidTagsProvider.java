package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaIdents;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFluidTagsProvider extends FluidTagsProvider {
	public IcariaFluidTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(FluidTags.WATER)
			.add(IcariaFluids.FLOWING_MEDITERRANEAN_WATER.get())
			.add(IcariaFluids.MEDITERRANEAN_WATER.get());
	}

	@Override
	public String getName() {
		return "Fluid Tags";
	}

	public static TagKey<Fluid> cKey(String pName) {
		return IcariaFluidTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Fluid> icariaKey(String pName) {
		return IcariaFluidTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<Fluid> createKey(String pName) {
		return TagKey.create(Registries.FLUID, ResourceLocation.parse(pName));
	}
}
