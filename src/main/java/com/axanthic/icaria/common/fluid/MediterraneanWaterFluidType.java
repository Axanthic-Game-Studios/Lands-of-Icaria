package com.axanthic.icaria.common.fluid;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.sounds.SoundEvents;

import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MediterraneanWaterFluidType extends FluidType {
	public MediterraneanWaterFluidType(Properties pProperties) {
		super(pProperties.descriptionId("fluid" + "." + IcariaIds.ID + "." + "mediterranean_water").canConvertToSource(true).canExtinguish(true).canHydrate(true).isWaterLike(true).supportsBoating(true).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL));
	}
}
