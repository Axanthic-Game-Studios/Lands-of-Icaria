package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemTagsProvider extends ItemTagsProvider {

	// ITEMS

	public static final TagKey<Item> ARACHNE_STRING_BLOCKS = IcariaItemTagsProvider.cKey("arachne_string_blocks");
	public static final TagKey<Item> ARACHNE_STRING_CARPETS = IcariaItemTagsProvider.cKey("arachne_string_carpets");

	public static final TagKey<Item> CROPS_SPELT = IcariaItemTagsProvider.cKey("crops/spelt");
	public static final TagKey<Item> CROPS_STRAWBERRIES = IcariaItemTagsProvider.cKey("crops/strawberries");
	public static final TagKey<Item> CROPS_PHYSALIS = IcariaItemTagsProvider.cKey("crops/physalis");
	public static final TagKey<Item> CROPS_ONION = IcariaItemTagsProvider.cKey("crops/onion");

	public static final TagKey<Item> DUSTS_CALCITE = IcariaItemTagsProvider.cKey("dusts/calcite");
	public static final TagKey<Item> DUSTS_HALITE = IcariaItemTagsProvider.cKey("dusts/halite");

	public static final TagKey<Item> GEMS_CHERT = IcariaItemTagsProvider.cKey("gems/chert");
	public static final TagKey<Item> GEMS_CALCITE = IcariaItemTagsProvider.cKey("gems/calcite");
	public static final TagKey<Item> GEMS_HALITE = IcariaItemTagsProvider.cKey("gems/halite");
	public static final TagKey<Item> GEMS_JASPER = IcariaItemTagsProvider.cKey("gems/jasper");
	public static final TagKey<Item> GEMS_ZIRCON = IcariaItemTagsProvider.cKey("gems/zircon");
	public static final TagKey<Item> GEMS_LIGNITE = IcariaItemTagsProvider.cKey("gems/lignite");
	public static final TagKey<Item> GEMS_DOLOMITE = IcariaItemTagsProvider.cKey("gems/dolomite");
	public static final TagKey<Item> GEMS_SLIVER = IcariaItemTagsProvider.cKey("gems/sliver");
	public static final TagKey<Item> GEMS_ANTHRACITE = IcariaItemTagsProvider.cKey("gems/anthracite");

	public static final TagKey<Item> INGOTS_CHALKOS = IcariaItemTagsProvider.cKey("ingots/chalkos");
	public static final TagKey<Item> INGOTS_KASSITEROS = IcariaItemTagsProvider.cKey("ingots/kassiteros");
	public static final TagKey<Item> INGOTS_ORICHALCUM = IcariaItemTagsProvider.cKey("ingots/orichalcum");
	public static final TagKey<Item> INGOTS_VANADIUM = IcariaItemTagsProvider.cKey("ingots/vanadium");
	public static final TagKey<Item> INGOTS_VANADIUMSTEEL = IcariaItemTagsProvider.cKey("ingots/vanadiumsteel");
	public static final TagKey<Item> INGOTS_SIDEROS = IcariaItemTagsProvider.cKey("ingots/sideros");
	public static final TagKey<Item> INGOTS_MOLYBDENUM = IcariaItemTagsProvider.cKey("ingots/molybdenum");
	public static final TagKey<Item> INGOTS_MOLYBDENUMSTEEL = IcariaItemTagsProvider.cKey("ingots/molybdenumsteel");
	public static final TagKey<Item> INGOTS_BLURIDIUM = IcariaItemTagsProvider.cKey("ingots/bluridium");

	public static final TagKey<Item> KETTLE_ITEMS = IcariaItemTagsProvider.icariaKey("kettle_items");

	public static final TagKey<Item> NUGGETS_CHALKOS = IcariaItemTagsProvider.cKey("nuggets/chalkos");
	public static final TagKey<Item> NUGGETS_KASSITEROS = IcariaItemTagsProvider.cKey("nuggets/kassiteros");
	public static final TagKey<Item> NUGGETS_ORICHALCUM = IcariaItemTagsProvider.cKey("nuggets/orichalcum");
	public static final TagKey<Item> NUGGETS_VANADIUM = IcariaItemTagsProvider.cKey("nuggets/vanadium");
	public static final TagKey<Item> NUGGETS_VANADIUMSTEEL = IcariaItemTagsProvider.cKey("nuggets/vanadiumsteel");
	public static final TagKey<Item> NUGGETS_SIDEROS = IcariaItemTagsProvider.cKey("nuggets/sideros");
	public static final TagKey<Item> NUGGETS_MOLYBDENUM = IcariaItemTagsProvider.cKey("nuggets/molybdenum");
	public static final TagKey<Item> NUGGETS_MOLYBDENUMSTEEL = IcariaItemTagsProvider.cKey("nuggets/molybdenumsteel");
	public static final TagKey<Item> NUGGETS_BLURIDIUM = IcariaItemTagsProvider.cKey("nuggets/bluridium");

	public static final TagKey<Item> RAW_BLOCKS_CHALKOS = IcariaItemTagsProvider.cKey("raw_blocks/chalkos");
	public static final TagKey<Item> RAW_BLOCKS_KASSITEROS = IcariaItemTagsProvider.cKey("raw_blocks/kassiteros");
	public static final TagKey<Item> RAW_BLOCKS_VANADIUM = IcariaItemTagsProvider.cKey("raw_blocks/vanadium");
	public static final TagKey<Item> RAW_BLOCKS_SIDEROS = IcariaItemTagsProvider.cKey("raw_blocks/sideros");
	public static final TagKey<Item> RAW_BLOCKS_MOLYBDENUM = IcariaItemTagsProvider.cKey("raw_blocks/molybdenum");

	public static final TagKey<Item> RAW_MATERIALS_CHALKOS = IcariaItemTagsProvider.cKey("raw_materials/chalkos");
	public static final TagKey<Item> RAW_MATERIALS_KASSITEROS = IcariaItemTagsProvider.cKey("raw_materials/kassiteros");
	public static final TagKey<Item> RAW_MATERIALS_VANADIUM = IcariaItemTagsProvider.cKey("raw_materials/vanadium");
	public static final TagKey<Item> RAW_MATERIALS_SIDEROS = IcariaItemTagsProvider.cKey("raw_materials/sideros");
	public static final TagKey<Item> RAW_MATERIALS_MOLYBDENUM = IcariaItemTagsProvider.cKey("raw_materials/molybdenum");

	public static final TagKey<Item> REPAIRS_AETERNAE_HIDE_ARMOR = IcariaItemTagsProvider.icariaKey("repairs_aeternae_hide_armor");
	public static final TagKey<Item> REPAIRS_CHALKOS_ARMOR = IcariaItemTagsProvider.icariaKey("repairs_chalkos_armor");
	public static final TagKey<Item> REPAIRS_KASSITEROS_ARMOR = IcariaItemTagsProvider.icariaKey("repairs_kassiteros_armor");
	public static final TagKey<Item> REPAIRS_ORICHALCUM_ARMOR = IcariaItemTagsProvider.icariaKey("repairs_orichalcum_armor");
	public static final TagKey<Item> REPAIRS_VANADIUMSTEEL_ARMOR = IcariaItemTagsProvider.icariaKey("repairs_vanadiumsteel_armor");
	public static final TagKey<Item> REPAIRS_LAUREL_WREATH = IcariaItemTagsProvider.icariaKey("repairs_laurel_wreath");

	public static final TagKey<Item> SEEDS_SPELT = IcariaItemTagsProvider.cKey("seeds/spelt");
	public static final TagKey<Item> SEEDS_STRAWBERRY = IcariaItemTagsProvider.cKey("seeds/strawberry");
	public static final TagKey<Item> SEEDS_PHYSALIS = IcariaItemTagsProvider.cKey("seeds/physalis");
	public static final TagKey<Item> SEEDS_ONION = IcariaItemTagsProvider.cKey("seeds/onion");

	public static final TagKey<Item> STORAGE_VASES = IcariaItemTagsProvider.cKey("storage_vases");

	public static final TagKey<Item> TOOL_MATERIALS_CHERT = IcariaItemTagsProvider.icariaKey("tool_materials/chert");
	public static final TagKey<Item> TOOL_MATERIALS_CHALKOS = IcariaItemTagsProvider.icariaKey("tool_materials/chalkos");
	public static final TagKey<Item> TOOL_MATERIALS_KASSITEROS = IcariaItemTagsProvider.icariaKey("tool_materials/kassiteros");
	public static final TagKey<Item> TOOL_MATERIALS_ORICHALCUM = IcariaItemTagsProvider.icariaKey("tool_materials/orichalcum");
	public static final TagKey<Item> TOOL_MATERIALS_VANADIUMSTEEL = IcariaItemTagsProvider.icariaKey("tool_materials/vanadiumsteel");
	public static final TagKey<Item> TOOL_MATERIALS_SIDEROS = IcariaItemTagsProvider.icariaKey("tool_materials/sideros");
	public static final TagKey<Item> TOOL_MATERIALS_MOLYBDENUMSTEEL = IcariaItemTagsProvider.icariaKey("tool_materials/molybdenumsteel");

	// ITEMBLOCKS

	public static final TagKey<Item> LOGS_CYPRESS = IcariaItemTagsProvider.cKey("logs/cypress");
	public static final TagKey<Item> LOGS_DROUGHTROOT = IcariaItemTagsProvider.cKey("logs/droughtroot");
	public static final TagKey<Item> LOGS_FIR = IcariaItemTagsProvider.cKey("logs/fir");
	public static final TagKey<Item> LOGS_LAUREL = IcariaItemTagsProvider.cKey("logs/laurel");
	public static final TagKey<Item> LOGS_OLIVE = IcariaItemTagsProvider.cKey("logs/olive");
	public static final TagKey<Item> LOGS_PLANE = IcariaItemTagsProvider.cKey("logs/plane");
	public static final TagKey<Item> LOGS_POPULUS = IcariaItemTagsProvider.cKey("logs/populus");

	public static final TagKey<Item> ORE_BEARING_GROUNDS_MARL = IcariaItemTagsProvider.cKey("ore_bearing_grounds/marl");
	public static final TagKey<Item> ORE_BEARING_GROUNDS_GRAINEL = IcariaItemTagsProvider.cKey("ore_bearing_grounds/grainel");
	public static final TagKey<Item> ORE_BEARING_GROUNDS_YELLOWSTONE = IcariaItemTagsProvider.cKey("ore_bearing_grounds/yellowstone");
	public static final TagKey<Item> ORE_BEARING_GROUNDS_SILKSTONE = IcariaItemTagsProvider.cKey("ore_bearing_grounds/silkstone");
	public static final TagKey<Item> ORE_BEARING_GROUNDS_SUNSTONE = IcariaItemTagsProvider.cKey("ore_bearing_grounds/sunstone");
	public static final TagKey<Item> ORE_BEARING_GROUNDS_VOIDSHALE = IcariaItemTagsProvider.cKey("ore_bearing_grounds/voidshale");
	public static final TagKey<Item> ORE_BEARING_GROUNDS_BAETYL = IcariaItemTagsProvider.cKey("ore_bearing_grounds/baetyl");

	public static final TagKey<Item> ORES_CHERT = IcariaItemTagsProvider.cKey("ores/chert");
	public static final TagKey<Item> ORES_BONES = IcariaItemTagsProvider.cKey("ores/bones");
	public static final TagKey<Item> ORES_LIGNITE = IcariaItemTagsProvider.cKey("ores/lignite");
	public static final TagKey<Item> ORES_CHALKOS = IcariaItemTagsProvider.cKey("ores/chalkos");
	public static final TagKey<Item> ORES_KASSITEROS = IcariaItemTagsProvider.cKey("ores/kassiteros");
	public static final TagKey<Item> ORES_DOLOMITE = IcariaItemTagsProvider.cKey("ores/dolomite");
	public static final TagKey<Item> ORES_VANADIUM = IcariaItemTagsProvider.cKey("ores/vanadium");
	public static final TagKey<Item> ORES_SLIVER = IcariaItemTagsProvider.cKey("ores/sliver");
	public static final TagKey<Item> ORES_SIDEROS = IcariaItemTagsProvider.cKey("ores/sideros");
	public static final TagKey<Item> ORES_ANTHRACITE = IcariaItemTagsProvider.cKey("ores/anthracite");
	public static final TagKey<Item> ORES_MOLYBDENUM = IcariaItemTagsProvider.cKey("ores/molybdenum");
	public static final TagKey<Item> ORES_HYLIASTRUM = IcariaItemTagsProvider.cKey("ores/hyliastrum");

	public static final TagKey<Item> ORES_IN_GROUND_MARL = IcariaItemTagsProvider.cKey("ores_in_ground/marl");
	public static final TagKey<Item> ORES_IN_GROUND_GRAINEL = IcariaItemTagsProvider.cKey("ores_in_ground/grainel");
	public static final TagKey<Item> ORES_IN_GROUND_YELLOWSTONE = IcariaItemTagsProvider.cKey("ores_in_ground/yellowstone");
	public static final TagKey<Item> ORES_IN_GROUND_SILKSTONE = IcariaItemTagsProvider.cKey("ores_in_ground/silkstone");
	public static final TagKey<Item> ORES_IN_GROUND_SUNSTONE = IcariaItemTagsProvider.cKey("ores_in_ground/sunstone");
	public static final TagKey<Item> ORES_IN_GROUND_VOIDSHALE = IcariaItemTagsProvider.cKey("ores_in_ground/voidshale");
	public static final TagKey<Item> ORES_IN_GROUND_BAETYL = IcariaItemTagsProvider.cKey("ores_in_ground/baetyl");

	public static final TagKey<Item> STORAGE_BLOCKS_ARISTONE = IcariaItemTagsProvider.cKey("storage_blocks/aristone");
	public static final TagKey<Item> STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY = IcariaItemTagsProvider.cKey("storage_blocks/ender_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY = IcariaItemTagsProvider.cKey("storage_blocks/fire_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY = IcariaItemTagsProvider.cKey("storage_blocks/nature_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_VOID_JELLYFISH_JELLY = IcariaItemTagsProvider.cKey("storage_blocks/void_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_WATER_JELLYFISH_JELLY = IcariaItemTagsProvider.cKey("storage_blocks/water_jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_ARACHNE_STRING = IcariaItemTagsProvider.cKey("storage_blocks/arachne_string");
	public static final TagKey<Item> STORAGE_BLOCKS_SPELT = IcariaItemTagsProvider.cKey("storage_blocks/spelt");
	public static final TagKey<Item> STORAGE_BLOCKS_VINE_REED = IcariaItemTagsProvider.cKey("storage_blocks/vine_reed");
	public static final TagKey<Item> STORAGE_BLOCKS_ROTTEN_BONES = IcariaItemTagsProvider.cKey("storage_blocks/rotten_bones");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_CHALKOS = IcariaItemTagsProvider.cKey("storage_blocks/raw_chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_KASSITEROS = IcariaItemTagsProvider.cKey("storage_blocks/raw_kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_VANADIUM = IcariaItemTagsProvider.cKey("storage_blocks/raw_vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_SIDEROS = IcariaItemTagsProvider.cKey("storage_blocks/raw_sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_MOLYBDENUM = IcariaItemTagsProvider.cKey("storage_blocks/raw_molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_CALCITE = IcariaItemTagsProvider.cKey("storage_blocks/calcite");
	public static final TagKey<Item> STORAGE_BLOCKS_HALITE = IcariaItemTagsProvider.cKey("storage_blocks/halite");
	public static final TagKey<Item> STORAGE_BLOCKS_JASPER = IcariaItemTagsProvider.cKey("storage_blocks/jasper");
	public static final TagKey<Item> STORAGE_BLOCKS_ZIRCON = IcariaItemTagsProvider.cKey("storage_blocks/zircon");
	public static final TagKey<Item> STORAGE_BLOCKS_CHERT = IcariaItemTagsProvider.cKey("storage_blocks/chert");
	public static final TagKey<Item> STORAGE_BLOCKS_LIGNITE = IcariaItemTagsProvider.cKey("storage_blocks/lignite");
	public static final TagKey<Item> STORAGE_BLOCKS_CHALKOS = IcariaItemTagsProvider.cKey("storage_blocks/chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_KASSITEROS = IcariaItemTagsProvider.cKey("storage_blocks/kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_ORICHALCUM = IcariaItemTagsProvider.cKey("storage_blocks/orichalcum");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUM = IcariaItemTagsProvider.cKey("storage_blocks/vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_SLIVER = IcariaItemTagsProvider.cKey("storage_blocks/sliver");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUMSTEEL = IcariaItemTagsProvider.cKey("storage_blocks/vanadiumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_SIDEROS = IcariaItemTagsProvider.cKey("storage_blocks/sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_ANTHRACITE = IcariaItemTagsProvider.cKey("storage_blocks/anthracite");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUM = IcariaItemTagsProvider.cKey("storage_blocks/molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUMSTEEL = IcariaItemTagsProvider.cKey("storage_blocks/molybdenumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_BLURIDIUM = IcariaItemTagsProvider.cKey("storage_blocks/bluridium");

	public IcariaItemTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {

		// ITEMS

		this.tag(ItemTags.AXES)
			.add(IcariaItems.CHERT_AXE.get())
			.add(IcariaItems.CHALKOS_AXE.get())
			.add(IcariaItems.KASSITEROS_AXE.get())
			.add(IcariaItems.ORICHALCUM_AXE.get())
			.add(IcariaItems.VANADIUMSTEEL_AXE.get())
			.add(IcariaItems.SIDEROS_AXE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_AXE.get());

		this.tag(ItemTags.BEE_FOOD)
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
			.add(IcariaItems.BLUE_GROUND_FLOWERS.get())
			.add(IcariaItems.CYAN_GROUND_FLOWERS.get())
			.add(IcariaItems.PINK_GROUND_FLOWERS.get())
			.add(IcariaItems.PURPLE_GROUND_FLOWERS.get())
			.add(IcariaItems.RED_GROUND_FLOWERS.get())
			.add(IcariaItems.WHITE_GROUND_FLOWERS.get())
			.add(IcariaItems.WHITE_BROMELIA.get())
			.add(IcariaItems.ORANGE_BROMELIA.get())
			.add(IcariaItems.PINK_BROMELIA.get())
			.add(IcariaItems.PURPLE_BROMELIA.get());

		this.tag(ItemTags.BREAKS_DECORATED_POTS)
			.add(IcariaItems.CHERT_DAGGER.get())
			.add(IcariaItems.CHERT_BIDENT.get())
			.add(IcariaItems.CHALKOS_DAGGER.get())
			.add(IcariaItems.CHALKOS_BIDENT.get())
			.add(IcariaItems.KASSITEROS_DAGGER.get())
			.add(IcariaItems.KASSITEROS_BIDENT.get())
			.add(IcariaItems.ORICHALCUM_DAGGER.get())
			.add(IcariaItems.ORICHALCUM_BIDENT.get())
			.add(IcariaItems.VANADIUMSTEEL_DAGGER.get())
			.add(IcariaItems.VANADIUMSTEEL_BIDENT.get())
			.add(IcariaItems.SIDEROS_DAGGER.get())
			.add(IcariaItems.SIDEROS_BIDENT.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_DAGGER.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());

		this.tag(ItemTags.CAMEL_FOOD)
			.add(IcariaItems.CARDON_CACTUS.get());

		this.tag(ItemTags.CAT_FOOD)
			.add(IcariaItems.RAW_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.RAW_BROWN_FEESH.get())
			.add(IcariaItems.RAW_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.RAW_PINK_RED_FEESH.get())
			.add(IcariaItems.RAW_PURPLE_FEESH.get())
			.add(IcariaItems.RAW_RED_FEESH.get())
			.add(IcariaItems.RAW_BLUE_RED_FICHE.get())
			.add(IcariaItems.RAW_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.RAW_GRAY_FICHE.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.RAW_RED_FICHE.get())
			.add(IcariaItems.RAW_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.RAW_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_RED_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.RAW_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_FYSH.get())
			.add(IcariaItems.RAW_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.RAW_GRAY_FYSH.get())
			.add(IcariaItems.RAW_RAINBOW_FYSH.get())
			.add(IcariaItems.RAW_RED_FYSH.get())
			.add(IcariaItems.RAW_RED_YELLOW_FYSH.get());

		this.tag(ItemTags.CHEST_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_CHESTPLATE.get())
			.add(IcariaItems.CHALKOS_CHESTPLATE.get())
			.add(IcariaItems.KASSITEROS_CHESTPLATE.get())
			.add(IcariaItems.ORICHALCUM_CHESTPLATE.get())
			.add(IcariaItems.VANADIUMSTEEL_CHESTPLATE.get());

		this.tag(ItemTags.CHICKEN_FOOD)
			.add(IcariaItems.SPELT_SEEDS.get())
			.add(IcariaItems.STRAWBERRY_SEEDS.get())
			.add(IcariaItems.PHYSALIS_SEEDS.get());

		this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
			.add(IcariaItems.CHERT_PICKAXE.get())
			.add(IcariaItems.CHALKOS_PICKAXE.get())
			.add(IcariaItems.KASSITEROS_PICKAXE.get())
			.add(IcariaItems.ORICHALCUM_PICKAXE.get())
			.add(IcariaItems.VANADIUMSTEEL_PICKAXE.get())
			.add(IcariaItems.SIDEROS_PICKAXE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());

		this.tag(ItemTags.COALS)
			.add(IcariaItems.LIGNITE.get())
			.add(IcariaItems.ANTHRACITE.get());

		this.tag(ItemTags.COW_FOOD)
			.add(IcariaItems.SPELT.get());

		this.tag(ItemTags.DURABILITY_ENCHANTABLE)
			.add(IcariaItems.CHERT_DAGGER.get())
			.add(IcariaItems.CHERT_BIDENT.get())
			.add(IcariaItems.CHALKOS_DAGGER.get())
			.add(IcariaItems.CHALKOS_BIDENT.get())
			.add(IcariaItems.KASSITEROS_DAGGER.get())
			.add(IcariaItems.KASSITEROS_BIDENT.get())
			.add(IcariaItems.ORICHALCUM_DAGGER.get())
			.add(IcariaItems.ORICHALCUM_BIDENT.get())
			.add(IcariaItems.VANADIUMSTEEL_DAGGER.get())
			.add(IcariaItems.VANADIUMSTEEL_BIDENT.get())
			.add(IcariaItems.SIDEROS_DAGGER.get())
			.add(IcariaItems.SIDEROS_BIDENT.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_DAGGER.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());

		this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
			.add(IcariaItems.LAUREL_WREATH.get());

		this.tag(ItemTags.FISHES)
			.add(IcariaItems.COOKED_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.RAW_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.COOKED_BROWN_FEESH.get())
			.add(IcariaItems.RAW_BROWN_FEESH.get())
			.add(IcariaItems.COOKED_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.RAW_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.COOKED_PINK_RED_FEESH.get())
			.add(IcariaItems.RAW_PINK_RED_FEESH.get())
			.add(IcariaItems.COOKED_PURPLE_FEESH.get())
			.add(IcariaItems.RAW_PURPLE_FEESH.get())
			.add(IcariaItems.COOKED_RED_FEESH.get())
			.add(IcariaItems.RAW_RED_FEESH.get())
			.add(IcariaItems.COOKED_BLUE_RED_FICHE.get())
			.add(IcariaItems.RAW_BLUE_RED_FICHE.get())
			.add(IcariaItems.COOKED_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.RAW_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.COOKED_GRAY_FICHE.get())
			.add(IcariaItems.RAW_GRAY_FICHE.get())
			.add(IcariaItems.COOKED_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.COOKED_RED_FICHE.get())
			.add(IcariaItems.RAW_RED_FICHE.get())
			.add(IcariaItems.COOKED_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.RAW_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.COOKED_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_RED_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_RED_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.COOKED_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_BROWN_FISSHH.get())
			.add(IcariaItems.COOKED_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.COOKED_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_FYSH.get())
			.add(IcariaItems.RAW_BLUE_FYSH.get())
			.add(IcariaItems.COOKED_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.RAW_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.COOKED_GRAY_FYSH.get())
			.add(IcariaItems.RAW_GRAY_FYSH.get())
			.add(IcariaItems.COOKED_RAINBOW_FYSH.get())
			.add(IcariaItems.RAW_RAINBOW_FYSH.get())
			.add(IcariaItems.COOKED_RED_FYSH.get())
			.add(IcariaItems.RAW_RED_FYSH.get())
			.add(IcariaItems.COOKED_RED_YELLOW_FYSH.get())
			.add(IcariaItems.RAW_RED_YELLOW_FYSH.get());

		this.tag(ItemTags.FOOT_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_BOOTS.get())
			.add(IcariaItems.CHALKOS_BOOTS.get())
			.add(IcariaItems.KASSITEROS_BOOTS.get())
			.add(IcariaItems.ORICHALCUM_BOOTS.get())
			.add(IcariaItems.VANADIUMSTEEL_BOOTS.get());

		this.tag(ItemTags.FOX_FOOD)
			.add(IcariaItems.VINEBERRIES.get())
			.add(IcariaItems.STRAWBERRIES.get());

		this.tag(ItemTags.FREEZE_IMMUNE_WEARABLES)
			.add(IcariaItems.AETERNAE_HIDE_HELMET.get())
			.add(IcariaItems.AETERNAE_HIDE_CHESTPLATE.get())
			.add(IcariaItems.AETERNAE_HIDE_LEGGINGS.get())
			.add(IcariaItems.AETERNAE_HIDE_BOOTS.get());

		this.tag(ItemTags.GOAT_FOOD)
			.add(IcariaItems.SPELT.get());

		this.tag(ItemTags.HANGING_SIGNS)
			.add(IcariaItems.CYPRESS_HANGING_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_HANGING_SIGN.get())
			.add(IcariaItems.FIR_HANGING_SIGN.get())
			.add(IcariaItems.LAUREL_HANGING_SIGN.get())
			.add(IcariaItems.OLIVE_HANGING_SIGN.get())
			.add(IcariaItems.PLANE_HANGING_SIGN.get())
			.add(IcariaItems.POPULUS_HANGING_SIGN.get());

		this.tag(ItemTags.HEAD_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_HELMET.get())
			.add(IcariaItems.CHALKOS_HELMET.get())
			.add(IcariaItems.KASSITEROS_HELMET.get())
			.add(IcariaItems.ORICHALCUM_HELMET.get())
			.add(IcariaItems.VANADIUMSTEEL_HELMET.get());

		this.tag(ItemTags.HOES)
			.add(IcariaItems.CHERT_SCYTHE.get())
			.add(IcariaItems.CHALKOS_SCYTHE.get())
			.add(IcariaItems.KASSITEROS_SCYTHE.get())
			.add(IcariaItems.ORICHALCUM_SCYTHE.get())
			.add(IcariaItems.VANADIUMSTEEL_SCYTHE.get())
			.add(IcariaItems.SIDEROS_SCYTHE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get());

		this.tag(ItemTags.HORSE_FOOD)
			.add(IcariaItems.SPELT_BALE_BLOCK.get())
			.add(IcariaItems.SPELT.get());

		this.tag(ItemTags.LLAMA_FOOD)
			.add(IcariaItems.SPELT_BALE_BLOCK.get())
			.add(IcariaItems.SPELT.get());

		this.tag(ItemTags.LLAMA_TEMPT_ITEMS)
			.add(IcariaItems.SPELT_BALE_BLOCK.get());

		this.tag(ItemTags.LEG_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE_LEGGINGS.get())
			.add(IcariaItems.CHALKOS_LEGGINGS.get())
			.add(IcariaItems.KASSITEROS_LEGGINGS.get())
			.add(IcariaItems.ORICHALCUM_LEGGINGS.get())
			.add(IcariaItems.VANADIUMSTEEL_LEGGINGS.get());

		this.tag(ItemTags.MEAT)
			.add(IcariaItems.RAW_AETERNAE_MEAT.get())
			.add(IcariaItems.COOKED_AETERNAE_MEAT.get())
			.add(IcariaItems.RAW_CAPELLA_MEAT.get())
			.add(IcariaItems.COOKED_CAPELLA_MEAT.get())
			.add(IcariaItems.RAW_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.COOKED_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.RAW_CERVER_MEAT.get())
			.add(IcariaItems.COOKED_CERVER_MEAT.get())
			.add(IcariaItems.RAW_CROCOTTA_MEAT.get())
			.add(IcariaItems.COOKED_CROCOTTA_MEAT.get())
			.add(IcariaItems.RAW_THOG_MEAT.get())
			.add(IcariaItems.COOKED_THOG_MEAT.get());

		this.tag(ItemTags.OCELOT_FOOD)
			.add(IcariaItems.RAW_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.RAW_BROWN_FEESH.get())
			.add(IcariaItems.RAW_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.RAW_PINK_RED_FEESH.get())
			.add(IcariaItems.RAW_PURPLE_FEESH.get())
			.add(IcariaItems.RAW_RED_FEESH.get())
			.add(IcariaItems.RAW_BLUE_RED_FICHE.get())
			.add(IcariaItems.RAW_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.RAW_GRAY_FICHE.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.RAW_RED_FICHE.get())
			.add(IcariaItems.RAW_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.RAW_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_RED_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.RAW_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_FYSH.get())
			.add(IcariaItems.RAW_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.RAW_GRAY_FYSH.get())
			.add(IcariaItems.RAW_RAINBOW_FYSH.get())
			.add(IcariaItems.RAW_RED_FYSH.get())
			.add(IcariaItems.RAW_RED_YELLOW_FYSH.get());

		this.tag(ItemTags.PANDA_EATS_FROM_GROUND)
			.add(IcariaItems.LAUREL_CHERRY_CAKE.get())
			.add(IcariaItems.STRAWBERRY_CAKE.get())
			.add(IcariaItems.PHYSALIS_CAKE.get())
			.add(IcariaItems.VINE_BERRY_CAKE.get())
			.add(IcariaItems.VINE_SPROUT_CAKE.get());

		this.tag(ItemTags.PARROT_FOOD)
			.add(IcariaItems.SPELT_SEEDS.get())
			.add(IcariaItems.STRAWBERRY_SEEDS.get())
			.add(IcariaItems.PHYSALIS_SEEDS.get());

		this.tag(ItemTags.PICKAXES)
			.add(IcariaItems.CHERT_PICKAXE.get())
			.add(IcariaItems.CHALKOS_PICKAXE.get())
			.add(IcariaItems.KASSITEROS_PICKAXE.get())
			.add(IcariaItems.ORICHALCUM_PICKAXE.get())
			.add(IcariaItems.VANADIUMSTEEL_PICKAXE.get())
			.add(IcariaItems.SIDEROS_PICKAXE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());

		this.tag(ItemTags.PIG_FOOD)
			.add(IcariaItems.GARLIC.get())
			.add(IcariaItems.ONION.get());

		this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
			.add(IcariaItems.CHERT_DAGGER.get())
			.add(IcariaItems.CHERT_SCYTHE.get())
			.add(IcariaItems.CHALKOS_DAGGER.get())
			.add(IcariaItems.CHALKOS_SCYTHE.get())
			.add(IcariaItems.KASSITEROS_DAGGER.get())
			.add(IcariaItems.KASSITEROS_SCYTHE.get())
			.add(IcariaItems.ORICHALCUM_DAGGER.get())
			.add(IcariaItems.ORICHALCUM_SCYTHE.get())
			.add(IcariaItems.VANADIUMSTEEL_DAGGER.get())
			.add(IcariaItems.VANADIUMSTEEL_SCYTHE.get())
			.add(IcariaItems.SIDEROS_DAGGER.get())
			.add(IcariaItems.SIDEROS_SCYTHE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_DAGGER.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get());

		this.tag(ItemTags.SHEEP_FOOD)
			.add(IcariaItems.SPELT.get());

		this.tag(ItemTags.SHOVELS)
			.add(IcariaItems.CHERT_SHOVEL.get())
			.add(IcariaItems.CHALKOS_SHOVEL.get())
			.add(IcariaItems.KASSITEROS_SHOVEL.get())
			.add(IcariaItems.ORICHALCUM_SHOVEL.get())
			.add(IcariaItems.VANADIUMSTEEL_SHOVEL.get())
			.add(IcariaItems.SIDEROS_SHOVEL.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_SHOVEL.get());

		this.tag(ItemTags.SIGNS)
			.add(IcariaItems.CYPRESS_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_SIGN.get())
			.add(IcariaItems.FIR_SIGN.get())
			.add(IcariaItems.LAUREL_SIGN.get())
			.add(IcariaItems.OLIVE_SIGN.get())
			.add(IcariaItems.PLANE_SIGN.get())
			.add(IcariaItems.POPULUS_SIGN.get());

		this.tag(ItemTags.SKULLS)
			.add(IcariaItems.AETERNAE_SKULL.get())
			.add(IcariaItems.ARGAN_HOUND_SKULL.get())
			.add(IcariaItems.CAPELLA_SKULL.get())
			.add(IcariaItems.CATOBLEPAS_SKULL.get())
			.add(IcariaItems.CERVER_SKULL.get())
			.add(IcariaItems.CROCOTTA_SKULL.get())
			.add(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get())
			.add(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get())
			.add(IcariaItems.FIR_FOREST_HAG_SKULL.get())
			.add(IcariaItems.LAUREL_FOREST_HAG_SKULL.get())
			.add(IcariaItems.OLIVE_FOREST_HAG_SKULL.get())
			.add(IcariaItems.PLANE_FOREST_HAG_SKULL.get())
			.add(IcariaItems.POPULUS_FOREST_HAG_SKULL.get())
			.add(IcariaItems.REVENANT_SKULL.get())
			.add(IcariaItems.THOG_SKULL.get());

		this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
			.add(IcariaItems.GRAINITE.get())
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(ItemTags.STONE_TOOL_MATERIALS)
			.add(IcariaItems.GRAINITE.get())
			.add(IcariaItems.COBBLED_YELLOWSTONE.get())
			.add(IcariaItems.COBBLED_SILKSTONE.get())
			.add(IcariaItems.COBBLED_SUNSTONE.get())
			.add(IcariaItems.COBBLED_VOIDSHALE.get())
			.add(IcariaItems.COBBLED_BAETYL.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		this.tag(ItemTags.SWORD_ENCHANTABLE)
			.add(IcariaItems.CHERT_DAGGER.get())
			.add(IcariaItems.CHERT_SCYTHE.get())
			.add(IcariaItems.CHALKOS_DAGGER.get())
			.add(IcariaItems.CHALKOS_SCYTHE.get())
			.add(IcariaItems.KASSITEROS_DAGGER.get())
			.add(IcariaItems.KASSITEROS_SCYTHE.get())
			.add(IcariaItems.ORICHALCUM_DAGGER.get())
			.add(IcariaItems.ORICHALCUM_SCYTHE.get())
			.add(IcariaItems.VANADIUMSTEEL_DAGGER.get())
			.add(IcariaItems.VANADIUMSTEEL_SCYTHE.get())
			.add(IcariaItems.SIDEROS_DAGGER.get())
			.add(IcariaItems.SIDEROS_SCYTHE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_DAGGER.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get());

		this.tag(ItemTags.SWORDS)
			.add(IcariaItems.CHERT_SWORD.get())
			.add(IcariaItems.CHALKOS_SWORD.get())
			.add(IcariaItems.KASSITEROS_SWORD.get())
			.add(IcariaItems.ORICHALCUM_SWORD.get())
			.add(IcariaItems.VANADIUMSTEEL_SWORD.get())
			.add(IcariaItems.SIDEROS_SWORD.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_SWORD.get());

		this.tag(ItemTags.VANISHING_ENCHANTABLE)
			.add(IcariaItems.LAUREL_WREATH.get());

		this.tag(ItemTags.VILLAGER_PICKS_UP)
			.add(IcariaItems.SPELT.get())
			.add(IcariaItems.STRAWBERRIES.get())
			.add(IcariaItems.PHYSALIS.get())
			.add(IcariaItems.GARLIC.get());

		this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
			.add(IcariaItems.ONION.get())
			.add(IcariaItems.SPELT_SEEDS.get())
			.add(IcariaItems.STRAWBERRY_SEEDS.get())
			.add(IcariaItems.PHYSALIS_SEEDS.get());

		this.tag(ItemTags.WOLF_FOOD)
			.add(IcariaItems.COOKED_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.RAW_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.COOKED_BROWN_FEESH.get())
			.add(IcariaItems.RAW_BROWN_FEESH.get())
			.add(IcariaItems.COOKED_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.RAW_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.COOKED_PINK_RED_FEESH.get())
			.add(IcariaItems.RAW_PINK_RED_FEESH.get())
			.add(IcariaItems.COOKED_PURPLE_FEESH.get())
			.add(IcariaItems.RAW_PURPLE_FEESH.get())
			.add(IcariaItems.COOKED_RED_FEESH.get())
			.add(IcariaItems.RAW_RED_FEESH.get())
			.add(IcariaItems.COOKED_BLUE_RED_FICHE.get())
			.add(IcariaItems.RAW_BLUE_RED_FICHE.get())
			.add(IcariaItems.COOKED_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.RAW_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.COOKED_GRAY_FICHE.get())
			.add(IcariaItems.RAW_GRAY_FICHE.get())
			.add(IcariaItems.COOKED_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.COOKED_RED_FICHE.get())
			.add(IcariaItems.RAW_RED_FICHE.get())
			.add(IcariaItems.COOKED_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.RAW_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.COOKED_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_RED_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_RED_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.COOKED_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_BROWN_FISSHH.get())
			.add(IcariaItems.COOKED_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.COOKED_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_FYSH.get())
			.add(IcariaItems.RAW_BLUE_FYSH.get())
			.add(IcariaItems.COOKED_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.RAW_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.COOKED_GRAY_FYSH.get())
			.add(IcariaItems.RAW_GRAY_FYSH.get())
			.add(IcariaItems.COOKED_RAINBOW_FYSH.get())
			.add(IcariaItems.RAW_RAINBOW_FYSH.get())
			.add(IcariaItems.COOKED_RED_FYSH.get())
			.add(IcariaItems.RAW_RED_FYSH.get())
			.add(IcariaItems.COOKED_RED_YELLOW_FYSH.get())
			.add(IcariaItems.RAW_RED_YELLOW_FYSH.get())
			.add(IcariaItems.AETERNAE_STEW.get())
			.add(IcariaItems.CATOBLEPAS_STEW.get())
			.add(IcariaItems.CERVER_STEW.get())
			.add(IcariaItems.THOG_STEW.get());

		this.tag(Tags.Items.BRICKS)
			.add(IcariaItems.LOAM_BRICK.get());

		this.tag(Tags.Items.BUCKETS)
			.add(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());

		this.tag(Tags.Items.CROPS)
			.addTag(IcariaItemTagsProvider.CROPS_SPELT)
			.addTag(IcariaItemTagsProvider.CROPS_STRAWBERRIES)
			.addTag(IcariaItemTagsProvider.CROPS_PHYSALIS)
			.addTag(IcariaItemTagsProvider.CROPS_ONION);

		this.tag(Tags.Items.DRINKS_MAGIC)
			.add(IcariaItems.ANTI_GRAVITY_FLASK.get())
			.add(IcariaItems.FORTIFYING_FLASK.get())
			.add(IcariaItems.HEALING_FLASK.get());

		this.tag(Tags.Items.DUSTS)
			.addTag(IcariaItemTagsProvider.DUSTS_CALCITE)
			.addTag(IcariaItemTagsProvider.DUSTS_HALITE);

		this.tag(Tags.Items.DYED_WHITE)
			.add(IcariaItems.WHITE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.WHITE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.WHITE_STORAGE_VASE.get())
			.add(IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_LIGHT_GRAY)
			.add(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIGHT_GRAY_STORAGE_VASE.get())
			.add(IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_GRAY)
			.add(IcariaItems.GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.GRAY_STORAGE_VASE.get())
			.add(IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_BLACK)
			.add(IcariaItems.BLACK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BLACK_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BLACK_STORAGE_VASE.get())
			.add(IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_BROWN)
			.add(IcariaItems.BROWN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BROWN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BROWN_STORAGE_VASE.get())
			.add(IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_RED)
			.add(IcariaItems.RED_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.RED_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.RED_STORAGE_VASE.get())
			.add(IcariaItems.RED_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_ORANGE)
			.add(IcariaItems.ORANGE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.ORANGE_STORAGE_VASE.get())
			.add(IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_YELLOW)
			.add(IcariaItems.YELLOW_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.YELLOW_STORAGE_VASE.get())
			.add(IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_LIME)
			.add(IcariaItems.LIME_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIME_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIME_STORAGE_VASE.get())
			.add(IcariaItems.LIME_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_GREEN)
			.add(IcariaItems.GREEN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.GREEN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.GREEN_STORAGE_VASE.get())
			.add(IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_CYAN)
			.add(IcariaItems.CYAN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.CYAN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.CYAN_STORAGE_VASE.get())
			.add(IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_LIGHT_BLUE)
			.add(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIGHT_BLUE_STORAGE_VASE.get())
			.add(IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_BLUE)
			.add(IcariaItems.BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BLUE_STORAGE_VASE.get())
			.add(IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_PURPLE)
			.add(IcariaItems.PURPLE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.PURPLE_STORAGE_VASE.get())
			.add(IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_MAGENTA)
			.add(IcariaItems.MAGENTA_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.MAGENTA_STORAGE_VASE.get())
			.add(IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.DYED_PINK)
			.add(IcariaItems.PINK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.PINK_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.PINK_STORAGE_VASE.get())
			.add(IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());

		this.tag(Tags.Items.ENCHANTING_FUELS)
			.addTag(IcariaItemTagsProvider.GEMS_ZIRCON);

		this.tag(Tags.Items.FERTILIZERS)
			.addTag(IcariaItemTagsProvider.DUSTS_CALCITE);

		this.tag(Tags.Items.FOODS_BERRY)
			.add(IcariaItems.VINEBERRIES.get())
			.add(IcariaItems.STRAWBERRIES.get());

		this.tag(Tags.Items.FOODS_BREAD)
			.add(IcariaItems.SPELT_BREAD.get());

		this.tag(Tags.Items.FOODS_COOKED_FISH)
			.add(IcariaItems.COOKED_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.COOKED_BROWN_FEESH.get())
			.add(IcariaItems.COOKED_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.COOKED_PINK_RED_FEESH.get())
			.add(IcariaItems.COOKED_PURPLE_FEESH.get())
			.add(IcariaItems.COOKED_RED_FEESH.get())
			.add(IcariaItems.COOKED_BLUE_RED_FICHE.get())
			.add(IcariaItems.COOKED_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.COOKED_GRAY_FICHE.get())
			.add(IcariaItems.COOKED_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.COOKED_RED_FICHE.get())
			.add(IcariaItems.COOKED_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.COOKED_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_RED_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.COOKED_BROWN_FISSHH.get())
			.add(IcariaItems.COOKED_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.COOKED_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.COOKED_BLUE_FYSH.get())
			.add(IcariaItems.COOKED_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.COOKED_GRAY_FYSH.get())
			.add(IcariaItems.COOKED_RAINBOW_FYSH.get())
			.add(IcariaItems.COOKED_RED_FYSH.get())
			.add(IcariaItems.COOKED_RED_YELLOW_FYSH.get());

		this.tag(Tags.Items.FOODS_COOKED_MEAT)
			.add(IcariaItems.COOKED_AETERNAE_MEAT.get())
			.add(IcariaItems.COOKED_CAPELLA_MEAT.get())
			.add(IcariaItems.COOKED_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.COOKED_CERVER_MEAT.get())
			.add(IcariaItems.COOKED_CROCOTTA_MEAT.get())
			.add(IcariaItems.COOKED_THOG_MEAT.get());

		this.tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
			.add(IcariaItems.LAUREL_CHERRY_CAKE.get())
			.add(IcariaItems.STRAWBERRY_CAKE.get())
			.add(IcariaItems.PHYSALIS_CAKE.get())
			.add(IcariaItems.VINE_BERRY_CAKE.get())
			.add(IcariaItems.VINE_SPROUT_CAKE.get());

		this.tag(Tags.Items.FOODS_FRUIT)
			.add(IcariaItems.PHYSALIS.get())
			.add(IcariaItems.LAUREL_CHERRY.get());

		this.tag(Tags.Items.FOODS_RAW_FISH)
			.add(IcariaItems.RAW_BLUE_GRAY_FEESH.get())
			.add(IcariaItems.RAW_BROWN_FEESH.get())
			.add(IcariaItems.RAW_BROWN_ORANGE_FEESH.get())
			.add(IcariaItems.RAW_PINK_RED_FEESH.get())
			.add(IcariaItems.RAW_PURPLE_FEESH.get())
			.add(IcariaItems.RAW_RED_FEESH.get())
			.add(IcariaItems.RAW_BLUE_RED_FICHE.get())
			.add(IcariaItems.RAW_BROWN_CYAN_FICHE.get())
			.add(IcariaItems.RAW_GRAY_FICHE.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FICHE.get())
			.add(IcariaItems.RAW_RED_FICHE.get())
			.add(IcariaItems.RAW_WHITE_YELLOW_FICHE.get())
			.add(IcariaItems.RAW_BLUE_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_RED_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BROWN_FISSHH.get())
			.add(IcariaItems.RAW_GREEN_MAGENTA_FISSHH.get())
			.add(IcariaItems.RAW_PURPLE_YELLOW_FISSHH.get())
			.add(IcariaItems.RAW_BLUE_FYSH.get())
			.add(IcariaItems.RAW_BLUE_PURPLE_FYSH.get())
			.add(IcariaItems.RAW_GRAY_FYSH.get())
			.add(IcariaItems.RAW_RAINBOW_FYSH.get())
			.add(IcariaItems.RAW_RED_FYSH.get())
			.add(IcariaItems.RAW_RED_YELLOW_FYSH.get());

		this.tag(Tags.Items.FOODS_RAW_MEAT)
			.add(IcariaItems.RAW_AETERNAE_MEAT.get())
			.add(IcariaItems.RAW_CAPELLA_MEAT.get())
			.add(IcariaItems.RAW_CATOBLEPAS_MEAT.get())
			.add(IcariaItems.RAW_CERVER_MEAT.get())
			.add(IcariaItems.RAW_CROCOTTA_MEAT.get())
			.add(IcariaItems.RAW_THOG_MEAT.get());

		this.tag(Tags.Items.FOODS_SOUP)
			.add(IcariaItems.ONION_SOUP.get())
			.add(IcariaItems.AETERNAE_STEW.get())
			.add(IcariaItems.CATOBLEPAS_STEW.get())
			.add(IcariaItems.CERVER_STEW.get())
			.add(IcariaItems.THOG_STEW.get());

		this.tag(Tags.Items.FOODS_VEGETABLE)
			.add(IcariaItems.BLACK_OLIVES.get())
			.add(IcariaItems.GREEN_OLIVES.get())
			.add(IcariaItems.GARLIC.get())
			.add(IcariaItems.ONION.get());

		this.tag(Tags.Items.GEMS)
			.addTag(IcariaItemTagsProvider.GEMS_CHERT)
			.addTag(IcariaItemTagsProvider.GEMS_CALCITE)
			.addTag(IcariaItemTagsProvider.GEMS_HALITE)
			.addTag(IcariaItemTagsProvider.GEMS_JASPER)
			.addTag(IcariaItemTagsProvider.GEMS_ZIRCON)
			.addTag(IcariaItemTagsProvider.GEMS_LIGNITE)
			.addTag(IcariaItemTagsProvider.GEMS_DOLOMITE)
			.addTag(IcariaItemTagsProvider.GEMS_SLIVER)
			.addTag(IcariaItemTagsProvider.GEMS_ANTHRACITE);

		this.tag(Tags.Items.GUNPOWDERS)
			.add(IcariaItems.GREENPOWDER.get());

		this.tag(Tags.Items.INGOTS)
			.addTag(IcariaItemTagsProvider.INGOTS_CHALKOS)
			.addTag(IcariaItemTagsProvider.INGOTS_KASSITEROS)
			.addTag(IcariaItemTagsProvider.INGOTS_ORICHALCUM)
			.addTag(IcariaItemTagsProvider.INGOTS_VANADIUM)
			.addTag(IcariaItemTagsProvider.INGOTS_VANADIUMSTEEL)
			.addTag(IcariaItemTagsProvider.INGOTS_SIDEROS)
			.addTag(IcariaItemTagsProvider.INGOTS_MOLYBDENUM)
			.addTag(IcariaItemTagsProvider.INGOTS_MOLYBDENUMSTEEL)
			.addTag(IcariaItemTagsProvider.INGOTS_BLURIDIUM);

		this.tag(Tags.Items.LEATHERS)
			.add(IcariaItems.AETERNAE_HIDE.get());

		this.tag(Tags.Items.MELEE_WEAPON_TOOLS)
			.add(IcariaItems.CHERT_SWORD.get())
			.add(IcariaItems.CHERT_DAGGER.get())
			.add(IcariaItems.CHERT_AXE.get())
			.add(IcariaItems.CHERT_SCYTHE.get())
			.add(IcariaItems.CHERT_BIDENT.get())
			.add(IcariaItems.CHALKOS_SWORD.get())
			.add(IcariaItems.CHALKOS_DAGGER.get())
			.add(IcariaItems.CHALKOS_AXE.get())
			.add(IcariaItems.CHALKOS_SCYTHE.get())
			.add(IcariaItems.CHALKOS_BIDENT.get())
			.add(IcariaItems.KASSITEROS_SWORD.get())
			.add(IcariaItems.KASSITEROS_DAGGER.get())
			.add(IcariaItems.KASSITEROS_AXE.get())
			.add(IcariaItems.KASSITEROS_SCYTHE.get())
			.add(IcariaItems.KASSITEROS_BIDENT.get())
			.add(IcariaItems.ORICHALCUM_SWORD.get())
			.add(IcariaItems.ORICHALCUM_DAGGER.get())
			.add(IcariaItems.ORICHALCUM_AXE.get())
			.add(IcariaItems.ORICHALCUM_SCYTHE.get())
			.add(IcariaItems.ORICHALCUM_BIDENT.get())
			.add(IcariaItems.VANADIUMSTEEL_SWORD.get())
			.add(IcariaItems.VANADIUMSTEEL_DAGGER.get())
			.add(IcariaItems.VANADIUMSTEEL_AXE.get())
			.add(IcariaItems.VANADIUMSTEEL_SCYTHE.get())
			.add(IcariaItems.VANADIUMSTEEL_BIDENT.get())
			.add(IcariaItems.SIDEROS_SWORD.get())
			.add(IcariaItems.SIDEROS_DAGGER.get())
			.add(IcariaItems.SIDEROS_AXE.get())
			.add(IcariaItems.SIDEROS_SCYTHE.get())
			.add(IcariaItems.SIDEROS_BIDENT.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_SWORD.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_DAGGER.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_AXE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());

		this.tag(Tags.Items.MINING_TOOL_TOOLS)
			.add(IcariaItems.CHERT_PICKAXE.get())
			.add(IcariaItems.CHALKOS_PICKAXE.get())
			.add(IcariaItems.KASSITEROS_PICKAXE.get())
			.add(IcariaItems.ORICHALCUM_PICKAXE.get())
			.add(IcariaItems.VANADIUMSTEEL_PICKAXE.get())
			.add(IcariaItems.SIDEROS_PICKAXE.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());

		this.tag(Tags.Items.MUSHROOMS)
			.add(IcariaItems.GREEN_GROUND_SHROOMS.get())
			.add(IcariaItems.BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get())
			.add(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get())
			.add(IcariaItems.UNNAMED_TREE_SHROOMS.get());

		this.tag(Tags.Items.NUGGETS)
			.addTag(IcariaItemTagsProvider.NUGGETS_CHALKOS)
			.addTag(IcariaItemTagsProvider.NUGGETS_KASSITEROS)
			.addTag(IcariaItemTagsProvider.NUGGETS_ORICHALCUM)
			.addTag(IcariaItemTagsProvider.NUGGETS_VANADIUM)
			.addTag(IcariaItemTagsProvider.NUGGETS_VANADIUMSTEEL)
			.addTag(IcariaItemTagsProvider.NUGGETS_SIDEROS)
			.addTag(IcariaItemTagsProvider.NUGGETS_MOLYBDENUM)
			.addTag(IcariaItemTagsProvider.NUGGETS_MOLYBDENUMSTEEL)
			.addTag(IcariaItemTagsProvider.NUGGETS_BLURIDIUM);

		this.tag(Tags.Items.RANGED_WEAPON_TOOLS)
			.add(IcariaItems.CHERT_BIDENT.get())
			.add(IcariaItems.CHALKOS_BIDENT.get())
			.add(IcariaItems.KASSITEROS_BIDENT.get())
			.add(IcariaItems.ORICHALCUM_BIDENT.get())
			.add(IcariaItems.VANADIUMSTEEL_BIDENT.get())
			.add(IcariaItems.SIDEROS_BIDENT.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());

		this.tag(Tags.Items.RAW_MATERIALS)
			.addTag(IcariaItemTagsProvider.RAW_MATERIALS_CHALKOS)
			.addTag(IcariaItemTagsProvider.RAW_MATERIALS_KASSITEROS)
			.addTag(IcariaItemTagsProvider.RAW_MATERIALS_VANADIUM)
			.addTag(IcariaItemTagsProvider.RAW_MATERIALS_SIDEROS)
			.addTag(IcariaItemTagsProvider.RAW_MATERIALS_MOLYBDENUM);

		this.tag(Tags.Items.SEEDS)
			.addTag(IcariaItemTagsProvider.SEEDS_SPELT)
			.addTag(IcariaItemTagsProvider.SEEDS_STRAWBERRY)
			.addTag(IcariaItemTagsProvider.SEEDS_PHYSALIS)
			.addTag(IcariaItemTagsProvider.SEEDS_ONION);

		this.tag(Tags.Items.SLIME_BALLS)
			.add(IcariaItems.ENDER_JELLYFISH_JELLY.get())
			.add(IcariaItems.FIRE_JELLYFISH_JELLY.get())
			.add(IcariaItems.NATURE_JELLYFISH_JELLY.get())
			.add(IcariaItems.VOID_JELLYFISH_JELLY.get())
			.add(IcariaItems.WATER_JELLYFISH_JELLY.get());

		this.tag(Tags.Items.STRINGS)
			.add(IcariaItems.ARACHNE_STRING.get());

		this.tag(Tags.Items.TOOLS_SPEAR)
			.add(IcariaItems.CHERT_BIDENT.get())
			.add(IcariaItems.CHALKOS_BIDENT.get())
			.add(IcariaItems.KASSITEROS_BIDENT.get())
			.add(IcariaItems.ORICHALCUM_BIDENT.get())
			.add(IcariaItems.VANADIUMSTEEL_BIDENT.get())
			.add(IcariaItems.SIDEROS_BIDENT.get())
			.add(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());

		this.tag(IcariaItemTagsProvider.ARACHNE_STRING_BLOCKS)
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.WHITE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BLACK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BROWN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.RED_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.ORANGE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.YELLOW_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIME_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.GREEN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.CYAN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.PURPLE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.MAGENTA_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.PINK_ARACHNE_STRING_BLOCK.get());

		this.tag(IcariaItemTagsProvider.ARACHNE_STRING_CARPETS)
			.add(IcariaItems.ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.WHITE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BLACK_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BROWN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.RED_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIME_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.GREEN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.CYAN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.PINK_ARACHNE_STRING_CARPET.get());

		this.tag(IcariaItemTagsProvider.CROPS_SPELT)
			.add(IcariaItems.SPELT.get());

		this.tag(IcariaItemTagsProvider.CROPS_STRAWBERRIES)
			.add(IcariaItems.STRAWBERRIES.get());

		this.tag(IcariaItemTagsProvider.CROPS_PHYSALIS)
			.add(IcariaItems.PHYSALIS.get());

		this.tag(IcariaItemTagsProvider.CROPS_ONION)
			.add(IcariaItems.ONION.get());

		this.tag(IcariaItemTagsProvider.DUSTS_CALCITE)
			.add(IcariaItems.CALCITE_DUST.get());

		this.tag(IcariaItemTagsProvider.DUSTS_HALITE)
			.add(IcariaItems.HALITE_DUST.get());

		this.tag(IcariaItemTagsProvider.GEMS_CHERT)
			.add(IcariaItems.CHERT.get());

		this.tag(IcariaItemTagsProvider.GEMS_CALCITE)
			.add(IcariaItems.CALCITE_SHARD.get());

		this.tag(IcariaItemTagsProvider.GEMS_HALITE)
			.add(IcariaItems.HALITE_SHARD.get());

		this.tag(IcariaItemTagsProvider.GEMS_JASPER)
			.add(IcariaItems.JASPER_SHARD.get());

		this.tag(IcariaItemTagsProvider.GEMS_ZIRCON)
			.add(IcariaItems.ZIRCON_SHARD.get());

		this.tag(IcariaItemTagsProvider.GEMS_LIGNITE)
			.add(IcariaItems.LIGNITE.get());

		this.tag(IcariaItemTagsProvider.GEMS_DOLOMITE)
			.add(IcariaItems.DOLOMITE.get());

		this.tag(IcariaItemTagsProvider.GEMS_SLIVER)
			.add(IcariaItems.SLIVER.get());

		this.tag(IcariaItemTagsProvider.GEMS_ANTHRACITE)
			.add(IcariaItems.ANTHRACITE.get());

		this.tag(IcariaItemTagsProvider.INGOTS_CHALKOS)
			.add(IcariaItems.CHALKOS_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_KASSITEROS)
			.add(IcariaItems.KASSITEROS_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_ORICHALCUM)
			.add(IcariaItems.ORICHALCUM_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_VANADIUM)
			.add(IcariaItems.VANADIUM_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_VANADIUMSTEEL)
			.add(IcariaItems.VANADIUMSTEEL_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_SIDEROS)
			.add(IcariaItems.SIDEROS_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_MOLYBDENUM)
			.add(IcariaItems.MOLYBDENUM_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_MOLYBDENUMSTEEL)
			.add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());

		this.tag(IcariaItemTagsProvider.INGOTS_BLURIDIUM)
			.add(IcariaItems.BLURIDIUM_INGOT.get());

		this.tag(IcariaItemTagsProvider.KETTLE_ITEMS)
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

		this.tag(IcariaItemTagsProvider.NUGGETS_CHALKOS)
			.add(IcariaItems.CHALKOS_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_KASSITEROS)
			.add(IcariaItems.KASSITEROS_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_ORICHALCUM)
			.add(IcariaItems.ORICHALCUM_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_VANADIUM)
			.add(IcariaItems.VANADIUM_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_VANADIUMSTEEL)
			.add(IcariaItems.VANADIUMSTEEL_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_SIDEROS)
			.add(IcariaItems.SIDEROS_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_MOLYBDENUM)
			.add(IcariaItems.MOLYBDENUM_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_MOLYBDENUMSTEEL)
			.add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());

		this.tag(IcariaItemTagsProvider.NUGGETS_BLURIDIUM)
			.add(IcariaItems.BLURIDIUM_NUGGET.get());

		this.tag(IcariaItemTagsProvider.RAW_BLOCKS_CHALKOS)
			.add(IcariaItems.RAW_CHALKOS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.RAW_BLOCKS_KASSITEROS)
			.add(IcariaItems.RAW_KASSITEROS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.RAW_BLOCKS_VANADIUM)
			.add(IcariaItems.RAW_VANADIUM_BLOCK.get());

		this.tag(IcariaItemTagsProvider.RAW_BLOCKS_SIDEROS)
			.add(IcariaItems.RAW_SIDEROS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.RAW_BLOCKS_MOLYBDENUM)
			.add(IcariaItems.RAW_MOLYBDENUM_BLOCK.get());

		this.tag(IcariaItemTagsProvider.RAW_MATERIALS_CHALKOS)
			.add(IcariaItems.RAW_CHALKOS.get());

		this.tag(IcariaItemTagsProvider.RAW_MATERIALS_KASSITEROS)
			.add(IcariaItems.RAW_KASSITEROS.get());

		this.tag(IcariaItemTagsProvider.RAW_MATERIALS_VANADIUM)
			.add(IcariaItems.RAW_VANADIUM.get());

		this.tag(IcariaItemTagsProvider.RAW_MATERIALS_SIDEROS)
			.add(IcariaItems.RAW_SIDEROS.get());

		this.tag(IcariaItemTagsProvider.RAW_MATERIALS_MOLYBDENUM)
			.add(IcariaItems.RAW_MOLYBDENUM.get());

		this.tag(IcariaItemTagsProvider.REPAIRS_AETERNAE_HIDE_ARMOR)
			.add(IcariaItems.AETERNAE_HIDE.get());

		this.tag(IcariaItemTagsProvider.REPAIRS_CHALKOS_ARMOR)
			.add(IcariaItems.CHALKOS_INGOT.get());

		this.tag(IcariaItemTagsProvider.REPAIRS_KASSITEROS_ARMOR)
			.add(IcariaItems.KASSITEROS_INGOT.get());

		this.tag(IcariaItemTagsProvider.REPAIRS_ORICHALCUM_ARMOR)
			.add(IcariaItems.ORICHALCUM_INGOT.get());

		this.tag(IcariaItemTagsProvider.REPAIRS_VANADIUMSTEEL_ARMOR)
			.add(IcariaItems.VANADIUMSTEEL_INGOT.get());

		this.tag(IcariaItemTagsProvider.REPAIRS_LAUREL_WREATH);

		this.tag(IcariaItemTagsProvider.SEEDS_SPELT)
			.add(IcariaItems.SPELT_SEEDS.get());

		this.tag(IcariaItemTagsProvider.SEEDS_STRAWBERRY)
			.add(IcariaItems.STRAWBERRY_SEEDS.get());

		this.tag(IcariaItemTagsProvider.SEEDS_PHYSALIS)
			.add(IcariaItems.PHYSALIS_SEEDS.get());

		this.tag(IcariaItemTagsProvider.SEEDS_ONION)
			.add(IcariaItems.ONION.get());

		this.tag(IcariaItemTagsProvider.STORAGE_VASES)
			.add(IcariaItems.UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.RED_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.LIME_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get())
			.add(IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());

		this.tag(IcariaItemTagsProvider.TOOL_MATERIALS_CHERT)
			.add(IcariaItems.CHERT.get());

		this.tag(IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS)
			.add(IcariaItems.CHALKOS_INGOT.get());

		this.tag(IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS)
			.add(IcariaItems.KASSITEROS_INGOT.get());

		this.tag(IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM)
			.add(IcariaItems.ORICHALCUM_INGOT.get());

		this.tag(IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL)
			.add(IcariaItems.VANADIUMSTEEL_INGOT.get());

		this.tag(IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS)
			.add(IcariaItems.SIDEROS_INGOT.get());

		this.tag(IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL)
			.add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());

		// ITEMBLOCKS

		this.tag(ItemTags.DAMPENS_VIBRATIONS)
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.WHITE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BLACK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BROWN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.RED_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.ORANGE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.YELLOW_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIME_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.GREEN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.CYAN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.PURPLE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.MAGENTA_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.PINK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaItems.ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.WHITE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BLACK_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BROWN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.RED_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIME_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.GREEN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.CYAN_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get())
			.add(IcariaItems.PINK_ARACHNE_STRING_CARPET.get());

		this.tag(ItemTags.DIRT)
			.add(IcariaItems.GRASSY_MARL.get())
			.add(IcariaItems.MARL.get())
			.add(IcariaItems.COARSE_MARL.get())
			.add(IcariaItems.DRY_LAKE_BED.get())
			.add(IcariaItems.LOAM.get());

		this.tag(ItemTags.FLOWERS)
			.add(IcariaItems.BLUE_GROUND_FLOWERS.get())
			.add(IcariaItems.CYAN_GROUND_FLOWERS.get())
			.add(IcariaItems.PINK_GROUND_FLOWERS.get())
			.add(IcariaItems.PURPLE_GROUND_FLOWERS.get())
			.add(IcariaItems.RED_GROUND_FLOWERS.get())
			.add(IcariaItems.WHITE_GROUND_FLOWERS.get())
			.add(IcariaItems.WHITE_BROMELIA.get())
			.add(IcariaItems.ORANGE_BROMELIA.get())
			.add(IcariaItems.PINK_BROMELIA.get())
			.add(IcariaItems.PURPLE_BROMELIA.get());

		this.tag(ItemTags.LEAVES)
			.add(IcariaItems.CYPRESS_LEAVES.get())
			.add(IcariaItems.DROUGHTROOT_LEAVES.get())
			.add(IcariaItems.FIR_LEAVES.get())
			.add(IcariaItems.LAUREL_LEAVES.get())
			.add(IcariaItems.OLIVE_LEAVES.get())
			.add(IcariaItems.PLANE_LEAVES.get())
			.add(IcariaItems.POPULUS_LEAVES.get());

		this.tag(ItemTags.LOGS_THAT_BURN)
			.addTag(IcariaItemTagsProvider.LOGS_CYPRESS)
			.addTag(IcariaItemTagsProvider.LOGS_DROUGHTROOT)
			.addTag(IcariaItemTagsProvider.LOGS_FIR)
			.addTag(IcariaItemTagsProvider.LOGS_LAUREL)
			.addTag(IcariaItemTagsProvider.LOGS_OLIVE)
			.addTag(IcariaItemTagsProvider.LOGS_PLANE)
			.addTag(IcariaItemTagsProvider.LOGS_POPULUS);

		this.tag(ItemTags.PLANKS)
			.add(IcariaItems.CYPRESS_PLANKS.get())
			.add(IcariaItems.DROUGHTROOT_PLANKS.get())
			.add(IcariaItems.FIR_PLANKS.get())
			.add(IcariaItems.LAUREL_PLANKS.get())
			.add(IcariaItems.OLIVE_PLANKS.get())
			.add(IcariaItems.PLANE_PLANKS.get())
			.add(IcariaItems.POPULUS_PLANKS.get());

		this.tag(ItemTags.SAND)
			.add(IcariaItems.LOAM.get())
			.add(IcariaItems.GRAINEL.get())
			.add(IcariaItems.SUSPICIOUS_GRAINEL.get())
			.add(IcariaItems.SILKSAND.get())
			.add(IcariaItems.SUSPICIOUS_SILKSAND.get());

		this.tag(ItemTags.SAPLINGS)
			.add(IcariaItems.CYPRESS_SAPLING.get())
			.add(IcariaItems.DROUGHTROOT_SAPLING.get())
			.add(IcariaItems.FIR_SAPLING.get())
			.add(IcariaItems.LAUREL_SAPLING.get())
			.add(IcariaItems.OLIVE_SAPLING.get())
			.add(IcariaItems.PLANE_SAPLING.get())
			.add(IcariaItems.POPULUS_SAPLING.get());

		this.tag(ItemTags.SLABS)
			.add(IcariaItems.MARL_ADOBE_SLAB.get())
			.add(IcariaItems.LOAM_BRICK_SLAB.get())
			.add(IcariaItems.DOLOMITE_ADOBE_SLAB.get())
			.add(IcariaItems.SMOOTH_DOLOMITE_SLAB.get())
			.add(IcariaItems.GRAINITE_ADOBE_SLAB.get())
			.add(IcariaItems.GRAINITE_SLAB.get())
			.add(IcariaItems.GRAINITE_BRICK_SLAB.get())
			.add(IcariaItems.YELLOWSTONE_ADOBE_SLAB.get())
			.add(IcariaItems.COBBLED_YELLOWSTONE_SLAB.get())
			.add(IcariaItems.YELLOWSTONE_SLAB.get())
			.add(IcariaItems.YELLOWSTONE_BRICK_SLAB.get())
			.add(IcariaItems.SILKSTONE_ADOBE_SLAB.get())
			.add(IcariaItems.COBBLED_SILKSTONE_SLAB.get())
			.add(IcariaItems.SILKSTONE_SLAB.get())
			.add(IcariaItems.SILKSTONE_BRICK_SLAB.get())
			.add(IcariaItems.SUNSTONE_ADOBE_SLAB.get())
			.add(IcariaItems.COBBLED_SUNSTONE_SLAB.get())
			.add(IcariaItems.SUNSTONE_SLAB.get())
			.add(IcariaItems.SUNSTONE_BRICK_SLAB.get())
			.add(IcariaItems.VOIDSHALE_ADOBE_SLAB.get())
			.add(IcariaItems.COBBLED_VOIDSHALE_SLAB.get())
			.add(IcariaItems.VOIDSHALE_SLAB.get())
			.add(IcariaItems.VOIDSHALE_BRICK_SLAB.get())
			.add(IcariaItems.BAETYL_ADOBE_SLAB.get())
			.add(IcariaItems.COBBLED_BAETYL_SLAB.get())
			.add(IcariaItems.BAETYL_SLAB.get())
			.add(IcariaItems.BAETYL_BRICK_SLAB.get())
			.add(IcariaItems.RELICSTONE_SLAB.get())
			.add(IcariaItems.SMOOTH_RELICSTONE_SLAB.get())
			.add(IcariaItems.RELICSTONE_BRICK_SLAB.get())
			.add(IcariaItems.CRACKED_RELICSTONE_BRICK_SLAB.get())
			.add(IcariaItems.MOSSY_RELICSTONE_BRICK_SLAB.get())
			.add(IcariaItems.RELICSTONE_TILE_SLAB.get())
			.add(IcariaItems.CRACKED_RELICSTONE_TILE_SLAB.get())
			.add(IcariaItems.MOSSY_RELICSTONE_TILE_SLAB.get())
			.add(IcariaItems.PLATOSHALE_SLAB.get())
			.add(IcariaItems.PLATOSHALE_BRICK_SLAB.get());

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
			.add(IcariaItems.VOIDLILY.get());

		this.tag(ItemTags.STAIRS)
			.add(IcariaItems.MARL_ADOBE_STAIRS.get())
			.add(IcariaItems.LOAM_BRICK_STAIRS.get())
			.add(IcariaItems.DOLOMITE_ADOBE_STAIRS.get())
			.add(IcariaItems.SMOOTH_DOLOMITE_STAIRS.get())
			.add(IcariaItems.GRAINITE_ADOBE_STAIRS.get())
			.add(IcariaItems.GRAINITE_STAIRS.get())
			.add(IcariaItems.GRAINITE_BRICK_STAIRS.get())
			.add(IcariaItems.YELLOWSTONE_ADOBE_STAIRS.get())
			.add(IcariaItems.COBBLED_YELLOWSTONE_STAIRS.get())
			.add(IcariaItems.YELLOWSTONE_STAIRS.get())
			.add(IcariaItems.YELLOWSTONE_BRICK_STAIRS.get())
			.add(IcariaItems.SILKSTONE_ADOBE_STAIRS.get())
			.add(IcariaItems.COBBLED_SILKSTONE_STAIRS.get())
			.add(IcariaItems.SILKSTONE_STAIRS.get())
			.add(IcariaItems.SILKSTONE_BRICK_STAIRS.get())
			.add(IcariaItems.SUNSTONE_ADOBE_STAIRS.get())
			.add(IcariaItems.COBBLED_SUNSTONE_STAIRS.get())
			.add(IcariaItems.SUNSTONE_STAIRS.get())
			.add(IcariaItems.SUNSTONE_BRICK_STAIRS.get())
			.add(IcariaItems.VOIDSHALE_ADOBE_STAIRS.get())
			.add(IcariaItems.COBBLED_VOIDSHALE_STAIRS.get())
			.add(IcariaItems.VOIDSHALE_STAIRS.get())
			.add(IcariaItems.VOIDSHALE_BRICK_STAIRS.get())
			.add(IcariaItems.BAETYL_ADOBE_STAIRS.get())
			.add(IcariaItems.COBBLED_BAETYL_STAIRS.get())
			.add(IcariaItems.BAETYL_STAIRS.get())
			.add(IcariaItems.BAETYL_BRICK_STAIRS.get())
			.add(IcariaItems.RELICSTONE_STAIRS.get())
			.add(IcariaItems.SMOOTH_RELICSTONE_STAIRS.get())
			.add(IcariaItems.RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaItems.CRACKED_RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaItems.MOSSY_RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaItems.RELICSTONE_TILE_STAIRS.get())
			.add(IcariaItems.CRACKED_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaItems.MOSSY_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaItems.PLATOSHALE_STAIRS.get())
			.add(IcariaItems.PLATOSHALE_BRICK_STAIRS.get());

		this.tag(ItemTags.WALLS)
			.add(IcariaItems.MARL_ADOBE_WALL.get())
			.add(IcariaItems.LOAM_BRICK_WALL.get())
			.add(IcariaItems.DOLOMITE_ADOBE_WALL.get())
			.add(IcariaItems.SMOOTH_DOLOMITE_WALL.get())
			.add(IcariaItems.GRAINITE_ADOBE_WALL.get())
			.add(IcariaItems.GRAINITE_WALL.get())
			.add(IcariaItems.GRAINITE_BRICK_WALL.get())
			.add(IcariaItems.YELLOWSTONE_ADOBE_WALL.get())
			.add(IcariaItems.COBBLED_YELLOWSTONE_WALL.get())
			.add(IcariaItems.YELLOWSTONE_WALL.get())
			.add(IcariaItems.YELLOWSTONE_BRICK_WALL.get())
			.add(IcariaItems.SILKSTONE_ADOBE_WALL.get())
			.add(IcariaItems.COBBLED_SILKSTONE_WALL.get())
			.add(IcariaItems.SILKSTONE_WALL.get())
			.add(IcariaItems.SILKSTONE_BRICK_WALL.get())
			.add(IcariaItems.SUNSTONE_ADOBE_WALL.get())
			.add(IcariaItems.COBBLED_SUNSTONE_WALL.get())
			.add(IcariaItems.SUNSTONE_WALL.get())
			.add(IcariaItems.SUNSTONE_BRICK_WALL.get())
			.add(IcariaItems.VOIDSHALE_ADOBE_WALL.get())
			.add(IcariaItems.COBBLED_VOIDSHALE_WALL.get())
			.add(IcariaItems.VOIDSHALE_WALL.get())
			.add(IcariaItems.VOIDSHALE_BRICK_WALL.get())
			.add(IcariaItems.BAETYL_ADOBE_WALL.get())
			.add(IcariaItems.COBBLED_BAETYL_WALL.get())
			.add(IcariaItems.BAETYL_WALL.get())
			.add(IcariaItems.BAETYL_BRICK_WALL.get())
			.add(IcariaItems.RELICSTONE_WALL.get())
			.add(IcariaItems.SMOOTH_RELICSTONE_WALL.get())
			.add(IcariaItems.RELICSTONE_BRICK_WALL.get())
			.add(IcariaItems.CRACKED_RELICSTONE_BRICK_WALL.get())
			.add(IcariaItems.MOSSY_RELICSTONE_BRICK_WALL.get())
			.add(IcariaItems.RELICSTONE_TILE_WALL.get())
			.add(IcariaItems.CRACKED_RELICSTONE_TILE_WALL.get())
			.add(IcariaItems.MOSSY_RELICSTONE_TILE_WALL.get())
			.add(IcariaItems.PLATOSHALE_WALL.get())
			.add(IcariaItems.PLATOSHALE_BRICK_WALL.get())
			.add(IcariaItems.QUARTZ_WALL.get());

		this.tag(ItemTags.WOODEN_BUTTONS)
			.add(IcariaItems.CYPRESS_BUTTON.get())
			.add(IcariaItems.DROUGHTROOT_BUTTON.get())
			.add(IcariaItems.FIR_BUTTON.get())
			.add(IcariaItems.LAUREL_BUTTON.get())
			.add(IcariaItems.OLIVE_BUTTON.get())
			.add(IcariaItems.PLANE_BUTTON.get())
			.add(IcariaItems.POPULUS_BUTTON.get());

		this.tag(ItemTags.WOODEN_DOORS)
			.add(IcariaItems.CYPRESS_DOOR.get())
			.add(IcariaItems.DROUGHTROOT_DOOR.get())
			.add(IcariaItems.FIR_DOOR.get())
			.add(IcariaItems.LAUREL_DOOR.get())
			.add(IcariaItems.OLIVE_DOOR.get())
			.add(IcariaItems.PLANE_DOOR.get())
			.add(IcariaItems.POPULUS_DOOR.get());

		this.tag(ItemTags.WOODEN_FENCES)
			.add(IcariaItems.CYPRESS_FENCE.get())
			.add(IcariaItems.DROUGHTROOT_FENCE.get())
			.add(IcariaItems.FIR_FENCE.get())
			.add(IcariaItems.LAUREL_FENCE.get())
			.add(IcariaItems.OLIVE_FENCE.get())
			.add(IcariaItems.PLANE_FENCE.get())
			.add(IcariaItems.POPULUS_FENCE.get());

		this.tag(ItemTags.FENCE_GATES)
			.add(IcariaItems.CYPRESS_FENCE_GATE.get())
			.add(IcariaItems.DROUGHTROOT_FENCE_GATE.get())
			.add(IcariaItems.FIR_FENCE_GATE.get())
			.add(IcariaItems.LAUREL_FENCE_GATE.get())
			.add(IcariaItems.OLIVE_FENCE_GATE.get())
			.add(IcariaItems.PLANE_FENCE_GATE.get())
			.add(IcariaItems.POPULUS_FENCE_GATE.get());

		this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
			.add(IcariaItems.CYPRESS_PRESSURE_PLATE.get())
			.add(IcariaItems.DROUGHTROOT_PRESSURE_PLATE.get())
			.add(IcariaItems.FIR_PRESSURE_PLATE.get())
			.add(IcariaItems.LAUREL_PRESSURE_PLATE.get())
			.add(IcariaItems.OLIVE_PRESSURE_PLATE.get())
			.add(IcariaItems.PLANE_PRESSURE_PLATE.get())
			.add(IcariaItems.POPULUS_PRESSURE_PLATE.get());

		this.tag(ItemTags.WOODEN_SLABS)
			.add(IcariaItems.CYPRESS_SLAB.get())
			.add(IcariaItems.DROUGHTROOT_SLAB.get())
			.add(IcariaItems.FIR_SLAB.get())
			.add(IcariaItems.LAUREL_SLAB.get())
			.add(IcariaItems.OLIVE_SLAB.get())
			.add(IcariaItems.PLANE_SLAB.get())
			.add(IcariaItems.POPULUS_SLAB.get());

		this.tag(ItemTags.WOODEN_STAIRS)
			.add(IcariaItems.CYPRESS_STAIRS.get())
			.add(IcariaItems.DROUGHTROOT_STAIRS.get())
			.add(IcariaItems.FIR_STAIRS.get())
			.add(IcariaItems.LAUREL_STAIRS.get())
			.add(IcariaItems.OLIVE_STAIRS.get())
			.add(IcariaItems.PLANE_STAIRS.get())
			.add(IcariaItems.POPULUS_STAIRS.get());

		this.tag(ItemTags.WOODEN_TRAPDOORS)
			.add(IcariaItems.CYPRESS_TRAPDOOR.get())
			.add(IcariaItems.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaItems.FIR_TRAPDOOR.get())
			.add(IcariaItems.LAUREL_TRAPDOOR.get())
			.add(IcariaItems.OLIVE_TRAPDOOR.get())
			.add(IcariaItems.PLANE_TRAPDOOR.get())
			.add(IcariaItems.POPULUS_TRAPDOOR.get());

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

		this.tag(Tags.Items.FENCE_GATES_WOODEN)
			.add(IcariaItems.CYPRESS_FENCE_GATE.get())
			.add(IcariaItems.DROUGHTROOT_FENCE_GATE.get())
			.add(IcariaItems.FIR_FENCE_GATE.get())
			.add(IcariaItems.LAUREL_FENCE_GATE.get())
			.add(IcariaItems.OLIVE_FENCE_GATE.get())
			.add(IcariaItems.PLANE_FENCE_GATE.get())
			.add(IcariaItems.POPULUS_FENCE_GATE.get());

		this.tag(Tags.Items.GLASS_BLOCKS_CHEAP)
			.add(IcariaItems.GRAINGLASS.get())
			.add(IcariaItems.SILKGLASS.get());

		this.tag(Tags.Items.GLASS_BLOCKS_COLORLESS)
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

		this.tag(Tags.Items.ORES)
			.addTag(IcariaItemTagsProvider.ORES_CHERT)
			.addTag(IcariaItemTagsProvider.ORES_BONES)
			.addTag(IcariaItemTagsProvider.ORES_LIGNITE)
			.addTag(IcariaItemTagsProvider.ORES_CHALKOS)
			.addTag(IcariaItemTagsProvider.ORES_KASSITEROS)
			.addTag(IcariaItemTagsProvider.ORES_DOLOMITE)
			.addTag(IcariaItemTagsProvider.ORES_VANADIUM)
			.addTag(IcariaItemTagsProvider.ORES_SLIVER)
			.addTag(IcariaItemTagsProvider.ORES_SIDEROS)
			.addTag(IcariaItemTagsProvider.ORES_ANTHRACITE)
			.addTag(IcariaItemTagsProvider.ORES_MOLYBDENUM)
			.addTag(IcariaItemTagsProvider.ORES_HYLIASTRUM);

		this.tag(Tags.Items.PLAYER_WORKSTATIONS_CRAFTING_TABLES)
			.add(IcariaItems.CYPRESS_CRAFTING_TABLE.get())
			.add(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaItems.FIR_CRAFTING_TABLE.get())
			.add(IcariaItems.LAUREL_CRAFTING_TABLE.get())
			.add(IcariaItems.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaItems.PLANE_CRAFTING_TABLE.get())
			.add(IcariaItems.POPULUS_CRAFTING_TABLE.get());

		this.tag(Tags.Items.FLOWERS_SMALL)
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
			.add(IcariaItems.VOIDLILY.get());

		this.tag(Tags.Items.STONES)
			.add(IcariaItems.YELLOWSTONE.get())
			.add(IcariaItems.SILKSTONE.get())
			.add(IcariaItems.SUNSTONE.get())
			.add(IcariaItems.VOIDSHALE.get())
			.add(IcariaItems.BAETYL.get())
			.add(IcariaItems.SMOOTH_RELICSTONE.get());

		this.tag(Tags.Items.STORAGE_BLOCKS)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_ARISTONE)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_ARACHNE_STRING)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_SPELT)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_VINE_REED)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_ROTTEN_BONES)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_CHALKOS)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_KASSITEROS)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_VANADIUM)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_SIDEROS)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_MOLYBDENUM)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_CALCITE)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_HALITE)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_JASPER)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_ZIRCON)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_CHERT)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_LIGNITE)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_CHALKOS)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_KASSITEROS)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_ORICHALCUM)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_VANADIUM)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_SLIVER)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_VANADIUMSTEEL)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_SIDEROS)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_ANTHRACITE)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_MOLYBDENUM)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_MOLYBDENUMSTEEL)
			.addTag(IcariaItemTagsProvider.STORAGE_BLOCKS_BLURIDIUM);

		this.tag(Tags.Items.STRIPPED_LOGS)
			.add(IcariaItems.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_FIR_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_FIR_LOG.get())
			.add(IcariaItems.STRIPPED_LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(Tags.Items.STRIPPED_WOODS)
			.add(IcariaItems.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaItems.STRIPPED_FIR_WOOD.get())
			.add(IcariaItems.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaItems.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaItems.STRIPPED_PLANE_WOOD.get())
			.add(IcariaItems.STRIPPED_POPULUS_WOOD.get());

		this.tag(IcariaItemTagsProvider.LOGS_CYPRESS)
			.add(IcariaItems.CYPRESS_WOOD.get())
			.add(IcariaItems.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaItems.CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaItems.DEAD_CYPRESS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get());

		this.tag(IcariaItemTagsProvider.LOGS_DROUGHTROOT)
			.add(IcariaItems.DROUGHTROOT_WOOD.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaItems.DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaItems.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get());

		this.tag(IcariaItemTagsProvider.LOGS_FIR)
			.add(IcariaItems.FIR_WOOD.get())
			.add(IcariaItems.STRIPPED_FIR_WOOD.get())
			.add(IcariaItems.FIR_LOG.get())
			.add(IcariaItems.STRIPPED_FIR_LOG.get())
			.add(IcariaItems.DEAD_FIR_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_FIR_LOG.get());

		this.tag(IcariaItemTagsProvider.LOGS_LAUREL)
			.add(IcariaItems.LAUREL_WOOD.get())
			.add(IcariaItems.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaItems.LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_LAUREL_LOG.get())
			.add(IcariaItems.DEAD_LAUREL_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get());

		this.tag(IcariaItemTagsProvider.LOGS_OLIVE)
			.add(IcariaItems.OLIVE_WOOD.get())
			.add(IcariaItems.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaItems.OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_OLIVE_LOG.get())
			.add(IcariaItems.DEAD_OLIVE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get());

		this.tag(IcariaItemTagsProvider.LOGS_PLANE)
			.add(IcariaItems.PLANE_WOOD.get())
			.add(IcariaItems.STRIPPED_PLANE_WOOD.get())
			.add(IcariaItems.PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_PLANE_LOG.get())
			.add(IcariaItems.DEAD_PLANE_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_PLANE_LOG.get());

		this.tag(IcariaItemTagsProvider.LOGS_POPULUS)
			.add(IcariaItems.POPULUS_WOOD.get())
			.add(IcariaItems.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaItems.POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_POPULUS_LOG.get())
			.add(IcariaItems.DEAD_POPULUS_LOG.get())
			.add(IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(IcariaItemTagsProvider.ORE_BEARING_GROUNDS_MARL)
			.add(IcariaItems.MARL.get());

		this.tag(IcariaItemTagsProvider.ORE_BEARING_GROUNDS_GRAINEL)
			.add(IcariaItems.GRAINEL.get());

		this.tag(IcariaItemTagsProvider.ORE_BEARING_GROUNDS_YELLOWSTONE)
			.add(IcariaItems.YELLOWSTONE.get());

		this.tag(IcariaItemTagsProvider.ORE_BEARING_GROUNDS_SILKSTONE)
			.add(IcariaItems.SILKSTONE.get());

		this.tag(IcariaItemTagsProvider.ORE_BEARING_GROUNDS_SUNSTONE)
			.add(IcariaItems.SUNSTONE.get());

		this.tag(IcariaItemTagsProvider.ORE_BEARING_GROUNDS_VOIDSHALE)
			.add(IcariaItems.VOIDSHALE.get());

		this.tag(IcariaItemTagsProvider.ORE_BEARING_GROUNDS_BAETYL)
			.add(IcariaItems.BAETYL.get());

		this.tag(IcariaItemTagsProvider.ORES_CHERT)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.GRAINEL_CHERT.get());

		this.tag(IcariaItemTagsProvider.ORES_BONES)
			.add(IcariaItems.MARL_BONES.get());

		this.tag(IcariaItemTagsProvider.ORES_LIGNITE)
			.add(IcariaItems.MARL_LIGNITE.get())
			.add(IcariaItems.LIGNITE_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_CHALKOS)
			.add(IcariaItems.CHALKOS_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_KASSITEROS)
			.add(IcariaItems.KASSITEROS_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_DOLOMITE)
			.add(IcariaItems.DOLOMITE_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_VANADIUM)
			.add(IcariaItems.VANADIUM_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_SLIVER)
			.add(IcariaItems.SLIVER_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_SIDEROS)
			.add(IcariaItems.SIDEROS_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_ANTHRACITE)
			.add(IcariaItems.ANTHRACITE_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_MOLYBDENUM)
			.add(IcariaItems.MOLYBDENUM_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_HYLIASTRUM)
			.add(IcariaItems.HYLIASTRUM_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_IN_GROUND_MARL)
			.add(IcariaItems.MARL_CHERT.get())
			.add(IcariaItems.MARL_BONES.get())
			.add(IcariaItems.MARL_LIGNITE.get());

		this.tag(IcariaItemTagsProvider.ORES_IN_GROUND_GRAINEL)
			.add(IcariaItems.GRAINEL_CHERT.get());

		this.tag(IcariaItemTagsProvider.ORES_IN_GROUND_YELLOWSTONE)
			.add(IcariaItems.LIGNITE_ORE.get())
			.add(IcariaItems.CHALKOS_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_IN_GROUND_SILKSTONE)
			.add(IcariaItems.KASSITEROS_ORE.get())
			.add(IcariaItems.DOLOMITE_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_IN_GROUND_SUNSTONE)
			.add(IcariaItems.VANADIUM_ORE.get())
			.add(IcariaItems.SLIVER_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_IN_GROUND_VOIDSHALE)
			.add(IcariaItems.SIDEROS_ORE.get())
			.add(IcariaItems.ANTHRACITE_ORE.get());

		this.tag(IcariaItemTagsProvider.ORES_IN_GROUND_BAETYL)
			.add(IcariaItems.MOLYBDENUM_ORE.get())
			.add(IcariaItems.HYLIASTRUM_ORE.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_ARISTONE)
			.add(IcariaItems.PACKED_ARISTONE.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY)
			.add(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY)
			.add(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY)
			.add(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY)
			.add(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY)
			.add(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_ARACHNE_STRING)
			.add(IcariaItems.ARACHNE_STRING_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_SPELT)
			.add(IcariaItems.SPELT_BALE_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_VINE_REED)
			.add(IcariaItems.VINE_REED_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_ROTTEN_BONES)
			.add(IcariaItems.ROTTEN_BONES_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_CHALKOS)
			.add(IcariaItems.RAW_CHALKOS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_KASSITEROS)
			.add(IcariaItems.RAW_KASSITEROS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_VANADIUM)
			.add(IcariaItems.RAW_VANADIUM_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_SIDEROS)
			.add(IcariaItems.RAW_SIDEROS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_RAW_MOLYBDENUM)
			.add(IcariaItems.RAW_MOLYBDENUM_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_CALCITE)
			.add(IcariaItems.CALCITE_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_HALITE)
			.add(IcariaItems.HALITE_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_JASPER)
			.add(IcariaItems.JASPER_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_ZIRCON)
			.add(IcariaItems.ZIRCON_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_CHERT)
			.add(IcariaItems.CHERT_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_LIGNITE)
			.add(IcariaItems.LIGNITE_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_CHALKOS)
			.add(IcariaItems.CHALKOS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_KASSITEROS)
			.add(IcariaItems.KASSITEROS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_ORICHALCUM)
			.add(IcariaItems.ORICHALCUM_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_VANADIUM)
			.add(IcariaItems.VANADIUM_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_SLIVER)
			.add(IcariaItems.SLIVER_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_VANADIUMSTEEL)
			.add(IcariaItems.VANADIUMSTEEL_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_SIDEROS)
			.add(IcariaItems.SIDEROS_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_ANTHRACITE)
			.add(IcariaItems.ANTHRACITE_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_MOLYBDENUM)
			.add(IcariaItems.MOLYBDENUM_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_MOLYBDENUMSTEEL)
			.add(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());

		this.tag(IcariaItemTagsProvider.STORAGE_BLOCKS_BLURIDIUM)
			.add(IcariaItems.BLURIDIUM_BLOCK.get());
	}

	@Override
	public String getName() {
		return "Item Tags";
	}

	public static TagKey<Item> cKey(String pName) {
		return IcariaItemTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Item> icariaKey(String pName) {
		return IcariaItemTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<Item> createKey(String pName) {
		return TagKey.create(Registries.ITEM, ResourceLocation.parse(pName));
	}
}
