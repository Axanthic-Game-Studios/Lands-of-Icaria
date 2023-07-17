package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.fluid.type.MediterraneanWaterFluidType;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, IcariaInfo.ID);

    public static final RegistryObject<FluidType> MEDITERRANEAN_WATER = IcariaFluidTypes.FLUID_TYPES.register("mediterranean_water", () -> new MediterraneanWaterFluidType(FluidType.Properties.create()));
}
