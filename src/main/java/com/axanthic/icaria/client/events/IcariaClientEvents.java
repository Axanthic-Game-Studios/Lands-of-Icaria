package com.axanthic.icaria.client.events;

import com.axanthic.icaria.client.extensions.IcariaClientBlockExtensions;
import com.axanthic.icaria.client.extensions.IcariaClientFluidTypeExtensions;
import com.axanthic.icaria.client.extensions.IcariaClientItemExtensions;
import com.axanthic.icaria.client.layer.BarrelRenderLayer;
import com.axanthic.icaria.client.layer.LootVaseRenderLayer;
import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.particle.provider.IcariaBubbleParticleProvider;
import com.axanthic.icaria.client.particle.provider.IcariaPortalParticleProvider;
import com.axanthic.icaria.client.particle.provider.IcariaSteamParticleProvider;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.registry.IcariaRenderPipelines;
import com.axanthic.icaria.client.renderer.*;
import com.axanthic.icaria.client.screen.*;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.types.SkullBlockTypes;

import com.google.common.reflect.TypeToken;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(modid = IcariaKeys.ID, value = Dist.CLIENT)
public class IcariaClientEvents {

	@SubscribeEvent
	public static void onAddLayers(EntityRenderersEvent.AddLayers pEvent) {
		for (var playerModelType : pEvent.getSkins()) {
			if (pEvent.getPlayerRenderer(playerModelType) instanceof AvatarRenderer<?> avatarRenderer) {
				avatarRenderer.addLayer(new BarrelRenderLayer(avatarRenderer));
				avatarRenderer.addLayer(new LootVaseRenderLayer(avatarRenderer));
			}
		}
	}

	@SubscribeEvent
	public static void onCreateSkullModels(EntityRenderersEvent.CreateSkullModels pEvent) {
		pEvent.registerSkullModel(SkullBlockTypes.AETERNAE, IcariaModelLayerLocations.AETERNAE_SKULL, IcariaIdentifiers.AETERNAE);
		pEvent.registerSkullModel(SkullBlockTypes.ARGAN_HOUND, IcariaModelLayerLocations.ARGAN_HOUND_SKULL, IcariaIdentifiers.ARGAN_HOUND);
		pEvent.registerSkullModel(SkullBlockTypes.CAPELLA, IcariaModelLayerLocations.CAPELLA_SKULL, IcariaIdentifiers.CAPELLA);
		pEvent.registerSkullModel(SkullBlockTypes.CATOBLEPAS, IcariaModelLayerLocations.CATOBLEPAS_SKULL, IcariaIdentifiers.CATOBLEPAS);
		pEvent.registerSkullModel(SkullBlockTypes.CERVER, IcariaModelLayerLocations.CERVER_SKULL, IcariaIdentifiers.CERVER);
		pEvent.registerSkullModel(SkullBlockTypes.CROCOTTA, IcariaModelLayerLocations.CROCOTTA_SKULL, IcariaIdentifiers.CROCOTTA);
		pEvent.registerSkullModel(SkullBlockTypes.CYPRESS_FOREST_HAG, IcariaModelLayerLocations.CYPRESS_FOREST_HAG_SKULL, IcariaIdentifiers.CYPRESS_FOREST_HAG);
		pEvent.registerSkullModel(SkullBlockTypes.DROUGHTROOT_FOREST_HAG, IcariaModelLayerLocations.DROUGHTROOT_FOREST_HAG_SKULL, IcariaIdentifiers.DROUGHTROOT_FOREST_HAG);
		pEvent.registerSkullModel(SkullBlockTypes.FIR_FOREST_HAG, IcariaModelLayerLocations.FIR_FOREST_HAG_SKULL, IcariaIdentifiers.FIR_FOREST_HAG);
		pEvent.registerSkullModel(SkullBlockTypes.LAUREL_FOREST_HAG, IcariaModelLayerLocations.LAUREL_FOREST_HAG_SKULL, IcariaIdentifiers.LAUREL_FOREST_HAG);
		pEvent.registerSkullModel(SkullBlockTypes.OLIVE_FOREST_HAG, IcariaModelLayerLocations.OLIVE_FOREST_HAG_SKULL, IcariaIdentifiers.OLIVE_FOREST_HAG);
		pEvent.registerSkullModel(SkullBlockTypes.PLANE_FOREST_HAG, IcariaModelLayerLocations.PLANE_FOREST_HAG_SKULL, IcariaIdentifiers.PLANE_FOREST_HAG);
		pEvent.registerSkullModel(SkullBlockTypes.POPULUS_FOREST_HAG, IcariaModelLayerLocations.POPULUS_FOREST_HAG_SKULL, IcariaIdentifiers.POPULUS_FOREST_HAG);
		pEvent.registerSkullModel(SkullBlockTypes.REVENANT, IcariaModelLayerLocations.REVENANT_SKULL, IcariaIdentifiers.CAPTAIN_REVENANT);
		pEvent.registerSkullModel(SkullBlockTypes.THOG, IcariaModelLayerLocations.THOG_SKULL, IcariaIdentifiers.THOG);
	}

