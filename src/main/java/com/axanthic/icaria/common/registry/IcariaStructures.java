package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.structure.VillageStructure;
import com.axanthic.icaria.data.tags.IcariaBiomeTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructures {
	public static final ResourceKey<Structure> FOREST_ERODED = IcariaStructures.registerKey("villages/forest/eroded");
	public static final ResourceKey<Structure> FOREST_PRISTINE = IcariaStructures.registerKey("villages/forest/pristine");
	public static final ResourceKey<Structure> FOREST_RUINED = IcariaStructures.registerKey("villages/forest/ruined");

	public static final ResourceKey<Structure> SCRUBLAND_ERODED = IcariaStructures.registerKey("villages/scrubland/eroded");
	public static final ResourceKey<Structure> SCRUBLAND_PRISTINE = IcariaStructures.registerKey("villages/scrubland/pristine");
	public static final ResourceKey<Structure> SCRUBLAND_RUINED = IcariaStructures.registerKey("villages/scrubland/ruined");

	public static final ResourceKey<Structure> STEPPE_ERODED = IcariaStructures.registerKey("villages/steppe/eroded");
	public static final ResourceKey<Structure> STEPPE_PRISTINE = IcariaStructures.registerKey("villages/steppe/pristine");
	public static final ResourceKey<Structure> STEPPE_RUINED = IcariaStructures.registerKey("villages/steppe/ruined");

	public static final ResourceKey<Structure> DESERT_ERODED = IcariaStructures.registerKey("villages/desert/eroded");
	public static final ResourceKey<Structure> DESERT_PRISTINE = IcariaStructures.registerKey("villages/desert/pristine");
	public static final ResourceKey<Structure> DESERT_RUINED = IcariaStructures.registerKey("villages/desert/ruined");

	public static void bootstrap(BootstrapContext<Structure> pContext) {
		var biomes = pContext.lookup(Registries.BIOME);
		var pools = pContext.lookup(Registries.TEMPLATE_POOL);

		pContext.register(IcariaStructures.FOREST_ERODED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.FOREST_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.FOREST_ERODED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.FOREST_PRISTINE, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.FOREST_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.FOREST_PRISTINE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.FOREST_RUINED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.FOREST_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.FOREST_RUINED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pContext.register(IcariaStructures.SCRUBLAND_ERODED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.SCRUBLAND_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.SCRUBLAND_ERODED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.SCRUBLAND_PRISTINE, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.SCRUBLAND_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.SCRUBLAND_PRISTINE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.SCRUBLAND_RUINED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.SCRUBLAND_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.SCRUBLAND_RUINED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pContext.register(IcariaStructures.STEPPE_ERODED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.STEPPE_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.STEPPE_ERODED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.STEPPE_PRISTINE, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.STEPPE_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.STEPPE_PRISTINE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.STEPPE_RUINED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.STEPPE_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.STEPPE_RUINED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pContext.register(IcariaStructures.DESERT_ERODED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.DESERT_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.DESERT_ERODED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.DESERT_PRISTINE, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.DESERT_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.DESERT_PRISTINE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.DESERT_RUINED, new VillageStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.DESERT_PLATEAU), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.DESERT_RUINED_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
	}

	public static ResourceKey<Structure> registerKey(String pName) {
		return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(IcariaInfo.ID, pName));
	}
}
