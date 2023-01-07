package com.axanthic.icaria.common.proxy;

import javax.annotation.ParametersAreNonnullByDefault;

import com.axanthic.icaria.client.model.AeternaeModel;
import com.axanthic.icaria.client.model.AeternaeSkullModel;
import com.axanthic.icaria.client.model.ArganHoundModel;
import com.axanthic.icaria.client.model.ArganHoundSkullModel;
import com.axanthic.icaria.client.model.CatoblepasModel;
import com.axanthic.icaria.client.model.CatoblepasSkullModel;
import com.axanthic.icaria.client.model.CerverModel;
import com.axanthic.icaria.client.model.CerverSkullModel;
import com.axanthic.icaria.client.model.HyliasterModel;
import com.axanthic.icaria.client.model.MyrmekeDroneModel;
import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.client.model.MyrmekeSoldierModel;
import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.client.model.SowModel;
import com.axanthic.icaria.client.model.SowSkullModel;
import com.axanthic.icaria.client.screen.GrinderScreen;
import com.axanthic.icaria.client.screen.StorageVaseScreen;
import com.axanthic.icaria.common.entity.AeternaeEntity;
import com.axanthic.icaria.common.entity.ArganHoundEntity;
import com.axanthic.icaria.common.entity.CatoblepasEntity;
import com.axanthic.icaria.common.entity.CerverEntity;
import com.axanthic.icaria.common.entity.HyliasterEntity;
import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;
import com.axanthic.icaria.common.entity.SowEntity;
import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.TotemItem;
import com.axanthic.icaria.common.registry.IcariaCompostables;
import com.axanthic.icaria.common.registry.IcariaDimensions;
import com.axanthic.icaria.common.registry.IcariaEffects;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaFlammables;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaMenus;
import com.axanthic.icaria.common.registry.IcariaPottables;
import com.axanthic.icaria.common.registry.IcariaStrippables;
import com.axanthic.icaria.common.registry.IcariaWoodTypes;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.IcariaBlockStates;
import com.axanthic.icaria.data.IcariaBlockTags;
import com.axanthic.icaria.data.IcariaFluidTags;
import com.axanthic.icaria.data.IcariaItemModels;
import com.axanthic.icaria.data.IcariaItemTags;
import com.axanthic.icaria.data.IcariaLang;
import com.axanthic.icaria.data.IcariaLootTables;
import com.axanthic.icaria.data.IcariaRecipes;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TridentItem;
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

@ParametersAreNonnullByDefault

public class CommonProxy {	
	public CommonProxy() {

	}

