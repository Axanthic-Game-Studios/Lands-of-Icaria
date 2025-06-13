package com.axanthic.icaria.client.events;

import com.axanthic.icaria.client.effects.IcariaDimensionSpecialEffects;
import com.axanthic.icaria.client.extensions.ClientBlockExtensions;
import com.axanthic.icaria.client.extensions.MediterraneanWaterClientFluidTypeExtensions;
import com.axanthic.icaria.client.extensions.OrichalcumHelmetClientItemExtensions;
import com.axanthic.icaria.client.layer.LootVaseLayer;
import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.particle.provider.IcariaBubbleParticleProvider;
import com.axanthic.icaria.client.particle.provider.IcariaPortalParticleProvider;
import com.axanthic.icaria.client.particle.provider.IcariaSteamParticleProvider;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.registry.IcariaRenderPipelines;
import com.axanthic.icaria.client.renderer.*;
import com.axanthic.icaria.client.screen.ForgeScreen;
import com.axanthic.icaria.client.screen.GrinderScreen;
import com.axanthic.icaria.client.screen.KilnScreen;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.client.special.unbaked.UnbakedScrollItemSpecialModelRenderer;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = IcariaIdents.ID, value = Dist.CLIENT)
public class IcariaClientModEvents {

	@SubscribeEvent
	public static void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
		IcariaClientModEvents.blockEntityRenderers();
		IcariaClientModEvents.entityRenderers();
		IcariaClientModEvents.itemBlockRenderTypes();
	}

	@SubscribeEvent
	public static void onAddLayers(EntityRenderersEvent.AddLayers pEvent) {
		for (var model : pEvent.getSkins()) {
			if (pEvent.getSkin(model) instanceof PlayerRenderer playerRenderer) {
				playerRenderer.addLayer(new LootVaseLayer(playerRenderer, pEvent.getContext()));
			}
		}
	}

	@SubscribeEvent
	public static void onCreateSkullModels(EntityRenderersEvent.CreateSkullModels pEvent) {
		pEvent.registerSkullModel(IcariaSkullBlockTypes.AETERNAE, IcariaModelLayerLocations.AETERNAE_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.ARGAN_HOUND, IcariaModelLayerLocations.ARGAN_HOUND_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.CAPELLA, IcariaModelLayerLocations.CAPELLA_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.CATOBLEPAS, IcariaModelLayerLocations.CATOBLEPAS_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.CERVER, IcariaModelLayerLocations.CERVER_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.CROCOTTA, IcariaModelLayerLocations.CROCOTTA_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, IcariaModelLayerLocations.CYPRESS_FOREST_HAG_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, IcariaModelLayerLocations.DROUGHTROOT_FOREST_HAG_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.FIR_FOREST_HAG, IcariaModelLayerLocations.FIR_FOREST_HAG_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.LAUREL_FOREST_HAG, IcariaModelLayerLocations.LAUREL_FOREST_HAG_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.OLIVE_FOREST_HAG, IcariaModelLayerLocations.OLIVE_FOREST_HAG_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.PLANE_FOREST_HAG, IcariaModelLayerLocations.PLANE_FOREST_HAG_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.POPULUS_FOREST_HAG, IcariaModelLayerLocations.POPULUS_FOREST_HAG_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.REVENANT, IcariaModelLayerLocations.REVENANT_SKULL);
		pEvent.registerSkullModel(IcariaSkullBlockTypes.THOG, IcariaModelLayerLocations.THOG_SKULL);
	}

	@SubscribeEvent
	public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.AETERNAE, AeternaeModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.AETERNAE_SKULL, AeternaeSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.ARACHNE, ArachneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.ARACHNE_DRONE, ArachneDroneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.ARGAN_HOUND, ArganHoundModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.ARGAN_HOUND_SKULL, ArganHoundSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CAPELLA, CapellaModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CAPELLA_SKULL, CapellaSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CATOBLEPAS, CatoblepasModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CATOBLEPAS_SKULL, CatoblepasSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CERVER, CerverModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CERVER_SKULL, CerverSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CROCOTTA, CrocottaModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CROCOTTA_SKULL, CrocottaSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CYPRESS_FOREST_HAG, CypressForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CYPRESS_FOREST_HAG_SKULL, CypressForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.DROUGHTROOT_FOREST_HAG, DroughtrootForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.DROUGHTROOT_FOREST_HAG_SKULL, DroughtrootForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FIR_FOREST_HAG, FirForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FIR_FOREST_HAG_SKULL, FirForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.LAUREL_FOREST_HAG, LaurelForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.LAUREL_FOREST_HAG_SKULL, LaurelForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.OLIVE_FOREST_HAG, OliveForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.OLIVE_FOREST_HAG_SKULL, OliveForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.PLANE_FOREST_HAG, PlaneForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.PLANE_FOREST_HAG_SKULL, PlaneForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.POPULUS_FOREST_HAG, PopulusForestHagModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.POPULUS_FOREST_HAG_SKULL, PopulusForestHagSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.HYLIASTER, HyliasterModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.ENDER_JELLYFISH, EnderJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FIRE_JELLYFISH, FireJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.NATURE_JELLYFISH, NatureJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.VOID_JELLYFISH, VoidJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.WATER_JELLYFISH, WaterJellyfishModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.MYRMEKE_DRONE, MyrmekeDroneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.MYRMEKE_SOLDIER, MyrmekeSoldierModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.MYRMEKE_QUEEN_BODY, MyrmekeQueenModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.MYRMEKE_QUEEN_RAYS, MyrmekeQueenModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.ORICHALCUM_HELMET, OrichalcumHelmetModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CAPTAIN_REVENANT_BODY, CaptainRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CAPTAIN_REVENANT_ITEM, CaptainRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CIVILIAN_REVENANT_BODY, CivilianRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CIVILIAN_REVENANT_ITEM, CivilianRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CRAWLER_REVENANT_BODY, CrawlerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CRAWLER_REVENANT_ITEM, CrawlerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.OVERGROWN_REVENANT_BODY, OvergrownRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.OVERGROWN_REVENANT_ITEM, OvergrownRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.OVERGROWN_REVENANT_RAYS, OvergrownRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.PYROMANCER_REVENANT_BODY, PyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.PYROMANCER_REVENANT_ITEM, PyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.NETHER_PYROMANCER_REVENANT_BODY, NetherPyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.NETHER_PYROMANCER_REVENANT_ITEM, NetherPyromancerRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.SOLDIER_REVENANT_BODY, SoldierRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.SOLDIER_REVENANT_ITEM, SoldierRevenantModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.REVENANT_SKULL, RevenantSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.SCORPION, ScorpionModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CRYSTAL_SLUG_BODY, CrystalSlugModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.CRYSTAL_SLUG_RAYS, CrystalSlugModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FOREST_SNULL, ForestSnullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.SNULL, SnullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.SOLIFUGAE, SolifugaeModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.THOG, ThogModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.THOG_SKULL, ThogSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.VINEGAROON, VinegaroonModel::createLayer);
	}

	@SubscribeEvent
	public static void onRegisterClientExtensions(RegisterClientExtensionsEvent pEvent) {
		pEvent.registerBlock(new ClientBlockExtensions(), IcariaBlocks.GRASSY_MARL.get(), IcariaBlocks.BLOOMY_VINE.get(), IcariaBlocks.BRANCHY_VINE.get(), IcariaBlocks.BRUSHY_VINE.get(), IcariaBlocks.REEDY_VINE.get(), IcariaBlocks.POTTED_FERN.get(), IcariaBlocks.POTTED_BLINDWEED.get(), IcariaBlocks.POTTED_CHAMEOMILE.get(), IcariaBlocks.POTTED_CHARMONDER.get(), IcariaBlocks.POTTED_CLOVER.get(), IcariaBlocks.POTTED_FIREHILT.get(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), IcariaBlocks.POTTED_LIONFANGS.get(), IcariaBlocks.POTTED_SPEARDROPS.get(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), IcariaBlocks.POTTED_SUNKETTLE.get(), IcariaBlocks.POTTED_SUNSPONGE.get(), IcariaBlocks.POTTED_VOIDLILY.get(), IcariaBlocks.BLUE_GROUND_FLOWERS.get(), IcariaBlocks.CYAN_GROUND_FLOWERS.get(), IcariaBlocks.PINK_GROUND_FLOWERS.get(), IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), IcariaBlocks.RED_GROUND_FLOWERS.get(), IcariaBlocks.WHITE_GROUND_FLOWERS.get(), IcariaBlocks.POTTED_PALM_FERN.get(), IcariaBlocks.POTTED_WHITE_BROMELIA.get(), IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), IcariaBlocks.POTTED_PINK_BROMELIA.get(), IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
		pEvent.registerFluidType(new MediterraneanWaterClientFluidTypeExtensions(), IcariaFluidTypes.MEDITERRANEAN_WATER.get());
		pEvent.registerItem(new OrichalcumHelmetClientItemExtensions(), IcariaItems.ORICHALCUM_HELMET.get());
	}

	@SubscribeEvent
	public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Block pEvent) {
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.GRASSY_MARL.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.BLOOMY_VINE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.BRANCHY_VINE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.BRUSHY_VINE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.DRY_VINE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.REEDY_VINE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.SWIRLY_VINE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.THORNY_VINE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.FERN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_FERN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.SMALL_GRASS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.MEDIUM_GRASS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.LARGE_GRASS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.SMALL_MIXED_GRAIN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.LARGE_BROWN_GRAIN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.BLINDWEED.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_BLINDWEED.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.CHAMEOMILE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_CHAMEOMILE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.CHARMONDER.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_CHARMONDER.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.CLOVER.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_CLOVER.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.FIREHILT.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_FIREHILT.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.BLUE_HYDRACINTH.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PURPLE_HYDRACINTH.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.LIONFANGS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_LIONFANGS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.SPEARDROPS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_SPEARDROPS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PURPLE_STAGHORN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.YELLOW_STAGHORN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.BLUE_STORMCOTTON.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PINK_STORMCOTTON.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PURPLE_STORMCOTTON.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.SUNKETTLE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_SUNKETTLE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.SUNSPONGE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_SUNSPONGE.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.VOIDLILY.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_VOIDLILY.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PINK_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.RED_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PALM_FERN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_PALM_FERN.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.WHITE_BROMELIA.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.ORANGE_BROMELIA.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PINK_BROMELIA.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_PINK_BROMELIA.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.PURPLE_BROMELIA.get());
		pEvent.register(IcariaClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
	}

	@SubscribeEvent
	public static void onRegisterDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent pEvent) {
		pEvent.register(IcariaResourceLocations.ICARIA, new IcariaDimensionSpecialEffects());
	}

	@SubscribeEvent
	public static void onRegisterMenuScreens(RegisterMenuScreensEvent pEvent) {
		pEvent.register(IcariaMenus.FORGE.get(), ForgeScreen::new);
		pEvent.register(IcariaMenus.GRINDER.get(), GrinderScreen::new);
		pEvent.register(IcariaMenus.KILN.get(), KilnScreen::new);
		pEvent.register(IcariaMenus.STORAGE_VASE.get(), StorageVaseScreen::new);
	}

	@SubscribeEvent
	public static void onRegisterParticleProviders(RegisterParticleProvidersEvent pEvent) {
		pEvent.registerSpriteSet(IcariaParticleTypes.BUBBLE.get(), IcariaBubbleParticleProvider::new);
		pEvent.registerSpriteSet(IcariaParticleTypes.PORTAL.get(), IcariaPortalParticleProvider::new);
		pEvent.registerSpriteSet(IcariaParticleTypes.STEAM.get(), IcariaSteamParticleProvider::new);
	}

	@SubscribeEvent
	public static void onRegisterRenderPipelines(RegisterRenderPipelinesEvent pEvent) {
		pEvent.registerPipeline(IcariaRenderPipelines.ADDITIVE);
		pEvent.registerPipeline(IcariaRenderPipelines.ADDITIVE_TEXTURED);
	}

	@SubscribeEvent
	public static void onRegisterRenderStateModifiers(RegisterRenderStateModifiersEvent pEvent) {
		pEvent.registerEntityModifier(PlayerRenderer.class, (abstractClientPlayer, playerRenderState) -> playerRenderState.setRenderData(IcariaContextKeys.LEVEL, abstractClientPlayer.level()));
		pEvent.registerEntityModifier(PlayerRenderer.class, (abstractClientPlayer, playerRenderState) -> playerRenderState.setRenderData(IcariaContextKeys.LOOT_VASE, abstractClientPlayer.getData(IcariaAttachmentTypes.LOOT_VASE)));
		pEvent.registerEntityModifier(PlayerRenderer.class, (abstractClientPlayer, playerRenderState) -> playerRenderState.setRenderData(IcariaContextKeys.LOOT_VASE_BLOCK_POS, abstractClientPlayer.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_POS)));
		pEvent.registerEntityModifier(PlayerRenderer.class, (abstractClientPlayer, playerRenderState) -> playerRenderState.setRenderData(IcariaContextKeys.LOOT_VASE_BLOCK_STATE, abstractClientPlayer.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE)));
	}

	@SubscribeEvent
	public static void onRegisterSpecialModelRenderer(RegisterSpecialModelRendererEvent pEvent) {
		pEvent.register(IcariaResourceLocations.SCROLL_RENDERER, UnbakedScrollItemSpecialModelRenderer.MAP_CODEC);
	}

	public static void blockEntityRenderers() {
		BlockEntityRenderers.register(IcariaBlockEntityTypes.CHEST.get(), IcariaChestBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.FORGE.get(), ForgeBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.KETTLE.get(), KettleBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.KILN.get(), KilnBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SIGN.get(), IcariaSignBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SPAWNER.get(), IcariaSpawnerBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.TRAPPED_CHEST.get(), IcariaChestBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.TROUGH.get(), TroughBlockRenderer::new);
	}

	public static void entityRenderers() {
		EntityRenderers.register(IcariaEntityTypes.AETERNAE.get(), AeternaeRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE.get(), ArachneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE_DRONE.get(), ArachneDroneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARGAN_HOUND.get(), ArganHoundRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BARREL.get(), IcariaBarrelRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BIDENT.get(), BidentRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CAPELLA.get(), CapellaRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CATOBLEPAS.get(), CatoblepasRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CERVER.get(), CerverRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CROCOTTA.get(), CrocottaRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), ThrownItemRenderer::new);
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
		EntityRenderers.register(IcariaEntityTypes.PAINTING.get(), PaintingRenderer::new);
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
		EntityRenderers.register(IcariaEntityTypes.ANTI_GRAVITY_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FORTIFYING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.HEALING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BUBBLE_SPELL.get(), BubbleSpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FREEZING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.MAGIC_MISSILE_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.THOG.get(), ThogRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAR.get(), ThrownItemRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAROON.get(), VinegaroonRenderer::new);
	}

	public static void itemBlockRenderTypes() {
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.MEDITERRANEAN_WATER.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.FLOWING_MEDITERRANEAN_WATER.get(), RenderType.translucent());
	}

	public static BlockColor blockColor() {
		return (blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos) : IcariaColors.ITEM;
	}
}
