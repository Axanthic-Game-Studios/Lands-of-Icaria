package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaStoneDecoItems;
import com.axanthic.icaria.common.registry.IcariaWoodDecoItems;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

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

import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemTags extends ItemTagsProvider {
	// ITEM TAGS
	public static final TagKey<Item> KETTLE_ITEMS = IcariaItemTags.forgeTag("kettle_items");

	public static final TagKey<Item> GEMS_CHERT = IcariaItemTags.forgeTag("gems/chert");
	public static final TagKey<Item> GEMS_LIGNITE = IcariaItemTags.forgeTag("gems/lignite");
	public static final TagKey<Item> GEMS_DOLOMITE = IcariaItemTags.forgeTag("gems/dolomite");
	public static final TagKey<Item> GEMS_SLIVER = IcariaItemTags.forgeTag("gems/sliver");
	public static final TagKey<Item> GEMS_ANTHRACITE = IcariaItemTags.forgeTag("gems/anthracite");
	public static final TagKey<Item> GEMS_CALCITE_SHARD = IcariaItemTags.forgeTag("gems/calcite_shard");
	public static final TagKey<Item> GEMS_HALITE_SHARD = IcariaItemTags.forgeTag("gems/halite_shard");
	public static final TagKey<Item> GEMS_JASPER_SHARD = IcariaItemTags.forgeTag("gems/jasper_shard");
	public static final TagKey<Item> GEMS_ZIRCON_SHARD = IcariaItemTags.forgeTag("gems/zircon_shard");

	public static final TagKey<Item> CROPS_SPELT = IcariaItemTags.forgeTag("crops/spelt");
	public static final TagKey<Item> CROPS_STRAWBERRIES = IcariaItemTags.forgeTag("crops/strawberry");
	public static final TagKey<Item> CROPS_GARLIC = IcariaItemTags.forgeTag("crops/garlic");
	public static final TagKey<Item> CROPS_ONION = IcariaItemTags.forgeTag("crops/onion");

	public static final TagKey<Item> DUSTS_CALCITE = IcariaItemTags.forgeTag("dusts/calcite");
	public static final TagKey<Item> DUSTS_HALITE = IcariaItemTags.forgeTag("dusts/halite");

	public static final TagKey<Item> RAW_MATERIALS_CHALKOS = IcariaItemTags.forgeTag("raw_materials/chalkos");
	public static final TagKey<Item> RAW_MATERIALS_KASSITEROS = IcariaItemTags.forgeTag("raw_materials/kassiteros");
	public static final TagKey<Item> RAW_MATERIALS_VANADIUM = IcariaItemTags.forgeTag("raw_materials/vanadium");
	public static final TagKey<Item> RAW_MATERIALS_SIDEROS = IcariaItemTags.forgeTag("raw_materials/sideros");
	public static final TagKey<Item> RAW_MATERIALS_MOLYBDENUM = IcariaItemTags.forgeTag("raw_materials/molybdenum");

	public static final TagKey<Item> NUGGETS_CHALKOS = IcariaItemTags.forgeTag("nuggets/chalkos");
	public static final TagKey<Item> NUGGETS_KASSITEROS = IcariaItemTags.forgeTag("nuggets/kassiteros");
	public static final TagKey<Item> NUGGETS_ORICHALCUM = IcariaItemTags.forgeTag("nuggets/orichalcum");
	public static final TagKey<Item> NUGGETS_VANADIUM = IcariaItemTags.forgeTag("nuggets/vanadium");
	public static final TagKey<Item> NUGGETS_VANADIUMSTEEL = IcariaItemTags.forgeTag("nuggets/vanadiumsteel");
	public static final TagKey<Item> NUGGETS_SIDEROS = IcariaItemTags.forgeTag("nuggets/sideros");
	public static final TagKey<Item> NUGGETS_MOLYBDENUM = IcariaItemTags.forgeTag("nuggets/molybdenum");
	public static final TagKey<Item> NUGGETS_MOLYBDENUMSTEEL = IcariaItemTags.forgeTag("nuggets/molybdenumsteel");
	public static final TagKey<Item> NUGGETS_BLURIDIUM = IcariaItemTags.forgeTag("nuggets/bluridium");

	public static final TagKey<Item> INGOTS_LOAM_BRICK = IcariaItemTags.forgeTag("ingots/loam_brick");
	public static final TagKey<Item> INGOTS_CHALKOS = IcariaItemTags.forgeTag("ingots/chalkos");
	public static final TagKey<Item> INGOTS_KASSITEROS = IcariaItemTags.forgeTag("ingots/kassiteros");
	public static final TagKey<Item> INGOTS_ORICHALCUM = IcariaItemTags.forgeTag("ingots/orichalcum");
	public static final TagKey<Item> INGOTS_VANADIUM = IcariaItemTags.forgeTag("ingots/vanadium");
	public static final TagKey<Item> INGOTS_VANADIUMSTEEL = IcariaItemTags.forgeTag("ingots/vanadiumsteel");
	public static final TagKey<Item> INGOTS_SIDEROS = IcariaItemTags.forgeTag("ingots/sideros");
	public static final TagKey<Item> INGOTS_MOLYBDENUM = IcariaItemTags.forgeTag("ingots/molybdenum");
	public static final TagKey<Item> INGOTS_MOLYBDENUMSTEEL = IcariaItemTags.forgeTag("ingots/molybdenumsteel");
	public static final TagKey<Item> INGOTS_BLURIDIUM = IcariaItemTags.forgeTag("ingots/bluridium");

	public static final TagKey<Item> SEEDS_SPELT = IcariaItemTags.forgeTag("seeds/spelt");
	public static final TagKey<Item> SEEDS_STRAWBERRY = IcariaItemTags.forgeTag("seeds/strawberry");
	public static final TagKey<Item> SEEDS_PHYSALIS = IcariaItemTags.forgeTag("seeds/physalis");
	public static final TagKey<Item> SEEDS_ONION = IcariaItemTags.forgeTag("seeds/onion");

	// ITEMBLOCK TAGS
	public static final TagKey<Item> ORES_CHERT = IcariaItemTags.forgeTag("ores/chert");
	public static final TagKey<Item> ORES_LIGNITE = IcariaItemTags.forgeTag("ores/lignite");
	public static final TagKey<Item> ORES_BLURIDIUM = IcariaItemTags.forgeTag("ores/bluridium");

	public static final TagKey<Item> ORES_IN_GROUND_MARL = IcariaItemTags.forgeTag("ores_in_ground/marl");
	public static final TagKey<Item> ORES_IN_GROUND_GRAINEL = IcariaItemTags.forgeTag("ores_in_ground/grainel");
	public static final TagKey<Item> ORES_IN_GROUND_YELLOWSTONE = IcariaItemTags.forgeTag("ores_in_ground/yellowstone");
	public static final TagKey<Item> ORES_IN_GROUND_SILKSTONE = IcariaItemTags.forgeTag("ores_in_ground/silkstone");
	public static final TagKey<Item> ORES_IN_GROUND_SUNSTONE = IcariaItemTags.forgeTag("ores_in_ground/sunstone");
	public static final TagKey<Item> ORES_IN_GROUND_VOIDSHALE = IcariaItemTags.forgeTag("ores_in_ground/voidshale");
	public static final TagKey<Item> ORES_IN_GROUND_BAETYL = IcariaItemTags.forgeTag("ores_in_ground/baetyl");
	public static final TagKey<Item> ORES_IN_GROUND_PLATOSHALE = IcariaItemTags.forgeTag("ores_in_ground/platoshale");

	public static final TagKey<Item> ORE_BEARING_GROUND_MARL = IcariaItemTags.forgeTag("ore_bearing_ground/marl");
	public static final TagKey<Item> ORE_BEARING_GROUND_GRAINEL = IcariaItemTags.forgeTag("ore_bearing_ground/grainel");
	public static final TagKey<Item> ORE_BEARING_GROUND_YELLOWSTONE = IcariaItemTags.forgeTag("ore_bearing_ground/yellowstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SILKSTONE = IcariaItemTags.forgeTag("ore_bearing_ground/silkstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SUNSTONE = IcariaItemTags.forgeTag("ore_bearing_ground/sunstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_VOIDSHALE = IcariaItemTags.forgeTag("ore_bearing_ground/voidshale");
	public static final TagKey<Item> ORE_BEARING_GROUND_BAETYL = IcariaItemTags.forgeTag("ore_bearing_ground/baetyl");
	public static final TagKey<Item> ORE_BEARING_GROUND_PLATOSHALE = IcariaItemTags.forgeTag("ore_bearing_ground/platoshale");
	public static final TagKey<Item> ORE_BEARING_GROUND_PLATOSHALE_BRICKS = IcariaItemTags.forgeTag("ore_bearing_ground/platoshale_bricks");

	public static final TagKey<Item> STORAGE_BLOCKS_PACKED_ARISTONE = IcariaItemTags.forgeTag("storage_blocks/packed_aristone");
	public static final TagKey<Item> STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY = IcariaItemTags.forgeTag("storage_blocks/ender_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY = IcariaItemTags.forgeTag("storage_blocks/fire_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY = IcariaItemTags.forgeTag("storage_blocks/nature_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_VOID_JELLYFISH_JELLY = IcariaItemTags.forgeTag("storage_blocks/void_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_WATER_JELLYFISH_JELLY = IcariaItemTags.forgeTag("storage_blocks/water_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_ARACHNE_STRING = IcariaItemTags.forgeTag("storage_blocks/arachne_string");
	public static final TagKey<Item> STORAGE_BLOCKS_SPELT = IcariaItemTags.forgeTag("storage_blocks/spelt");
	public static final TagKey<Item> STORAGE_BLOCKS_VINE_REED = IcariaItemTags.forgeTag("storage_blocks/vine_reed");
	public static final TagKey<Item> STORAGE_BLOCKS_ROTTEN_BONES = IcariaItemTags.forgeTag("storage_blocks/rotten_bones");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_CHALKOS = IcariaItemTags.forgeTag("storage_blocks/raw_chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_KASSITEROS = IcariaItemTags.forgeTag("storage_blocks/raw_kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_VANADIUM = IcariaItemTags.forgeTag("storage_blocks/raw_vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_SIDEROS = IcariaItemTags.forgeTag("storage_blocks/raw_sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_MOLYBDENUM = IcariaItemTags.forgeTag("storage_blocks/raw_molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_CALCITE = IcariaItemTags.forgeTag("storage_blocks/calcite");
	public static final TagKey<Item> STORAGE_BLOCKS_HALITE = IcariaItemTags.forgeTag("storage_blocks/halite");
	public static final TagKey<Item> STORAGE_BLOCKS_JASPER = IcariaItemTags.forgeTag("storage_blocks/jasper");
	public static final TagKey<Item> STORAGE_BLOCKS_ZIRCON = IcariaItemTags.forgeTag("storage_blocks/zircon");
	public static final TagKey<Item> STORAGE_BLOCKS_CHERT = IcariaItemTags.forgeTag("storage_blocks/chert");
	public static final TagKey<Item> STORAGE_BLOCKS_LIGNITE = IcariaItemTags.forgeTag("storage_blocks/lignite");
	public static final TagKey<Item> STORAGE_BLOCKS_CHALKOS = IcariaItemTags.forgeTag("storage_blocks/chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_KASSITEROS = IcariaItemTags.forgeTag("storage_blocks/kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_ORICHALCUM = IcariaItemTags.forgeTag("storage_blocks/orichalcum");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUM = IcariaItemTags.forgeTag("storage_blocks/vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUMSTEEL = IcariaItemTags.forgeTag("storage_blocks/vanadiumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_SLIVER = IcariaItemTags.forgeTag("storage_blocks/sliver");
	public static final TagKey<Item> STORAGE_BLOCKS_SIDEROS = IcariaItemTags.forgeTag("storage_blocks/sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_ANTHRACITE = IcariaItemTags.forgeTag("storage_blocks/anthracite");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUM = IcariaItemTags.forgeTag("storage_blocks/molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUMSTEEL = IcariaItemTags.forgeTag("storage_blocks/molybdenumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_BLURIDIUM = IcariaItemTags.forgeTag("storage_blocks/bluridium");

	public static final TagKey<Item> LOGS_CYPRESS = IcariaItemTags.forgeTag("logs/cypress");
	public static final TagKey<Item> LOGS_DROUGHTROOT = IcariaItemTags.forgeTag("logs/droughtroot");
	public static final TagKey<Item> LOGS_FIR = IcariaItemTags.forgeTag("logs/fir");
	public static final TagKey<Item> LOGS_LAUREL = IcariaItemTags.forgeTag("logs/laurel");
	public static final TagKey<Item> LOGS_OLIVE = IcariaItemTags.forgeTag("logs/olive");
	public static final TagKey<Item> LOGS_PLANE = IcariaItemTags.forgeTag("logs/plane");
	public static final TagKey<Item> LOGS_POPULUS = IcariaItemTags.forgeTag("logs/populus");

	public IcariaItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, CompletableFuture<TagLookup<Block>> pTags, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pTags, pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		// ITEM TAGS
		this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(ItemTags.STONE_TOOL_MATERIALS)
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
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
			.add(IcariaItems.LAUREL_FOREST_HAG_SKULL.get())
			.add(IcariaItems.OLIVE_FOREST_HAG_SKULL.get())
			.add(IcariaItems.PLANE_FOREST_HAG_SKULL.get())
			.add(IcariaItems.POPULUS_FOREST_HAG_SKULL.get())
			.add(IcariaItems.REVENANT_SKULL.get())
			.add(IcariaItems.SOW_SKULL.get());

		this.tag(ItemTags.SIGNS)
			.add(IcariaItems.CYPRESS_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_SIGN.get())
			.add(IcariaItems.FIR_SIGN.get())
			.add(IcariaItems.LAUREL_SIGN.get())
			.add(IcariaItems.OLIVE_SIGN.get())
			.add(IcariaItems.PLANE_SIGN.get())
			.add(IcariaItems.POPULUS_SIGN.get());

		this.tag(ItemTags.HANGING_SIGNS)
			.add(IcariaItems.CYPRESS_HANGING_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_HANGING_SIGN.get())
			.add(IcariaItems.FIR_HANGING_SIGN.get())
			.add(IcariaItems.LAUREL_HANGING_SIGN.get())
			.add(IcariaItems.OLIVE_HANGING_SIGN.get())
			.add(IcariaItems.PLANE_HANGING_SIGN.get())
			.add(IcariaItems.POPULUS_HANGING_SIGN.get());

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
		this.tag(IcariaItemTags.GEMS_CALCITE_SHARD).add(IcariaItems.CALCITE_SHARD.get());
		this.tag(IcariaItemTags.GEMS_HALITE_SHARD).add(IcariaItems.HALITE_SHARD.get());
		this.tag(IcariaItemTags.GEMS_JASPER_SHARD).add(IcariaItems.JASPER_SHARD.get());
		this.tag(IcariaItemTags.GEMS_ZIRCON_SHARD).add(IcariaItems.ZIRCON_SHARD.get());

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

		this.tag(Tags.Items.GUNPOWDER)
			.add(IcariaItems.GREENPOWDER.get());

		this.tag(IcariaItemTags.DUSTS_CALCITE).add(IcariaItems.CALCITE_DUST.get());
		this.tag(IcariaItemTags.DUSTS_HALITE).add(IcariaItems.HALITE_DUST.get());

		this.tag(Tags.Items.DUSTS)
			.add(IcariaItems.CALCITE_DUST.get())
			.add(IcariaItems.HALITE_DUST.get());

		this.tag(ItemTags.COALS)
			.add(IcariaItems.LIGNITE.get())
			.add(IcariaItems.ANTHRACITE.get());

		this.tag(IcariaItemTags.RAW_MATERIALS_CHALKOS).add(IcariaItems.RAW_CHALKOS.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_KASSITEROS).add(IcariaItems.RAW_KASSITEROS.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_VANADIUM).add(IcariaItems.RAW_VANADIUM.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_SIDEROS).add(IcariaItems.RAW_SIDEROS.get());
		this.tag(IcariaItemTags.RAW_MATERIALS_MOLYBDENUM).add(IcariaItems.RAW_MOLYBDENUM.get());

		this.tag(Tags.Items.RAW_MATERIALS)
			.add(IcariaItems.RAW_CHALKOS.get())
			.add(IcariaItems.RAW_KASSITEROS.get())
			.add(IcariaItems.RAW_VANADIUM.get())
			.add(IcariaItems.RAW_SIDEROS.get())
			.add(IcariaItems.RAW_MOLYBDENUM.get());

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

		this.tag(ItemTags.HOES)
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
		for (var items : IcariaStoneDecoItems.STONE_DECO_ITEMS) {
			this.tag(ItemTags.STAIRS).add(items.stairs.get());
			this.tag(ItemTags.SLABS).add(items.slab.get());
			this.tag(ItemTags.WALLS).add(items.wall.get());
		}

		for (var items : IcariaWoodDecoItems.WOOD_DECO_ITEMS) {
			this.tag(ItemTags.WOODEN_STAIRS).add(items.stairs.get());
			this.tag(ItemTags.WOODEN_SLABS).add(items.slab.get());
			this.tag(ItemTags.WOODEN_FENCES).add(items.fence.get());
			this.tag(Tags.Items.FENCE_GATES_WOODEN).add(items.gate.get());
		}

		this.tag(ItemTags.DIRT)
			.add(IcariaItems.GRASSY_MARL.get())
			.add(IcariaItems.MARL.get())
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.COARSE_MARL.get())
			.add(IcariaItems.DRY_LAKE_BED.get())
			.add(IcariaItems.LOAM.get());

		this.tag(IcariaItemTags.ORES_CHERT)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.GRAINEL_CHERT.get());

		this.tag(IcariaItemTags.ORES_LIGNITE)
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.LIGNITE_ORE.get());

		this.tag(IcariaItemTags.ORES_BLURIDIUM)
			.add(IcariaItems.BLURRED_PLATOSHALE.get())
			.add(IcariaItems.BLURRED_PLATOSHALE_BRICKS.get());

		this.tag(Tags.Items.ORES)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.GRAINEL_CHERT.get())
			.add(IcariaItems.BLURRED_PLATOSHALE.get())
			.add(IcariaItems.BLURRED_PLATOSHALE_BRICKS.get())
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
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.GRAINEL_CHERT.get())
			.add(IcariaItems.BLURRED_PLATOSHALE.get())
			.add(IcariaItems.BLURRED_PLATOSHALE_BRICKS.get())
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
			.add(IcariaItems.BLURRED_PLATOSHALE.get())
			.add(IcariaItems.BLURRED_PLATOSHALE_BRICKS.get());

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
			.add(IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get())
			.add(IcariaItems.SILKGLASS_PANE.get())
			.add(IcariaItems.HORIZONTAL_SILKGLASS_PANE.get());

		this.tag(Tags.Items.COBBLESTONE_NORMAL)
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(Tags.Items.STONE)
			.add(IcariaItems.YELLOWSTONE.get())
			.add(IcariaItems.SILKSTONE.get())
			.add(IcariaItems.SUNSTONE.get())
			.add(IcariaItems.VOIDSHALE.get())
			.add(IcariaItems.BAETYL.get())
			.add(IcariaItems.SMOOTH_RELICSTONE.get());

		this.tag(ItemTags.STONE_BRICKS)
			.add(IcariaItems.YELLOWSTONE_BRICKS.get())
			.add(IcariaItems.SILKSTONE_BRICKS.get())
			.add(IcariaItems.SUNSTONE_BRICKS.get())
			.add(IcariaItems.VOIDSHALE_BRICKS.get())
			.add(IcariaItems.BAETYL_BRICKS.get())
			.add(IcariaItems.RELICSTONE_BRICKS.get())
			.add(IcariaItems.PLATOSHALE_BRICKS.get());

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
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SLIVER).add(IcariaItems.SLIVER_BLOCK.get());
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
		this.tag(IcariaItemTags.STORAGE_BLOCKS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_SIDEROS).add(IcariaItems.SIDEROS_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_ANTHRACITE).add(IcariaItems.ANTHRACITE_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());
		this.tag(IcariaItemTags.STORAGE_BLOCKS_BLURIDIUM).add(IcariaItems.BLURIDIUM_BLOCK.get());

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
			.add(IcariaItems.SLIVER_BLOCK.get())
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
			.add(IcariaItems.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaItems.SIDEROS_BLOCK.get())
			.add(IcariaItems.ANTHRACITE_BLOCK.get())
			.add(IcariaItems.MOLYBDENUM_BLOCK.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get())
			.add(IcariaItems.BLURIDIUM_BLOCK.get());

		this.tag(ItemTags.DAMPENS_VIBRATIONS)
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get());

		this.tag(Tags.Items.CHESTS_WOODEN)
			.add(IcariaItems.CHEST.get())
			.add(IcariaItems.TRAPPED_CHEST.get());

		this.tag(Tags.Items.CHESTS_TRAPPED)
			.add(IcariaItems.TRAPPED_CHEST.get());

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
		return IcariaItemTags.bind(IcariaInfo.FORGE + ":" + pName);
	}

	public static TagKey<Item> icariaTag(String pName) {
		return IcariaItemTags.bind(IcariaInfo.ID + ":" + pName);
	}
}
