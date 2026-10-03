package com.axanthic.icaria.common.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockTags {
	public static final TagKey<Block> BARRELS_CYPRESS = IcariaBlockTags.createIcaria("barrels/cypress");
	public static final TagKey<Block> BARRELS_DROUGHTROOT = IcariaBlockTags.createIcaria("barrels/droughtroot");
	public static final TagKey<Block> BARRELS_FIR = IcariaBlockTags.createIcaria("barrels/fir");
	public static final TagKey<Block> BARRELS_LAUREL = IcariaBlockTags.createIcaria("barrels/laurel");
	public static final TagKey<Block> BARRELS_LOADED = IcariaBlockTags.createIcaria("barrels/loaded");
	public static final TagKey<Block> BARRELS_OLIVE = IcariaBlockTags.createIcaria("barrels/olive");
	public static final TagKey<Block> BARRELS_PLANE = IcariaBlockTags.createIcaria("barrels/plane");
	public static final TagKey<Block> BARRELS_POPULUS = IcariaBlockTags.createIcaria("barrels/populus");
	public static final TagKey<Block> BARRELS_TAPPED = IcariaBlockTags.createIcaria("barrels/tapped");

	public static final TagKey<Block> GRASS_BLOCKS = IcariaBlockTags.createIcaria("grass_blocks");

	public static final TagKey<Block> INCORRECT_FOR_CHALKOS_TOOL = IcariaBlockTags.createIcaria("incorrect_for_chalkos_tool");
	public static final TagKey<Block> INCORRECT_FOR_CHERT_TOOL = IcariaBlockTags.createIcaria("incorrect_for_chert_tool");
	public static final TagKey<Block> INCORRECT_FOR_KASSITEROS_TOOL = IcariaBlockTags.createIcaria("incorrect_for_kassiteros_tool");
	public static final TagKey<Block> INCORRECT_FOR_MOLYBDENUMSTEEL_TOOL = IcariaBlockTags.createIcaria("incorrect_for_molybdenumsteel_tool");
	public static final TagKey<Block> INCORRECT_FOR_ORICHALCUM_TOOL = IcariaBlockTags.createIcaria("incorrect_for_orichalcum_tool");
	public static final TagKey<Block> INCORRECT_FOR_SIDEROS_TOOL = IcariaBlockTags.createIcaria("incorrect_for_sideros_tool");
	public static final TagKey<Block> INCORRECT_FOR_VANADIUMSTEEL_TOOL = IcariaBlockTags.createIcaria("incorrect_for_vanadiumsteel_tool");

	public static final TagKey<Block> MINEABLE_WITH_SCYTHE = IcariaBlockTags.createIcaria("mineable/scythe");

	public static final TagKey<Block> NEEDS_CHALKOS_TOOL = IcariaBlockTags.createIcaria("needs_chalkos_tool");
	public static final TagKey<Block> NEEDS_CHERT_TOOL = IcariaBlockTags.createIcaria("needs_chert_tool");
	public static final TagKey<Block> NEEDS_KASSITEROS_TOOL = IcariaBlockTags.createIcaria("needs_kassiteros_tool");
	public static final TagKey<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = IcariaBlockTags.createIcaria("needs_molybdenumsteel_tool");
	public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = IcariaBlockTags.createIcaria("needs_orichalcum_tool");
	public static final TagKey<Block> NEEDS_SIDEROS_TOOL = IcariaBlockTags.createIcaria("needs_sideros_tool");
	public static final TagKey<Block> NEEDS_VANADIUMSTEEL_TOOL = IcariaBlockTags.createIcaria("needs_vanadiumsteel_tool");

	public static final TagKey<Block> PORTAL_BLOCKS_PILLAR = IcariaBlockTags.createIcaria("portal_blocks_pillar");
	public static final TagKey<Block> PORTAL_BLOCKS_PILLAR_HEAD = IcariaBlockTags.createIcaria("portal_blocks_pillar_head");
	public static final TagKey<Block> PORTAL_BLOCKS_SLAB = IcariaBlockTags.createIcaria("portal_blocks_slab");

	public static final TagKey<Block> RACKS_CYPRESS = IcariaBlockTags.createIcaria("racks/cypress");
	public static final TagKey<Block> RACKS_DROUGHTROOT = IcariaBlockTags.createIcaria("racks/droughtroot");
	public static final TagKey<Block> RACKS_FIR = IcariaBlockTags.createIcaria("racks/fir");
	public static final TagKey<Block> RACKS_LAUREL = IcariaBlockTags.createIcaria("racks/laurel");
	public static final TagKey<Block> RACKS_OLIVE = IcariaBlockTags.createIcaria("racks/olive");
	public static final TagKey<Block> RACKS_PLANE = IcariaBlockTags.createIcaria("racks/plane");
	public static final TagKey<Block> RACKS_POPULUS = IcariaBlockTags.createIcaria("racks/populus");

	public static final TagKey<Block> REPLACE_BLOCKS_ERODED_VILLAGE = IcariaBlockTags.createIcaria("replace_blocks/eroded_village");
	public static final TagKey<Block> REPLACE_BLOCKS_PRISTINE_VILLAGE = IcariaBlockTags.createIcaria("replace_blocks/pristine_village");
	public static final TagKey<Block> REPLACE_BLOCKS_RUINED_VILLAGE = IcariaBlockTags.createIcaria("replace_blocks/ruined_village");

	public static final TagKey<Block> SOILS = IcariaBlockTags.createIcaria("soils");

	public static final TagKey<Block> SUPPORT_BLOCKS_CLUSTER = IcariaBlockTags.createIcaria("support_blocks/cluster");
	public static final TagKey<Block> SUPPORT_BLOCKS_GRAINITE_RUBBLE = IcariaBlockTags.createIcaria("support_blocks/grainite_rubble");
	public static final TagKey<Block> SUPPORT_BLOCKS_RUBBLE = IcariaBlockTags.createIcaria("support_blocks/rubble");

	public static TagKey<Block> create(String pName) {
		return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(IcariaIds.C, pName));
	}

	public static TagKey<Block> createIcaria(String pName) {
		return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
