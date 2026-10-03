package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Instrument;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaInstrumentIds {
	public static final ResourceKey<Instrument> FAIL_CAPELLA_HORN = IcariaInstrumentIds.create("fail_capella_horn");

	public static ResourceKey<Instrument> create(String pName) {
		return ResourceKey.create(Registries.INSTRUMENT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
