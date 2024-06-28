package com.axanthic.icaria.common.events;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.ScytheItem;
import com.axanthic.icaria.common.network.TotemPacket;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaMobEffects;
import com.axanthic.icaria.common.registry.IcariaPotions;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = IcariaInfo.ID)
public class CommonGameEvents {

	@SubscribeEvent
	public static void onBreak(BlockEvent.BreakEvent pEvent) {
		var level = pEvent.getLevel();
		var player = pEvent.getPlayer();
		var pos = pEvent.getPos();
		var stack = player.getMainHandItem();
		if (stack.getItem() instanceof ScytheItem) {
			if (stack.isCorrectToolForDrops(level.getBlockState(pos))) {
				for (var blockPos : BlockPos.withinManhattan(pos, 1, 1, 1)) {
					if (stack.isCorrectToolForDrops(level.getBlockState(blockPos))) {
						level.destroyBlock(blockPos, true, player);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingIncomingDamage(LivingIncomingDamageEvent pEvent) {
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
					mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.removeEffect(MobEffects.HUNGER);
					player.setHealth(health + amount);
					CommonGameEvents.sendPacket(totem, player);
				} else if (offhandItem.getItem().equals(totem)) {
					foodData.setFoodLevel(20);
					foodData.setSaturation(20.0F);
					offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.removeEffect(MobEffects.HUNGER);
					player.setHealth(health + amount);
					CommonGameEvents.sendPacket(totem, player);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNDROWNING.get();
			if (player.getAirSupply() <= 0) {
				if (mainHandItem.getItem().equals(totem)) {
					mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.setAirSupply(300);
					player.setHealth(health + amount);
					CommonGameEvents.sendPacket(totem, player);
				} else if (offhandItem.getItem().equals(totem)) {
					offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.setAirSupply(300);
					player.setHealth(health + amount);
					CommonGameEvents.sendPacket(totem, player);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNSINKING.get();
			if (player.blockPosition().getY() <= -64) {
				if (mainHandItem.getItem().equals(totem)) {
					mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.moveTo(player.blockPosition().getX() + 0.5D, 320, player.blockPosition().getZ() + 0.5D);
					player.setHealth(health + amount);
					CommonGameEvents.sendPacket(totem, player);
				} else if (offhandItem.getItem().equals(totem)) {
					offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					player.moveTo(player.blockPosition().getX() + 0.5D, 320, player.blockPosition().getZ() + 0.5D);
					player.setHealth(health + amount);
					CommonGameEvents.sendPacket(totem, player);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			for (int slot = 5; slot < 9; slot++) {
				var itemStack = player.inventoryMenu.slots.get(slot).getItem();
				if (itemStack.getItem() instanceof ArmorItem) {
					if (itemStack.getDamageValue() >= (itemStack.getMaxDamage() * 0.9F)) {
						if (mainHandItem.getItem().equals(totem)) {
							itemStack.setDamageValue((int) (itemStack.getItem().getMaxDamage(itemStack) * 0.1F));
							mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
							player.awardStat(Stats.ITEM_USED.get(totem));
							CommonGameEvents.sendPacket(totem, player);
						} else if (offhandItem.getItem().equals(totem)) {
							itemStack.setDamageValue((int) (itemStack.getItem().getMaxDamage(itemStack) * 0.1F));
							offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
							player.awardStat(Stats.ITEM_USED.get(totem));
							CommonGameEvents.sendPacket(totem, player);
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
						mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
						player.awardStat(Stats.ITEM_USED.get(totem));
						CommonGameEvents.sendPacket(totem, player);
					}
				}
			} else if (offhandItem.getItem().equals(totem)) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem() instanceof TieredItem || mainHandItem.getItem() instanceof TridentItem) {
						mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
						offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
						player.awardStat(Stats.ITEM_USED.get(totem));
						CommonGameEvents.sendPacket(totem, player);
					}
				}
			}

			if (player.hasEffect(IcariaMobEffects.LIFESTEAL)) {
				player.heal(amount);
			}
		}
	}

	@SubscribeEvent
	public static void onMobEffectApplicable(MobEffectEvent.Applicable pEvent) {
		var effectInstance = pEvent.getEffectInstance();
		var totem = IcariaItems.TOTEM_OF_UNBLINDING.get();
		if (effectInstance != null) {
			var effect = effectInstance.getEffect();
			if (pEvent.getEntity() instanceof Player player) {
				var mainHandItem = player.getMainHandItem();
				var offhandItem = player.getOffhandItem();
				if (effect.equals(MobEffects.BLINDNESS) || effect.equals(MobEffects.DARKNESS)) {
					if (mainHandItem.getItem().equals(totem)) {
						mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
						player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY, 600));
						player.awardStat(Stats.ITEM_USED.get(totem));
						CommonGameEvents.sendPacket(totem, player);
					} else if (offhandItem.getItem().equals(totem)) {
						offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
						player.addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY, 600));
						player.awardStat(Stats.ITEM_USED.get(totem));
						CommonGameEvents.sendPacket(totem, player);
					}
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
					mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof BidentItem || mainHandItem.getItem() instanceof BowItem || mainHandItem.getItem() instanceof CrossbowItem || mainHandItem.getItem() instanceof FishingRodItem || mainHandItem.getItem() instanceof ShieldItem || mainHandItem.getItem() instanceof TridentItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
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
					mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof ShearsItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
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
					mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof ShearsItem || mainHandItem.getItem() instanceof TieredItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
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
					mainHandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1F));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof AxeItem || mainHandItem.getItem() instanceof FlintAndSteelItem || mainHandItem.getItem() instanceof HoeItem || mainHandItem.getItem() instanceof ShovelItem) {
					mainHandItem.setDamageValue((int) (mainHandItem.getItem().getMaxDamage(mainHandItem) * 0.1F));
					offhandItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					player.awardStat(Stats.ITEM_USED.get(totem));
					CommonGameEvents.sendPacket(totem, player);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onRegisterBrewingRecipes(RegisterBrewingRecipesEvent pEvent) {
		pEvent.getBuilder().addMix(Potions.AWKWARD, IcariaItems.BLINDWEED.get(), IcariaPotions.BLINDNESS);
		pEvent.getBuilder().addMix(Potions.AWKWARD, IcariaItems.SNULL_CREAM.get(), IcariaPotions.NAUSEA);
		pEvent.getBuilder().addMix(Potions.AWKWARD, Items.WITHER_ROSE, IcariaPotions.WITHER);
	}

	public static void sendPacket(Item pItem, Player pPlayer) {
		if (pPlayer instanceof ServerPlayer serverPlayer) {
			PacketDistributor.sendToPlayer(serverPlayer, new TotemPacket(new ItemStack(pItem), Holder.direct(SoundEvents.TOTEM_USE)));
		}
	}
}
