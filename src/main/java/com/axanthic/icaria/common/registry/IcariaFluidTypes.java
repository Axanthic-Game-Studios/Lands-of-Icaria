package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.fluid.type.MediterraneanWaterFluidType;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class IcariaFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, IcariaInfo.ID);

    public static final Supplier<FluidType> MEDITERRANEAN_WATER = IcariaFluidTypes.FLUID_TYPES.register("mediterranean_water", () -> new MediterraneanWaterFluidType(FluidType.Properties.create()));
}
