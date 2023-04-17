package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.util.IcariaFluidTypeRenderProperties;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class IcariaFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, IcariaInfo.ID);

    public static final RegistryObject<FluidType> MEDITERRANEAN_WATER_TYPE = FLUID_TYPES.register("mediterranean_water", () -> new FluidType(FluidType.Properties.create()
        .descriptionId("fluid." + IcariaInfo.ID + ".mediterranean_water")
        .motionScale(0.014)
        .canPushEntity(true)
        .canSwim(true)
        .canDrown(true)
        .fallDistanceModifier(0)
        .canExtinguish(true)
        .canConvertToSource(true)
        .supportsBoating(true)
        .pathType(BlockPathTypes.WATER)
        .canHydrate(true)
        .lightLevel(0)
        .density(1000)
        .temperature(300)
        .viscosity(1000)
        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {
        @Override
        public void initializeClient(Consumer<IClientFluidTypeExtensions> pConsumer) {
            pConsumer.accept(new IcariaFluidTypeRenderProperties(IcariaResourceLocations.MEDITERRANEAN_WATER_TEXTURE_STILL, IcariaResourceLocations.MEDITERRANEAN_WATER_TEXTURE_FLOWING, IcariaResourceLocations.MEDITERRANEAN_WATER_TEXTURE_OVERLAY));
        }
    });
}
