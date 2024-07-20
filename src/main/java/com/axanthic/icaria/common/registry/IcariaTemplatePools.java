package com.axanthic.icaria.common.registry;

import com.google.common.collect.ImmutableList;

import com.mojang.datafixers.util.Pair;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.function.Function;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTemplatePools {
	public static final ResourceKey<StructureTemplatePool> ARACHNE = IcariaTemplatePools.createKey("arachne");
	public static final ResourceKey<StructureTemplatePool> ARACHNE_DRONE = IcariaTemplatePools.createKey("arachne_drone");
	public static final ResourceKey<StructureTemplatePool> CAPTAIN_REVENANT = IcariaTemplatePools.createKey("captain_revenant");
	public static final ResourceKey<StructureTemplatePool> REVENANT = IcariaTemplatePools.createKey("revenant");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/forest/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/forest/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/forest/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/forest/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/forest/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/forest/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/forest/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/forest/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/forest/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_FOREST_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/forest/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_FOREST_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/forest/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_FOREST_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/forest/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/scrubland/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/scrubland/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/scrubland/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/scrubland/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/scrubland/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/scrubland/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/scrubland/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/scrubland/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/scrubland/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_SCRUBLAND_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/scrubland/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_SCRUBLAND_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/scrubland/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_SCRUBLAND_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/scrubland/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/steppe/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/steppe/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/steppe/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/steppe/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/steppe/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/steppe/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/steppe/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/steppe/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/steppe/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_STEPPE_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/steppe/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_STEPPE_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/steppe/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_STEPPE_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/steppe/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/desert/eroded/building");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/desert/pristine/building");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_BUILDING = IcariaTemplatePools.createKey("villages/desert/ruined/building");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/desert/eroded/center");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/desert/pristine/center");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_CENTER = IcariaTemplatePools.createKey("villages/desert/ruined/center");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/desert/eroded/street");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/desert/pristine/street");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_STREET = IcariaTemplatePools.createKey("villages/desert/ruined/street");

	public static final ResourceKey<StructureTemplatePool> ERODED_DESERT_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/desert/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> PRISTINE_DESERT_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/desert/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> RUINED_DESERT_VILLAGE_WALK = IcariaTemplatePools.createKey("villages/desert/ruined/walk");

	public static void bootstrap(BootstrapContext<StructureTemplatePool> pContext) {
		var lists = pContext.lookup(Registries.PROCESSOR_LIST);
		var pools = pContext.lookup(Registries.TEMPLATE_POOL);
		var empty = pools.getOrThrow(Pools.EMPTY);

		pContext.register(IcariaTemplatePools.ARACHNE, IcariaTemplatePools.arachne(empty));
		pContext.register(IcariaTemplatePools.ARACHNE_DRONE, IcariaTemplatePools.arachneDrone(empty));
		pContext.register(IcariaTemplatePools.CAPTAIN_REVENANT, IcariaTemplatePools.captainRevenant(empty));
		pContext.register(IcariaTemplatePools.REVENANT, IcariaTemplatePools.revenant(empty));

		pContext.register(IcariaTemplatePools.ERODED_FOREST_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.ERODED_DOLOMITE_FOREST_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_SILKSTONE_FOREST_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_SUNSTONE_FOREST_VILLAGE)));
		pContext.register(IcariaTemplatePools.PRISTINE_FOREST_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.PRISTINE_DOLOMITE_FOREST_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_SILKSTONE_FOREST_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_SUNSTONE_FOREST_VILLAGE)));
		pContext.register(IcariaTemplatePools.RUINED_FOREST_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.RUINED_DOLOMITE_FOREST_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_SILKSTONE_FOREST_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_SUNSTONE_FOREST_VILLAGE)));

		pContext.register(IcariaTemplatePools.ERODED_FOREST_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_FOREST_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_FOREST_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_FOREST_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_FOREST_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_FOREST_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_FOREST_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_FOREST_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_FOREST_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.FOREST, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_SCRUBLAND_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.ERODED_SUNSTONE_SCRUBLAND_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_VOIDSHALE_SCRUBLAND_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_YELLOWSTONE_SCRUBLAND_VILLAGE)));
		pContext.register(IcariaTemplatePools.PRISTINE_SCRUBLAND_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.PRISTINE_SUNSTONE_SCRUBLAND_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_VOIDSHALE_SCRUBLAND_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_YELLOWSTONE_SCRUBLAND_VILLAGE)));
		pContext.register(IcariaTemplatePools.RUINED_SCRUBLAND_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.RUINED_SUNSTONE_SCRUBLAND_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_VOIDSHALE_SCRUBLAND_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_YELLOWSTONE_SCRUBLAND_VILLAGE)));

		pContext.register(IcariaTemplatePools.ERODED_SCRUBLAND_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_SCRUBLAND_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_SCRUBLAND_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_SCRUBLAND_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_SCRUBLAND_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_SCRUBLAND_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_SCRUBLAND_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_SCRUBLAND_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_SCRUBLAND_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_STEPPE_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.ERODED_GRAINITE_STEPPE_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_MARL_STEPPE_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_YELLOWSTONE_STEPPE_VILLAGE)));
		pContext.register(IcariaTemplatePools.PRISTINE_STEPPE_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.PRISTINE_GRAINITE_STEPPE_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_MARL_STEPPE_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_YELLOWSTONE_STEPPE_VILLAGE)));
		pContext.register(IcariaTemplatePools.RUINED_STEPPE_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.RUINED_GRAINITE_STEPPE_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_MARL_STEPPE_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_YELLOWSTONE_STEPPE_VILLAGE)));

		pContext.register(IcariaTemplatePools.ERODED_STEPPE_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_STEPPE_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_STEPPE_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_STEPPE_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_STEPPE_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_STEPPE_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_STEPPE_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_STEPPE_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_STEPPE_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.STEPPE, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_DESERT_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.ERODED_BAETYL_DESERT_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_GRAINITE_DESERT_VILLAGE), lists.getOrThrow(IcariaProcessorLists.ERODED_VOIDSHALE_DESERT_VILLAGE)));
		pContext.register(IcariaTemplatePools.PRISTINE_DESERT_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.PRISTINE_BAETYL_DESERT_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_GRAINITE_DESERT_VILLAGE), lists.getOrThrow(IcariaProcessorLists.PRISTINE_VOIDSHALE_DESERT_VILLAGE)));
		pContext.register(IcariaTemplatePools.RUINED_DESERT_VILLAGE_BUILDING, IcariaTemplatePools.villagesBuilding(empty, lists.getOrThrow(IcariaProcessorLists.RUINED_BAETYL_DESERT_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_GRAINITE_DESERT_VILLAGE), lists.getOrThrow(IcariaProcessorLists.RUINED_VOIDSHALE_DESERT_VILLAGE)));

		pContext.register(IcariaTemplatePools.ERODED_DESERT_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_DESERT_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_DESERT_VILLAGE_CENTER, IcariaTemplatePools.villagesCenter(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_DESERT_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_DESERT_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_DESERT_VILLAGE_STREET, IcariaTemplatePools.villagesStreet(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.ERODED_DESERT_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.PRISTINE_DESERT_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.RUINED_DESERT_VILLAGE_WALK, IcariaTemplatePools.villagesWalk(empty, IcariaBiomeTypes.DESERT, IcariaVillageTypes.RUINED));



	}

	public static StructureTemplatePool arachne(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "arachne"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool arachneDrone(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "arachne_drone"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool captainRevenant(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "captain_revenant"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool revenant(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "civilian_revenant"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "pyromancer_revenant"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "soldier_revenant"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool villagesBuilding(Holder<StructureTemplatePool> pFallback, Holder<StructureProcessorList> pProcessorA, Holder<StructureProcessorList> pProcessorB, Holder<StructureProcessorList> pProcessorC) {
		return new StructureTemplatePool(pFallback, ImmutableList.<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>>of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_arch_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_blob_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_hook_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_plus_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_plus_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1503", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2007", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2008", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2009", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2010", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2011", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_twin_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_arch_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_blob_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_hook_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_plus_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_plus_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1503", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2007", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2008", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2009", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2010", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2011", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_twin_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_arch_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_blob_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_hook_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_junc_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_loop_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_plus_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_plus_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_1503", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2007", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2008", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2009", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2010", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_rect_2011", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_turn_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "building_resident_twin_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_arch_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_blob_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_hook_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1503", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2007", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2008", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2009", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2010", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2011", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1500", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1501", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1502", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2001", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2002", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2003", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2004", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2005", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2006", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_twin_1000", pProcessorA), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_arch_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_blob_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_hook_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1503", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2007", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2008", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2009", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2010", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2011", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1500", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1501", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1502", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2001", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2002", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2003", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2004", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2005", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2006", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_twin_1000", pProcessorB), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_arch_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_blob_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_hook_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_junc_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_loop_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_plus_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_1503", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2007", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2008", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2009", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2010", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_rect_2011", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1500", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1501", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_1502", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2000", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2001", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2002", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2003", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2004", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2005", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_turn_2006", pProcessorC), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "mirrored_building_resident_twin_1000", pProcessorC), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool villagesCenter(Holder<StructureTemplatePool> pFallback, String pBiomeType, String pVillageType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "center"), 1)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static StructureTemplatePool villagesStreet(Holder<StructureTemplatePool> pFallback, String pBiomeType, String pVillageType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street"), 4),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop_arch"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop_junc"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_stop_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn"), 64),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_half_long"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_half_long_left"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi_left"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi_long"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "street_turn_semi_long_left"), 16)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static StructureTemplatePool villagesWalk(Holder<StructureTemplatePool> pFallback, String pBiomeType, String pVillageType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_half"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_half_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_semi"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiomeType + "/" + pVillageType + "/" + "walk_turn_semi_left"), 1)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static ResourceKey<StructureTemplatePool> createKey(String pName) {
		return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
