package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.data.map.Freezable;
import com.axanthic.icaria.data.map.GrinderFuel;
import com.axanthic.icaria.data.map.Pottable;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.registries.datamaps.DataMapType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDataMapTypes {
	public static final DataMapType<Fluid, Freezable> FREEZABLES = DataMapType.builder(Identifier.fromNamespaceAndPath(IcariaIds.ID, "freezables"), Registries.FLUID, Freezable.CODEC).synced(Freezable.CODEC, false).build();
	public static final DataMapType<Item, GrinderFuel> GRINDER_FUELS = DataMapType.builder(Identifier.fromNamespaceAndPath(IcariaIds.ID, "grinder_fuels"), Registries.ITEM, GrinderFuel.CODEC).synced(GrinderFuel.CODEC, false).build();
	public static final DataMapType<Item, Pottable> POTTABLES = DataMapType.builder(Identifier.fromNamespaceAndPath(IcariaIds.ID, "pottables"), Registries.ITEM, Pottable.CODEC).synced(Pottable.CODEC, false).build();
}
