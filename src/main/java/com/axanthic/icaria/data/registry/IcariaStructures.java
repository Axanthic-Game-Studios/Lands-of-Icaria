package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.world.structure.IcariaJigsawStructure;
import com.axanthic.icaria.data.provider.tags.IcariaBiomeTagsProvider;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructures {
	public static final ResourceKey<Structure> PORTAL_ICARIA = IcariaStructures.createKey("portal/icaria");
	public static final ResourceKey<Structure> PORTAL_NETHER = IcariaStructures.createKey("portal/nether");

	public static final ResourceKey<Structure> RUIN = IcariaStructures.createKey("ruin");

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

	public static void bootstrap(BootstrapContext<Structure> pBootstrapContext) {
		var biomes = pBootstrapContext.lookup(Registries.BIOME);
		var templatePools = pBootstrapContext.lookup(Registries.TEMPLATE_POOL);

		pBootstrapContext.register(IcariaStructures.PORTAL_ICARIA, new IcariaJigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTagsProvider.IS_SURFACE), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.PORTAL_ICARIA), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.PORTAL_NETHER, new IcariaJigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTagsProvider.HAS_PORTAL), Map.of(), GenerationStep.Decoration.UNDERGROUND_DECORATION, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.PORTAL_NETHER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(32)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pBootstrapContext.register(IcariaStructures.RUIN, new IcariaJigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTagsProvider.IS_LOST), Map.of(), GenerationStep.Decoration.UNDERGROUND_DECORATION, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.RUIN_BUILDING), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(40)), ConstantHeight.of(VerticalAnchor.absolute(48)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pBootstrapContext.register(IcariaStructures.TEMPLE, new IcariaJigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(IcariaBiomeTagsProvider.IS_SURFACE), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.TEMPLE_HALL), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pBootstrapContext.register(IcariaStructures.ERODED_FOREST_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.FOREST)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.ERODED_FOREST_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.PRISTINE_FOREST_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.FOREST)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.PRISTINE_FOREST_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.RUINED_FOREST_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.FOREST)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.RUINED_FOREST_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pBootstrapContext.register(IcariaStructures.ERODED_SCRUBLAND_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.SCRUBLAND)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.ERODED_SCRUBLAND_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.SCRUBLAND)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.PRISTINE_SCRUBLAND_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.RUINED_SCRUBLAND_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.SCRUBLAND)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.RUINED_SCRUBLAND_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pBootstrapContext.register(IcariaStructures.ERODED_STEPPE_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.STEPPE)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.ERODED_STEPPE_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.PRISTINE_STEPPE_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.STEPPE)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.PRISTINE_STEPPE_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.RUINED_STEPPE_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.STEPPE)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.RUINED_STEPPE_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));

		pBootstrapContext.register(IcariaStructures.ERODED_DESERT_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.DESERT)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.ERODED_DESERT_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.PRISTINE_DESERT_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.DESERT)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.PRISTINE_DESERT_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
		pBootstrapContext.register(IcariaStructures.RUINED_DESERT_VILLAGE, new IcariaJigsawStructure(new Structure.StructureSettings(HolderSet.direct(biomes.getOrThrow(IcariaBiomes.DESERT)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(IcariaTemplatePools.RUINED_DESERT_VILLAGE_CENTER), Optional.empty(), 16, ConstantHeight.of(VerticalAnchor.absolute(88)), ConstantHeight.of(VerticalAnchor.absolute(96)), false, Optional.empty(), new JigsawStructure.MaxDistance(128), List.of(), DimensionPadding.ZERO, LiquidSettings.APPLY_WATERLOGGING));
	}

	public static ResourceKey<Structure> createKey(String pName) {
		return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