	@SubscribeEvent
	public static void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
		IcariaClientEvents.blockEntityRenderers();
		IcariaClientEvents.entityRenderers();
		IcariaClientEvents.itemBlockRenderTypes();
	}

	@SubscribeEvent
	public static void onRecipesReceived(RecipesReceivedEvent pEvent) {
		ScrollItemSpecialModelRenderer.setRecipeMap(pEvent.getRecipeMap());
	}

	@SubscribeEvent
	public static void onRegisterClientExtensions(RegisterClientExtensionsEvent pEvent) {
		IcariaClientEvents.registerBlock(pEvent);
		IcariaClientEvents.registerFluidType(pEvent);
		IcariaClientEvents.registerItem(pEvent);
	}

	@SubscribeEvent
	public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Block pEvent) {
		IcariaClientEvents.grassColor(pEvent);
		IcariaClientEvents.waterColor(pEvent);
	}

	@SubscribeEvent
	public static void onRegisterCustomEnvironmentEffectRenderer(RegisterCustomEnvironmentEffectRendererEvent pEvent) {
		pEvent.registerSkyboxRenderer(IcariaIdentifiers.ICARIA, new SkyboxRenderer());
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
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FEESH, FeeshModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FICHE, FicheModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FISSHH, FisshhModel::createLayer);
		pEvent.registerLayerDefinition(IcariaModelLayerLocations.FYSH, FyshModel::createLayer);
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
		pEvent.registerEntityModifier(new TypeToken<AvatarRenderer<?>>() {}, (avatar, avatarRenderState) -> avatarRenderState.setRenderData(IcariaContextKeys.BARREL, avatar.getData(IcariaAttachmentTypes.BARREL)));
		pEvent.registerEntityModifier(new TypeToken<AvatarRenderer<?>>() {}, (avatar, avatarRenderState) -> avatarRenderState.setRenderData(IcariaContextKeys.BARREL_BLOCK_STATE, avatar.getData(IcariaAttachmentTypes.BARREL_BLOCK_STATE)));
		pEvent.registerEntityModifier(new TypeToken<AvatarRenderer<?>>() {}, (avatar, avatarRenderState) -> avatarRenderState.setRenderData(IcariaContextKeys.LOOT_VASE, avatar.getData(IcariaAttachmentTypes.LOOT_VASE)));
		pEvent.registerEntityModifier(new TypeToken<AvatarRenderer<?>>() {}, (avatar, avatarRenderState) -> avatarRenderState.setRenderData(IcariaContextKeys.LOOT_VASE_BLOCK_STATE, avatar.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE)));
	}

	@SubscribeEvent
	public static void onRegisterSpecialModelRenderer(RegisterSpecialModelRendererEvent pEvent) {
		pEvent.register(IcariaIdentifiers.SCROLL_RENDERER, UnbakedScrollItemSpecialModelRenderer.MAP_CODEC);
	}

	@SubscribeEvent
	public static void onRenderPlayer(RenderPlayerEvent.Pre<?> pEvent) {
		var flag = pEvent.getRenderState().wornHeadType instanceof SkullBlockTypes;
		var playerModel = pEvent.getRenderer().getModel();
		playerModel.hat.visible = !flag;
		playerModel.head.visible = !flag;
	}

	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem pEvent) {
		var itemStack = pEvent.getItemStack();
		if (pEvent.getHand() == InteractionHand.MAIN_HAND && itemStack.is(IcariaItems.CHEST_LABEL.get())) {
			pEvent.getEntity().awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
			Minecraft.getInstance().setScreen(new ChestLabelScreen(itemStack));
		}
	}

	public static void blockEntityRenderers() {
		BlockEntityRenderers.register(IcariaBlockEntityTypes.BATHTUB.get(), BathtubBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.CHEST.get(), ChestBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.FIREPLACE.get(), FireplaceBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.FLOWER_POT_COUNTERTOP.get(), FlowerPotCountertopBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.FORGE.get(), ForgeBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.GRINDER.get(), GrinderBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.HUTCH.get(), HutchBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.KETTLE.get(), KettleBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.KILN.get(), KilnBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.POT.get(), PotBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.SIGN.get(), SignBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.TRAPPED_CHEST.get(), ChestBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntityTypes.TROUGH.get(), TroughBlockRenderer::new);
	}

	public static void entityRenderers() {
		EntityRenderers.register(IcariaEntityTypes.AETERNAE.get(), AeternaeRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE.get(), ArachneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARACHNE_DRONE.get(), ArachneDroneRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ARGAN_HOUND.get(), ArganHoundRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BARREL.get(), BarrelRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BIDENT.get(), BidentRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CAPELLA.get(), CapellaRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CATOBLEPAS.get(), CatoblepasRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CERVER.get(), CerverRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CROCOTTA.get(), CrocottaRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FEESH.get(), FeeshRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FICHE.get(), FicheRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FISSHH.get(), FisshhRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FYSH.get(), FyshRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), CypressForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), DroughtrootForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FIR_FOREST_HAG.get(), FirForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), LaurelForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), OliveForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.PLANE_FOREST_HAG.get(), PlaneForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), PopulusForestHagRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), ThrownItemRenderer::new);
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
		EntityRenderers.register(IcariaEntityTypes.RUG.get(), RugRenderer::new);
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
		EntityRenderers.register(IcariaEntityTypes.STOOL.get(), StoolRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.THOG.get(), ThogRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAR.get(), ThrownItemRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAROON.get(), VinegaroonRenderer::new);
	}

	public static void itemBlockRenderTypes() {
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.MEDITERRANEAN_WATER.get(), ChunkSectionLayer.TRANSLUCENT);
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.FLOWING_MEDITERRANEAN_WATER.get(), ChunkSectionLayer.TRANSLUCENT);
	}

	public static void registerBlock(RegisterClientExtensionsEvent pEvent) {
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.GRASSY_MARL.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.SMALL_BOWLS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.CYPRESS_HERB_HOLDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.CYPRESS_POT_COUNTERTOP.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.DROUGHTROOT_HERB_HOLDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.DROUGHTROOT_POT_COUNTERTOP.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.FIR_HERB_HOLDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.FIR_POT_COUNTERTOP.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.LAUREL_HERB_HOLDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.LAUREL_POT_COUNTERTOP.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.OLIVE_HERB_HOLDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.OLIVE_POT_COUNTERTOP.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.PLANE_HERB_HOLDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.PLANE_POT_COUNTERTOP.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POPULUS_HERB_HOLDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POPULUS_POT_COUNTERTOP.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.BLOOMY_VINE.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.BRANCHY_VINE.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.BRUSHY_VINE.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.REEDY_VINE.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_FERN.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_BLINDWEED.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_CHAMEOMILE.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_CHARMONDER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_CLOVER.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_FIREHILT.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_LIONFANGS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_SPEARDROPS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_SUNKETTLE.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_SUNSPONGE.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_VOIDLILY.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.PINK_GROUND_FLOWERS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.RED_GROUND_FLOWERS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_PALM_FERN.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_PINK_BROMELIA.get());
		pEvent.registerBlock(new IcariaClientBlockExtensions(), IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
	}

	public static void registerFluidType(RegisterClientExtensionsEvent pEvent) {
		pEvent.registerFluidType(new IcariaClientFluidTypeExtensions(), IcariaFluidTypes.MEDITERRANEAN_WATER.get());
	}

	public static void registerItem(RegisterClientExtensionsEvent pEvent) {
		pEvent.registerItem(new IcariaClientItemExtensions(), IcariaItems.ORICHALCUM_HELMET.get());
	}

	public static void grassColor(RegisterColorHandlersEvent.Block pEvent) {
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.GRASSY_MARL.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.CYPRESS_HERB_HOLDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.DROUGHTROOT_HERB_HOLDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.FIR_HERB_HOLDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.LAUREL_HERB_HOLDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.OLIVE_HERB_HOLDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PLANE_HERB_HOLDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POPULUS_HERB_HOLDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.BLOOMY_VINE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.BRANCHY_VINE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.BRUSHY_VINE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.DRY_VINE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.REEDY_VINE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.SWIRLY_VINE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.THORNY_VINE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.FERN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_FERN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.SMALL_GRASS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.MEDIUM_GRASS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.LARGE_GRASS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.SMALL_MIXED_GRAIN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.LARGE_BROWN_GRAIN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.BLINDWEED.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_BLINDWEED.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.CHAMEOMILE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_CHAMEOMILE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.CHARMONDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_CHARMONDER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.CLOVER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_CLOVER.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.FIREHILT.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_FIREHILT.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.BLUE_HYDRACINTH.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PURPLE_HYDRACINTH.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.LIONFANGS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_LIONFANGS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.SPEARDROPS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_SPEARDROPS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PURPLE_STAGHORN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.YELLOW_STAGHORN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.BLUE_STORMCOTTON.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PINK_STORMCOTTON.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PURPLE_STORMCOTTON.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.SUNKETTLE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_SUNKETTLE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.SUNSPONGE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_SUNSPONGE.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.VOIDLILY.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_VOIDLILY.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PINK_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.RED_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PALM_FERN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_PALM_FERN.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.WHITE_BROMELIA.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.ORANGE_BROMELIA.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PINK_BROMELIA.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_PINK_BROMELIA.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.PURPLE_BROMELIA.get());
		pEvent.register(IcariaClientEvents.grassColor(), IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
	}

	public static void waterColor(RegisterColorHandlersEvent.Block pEvent) {
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.SMALL_BOWLS.get());
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.CYPRESS_POT_COUNTERTOP.get());
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.DROUGHTROOT_POT_COUNTERTOP.get());
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.FIR_POT_COUNTERTOP.get());
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.LAUREL_POT_COUNTERTOP.get());
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.OLIVE_POT_COUNTERTOP.get());
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.PLANE_POT_COUNTERTOP.get());
		pEvent.register(IcariaClientEvents.waterColor(), IcariaBlocks.POPULUS_POT_COUNTERTOP.get());
	}

	public static BlockColor grassColor() {
		return (blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos) : IcariaColors.TINT_GRASS;
	}

	public static BlockColor waterColor() {
		return (blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageWaterColor(blockAndTintGetter, blockPos) : IcariaColors.TINT_WATER;
	}
}
