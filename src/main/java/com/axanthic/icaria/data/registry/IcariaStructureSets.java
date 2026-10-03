package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaStructureIds;
import com.axanthic.icaria.common.ids.IcariaStructureSetIds;

import java.util.List;
import java.util.Optional;

import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureSets {
	public static void bootstrap(BootstrapContext<StructureSet> pBootstrapContext) {
		pBootstrapContext.register(IcariaStructureSetIds.PORTAL, new StructureSet(List.of(StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.PORTAL_ICARIA)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.PORTAL_NETHER))), new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F, 1797898789, Optional.of(new StructurePlacement.ExclusionZone(pBootstrapContext.lookup(Registries.STRUCTURE_SET).getOrThrow(IcariaStructureSetIds.VILLAGES), 2)), 6, 4, RandomSpreadType.LINEAR)));
		pBootstrapContext.register(IcariaStructureSetIds.RUIN, new StructureSet(List.of(StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.RUIN))), new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F, 1347443952, Optional.empty(), 4, 2, RandomSpreadType.LINEAR)));
		pBootstrapContext.register(IcariaStructureSetIds.TEMPLE, new StructureSet(List.of(StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.TEMPLE))), new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F, 1821000543, Optional.of(new StructurePlacement.ExclusionZone(pBootstrapContext.lookup(Registries.STRUCTURE_SET).getOrThrow(IcariaStructureSetIds.VILLAGES), 2)), 6, 4, RandomSpreadType.LINEAR)));
		pBootstrapContext.register(IcariaStructureSetIds.VILLAGES, new StructureSet(List.of(StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.ERODED_FOREST_VILLAGE)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.RUINED_FOREST_VILLAGE)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.ERODED_SCRUBLAND_VILLAGE)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.RUINED_SCRUBLAND_VILLAGE)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.ERODED_STEPPE_VILLAGE)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.RUINED_STEPPE_VILLAGE)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.ERODED_DESERT_VILLAGE)), StructureSet.entry(pBootstrapContext.lookup(Registries.STRUCTURE).getOrThrow(IcariaStructureIds.RUINED_DESERT_VILLAGE))), new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F, 1117821874, Optional.empty(), 10, 8, RandomSpreadType.LINEAR)));
	}
}
