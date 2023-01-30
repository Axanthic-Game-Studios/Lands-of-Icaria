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
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, IcariaInfo.MODID);

	public static final RegistryObject<FlowingFluid> MEDITERRANEAN_WATER_FLOWING = registerMediterraneanWater("mediterranean_water_flowing", ForgeFlowingFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MEDITERRANEAN_WATER_SOURCE = registerMediterraneanWater("mediterranean_water", ForgeFlowingFluid.Source::new);

	public static RegistryObject<FlowingFluid> registerMediterraneanWater(String pName, NonNullFunction<ForgeFlowingFluid.Properties, FlowingFluid> pFunction) {
		return FLUIDS.register(pName, () -> pFunction.apply((new ForgeFlowingFluid.Properties(IcariaFluidTypes.MEDITERRANEAN_WATER_TYPE, MEDITERRANEAN_WATER_SOURCE, MEDITERRANEAN_WATER_FLOWING)).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET).block(IcariaBlocks.MEDITERRANEAN_WATER)));
	}
}
