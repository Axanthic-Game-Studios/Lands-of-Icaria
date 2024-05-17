package com.axanthic.icaria.common.proxy;

import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.registry.*;

import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.levelgen.Heightmap;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

@ParametersAreNonnullByDefault

public class CommonProxy {
	public CommonProxy() {
		// NOOP
	}

	public void onCreativeModeTabRegistration(BuildCreativeModeTabContentsEvent pEvent) {
		// NOOP
	}

	public void onEntityAttributeCreation(EntityAttributeCreationEvent pEvent) {
		pEvent.put(IcariaEntityTypes.AETERNAE.get(), AeternaeEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ARACHNE.get(), ArachneEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ARACHNE_DRONE.get(), ArachneDroneEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ARGAN_HOUND.get(), ArganHoundEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CATOBLEPAS.get(), CatoblepasEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CERVER.get(), CerverEntity.registerAttributes().build());
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

	public void onFMLClientSetup(FMLClientSetupEvent pEvent) {
		// NOOP
	}

	public void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		pEvent.enqueueWork(IcariaCompostables::setup);
		pEvent.enqueueWork(IcariaFlammables::setup);
		pEvent.enqueueWork(IcariaPottables::setup);
		pEvent.enqueueWork(IcariaStrippables::setup);
		pEvent.enqueueWork(IcariaWoodTypes::setup);

		pEvent.enqueueWork(() -> this.setupBrewing(IcariaItems.BLINDWEED.get(), Potions.AWKWARD, IcariaPotions.BLINDNESS.get()));
		pEvent.enqueueWork(() -> this.setupBrewing(IcariaItems.SNULL_CREAM.get(), Potions.AWKWARD, IcariaPotions.NAUSEA.get()));
		pEvent.enqueueWork(() -> this.setupBrewing(Items.WITHER_ROSE, Potions.AWKWARD, IcariaPotions.WITHER.get()));
	}

	public void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {
		// NOOP
	}

	public void onGatherData(GatherDataEvent pEvent) {
		// NOOP
	}

	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {
		// NOOP
	}

