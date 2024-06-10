package com.axanthic.icaria.common.events;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaMobEffects;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = IcariaInfo.ID)
public class CommonForgeEvents {

	@SubscribeEvent
	public static void onLivingAttack(LivingAttackEvent pEvent) {
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

	@SubscribeEvent
	public static void onMobEffectApplicable(MobEffectEvent.Applicable pEvent) {
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

	@SubscribeEvent
	public static void onPlayerInteract(PlayerInteractEvent.RightClickItem pEvent) {
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

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteract pEvent) {
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

	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock pEvent) {
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

	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock pEvent) {
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
}
