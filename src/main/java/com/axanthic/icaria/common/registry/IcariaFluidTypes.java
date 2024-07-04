package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.fluid.type.MediterraneanWaterFluidType;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, IcariaIdents.ID);

    public static final Supplier<FluidType> MEDITERRANEAN_WATER = IcariaFluidTypes.FLUID_TYPES.register("mediterranean_water", () -> new MediterraneanWaterFluidType(FluidType.Properties.create()));
}
