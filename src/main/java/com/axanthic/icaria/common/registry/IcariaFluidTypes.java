package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.type.MediterraneanWaterFluidType;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFluidTypes {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, IcariaKeys.ID);

	public static final DeferredHolder<FluidType, FluidType> MEDITERRANEAN_WATER = IcariaFluidTypes.FLUID_TYPES.register("mediterranean_water", () -> new MediterraneanWaterFluidType(FluidType.Properties.create()));
}
