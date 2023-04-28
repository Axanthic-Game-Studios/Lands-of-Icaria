package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.renderer.*;
import com.axanthic.icaria.client.screen.GrinderScreen;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.item.TotemItem;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.IcariaBlockStates;
import com.axanthic.icaria.data.IcariaItemModels;
import com.axanthic.icaria.data.IcariaRecipes;
import com.axanthic.icaria.data.lang.IcariaGerman;
import com.axanthic.icaria.data.lang.IcariaEnglish;
import com.axanthic.icaria.data.loot.IcariaLoot;
import com.axanthic.icaria.data.tags.IcariaBlockTags;
import com.axanthic.icaria.data.tags.IcariaFluidTags;
import com.axanthic.icaria.data.tags.IcariaItemTags;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class ClientProxy extends CommonProxy {
	public ClientProxy() {
		// NOOP
	}

	@Override
	public void onCreativeModeTabRegistration(CreativeModeTabEvent.Register pEvent) {
		pEvent.registerCreativeModeTab(new ResourceLocation(IcariaInfo.ID, "blocks"), pBuilder -> pBuilder.title(Component.translatable("itemgroup." + IcariaInfo.ID + ".blocks")).icon(() -> new ItemStack(IcariaItems.MARL_GRASS.get())).displayItems((pParameters, pOutput) -> {
			pOutput.accept(IcariaItems.MARL_GRASS.get());
			pOutput.accept(IcariaItems.MARL.get());
			pOutput.accept(IcariaItems.MARL_CHERT.get());
			pOutput.accept(IcariaItems.SURFACE_CHERT.get());
			pOutput.accept(IcariaItems.MARL_BONES.get());
			pOutput.accept(IcariaItems.SURFACE_BONES.get());
			pOutput.accept(IcariaItems.MARL_LIGNITE.get());
			pOutput.accept(IcariaItems.MARL_COARSE.get());

			pOutput.accept(IcariaItems.FARMLAND.get());
			pOutput.accept(IcariaItems.FARMLAND_FERTILIZED.get());

			pOutput.accept(IcariaItems.MARL_ADOBE.get());
			pOutput.accept(IcariaItems.MARL_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.MARL_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.MARL_ADOBE_DECO.wall.get());

			pOutput.accept(IcariaItems.LOAM.get());
			pOutput.accept(IcariaItems.LOAM_BRICKS.get());
			pOutput.accept(IcariaItems.LOAM_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.LOAM_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.LOAM_BRICKS_DECO.wall.get());

			pOutput.accept(IcariaItems.DOLOMITE_ADOBE.get());
			pOutput.accept(IcariaItems.DOLOMITE_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.DOLOMITE_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.DOLOMITE_ADOBE_DECO.wall.get());
			pOutput.accept(IcariaItems.DOLOMITE_SMOOTH.get());
			pOutput.accept(IcariaItems.DOLOMITE_SMOOTH_DECO.stairs.get());
			pOutput.accept(IcariaItems.DOLOMITE_SMOOTH_DECO.slab.get());
			pOutput.accept(IcariaItems.DOLOMITE_SMOOTH_DECO.wall.get());
			pOutput.accept(IcariaItems.DOLOMITE_BRICKS.get());
			pOutput.accept(IcariaItems.DOLOMITE_PILLAR.get());
			pOutput.accept(IcariaItems.DOLOMITE_PILLAR_HEAD.get());

			pOutput.accept(IcariaItems.GRAINEL.get());
			pOutput.accept(IcariaItems.GRAINEL_CHERT.get());
			pOutput.accept(IcariaItems.GRAINGLASS.get());
			pOutput.accept(IcariaItems.GRAINGLASS_PANE.get());
			pOutput.accept(IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get());
			pOutput.accept(IcariaItems.GRAINITE_ADOBE.get());
			pOutput.accept(IcariaItems.GRAINITE_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.GRAINITE_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.GRAINITE_ADOBE_DECO.wall.get());
			pOutput.accept(IcariaItems.GRAINITE.get());
			pOutput.accept(IcariaItems.GRAINITE_DECO.stairs.get());
			pOutput.accept(IcariaItems.GRAINITE_DECO.slab.get());
			pOutput.accept(IcariaItems.GRAINITE_DECO.wall.get());
			pOutput.accept(IcariaItems.GRAINITE_BRICKS.get());
			pOutput.accept(IcariaItems.GRAINITE_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.GRAINITE_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.GRAINITE_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.GRAINITE_CHISELED.get());
			pOutput.accept(IcariaItems.GRAINITE_RUBBLE.get());

			pOutput.accept(IcariaItems.YELLOWSTONE_ADOBE.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_ADOBE_DECO.wall.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_COBBLE.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_COBBLE_DECO.stairs.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_COBBLE_DECO.slab.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_COBBLE_DECO.wall.get());
			pOutput.accept(IcariaItems.YELLOWSTONE.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_DECO.stairs.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_DECO.slab.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_DECO.wall.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_BRICKS.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_CHISELED.get());
			pOutput.accept(IcariaItems.YELLOWSTONE_RUBBLE.get());

			pOutput.accept(IcariaItems.SILKSAND.get());
			pOutput.accept(IcariaItems.SILKGLASS.get());
			pOutput.accept(IcariaItems.SILKGLASS_PANE.get());
			pOutput.accept(IcariaItems.SILKGLASS_PANE_HORIZONTAL.get());
			pOutput.accept(IcariaItems.SILKSTONE_ADOBE.get());
			pOutput.accept(IcariaItems.SILKSTONE_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.SILKSTONE_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.SILKSTONE_ADOBE_DECO.wall.get());
			pOutput.accept(IcariaItems.SILKSTONE_COBBLE.get());
			pOutput.accept(IcariaItems.SILKSTONE_COBBLE_DECO.stairs.get());
			pOutput.accept(IcariaItems.SILKSTONE_COBBLE_DECO.slab.get());
			pOutput.accept(IcariaItems.SILKSTONE_COBBLE_DECO.wall.get());
			pOutput.accept(IcariaItems.SILKSTONE.get());
			pOutput.accept(IcariaItems.SILKSTONE_DECO.stairs.get());
			pOutput.accept(IcariaItems.SILKSTONE_DECO.slab.get());
			pOutput.accept(IcariaItems.SILKSTONE_DECO.wall.get());
			pOutput.accept(IcariaItems.SILKSTONE_BRICKS.get());
			pOutput.accept(IcariaItems.SILKSTONE_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.SILKSTONE_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.SILKSTONE_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.SILKSTONE_CHISELED.get());
			pOutput.accept(IcariaItems.SILKSTONE_RUBBLE.get());

			pOutput.accept(IcariaItems.SUNSTONE_ADOBE.get());
			pOutput.accept(IcariaItems.SUNSTONE_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.SUNSTONE_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.SUNSTONE_ADOBE_DECO.wall.get());
			pOutput.accept(IcariaItems.SUNSTONE_COBBLE.get());
			pOutput.accept(IcariaItems.SUNSTONE_COBBLE_DECO.stairs.get());
			pOutput.accept(IcariaItems.SUNSTONE_COBBLE_DECO.slab.get());
			pOutput.accept(IcariaItems.SUNSTONE_COBBLE_DECO.wall.get());
			pOutput.accept(IcariaItems.SUNSTONE.get());
			pOutput.accept(IcariaItems.SUNSTONE_DECO.slab.get());
			pOutput.accept(IcariaItems.SUNSTONE_DECO.stairs.get());
			pOutput.accept(IcariaItems.SUNSTONE_DECO.wall.get());
			pOutput.accept(IcariaItems.SUNSTONE_BRICKS.get());
			pOutput.accept(IcariaItems.SUNSTONE_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.SUNSTONE_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.SUNSTONE_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.SUNSTONE_CHISELED.get());
			pOutput.accept(IcariaItems.SUNSTONE_RUBBLE.get());

			pOutput.accept(IcariaItems.VOIDSHALE_ADOBE.get());
			pOutput.accept(IcariaItems.VOIDSHALE_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.VOIDSHALE_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.VOIDSHALE_ADOBE_DECO.wall.get());
			pOutput.accept(IcariaItems.VOIDSHALE_COBBLE.get());
			pOutput.accept(IcariaItems.VOIDSHALE_COBBLE_DECO.stairs.get());
			pOutput.accept(IcariaItems.VOIDSHALE_COBBLE_DECO.slab.get());
			pOutput.accept(IcariaItems.VOIDSHALE_COBBLE_DECO.wall.get());
			pOutput.accept(IcariaItems.VOIDSHALE.get());
			pOutput.accept(IcariaItems.VOIDSHALE_DECO.stairs.get());
			pOutput.accept(IcariaItems.VOIDSHALE_DECO.slab.get());
			pOutput.accept(IcariaItems.VOIDSHALE_DECO.wall.get());
			pOutput.accept(IcariaItems.VOIDSHALE_BRICKS.get());
			pOutput.accept(IcariaItems.VOIDSHALE_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.VOIDSHALE_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.VOIDSHALE_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.VOIDSHALE_CHISELED.get());
			pOutput.accept(IcariaItems.VOIDSHALE_RUBBLE.get());

			pOutput.accept(IcariaItems.BAETYL_ADOBE.get());
			pOutput.accept(IcariaItems.BAETYL_ADOBE_DECO.stairs.get());
			pOutput.accept(IcariaItems.BAETYL_ADOBE_DECO.slab.get());
			pOutput.accept(IcariaItems.BAETYL_ADOBE_DECO.wall.get());
			pOutput.accept(IcariaItems.BAETYL_COBBLE.get());
			pOutput.accept(IcariaItems.BAETYL_COBBLE_DECO.stairs.get());
			pOutput.accept(IcariaItems.BAETYL_COBBLE_DECO.slab.get());
			pOutput.accept(IcariaItems.BAETYL_COBBLE_DECO.wall.get());
			pOutput.accept(IcariaItems.BAETYL.get());
			pOutput.accept(IcariaItems.BAETYL_DECO.stairs.get());
			pOutput.accept(IcariaItems.BAETYL_DECO.slab.get());
			pOutput.accept(IcariaItems.BAETYL_DECO.wall.get());
			pOutput.accept(IcariaItems.BAETYL_BRICKS.get());
			pOutput.accept(IcariaItems.BAETYL_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.BAETYL_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.BAETYL_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.BAETYL_CHISELED.get());
			pOutput.accept(IcariaItems.BAETYL_RUBBLE.get());

			pOutput.accept(IcariaItems.RELICSTONE.get());
			pOutput.accept(IcariaItems.RELICSTONE_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_SMOOTH.get());
			pOutput.accept(IcariaItems.RELICSTONE_SMOOTH_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_SMOOTH_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_SMOOTH_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_CRACKED.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_CRACKED_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_CRACKED_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_CRACKED_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_MOSSY.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_MOSSY_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_MOSSY_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_BRICKS_MOSSY_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_CRACKED.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_CRACKED_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_CRACKED_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_CRACKED_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_MOSSY.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_MOSSY_DECO.stairs.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_MOSSY_DECO.slab.get());
			pOutput.accept(IcariaItems.RELICSTONE_TILES_MOSSY_DECO.wall.get());
			pOutput.accept(IcariaItems.RELICSTONE_CHISELED.get());
			pOutput.accept(IcariaItems.RELICSTONE_PILLAR.get());
			pOutput.accept(IcariaItems.RELICSTONE_PILLAR_HEAD.get());
			pOutput.accept(IcariaItems.RELICSTONE_RUBBLE.get());

			pOutput.accept(IcariaItems.PLATOSHALE.get());
			pOutput.accept(IcariaItems.PLATOSHALE_DECO.stairs.get());
			pOutput.accept(IcariaItems.PLATOSHALE_DECO.slab.get());
			pOutput.accept(IcariaItems.PLATOSHALE_DECO.wall.get());
			pOutput.accept(IcariaItems.PLATOSHALE_BLURRED.get());
			pOutput.accept(IcariaItems.PLATOSHALE_BRICKS.get());
			pOutput.accept(IcariaItems.PLATOSHALE_BRICKS_DECO.stairs.get());
			pOutput.accept(IcariaItems.PLATOSHALE_BRICKS_DECO.slab.get());
			pOutput.accept(IcariaItems.PLATOSHALE_BRICKS_DECO.wall.get());
			pOutput.accept(IcariaItems.PLATOSHALE_BRICKS_BLURRED.get());
			pOutput.accept(IcariaItems.PLATOSHALE_CHISELED.get());

			pOutput.accept(IcariaItems.QUARTZ_PILLAR_HEAD.get());

			pOutput.accept(IcariaItems.LIGNITE_ORE.get());
			pOutput.accept(IcariaItems.CHALKOS_ORE.get());
			pOutput.accept(IcariaItems.KASSITEROS_ORE.get());
			pOutput.accept(IcariaItems.DOLOMITE_ORE.get());
			pOutput.accept(IcariaItems.VANADIUM_ORE.get());
			pOutput.accept(IcariaItems.SLIVER_ORE.get());
			pOutput.accept(IcariaItems.SIDEROS_ORE.get());
			pOutput.accept(IcariaItems.ANTHRACITE_ORE.get());
			pOutput.accept(IcariaItems.MOLYBDENUM_ORE.get());
			pOutput.accept(IcariaItems.HYLIASTRUM_ORE.get());

			pOutput.accept(IcariaItems.CALCITE_GEODE_BLOCK.get());
			pOutput.accept(IcariaItems.BUDDING_CALCITE_GEODE_BLOCK.get());
			pOutput.accept(IcariaItems.HALITE_GEODE_BLOCK.get());
			pOutput.accept(IcariaItems.BUDDING_HALITE_GEODE_BLOCK.get());
			pOutput.accept(IcariaItems.JASPER_GEODE_BLOCK.get());
			pOutput.accept(IcariaItems.BUDDING_JASPER_GEODE_BLOCK.get());
			pOutput.accept(IcariaItems.ZIRCON_GEODE_BLOCK.get());
			pOutput.accept(IcariaItems.BUDDING_ZIRCON_GEODE_BLOCK.get());

			pOutput.accept(IcariaItems.CALCITE_CRYSTAL.get());
			pOutput.accept(IcariaItems.HALITE_CRYSTAL.get());
			pOutput.accept(IcariaItems.JASPER_CRYSTAL.get());
			pOutput.accept(IcariaItems.ZIRCON_CRYSTAL.get());

			pOutput.accept(IcariaItems.ARISTONE.get());
			pOutput.accept(IcariaItems.ARISTONE_PACKED.get());

			pOutput.accept(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());
			pOutput.accept(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());
			pOutput.accept(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());
			pOutput.accept(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());
			pOutput.accept(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());
			pOutput.accept(IcariaItems.ARACHNE_STRING_BLOCK.get());
			pOutput.accept(IcariaItems.SPELT_BALE_BLOCK.get());
			pOutput.accept(IcariaItems.VINE_REED_BLOCK.get());
			pOutput.accept(IcariaItems.VINE_SPROUT_BLOCK.get());
			pOutput.accept(IcariaItems.ROTTEN_BONES_BLOCK.get());

			pOutput.accept(IcariaItems.CHALKOS_RAW_BLOCK.get());
			pOutput.accept(IcariaItems.KASSITEROS_RAW_BLOCK.get());
			pOutput.accept(IcariaItems.VANADIUM_RAW_BLOCK.get());
			pOutput.accept(IcariaItems.SLIVER_BLOCK.get());
			pOutput.accept(IcariaItems.SIDEROS_RAW_BLOCK.get());
			pOutput.accept(IcariaItems.MOLYBDENUM_RAW_BLOCK.get());

			pOutput.accept(IcariaItems.CALCITE_BLOCK.get());
			pOutput.accept(IcariaItems.HALITE_BLOCK.get());
			pOutput.accept(IcariaItems.JASPER_BLOCK.get());
			pOutput.accept(IcariaItems.ZIRCON_BLOCK.get());
			pOutput.accept(IcariaItems.CHERT_BLOCK.get());
			pOutput.accept(IcariaItems.LIGNITE_BLOCK.get());
			pOutput.accept(IcariaItems.CHALKOS_BLOCK.get());
			pOutput.accept(IcariaItems.KASSITEROS_BLOCK.get());
			pOutput.accept(IcariaItems.ORICHALCUM_BLOCK.get());
			pOutput.accept(IcariaItems.VANADIUM_BLOCK.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_BLOCK.get());
			pOutput.accept(IcariaItems.SIDEROS_BLOCK.get());
			pOutput.accept(IcariaItems.ANTHRACITE_BLOCK.get());
			pOutput.accept(IcariaItems.MOLYBDENUM_BLOCK.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());
			pOutput.accept(IcariaItems.BLURIDIUM_BLOCK.get());

			pOutput.accept(IcariaItems.VANADIUMSTEEL_BARS.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_BARS_HORIZONTAL.get());

			pOutput.accept(IcariaItems.GRINDER.get());

			pOutput.accept(IcariaItems.STORAGE_VASE.get());
			pOutput.accept(IcariaItems.WHITE_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.LIGHT_GRAY_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.GRAY_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.BLACK_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.BROWN_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.RED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.ORANGE_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.YELLOW_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.LIME_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.GREEN_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.CYAN_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.LIGHT_BLUE_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.BLUE_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.PURPLE_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.MAGENTA_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.PINK_STORAGE_VASE.get());

			pOutput.accept(IcariaItems.AETERNAE_SKULL.get());
			pOutput.accept(IcariaItems.ARGAN_HOUND_SKULL.get());
			pOutput.accept(IcariaItems.CATOBLEPAS_SKULL.get());
			pOutput.accept(IcariaItems.CERVER_SKULL.get());
			pOutput.accept(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get());
			pOutput.accept(IcariaItems.FIR_FOREST_HAG_SKULL.get());
			pOutput.accept(IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
			pOutput.accept(IcariaItems.OLIVE_FOREST_HAG_SKULL.get());
			pOutput.accept(IcariaItems.PLANE_FOREST_HAG_SKULL.get());
			pOutput.accept(IcariaItems.POPULUS_FOREST_HAG_SKULL.get());
			pOutput.accept(IcariaItems.REVENANT_SKULL.get());
			pOutput.accept(IcariaItems.SOW_SKULL.get());

			pOutput.accept(IcariaItems.DIM_TORCH.get());
			pOutput.accept(IcariaItems.LIGNITE_TORCH.get());
			pOutput.accept(IcariaItems.ANTHRACITE_TORCH.get());

			pOutput.accept(IcariaItems.LAUREL_CHERRY_CAKE.get());
			pOutput.accept(IcariaItems.STRAWBERRY_CAKE.get());
			pOutput.accept(IcariaItems.PHYSALIS_CAKE.get());
			pOutput.accept(IcariaItems.VINE_BERRY_CAKE.get());
			pOutput.accept(IcariaItems.VINE_SPROUT_CAKE.get());
		}));

		pEvent.registerCreativeModeTab(new ResourceLocation(IcariaInfo.ID, "flora"), List.of(new ResourceLocation(IcariaInfo.ID, "items")), List.of(new ResourceLocation(IcariaInfo.ID, "blocks")), pBuilder -> pBuilder.title(Component.translatable("itemgroup." + IcariaInfo.ID + ".flora")).icon(() -> new ItemStack(IcariaItems.OLIVE_LEAVES.get())).displayItems((pParameters, pOutput) -> {
			pOutput.accept(IcariaItems.CYPRESS_SAPLING.get());
			pOutput.accept(IcariaItems.CYPRESS_LEAVES.get());
			pOutput.accept(IcariaItems.FALLEN_CYPRESS_LEAVES.get());
			pOutput.accept(IcariaItems.CYPRESS_TWIGS.get());
			pOutput.accept(IcariaItems.CYPRESS_WOOD.get());
			pOutput.accept(IcariaItems.STRIPPED_CYPRESS_WOOD.get());
			pOutput.accept(IcariaItems.CYPRESS_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_CYPRESS_LOG.get());
			pOutput.accept(IcariaItems.DEAD_CYPRESS_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get());
			pOutput.accept(IcariaItems.CYPRESS_PLANKS.get());
			pOutput.accept(IcariaItems.CYPRESS_DECO.stairs.get());
			pOutput.accept(IcariaItems.CYPRESS_DECO.slab.get());
			pOutput.accept(IcariaItems.CYPRESS_DECO.fence.get());
			pOutput.accept(IcariaItems.CYPRESS_DECO.gate.get());
			pOutput.accept(IcariaItems.CYPRESS_CRAFTING_TABLE.get());
			pOutput.accept(IcariaItems.CYPRESS_DOOR.get());
			pOutput.accept(IcariaItems.CYPRESS_TRAPDOOR.get());
			pOutput.accept(IcariaItems.CYPRESS_LADDER.get());
			pOutput.accept(IcariaItems.CYPRESS_SIGN.get());

			pOutput.accept(IcariaItems.DROUGHTROOT_SAPLING.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_LEAVES.get());
			pOutput.accept(IcariaItems.FALLEN_DROUGHTROOT_LEAVES.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_TWIGS.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_WOOD.get());
			pOutput.accept(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
			pOutput.accept(IcariaItems.DEAD_DROUGHTROOT_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_PLANKS.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_DECO.stairs.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_DECO.slab.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_DECO.fence.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_DECO.gate.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_DOOR.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_TRAPDOOR.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_LADDER.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_SIGN.get());

			pOutput.accept(IcariaItems.FIR_SAPLING.get());
			pOutput.accept(IcariaItems.FIR_LEAVES.get());
			pOutput.accept(IcariaItems.FALLEN_FIR_LEAVES.get());
			pOutput.accept(IcariaItems.FIR_TWIGS.get());
			pOutput.accept(IcariaItems.FIR_WOOD.get());
			pOutput.accept(IcariaItems.STRIPPED_FIR_WOOD.get());
			pOutput.accept(IcariaItems.FIR_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_FIR_LOG.get());
			pOutput.accept(IcariaItems.DEAD_FIR_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DEAD_FIR_LOG.get());
			pOutput.accept(IcariaItems.FIR_PLANKS.get());
			pOutput.accept(IcariaItems.FIR_DECO.stairs.get());
			pOutput.accept(IcariaItems.FIR_DECO.slab.get());
			pOutput.accept(IcariaItems.FIR_DECO.fence.get());
			pOutput.accept(IcariaItems.FIR_DECO.gate.get());
			pOutput.accept(IcariaItems.FIR_CRAFTING_TABLE.get());
			pOutput.accept(IcariaItems.FIR_DOOR.get());
			pOutput.accept(IcariaItems.FIR_TRAPDOOR.get());
			pOutput.accept(IcariaItems.FIR_LADDER.get());
			pOutput.accept(IcariaItems.FIR_SIGN.get());

			pOutput.accept(IcariaItems.LAUREL_SAPLING.get());
			pOutput.accept(IcariaItems.LAUREL_LEAVES.get());
			pOutput.accept(IcariaItems.FALLEN_LAUREL_LEAVES.get());
			pOutput.accept(IcariaItems.LAUREL_TWIGS.get());
			pOutput.accept(IcariaItems.LAUREL_WOOD.get());
			pOutput.accept(IcariaItems.STRIPPED_LAUREL_WOOD.get());
			pOutput.accept(IcariaItems.LAUREL_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_LAUREL_LOG.get());
			pOutput.accept(IcariaItems.DEAD_LAUREL_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get());
			pOutput.accept(IcariaItems.LAUREL_PLANKS.get());
			pOutput.accept(IcariaItems.LAUREL_DECO.stairs.get());
			pOutput.accept(IcariaItems.LAUREL_DECO.slab.get());
			pOutput.accept(IcariaItems.LAUREL_DECO.fence.get());
			pOutput.accept(IcariaItems.LAUREL_DECO.gate.get());
			pOutput.accept(IcariaItems.LAUREL_CRAFTING_TABLE.get());
			pOutput.accept(IcariaItems.LAUREL_DOOR.get());
			pOutput.accept(IcariaItems.LAUREL_TRAPDOOR.get());
			pOutput.accept(IcariaItems.LAUREL_LADDER.get());
			pOutput.accept(IcariaItems.LAUREL_SIGN.get());

			pOutput.accept(IcariaItems.OLIVE_SAPLING.get());
			pOutput.accept(IcariaItems.OLIVE_LEAVES.get());
			pOutput.accept(IcariaItems.FALLEN_OLIVE_LEAVES.get());
			pOutput.accept(IcariaItems.OLIVE_TWIGS.get());
			pOutput.accept(IcariaItems.OLIVE_WOOD.get());
			pOutput.accept(IcariaItems.STRIPPED_OLIVE_WOOD.get());
			pOutput.accept(IcariaItems.OLIVE_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_OLIVE_LOG.get());
			pOutput.accept(IcariaItems.DEAD_OLIVE_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get());
			pOutput.accept(IcariaItems.OLIVE_PLANKS.get());
			pOutput.accept(IcariaItems.OLIVE_DECO.stairs.get());
			pOutput.accept(IcariaItems.OLIVE_DECO.slab.get());
			pOutput.accept(IcariaItems.OLIVE_DECO.fence.get());
			pOutput.accept(IcariaItems.OLIVE_DECO.gate.get());
			pOutput.accept(IcariaItems.OLIVE_CRAFTING_TABLE.get());
			pOutput.accept(IcariaItems.OLIVE_DOOR.get());
			pOutput.accept(IcariaItems.OLIVE_TRAPDOOR.get());
			pOutput.accept(IcariaItems.OLIVE_LADDER.get());
			pOutput.accept(IcariaItems.OLIVE_SIGN.get());

			pOutput.accept(IcariaItems.PLANE_SAPLING.get());
			pOutput.accept(IcariaItems.PLANE_LEAVES.get());
			pOutput.accept(IcariaItems.FALLEN_PLANE_LEAVES.get());
			pOutput.accept(IcariaItems.PLANE_TWIGS.get());
			pOutput.accept(IcariaItems.PLANE_WOOD.get());
			pOutput.accept(IcariaItems.STRIPPED_PLANE_WOOD.get());
			pOutput.accept(IcariaItems.PLANE_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_PLANE_LOG.get());
			pOutput.accept(IcariaItems.DEAD_PLANE_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DEAD_PLANE_LOG.get());
			pOutput.accept(IcariaItems.PLANE_PLANKS.get());
			pOutput.accept(IcariaItems.PLANE_DECO.stairs.get());
			pOutput.accept(IcariaItems.PLANE_DECO.slab.get());
			pOutput.accept(IcariaItems.PLANE_DECO.fence.get());
			pOutput.accept(IcariaItems.PLANE_DECO.gate.get());
			pOutput.accept(IcariaItems.PLANE_CRAFTING_TABLE.get());
			pOutput.accept(IcariaItems.PLANE_DOOR.get());
			pOutput.accept(IcariaItems.PLANE_TRAPDOOR.get());
			pOutput.accept(IcariaItems.PLANE_LADDER.get());
			pOutput.accept(IcariaItems.PLANE_SIGN.get());

			pOutput.accept(IcariaItems.POPULUS_SAPLING.get());
			pOutput.accept(IcariaItems.POPULUS_LEAVES.get());
			pOutput.accept(IcariaItems.FALLEN_POPULUS_LEAVES.get());
			pOutput.accept(IcariaItems.POPULUS_TWIGS.get());
			pOutput.accept(IcariaItems.POPULUS_WOOD.get());
			pOutput.accept(IcariaItems.STRIPPED_POPULUS_WOOD.get());
			pOutput.accept(IcariaItems.POPULUS_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_POPULUS_LOG.get());
			pOutput.accept(IcariaItems.DEAD_POPULUS_LOG.get());
			pOutput.accept(IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());
			pOutput.accept(IcariaItems.POPULUS_PLANKS.get());
			pOutput.accept(IcariaItems.POPULUS_DECO.stairs.get());
			pOutput.accept(IcariaItems.POPULUS_DECO.slab.get());
			pOutput.accept(IcariaItems.POPULUS_DECO.fence.get());
			pOutput.accept(IcariaItems.POPULUS_DECO.gate.get());
			pOutput.accept(IcariaItems.POPULUS_CRAFTING_TABLE.get());
			pOutput.accept(IcariaItems.POPULUS_DOOR.get());
			pOutput.accept(IcariaItems.POPULUS_TRAPDOOR.get());
			pOutput.accept(IcariaItems.POPULUS_LADDER.get());
			pOutput.accept(IcariaItems.POPULUS_SIGN.get());

			pOutput.accept(IcariaItems.DEAD_BLOOMY_VINE.get());
			pOutput.accept(IcariaItems.GROWING_BLOOMY_VINE.get());
			pOutput.accept(IcariaItems.BLOOMY_VINE.get());
			pOutput.accept(IcariaItems.BLOOMING_BLOOMY_VINE.get());
			pOutput.accept(IcariaItems.RIPE_BLOOMY_VINE.get());

			pOutput.accept(IcariaItems.DEAD_BRANCHY_VINE.get());
			pOutput.accept(IcariaItems.GROWING_BRANCHY_VINE.get());
			pOutput.accept(IcariaItems.BRANCHY_VINE.get());

			pOutput.accept(IcariaItems.DEAD_BRUSHY_VINE.get());
			pOutput.accept(IcariaItems.GROWING_BRUSHY_VINE.get());
			pOutput.accept(IcariaItems.BRUSHY_VINE.get());
			pOutput.accept(IcariaItems.RIPE_BRUSHY_VINE.get());

			pOutput.accept(IcariaItems.DEAD_DRY_VINE.get());
			pOutput.accept(IcariaItems.GROWING_DRY_VINE.get());
			pOutput.accept(IcariaItems.DRY_VINE.get());

			pOutput.accept(IcariaItems.DEAD_REEDY_VINE.get());
			pOutput.accept(IcariaItems.GROWING_REEDY_VINE.get());
			pOutput.accept(IcariaItems.REEDY_VINE.get());

			pOutput.accept(IcariaItems.DEAD_SWIRLY_VINE.get());
			pOutput.accept(IcariaItems.GROWING_SWIRLY_VINE.get());
			pOutput.accept(IcariaItems.SWIRLY_VINE.get());

			pOutput.accept(IcariaItems.DEAD_THORNY_VINE.get());
			pOutput.accept(IcariaItems.GROWING_THORNY_VINE.get());
			pOutput.accept(IcariaItems.THORNY_VINE.get());

			pOutput.accept(IcariaItems.FERN.get());

			pOutput.accept(IcariaItems.SMALL_GRASS.get());
			pOutput.accept(IcariaItems.MEDIUM_GRASS.get());
			pOutput.accept(IcariaItems.LARGE_GRASS.get());

			pOutput.accept(IcariaItems.GRAIN_0.get());
			pOutput.accept(IcariaItems.GRAIN_1.get());
			pOutput.accept(IcariaItems.GRAIN_2.get());
			pOutput.accept(IcariaItems.GRAIN_3.get());
			pOutput.accept(IcariaItems.GRAIN_4.get());
			pOutput.accept(IcariaItems.GRAIN_5.get());

			pOutput.accept(IcariaItems.BLINDWEED.get());
			pOutput.accept(IcariaItems.CHAMEOMILE.get());
			pOutput.accept(IcariaItems.CHARMONDER.get());
			pOutput.accept(IcariaItems.CLOVER.get());
			pOutput.accept(IcariaItems.FIREHILT.get());
			pOutput.accept(IcariaItems.BLUE_HYDRACINTH.get());
			pOutput.accept(IcariaItems.PURPLE_HYDRACINTH.get());
			pOutput.accept(IcariaItems.LIONFANGS.get());
			pOutput.accept(IcariaItems.SPEARDROPS.get());
			pOutput.accept(IcariaItems.PURPLE_STAGHORN.get());
			pOutput.accept(IcariaItems.YELLOW_STAGHORN.get());
			pOutput.accept(IcariaItems.BLUE_STORMCOTTON.get());
			pOutput.accept(IcariaItems.PINK_STORMCOTTON.get());
			pOutput.accept(IcariaItems.PURPLE_STORMCOTTON.get());
			pOutput.accept(IcariaItems.SUNKETTLE.get());
			pOutput.accept(IcariaItems.SUNSPONGE.get());
			pOutput.accept(IcariaItems.VOIDLILY.get());

			pOutput.accept(IcariaItems.BOLBOS.get());
			pOutput.accept(IcariaItems.DATHULLA.get());
			pOutput.accept(IcariaItems.MONDANOS.get());
			pOutput.accept(IcariaItems.MOTH_AGARIC.get());
			pOutput.accept(IcariaItems.NAMDRAKE.get());
			pOutput.accept(IcariaItems.PSILOCYBOS.get());
			pOutput.accept(IcariaItems.ROWAN.get());

			pOutput.accept(IcariaItems.BLUE_GROUND_FLOWERS.get());
			pOutput.accept(IcariaItems.CYAN_GROUND_FLOWERS.get());
			pOutput.accept(IcariaItems.PINK_GROUND_FLOWERS.get());
			pOutput.accept(IcariaItems.PURPLE_GROUND_FLOWERS.get());
			pOutput.accept(IcariaItems.RED_GROUND_FLOWERS.get());
			pOutput.accept(IcariaItems.WHITE_GROUND_FLOWERS.get());

			pOutput.accept(IcariaItems.MOSS_0.get());
			pOutput.accept(IcariaItems.MOSS_1.get());
			pOutput.accept(IcariaItems.MOSS_2.get());

			pOutput.accept(IcariaItems.PALM_FERN.get());

			pOutput.accept(IcariaItems.WHITE_BROMELIA.get());
			pOutput.accept(IcariaItems.ORANGE_BROMELIA.get());
			pOutput.accept(IcariaItems.PINK_BROMELIA.get());
			pOutput.accept(IcariaItems.PURPLE_BROMELIA.get());

			pOutput.accept(IcariaItems.GREEN_GROUND_SHROOMS.get());
			pOutput.accept(IcariaItems.BROWN_GROUND_SHROOMS.get());
			pOutput.accept(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get());

			pOutput.accept(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get());
			pOutput.accept(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get());
			pOutput.accept(IcariaItems.UNNAMED_TREE_SHROOMS.get());

			pOutput.accept(IcariaItems.CARDON_CACTUS.get());

			pOutput.accept(IcariaItems.STRAWBERRY_BUSH.get());
		}));

		pEvent.registerCreativeModeTab(new ResourceLocation(IcariaInfo.ID, "items"), pBuilder -> pBuilder.title(Component.translatable("itemgroup." + IcariaInfo.ID + ".items")).icon(() -> new ItemStack(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get())).displayItems((pParameters, pOutput) -> {
			pOutput.accept(IcariaItems.BONE_REMAINS.get());
			pOutput.accept(IcariaItems.LOAM_LUMP.get());
			pOutput.accept(IcariaItems.LOAM_BRICK.get());
			pOutput.accept(IcariaItems.CHERT.get());
			pOutput.accept(IcariaItems.ENDER_JELLYFISH_JELLY.get());
			pOutput.accept(IcariaItems.FIRE_JELLYFISH_JELLY.get());
			pOutput.accept(IcariaItems.NATURE_JELLYFISH_JELLY.get());
			pOutput.accept(IcariaItems.VOID_JELLYFISH_JELLY.get());
			pOutput.accept(IcariaItems.WATER_JELLYFISH_JELLY.get());
			pOutput.accept(IcariaItems.ARACHNE_STRING.get());
			pOutput.accept(IcariaItems.SPELT.get());
			pOutput.accept(IcariaItems.VINE_REED.get());
			pOutput.accept(IcariaItems.VINE_SPROUT.get());
			pOutput.accept(IcariaItems.ROTTEN_BONES.get());
			pOutput.accept(IcariaItems.CALCITE.get());
			pOutput.accept(IcariaItems.HALITE.get());
			pOutput.accept(IcariaItems.JASPER.get());
			pOutput.accept(IcariaItems.ZIRCON.get());
			pOutput.accept(IcariaItems.CALCITE_DUST.get());
			pOutput.accept(IcariaItems.HALITE_DUST.get());
			pOutput.accept(IcariaItems.LIGNITE.get());
			pOutput.accept(IcariaItems.CHALKOS_RAW.get());
			pOutput.accept(IcariaItems.KASSITEROS_RAW.get());
			pOutput.accept(IcariaItems.DOLOMITE.get());
			pOutput.accept(IcariaItems.VANADIUM_RAW.get());
			pOutput.accept(IcariaItems.SLIVER.get());
			pOutput.accept(IcariaItems.SIDEROS_RAW.get());
			pOutput.accept(IcariaItems.ANTHRACITE.get());
			pOutput.accept(IcariaItems.MOLYBDENUM_RAW.get());

			pOutput.accept(IcariaItems.CHALKOS_NUGGET.get());
			pOutput.accept(IcariaItems.KASSITEROS_NUGGET.get());
			pOutput.accept(IcariaItems.ORICHALCUM_NUGGET.get());
			pOutput.accept(IcariaItems.VANADIUM_NUGGET.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_NUGGET.get());
			pOutput.accept(IcariaItems.SIDEROS_NUGGET.get());
			pOutput.accept(IcariaItems.MOLYBDENUM_NUGGET.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
			pOutput.accept(IcariaItems.BLURIDIUM_NUGGET.get());

			pOutput.accept(IcariaItems.CHALKOS_INGOT.get());
			pOutput.accept(IcariaItems.KASSITEROS_INGOT.get());
			pOutput.accept(IcariaItems.ORICHALCUM_INGOT.get());
			pOutput.accept(IcariaItems.VANADIUM_INGOT.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_INGOT.get());
			pOutput.accept(IcariaItems.SIDEROS_INGOT.get());
			pOutput.accept(IcariaItems.MOLYBDENUM_INGOT.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
			pOutput.accept(IcariaItems.BLURIDIUM_INGOT.get());

			pOutput.accept(IcariaItems.CHERT_TOOLS.sword.get());
			pOutput.accept(IcariaItems.CHERT_TOOLS.dagger.get());
			pOutput.accept(IcariaItems.CHERT_TOOLS.shovel.get());
			pOutput.accept(IcariaItems.CHERT_TOOLS.pickaxe.get());
			pOutput.accept(IcariaItems.CHERT_TOOLS.axe.get());
			pOutput.accept(IcariaItems.CHERT_TOOLS.scythe.get());
			pOutput.accept(IcariaItems.CHERT_TOOLS.bident.get());
			pOutput.accept(IcariaItems.CHALKOS_TOOLS.sword.get());
			pOutput.accept(IcariaItems.CHALKOS_TOOLS.dagger.get());
			pOutput.accept(IcariaItems.CHALKOS_TOOLS.shovel.get());
			pOutput.accept(IcariaItems.CHALKOS_TOOLS.pickaxe.get());
			pOutput.accept(IcariaItems.CHALKOS_TOOLS.axe.get());
			pOutput.accept(IcariaItems.CHALKOS_TOOLS.scythe.get());
			pOutput.accept(IcariaItems.CHALKOS_TOOLS.bident.get());
			pOutput.accept(IcariaItems.KASSITEROS_TOOLS.sword.get());
			pOutput.accept(IcariaItems.KASSITEROS_TOOLS.dagger.get());
			pOutput.accept(IcariaItems.KASSITEROS_TOOLS.shovel.get());
			pOutput.accept(IcariaItems.KASSITEROS_TOOLS.pickaxe.get());
			pOutput.accept(IcariaItems.KASSITEROS_TOOLS.axe.get());
			pOutput.accept(IcariaItems.KASSITEROS_TOOLS.scythe.get());
			pOutput.accept(IcariaItems.KASSITEROS_TOOLS.bident.get());
			pOutput.accept(IcariaItems.ORICHALCUM_TOOLS.sword.get());
			pOutput.accept(IcariaItems.ORICHALCUM_TOOLS.dagger.get());
			pOutput.accept(IcariaItems.ORICHALCUM_TOOLS.shovel.get());
			pOutput.accept(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get());
			pOutput.accept(IcariaItems.ORICHALCUM_TOOLS.axe.get());
			pOutput.accept(IcariaItems.ORICHALCUM_TOOLS.scythe.get());
			pOutput.accept(IcariaItems.ORICHALCUM_TOOLS.bident.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_TOOLS.sword.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_TOOLS.axe.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get());
			pOutput.accept(IcariaItems.SIDEROS_TOOLS.sword.get());
			pOutput.accept(IcariaItems.SIDEROS_TOOLS.dagger.get());
			pOutput.accept(IcariaItems.SIDEROS_TOOLS.shovel.get());
			pOutput.accept(IcariaItems.SIDEROS_TOOLS.pickaxe.get());
			pOutput.accept(IcariaItems.SIDEROS_TOOLS.axe.get());
			pOutput.accept(IcariaItems.SIDEROS_TOOLS.scythe.get());
			pOutput.accept(IcariaItems.SIDEROS_TOOLS.bident.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get());
			pOutput.accept(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());

			pOutput.accept(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get());
			pOutput.accept(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get());
			pOutput.accept(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get());
			pOutput.accept(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get());
			pOutput.accept(IcariaItems.CHALKOS_ARMOR.helmet.get());
			pOutput.accept(IcariaItems.CHALKOS_ARMOR.chestplate.get());
			pOutput.accept(IcariaItems.CHALKOS_ARMOR.leggings.get());
			pOutput.accept(IcariaItems.CHALKOS_ARMOR.boots.get());
			pOutput.accept(IcariaItems.KASSITEROS_ARMOR.helmet.get());
			pOutput.accept(IcariaItems.KASSITEROS_ARMOR.chestplate.get());
			pOutput.accept(IcariaItems.KASSITEROS_ARMOR.leggings.get());
			pOutput.accept(IcariaItems.KASSITEROS_ARMOR.boots.get());
			pOutput.accept(IcariaItems.ORICHALCUM_HELMET.get());
			pOutput.accept(IcariaItems.ORICHALCUM_CHESTPLATE.get());
			pOutput.accept(IcariaItems.ORICHALCUM_LEGGINGS.get());
			pOutput.accept(IcariaItems.ORICHALCUM_BOOTS.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get());
			pOutput.accept(IcariaItems.VANADIUMSTEEL_ARMOR.boots.get());
			pOutput.accept(IcariaItems.LAUREL_WREATH.get());

			pOutput.accept(IcariaItems.GREEK_FIRE_GRENADE.get());

			pOutput.accept(IcariaItems.TOTEM_OF_PREVENTATION.get());
			pOutput.accept(IcariaItems.TOTEM_OF_STUFFING.get());
			pOutput.accept(IcariaItems.TOTEM_OF_UNBLINDING.get());
			pOutput.accept(IcariaItems.TOTEM_OF_UNDROWNING.get());
			pOutput.accept(IcariaItems.TOTEM_OF_UNDYING.get());
			pOutput.accept(IcariaItems.TOTEM_OF_UNSHATTERING.get());
			pOutput.accept(IcariaItems.TOTEM_OF_UNSINKING.get());

			pOutput.accept(IcariaItems.UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.RED_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.LIME_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get());
			pOutput.accept(IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());

			pOutput.accept(IcariaItems.FLASK_EMPTY.get());

			pOutput.accept(IcariaItems.VIAL_EMPTY.get());
			pOutput.accept(IcariaItems.VIAL_HYLIASTRUM.get());

			pOutput.accept(IcariaItems.GEAR_YELLOWSTONE.get());
			pOutput.accept(IcariaItems.GEAR_LOAM_UNFIRED.get());
			pOutput.accept(IcariaItems.GEAR_LOAM.get());
			pOutput.accept(IcariaItems.GEAR_VOIDSHALE.get());
			pOutput.accept(IcariaItems.GEAR_VANADIUM.get());
			pOutput.accept(IcariaItems.GEARFRAGMENT_BLUE.get());
			pOutput.accept(IcariaItems.GEARFRAGMENT_GREEN.get());
			pOutput.accept(IcariaItems.GEARFRAGMENT_YELLOW.get());
			pOutput.accept(IcariaItems.GEAR_DAEDALIAN.get());

			pOutput.accept(IcariaItems.AETERNAE_HIDE.get());
			pOutput.accept(IcariaItems.SPELT_FLOUR.get());
			pOutput.accept(IcariaItems.SPELT_BREAD.get());
			pOutput.accept(IcariaItems.VINEBERRIES.get());
			pOutput.accept(IcariaItems.STRAWBERRIES.get());
			pOutput.accept(IcariaItems.PHYSALIS.get());
			pOutput.accept(IcariaItems.LAUREL_CHERRY.get());
			pOutput.accept(IcariaItems.OLIVES_BLACK.get());
			pOutput.accept(IcariaItems.OLIVES_GREEN.get());
			pOutput.accept(IcariaItems.GARLIC.get());
			pOutput.accept(IcariaItems.ONION.get());
			pOutput.accept(IcariaItems.RAW_AETERNAE_MEAT.get());
			pOutput.accept(IcariaItems.COOKED_AETERNAE_MEAT.get());
			pOutput.accept(IcariaItems.RAW_CATOBLEPAS_MEAT.get());
			pOutput.accept(IcariaItems.COOKED_CATOBLEPAS_MEAT.get());
			pOutput.accept(IcariaItems.RAW_CERVER_MEAT.get());
			pOutput.accept(IcariaItems.COOKED_CERVER_MEAT.get());
			pOutput.accept(IcariaItems.RAW_SOW_MEAT.get());
			pOutput.accept(IcariaItems.COOKED_SOW_MEAT.get());
			pOutput.accept(IcariaItems.MYRMEKE_SCALES.get());
			pOutput.accept(IcariaItems.SLUG_SCALES.get());
			pOutput.accept(IcariaItems.SNULL_CREAM.get());

			pOutput.accept(IcariaItems.LOAM_BOWL_UNFIRED.get());
			pOutput.accept(IcariaItems.LOAM_BOWL.get());
			pOutput.accept(IcariaItems.SALAD_FRUIT.get());
			pOutput.accept(IcariaItems.SOUP_ONION.get());
			pOutput.accept(IcariaItems.STEW_AETERNAE.get());
			pOutput.accept(IcariaItems.STEW_CATOBLEPAS.get());
			pOutput.accept(IcariaItems.STEW_CERVER.get());
			pOutput.accept(IcariaItems.STEW_SOW.get());

			pOutput.accept(IcariaItems.SPELT_SEEDS.get());
			pOutput.accept(IcariaItems.STRAWBERRY_SEEDS.get());
			pOutput.accept(IcariaItems.PHYSALIS_SEEDS.get());

			pOutput.accept(IcariaItems.AETERNAE_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.ARACHNE_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.ARACHNE_DRONE_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.ARGAN_HOUND_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.CATOBLEPAS_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.CERVER_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.CYPRESS_FOREST_HAG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.DROUGHTROOT_FOREST_HAG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.FIR_FOREST_HAG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.LAUREL_FOREST_HAG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.OLIVE_FOREST_HAG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.PLANE_FOREST_HAG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.POPULUS_FOREST_HAG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.HYLIASTER_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.ENDER_JELLYFISH_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.FIRE_JELLYFISH_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.NATURE_JELLYFISH_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.VOID_JELLYFISH_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.WATER_JELLYFISH_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.MYRMEKE_DRONE_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.MYRMEKE_SOLDIER_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.MYRMEKE_QUEEN_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.CAPTAIN_REVENANT_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.CIVILIAN_REVENANT_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.CRAWLER_REVENANT_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.OVERGROWN_REVENANT_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.PYROMANCER_REVENANT_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.NETHER_PYROMANCER_REVENANT_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.SOLDIER_REVENANT_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.SCORPION_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.CRYSTAL_SLUG_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.FOREST_SNULL_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.SNULL_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.SOLIFUGAE_SPAWN_EGG.get());
			pOutput.accept(IcariaItems.SOW_SPAWN_EGG.get());

			pOutput.accept(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());
		}));
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

		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenuTypes.GRINDER.get(), GrinderScreen::new));
		pEvent.enqueueWork(() -> MenuScreens.register(IcariaMenuTypes.STORAGE_VASE.get(), StorageVaseScreen::new));

		ItemProperties.register(IcariaItems.GREEK_FIRE_GRENADE.get(), new ResourceLocation(IcariaInfo.ID, "throwing"), (pStack, pLevel, pEntity, pId) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);

		for (IcariaItems.ToolSet tools : IcariaItems.TOOLS) {
			ItemProperties.register(tools.bident.get(), new ResourceLocation(IcariaInfo.ID, "throwing"), (pStack, pLevel, pEntity, pId) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
		}
	}

	@Override
	public void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		super.onFMLCommonSetup(pEvent);
	}

	@Override
	public void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
		// BLOCK COLOR
		this.blockColor(IcariaBlocks.MARL_GRASS.get());
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
		this.blockColor(IcariaBlocks.GRAIN_0.get());
		this.blockColor(IcariaBlocks.GRAIN_1.get());
		this.blockColor(IcariaBlocks.GRAIN_2.get());
		this.blockColor(IcariaBlocks.GRAIN_3.get());
		this.blockColor(IcariaBlocks.GRAIN_4.get());
		this.blockColor(IcariaBlocks.GRAIN_5.get());
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
		this.blockColor(IcariaBlocks.WHITE_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		this.blockColor(IcariaBlocks.ORANGE_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		this.blockColor(IcariaBlocks.PINK_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		this.blockColor(IcariaBlocks.PURPLE_BROMELIA.get());
		this.blockColor(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());

		// ITEM COLOR
		this.itemColor(IcariaItems.MARL_GRASS.get());
		this.itemColor(IcariaItems.WHITE_BROMELIA.get());
		this.itemColor(IcariaItems.ORANGE_BROMELIA.get());
		this.itemColor(IcariaItems.PINK_BROMELIA.get());
		this.itemColor(IcariaItems.PURPLE_BROMELIA.get());

		// RENDER CUTOUT
		this.renderCutout(IcariaBlocks.MARL_GRASS.get());
		this.renderCutout(IcariaBlocks.GRAINGLASS.get());
		this.renderCutout(IcariaBlocks.GRAINGLASS_PANE.get());
		this.renderCutout(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get());
		this.renderCutout(IcariaBlocks.SILKGLASS.get());
		this.renderCutout(IcariaBlocks.SILKGLASS_PANE.get());
		this.renderCutout(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());
		this.renderCutout(IcariaBlocks.PLATOSHALE_BLURRED.get());
		this.renderCutout(IcariaBlocks.PLATOSHALE_BRICKS_BLURRED.get());
		this.renderCutout(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		this.renderCutout(IcariaBlocks.VANADIUMSTEEL_BARS_HORIZONTAL.get());
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
		this.renderCutout(IcariaBlocks.GRAIN_0.get());
		this.renderCutout(IcariaBlocks.GRAIN_1.get());
		this.renderCutout(IcariaBlocks.GRAIN_2.get());
		this.renderCutout(IcariaBlocks.GRAIN_3.get());
		this.renderCutout(IcariaBlocks.GRAIN_4.get());
		this.renderCutout(IcariaBlocks.GRAIN_5.get());
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
		this.renderTranslucent(IcariaBlocks.ICARIA_PORTAL.get());
		this.renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER_SOURCE.get());
		this.renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER_FLOWING.get());

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

		// BLOCK ENTITY RENDERERS
		BlockEntityRenderers.register(IcariaBlockEntityTypes.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SIGN.get(), IcariaSignBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SKULL.get(), IcariaSkullBlockRenderer::new);
	}

	@Override
	public void onGatherData(GatherDataEvent pEvent) {
		var generator = pEvent.getGenerator();
		var helper = pEvent.getExistingFileHelper();
		var output = generator.getPackOutput();
		var provider = pEvent.getLookupProvider();

		IcariaBlockTags blockTags = new IcariaBlockTags(output, provider, IcariaInfo.ID, helper);

		generator.addProvider(pEvent.includeClient(), new IcariaEnglish(output, IcariaInfo.ID, "en_us"));
		generator.addProvider(pEvent.includeClient(), new IcariaGerman(output, IcariaInfo.ID, "de_de"));
		generator.addProvider(pEvent.includeClient(), new IcariaBlockStates(output, IcariaInfo.ID, helper));
		generator.addProvider(pEvent.includeClient(), new IcariaItemModels(output, IcariaInfo.ID, helper));

		generator.addProvider(pEvent.includeServer(), new IcariaLoot(output));
		generator.addProvider(pEvent.includeServer(), blockTags);
		generator.addProvider(pEvent.includeServer(), new IcariaFluidTags(output, provider, IcariaInfo.ID, helper));
		generator.addProvider(pEvent.includeServer(), new IcariaItemTags(output, provider, blockTags.contentsGetter(), IcariaInfo.ID, helper));
		generator.addProvider(pEvent.includeServer(), new IcariaRecipes(output));
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
	}

	@Override
	public void onEntityAttributeModification(EntityAttributeModificationEvent pEvent) {
		super.onEntityAttributeModification(pEvent);
	}

	@Override
	public void onLivingAttack(LivingAttackEvent pEvent) {
		float damage = pEvent.getAmount();
		Entity entity = pEvent.getEntity();
		if (entity instanceof Player player) {
			float health = player.getHealth();
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_STUFFING.get();
			if (player.getFoodData().getFoodLevel() <= 0) {
				if (offHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (entity instanceof Player player) {
			float health = player.getHealth();
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNDROWNING.get();
			if (player.getAirSupply() <= 0) {
				if (offHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (entity instanceof Player player) {
			float health = player.getHealth();
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNDYING.get();
			if (damage >= health) {
				if (offHand.getItem().equals(totem)) {
					pEvent.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					pEvent.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		DamageSource source = pEvent.getSource();
		Entity entitySource = source.getEntity();
		if (entitySource instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof TieredItem || mainHand.getItem() instanceof TridentItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}

		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			for (int slot = 5; slot < 9; slot++) {
				ItemStack armor = player.inventoryMenu.slots.get(slot).getItem();
				if (armor.getItem() instanceof ArmorItem) {
					if (armor.getDamageValue() >= (armor.getMaxDamage() * 0.9)) {
						if (offHand.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}

						if (mainHand.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}
					}
				}
			}
		}

		if (entity instanceof Player player) {
			float health = player.getHealth();
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSINKING.get();
			if (player.position().y <= -64) {
				if (offHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (entitySource instanceof Player player) {
			if (player.hasEffect(IcariaMobEffects.LIFESTEAL.get())) {
				player.heal(damage);
			}
		}
	}

	@Override
	public void onMobEffectApplicable(MobEffectEvent.Applicable pEvent) {
		Entity entity = pEvent.getEntity();
		MobEffectInstance effect = pEvent.getEffectInstance();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNBLINDING.get();
			if (effect.getEffect().equals(MobEffects.BLINDNESS)) {
				if (offHand.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent pEvent) {
		Entity entity = pEvent.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof FishingRodItem || mainHand.getItem() instanceof BowItem || mainHand.getItem() instanceof CrossbowItem || mainHand.getItem() instanceof ShieldItem || mainHand.getItem() instanceof TridentItem || mainHand.getItem() instanceof BidentItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offHand.getItem() instanceof FishingRodItem || offHand.getItem() instanceof BowItem || offHand.getItem() instanceof CrossbowItem || offHand.getItem() instanceof ShieldItem || offHand.getItem() instanceof TridentItem || offHand.getItem() instanceof BidentItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onEntityInteract(PlayerInteractEvent.EntityInteract pEvent) {
		Entity entity = pEvent.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof ShearsItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offHand.getItem() instanceof ShearsItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock pEvent) {
		Entity entity = pEvent.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof TieredItem || mainHand.getItem() instanceof ShearsItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock pEvent) {
		Entity entity = pEvent.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof AxeItem || mainHand.getItem() instanceof HoeItem || mainHand.getItem() instanceof ShovelItem || mainHand.getItem() instanceof FlintAndSteelItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offHand.getItem() instanceof AxeItem || offHand.getItem() instanceof HoeItem || offHand.getItem() instanceof ShovelItem || offHand.getItem() instanceof FlintAndSteelItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
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
			for (ItemStack itemStack : pEvent.getEntity().getArmorSlots()) {
				if (itemStack.getItem() instanceof IcariaSkullItem) {
					((PlayerModel<?>) pEvent.getRenderer().getModel()).hat.visible = false;
					((PlayerModel<?>) pEvent.getRenderer().getModel()).head.visible = false;
					return;
				}
			}
		}
	}

	public void blockColor(Block pBlock) {
		Minecraft minecraft = Minecraft.getInstance();
		BlockColors blockColors = minecraft.getBlockColors();
		blockColors.register((pState, pLevel, pPos, pIndex) -> GrassColor.get(0.6D, 0.1D), pBlock);
	}

	public void itemColor(Item pItem) {
		Minecraft minecraft = Minecraft.getInstance();
		ItemColors itemColors = minecraft.getItemColors();
		itemColors.register((pStack, pIndex) -> GrassColor.get(0.6D, 0.1D), pItem);
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
