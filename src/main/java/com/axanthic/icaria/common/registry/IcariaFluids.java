package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, IcariaKeys.ID);

	public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_MEDITERRANEAN_WATER = IcariaFluids.FLUIDS.register("flowing_mediterranean_water", () -> new BaseFlowingFluid.Flowing(IcariaFluids.propertiesMediterraneanWater()));
	public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MEDITERRANEAN_WATER = IcariaFluids.FLUIDS.register("mediterranean_water", () -> new BaseFlowingFluid.Source(IcariaFluids.propertiesMediterraneanWater()));

	public static BaseFlowingFluid.Properties propertiesMediterraneanWater() {
		return new BaseFlowingFluid.Properties(IcariaFluidTypes.MEDITERRANEAN_WATER, IcariaFluids.MEDITERRANEAN_WATER, IcariaFluids.FLOWING_MEDITERRANEAN_WATER).block(IcariaBlocks.MEDITERRANEAN_WATER).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET);
	}
}
