package com.axanthic.icaria.data.provider.advancement;

import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.data.registry.IcariaDimensions;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAdvancementSubProvider implements AdvancementSubProvider {

	@Override
	public void generate(HolderLookup.Provider pProvider, Consumer<AdvancementHolder> pConsumer) {
		var arachneReward = AdvancementRewards.Builder.experience(100).build();
		var captainRevenantReward = AdvancementRewards.Builder.experience(100).build();

		var rootTrigger = ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(IcariaDimensions.ICARIA);
		var arachneTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(pProvider.lookupOrThrow(Registries.ENTITY_TYPE), IcariaEntityTypes.ARACHNE.get()));
		var barrelTrigger = EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(pProvider.lookupOrThrow(Registries.ENTITY_TYPE), IcariaEntityTypes.BARREL.get()));
		var captainRevenantTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(pProvider.lookupOrThrow(Registries.ENTITY_TYPE), IcariaEntityTypes.CAPTAIN_REVENANT.get()));
		var chertPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.CHERT_PICKAXE.get());
		var chestTrigger = ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(pProvider.lookupOrThrow(Registries.BLOCK), IcariaBlocks.CHEST.get())), ItemPredicate.Builder.item().of(pProvider.lookupOrThrow(Registries.ITEM), IcariaItems.CHEST_LABEL.get()));
		var fertilizedFarmlandTrigger = ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(pProvider.lookupOrThrow(Registries.BLOCK), IcariaBlocks.FERTILIZED_FARMLAND.get())), ItemPredicate.Builder.item().of(pProvider.lookupOrThrow(Registries.ITEM), IcariaItems.CALCITE_DUST.get()));
		var lootVaseTrigger = EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(pProvider.lookupOrThrow(Registries.ENTITY_TYPE), IcariaEntityTypes.LOOT_VASE.get()));
		var storageVaseTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.STORAGE_VASE.get());
		var chalkosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.CHALKOS_PICKAXE.get());
		var kilnTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.KILN.get());
		var kassiterosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.KASSITEROS_PICKAXE.get());
		var forgeTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.FORGE.get());
		var orichalcumPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.ORICHALCUM_PICKAXE.get());
		var grinderTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.GRINDER.get());
		var vanadiumsteelPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.VANADIUMSTEEL_PICKAXE.get());
		var kettleTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.KETTLE.get());
		var siderosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.SIDEROS_PICKAXE.get());
		var hyliasterTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(pProvider.lookupOrThrow(Registries.ENTITY_TYPE), IcariaEntityTypes.HYLIASTER.get()));
		var molybdenumsteelPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());

		var root = IcariaAdvancementSubProvider.advancement("root", IcariaItems.GRASSY_MARL.get(), rootTrigger, pConsumer, AdvancementType.TASK, true, false, true);
		var arachne = IcariaAdvancementSubProvider.advancement("arachne", IcariaItems.ARACHNE_STRING.get(), arachneTrigger, pConsumer, AdvancementType.CHALLENGE, arachneReward, root, true, false, true);
		var barrel = IcariaAdvancementSubProvider.advancement("barrel", IcariaItems.LAUREL_BARREL.get(), barrelTrigger, pConsumer, AdvancementType.TASK, root, true, false, true);
		var captainRevenant = IcariaAdvancementSubProvider.advancement("captain_revenant", Items.BONE, captainRevenantTrigger, pConsumer, AdvancementType.CHALLENGE, captainRevenantReward, root, true, false, true);
		var chertPickaxe = IcariaAdvancementSubProvider.advancement("chert_pickaxe", IcariaItems.CHERT_PICKAXE.get(), chertPickaxeTrigger, pConsumer, AdvancementType.TASK, root, true, false, true);
		var chest = IcariaAdvancementSubProvider.chest("chest", pProvider, IcariaItems.CHEST.get(), chestTrigger, pConsumer, AdvancementType.TASK, root, true, false, true);
		var fertilizedFarmland = IcariaAdvancementSubProvider.advancement("fertilized_farmland", IcariaItems.CALCITE_DUST.get(), fertilizedFarmlandTrigger, pConsumer, AdvancementType.TASK, root, true, false, true);
		var lootVase = IcariaAdvancementSubProvider.advancement("loot_vase", IcariaItems.CYAN_LOOT_VASE.get(), lootVaseTrigger, pConsumer, AdvancementType.TASK, root, true, false, true);
		var storageVase = IcariaAdvancementSubProvider.storageVase("storage_vase", IcariaItems.STORAGE_VASE.get(), storageVaseTrigger, pConsumer, AdvancementType.TASK, root, true, false, true);
		var chalkosPickaxe = IcariaAdvancementSubProvider.advancement("chalkos_pickaxe", IcariaItems.CHALKOS_PICKAXE.get(), chalkosPickaxeTrigger, pConsumer, AdvancementType.TASK, chertPickaxe, true, false, true);
		var kiln = IcariaAdvancementSubProvider.advancement("kiln", IcariaItems.KILN.get(), kilnTrigger, pConsumer, AdvancementType.GOAL, chertPickaxe, true, false, true);
		var kassiterosPickaxe = IcariaAdvancementSubProvider.advancement("kassiteros_pickaxe", IcariaItems.KASSITEROS_PICKAXE.get(), kassiterosPickaxeTrigger, pConsumer, AdvancementType.TASK, chalkosPickaxe, true, false, true);
		var forge = IcariaAdvancementSubProvider.advancement("forge", IcariaItems.FORGE.get(), forgeTrigger, pConsumer, AdvancementType.GOAL, chalkosPickaxe, true, false, true);
		var orichalcumPickaxe = IcariaAdvancementSubProvider.advancement("orichalcum_pickaxe", IcariaItems.ORICHALCUM_PICKAXE.get(), orichalcumPickaxeTrigger, pConsumer, AdvancementType.TASK, kassiterosPickaxe, true, false, true);
		var grinder = IcariaAdvancementSubProvider.advancement("grinder", IcariaItems.GRINDER.get(), grinderTrigger, pConsumer, AdvancementType.GOAL, kassiterosPickaxe, true, false, true);
		var vanadiumsteelPickaxe = IcariaAdvancementSubProvider.advancement("vanadiumsteel_pickaxe", IcariaItems.VANADIUMSTEEL_PICKAXE.get(), vanadiumsteelPickaxeTrigger, pConsumer, AdvancementType.TASK, orichalcumPickaxe, true, false, true);
		var kettle = IcariaAdvancementSubProvider.advancement("kettle", IcariaItems.KETTLE.get(), kettleTrigger, pConsumer, AdvancementType.GOAL, orichalcumPickaxe, true, false, true);
		var siderosPickaxe = IcariaAdvancementSubProvider.advancement("sideros_pickaxe", IcariaItems.SIDEROS_PICKAXE.get(), siderosPickaxeTrigger, pConsumer, AdvancementType.TASK, vanadiumsteelPickaxe, true, false, true);
		var hyliaster = IcariaAdvancementSubProvider.advancement("hyliaster", IcariaItems.HYLIASTRUM_VIAL.get(), hyliasterTrigger, pConsumer, AdvancementType.GOAL, siderosPickaxe, true, false, true);
		var molybdenumsteelPickaxe = IcariaAdvancementSubProvider.advancement("molybdenumsteel_pickaxe", IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get(), molybdenumsteelPickaxeTrigger, pConsumer, AdvancementType.GOAL, siderosPickaxe, true, false, true);
	}

	public static AdvancementHolder storageVase(String pKey, Item pItem, Criterion<?> pTrigger, Consumer<AdvancementHolder> pConsumer, AdvancementType pAdvancementType, AdvancementHolder pParent, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).addCriterion("white_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.WHITE_STORAGE_VASE.get())).addCriterion("light_gray_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get())).addCriterion("gray_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.GRAY_STORAGE_VASE.get())).addCriterion("black_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.BLACK_STORAGE_VASE.get())).addCriterion("brown_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.BROWN_STORAGE_VASE.get())).addCriterion("red_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.RED_STORAGE_VASE.get())).addCriterion("orange_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.ORANGE_STORAGE_VASE.get())).addCriterion("yellow_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.YELLOW_STORAGE_VASE.get())).addCriterion("lime_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.LIME_STORAGE_VASE.get())).addCriterion("green_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.GREEN_STORAGE_VASE.get())).addCriterion("cyan_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.CYAN_STORAGE_VASE.get())).addCriterion("light_blue_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get())).addCriterion("blue_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.BLUE_STORAGE_VASE.get())).addCriterion("purple_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.PURPLE_STORAGE_VASE.get())).addCriterion("magenta_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.MAGENTA_STORAGE_VASE.get())).addCriterion("pink_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.PINK_STORAGE_VASE.get())).display(pItem, Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "description"), IcariaResourceLocations.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).parent(pParent).requirements(AdvancementRequirements.Strategy.OR).save(pConsumer, IcariaIdents.ID + ":" + pKey);
	}

	public static AdvancementHolder chest(String pKey, HolderLookup.Provider pProvider, Item pItem, Criterion<?> pTrigger, Consumer<AdvancementHolder> pConsumer, AdvancementType pAdvancementType, AdvancementHolder pParent, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).addCriterion("trapped_chest", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(pProvider.lookupOrThrow(Registries.BLOCK), IcariaBlocks.TRAPPED_CHEST.get())), ItemPredicate.Builder.item().of(pProvider.lookupOrThrow(Registries.ITEM), IcariaItems.CHEST_LABEL.get()))).display(pItem, Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "description"), IcariaResourceLocations.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).parent(pParent).requirements(AdvancementRequirements.Strategy.OR).save(pConsumer, IcariaIdents.ID + ":" + pKey);
	}

	public static AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, Consumer<AdvancementHolder> pConsumer, AdvancementType pAdvancementType, AdvancementRewards pReward, AdvancementHolder pParent, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem, Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "description"), IcariaResourceLocations.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).rewards(pReward).parent(pParent).save(pConsumer, IcariaIdents.ID + ":" + pKey);
	}

	public static AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, Consumer<AdvancementHolder> pConsumer, AdvancementType pAdvancementType, AdvancementRewards pReward, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem, Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "description"), IcariaResourceLocations.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).rewards(pReward).save(pConsumer, IcariaIdents.ID + ":" + pKey);
	}

	public static AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, Consumer<AdvancementHolder> pConsumer, AdvancementType pAdvancementType, AdvancementHolder pParent, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem, Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "description"), IcariaResourceLocations.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).parent(pParent).save(pConsumer, IcariaIdents.ID + ":" + pKey);
	}

	public static AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, Consumer<AdvancementHolder> pConsumer, AdvancementType pAdvancementType, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem, Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIdents.ID + "." + pKey + "." + "description"), IcariaResourceLocations.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).save(pConsumer, IcariaIdents.ID + ":" + pKey);
	}
}
