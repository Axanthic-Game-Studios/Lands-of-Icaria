package com.axanthic.icaria.common.events;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.DaggerItem;
import com.axanthic.icaria.common.item.ScytheItem;
import com.axanthic.icaria.common.network.packet.IcariaTotemPacket;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaMobEffects;
import com.axanthic.icaria.common.registry.IcariaPotions;

import com.mojang.brigadier.arguments.IntegerArgumentType;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
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
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.entity.player.ArrowLooseEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerDestroyItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = IcariaIdents.ID)
public class IcariaCommonGameEvents {

	@SubscribeEvent
	public static void onArmorHurt(ArmorHurtEvent pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
	}

	@SubscribeEvent
	public static void onArrowLoose(ArrowLooseEvent pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
	}

	@SubscribeEvent
	public static void onAttackEntity(AttackEntityEvent pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
	}

	@SubscribeEvent
	public static void onBreak(BlockEvent.BreakEvent pEvent) {
		var pos = pEvent.getPos();
		var player = pEvent.getPlayer();
		var levelAccessor = pEvent.getLevel();
		var itemStack = player.getMainHandItem();
		for (var blockPos : BlockPos.withinManhattan(pos, 1, 1, 1)) {
			if (itemStack.getItem() instanceof ScytheItem) {
				if (itemStack.isCorrectToolForDrops(levelAccessor.getBlockState(pos))) {
					if (itemStack.isCorrectToolForDrops(levelAccessor.getBlockState(blockPos))) {
						levelAccessor.destroyBlock(blockPos, true, player);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingIncomingDamage(LivingIncomingDamageEvent pEvent) {
		IcariaCommonGameEvents.lifesteal(pEvent);
		IcariaCommonGameEvents.stuffingTotem(pEvent, IcariaItems.TOTEM_OF_STUFFING.get());
		IcariaCommonGameEvents.undrowningTotem(pEvent, IcariaItems.TOTEM_OF_UNDROWNING.get());
		IcariaCommonGameEvents.undyingTotem(pEvent, IcariaItems.TOTEM_OF_UNDYING.get());
		IcariaCommonGameEvents.unsinkingTotem(pEvent, IcariaItems.TOTEM_OF_UNSINKING.get());
	}

	@SubscribeEvent
	public static void onLivingShieldBlock(LivingShieldBlockEvent pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
	}

	@SubscribeEvent
	public static void onPlayerDestroyItem(PlayerDestroyItemEvent pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
	}

	@SubscribeEvent
	public static void onPlayerInteract(PlayerInteractEvent.EntityInteract pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Pre pEvent) {
		IcariaCommonGameEvents.unblindingTotem(pEvent, IcariaItems.TOTEM_OF_UNBLINDING.get());
	}

	@SubscribeEvent
	public static void onRegisterBrewingRecipes(RegisterBrewingRecipesEvent pEvent) {
		pEvent.getBuilder().addMix(Potions.AWKWARD, IcariaItems.BLINDWEED.get(), IcariaPotions.BLINDNESS);
		pEvent.getBuilder().addMix(Potions.AWKWARD, IcariaItems.SNULL_CREAM.get(), IcariaPotions.NAUSEA);
		pEvent.getBuilder().addMix(Potions.AWKWARD, Items.WITHER_ROSE, IcariaPotions.WITHER);
	}

	@SubscribeEvent
	public static void onRegisterCommands(RegisterCommandsEvent pEvent) {
		pEvent.getDispatcher().register(Commands.literal("heal").requires((commandSourceStack) -> commandSourceStack.hasPermission(2)).executes((commandContext) -> IcariaCommonGameEvents.heal(commandContext.getSource(), Integer.MAX_VALUE)).then(Commands.argument("amount", IntegerArgumentType.integer(0)).executes((commandContext) -> IcariaCommonGameEvents.heal(commandContext.getSource(), IntegerArgumentType.getInteger(commandContext, "amount")))));
	}

	public static int heal(CommandSourceStack pCommandSourceStack, int pAmount) {
		if (pCommandSourceStack.getPlayer() != null) {
			pCommandSourceStack.getPlayer().heal(pAmount);
			pCommandSourceStack.sendSuccess(() -> Component.translatable("command" + "." + IcariaIdents.ID + "." + "heal" + "." + "success"), true);
			return 1;
		} else {
			return 0;
		}
	}

	public static void lifesteal(LivingIncomingDamageEvent pEvent) {
		if (pEvent.getSource().getEntity() instanceof Player player && player.hasEffect(IcariaMobEffects.LIFESTEAL)) {
			player.heal(pEvent.getAmount());
		}
	}

	public static void stuffingTotem(LivingIncomingDamageEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.stuffingTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.stuffingTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem());
	}

	public static void stuffingTotem(LivingIncomingDamageEvent pEvent, Item pItem, ItemStack pTotem) {
		if (pEvent.getEntity() instanceof Player player) {
			if (pEvent.getSource() == player.level().damageSources().starve()) {
				if (pTotem.getItem() == pItem) {
					pEvent.setCanceled(true);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(pItem));
					player.getFoodData().setFoodLevel(20);
					player.getFoodData().setSaturation(20.0F);
					player.removeEffect(MobEffects.HUNGER);
					pTotem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, player);
				}
			}
		}
	}

	public static void unblindingTotem(PlayerTickEvent.Pre pEvent, Item pItem) {
		IcariaCommonGameEvents.unblindingTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.unblindingTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem());
	}

	public static void unblindingTotem(PlayerTickEvent.Pre pEvent, Item pItem, ItemStack pTotem) {
		if (!pEvent.getEntity().hasEffect(IcariaMobEffects.BLINDNESS_IMMUNITY)) {
			if (pEvent.getEntity().hasEffect(MobEffects.BLINDNESS) || pEvent.getEntity().hasEffect(MobEffects.DARKNESS)) {
				if (pTotem.getItem() == pItem) {
					pEvent.getEntity().addEffect(new MobEffectInstance(IcariaMobEffects.BLINDNESS_IMMUNITY, 600));
					pEvent.getEntity().awardStat(Stats.ITEM_USED.get(pItem));
					pTotem.hurtAndBreak(1, pEvent.getEntity(), LivingEntity.getSlotForHand(pEvent.getEntity().getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, pEvent.getEntity());
				}
			}
		}
	}

	public static void undrowningTotem(LivingIncomingDamageEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.undrowningTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.undrowningTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem());
	}

	public static void undrowningTotem(LivingIncomingDamageEvent pEvent, Item pItem, ItemStack pTotem) {
		if (pEvent.getEntity() instanceof Player player) {
			if (pEvent.getSource() == player.level().damageSources().drown()) {
				if (pTotem.getItem() == pItem) {
					pEvent.setCanceled(true);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(pItem));
					player.setAirSupply(300);
					pTotem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, player);
				}
			}
		}
	}

	public static void undyingTotem(LivingIncomingDamageEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.undyingTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.undyingTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem());
	}

	public static void undyingTotem(LivingIncomingDamageEvent pEvent, Item pItem, ItemStack pTotem) {
		if (pEvent.getEntity() instanceof Player player) {
			if (pEvent.getSource() != player.level().damageSources().fellOutOfWorld() && pEvent.getAmount() >= player.getHealth()) {
				if (pTotem.getItem() == pItem) {
					pEvent.setCanceled(true);
					player.setHealth(2.0F);
					player.removeAllEffects();
					player.awardStat(Stats.ITEM_USED.get(pItem));
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
					player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
					pTotem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, player);
				}
			}
		}
	}

	public static void unshatteringTotem(ArmorHurtEvent pEvent, Item pItem) {
		for (var slot = 0; slot < 4; slot++) {
			if (pEvent.getEntity() instanceof Player player) {
				IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, player.getInventory().getArmor(slot), pEvent.getEntity().getMainHandItem());
				IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, player.getInventory().getArmor(slot), pEvent.getEntity().getOffhandItem());
			}
		}
	}

	public static void unshatteringTotem(ArmorHurtEvent pEvent, Item pItem, ItemStack pStack, ItemStack pTotem) {
		if (pEvent.getEntity() instanceof Player player) {
			if (pStack.getDamageValue() >= pStack.getMaxDamage() * 0.7F) {
				if (pStack.getItem() instanceof ArmorItem) {
					if (pTotem.getItem() == pItem) {
						player.awardStat(Stats.ITEM_USED.get(pItem));
						pStack.setDamageValue((int) (pStack.getMaxDamage() * 0.3F));
						pTotem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
						IcariaCommonGameEvents.sendPacket(pItem, player);
					}
				}
			}
		}
	}

	public static void unshatteringTotem(ArrowLooseEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem(), pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem(), pEvent.getEntity().getOffhandItem());
	}

	public static void unshatteringTotem(ArrowLooseEvent pEvent, Item pItem, ItemStack pStack, ItemStack pTotem) {
		if (pStack.getDamageValue() >= pStack.getMaxDamage() * 0.7F) {
			if (pStack.getItem() instanceof BowItem || pStack.getItem() instanceof CrossbowItem) {
				if (pTotem.getItem() == pItem) {
					pEvent.getEntity().awardStat(Stats.ITEM_USED.get(pItem));
					pStack.setDamageValue((int) (pStack.getMaxDamage() * 0.3F));
					pTotem.hurtAndBreak(1, pEvent.getEntity(), LivingEntity.getSlotForHand(pEvent.getEntity().getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, pEvent.getEntity());
				}
			}
		}
	}

	public static void unshatteringTotem(AttackEntityEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem(), pEvent.getEntity().getOffhandItem());
	}

	public static void unshatteringTotem(AttackEntityEvent pEvent, Item pItem, ItemStack pStack, ItemStack pTotem) {
		if (pStack.getDamageValue() >= pStack.getMaxDamage() * 0.7F) {
			if (pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof BidentItem || pStack.getItem() instanceof DaggerItem || pStack.getItem() instanceof HoeItem || pStack.getItem() instanceof MaceItem || pStack.getItem() instanceof PickaxeItem || pStack.getItem() instanceof ShovelItem || pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof TridentItem) {
				if (pTotem.getItem() == pItem) {
					pEvent.getEntity().awardStat(Stats.ITEM_USED.get(pItem));
					pStack.setDamageValue((int) (pStack.getMaxDamage() * 0.3F));
					pTotem.hurtAndBreak(1, pEvent.getEntity(), LivingEntity.getSlotForHand(pEvent.getEntity().getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, pEvent.getEntity());
				}
			}
		}
	}

	public static void unshatteringTotem(LivingShieldBlockEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem(), pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem(), pEvent.getEntity().getOffhandItem());
	}

	public static void unshatteringTotem(LivingShieldBlockEvent pEvent, Item pItem, ItemStack pStack, ItemStack pTotem) {
		if (pEvent.getEntity() instanceof Player player) {
			if (pStack.getDamageValue() >= pStack.getMaxDamage() * 0.7F) {
				if (pStack.getItem() instanceof ShieldItem) {
					if (pTotem.getItem() == pItem) {
						player.awardStat(Stats.ITEM_USED.get(pItem));
						pStack.setDamageValue((int) (pStack.getMaxDamage() * 0.3F));
						pTotem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
						IcariaCommonGameEvents.sendPacket(pItem, player);
					}
				}
			}
		}
	}

	public static void unshatteringTotem(PlayerDestroyItemEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getOriginal(), pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getOriginal(), pEvent.getEntity().getOffhandItem());
	}

	public static void unshatteringTotem(PlayerDestroyItemEvent pEvent, Item pItem, ItemStack pStack, ItemStack pTotem) {
		if (pEvent.getHand() != null) {
			if (pStack.getDamageValue() >= pStack.getMaxDamage() * 0.7F) {
				if (pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof BidentItem || pStack.getItem() instanceof DaggerItem || pStack.getItem() instanceof FlintAndSteelItem || pStack.getItem() instanceof HoeItem || pStack.getItem() instanceof MaceItem || pStack.getItem() instanceof PickaxeItem || pStack.getItem() instanceof ShearsItem || pStack.getItem() instanceof ShovelItem || pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof TridentItem) {
					if (pTotem.getItem() == pItem) {
						pEvent.getEntity().awardStat(Stats.ITEM_USED.get(pItem));
						pEvent.getEntity().setItemInHand(pEvent.getHand(), pStack);
						pStack.setDamageValue((int) (pStack.getMaxDamage() * 0.3F));
						pTotem.hurtAndBreak(1, pEvent.getEntity(), LivingEntity.getSlotForHand(pEvent.getEntity().getUsedItemHand()));
						IcariaCommonGameEvents.sendPacket(pItem, pEvent.getEntity());
					}
				}
			}
		}
	}

	public static void unshatteringTotem(PlayerInteractEvent.EntityInteract pEvent, Item pItem) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem(), pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.unshatteringTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem(), pEvent.getEntity().getOffhandItem());
	}

	public static void unshatteringTotem(PlayerInteractEvent.EntityInteract pEvent, Item pItem, ItemStack pStack, ItemStack pTotem) {
		if (pStack.getDamageValue() >= pStack.getMaxDamage() * 0.7F) {
			if (pStack.getItem() instanceof BrushItem || pStack.getItem() instanceof ShearsItem) {
				if (pTotem.getItem() == pItem) {
					pEvent.getEntity().awardStat(Stats.ITEM_USED.get(pItem));
					pStack.setDamageValue((int) (pStack.getMaxDamage() * 0.3F));
					pTotem.hurtAndBreak(1, pEvent.getEntity(), LivingEntity.getSlotForHand(pEvent.getEntity().getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, pEvent.getEntity());
				}
			}
		}
	}

	public static void unsinkingTotem(LivingIncomingDamageEvent pEvent, Item pItem) {
		IcariaCommonGameEvents.unsinkingTotem(pEvent, pItem, pEvent.getEntity().getMainHandItem());
		IcariaCommonGameEvents.unsinkingTotem(pEvent, pItem, pEvent.getEntity().getOffhandItem());
	}

	public static void unsinkingTotem(LivingIncomingDamageEvent pEvent, Item pItem, ItemStack pTotem) {
		if (pEvent.getEntity() instanceof Player player) {
			if (pEvent.getSource() == player.level().damageSources().fellOutOfWorld()) {
				if (pTotem.getItem() == pItem) {
					pEvent.setCanceled(true);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(pItem));
					player.teleportTo(player.blockPosition().getX() + 0.5D, pEvent.getEntity().level().getMaxY(), player.blockPosition().getZ() + 0.5D);
					pTotem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					IcariaCommonGameEvents.sendPacket(pItem, player);
				}
			}
		}
	}

	public static void sendPacket(Item pItem, Player pPlayer) {
		if (pPlayer instanceof ServerPlayer serverPlayer) {
			PacketDistributor.sendToPlayer(serverPlayer, new IcariaTotemPacket(new ItemStack(pItem), Holder.direct(SoundEvents.TOTEM_USE)));
		}
	}
}
