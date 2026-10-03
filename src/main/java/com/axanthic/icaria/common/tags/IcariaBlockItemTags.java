package com.axanthic.icaria.common.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockItemTagId;
import net.minecraft.tags.TagKey;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockItemTags {
	public static final BlockItemTagId ARACHNE_STRING_BLOCKS = IcariaBlockItemTags.createIcaria("arachne_string_blocks");

	public static final BlockItemTagId ARACHNE_STRING_CARPETS = IcariaBlockItemTags.createIcaria("arachne_string_carpets");

	public static final BlockItemTagId BARS_VANADIUMSTEEL = IcariaBlockItemTags.create("bars/vanadiumsteel");

	public static final BlockItemTagId COBBLESTONES_BAETYL = IcariaBlockItemTags.create("cobblesstones/baetyl");
	public static final BlockItemTagId COBBLESTONES_SILKSTONE = IcariaBlockItemTags.create("cobblesstones/silkstone");
	public static final BlockItemTagId COBBLESTONES_SUNSTONE = IcariaBlockItemTags.create("cobblesstones/sunstone");
	public static final BlockItemTagId COBBLESTONES_VOIDSHALE = IcariaBlockItemTags.create("cobblesstones/voidshale");
	public static final BlockItemTagId COBBLESTONES_YELLOWSTONE = IcariaBlockItemTags.create("cobblesstones/yellowstone");

	public static final BlockItemTagId LOGS_CYPRESS = IcariaBlockItemTags.createIcaria("logs/cypress");
	public static final BlockItemTagId LOGS_DROUGHTROOT = IcariaBlockItemTags.createIcaria("logs/droughtroot");
	public static final BlockItemTagId LOGS_FIR = IcariaBlockItemTags.createIcaria("logs/fir");
	public static final BlockItemTagId LOGS_LAUREL = IcariaBlockItemTags.createIcaria("logs/laurel");
	public static final BlockItemTagId LOGS_OLIVE = IcariaBlockItemTags.createIcaria("logs/olive");
	public static final BlockItemTagId LOGS_PLANE = IcariaBlockItemTags.createIcaria("logs/plane");
	public static final BlockItemTagId LOGS_POPULUS = IcariaBlockItemTags.createIcaria("logs/populus");

	public static final BlockItemTagId ORE_BEARING_GROUND_BAETYL = IcariaBlockItemTags.create("ore_bearing_ground/baetyl");
	public static final BlockItemTagId ORE_BEARING_GROUND_GRAINEL = IcariaBlockItemTags.create("ore_bearing_ground/grainel");
	public static final BlockItemTagId ORE_BEARING_GROUND_MARL = IcariaBlockItemTags.create("ore_bearing_ground/marl");
	public static final BlockItemTagId ORE_BEARING_GROUND_SILKSTONE = IcariaBlockItemTags.create("ore_bearing_ground/silkstone");
	public static final BlockItemTagId ORE_BEARING_GROUND_SUNSTONE = IcariaBlockItemTags.create("ore_bearing_ground/sunstone");
	public static final BlockItemTagId ORE_BEARING_GROUND_VOIDSHALE = IcariaBlockItemTags.create("ore_bearing_ground/voidshale");
	public static final BlockItemTagId ORE_BEARING_GROUND_YELLOWSTONE = IcariaBlockItemTags.create("ore_bearing_ground/yellowstone");

	public static final BlockItemTagId ORES_ANTHRACITE = IcariaBlockItemTags.create("ores/anthracite");
	public static final BlockItemTagId ORES_BONE = IcariaBlockItemTags.create("ores/bone");
	public static final BlockItemTagId ORES_CHALKOS = IcariaBlockItemTags.create("ores/chalkos");
	public static final BlockItemTagId ORES_CHERT = IcariaBlockItemTags.create("ores/chert");
	public static final BlockItemTagId ORES_DOLOMITE = IcariaBlockItemTags.create("ores/dolomite");
	public static final BlockItemTagId ORES_HYLIASTRUM = IcariaBlockItemTags.create("ores/hyliastrum");
	public static final BlockItemTagId ORES_KASSITEROS = IcariaBlockItemTags.create("ores/kassiteros");
	public static final BlockItemTagId ORES_LIGNITE = IcariaBlockItemTags.create("ores/lignite");
	public static final BlockItemTagId ORES_MOLYBDENUM = IcariaBlockItemTags.create("ores/molybdenum");
	public static final BlockItemTagId ORES_SIDEROS = IcariaBlockItemTags.create("ores/sideros");
	public static final BlockItemTagId ORES_SLIVER = IcariaBlockItemTags.create("ores/sliver");
	public static final BlockItemTagId ORES_VANADIUM = IcariaBlockItemTags.create("ores/vanadium");

	public static final BlockItemTagId ORES_IN_GROUND_BAETYL = IcariaBlockItemTags.create("ores_in_ground/baetyl");
	public static final BlockItemTagId ORES_IN_GROUND_GRAINEL = IcariaBlockItemTags.create("ores_in_ground/grainel");
	public static final BlockItemTagId ORES_IN_GROUND_MARL = IcariaBlockItemTags.create("ores_in_ground/marl");
	public static final BlockItemTagId ORES_IN_GROUND_SILKSTONE = IcariaBlockItemTags.create("ores_in_ground/silkstone");
	public static final BlockItemTagId ORES_IN_GROUND_SUNSTONE = IcariaBlockItemTags.create("ores_in_ground/sunstone");
	public static final BlockItemTagId ORES_IN_GROUND_VOIDSHALE = IcariaBlockItemTags.create("ores_in_ground/voidshale");
	public static final BlockItemTagId ORES_IN_GROUND_YELLOWSTONE = IcariaBlockItemTags.create("ores_in_ground/yellowstone");

	public static final BlockItemTagId STORAGE_BLOCKS_ANTHRACITE = IcariaBlockItemTags.create("storage_blocks/anthracite");
	public static final BlockItemTagId STORAGE_BLOCKS_ARACHNE_STRING = IcariaBlockItemTags.create("storage_blocks/arachne_string");
	public static final BlockItemTagId STORAGE_BLOCKS_ARISTONE = IcariaBlockItemTags.create("storage_blocks/aristone");
	public static final BlockItemTagId STORAGE_BLOCKS_BLURIDIUM = IcariaBlockItemTags.create("storage_blocks/bluridium");
	public static final BlockItemTagId STORAGE_BLOCKS_CHALKOS = IcariaBlockItemTags.create("storage_blocks/chalkos");
	public static final BlockItemTagId STORAGE_BLOCKS_CHERT = IcariaBlockItemTags.create("storage_blocks/chert");
	public static final BlockItemTagId STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY = IcariaBlockItemTags.create("storage_blocks/ender_jellyfish_jelly");
	public static final BlockItemTagId STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY = IcariaBlockItemTags.create("storage_blocks/fire_jellyfish_jelly");
	public static final BlockItemTagId STORAGE_BLOCKS_KASSITEROS = IcariaBlockItemTags.create("storage_blocks/kassiteros");
	public static final BlockItemTagId STORAGE_BLOCKS_LIGNITE = IcariaBlockItemTags.create("storage_blocks/lignite");
	public static final BlockItemTagId STORAGE_BLOCKS_MOLYBDENUM = IcariaBlockItemTags.create("storage_blocks/molybdenum");
	public static final BlockItemTagId STORAGE_BLOCKS_MOLYBDENUMSTEEL = IcariaBlockItemTags.create("storage_blocks/molybdenumsteel");
	public static final BlockItemTagId STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY = IcariaBlockItemTags.create("storage_blocks/nature_jellyfish_jelly");
	public static final BlockItemTagId STORAGE_BLOCKS_ORICHALCUM = IcariaBlockItemTags.create("storage_blocks/orichalcum");
	public static final BlockItemTagId STORAGE_BLOCKS_RAW_CHALKOS = IcariaBlockItemTags.create("storage_blocks/raw_chalkos");
	public static final BlockItemTagId STORAGE_BLOCKS_RAW_KASSITEROS = IcariaBlockItemTags.create("storage_blocks/raw_kassiteros");
	public static final BlockItemTagId STORAGE_BLOCKS_RAW_MOLYBDENUM = IcariaBlockItemTags.create("storage_blocks/raw_molybdenum");
	public static final BlockItemTagId STORAGE_BLOCKS_RAW_SIDEROS = IcariaBlockItemTags.create("storage_blocks/raw_sideros");
	public static final BlockItemTagId STORAGE_BLOCKS_RAW_VANADIUM = IcariaBlockItemTags.create("storage_blocks/raw_vanadium");
	public static final BlockItemTagId STORAGE_BLOCKS_ROTTEN_BONES = IcariaBlockItemTags.create("storage_blocks/rotten_bones");
	public static final BlockItemTagId STORAGE_BLOCKS_SIDEROS = IcariaBlockItemTags.create("storage_blocks/sideros");
	public static final BlockItemTagId STORAGE_BLOCKS_SLIVER = IcariaBlockItemTags.create("storage_blocks/sliver");
	public static final BlockItemTagId STORAGE_BLOCKS_SPELT = IcariaBlockItemTags.create("storage_blocks/spelt");
	public static final BlockItemTagId STORAGE_BLOCKS_VANADIUM = IcariaBlockItemTags.create("storage_blocks/vanadium");
	public static final BlockItemTagId STORAGE_BLOCKS_VANADIUMSTEEL = IcariaBlockItemTags.create("storage_blocks/vanadiumsteel");
	public static final BlockItemTagId STORAGE_BLOCKS_VINE_REED = IcariaBlockItemTags.create("storage_blocks/vine_reed");
	public static final BlockItemTagId STORAGE_BLOCKS_VOID_JELLYFISH_JELLY = IcariaBlockItemTags.create("storage_blocks/void_jellyfish_jelly");
	public static final BlockItemTagId STORAGE_BLOCKS_WATER_JELLYFISH_JELLY = IcariaBlockItemTags.create("storage_blocks/water_jellyfish_jelly");

	public static BlockItemTagId create(String pName) {
		return new BlockItemTagId(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(IcariaIds.C, pName)), TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(IcariaIds.C, pName)));
	}

	public static BlockItemTagId createIcaria(String pName) {
		return new BlockItemTagId(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName)), TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName)));
	}
}
