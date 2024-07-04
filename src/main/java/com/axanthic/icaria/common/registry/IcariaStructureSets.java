package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureSets {
	public static final ResourceKey<StructureSet> VILLAGES = IcariaStructureSets.createKey("villages");

	public static void bootstrap(BootstrapContext<StructureSet> pContext) {
		var structures = pContext.lookup(Registries.STRUCTURE);
		pContext.register(IcariaStructureSets.VILLAGES, new StructureSet(List.of(StructureSet.entry(structures.getOrThrow(IcariaStructures.FOREST_ERODED), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.FOREST_RUINED), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.SCRUBLAND_ERODED), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.SCRUBLAND_RUINED), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.STEPPE_ERODED), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.STEPPE_RUINED), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.DESERT_ERODED), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.DESERT_RUINED), 1)), new RandomSpreadStructurePlacement(4, 3, RandomSpreadType.LINEAR, 1117821874)));
	}

	public static ResourceKey<StructureSet> createKey(String pName) {
		return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
