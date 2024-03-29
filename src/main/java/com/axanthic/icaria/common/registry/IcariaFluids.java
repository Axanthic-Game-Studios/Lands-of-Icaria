package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, IcariaInfo.ID);

	public static final RegistryObject<FlowingFluid> FLOWING_MEDITERRANEAN_WATER = IcariaFluids.registerMediterraneanWater("flowing_mediterranean_water", ForgeFlowingFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MEDITERRANEAN_WATER = IcariaFluids.registerMediterraneanWater("mediterranean_water", ForgeFlowingFluid.Source::new);

	public static RegistryObject<FlowingFluid> registerMediterraneanWater(String pName, NonNullFunction<ForgeFlowingFluid.Properties, FlowingFluid> pFunction) {
		return IcariaFluids.FLUIDS.register(pName, () -> pFunction.apply((new ForgeFlowingFluid.Properties(IcariaFluidTypes.MEDITERRANEAN_WATER, IcariaFluids.MEDITERRANEAN_WATER, IcariaFluids.FLOWING_MEDITERRANEAN_WATER)).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET).block(IcariaBlocks.MEDITERRANEAN_WATER)));
	}
}
