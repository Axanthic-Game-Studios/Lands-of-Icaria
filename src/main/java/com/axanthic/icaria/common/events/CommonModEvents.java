package com.axanthic.icaria.common.events;

import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.data.*;
import com.axanthic.icaria.data.advancements.IcariaAdvancements;
import com.axanthic.icaria.data.lang.IcariaEnglish;
import com.axanthic.icaria.data.lang.IcariaGerman;
import com.axanthic.icaria.data.loot.IcariaLoot;
import com.axanthic.icaria.data.models.IcariaBlockModels;
import com.axanthic.icaria.data.models.IcariaItemModels;
import com.axanthic.icaria.data.tags.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(modid = IcariaIdents.ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

	@SubscribeEvent
	public static void onCreativeModeTabRegistration(BuildCreativeModeTabContentsEvent pEvent) {
		if (pEvent.getTab().equals(IcariaCreativeModeTabs.BLOCKS.get())) {
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

			pEvent.accept(IcariaItems.MARL_ADOBE.get());
			pEvent.accept(IcariaItems.MARL_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.MARL_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.MARL_ADOBE_DECO.wall.get());

			pEvent.accept(IcariaItems.LOAM.get());
			pEvent.accept(IcariaItems.LOAM_BRICKS.get());
			pEvent.accept(IcariaItems.LOAM_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.LOAM_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.LOAM_BRICK_DECO.wall.get());

			pEvent.accept(IcariaItems.DOLOMITE_ADOBE.get());
			pEvent.accept(IcariaItems.DOLOMITE_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.DOLOMITE_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.DOLOMITE_ADOBE_DECO.wall.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE_DECO.stairs.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE_DECO.slab.get());
			pEvent.accept(IcariaItems.SMOOTH_DOLOMITE_DECO.wall.get());
			pEvent.accept(IcariaItems.DOLOMITE_BRICKS.get());
			pEvent.accept(IcariaItems.DOLOMITE_PILLAR.get());
			pEvent.accept(IcariaItems.DOLOMITE_PILLAR_HEAD.get());

			pEvent.accept(IcariaItems.GRAINEL.get());
			pEvent.accept(IcariaItems.GRAINEL_CHERT.get());
			pEvent.accept(IcariaItems.GRAINGLASS.get());
			pEvent.accept(IcariaItems.GRAINGLASS_PANE.get());
			pEvent.accept(IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.GRAINITE_ADOBE_DECO.wall.get());
			pEvent.accept(IcariaItems.GRAINITE.get());
			pEvent.accept(IcariaItems.GRAINITE_DECO.stairs.get());
			pEvent.accept(IcariaItems.GRAINITE_DECO.slab.get());
			pEvent.accept(IcariaItems.GRAINITE_DECO.wall.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICKS.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.GRAINITE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.CHISELED_GRAINITE.get());
			pEvent.accept(IcariaItems.GRAINITE_RUBBLE.get());

			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_ADOBE_DECO.wall.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.COBBLED_YELLOWSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.YELLOWSTONE.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.CHISELED_YELLOWSTONE.get());
			pEvent.accept(IcariaItems.YELLOWSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.SILKSAND.get());
			pEvent.accept(IcariaItems.SILKGLASS.get());
			pEvent.accept(IcariaItems.SILKGLASS_PANE.get());
			pEvent.accept(IcariaItems.HORIZONTAL_SILKGLASS_PANE.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.SILKSTONE_ADOBE_DECO.wall.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.COBBLED_SILKSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.SILKSTONE.get());
			pEvent.accept(IcariaItems.SILKSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.SILKSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.SILKSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.SILKSTONE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.CHISELED_SILKSTONE.get());
			pEvent.accept(IcariaItems.SILKSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.SUNSTONE_ADOBE.get());
			pEvent.accept(IcariaItems.SUNSTONE_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.SUNSTONE_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.SUNSTONE_ADOBE_DECO.wall.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.COBBLED_SUNSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.SUNSTONE.get());
			pEvent.accept(IcariaItems.SUNSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.SUNSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.SUNSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.SUNSTONE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.CHISELED_SUNSTONE.get());
			pEvent.accept(IcariaItems.SUNSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE.get());
			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.VOIDSHALE_ADOBE_DECO.wall.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE_DECO.stairs.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE_DECO.slab.get());
			pEvent.accept(IcariaItems.COBBLED_VOIDSHALE_DECO.wall.get());
			pEvent.accept(IcariaItems.VOIDSHALE.get());
			pEvent.accept(IcariaItems.VOIDSHALE_DECO.stairs.get());
			pEvent.accept(IcariaItems.VOIDSHALE_DECO.slab.get());
			pEvent.accept(IcariaItems.VOIDSHALE_DECO.wall.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICKS.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.VOIDSHALE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.CHISELED_VOIDSHALE.get());
			pEvent.accept(IcariaItems.VOIDSHALE_RUBBLE.get());

			pEvent.accept(IcariaItems.BAETYL_ADOBE.get());
			pEvent.accept(IcariaItems.BAETYL_ADOBE_DECO.stairs.get());
			pEvent.accept(IcariaItems.BAETYL_ADOBE_DECO.slab.get());
			pEvent.accept(IcariaItems.BAETYL_ADOBE_DECO.wall.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL_DECO.stairs.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL_DECO.slab.get());
			pEvent.accept(IcariaItems.COBBLED_BAETYL_DECO.wall.get());
			pEvent.accept(IcariaItems.BAETYL.get());
			pEvent.accept(IcariaItems.BAETYL_DECO.stairs.get());
			pEvent.accept(IcariaItems.BAETYL_DECO.slab.get());
			pEvent.accept(IcariaItems.BAETYL_DECO.wall.get());
			pEvent.accept(IcariaItems.BAETYL_BRICKS.get());
			pEvent.accept(IcariaItems.BAETYL_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.BAETYL_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.BAETYL_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.CHISELED_BAETYL.get());
			pEvent.accept(IcariaItems.BAETYL_RUBBLE.get());

			pEvent.accept(IcariaItems.RELICSTONE.get());
			pEvent.accept(IcariaItems.RELICSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.RELICSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.RELICSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE_DECO.stairs.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE_DECO.slab.get());
			pEvent.accept(IcariaItems.SMOOTH_RELICSTONE_DECO.wall.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.RELICSTONE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_BRICK_DECO.wall.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILES.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILE_DECO.stairs.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILE_DECO.slab.get());
			pEvent.accept(IcariaItems.RELICSTONE_TILE_DECO.wall.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILES.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILE_DECO.stairs.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILE_DECO.slab.get());
			pEvent.accept(IcariaItems.CRACKED_RELICSTONE_TILE_DECO.wall.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILES.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILE_DECO.stairs.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILE_DECO.slab.get());
			pEvent.accept(IcariaItems.MOSSY_RELICSTONE_TILE_DECO.wall.get());
			pEvent.accept(IcariaItems.CHISELED_RELICSTONE.get());
			pEvent.accept(IcariaItems.RELICSTONE_PILLAR.get());
			pEvent.accept(IcariaItems.RELICSTONE_PILLAR_HEAD.get());
			pEvent.accept(IcariaItems.RELICSTONE_RUBBLE.get());

			pEvent.accept(IcariaItems.PLATOSHALE.get());
			pEvent.accept(IcariaItems.PLATOSHALE_DECO.stairs.get());
			pEvent.accept(IcariaItems.PLATOSHALE_DECO.slab.get());
			pEvent.accept(IcariaItems.PLATOSHALE_DECO.wall.get());
			pEvent.accept(IcariaItems.BLURRED_PLATOSHALE.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICKS.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICK_DECO.stairs.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICK_DECO.slab.get());
			pEvent.accept(IcariaItems.PLATOSHALE_BRICK_DECO.wall.get());
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
			pEvent.accept(IcariaItems.SOW_SKULL.get());

			pEvent.accept(IcariaItems.LIGNITE_TORCH.get());
			pEvent.accept(IcariaItems.ANTHRACITE_TORCH.get());

			pEvent.accept(IcariaItems.LAUREL_CHERRY_CAKE.get());
			pEvent.accept(IcariaItems.STRAWBERRY_CAKE.get());
			pEvent.accept(IcariaItems.PHYSALIS_CAKE.get());
			pEvent.accept(IcariaItems.VINE_BERRY_CAKE.get());
			pEvent.accept(IcariaItems.VINE_SPROUT_CAKE.get());
		}

		if (pEvent.getTab().equals(IcariaCreativeModeTabs.FLORA.get())) {
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
			pEvent.accept(IcariaItems.CYPRESS_DECO.stairs.get());
			pEvent.accept(IcariaItems.CYPRESS_DECO.slab.get());
			pEvent.accept(IcariaItems.CYPRESS_DECO.fence.get());
			pEvent.accept(IcariaItems.CYPRESS_DECO.gate.get());
			pEvent.accept(IcariaItems.SIMPLE_CYPRESS_RACK.get());
			pEvent.accept(IcariaItems.CYPRESS_RACK.get());
			pEvent.accept(IcariaItems.CYPRESS_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_CYPRESS_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_CYPRESS_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_CYPRESS_BARREL_RACK.get());
			pEvent.accept(IcariaItems.CYPRESS_TROUGH.get());
			pEvent.accept(IcariaItems.CYPRESS_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.CYPRESS_DOOR.get());
			pEvent.accept(IcariaItems.CYPRESS_TRAPDOOR.get());
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
			pEvent.accept(IcariaItems.DROUGHTROOT_DECO.stairs.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_DECO.slab.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_DECO.fence.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_DECO.gate.get());
			pEvent.accept(IcariaItems.SIMPLE_DROUGHTROOT_RACK.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_RACK.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_DROUGHTROOT_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_DROUGHTROOT_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_DROUGHTROOT_BARREL_RACK.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_TROUGH.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_DOOR.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_TRAPDOOR.get());
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
			pEvent.accept(IcariaItems.FIR_DECO.stairs.get());
			pEvent.accept(IcariaItems.FIR_DECO.slab.get());
			pEvent.accept(IcariaItems.FIR_DECO.fence.get());
			pEvent.accept(IcariaItems.FIR_DECO.gate.get());
			pEvent.accept(IcariaItems.SIMPLE_FIR_RACK.get());
			pEvent.accept(IcariaItems.FIR_RACK.get());
			pEvent.accept(IcariaItems.FIR_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_FIR_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_FIR_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_FIR_BARREL_RACK.get());
			pEvent.accept(IcariaItems.FIR_TROUGH.get());
			pEvent.accept(IcariaItems.FIR_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.FIR_DOOR.get());
			pEvent.accept(IcariaItems.FIR_TRAPDOOR.get());
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
			pEvent.accept(IcariaItems.LAUREL_DECO.stairs.get());
			pEvent.accept(IcariaItems.LAUREL_DECO.slab.get());
			pEvent.accept(IcariaItems.LAUREL_DECO.fence.get());
			pEvent.accept(IcariaItems.LAUREL_DECO.gate.get());
			pEvent.accept(IcariaItems.SIMPLE_LAUREL_RACK.get());
			pEvent.accept(IcariaItems.LAUREL_RACK.get());
			pEvent.accept(IcariaItems.LAUREL_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_LAUREL_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_LAUREL_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_LAUREL_BARREL_RACK.get());
			pEvent.accept(IcariaItems.LAUREL_TROUGH.get());
			pEvent.accept(IcariaItems.LAUREL_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.LAUREL_DOOR.get());
			pEvent.accept(IcariaItems.LAUREL_TRAPDOOR.get());
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
			pEvent.accept(IcariaItems.OLIVE_DECO.stairs.get());
			pEvent.accept(IcariaItems.OLIVE_DECO.slab.get());
			pEvent.accept(IcariaItems.OLIVE_DECO.fence.get());
			pEvent.accept(IcariaItems.OLIVE_DECO.gate.get());
			pEvent.accept(IcariaItems.SIMPLE_OLIVE_RACK.get());
			pEvent.accept(IcariaItems.OLIVE_RACK.get());
			pEvent.accept(IcariaItems.OLIVE_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_OLIVE_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_OLIVE_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_OLIVE_BARREL_RACK.get());
			pEvent.accept(IcariaItems.OLIVE_TROUGH.get());
			pEvent.accept(IcariaItems.OLIVE_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.OLIVE_DOOR.get());
			pEvent.accept(IcariaItems.OLIVE_TRAPDOOR.get());
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
			pEvent.accept(IcariaItems.PLANE_DECO.stairs.get());
			pEvent.accept(IcariaItems.PLANE_DECO.slab.get());
			pEvent.accept(IcariaItems.PLANE_DECO.fence.get());
			pEvent.accept(IcariaItems.PLANE_DECO.gate.get());
			pEvent.accept(IcariaItems.SIMPLE_PLANE_RACK.get());
			pEvent.accept(IcariaItems.PLANE_RACK.get());
			pEvent.accept(IcariaItems.PLANE_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_PLANE_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_PLANE_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_PLANE_BARREL_RACK.get());
			pEvent.accept(IcariaItems.PLANE_TROUGH.get());
			pEvent.accept(IcariaItems.PLANE_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.PLANE_DOOR.get());
			pEvent.accept(IcariaItems.PLANE_TRAPDOOR.get());
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
			pEvent.accept(IcariaItems.POPULUS_DECO.stairs.get());
			pEvent.accept(IcariaItems.POPULUS_DECO.slab.get());
			pEvent.accept(IcariaItems.POPULUS_DECO.fence.get());
			pEvent.accept(IcariaItems.POPULUS_DECO.gate.get());
			pEvent.accept(IcariaItems.SIMPLE_POPULUS_RACK.get());
			pEvent.accept(IcariaItems.POPULUS_RACK.get());
			pEvent.accept(IcariaItems.POPULUS_BARREL.get());
			pEvent.accept(IcariaItems.LOADED_POPULUS_BARREL.get());
			pEvent.accept(IcariaItems.TAPPED_POPULUS_BARREL.get());
			pEvent.accept(IcariaItems.TRIPLE_POPULUS_BARREL_RACK.get());
			pEvent.accept(IcariaItems.POPULUS_TROUGH.get());
			pEvent.accept(IcariaItems.POPULUS_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.POPULUS_DOOR.get());
			pEvent.accept(IcariaItems.POPULUS_TRAPDOOR.get());
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

		if (pEvent.getTab().equals(IcariaCreativeModeTabs.ITEMS.get())) {
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

			pEvent.accept(IcariaItems.CHERT_TOOLS.sword.get());
			pEvent.accept(IcariaItems.CHERT_TOOLS.dagger.get());
			pEvent.accept(IcariaItems.CHERT_TOOLS.shovel.get());
			pEvent.accept(IcariaItems.CHERT_TOOLS.pickaxe.get());
			pEvent.accept(IcariaItems.CHERT_TOOLS.axe.get());
			pEvent.accept(IcariaItems.CHERT_TOOLS.scythe.get());
			pEvent.accept(IcariaItems.CHERT_TOOLS.bident.get());
			pEvent.accept(IcariaItems.CHALKOS_TOOLS.sword.get());
			pEvent.accept(IcariaItems.CHALKOS_TOOLS.dagger.get());
			pEvent.accept(IcariaItems.CHALKOS_TOOLS.shovel.get());
			pEvent.accept(IcariaItems.CHALKOS_TOOLS.pickaxe.get());
			pEvent.accept(IcariaItems.CHALKOS_TOOLS.axe.get());
			pEvent.accept(IcariaItems.CHALKOS_TOOLS.scythe.get());
			pEvent.accept(IcariaItems.CHALKOS_TOOLS.bident.get());
			pEvent.accept(IcariaItems.KASSITEROS_TOOLS.sword.get());
			pEvent.accept(IcariaItems.KASSITEROS_TOOLS.dagger.get());
			pEvent.accept(IcariaItems.KASSITEROS_TOOLS.shovel.get());
			pEvent.accept(IcariaItems.KASSITEROS_TOOLS.pickaxe.get());
			pEvent.accept(IcariaItems.KASSITEROS_TOOLS.axe.get());
			pEvent.accept(IcariaItems.KASSITEROS_TOOLS.scythe.get());
			pEvent.accept(IcariaItems.KASSITEROS_TOOLS.bident.get());
			pEvent.accept(IcariaItems.ORICHALCUM_TOOLS.sword.get());
			pEvent.accept(IcariaItems.ORICHALCUM_TOOLS.dagger.get());
			pEvent.accept(IcariaItems.ORICHALCUM_TOOLS.shovel.get());
			pEvent.accept(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get());
			pEvent.accept(IcariaItems.ORICHALCUM_TOOLS.axe.get());
			pEvent.accept(IcariaItems.ORICHALCUM_TOOLS.scythe.get());
			pEvent.accept(IcariaItems.ORICHALCUM_TOOLS.bident.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_TOOLS.sword.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_TOOLS.axe.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get());
			pEvent.accept(IcariaItems.SIDEROS_TOOLS.sword.get());
			pEvent.accept(IcariaItems.SIDEROS_TOOLS.dagger.get());
			pEvent.accept(IcariaItems.SIDEROS_TOOLS.shovel.get());
			pEvent.accept(IcariaItems.SIDEROS_TOOLS.pickaxe.get());
			pEvent.accept(IcariaItems.SIDEROS_TOOLS.axe.get());
			pEvent.accept(IcariaItems.SIDEROS_TOOLS.scythe.get());
			pEvent.accept(IcariaItems.SIDEROS_TOOLS.bident.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get());
			pEvent.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());

			pEvent.accept(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get());
			pEvent.accept(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get());
			pEvent.accept(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get());
			pEvent.accept(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get());
			pEvent.accept(IcariaItems.CHALKOS_ARMOR.helmet.get());
			pEvent.accept(IcariaItems.CHALKOS_ARMOR.chestplate.get());
			pEvent.accept(IcariaItems.CHALKOS_ARMOR.leggings.get());
			pEvent.accept(IcariaItems.CHALKOS_ARMOR.boots.get());
			pEvent.accept(IcariaItems.KASSITEROS_ARMOR.helmet.get());
			pEvent.accept(IcariaItems.KASSITEROS_ARMOR.chestplate.get());
			pEvent.accept(IcariaItems.KASSITEROS_ARMOR.leggings.get());
			pEvent.accept(IcariaItems.KASSITEROS_ARMOR.boots.get());
			pEvent.accept(IcariaItems.ORICHALCUM_ARMOR.helmet.get());
			pEvent.accept(IcariaItems.ORICHALCUM_ARMOR.chestplate.get());
			pEvent.accept(IcariaItems.ORICHALCUM_ARMOR.leggings.get());
			pEvent.accept(IcariaItems.ORICHALCUM_ARMOR.boots.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.boots.get());
			pEvent.accept(IcariaItems.LAUREL_WREATH.get());

			pEvent.accept(IcariaItems.GREEK_FIRE_GRENADE.get());

			pEvent.accept(IcariaItems.TOTEM_OF_STUFFING.get());
			pEvent.accept(IcariaItems.TOTEM_OF_UNBLINDING.get());
			pEvent.accept(IcariaItems.TOTEM_OF_UNDROWNING.get());
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
			pEvent.accept(IcariaItems.RAW_SOW_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_SOW_MEAT.get());
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
			pEvent.accept(IcariaItems.SOW_STEW.get());

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
			pEvent.accept(IcariaItems.SOW_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.VINEGAROON_SPAWN_EGG.get());

			pEvent.accept(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());
		}
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
		pEvent.put(IcariaEntityTypes.ENDER_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.FIRE_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.NATURE_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.VOID_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.WATER_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
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
		pEvent.put(IcariaEntityTypes.SOW.get(), SowEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.VINEGAROON.get(), VinegaroonEntity.registerAttributes().build());
	}

	@SubscribeEvent
	public static void onGatherData(GatherDataEvent pEvent) {
		var generator = pEvent.getGenerator();
		var lookupProvider = pEvent.getLookupProvider();
		var existingFileHelper = pEvent.getExistingFileHelper();

		var packOutput = generator.getPackOutput();

		var blockTags = new IcariaBlockTags(packOutput, lookupProvider, IcariaIdents.ID, existingFileHelper);
		var builtinEntries = new IcariaBuiltinEntries(packOutput, lookupProvider, IcariaIdents.ID);

		var registryProvider = builtinEntries.getRegistryProvider();
		var tagLookup = blockTags.contentsGetter();

		generator.addProvider(pEvent.includeClient(), new IcariaEnglish(packOutput, IcariaIdents.ID, "en_us"));
		generator.addProvider(pEvent.includeClient(), new IcariaGerman(packOutput, IcariaIdents.ID, "de_de"));
		generator.addProvider(pEvent.includeClient(), new IcariaBlockModels(packOutput, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeClient(), new IcariaItemModels(packOutput, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeClient(), new IcariaBlockStates(packOutput, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeClient(), new IcariaParticleDescriptions(packOutput, existingFileHelper));
		generator.addProvider(pEvent.includeClient(), new IcariaSounds(packOutput, IcariaIdents.ID, existingFileHelper));

		generator.addProvider(pEvent.includeServer(), new IcariaAdvancements(packOutput, lookupProvider, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), new IcariaLoot(packOutput, lookupProvider));
		generator.addProvider(pEvent.includeServer(), new IcariaBiomeTags(packOutput, registryProvider, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), blockTags);
		generator.addProvider(pEvent.includeServer(), new IcariaFluidTags(packOutput, lookupProvider, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), new IcariaItemTags(packOutput, lookupProvider, tagLookup, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), new IcariaPaintingVariantTags(packOutput, registryProvider, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), new IcariaStructureTags(packOutput, registryProvider, IcariaIdents.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), builtinEntries);
		generator.addProvider(pEvent.includeServer(), new IcariaDataMaps(packOutput, lookupProvider));
		generator.addProvider(pEvent.includeServer(), new IcariaRecipes(packOutput, lookupProvider));
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
	public static void onSpawnPlacementRegister(RegisterSpawnPlacementsEvent pEvent) {
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
		pEvent.register(IcariaEntityTypes.ENDER_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.FIRE_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.NATURE_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.VOID_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.WATER_JELLYFISH.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
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
		pEvent.register(IcariaEntityTypes.SOW.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SowEntity::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.VINEGAROON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, VinegaroonEntity::checkAnyLightArachnidSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}
}
