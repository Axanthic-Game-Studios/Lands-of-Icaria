package com.axanthic.icaria.data.advancements;

import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSimpleAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider pProvider, Consumer<Advancement> pConsumer, ExistingFileHelper pHelper) {
        var rootTrigger = ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(IcariaDimensions.ICARIA);
        var arachneTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(IcariaEntityTypes.ARACHNE.get()));
        var captainRevenantTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(IcariaEntityTypes.CAPTAIN_REVENANT.get()));
        var chestTrigger = ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(IcariaBlocks.CHEST.get()).build()), ItemPredicate.Builder.item().of(IcariaItems.CHEST_LABEL.get()));
        var barrelTrigger = EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(IcariaEntityTypes.BARREL.get()).build());
        var lootVaseTrigger = EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(IcariaEntityTypes.LOOT_VASE.get()).build());
        var storageVaseTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.STORAGE_VASE.get());
        var chertPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.CHERT_TOOLS.pickaxe.get());
        var chalkosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.CHALKOS_TOOLS.pickaxe.get());
        var kilnTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.KILN.get());
        var kassiterosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.KASSITEROS_TOOLS.pickaxe.get());
        var forgeTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.FORGE.get());
        var orichalcumPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get());
        var grinderTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.GRINDER.get());
        var fertilizedFarmlandTrigger = ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(IcariaBlocks.FERTILIZED_FARMLAND.get()).build()), ItemPredicate.Builder.item().of(IcariaItems.CALCITE_DUST.get()));
        var vanadiumsteelPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get());
        var kettleTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.KETTLE.get());
        var siderosPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.SIDEROS_TOOLS.pickaxe.get());
        var molybdenumsteelPickaxeTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get());

        var root = IcariaSimpleAdvancements.advancement("root", rootTrigger, pConsumer, IcariaItems.GRASSY_MARL, FrameType.TASK, true, true, false);
        var arachne = IcariaSimpleAdvancements.advancement("arachne", arachneTrigger, root, pConsumer, IcariaItems.ARACHNE_STRING, FrameType.TASK, true, true, false);
        var captainRevenant = IcariaSimpleAdvancements.advancement("captain_revenant", captainRevenantTrigger, root, pConsumer, IcariaItems.REVENANT_SKULL, FrameType.TASK, true, true, false);
        var chest = IcariaSimpleAdvancements.icariaChest("chest", chestTrigger, root, pConsumer, IcariaItems.CHEST, FrameType.TASK, true, true, false);
        var barrel = IcariaSimpleAdvancements.advancement("barrel", barrelTrigger, root, pConsumer, IcariaItems.LAUREL_BARREL, FrameType.TASK, true, true, false);
        var lootVase = IcariaSimpleAdvancements.advancement("loot_vase", lootVaseTrigger, root, pConsumer, IcariaItems.CYAN_LOOT_VASE, FrameType.TASK, true, true, false);
        var storageVase = IcariaSimpleAdvancements.storageVase("storage_vase", storageVaseTrigger, root, pConsumer, IcariaItems.STORAGE_VASE, FrameType.TASK, true, true, false);
        var chertPickaxe = IcariaSimpleAdvancements.advancement("chert_pickaxe", chertPickaxeTrigger, root, pConsumer, IcariaItems.CHERT_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var chalkosPickaxe = IcariaSimpleAdvancements.advancement("chalkos_pickaxe", chalkosPickaxeTrigger, chertPickaxe, pConsumer, IcariaItems.CHALKOS_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var kiln = IcariaSimpleAdvancements.advancement("kiln", kilnTrigger, chertPickaxe, pConsumer, IcariaItems.KILN, FrameType.TASK, true, true, false);
        var kassiterosPickaxe = IcariaSimpleAdvancements.advancement("kassiteros_pickaxe", kassiterosPickaxeTrigger, chalkosPickaxe, pConsumer, IcariaItems.KASSITEROS_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var forge = IcariaSimpleAdvancements.advancement("forge", forgeTrigger, chalkosPickaxe, pConsumer, IcariaItems.FORGE, FrameType.TASK, true, true, false);
        var orichalcumPickaxe = IcariaSimpleAdvancements.advancement("orichalcum_pickaxe", orichalcumPickaxeTrigger, kassiterosPickaxe, pConsumer, IcariaItems.ORICHALCUM_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var grinder = IcariaSimpleAdvancements.advancement("grinder", grinderTrigger, kassiterosPickaxe, pConsumer, IcariaItems.GRINDER, FrameType.TASK, true, true, false);
        var fertilizedFarmland = IcariaSimpleAdvancements.advancement("fertilized_farmland", fertilizedFarmlandTrigger, grinder, pConsumer, IcariaItems.CALCITE_DUST, FrameType.TASK, true, true, false);
        var vanadiumsteelPickaxe = IcariaSimpleAdvancements.advancement("vanadiumsteel_pickaxe", vanadiumsteelPickaxeTrigger, orichalcumPickaxe, pConsumer, IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var kettle = IcariaSimpleAdvancements.advancement("kettle", kettleTrigger, orichalcumPickaxe, pConsumer, IcariaItems.KETTLE, FrameType.TASK, true, true, false);
        var siderosPickaxe = IcariaSimpleAdvancements.advancement("sideros_pickaxe", siderosPickaxeTrigger, vanadiumsteelPickaxe, pConsumer, IcariaItems.SIDEROS_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var molybdenumsteelPickaxe = IcariaSimpleAdvancements.advancement("molybdenumsteel_pickaxe", molybdenumsteelPickaxeTrigger, siderosPickaxe, pConsumer, IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe, FrameType.TASK, true, true, false);
    }

    public static Advancement advancement(String pKey, AbstractCriterionTriggerInstance pTrigger, Consumer<Advancement> pConsumer, RegistryObject<Item> pItem, FrameType pFrame, boolean pToast, boolean pChat, boolean pHidden) {
        return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem.get(), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "description"), IcariaResourceLocations.BACKGROUND, pFrame, pToast, pChat, pHidden).save(pConsumer, IcariaInfo.ID + ":" + pKey);
    }

    public static Advancement advancement(String pKey, AbstractCriterionTriggerInstance pTrigger, Advancement pParent, Consumer<Advancement> pConsumer, RegistryObject<Item> pItem, FrameType pFrame, boolean pToast, boolean pChat, boolean pHidden) {
        return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem.get(), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "description"), IcariaResourceLocations.BACKGROUND, pFrame, pToast, pChat, pHidden).parent(pParent).save(pConsumer, IcariaInfo.ID + ":" + pKey);
    }

    public static Advancement icariaChest(String pKey, AbstractCriterionTriggerInstance pTrigger, Advancement pParent, Consumer<Advancement> pConsumer, RegistryObject<Item> pItem, FrameType pFrame, boolean pToast, boolean pChat, boolean pHidden) {
        return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).addCriterion("trapped_chest", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(IcariaBlocks.TRAPPED_CHEST.get()).build()), ItemPredicate.Builder.item().of(IcariaItems.CHEST_LABEL.get()))).display(pItem.get(), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "description"), IcariaResourceLocations.BACKGROUND, pFrame, pToast, pChat, pHidden).parent(pParent).requirements(RequirementsStrategy.OR).save(pConsumer, IcariaInfo.ID + ":" + pKey);
    }

    public static Advancement storageVase(String pKey, AbstractCriterionTriggerInstance pTrigger, Advancement pParent, Consumer<Advancement> pConsumer, RegistryObject<Item> pItem, FrameType pFrame, boolean pToast, boolean pChat, boolean pHidden) {
        return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).addCriterion("white_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.WHITE_STORAGE_VASE.get())).addCriterion("light_gray_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get())).addCriterion("gray_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.GRAY_STORAGE_VASE.get())).addCriterion("black_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.BLACK_STORAGE_VASE.get())).addCriterion("brown_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.BROWN_STORAGE_VASE.get())).addCriterion("red_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.RED_STORAGE_VASE.get())).addCriterion("orange_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.ORANGE_STORAGE_VASE.get())).addCriterion("yellow_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.YELLOW_STORAGE_VASE.get())).addCriterion("lime_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.LIME_STORAGE_VASE.get())).addCriterion("green_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.GREEN_STORAGE_VASE.get())).addCriterion("cyan_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.CYAN_STORAGE_VASE.get())).addCriterion("light_blue_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get())).addCriterion("blue_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.BLUE_STORAGE_VASE.get())).addCriterion("purple_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.PURPLE_STORAGE_VASE.get())).addCriterion("magenta_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.MAGENTA_STORAGE_VASE.get())).addCriterion("pink_storage_vase", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.PINK_STORAGE_VASE.get())).display(pItem.get(), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "description"), IcariaResourceLocations.BACKGROUND, pFrame, pToast, pChat, pHidden).parent(pParent).requirements(RequirementsStrategy.OR).save(pConsumer, IcariaInfo.ID + ":" + pKey);
    }
}
