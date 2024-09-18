package com.axanthic.icaria.client.events;

import com.axanthic.icaria.client.effects.IcariaSpecialEffects;
import com.axanthic.icaria.client.extensions.*;
import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.particle.provider.IcariaBubbleParticleProvider;
import com.axanthic.icaria.client.particle.provider.IcariaPortalParticleProvider;
import com.axanthic.icaria.client.particle.provider.IcariaSteamParticleProvider;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.renderer.*;
import com.axanthic.icaria.client.screen.ForgeScreen;
import com.axanthic.icaria.client.screen.GrinderScreen;
import com.axanthic.icaria.client.screen.KilnScreen;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.common.registry.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.PaintingRenderer;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = IcariaIdents.ID, value = Dist.CLIENT)
public class ClientModEvents {

	@SubscribeEvent
	public static void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
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
		BlockEntityRenderers.register(IcariaBlockEntityTypes.TROUGH.get(), TroughBlockRenderer::new);

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
		EntityRenderers.register(IcariaEntityTypes.SOW.get(), SowRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.ANTI_GRAVITY_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FORTIFYING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.HEALING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.BUBBLE_SPELL.get(), BubbleSpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.FREEZING_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.MAGIC_MISSILE_SPELL.get(), SpellRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAR.get(), VinegarRenderer::new);
		EntityRenderers.register(IcariaEntityTypes.VINEGAROON.get(), VinegaroonRenderer::new);

		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.MEDITERRANEAN_WATER.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(IcariaFluids.FLOWING_MEDITERRANEAN_WATER.get(), RenderType.translucent());
	}

	@SubscribeEvent
	public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
		pEvent.registerLayerDefinition(IcariaLayerLocations.AETERNAE, AeternaeModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.AETERNAE_SKULL, AeternaeSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARACHNE, ArachneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARACHNE_DRONE, ArachneDroneModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARGAN_HOUND, ArganHoundModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.ARGAN_HOUND_SKULL, ArganHoundSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CAPELLA, CapellaModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CAPELLA_SKULL, CapellaSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CATOBLEPAS, CatoblepasModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CATOBLEPAS_SKULL, CatoblepasSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CERVER, CerverModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CERVER_SKULL, CerverSkullModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CROCOTTA, CrocottaModel::createLayer);
		pEvent.registerLayerDefinition(IcariaLayerLocations.CROCOTTA_SKULL, CrocottaSkullModel::createLayer);
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
	public static void onRegisterClientExtensions(RegisterClientExtensionsEvent pEvent) {
		pEvent.registerBlock(new TintedBlockExtensions(), IcariaBlocks.GRASSY_MARL.get(), IcariaBlocks.BLOOMY_VINE.get(), IcariaBlocks.BRANCHY_VINE.get(), IcariaBlocks.BRUSHY_VINE.get(), IcariaBlocks.REEDY_VINE.get(), IcariaBlocks.POTTED_FERN.get(), IcariaBlocks.POTTED_BLINDWEED.get(), IcariaBlocks.POTTED_CHAMEOMILE.get(), IcariaBlocks.POTTED_CHARMONDER.get(), IcariaBlocks.POTTED_CLOVER.get(), IcariaBlocks.POTTED_FIREHILT.get(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), IcariaBlocks.POTTED_LIONFANGS.get(), IcariaBlocks.POTTED_SPEARDROPS.get(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), IcariaBlocks.POTTED_SUNKETTLE.get(), IcariaBlocks.POTTED_SUNSPONGE.get(), IcariaBlocks.POTTED_VOIDLILY.get(), IcariaBlocks.POTTED_PALM_FERN.get(), IcariaBlocks.POTTED_WHITE_BROMELIA.get(), IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), IcariaBlocks.POTTED_PINK_BROMELIA.get(), IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
		pEvent.registerFluidType(new MediterraneanWaterFluidTypeExtensions(), IcariaFluidTypes.MEDITERRANEAN_WATER.get());
		pEvent.registerItem(new IcariaChestItemExtensions(), IcariaItems.CHEST.get(), IcariaItems.TRAPPED_CHEST.get());
		pEvent.registerItem(new IcariaSkullItemExtensions(), IcariaItems.AETERNAE_SKULL.get(), IcariaItems.ARGAN_HOUND_SKULL.get(), IcariaItems.CAPELLA_SKULL.get(), IcariaItems.CATOBLEPAS_SKULL.get(), IcariaItems.CERVER_SKULL.get(), IcariaItems.CROCOTTA_SKULL.get(), IcariaItems.CYPRESS_FOREST_HAG_SKULL.get(), IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get(), IcariaItems.FIR_FOREST_HAG_SKULL.get(), IcariaItems.LAUREL_FOREST_HAG_SKULL.get(), IcariaItems.OLIVE_FOREST_HAG_SKULL.get(), IcariaItems.PLANE_FOREST_HAG_SKULL.get(), IcariaItems.POPULUS_FOREST_HAG_SKULL.get(), IcariaItems.REVENANT_SKULL.get(), IcariaItems.SOW_SKULL.get());
		pEvent.registerItem(new OrichalcumHelmetItemExtensions(), IcariaItems.ORICHALCUM_ARMOR.helmet.get());
		pEvent.registerItem(new ScrollItemExtensions(), IcariaItems.ANTI_GRAVITY_SCROLL.get(), IcariaItems.FORTIFYING_SCROLL.get(), IcariaItems.HEALING_SCROLL.get(), IcariaItems.BUBBLE_SCROLL.get(), IcariaItems.FREEZING_SCROLL.get(), IcariaItems.MAGIC_MISSILE_SCROLL.get());
	}

	@SubscribeEvent
	public static void onRegisterBlockColorHandlers(RegisterColorHandlersEvent.Block pEvent) {
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.GRASSY_MARL.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.BLOOMY_VINE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.BRANCHY_VINE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.BRUSHY_VINE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.DRY_VINE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.REEDY_VINE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.SWIRLY_VINE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.THORNY_VINE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.FERN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_FERN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.SMALL_GRASS.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.MEDIUM_GRASS.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.LARGE_GRASS.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.SMALL_MIXED_GRAIN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.LARGE_BROWN_GRAIN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.BLINDWEED.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_BLINDWEED.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.CHAMEOMILE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_CHAMEOMILE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.CHARMONDER.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_CHARMONDER.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.CLOVER.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_CLOVER.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.FIREHILT.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_FIREHILT.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.BLUE_HYDRACINTH.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.PURPLE_HYDRACINTH.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.LIONFANGS.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_LIONFANGS.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.SPEARDROPS.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_SPEARDROPS.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.PURPLE_STAGHORN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.YELLOW_STAGHORN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.BLUE_STORMCOTTON.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.PINK_STORMCOTTON.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.PURPLE_STORMCOTTON.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.SUNKETTLE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_SUNKETTLE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.SUNSPONGE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_SUNSPONGE.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.VOIDLILY.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_VOIDLILY.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.PALM_FERN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_PALM_FERN.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.WHITE_BROMELIA.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.ORANGE_BROMELIA.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.PINK_BROMELIA.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_PINK_BROMELIA.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.PURPLE_BROMELIA.get());
		pEvent.register(ClientModEvents.blockColor(), IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
	}

	@SubscribeEvent
	public static void onRegisterItemColorHandlers(RegisterColorHandlersEvent.Item pEvent) {
		pEvent.register(ClientModEvents.itemColor(), IcariaItems.GRASSY_MARL.get());
		pEvent.register(ClientModEvents.itemColor(), IcariaItems.PALM_FERN.get());
		pEvent.register(ClientModEvents.itemColor(), IcariaItems.WHITE_BROMELIA.get());
		pEvent.register(ClientModEvents.itemColor(), IcariaItems.ORANGE_BROMELIA.get());
		pEvent.register(ClientModEvents.itemColor(), IcariaItems.PINK_BROMELIA.get());
		pEvent.register(ClientModEvents.itemColor(), IcariaItems.PURPLE_BROMELIA.get());
	}

	@SubscribeEvent
	public static void onRegisterDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent pEvent) {
		pEvent.register(IcariaResourceLocations.ICARIA, new IcariaSpecialEffects());
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

	public static BlockColor blockColor() {
		return (pBlockState, pLevel, pBlockPos, pIndex) -> {
			assert pLevel != null;
			assert pBlockPos != null;
			return BiomeColors.getAverageGrassColor(pLevel, pBlockPos);
		};
	}

	public static ItemColor itemColor() {
		return (stack, tintIndex) -> IcariaColors.ITEM;
	}
}
