package com.axanthic.icaria.common.events;

import com.axanthic.icaria.common.block.DeadLogBlock;
import com.axanthic.icaria.common.block.IcariaLogBlock;
import com.axanthic.icaria.common.block.LootVaseBlock;
import com.axanthic.icaria.common.entity.IcariaBarrelEntity;
import com.axanthic.icaria.common.entity.LootVaseEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.DaggerItem;
import com.axanthic.icaria.common.item.ScytheItem;
import com.axanthic.icaria.common.network.packet.LootVasePacket;
import com.axanthic.icaria.common.network.packet.TotemPacket;
import com.axanthic.icaria.common.registry.*;

import com.mojang.brigadier.arguments.IntegerArgumentType;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
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
	public static void onBlockToolModification(BlockEvent.BlockToolModificationEvent pEvent) {
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.GRASSY_MARL.get(), IcariaBlocks.FARMLAND.get(), ItemAbilities.HOE_TILL, true);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.MARL.get(), IcariaBlocks.FARMLAND.get(), ItemAbilities.HOE_TILL, true);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.COARSE_MARL.get(), IcariaBlocks.MARL.get(), ItemAbilities.HOE_TILL, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DRY_LAKE_BED.get(), IcariaBlocks.COARSE_MARL.get(), ItemAbilities.HOE_TILL, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.CYPRESS_WOOD.get(), IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DROUGHTROOT_WOOD.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.FIR_WOOD.get(), IcariaBlocks.STRIPPED_FIR_WOOD.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.FIR_LOG.get(), IcariaBlocks.STRIPPED_FIR_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DEAD_FIR_LOG.get(), IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.LAUREL_WOOD.get(), IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.OLIVE_WOOD.get(), IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DEAD_OLIVE_LOG.get(), IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.PLANE_WOOD.get(), IcariaBlocks.STRIPPED_PLANE_WOOD.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.POPULUS_WOOD.get(), IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get(), ItemAbilities.AXE_STRIP, false);
		IcariaCommonGameEvents.toolModification(pEvent, IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), ItemAbilities.AXE_STRIP, false);
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
	public static void onEntityInteract(PlayerInteractEvent.EntityInteract pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
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
	public static void onOnDatapackSync(OnDatapackSyncEvent pEvent) {
		pEvent.sendRecipes(IcariaRecipeTypes.ENTITY_CONCOCTING.get());
		pEvent.sendRecipes(IcariaRecipeTypes.EXPLOSION_CONCOCTING.get());
		pEvent.sendRecipes(IcariaRecipeTypes.FIRING.get());
		pEvent.sendRecipes(IcariaRecipeTypes.FORGING.get());
		pEvent.sendRecipes(IcariaRecipeTypes.GRINDING.get());
		pEvent.sendRecipes(IcariaRecipeTypes.ITEM_CONCOCTING.get());
		pEvent.sendRecipes(IcariaRecipeTypes.POTION_CONCOCTING.get());
	}

	@SubscribeEvent
	public static void onPlayerDestroyItem(PlayerDestroyItemEvent pEvent) {
		IcariaCommonGameEvents.unshatteringTotem(pEvent, IcariaItems.TOTEM_OF_UNSHATTERING.get());
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Pre pEvent) {
		IcariaCommonGameEvents.lootVase(pEvent);
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

	public static void lootVase(PlayerTickEvent.Pre pEvent) {
		var player = pEvent.getEntity();

		var level = player.level();

		var entity = IcariaCommonGameEvents.entity(pEvent, player);

		var f = Mth.sin(player.getXRot() * IcariaValues.DEG_2_RAD);
		var g = Mth.cos(player.getXRot() * IcariaValues.DEG_2_RAD);
		var h = Mth.sin(player.getYRot() * IcariaValues.DEG_2_RAD);
		var i = Mth.cos(player.getYRot() * IcariaValues.DEG_2_RAD);

		var strength = player.isCrouching() ? 1.0F : 0.0F;

		var lootVase = player.getData(IcariaAttachmentTypes.LOOT_VASE);

		if (IcariaCommonHelper.canCarry(player) && lootVase) {
			entity.moveTo(player.blockPosition().above(2), 0.0F, 0.0F);
			entity.setDeltaMovement(-h * g * strength, -f, i * g * strength);
			level.addFreshEntity(entity);
			player.setData(IcariaAttachmentTypes.LOOT_VASE, false);
		} else if (!level.isClientSide() && lootVase) {
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40));
			PacketDistributor.sendToAllPlayers(new LootVasePacket(player.getData(IcariaAttachmentTypes.LOOT_VASE), player.getId(), player.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_POS), player.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE)));
		}
	}

	public static void sendPacket(Item pItem, Player pPlayer) {
		if (pPlayer instanceof ServerPlayer serverPlayer) {
			PacketDistributor.sendToAllPlayers(new TotemPacket(serverPlayer.getId(), new ItemStack(pItem)));
		}
	}

	public static void toolModification(BlockEvent.BlockToolModificationEvent pEvent, Block pBlockOld, Block pBlockNew, ItemAbility pItemAbility, boolean pCheckAbove) {
		var useOnContext = pEvent.getContext();
		if (pEvent.getItemAbility() == pItemAbility) {
			var state = useOnContext.getLevel().getBlockState(useOnContext.getClickedPos());
			if (state.is(pBlockOld)) {
				var flag = !useOnContext.getLevel().getBlockState(useOnContext.getClickedPos().above()).isAir() && pCheckAbove;
				if (!flag) {
					if (state.getBlock() instanceof DeadLogBlock) {
						pEvent.setFinalState(pBlockNew.defaultBlockState().setValue(BlockStateProperties.AXIS, state.getValue(BlockStateProperties.AXIS)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, state.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)).setValue(BlockStateProperties.WATERLOGGED, state.getValue(BlockStateProperties.WATERLOGGED)));
					} else if (state.getBlock() instanceof IcariaLogBlock) {
						pEvent.setFinalState(pBlockNew.defaultBlockState().setValue(BlockStateProperties.AXIS, state.getValue(BlockStateProperties.AXIS)).setValue(IcariaBlockStateProperties.PLAYER_PLACED, state.getValue(IcariaBlockStateProperties.PLAYER_PLACED)));
					} else if (state.getBlock() instanceof RotatedPillarBlock) {
						pEvent.setFinalState(pBlockNew.defaultBlockState().setValue(BlockStateProperties.AXIS, state.getValue(BlockStateProperties.AXIS)));
					} else {
						pEvent.setFinalState(pBlockNew.defaultBlockState());
					}
				}
			}
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

	public static Entity entity(PlayerTickEvent.Pre pEvent, Player pPlayer) {
		if (pPlayer.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE).getBlock() instanceof LootVaseBlock) {
			return new LootVaseEntity(IcariaEntityTypes.LOOT_VASE.get(), pEvent.getEntity().level(), pPlayer.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE), pPlayer.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_POS));
		} else {
			return new IcariaBarrelEntity(IcariaEntityTypes.BARREL.get(), pEvent.getEntity().level(), pPlayer.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE), pPlayer.getData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_POS));
		}
	}
}
