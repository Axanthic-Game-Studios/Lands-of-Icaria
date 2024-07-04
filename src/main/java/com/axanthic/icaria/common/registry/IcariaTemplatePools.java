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
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.function.Function;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTemplatePools {
	public static final ResourceKey<StructureTemplatePool> ARACHNE = IcariaTemplatePools.createKey("villages/arachne");
	public static final ResourceKey<StructureTemplatePool> ARACHNE_DRONE = IcariaTemplatePools.createKey("villages/arachne_drone");
	public static final ResourceKey<StructureTemplatePool> CAPTAIN_REVENANT = IcariaTemplatePools.createKey("villages/captain_revenant");
	public static final ResourceKey<StructureTemplatePool> REVENANT = IcariaTemplatePools.createKey("villages/revenant");

	public static final ResourceKey<StructureTemplatePool> FOREST_ERODED_BUILDING = IcariaTemplatePools.createKey("villages/forest/eroded/building");
	public static final ResourceKey<StructureTemplatePool> FOREST_PRISTINE_BUILDING = IcariaTemplatePools.createKey("villages/forest/pristine/building");
	public static final ResourceKey<StructureTemplatePool> FOREST_RUINED_BUILDING = IcariaTemplatePools.createKey("villages/forest/ruined/building");

	public static final ResourceKey<StructureTemplatePool> FOREST_ERODED_CENTER = IcariaTemplatePools.createKey("villages/forest/eroded/center");
	public static final ResourceKey<StructureTemplatePool> FOREST_PRISTINE_CENTER = IcariaTemplatePools.createKey("villages/forest/pristine/center");
	public static final ResourceKey<StructureTemplatePool> FOREST_RUINED_CENTER = IcariaTemplatePools.createKey("villages/forest/ruined/center");

	public static final ResourceKey<StructureTemplatePool> FOREST_ERODED_STREET = IcariaTemplatePools.createKey("villages/forest/eroded/street");
	public static final ResourceKey<StructureTemplatePool> FOREST_PRISTINE_STREET = IcariaTemplatePools.createKey("villages/forest/pristine/street");
	public static final ResourceKey<StructureTemplatePool> FOREST_RUINED_STREET = IcariaTemplatePools.createKey("villages/forest/ruined/street");

	public static final ResourceKey<StructureTemplatePool> FOREST_ERODED_WALK = IcariaTemplatePools.createKey("villages/forest/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> FOREST_PRISTINE_WALK = IcariaTemplatePools.createKey("villages/forest/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> FOREST_RUINED_WALK = IcariaTemplatePools.createKey("villages/forest/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_ERODED_BUILDING = IcariaTemplatePools.createKey("villages/scrubland/eroded/building");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_PRISTINE_BUILDING = IcariaTemplatePools.createKey("villages/scrubland/pristine/building");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_RUINED_BUILDING = IcariaTemplatePools.createKey("villages/scrubland/ruined/building");

	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_ERODED_CENTER = IcariaTemplatePools.createKey("villages/scrubland/eroded/center");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_PRISTINE_CENTER = IcariaTemplatePools.createKey("villages/scrubland/pristine/center");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_RUINED_CENTER = IcariaTemplatePools.createKey("villages/scrubland/ruined/center");

	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_ERODED_STREET = IcariaTemplatePools.createKey("villages/scrubland/eroded/street");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_PRISTINE_STREET = IcariaTemplatePools.createKey("villages/scrubland/pristine/street");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_RUINED_STREET = IcariaTemplatePools.createKey("villages/scrubland/ruined/street");

	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_ERODED_WALK = IcariaTemplatePools.createKey("villages/scrubland/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_PRISTINE_WALK = IcariaTemplatePools.createKey("villages/scrubland/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> SCRUBLAND_RUINED_WALK = IcariaTemplatePools.createKey("villages/scrubland/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> STEPPE_ERODED_BUILDING = IcariaTemplatePools.createKey("villages/steppe/eroded/building");
	public static final ResourceKey<StructureTemplatePool> STEPPE_PRISTINE_BUILDING = IcariaTemplatePools.createKey("villages/steppe/pristine/building");
	public static final ResourceKey<StructureTemplatePool> STEPPE_RUINED_BUILDING = IcariaTemplatePools.createKey("villages/steppe/ruined/building");

	public static final ResourceKey<StructureTemplatePool> STEPPE_ERODED_CENTER = IcariaTemplatePools.createKey("villages/steppe/eroded/center");
	public static final ResourceKey<StructureTemplatePool> STEPPE_PRISTINE_CENTER = IcariaTemplatePools.createKey("villages/steppe/pristine/center");
	public static final ResourceKey<StructureTemplatePool> STEPPE_RUINED_CENTER = IcariaTemplatePools.createKey("villages/steppe/ruined/center");

	public static final ResourceKey<StructureTemplatePool> STEPPE_ERODED_STREET = IcariaTemplatePools.createKey("villages/steppe/eroded/street");
	public static final ResourceKey<StructureTemplatePool> STEPPE_PRISTINE_STREET = IcariaTemplatePools.createKey("villages/steppe/pristine/street");
	public static final ResourceKey<StructureTemplatePool> STEPPE_RUINED_STREET = IcariaTemplatePools.createKey("villages/steppe/ruined/street");

	public static final ResourceKey<StructureTemplatePool> STEPPE_ERODED_WALK = IcariaTemplatePools.createKey("villages/steppe/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> STEPPE_PRISTINE_WALK = IcariaTemplatePools.createKey("villages/steppe/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> STEPPE_RUINED_WALK = IcariaTemplatePools.createKey("villages/steppe/ruined/walk");

	public static final ResourceKey<StructureTemplatePool> DESERT_ERODED_BUILDING = IcariaTemplatePools.createKey("villages/desert/eroded/building");
	public static final ResourceKey<StructureTemplatePool> DESERT_PRISTINE_BUILDING = IcariaTemplatePools.createKey("villages/desert/pristine/building");
	public static final ResourceKey<StructureTemplatePool> DESERT_RUINED_BUILDING = IcariaTemplatePools.createKey("villages/desert/ruined/building");

	public static final ResourceKey<StructureTemplatePool> DESERT_ERODED_CENTER = IcariaTemplatePools.createKey("villages/desert/eroded/center");
	public static final ResourceKey<StructureTemplatePool> DESERT_PRISTINE_CENTER = IcariaTemplatePools.createKey("villages/desert/pristine/center");
	public static final ResourceKey<StructureTemplatePool> DESERT_RUINED_CENTER = IcariaTemplatePools.createKey("villages/desert/ruined/center");

	public static final ResourceKey<StructureTemplatePool> DESERT_ERODED_STREET = IcariaTemplatePools.createKey("villages/desert/eroded/street");
	public static final ResourceKey<StructureTemplatePool> DESERT_PRISTINE_STREET = IcariaTemplatePools.createKey("villages/desert/pristine/street");
	public static final ResourceKey<StructureTemplatePool> DESERT_RUINED_STREET = IcariaTemplatePools.createKey("villages/desert/ruined/street");

	public static final ResourceKey<StructureTemplatePool> DESERT_ERODED_WALK = IcariaTemplatePools.createKey("villages/desert/eroded/walk");
	public static final ResourceKey<StructureTemplatePool> DESERT_PRISTINE_WALK = IcariaTemplatePools.createKey("villages/desert/pristine/walk");
	public static final ResourceKey<StructureTemplatePool> DESERT_RUINED_WALK = IcariaTemplatePools.createKey("villages/desert/ruined/walk");

	public static void bootstrap(BootstrapContext<StructureTemplatePool> pContext) {
		var lists = pContext.lookup(Registries.PROCESSOR_LIST);
		var pools = pContext.lookup(Registries.TEMPLATE_POOL);
		var empty = pools.getOrThrow(Pools.EMPTY);

		pContext.register(IcariaTemplatePools.ARACHNE, IcariaTemplatePools.arachne(empty));
		pContext.register(IcariaTemplatePools.ARACHNE_DRONE, IcariaTemplatePools.arachneDrone(empty));
		pContext.register(IcariaTemplatePools.CAPTAIN_REVENANT, IcariaTemplatePools.captainRevenant(empty));
		pContext.register(IcariaTemplatePools.REVENANT, IcariaTemplatePools.revenant(empty));

		pContext.register(IcariaTemplatePools.FOREST_ERODED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.FOREST_ERODED_DOLOMITE), lists.getOrThrow(IcariaProcessorLists.FOREST_ERODED_SILKSTONE), lists.getOrThrow(IcariaProcessorLists.FOREST_ERODED_SUNSTONE)));
		pContext.register(IcariaTemplatePools.FOREST_PRISTINE_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.FOREST_PRISTINE_DOLOMITE), lists.getOrThrow(IcariaProcessorLists.FOREST_PRISTINE_SILKSTONE), lists.getOrThrow(IcariaProcessorLists.FOREST_PRISTINE_SUNSTONE)));
		pContext.register(IcariaTemplatePools.FOREST_RUINED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.FOREST_RUINED_DOLOMITE), lists.getOrThrow(IcariaProcessorLists.FOREST_RUINED_SILKSTONE), lists.getOrThrow(IcariaProcessorLists.FOREST_RUINED_SUNSTONE)));

		pContext.register(IcariaTemplatePools.FOREST_ERODED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.FOREST, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.FOREST_PRISTINE_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.FOREST, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.FOREST_RUINED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.FOREST, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.FOREST_ERODED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.FOREST, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.FOREST_PRISTINE_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.FOREST, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.FOREST_RUINED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.FOREST, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.FOREST_ERODED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.FOREST, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.FOREST_PRISTINE_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.FOREST, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.FOREST_RUINED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.FOREST, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.SCRUBLAND_ERODED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_ERODED_SUNSTONE), lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_ERODED_VOIDSHALE), lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_ERODED_YELLOWSTONE)));
		pContext.register(IcariaTemplatePools.SCRUBLAND_PRISTINE_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_PRISTINE_SUNSTONE), lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_PRISTINE_VOIDSHALE), lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_PRISTINE_YELLOWSTONE)));
		pContext.register(IcariaTemplatePools.SCRUBLAND_RUINED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_RUINED_SUNSTONE), lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_RUINED_VOIDSHALE), lists.getOrThrow(IcariaProcessorLists.SCRUBLAND_RUINED_YELLOWSTONE)));

		pContext.register(IcariaTemplatePools.SCRUBLAND_ERODED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.SCRUBLAND_PRISTINE_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.SCRUBLAND_RUINED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.SCRUBLAND_ERODED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.SCRUBLAND_PRISTINE_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.SCRUBLAND_RUINED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.SCRUBLAND_ERODED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.SCRUBLAND_PRISTINE_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.SCRUBLAND_RUINED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.SCRUBLAND, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.STEPPE_ERODED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.STEPPE_ERODED_GRAINITE), lists.getOrThrow(IcariaProcessorLists.STEPPE_ERODED_MARL), lists.getOrThrow(IcariaProcessorLists.STEPPE_ERODED_YELLOWSTONE)));
		pContext.register(IcariaTemplatePools.STEPPE_PRISTINE_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.STEPPE_PRISTINE_GRAINITE), lists.getOrThrow(IcariaProcessorLists.STEPPE_PRISTINE_MARL), lists.getOrThrow(IcariaProcessorLists.STEPPE_PRISTINE_YELLOWSTONE)));
		pContext.register(IcariaTemplatePools.STEPPE_RUINED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.STEPPE_RUINED_GRAINITE), lists.getOrThrow(IcariaProcessorLists.STEPPE_RUINED_MARL), lists.getOrThrow(IcariaProcessorLists.STEPPE_RUINED_YELLOWSTONE)));

		pContext.register(IcariaTemplatePools.STEPPE_ERODED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.STEPPE_PRISTINE_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.STEPPE_RUINED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.STEPPE_ERODED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.STEPPE_PRISTINE_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.STEPPE_RUINED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.STEPPE_ERODED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.STEPPE_PRISTINE_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.STEPPE_RUINED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.STEPPE, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.DESERT_ERODED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.DESERT_ERODED_BAETYL), lists.getOrThrow(IcariaProcessorLists.DESERT_ERODED_GRAINITE), lists.getOrThrow(IcariaProcessorLists.DESERT_ERODED_VOIDSHALE)));
		pContext.register(IcariaTemplatePools.DESERT_PRISTINE_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.DESERT_PRISTINE_BAETYL), lists.getOrThrow(IcariaProcessorLists.DESERT_PRISTINE_GRAINITE), lists.getOrThrow(IcariaProcessorLists.DESERT_PRISTINE_VOIDSHALE)));
		pContext.register(IcariaTemplatePools.DESERT_RUINED_BUILDING, IcariaTemplatePools.building(empty, lists.getOrThrow(IcariaProcessorLists.DESERT_RUINED_BAETYL), lists.getOrThrow(IcariaProcessorLists.DESERT_RUINED_GRAINITE), lists.getOrThrow(IcariaProcessorLists.DESERT_RUINED_VOIDSHALE)));

		pContext.register(IcariaTemplatePools.DESERT_ERODED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.DESERT, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.DESERT_PRISTINE_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.DESERT, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.DESERT_RUINED_CENTER, IcariaTemplatePools.center(empty, IcariaBiomes.DESERT, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.DESERT_ERODED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.DESERT, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.DESERT_PRISTINE_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.DESERT, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.DESERT_RUINED_STREET, IcariaTemplatePools.street(empty, IcariaBiomes.DESERT, IcariaVillageTypes.RUINED));

		pContext.register(IcariaTemplatePools.DESERT_ERODED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.DESERT, IcariaVillageTypes.ERODED));
		pContext.register(IcariaTemplatePools.DESERT_PRISTINE_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.DESERT, IcariaVillageTypes.PRISTINE));
		pContext.register(IcariaTemplatePools.DESERT_RUINED_WALK, IcariaTemplatePools.walk(empty, IcariaBiomes.DESERT, IcariaVillageTypes.RUINED));
	}

	public static StructureTemplatePool arachne(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "arachne"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool arachneDrone(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "arachne_drone"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool captainRevenant(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "captain_revenant"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool revenant(Holder<StructureTemplatePool> pFallback) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "civilian_revenant"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "pyromancer_revenant"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + "soldier_revenant"), 1)
		), StructureTemplatePool.Projection.RIGID);
	}

	public static StructureTemplatePool building(Holder<StructureTemplatePool> pFallback, Holder<StructureProcessorList> pProcessorA, Holder<StructureProcessorList> pProcessorB, Holder<StructureProcessorList> pProcessorC) {
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

	public static StructureTemplatePool center(Holder<StructureTemplatePool> pFallback, ResourceKey<Biome> pBiome, String pType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "center"), 1)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static StructureTemplatePool street(Holder<StructureTemplatePool> pFallback, ResourceKey<Biome> pBiome, String pType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street"), 4),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_stop"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_stop_arch"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_stop_junc"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_stop_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_turn"), 64),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_turn_half_long"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_turn_half_long_left"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_turn_semi"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_turn_semi_left"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_turn_semi_long"), 16),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "street_turn_semi_long_left"), 16)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static StructureTemplatePool walk(Holder<StructureTemplatePool> pFallback, ResourceKey<Biome> pBiome, String pType) {
		return new StructureTemplatePool(pFallback, ImmutableList.of(
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk_long"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk_turn"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk_turn_half"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk_turn_half_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk_turn_left"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk_turn_semi"), 1),
			Pair.of(StructurePoolElement.single(IcariaIdents.ID + ":" + "villages" + "/" + pBiome.location().getPath() + "/" + pType + "/" + "walk_turn_semi_left"), 1)
		), StructureTemplatePool.Projection.TERRAIN_MATCHING);
	}

	public static ResourceKey<StructureTemplatePool> createKey(String pName) {
		return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
