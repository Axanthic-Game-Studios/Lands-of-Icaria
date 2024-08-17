package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaStoneDecoItems;
import com.axanthic.icaria.common.registry.IcariaWoodDecoItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemTags extends ItemTagsProvider {

	// ITEM TAGS

	public static final TagKey<Item> CROPS_SPELT = IcariaItemTags.cTag("crops/spelt");
	public static final TagKey<Item> CROPS_STRAWBERRIES = IcariaItemTags.cTag("crops/strawberry");
	public static final TagKey<Item> CROPS_GARLIC = IcariaItemTags.cTag("crops/garlic");
	public static final TagKey<Item> CROPS_ONION = IcariaItemTags.cTag("crops/onion");

	public static final TagKey<Item> DUSTS_CALCITE = IcariaItemTags.cTag("dusts/calcite");
	public static final TagKey<Item> DUSTS_HALITE = IcariaItemTags.cTag("dusts/halite");

	public static final TagKey<Item> GEMS_CHERT = IcariaItemTags.cTag("gems/chert");
	public static final TagKey<Item> GEMS_LIGNITE = IcariaItemTags.cTag("gems/lignite");
	public static final TagKey<Item> GEMS_DOLOMITE = IcariaItemTags.cTag("gems/dolomite");
	public static final TagKey<Item> GEMS_SLIVER = IcariaItemTags.cTag("gems/sliver");
	public static final TagKey<Item> GEMS_ANTHRACITE = IcariaItemTags.cTag("gems/anthracite");
	public static final TagKey<Item> GEMS_CALCITE_SHARD = IcariaItemTags.cTag("gems/calcite_shard");
	public static final TagKey<Item> GEMS_HALITE_SHARD = IcariaItemTags.cTag("gems/halite_shard");
	public static final TagKey<Item> GEMS_JASPER_SHARD = IcariaItemTags.cTag("gems/jasper_shard");
	public static final TagKey<Item> GEMS_ZIRCON_SHARD = IcariaItemTags.cTag("gems/zircon_shard");

	public static final TagKey<Item> INGOTS_CHALKOS = IcariaItemTags.cTag("ingots/chalkos");
	public static final TagKey<Item> INGOTS_KASSITEROS = IcariaItemTags.cTag("ingots/kassiteros");
	public static final TagKey<Item> INGOTS_ORICHALCUM = IcariaItemTags.cTag("ingots/orichalcum");
	public static final TagKey<Item> INGOTS_VANADIUM = IcariaItemTags.cTag("ingots/vanadium");
	public static final TagKey<Item> INGOTS_VANADIUMSTEEL = IcariaItemTags.cTag("ingots/vanadiumsteel");
	public static final TagKey<Item> INGOTS_SIDEROS = IcariaItemTags.cTag("ingots/sideros");
	public static final TagKey<Item> INGOTS_MOLYBDENUM = IcariaItemTags.cTag("ingots/molybdenum");
	public static final TagKey<Item> INGOTS_MOLYBDENUMSTEEL = IcariaItemTags.cTag("ingots/molybdenumsteel");
	public static final TagKey<Item> INGOTS_BLURIDIUM = IcariaItemTags.cTag("ingots/bluridium");

	public static final TagKey<Item> KETTLE_ITEMS = IcariaItemTags.icariaTag("kettle_items");

	public static final TagKey<Item> NUGGETS_CHALKOS = IcariaItemTags.cTag("nuggets/chalkos");
	public static final TagKey<Item> NUGGETS_KASSITEROS = IcariaItemTags.cTag("nuggets/kassiteros");
	public static final TagKey<Item> NUGGETS_ORICHALCUM = IcariaItemTags.cTag("nuggets/orichalcum");
	public static final TagKey<Item> NUGGETS_VANADIUM = IcariaItemTags.cTag("nuggets/vanadium");
	public static final TagKey<Item> NUGGETS_VANADIUMSTEEL = IcariaItemTags.cTag("nuggets/vanadiumsteel");
	public static final TagKey<Item> NUGGETS_SIDEROS = IcariaItemTags.cTag("nuggets/sideros");
	public static final TagKey<Item> NUGGETS_MOLYBDENUM = IcariaItemTags.cTag("nuggets/molybdenum");
	public static final TagKey<Item> NUGGETS_MOLYBDENUMSTEEL = IcariaItemTags.cTag("nuggets/molybdenumsteel");
	public static final TagKey<Item> NUGGETS_BLURIDIUM = IcariaItemTags.cTag("nuggets/bluridium");

	public static final TagKey<Item> RAW_BLOCKS_CHALKOS = IcariaItemTags.cTag("raw_blocks/chalkos");
	public static final TagKey<Item> RAW_BLOCKS_KASSITEROS = IcariaItemTags.cTag("raw_blocks/kassiteros");
	public static final TagKey<Item> RAW_BLOCKS_VANADIUM = IcariaItemTags.cTag("raw_blocks/vanadium");
	public static final TagKey<Item> RAW_BLOCKS_SIDEROS = IcariaItemTags.cTag("raw_blocks/sideros");
	public static final TagKey<Item> RAW_BLOCKS_MOLYBDENUM = IcariaItemTags.cTag("raw_blocks/molybdenum");

	public static final TagKey<Item> RAW_MATERIALS_CHALKOS = IcariaItemTags.cTag("raw_materials/chalkos");
	public static final TagKey<Item> RAW_MATERIALS_KASSITEROS = IcariaItemTags.cTag("raw_materials/kassiteros");
	public static final TagKey<Item> RAW_MATERIALS_VANADIUM = IcariaItemTags.cTag("raw_materials/vanadium");
	public static final TagKey<Item> RAW_MATERIALS_SIDEROS = IcariaItemTags.cTag("raw_materials/sideros");
	public static final TagKey<Item> RAW_MATERIALS_MOLYBDENUM = IcariaItemTags.cTag("raw_materials/molybdenum");

	public static final TagKey<Item> SEEDS_SPELT = IcariaItemTags.cTag("seeds/spelt");
	public static final TagKey<Item> SEEDS_STRAWBERRY = IcariaItemTags.cTag("seeds/strawberry");
	public static final TagKey<Item> SEEDS_PHYSALIS = IcariaItemTags.cTag("seeds/physalis");
	public static final TagKey<Item> SEEDS_ONION = IcariaItemTags.cTag("seeds/onion");

	// ITEMBLOCK TAGS

	public static final TagKey<Item> LOGS_CYPRESS = IcariaItemTags.cTag("logs/cypress");
	public static final TagKey<Item> LOGS_DROUGHTROOT = IcariaItemTags.cTag("logs/droughtroot");
	public static final TagKey<Item> LOGS_FIR = IcariaItemTags.cTag("logs/fir");
	public static final TagKey<Item> LOGS_LAUREL = IcariaItemTags.cTag("logs/laurel");
	public static final TagKey<Item> LOGS_OLIVE = IcariaItemTags.cTag("logs/olive");
	public static final TagKey<Item> LOGS_PLANE = IcariaItemTags.cTag("logs/plane");
	public static final TagKey<Item> LOGS_POPULUS = IcariaItemTags.cTag("logs/populus");

	public static final TagKey<Item> ORE_BEARING_GROUND_MARL = IcariaItemTags.cTag("ore_bearing_ground/marl");
	public static final TagKey<Item> ORE_BEARING_GROUND_GRAINEL = IcariaItemTags.cTag("ore_bearing_ground/grainel");
	public static final TagKey<Item> ORE_BEARING_GROUND_YELLOWSTONE = IcariaItemTags.cTag("ore_bearing_ground/yellowstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SILKSTONE = IcariaItemTags.cTag("ore_bearing_ground/silkstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SUNSTONE = IcariaItemTags.cTag("ore_bearing_ground/sunstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_VOIDSHALE = IcariaItemTags.cTag("ore_bearing_ground/voidshale");
	public static final TagKey<Item> ORE_BEARING_GROUND_BAETYL = IcariaItemTags.cTag("ore_bearing_ground/baetyl");

	public static final TagKey<Item> ORES_CHERT = IcariaItemTags.cTag("ores/chert");
	public static final TagKey<Item> ORES_BONES = IcariaItemTags.cTag("ores/bones");
	public static final TagKey<Item> ORES_LIGNITE = IcariaItemTags.cTag("ores/lignite");
	public static final TagKey<Item> ORES_CHALKOS = IcariaItemTags.cTag("ores/chalkos");
	public static final TagKey<Item> ORES_KASSITEROS = IcariaItemTags.cTag("ores/kassiteros");
	public static final TagKey<Item> ORES_DOLOMITE = IcariaItemTags.cTag("ores/dolomite");
	public static final TagKey<Item> ORES_VANADIUM = IcariaItemTags.cTag("ores/vanadium");
	public static final TagKey<Item> ORES_SLIVER = IcariaItemTags.cTag("ores/sliver");
	public static final TagKey<Item> ORES_SIDEROS = IcariaItemTags.cTag("ores/sideros");
	public static final TagKey<Item> ORES_ANTHRACITE = IcariaItemTags.cTag("ores/anthracite");
	public static final TagKey<Item> ORES_MOLYBDENUM = IcariaItemTags.cTag("ores/molybdenum");
	public static final TagKey<Item> ORES_HYLIASTRUM = IcariaItemTags.cTag("ores/hyliastrum");

	public static final TagKey<Item> ORES_IN_GROUND_MARL = IcariaItemTags.cTag("ores_in_ground/marl");
	public static final TagKey<Item> ORES_IN_GROUND_GRAINEL = IcariaItemTags.cTag("ores_in_ground/grainel");
	public static final TagKey<Item> ORES_IN_GROUND_YELLOWSTONE = IcariaItemTags.cTag("ores_in_ground/yellowstone");
	public static final TagKey<Item> ORES_IN_GROUND_SILKSTONE = IcariaItemTags.cTag("ores_in_ground/silkstone");
	public static final TagKey<Item> ORES_IN_GROUND_SUNSTONE = IcariaItemTags.cTag("ores_in_ground/sunstone");
	public static final TagKey<Item> ORES_IN_GROUND_VOIDSHALE = IcariaItemTags.cTag("ores_in_ground/voidshale");
	public static final TagKey<Item> ORES_IN_GROUND_BAETYL = IcariaItemTags.cTag("ores_in_ground/baetyl");

	public static final TagKey<Item> STORAGE_BLOCKS_PACKED_ARISTONE = IcariaItemTags.cTag("storage_blocks/packed_aristone");
	public static final TagKey<Item> STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY = IcariaItemTags.cTag("storage_blocks/ender_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY = IcariaItemTags.cTag("storage_blocks/fire_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY = IcariaItemTags.cTag("storage_blocks/nature_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_VOID_JELLYFISH_JELLY = IcariaItemTags.cTag("storage_blocks/void_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_WATER_JELLYFISH_JELLY = IcariaItemTags.cTag("storage_blocks/water_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_ARACHNE_STRING = IcariaItemTags.cTag("storage_blocks/arachne_string");
	public static final TagKey<Item> STORAGE_BLOCKS_SPELT = IcariaItemTags.cTag("storage_blocks/spelt");
	public static final TagKey<Item> STORAGE_BLOCKS_VINE_REED = IcariaItemTags.cTag("storage_blocks/vine_reed");
	public static final TagKey<Item> STORAGE_BLOCKS_ROTTEN_BONES = IcariaItemTags.cTag("storage_blocks/rotten_bones");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_CHALKOS = IcariaItemTags.cTag("storage_blocks/raw_chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_KASSITEROS = IcariaItemTags.cTag("storage_blocks/raw_kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_VANADIUM = IcariaItemTags.cTag("storage_blocks/raw_vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_SIDEROS = IcariaItemTags.cTag("storage_blocks/raw_sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_MOLYBDENUM = IcariaItemTags.cTag("storage_blocks/raw_molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_CALCITE = IcariaItemTags.cTag("storage_blocks/calcite");
	public static final TagKey<Item> STORAGE_BLOCKS_HALITE = IcariaItemTags.cTag("storage_blocks/halite");
	public static final TagKey<Item> STORAGE_BLOCKS_JASPER = IcariaItemTags.cTag("storage_blocks/jasper");
	public static final TagKey<Item> STORAGE_BLOCKS_ZIRCON = IcariaItemTags.cTag("storage_blocks/zircon");
	public static final TagKey<Item> STORAGE_BLOCKS_CHERT = IcariaItemTags.cTag("storage_blocks/chert");
	public static final TagKey<Item> STORAGE_BLOCKS_LIGNITE = IcariaItemTags.cTag("storage_blocks/lignite");
	public static final TagKey<Item> STORAGE_BLOCKS_CHALKOS = IcariaItemTags.cTag("storage_blocks/chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_KASSITEROS = IcariaItemTags.cTag("storage_blocks/kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_ORICHALCUM = IcariaItemTags.cTag("storage_blocks/orichalcum");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUM = IcariaItemTags.cTag("storage_blocks/vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUMSTEEL = IcariaItemTags.cTag("storage_blocks/vanadiumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_SLIVER = IcariaItemTags.cTag("storage_blocks/sliver");
	public static final TagKey<Item> STORAGE_BLOCKS_SIDEROS = IcariaItemTags.cTag("storage_blocks/sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_ANTHRACITE = IcariaItemTags.cTag("storage_blocks/anthracite");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUM = IcariaItemTags.cTag("storage_blocks/molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUMSTEEL = IcariaItemTags.cTag("storage_blocks/molybdenumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_BLURIDIUM = IcariaItemTags.cTag("storage_blocks/bluridium");

	public IcariaItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, CompletableFuture<TagLookup<Block>> pTags, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pTags, pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {

		// ITEM TAGS

		this.tag(ItemTags.MEAT)
			.add(IcariaItems.RAW_AETERNAE_MEAT.get())
			.add(IcariaItems.COOKED_AETERNAE_MEAT.get())
			.add(IcariaItems.RAW_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.COOKED_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.RAW_CERVER_MEAT.get())
			.add(IcariaItems.COOKED_CERVER_MEAT.get())
			.add(IcariaItems.RAW_SOW_MEAT.get())
			.add(IcariaItems.COOKED_SOW_MEAT.get());

		this.tag(ItemTags.SIGNS)
			.add(IcariaItems.CYPRESS_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_SIGN.get())
			.add(IcariaItems.FIR_SIGN.get())
			.add(IcariaItems.LAUREL_SIGN.get())
			.add(IcariaItems.OLIVE_SIGN.get())
			.add(IcariaItems.PLANE_SIGN.get())
			.add(IcariaItems.POPULUS_SIGN.get());

		this.tag(ItemTags.COALS)
			.add(IcariaItems.LIGNITE.get())
			.add(IcariaItems.ANTHRACITE.get());

		this.tag(ItemTags.STONE_TOOL_MATERIALS)
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(ItemTags.FREEZE_IMMUNE_WEARABLES)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get())
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get())
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get())
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get());

		this.tag(ItemTags.HANGING_SIGNS)
			.add(IcariaItems.CYPRESS_HANGING_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_HANGING_SIGN.get())
			.add(IcariaItems.FIR_HANGING_SIGN.get())
			.add(IcariaItems.LAUREL_HANGING_SIGN.get())
			.add(IcariaItems.OLIVE_HANGING_SIGN.get())
			.add(IcariaItems.PLANE_HANGING_SIGN.get())
			.add(IcariaItems.POPULUS_HANGING_SIGN.get());

		this.tag(ItemTags.FOOT_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get())
			.add(IcariaItems.CHALKOS_ARMOR.boots.get())
			.add(IcariaItems.KASSITEROS_ARMOR.boots.get())
			.add(IcariaItems.ORICHALCUM_ARMOR.boots.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.boots.get());

		this.tag(ItemTags.LEG_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get())
			.add(IcariaItems.CHALKOS_ARMOR.leggings.get())
			.add(IcariaItems.KASSITEROS_ARMOR.leggings.get())
			.add(IcariaItems.ORICHALCUM_ARMOR.leggings.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get());

		this.tag(ItemTags.CHEST_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get())
			.add(IcariaItems.CHALKOS_ARMOR.chestplate.get())
			.add(IcariaItems.KASSITEROS_ARMOR.chestplate.get())
			.add(IcariaItems.ORICHALCUM_ARMOR.chestplate.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get());

		this.tag(ItemTags.HEAD_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get())
			.add(IcariaItems.CHALKOS_ARMOR.helmet.get())
			.add(IcariaItems.KASSITEROS_ARMOR.helmet.get())
			.add(IcariaItems.ORICHALCUM_ARMOR.helmet.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get());

		this.tag(ItemTags.SKULLS)
			.add(IcariaItems.AETERNAE_SKULL.get())
			.add(IcariaItems.ARGAN_HOUND_SKULL.get())
			.add(IcariaItems.CATOBLEPAS_SKULL.get())
			.add(IcariaItems.CERVER_SKULL.get())
			.add(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get())
			.add(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get())
			.add(IcariaItems.FIR_FOREST_HAG_SKULL.get())
			.add(IcariaItems.LAUREL_FOREST_HAG_SKULL.get())
			.add(IcariaItems.OLIVE_FOREST_HAG_SKULL.get())
			.add(IcariaItems.PLANE_FOREST_HAG_SKULL.get())
			.add(IcariaItems.POPULUS_FOREST_HAG_SKULL.get())
			.add(IcariaItems.REVENANT_SKULL.get())
			.add(IcariaItems.SOW_SKULL.get());

		this.tag(ItemTags.SWORDS)
			.add(IcariaItems.CHERT_TOOLS.sword.get())
			.add(IcariaItems.CHALKOS_TOOLS.sword.get())
			.add(IcariaItems.KASSITEROS_TOOLS.sword.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.sword.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.sword.get())
			.add(IcariaItems.SIDEROS_TOOLS.sword.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get());

		this.tag(ItemTags.AXES)
			.add(IcariaItems.CHERT_TOOLS.axe.get())
			.add(IcariaItems.CHALKOS_TOOLS.axe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.axe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.axe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.axe.get())
			.add(IcariaItems.SIDEROS_TOOLS.axe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get());

		this.tag(ItemTags.HOES)
			.add(IcariaItems.CHERT_TOOLS.scythe.get())
			.add(IcariaItems.CHALKOS_TOOLS.scythe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.scythe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.scythe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get())
			.add(IcariaItems.SIDEROS_TOOLS.scythe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get());

		this.tag(ItemTags.PICKAXES)
			.add(IcariaItems.CHERT_TOOLS.pickaxe.get())
			.add(IcariaItems.CHALKOS_TOOLS.pickaxe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.pickaxe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get())
			.add(IcariaItems.SIDEROS_TOOLS.pickaxe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get());

		this.tag(ItemTags.SHOVELS)
			.add(IcariaItems.CHERT_TOOLS.shovel.get())
			.add(IcariaItems.CHALKOS_TOOLS.shovel.get())
			.add(IcariaItems.KASSITEROS_TOOLS.shovel.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.shovel.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get())
			.add(IcariaItems.SIDEROS_TOOLS.shovel.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get());

		this.tag(ItemTags.SWORD_ENCHANTABLE)
			.add(IcariaItems.CHERT_TOOLS.dagger.get())
			.add(IcariaItems.CHERT_TOOLS.scythe.get())
			.add(IcariaItems.CHALKOS_TOOLS.dagger.get())
			.add(IcariaItems.CHALKOS_TOOLS.scythe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.dagger.get())
			.add(IcariaItems.KASSITEROS_TOOLS.scythe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.dagger.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.scythe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get())
			.add(IcariaItems.SIDEROS_TOOLS.dagger.get())
			.add(IcariaItems.SIDEROS_TOOLS.scythe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get());

		this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
			.add(IcariaItems.CHERT_TOOLS.dagger.get())
			.add(IcariaItems.CHERT_TOOLS.scythe.get())
			.add(IcariaItems.CHALKOS_TOOLS.dagger.get())
			.add(IcariaItems.CHALKOS_TOOLS.scythe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.dagger.get())
			.add(IcariaItems.KASSITEROS_TOOLS.scythe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.dagger.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.scythe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get())
			.add(IcariaItems.SIDEROS_TOOLS.dagger.get())
			.add(IcariaItems.SIDEROS_TOOLS.scythe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get());

		this.tag(ItemTags.DURABILITY_ENCHANTABLE)
			.add(IcariaItems.CHERT_TOOLS.dagger.get())
			.add(IcariaItems.CHERT_TOOLS.bident.get())
			.add(IcariaItems.CHALKOS_TOOLS.dagger.get())
			.add(IcariaItems.CHALKOS_TOOLS.bident.get())
			.add(IcariaItems.KASSITEROS_TOOLS.dagger.get())
			.add(IcariaItems.KASSITEROS_TOOLS.bident.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.dagger.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.bident.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get())
			.add(IcariaItems.SIDEROS_TOOLS.dagger.get())
			.add(IcariaItems.SIDEROS_TOOLS.bident.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());

		this.tag(Tags.Items.ENCHANTING_FUELS)
			.add(IcariaItems.ZIRCON_SHARD.get());

		this.tag(Tags.Items.BRICKS)
			.add(IcariaItems.LOAM_BRICK.get());

		this.tag(Tags.Items.BUCKETS)
			.add(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());

		this.tag(Tags.Items.CROPS)
			.add(IcariaItems.SPELT.get())
			.add(IcariaItems.STRAWBERRIES.get())
			.add(IcariaItems.PHYSALIS.get())
			.add(IcariaItems.ONION.get());

		this.tag(Tags.Items.DUSTS)
			.add(IcariaItems.CALCITE_DUST.get())
			.add(IcariaItems.HALITE_DUST.get());

		this.tag(Tags.Items.DYED)
			.add(IcariaItems.WHITE_STORAGE_VASE.get())
			.add(IcariaItems.LIGHT_GRAY_STORAGE_VASE.get())
			.add(IcariaItems.GRAY_STORAGE_VASE.get())
			.add(IcariaItems.BLACK_STORAGE_VASE.get())
			.add(IcariaItems.BROWN_STORAGE_VASE.get())
			.add(IcariaItems.RED_STORAGE_VASE.get())
			.add(IcariaItems.ORANGE_STORAGE_VASE.get())
			.add(IcariaItems.YELLOW_STORAGE_VASE.get())
			.add(IcariaItems.LIME_STORAGE_VASE.get())
			.add(IcariaItems.GREEN_STORAGE_VASE.get())
			.add(IcariaItems.CYAN_STORAGE_VASE.get())
			.add(IcariaItems.LIGHT_BLUE_STORAGE_VASE.get())
			.add(IcariaItems.BLUE_STORAGE_VASE.get())
			.add(IcariaItems.PURPLE_STORAGE_VASE.get())
			.add(IcariaItems.MAGENTA_STORAGE_VASE.get())
			.add(IcariaItems.PINK_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_WHITE).add(IcariaItems.WHITE_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_LIGHT_GRAY).add(IcariaItems.LIGHT_GRAY_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_GRAY).add(IcariaItems.GRAY_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_BLACK).add(IcariaItems.BLACK_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_BROWN).add(IcariaItems.BROWN_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_RED).add(IcariaItems.RED_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_ORANGE).add(IcariaItems.ORANGE_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_YELLOW).add(IcariaItems.YELLOW_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_LIME).add(IcariaItems.LIME_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_GREEN).add(IcariaItems.GREEN_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_CYAN).add(IcariaItems.CYAN_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_LIGHT_BLUE).add(IcariaItems.LIGHT_BLUE_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_BLUE).add(IcariaItems.BLUE_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_PURPLE).add(IcariaItems.PURPLE_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_MAGENTA).add(IcariaItems.MAGENTA_STORAGE_VASE.get());
		this.tag(Tags.Items.DYED_PINK).add(IcariaItems.PINK_STORAGE_VASE.get());

		this.tag(Tags.Items.FERTILIZERS)
			.add(IcariaItems.CALCITE_DUST.get());

		this.tag(Tags.Items.FOODS_FRUIT)
			.add(IcariaItems.PHYSALIS.get())
			.add(IcariaItems.LAUREL_CHERRY.get());

		this.tag(Tags.Items.FOODS_VEGETABLE)
			.add(IcariaItems.BLACK_OLIVES.get())
			.add(IcariaItems.GREEN_OLIVES.get())
			.add(IcariaItems.GARLIC.get())
			.add(IcariaItems.ONION.get());

		this.tag(Tags.Items.FOODS_BERRY)
			.add(IcariaItems.VINEBERRIES.get())
			.add(IcariaItems.STRAWBERRIES.get());

		this.tag(Tags.Items.FOODS_BREAD)
			.add(IcariaItems.SPELT_BREAD.get());

		this.tag(Tags.Items.FOODS_RAW_MEAT)
			.add(IcariaItems.RAW_AETERNAE_MEAT.get())
			.add(IcariaItems.RAW_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.RAW_CERVER_MEAT.get())
			.add(IcariaItems.RAW_SOW_MEAT.get());

		this.tag(Tags.Items.FOODS_COOKED_MEAT)
			.add(IcariaItems.COOKED_AETERNAE_MEAT.get())
			.add(IcariaItems.COOKED_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.COOKED_CERVER_MEAT.get())
			.add(IcariaItems.COOKED_SOW_MEAT.get());

		this.tag(Tags.Items.FOODS_SOUP)
			.add(IcariaItems.ONION_SOUP.get())
			.add(IcariaItems.AETERNAE_STEW.get())
			.add(IcariaItems.CATOBLEPAS_STEW.get())
			.add(IcariaItems.CERVER_STEW.get())
			.add(IcariaItems.SOW_STEW.get());

		this.tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
			.add(IcariaItems.LAUREL_CHERRY_CAKE.get())
			.add(IcariaItems.STRAWBERRY_CAKE.get())
			.add(IcariaItems.PHYSALIS_CAKE.get())
			.add(IcariaItems.VINE_BERRY_CAKE.get())
			.add(IcariaItems.VINE_SPROUT_CAKE.get());

		this.tag(Tags.Items.GEMS)
			.add(IcariaItems.CHERT.get())
			.add(IcariaItems.LIGNITE.get())
			.add(IcariaItems.DOLOMITE.get())
			.add(IcariaItems.SLIVER.get())
			.add(IcariaItems.ANTHRACITE.get())
			.add(IcariaItems.CALCITE_SHARD.get())
			.add(IcariaItems.HALITE_SHARD.get())
			.add(IcariaItems.JASPER_SHARD.get())
			.add(IcariaItems.ZIRCON_SHARD.get());

		this.tag(Tags.Items.GUNPOWDERS)
			.add(IcariaItems.GREENPOWDER.get());

		this.tag(Tags.Items.INGOTS)
			.add(IcariaItems.LOAM_BRICK.get())
			.add(IcariaItems.CHALKOS_INGOT.get())
			.add(IcariaItems.KASSITEROS_INGOT.get())
			.add(IcariaItems.ORICHALCUM_INGOT.get())
			.add(IcariaItems.VANADIUM_INGOT.get())
			.add(IcariaItems.VANADIUMSTEEL_INGOT.get())
			.add(IcariaItems.SIDEROS_INGOT.get())
			.add(IcariaItems.MOLYBDENUM_INGOT.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get())
			.add(IcariaItems.BLURIDIUM_INGOT.get());

		this.tag(Tags.Items.LEATHERS)
			.add(IcariaItems.AETERNAE_HIDE.get());

		this.tag(Tags.Items.MUSHROOMS)
			.add(IcariaItems.GREEN_GROUND_SHROOMS.get())
			.add(IcariaItems.BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get())
			.add(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get())
			.add(IcariaItems.UNNAMED_TREE_SHROOMS.get());

		this.tag(Tags.Items.NUGGETS)
			.add(IcariaItems.CHALKOS_NUGGET.get())
			.add(IcariaItems.KASSITEROS_NUGGET.get())
			.add(IcariaItems.ORICHALCUM_NUGGET.get())
			.add(IcariaItems.VANADIUM_NUGGET.get())
			.add(IcariaItems.VANADIUMSTEEL_NUGGET.get())
			.add(IcariaItems.SIDEROS_NUGGET.get())
			.add(IcariaItems.MOLYBDENUM_NUGGET.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get())
			.add(IcariaItems.BLURIDIUM_NUGGET.get());

		this.tag(Tags.Items.RAW_MATERIALS)
			.add(IcariaItems.RAW_CHALKOS.get())
			.add(IcariaItems.RAW_KASSITEROS.get())
			.add(IcariaItems.RAW_VANADIUM.get())
			.add(IcariaItems.RAW_SIDEROS.get())
			.add(IcariaItems.RAW_MOLYBDENUM.get());

		this.tag(Tags.Items.SEEDS)
			.add(IcariaItems.SPELT_SEEDS.get())
			.add(IcariaItems.STRAWBERRY_SEEDS.get())
			.add(IcariaItems.PHYSALIS_SEEDS.get())
			.add(IcariaItems.ONION.get());

		this.tag(Tags.Items.SLIME_BALLS)
			.add(IcariaItems.ENDER_JELLYFISH_JELLY.get())
			.add(IcariaItems.FIRE_JELLYFISH_JELLY.get())
			.add(IcariaItems.NATURE_JELLYFISH_JELLY.get())
			.add(IcariaItems.VOID_JELLYFISH_JELLY.get())
			.add(IcariaItems.WATER_JELLYFISH_JELLY.get());

		this.tag(Tags.Items.STRINGS)
			.add(IcariaItems.ARACHNE_STRING.get());

		this.tag(Tags.Items.TOOLS_SPEAR)
			.add(IcariaItems.CHERT_TOOLS.bident.get())
			.add(IcariaItems.CHALKOS_TOOLS.bident.get())
			.add(IcariaItems.KASSITEROS_TOOLS.bident.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.bident.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get())
			.add(IcariaItems.SIDEROS_TOOLS.bident.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());

		this.tag(Tags.Items.MELEE_WEAPON_TOOLS)
			.add(IcariaItems.CHERT_TOOLS.sword.get())
			.add(IcariaItems.CHERT_TOOLS.dagger.get())
			.add(IcariaItems.CHERT_TOOLS.axe.get())
			.add(IcariaItems.CHERT_TOOLS.scythe.get())
			.add(IcariaItems.CHERT_TOOLS.bident.get())
			.add(IcariaItems.CHALKOS_TOOLS.sword.get())
			.add(IcariaItems.CHALKOS_TOOLS.dagger.get())
			.add(IcariaItems.CHALKOS_TOOLS.axe.get())
			.add(IcariaItems.CHALKOS_TOOLS.scythe.get())
			.add(IcariaItems.CHALKOS_TOOLS.bident.get())
			.add(IcariaItems.KASSITEROS_TOOLS.sword.get())
			.add(IcariaItems.KASSITEROS_TOOLS.dagger.get())
			.add(IcariaItems.KASSITEROS_TOOLS.axe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.scythe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.bident.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.sword.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.dagger.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.axe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.scythe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.bident.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.sword.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.axe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get())
			.add(IcariaItems.SIDEROS_TOOLS.sword.get())
			.add(IcariaItems.SIDEROS_TOOLS.dagger.get())
			.add(IcariaItems.SIDEROS_TOOLS.axe.get())
			.add(IcariaItems.SIDEROS_TOOLS.scythe.get())
			.add(IcariaItems.SIDEROS_TOOLS.bident.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());

		this.tag(Tags.Items.RANGED_WEAPON_TOOLS)
			.add(IcariaItems.CHERT_TOOLS.bident.get())
			.add(IcariaItems.CHALKOS_TOOLS.bident.get())
			.add(IcariaItems.KASSITEROS_TOOLS.bident.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.bident.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get())
			.add(IcariaItems.SIDEROS_TOOLS.bident.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());

		this.tag(Tags.Items.MINING_TOOL_TOOLS)
			.add(IcariaItems.CHERT_TOOLS.pickaxe.get())
			.add(IcariaItems.CHALKOS_TOOLS.pickaxe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.pickaxe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get())
			.add(IcariaItems.SIDEROS_TOOLS.pickaxe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get());

		this.tag(IcariaItemTags.CROPS_SPELT).add(IcariaItems.SPELT.get());
		this.tag(IcariaItemTags.CROPS_STRAWBERRIES).add(IcariaItems.STRAWBERRIES.get());
		this.tag(IcariaItemTags.CROPS_GARLIC).add(IcariaItems.GARLIC.get());
		this.tag(IcariaItemTags.CROPS_ONION).add(IcariaItems.ONION.get());

		this.tag(IcariaItemTags.DUSTS_CALCITE).add(IcariaItems.CALCITE_DUST.get());
		this.tag(IcariaItemTags.DUSTS_HALITE).add(IcariaItems.HALITE_DUST.get());

		this.tag(IcariaItemTags.GEMS_CHERT).add(IcariaItems.CHERT.get());
		this.tag(IcariaItemTags.GEMS_LIGNITE).add(IcariaItems.LIGNITE.get());
		this.tag(IcariaItemTags.GEMS_DOLOMITE).add(IcariaItems.DOLOMITE.get());
		this.tag(IcariaItemTags.GEMS_SLIVER).add(IcariaItems.SLIVER.get());
		this.tag(IcariaItemTags.GEMS_ANTHRACITE).add(IcariaItems.ANTHRACITE.get());
		this.tag(IcariaItemTags.GEMS_CALCITE_SHARD).add(IcariaItems.CALCITE_SHARD.get());
		this.tag(IcariaItemTags.GEMS_HALITE_SHARD).add(IcariaItems.HALITE_SHARD.get());
		this.tag(IcariaItemTags.GEMS_JASPER_SHARD).add(IcariaItems.JASPER_SHARD.get());
		this.tag(IcariaItemTags.GEMS_ZIRCON_SHARD).add(IcariaItems.ZIRCON_SHARD.get());

		this.tag(IcariaItemTags.INGOTS_CHALKOS).add(IcariaItems.CHALKOS_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_KASSITEROS).add(IcariaItems.KASSITEROS_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_ORICHALCUM).add(IcariaItems.ORICHALCUM_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_VANADIUM).add(IcariaItems.VANADIUM_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_SIDEROS).add(IcariaItems.SIDEROS_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_BLURIDIUM).add(IcariaItems.BLURIDIUM_INGOT.get());

		this.tag(IcariaItemTags.KETTLE_ITEMS)
			.add(IcariaItems.BOLBOS.get())
			.add(IcariaItems.DATHULLA.get())
			.add(IcariaItems.MONDANOS.get())
			.add(IcariaItems.MOTH_AGARIC.get())
			.add(IcariaItems.NAMDRAKE.get())
			.add(IcariaItems.PSILOCYBOS.get())
			.add(IcariaItems.ROWAN.get())
			.add(IcariaItems.WILTED_ELM.get())
			.add(IcariaItems.BONE_REMAINS.get())
			.add(IcariaItems.ARACHNE_VENOM_VIAL.get())
			.add(IcariaItems.HYLIASTRUM_VIAL.get());

		this.tag(IcariaItemTags.NUGGETS_CHALKOS).add(IcariaItems.CHALKOS_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_KASSITEROS).add(IcariaItems.KASSITEROS_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_ORICHALCUM).add(IcariaItems.ORICHALCUM_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_VANADIUM).add(IcariaItems.VANADIUM_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_SIDEROS).add(IcariaItems.SIDEROS_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_BLURIDIUM).add(IcariaItems.BLURIDIUM_NUGGET.get());

		this.tag(IcariaItemTags.RAW_BLOCKS_CHALKOS).add(IcariaItems.RAW_CHALKOS_BLOCK.get());
		this.tag(IcariaItemTags.RAW_BLOCKS_KASSITEROS).add(IcariaItems.RAW_KASSITEROS_BLOCK.get());
		this.tag(IcariaItemTags.RAW_BLOCKS_VANADIUM).add(IcariaItems.RAW_VANADIUM_BLOCK.get());
		this.tag(IcariaItemTags.RAW_BLOCKS_SIDEROS).add(IcariaItems.RAW_SIDEROS_BLOCK.get());
		this.tag(IcariaItemTags.RAW_BLOCKS_MOLYBDENUM).add(IcariaItems.RAW_MOLYBDENUM_BLOCK.get());

		this.tag(IcariaItemTags.RAW_MATERIALS_CHALKOS).add(IcariaItems.RAW_CHALKOS.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_KASSITEROS).add(IcariaItems.RAW_KASSITEROS.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_VANADIUM).add(IcariaItems.RAW_VANADIUM.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_SIDEROS).add(IcariaItems.RAW_SIDEROS.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_MOLYBDENUM).add(IcariaItems.RAW_MOLYBDENUM.get());

		this.tag(IcariaItemTags.SEEDS_SPELT).add(IcariaItems.SPELT_SEEDS.get());
		this.tag(IcariaItemTags.SEEDS_STRAWBERRY).add(IcariaItems.STRAWBERRY_SEEDS.get());
		this.tag(IcariaItemTags.SEEDS_PHYSALIS).add(IcariaItems.PHYSALIS_SEEDS.get());
		this.tag(IcariaItemTags.SEEDS_ONION).add(IcariaItems.ONION.get());

		// ITEMBLOCK TAGS

		for (var items : IcariaStoneDecoItems.STONE_DECO_ITEMS) {
			this.tag(ItemTags.STAIRS).add(items.stairs.get());
			this.tag(ItemTags.SLABS).add(items.slab.get());
			this.tag(ItemTags.WALLS).add(items.wall.get());
		}

		for (var items : IcariaWoodDecoItems.WOOD_DECO_ITEMS) {
			this.tag(ItemTags.WOODEN_STAIRS).add(items.stairs.get());
			this.tag(ItemTags.WOODEN_SLABS).add(items.slab.get());
			this.tag(ItemTags.WOODEN_FENCES).add(items.fence.get());
			this.tag(ItemTags.FENCE_GATES).add(items.gate.get());
		}

		this.tag(ItemTags.PLANKS)
			.add(IcariaItems.CYPRESS_PLANKS.get())
			.add(IcariaItems.DROUGHTROOT_PLANKS.get())
			.add(IcariaItems.FIR_PLANKS.get())
			.add(IcariaItems.LAUREL_PLANKS.get())
			.add(IcariaItems.OLIVE_PLANKS.get())
			.add(IcariaItems.PLANE_PLANKS.get())
			.add(IcariaItems.POPULUS_PLANKS.get());

		this.tag(ItemTags.STONE_BRICKS)
			.add(IcariaItems.YELLOWSTONE_BRICKS.get())
			.add(IcariaItems.SILKSTONE_BRICKS.get())
			.add(IcariaItems.SUNSTONE_BRICKS.get())
			.add(IcariaItems.VOIDSHALE_BRICKS.get())
			.add(IcariaItems.BAETYL_BRICKS.get())
			.add(IcariaItems.RELICSTONE_BRICKS.get())
			.add(IcariaItems.PLATOSHALE_BRICKS.get());

		this.tag(ItemTags.WOODEN_DOORS)
			.add(IcariaItems.CYPRESS_DOOR.get())
			.add(IcariaItems.DROUGHTROOT_DOOR.get())
			.add(IcariaItems.FIR_DOOR.get())
			.add(IcariaItems.LAUREL_DOOR.get())
			.add(IcariaItems.OLIVE_DOOR.get())
			.add(IcariaItems.PLANE_DOOR.get())
			.add(IcariaItems.POPULUS_DOOR.get());

		this.tag(ItemTags.WOODEN_TRAPDOORS)
			.add(IcariaItems.CYPRESS_TRAPDOOR.get())
			.add(IcariaItems.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaItems.FIR_TRAPDOOR.get())
			.add(IcariaItems.LAUREL_TRAPDOOR.get())
			.add(IcariaItems.OLIVE_TRAPDOOR.get())
			.add(IcariaItems.PLANE_TRAPDOOR.get())
			.add(IcariaItems.POPULUS_TRAPDOOR.get());

		this.tag(ItemTags.SAPLINGS)
			.add(IcariaItems.CYPRESS_SAPLING.get())
			.add(IcariaItems.DROUGHTROOT_SAPLING.get())
			.add(IcariaItems.FIR_SAPLING.get())
			.add(IcariaItems.LAUREL_SAPLING.get())
			.add(IcariaItems.OLIVE_SAPLING.get())
			.add(IcariaItems.PLANE_SAPLING.get())
			.add(IcariaItems.POPULUS_SAPLING.get());

		this.tag(ItemTags.LOGS_THAT_BURN)
			.addTag(IcariaItemTags.LOGS_CYPRESS)
			.addTag(IcariaItemTags.LOGS_DROUGHTROOT)
			.addTag(IcariaItemTags.LOGS_FIR)
			.addTag(IcariaItemTags.LOGS_LAUREL)
			.addTag(IcariaItemTags.LOGS_OLIVE)
			.addTag(IcariaItemTags.LOGS_PLANE)
			.addTag(IcariaItemTags.LOGS_POPULUS);

		this.tag(ItemTags.WALLS)
			.add(IcariaItems.QUARTZ_WALL.get());

		this.tag(ItemTags.LEAVES)
			.add(IcariaItems.CYPRESS_LEAVES.get())
			.add(IcariaItems.DROUGHTROOT_LEAVES.get())
			.add(IcariaItems.FIR_LEAVES.get())
			.add(IcariaItems.LAUREL_LEAVES.get())
			.add(IcariaItems.OLIVE_LEAVES.get())
			.add(IcariaItems.PLANE_LEAVES.get())
			.add(IcariaItems.POPULUS_LEAVES.get());

		this.tag(ItemTags.SMALL_FLOWERS)
			.add(IcariaItems.BLINDWEED.get())
			.add(IcariaItems.CHAMEOMILE.get())
			.add(IcariaItems.CHARMONDER.get())
			.add(IcariaItems.CLOVER.get())
			.add(IcariaItems.FIREHILT.get())
			.add(IcariaItems.BLUE_HYDRACINTH.get())
			.add(IcariaItems.PURPLE_HYDRACINTH.get())
			.add(IcariaItems.LIONFANGS.get())
			.add(IcariaItems.SPEARDROPS.get())
			.add(IcariaItems.PURPLE_STAGHORN.get())
			.add(IcariaItems.YELLOW_STAGHORN.get())
			.add(IcariaItems.BLUE_STORMCOTTON.get())
			.add(IcariaItems.PINK_STORMCOTTON.get())
			.add(IcariaItems.PURPLE_STORMCOTTON.get())
			.add(IcariaItems.SUNKETTLE.get())
			.add(IcariaItems.SUNSPONGE.get())
			.add(IcariaItems.VOIDLILY.get())
			.add(IcariaItems.WHITE_BROMELIA.get())
			.add(IcariaItems.ORANGE_BROMELIA.get())
			.add(IcariaItems.PINK_BROMELIA.get())
			.add(IcariaItems.PURPLE_BROMELIA.get());

		this.tag(ItemTags.DIRT)
			.add(IcariaItems.GRASSY_MARL.get())
			.add(IcariaItems.MARL.get())
			.add(IcariaItems.COARSE_MARL.get())
			.add(IcariaItems.DRY_LAKE_BED.get())
			.add(IcariaItems.LOAM.get());

		this.tag(ItemTags.DAMPENS_VIBRATIONS)
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get());

		this.tag(Tags.Items.BUDDING_BLOCKS)
			.add(IcariaItems.BUDDING_CALCITE.get())
			.add(IcariaItems.BUDDING_HALITE.get())
			.add(IcariaItems.BUDDING_JASPER.get())
			.add(IcariaItems.BUDDING_ZIRCON.get());

		this.tag(Tags.Items.CHAINS)
			.add(IcariaItems.VANADIUMSTEEL_CHAIN.get());

		this.tag(Tags.Items.CHESTS_TRAPPED)
			.add(IcariaItems.TRAPPED_CHEST.get());

		this.tag(Tags.Items.CHESTS_WOODEN)
			.add(IcariaItems.CHEST.get())
			.add(IcariaItems.TRAPPED_CHEST.get());

		this.tag(Tags.Items.COBBLESTONES_NORMAL)
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(Tags.Items.GLASS_BLOCKS_COLORLESS)
			.add(IcariaItems.GRAINGLASS.get())
			.add(IcariaItems.SILKGLASS.get());

		this.tag(Tags.Items.GLASS_BLOCKS_CHEAP)
			.add(IcariaItems.GRAINGLASS.get())
			.add(IcariaItems.SILKGLASS.get());

		this.tag(Tags.Items.GLASS_PANES_COLORLESS)
			.add(IcariaItems.GRAINGLASS_PANE.get())
			.add(IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get())
			.add(IcariaItems.SILKGLASS_PANE.get())
			.add(IcariaItems.HORIZONTAL_SILKGLASS_PANE.get());

		this.tag(Tags.Items.ORE_RATES_SINGULAR)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.GRAINEL_CHERT.get())
			.add(IcariaItems.LIGNITE_ORE.get())
			.add(IcariaItems.CHALKOS_ORE.get())
			.add(IcariaItems.KASSITEROS_ORE.get())
			.add(IcariaItems.DOLOMITE_ORE.get())
			.add(IcariaItems.VANADIUM_ORE.get())
			.add(IcariaItems.SLIVER_ORE.get())
			.add(IcariaItems.SIDEROS_ORE.get())
			.add(IcariaItems.ANTHRACITE_ORE.get())
			.add(IcariaItems.MOLYBDENUM_ORE.get());

		this.tag(Tags.Items.ORE_RATES_SPARSE)
			.add(IcariaItems.HYLIASTRUM_ORE.get());

		this.tag(Tags.Items.ORES)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.GRAINEL_CHERT.get())
			.add(IcariaItems.LIGNITE_ORE.get())
			.add(IcariaItems.CHALKOS_ORE.get())
			.add(IcariaItems.KASSITEROS_ORE.get())
			.add(IcariaItems.DOLOMITE_ORE.get())
			.add(IcariaItems.VANADIUM_ORE.get())
			.add(IcariaItems.SLIVER_ORE.get())
			.add(IcariaItems.SIDEROS_ORE.get())
			.add(IcariaItems.ANTHRACITE_ORE.get())
			.add(IcariaItems.MOLYBDENUM_ORE.get())
			.add(IcariaItems.HYLIASTRUM_ORE.get());

		this.tag(Tags.Items.PLAYER_WORKSTATIONS_CRAFTING_TABLES)
			.add(IcariaItems.CYPRESS_CRAFTING_TABLE.get())
			.add(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaItems.FIR_CRAFTING_TABLE.get())
			.add(IcariaItems.LAUREL_CRAFTING_TABLE.get())
			.add(IcariaItems.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaItems.PLANE_CRAFTING_TABLE.get())
			.add(IcariaItems.POPULUS_CRAFTING_TABLE.get());

		this.tag(Tags.Items.STONES)
			.add(IcariaItems.YELLOWSTONE.get())
			.add(IcariaItems.SILKSTONE.get())
			.add(IcariaItems.SUNSTONE.get())
			.add(IcariaItems.VOIDSHALE.get())
			.add(IcariaItems.BAETYL.get())
			.add(IcariaItems.SMOOTH_RELICSTONE.get());

		this.tag(Tags.Items.STORAGE_BLOCKS)
			.add(IcariaItems.PACKED_ARISTONE.get())
			.add(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.SPELT_BALE_BLOCK.get())
			.add(IcariaItems.VINE_REED_BLOCK.get())
			.add(IcariaItems.ROTTEN_BONES_BLOCK.get())
			.add(IcariaItems.RAW_CHALKOS_BLOCK.get())
			.add(IcariaItems.RAW_KASSITEROS_BLOCK.get())
			.add(IcariaItems.RAW_VANADIUM_BLOCK.get())
			.add(IcariaItems.RAW_SIDEROS_BLOCK.get())
			.add(IcariaItems.RAW_MOLYBDENUM_BLOCK.get())
			.add(IcariaItems.CALCITE_BLOCK.get())
			.add(IcariaItems.HALITE_BLOCK.get())
			.add(IcariaItems.JASPER_BLOCK.get())
			.add(IcariaItems.ZIRCON_BLOCK.get())
			.add(IcariaItems.CHERT_BLOCK.get())
			.add(IcariaItems.LIGNITE_BLOCK.get())
			.add(IcariaItems.CHALKOS_BLOCK.get())
			.add(IcariaItems.KASSITEROS_BLOCK.get())
			.add(IcariaItems.ORICHALCUM_BLOCK.get())
			.add(IcariaItems.VANADIUM_BLOCK.get())
			.add(IcariaItems.SLIVER_BLOCK.get())
			.add(IcariaItems.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaItems.SIDEROS_BLOCK.get())
			.add(IcariaItems.ANTHRACITE_BLOCK.get())
			.add(IcariaItems.MOLYBDENUM_BLOCK.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get())
			.add(IcariaItems.BLURIDIUM_BLOCK.get());

		this.tag(IcariaItemTags.LOGS_CYPRESS)
			.add(IcariaItems.CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaItems.CYPRESS_WOOD.get())
			.add(IcariaItems.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaItems.DEAD_CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get());

		this.tag(IcariaItemTags.LOGS_DROUGHTROOT)
			.add(IcariaItems.DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaItems.DROUGHTROOT_WOOD.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaItems.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get());

		this.tag(IcariaItemTags.LOGS_FIR)
			.add(IcariaItems.FIR_LOG.get())
			.add(IcariaItems.STRIPPED_FIR_LOG.get())
			.add(IcariaItems.FIR_WOOD.get())
			.add(IcariaItems.STRIPPED_FIR_WOOD.get())
			.add(IcariaItems.DEAD_FIR_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_FIR_LOG.get());

		this.tag(IcariaItemTags.LOGS_LAUREL)
			.add(IcariaItems.LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_LAUREL_LOG.get())
			.add(IcariaItems.LAUREL_WOOD.get())
			.add(IcariaItems.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaItems.DEAD_LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get());

		this.tag(IcariaItemTags.LOGS_OLIVE)
			.add(IcariaItems.OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_OLIVE_LOG.get())
			.add(IcariaItems.OLIVE_WOOD.get())
			.add(IcariaItems.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaItems.DEAD_OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get());

		this.tag(IcariaItemTags.LOGS_PLANE)
			.add(IcariaItems.PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_PLANE_LOG.get())
			.add(IcariaItems.PLANE_WOOD.get())
			.add(IcariaItems.STRIPPED_PLANE_WOOD.get())
			.add(IcariaItems.DEAD_PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_PLANE_LOG.get());

		this.tag(IcariaItemTags.LOGS_POPULUS)
			.add(IcariaItems.POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_POPULUS_LOG.get())
			.add(IcariaItems.POPULUS_WOOD.get())
			.add(IcariaItems.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaItems.DEAD_POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(IcariaItemTags.ORE_BEARING_GROUND_MARL).add(IcariaItems.MARL.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_GRAINEL).add(IcariaItems.GRAINEL.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_YELLOWSTONE).add(IcariaItems.YELLOWSTONE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_SILKSTONE).add(IcariaItems.SILKSTONE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_SUNSTONE).add(IcariaItems.SUNSTONE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_VOIDSHALE).add(IcariaItems.VOIDSHALE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_BAETYL).add(IcariaItems.BAETYL.get());

		this.tag(IcariaItemTags.ORES_CHERT)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.GRAINEL_CHERT.get());

		this.tag(IcariaItemTags.ORES_BONES)
			.add(IcariaItems.MARL_BONES.get());

		this.tag(IcariaItemTags.ORES_LIGNITE)
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.LIGNITE_ORE.get());

		this.tag(IcariaItemTags.ORES_CHALKOS)
			.add(IcariaItems.CHALKOS_ORE.get());

		this.tag(IcariaItemTags.ORES_KASSITEROS)
			.add(IcariaItems.KASSITEROS_ORE.get());

		this.tag(IcariaItemTags.ORES_DOLOMITE)
			.add(IcariaItems.DOLOMITE_ORE.get());

		this.tag(IcariaItemTags.ORES_VANADIUM)
			.add(IcariaItems.VANADIUM_ORE.get());

		this.tag(IcariaItemTags.ORES_SLIVER)
			.add(IcariaItems.SLIVER_ORE.get());

		this.tag(IcariaItemTags.ORES_SIDEROS)
			.add(IcariaItems.SIDEROS_ORE.get());

		this.tag(IcariaItemTags.ORES_ANTHRACITE)
			.add(IcariaItems.ANTHRACITE_ORE.get());

		this.tag(IcariaItemTags.ORES_MOLYBDENUM)
			.add(IcariaItems.MOLYBDENUM_ORE.get());

		this.tag(IcariaItemTags.ORES_HYLIASTRUM)
			.add(IcariaItems.HYLIASTRUM_ORE.get());

		this.tag(IcariaItemTags.ORES_IN_GROUND_MARL)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get());

		this.tag(IcariaItemTags.ORES_IN_GROUND_GRAINEL)
			.add(IcariaItems.GRAINEL_CHERT.get());

		this.tag(IcariaItemTags.ORES_IN_GROUND_YELLOWSTONE)
			.add(IcariaItems.LIGNITE_ORE.get())
			.add(IcariaItems.CHALKOS_ORE.get());

		this.tag(IcariaItemTags.ORES_IN_GROUND_SILKSTONE)
			.add(IcariaItems.KASSITEROS_ORE.get())
			.add(IcariaItems.DOLOMITE_ORE.get());

		this.tag(IcariaItemTags.ORES_IN_GROUND_SUNSTONE)
			.add(IcariaItems.VANADIUM_ORE.get())
			.add(IcariaItems.SLIVER_ORE.get());

		this.tag(IcariaItemTags.ORES_IN_GROUND_VOIDSHALE)
			.add(IcariaItems.SIDEROS_ORE.get())
			.add(IcariaItems.ANTHRACITE_ORE.get());

		this.tag(IcariaItemTags.ORES_IN_GROUND_BAETYL)
			.add(IcariaItems.MOLYBDENUM_ORE.get())
			.add(IcariaItems.HYLIASTRUM_ORE.get());

		this.tag(IcariaItemTags.STORAGE_BLOCKS_PACKED_ARISTONE).add(IcariaItems.PACKED_ARISTONE.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY).add(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY).add(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY).add(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY).add(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY).add(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ARACHNE_STRING).add(IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SPELT).add(IcariaItems.SPELT_BALE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VINE_REED).add(IcariaItems.VINE_REED_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ROTTEN_BONES).add(IcariaItems.ROTTEN_BONES_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_CHALKOS).add(IcariaItems.RAW_CHALKOS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_KASSITEROS).add(IcariaItems.RAW_KASSITEROS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_VANADIUM).add(IcariaItems.RAW_VANADIUM_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_SIDEROS).add(IcariaItems.RAW_SIDEROS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_MOLYBDENUM).add(IcariaItems.RAW_MOLYBDENUM_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_CALCITE).add(IcariaItems.CALCITE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_HALITE).add(IcariaItems.HALITE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_JASPER).add(IcariaItems.JASPER_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ZIRCON).add(IcariaItems.ZIRCON_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_CHERT).add(IcariaItems.CHERT_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_LIGNITE).add(IcariaItems.LIGNITE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_CHALKOS).add(IcariaItems.CHALKOS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_KASSITEROS).add(IcariaItems.KASSITEROS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ORICHALCUM).add(IcariaItems.ORICHALCUM_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VANADIUM).add(IcariaItems.VANADIUM_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SLIVER).add(IcariaItems.SLIVER_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SIDEROS).add(IcariaItems.SIDEROS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ANTHRACITE).add(IcariaItems.ANTHRACITE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_BLURIDIUM).add(IcariaItems.BLURIDIUM_BLOCK.get());
	}

	public static TagKey<Item> bind(String pName) {
		return TagKey.create(Registries.ITEM, ResourceLocation.parse(pName));
	}

	public static TagKey<Item> cTag(String pName) {
		return IcariaItemTags.bind(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Item> icariaTag(String pName) {
		return IcariaItemTags.bind(IcariaIdents.ID + ":" + pName);
	}
}
