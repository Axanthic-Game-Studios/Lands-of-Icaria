package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, IcariaInfo.ID);

	public static final RegistryObject<FlowingFluid> FLOWING_MEDITERRANEAN_WATER = registerMediterraneanWater("flowing_mediterranean_water", ForgeFlowingFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MEDITERRANEAN_WATER = registerMediterraneanWater("mediterranean_water", ForgeFlowingFluid.Source::new);

	public static RegistryObject<FlowingFluid> registerMediterraneanWater(String pName, NonNullFunction<ForgeFlowingFluid.Properties, FlowingFluid> pFunction) {
		return FLUIDS.register(pName, () -> pFunction.apply((new ForgeFlowingFluid.Properties(IcariaFluidTypes.MEDITERRANEAN_WATER_TYPE, MEDITERRANEAN_WATER, FLOWING_MEDITERRANEAN_WATER)).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET).block(IcariaBlocks.MEDITERRANEAN_WATER)));
	}
}
