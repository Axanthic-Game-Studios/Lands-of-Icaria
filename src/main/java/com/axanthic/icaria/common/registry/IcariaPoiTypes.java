package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, IcariaInfo.ID);

    public static final RegistryObject<PoiType> PORTAL = IcariaPoiTypes.POI_TYPES.register("portal", () -> new PoiType(ImmutableSet.copyOf(IcariaBlocks.PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
