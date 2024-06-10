package com.axanthic.icaria.client.events;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaMobEffects;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = IcariaInfo.ID, value = Dist.CLIENT)
public class ClientForgeEvents {

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
					totem.totemAnimation(player);
				} else if (offhandItem.getItem().equals(totem)) {
					totem.totemAnimation(player);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNDROWNING.get();
			if (player.getAirSupply() <= 0) {
				if (mainHandItem.getItem().equals(totem)) {
					totem.totemAnimation(player);
				} else if (offhandItem.getItem().equals(totem)) {
					totem.totemAnimation(player);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNSINKING.get();
			if (player.blockPosition().getY() <= -64) {
				if (mainHandItem.getItem().equals(totem)) {
					totem.totemAnimation(player);
				} else if (offhandItem.getItem().equals(totem)) {
					totem.totemAnimation(player);
				}
			}

			totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
			for (int slot = 5; slot < 9; slot++) {
				var itemStack = player.inventoryMenu.slots.get(slot).getItem();
				if (itemStack.getItem() instanceof ArmorItem) {
					if (itemStack.getDamageValue() >= (itemStack.getMaxDamage() * 0.9F)) {
						if (mainHandItem.getItem().equals(totem)) {
							totem.totemAnimation(player);
						} else if (offhandItem.getItem().equals(totem)) {
							totem.totemAnimation(player);
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
						totem.totemAnimation(player);
					}
				}
			} else if (offhandItem.getItem().equals(totem)) {
				if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem() instanceof TieredItem || mainHandItem.getItem() instanceof TridentItem) {
						totem.totemAnimation(player);
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
					totem.totemAnimation(player);
				} else if (offhandItem.getItem().equals(totem)) {
					totem.totemAnimation(player);
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
					totem.totemAnimation(player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof ShearsItem) {
					totem.totemAnimation(player);
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
					totem.totemAnimation(player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof ShearsItem || mainHandItem.getItem() instanceof TieredItem) {
					totem.totemAnimation(player);
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
					totem.totemAnimation(player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof AxeItem || mainHandItem.getItem() instanceof FlintAndSteelItem || mainHandItem.getItem() instanceof HoeItem || mainHandItem.getItem() instanceof ShovelItem) {
					totem.totemAnimation(player);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem pEvent) {
		var player = pEvent.getEntity();
		var mainHandItem = player.getMainHandItem();
		var offhandItem = player.getOffhandItem();
		var totem = IcariaItems.TOTEM_OF_UNSHATTERING.get();
		if (mainHandItem.getItem().equals(totem)) {
			if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9F)) {
				if (offhandItem.getItem() instanceof BidentItem || offhandItem.getItem() instanceof BowItem || offhandItem.getItem() instanceof CrossbowItem || offhandItem.getItem() instanceof FishingRodItem || offhandItem.getItem() instanceof ShieldItem || offhandItem.getItem() instanceof TridentItem) {
					totem.totemAnimation(player);
				}
			}
		} else if (offhandItem.getItem().equals(totem)) {
			if (mainHandItem.getDamageValue() >= (mainHandItem.getMaxDamage() * 0.9F)) {
				if (mainHandItem.getItem() instanceof BidentItem || mainHandItem.getItem() instanceof BowItem || mainHandItem.getItem() instanceof CrossbowItem || mainHandItem.getItem() instanceof FishingRodItem || mainHandItem.getItem() instanceof ShieldItem || mainHandItem.getItem() instanceof TridentItem) {
					totem.totemAnimation(player);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> pEvent) {
		if (pEvent.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof IcariaSkullItem) {
			if (pEvent.getRenderer().getModel() instanceof PlayerModel<?> playerModel) {
				playerModel.hat.visible = false;
				playerModel.head.visible = false;
			}
		}
	}
}
