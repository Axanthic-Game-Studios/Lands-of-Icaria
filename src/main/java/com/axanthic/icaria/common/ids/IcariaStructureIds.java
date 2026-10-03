package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureIds {
	public static final ResourceKey<Structure> PORTAL_ICARIA = IcariaStructureIds.create("portal/icaria");
	public static final ResourceKey<Structure> PORTAL_NETHER = IcariaStructureIds.create("portal/nether");

	public static final ResourceKey<Structure> RUIN = IcariaStructureIds.create("ruin");

	public static final ResourceKey<Structure> TEMPLE = IcariaStructureIds.create("temple");

	public static final ResourceKey<Structure> ERODED_FOREST_VILLAGE = IcariaStructureIds.create("villages/forest/eroded");
	public static final ResourceKey<Structure> PRISTINE_FOREST_VILLAGE = IcariaStructureIds.create("villages/forest/pristine");
	public static final ResourceKey<Structure> RUINED_FOREST_VILLAGE = IcariaStructureIds.create("villages/forest/ruined");

	public static final ResourceKey<Structure> ERODED_SCRUBLAND_VILLAGE = IcariaStructureIds.create("villages/scrubland/eroded");
	public static final ResourceKey<Structure> PRISTINE_SCRUBLAND_VILLAGE = IcariaStructureIds.create("villages/scrubland/pristine");
	public static final ResourceKey<Structure> RUINED_SCRUBLAND_VILLAGE = IcariaStructureIds.create("villages/scrubland/ruined");

	public static final ResourceKey<Structure> ERODED_STEPPE_VILLAGE = IcariaStructureIds.create("villages/steppe/eroded");
	public static final ResourceKey<Structure> PRISTINE_STEPPE_VILLAGE = IcariaStructureIds.create("villages/steppe/pristine");
	public static final ResourceKey<Structure> RUINED_STEPPE_VILLAGE = IcariaStructureIds.create("villages/steppe/ruined");

	public static final ResourceKey<Structure> ERODED_DESERT_VILLAGE = IcariaStructureIds.create("villages/desert/eroded");
	public static final ResourceKey<Structure> PRISTINE_DESERT_VILLAGE = IcariaStructureIds.create("villages/desert/pristine");
	public static final ResourceKey<Structure> RUINED_DESERT_VILLAGE = IcariaStructureIds.create("villages/desert/ruined");

	public static ResourceKey<Structure> create(String pName) {
		return ResourceKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
