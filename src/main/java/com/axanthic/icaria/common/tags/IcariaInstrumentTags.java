package com.axanthic.icaria.common.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaInstrumentTags {
	public static final TagKey<Instrument> CAPELLA_HORNS = IcariaInstrumentTags.creatIcaria("capella_horns");

	public static TagKey<Instrument> create(String pName) {
		return TagKey.create(Registries.INSTRUMENT, Identifier.fromNamespaceAndPath(IcariaIds.C, pName));
	}

	public static TagKey<Instrument> creatIcaria(String pName) {
		return TagKey.create(Registries.INSTRUMENT, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