	public void onSpawnPlacementRegister(SpawnPlacementRegisterEvent pEvent) {
		pEvent.register(IcariaEntityTypes.AETERNAE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AeternaeEntity::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ARACHNE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArachneEntity::checkAnyLightArachnidSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ARACHNE_DRONE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArachneDroneEntity::checkAnyLightArachnidSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ARGAN_HOUND.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArganHoundEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CATOBLEPAS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CatoblepasEntity::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CERVER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CerverEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.FIR_FOREST_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.PLANE_FOREST_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ForestHagEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.HYLIASTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HyliasterEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.ENDER_JELLYFISH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.FIRE_JELLYFISH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.NATURE_JELLYFISH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.VOID_JELLYFISH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.WATER_JELLYFISH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.MYRMEKE_DRONE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MyrmekeDroneEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MyrmekeSoldierEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.MYRMEKE_QUEEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MyrmekeQueenEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CAPTAIN_REVENANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CaptainRevenantEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CIVILIAN_REVENANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CivilianRevenantEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CRAWLER_REVENANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrawlerRevenantEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.OVERGROWN_REVENANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OvergrownRevenantEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.PYROMANCER_REVENANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PyromancerRevenantEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NetherPyromancerRevenantEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SOLDIER_REVENANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SoldierRevenantEntity::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SCORPION.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ScorpionEntity::checkArachnidSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.CRYSTAL_SLUG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SlugEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.FOREST_SNULL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnullEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SNULL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnullEntity::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SOLIFUGAE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SolifugaeEntity::checkArachnidSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.SOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SowEntity::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		pEvent.register(IcariaEntityTypes.VINEGAROON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, VinegaroonEntity::checkArachnidSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
	}

	public void onEntityAttributeModification(EntityAttributeModificationEvent pEvent) {
		pEvent.add(EntityType.PLAYER, ForgeMod.ENTITY_REACH.get());
	}

	public void onLivingAttack(LivingAttackEvent pEvent) {
		float amount = pEvent.getAmount();
		if (pEvent.getEntity() instanceof Player player) {
			float health = player.getHealth();
			var foodData = player.getFoodData();
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_STUFFING.get();
			if (foodData.getFoodLevel() <= 0) {
				if (mainHandItem.getItem().equals(totem)) {
					foodData.setFoodLevel(20);
					foodData.setSaturation(20.0F);
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.removeEffect(MobEffects.HUNGER);
					player.setHealth(health + amount);
				} else if (offhandItem.getItem().equals(totem)) {
					foodData.setFoodLevel(20);
					foodData.setSaturation(20.0F);
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.removeEffect(MobEffects.HUNGER);
					player.setHealth(health + amount);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNDROWNING.get();
			if (player.getAirSupply() <= 0) {
				if (mainHandItem.getItem().equals(totem)) {
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.setAirSupply(300);
					player.setHealth(health + amount);
				} else if (offhandItem.getItem().equals(totem)) {
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.setAirSupply(300);
					player.setHealth(health + amount);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNSINKING.get();
			if (player.blockPosition().getY() <= -64) {
				if (mainHandItem.getItem().equals(totem)) {
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.moveTo(player.blockPosition().getX() + 0.5D, 320, player.blockPosition().getZ() + 0.5D);
					player.setHealth(health + amount);
				} else if (offhandItem.getItem().equals(totem)) {
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.moveTo(player.blockPosition().getX() + 0.5D, 320, player.blockPosition().getZ() + 0.5D);
					player.setHealth(health + amount);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			for (int slot = 5; slot < 9; slot++) {
				var itemStack = player.inventoryMenu.slots.get(slot).getItem();
				if (itemStack.getItem() instanceof ArmorItem) {
					if (itemStack.getDamageValue() >= (itemStack.getMaxDamage() * 0.9F)) {
						if (mainHandItem.getItem().equals(totem)) {
							itemStack.setDamageValue((int) (itemStack.getItem().getMaxDamage(itemStack) * 0.1F));
							mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
							player.awardStat(Stats.ITEM_USED.get(totem));
						} else if (offhandItem.getItem().equals(totem)) {
							itemStack.setDamageValue((int) (itemStack.getItem().getMaxDamage(itemStack) * 0.1F));
							offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
							player.awardStat(Stats.ITEM_USED.get(totem));
						}
					}
				}
			}
		}

		if (pEvent.getSource().getEntity() instanceof Player player) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			if (mainHandItem.getItem().equals(totem)) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (offhandItem.getItem() instanceof TieredItem || offhandItem.getItem() instanceof TridentItem) {
						mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
						player.awardStat(Stats.ITEM_USED.get(totem));
					}
				}
			} else if (offhandItem.getItem().equals(totem)) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem() instanceof TieredItem || mainHandItem.getItem() instanceof TridentItem) {
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
						offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						player.awardStat(Stats.ITEM_USED.get(totem));
					}
				}
			}

			if (player.hasEffect(IcariaMobEffects.LIFESTEAL.get())) {
				player.heal(amount);
			}
		}
	}

	public void onMobEffectApplicable(MobEffectEvent.Applicable pEvent) {
		var mobEffect = pEvent.getEffectInstance().getEffect();
		var totem = IcariaItems.TOTEM_OF_UNBLINDING.get();
		if (pEvent.getEntity() instanceof Player player) {
			var mainHandItem = player.getMainHandItem();
			var offhandItem = player.getOffhandItem();
			if (mobEffect.equals(MobEffects.BLINDNESS) || mobEffect.equals(MobEffects.DARKNESS)) {
				if (mainHandItem.getItem().equals(totem)) {
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
				} else if (offhandItem.getItem().equals(totem)) {
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		}
	}

	public void onPlayerInteract(PlayerInteractEvent pEvent) {
		var player = pEvent.getEntity();
		var mainHandItem = player.getMainHandItem();
		var offhandItem = player.getOffhandItem();
		var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
		if (mainHandItem.getItem().equals(totem)) {
			if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9F)) {
				if (offhandItem.getItem() instanceof BidentItem || offhandItem.getItem() instanceof BowItem || offhandItem.getItem() instanceof CrossbowItem || offhandItem.getItem() instanceof FishingRodItem || offhandItem.getItem() instanceof ShieldItem || offhandItem.getItem() instanceof TridentItem) {
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof BidentItem || mainHandItem.getItem() instanceof BowItem || mainHandItem.getItem() instanceof CrossbowItem || mainHandItem.getItem() instanceof FishingRodItem || mainHandItem.getItem() instanceof ShieldItem || mainHandItem.getItem() instanceof TridentItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		}
	}

	public void onEntityInteract(PlayerInteractEvent.EntityInteract pEvent) {
		var player = pEvent.getEntity();
		var mainHandItem = player.getMainHandItem();
		var offhandItem = player.getOffhandItem();
		var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
		if (mainHandItem.getItem().equals(totem)) {
			if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9F)) {
				if (offhandItem.getItem() instanceof ShearsItem) {
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof ShearsItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		}
	}

	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock pEvent) {
		var player = pEvent.getEntity();
		var mainHandItem = player.getMainHandItem();
		var offhandItem = player.getOffhandItem();
		var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
		if (mainHandItem.getItem().equals(totem)) {
			if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9F)) {
				if (offhandItem.getItem() instanceof ShearsItem || offhandItem.getItem() instanceof TieredItem) {
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof ShearsItem || mainHandItem.getItem() instanceof TieredItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		}
	}

	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock pEvent) {
		var player = pEvent.getEntity();
		var mainHandItem = player.getMainHandItem();
		var offhandItem = player.getOffhandItem();
		var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
		if (mainHandItem.getItem().equals(totem)) {
			if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9F)) {
				if (offhandItem.getItem() instanceof AxeItem || offhandItem.getItem() instanceof FlintAndSteelItem || offhandItem.getItem() instanceof HoeItem || offhandItem.getItem() instanceof ShovelItem) {
					mainHandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof AxeItem || mainHandItem.getItem() instanceof FlintAndSteelItem || mainHandItem.getItem() instanceof HoeItem || mainHandItem.getItem() instanceof ShovelItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
				}
			}
		}
	}

	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> pEvent) {
		// NOOP
	}

	public void setupBrewing(Item pItem, Potion pPotion, Potion pResult) {
		var potion = new ItemStack(Items.POTION);
		BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(potion.copy(), pPotion)), Ingredient.of(pItem), PotionUtils.setPotion(potion.copy(), pResult));
	}
}
