package com.axanthic.icaria.common.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureTags {
	public static final TagKey<Structure> FOREST_VILLAGES = IcariaStructureTags.creatIcaria("forest_villages");
	public static final TagKey<Structure> SCRUBLAND_VILLAGES = IcariaStructureTags.creatIcaria("scrubland_villages");
	public static final TagKey<Structure> STEPPE_VILLAGES = IcariaStructureTags.creatIcaria("steppe_villages");
	public static final TagKey<Structure> DESERT_VILLAGES = IcariaStructureTags.creatIcaria("desert_villages");

	public static final TagKey<Structure> ERODED_VILLAGES = IcariaStructureTags.creatIcaria("eroded_villages");
	public static final TagKey<Structure> PRISTINE_VILLAGES = IcariaStructureTags.creatIcaria("pristine_villages");
	public static final TagKey<Structure> RUINED_VILLAGES = IcariaStructureTags.creatIcaria("ruined_villages");

	public static final TagKey<Structure> VILLAGES = IcariaStructureTags.creatIcaria("villages");

	public static TagKey<Structure> create(String pName) {
		return TagKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(IcariaIds.C, pName));
	}

	public static TagKey<Structure> creatIcaria(String pName) {
		return TagKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
