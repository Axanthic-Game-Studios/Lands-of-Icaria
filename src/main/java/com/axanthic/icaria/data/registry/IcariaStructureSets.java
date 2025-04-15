package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdents;

import java.util.List;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

@SuppressWarnings("deprecation, OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureSets {
	public static final ResourceKey<StructureSet> PORTAL = IcariaStructureSets.createKey("portal");
	public static final ResourceKey<StructureSet> RUIN = IcariaStructureSets.createKey("ruin");
	public static final ResourceKey<StructureSet> TEMPLE = IcariaStructureSets.createKey("temple");
	public static final ResourceKey<StructureSet> VILLAGES = IcariaStructureSets.createKey("villages");

	public static void bootstrap(BootstrapContext<StructureSet> pBootstrapContext) {
		var structures = pBootstrapContext.lookup(Registries.STRUCTURE);
		var structureSets = pBootstrapContext.lookup(Registries.STRUCTURE_SET);

		IcariaStructureSets.register(pBootstrapContext, IcariaStructureSets.PORTAL, List.of(StructureSet.entry(structures.getOrThrow(IcariaStructures.PORTAL_ICARIA), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.PORTAL_NETHER), 1)), Optional.of(new StructurePlacement.ExclusionZone(structureSets.getOrThrow(IcariaStructureSets.VILLAGES), 2)), 1797898789, 4, 6);
		IcariaStructureSets.register(pBootstrapContext, IcariaStructureSets.RUIN, List.of(StructureSet.entry(structures.getOrThrow(IcariaStructures.RUIN), 1)), Optional.empty(), 1347443952, 2, 4);
		IcariaStructureSets.register(pBootstrapContext, IcariaStructureSets.TEMPLE, List.of(StructureSet.entry(structures.getOrThrow(IcariaStructures.TEMPLE), 1)), Optional.of(new StructurePlacement.ExclusionZone(structureSets.getOrThrow(IcariaStructureSets.VILLAGES), 2)), 1821000543, 4, 6);
		IcariaStructureSets.register(pBootstrapContext, IcariaStructureSets.VILLAGES, List.of(StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_FOREST_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_FOREST_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_SCRUBLAND_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_SCRUBLAND_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_STEPPE_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_STEPPE_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.ERODED_DESERT_VILLAGE), 1), StructureSet.entry(structures.getOrThrow(IcariaStructures.RUINED_DESERT_VILLAGE), 1)), Optional.empty(), 1117821874, 8, 10);
	}

	public static Holder.Reference<StructureSet> register(BootstrapContext<StructureSet> pBootstrapContext, ResourceKey<StructureSet> pStructureSets, List<StructureSet.StructureSelectionEntry> pStructureSelectionEntries, Optional<StructurePlacement.ExclusionZone> pExclusionZone, int pSalt, int pSeparation, int pSpacing) {
		return pBootstrapContext.register(pStructureSets, new StructureSet(pStructureSelectionEntries, new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F, pSalt, pExclusionZone, pSpacing, pSeparation, RandomSpreadType.LINEAR)));
	}

	public static ResourceKey<StructureSet> createKey(String pName) {
		return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
