package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFluidIds;

import java.util.function.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, IcariaIds.ID);

	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_MEDITERRANEAN_WATER = IcariaFluids.register(IcariaFluidIds.FLOWING_MEDITERRANEAN_WATER, () -> new BaseFlowingFluid.Flowing(IcariaFluids.propertiesMediterraneanWater()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MEDITERRANEAN_WATER = IcariaFluids.register(IcariaFluidIds.MEDITERRANEAN_WATER, () -> new BaseFlowingFluid.Source(IcariaFluids.propertiesMediterraneanWater()));

	public static BaseFlowingFluid.Properties propertiesMediterraneanWater() {
		return new BaseFlowingFluid.Properties(IcariaFluidTypes.MEDITERRANEAN_WATER, IcariaFluids.MEDITERRANEAN_WATER, IcariaFluids.FLOWING_MEDITERRANEAN_WATER).block(IcariaBlocks.MEDITERRANEAN_WATER).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET);
	}

	public static <T extends Fluid> DeferredHolder<Fluid, T> register(ResourceKey<Fluid> pResourceKey, Supplier<? extends T> pSupplier) {
		return IcariaFluids.FLUIDS.register(pResourceKey.identifier().getPath(), pSupplier);
	}
}
