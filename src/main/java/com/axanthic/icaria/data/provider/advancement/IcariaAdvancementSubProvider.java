package com.axanthic.icaria.data.provider.advancement;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaDimensionIds;
import com.axanthic.icaria.common.registry.*;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.BlockPredicate;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.triggers.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAdvancementSubProvider extends AdvancementSubProvider {
	public IcariaAdvancementSubProvider(BootstrapContext<Advancement> pBootstrapContext) {
		super(pBootstrapContext);
	}

	@Override
	public void generate() {
		var blocks = this.output.lookup(Registries.BLOCK);
		var entityTypes = this.output.lookup(Registries.ENTITY_TYPE);
		var items = this.output.lookup(Registries.ITEM);

		var arachneReward = AdvancementRewards.Builder.experience(100).build();
		var captainRevenantReward = AdvancementRewards.Builder.experience(100).build();

		var rootTrigger = ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(IcariaDimensionIds.ICARIA);
		var arachneTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entityTypes, IcariaEntityTypes.ARACHNE.get()));
		var barrelTrigger = EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(entityTypes, IcariaEntityTypes.BARREL.get()));
		var captainRevenantTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entityTypes, IcariaEntityTypes.CAPTAIN_REVENANT.get()));
		var chertPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.CHERT_PICKAXE.get());
		var chestTrigger = ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blocks, IcariaBlocks.CHEST.get(), IcariaBlocks.TRAPPED_CHEST.get())), ItemPredicate.Builder.item().of(items, IcariaItems.CHEST_LABEL.get()));
		var fertilizedFarmlandTrigger = ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blocks, IcariaBlocks.FERTILIZED_FARMLAND.get())), ItemPredicate.Builder.item().of(items, IcariaItems.CALCITE_DUST.get()));
		var lootVaseTrigger = EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(entityTypes, IcariaEntityTypes.LOOT_VASE.get()));
		var storageVaseTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(AnyOfCondition.anyOf(MatchBlock.blockMatches(blocks, IcariaBlocks.STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.WHITE_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.GRAY_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.BLACK_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.BROWN_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.RED_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.ORANGE_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.YELLOW_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.LIME_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.GREEN_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.CYAN_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.BLUE_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.PURPLE_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.MAGENTA_STORAGE_VASE.get()), MatchBlock.blockMatches(blocks, IcariaBlocks.PINK_STORAGE_VASE.get())));
		var chalkosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.CHALKOS_PICKAXE.get());
		var kilnTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blocks, IcariaBlocks.KILN.get());
		var kassiterosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.KASSITEROS_PICKAXE.get());
		var forgeTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blocks, IcariaBlocks.FORGE.get());
		var orichalcumPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.ORICHALCUM_PICKAXE.get());
		var grinderTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blocks, IcariaBlocks.GRINDER.get());
		var vanadiumsteelPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.VANADIUMSTEEL_PICKAXE.get());
		var kettleTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blocks, IcariaBlocks.KETTLE.get());
		var siderosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.SIDEROS_PICKAXE.get());
		var hyliasterTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entityTypes, IcariaEntityTypes.HYLIASTER.get()));
		var molybdenumsteelPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());

		var root = this.advancement("root", IcariaItems.GRASSY_MARL.get(), rootTrigger, AdvancementType.TASK, true, false, true);
		var arachne = this.advancement("arachne", IcariaItems.ARACHNE_STRING.get(), arachneTrigger, AdvancementType.CHALLENGE, arachneReward, root, true, false, true);
		var barrel = this.advancement("barrel", IcariaItems.LAUREL_BARREL.get(), barrelTrigger, AdvancementType.TASK, root, true, false, true);
		var captainRevenant = this.advancement("captain_revenant", Items.BONE, captainRevenantTrigger, AdvancementType.CHALLENGE, captainRevenantReward, root, true, false, true);
		var chertPickaxe = this.advancement("chert_pickaxe", IcariaItems.CHERT_PICKAXE.get(), chertPickaxeTrigger, AdvancementType.TASK, root, true, false, true);
		var chest = this.advancement("chest", IcariaItems.CHEST.get(), chestTrigger, AdvancementType.TASK, root, true, false, true);
		var fertilizedFarmland = this.advancement("fertilized_farmland", IcariaItems.CALCITE_DUST.get(), fertilizedFarmlandTrigger, AdvancementType.TASK, root, true, false, true);
		var lootVase = this.advancement("loot_vase", IcariaItems.CYAN_LOOT_VASE.get(), lootVaseTrigger, AdvancementType.TASK, root, true, false, true);
		var storageVase = this.advancement("storage_vase", IcariaItems.STORAGE_VASE.get(), storageVaseTrigger, AdvancementType.TASK, root, true, false, true);
		var chalkosPickaxe = this.advancement("chalkos_pickaxe", IcariaItems.CHALKOS_PICKAXE.get(), chalkosPickaxeTrigger, AdvancementType.TASK, chertPickaxe, true, false, true);
		var kiln = this.advancement("kiln", IcariaItems.KILN.get(), kilnTrigger, AdvancementType.GOAL, chertPickaxe, true, false, true);
		var kassiterosPickaxe = this.advancement("kassiteros_pickaxe", IcariaItems.KASSITEROS_PICKAXE.get(), kassiterosPickaxeTrigger, AdvancementType.TASK, chalkosPickaxe, true, false, true);
		var forge = this.advancement("forge", IcariaItems.FORGE.get(), forgeTrigger, AdvancementType.GOAL, chalkosPickaxe, true, false, true);
		var orichalcumPickaxe = this.advancement("orichalcum_pickaxe", IcariaItems.ORICHALCUM_PICKAXE.get(), orichalcumPickaxeTrigger, AdvancementType.TASK, kassiterosPickaxe, true, false, true);
		var grinder = this.advancement("grinder", IcariaItems.GRINDER.get(), grinderTrigger, AdvancementType.GOAL, kassiterosPickaxe, true, false, true);
		var vanadiumsteelPickaxe = this.advancement("vanadiumsteel_pickaxe", IcariaItems.VANADIUMSTEEL_PICKAXE.get(), vanadiumsteelPickaxeTrigger, AdvancementType.TASK, orichalcumPickaxe, true, false, true);
		var kettle = this.advancement("kettle", IcariaItems.KETTLE.get(), kettleTrigger, AdvancementType.GOAL, orichalcumPickaxe, true, false, true);
		var siderosPickaxe = this.advancement("sideros_pickaxe", IcariaItems.SIDEROS_PICKAXE.get(), siderosPickaxeTrigger, AdvancementType.TASK, vanadiumsteelPickaxe, true, false, true);
		var hyliaster = this.advancement("hyliaster", IcariaItems.HYLIASTRUM_VIAL.get(), hyliasterTrigger, AdvancementType.GOAL, siderosPickaxe, true, false, true);
		var molybdenumsteelPickaxe = this.advancement("molybdenumsteel_pickaxe", IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get(), molybdenumsteelPickaxeTrigger, AdvancementType.GOAL, siderosPickaxe, true, false, true);
	}

	public AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, AdvancementType pAdvancementType, AdvancementRewards pReward, AdvancementHolder pParent, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem, Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "description"), pAdvancementType, pToast, pChat, pHidden).rewards(pReward).parent(pParent).save(this.output, IcariaIds.ID + ":" + pKey);
	}

	public AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, AdvancementType pAdvancementType, AdvancementRewards pReward, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).rootDisplay(pItem, Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "description"), IcariaIdentifiers.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).rewards(pReward).save(this.output, IcariaIds.ID + ":" + pKey);
	}

	public AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, AdvancementType pAdvancementType, AdvancementHolder pParent, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem, Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "description"), pAdvancementType, pToast, pChat, pHidden).parent(pParent).save(this.output, IcariaIds.ID + ":" + pKey);
	}

	public AdvancementHolder advancement(String pKey, Item pItem, Criterion<?> pTrigger, AdvancementType pAdvancementType, boolean pChat, boolean pHidden, boolean pToast) {
		return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).rootDisplay(pItem, Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaIds.ID + "." + pKey + "." + "description"), IcariaIdentifiers.SUNSTONE_BRICKS, pAdvancementType, pToast, pChat, pHidden).save(this.output, IcariaIds.ID + ":" + pKey);
	}
}
