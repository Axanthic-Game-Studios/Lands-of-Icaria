package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault

public class IcariaFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, IcariaInfo.ID);

	public static final Supplier<FlowingFluid> FLOWING_MEDITERRANEAN_WATER = IcariaFluids.registerMediterraneanWater("flowing_mediterranean_water", BaseFlowingFluid.Flowing::new);
	public static final Supplier<FlowingFluid> MEDITERRANEAN_WATER = IcariaFluids.registerMediterraneanWater("mediterranean_water", BaseFlowingFluid.Source::new);

	public static Supplier<FlowingFluid> registerMediterraneanWater(String pName, Function<BaseFlowingFluid.Properties, FlowingFluid> pFunction) {
		return IcariaFluids.FLUIDS.register(pName, () -> pFunction.apply((new BaseFlowingFluid.Properties(IcariaFluidTypes.MEDITERRANEAN_WATER, IcariaFluids.MEDITERRANEAN_WATER, IcariaFluids.FLOWING_MEDITERRANEAN_WATER)).bucket(IcariaItems.MEDITERRANEAN_WATER_BUCKET).block(IcariaBlocks.MEDITERRANEAN_WATER)));
	}
}
