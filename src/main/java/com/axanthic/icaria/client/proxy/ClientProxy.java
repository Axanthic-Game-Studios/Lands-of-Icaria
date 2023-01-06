package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.model.*;
import com.axanthic.icaria.client.renderer.*;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.item.TotemItem;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.*;

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
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class ClientProxy extends CommonProxy {
	public ClientProxy() {

	}

	@Override
	public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(IcariaEntities.AETERNAE.get(), AeternaeEntity.registerAttributes().build());
		event.put(IcariaEntities.ARACHNE.get(), ArachneEntity.registerAttributes().build());
		event.put(IcariaEntities.ARACHNE_DRONE.get(), ArachneDroneEntity.registerAttributes().build());
		event.put(IcariaEntities.ARGAN_HOUND.get(), ArganHoundEntity.registerAttributes().build());
		event.put(IcariaEntities.CATOBLEPAS.get(), CatoblepasEntity.registerAttributes().build());
		event.put(IcariaEntities.CERVER.get(), CerverEntity.registerAttributes().build());
		event.put(IcariaEntities.HYLIASTER.get(), HyliasterEntity.registerAttributes().build());
		event.put(IcariaEntities.MYRMEKE_DRONE.get(), MyrmekeDroneEntity.registerAttributes().build());
		event.put(IcariaEntities.MYRMEKE_SOLDIER.get(), MyrmekeSoldierEntity.registerAttributes().build());
		event.put(IcariaEntities.MYRMEKE_QUEEN.get(), MyrmekeQueenEntity.registerAttributes().build());
		event.put(IcariaEntities.SOW.get(), SowEntity.registerAttributes().build());
	}

	@Override
	public void onFMLClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.CYPRESS));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.DROUGHTROOT));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.FIR));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.LAUREL));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.OLIVE));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.PLANE));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.POPULUS));

		event.enqueueWork(() -> MenuScreens.register(IcariaMenus.STORAGE_VASE.get(), StorageVaseScreen::new));

		ItemProperties.register(IcariaItems.GREEK_FIRE_GRENADE.get(), new ResourceLocation(IcariaInfo.MODID, "throwing"), (pStack, pLevel, pEntity, pId) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);

		for (IcariaItems.ToolSet tools : IcariaItems.TOOLS) {
			ItemProperties.register(tools.bident.get(), new ResourceLocation(IcariaInfo.MODID, "throwing"), (pStack, pLevel, pEntity, pId) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
		}
	}

	@Override
	public void onFMLCommonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(IcariaCompostables::setup);
		event.enqueueWork(IcariaFlammables::setup);
		event.enqueueWork(IcariaPottables::setup);
		event.enqueueWork(IcariaStrippables::setup);
		event.enqueueWork(IcariaWoodTypes::setup);
	}

	@Override
	public void onFMLLoadComplete() {
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
		this.renderTranslucent(IcariaBlocks.JELLYFISH_JELLY_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.CALCITE_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.HALITE_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.ZIRCON_BLOCK.get());
		this.renderTranslucent(IcariaBlocks.ICARIA_PORTAL.get());
		this.renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER_SOURCE.get());
		this.renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER_FLOWING.get());

		// ENTITY RENDERERS
		EntityRenderers.register(IcariaEntities.AETERNAE.get(), AeternaeRenderer::new);
		EntityRenderers.register(IcariaEntities.ARACHNE.get(), ArachneRenderer::new);
		EntityRenderers.register(IcariaEntities.ARACHNE_DRONE.get(), ArachneDroneRenderer::new);
		EntityRenderers.register(IcariaEntities.ARGAN_HOUND.get(), ArganHoundRenderer::new);
		EntityRenderers.register(IcariaEntities.BIDENT.get(), BidentRenderer::new);
		EntityRenderers.register(IcariaEntities.CATOBLEPAS.get(), CatoblepasRenderer::new);
		EntityRenderers.register(IcariaEntities.CERVER.get(), CerverRenderer::new);
		EntityRenderers.register(IcariaEntities.GREEK_FIRE_GRENADE.get(), GreekFireGrenadeRenderer::new);
		EntityRenderers.register(IcariaEntities.HYLIASTER.get(), HyliasterRenderer::new);
		EntityRenderers.register(IcariaEntities.MYRMEKE_DRONE.get(), MyrmekeDroneRenderer::new);
		EntityRenderers.register(IcariaEntities.MYRMEKE_SOLDIER.get(), MyrmekeSoldierRenderer::new);
		EntityRenderers.register(IcariaEntities.MYRMEKE_QUEEN.get(), MyrmekeQueenRenderer::new);
		EntityRenderers.register(IcariaEntities.SOW.get(), SowRenderer::new);

		// BLOCK ENTITY RENDERERS
		BlockEntityRenderers.register(IcariaBlockEntities.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntities.SIGN.get(), IcariaSignBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntities.SKULL.get(), IcariaSkullBlockRenderer::new);
	}

	@Override
	public void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeClient(), new IcariaLang(generator));
		generator.addProvider(event.includeClient(), new IcariaItemModels(generator, helper));
		generator.addProvider(event.includeClient(), new IcariaBlockStates(generator, helper));

		BlockTagsProvider tags = new IcariaBlockTags(generator, helper);

		generator.addProvider(event.includeServer(), new IcariaLootTables(generator));
		generator.addProvider(event.includeServer(), new IcariaRecipes(generator));
		generator.addProvider(event.includeServer(), new IcariaBlockTags(generator, helper));
		generator.addProvider(event.includeServer(), new IcariaItemTags(generator, tags, helper));
		generator.addProvider(event.includeServer(), new IcariaFluidTags(generator, helper));
	}

	@Override
	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(AeternaeModel.LAYER_LOCATION, AeternaeModel::createLayer);
		event.registerLayerDefinition(AeternaeSkullModel.LAYER_LOCATION, AeternaeSkullModel::createLayer);
		event.registerLayerDefinition(ArachneModel.LAYER_LOCATION, ArachneModel::createLayer);
		event.registerLayerDefinition(ArachneDroneModel.LAYER_LOCATION, ArachneDroneModel::createLayer);
		event.registerLayerDefinition(ArganHoundModel.LAYER_LOCATION, ArganHoundModel::createLayer);
		event.registerLayerDefinition(ArganHoundSkullModel.LAYER_LOCATION, ArganHoundSkullModel::createLayer);
		event.registerLayerDefinition(CatoblepasModel.LAYER_LOCATION, CatoblepasModel::createLayer);
		event.registerLayerDefinition(CatoblepasSkullModel.LAYER_LOCATION, CatoblepasSkullModel::createLayer);
		event.registerLayerDefinition(CerverModel.LAYER_LOCATION, CerverModel::createLayer);
		event.registerLayerDefinition(CerverSkullModel.LAYER_LOCATION, CerverSkullModel::createLayer);
		event.registerLayerDefinition(HyliasterModel.LAYER_LOCATION, HyliasterModel::createLayer);
		event.registerLayerDefinition(HyliasterModel.TRANSLUCENT_LAYER_LOCATION, HyliasterModel::createTranslucentLayer);
		event.registerLayerDefinition(MyrmekeDroneModel.LAYER_LOCATION, MyrmekeDroneModel::createLayer);
		event.registerLayerDefinition(MyrmekeSoldierModel.LAYER_LOCATION, MyrmekeSoldierModel::createLayer);
		event.registerLayerDefinition(MyrmekeQueenModel.BODY_LAYER_LOCATION, MyrmekeQueenModel::createLayer);
		event.registerLayerDefinition(MyrmekeQueenModel.RAYS_LAYER_LOCATION, MyrmekeQueenModel::createLayer);
		event.registerLayerDefinition(OrichalcumHelmetModel.LAYER_LOCATION, OrichalcumHelmetModel::createLayer);
		event.registerLayerDefinition(SowModel.LAYER_LOCATION, SowModel::createLayer);
		event.registerLayerDefinition(SowSkullModel.LAYER_LOCATION, SowSkullModel::createLayer);
	}

	@Override
	public void onEntityAttributeModification(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, ForgeMod.ATTACK_RANGE.get());
	}

	@Override
	public void onLivingAttack(LivingAttackEvent event) {
		float damage = event.getAmount();
		Entity entity = event.getEntity();
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
					offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
					offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
					event.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					event.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		DamageSource source = event.getSource();
		if (source instanceof EntityDamageSource damageSource) {
			Entity entitySource = damageSource.getEntity();
			if (entitySource instanceof Player player) {
				ItemStack mainHand = player.getMainHandItem();
				ItemStack offHand = player.getOffhandItem();
				TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
				if (mainHand.getItem() instanceof TieredItem || mainHand.getItem() instanceof TridentItem) {
					if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
						if (offHand.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
							offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}
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
							offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}

						if (mainHand.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
					offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}
	}

	@Override
	public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
		Entity entity = event.getEntity();
		MobEffectInstance effect = event.getEffectInstance();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNBLINDING.get();
			if (effect.getEffect().equals(MobEffects.BLINDNESS)) {
				if (offHand.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHand.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof FishingRodItem || mainHand.getItem() instanceof BowItem || mainHand.getItem() instanceof CrossbowItem || mainHand.getItem() instanceof ShieldItem || mainHand.getItem() instanceof TridentItem || mainHand.getItem() instanceof BidentItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offHand.getItem() instanceof FishingRodItem || offHand.getItem() instanceof BowItem || offHand.getItem() instanceof CrossbowItem || offHand.getItem() instanceof ShieldItem || offHand.getItem() instanceof TridentItem || offHand.getItem() instanceof BidentItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof ShearsItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offHand.getItem() instanceof ShearsItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof TieredItem || mainHand.getItem() instanceof ShearsItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHand = player.getMainHandItem();
			ItemStack offHand = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHand.getItem() instanceof AxeItem || mainHand.getItem() instanceof HoeItem || mainHand.getItem() instanceof ShovelItem || mainHand.getItem() instanceof FlintAndSteelItem) {
				if (mainHand.getDamageValue() >= (mainHand.getMaxDamage() * 0.9)) {
					if (offHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHand.setDamageValue((int) (mainHand.getItem().getMaxDamage(mainHand) * 0.1));
						offHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offHand.getItem() instanceof AxeItem || offHand.getItem() instanceof HoeItem || offHand.getItem() instanceof ShovelItem || offHand.getItem() instanceof FlintAndSteelItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}
		}
	}

	@Override
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		Player player = event.player;
		if (player.level.dimension() == IcariaDimensions.ICARIA) {
			for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
				ItemStack itemStack = player.getInventory().getItem(slot);
				if (itemStack.getItem().equals(Items.TORCH)) {
					int size = itemStack.getCount();
					player.getInventory().removeItem(itemStack);
					player.getInventory().add(slot, new ItemStack(IcariaItems.DIM_TORCH.get(), size));
				}
			}
		} else {
			for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
				ItemStack itemStack = player.getInventory().getItem(slot);
				if (itemStack.getItem().equals(IcariaItems.DIM_TORCH.get())) {
					int size = itemStack.getCount();
					player.getInventory().removeItem(itemStack);
					player.getInventory().add(slot, new ItemStack(Items.TORCH, size));
				}
			}
		}
	}

	@Override
	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
		if (event.getRenderer().getModel() instanceof PlayerModel<?>) {
			for (ItemStack itemStack : event.getEntity().getArmorSlots()) {
				if (itemStack.getItem() instanceof IcariaSkullItem) {
					((PlayerModel<?>) event.getRenderer().getModel()).hat.visible = false;
					((PlayerModel<?>) event.getRenderer().getModel()).head.visible = false;
					return;
				}
			}
		}
	}

	public void blockColor(Block block) {
		Minecraft minecraft = Minecraft.getInstance();
		BlockColors blockColors = minecraft.getBlockColors();
		blockColors.register((pState, pGetter, pPos, pIndex) -> GrassColor.get(0.6D, 0.1D), block);
	}

	public void itemColor(Item item) {
		Minecraft minecraft = Minecraft.getInstance();
		ItemColors itemColors = minecraft.getItemColors();
		itemColors.register((pStack, pIndex) -> GrassColor.get(0.6D, 0.1D), item);
	}

	public void renderCutout(Block block) {
		ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
	}

	public void renderTranslucent(Block block) {
		ItemBlockRenderTypes.setRenderLayer(block, RenderType.translucent());
	}

	public void renderTranslucent(Fluid fluid) {
		ItemBlockRenderTypes.setRenderLayer(fluid, RenderType.translucent());
	}
}
