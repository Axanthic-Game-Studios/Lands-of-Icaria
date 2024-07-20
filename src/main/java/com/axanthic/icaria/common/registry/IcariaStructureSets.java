package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

import java.util.List;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureSets {
	public static final ResourceKey<StructureSet> TEMPLE = IcariaStructureSets.createKey("temple");
	public static final ResourceKey<StructureSet> VILLAGES = IcariaStructureSets.createKey("villages");

	public static void bootstrap(BootstrapContext<StructureSet> pContext) {
		var structures = pContext.lookup(Registries.STRUCTURE);
		var structureSets = pContext.lookup(Registries.STRUCTURE_SET);

		pContext.register(IcariaStructureSets.TEMPLE, new StructureSet(List.of(StructureSet.entry(structures.getOrThrow(IcariaStructures.TEMPLE), 1)), new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F, 1821000543, Optional.of(new StructurePlacement.ExclusionZone(structureSets.getOrThrow(IcariaStructureSets.VILLAGES), 2)), 4, 3, RandomSpreadType.LINEAR)));
		pContext.register(IcariaStructureSets.VILLAGES, new StructureSet(List.of(StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_FOREST_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_FOREST_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_SCRUBLAND_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_SCRUBLAND_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_STEPPE_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_STEPPE_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_DESERT_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_DESERT_VILLAGE), 1)), new RandomSpreadStructurePlacement(8, 6, RandomSpreadType.LINEAR, 1117821874)));
	}

	public static ResourceKey<StructureSet> createKey(String pName) {
		return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
