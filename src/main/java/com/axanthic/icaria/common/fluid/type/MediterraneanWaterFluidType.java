package com.axanthic.icaria.common.fluid.type;

import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;

import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MediterraneanWaterFluidType extends FluidType {
	public MediterraneanWaterFluidType(Properties pProperties) {
		super(pProperties.descriptionId("fluid" + "." + IcariaIdents.ID + "." + "mediterranean_water").canConvertToSource(true).canDrown(true).canExtinguish(true).canHydrate(true).canPushEntity(true).canSwim(true).supportsBoating(true).density(1000).fallDistanceModifier(0).lightLevel(0).motionScale(0.014).temperature(300).viscosity(1000).pathType(PathType.WATER).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL));
	}
}
