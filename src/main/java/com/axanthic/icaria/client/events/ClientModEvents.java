package com.axanthic.icaria.client.events;

import com.axanthic.icaria.client.effects.IcariaSpecialEffects;
import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.renderer.*;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaColors;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation, unused")

@ParametersAreNonnullByDefault

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = IcariaInfo.ID, value = Dist.CLIENT)
public class ClientModEvents {

	@SubscribeEvent
	public static void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
		ClientModEvents.grassColor(IcariaBlocks.GRASSY_MARL.get());
		ClientModEvents.grassColor(IcariaBlocks.BLOOMY_VINE.get());
		ClientModEvents.grassColor(IcariaBlocks.BRANCHY_VINE.get());
		ClientModEvents.grassColor(IcariaBlocks.BRUSHY_VINE.get());
		ClientModEvents.grassColor(IcariaBlocks.DRY_VINE.get());
		ClientModEvents.grassColor(IcariaBlocks.REEDY_VINE.get());
		ClientModEvents.grassColor(IcariaBlocks.SWIRLY_VINE.get());
		ClientModEvents.grassColor(IcariaBlocks.THORNY_VINE.get());
		ClientModEvents.grassColor(IcariaBlocks.FERN.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_FERN.get());
		ClientModEvents.grassColor(IcariaBlocks.SMALL_GRASS.get());
		ClientModEvents.grassColor(IcariaBlocks.MEDIUM_GRASS.get());
		ClientModEvents.grassColor(IcariaBlocks.LARGE_GRASS.get());
		ClientModEvents.grassColor(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		ClientModEvents.grassColor(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		ClientModEvents.grassColor(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		ClientModEvents.grassColor(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		ClientModEvents.grassColor(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		ClientModEvents.grassColor(IcariaBlocks.LARGE_BROWN_GRAIN.get());
		ClientModEvents.grassColor(IcariaBlocks.BLINDWEED.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_BLINDWEED.get());
		ClientModEvents.grassColor(IcariaBlocks.CHAMEOMILE.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_CHAMEOMILE.get());
		ClientModEvents.grassColor(IcariaBlocks.CHARMONDER.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_CHARMONDER.get());
		ClientModEvents.grassColor(IcariaBlocks.CLOVER.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_CLOVER.get());
		ClientModEvents.grassColor(IcariaBlocks.FIREHILT.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_FIREHILT.get());
		ClientModEvents.grassColor(IcariaBlocks.BLUE_HYDRACINTH.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		ClientModEvents.grassColor(IcariaBlocks.PURPLE_HYDRACINTH.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		ClientModEvents.grassColor(IcariaBlocks.LIONFANGS.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_LIONFANGS.get());
		ClientModEvents.grassColor(IcariaBlocks.SPEARDROPS.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_SPEARDROPS.get());
		ClientModEvents.grassColor(IcariaBlocks.PURPLE_STAGHORN.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		ClientModEvents.grassColor(IcariaBlocks.YELLOW_STAGHORN.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		ClientModEvents.grassColor(IcariaBlocks.BLUE_STORMCOTTON.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		ClientModEvents.grassColor(IcariaBlocks.PINK_STORMCOTTON.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		ClientModEvents.grassColor(IcariaBlocks.PURPLE_STORMCOTTON.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		ClientModEvents.grassColor(IcariaBlocks.SUNKETTLE.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_SUNKETTLE.get());
		ClientModEvents.grassColor(IcariaBlocks.SUNSPONGE.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_SUNSPONGE.get());
		ClientModEvents.grassColor(IcariaBlocks.VOIDLILY.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_VOIDLILY.get());
		ClientModEvents.grassColor(IcariaBlocks.PALM_FERN.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_PALM_FERN.get());
		ClientModEvents.grassColor(IcariaBlocks.WHITE_BROMELIA.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		ClientModEvents.grassColor(IcariaBlocks.ORANGE_BROMELIA.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		ClientModEvents.grassColor(IcariaBlocks.PINK_BROMELIA.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		ClientModEvents.grassColor(IcariaBlocks.PURPLE_BROMELIA.get());
		ClientModEvents.grassColor(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());

		ClientModEvents.waterColor(IcariaBlocks.CYPRESS_TROUGH.get());
		ClientModEvents.waterColor(IcariaBlocks.DROUGHTROOT_TROUGH.get());
		ClientModEvents.waterColor(IcariaBlocks.FIR_TROUGH.get());
		ClientModEvents.waterColor(IcariaBlocks.LAUREL_TROUGH.get());
		ClientModEvents.waterColor(IcariaBlocks.OLIVE_TROUGH.get());
		ClientModEvents.waterColor(IcariaBlocks.PLANE_TROUGH.get());
		ClientModEvents.waterColor(IcariaBlocks.POPULUS_TROUGH.get());

		ClientModEvents.itemColor(IcariaItems.GRASSY_MARL.get());
		ClientModEvents.itemColor(IcariaItems.PALM_FERN.get());
		ClientModEvents.itemColor(IcariaItems.WHITE_BROMELIA.get());
		ClientModEvents.itemColor(IcariaItems.ORANGE_BROMELIA.get());
		ClientModEvents.itemColor(IcariaItems.PINK_BROMELIA.get());
		ClientModEvents.itemColor(IcariaItems.PURPLE_BROMELIA.get());

		ClientModEvents.renderCutout(IcariaBlocks.GRASSY_MARL.get());
		ClientModEvents.renderCutout(IcariaBlocks.GRAINGLASS.get());
		ClientModEvents.renderCutout(IcariaBlocks.GRAINGLASS_PANE.get());
		ClientModEvents.renderCutout(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get());
		ClientModEvents.renderCutout(IcariaBlocks.SILKGLASS.get());
		ClientModEvents.renderCutout(IcariaBlocks.SILKGLASS_PANE.get());
		ClientModEvents.renderCutout(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get());
		ClientModEvents.renderCutout(IcariaBlocks.BLURRED_PLATOSHALE.get());
		ClientModEvents.renderCutout(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get());
		ClientModEvents.renderCutout(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		ClientModEvents.renderCutout(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get());
		ClientModEvents.renderCutout(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());
		ClientModEvents.renderCutout(IcariaBlocks.ARACHNE_SPAWNER.get());
		ClientModEvents.renderCutout(IcariaBlocks.REVENANT_SPAWNER.get());
		ClientModEvents.renderCutout(IcariaBlocks.CYPRESS_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		ClientModEvents.renderCutout(IcariaBlocks.SIMPLE_CYPRESS_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.CYPRESS_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.CYPRESS_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.LOADED_CYPRESS_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TAPPED_CYPRESS_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.CYPRESS_DOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.CYPRESS_LADDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		ClientModEvents.renderCutout(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.DROUGHTROOT_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.DROUGHTROOT_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.DROUGHTROOT_DOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.DROUGHTROOT_LADDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.FIR_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_FIR_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		ClientModEvents.renderCutout(IcariaBlocks.SIMPLE_FIR_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.FIR_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.FIR_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.LOADED_FIR_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TAPPED_FIR_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.FIR_DOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.FIR_TRAPDOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.FIR_LADDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.LAUREL_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		ClientModEvents.renderCutout(IcariaBlocks.SIMPLE_LAUREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.LAUREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.LAUREL_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.LOADED_LAUREL_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TAPPED_LAUREL_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.LAUREL_DOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.LAUREL_TRAPDOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.LAUREL_LADDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.OLIVE_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		ClientModEvents.renderCutout(IcariaBlocks.SIMPLE_OLIVE_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.OLIVE_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.OLIVE_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.LOADED_OLIVE_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TAPPED_OLIVE_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.OLIVE_DOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.OLIVE_TRAPDOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.OLIVE_LADDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.PLANE_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PLANE_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		ClientModEvents.renderCutout(IcariaBlocks.SIMPLE_PLANE_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.PLANE_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.PLANE_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.LOADED_PLANE_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TAPPED_PLANE_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.PLANE_DOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.PLANE_TRAPDOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.PLANE_LADDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.POPULUS_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_POPULUS_SAPLING.get());
		ClientModEvents.renderCutout(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		ClientModEvents.renderCutout(IcariaBlocks.SIMPLE_POPULUS_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.POPULUS_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.POPULUS_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.LOADED_POPULUS_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TAPPED_POPULUS_BARREL.get());
		ClientModEvents.renderCutout(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get());
		ClientModEvents.renderCutout(IcariaBlocks.POPULUS_DOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.POPULUS_TRAPDOOR.get());
		ClientModEvents.renderCutout(IcariaBlocks.POPULUS_LADDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.BLOOMY_VINE.get());
		ClientModEvents.renderCutout(IcariaBlocks.BRANCHY_VINE.get());
		ClientModEvents.renderCutout(IcariaBlocks.BRUSHY_VINE.get());
		ClientModEvents.renderCutout(IcariaBlocks.DRY_VINE.get());
		ClientModEvents.renderCutout(IcariaBlocks.REEDY_VINE.get());
		ClientModEvents.renderCutout(IcariaBlocks.SWIRLY_VINE.get());
		ClientModEvents.renderCutout(IcariaBlocks.THORNY_VINE.get());
		ClientModEvents.renderCutout(IcariaBlocks.FERN.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_FERN.get());
		ClientModEvents.renderCutout(IcariaBlocks.SMALL_GRASS.get());
		ClientModEvents.renderCutout(IcariaBlocks.MEDIUM_GRASS.get());
		ClientModEvents.renderCutout(IcariaBlocks.LARGE_GRASS.get());
		ClientModEvents.renderCutout(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		ClientModEvents.renderCutout(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		ClientModEvents.renderCutout(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		ClientModEvents.renderCutout(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		ClientModEvents.renderCutout(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		ClientModEvents.renderCutout(IcariaBlocks.LARGE_BROWN_GRAIN.get());
		ClientModEvents.renderCutout(IcariaBlocks.BLINDWEED.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_BLINDWEED.get());
		ClientModEvents.renderCutout(IcariaBlocks.CHAMEOMILE.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_CHAMEOMILE.get());
		ClientModEvents.renderCutout(IcariaBlocks.CHARMONDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_CHARMONDER.get());
		ClientModEvents.renderCutout(IcariaBlocks.CLOVER.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_CLOVER.get());
		ClientModEvents.renderCutout(IcariaBlocks.FIREHILT.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_FIREHILT.get());
		ClientModEvents.renderCutout(IcariaBlocks.BLUE_HYDRACINTH.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		ClientModEvents.renderCutout(IcariaBlocks.PURPLE_HYDRACINTH.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		ClientModEvents.renderCutout(IcariaBlocks.LIONFANGS.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_LIONFANGS.get());
		ClientModEvents.renderCutout(IcariaBlocks.SPEARDROPS.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_SPEARDROPS.get());
		ClientModEvents.renderCutout(IcariaBlocks.PURPLE_STAGHORN.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		ClientModEvents.renderCutout(IcariaBlocks.YELLOW_STAGHORN.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		ClientModEvents.renderCutout(IcariaBlocks.BLUE_STORMCOTTON.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		ClientModEvents.renderCutout(IcariaBlocks.PINK_STORMCOTTON.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		ClientModEvents.renderCutout(IcariaBlocks.PURPLE_STORMCOTTON.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		ClientModEvents.renderCutout(IcariaBlocks.SUNKETTLE.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_SUNKETTLE.get());
		ClientModEvents.renderCutout(IcariaBlocks.SUNSPONGE.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_SUNSPONGE.get());
		ClientModEvents.renderCutout(IcariaBlocks.VOIDLILY.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_VOIDLILY.get());
		ClientModEvents.renderCutout(IcariaBlocks.PSILOCYBOS.get());
		ClientModEvents.renderCutout(IcariaBlocks.ROWAN.get());
		ClientModEvents.renderCutout(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		ClientModEvents.renderCutout(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		ClientModEvents.renderCutout(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		ClientModEvents.renderCutout(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		ClientModEvents.renderCutout(IcariaBlocks.RED_GROUND_FLOWERS.get());
		ClientModEvents.renderCutout(IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		ClientModEvents.renderCutout(IcariaBlocks.PALM_FERN.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PALM_FERN.get());
		ClientModEvents.renderCutout(IcariaBlocks.WHITE_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.ORANGE_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.PINK_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.PURPLE_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
		ClientModEvents.renderCutout(IcariaBlocks.STRAWBERRY_BUSH.get());
		ClientModEvents.renderCutout(IcariaBlocks.SPELT_CROP.get());
		ClientModEvents.renderCutout(IcariaBlocks.STRAWBERRY_CROP.get());
		ClientModEvents.renderCutout(IcariaBlocks.PHYSALIS_CROP.get());
		ClientModEvents.renderCutout(IcariaBlocks.ONION_CROP.get());
		ClientModEvents.renderCutout(IcariaBlocks.GREEK_FIRE.get());

		ClientModEvents.renderTranslucent(IcariaBlocks.ARISTONE.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.CALCITE_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.HALITE_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.ZIRCON_BLOCK.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.CYPRESS_TROUGH.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.DROUGHTROOT_TROUGH.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.FIR_TROUGH.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.LAUREL_TROUGH.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.OLIVE_TROUGH.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.PLANE_TROUGH.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.POPULUS_TROUGH.get());
		ClientModEvents.renderTranslucent(IcariaBlocks.ICARIA_PORTAL.get());
		ClientModEvents.renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER.get());
		ClientModEvents.renderTranslucent(IcariaFluids.FLOWING_MEDITERRANEAN_WATER.get());

		EntityRenderers.register(IcariaEntityTypes.AETERNAE.get(), AeternaeRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE.get(), ArachneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE_DRONE.get(), ArachneDroneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARGAN_HOUND.get(), ArganHoundRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BARREL.get(), IcariaBarrelRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BIDENT.get(), BidentRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CATOBLEPAS.get(), CatoblepasRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CERVER.get(), CerverRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
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
		EntityRenderers.register(IcariaEntityTypes.ANTI_GRAVITY_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FORTIFYING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.HEALING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BUBBLE_SPELL.get(), BubbleSpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FREEZING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.MAGIC_MISSILE_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAR.get(), VinegarRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAROON.get(), VinegaroonRenderer::new);

		BlockEntityRenderers.register(IcariaBlockEntityTypes.CHEST.get(), IcariaChestBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.FORGE.get(), ForgeBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.HANGING_SIGN.get(), HangingSignRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.KETTLE.get(), KettleBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.KILN.get(), KilnBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SIGN.get(), IcariaSignBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SKULL.get(), IcariaSkullBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SPAWNER.get(), IcariaSpawnerBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.TRAPPED_CHEST.get(), IcariaChestBlockRenderer::new);
	}

	@SubscribeEvent
	public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
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

	@SubscribeEvent
	public static void onRegisterDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent pEvent) {
		pEvent.register(IcariaResourceLocations.ICARIA, new IcariaSpecialEffects());
	}

	public static void grassColor(Block pBlock) {
		Minecraft.getInstance().getBlockColors().register((pBlockState, pLevel, pBlockPos, pIndex) -> BiomeColors.getAverageGrassColor(pLevel, pBlockPos), pBlock);
	}

	public static void waterColor(Block pBlock) {
		Minecraft.getInstance().getBlockColors().register((pBlockState, pLevel, pBlockPos, pIndex) -> BiomeColors.getAverageWaterColor(pLevel, pBlockPos), pBlock);
	}

	public static void itemColor(Item pItem) {
		Minecraft.getInstance().getItemColors().register((pItemStack, pIndex) -> IcariaColors.ITEM, pItem);
	}

	public static void renderCutout(Block pBlock) {
		ItemBlockRenderTypes.setRenderLayer(pBlock, RenderType.cutout());
	}

	public static void renderTranslucent(Block pBlock) {
		ItemBlockRenderTypes.setRenderLayer(pBlock, RenderType.translucent());
	}

	public static void renderTranslucent(Fluid pFluid) {
		ItemBlockRenderTypes.setRenderLayer(pFluid, RenderType.translucent());
	}
}
