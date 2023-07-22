package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.renderer.*;
import com.axanthic.icaria.client.screen.GrinderScreen;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.IcariaBlockStates;
import com.axanthic.icaria.data.IcariaBuiltinEntries;
import com.axanthic.icaria.data.IcariaItemModels;
import com.axanthic.icaria.data.IcariaRecipes;
import com.axanthic.icaria.data.lang.IcariaGerman;
import com.axanthic.icaria.data.lang.IcariaEnglish;
import com.axanthic.icaria.data.loot.IcariaLoot;
import com.axanthic.icaria.data.tags.IcariaBiomeTags;
import com.axanthic.icaria.data.tags.IcariaBlockTags;
import com.axanthic.icaria.data.tags.IcariaFluidTags;
import com.axanthic.icaria.data.tags.IcariaItemTags;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class ClientProxy extends CommonProxy {
	public ClientProxy() {
		// NOOP
	}

	@Override
	public void onCreativeModeTabRegistration(BuildCreativeModeTabContentsEvent pEvent) {
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
			pEvent.accept(IcariaItems.VINE_SPROUT_BLOCK.get());
			pEvent.accept(IcariaItems.ROTTEN_BONES_BLOCK.get());

			pEvent.accept(IcariaItems.RAW_CHALKOS_BLOCK.get());
			pEvent.accept(IcariaItems.RAW_KASSITEROS_BLOCK.get());
			pEvent.accept(IcariaItems.RAW_VANADIUM_BLOCK.get());
			pEvent.accept(IcariaItems.SLIVER_BLOCK.get());
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

			pEvent.accept(IcariaItems.BARREL.get());
			pEvent.accept(IcariaItems.BARREL_RACK.get());

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
			pEvent.accept(IcariaItems.CYAN_LOOT_VASE.get());

			pEvent.accept(IcariaItems.DUNGEON_SPAWNER.get());
			pEvent.accept(IcariaItems.MYRMEKE_SPAWNER.get());
			pEvent.accept(IcariaItems.RUIN_SPAWNER.get());
			pEvent.accept(IcariaItems.VILLAGE_SPAWNER.get());

			pEvent.accept(IcariaItems.AETERNAE_SKULL.get());
			pEvent.accept(IcariaItems.ARGAN_HOUND_SKULL.get());
			pEvent.accept(IcariaItems.CATOBLEPAS_SKULL.get());
			pEvent.accept(IcariaItems.CERVER_SKULL.get());
			pEvent.accept(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.FIR_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.OLIVE_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.PLANE_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.POPULUS_FOREST_HAG_SKULL.get());
			pEvent.accept(IcariaItems.REVENANT_SKULL.get());
			pEvent.accept(IcariaItems.SOW_SKULL.get());

			pEvent.accept(IcariaItems.DIM_TORCH.get());
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
			pEvent.accept(IcariaItems.POPULUS_CRAFTING_TABLE.get());
			pEvent.accept(IcariaItems.POPULUS_DOOR.get());
			pEvent.accept(IcariaItems.POPULUS_TRAPDOOR.get());
			pEvent.accept(IcariaItems.POPULUS_LADDER.get());
			pEvent.accept(IcariaItems.POPULUS_SIGN.get());
			pEvent.accept(IcariaItems.POPULUS_HANGING_SIGN.get());

			pEvent.accept(IcariaItems.DEAD_BLOOMY_VINE.get());
			pEvent.accept(IcariaItems.GROWING_BLOOMY_VINE.get());
			pEvent.accept(IcariaItems.BLOOMY_VINE.get());
			pEvent.accept(IcariaItems.BLOOMING_BLOOMY_VINE.get());
			pEvent.accept(IcariaItems.RIPE_BLOOMY_VINE.get());

			pEvent.accept(IcariaItems.DEAD_BRANCHY_VINE.get());
			pEvent.accept(IcariaItems.GROWING_BRANCHY_VINE.get());
			pEvent.accept(IcariaItems.BRANCHY_VINE.get());

			pEvent.accept(IcariaItems.DEAD_BRUSHY_VINE.get());
			pEvent.accept(IcariaItems.GROWING_BRUSHY_VINE.get());
			pEvent.accept(IcariaItems.BRUSHY_VINE.get());
			pEvent.accept(IcariaItems.RIPE_BRUSHY_VINE.get());

			pEvent.accept(IcariaItems.DEAD_DRY_VINE.get());
			pEvent.accept(IcariaItems.GROWING_DRY_VINE.get());
			pEvent.accept(IcariaItems.DRY_VINE.get());

			pEvent.accept(IcariaItems.DEAD_REEDY_VINE.get());
			pEvent.accept(IcariaItems.GROWING_REEDY_VINE.get());
			pEvent.accept(IcariaItems.REEDY_VINE.get());

			pEvent.accept(IcariaItems.DEAD_SWIRLY_VINE.get());
			pEvent.accept(IcariaItems.GROWING_SWIRLY_VINE.get());
			pEvent.accept(IcariaItems.SWIRLY_VINE.get());

			pEvent.accept(IcariaItems.DEAD_THORNY_VINE.get());
			pEvent.accept(IcariaItems.GROWING_THORNY_VINE.get());
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
			pEvent.accept(IcariaItems.VINE_SPROUT.get());
			pEvent.accept(IcariaItems.ROTTEN_BONES.get());
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
			pEvent.accept(IcariaItems.ORICHALCUM_HELMET.get());
			pEvent.accept(IcariaItems.ORICHALCUM_CHESTPLATE.get());
			pEvent.accept(IcariaItems.ORICHALCUM_LEGGINGS.get());
			pEvent.accept(IcariaItems.ORICHALCUM_BOOTS.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get());
			pEvent.accept(IcariaItems.VANADIUMSTEEL_ARMOR.boots.get());
			pEvent.accept(IcariaItems.LAUREL_WREATH.get());

			pEvent.accept(IcariaItems.GREEK_FIRE_GRENADE.get());

			pEvent.accept(IcariaItems.TOTEM_OF_PREVENTATION.get());
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

			pEvent.accept(IcariaItems.EMPTY_FLASK.get());

			pEvent.accept(IcariaItems.EMPTY_VIAL.get());
			pEvent.accept(IcariaItems.HYLIASTRUM_VIAL.get());

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
			pEvent.accept(IcariaItems.RAW_CATOBLEPAS_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_CATOBLEPAS_MEAT.get());
			pEvent.accept(IcariaItems.RAW_CERVER_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_CERVER_MEAT.get());
			pEvent.accept(IcariaItems.RAW_SOW_MEAT.get());
			pEvent.accept(IcariaItems.COOKED_SOW_MEAT.get());
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
			pEvent.accept(IcariaItems.CATOBLEPAS_SPAWN_EGG.get());
			pEvent.accept(IcariaItems.CERVER_SPAWN_EGG.get());
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

	@Override
	public void onEntityAttributeCreation(EntityAttributeCreationEvent pEvent) {
		super.onEntityAttributeCreation(pEvent);
	}

	@Override
	public void onFMLClientSetup(FMLClientSetupEvent pEvent) {
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.CYPRESS));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.DROUGHTROOT));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.FIR));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.LAUREL));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.OLIVE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.PLANE));
		pEvent.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.POPULUS));

		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenus.GRINDER.get(), GrinderScreen::new));
		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenus.STORAGE_VASE.get(), StorageVaseScreen::new));

		ItemProperties.register(IcariaItems.GREEK_FIRE_GRENADE.get(), IcariaResourceLocations.THROWING, (pItemStack, pClientLevel, pLivingEntity, pId) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
		ItemProperties.register(IcariaItems.VINEGAR.get(), IcariaResourceLocations.THROWING, (pItemStack, pClientLevel, pLivingEntity, pId) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);

		for (var items : IcariaToolItems.TOOL_ITEMS) {
			ItemProperties.register(items.bident.get(), IcariaResourceLocations.THROWING, (pItemStack, pClientLevel, pLivingEntity, pId) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
		}
	}

	@Override
	public void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		super.onFMLCommonSetup(pEvent);
	}

	@Override
	public void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
		// BLOCK COLOR
		this.blockColor(IcariaBlocks.GRASSY_MARL.get());
		this.blockColor(IcariaBlocks.GROWING_BLOOMY_VINE.get());
		this.blockColor(IcariaBlocks.BLOOMY_VINE.get());
		this.blockColor(IcariaBlocks.BLOOMING_BLOOMY_VINE.get());
		this.blockColor(IcariaBlocks.RIPE_BLOOMY_VINE.get());
		this.blockColor(IcariaBlocks.GROWING_BRANCHY_VINE.get());
		this.blockColor(IcariaBlocks.BRANCHY_VINE.get());
		this.blockColor(IcariaBlocks.GROWING_BRUSHY_VINE.get());
		this.blockColor(IcariaBlocks.RIPE_BRUSHY_VINE.get());
		this.blockColor(IcariaBlocks.BRUSHY_VINE.get());
		this.blockColor(IcariaBlocks.DEAD_DRY_VINE.get());
		this.blockColor(IcariaBlocks.GROWING_DRY_VINE.get());
		this.blockColor(IcariaBlocks.DRY_VINE.get());
		this.blockColor(IcariaBlocks.GROWING_REEDY_VINE.get());
		this.blockColor(IcariaBlocks.REEDY_VINE.get());
		this.blockColor(IcariaBlocks.DEAD_SWIRLY_VINE.get());
		this.blockColor(IcariaBlocks.GROWING_SWIRLY_VINE.get());
		this.blockColor(IcariaBlocks.SWIRLY_VINE.get());
		this.blockColor(IcariaBlocks.DEAD_THORNY_VINE.get());
		this.blockColor(IcariaBlocks.GROWING_THORNY_VINE.get());
		this.blockColor(IcariaBlocks.THORNY_VINE.get());
		this.blockColor(IcariaBlocks.FERN.get());
		this.blockColor(IcariaBlocks.POTTED_FERN.get());
		this.blockColor(IcariaBlocks.SMALL_GRASS.get());
		this.blockColor(IcariaBlocks.MEDIUM_GRASS.get());
		this.blockColor(IcariaBlocks.LARGE_GRASS.get());
		this.blockColor(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		this.blockColor(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		this.blockColor(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		this.blockColor(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		this.blockColor(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		this.blockColor(IcariaBlocks.LARGE_BROWN_GRAIN.get());
		this.blockColor(IcariaBlocks.BLINDWEED.get());
		this.blockColor(IcariaBlocks.POTTED_BLINDWEED.get());
		this.blockColor(IcariaBlocks.CHAMEOMILE.get());
		this.blockColor(IcariaBlocks.POTTED_CHAMEOMILE.get());
		this.blockColor(IcariaBlocks.CHARMONDER.get());
		this.blockColor(IcariaBlocks.POTTED_CHARMONDER.get());
		this.blockColor(IcariaBlocks.CLOVER.get());
		this.blockColor(IcariaBlocks.POTTED_CLOVER.get());
		this.blockColor(IcariaBlocks.FIREHILT.get());
		this.blockColor(IcariaBlocks.POTTED_FIREHILT.get());
		this.blockColor(IcariaBlocks.BLUE_HYDRACINTH.get());
		this.blockColor(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		this.blockColor(IcariaBlocks.PURPLE_HYDRACINTH.get());
		this.blockColor(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		this.blockColor(IcariaBlocks.LIONFANGS.get());
		this.blockColor(IcariaBlocks.POTTED_LIONFANGS.get());
		this.blockColor(IcariaBlocks.SPEARDROPS.get());
		this.blockColor(IcariaBlocks.POTTED_SPEARDROPS.get());
		this.blockColor(IcariaBlocks.PURPLE_STAGHORN.get());
		this.blockColor(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		this.blockColor(IcariaBlocks.YELLOW_STAGHORN.get());
		this.blockColor(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		this.blockColor(IcariaBlocks.BLUE_STORMCOTTON.get());
		this.blockColor(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		this.blockColor(IcariaBlocks.PINK_STORMCOTTON.get());
		this.blockColor(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		this.blockColor(IcariaBlocks.PURPLE_STORMCOTTON.get());
		this.blockColor(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		this.blockColor(IcariaBlocks.SUNKETTLE.get());
		this.blockColor(IcariaBlocks.POTTED_SUNKETTLE.get());
		this.blockColor(IcariaBlocks.SUNSPONGE.get());
		this.blockColor(IcariaBlocks.POTTED_SUNSPONGE.get());
		this.blockColor(IcariaBlocks.VOIDLILY.get());
		this.blockColor(IcariaBlocks.POTTED_VOIDLILY.get());
		this.blockColor(IcariaBlocks.PALM_FERN.get());
		this.blockColor(IcariaBlocks.POTTED_PALM_FERN.get());
		this.blockColor(IcariaBlocks.WHITE_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		this.blockColor(IcariaBlocks.ORANGE_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		this.blockColor(IcariaBlocks.PINK_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		this.blockColor(IcariaBlocks.PURPLE_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());

		// ITEM COLOR
		this.itemColor(IcariaItems.GRASSY_MARL.get());
		this.itemColor(IcariaItems.PALM_FERN.get());
		this.itemColor(IcariaItems.WHITE_BROMELIA.get());
		this.itemColor(IcariaItems.ORANGE_BROMELIA.get());
		this.itemColor(IcariaItems.PINK_BROMELIA.get());
		this.itemColor(IcariaItems.PURPLE_BROMELIA.get());

		// RENDER CUTOUT
		this.renderCutout(IcariaBlocks.GRASSY_MARL.get());
		this.renderCutout(IcariaBlocks.GRAINGLASS.get());
		this.renderCutout(IcariaBlocks.GRAINGLASS_PANE.get());
		this.renderCutout(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get());
		this.renderCutout(IcariaBlocks.SILKGLASS.get());
		this.renderCutout(IcariaBlocks.SILKGLASS_PANE.get());
		this.renderCutout(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get());
		this.renderCutout(IcariaBlocks.BLURRED_PLATOSHALE.get());
		this.renderCutout(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get());
		this.renderCutout(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		this.renderCutout(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get());
		this.renderCutout(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());
		this.renderCutout(IcariaBlocks.DUNGEON_SPAWNER.get());
		this.renderCutout(IcariaBlocks.MYRMEKE_SPAWNER.get());
		this.renderCutout(IcariaBlocks.RUIN_SPAWNER.get());
		this.renderCutout(IcariaBlocks.VILLAGE_SPAWNER.get());
		this.renderCutout(IcariaBlocks.CYPRESS_SAPLING.get());
		this.renderCutout(IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		this.renderCutout(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		this.renderCutout(IcariaBlocks.CYPRESS_DOOR.get());
		this.renderCutout(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		this.renderCutout(IcariaBlocks.CYPRESS_LADDER.get());
		this.renderCutout(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.renderCutout(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		this.renderCutout(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		this.renderCutout(IcariaBlocks.DROUGHTROOT_DOOR.get());
		this.renderCutout(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		this.renderCutout(IcariaBlocks.DROUGHTROOT_LADDER.get());
		this.renderCutout(IcariaBlocks.FIR_SAPLING.get());
		this.renderCutout(IcariaBlocks.POTTED_FIR_SAPLING.get());
		this.renderCutout(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		this.renderCutout(IcariaBlocks.FIR_DOOR.get());
		this.renderCutout(IcariaBlocks.FIR_TRAPDOOR.get());
		this.renderCutout(IcariaBlocks.FIR_LADDER.get());
		this.renderCutout(IcariaBlocks.LAUREL_SAPLING.get());
		this.renderCutout(IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		this.renderCutout(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		this.renderCutout(IcariaBlocks.LAUREL_DOOR.get());
		this.renderCutout(IcariaBlocks.LAUREL_TRAPDOOR.get());
		this.renderCutout(IcariaBlocks.LAUREL_LADDER.get());
		this.renderCutout(IcariaBlocks.OLIVE_SAPLING.get());
		this.renderCutout(IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		this.renderCutout(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		this.renderCutout(IcariaBlocks.OLIVE_DOOR.get());
		this.renderCutout(IcariaBlocks.OLIVE_TRAPDOOR.get());
		this.renderCutout(IcariaBlocks.OLIVE_LADDER.get());
		this.renderCutout(IcariaBlocks.PLANE_SAPLING.get());
		this.renderCutout(IcariaBlocks.POTTED_PLANE_SAPLING.get());
		this.renderCutout(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		this.renderCutout(IcariaBlocks.PLANE_DOOR.get());
		this.renderCutout(IcariaBlocks.PLANE_TRAPDOOR.get());
		this.renderCutout(IcariaBlocks.PLANE_LADDER.get());
		this.renderCutout(IcariaBlocks.POPULUS_SAPLING.get());
		this.renderCutout(IcariaBlocks.POTTED_POPULUS_SAPLING.get());
		this.renderCutout(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		this.renderCutout(IcariaBlocks.POPULUS_DOOR.get());
		this.renderCutout(IcariaBlocks.POPULUS_TRAPDOOR.get());
		this.renderCutout(IcariaBlocks.POPULUS_LADDER.get());
		this.renderCutout(IcariaBlocks.DIM_TORCH.get());
		this.renderCutout(IcariaBlocks.DIM_WALL_TORCH.get());
		this.renderCutout(IcariaBlocks.DEAD_BLOOMY_VINE.get());
		this.renderCutout(IcariaBlocks.GROWING_BLOOMY_VINE.get());
		this.renderCutout(IcariaBlocks.BLOOMY_VINE.get());
		this.renderCutout(IcariaBlocks.BLOOMING_BLOOMY_VINE.get());
		this.renderCutout(IcariaBlocks.RIPE_BLOOMY_VINE.get());
		this.renderCutout(IcariaBlocks.DEAD_BRANCHY_VINE.get());
		this.renderCutout(IcariaBlocks.GROWING_BRANCHY_VINE.get());
		this.renderCutout(IcariaBlocks.BRANCHY_VINE.get());
		this.renderCutout(IcariaBlocks.DEAD_BRUSHY_VINE.get());
		this.renderCutout(IcariaBlocks.GROWING_BRUSHY_VINE.get());
		this.renderCutout(IcariaBlocks.RIPE_BRUSHY_VINE.get());
		this.renderCutout(IcariaBlocks.BRUSHY_VINE.get());
		this.renderCutout(IcariaBlocks.DEAD_DRY_VINE.get());
		this.renderCutout(IcariaBlocks.GROWING_DRY_VINE.get());
		this.renderCutout(IcariaBlocks.DRY_VINE.get());
		this.renderCutout(IcariaBlocks.DEAD_REEDY_VINE.get());
		this.renderCutout(IcariaBlocks.GROWING_REEDY_VINE.get());
		this.renderCutout(IcariaBlocks.REEDY_VINE.get());
		this.renderCutout(IcariaBlocks.DEAD_SWIRLY_VINE.get());
		this.renderCutout(IcariaBlocks.GROWING_SWIRLY_VINE.get());
		this.renderCutout(IcariaBlocks.SWIRLY_VINE.get());
		this.renderCutout(IcariaBlocks.DEAD_THORNY_VINE.get());
		this.renderCutout(IcariaBlocks.GROWING_THORNY_VINE.get());
		this.renderCutout(IcariaBlocks.THORNY_VINE.get());
		this.renderCutout(IcariaBlocks.FERN.get());
		this.renderCutout(IcariaBlocks.POTTED_FERN.get());
		this.renderCutout(IcariaBlocks.SMALL_GRASS.get());
		this.renderCutout(IcariaBlocks.MEDIUM_GRASS.get());
		this.renderCutout(IcariaBlocks.LARGE_GRASS.get());
		this.renderCutout(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		this.renderCutout(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		this.renderCutout(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		this.renderCutout(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		this.renderCutout(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		this.renderCutout(IcariaBlocks.LARGE_BROWN_GRAIN.get());
		this.renderCutout(IcariaBlocks.BLINDWEED.get());
		this.renderCutout(IcariaBlocks.POTTED_BLINDWEED.get());
		this.renderCutout(IcariaBlocks.CHAMEOMILE.get());
		this.renderCutout(IcariaBlocks.POTTED_CHAMEOMILE.get());
		this.renderCutout(IcariaBlocks.CHARMONDER.get());
		this.renderCutout(IcariaBlocks.POTTED_CHARMONDER.get());
		this.renderCutout(IcariaBlocks.CLOVER.get());
		this.renderCutout(IcariaBlocks.POTTED_CLOVER.get());
		this.renderCutout(IcariaBlocks.FIREHILT.get());
		this.renderCutout(IcariaBlocks.POTTED_FIREHILT.get());
		this.renderCutout(IcariaBlocks.BLUE_HYDRACINTH.get());
		this.renderCutout(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		this.renderCutout(IcariaBlocks.PURPLE_HYDRACINTH.get());
		this.renderCutout(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		this.renderCutout(IcariaBlocks.LIONFANGS.get());
		this.renderCutout(IcariaBlocks.POTTED_LIONFANGS.get());
		this.renderCutout(IcariaBlocks.SPEARDROPS.get());
		this.renderCutout(IcariaBlocks.POTTED_SPEARDROPS.get());
		this.renderCutout(IcariaBlocks.PURPLE_STAGHORN.get());
		this.renderCutout(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		this.renderCutout(IcariaBlocks.YELLOW_STAGHORN.get());
		this.renderCutout(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		this.renderCutout(IcariaBlocks.BLUE_STORMCOTTON.get());
		this.renderCutout(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		this.renderCutout(IcariaBlocks.PINK_STORMCOTTON.get());
		this.renderCutout(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		this.renderCutout(IcariaBlocks.PURPLE_STORMCOTTON.get());
		this.renderCutout(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		this.renderCutout(IcariaBlocks.SUNKETTLE.get());
		this.renderCutout(IcariaBlocks.POTTED_SUNKETTLE.get());
		this.renderCutout(IcariaBlocks.SUNSPONGE.get());
		this.renderCutout(IcariaBlocks.POTTED_SUNSPONGE.get());
		this.renderCutout(IcariaBlocks.VOIDLILY.get());
		this.renderCutout(IcariaBlocks.POTTED_VOIDLILY.get());
		this.renderCutout(IcariaBlocks.PSILOCYBOS.get());
		this.renderCutout(IcariaBlocks.ROWAN.get());
		this.renderCutout(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		this.renderCutout(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		this.renderCutout(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		this.renderCutout(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		this.renderCutout(IcariaBlocks.RED_GROUND_FLOWERS.get());
		this.renderCutout(IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		this.renderCutout(IcariaBlocks.PALM_FERN.get());
		this.renderCutout(IcariaBlocks.POTTED_PALM_FERN.get());
		this.renderCutout(IcariaBlocks.WHITE_BROMELIA.get());
		this.renderCutout(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		this.renderCutout(IcariaBlocks.ORANGE_BROMELIA.get());
		this.renderCutout(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		this.renderCutout(IcariaBlocks.PINK_BROMELIA.get());
		this.renderCutout(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		this.renderCutout(IcariaBlocks.PURPLE_BROMELIA.get());
		this.renderCutout(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
		this.renderCutout(IcariaBlocks.STRAWBERRY_BUSH.get());
		this.renderCutout(IcariaBlocks.SPELT_CROP.get());
		this.renderCutout(IcariaBlocks.STRAWBERRY_CROP.get());
		this.renderCutout(IcariaBlocks.PHYSALIS_CROP.get());
		this.renderCutout(IcariaBlocks.ONION_CROP.get());
		this.renderCutout(IcariaBlocks.GREEK_FIRE.get());

		// RENDER TRANSLUCENT
		this.renderTranslucent(IcariaBlocks.ARISTONE.get());
		this.renderTranslucent(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.CALCITE_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.HALITE_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.ZIRCON_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.PORTAL.get());
		this.renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER.get());
		this.renderTranslucent(IcariaFluids.FLOWING_MEDITERRANEAN_WATER.get());

		// ENTITY RENDERERS
		EntityRenderers.register(IcariaEntityTypes.AETERNAE.get(), AeternaeRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE.get(), ArachneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE_DRONE.get(), ArachneDroneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARGAN_HOUND.get(), ArganHoundRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BIDENT.get(), BidentRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CATOBLEPAS.get(), CatoblepasRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CERVER.get(), CerverRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), GreekFireGrenadeRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), CypressForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), DroughtrootForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FIR_FOREST_HAG.get(), FirForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), LaurelForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), OliveForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.PLANE_FOREST_HAG.get(), PlaneForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), PopulusForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.HYLIASTER.get(), HyliasterRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ENDER_JELLYFISH.get(), EnderJellyfishRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FIRE_JELLYFISH.get(), FireJellyfishRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.NATURE_JELLYFISH.get(), NatureJellyfishRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VOID_JELLYFISH.get(), VoidJellyfishRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.WATER_JELLYFISH.get(), WaterJellyfishRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.LOOT_VASE.get(), LootVaseRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.MYRMEKE_DRONE.get(), MyrmekeDroneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), MyrmekeSoldierRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.MYRMEKE_QUEEN.get(), MyrmekeQueenRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CAPTAIN_REVENANT.get(), CaptainRevenantRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CIVILIAN_REVENANT.get(), CivilianRevenantRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CRAWLER_REVENANT.get(), CrawlerRevenantRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.OVERGROWN_REVENANT.get(), OvergrownRevenantRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.PYROMANCER_REVENANT.get(), PyromancerRevenantRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), NetherPyromancerRevenantRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.SOLDIER_REVENANT.get(), SoldierRevenantRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.SCORPION.get(), ScorpionRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CRYSTAL_SLUG.get(), CrystalSlugRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FOREST_SNULL.get(), ForestSnullRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.SNULL.get(), SnullRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.SOLIFUGAE.get(), SolifugaeRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.SOW.get(), SowRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAR.get(), VinegarRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAROON.get(), VinegaroonRenderer::new);

		// BLOCK ENTITY RENDERERS
		BlockEntityRenderers.register(IcariaBlockEntityTypes.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.HANGING_SIGN.get(), HangingSignRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SIGN.get(), IcariaSignBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SKULL.get(), IcariaSkullBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SPAWNER.get(), IcariaSpawnerBlockRenderer::new);
	}

	@Override
	public void onGatherData(GatherDataEvent pEvent) {
		var generator = pEvent.getGenerator();
		var existingFileHelper = pEvent.getExistingFileHelper();
		var packOutput = generator.getPackOutput();
		var lookupProvider = pEvent.getLookupProvider();

		var blockTags = new IcariaBlockTags(packOutput, lookupProvider, IcariaInfo.ID, existingFileHelper);
		var registrySet = new IcariaRegistrySetBuilder();

		generator.addProvider(pEvent.includeClient(), new IcariaEnglish(packOutput, IcariaInfo.ID, "en_us"));
		generator.addProvider(pEvent.includeClient(), new IcariaGerman(packOutput, IcariaInfo.ID, "de_de"));
		generator.addProvider(pEvent.includeClient(), new IcariaBlockStates(packOutput, IcariaInfo.ID, existingFileHelper));
		generator.addProvider(pEvent.includeClient(), new IcariaItemModels(packOutput, IcariaInfo.ID, existingFileHelper));

		generator.addProvider(pEvent.includeServer(), new IcariaLoot(packOutput));
		generator.addProvider(pEvent.includeServer(), new IcariaBiomeTags(packOutput, lookupProvider, registrySet, IcariaInfo.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), blockTags);
		generator.addProvider(pEvent.includeServer(), new IcariaFluidTags(packOutput, lookupProvider, IcariaInfo.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), new IcariaItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), IcariaInfo.ID, existingFileHelper));
		generator.addProvider(pEvent.includeServer(), new IcariaRecipes(packOutput));
		generator.addProvider(pEvent.includeServer(), new IcariaBuiltinEntries(packOutput, lookupProvider, registrySet, IcariaInfo.ID));
	}

	@Override
	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
		pEvent.registerLayerDefinition(IcariaLayerLocations.AETERNAE, AeternaeModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.AETERNAE_SKULL, AeternaeSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARACHNE, ArachneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARACHNE_DRONE, ArachneDroneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARGAN_HOUND, ArganHoundModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARGAN_HOUND_SKULL, ArganHoundSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CATOBLEPAS, CatoblepasModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CATOBLEPAS_SKULL, CatoblepasSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CERVER, CerverModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CERVER_SKULL, CerverSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CYPRESS_FOREST_HAG, CypressForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CYPRESS_FOREST_HAG_SKULL, CypressForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.DROUGHTROOT_FOREST_HAG, DroughtrootForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.DROUGHTROOT_FOREST_HAG_SKULL, DroughtrootForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.FIR_FOREST_HAG, FirForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.FIR_FOREST_HAG_SKULL, FirForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.LAUREL_FOREST_HAG, LaurelForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.LAUREL_FOREST_HAG_SKULL, LaurelForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.OLIVE_FOREST_HAG, OliveForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.OLIVE_FOREST_HAG_SKULL, OliveForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.PLANE_FOREST_HAG, PlaneForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.PLANE_FOREST_HAG_SKULL, PlaneForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.POPULUS_FOREST_HAG, PopulusForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.POPULUS_FOREST_HAG_SKULL, PopulusForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.HYLIASTER, HyliasterModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ENDER_JELLYFISH, EnderJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.FIRE_JELLYFISH, FireJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.NATURE_JELLYFISH, NatureJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.VOID_JELLYFISH, VoidJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.WATER_JELLYFISH, WaterJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.MYRMEKE_DRONE, MyrmekeDroneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.MYRMEKE_SOLDIER, MyrmekeSoldierModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.MYRMEKE_QUEEN_BODY, MyrmekeQueenModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.MYRMEKE_QUEEN_RAYS, MyrmekeQueenModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ORICHALCUM_HELMET, OrichalcumHelmetModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CAPTAIN_REVENANT_BODY, CaptainRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CAPTAIN_REVENANT_ITEM, CaptainRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CIVILIAN_REVENANT_BODY, CivilianRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CIVILIAN_REVENANT_ITEM, CivilianRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CRAWLER_REVENANT_BODY, CrawlerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CRAWLER_REVENANT_ITEM, CrawlerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.OVERGROWN_REVENANT_BODY, OvergrownRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.OVERGROWN_REVENANT_ITEM, OvergrownRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.OVERGROWN_REVENANT_RAYS, OvergrownRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.PYROMANCER_REVENANT_BODY, PyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.PYROMANCER_REVENANT_ITEM, PyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.NETHER_PYROMANCER_REVENANT_BODY, NetherPyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.NETHER_PYROMANCER_REVENANT_ITEM, NetherPyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.SOLDIER_REVENANT_BODY, SoldierRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.SOLDIER_REVENANT_ITEM, SoldierRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.REVENANT_SKULL, RevenantSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.SCORPION, ScorpionModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CRYSTAL_SLUG_BODY, CrystalSlugModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CRYSTAL_SLUG_RAYS, CrystalSlugModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.FOREST_SNULL, ForestSnullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.SNULL, SnullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.SOLIFUGAE, SolifugaeModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.SOW, SowModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.SOW_SKULL, SowSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.VINEGAROON, VinegaroonModel::createLayer);
	}

	@Override
	public void onSpawnPlacementRegister(SpawnPlacementRegisterEvent pEvent) {
		super.onSpawnPlacementRegister(pEvent);
	}

	@Override
	public void onEntityAttributeModification(EntityAttributeModificationEvent pEvent) {
		super.onEntityAttributeModification(pEvent);
	}

	@Override
	public void onLivingAttack(LivingAttackEvent pEvent) {
		float amount = pEvent.getAmount();
		var livingEntity = pEvent.getEntity();
		if (livingEntity instanceof Player player) {
			float health = player.getHealth();
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_STUFFING.get();
			if (player.getFoodData().getFoodLevel() <= 0) {
				if (offhandItem.getItem().equals(totem)) {
					player.setHealth(health + amount);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + amount);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (livingEntity instanceof Player player) {
			float health = player.getHealth();
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNDROWNING.get();
			if (player.getAirSupply() <= 0) {
				if (offhandItem.getItem().equals(totem)) {
					player.setHealth(health + amount);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + amount);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (livingEntity instanceof Player player) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNDYING.get();
			if (amount >= player.getHealth()) {
				if (offhandItem.getItem().equals(totem)) {
					pEvent.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					pEvent.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		var entity = pEvent.getSource().getEntity();
		if (entity instanceof Player player) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof TieredItem || mainHandItem.getItem() instanceof TridentItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}

		if (livingEntity instanceof Player player) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			for (int slot = 5; slot < 9; slot++) {
				var armor = player.inventoryMenu.slots.get(slot).getItem();
				if (armor.getItem() instanceof ArmorItem) {
					if (armor.getDamageValue() >= (armor.getMaxDamage() * 0.9)) {
						if (offhandItem.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}

						if (mainHandItem.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}
					}
				}
			}
		}

		if (livingEntity instanceof Player player) {
			float health = player.getHealth();
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSINKING.get();
			if (player.position().y <= -64) {
				if (offhandItem.getItem().equals(totem)) {
					player.setHealth(health + amount);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + amount);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (entity instanceof Player player) {
			if (player.hasEffect(IcariaMobEffects.LIFESTEAL.get())) {
				player.heal(amount);
			}
		}
	}

	@Override
	public void onMobEffectApplicable(MobEffectEvent.Applicable pEvent) {
		if (pEvent.getEntity() instanceof Player player) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNBLINDING.get();
			if (pEvent.getEffectInstance().getEffect().equals(MobEffects.BLINDNESS)) {
				if (offhandItem.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent pEvent) {
		var player = pEvent.getEntity();
		if (player != null) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof FishingRodItem || mainHandItem.getItem() instanceof BowItem || mainHandItem.getItem() instanceof CrossbowItem || mainHandItem.getItem() instanceof ShieldItem || mainHandItem.getItem() instanceof TridentItem || mainHandItem.getItem() instanceof BidentItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offhandItem.getItem() instanceof FishingRodItem || offhandItem.getItem() instanceof BowItem || offhandItem.getItem() instanceof CrossbowItem || offhandItem.getItem() instanceof ShieldItem || offhandItem.getItem() instanceof TridentItem || offhandItem.getItem() instanceof BidentItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onEntityInteract(PlayerInteractEvent.EntityInteract pEvent) {
		var player = pEvent.getEntity();
		if (player != null) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof ShearsItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offhandItem.getItem() instanceof ShearsItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock pEvent) {
		var player = pEvent.getEntity();
		if (player != null) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof TieredItem || mainHandItem.getItem() instanceof ShearsItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock pEvent) {
		var player = pEvent.getEntity();
		if (player != null) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof AxeItem || mainHandItem.getItem() instanceof HoeItem || mainHandItem.getItem() instanceof ShovelItem || mainHandItem.getItem() instanceof FlintAndSteelItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offhandItem.getItem() instanceof AxeItem || offhandItem.getItem() instanceof HoeItem || offhandItem.getItem() instanceof ShovelItem || offhandItem.getItem() instanceof FlintAndSteelItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onPlayerTick(TickEvent.PlayerTickEvent pEvent) {
		super.onPlayerTick(pEvent);
	}

	@Override
	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> pEvent) {
		if (pEvent.getRenderer().getModel() instanceof PlayerModel<?>) {
			for (var itemStack : pEvent.getEntity().getArmorSlots()) {
				if (itemStack.getItem() instanceof IcariaSkullItem) {
					((PlayerModel<?>) pEvent.getRenderer().getModel()).hat.visible = false;
					((PlayerModel<?>) pEvent.getRenderer().getModel()).head.visible = false;
					return;
				}
			}
		}
	}

	public void blockColor(Block pBlock) {
		Minecraft.getInstance().getBlockColors().register((pBlockState, pLevel, pBlockPos, pIndex) -> BiomeColors.getAverageGrassColor(pLevel, pBlockPos), pBlock);
	}

	public void itemColor(Item pItem) {
		Minecraft.getInstance().getItemColors().register((pItemStack, pIndex) -> 11909984, pItem);
	}

	public void renderCutout(Block pBlock) {
		ItemBlockRenderTypes.setRenderLayer(pBlock, RenderType.cutout());
	}

	public void renderTranslucent(Block pBlock) {
		ItemBlockRenderTypes.setRenderLayer(pBlock, RenderType.translucent());
	}

	public void renderTranslucent(Fluid pFluid) {
		ItemBlockRenderTypes.setRenderLayer(pFluid, RenderType.translucent());
	}
}
