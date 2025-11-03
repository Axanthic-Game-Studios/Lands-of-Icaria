package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.data.map.Freezable;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.registries.datamaps.DataMapType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDataMapTypes {
	public static final DataMapType<Fluid, Freezable> FREEZABLES = DataMapType.builder(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "freezables"), Registries.FLUID, Freezable.CODEC).synced(Freezable.CODEC, false).build();
}
