package com.axanthic.icaria.data.advancements;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaDimensions;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
    public static final ResourceLocation BACKGROUND = new ResourceLocation(IcariaInfo.ID, "textures/block/sunstone_bricks.png");
    public static final ResourceLocation CHERT_PICKAXE = new ResourceLocation(IcariaInfo.ID, "chert_pickaxe");
    public static final ResourceLocation CHALKOS_PICKAXE = new ResourceLocation(IcariaInfo.ID, "chalkos_pickaxe");
    public static final ResourceLocation KASSITEROS_PICKAXE = new ResourceLocation(IcariaInfo.ID, "kassiteros_pickaxe");
    public static final ResourceLocation ORICHALCUM_PICKAXE = new ResourceLocation(IcariaInfo.ID, "orichalcum_pickaxe");
    public static final ResourceLocation VANADIUMSTEEL_PICKAXE = new ResourceLocation(IcariaInfo.ID, "vanadiumsteel_pickaxe");
    public static final ResourceLocation SIDEROS_PICKAXE = new ResourceLocation(IcariaInfo.ID, "sideros_pickaxe");
    public static final ResourceLocation MOLYBDENUMSTEEL_PICKAXE = new ResourceLocation(IcariaInfo.ID, "molybdenumsteel_pickaxe");

    @Override
    public void generate(HolderLookup.Provider pProvider, Consumer<Advancement> pConsumer, ExistingFileHelper pHelper) {
        var rootTrigger = ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(IcariaDimensions.ICARIA);
        var captainRevenantTrigger = KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(IcariaEntityTypes.CAPTAIN_REVENANT.get()));
        var lootVaseTrigger = EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(IcariaEntityTypes.LOOT_VASE.get()).build());
        var storageVaseTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.STORAGE_VASE.get());
        var chertPickaxeTrigger = RecipeCraftedTrigger.TriggerInstance.craftedItem(IcariaSimpleAdvancements.CHERT_PICKAXE);
        var chalkosPickaxeTrigger = RecipeCraftedTrigger.TriggerInstance.craftedItem(IcariaSimpleAdvancements.CHALKOS_PICKAXE);
        var kilnTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.KILN.get());
        var kassiterosPickaxeTrigger = RecipeCraftedTrigger.TriggerInstance.craftedItem(IcariaSimpleAdvancements.KASSITEROS_PICKAXE);
        var forgeTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.FORGE.get());
        var orichalcumPickaxeTrigger = RecipeCraftedTrigger.TriggerInstance.craftedItem(IcariaSimpleAdvancements.ORICHALCUM_PICKAXE);
        var grinderTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.GRINDER.get());
        var fertilizingTrigger = ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(IcariaBlocks.FERTILIZED_FARMLAND.get()).build()), ItemPredicate.Builder.item().of(IcariaItems.CALCITE_DUST.get()));
        var vanadiumsteelPickaxeTrigger = RecipeCraftedTrigger.TriggerInstance.craftedItem(IcariaSimpleAdvancements.VANADIUMSTEEL_PICKAXE);
        var kettleTrigger = ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(IcariaBlocks.KETTLE.get());
        var siderosPickaxeTrigger = RecipeCraftedTrigger.TriggerInstance.craftedItem(IcariaSimpleAdvancements.SIDEROS_PICKAXE);
        var molybdenumsteelPickaxeTrigger = RecipeCraftedTrigger.TriggerInstance.craftedItem(IcariaSimpleAdvancements.MOLYBDENUMSTEEL_PICKAXE);

        var root = IcariaSimpleAdvancements.advancement("root", rootTrigger, pConsumer, IcariaItems.GRASSY_MARL, FrameType.TASK, true, true, false);
        var captainRevenant = IcariaSimpleAdvancements.advancement("captain_revenant", captainRevenantTrigger, root, pConsumer, IcariaItems.REVENANT_SKULL, FrameType.TASK, true, true, false);
        var lootVase = IcariaSimpleAdvancements.advancement("loot_vase", lootVaseTrigger, root, pConsumer, IcariaItems.CYAN_LOOT_VASE, FrameType.TASK, true, true, false);
        var storageVase = IcariaSimpleAdvancements.advancement("storage_vase", storageVaseTrigger, root, pConsumer, IcariaItems.STORAGE_VASE, FrameType.TASK, true, true, false);
        var chertPickaxe = IcariaSimpleAdvancements.advancement("chert_pickaxe", chertPickaxeTrigger, root, pConsumer, IcariaItems.CHERT_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var chalkosPickaxe = IcariaSimpleAdvancements.advancement("chalkos_pickaxe", chalkosPickaxeTrigger, chertPickaxe, pConsumer, IcariaItems.CHALKOS_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var kiln = IcariaSimpleAdvancements.advancement("kiln", kilnTrigger, chertPickaxe, pConsumer, IcariaItems.KILN, FrameType.TASK, true, true, false);
        var kassiterosPickaxe = IcariaSimpleAdvancements.advancement("kassiteros_pickaxe", kassiterosPickaxeTrigger, chalkosPickaxe, pConsumer, IcariaItems.KASSITEROS_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var forge = IcariaSimpleAdvancements.advancement("forge", forgeTrigger, chalkosPickaxe, pConsumer, IcariaItems.FORGE, FrameType.TASK, true, true, false);
        var orichalcumPickaxe = IcariaSimpleAdvancements.advancement("orichalcum_pickaxe", orichalcumPickaxeTrigger, kassiterosPickaxe, pConsumer, IcariaItems.ORICHALCUM_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var grinder = IcariaSimpleAdvancements.advancement("grinder", grinderTrigger, kassiterosPickaxe, pConsumer, IcariaItems.GRINDER, FrameType.TASK, true, true, false);
        var fertilizing = IcariaSimpleAdvancements.advancement("fertilizing", fertilizingTrigger, grinder, pConsumer, IcariaItems.CALCITE_DUST, FrameType.TASK, true, true, false);
        var vanadiumsteelPickaxe = IcariaSimpleAdvancements.advancement("vanadiumsteel_pickaxe", vanadiumsteelPickaxeTrigger, orichalcumPickaxe, pConsumer, IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var kettle = IcariaSimpleAdvancements.advancement("kettle", kettleTrigger, orichalcumPickaxe, pConsumer, IcariaItems.KETTLE, FrameType.TASK, true, true, false);
        var siderosPickaxe = IcariaSimpleAdvancements.advancement("sideros_pickaxe", siderosPickaxeTrigger, vanadiumsteelPickaxe, pConsumer, IcariaItems.SIDEROS_TOOLS.pickaxe, FrameType.TASK, true, true, false);
        var molybdenumsteelPickaxe = IcariaSimpleAdvancements.advancement("molybdenumsteel_pickaxe", molybdenumsteelPickaxeTrigger, siderosPickaxe, pConsumer, IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe, FrameType.TASK, true, true, false);
    }

    public static Advancement advancement(String pKey, AbstractCriterionTriggerInstance pTrigger, Consumer<Advancement> pConsumer, RegistryObject<Item> pItem, FrameType pFrame, boolean pToast, boolean pChat, boolean pHidden) {
        return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem.get(), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "description"), IcariaSimpleAdvancements.BACKGROUND, pFrame, pToast, pChat, pHidden).save(pConsumer, IcariaInfo.ID + ":" + pKey);
    }

    public static Advancement advancement(String pKey, AbstractCriterionTriggerInstance pTrigger, Advancement pParent, Consumer<Advancement> pConsumer, RegistryObject<Item> pItem, FrameType pFrame, boolean pToast, boolean pChat, boolean pHidden) {
        return Advancement.Builder.advancement().addCriterion(pKey, pTrigger).display(pItem.get(), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "title"), Component.translatable("advancement" + "." + IcariaInfo.ID + "." + pKey + "." + "description"), IcariaSimpleAdvancements.BACKGROUND, pFrame, pToast, pChat, pHidden).parent(pParent).save(pConsumer, IcariaInfo.ID + ":" + pKey);
    }
}
