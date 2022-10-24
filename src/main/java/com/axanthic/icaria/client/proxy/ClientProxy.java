package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.renderer.BidentRenderer;
import com.axanthic.icaria.client.renderer.CrystalBlockRenderer;
import com.axanthic.icaria.client.renderer.GreekFireGrenadeRenderer;
import com.axanthic.icaria.client.renderer.IcariaSignBlockRenderer;
import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.TotemItem;
import com.axanthic.icaria.common.proxy.CommonProxy;
import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.screens.MenuScreens;
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
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.TickEvent;
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
	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(OrichalcumHelmetModel.LAYER_LOCATION, OrichalcumHelmetModel::createLayer);
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
			ItemProperties.register(tools.BIDENT.get(), new ResourceLocation(IcariaInfo.MODID, "throwing"), (pStack, pLevel, pEntity, pId) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
		}
	}

	@Override
	public void onFMLCommonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(IcariaCompostables::setup);
		event.enqueueWork(IcariaFlammables::setup);
		event.enqueueWork(IcariaPottables::setup);
		event.enqueueWork(IcariaStrippables::setup);
		event.enqueueWork(IcariaTillables::setup);
		event.enqueueWork(IcariaWoodTypes::setup);
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
	public void onFMLLoadComplete() {
		// BLOCK COLOR
		blockColor(IcariaBlocks.MARL_GRASS.get());
		blockColor(IcariaBlocks.GROWING_BLOOMY_VINE.get());
		blockColor(IcariaBlocks.BLOOMY_VINE.get());
		blockColor(IcariaBlocks.BLOOMING_BLOOMY_VINE.get());
		blockColor(IcariaBlocks.RIPE_BLOOMY_VINE.get());
		blockColor(IcariaBlocks.GROWING_BRANCHY_VINE.get());
		blockColor(IcariaBlocks.BRANCHY_VINE.get());
		blockColor(IcariaBlocks.GROWING_BRUSHY_VINE.get());
		blockColor(IcariaBlocks.RIPE_BRUSHY_VINE.get());
		blockColor(IcariaBlocks.BRUSHY_VINE.get());
		blockColor(IcariaBlocks.DEAD_DRY_VINE.get());
		blockColor(IcariaBlocks.GROWING_DRY_VINE.get());
		blockColor(IcariaBlocks.DRY_VINE.get());
		blockColor(IcariaBlocks.GROWING_REEDY_VINE.get());
		blockColor(IcariaBlocks.REEDY_VINE.get());
		blockColor(IcariaBlocks.DEAD_SWIRLY_VINE.get());
		blockColor(IcariaBlocks.GROWING_SWIRLY_VINE.get());
		blockColor(IcariaBlocks.SWIRLY_VINE.get());
		blockColor(IcariaBlocks.DEAD_THORNY_VINE.get());
		blockColor(IcariaBlocks.GROWING_THORNY_VINE.get());
		blockColor(IcariaBlocks.THORNY_VINE.get());
		blockColor(IcariaBlocks.FERN.get());
		blockColor(IcariaBlocks.POTTED_FERN.get());
		blockColor(IcariaBlocks.SMALL_GRASS.get());
		blockColor(IcariaBlocks.MEDIUM_GRASS.get());
		blockColor(IcariaBlocks.LARGE_GRASS.get());
		blockColor(IcariaBlocks.GRAIN_0.get());
		blockColor(IcariaBlocks.GRAIN_1.get());
		blockColor(IcariaBlocks.GRAIN_2.get());
		blockColor(IcariaBlocks.GRAIN_3.get());
		blockColor(IcariaBlocks.GRAIN_4.get());
		blockColor(IcariaBlocks.GRAIN_5.get());
		blockColor(IcariaBlocks.BLINDWEED.get());
		blockColor(IcariaBlocks.POTTED_BLINDWEED.get());
		blockColor(IcariaBlocks.CHAMEOMILE.get());
		blockColor(IcariaBlocks.POTTED_CHAMEOMILE.get());
		blockColor(IcariaBlocks.CHARMONDER.get());
		blockColor(IcariaBlocks.POTTED_CHARMONDER.get());
		blockColor(IcariaBlocks.CLOVER.get());
		blockColor(IcariaBlocks.POTTED_CLOVER.get());
		blockColor(IcariaBlocks.FIREHILT.get());
		blockColor(IcariaBlocks.POTTED_FIREHILT.get());
		blockColor(IcariaBlocks.BLUE_HYDRACINTH.get());
		blockColor(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		blockColor(IcariaBlocks.PURPLE_HYDRACINTH.get());
		blockColor(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		blockColor(IcariaBlocks.LIONFANGS.get());
		blockColor(IcariaBlocks.POTTED_LIONFANGS.get());
		blockColor(IcariaBlocks.SPEARDROPS.get());
		blockColor(IcariaBlocks.POTTED_SPEARDROPS.get());
		blockColor(IcariaBlocks.PURPLE_STAGHORN.get());
		blockColor(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		blockColor(IcariaBlocks.YELLOW_STAGHORN.get());
		blockColor(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		blockColor(IcariaBlocks.BLUE_STORMCOTTON.get());
		blockColor(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		blockColor(IcariaBlocks.PINK_STORMCOTTON.get());
		blockColor(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		blockColor(IcariaBlocks.PURPLE_STORMCOTTON.get());
		blockColor(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		blockColor(IcariaBlocks.SUNKETTLE.get());
		blockColor(IcariaBlocks.POTTED_SUNKETTLE.get());
		blockColor(IcariaBlocks.SUNSPONGE.get());
		blockColor(IcariaBlocks.POTTED_SUNSPONGE.get());
		blockColor(IcariaBlocks.VOIDLILY.get());
		blockColor(IcariaBlocks.POTTED_VOIDLILY.get());
		blockColor(IcariaBlocks.WHITE_BROMELIA.get());
		blockColor(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		blockColor(IcariaBlocks.ORANGE_BROMELIA.get());
		blockColor(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		blockColor(IcariaBlocks.PINK_BROMELIA.get());
		blockColor(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		blockColor(IcariaBlocks.PURPLE_BROMELIA.get());
		blockColor(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());

		// ITEM COLOR
		itemColor(IcariaItems.MARL_GRASS.get());
		itemColor(IcariaItems.WHITE_BROMELIA.get());
		itemColor(IcariaItems.ORANGE_BROMELIA.get());
		itemColor(IcariaItems.PINK_BROMELIA.get());
		itemColor(IcariaItems.PURPLE_BROMELIA.get());

		// RENDER CUTOUT
		renderCutout(IcariaBlocks.MARL_GRASS.get());
		renderCutout(IcariaBlocks.GRAINGLASS.get());
		renderCutout(IcariaBlocks.GRAINGLASS_PANE.get());
		renderCutout(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get());
		renderCutout(IcariaBlocks.SILKGLASS.get());
		renderCutout(IcariaBlocks.SILKGLASS_PANE.get());
		renderCutout(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());
		renderCutout(IcariaBlocks.PLATOSHALE_BLURRED.get());
		renderCutout(IcariaBlocks.PLATOSHALE_BRICKS_BLURRED.get());
		renderCutout(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		renderCutout(IcariaBlocks.VANADIUMSTEEL_BARS_HORIZONTAL.get());
		renderCutout(IcariaBlocks.CYPRESS_SAPLING.get());
		renderCutout(IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		renderCutout(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		renderCutout(IcariaBlocks.CYPRESS_DOOR.get());
		renderCutout(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		renderCutout(IcariaBlocks.CYPRESS_LADDER.get());
		renderCutout(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		renderCutout(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		renderCutout(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		renderCutout(IcariaBlocks.DROUGHTROOT_DOOR.get());
		renderCutout(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		renderCutout(IcariaBlocks.DROUGHTROOT_LADDER.get());
		renderCutout(IcariaBlocks.FIR_SAPLING.get());
		renderCutout(IcariaBlocks.POTTED_FIR_SAPLING.get());
		renderCutout(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		renderCutout(IcariaBlocks.FIR_DOOR.get());
		renderCutout(IcariaBlocks.FIR_TRAPDOOR.get());
		renderCutout(IcariaBlocks.FIR_LADDER.get());
		renderCutout(IcariaBlocks.LAUREL_SAPLING.get());
		renderCutout(IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		renderCutout(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		renderCutout(IcariaBlocks.LAUREL_DOOR.get());
		renderCutout(IcariaBlocks.LAUREL_TRAPDOOR.get());
		renderCutout(IcariaBlocks.LAUREL_LADDER.get());
		renderCutout(IcariaBlocks.OLIVE_SAPLING.get());
		renderCutout(IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		renderCutout(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		renderCutout(IcariaBlocks.OLIVE_DOOR.get());
		renderCutout(IcariaBlocks.OLIVE_TRAPDOOR.get());
		renderCutout(IcariaBlocks.OLIVE_LADDER.get());
		renderCutout(IcariaBlocks.PLANE_SAPLING.get());
		renderCutout(IcariaBlocks.POTTED_PLANE_SAPLING.get());
		renderCutout(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		renderCutout(IcariaBlocks.PLANE_DOOR.get());
		renderCutout(IcariaBlocks.PLANE_TRAPDOOR.get());
		renderCutout(IcariaBlocks.PLANE_LADDER.get());
		renderCutout(IcariaBlocks.POPULUS_SAPLING.get());
		renderCutout(IcariaBlocks.POTTED_POPULUS_SAPLING.get());
		renderCutout(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		renderCutout(IcariaBlocks.POPULUS_DOOR.get());
		renderCutout(IcariaBlocks.POPULUS_TRAPDOOR.get());
		renderCutout(IcariaBlocks.POPULUS_LADDER.get());
		renderCutout(IcariaBlocks.DIM_TORCH.get());
		renderCutout(IcariaBlocks.DIM_WALL_TORCH.get());
		renderCutout(IcariaBlocks.DEAD_BLOOMY_VINE.get());
		renderCutout(IcariaBlocks.GROWING_BLOOMY_VINE.get());
		renderCutout(IcariaBlocks.BLOOMY_VINE.get());
		renderCutout(IcariaBlocks.BLOOMING_BLOOMY_VINE.get());
		renderCutout(IcariaBlocks.RIPE_BLOOMY_VINE.get());
		renderCutout(IcariaBlocks.DEAD_BRANCHY_VINE.get());
		renderCutout(IcariaBlocks.GROWING_BRANCHY_VINE.get());
		renderCutout(IcariaBlocks.BRANCHY_VINE.get());
		renderCutout(IcariaBlocks.DEAD_BRUSHY_VINE.get());
		renderCutout(IcariaBlocks.GROWING_BRUSHY_VINE.get());
		renderCutout(IcariaBlocks.RIPE_BRUSHY_VINE.get());
		renderCutout(IcariaBlocks.BRUSHY_VINE.get());
		renderCutout(IcariaBlocks.DEAD_DRY_VINE.get());
		renderCutout(IcariaBlocks.GROWING_DRY_VINE.get());
		renderCutout(IcariaBlocks.DRY_VINE.get());
		renderCutout(IcariaBlocks.DEAD_REEDY_VINE.get());
		renderCutout(IcariaBlocks.GROWING_REEDY_VINE.get());
		renderCutout(IcariaBlocks.REEDY_VINE.get());
		renderCutout(IcariaBlocks.DEAD_SWIRLY_VINE.get());
		renderCutout(IcariaBlocks.GROWING_SWIRLY_VINE.get());
		renderCutout(IcariaBlocks.SWIRLY_VINE.get());
		renderCutout(IcariaBlocks.DEAD_THORNY_VINE.get());
		renderCutout(IcariaBlocks.GROWING_THORNY_VINE.get());
		renderCutout(IcariaBlocks.THORNY_VINE.get());
		renderCutout(IcariaBlocks.FERN.get());
		renderCutout(IcariaBlocks.POTTED_FERN.get());
		renderCutout(IcariaBlocks.SMALL_GRASS.get());
		renderCutout(IcariaBlocks.MEDIUM_GRASS.get());
		renderCutout(IcariaBlocks.LARGE_GRASS.get());
		renderCutout(IcariaBlocks.GRAIN_0.get());
		renderCutout(IcariaBlocks.GRAIN_1.get());
		renderCutout(IcariaBlocks.GRAIN_2.get());
		renderCutout(IcariaBlocks.GRAIN_3.get());
		renderCutout(IcariaBlocks.GRAIN_4.get());
		renderCutout(IcariaBlocks.GRAIN_5.get());
		renderCutout(IcariaBlocks.BLINDWEED.get());
		renderCutout(IcariaBlocks.POTTED_BLINDWEED.get());
		renderCutout(IcariaBlocks.CHAMEOMILE.get());
		renderCutout(IcariaBlocks.POTTED_CHAMEOMILE.get());
		renderCutout(IcariaBlocks.CHARMONDER.get());
		renderCutout(IcariaBlocks.POTTED_CHARMONDER.get());
		renderCutout(IcariaBlocks.CLOVER.get());
		renderCutout(IcariaBlocks.POTTED_CLOVER.get());
		renderCutout(IcariaBlocks.FIREHILT.get());
		renderCutout(IcariaBlocks.POTTED_FIREHILT.get());
		renderCutout(IcariaBlocks.BLUE_HYDRACINTH.get());
		renderCutout(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		renderCutout(IcariaBlocks.PURPLE_HYDRACINTH.get());
		renderCutout(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		renderCutout(IcariaBlocks.LIONFANGS.get());
		renderCutout(IcariaBlocks.POTTED_LIONFANGS.get());
		renderCutout(IcariaBlocks.SPEARDROPS.get());
		renderCutout(IcariaBlocks.POTTED_SPEARDROPS.get());
		renderCutout(IcariaBlocks.PURPLE_STAGHORN.get());
		renderCutout(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		renderCutout(IcariaBlocks.YELLOW_STAGHORN.get());
		renderCutout(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		renderCutout(IcariaBlocks.BLUE_STORMCOTTON.get());
		renderCutout(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		renderCutout(IcariaBlocks.PINK_STORMCOTTON.get());
		renderCutout(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		renderCutout(IcariaBlocks.PURPLE_STORMCOTTON.get());
		renderCutout(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		renderCutout(IcariaBlocks.SUNKETTLE.get());
		renderCutout(IcariaBlocks.POTTED_SUNKETTLE.get());
		renderCutout(IcariaBlocks.SUNSPONGE.get());
		renderCutout(IcariaBlocks.POTTED_SUNSPONGE.get());
		renderCutout(IcariaBlocks.VOIDLILY.get());
		renderCutout(IcariaBlocks.POTTED_VOIDLILY.get());
		renderCutout(IcariaBlocks.PSILOCYBOS.get());
		renderCutout(IcariaBlocks.ROWAN.get());
		renderCutout(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		renderCutout(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		renderCutout(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		renderCutout(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		renderCutout(IcariaBlocks.RED_GROUND_FLOWERS.get());
		renderCutout(IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		renderCutout(IcariaBlocks.PALM_FERN.get());
		renderCutout(IcariaBlocks.POTTED_PALM_FERN.get());
		renderCutout(IcariaBlocks.WHITE_BROMELIA.get());
		renderCutout(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		renderCutout(IcariaBlocks.ORANGE_BROMELIA.get());
		renderCutout(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		renderCutout(IcariaBlocks.PINK_BROMELIA.get());
		renderCutout(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		renderCutout(IcariaBlocks.PURPLE_BROMELIA.get());
		renderCutout(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
		renderCutout(IcariaBlocks.STRAWBERRY_BUSH.get());
		renderCutout(IcariaBlocks.SPELT_CROP.get());
		renderCutout(IcariaBlocks.STRAWBERRY_CROP.get());
		renderCutout(IcariaBlocks.PHYSALIS_CROP.get());
		renderCutout(IcariaBlocks.ONION_CROP.get());
		renderCutout(IcariaBlocks.GREEK_FIRE.get());

		// RENDER TRANSLUCENT
		renderTranslucent(IcariaBlocks.ARISTONE.get());
		renderTranslucent(IcariaBlocks.JELLYFISH_JELLY_BLOCK.get());
		renderTranslucent(IcariaBlocks.CALCITE_BLOCK.get());
		renderTranslucent(IcariaBlocks.HALITE_BLOCK.get());
		renderTranslucent(IcariaBlocks.ZIRCON_BLOCK.get());
		renderTranslucent(IcariaBlocks.ICARIA_PORTAL.get());
		renderTranslucent(IcariaFluids.HYLIASTRUM_FLUID_SOURCE.get());
		renderTranslucent(IcariaFluids.HYLIASTRUM_FLUID_FLOWING.get());
		renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER_SOURCE.get());
		renderTranslucent(IcariaFluids.MEDITERRANEAN_WATER_FLOWING.get());
		renderTranslucent(IcariaFluids.UPWARDS_FLUID_SOURCE.get());
		renderTranslucent(IcariaFluids.UPWARDS_FLUID_FLOWING.get());

		// ENTITY RENDERERS
		EntityRenderers.register(IcariaEntities.BIDENT.get(), BidentRenderer::new);
		EntityRenderers.register(IcariaEntities.GREEK_FIRE_GRENADE.get(), GreekFireGrenadeRenderer::new);

		// BLOCK ENTITY RENDERERS
		BlockEntityRenderers.register(IcariaBlockEntities.CRYSTAL.get(), CrystalBlockRenderer::new);
		BlockEntityRenderers.register(IcariaBlockEntities.SIGN.get(), IcariaSignBlockRenderer::new);
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
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_STUFFING.get();
			if (player.getFoodData().getFoodLevel() <= 0) {
				if (offhandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (entity instanceof Player player) {
			float health = player.getHealth();
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNDROWNING.get();
			if (player.getAirSupply() <= 0) {
				if (offhandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		if (entity instanceof Player player) {
			float health = player.getHealth();
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNDYING.get();
			if (damage >= health) {
				if (offhandItem.getItem().equals(totem)) {
					event.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					event.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}

		DamageSource source = event.getSource();
		if (source instanceof EntityDamageSource damageSource) {
			Entity entitySource = damageSource.getEntity();
			if (entitySource instanceof Player player) {
				ItemStack mainHandItem = player.getMainHandItem();
				ItemStack offhandItem = player.getOffhandItem();
				TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
				if (mainHandItem.getItem() instanceof TieredItem || mainHandItem.getItem() instanceof TridentItem) {
					if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
						if (offhandItem.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
							offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}
					}
				}
			}
		}

		if (entity instanceof Player player) {
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			for (int slot = 5; slot < 9; slot++) {
				ItemStack armor = player.inventoryMenu.slots.get(slot).getItem();
				if (armor.getItem() instanceof ArmorItem) {
					if (armor.getDamageValue() >= (armor.getMaxDamage() * 0.9)) {
						if (offhandItem.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}

						if (mainHandItem.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
							totem.totemAnimation(player);
						}
					}
				}
			}
		}

		if (entity instanceof Player player) {
			float health = player.getHealth();
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSINKING.get();
			if (player.position().y <= -64) {
				if (offhandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}
			}
		}
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player player) {
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof FishingRodItem || mainHandItem.getItem() instanceof BowItem || mainHandItem.getItem() instanceof CrossbowItem || mainHandItem.getItem() instanceof ShieldItem || mainHandItem.getItem() instanceof TridentItem || mainHandItem.getItem() instanceof BidentItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offhandItem.getItem() instanceof FishingRodItem || offhandItem.getItem() instanceof BowItem || offhandItem.getItem() instanceof CrossbowItem || offhandItem.getItem() instanceof ShieldItem || offhandItem.getItem() instanceof TridentItem || offhandItem.getItem() instanceof BidentItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof ShearsItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offhandItem.getItem() instanceof ShearsItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof TieredItem || mainHandItem.getItem() instanceof ShearsItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem() instanceof AxeItem || mainHandItem.getItem() instanceof HoeItem || mainHandItem.getItem() instanceof ShovelItem || mainHandItem.getItem() instanceof FlintAndSteelItem) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1));
						offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
						totem.totemAnimation(player);
					}
				}
			}

			if (offhandItem.getItem() instanceof AxeItem || offhandItem.getItem() instanceof HoeItem || offhandItem.getItem() instanceof ShovelItem || offhandItem.getItem() instanceof FlintAndSteelItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
				ItemStack stack = player.getInventory().getItem(slot);
				if (stack.getItem().equals(Items.TORCH)) {
					int size = stack.getCount();
					player.getInventory().removeItem(stack);
					player.getInventory().add(slot, new ItemStack(IcariaItems.DIM_TORCH.get(), size));
				}
			}
		} else {
			for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
				ItemStack stack = player.getInventory().getItem(slot);
				if (stack.getItem().equals(IcariaItems.DIM_TORCH.get())) {
					int size = stack.getCount();
					player.getInventory().removeItem(stack);
					player.getInventory().add(slot, new ItemStack(Items.TORCH, size));
				}
			}
		}
	}

	@Override
	public void onPotionApplicable(MobEffectEvent.Applicable event) {
		Entity entity = event.getEntity();
		MobEffectInstance effect = event.getEffectInstance();
		if (entity instanceof Player player) {
			ItemStack mainHandItem = player.getMainHandItem();
			ItemStack offhandItem = player.getOffhandItem();
			TotemItem totem = IcariaItems.TOTEM_OF_UNBLINDING.get();
			if (effect.getEffect().equals(MobEffects.BLINDNESS)) {
				if (offhandItem.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					offhandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					totem.totemAnimation(player);
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