	public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(IcariaEntities.AETERNAE.get(), AeternaeEntity.registerAttributes().build());
		event.put(IcariaEntities.ARGAN_HOUND.get(), ArganHoundEntity.registerAttributes().build());
		event.put(IcariaEntities.CATOBLEPAS.get(), CatoblepasEntity.registerAttributes().build());
		event.put(IcariaEntities.CERVER.get(), CerverEntity.registerAttributes().build());
		event.put(IcariaEntities.HYLIASTER.get(), HyliasterEntity.registerAttributes().build());
		event.put(IcariaEntities.MYRMEKE_DRONE.get(), MyrmekeDroneEntity.registerAttributes().build());
		event.put(IcariaEntities.MYRMEKE_SOLDIER.get(), MyrmekeSoldierEntity.registerAttributes().build());
		event.put(IcariaEntities.MYRMEKE_QUEEN.get(), MyrmekeQueenEntity.registerAttributes().build());
		event.put(IcariaEntities.SOW.get(), SowEntity.registerAttributes().build());
	}

	public void onFMLClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.CYPRESS));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.DROUGHTROOT));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.FIR));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.LAUREL));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.OLIVE));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.PLANE));
		event.enqueueWork(() -> Sheets.addWoodType(IcariaWoodTypes.POPULUS));

		event.enqueueWork(() -> MenuScreens.register(IcariaMenus.STORAGE_VASE.get(), StorageVaseScreen::new));
		event.enqueueWork(() -> MenuScreens.register(IcariaMenus.GRINDER.get(), GrinderScreen::new));

		ItemProperties.register(IcariaItems.GREEK_FIRE_GRENADE.get(), new ResourceLocation(IcariaInfo.MODID, "throwing"), (pStack, pLevel, pEntity, pId) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);

		for (IcariaItems.ToolSet tools : IcariaItems.TOOLS) {
			ItemProperties.register(tools.BIDENT.get(), new ResourceLocation(IcariaInfo.MODID, "throwing"), (pStack, pLevel, pEntity, pId) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
		}
	}

	public void onFMLCommonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(IcariaCompostables::setup);
		event.enqueueWork(IcariaFlammables::setup);
		event.enqueueWork(IcariaPottables::setup);
		event.enqueueWork(IcariaStrippables::setup);
		event.enqueueWork(IcariaWoodTypes::setup);
	}

	public void onFMLLoadComplete() {

	}

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

	public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(AeternaeModel.LAYER_LOCATION, AeternaeModel::createLayer);
		event.registerLayerDefinition(AeternaeSkullModel.LAYER_LOCATION, AeternaeSkullModel::createLayer);
		event.registerLayerDefinition(ArganHoundModel.LAYER_LOCATION, ArganHoundModel::createLayer);
		event.registerLayerDefinition(ArganHoundSkullModel.LAYER_LOCATION, ArganHoundSkullModel::createLayer);
		event.registerLayerDefinition(CatoblepasModel.LAYER_LOCATION, CatoblepasModel::createLayer);
		event.registerLayerDefinition(CatoblepasSkullModel.LAYER_LOCATION, CatoblepasSkullModel::createLayer);
		event.registerLayerDefinition(CerverModel.LAYER_LOCATION, CerverModel::createLayer);
		event.registerLayerDefinition(CerverSkullModel.LAYER_LOCATION, CerverSkullModel::createLayer);
		event.registerLayerDefinition(HyliasterModel.INNER_LAYER_LOCATION, HyliasterModel::createInnerLayer);
		event.registerLayerDefinition(HyliasterModel.OUTER_LAYER_LOCATION, HyliasterModel::createOuterLayer);
		event.registerLayerDefinition(MyrmekeDroneModel.LAYER_LOCATION, MyrmekeDroneModel::createLayer);
		event.registerLayerDefinition(MyrmekeSoldierModel.LAYER_LOCATION, MyrmekeSoldierModel::createLayer);
		event.registerLayerDefinition(MyrmekeQueenModel.LAYER_LOCATION, MyrmekeQueenModel::createLayer);
		event.registerLayerDefinition(OrichalcumHelmetModel.LAYER_LOCATION, OrichalcumHelmetModel::createLayer);
		event.registerLayerDefinition(SowModel.LAYER_LOCATION, SowModel::createLayer);
		event.registerLayerDefinition(SowSkullModel.LAYER_LOCATION, SowSkullModel::createLayer);
	}

	public void onEntityAttributeModification(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, ForgeMod.ATTACK_RANGE.get());
	}

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
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.removeEffect(MobEffects.HUNGER);
					player.getFoodData().setSaturation(20);
					player.getFoodData().setFoodLevel(20);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setAirSupply(300);
					player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
				}

				if (mainHandItem.getItem().equals(totem)) {
					event.setCanceled(true);
					player.setHealth(1);
					player.removeAllEffects();
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900));
					player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
						}

						if (mainHandItem.getItem().equals(totem)) {
							player.awardStat(Stats.ITEM_USED.get(totem));
							armor.setDamageValue((int) (armor.getItem().getMaxDamage(armor) * 0.1));
							mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
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
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.setHealth(health + damage);
					player.setPos(player.position().x, 320, player.position().z);
					player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
				}
			}
		}
	}

	public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
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
				}

				if (mainHandItem.getItem().equals(totem)) {
					player.addEffect(new MobEffectInstance(IcariaEffects.BLINDNESS_IMMUNITY.get(), 600));
					player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600));
					player.awardStat(Stats.ITEM_USED.get(totem));
					mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
				}
			}
		}
	}

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
					}
				}
			}

			if (offhandItem.getItem() instanceof FishingRodItem || offhandItem.getItem() instanceof BowItem || offhandItem.getItem() instanceof CrossbowItem || offhandItem.getItem() instanceof ShieldItem || offhandItem.getItem() instanceof TridentItem || offhandItem.getItem() instanceof BidentItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					}
				}
			}
		}
	}

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
					}
				}
			}

			if (offhandItem.getItem() instanceof ShearsItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					}
				}
			}
		}
	}

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
					}
				}
			}
		}
	}

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
					}
				}
			}

			if (offhandItem.getItem() instanceof AxeItem || offhandItem.getItem() instanceof HoeItem || offhandItem.getItem() instanceof ShovelItem || offhandItem.getItem() instanceof FlintAndSteelItem) {
				if (offhandItem.getDamageValue() >= (offhandItem.getMaxDamage() * 0.9)) {
					if (mainHandItem.getItem().equals(totem)) {
						player.awardStat(Stats.ITEM_USED.get(totem));
						offhandItem.setDamageValue((int) (offhandItem.getItem().getMaxDamage(offhandItem) * 0.1));
						mainHandItem.hurtAndBreak(1, player, (playerUsing) -> playerUsing.broadcastBreakEvent(player.getUsedItemHand()));
					}
				}
			}
		}
	}

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

	public void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {

	}
}
