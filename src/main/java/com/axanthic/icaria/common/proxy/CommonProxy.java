package com.axanthic.icaria.common.proxy;

import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.TotemItem;

import com.axanthic.icaria.common.registry.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.*;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.ForgeMod;
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

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class CommonProxy {
	public CommonProxy() {

	}

	public void onCreativeModeTabRegistration(CreativeModeTabEvent.Register pEvent) {

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
		pEvent.put(IcariaEntityTypes.HYLIASTER.get(), HyliasterEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.ENDER_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.FIRE_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.NATURE_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.VOID_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.WATER_JELLYFISH.get(), JellyfishEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.MYRMEKE_DRONE.get(), MyrmekeDroneEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), MyrmekeSoldierEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.MYRMEKE_QUEEN.get(), MyrmekeQueenEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.CRYSTAL_SLUG.get(), SlugEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.FOREST_SNULL.get(), SnullEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.SNULL.get(), SnullEntity.registerAttributes().build());
		pEvent.put(IcariaEntityTypes.SOW.get(), SowEntity.registerAttributes().build());
	}

	public void onFMLClientSetup(FMLClientSetupEvent pEvent) {

	}

	public void onFMLCommonSetup(FMLCommonSetupEvent pEvent) {
		pEvent.enqueueWork(IcariaCompostables::setup);
		pEvent.enqueueWork(IcariaFlammables::setup);
		pEvent.enqueueWork(IcariaPottables::setup);
		pEvent.enqueueWork(IcariaStrippables::setup);
		pEvent.enqueueWork(IcariaWoodTypes::setup);
	}

	public void onFMLLoadComplete(FMLLoadCompleteEvent pEvent) {

	}

	public void onGatherData(GatherDataEvent pEvent) {

	}

	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions pEvent) {

	}

	public void onEntityAttributeModification(EntityAttributeModificationEvent pEvent) {
		pEvent.add(EntityType.PLAYER, ForgeMod.ATTACK_RANGE.get());
	}

	public void onLivingAttack(LivingAttackEvent pEvent) {
		float damage = pEvent.getAmount();
		DamageSource source = pEvent.getSource();
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
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
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
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
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
				}

				if (mainHand.getItem().equals(totem)) {
					pEvent.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
				}
			}
		}

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
							offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
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
							offHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
						}

						if (mainHand.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
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
				}

				if (mainHand.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
				}
			}
		}

		if (source instanceof EntityDamageSource damageSource) {
			Entity entitySource = damageSource.getEntity();
			if (entitySource instanceof Player player) {
				if (player.hasEffect(IcariaMobEffects.LIFESTEAL.get())) {
					player.heal(damage);
				}
			}
		}
	}

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
				}

				if (mainHand.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
				}
			}
		}
	}

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
					}
				}
			}

			if (offHand.getItem() instanceof FishingRodItem || offHand.getItem() instanceof BowItem || offHand.getItem() instanceof CrossbowItem || offHand.getItem() instanceof ShieldItem || offHand.getItem() instanceof TridentItem || offHand.getItem() instanceof BidentItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					}
				}
			}
		}
	}

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
					}
				}
			}

			if (offHand.getItem() instanceof ShearsItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					}
				}
			}
		}
	}

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
					}
				}
			}
		}
	}

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
					}
				}
			}

			if (offHand.getItem() instanceof AxeItem || offHand.getItem() instanceof HoeItem || offHand.getItem() instanceof ShovelItem || offHand.getItem() instanceof FlintAndSteelItem) {
				if (offHand.getDamageValue() >= (offHand.getMaxDamage() * 0.9)) {
					if (mainHand.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offHand.setDamageValue((int) (offHand.getItem().getMaxDamage(offHand) * 0.1));
						mainHand.hurtAndBreak(1, player, (pPlayer) -> pPlayer.broadcastBreakEvent(player.getUsedItemHand()));
					}
				}
			}
		}
	}

	public void onPlayerTick(TickEvent.PlayerTickEvent pEvent) {
		Player player = pEvent.player;
		if (player.level.dimension() == IcariaDimensions.ICARIA) {
			for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
				ItemStack itemStack = player.getInventory().getItem(slot);
				if (itemStack.getItem().equals(Items.TORCH)) {
					int count = itemStack.getCount();
					player.getInventory().removeItem(itemStack);
					player.getInventory().add(slot, new ItemStack(IcariaItems.DIM_TORCH.get(), count));
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

	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> pEvent) {

	}
}
