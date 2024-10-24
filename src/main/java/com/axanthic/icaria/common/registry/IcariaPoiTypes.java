package com.axanthic.icaria.common.registry;

import com.google.common.collect.ImmutableSet;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPoiTypes {
	public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, IcariaIdents.ID);

	public static final Holder<PoiType> ICARIA_PORTAL = IcariaPoiTypes.POI_TYPES.register("icaria_portal", () -> new PoiType(ImmutableSet.copyOf(IcariaBlocks.ICARIA_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
