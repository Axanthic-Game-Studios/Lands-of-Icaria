package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemTags extends ItemTagsProvider {
	// ITEM TAGS
	public static final TagKey<Item> GEMS_CHERT = forgeTag("gems/chert");
	public static final TagKey<Item> GEMS_LIGNITE = forgeTag("gems/lignite");
	public static final TagKey<Item> GEMS_DOLOMITE = forgeTag("gems/dolomite");
	public static final TagKey<Item> GEMS_SLIVER = forgeTag("gems/sliver");
	public static final TagKey<Item> GEMS_ANTHRACITE = forgeTag("gems/anthracite");
	public static final TagKey<Item> GEMS_CALCITE = forgeTag("gems/calcite");
	public static final TagKey<Item> GEMS_HALITE = forgeTag("gems/halite");
	public static final TagKey<Item> GEMS_JASPER = forgeTag("gems/jasper");
	public static final TagKey<Item> GEMS_ZIRCON = forgeTag("gems/zircon");

	public static final TagKey<Item> CROPS_SPELT = forgeTag("crops/spelt");
	public static final TagKey<Item> CROPS_STRAWBERRIES = forgeTag("crops/strawberry");
	public static final TagKey<Item> CROPS_GARLIC = forgeTag("crops/garlic");
	public static final TagKey<Item> CROPS_ONION = forgeTag("crops/onion");

	public static final TagKey<Item> DUSTS_CALCITE = forgeTag("dusts/calcite");
	public static final TagKey<Item> DUSTS_HALITE = forgeTag("dusts/halite");

	public static final TagKey<Item> RAW_MATERIALS_CHALKOS = forgeTag("raw_materials/chalkos");
	public static final TagKey<Item> RAW_MATERIALS_KASSITEROS = forgeTag("raw_materials/kassiteros");
	public static final TagKey<Item> RAW_MATERIALS_VANADIUM = forgeTag("raw_materials/vanadium");
	public static final TagKey<Item> RAW_MATERIALS_SIDEROS = forgeTag("raw_materials/sideros");
	public static final TagKey<Item> RAW_MATERIALS_MOLYBDENUM = forgeTag("raw_materials/molybdenum");

	public static final TagKey<Item> NUGGETS_CHALKOS = forgeTag("nuggets/chalkos");
	public static final TagKey<Item> NUGGETS_KASSITEROS = forgeTag("nuggets/kassiteros");
	public static final TagKey<Item> NUGGETS_ORICHALCUM = forgeTag("nuggets/orichalcum");
	public static final TagKey<Item> NUGGETS_VANADIUM = forgeTag("nuggets/vanadium");
	public static final TagKey<Item> NUGGETS_VANADIUMSTEEL = forgeTag("nuggets/vanadiumsteel");
	public static final TagKey<Item> NUGGETS_SIDEROS = forgeTag("nuggets/sideros");
	public static final TagKey<Item> NUGGETS_MOLYBDENUM = forgeTag("nuggets/molybdenum");
	public static final TagKey<Item> NUGGETS_MOLYBDENUMSTEEL = forgeTag("nuggets/molybdenumsteel");
	public static final TagKey<Item> NUGGETS_BLURIDIUM = forgeTag("nuggets/bluridium");

	public static final TagKey<Item> INGOTS_LOAM_BRICK = forgeTag("ingots/loam_brick");
	public static final TagKey<Item> INGOTS_CHALKOS = forgeTag("ingots/chalkos");
	public static final TagKey<Item> INGOTS_KASSITEROS = forgeTag("ingots/kassiteros");
	public static final TagKey<Item> INGOTS_ORICHALCUM = forgeTag("ingots/orichalcum");
	public static final TagKey<Item> INGOTS_VANADIUM = forgeTag("ingots/vanadium");
	public static final TagKey<Item> INGOTS_VANADIUMSTEEL = forgeTag("ingots/vanadiumsteel");
	public static final TagKey<Item> INGOTS_SIDEROS = forgeTag("ingots/sideros");
	public static final TagKey<Item> INGOTS_MOLYBDENUM = forgeTag("ingots/molybdenum");
	public static final TagKey<Item> INGOTS_MOLYBDENUMSTEEL = forgeTag("ingots/molybdenumsteel");
	public static final TagKey<Item> INGOTS_BLURIDIUM = forgeTag("ingots/bluridium");

	public static final TagKey<Item> SEEDS_SPELT = forgeTag("seeds/spelt");
	public static final TagKey<Item> SEEDS_STRAWBERRY = forgeTag("seeds/strawberry");
	public static final TagKey<Item> SEEDS_PHYSALIS = forgeTag("seeds/physalis");
	public static final TagKey<Item> SEEDS_ONION = forgeTag("seeds/onion");

	// ITEMBLOCK TAGS
	public static final TagKey<Item> ORES_CHERT = forgeTag("ores/chert");
	public static final TagKey<Item> ORES_LIGNITE = forgeTag("ores/lignite");
	public static final TagKey<Item> ORES_BLURIDIUM = forgeTag("ores/bluridium");

	public static final TagKey<Item> ORES_IN_GROUND_MARL = forgeTag("ores_in_ground/marl");
	public static final TagKey<Item> ORES_IN_GROUND_GRAINEL = forgeTag("ores_in_ground/grainel");
	public static final TagKey<Item> ORES_IN_GROUND_YELLOWSTONE = forgeTag("ores_in_ground/yellowstone");
	public static final TagKey<Item> ORES_IN_GROUND_SILKSTONE = forgeTag("ores_in_ground/silkstone");
	public static final TagKey<Item> ORES_IN_GROUND_SUNSTONE = forgeTag("ores_in_ground/sunstone");
	public static final TagKey<Item> ORES_IN_GROUND_VOIDSHALE = forgeTag("ores_in_ground/voidshale");
	public static final TagKey<Item> ORES_IN_GROUND_BAETYL = forgeTag("ores_in_ground/baetyl");
	public static final TagKey<Item> ORES_IN_GROUND_PLATOSHALE = forgeTag("ores_in_ground/platoshale");

	public static final TagKey<Item> ORE_BEARING_GROUND_MARL = forgeTag("ore_bearing_ground/marl");
	public static final TagKey<Item> ORE_BEARING_GROUND_GRAINEL = forgeTag("ore_bearing_ground/grainel");
	public static final TagKey<Item> ORE_BEARING_GROUND_YELLOWSTONE = forgeTag("ore_bearing_ground/yellowstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SILKSTONE = forgeTag("ore_bearing_ground/silkstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SUNSTONE = forgeTag("ore_bearing_ground/sunstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_VOIDSHALE = forgeTag("ore_bearing_ground/voidshale");
	public static final TagKey<Item> ORE_BEARING_GROUND_BAETYL = forgeTag("ore_bearing_ground/baetyl");
	public static final TagKey<Item> ORE_BEARING_GROUND_PLATOSHALE = forgeTag("ore_bearing_ground/platoshale");
	public static final TagKey<Item> ORE_BEARING_GROUND_PLATOSHALE_BRICKS = forgeTag("ore_bearing_ground/platoshale_bricks");

	public static final TagKey<Item> STORAGE_BLOCKS_ARISTONE_PACKED = forgeTag("storage_blocks/aristone_packed");
	public static final TagKey<Item> STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY = forgeTag("storage_blocks/ender_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY = forgeTag("storage_blocks/fire_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY = forgeTag("storage_blocks/nature_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_VOID_JELLYFISH_JELLY = forgeTag("storage_blocks/void_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_WATER_JELLYFISH_JELLY = forgeTag("storage_blocks/water_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_ARACHNE_STRING = forgeTag("storage_blocks/arachne_string");
	public static final TagKey<Item> STORAGE_BLOCKS_SPELT = forgeTag("storage_blocks/spelt");
	public static final TagKey<Item> STORAGE_BLOCKS_VINE_REED = forgeTag("storage_blocks/vine_reed");
	public static final TagKey<Item> STORAGE_BLOCKS_VINE_SPROUT = forgeTag("storage_blocks/vine_sprout");
	public static final TagKey<Item> STORAGE_BLOCKS_ROTTEN_BONES = forgeTag("storage_blocks/rotten_bones");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_CHALKOS = forgeTag("storage_blocks/raw_chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_KASSITEROS = forgeTag("storage_blocks/raw_kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_VANADIUM = forgeTag("storage_blocks/raw_vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_SIDEROS = forgeTag("storage_blocks/raw_sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_MOLYBDENUM = forgeTag("storage_blocks/raw_molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_CALCITE = forgeTag("storage_blocks/calcite");
	public static final TagKey<Item> STORAGE_BLOCKS_HALITE = forgeTag("storage_blocks/halite");
	public static final TagKey<Item> STORAGE_BLOCKS_JASPER = forgeTag("storage_blocks/jasper");
	public static final TagKey<Item> STORAGE_BLOCKS_ZIRCON = forgeTag("storage_blocks/zircon");
	public static final TagKey<Item> STORAGE_BLOCKS_CHERT = forgeTag("storage_blocks/chert");
	public static final TagKey<Item> STORAGE_BLOCKS_LIGNITE = forgeTag("storage_blocks/lignite");
	public static final TagKey<Item> STORAGE_BLOCKS_CHALKOS = forgeTag("storage_blocks/chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_KASSITEROS = forgeTag("storage_blocks/kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_ORICHALCUM = forgeTag("storage_blocks/orichalcum");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUM = forgeTag("storage_blocks/vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUMSTEEL = forgeTag("storage_blocks/vanadiumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_SLIVER = forgeTag("storage_blocks/sliver");
	public static final TagKey<Item> STORAGE_BLOCKS_SIDEROS = forgeTag("storage_blocks/sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_ANTHRACITE = forgeTag("storage_blocks/anthracite");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUM = forgeTag("storage_blocks/molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUMSTEEL = forgeTag("storage_blocks/molybdenumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_BLURIDIUM = forgeTag("storage_blocks/bluridium");

	public static final TagKey<Item> LOGS_CYPRESS = forgeTag("logs/cypress");
	public static final TagKey<Item> LOGS_DROUGHTROOT = forgeTag("logs/droughtroot");
	public static final TagKey<Item> LOGS_FIR = forgeTag("logs/fir");
	public static final TagKey<Item> LOGS_LAUREL = forgeTag("logs/laurel");
	public static final TagKey<Item> LOGS_OLIVE = forgeTag("logs/olive");
	public static final TagKey<Item> LOGS_PLANE = forgeTag("logs/plane");
	public static final TagKey<Item> LOGS_POPULUS = forgeTag("logs/populus");

	public IcariaItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, new IcariaBlockTags(pOutput, pProvider, pId, pHelper), pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		// ITEM TAGS
		this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
			.add(IcariaItems.YELLOWSTONE_COBBLE.get())
			.add(IcariaItems.SILKSTONE_COBBLE.get())
			.add(IcariaItems.SUNSTONE_COBBLE.get())
			.add(IcariaItems.VOIDSHALE_COBBLE.get())
			.add(IcariaItems.BAETYL_COBBLE.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(ItemTags.STONE_TOOL_MATERIALS)
			.add(IcariaItems.YELLOWSTONE_COBBLE.get())
			.add(IcariaItems.SILKSTONE_COBBLE.get())
			.add(IcariaItems.SUNSTONE_COBBLE.get())
			.add(IcariaItems.VOIDSHALE_COBBLE.get())
			.add(IcariaItems.BAETYL_COBBLE.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(Tags.Items.HEADS)
			.add(IcariaItems.AETERNAE_SKULL.get())
			.add(IcariaItems.ARGAN_HOUND_SKULL.get())
			.add(IcariaItems.CATOBLEPAS_SKULL.get())
			.add(IcariaItems.CERVER_SKULL.get())
			.add(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get())
			.add(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get())
			.add(IcariaItems.FIR_FOREST_HAG_SKULL.get())
			.add(IcariaItems.SOW_SKULL.get());

		this.tag(ItemTags.SIGNS)
			.add(IcariaItems.CYPRESS_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_SIGN.get())
			.add(IcariaItems.FIR_SIGN.get())
			.add(IcariaItems.LAUREL_SIGN.get())
			.add(IcariaItems.OLIVE_SIGN.get())
			.add(IcariaItems.PLANE_SIGN.get())
			.add(IcariaItems.POPULUS_SIGN.get());

		this.tag(Tags.Items.MUSHROOMS)
			.add(IcariaItems.GREEN_GROUND_SHROOMS.get())
			.add(IcariaItems.BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get())
			.add(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get())
			.add(IcariaItems.UNNAMED_TREE_SHROOMS.get());

		this.tag(IcariaItemTags.GEMS_CHERT).add(IcariaItems.CHERT.get());
		this.tag(IcariaItemTags.GEMS_LIGNITE).add(IcariaItems.LIGNITE.get());
		this.tag(IcariaItemTags.GEMS_DOLOMITE).add(IcariaItems.DOLOMITE.get());
		this.tag(IcariaItemTags.GEMS_SLIVER).add(IcariaItems.SLIVER.get());
		this.tag(IcariaItemTags.GEMS_ANTHRACITE).add(IcariaItems.ANTHRACITE.get());
		this.tag(IcariaItemTags.GEMS_CALCITE).add(IcariaItems.CALCITE.get());
		this.tag(IcariaItemTags.GEMS_HALITE).add(IcariaItems.HALITE.get());
		this.tag(IcariaItemTags.GEMS_JASPER).add(IcariaItems.JASPER.get());
		this.tag(IcariaItemTags.GEMS_ZIRCON).add(IcariaItems.ZIRCON.get());

		this.tag(Tags.Items.GEMS)
			.add(IcariaItems.CHERT.get())
			.add(IcariaItems.LIGNITE.get())
			.add(IcariaItems.DOLOMITE.get())
			.add(IcariaItems.SLIVER.get())
			.add(IcariaItems.ANTHRACITE.get())
			.add(IcariaItems.CALCITE.get())
			.add(IcariaItems.HALITE.get())
			.add(IcariaItems.JASPER.get())
			.add(IcariaItems.ZIRCON.get());

		this.tag(Tags.Items.SLIMEBALLS)
			.add(IcariaItems.ENDER_JELLYFISH_JELLY.get())
			.add(IcariaItems.FIRE_JELLYFISH_JELLY.get())
			.add(IcariaItems.NATURE_JELLYFISH_JELLY.get())
			.add(IcariaItems.VOID_JELLYFISH_JELLY.get())
			.add(IcariaItems.WATER_JELLYFISH_JELLY.get());

		this.tag(Tags.Items.STRING)
			.add(IcariaItems.ARACHNE_STRING.get());

		this.tag(IcariaItemTags.CROPS_SPELT).add(IcariaItems.SPELT.get());
		this.tag(IcariaItemTags.CROPS_STRAWBERRIES).add(IcariaItems.STRAWBERRIES.get());
		this.tag(IcariaItemTags.CROPS_GARLIC).add(IcariaItems.GARLIC.get());
		this.tag(IcariaItemTags.CROPS_ONION).add(IcariaItems.ONION.get());

		this.tag(Tags.Items.CROPS)
			.add(IcariaItems.SPELT.get())
			.add(IcariaItems.STRAWBERRIES.get())
			.add(IcariaItems.PHYSALIS.get())
			.add(IcariaItems.ONION.get());

		this.tag(IcariaItemTags.DUSTS_CALCITE).add(IcariaItems.CALCITE_DUST.get());
		this.tag(IcariaItemTags.DUSTS_HALITE).add(IcariaItems.HALITE_DUST.get());

		this.tag(Tags.Items.DUSTS)
			.add(IcariaItems.CALCITE_DUST.get())
			.add(IcariaItems.HALITE_DUST.get());

		this.tag(ItemTags.COALS)
			.add(IcariaItems.LIGNITE.get())
			.add(IcariaItems.ANTHRACITE.get());

		this.tag(IcariaItemTags.RAW_MATERIALS_CHALKOS).add(IcariaItems.CHALKOS_RAW.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_KASSITEROS).add(IcariaItems.KASSITEROS_RAW.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_VANADIUM).add(IcariaItems.VANADIUM_RAW.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_SIDEROS).add(IcariaItems.SIDEROS_RAW.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_RAW.get());

		this.tag(Tags.Items.RAW_MATERIALS)
			.add(IcariaItems.CHALKOS_RAW.get())
			.add(IcariaItems.KASSITEROS_RAW.get())
			.add(IcariaItems.VANADIUM_RAW.get())
			.add(IcariaItems.SIDEROS_RAW.get())
			.add(IcariaItems.MOLYBDENUM_RAW.get());

		this.tag(IcariaItemTags.NUGGETS_CHALKOS).add(IcariaItems.CHALKOS_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_KASSITEROS).add(IcariaItems.KASSITEROS_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_ORICHALCUM).add(IcariaItems.ORICHALCUM_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_VANADIUM).add(IcariaItems.VANADIUM_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_SIDEROS).add(IcariaItems.SIDEROS_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		this.tag(IcariaItemTags.NUGGETS_BLURIDIUM).add(IcariaItems.BLURIDIUM_NUGGET.get());

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

		this.tag(IcariaItemTags.INGOTS_LOAM_BRICK).add(IcariaItems.LOAM_BRICK.get());
		this.tag(IcariaItemTags.INGOTS_CHALKOS).add(IcariaItems.CHALKOS_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_KASSITEROS).add(IcariaItems.KASSITEROS_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_ORICHALCUM).add(IcariaItems.ORICHALCUM_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_VANADIUM).add(IcariaItems.VANADIUM_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_SIDEROS).add(IcariaItems.SIDEROS_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.tag(IcariaItemTags.INGOTS_BLURIDIUM).add(IcariaItems.BLURIDIUM_INGOT.get());

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

		this.tag(Tags.Items.TOOLS_SWORDS)
			.add(IcariaItems.CHERT_TOOLS.sword.get())
			.add(IcariaItems.CHALKOS_TOOLS.sword.get())
			.add(IcariaItems.KASSITEROS_TOOLS.sword.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.sword.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.sword.get())
			.add(IcariaItems.SIDEROS_TOOLS.sword.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get());

		this.tag(Tags.Items.TOOLS_AXES)
			.add(IcariaItems.CHERT_TOOLS.axe.get())
			.add(IcariaItems.CHALKOS_TOOLS.axe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.axe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.axe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.axe.get())
			.add(IcariaItems.SIDEROS_TOOLS.axe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get());

		this.tag(Tags.Items.TOOLS_PICKAXES)
			.add(IcariaItems.CHERT_TOOLS.pickaxe.get())
			.add(IcariaItems.CHALKOS_TOOLS.pickaxe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.pickaxe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get())
			.add(IcariaItems.SIDEROS_TOOLS.pickaxe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get());

		this.tag(Tags.Items.TOOLS_SHOVELS)
			.add(IcariaItems.CHERT_TOOLS.shovel.get())
			.add(IcariaItems.CHALKOS_TOOLS.shovel.get())
			.add(IcariaItems.KASSITEROS_TOOLS.shovel.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.shovel.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get())
			.add(IcariaItems.SIDEROS_TOOLS.shovel.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get());

		this.tag(Tags.Items.TOOLS_HOES)
			.add(IcariaItems.CHERT_TOOLS.scythe.get())
			.add(IcariaItems.CHALKOS_TOOLS.scythe.get())
			.add(IcariaItems.KASSITEROS_TOOLS.scythe.get())
			.add(IcariaItems.ORICHALCUM_TOOLS.scythe.get())
			.add(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get())
			.add(IcariaItems.SIDEROS_TOOLS.scythe.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get());

		this.tag(ItemTags.FREEZE_IMMUNE_WEARABLES)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get())
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get())
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get())
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get());

		this.tag(Tags.Items.ARMORS_HELMETS)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get())
			.add(IcariaItems.CHALKOS_ARMOR.helmet.get())
			.add(IcariaItems.KASSITEROS_ARMOR.helmet.get())
			.add(IcariaItems.ORICHALCUM_HELMET.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get());

		this.tag(Tags.Items.ARMORS_CHESTPLATES)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get())
			.add(IcariaItems.CHALKOS_ARMOR.chestplate.get())
			.add(IcariaItems.KASSITEROS_ARMOR.chestplate.get())
			.add(IcariaItems.ORICHALCUM_CHESTPLATE.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get());

		this.tag(Tags.Items.ARMORS_LEGGINGS)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get())
			.add(IcariaItems.CHALKOS_ARMOR.leggings.get())
			.add(IcariaItems.KASSITEROS_ARMOR.leggings.get())
			.add(IcariaItems.ORICHALCUM_LEGGINGS.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get());

		this.tag(Tags.Items.ARMORS_BOOTS)
			.add(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get())
			.add(IcariaItems.CHALKOS_ARMOR.boots.get())
			.add(IcariaItems.KASSITEROS_ARMOR.boots.get())
			.add(IcariaItems.ORICHALCUM_BOOTS.get())
			.add(IcariaItems.VANADIUMSTEEL_ARMOR.boots.get());

		this.tag(Tags.Items.LEATHER)
			.add(IcariaItems.AETERNAE_HIDE.get());

		this.tag(IcariaItemTags.SEEDS_SPELT).add(IcariaItems.SPELT_SEEDS.get());
		this.tag(IcariaItemTags.SEEDS_STRAWBERRY).add(IcariaItems.STRAWBERRY_SEEDS.get());
		this.tag(IcariaItemTags.SEEDS_PHYSALIS).add(IcariaItems.PHYSALIS_SEEDS.get());
		this.tag(IcariaItemTags.SEEDS_ONION).add(IcariaItems.ONION.get());

		this.tag(Tags.Items.SEEDS)
			.add(IcariaItems.SPELT_SEEDS.get())
			.add(IcariaItems.STRAWBERRY_SEEDS.get())
			.add(IcariaItems.PHYSALIS_SEEDS.get())
			.add(IcariaItems.ONION.get());

		// ITEMBLOCK TAGS
		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_DECO) {
			this.tag(ItemTags.STAIRS).add(deco.stairs.get());
			this.tag(ItemTags.SLABS).add(deco.slab.get());
			this.tag(ItemTags.WALLS).add(deco.wall.get());
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_DECO) {
			this.tag(ItemTags.WOODEN_STAIRS).add(deco.stairs.get());
			this.tag(ItemTags.WOODEN_SLABS).add(deco.slab.get());
			this.tag(ItemTags.WOODEN_FENCES).add(deco.fence.get());
			this.tag(Tags.Items.FENCE_GATES_WOODEN).add(deco.gate.get());
		}

		this.tag(ItemTags.DIRT)
			.add(IcariaItems.MARL_GRASS.get())
			.add(IcariaItems.MARL.get())
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.MARL_COARSE.get())
			.add(IcariaItems.LOAM.get());

		this.tag(IcariaItemTags.ORES_CHERT)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.GRAINEL_CHERT.get());

		this.tag(IcariaItemTags.ORES_LIGNITE)
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.LIGNITE_ORE.get());

		this.tag(IcariaItemTags.ORES_BLURIDIUM)
			.add(IcariaItems.PLATOSHALE_BLURRED.get())
			.add(IcariaItems.PLATOSHALE_BRICKS_BLURRED.get());

		this.tag(Tags.Items.ORES)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.GRAINEL_CHERT.get())
			.add(IcariaItems.PLATOSHALE_BLURRED.get())
			.add(IcariaItems.PLATOSHALE_BRICKS_BLURRED.get())
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

		this.tag(Tags.Items.ORE_RATES_SINGULAR)
			.add(IcariaItems.MARL_CHERT.get())
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

		this.tag(Tags.Items.ORE_RATES_DENSE)
			.add(IcariaItems.MARL_BONES.get());

		this.tag(Tags.Items.ORE_RATES_SPARSE)
			.add(IcariaItems.PLATOSHALE_BLURRED.get())
			.add(IcariaItems.PLATOSHALE_BRICKS_BLURRED.get());

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

		this.tag(IcariaItemTags.ORES_IN_GROUND_PLATOSHALE)
			.add(IcariaItems.PLATOSHALE_BLURRED.get())
			.add(IcariaItems.PLATOSHALE_BRICKS_BLURRED.get());

		this.tag(IcariaItemTags.ORE_BEARING_GROUND_MARL).add(IcariaItems.MARL.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_GRAINEL).add(IcariaItems.GRAINEL.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_YELLOWSTONE).add(IcariaItems.YELLOWSTONE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_SILKSTONE).add(IcariaItems.SILKSTONE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_SUNSTONE).add(IcariaItems.SUNSTONE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_VOIDSHALE).add(IcariaItems.VOIDSHALE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_BAETYL).add(IcariaItems.BAETYL.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_PLATOSHALE).add(IcariaItems.PLATOSHALE.get());
		this.tag(IcariaItemTags.ORE_BEARING_GROUND_PLATOSHALE_BRICKS).add(IcariaItems.PLATOSHALE_BRICKS.get());

		this.tag(Tags.Items.GLASS_COLORLESS)
			.add(IcariaItems.GRAINGLASS.get())
			.add(IcariaItems.SILKGLASS.get());

		this.tag(Tags.Items.GLASS_PANES_COLORLESS)
			.add(IcariaItems.GRAINGLASS_PANE.get())
			.add(IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get())
			.add(IcariaItems.SILKGLASS_PANE.get())
			.add(IcariaItems.SILKGLASS_PANE_HORIZONTAL.get());

		this.tag(Tags.Items.COBBLESTONE_NORMAL)
			.add(IcariaItems.YELLOWSTONE_COBBLE.get())
			.add(IcariaItems.SILKSTONE_COBBLE.get())
			.add(IcariaItems.SUNSTONE_COBBLE.get())
			.add(IcariaItems.VOIDSHALE_COBBLE.get())
			.add(IcariaItems.BAETYL_COBBLE.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(Tags.Items.STONE)
			.add(IcariaItems.YELLOWSTONE.get())
			.add(IcariaItems.SILKSTONE.get())
			.add(IcariaItems.SUNSTONE.get())
			.add(IcariaItems.VOIDSHALE.get())
			.add(IcariaItems.BAETYL.get())
			.add(IcariaItems.RELICSTONE_SMOOTH.get());

		this.tag(ItemTags.STONE_BRICKS)
			.add(IcariaItems.YELLOWSTONE_BRICKS.get())
			.add(IcariaItems.SILKSTONE_BRICKS.get())
			.add(IcariaItems.SUNSTONE_BRICKS.get())
			.add(IcariaItems.VOIDSHALE_BRICKS.get())
			.add(IcariaItems.BAETYL_BRICKS.get())
			.add(IcariaItems.RELICSTONE_BRICKS.get())
			.add(IcariaItems.PLATOSHALE_BRICKS.get());

		this.tag(IcariaItemTags.STORAGE_BLOCKS_ARISTONE_PACKED).add(IcariaItems.ARISTONE_PACKED.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY).add(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY).add(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY).add(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY).add(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY).add(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ARACHNE_STRING).add(IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SPELT).add(IcariaItems.SPELT_BALE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VINE_REED).add(IcariaItems.VINE_REED_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VINE_SPROUT).add(IcariaItems.VINE_SPROUT_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ROTTEN_BONES).add(IcariaItems.ROTTEN_BONES_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_CHALKOS).add(IcariaItems.CHALKOS_RAW_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_KASSITEROS).add(IcariaItems.KASSITEROS_RAW_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_VANADIUM).add(IcariaItems.VANADIUM_RAW_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SLIVER).add(IcariaItems.SLIVER_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_SIDEROS).add(IcariaItems.SIDEROS_RAW_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_RAW_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_RAW_BLOCK.get());
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
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SIDEROS).add(IcariaItems.SIDEROS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ANTHRACITE).add(IcariaItems.ANTHRACITE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_BLURIDIUM).add(IcariaItems.BLURIDIUM_BLOCK.get());

		this.tag(Tags.Items.STORAGE_BLOCKS)
			.add(IcariaItems.ARISTONE_PACKED.get())
			.add(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.SPELT_BALE_BLOCK.get())
			.add(IcariaItems.VINE_REED_BLOCK.get())
			.add(IcariaItems.VINE_SPROUT_BLOCK.get())
			.add(IcariaItems.ROTTEN_BONES_BLOCK.get())
			.add(IcariaItems.CHALKOS_RAW_BLOCK.get())
			.add(IcariaItems.KASSITEROS_RAW_BLOCK.get())
			.add(IcariaItems.VANADIUM_RAW_BLOCK.get())
			.add(IcariaItems.SLIVER_BLOCK.get())
			.add(IcariaItems.SIDEROS_RAW_BLOCK.get())
			.add(IcariaItems.MOLYBDENUM_RAW_BLOCK.get())
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
			.add(IcariaItems.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaItems.SIDEROS_BLOCK.get())
			.add(IcariaItems.ANTHRACITE_BLOCK.get())
			.add(IcariaItems.MOLYBDENUM_BLOCK.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get())
			.add(IcariaItems.BLURIDIUM_BLOCK.get());

		this.tag(ItemTags.DAMPENS_VIBRATIONS)
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get());

		this.tag(ItemTags.SAPLINGS)
			.add(IcariaItems.CYPRESS_SAPLING.get())
			.add(IcariaItems.DROUGHTROOT_SAPLING.get())
			.add(IcariaItems.FIR_SAPLING.get())
			.add(IcariaItems.LAUREL_SAPLING.get())
			.add(IcariaItems.OLIVE_SAPLING.get())
			.add(IcariaItems.PLANE_SAPLING.get())
			.add(IcariaItems.POPULUS_SAPLING.get());

		this.tag(ItemTags.LEAVES)
			.add(IcariaItems.CYPRESS_LEAVES.get())
			.add(IcariaItems.DROUGHTROOT_LEAVES.get())
			.add(IcariaItems.FIR_LEAVES.get())
			.add(IcariaItems.LAUREL_LEAVES.get())
			.add(IcariaItems.OLIVE_LEAVES.get())
			.add(IcariaItems.OLIVE_LEAVES_BLACK.get())
			.add(IcariaItems.OLIVE_LEAVES_GREEN.get())
			.add(IcariaItems.PLANE_LEAVES.get())
			.add(IcariaItems.POPULUS_LEAVES.get());

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

		this.tag(ItemTags.LOGS_THAT_BURN)
			.add(IcariaItems.CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaItems.CYPRESS_WOOD.get())
			.add(IcariaItems.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaItems.DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaItems.DROUGHTROOT_WOOD.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaItems.FIR_LOG.get())
			.add(IcariaItems.STRIPPED_FIR_LOG.get())
			.add(IcariaItems.FIR_WOOD.get())
			.add(IcariaItems.STRIPPED_FIR_WOOD.get())
			.add(IcariaItems.LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_LAUREL_LOG.get())
			.add(IcariaItems.LAUREL_WOOD.get())
			.add(IcariaItems.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaItems.OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_OLIVE_LOG.get())
			.add(IcariaItems.OLIVE_WOOD.get())
			.add(IcariaItems.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaItems.PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_PLANE_LOG.get())
			.add(IcariaItems.PLANE_WOOD.get())
			.add(IcariaItems.STRIPPED_PLANE_WOOD.get())
			.add(IcariaItems.POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_POPULUS_LOG.get())
			.add(IcariaItems.POPULUS_WOOD.get())
			.add(IcariaItems.STRIPPED_POPULUS_WOOD.get());

		this.tag(ItemTags.LOGS)
			.add(IcariaItems.CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaItems.CYPRESS_WOOD.get())
			.add(IcariaItems.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaItems.DEAD_CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get())
			.add(IcariaItems.DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaItems.DROUGHTROOT_WOOD.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaItems.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaItems.FIR_LOG.get())
			.add(IcariaItems.STRIPPED_FIR_LOG.get())
			.add(IcariaItems.FIR_WOOD.get())
			.add(IcariaItems.STRIPPED_FIR_WOOD.get())
			.add(IcariaItems.DEAD_FIR_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_FIR_LOG.get())
			.add(IcariaItems.LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_LAUREL_LOG.get())
			.add(IcariaItems.LAUREL_WOOD.get())
			.add(IcariaItems.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaItems.DEAD_LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get())
			.add(IcariaItems.OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_OLIVE_LOG.get())
			.add(IcariaItems.OLIVE_WOOD.get())
			.add(IcariaItems.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaItems.DEAD_OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get())
			.add(IcariaItems.PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_PLANE_LOG.get())
			.add(IcariaItems.PLANE_WOOD.get())
			.add(IcariaItems.STRIPPED_PLANE_WOOD.get())
			.add(IcariaItems.DEAD_PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_PLANE_LOG.get())
			.add(IcariaItems.POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_POPULUS_LOG.get())
			.add(IcariaItems.POPULUS_WOOD.get())
			.add(IcariaItems.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaItems.DEAD_POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(ItemTags.PLANKS)
			.add(IcariaItems.CYPRESS_PLANKS.get())
			.add(IcariaItems.DROUGHTROOT_PLANKS.get())
			.add(IcariaItems.FIR_PLANKS.get())
			.add(IcariaItems.LAUREL_PLANKS.get())
			.add(IcariaItems.OLIVE_PLANKS.get())
			.add(IcariaItems.PLANE_PLANKS.get())
			.add(IcariaItems.POPULUS_PLANKS.get());

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
	}

	public static TagKey<Item> bind(String pName) {
		return TagKey.create(Registries.ITEM, new ResourceLocation(pName));
	}

	public static TagKey<Item> forgeTag(String pName) {
		return IcariaItemTags.bind("forge:" + pName);
	}

	public static TagKey<Item> icariaTag(String pName) {
		return IcariaItemTags.bind(IcariaInfo.MODID + ":" + pName);
	}
}
