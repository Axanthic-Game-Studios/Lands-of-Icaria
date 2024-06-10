package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, IcariaInfo.ID);

    public static final Supplier<PoiType> ICARIA_PORTAL = IcariaPoiTypes.POI_TYPES.register("icaria_portal", () -> new PoiType(ImmutableSet.copyOf(IcariaBlocks.ICARIA_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
