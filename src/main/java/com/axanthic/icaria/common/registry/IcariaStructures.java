package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.world.structure.IcariaJigsawStructure;
import com.axanthic.icaria.data.tags.IcariaBiomeTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderSet;
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
	public static final ResourceKey<Structure> TEMPLE = IcariaStructures.createKey("temple");

	public static final ResourceKey<Structure> ERODED_FOREST_VILLAGE = IcariaStructures.createKey("villages/forest/eroded");
	public static final ResourceKey<Structure> PRISTINE_FOREST_VILLAGE = IcariaStructures.createKey("villages/forest/pristine");
	public static final ResourceKey<Structure> RUINED_FOREST_VILLAGE = IcariaStructures.createKey("villages/forest/ruined");

	public static final ResourceKey<Structure> ERODED_SCRUBLAND_VILLAGE = IcariaStructures.createKey("villages/scrubland/eroded");
	public static final ResourceKey<Structure> PRISTINE_SCRUBLAND_VILLAGE = IcariaStructures.createKey("villages/scrubland/pristine");
	public static final ResourceKey<Structure> RUINED_SCRUBLAND_VILLAGE = IcariaStructures.createKey("villages/scrubland/ruined");

	public static final ResourceKey<Structure> ERODED_STEPPE_VILLAGE = IcariaStructures.createKey("villages/steppe/eroded");
	public static final ResourceKey<Structure> PRISTINE_STEPPE_VILLAGE = IcariaStructures.createKey("villages/steppe/pristine");
	public static final ResourceKey<Structure> RUINED_STEPPE_VILLAGE = IcariaStructures.createKey("villages/steppe/ruined");

	public static final ResourceKey<Structure> ERODED_DESERT_VILLAGE = IcariaStructures.createKey("villages/desert/eroded");
	public static final ResourceKey<Structure> PRISTINE_DESERT_VILLAGE = IcariaStructures.createKey("villages/desert/pristine");
	public static final ResourceKey<Structure> RUINED_DESERT_VILLAGE = IcariaStructures.createKey("villages/desert/ruined");

	public static void bootstrap(BootstrapContext<Structure> pContext) {
		var biomes = pContext.lookup(Registries.BIOME);
		var pools = pContext.lookup(Registries.TEMPLATE_POOL);

		pContext.register(IcariaStructures.TEMPLE, new IcariaJigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTags.IS_PEAK), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.TEMPLE_HALL), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pContext.register(IcariaStructures.ERODED_FOREST_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.FOREST_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.ERODED_FOREST_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.PRISTINE_FOREST_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.FOREST_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.PRISTINE_FOREST_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.RUINED_FOREST_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.FOREST_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.RUINED_FOREST_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pContext.register(IcariaStructures.ERODED_SCRUBLAND_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.SCRUBLAND_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.ERODED_SCRUBLAND_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.SCRUBLAND_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.PRISTINE_SCRUBLAND_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.RUINED_SCRUBLAND_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.SCRUBLAND_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.RUINED_SCRUBLAND_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pContext.register(IcariaStructures.ERODED_STEPPE_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.STEPPE_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.ERODED_STEPPE_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.PRISTINE_STEPPE_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.STEPPE_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.PRISTINE_STEPPE_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.RUINED_STEPPE_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.STEPPE_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.RUINED_STEPPE_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pContext.register(IcariaStructures.ERODED_DESERT_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.DESERT_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.ERODED_DESERT_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.PRISTINE_DESERT_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.DESERT_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.PRISTINE_DESERT_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pContext.register(IcariaStructures.RUINED_DESERT_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.DESERT_PEAK)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), pools.getOrThrow(IcariaTemplatePools.RUINED_DESERT_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 128, List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
	}

	public static ResourceKey<Structure> createKey(String pName) {
		return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
