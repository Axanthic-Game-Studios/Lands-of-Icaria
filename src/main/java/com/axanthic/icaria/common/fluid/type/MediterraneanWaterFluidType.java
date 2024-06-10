package com.axanthic.icaria.common.fluid.type;

import com.axanthic.icaria.client.extensions.MediterraneanWaterFluidTypeExtensions;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class MediterraneanWaterFluidType extends FluidType {
    public MediterraneanWaterFluidType(Properties pProperties) {
        super(pProperties.descriptionId("fluid" + "." + IcariaInfo.ID + "." + "mediterranean_water").canConvertToSource(true).canDrown(true).canExtinguish(true).canHydrate(true).canPushEntity(true).canSwim(true).supportsBoating(true).density(1000).fallDistanceModifier(0).lightLevel(0).motionScale(0.014).temperature(300).viscosity(1000).pathType(BlockPathTypes.WATER).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL));
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> pConsumer) {
        pConsumer.accept(new MediterraneanWaterFluidTypeExtensions());
    }
}
