package com.axanthic.icaria.common.events;

import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.data.IcariaRecipeRunner;
import com.axanthic.icaria.data.provider.*;
import com.axanthic.icaria.data.provider.advancement.IcariaAdvancementProvider;
import com.axanthic.icaria.data.provider.language.IcariaEnglishLanguageProvider;
import com.axanthic.icaria.data.provider.language.IcariaGermanLanguageProvider;
import com.axanthic.icaria.data.provider.loot.IcariaLootTableProvider;
import com.axanthic.icaria.data.provider.model.IcariaModelProvider;
import com.axanthic.icaria.data.provider.tags.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(modid = IcariaIdents.ID)
public class IcariaCommonModEvents {

	@SubscribeEvent
	public static void onBlockEntityTypeAddBlocks(BlockEntityTypeAddBlocksEvent pEvent) {
		pEvent.modify(BlockEntityType.BRUSHABLE_BLOCK, IcariaBlocks.SUSPICIOUS_GRAINEL.get(), IcariaBlocks.SUSPICIOUS_SILKSAND.get());
		pEvent.modify(BlockEntityType.HANGING_SIGN, IcariaBlocks.CYPRESS_HANGING_SIGN.get(), IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), IcariaBlocks.FIR_HANGING_SIGN.get(), IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), IcariaBlocks.LAUREL_HANGING_SIGN.get(), IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), IcariaBlocks.OLIVE_HANGING_SIGN.get(), IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), IcariaBlocks.PLANE_HANGING_SIGN.get(), IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), IcariaBlocks.POPULUS_HANGING_SIGN.get(), IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get());
		pEvent.modify(BlockEntityType.SKULL, IcariaBlocks.AETERNAE_SKULL.get(), IcariaBlocks.AETERNAE_WALL_SKULL.get(), IcariaBlocks.ARGAN_HOUND_SKULL.get(), IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), IcariaBlocks.CAPELLA_SKULL.get(), IcariaBlocks.CAPELLA_WALL_SKULL.get(), IcariaBlocks.CATOBLEPAS_SKULL.get(), IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), IcariaBlocks.CERVER_SKULL.get(), IcariaBlocks.CERVER_WALL_SKULL.get(), IcariaBlocks.CROCOTTA_SKULL.get(), IcariaBlocks.CROCOTTA_WALL_SKULL.get(), IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get(), IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get(), IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.FIR_FOREST_HAG_SKULL.get(), IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get(), IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get(), IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.PLANE_FOREST_HAG_SKULL.get(), IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get(), IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.REVENANT_SKULL.get(), IcariaBlocks.REVENANT_WALL_SKULL.get(), IcariaBlocks.THOG_SKULL.get(), IcariaBlocks.THOG_WALL_SKULL.get());
	}

	@SubscribeEvent
	public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent pEvent) {
		IcariaCommonModEvents.blocks(pEvent);
		IcariaCommonModEvents.flora(pEvent);
		IcariaCommonModEvents.items(pEvent);
	}

	@SubscribeEvent
	public static void onEntityAttributeCreation(EntityAttributeCreationEvent pEvent) {
		pEvent.put(IcariaEntityTypes.AETERNAE.get(), AeternaeEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ARACHNE.get(), ArachneEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ARACHNE_DRONE.get(), ArachneDroneEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ARGAN_HOUND.get(), ArganHoundEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CAPELLA.get(), CapellaEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CATOBLEPAS.get(), CatoblepasEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CERVER.get(), CerverEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CROCOTTA.get(), CrocottaEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), ForestHagEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), ForestHagEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.FIR_FOREST_HAG.get(), ForestHagEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), ForestHagEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), ForestHagEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.PLANE_FOREST_HAG.get(), ForestHagEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), ForestHagEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.HYLIASTER.get(), HyliasterEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ENDER_JELLYFISH.get(), EnderJellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.FIRE_JELLYFISH.get(), FireJellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.NATURE_JELLYFISH.get(), NatureJellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.VOID_JELLYFISH.get(), VoidJellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.WATER_JELLYFISH.get(), WaterJellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.MYRMEKE_DRONE.get(), MyrmekeDroneEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), MyrmekeSoldierEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.MYRMEKE_QUEEN.get(), MyrmekeQueenEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CAPTAIN_REVENANT.get(), CaptainRevenantEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CIVILIAN_REVENANT.get(), CivilianRevenantEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CRAWLER_REVENANT.get(), CrawlerRevenantEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.OVERGROWN_REVENANT.get(), OvergrownRevenantEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.PYROMANCER_REVENANT.get(), PyromancerRevenantEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), NetherPyromancerRevenantEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.SOLDIER_REVENANT.get(), SoldierRevenantEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.SCORPION.get(), ScorpionEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CRYSTAL_SLUG.get(), SlugEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.FOREST_SNULL.get(), SnullEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.SNULL.get(), SnullEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.SOLIFUGAE.get(), SolifugaeEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.THOG.get(), ThogEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.VINEGAROON.get(), VinegaroonEntity.registerAttributes().build());
	}

	@SubscribeEvent
	public static void onGatherData(GatherDataEvent.Client pEvent) {
		var generator = pEvent.getGenerator();
		var lookupProvider = pEvent.getLookupProvider();

		var packOutput = generator.getPackOutput();

		var builtinEntries = new IcariaDatapackBuiltinEntriesProvider(packOutput, lookupProvider, IcariaIdents.ID);

		var registryProvider = builtinEntries.getRegistryProvider();

		generator.addProvider(true, new IcariaAdvancementProvider(packOutput, lookupProvider));
		generator.addProvider(true, new IcariaEnglishLanguageProvider(packOutput, IcariaIdents.ID, "en_us"));
		generator.addProvider(true, new IcariaGermanLanguageProvider(packOutput, IcariaIdents.ID, "de_de"));
		generator.addProvider(true, new IcariaLootTableProvider(packOutput, lookupProvider));
		generator.addProvider(true, new IcariaModelProvider(packOutput, IcariaIdents.ID));
		generator.addProvider(true, new IcariaBiomeTagsProvider(packOutput, registryProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaBlockTagsProvider(packOutput, lookupProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaEntityTypeTagsProvider(packOutput, lookupProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaFluidTagsProvider(packOutput, lookupProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaInstrumentTagsProvider(packOutput, registryProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaItemTagsProvider(packOutput, lookupProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaPaintingVariantTagsProvider(packOutput, registryProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaStructureTagsProvider(packOutput, registryProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaDataMapProvider(packOutput, lookupProvider));
		generator.addProvider(true, builtinEntries);
		generator.addProvider(true, new IcariaEquipmentAssetProvider(packOutput));
		generator.addProvider(true, new IcariaParticleDescriptionProvider(packOutput));
		generator.addProvider(true, new IcariaRecipePrioritiesProvider(packOutput, lookupProvider, IcariaIdents.ID));
		generator.addProvider(true, new IcariaSoundDefinitionsProvider(packOutput, IcariaIdents.ID));
		generator.addProvider(true, new IcariaRecipeRunner(packOutput, lookupProvider));
	}

	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent pEvent) {
		pEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IcariaBlockEntityTypes.FORGE.get(), ForgeBlockEntity::getCapability);
		pEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IcariaBlockEntityTypes.FORGE_REDIRECTOR.get(), ForgeRedirectorBlockEntity::getCapability);
		pEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockEntity::getCapability);
		pEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IcariaBlockEntityTypes.GRINDER_REDIRECTOR.get(), GrinderRedirectorBlockEntity::getCapability);
		pEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IcariaBlockEntityTypes.KETTLE.get(), KettleBlockEntity::getCapability);
		pEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IcariaBlockEntityTypes.KILN.get(), KilnBlockEntity::getCapability);
		pEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IcariaBlockEntityTypes.KILN_REDIRECTOR.get(), KilnRedirectorBlockEntity::getCapability);
	}

	@SubscribeEvent
	public static void onRegisterSpawnPlacements(RegisterSpawnPlacementsEvent pEvent) {
		pEvent.register(IcariaEntityTypes.AETERNAE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AeternaeEntity::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ARACHNE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArachneEntity::checkAnyLightArachnidSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ARACHNE_DRONE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArachneDroneEntity::checkAnyLightArachnidSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ARGAN_HOUND.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArganHoundEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CAPELLA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CapellaEntity::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CATOBLEPAS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CatoblepasEntity::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CERVER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CerverEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CROCOTTA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrocottaEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.FIR_FOREST_HAG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.PLANE_FOREST_HAG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.HYLIASTER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HyliasterEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ENDER_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EnderJellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.FIRE_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FireJellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.NATURE_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NatureJellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.VOID_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, VoidJellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.WATER_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterJellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.MYRMEKE_DRONE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MyrmekeDroneEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MyrmekeSoldierEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.MYRMEKE_QUEEN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MyrmekeQueenEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CAPTAIN_REVENANT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CaptainRevenantEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CIVILIAN_REVENANT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CivilianRevenantEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CRAWLER_REVENANT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrawlerRevenantEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.OVERGROWN_REVENANT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OvergrownRevenantEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.PYROMANCER_REVENANT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PyromancerRevenantEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NetherPyromancerRevenantEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SOLDIER_REVENANT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SoldierRevenantEntity::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SCORPION.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ScorpionEntity::checkAnyLightArachnidSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CRYSTAL_SLUG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SlugEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.FOREST_SNULL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnullEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SNULL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnullEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SOLIFUGAE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SolifugaeEntity::checkAnyLightArachnidSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.THOG.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ThogEntity::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.VINEGAROON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, VinegaroonEntity::checkAnyLightArachnidSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static void blocks(BuildCreativeModeTabContentsEvent pEvent) {
		if (pEvent.getTab() == IcariaCreativeModeTabs.BLOCKS.get()) {
			pEvent.accept(IcariaItems.GRASSY_MARL.get());
			pEvent.accept(IcariaItems.MARL.get());
			pEvent.accept(IcariaItems.MARL_CHERT.get());
			pEvent.accept(IcariaItems.SURFACE_CHERT.get());
			pEvent.accept(IcariaItems.MARL_BONES.get());
			pEvent.accept(IcariaItems.SURFACE_BONES.get());
			pEvent.accept(IcariaItems.MARL_LIGNITE.get());
			pEvent.accept(IcariaItems.SURFACE_LIGNITE.get());
			pEvent.accept(IcariaItems.COARSE_MARL.get());
			pEvent.accept(IcariaItems.DRY_LAKE_BED.get());
			pEvent.accept(IcariaItems.FARMLAND.get());
			pEvent.accept(IcariaItems.FERTILIZED_FARMLAND.get());
			pEvent.accept(IcariaItems.MARL_PATH.get());

			pEvent.accept(IcariaItems.MARL_ADOBE.get());
			pEvent.accept(IcariaItems.MARL_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.MARL_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.MARL_ADOBE_WALL.get());

			pEvent.accept(IcariaItems.LOAM.get());
			pEvent.accept(IcariaItems.LOAM_PATH.get());
			pEvent.accept(IcariaItems.LOAM_BRICKS.get());
			pEvent.accept(IcariaItems.LOAM_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.LOAM_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.LOAM_BRICK_WALL.get());

			pEvent.accept(IcariaItems.DOLOMITE_ADOBE.get());
			pEvent.accept(IcariaItems.DOLOMITE_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.DOLOMITE_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.DOLOMITE_ADOBE_WALL.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE_STAIRS.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE_SLAB.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE_WALL.get());
			pEvent.accept(IcariaItems.DOLOMITE_BRICKS.get());
			pEvent.accept(IcariaItems.CHISELED_DOLOMITE.get());
			pEvent.accept(IcariaItems.DOLOMITE_PILLAR.get());
			pEvent.accept(IcariaItems.DOLOMITE_PILLAR_HEAD.get());

			pEvent.accept(IcariaItems.GRAINEL.get());
			pEvent.accept(IcariaItems.SUSPICIOUS_GRAINEL.get());
			pEvent.accept(IcariaItems.GRAINEL_CHERT.get());
			pEvent.accept(IcariaItems.GRAINEL_PATH.get());
			pEvent.accept(IcariaItems.GRAINGLASS.get());
			pEvent.accept(IcariaItems.GRAINGLASS_PANE.get());
			pEvent.accept(IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE_WALL.get());
			pEvent.accept(IcariaItems.GRAINITE.get());
			pEvent.accept(IcariaItems.GRAINITE_STAIRS.get());
			pEvent.accept(IcariaItems.GRAINITE_SLAB.get());
			pEvent.accept(IcariaItems.GRAINITE_WALL.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICKS.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.CHISELED_GRAINITE.get());
			pEvent.accept(IcariaItems.GRAINITE_RUBBLE.get());

			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE_WALL.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE_SLAB.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE_WALL.get());
			pEvent.accept(IcariaItems.YELLOWSTONE.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_SLAB.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_WALL.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.CHISELED_YELLOWSTONE.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.SILKSAND.get());
			pEvent.accept(IcariaItems.SUSPICIOUS_SILKSAND.get());
			pEvent.accept(IcariaItems.SILKSAND_PATH.get());
			pEvent.accept(IcariaItems.SILKGLASS.get());
			pEvent.accept(IcariaItems.SILKGLASS_PANE.get());
			pEvent.accept(IcariaItems.HORIZONTAL_SILKGLASS_PANE.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE_WALL.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE_SLAB.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE_WALL.get());
			pEvent.accept(IcariaItems.SILKSTONE.get());
			pEvent.accept(IcariaItems.SILKSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.SILKSTONE_SLAB.get());
			pEvent.accept(IcariaItems.SILKSTONE_WALL.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.CHISELED_SILKSTONE.get());
			pEvent.accept(IcariaItems.SILKSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.SUNSTONE_ADOBE.get());
			pEvent.accept(IcariaItems.SUNSTONE_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.SUNSTONE_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.SUNSTONE_ADOBE_WALL.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE_SLAB.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE_WALL.get());
			pEvent.accept(IcariaItems.SUNSTONE.get());
			pEvent.accept(IcariaItems.SUNSTONE_SLAB.get());
			pEvent.accept(IcariaItems.SUNSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.SUNSTONE_WALL.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.CHISELED_SUNSTONE.get());
			pEvent.accept(IcariaItems.SUNSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE.get());
			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE_WALL.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE_STAIRS.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE_SLAB.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE_WALL.get());
			pEvent.accept(IcariaItems.VOIDSHALE.get());
			pEvent.accept(IcariaItems.VOIDSHALE_STAIRS.get());
			pEvent.accept(IcariaItems.VOIDSHALE_SLAB.get());
			pEvent.accept(IcariaItems.VOIDSHALE_WALL.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICKS.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.CHISELED_VOIDSHALE.get());
			pEvent.accept(IcariaItems.VOIDSHALE_RUBBLE.get());

			pEvent.accept(IcariaItems.BAETYL_ADOBE.get());
			pEvent.accept(IcariaItems.BAETYL_ADOBE_STAIRS.get());
			pEvent.accept(IcariaItems.BAETYL_ADOBE_SLAB.get());
			pEvent.accept(IcariaItems.BAETYL_ADOBE_WALL.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL_STAIRS.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL_SLAB.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL_WALL.get());
			pEvent.accept(IcariaItems.BAETYL.get());
			pEvent.accept(IcariaItems.BAETYL_STAIRS.get());
			pEvent.accept(IcariaItems.BAETYL_SLAB.get());
			pEvent.accept(IcariaItems.BAETYL_WALL.get());
			pEvent.accept(IcariaItems.BAETYL_BRICKS.get());
			pEvent.accept(IcariaItems.BAETYL_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.BAETYL_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.BAETYL_BRICK_WALL.get());
			pEvent.accept(IcariaItems.CHISELED_BAETYL.get());
			pEvent.accept(IcariaItems.BAETYL_RUBBLE.get());

			pEvent.accept(IcariaItems.RELICSTONE.get());
			pEvent.accept(IcariaItems.RELICSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.RELICSTONE_SLAB.get());
			pEvent.accept(IcariaItems.RELICSTONE_WALL.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE_STAIRS.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE_SLAB.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE_WALL.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILES.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILE_STAIRS.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILE_SLAB.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILE_WALL.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILES.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILE_STAIRS.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILE_SLAB.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILE_WALL.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILES.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILE_STAIRS.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILE_SLAB.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILE_WALL.get());
			pEvent.accept(IcariaItems.CHISELED_RELICSTONE.get());
			pEvent.accept(IcariaItems.RELICSTONE_PILLAR.get());
			pEvent.accept(IcariaItems.RELICSTONE_PILLAR_HEAD.get());
			pEvent.accept(IcariaItems.RELICSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.PLATOSHALE.get());
			pEvent.accept(IcariaItems.PLATOSHALE_STAIRS.get());
			pEvent.accept(IcariaItems.PLATOSHALE_SLAB.get());
			pEvent.accept(IcariaItems.PLATOSHALE_WALL.get());
			pEvent.accept(IcariaItems.BLURRED_PLATOSHALE.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICKS.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICK_STAIRS.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICK_SLAB.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICK_WALL.get());
			pEvent.accept(IcariaItems.BLURRED_PLATOSHALE_BRICKS.get());
			pEvent.accept(IcariaItems.CHISELED_PLATOSHALE.get());

			pEvent.accept(IcariaItems.QUARTZ_WALL.get());
			pEvent.accept(IcariaItems.QUARTZ_PILLAR_HEAD.get());

			pEvent.accept(IcariaItems.LIGNITE_ORE.get());
			pEvent.accept(IcariaItems.CHALKOS_ORE.get());
			pEvent.accept(IcariaItems.KASSITEROS_ORE.get());
			pEvent.accept(IcariaItems.DOLOMITE_ORE.get());
			pEvent.accept(IcariaItems.VANADIUM_ORE.get());
			pEvent.accept(IcariaItems.SLIVER_ORE.get());
			pEvent.accept(IcariaItems.SIDEROS_ORE.get());
			pEvent.accept(IcariaItems.ANTHRACITE_ORE.get());
			pEvent.accept(IcariaItems.MOLYBDENUM_ORE.get());
			pEvent.accept(IcariaItems.HYLIASTRUM_ORE.get());

			pEvent.accept(IcariaItems.CALCITE.get());
			pEvent.accept(IcariaItems.BUDDING_CALCITE.get());
			pEvent.accept(IcariaItems.HALITE.get());
			pEvent.accept(IcariaItems.BUDDING_HALITE.get());
			pEvent.accept(IcariaItems.JASPER.get());
			pEvent.accept(IcariaItems.BUDDING_JASPER.get());
			pEvent.accept(IcariaItems.ZIRCON.get());
			pEvent.accept(IcariaItems.BUDDING_ZIRCON.get());

			pEvent.accept(IcariaItems.CALCITE_CRYSTAL.get());
			pEvent.accept(IcariaItems.HALITE_CRYSTAL.get());
			pEvent.accept(IcariaItems.JASPER_CRYSTAL.get());
			pEvent.accept(IcariaItems.ZIRCON_CRYSTAL.get());

			pEvent.accept(IcariaItems.ARISTONE.get());
			pEvent.accept(IcariaItems.PACKED_ARISTONE.get());

			pEvent.accept(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());
			pEvent.accept(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());
			pEvent.accept(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());
			pEvent.accept(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());
			pEvent.accept(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());

			pEvent.accept(IcariaItems.ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.WHITE_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.GRAY_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.BLACK_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.BROWN_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.RED_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.ORANGE_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.YELLOW_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.LIME_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.GREEN_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.CYAN_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.BLUE_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.PURPLE_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.MAGENTA_ARACHNE_STRING_BLOCK.get());
			pEvent.accept(IcariaItems.PINK_ARACHNE_STRING_BLOCK.get());

			pEvent.accept(IcariaItems.ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.WHITE_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.GRAY_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.BLACK_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.BROWN_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.RED_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.LIME_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.GREEN_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.CYAN_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.BLUE_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get());
			pEvent.accept(IcariaItems.PINK_ARACHNE_STRING_CARPET.get());

			pEvent.accept(IcariaItems.SPELT_BALE_BLOCK.get());
			pEvent.accept(IcariaItems.VINE_REED_BLOCK.get());
			pEvent.accept(IcariaItems.ROTTEN_BONES_BLOCK.get());

			pEvent.accept(IcariaItems.RAW_CHALKOS_BLOCK.get());
			pEvent.accept(IcariaItems.RAW_KASSITEROS_BLOCK.get());
			pEvent.accept(IcariaItems.RAW_VANADIUM_BLOCK.get());
			pEvent.accept(IcariaItems.RAW_SIDEROS_BLOCK.get());
			pEvent.accept(IcariaItems.RAW_MOLYBDENUM_BLOCK.get());

			pEvent.accept(IcariaItems.CALCITE_BLOCK.get());
			pEvent.accept(IcariaItems.HALITE_BLOCK.get());
			pEvent.accept(IcariaItems.JASPER_BLOCK.get());
			pEvent.accept(IcariaItems.ZIRCON_BLOCK.get());
			pEvent.accept(IcariaItems.CHERT_BLOCK.get());
			pEvent.accept(IcariaItems.LIGNITE_BLOCK.get());
			pEvent.accept(IcariaItems.CHALKOS_BLOCK.get());
			pEvent.accept(IcariaItems.KASSITEROS_BLOCK.get());
			pEvent.accept(IcariaItems.ORICHALCUM_BLOCK.get());
			pEvent.accept(IcariaItems.VANADIUM_BLOCK.get());
			pEvent.accept(IcariaItems.SLIVER_BLOCK.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_BLOCK.get());
			pEvent.accept(IcariaItems.SIDEROS_BLOCK.get());
			pEvent.accept(IcariaItems.ANTHRACITE_BLOCK.get());
			pEvent.accept(IcariaItems.MOLYBDENUM_BLOCK.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());
			pEvent.accept(IcariaItems.BLURIDIUM_BLOCK.get());

			pEvent.accept(IcariaItems.VANADIUMSTEEL_BARS.get());
			pEvent.accept(IcariaItems.HORIZONTAL_VANADIUMSTEEL_BARS.get());

			pEvent.accept(IcariaItems.VANADIUMSTEEL_CHAIN.get());

			pEvent.accept(IcariaItems.KETTLE.get());
			pEvent.accept(IcariaItems.GRINDER.get());
			pEvent.accept(IcariaItems.KILN.get());
			pEvent.accept(IcariaItems.FORGE.get());

			pEvent.accept(IcariaItems.CHEST.get());
			pEvent.accept(IcariaItems.TRAPPED_CHEST.get());

			pEvent.accept(IcariaItems.STORAGE_VASE.get());
			pEvent.accept(IcariaItems.WHITE_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.LIGHT_GRAY_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.GRAY_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.BLACK_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.BROWN_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.RED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.ORANGE_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.YELLOW_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.LIME_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.GREEN_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.CYAN_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.LIGHT_BLUE_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.BLUE_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.PURPLE_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.MAGENTA_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.PINK_STORAGE_VASE.get());

			pEvent.accept(IcariaItems.RED_LOOT_VASE.get());
			pEvent.accept(IcariaItems.LOST_LOOT_VASE.get());
			pEvent.accept(IcariaItems.CYAN_LOOT_VASE.get());

			pEvent.accept(IcariaItems.ARACHNE_SPAWNER.get());
			pEvent.accept(IcariaItems.REVENANT_SPAWNER.get());

			pEvent.accept(IcariaItems.AETERNAE_SKULL.get());
			pEvent.accept(IcariaItems.ARGAN_HOUND_SKULL.get());
			pEvent.accept(IcariaItems.CAPELLA_SKULL.get());
			pEvent.accept(IcariaItems.CATOBLEPAS_SKULL.get());
			pEvent.accept(IcariaItems.CERVER_SKULL.get());
			pEvent.accept(IcariaItems.CROCOTTA_SKULL.get());
			pEvent.accept(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.FIR_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.OLIVE_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.PLANE_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.POPULUS_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.REVENANT_SKULL.get());
			pEvent.accept(IcariaItems.THOG_SKULL.get());

			pEvent.accept(IcariaItems.LIGNITE_TORCH.get());
			pEvent.accept(IcariaItems.ANTHRACITE_TORCH.get());

			pEvent.accept(IcariaItems.LAUREL_CHERRY_CAKE.get());
			pEvent.accept(IcariaItems.STRAWBERRY_CAKE.get());
			pEvent.accept(IcariaItems.PHYSALIS_CAKE.get());
			pEvent.accept(IcariaItems.VINE_BERRY_CAKE.get());
			pEvent.accept(IcariaItems.VINE_SPROUT_CAKE.get());
		}
	}

	public static void flora(BuildCreativeModeTabContentsEvent pEvent) {
		if (pEvent.getTab() == IcariaCreativeModeTabs.FLORA.get()) {
			pEvent.accept(IcariaItems.CYPRESS_SAPLING.get());
			pEvent.accept(IcariaItems.CYPRESS_LEAVES.get());
			pEvent.accept(IcariaItems.FALLEN_CYPRESS_LEAVES.get());
			pEvent.accept(IcariaItems.CYPRESS_TWIGS.get());
			pEvent.accept(IcariaItems.CYPRESS_WOOD.get());
			pEvent.accept(IcariaItems.STRIPPED_CYPRESS_WOOD.get());
			pEvent.accept(IcariaItems.CYPRESS_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_CYPRESS_LOG.get());
			pEvent.accept(IcariaItems.DEAD_CYPRESS_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get());
			pEvent.accept(IcariaItems.CYPRESS_PLANKS.get());
			pEvent.accept(IcariaItems.CYPRESS_STAIRS.get());
			pEvent.accept(IcariaItems.CYPRESS_SLAB.get());
			pEvent.accept(IcariaItems.CYPRESS_FENCE.get());
			pEvent.accept(IcariaItems.CYPRESS_FENCE_GATE.get());
			pEvent.accept(IcariaItems.SIMPLE_CYPRESS_RACK.get());
			pEvent.accept(IcariaItems.CYPRESS_RACK.get());
			pEvent.accept(IcariaItems.CYPRESS_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_CYPRESS_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_CYPRESS_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_CYPRESS_BARREL_RACK.get());
			pEvent.accept(IcariaItems.CYPRESS_TROUGH.get());
			pEvent.accept(IcariaItems.CYPRESS_STOOL.get());
			pEvent.accept(IcariaItems.CYPRESS_PAN_HOLDER.get());
			pEvent.accept(IcariaItems.CYPRESS_SPOON_HOLDER.get());
			pEvent.accept(IcariaItems.CYPRESS_TOWEL_HOLDER.get());
			pEvent.accept(IcariaItems.CYPRESS_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.CYPRESS_SCROLLSHELF.get());
			pEvent.accept(IcariaItems.CYPRESS_DOOR.get());
			pEvent.accept(IcariaItems.CYPRESS_TRAPDOOR.get());
			pEvent.accept(IcariaItems.CYPRESS_PRESSURE_PLATE.get());
			pEvent.accept(IcariaItems.CYPRESS_BUTTON.get());
			pEvent.accept(IcariaItems.CYPRESS_LADDER.get());
			pEvent.accept(IcariaItems.CYPRESS_SIGN.get());
			pEvent.accept(IcariaItems.CYPRESS_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.DROUGHTROOT_SAPLING.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_LEAVES.get());
			pEvent.accept(IcariaItems.FALLEN_DROUGHTROOT_LEAVES.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_TWIGS.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_WOOD.get());
			pEvent.accept(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
			pEvent.accept(IcariaItems.DEAD_DROUGHTROOT_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_PLANKS.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_STAIRS.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_SLAB.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_FENCE.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_FENCE_GATE.get());
			pEvent.accept(IcariaItems.SIMPLE_DROUGHTROOT_RACK.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_RACK.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_DROUGHTROOT_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_DROUGHTROOT_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_DROUGHTROOT_BARREL_RACK.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_TROUGH.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_STOOL.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_PAN_HOLDER.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_SPOON_HOLDER.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_TOWEL_HOLDER.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_SCROLLSHELF.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_DOOR.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_TRAPDOOR.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_PRESSURE_PLATE.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_BUTTON.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_LADDER.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_SIGN.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.FIR_SAPLING.get());
			pEvent.accept(IcariaItems.FIR_LEAVES.get());
			pEvent.accept(IcariaItems.FALLEN_FIR_LEAVES.get());
			pEvent.accept(IcariaItems.FIR_TWIGS.get());
			pEvent.accept(IcariaItems.FIR_WOOD.get());
			pEvent.accept(IcariaItems.STRIPPED_FIR_WOOD.get());
			pEvent.accept(IcariaItems.FIR_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_FIR_LOG.get());
			pEvent.accept(IcariaItems.DEAD_FIR_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DEAD_FIR_LOG.get());
			pEvent.accept(IcariaItems.FIR_PLANKS.get());
			pEvent.accept(IcariaItems.FIR_STAIRS.get());
			pEvent.accept(IcariaItems.FIR_SLAB.get());
			pEvent.accept(IcariaItems.FIR_FENCE.get());
			pEvent.accept(IcariaItems.FIR_FENCE_GATE.get());
			pEvent.accept(IcariaItems.SIMPLE_FIR_RACK.get());
			pEvent.accept(IcariaItems.FIR_RACK.get());
			pEvent.accept(IcariaItems.FIR_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_FIR_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_FIR_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_FIR_BARREL_RACK.get());
			pEvent.accept(IcariaItems.FIR_TROUGH.get());
			pEvent.accept(IcariaItems.FIR_STOOL.get());
			pEvent.accept(IcariaItems.FIR_PAN_HOLDER.get());
			pEvent.accept(IcariaItems.FIR_SPOON_HOLDER.get());
			pEvent.accept(IcariaItems.FIR_TOWEL_HOLDER.get());
			pEvent.accept(IcariaItems.FIR_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.FIR_SCROLLSHELF.get());
			pEvent.accept(IcariaItems.FIR_DOOR.get());
			pEvent.accept(IcariaItems.FIR_TRAPDOOR.get());
			pEvent.accept(IcariaItems.FIR_PRESSURE_PLATE.get());
			pEvent.accept(IcariaItems.FIR_BUTTON.get());
			pEvent.accept(IcariaItems.FIR_LADDER.get());
			pEvent.accept(IcariaItems.FIR_SIGN.get());
			pEvent.accept(IcariaItems.FIR_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.LAUREL_SAPLING.get());
			pEvent.accept(IcariaItems.LAUREL_LEAVES.get());
			pEvent.accept(IcariaItems.FALLEN_LAUREL_LEAVES.get());
			pEvent.accept(IcariaItems.LAUREL_TWIGS.get());
			pEvent.accept(IcariaItems.LAUREL_WOOD.get());
			pEvent.accept(IcariaItems.STRIPPED_LAUREL_WOOD.get());
			pEvent.accept(IcariaItems.LAUREL_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_LAUREL_LOG.get());
			pEvent.accept(IcariaItems.DEAD_LAUREL_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get());
			pEvent.accept(IcariaItems.LAUREL_PLANKS.get());
			pEvent.accept(IcariaItems.LAUREL_STAIRS.get());
			pEvent.accept(IcariaItems.LAUREL_SLAB.get());
			pEvent.accept(IcariaItems.LAUREL_FENCE.get());
			pEvent.accept(IcariaItems.LAUREL_FENCE_GATE.get());
			pEvent.accept(IcariaItems.SIMPLE_LAUREL_RACK.get());
			pEvent.accept(IcariaItems.LAUREL_RACK.get());
			pEvent.accept(IcariaItems.LAUREL_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_LAUREL_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_LAUREL_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_LAUREL_BARREL_RACK.get());
			pEvent.accept(IcariaItems.LAUREL_TROUGH.get());
			pEvent.accept(IcariaItems.LAUREL_STOOL.get());
			pEvent.accept(IcariaItems.LAUREL_PAN_HOLDER.get());
			pEvent.accept(IcariaItems.LAUREL_SPOON_HOLDER.get());
			pEvent.accept(IcariaItems.LAUREL_TOWEL_HOLDER.get());
			pEvent.accept(IcariaItems.LAUREL_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.LAUREL_SCROLLSHELF.get());
			pEvent.accept(IcariaItems.LAUREL_DOOR.get());
			pEvent.accept(IcariaItems.LAUREL_TRAPDOOR.get());
			pEvent.accept(IcariaItems.LAUREL_PRESSURE_PLATE.get());
			pEvent.accept(IcariaItems.LAUREL_BUTTON.get());
			pEvent.accept(IcariaItems.LAUREL_LADDER.get());
			pEvent.accept(IcariaItems.LAUREL_SIGN.get());
			pEvent.accept(IcariaItems.LAUREL_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.OLIVE_SAPLING.get());
			pEvent.accept(IcariaItems.OLIVE_LEAVES.get());
			pEvent.accept(IcariaItems.FALLEN_OLIVE_LEAVES.get());
			pEvent.accept(IcariaItems.OLIVE_TWIGS.get());
			pEvent.accept(IcariaItems.OLIVE_WOOD.get());
			pEvent.accept(IcariaItems.STRIPPED_OLIVE_WOOD.get());
			pEvent.accept(IcariaItems.OLIVE_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_OLIVE_LOG.get());
			pEvent.accept(IcariaItems.DEAD_OLIVE_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get());
			pEvent.accept(IcariaItems.OLIVE_PLANKS.get());
			pEvent.accept(IcariaItems.OLIVE_STAIRS.get());
			pEvent.accept(IcariaItems.OLIVE_SLAB.get());
			pEvent.accept(IcariaItems.OLIVE_FENCE.get());
			pEvent.accept(IcariaItems.OLIVE_FENCE_GATE.get());
			pEvent.accept(IcariaItems.SIMPLE_OLIVE_RACK.get());
			pEvent.accept(IcariaItems.OLIVE_RACK.get());
			pEvent.accept(IcariaItems.OLIVE_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_OLIVE_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_OLIVE_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_OLIVE_BARREL_RACK.get());
			pEvent.accept(IcariaItems.OLIVE_TROUGH.get());
			pEvent.accept(IcariaItems.OLIVE_STOOL.get());
			pEvent.accept(IcariaItems.OLIVE_PAN_HOLDER.get());
			pEvent.accept(IcariaItems.OLIVE_SPOON_HOLDER.get());
			pEvent.accept(IcariaItems.OLIVE_TOWEL_HOLDER.get());
			pEvent.accept(IcariaItems.OLIVE_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.OLIVE_SCROLLSHELF.get());
			pEvent.accept(IcariaItems.OLIVE_DOOR.get());
			pEvent.accept(IcariaItems.OLIVE_TRAPDOOR.get());
			pEvent.accept(IcariaItems.OLIVE_PRESSURE_PLATE.get());
			pEvent.accept(IcariaItems.OLIVE_BUTTON.get());
			pEvent.accept(IcariaItems.OLIVE_LADDER.get());
			pEvent.accept(IcariaItems.OLIVE_SIGN.get());
			pEvent.accept(IcariaItems.OLIVE_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.PLANE_SAPLING.get());
			pEvent.accept(IcariaItems.PLANE_LEAVES.get());
			pEvent.accept(IcariaItems.FALLEN_PLANE_LEAVES.get());
			pEvent.accept(IcariaItems.PLANE_TWIGS.get());
			pEvent.accept(IcariaItems.PLANE_WOOD.get());
			pEvent.accept(IcariaItems.STRIPPED_PLANE_WOOD.get());
			pEvent.accept(IcariaItems.PLANE_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_PLANE_LOG.get());
			pEvent.accept(IcariaItems.DEAD_PLANE_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DEAD_PLANE_LOG.get());
			pEvent.accept(IcariaItems.PLANE_PLANKS.get());
			pEvent.accept(IcariaItems.PLANE_STAIRS.get());
			pEvent.accept(IcariaItems.PLANE_SLAB.get());
			pEvent.accept(IcariaItems.PLANE_FENCE.get());
			pEvent.accept(IcariaItems.PLANE_FENCE_GATE.get());
			pEvent.accept(IcariaItems.SIMPLE_PLANE_RACK.get());
			pEvent.accept(IcariaItems.PLANE_RACK.get());
			pEvent.accept(IcariaItems.PLANE_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_PLANE_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_PLANE_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_PLANE_BARREL_RACK.get());
			pEvent.accept(IcariaItems.PLANE_TROUGH.get());
			pEvent.accept(IcariaItems.PLANE_STOOL.get());
			pEvent.accept(IcariaItems.PLANE_PAN_HOLDER.get());
			pEvent.accept(IcariaItems.PLANE_SPOON_HOLDER.get());
			pEvent.accept(IcariaItems.PLANE_TOWEL_HOLDER.get());
			pEvent.accept(IcariaItems.PLANE_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.PLANE_SCROLLSHELF.get());
			pEvent.accept(IcariaItems.PLANE_DOOR.get());
			pEvent.accept(IcariaItems.PLANE_TRAPDOOR.get());
			pEvent.accept(IcariaItems.PLANE_PRESSURE_PLATE.get());
			pEvent.accept(IcariaItems.PLANE_BUTTON.get());
			pEvent.accept(IcariaItems.PLANE_LADDER.get());
			pEvent.accept(IcariaItems.PLANE_SIGN.get());
			pEvent.accept(IcariaItems.PLANE_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.POPULUS_SAPLING.get());
			pEvent.accept(IcariaItems.POPULUS_LEAVES.get());
			pEvent.accept(IcariaItems.FALLEN_POPULUS_LEAVES.get());
			pEvent.accept(IcariaItems.POPULUS_TWIGS.get());
			pEvent.accept(IcariaItems.POPULUS_WOOD.get());
			pEvent.accept(IcariaItems.STRIPPED_POPULUS_WOOD.get());
			pEvent.accept(IcariaItems.POPULUS_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_POPULUS_LOG.get());
			pEvent.accept(IcariaItems.DEAD_POPULUS_LOG.get());
			pEvent.accept(IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());
			pEvent.accept(IcariaItems.POPULUS_PLANKS.get());
			pEvent.accept(IcariaItems.POPULUS_STAIRS.get());
			pEvent.accept(IcariaItems.POPULUS_SLAB.get());
			pEvent.accept(IcariaItems.POPULUS_FENCE.get());
			pEvent.accept(IcariaItems.POPULUS_FENCE_GATE.get());
			pEvent.accept(IcariaItems.SIMPLE_POPULUS_RACK.get());
			pEvent.accept(IcariaItems.POPULUS_RACK.get());
			pEvent.accept(IcariaItems.POPULUS_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_POPULUS_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_POPULUS_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_POPULUS_BARREL_RACK.get());
			pEvent.accept(IcariaItems.POPULUS_TROUGH.get());
			pEvent.accept(IcariaItems.POPULUS_STOOL.get());
			pEvent.accept(IcariaItems.POPULUS_PAN_HOLDER.get());
			pEvent.accept(IcariaItems.POPULUS_SPOON_HOLDER.get());
			pEvent.accept(IcariaItems.POPULUS_TOWEL_HOLDER.get());
			pEvent.accept(IcariaItems.POPULUS_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.POPULUS_SCROLLSHELF.get());
			pEvent.accept(IcariaItems.POPULUS_DOOR.get());
			pEvent.accept(IcariaItems.POPULUS_TRAPDOOR.get());
			pEvent.accept(IcariaItems.POPULUS_PRESSURE_PLATE.get());
			pEvent.accept(IcariaItems.POPULUS_BUTTON.get());
			pEvent.accept(IcariaItems.POPULUS_LADDER.get());
			pEvent.accept(IcariaItems.POPULUS_SIGN.get());
			pEvent.accept(IcariaItems.POPULUS_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.BLOOMY_VINE.get());
			pEvent.accept(IcariaItems.BRANCHY_VINE.get());
			pEvent.accept(IcariaItems.BRUSHY_VINE.get());
			pEvent.accept(IcariaItems.DRY_VINE.get());
			pEvent.accept(IcariaItems.REEDY_VINE.get());
			pEvent.accept(IcariaItems.SWIRLY_VINE.get());
			pEvent.accept(IcariaItems.THORNY_VINE.get());

			pEvent.accept(IcariaItems.FERN.get());

			pEvent.accept(IcariaItems.SMALL_GRASS.get());
			pEvent.accept(IcariaItems.MEDIUM_GRASS.get());
			pEvent.accept(IcariaItems.LARGE_GRASS.get());

			pEvent.accept(IcariaItems.SMALL_MIXED_GRAIN.get());
			pEvent.accept(IcariaItems.MEDIUM_MIXED_GRAIN.get());
			pEvent.accept(IcariaItems.MEDIUM_BROWN_GRAIN.get());
			pEvent.accept(IcariaItems.MEDIUM_WHITE_GRAIN.get());
			pEvent.accept(IcariaItems.MEDIUM_YELLOW_GRAIN.get());
			pEvent.accept(IcariaItems.LARGE_BROWN_GRAIN.get());

			pEvent.accept(IcariaItems.BLINDWEED.get());
			pEvent.accept(IcariaItems.CHAMEOMILE.get());
			pEvent.accept(IcariaItems.CHARMONDER.get());
			pEvent.accept(IcariaItems.CLOVER.get());
			pEvent.accept(IcariaItems.FIREHILT.get());
			pEvent.accept(IcariaItems.BLUE_HYDRACINTH.get());
			pEvent.accept(IcariaItems.PURPLE_HYDRACINTH.get());
			pEvent.accept(IcariaItems.LIONFANGS.get());
			pEvent.accept(IcariaItems.SPEARDROPS.get());
			pEvent.accept(IcariaItems.PURPLE_STAGHORN.get());
			pEvent.accept(IcariaItems.YELLOW_STAGHORN.get());
			pEvent.accept(IcariaItems.BLUE_STORMCOTTON.get());
			pEvent.accept(IcariaItems.PINK_STORMCOTTON.get());
			pEvent.accept(IcariaItems.PURPLE_STORMCOTTON.get());
			pEvent.accept(IcariaItems.SUNKETTLE.get());
			pEvent.accept(IcariaItems.SUNSPONGE.get());
			pEvent.accept(IcariaItems.VOIDLILY.get());

			pEvent.accept(IcariaItems.BOLBOS.get());
			pEvent.accept(IcariaItems.DATHULLA.get());
			pEvent.accept(IcariaItems.MONDANOS.get());
			pEvent.accept(IcariaItems.MOTH_AGARIC.get());
			pEvent.accept(IcariaItems.NAMDRAKE.get());
			pEvent.accept(IcariaItems.PSILOCYBOS.get());
			pEvent.accept(IcariaItems.ROWAN.get());
			pEvent.accept(IcariaItems.WILTED_ELM.get());

			pEvent.accept(IcariaItems.BLUE_GROUND_FLOWERS.get());
			pEvent.accept(IcariaItems.CYAN_GROUND_FLOWERS.get());
			pEvent.accept(IcariaItems.PINK_GROUND_FLOWERS.get());
			pEvent.accept(IcariaItems.PURPLE_GROUND_FLOWERS.get());
			pEvent.accept(IcariaItems.RED_GROUND_FLOWERS.get());
			pEvent.accept(IcariaItems.WHITE_GROUND_FLOWERS.get());

			pEvent.accept(IcariaItems.FOREST_MOSS.get());
			pEvent.accept(IcariaItems.SCRUBLAND_MOSS.get());
			pEvent.accept(IcariaItems.STEPPE_MOSS.get());

			pEvent.accept(IcariaItems.PALM_FERN.get());

			pEvent.accept(IcariaItems.WHITE_BROMELIA.get());
			pEvent.accept(IcariaItems.ORANGE_BROMELIA.get());
			pEvent.accept(IcariaItems.PINK_BROMELIA.get());
			pEvent.accept(IcariaItems.PURPLE_BROMELIA.get());

			pEvent.accept(IcariaItems.GREEN_GROUND_SHROOMS.get());
			pEvent.accept(IcariaItems.BROWN_GROUND_SHROOMS.get());
			pEvent.accept(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get());

			pEvent.accept(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get());
			pEvent.accept(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get());
			pEvent.accept(IcariaItems.UNNAMED_TREE_SHROOMS.get());

			pEvent.accept(IcariaItems.CARDON_CACTUS.get());

			pEvent.accept(IcariaItems.STRAWBERRY_BUSH.get());
		}
	}

	public static void items(BuildCreativeModeTabContentsEvent pEvent) {
		if (pEvent.getTab() == IcariaCreativeModeTabs.ITEMS.get()) {
			pEvent.accept(IcariaItems.PAINTING.get());

			pEvent.accept(IcariaItems.BONE_REMAINS.get());
			pEvent.accept(IcariaItems.LOAM_LUMP.get());
			pEvent.accept(IcariaItems.LOAM_BRICK.get());
			pEvent.accept(IcariaItems.CHERT.get());
			pEvent.accept(IcariaItems.ENDER_JELLYFISH_JELLY.get());
			pEvent.accept(IcariaItems.FIRE_JELLYFISH_JELLY.get());
			pEvent.accept(IcariaItems.NATURE_JELLYFISH_JELLY.get());
			pEvent.accept(IcariaItems.VOID_JELLYFISH_JELLY.get());
			pEvent.accept(IcariaItems.WATER_JELLYFISH_JELLY.get());
			pEvent.accept(IcariaItems.ARACHNE_STRING.get());
			pEvent.accept(IcariaItems.SPELT.get());
			pEvent.accept(IcariaItems.VINE_REED.get());
			pEvent.accept(IcariaItems.ROTTEN_BONES.get());
			pEvent.accept(IcariaItems.GREENPOWDER.get());
			pEvent.accept(IcariaItems.CALCITE_SHARD.get());
			pEvent.accept(IcariaItems.HALITE_SHARD.get());
			pEvent.accept(IcariaItems.JASPER_SHARD.get());
			pEvent.accept(IcariaItems.ZIRCON_SHARD.get());
			pEvent.accept(IcariaItems.CALCITE_DUST.get());
			pEvent.accept(IcariaItems.HALITE_DUST.get());
			pEvent.accept(IcariaItems.LIGNITE.get());
			pEvent.accept(IcariaItems.RAW_CHALKOS.get());
			pEvent.accept(IcariaItems.RAW_KASSITEROS.get());
			pEvent.accept(IcariaItems.DOLOMITE.get());
			pEvent.accept(IcariaItems.RAW_VANADIUM.get());
			pEvent.accept(IcariaItems.SLIVER.get());
			pEvent.accept(IcariaItems.RAW_SIDEROS.get());
			pEvent.accept(IcariaItems.ANTHRACITE.get());
			pEvent.accept(IcariaItems.RAW_MOLYBDENUM.get());

			pEvent.accept(IcariaItems.CHALKOS_NUGGET.get());
			pEvent.accept(IcariaItems.KASSITEROS_NUGGET.get());
			pEvent.accept(IcariaItems.ORICHALCUM_NUGGET.get());
			pEvent.accept(IcariaItems.VANADIUM_NUGGET.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_NUGGET.get());
			pEvent.accept(IcariaItems.SIDEROS_NUGGET.get());
			pEvent.accept(IcariaItems.MOLYBDENUM_NUGGET.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
			pEvent.accept(IcariaItems.BLURIDIUM_NUGGET.get());

			pEvent.accept(IcariaItems.CHALKOS_INGOT.get());
			pEvent.accept(IcariaItems.KASSITEROS_INGOT.get());
			pEvent.accept(IcariaItems.ORICHALCUM_INGOT.get());
			pEvent.accept(IcariaItems.VANADIUM_INGOT.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_INGOT.get());
			pEvent.accept(IcariaItems.SIDEROS_INGOT.get());
			pEvent.accept(IcariaItems.MOLYBDENUM_INGOT.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
			pEvent.accept(IcariaItems.BLURIDIUM_INGOT.get());

			pEvent.accept(IcariaItems.CHERT_SWORD.get());
			pEvent.accept(IcariaItems.CHERT_DAGGER.get());
			pEvent.accept(IcariaItems.CHERT_SHOVEL.get());
			pEvent.accept(IcariaItems.CHERT_PICKAXE.get());
			pEvent.accept(IcariaItems.CHERT_AXE.get());
			pEvent.accept(IcariaItems.CHERT_SCYTHE.get());
			pEvent.accept(IcariaItems.CHERT_BIDENT.get());
			pEvent.accept(IcariaItems.CHALKOS_SWORD.get());
			pEvent.accept(IcariaItems.CHALKOS_DAGGER.get());
			pEvent.accept(IcariaItems.CHALKOS_SHOVEL.get());
			pEvent.accept(IcariaItems.CHALKOS_PICKAXE.get());
			pEvent.accept(IcariaItems.CHALKOS_AXE.get());
			pEvent.accept(IcariaItems.CHALKOS_SCYTHE.get());
			pEvent.accept(IcariaItems.CHALKOS_BIDENT.get());
			pEvent.accept(IcariaItems.KASSITEROS_SWORD.get());
			pEvent.accept(IcariaItems.KASSITEROS_DAGGER.get());
			pEvent.accept(IcariaItems.KASSITEROS_SHOVEL.get());
			pEvent.accept(IcariaItems.KASSITEROS_PICKAXE.get());
			pEvent.accept(IcariaItems.KASSITEROS_AXE.get());
			pEvent.accept(IcariaItems.KASSITEROS_SCYTHE.get());
			pEvent.accept(IcariaItems.KASSITEROS_BIDENT.get());
			pEvent.accept(IcariaItems.ORICHALCUM_SWORD.get());
			pEvent.accept(IcariaItems.ORICHALCUM_DAGGER.get());
			pEvent.accept(IcariaItems.ORICHALCUM_SHOVEL.get());
			pEvent.accept(IcariaItems.ORICHALCUM_PICKAXE.get());
			pEvent.accept(IcariaItems.ORICHALCUM_AXE.get());
			pEvent.accept(IcariaItems.ORICHALCUM_SCYTHE.get());
			pEvent.accept(IcariaItems.ORICHALCUM_BIDENT.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_SWORD.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_DAGGER.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_SHOVEL.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_PICKAXE.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_AXE.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_SCYTHE.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_BIDENT.get());
			pEvent.accept(IcariaItems.SIDEROS_SWORD.get());
			pEvent.accept(IcariaItems.SIDEROS_DAGGER.get());
			pEvent.accept(IcariaItems.SIDEROS_SHOVEL.get());
			pEvent.accept(IcariaItems.SIDEROS_PICKAXE.get());
			pEvent.accept(IcariaItems.SIDEROS_AXE.get());
			pEvent.accept(IcariaItems.SIDEROS_SCYTHE.get());
			pEvent.accept(IcariaItems.SIDEROS_BIDENT.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_SWORD.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_DAGGER.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_SHOVEL.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_AXE.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());

			pEvent.accept(IcariaItems.AETERNAE_HIDE_HELMET.get());
			pEvent.accept(IcariaItems.AETERNAE_HIDE_CHESTPLATE.get());
			pEvent.accept(IcariaItems.AETERNAE_HIDE_LEGGINGS.get());
			pEvent.accept(IcariaItems.AETERNAE_HIDE_BOOTS.get());
			pEvent.accept(IcariaItems.CHALKOS_HELMET.get());
			pEvent.accept(IcariaItems.CHALKOS_CHESTPLATE.get());
			pEvent.accept(IcariaItems.CHALKOS_LEGGINGS.get());
			pEvent.accept(IcariaItems.CHALKOS_BOOTS.get());
			pEvent.accept(IcariaItems.KASSITEROS_HELMET.get());
			pEvent.accept(IcariaItems.KASSITEROS_CHESTPLATE.get());
			pEvent.accept(IcariaItems.KASSITEROS_LEGGINGS.get());
			pEvent.accept(IcariaItems.KASSITEROS_BOOTS.get());
			pEvent.accept(IcariaItems.ORICHALCUM_HELMET.get());
			pEvent.accept(IcariaItems.ORICHALCUM_CHESTPLATE.get());
			pEvent.accept(IcariaItems.ORICHALCUM_LEGGINGS.get());
			pEvent.accept(IcariaItems.ORICHALCUM_BOOTS.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_HELMET.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_CHESTPLATE.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_LEGGINGS.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_BOOTS.get());
			pEvent.accept(IcariaItems.LAUREL_WREATH.get());

			pEvent.accept(IcariaItems.GREEK_FIRE_GRENADE.get());

			pEvent.accept(IcariaItems.TOTEM_OF_STUFFING.get());
			pEvent.accept(IcariaItems.TOTEM_OF_UNBLINDING.get());
			pEvent.accept(IcariaItems.TOTEM_OF_UNDROWNING.get());
			pEvent.accept(IcariaItems.TOTEM_OF_UNDYING.get());
			pEvent.accept(IcariaItems.TOTEM_OF_UNSHATTERING.get());
			pEvent.accept(IcariaItems.TOTEM_OF_UNSINKING.get());

			pEvent.accept(IcariaItems.UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.RED_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.LIME_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get());
			pEvent.accept(IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());

			pEvent.accept(IcariaItems.ANTI_GRAVITY_SCROLL.get());
			pEvent.accept(IcariaItems.FORTIFYING_SCROLL.get());
			pEvent.accept(IcariaItems.HEALING_SCROLL.get());
			pEvent.accept(IcariaItems.BUBBLE_SCROLL.get());
			pEvent.accept(IcariaItems.FREEZING_SCROLL.get());
			pEvent.accept(IcariaItems.MAGIC_MISSILE_SCROLL.get());

			pEvent.accept(IcariaItems.ANTI_GRAVITY_SPELL.get());
			pEvent.accept(IcariaItems.FORTIFYING_SPELL.get());
			pEvent.accept(IcariaItems.HEALING_SPELL.get());
			pEvent.accept(IcariaItems.BUBBLE_SPELL.get());
			pEvent.accept(IcariaItems.FREEZING_SPELL.get());
			pEvent.accept(IcariaItems.MAGIC_MISSILE_SPELL.get());

			pEvent.accept(IcariaItems.EMPTY_FLASK.get());
			pEvent.accept(IcariaItems.ANTI_GRAVITY_FLASK.get());
			pEvent.accept(IcariaItems.FORTIFYING_FLASK.get());
			pEvent.accept(IcariaItems.HEALING_FLASK.get());

			pEvent.accept(IcariaItems.EMPTY_VIAL.get());
			pEvent.accept(IcariaItems.ARACHNE_VENOM_VIAL.get());
			pEvent.accept(IcariaItems.HYLIASTRUM_VIAL.get());

			pEvent.accept(IcariaItems.CHEST_LABEL.get());

			pEvent.accept(IcariaItems.YELLOWSTONE_GEAR.get());
			pEvent.accept(IcariaItems.UNFIRED_LOAM_GEAR.get());
			pEvent.accept(IcariaItems.LOAM_GEAR.get());
			pEvent.accept(IcariaItems.VOIDSHALE_GEAR.get());
			pEvent.accept(IcariaItems.VANADIUM_GEAR.get());
			pEvent.accept(IcariaItems.BLUE_GEARFRAGMENT.get());
			pEvent.accept(IcariaItems.GREEN_GEARFRAGMENT.get());
			pEvent.accept(IcariaItems.YELLOW_GEARFRAGMENT.get());
			pEvent.accept(IcariaItems.DAEDALIAN_GEAR.get());

			pEvent.accept(IcariaItems.AETERNAE_HIDE.get());
			pEvent.accept(IcariaItems.SPELT_FLOUR.get());
			pEvent.accept(IcariaItems.SPELT_BREAD.get());
			pEvent.accept(IcariaItems.VINE_SPROUT.get());
			pEvent.accept(IcariaItems.VINEBERRIES.get());
			pEvent.accept(IcariaItems.STRAWBERRIES.get());
			pEvent.accept(IcariaItems.PHYSALIS.get());
			pEvent.accept(IcariaItems.LAUREL_CHERRY.get());
			pEvent.accept(IcariaItems.BLACK_OLIVES.get());
			pEvent.accept(IcariaItems.GREEN_OLIVES.get());
			pEvent.accept(IcariaItems.GARLIC.get());
			pEvent.accept(IcariaItems.ONION.get());
			pEvent.accept(IcariaItems.RAW_AETERNAE_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_AETERNAE_MEAT.get());
			pEvent.accept(IcariaItems.RAW_CAPELLA_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_CAPELLA_MEAT.get());
			pEvent.accept(IcariaItems.RAW_CATOBLEPAS_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_CATOBLEPAS_MEAT.get());
			pEvent.accept(IcariaItems.RAW_CERVER_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_CERVER_MEAT.get());
			pEvent.accept(IcariaItems.RAW_CROCOTTA_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_CROCOTTA_MEAT.get());
			pEvent.accept(IcariaItems.RAW_THOG_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_THOG_MEAT.get());
			pEvent.accept(IcariaItems.CAPELLA_HORN.get());
			pEvent.accept(IcariaItems.MYRMEKE_SCALES.get());
			pEvent.accept(IcariaItems.SLUG_SCALES.get());
			pEvent.accept(IcariaItems.SNULL_CREAM.get());

			pEvent.accept(IcariaItems.UNFIRED_LOAM_BOWL.get());
			pEvent.accept(IcariaItems.LOAM_BOWL.get());
			pEvent.accept(IcariaItems.FRUIT_SALAD.get());
			pEvent.accept(IcariaItems.ONION_SOUP.get());
			pEvent.accept(IcariaItems.AETERNAE_STEW.get());
			pEvent.accept(IcariaItems.CATOBLEPAS_STEW.get());
			pEvent.accept(IcariaItems.CERVER_STEW.get());
			pEvent.accept(IcariaItems.THOG_STEW.get());

			pEvent.accept(IcariaItems.SPELT_SEEDS.get());
			pEvent.accept(IcariaItems.STRAWBERRY_SEEDS.get());
			pEvent.accept(IcariaItems.PHYSALIS_SEEDS.get());

			pEvent.accept(IcariaItems.AETERNAE_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.ARACHNE_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.ARACHNE_DRONE_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.ARGAN_HOUND_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CAPELLA_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CATOBLEPAS_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CERVER_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CROCOTTA_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CYPRESS_FOREST_HAG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_FOREST_HAG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.FIR_FOREST_HAG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.LAUREL_FOREST_HAG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.OLIVE_FOREST_HAG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.PLANE_FOREST_HAG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.POPULUS_FOREST_HAG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.HYLIASTER_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.ENDER_JELLYFISH_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.FIRE_JELLYFISH_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.NATURE_JELLYFISH_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.VOID_JELLYFISH_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.WATER_JELLYFISH_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.MYRMEKE_DRONE_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.MYRMEKE_SOLDIER_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.MYRMEKE_QUEEN_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CAPTAIN_REVENANT_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CIVILIAN_REVENANT_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CRAWLER_REVENANT_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.OVERGROWN_REVENANT_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.PYROMANCER_REVENANT_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.NETHER_PYROMANCER_REVENANT_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.SOLDIER_REVENANT_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.SCORPION_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CRYSTAL_SLUG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.FOREST_SNULL_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.SNULL_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.SOLIFUGAE_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.THOG_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.VINEGAROON_SPAWN_EGG.get());

			pEvent.accept(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());
		}
	}
}
