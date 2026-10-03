package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTemplatePoolIds {
	public static final ResourceKey<StructureTemplatePool> PORTAL_ICARIA = IcariaTemplatePoolIds.create("portal/icaria");
	public static final ResourceKey<StructureTemplatePool> PORTAL_NETHER = IcariaTemplatePoolIds.create("portal/nether");

	public static final ResourceKey<StructureTemplatePool> RUIN_BUILDING = IcariaTemplatePoolIds.create("ruin/building");
	public static final ResourceKey<StructureTemplatePool> RUIN_ENDING = IcariaTemplatePoolIds.create("ruin/ending");
	public static final ResourceKey<StructureTemplatePool> RUIN_STREET = IcariaTemplatePoolIds.create("ruin/street");
	public static final ResourceKey<StructureTemplatePool> RUIN_WALK = IcariaTemplatePoolIds.create("ruin/walk");

	public static final ResourceKey<StructureTemplatePool> TEMPLE_BACK = IcariaTemplatePoolIds.create("temple/back");
	public static final ResourceKey<StructureTemplatePool> TEMPLE_HALL = IcariaTemplatePoolIds.create("temple/hall");
	public static final ResourceKey<StructureTemplatePool> TEMPLE_OPEN = IcariaTemplatePoolIds.create("temple/open");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/forest/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/forest/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/forest/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/forest/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/forest/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/forest/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/forest/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/forest/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/forest/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/forest/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/forest/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/forest/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/scrubland/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/scrubland/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/scrubland/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/scrubland/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/scrubland/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/scrubland/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/scrubland/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/scrubland/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/scrubland/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/scrubland/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/scrubland/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/scrubland/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/steppe/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/steppe/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/steppe/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/steppe/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/steppe/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/steppe/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/steppe/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/steppe/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/steppe/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/steppe/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/steppe/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/steppe/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/desert/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/desert/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_BUILDING = IcariaTemplatePoolIds.create("villages/desert/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/desert/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/desert/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_CENTER = IcariaTemplatePoolIds.create("villages/desert/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/desert/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/desert/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_STREET = IcariaTemplatePoolIds.create("villages/desert/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/desert/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/desert/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_WALK = IcariaTemplatePoolIds.create("villages/desert/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> ARACHNE = IcariaTemplatePoolIds.create("arachne");
	public static final ResourceKey<StructureTemplatePool> ARACHNE_DRONE = IcariaTemplatePoolIds.create("arachne_drone");
	public static final ResourceKey<StructureTemplatePool> CAPTAIN_REVENANT = IcariaTemplatePoolIds.create("captain_revenant");
	public static final ResourceKey<StructureTemplatePool> REVENANT = IcariaTemplatePoolIds.create("revenant");

	public static ResourceKey<StructureTemplatePool> create(String pName) {
		return ResourceKey.create(Registries.TEMPLATE_POOL, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
