package com.axanthic.icaria.common.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemTags {
	public static final TagKey<Item> BRICKS_LOAM = IcariaItemTags.create("bricks/loam");

	public static final TagKey<Item> BUCKETS_MEDITERRANEAN_WATER = IcariaItemTags.create("buckets/mediterranean_water");

	public static final TagKey<Item> CROPS_ONION = IcariaItemTags.create("crops/onion");
	public static final TagKey<Item> CROPS_PHYSALIS = IcariaItemTags.create("crops/physalis");
	public static final TagKey<Item> CROPS_SPELT = IcariaItemTags.create("crops/spelt");
	public static final TagKey<Item> CROPS_STRAWBERRIES = IcariaItemTags.create("crops/strawberries");

	public static final TagKey<Item> DUSTS_CALCITE = IcariaItemTags.create("dusts/calcite");
	public static final TagKey<Item> DUSTS_HALITE = IcariaItemTags.create("dusts/halite");

	public static final TagKey<Item> FIREPLACE_ITEMS = IcariaItemTags.creatIcaria("fireplace_items");

	public static final TagKey<Item> GEMS_ANTHRACITE = IcariaItemTags.create("gems/anthracite");
	public static final TagKey<Item> GEMS_CALCITE = IcariaItemTags.create("gems/calcite");
	public static final TagKey<Item> GEMS_CHERT = IcariaItemTags.create("gems/chert");
	public static final TagKey<Item> GEMS_DOLOMITE = IcariaItemTags.create("gems/dolomite");
	public static final TagKey<Item> GEMS_HALITE = IcariaItemTags.create("gems/halite");
	public static final TagKey<Item> GEMS_JASPER = IcariaItemTags.create("gems/jasper");
	public static final TagKey<Item> GEMS_LIGNITE = IcariaItemTags.create("gems/lignite");
	public static final TagKey<Item> GEMS_SLIVER = IcariaItemTags.create("gems/sliver");
	public static final TagKey<Item> GEMS_ZIRCON = IcariaItemTags.create("gems/zircon");

	public static final TagKey<Item> GRINDER_GEARS = IcariaItemTags.creatIcaria("grinder_gears");

	public static final TagKey<Item> INGOTS_BLURIDIUM = IcariaItemTags.create("ingots/bluridium");
	public static final TagKey<Item> INGOTS_CHALKOS = IcariaItemTags.create("ingots/chalkos");
	public static final TagKey<Item> INGOTS_KASSITEROS = IcariaItemTags.create("ingots/kassiteros");
	public static final TagKey<Item> INGOTS_MOLYBDENUM = IcariaItemTags.create("ingots/molybdenum");
	public static final TagKey<Item> INGOTS_MOLYBDENUMSTEEL = IcariaItemTags.create("ingots/molybdenumsteel");
	public static final TagKey<Item> INGOTS_ORICHALCUM = IcariaItemTags.create("ingots/orichalcum");
	public static final TagKey<Item> INGOTS_SIDEROS = IcariaItemTags.create("ingots/sideros");
	public static final TagKey<Item> INGOTS_VANADIUM = IcariaItemTags.create("ingots/vanadium");
	public static final TagKey<Item> INGOTS_VANADIUMSTEEL = IcariaItemTags.create("ingots/vanadiumsteel");

	public static final TagKey<Item> KETTLE_ITEMS = IcariaItemTags.creatIcaria("kettle_items");

	public static final TagKey<Item> NUGGETS_BLURIDIUM = IcariaItemTags.create("nuggets/bluridium");
	public static final TagKey<Item> NUGGETS_CHALKOS = IcariaItemTags.create("nuggets/chalkos");
	public static final TagKey<Item> NUGGETS_KASSITEROS = IcariaItemTags.create("nuggets/kassiteros");
	public static final TagKey<Item> NUGGETS_MOLYBDENUM = IcariaItemTags.create("nuggets/molybdenum");
	public static final TagKey<Item> NUGGETS_MOLYBDENUMSTEEL = IcariaItemTags.create("nuggets/molybdenumsteel");
	public static final TagKey<Item> NUGGETS_ORICHALCUM = IcariaItemTags.create("nuggets/orichalcum");
	public static final TagKey<Item> NUGGETS_SIDEROS = IcariaItemTags.create("nuggets/sideros");
	public static final TagKey<Item> NUGGETS_VANADIUM = IcariaItemTags.create("nuggets/vanadium");
	public static final TagKey<Item> NUGGETS_VANADIUMSTEEL = IcariaItemTags.create("nuggets/vanadiumsteel");

	public static final TagKey<Item> RAW_MATERIALS_CHALKOS = IcariaItemTags.create("raw_materials/chalkos");
	public static final TagKey<Item> RAW_MATERIALS_KASSITEROS = IcariaItemTags.create("raw_materials/kassiteros");
	public static final TagKey<Item> RAW_MATERIALS_MOLYBDENUM = IcariaItemTags.create("raw_materials/molybdenum");
	public static final TagKey<Item> RAW_MATERIALS_SIDEROS = IcariaItemTags.create("raw_materials/sideros");
	public static final TagKey<Item> RAW_MATERIALS_VANADIUM = IcariaItemTags.create("raw_materials/vanadium");

	public static final TagKey<Item> REPAIRS_AETERNAE_HIDE_ARMOR = IcariaItemTags.creatIcaria("repairs_aeternae_hide_armor");
	public static final TagKey<Item> REPAIRS_CHALKOS_ARMOR = IcariaItemTags.creatIcaria("repairs_chalkos_armor");
	public static final TagKey<Item> REPAIRS_KASSITEROS_ARMOR = IcariaItemTags.creatIcaria("repairs_kassiteros_armor");
	public static final TagKey<Item> REPAIRS_LAUREL_WREATH = IcariaItemTags.creatIcaria("repairs_laurel_wreath");
	public static final TagKey<Item> REPAIRS_LOAM_GEAR = IcariaItemTags.creatIcaria("repairs_loam_gear");
	public static final TagKey<Item> REPAIRS_ORICHALCUM_ARMOR = IcariaItemTags.creatIcaria("repairs_orichalcum_armor");
	public static final TagKey<Item> REPAIRS_TOTEM = IcariaItemTags.creatIcaria("repairs_totem");
	public static final TagKey<Item> REPAIRS_VANADIUM_GEAR = IcariaItemTags.creatIcaria("repairs_vanadium_gear");
	public static final TagKey<Item> REPAIRS_VANADIUMSTEEL_ARMOR = IcariaItemTags.creatIcaria("repairs_vanadiumsteel_armor");
	public static final TagKey<Item> REPAIRS_VINE_SPROUT = IcariaItemTags.creatIcaria("repairs_vine_sprout");
	public static final TagKey<Item> REPAIRS_VOIDSHALE_GEAR = IcariaItemTags.creatIcaria("repairs_voidshale_gear");
	public static final TagKey<Item> REPAIRS_YELLOWSTONE_GEAR = IcariaItemTags.creatIcaria("repairs_yellowstone_gear");

	public static final TagKey<Item> SEEDS_ONION = IcariaItemTags.create("seeds/onion");
	public static final TagKey<Item> SEEDS_PHYSALIS = IcariaItemTags.create("seeds/physalis");
	public static final TagKey<Item> SEEDS_SPELT = IcariaItemTags.create("seeds/spelt");
	public static final TagKey<Item> SEEDS_STRAWBERRY = IcariaItemTags.create("seeds/strawberry");

	public static final TagKey<Item> TOOL_MATERIALS_CHALKOS = IcariaItemTags.creatIcaria("tool_materials/chalkos");
	public static final TagKey<Item> TOOL_MATERIALS_CHERT = IcariaItemTags.creatIcaria("tool_materials/chert");
	public static final TagKey<Item> TOOL_MATERIALS_KASSITEROS = IcariaItemTags.creatIcaria("tool_materials/kassiteros");
	public static final TagKey<Item> TOOL_MATERIALS_MOLYBDENUMSTEEL = IcariaItemTags.creatIcaria("tool_materials/molybdenumsteel");
	public static final TagKey<Item> TOOL_MATERIALS_ORICHALCUM = IcariaItemTags.creatIcaria("tool_materials/orichalcum");
	public static final TagKey<Item> TOOL_MATERIALS_SIDEROS = IcariaItemTags.creatIcaria("tool_materials/sideros");
	public static final TagKey<Item> TOOL_MATERIALS_VANADIUMSTEEL = IcariaItemTags.creatIcaria("tool_materials/vanadiumsteel");

	public static final TagKey<Item> TOOLS_BIDENT = IcariaItemTags.create("tools/bident");
	public static final TagKey<Item> TOOLS_DAGGER = IcariaItemTags.create("tools/dagger");
	public static final TagKey<Item> TOOLS_SCYTHE = IcariaItemTags.create("tools/scythe");

	public static final TagKey<Item> UNFIRED_STORAGE_VASES = IcariaItemTags.creatIcaria("unfired_storage_vases");

	public static TagKey<Item> create(String pName) {
		return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(IcariaIds.C, pName));
	}

	public static TagKey<Item> creatIcaria(String pName) {
		return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
