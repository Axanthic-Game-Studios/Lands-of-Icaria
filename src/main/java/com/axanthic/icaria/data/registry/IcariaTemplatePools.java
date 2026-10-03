package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaProcessorListIds;
import com.axanthic.icaria.common.ids.IcariaTemplatePoolIds;
import com.axanthic.icaria.common.registry.IcariaBiomeTypes;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.registry.IcariaVillageTypes;

import com.google.common.collect.ImmutableList;

import com.mojang.datafixers.util.Pair;

import java.util.function.Function;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTemplatePools {
	public static void bootstrap(BootstrapContext<StructureTemplatePool> pBootstrapContext) {
		pBootstrapContext.register(IcariaTemplatePoolIds.PORTAL_ICARIA, IcariaTemplatePools.portalIcaria(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
		pBootstrapContext.register(IcariaTemplatePoolIds.PORTAL_NETHER, IcariaTemplatePools.portalNether(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));

		pBootstrapContext.register(IcariaTemplatePoolIds.RUIN_BUILDING, IcariaTemplatePools.ruinBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUIN)));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUIN_ENDING, IcariaTemplatePools.ruinEnding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUIN_STREET, IcariaTemplatePools.ruinStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUIN_WALK, IcariaTemplatePools.ruinWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));

		pBootstrapContext.register(IcariaTemplatePoolIds.TEMPLE_BACK, IcariaTemplatePools.templeBack(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.TEMPLE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.TEMPLE_HALL, IcariaTemplatePools.templeHall(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.TEMPLE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.TEMPLE_OPEN, IcariaTemplatePools.templeOpen(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.TEMPLE)));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_FOREST_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_DOLOMITE_FOREST_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_SILKSTONE_FOREST_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_SUNSTONE_FOREST_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_FOREST_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_DOLOMITE_FOREST_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_SILKSTONE_FOREST_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_SUNSTONE_FOREST_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_FOREST_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_DOLOMITE_FOREST_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_SILKSTONE_FOREST_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_SUNSTONE_FOREST_VILLAGE)));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_FOREST_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_FOREST_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_FOREST_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_FOREST_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_FOREST_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_FOREST_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_FOREST_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_FOREST_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_FOREST_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.FOREST, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_SCRUBLAND_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_SUNSTONE_SCRUBLAND_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_VOIDSHALE_SCRUBLAND_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_YELLOWSTONE_SCRUBLAND_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_SCRUBLAND_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_SUNSTONE_SCRUBLAND_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_VOIDSHALE_SCRUBLAND_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_YELLOWSTONE_SCRUBLAND_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_SCRUBLAND_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_SUNSTONE_SCRUBLAND_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_VOIDSHALE_SCRUBLAND_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_YELLOWSTONE_SCRUBLAND_VILLAGE)));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_SCRUBLAND_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_SCRUBLAND_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_SCRUBLAND_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_SCRUBLAND_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_SCRUBLAND_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_SCRUBLAND_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_SCRUBLAND_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_SCRUBLAND_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_SCRUBLAND_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_STEPPE_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_GRAINITE_STEPPE_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_MARL_STEPPE_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_YELLOWSTONE_STEPPE_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_STEPPE_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_GRAINITE_STEPPE_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_MARL_STEPPE_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_YELLOWSTONE_STEPPE_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_STEPPE_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_GRAINITE_STEPPE_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_MARL_STEPPE_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_YELLOWSTONE_STEPPE_VILLAGE)));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_STEPPE_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_STEPPE_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_STEPPE_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_STEPPE_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_STEPPE_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_STEPPE_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_STEPPE_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_STEPPE_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_STEPPE_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.STEPPE, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_DESERT_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_BAETYL_DESERT_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_GRAINITE_DESERT_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.ERODED_VOIDSHALE_DESERT_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_DESERT_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_BAETYL_DESERT_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_GRAINITE_DESERT_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.PRISTINE_VOIDSHALE_DESERT_VILLAGE)));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_DESERT_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_BAETYL_DESERT_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_GRAINITE_DESERT_VILLAGE), pBootstrapContext.lookup(Registries.PROCESSOR_LIST).getOrThrow(IcariaProcessorListIds.RUINED_VOIDSHALE_DESERT_VILLAGE)));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_DESERT_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_DESERT_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_DESERT_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_DESERT_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_DESERT_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_DESERT_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ERODED_DESERT_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.ERODED));
		pBootstrapContext.register(IcariaTemplatePoolIds.PRISTINE_DESERT_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.PRISTINE));
		pBootstrapContext.register(IcariaTemplatePoolIds.RUINED_DESERT_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY), IcariaBiomeTypes.DESERT, IcariaVillageTypes.RUINED));

		pBootstrapContext.register(IcariaTemplatePoolIds.ARACHNE, IcariaTemplatePools.arachne(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
		pBootstrapContext.register(IcariaTemplatePoolIds.ARACHNE_DRONE, IcariaTemplatePools.arachneDrone(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
		pBootstrapContext.register(IcariaTemplatePoolIds.CAPTAIN_REVENANT, IcariaTemplatePools.captainRevenant(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
		pBootstrapContext.register(IcariaTemplatePoolIds.REVENANT, IcariaTemplatePools.revenant(pBootstrapContext.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY)));
	}

	public static StructureTemplatePool portalIcaria(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_icaria_1000"), 2),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_icaria_1001"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_icaria_1002"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_icaria_1003"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_icaria_1004"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_icaria_1000"), 2),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_icaria_1001"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_icaria_1002"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_icaria_1003"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_icaria_1004"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool portalNether(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_nether_1000"), 2),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_nether_1001"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_nether_1002"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_nether_1003"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "ruined_portal_nether_1004"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_nether_1000"), 2),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_nether_1001"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_nether_1002"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_nether_1003"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "portal" + "/" + "mirrored_ruined_portal_nether_1004"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool ruinBuilding(Holder<StructureTemplatePool> pFallback, Holder<StructureProcessorList> pProcessor) {
		return new StructureTemplatePool(pFallback, ImmutableList.<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>>of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1000", pProcessor), 100),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1003", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1004", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1005", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1006", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1007", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1008", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1009", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1010", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1011", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1012", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1013", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1014", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1015", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1016", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1017", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1018", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1019", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1020", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1021", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1022", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1023", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1024", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1025", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1026", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1027", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1028", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1029", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1030", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1031", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1032", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1033", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1034", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1035", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1036", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1037", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1038", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1039", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1040", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1041", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1042", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1043", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1044", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1045", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1046", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1047", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1048", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1049", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1050", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1051", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1052", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1053", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1054", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1055", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1056", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1057", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1058", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1059", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1060", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1061", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1062", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1063", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1064", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1065", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1066", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1067", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1068", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1069", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1070", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1071", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1072", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1073", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1074", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1075", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1076", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1077", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1078", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1079", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1080", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1081", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1082", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1083", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1084", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1085", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1086", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1087", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1088", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1089", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1090", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1091", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1092", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1093", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1094", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1095", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1096", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1097", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1098", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1099", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1100", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1101", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1102", pProcessor), 4),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1103", pProcessor), 4),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1104", pProcessor), 4),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "building" + "/" + "ruin_1105", pProcessor), 4)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool ruinEnding(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "ending" + "/" + "ending"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "ending" + "/" + "ending_arch"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "ending" + "/" + "ending_junc"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "ending" + "/" + "ending_long"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool ruinStreet(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street_turn"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street_turn_half_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street_turn_half_long_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street_turn_semi"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street_turn_semi_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street_turn_semi_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "street" + "/" + "street_turn_semi_long_left"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool ruinWalk(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "walk" + "/" + "walk"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "walk" + "/" + "walk_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "walk" + "/" + "walk_turn_half"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "walk" + "/" + "walk_turn_half_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "walk" + "/" + "walk_turn_semi"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "ruin" + "/" + "walk" + "/" + "walk_turn_semi_left"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool templeBack(Holder<StructureTemplatePool> pFallback, Holder<StructureProcessorList> pProcessor) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_back_4000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_back_4001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_back_4002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_back_4003", pProcessor), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool templeHall(Holder<StructureTemplatePool> pFallback, Holder<StructureProcessorList> pProcessor) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_4000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_4001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_4002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_4003", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_5000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_5001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_5002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_5003", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_6000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_6001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_6002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "mirrored_ruined_temple_hall_6003", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_4000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_4001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_4002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_4003", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_5000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_5001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_5002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_5003", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_6000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_6001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_6002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_hall_6003", pProcessor), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool templeOpen(Holder<StructureTemplatePool> pFallback, Holder<StructureProcessorList> pProcessor) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_open_3000", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_open_3001", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_open_3002", pProcessor), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "temple" + "/" + "ruined_temple_open_3003", pProcessor), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool villagesBuilding(Holder<StructureTemplatePool> pFallback, Holder<StructureProcessorList> pProcessorA, Holder<StructureProcessorList> pProcessorB, Holder<StructureProcessorList> pProcessorC) {
		return new StructureTemplatePool(pFallback, ImmutableList.<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>>of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_arch_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_blob_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_hook_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_plus_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_plus_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1503", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2007", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2008", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2009", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2010", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2011", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_twin_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_arch_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_blob_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_hook_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_plus_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_plus_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1503", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2007", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2008", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2009", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2010", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2011", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_twin_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_arch_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_blob_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_hook_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_junc_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_loop_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_plus_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_plus_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_1503", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2007", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2008", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2009", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2010", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_rect_2011", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_turn_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "building_resident_twin_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_arch_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_blob_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_hook_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1503", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2007", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2008", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2009", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2010", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2011", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_twin_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_arch_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_blob_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_hook_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1503", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2007", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2008", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2009", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2010", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2011", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_twin_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_arch_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_blob_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_hook_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1503", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2007", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2008", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2009", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2010", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2011", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + "mirrored_building_resident_twin_1000", pProcessorC), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool villagesCenter(Holder<StructureTemplatePool> pFallback, String pBiomeType, String pVillageType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "center"), 1)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static StructureTemplatePool villagesStreet(Holder<StructureTemplatePool> pFallback, String pBiomeType, String pVillageType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street"), 4),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop_arch"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop_junc"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn"), 64),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_half_long"), 16),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_half_long_left"), 16),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi"), 16),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi_left"), 16),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi_long"), 16),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi_long_left"), 16)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static StructureTemplatePool villagesWalk(Holder<StructureTemplatePool> pFallback, String pBiomeType, String pVillageType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_half"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_half_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_semi"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_semi_left"), 1)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static StructureTemplatePool arachne(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "arachne"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool arachneDrone(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "arachne_drone"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool captainRevenant(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "captain_revenant"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool revenant(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "civilian_revenant"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "pyromancer_revenant"), 1),
			Pair.of(StructurePoolElement.single(IcariaIds.ID + ":" + "soldier_revenant"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}
}
