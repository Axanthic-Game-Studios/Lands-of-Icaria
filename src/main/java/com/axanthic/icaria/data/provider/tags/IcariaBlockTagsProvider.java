package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockTagsProvider extends BlockTagsProvider {

	// BLOCKS

	public static final TagKey<Block> BARRELS_CYPRESS = IcariaBlockTagsProvider.icariaKey("barrels/cypress");
	public static final TagKey<Block> BARRELS_DROUGHTROOT = IcariaBlockTagsProvider.icariaKey("barrels/droughtroot");
	public static final TagKey<Block> BARRELS_FIR = IcariaBlockTagsProvider.icariaKey("barrels/fir");
	public static final TagKey<Block> BARRELS_LAUREL = IcariaBlockTagsProvider.icariaKey("barrels/laurel");
	public static final TagKey<Block> BARRELS_LOADED = IcariaBlockTagsProvider.icariaKey("barrels/loaded");
	public static final TagKey<Block> BARRELS_OLIVE = IcariaBlockTagsProvider.icariaKey("barrels/olive");
	public static final TagKey<Block> BARRELS_PLANE = IcariaBlockTagsProvider.icariaKey("barrels/plane");
	public static final TagKey<Block> BARRELS_POPULUS = IcariaBlockTagsProvider.icariaKey("barrels/populus");
	public static final TagKey<Block> BARRELS_TAPPED = IcariaBlockTagsProvider.icariaKey("barrels/tapped");

	public static final TagKey<Block> GRASS_BLOCKS = IcariaBlockTagsProvider.icariaKey("grass_blocks");

	public static final TagKey<Block> INCORRECT_FOR_CHERT_TOOL = IcariaBlockTagsProvider.icariaKey("incorrect_for_chert_tool");
	public static final TagKey<Block> INCORRECT_FOR_CHALKOS_TOOL = IcariaBlockTagsProvider.icariaKey("incorrect_for_chalkos_tool");
	public static final TagKey<Block> INCORRECT_FOR_KASSITEROS_TOOL = IcariaBlockTagsProvider.icariaKey("incorrect_for_kassiteros_tool");
	public static final TagKey<Block> INCORRECT_FOR_ORICHALCUM_TOOL = IcariaBlockTagsProvider.icariaKey("incorrect_for_orichalcum_tool");
	public static final TagKey<Block> INCORRECT_FOR_VANADIUMSTEEL_TOOL = IcariaBlockTagsProvider.icariaKey("incorrect_for_vanadiumsteel_tool");
	public static final TagKey<Block> INCORRECT_FOR_SIDEROS_TOOL = IcariaBlockTagsProvider.icariaKey("incorrect_for_sideros_tool");
	public static final TagKey<Block> INCORRECT_FOR_MOLYBDENUMSTEEL_TOOL = IcariaBlockTagsProvider.icariaKey("incorrect_for_molybdenumsteel_tool");

	public static final TagKey<Block> MINEABLE_WITH_SCYTHE = IcariaBlockTagsProvider.icariaKey("mineable/scythe");

	public static final TagKey<Block> NEEDS_CHERT_TOOL = IcariaBlockTagsProvider.icariaKey("needs_chert_tool");
	public static final TagKey<Block> NEEDS_CHALKOS_TOOL = IcariaBlockTagsProvider.icariaKey("needs_chalkos_tool");
	public static final TagKey<Block> NEEDS_KASSITEROS_TOOL = IcariaBlockTagsProvider.icariaKey("needs_kassiteros_tool");
	public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = IcariaBlockTagsProvider.icariaKey("needs_orichalcum_tool");
	public static final TagKey<Block> NEEDS_VANADIUMSTEEL_TOOL = IcariaBlockTagsProvider.icariaKey("needs_vanadiumsteel_tool");
	public static final TagKey<Block> NEEDS_SIDEROS_TOOL = IcariaBlockTagsProvider.icariaKey("needs_sideros_tool");
	public static final TagKey<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = IcariaBlockTagsProvider.icariaKey("needs_molybdenumsteel_tool");

	public static final TagKey<Block> PORTAL_BLOCKS_PILLAR = IcariaBlockTagsProvider.icariaKey("portal_blocks_pillar");
	public static final TagKey<Block> PORTAL_BLOCKS_PILLAR_HEAD = IcariaBlockTagsProvider.icariaKey("portal_blocks_pillar_head");
	public static final TagKey<Block> PORTAL_BLOCKS_SLAB = IcariaBlockTagsProvider.icariaKey("portal_blocks_slab");

	public static final TagKey<Block> RACKS_CYPRESS = IcariaBlockTagsProvider.icariaKey("racks/cypress");
	public static final TagKey<Block> RACKS_DROUGHTROOT = IcariaBlockTagsProvider.icariaKey("racks/droughtroot");
	public static final TagKey<Block> RACKS_FIR = IcariaBlockTagsProvider.icariaKey("racks/fir");
	public static final TagKey<Block> RACKS_LAUREL = IcariaBlockTagsProvider.icariaKey("racks/laurel");
	public static final TagKey<Block> RACKS_OLIVE = IcariaBlockTagsProvider.icariaKey("racks/olive");
	public static final TagKey<Block> RACKS_PLANE = IcariaBlockTagsProvider.icariaKey("racks/plane");
	public static final TagKey<Block> RACKS_POPULUS = IcariaBlockTagsProvider.icariaKey("racks/populus");

	public static final TagKey<Block> REPLACE_BLOCKS_ERODED_VILLAGE = IcariaBlockTagsProvider.icariaKey("replace_blocks/eroded_village");
	public static final TagKey<Block> REPLACE_BLOCKS_PRISTINE_VILLAGE = IcariaBlockTagsProvider.icariaKey("replace_blocks/pristine_village");
	public static final TagKey<Block> REPLACE_BLOCKS_RUINED_VILLAGE = IcariaBlockTagsProvider.icariaKey("replace_blocks/ruined_village");

	public static final TagKey<Block> SOILS = IcariaBlockTagsProvider.icariaKey("soils");

	public static final TagKey<Block> SUPPORT_BLOCKS_CRYSTAL = IcariaBlockTagsProvider.icariaKey("support_blocks/crystal");
	public static final TagKey<Block> SUPPORT_BLOCKS_RELICSTONE_RUBBLE = IcariaBlockTagsProvider.icariaKey("support_blocks/relicstone_rubble");
	public static final TagKey<Block> SUPPORT_BLOCKS_RUBBLE = IcariaBlockTagsProvider.icariaKey("support_blocks/rubble");

	// ITEMBLOCKS

	public static final TagKey<Block> LOGS_CYPRESS = IcariaBlockTagsProvider.cKey("logs/cypress");
	public static final TagKey<Block> LOGS_DROUGHTROOT = IcariaBlockTagsProvider.cKey("logs/droughtroot");
	public static final TagKey<Block> LOGS_FIR = IcariaBlockTagsProvider.cKey("logs/fir");
	public static final TagKey<Block> LOGS_LAUREL = IcariaBlockTagsProvider.cKey("logs/laurel");
	public static final TagKey<Block> LOGS_OLIVE = IcariaBlockTagsProvider.cKey("logs/olive");
	public static final TagKey<Block> LOGS_PLANE = IcariaBlockTagsProvider.cKey("logs/plane");
	public static final TagKey<Block> LOGS_POPULUS = IcariaBlockTagsProvider.cKey("logs/populus");

	public static final TagKey<Block> ORE_BEARING_GROUNDS_MARL = IcariaBlockTagsProvider.cKey("ore_bearing_grounds/marl");
	public static final TagKey<Block> ORE_BEARING_GROUNDS_GRAINEL = IcariaBlockTagsProvider.cKey("ore_bearing_grounds/grainel");
	public static final TagKey<Block> ORE_BEARING_GROUNDS_YELLOWSTONE = IcariaBlockTagsProvider.cKey("ore_bearing_grounds/yellowstone");
	public static final TagKey<Block> ORE_BEARING_GROUNDS_SILKSTONE = IcariaBlockTagsProvider.cKey("ore_bearing_grounds/silkstone");
	public static final TagKey<Block> ORE_BEARING_GROUNDS_SUNSTONE = IcariaBlockTagsProvider.cKey("ore_bearing_grounds/sunstone");
	public static final TagKey<Block> ORE_BEARING_GROUNDS_VOIDSHALE = IcariaBlockTagsProvider.cKey("ore_bearing_grounds/voidshale");
	public static final TagKey<Block> ORE_BEARING_GROUNDS_BAETYL = IcariaBlockTagsProvider.cKey("ore_bearing_grounds/baetyl");

	public static final TagKey<Block> ORES_CHERT = IcariaBlockTagsProvider.cKey("ores/chert");
	public static final TagKey<Block> ORES_BONES = IcariaBlockTagsProvider.cKey("ores/bones");
	public static final TagKey<Block> ORES_LIGNITE = IcariaBlockTagsProvider.cKey("ores/lignite");
	public static final TagKey<Block> ORES_CHALKOS = IcariaBlockTagsProvider.cKey("ores/chalkos");
	public static final TagKey<Block> ORES_KASSITEROS = IcariaBlockTagsProvider.cKey("ores/kassiteros");
	public static final TagKey<Block> ORES_DOLOMITE = IcariaBlockTagsProvider.cKey("ores/dolomite");
	public static final TagKey<Block> ORES_VANADIUM = IcariaBlockTagsProvider.cKey("ores/vanadium");
	public static final TagKey<Block> ORES_SLIVER = IcariaBlockTagsProvider.cKey("ores/sliver");
	public static final TagKey<Block> ORES_SIDEROS = IcariaBlockTagsProvider.cKey("ores/sideros");
	public static final TagKey<Block> ORES_ANTHRACITE = IcariaBlockTagsProvider.cKey("ores/anthracite");
	public static final TagKey<Block> ORES_MOLYBDENUM = IcariaBlockTagsProvider.cKey("ores/molybdenum");
	public static final TagKey<Block> ORES_HYLIASTRUM = IcariaBlockTagsProvider.cKey("ores/hyliastrum");

	public static final TagKey<Block> ORES_IN_GROUND_MARL = IcariaBlockTagsProvider.cKey("ores_in_ground/marl");
	public static final TagKey<Block> ORES_IN_GROUND_GRAINEL = IcariaBlockTagsProvider.cKey("ores_in_ground/grainel");
	public static final TagKey<Block> ORES_IN_GROUND_YELLOWSTONE = IcariaBlockTagsProvider.cKey("ores_in_ground/yellowstone");
	public static final TagKey<Block> ORES_IN_GROUND_SILKSTONE = IcariaBlockTagsProvider.cKey("ores_in_ground/silkstone");
	public static final TagKey<Block> ORES_IN_GROUND_SUNSTONE = IcariaBlockTagsProvider.cKey("ores_in_ground/sunstone");
	public static final TagKey<Block> ORES_IN_GROUND_VOIDSHALE = IcariaBlockTagsProvider.cKey("ores_in_ground/voidshale");
	public static final TagKey<Block> ORES_IN_GROUND_BAETYL = IcariaBlockTagsProvider.cKey("ores_in_ground/baetyl");

	public static final TagKey<Block> STORAGE_BLOCKS_ARISTONE = IcariaBlockTagsProvider.cKey("storage_blocks/aristone");
	public static final TagKey<Block> STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY = IcariaBlockTagsProvider.cKey("storage_blocks/ender_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY = IcariaBlockTagsProvider.cKey("storage_blocks/fire_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY = IcariaBlockTagsProvider.cKey("storage_blocks/nature_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_VOID_JELLYFISH_JELLY = IcariaBlockTagsProvider.cKey("storage_blocks/void_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_WATER_JELLYFISH_JELLY = IcariaBlockTagsProvider.cKey("storage_blocks/water_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_ARACHNE_STRING = IcariaBlockTagsProvider.cKey("storage_blocks/arachne_string");
	public static final TagKey<Block> STORAGE_BLOCKS_SPELT = IcariaBlockTagsProvider.cKey("storage_blocks/spelt");
	public static final TagKey<Block> STORAGE_BLOCKS_VINE_REED = IcariaBlockTagsProvider.cKey("storage_blocks/vine_reed");
	public static final TagKey<Block> STORAGE_BLOCKS_ROTTEN_BONES = IcariaBlockTagsProvider.cKey("storage_blocks/rotten_bones");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_CHALKOS = IcariaBlockTagsProvider.cKey("storage_blocks/raw_chalkos");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_KASSITEROS = IcariaBlockTagsProvider.cKey("storage_blocks/raw_kassiteros");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_VANADIUM = IcariaBlockTagsProvider.cKey("storage_blocks/raw_vanadium");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_SIDEROS = IcariaBlockTagsProvider.cKey("storage_blocks/raw_sideros");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_MOLYBDENUM = IcariaBlockTagsProvider.cKey("storage_blocks/raw_molybdenum");
	public static final TagKey<Block> STORAGE_BLOCKS_CALCITE = IcariaBlockTagsProvider.cKey("storage_blocks/calcite");
	public static final TagKey<Block> STORAGE_BLOCKS_HALITE = IcariaBlockTagsProvider.cKey("storage_blocks/halite");
	public static final TagKey<Block> STORAGE_BLOCKS_JASPER = IcariaBlockTagsProvider.cKey("storage_blocks/jasper");
	public static final TagKey<Block> STORAGE_BLOCKS_ZIRCON = IcariaBlockTagsProvider.cKey("storage_blocks/zircon");
	public static final TagKey<Block> STORAGE_BLOCKS_CHERT = IcariaBlockTagsProvider.cKey("storage_blocks/chert");
	public static final TagKey<Block> STORAGE_BLOCKS_LIGNITE = IcariaBlockTagsProvider.cKey("storage_blocks/lignite");
	public static final TagKey<Block> STORAGE_BLOCKS_CHALKOS = IcariaBlockTagsProvider.cKey("storage_blocks/chalkos");
	public static final TagKey<Block> STORAGE_BLOCKS_KASSITEROS = IcariaBlockTagsProvider.cKey("storage_blocks/kassiteros");
	public static final TagKey<Block> STORAGE_BLOCKS_ORICHALCUM = IcariaBlockTagsProvider.cKey("storage_blocks/orichalcum");
	public static final TagKey<Block> STORAGE_BLOCKS_VANADIUM = IcariaBlockTagsProvider.cKey("storage_blocks/vanadium");
	public static final TagKey<Block> STORAGE_BLOCKS_SLIVER = IcariaBlockTagsProvider.cKey("storage_blocks/sliver");
	public static final TagKey<Block> STORAGE_BLOCKS_VANADIUMSTEEL = IcariaBlockTagsProvider.cKey("storage_blocks/vanadiumsteel");
	public static final TagKey<Block> STORAGE_BLOCKS_SIDEROS = IcariaBlockTagsProvider.cKey("storage_blocks/sideros");
	public static final TagKey<Block> STORAGE_BLOCKS_ANTHRACITE = IcariaBlockTagsProvider.cKey("storage_blocks/anthracite");
	public static final TagKey<Block> STORAGE_BLOCKS_MOLYBDENUM = IcariaBlockTagsProvider.cKey("storage_blocks/molybdenum");
	public static final TagKey<Block> STORAGE_BLOCKS_MOLYBDENUMSTEEL = IcariaBlockTagsProvider.cKey("storage_blocks/molybdenumsteel");
	public static final TagKey<Block> STORAGE_BLOCKS_BLURIDIUM = IcariaBlockTagsProvider.cKey("storage_blocks/bluridium");

	public IcariaBlockTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {

		// BLOCKS

		this.tag(BlockTags.BEE_ATTRACTIVE)
			.add(IcariaBlocks.BLINDWEED.get())
			.add(IcariaBlocks.CHAMEOMILE.get())
			.add(IcariaBlocks.CHARMONDER.get())
			.add(IcariaBlocks.CLOVER.get())
			.add(IcariaBlocks.FIREHILT.get())
			.add(IcariaBlocks.BLUE_HYDRACINTH.get())
			.add(IcariaBlocks.PURPLE_HYDRACINTH.get())
			.add(IcariaBlocks.LIONFANGS.get())
			.add(IcariaBlocks.SPEARDROPS.get())
			.add(IcariaBlocks.PURPLE_STAGHORN.get())
			.add(IcariaBlocks.YELLOW_STAGHORN.get())
			.add(IcariaBlocks.BLUE_STORMCOTTON.get())
			.add(IcariaBlocks.PINK_STORMCOTTON.get())
			.add(IcariaBlocks.PURPLE_STORMCOTTON.get())
			.add(IcariaBlocks.SUNKETTLE.get())
			.add(IcariaBlocks.SUNSPONGE.get())
			.add(IcariaBlocks.VOIDLILY.get())
			.add(IcariaBlocks.BLUE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.CYAN_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PINK_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PURPLE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.RED_GROUND_FLOWERS.get())
			.add(IcariaBlocks.WHITE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.WHITE_BROMELIA.get())
			.add(IcariaBlocks.ORANGE_BROMELIA.get())
			.add(IcariaBlocks.PINK_BROMELIA.get())
			.add(IcariaBlocks.PURPLE_BROMELIA.get());

		this.tag(BlockTags.CEILING_HANGING_SIGNS)
			.add(IcariaBlocks.CYPRESS_HANGING_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get())
			.add(IcariaBlocks.FIR_HANGING_SIGN.get())
			.add(IcariaBlocks.LAUREL_HANGING_SIGN.get())
			.add(IcariaBlocks.OLIVE_HANGING_SIGN.get())
			.add(IcariaBlocks.PLANE_HANGING_SIGN.get())
			.add(IcariaBlocks.POPULUS_HANGING_SIGN.get());

		this.tag(BlockTags.CLIMBABLE)
			.add(IcariaBlocks.CYPRESS_LADDER.get())
			.add(IcariaBlocks.DROUGHTROOT_LADDER.get())
			.add(IcariaBlocks.FIR_LADDER.get())
			.add(IcariaBlocks.LAUREL_LADDER.get())
			.add(IcariaBlocks.OLIVE_LADDER.get())
			.add(IcariaBlocks.PLANE_LADDER.get())
			.add(IcariaBlocks.POPULUS_LADDER.get())
			.add(IcariaBlocks.BLOOMY_VINE.get())
			.add(IcariaBlocks.BRANCHY_VINE.get())
			.add(IcariaBlocks.BRUSHY_VINE.get())
			.add(IcariaBlocks.DRY_VINE.get())
			.add(IcariaBlocks.REEDY_VINE.get())
			.add(IcariaBlocks.SWIRLY_VINE.get())
			.add(IcariaBlocks.THORNY_VINE.get());

		this.tag(BlockTags.COMBINATION_STEP_SOUND_BLOCKS)
			.add(IcariaBlocks.SURFACE_CHERT.get())
			.add(IcariaBlocks.SURFACE_BONES.get())
			.add(IcariaBlocks.SURFACE_LIGNITE.get())
			.add(IcariaBlocks.GRAINITE_RUBBLE.get())
			.add(IcariaBlocks.YELLOWSTONE_RUBBLE.get())
			.add(IcariaBlocks.SILKSTONE_RUBBLE.get())
			.add(IcariaBlocks.SUNSTONE_RUBBLE.get())
			.add(IcariaBlocks.VOIDSHALE_RUBBLE.get())
			.add(IcariaBlocks.BAETYL_RUBBLE.get())
			.add(IcariaBlocks.RELICSTONE_RUBBLE.get())
			.add(IcariaBlocks.CYPRESS_SAPLING.get())
			.add(IcariaBlocks.CYPRESS_TWIGS.get())
			.add(IcariaBlocks.SIMPLE_CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_PRESSURE_PLATE.get())
			.add(IcariaBlocks.CYPRESS_BUTTON.get())
			.add(IcariaBlocks.DROUGHTROOT_SAPLING.get())
			.add(IcariaBlocks.DROUGHTROOT_TWIGS.get())
			.add(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get())
			.add(IcariaBlocks.DROUGHTROOT_RACK.get())
			.add(IcariaBlocks.DROUGHTROOT_PRESSURE_PLATE.get())
			.add(IcariaBlocks.DROUGHTROOT_BUTTON.get())
			.add(IcariaBlocks.FIR_SAPLING.get())
			.add(IcariaBlocks.FIR_TWIGS.get())
			.add(IcariaBlocks.SIMPLE_FIR_RACK.get())
			.add(IcariaBlocks.FIR_RACK.get())
			.add(IcariaBlocks.FIR_PRESSURE_PLATE.get())
			.add(IcariaBlocks.FIR_BUTTON.get())
			.add(IcariaBlocks.LAUREL_SAPLING.get())
			.add(IcariaBlocks.LAUREL_TWIGS.get())
			.add(IcariaBlocks.SIMPLE_LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_PRESSURE_PLATE.get())
			.add(IcariaBlocks.LAUREL_BUTTON.get())
			.add(IcariaBlocks.OLIVE_SAPLING.get())
			.add(IcariaBlocks.OLIVE_TWIGS.get())
			.add(IcariaBlocks.SIMPLE_OLIVE_RACK.get())
			.add(IcariaBlocks.OLIVE_RACK.get())
			.add(IcariaBlocks.OLIVE_PRESSURE_PLATE.get())
			.add(IcariaBlocks.OLIVE_BUTTON.get())
			.add(IcariaBlocks.PLANE_SAPLING.get())
			.add(IcariaBlocks.PLANE_TWIGS.get())
			.add(IcariaBlocks.SIMPLE_PLANE_RACK.get())
			.add(IcariaBlocks.PLANE_RACK.get())
			.add(IcariaBlocks.PLANE_PRESSURE_PLATE.get())
			.add(IcariaBlocks.PLANE_BUTTON.get())
			.add(IcariaBlocks.POPULUS_SAPLING.get())
			.add(IcariaBlocks.POPULUS_TWIGS.get())
			.add(IcariaBlocks.SIMPLE_POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_PRESSURE_PLATE.get())
			.add(IcariaBlocks.POPULUS_BUTTON.get())
			.add(IcariaBlocks.FERN.get())
			.add(IcariaBlocks.SMALL_GRASS.get())
			.add(IcariaBlocks.MEDIUM_GRASS.get())
			.add(IcariaBlocks.LARGE_GRASS.get())
			.add(IcariaBlocks.SMALL_MIXED_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_MIXED_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_BROWN_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_WHITE_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get())
			.add(IcariaBlocks.LARGE_BROWN_GRAIN.get())
			.add(IcariaBlocks.BLINDWEED.get())
			.add(IcariaBlocks.CHAMEOMILE.get())
			.add(IcariaBlocks.CHARMONDER.get())
			.add(IcariaBlocks.CLOVER.get())
			.add(IcariaBlocks.FIREHILT.get())
			.add(IcariaBlocks.BLUE_HYDRACINTH.get())
			.add(IcariaBlocks.PURPLE_HYDRACINTH.get())
			.add(IcariaBlocks.LIONFANGS.get())
			.add(IcariaBlocks.SPEARDROPS.get())
			.add(IcariaBlocks.PURPLE_STAGHORN.get())
			.add(IcariaBlocks.YELLOW_STAGHORN.get())
			.add(IcariaBlocks.BLUE_STORMCOTTON.get())
			.add(IcariaBlocks.PINK_STORMCOTTON.get())
			.add(IcariaBlocks.PURPLE_STORMCOTTON.get())
			.add(IcariaBlocks.SUNKETTLE.get())
			.add(IcariaBlocks.SUNSPONGE.get())
			.add(IcariaBlocks.VOIDLILY.get())
			.add(IcariaBlocks.BOLBOS.get())
			.add(IcariaBlocks.DATHULLA.get())
			.add(IcariaBlocks.MONDANOS.get())
			.add(IcariaBlocks.MOTH_AGARIC.get())
			.add(IcariaBlocks.NAMDRAKE.get())
			.add(IcariaBlocks.PSILOCYBOS.get())
			.add(IcariaBlocks.ROWAN.get())
			.add(IcariaBlocks.WILTED_ELM.get())
			.add(IcariaBlocks.BLUE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.CYAN_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PINK_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PURPLE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.RED_GROUND_FLOWERS.get())
			.add(IcariaBlocks.WHITE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PALM_FERN.get())
			.add(IcariaBlocks.WHITE_BROMELIA.get())
			.add(IcariaBlocks.ORANGE_BROMELIA.get())
			.add(IcariaBlocks.PINK_BROMELIA.get())
			.add(IcariaBlocks.PURPLE_BROMELIA.get())
			.add(IcariaBlocks.GREEN_GROUND_SHROOMS.get())
			.add(IcariaBlocks.BROWN_GROUND_SHROOMS.get())
			.add(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get())
			.add(IcariaBlocks.STRAWBERRY_BUSH.get())
			.add(IcariaBlocks.SPELT_CROP.get())
			.add(IcariaBlocks.STRAWBERRY_CROP.get())
			.add(IcariaBlocks.PHYSALIS_CROP.get())
			.add(IcariaBlocks.ONION_CROP.get());

		this.tag(BlockTags.CROPS)
			.add(IcariaBlocks.SPELT_CROP.get())
			.add(IcariaBlocks.STRAWBERRY_CROP.get())
			.add(IcariaBlocks.PHYSALIS_CROP.get())
			.add(IcariaBlocks.ONION_CROP.get());

		this.tag(BlockTags.DRY_VEGETATION_MAY_PLACE_ON)
			.add(IcariaBlocks.FARMLAND.get())
			.add(IcariaBlocks.FERTILIZED_FARMLAND.get());

		this.tag(BlockTags.ENDERMAN_HOLDABLE)
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.CARDON_CACTUS.get());

		this.tag(BlockTags.FIRE)
			.add(IcariaBlocks.GREEK_FIRE.get());

		this.tag(BlockTags.FLOWER_POTS)
			.add(IcariaBlocks.POTTED_CYPRESS_SAPLING.get())
			.add(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get())
			.add(IcariaBlocks.POTTED_FIR_SAPLING.get())
			.add(IcariaBlocks.POTTED_LAUREL_SAPLING.get())
			.add(IcariaBlocks.POTTED_OLIVE_SAPLING.get())
			.add(IcariaBlocks.POTTED_PLANE_SAPLING.get())
			.add(IcariaBlocks.POTTED_POPULUS_SAPLING.get())
			.add(IcariaBlocks.POTTED_BLINDWEED.get())
			.add(IcariaBlocks.POTTED_CHAMEOMILE.get())
			.add(IcariaBlocks.POTTED_CHARMONDER.get())
			.add(IcariaBlocks.POTTED_CLOVER.get())
			.add(IcariaBlocks.POTTED_FIREHILT.get())
			.add(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get())
			.add(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get())
			.add(IcariaBlocks.POTTED_LIONFANGS.get())
			.add(IcariaBlocks.POTTED_SPEARDROPS.get())
			.add(IcariaBlocks.POTTED_PURPLE_STAGHORN.get())
			.add(IcariaBlocks.POTTED_YELLOW_STAGHORN.get())
			.add(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get())
			.add(IcariaBlocks.POTTED_PINK_STORMCOTTON.get())
			.add(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get())
			.add(IcariaBlocks.POTTED_SUNKETTLE.get())
			.add(IcariaBlocks.POTTED_SUNSPONGE.get())
			.add(IcariaBlocks.POTTED_VOIDLILY.get())
			.add(IcariaBlocks.POTTED_PALM_FERN.get())
			.add(IcariaBlocks.POTTED_WHITE_BROMELIA.get())
			.add(IcariaBlocks.POTTED_ORANGE_BROMELIA.get())
			.add(IcariaBlocks.POTTED_PINK_BROMELIA.get())
			.add(IcariaBlocks.POTTED_PURPLE_BROMELIA.get())
			.add(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get())
			.add(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get())
			.add(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get())
			.add(IcariaBlocks.POTTED_CARDON_CACTUS.get());

		this.tag(BlockTags.HAPPY_GHAST_AVOIDS)
			.add(IcariaBlocks.SURFACE_LIGNITE.get())
			.add(IcariaBlocks.THORNY_VINE.get())
			.add(IcariaBlocks.PURPLE_STAGHORN.get())
			.add(IcariaBlocks.POTTED_PURPLE_STAGHORN.get())
			.add(IcariaBlocks.YELLOW_STAGHORN.get())
			.add(IcariaBlocks.POTTED_YELLOW_STAGHORN.get())
			.add(IcariaBlocks.CARDON_CACTUS.get())
			.add(IcariaBlocks.POTTED_CARDON_CACTUS.get());

		this.tag(BlockTags.IMPERMEABLE)
			.add(IcariaBlocks.GRAINGLASS.get())
			.add(IcariaBlocks.SILKGLASS.get());

		this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHALKOS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHERT_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHALKOS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHERT_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHALKOS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHERT_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHALKOS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHERT_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHALKOS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
			.add(IcariaBlocks.ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.WHITE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BLACK_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BROWN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.RED_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.ORANGE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.YELLOW_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIME_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.GREEN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.CYAN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.PURPLE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.MAGENTA_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.PINK_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get())
			.add(IcariaBlocks.CYPRESS_BATHTUB.get())
			.add(IcariaBlocks.CYPRESS_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_POT_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_TRAPDOOR.get())
			.add(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get())
			.add(IcariaBlocks.DROUGHTROOT_BATHTUB.get())
			.add(IcariaBlocks.DROUGHTROOT_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_POT_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaBlocks.FALLEN_FIR_LEAVES.get())
			.add(IcariaBlocks.FIR_BATHTUB.get())
			.add(IcariaBlocks.FIR_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_POT_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_TRAPDOOR.get())
			.add(IcariaBlocks.FALLEN_LAUREL_LEAVES.get())
			.add(IcariaBlocks.LAUREL_BATHTUB.get())
			.add(IcariaBlocks.LAUREL_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_POT_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_TRAPDOOR.get())
			.add(IcariaBlocks.FALLEN_OLIVE_LEAVES.get())
			.add(IcariaBlocks.OLIVE_BATHTUB.get())
			.add(IcariaBlocks.OLIVE_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_POT_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_TRAPDOOR.get())
			.add(IcariaBlocks.FALLEN_PLANE_LEAVES.get())
			.add(IcariaBlocks.PLANE_BATHTUB.get())
			.add(IcariaBlocks.PLANE_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_POT_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_TRAPDOOR.get())
			.add(IcariaBlocks.FALLEN_POPULUS_LEAVES.get())
			.add(IcariaBlocks.POPULUS_BATHTUB.get())
			.add(IcariaBlocks.POPULUS_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_POT_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_TRAPDOOR.get())
			.add(IcariaBlocks.FOREST_MOSS.get())
			.add(IcariaBlocks.SCRUBLAND_MOSS.get())
			.add(IcariaBlocks.STEPPE_MOSS.get());

		this.tag(BlockTags.MAINTAINS_FARMLAND)
			.add(IcariaBlocks.ONION_CROP.get())
			.add(IcariaBlocks.PHYSALIS_CROP.get())
			.add(IcariaBlocks.SPELT_CROP.get())
			.add(IcariaBlocks.STRAWBERRY_CROP.get());

		this.tag(BlockTags.MINEABLE_WITH_AXE)
			.add(IcariaBlocks.VINE_REED_BLOCK.get())
			.add(IcariaBlocks.KETTLE.get())
			.add(IcariaBlocks.CHEST.get())
			.add(IcariaBlocks.TRAPPED_CHEST.get())
			.add(IcariaBlocks.CYPRESS_BATHTUB.get())
			.add(IcariaBlocks.CYPRESS_TROUGH.get())
			.add(IcariaBlocks.CYPRESS_STOOL.get())
			.add(IcariaBlocks.CYPRESS_HERB_HOLDER.get())
			.add(IcariaBlocks.CYPRESS_PAN_HOLDER.get())
			.add(IcariaBlocks.CYPRESS_POT_HOLDER.get())
			.add(IcariaBlocks.CYPRESS_SPOON_HOLDER.get())
			.add(IcariaBlocks.CYPRESS_TOWEL_HOLDER.get())
			.add(IcariaBlocks.CYPRESS_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_POT_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.CYPRESS_CUPBOARD.get())
			.add(IcariaBlocks.CYPRESS_DISHES_CUPBOARD.get())
			.add(IcariaBlocks.CYPRESS_FLASKS_CUPBOARD.get())
			.add(IcariaBlocks.CYPRESS_POTS_CUPBOARD.get())
			.add(IcariaBlocks.CYPRESS_VASE_CUPBOARD.get())
			.add(IcariaBlocks.CYPRESS_KITCHEN_TABLE.get())
			.add(IcariaBlocks.CYPRESS_KLINE.get())
			.add(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get())
			.add(IcariaBlocks.CYPRESS_SCROLLSHELF.get())
			.add(IcariaBlocks.CYPRESS_LADDER.get())
			.add(IcariaBlocks.DROUGHTROOT_BATHTUB.get())
			.add(IcariaBlocks.DROUGHTROOT_TROUGH.get())
			.add(IcariaBlocks.DROUGHTROOT_STOOL.get())
			.add(IcariaBlocks.DROUGHTROOT_HERB_HOLDER.get())
			.add(IcariaBlocks.DROUGHTROOT_PAN_HOLDER.get())
			.add(IcariaBlocks.DROUGHTROOT_POT_HOLDER.get())
			.add(IcariaBlocks.DROUGHTROOT_SPOON_HOLDER.get())
			.add(IcariaBlocks.DROUGHTROOT_TOWEL_HOLDER.get())
			.add(IcariaBlocks.DROUGHTROOT_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_POT_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.DROUGHTROOT_CUPBOARD.get())
			.add(IcariaBlocks.DROUGHTROOT_DISHES_CUPBOARD.get())
			.add(IcariaBlocks.DROUGHTROOT_FLASKS_CUPBOARD.get())
			.add(IcariaBlocks.DROUGHTROOT_POTS_CUPBOARD.get())
			.add(IcariaBlocks.DROUGHTROOT_VASE_CUPBOARD.get())
			.add(IcariaBlocks.DROUGHTROOT_KITCHEN_TABLE.get())
			.add(IcariaBlocks.DROUGHTROOT_KLINE.get())
			.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaBlocks.DROUGHTROOT_SCROLLSHELF.get())
			.add(IcariaBlocks.DROUGHTROOT_LADDER.get())
			.add(IcariaBlocks.FIR_BATHTUB.get())
			.add(IcariaBlocks.FIR_TROUGH.get())
			.add(IcariaBlocks.FIR_STOOL.get())
			.add(IcariaBlocks.FIR_HERB_HOLDER.get())
			.add(IcariaBlocks.FIR_PAN_HOLDER.get())
			.add(IcariaBlocks.FIR_POT_HOLDER.get())
			.add(IcariaBlocks.FIR_SPOON_HOLDER.get())
			.add(IcariaBlocks.FIR_TOWEL_HOLDER.get())
			.add(IcariaBlocks.FIR_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_POT_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.FIR_CUPBOARD.get())
			.add(IcariaBlocks.FIR_DISHES_CUPBOARD.get())
			.add(IcariaBlocks.FIR_FLASKS_CUPBOARD.get())
			.add(IcariaBlocks.FIR_POTS_CUPBOARD.get())
			.add(IcariaBlocks.FIR_VASE_CUPBOARD.get())
			.add(IcariaBlocks.FIR_KITCHEN_TABLE.get())
			.add(IcariaBlocks.FIR_KLINE.get())
			.add(IcariaBlocks.FIR_CRAFTING_TABLE.get())
			.add(IcariaBlocks.FIR_SCROLLSHELF.get())
			.add(IcariaBlocks.FIR_LADDER.get())
			.add(IcariaBlocks.LAUREL_BATHTUB.get())
			.add(IcariaBlocks.LAUREL_TROUGH.get())
			.add(IcariaBlocks.LAUREL_STOOL.get())
			.add(IcariaBlocks.LAUREL_HERB_HOLDER.get())
			.add(IcariaBlocks.LAUREL_PAN_HOLDER.get())
			.add(IcariaBlocks.LAUREL_POT_HOLDER.get())
			.add(IcariaBlocks.LAUREL_SPOON_HOLDER.get())
			.add(IcariaBlocks.LAUREL_TOWEL_HOLDER.get())
			.add(IcariaBlocks.LAUREL_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_POT_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.LAUREL_CUPBOARD.get())
			.add(IcariaBlocks.LAUREL_DISHES_CUPBOARD.get())
			.add(IcariaBlocks.LAUREL_FLASKS_CUPBOARD.get())
			.add(IcariaBlocks.LAUREL_POTS_CUPBOARD.get())
			.add(IcariaBlocks.LAUREL_VASE_CUPBOARD.get())
			.add(IcariaBlocks.LAUREL_KITCHEN_TABLE.get())
			.add(IcariaBlocks.LAUREL_KLINE.get())
			.add(IcariaBlocks.LAUREL_CRAFTING_TABLE.get())
			.add(IcariaBlocks.LAUREL_SCROLLSHELF.get())
			.add(IcariaBlocks.LAUREL_LADDER.get())
			.add(IcariaBlocks.OLIVE_BATHTUB.get())
			.add(IcariaBlocks.OLIVE_TROUGH.get())
			.add(IcariaBlocks.OLIVE_STOOL.get())
			.add(IcariaBlocks.OLIVE_HERB_HOLDER.get())
			.add(IcariaBlocks.OLIVE_PAN_HOLDER.get())
			.add(IcariaBlocks.OLIVE_POT_HOLDER.get())
			.add(IcariaBlocks.OLIVE_SPOON_HOLDER.get())
			.add(IcariaBlocks.OLIVE_TOWEL_HOLDER.get())
			.add(IcariaBlocks.OLIVE_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_POT_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.OLIVE_CUPBOARD.get())
			.add(IcariaBlocks.OLIVE_DISHES_CUPBOARD.get())
			.add(IcariaBlocks.OLIVE_FLASKS_CUPBOARD.get())
			.add(IcariaBlocks.OLIVE_POTS_CUPBOARD.get())
			.add(IcariaBlocks.OLIVE_VASE_CUPBOARD.get())
			.add(IcariaBlocks.OLIVE_KITCHEN_TABLE.get())
			.add(IcariaBlocks.OLIVE_KLINE.get())
			.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.OLIVE_SCROLLSHELF.get())
			.add(IcariaBlocks.OLIVE_LADDER.get())
			.add(IcariaBlocks.PLANE_BATHTUB.get())
			.add(IcariaBlocks.PLANE_TROUGH.get())
			.add(IcariaBlocks.PLANE_STOOL.get())
			.add(IcariaBlocks.PLANE_HERB_HOLDER.get())
			.add(IcariaBlocks.PLANE_PAN_HOLDER.get())
			.add(IcariaBlocks.PLANE_POT_HOLDER.get())
			.add(IcariaBlocks.PLANE_SPOON_HOLDER.get())
			.add(IcariaBlocks.PLANE_TOWEL_HOLDER.get())
			.add(IcariaBlocks.PLANE_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_POT_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.PLANE_CUPBOARD.get())
			.add(IcariaBlocks.PLANE_DISHES_CUPBOARD.get())
			.add(IcariaBlocks.PLANE_FLASKS_CUPBOARD.get())
			.add(IcariaBlocks.PLANE_POTS_CUPBOARD.get())
			.add(IcariaBlocks.PLANE_VASE_CUPBOARD.get())
			.add(IcariaBlocks.PLANE_KITCHEN_TABLE.get())
			.add(IcariaBlocks.PLANE_KLINE.get())
			.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.PLANE_SCROLLSHELF.get())
			.add(IcariaBlocks.PLANE_LADDER.get())
			.add(IcariaBlocks.POPULUS_BATHTUB.get())
			.add(IcariaBlocks.POPULUS_TROUGH.get())
			.add(IcariaBlocks.POPULUS_STOOL.get())
			.add(IcariaBlocks.POPULUS_HERB_HOLDER.get())
			.add(IcariaBlocks.POPULUS_PAN_HOLDER.get())
			.add(IcariaBlocks.POPULUS_POT_HOLDER.get())
			.add(IcariaBlocks.POPULUS_SPOON_HOLDER.get())
			.add(IcariaBlocks.POPULUS_TOWEL_HOLDER.get())
			.add(IcariaBlocks.POPULUS_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_FLOWER_POT_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_MORTAR_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_POT_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_RAISED_BASINS_COUNTERTOP.get())
			.add(IcariaBlocks.POPULUS_CUPBOARD.get())
			.add(IcariaBlocks.POPULUS_DISHES_CUPBOARD.get())
			.add(IcariaBlocks.POPULUS_FLASKS_CUPBOARD.get())
			.add(IcariaBlocks.POPULUS_POTS_CUPBOARD.get())
			.add(IcariaBlocks.POPULUS_VASE_CUPBOARD.get())
			.add(IcariaBlocks.POPULUS_KITCHEN_TABLE.get())
			.add(IcariaBlocks.POPULUS_KLINE.get())
			.add(IcariaBlocks.POPULUS_CRAFTING_TABLE.get())
			.add(IcariaBlocks.POPULUS_SCROLLSHELF.get())
			.add(IcariaBlocks.POPULUS_LADDER.get());

		this.tag(BlockTags.MINEABLE_WITH_HOE)
			.add(IcariaBlocks.SPELT_BALE_BLOCK.get())
			.add(IcariaBlocks.CYPRESS_LEAVES.get())
			.add(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get())
			.add(IcariaBlocks.DROUGHTROOT_LEAVES.get())
			.add(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get())
			.add(IcariaBlocks.FIR_LEAVES.get())
			.add(IcariaBlocks.FALLEN_FIR_LEAVES.get())
			.add(IcariaBlocks.LAUREL_LEAVES.get())
			.add(IcariaBlocks.FALLEN_LAUREL_LEAVES.get())
			.add(IcariaBlocks.OLIVE_LEAVES.get())
			.add(IcariaBlocks.FALLEN_OLIVE_LEAVES.get())
			.add(IcariaBlocks.PLANE_LEAVES.get())
			.add(IcariaBlocks.FALLEN_PLANE_LEAVES.get())
			.add(IcariaBlocks.POPULUS_LEAVES.get())
			.add(IcariaBlocks.FALLEN_POPULUS_LEAVES.get())
			.add(IcariaBlocks.FOREST_MOSS.get())
			.add(IcariaBlocks.SCRUBLAND_MOSS.get())
			.add(IcariaBlocks.STEPPE_MOSS.get());

		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(IcariaBlocks.MARL_ADOBE.get())
			.add(IcariaBlocks.MARL_ADOBE_STAIRS.get())
			.add(IcariaBlocks.MARL_ADOBE_SLAB.get())
			.add(IcariaBlocks.LOAM_BRICKS.get())
			.add(IcariaBlocks.LOAM_BRICK_STAIRS.get())
			.add(IcariaBlocks.LOAM_BRICK_SLAB.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_SLAB.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_STAIRS.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get())
			.add(IcariaBlocks.DOLOMITE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_DOLOMITE.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.GRAINITE_ADOBE.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_SLAB.get())
			.add(IcariaBlocks.GRAINITE.get())
			.add(IcariaBlocks.GRAINITE_STAIRS.get())
			.add(IcariaBlocks.GRAINITE_SLAB.get())
			.add(IcariaBlocks.GRAINITE_BRICKS.get())
			.add(IcariaBlocks.GRAINITE_BRICK_STAIRS.get())
			.add(IcariaBlocks.GRAINITE_BRICK_SLAB.get())
			.add(IcariaBlocks.CHISELED_GRAINITE.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_SLAB.get())
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_SLAB.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.CHISELED_YELLOWSTONE.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_SLAB.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_SLAB.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.CHISELED_SILKSTONE.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_SLAB.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_SLAB.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.CHISELED_SUNSTONE.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_SLAB.get())
			.add(IcariaBlocks.CHISELED_VOIDSHALE.get())
			.add(IcariaBlocks.BAETYL_ADOBE.get())
			.add(IcariaBlocks.BAETYL_ADOBE_STAIRS.get())
			.add(IcariaBlocks.BAETYL_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_BAETYL.get())
			.add(IcariaBlocks.COBBLED_BAETYL_STAIRS.get())
			.add(IcariaBlocks.COBBLED_BAETYL_SLAB.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.BAETYL_STAIRS.get())
			.add(IcariaBlocks.BAETYL_SLAB.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.BAETYL_BRICK_STAIRS.get())
			.add(IcariaBlocks.BAETYL_BRICK_SLAB.get())
			.add(IcariaBlocks.CHISELED_BAETYL.get())
			.add(IcariaBlocks.RELICSTONE.get())
			.add(IcariaBlocks.RELICSTONE_STAIRS.get())
			.add(IcariaBlocks.RELICSTONE_SLAB.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE_STAIRS.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE_SLAB.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.RELICSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.RELICSTONE_TILES.get())
			.add(IcariaBlocks.RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.RELICSTONE_TILE_SLAB.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILES.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_SLAB.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILES.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_SLAB.get())
			.add(IcariaBlocks.CHISELED_RELICSTONE.get())
			.add(IcariaBlocks.RELICSTONE_PILLAR.get())
			.add(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get())
			.add(IcariaBlocks.PLATOSHALE.get())
			.add(IcariaBlocks.PLATOSHALE_STAIRS.get())
			.add(IcariaBlocks.PLATOSHALE_SLAB.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.PLATOSHALE_BRICKS.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_STAIRS.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_SLAB.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_PLATOSHALE.get())
			.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get())
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get())
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get())
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get())
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get())
			.add(IcariaBlocks.MOLYBDENUM_ORE.get())
			.add(IcariaBlocks.HYLIASTRUM_ORE.get())
			.add(IcariaBlocks.CALCITE.get())
			.add(IcariaBlocks.BUDDING_CALCITE.get())
			.add(IcariaBlocks.HALITE.get())
			.add(IcariaBlocks.BUDDING_HALITE.get())
			.add(IcariaBlocks.JASPER.get())
			.add(IcariaBlocks.BUDDING_JASPER.get())
			.add(IcariaBlocks.ZIRCON.get())
			.add(IcariaBlocks.BUDDING_ZIRCON.get())
			.add(IcariaBlocks.CALCITE_CRYSTAL.get())
			.add(IcariaBlocks.HALITE_CRYSTAL.get())
			.add(IcariaBlocks.JASPER_CRYSTAL.get())
			.add(IcariaBlocks.ZIRCON_CRYSTAL.get())
			.add(IcariaBlocks.ARISTONE.get())
			.add(IcariaBlocks.PACKED_ARISTONE.get())
			.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get())
			.add(IcariaBlocks.RAW_CHALKOS_BLOCK.get())
			.add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get())
			.add(IcariaBlocks.RAW_VANADIUM_BLOCK.get())
			.add(IcariaBlocks.RAW_SIDEROS_BLOCK.get())
			.add(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.CALCITE_BLOCK.get())
			.add(IcariaBlocks.HALITE_BLOCK.get())
			.add(IcariaBlocks.JASPER_BLOCK.get())
			.add(IcariaBlocks.ZIRCON_BLOCK.get())
			.add(IcariaBlocks.CHERT_BLOCK.get())
			.add(IcariaBlocks.LIGNITE_BLOCK.get())
			.add(IcariaBlocks.CHALKOS_BLOCK.get())
			.add(IcariaBlocks.KASSITEROS_BLOCK.get())
			.add(IcariaBlocks.ORICHALCUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_BLOCK.get())
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.BLURIDIUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.VANADIUMSTEEL_CHAIN.get())
			.add(IcariaBlocks.GRINDER.get())
			.add(IcariaBlocks.KILN.get())
			.add(IcariaBlocks.FORGE.get())
			.add(IcariaBlocks.STORAGE_VASE.get())
			.add(IcariaBlocks.WHITE_STORAGE_VASE.get())
			.add(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get())
			.add(IcariaBlocks.GRAY_STORAGE_VASE.get())
			.add(IcariaBlocks.BLACK_STORAGE_VASE.get())
			.add(IcariaBlocks.BROWN_STORAGE_VASE.get())
			.add(IcariaBlocks.RED_STORAGE_VASE.get())
			.add(IcariaBlocks.ORANGE_STORAGE_VASE.get())
			.add(IcariaBlocks.YELLOW_STORAGE_VASE.get())
			.add(IcariaBlocks.LIME_STORAGE_VASE.get())
			.add(IcariaBlocks.GREEN_STORAGE_VASE.get())
			.add(IcariaBlocks.CYAN_STORAGE_VASE.get())
			.add(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get())
			.add(IcariaBlocks.BLUE_STORAGE_VASE.get())
			.add(IcariaBlocks.PURPLE_STORAGE_VASE.get())
			.add(IcariaBlocks.MAGENTA_STORAGE_VASE.get())
			.add(IcariaBlocks.PINK_STORAGE_VASE.get())
			.add(IcariaBlocks.AMPHORA.get())
			.add(IcariaBlocks.ARACHNE_SPAWNER.get())
			.add(IcariaBlocks.REVENANT_SPAWNER.get());

		this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.FARMLAND.get())
			.add(IcariaBlocks.FERTILIZED_FARMLAND.get())
			.add(IcariaBlocks.MARL_PATH.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.LOAM_PATH.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SUSPICIOUS_GRAINEL.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get())
			.add(IcariaBlocks.GRAINEL_PATH.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.SUSPICIOUS_SILKSAND.get())
			.add(IcariaBlocks.SILKSAND_PATH.get());

		this.tag(BlockTags.OCCLUDES_VIBRATION_SIGNALS)
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.WHITE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BLACK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BROWN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.RED_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.ORANGE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.YELLOW_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIME_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.GREEN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.CYAN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.PURPLE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.MAGENTA_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.PINK_ARACHNE_STRING_BLOCK.get());

		this.tag(BlockTags.PORTALS)
			.add(IcariaBlocks.ICARIA_PORTAL.get());

		this.tag(BlockTags.REPLACEABLE)
			.add(IcariaBlocks.BLOOMY_VINE.get())
			.add(IcariaBlocks.BRANCHY_VINE.get())
			.add(IcariaBlocks.BRUSHY_VINE.get())
			.add(IcariaBlocks.DRY_VINE.get())
			.add(IcariaBlocks.REEDY_VINE.get())
			.add(IcariaBlocks.SWIRLY_VINE.get())
			.add(IcariaBlocks.THORNY_VINE.get())
			.add(IcariaBlocks.FERN.get())
			.add(IcariaBlocks.SMALL_GRASS.get())
			.add(IcariaBlocks.MEDIUM_GRASS.get())
			.add(IcariaBlocks.LARGE_GRASS.get())
			.add(IcariaBlocks.SMALL_MIXED_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_MIXED_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_BROWN_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_WHITE_GRAIN.get())
			.add(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get())
			.add(IcariaBlocks.LARGE_BROWN_GRAIN.get());

		this.tag(BlockTags.SNIFFER_DIGGABLE_BLOCK)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get());

		this.tag(BlockTags.STANDING_SIGNS)
			.add(IcariaBlocks.CYPRESS_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_SIGN.get())
			.add(IcariaBlocks.FIR_SIGN.get())
			.add(IcariaBlocks.LAUREL_SIGN.get())
			.add(IcariaBlocks.OLIVE_SIGN.get())
			.add(IcariaBlocks.PLANE_SIGN.get())
			.add(IcariaBlocks.POPULUS_SIGN.get());

		this.tag(BlockTags.SWORD_EFFICIENT)
			.add(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get())
			.add(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get())
			.add(IcariaBlocks.FALLEN_FIR_LEAVES.get())
			.add(IcariaBlocks.FALLEN_LAUREL_LEAVES.get())
			.add(IcariaBlocks.FALLEN_OLIVE_LEAVES.get())
			.add(IcariaBlocks.FALLEN_PLANE_LEAVES.get())
			.add(IcariaBlocks.FALLEN_POPULUS_LEAVES.get())
			.add(IcariaBlocks.BLOOMY_VINE.get())
			.add(IcariaBlocks.BRANCHY_VINE.get())
			.add(IcariaBlocks.BRUSHY_VINE.get())
			.add(IcariaBlocks.DRY_VINE.get())
			.add(IcariaBlocks.REEDY_VINE.get())
			.add(IcariaBlocks.SWIRLY_VINE.get())
			.add(IcariaBlocks.THORNY_VINE.get());

		this.tag(BlockTags.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS)
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get());

		this.tag(BlockTags.WALL_HANGING_SIGNS)
			.add(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get());

		this.tag(BlockTags.WALL_POST_OVERRIDE)
			.add(IcariaBlocks.LIGNITE_TORCH.get())
			.add(IcariaBlocks.ANTHRACITE_TORCH.get());

		this.tag(BlockTags.WALL_SIGNS)
			.add(IcariaBlocks.CYPRESS_WALL_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_SIGN.get());

		this.tag(Tags.Blocks.DYED_WHITE)
			.add(IcariaBlocks.WHITE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.WHITE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.WHITE_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_LIGHT_GRAY)
			.add(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_GRAY)
			.add(IcariaBlocks.GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.GRAY_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_BLACK)
			.add(IcariaBlocks.BLACK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BLACK_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BLACK_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_BROWN)
			.add(IcariaBlocks.BROWN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BROWN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BROWN_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_RED)
			.add(IcariaBlocks.RED_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.RED_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.RED_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_ORANGE)
			.add(IcariaBlocks.ORANGE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.ORANGE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.ORANGE_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_YELLOW)
			.add(IcariaBlocks.YELLOW_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.YELLOW_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.YELLOW_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_LIME)
			.add(IcariaBlocks.LIME_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIME_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIME_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_GREEN)
			.add(IcariaBlocks.GREEN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.GREEN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.GREEN_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_CYAN)
			.add(IcariaBlocks.CYAN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.CYAN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.CYAN_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_LIGHT_BLUE)
			.add(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_BLUE)
			.add(IcariaBlocks.BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BLUE_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_PURPLE)
			.add(IcariaBlocks.PURPLE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.PURPLE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.PURPLE_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_MAGENTA)
			.add(IcariaBlocks.MAGENTA_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.MAGENTA_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.MAGENTA_STORAGE_VASE.get());

		this.tag(Tags.Blocks.DYED_PINK)
			.add(IcariaBlocks.PINK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.PINK_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.PINK_STORAGE_VASE.get());

		this.tag(Tags.Blocks.SKULLS)
			.add(IcariaBlocks.AETERNAE_SKULL.get())
			.add(IcariaBlocks.AETERNAE_WALL_SKULL.get())
			.add(IcariaBlocks.ARGAN_HOUND_SKULL.get())
			.add(IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get())
			.add(IcariaBlocks.CAPELLA_SKULL.get())
			.add(IcariaBlocks.CAPELLA_WALL_SKULL.get())
			.add(IcariaBlocks.CATOBLEPAS_SKULL.get())
			.add(IcariaBlocks.CATOBLEPAS_WALL_SKULL.get())
			.add(IcariaBlocks.CERVER_SKULL.get())
			.add(IcariaBlocks.CERVER_WALL_SKULL.get())
			.add(IcariaBlocks.CROCOTTA_SKULL.get())
			.add(IcariaBlocks.CROCOTTA_WALL_SKULL.get())
			.add(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get())
			.add(IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get())
			.add(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get())
			.add(IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get())
			.add(IcariaBlocks.FIR_FOREST_HAG_SKULL.get())
			.add(IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get())
			.add(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get())
			.add(IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get())
			.add(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get())
			.add(IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get())
			.add(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get())
			.add(IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get())
			.add(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get())
			.add(IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get())
			.add(IcariaBlocks.REVENANT_SKULL.get())
			.add(IcariaBlocks.REVENANT_WALL_SKULL.get())
			.add(IcariaBlocks.THOG_SKULL.get())
			.add(IcariaBlocks.THOG_WALL_SKULL.get());

		this.tag(Tags.Blocks.VILLAGER_FARMLANDS)
			.add(IcariaBlocks.FARMLAND.get())
			.add(IcariaBlocks.FERTILIZED_FARMLAND.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_CYPRESS)
			.add(IcariaBlocks.CYPRESS_BARREL.get())
			.add(IcariaBlocks.LOADED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TAPPED_CYPRESS_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_DROUGHTROOT)
			.add(IcariaBlocks.DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_FIR)
			.add(IcariaBlocks.FIR_BARREL.get())
			.add(IcariaBlocks.LOADED_FIR_BARREL.get())
			.add(IcariaBlocks.TAPPED_FIR_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_LAUREL)
			.add(IcariaBlocks.LAUREL_BARREL.get())
			.add(IcariaBlocks.LOADED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TAPPED_LAUREL_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_LOADED)
			.add(IcariaBlocks.LOADED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.LOADED_FIR_BARREL.get())
			.add(IcariaBlocks.LOADED_LAUREL_BARREL.get())
			.add(IcariaBlocks.LOADED_OLIVE_BARREL.get())
			.add(IcariaBlocks.LOADED_PLANE_BARREL.get())
			.add(IcariaBlocks.LOADED_POPULUS_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_OLIVE)
			.add(IcariaBlocks.OLIVE_BARREL.get())
			.add(IcariaBlocks.LOADED_OLIVE_BARREL.get())
			.add(IcariaBlocks.TAPPED_OLIVE_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_PLANE)
			.add(IcariaBlocks.PLANE_BARREL.get())
			.add(IcariaBlocks.LOADED_PLANE_BARREL.get())
			.add(IcariaBlocks.TAPPED_PLANE_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_POPULUS)
			.add(IcariaBlocks.POPULUS_BARREL.get())
			.add(IcariaBlocks.LOADED_POPULUS_BARREL.get())
			.add(IcariaBlocks.TAPPED_POPULUS_BARREL.get());

		this.tag(IcariaBlockTagsProvider.BARRELS_TAPPED)
			.add(IcariaBlocks.TAPPED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.TAPPED_FIR_BARREL.get())
			.add(IcariaBlocks.TAPPED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TAPPED_OLIVE_BARREL.get())
			.add(IcariaBlocks.TAPPED_PLANE_BARREL.get())
			.add(IcariaBlocks.TAPPED_POPULUS_BARREL.get());

		this.tag(IcariaBlockTagsProvider.GRASS_BLOCKS)
			.add(IcariaBlocks.SMALL_GRASS.get())
			.add(IcariaBlocks.MEDIUM_GRASS.get())
			.add(IcariaBlocks.LARGE_GRASS.get());

		this.tag(IcariaBlockTagsProvider.INCORRECT_FOR_CHERT_TOOL)
			.addTag(BlockTags.NEEDS_IRON_TOOL)
			.addTag(BlockTags.NEEDS_DIAMOND_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_CHALKOS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.INCORRECT_FOR_CHALKOS_TOOL)
			.addTag(BlockTags.NEEDS_IRON_TOOL)
			.addTag(BlockTags.NEEDS_DIAMOND_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.INCORRECT_FOR_KASSITEROS_TOOL)
			.addTag(BlockTags.NEEDS_DIAMOND_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.INCORRECT_FOR_ORICHALCUM_TOOL)
			.addTag(BlockTags.NEEDS_DIAMOND_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.INCORRECT_FOR_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.INCORRECT_FOR_SIDEROS_TOOL)
			.addTag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.INCORRECT_FOR_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.MINEABLE_WITH_SCYTHE)
			.addTag(BlockTags.CROPS)
			.addTag(BlockTags.MINEABLE_WITH_HOE)
			.addTag(BlockTags.REPLACEABLE);

		this.tag(IcariaBlockTagsProvider.NEEDS_CHERT_TOOL)
			.add(IcariaBlocks.COBBLED_YELLOWSTONE.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_SLAB.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_WALL.get())
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_SLAB.get())
			.add(IcariaBlocks.YELLOWSTONE_WALL.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.CHISELED_YELLOWSTONE.get())
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get())
			.add(IcariaBlocks.CALCITE_CRYSTAL.get())
			.add(IcariaBlocks.CALCITE.get())
			.add(IcariaBlocks.BUDDING_CALCITE.get())
			.add(IcariaBlocks.RAW_CHALKOS_BLOCK.get())
			.add(IcariaBlocks.CHALKOS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.NEEDS_CHALKOS_TOOL)
			.add(IcariaBlocks.SMOOTH_DOLOMITE.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_STAIRS.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_WALL.get())
			.add(IcariaBlocks.DOLOMITE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_DOLOMITE.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.SUSPICIOUS_SILKSAND.get())
			.add(IcariaBlocks.SILKGLASS.get())
			.add(IcariaBlocks.SILKGLASS_PANE.get())
			.add(IcariaBlocks.SILKGLASS.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_SLAB.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_WALL.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_SLAB.get())
			.add(IcariaBlocks.SILKSTONE_WALL.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.CHISELED_SILKSTONE.get())
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get())
			.add(IcariaBlocks.HALITE_CRYSTAL.get())
			.add(IcariaBlocks.HALITE.get())
			.add(IcariaBlocks.BUDDING_HALITE.get())
			.add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get())
			.add(IcariaBlocks.KASSITEROS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.NEEDS_KASSITEROS_TOOL)
			.add(IcariaBlocks.ORICHALCUM_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.NEEDS_ORICHALCUM_TOOL)
			.add(IcariaBlocks.COBBLED_SUNSTONE.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_SLAB.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_WALL.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_SLAB.get())
			.add(IcariaBlocks.SUNSTONE_WALL.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.CHISELED_SUNSTONE.get())
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get())
			.add(IcariaBlocks.JASPER_CRYSTAL.get())
			.add(IcariaBlocks.JASPER.get())
			.add(IcariaBlocks.BUDDING_JASPER.get())
			.add(IcariaBlocks.RAW_VANADIUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());

		this.tag(IcariaBlockTagsProvider.NEEDS_VANADIUMSTEEL_TOOL)
			.add(IcariaBlocks.COBBLED_VOIDSHALE.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_SLAB.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_WALL.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE_WALL.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_WALL.get())
			.add(IcariaBlocks.CHISELED_VOIDSHALE.get())
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get())
			.add(IcariaBlocks.RAW_SIDEROS_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_BLOCK.get())
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.NEEDS_SIDEROS_TOOL)
			.add(IcariaBlocks.COBBLED_BAETYL.get())
			.add(IcariaBlocks.COBBLED_BAETYL_STAIRS.get())
			.add(IcariaBlocks.COBBLED_BAETYL_SLAB.get())
			.add(IcariaBlocks.COBBLED_BAETYL_WALL.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.BAETYL_STAIRS.get())
			.add(IcariaBlocks.BAETYL_SLAB.get())
			.add(IcariaBlocks.BAETYL_WALL.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.BAETYL_BRICK_STAIRS.get())
			.add(IcariaBlocks.BAETYL_BRICK_SLAB.get())
			.add(IcariaBlocks.BAETYL_BRICK_WALL.get())
			.add(IcariaBlocks.CHISELED_BAETYL.get())
			.add(IcariaBlocks.PLATOSHALE.get())
			.add(IcariaBlocks.PLATOSHALE_STAIRS.get())
			.add(IcariaBlocks.PLATOSHALE_SLAB.get())
			.add(IcariaBlocks.PLATOSHALE_WALL.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.PLATOSHALE_BRICKS.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_STAIRS.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_SLAB.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_WALL.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_PLATOSHALE.get())
			.add(IcariaBlocks.MOLYBDENUM_ORE.get())
			.add(IcariaBlocks.HYLIASTRUM_ORE.get())
			.add(IcariaBlocks.ZIRCON_CRYSTAL.get())
			.add(IcariaBlocks.ZIRCON.get())
			.add(IcariaBlocks.BUDDING_ZIRCON.get())
			.add(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.BLURIDIUM_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR)
			.add(Blocks.QUARTZ_PILLAR)
			.add(IcariaBlocks.DOLOMITE_PILLAR.get());

		this.tag(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR_HEAD)
			.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());

		this.tag(IcariaBlockTagsProvider.PORTAL_BLOCKS_SLAB)
			.add(Blocks.QUARTZ_SLAB)
			.add(Blocks.SMOOTH_QUARTZ_SLAB)
			.add(IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get());

		this.tag(IcariaBlockTagsProvider.RACKS_CYPRESS)
			.add(IcariaBlocks.SIMPLE_CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_RACK.get());

		this.tag(IcariaBlockTagsProvider.RACKS_DROUGHTROOT)
			.add(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get())
			.add(IcariaBlocks.DROUGHTROOT_RACK.get());

		this.tag(IcariaBlockTagsProvider.RACKS_FIR)
			.add(IcariaBlocks.SIMPLE_FIR_RACK.get())
			.add(IcariaBlocks.FIR_RACK.get());

		this.tag(IcariaBlockTagsProvider.RACKS_LAUREL)
			.add(IcariaBlocks.SIMPLE_LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_RACK.get());

		this.tag(IcariaBlockTagsProvider.RACKS_OLIVE)
			.add(IcariaBlocks.SIMPLE_OLIVE_RACK.get())
			.add(IcariaBlocks.OLIVE_RACK.get());

		this.tag(IcariaBlockTagsProvider.RACKS_PLANE)
			.add(IcariaBlocks.SIMPLE_PLANE_RACK.get())
			.add(IcariaBlocks.PLANE_RACK.get());

		this.tag(IcariaBlockTagsProvider.RACKS_POPULUS)
			.add(IcariaBlocks.SIMPLE_POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_RACK.get());

		this.tag(IcariaBlockTagsProvider.REPLACE_BLOCKS_PRISTINE_VILLAGE);

		this.tag(IcariaBlockTagsProvider.REPLACE_BLOCKS_ERODED_VILLAGE)
			.add(Blocks.COBWEB) // TODO replace with Arachne web
			.add(Blocks.CHISELED_BOOKSHELF)
			.add(Blocks.FLOWER_POT)
			.add(Blocks.COMPOSTER)
			.add(Blocks.DECORATED_POT)
			.add(IcariaBlocks.SURFACE_LIGNITE.get())
			.add(IcariaBlocks.MARL_ADOBE.get())
			.add(IcariaBlocks.MARL_ADOBE_STAIRS.get())
			.add(IcariaBlocks.MARL_ADOBE_SLAB.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_SLAB.get())
			.add(IcariaBlocks.GRAINITE_ADOBE.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_SLAB.get())
			.add(IcariaBlocks.GRAINITE_BRICKS.get())
			.add(IcariaBlocks.GRAINITE_BRICK_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_SLAB.get())
			.add(IcariaBlocks.BAETYL_ADOBE.get())
			.add(IcariaBlocks.BAETYL_ADOBE_STAIRS.get())
			.add(IcariaBlocks.BAETYL_ADOBE_SLAB.get())
			.add(IcariaBlocks.RELICSTONE_TILES.get())
			.add(IcariaBlocks.RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILES.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILES.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.SPELT_BALE_BLOCK.get())
			.add(IcariaBlocks.VINE_REED_BLOCK.get())
			.add(IcariaBlocks.CHERT_BLOCK.get())
			.add(IcariaBlocks.LIGNITE_BLOCK.get())
			.add(IcariaBlocks.CHEST.get())
			.add(IcariaBlocks.RED_STORAGE_VASE.get())
			.add(IcariaBlocks.CYAN_STORAGE_VASE.get())
			.add(IcariaBlocks.RED_LOOT_VASE.get())
			.add(IcariaBlocks.CYAN_LOOT_VASE.get())
			.add(IcariaBlocks.ARACHNE_SPAWNER.get())
			.add(IcariaBlocks.REVENANT_SPAWNER.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.CYPRESS_STAIRS.get())
			.add(IcariaBlocks.CYPRESS_SLAB.get())
			.add(IcariaBlocks.SIMPLE_CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_BARREL.get())
			.add(IcariaBlocks.LOADED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TAPPED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get())
			.add(IcariaBlocks.CYPRESS_WALL_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_PLANKS.get())
			.add(IcariaBlocks.DROUGHTROOT_SLAB.get())
			.add(IcariaBlocks.DROUGHTROOT_FENCE.get())
			.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaBlocks.DROUGHTROOT_DOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_LADDER.get())
			.add(IcariaBlocks.FIR_PLANKS.get())
			.add(IcariaBlocks.FIR_SLAB.get())
			.add(IcariaBlocks.FIR_FENCE.get())
			.add(IcariaBlocks.FIR_CRAFTING_TABLE.get())
			.add(IcariaBlocks.FIR_DOOR.get())
			.add(IcariaBlocks.FIR_TRAPDOOR.get())
			.add(IcariaBlocks.FIR_LADDER.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_STAIRS.get())
			.add(IcariaBlocks.LAUREL_SLAB.get())
			.add(IcariaBlocks.SIMPLE_LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_BARREL.get())
			.add(IcariaBlocks.LOADED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TAPPED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get())
			.add(IcariaBlocks.LAUREL_WALL_SIGN.get())
			.add(IcariaBlocks.OLIVE_PLANKS.get())
			.add(IcariaBlocks.OLIVE_SLAB.get())
			.add(IcariaBlocks.OLIVE_FENCE.get())
			.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.OLIVE_DOOR.get())
			.add(IcariaBlocks.OLIVE_TRAPDOOR.get())
			.add(IcariaBlocks.OLIVE_LADDER.get())
			.add(IcariaBlocks.PLANE_PLANKS.get())
			.add(IcariaBlocks.PLANE_SLAB.get())
			.add(IcariaBlocks.PLANE_FENCE.get())
			.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.PLANE_DOOR.get())
			.add(IcariaBlocks.PLANE_TRAPDOOR.get())
			.add(IcariaBlocks.PLANE_LADDER.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_STAIRS.get())
			.add(IcariaBlocks.POPULUS_SLAB.get())
			.add(IcariaBlocks.SIMPLE_POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_BARREL.get())
			.add(IcariaBlocks.LOADED_POPULUS_BARREL.get())
			.add(IcariaBlocks.TAPPED_POPULUS_BARREL.get())
			.add(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get())
			.add(IcariaBlocks.POPULUS_WALL_SIGN.get());

		this.tag(IcariaBlockTagsProvider.REPLACE_BLOCKS_RUINED_VILLAGE)
			.add(Blocks.FLOWER_POT)
			.add(Blocks.DECORATED_POT)
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.SPELT_BALE_BLOCK.get())
			.add(IcariaBlocks.VINE_REED_BLOCK.get())
			.add(IcariaBlocks.CHERT_BLOCK.get())
			.add(IcariaBlocks.LIGNITE_BLOCK.get())
			.add(IcariaBlocks.RED_STORAGE_VASE.get())
			.add(IcariaBlocks.CYAN_STORAGE_VASE.get())
			.add(IcariaBlocks.RED_LOOT_VASE.get())
			.add(IcariaBlocks.CYAN_LOOT_VASE.get())
			.add(IcariaBlocks.ARACHNE_SPAWNER.get());

		this.tag(IcariaBlockTagsProvider.SOILS)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get());

		this.tag(IcariaBlockTagsProvider.SUPPORT_BLOCKS_CRYSTAL)
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.BAETYL.get());

		this.tag(IcariaBlockTagsProvider.SUPPORT_BLOCKS_RELICSTONE_RUBBLE)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.RELICSTONE.get());

		this.tag(IcariaBlockTagsProvider.SUPPORT_BLOCKS_RUBBLE)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.YELLOWSTONE.get());

		// ITEMBLOCKS

		this.tag(BlockTags.DAMPENS_VIBRATIONS)
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.WHITE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.GRAY_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BLACK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BROWN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.RED_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.ORANGE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.YELLOW_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIME_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.GREEN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.CYAN_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.BLUE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.PURPLE_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.MAGENTA_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.PINK_ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.WHITE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.GRAY_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BLACK_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BROWN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.RED_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.ORANGE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.YELLOW_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIME_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.GREEN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.CYAN_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.BLUE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.PURPLE_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.MAGENTA_ARACHNE_STRING_CARPET.get())
			.add(IcariaBlocks.PINK_ARACHNE_STRING_CARPET.get());

		this.tag(BlockTags.DIRT)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get());

		this.tag(BlockTags.FLOWERS)
			.add(IcariaBlocks.BLUE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.CYAN_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PINK_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PURPLE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.RED_GROUND_FLOWERS.get())
			.add(IcariaBlocks.WHITE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.WHITE_BROMELIA.get())
			.add(IcariaBlocks.ORANGE_BROMELIA.get())
			.add(IcariaBlocks.PINK_BROMELIA.get())
			.add(IcariaBlocks.PURPLE_BROMELIA.get());

		this.tag(BlockTags.LEAVES)
			.add(IcariaBlocks.CYPRESS_LEAVES.get())
			.add(IcariaBlocks.DROUGHTROOT_LEAVES.get())
			.add(IcariaBlocks.FIR_LEAVES.get())
			.add(IcariaBlocks.LAUREL_LEAVES.get())
			.add(IcariaBlocks.OLIVE_LEAVES.get())
			.add(IcariaBlocks.PLANE_LEAVES.get())
			.add(IcariaBlocks.POPULUS_LEAVES.get());

		this.tag(BlockTags.LOGS_THAT_BURN)
			.addTag(IcariaBlockTagsProvider.LOGS_CYPRESS)
			.addTag(IcariaBlockTagsProvider.LOGS_DROUGHTROOT)
			.addTag(IcariaBlockTagsProvider.LOGS_FIR)
			.addTag(IcariaBlockTagsProvider.LOGS_LAUREL)
			.addTag(IcariaBlockTagsProvider.LOGS_OLIVE)
			.addTag(IcariaBlockTagsProvider.LOGS_PLANE)
			.addTag(IcariaBlockTagsProvider.LOGS_POPULUS);

		this.tag(BlockTags.PLANKS)
			.add(IcariaBlocks.CYPRESS_PLANKS.get())
			.add(IcariaBlocks.DROUGHTROOT_PLANKS.get())
			.add(IcariaBlocks.FIR_PLANKS.get())
			.add(IcariaBlocks.LAUREL_PLANKS.get())
			.add(IcariaBlocks.OLIVE_PLANKS.get())
			.add(IcariaBlocks.PLANE_PLANKS.get())
			.add(IcariaBlocks.POPULUS_PLANKS.get());

		this.tag(BlockTags.SAND)
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SUSPICIOUS_GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.SUSPICIOUS_SILKSAND.get());

		this.tag(BlockTags.SAPLINGS)
			.add(IcariaBlocks.CYPRESS_SAPLING.get())
			.add(IcariaBlocks.DROUGHTROOT_SAPLING.get())
			.add(IcariaBlocks.FIR_SAPLING.get())
			.add(IcariaBlocks.LAUREL_SAPLING.get())
			.add(IcariaBlocks.OLIVE_SAPLING.get())
			.add(IcariaBlocks.PLANE_SAPLING.get())
			.add(IcariaBlocks.POPULUS_SAPLING.get());

		this.tag(BlockTags.SLABS)
			.add(IcariaBlocks.MARL_ADOBE_SLAB.get())
			.add(IcariaBlocks.LOAM_BRICK_SLAB.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_SLAB.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_SLAB.get())
			.add(IcariaBlocks.GRAINITE_SLAB.get())
			.add(IcariaBlocks.GRAINITE_BRICK_SLAB.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_SLAB.get())
			.add(IcariaBlocks.YELLOWSTONE_SLAB.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_SLAB.get())
			.add(IcariaBlocks.SILKSTONE_SLAB.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_SLAB.get())
			.add(IcariaBlocks.SUNSTONE_SLAB.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE_SLAB.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_SLAB.get())
			.add(IcariaBlocks.BAETYL_ADOBE_SLAB.get())
			.add(IcariaBlocks.COBBLED_BAETYL_SLAB.get())
			.add(IcariaBlocks.BAETYL_SLAB.get())
			.add(IcariaBlocks.BAETYL_BRICK_SLAB.get())
			.add(IcariaBlocks.RELICSTONE_SLAB.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE_SLAB.get())
			.add(IcariaBlocks.RELICSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_SLAB.get())
			.add(IcariaBlocks.RELICSTONE_TILE_SLAB.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_SLAB.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_SLAB.get())
			.add(IcariaBlocks.PLATOSHALE_SLAB.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_SLAB.get());

		this.tag(BlockTags.SMALL_FLOWERS)
			.add(IcariaBlocks.BLINDWEED.get())
			.add(IcariaBlocks.CHAMEOMILE.get())
			.add(IcariaBlocks.CHARMONDER.get())
			.add(IcariaBlocks.CLOVER.get())
			.add(IcariaBlocks.FIREHILT.get())
			.add(IcariaBlocks.BLUE_HYDRACINTH.get())
			.add(IcariaBlocks.PURPLE_HYDRACINTH.get())
			.add(IcariaBlocks.LIONFANGS.get())
			.add(IcariaBlocks.SPEARDROPS.get())
			.add(IcariaBlocks.PURPLE_STAGHORN.get())
			.add(IcariaBlocks.YELLOW_STAGHORN.get())
			.add(IcariaBlocks.BLUE_STORMCOTTON.get())
			.add(IcariaBlocks.PINK_STORMCOTTON.get())
			.add(IcariaBlocks.PURPLE_STORMCOTTON.get())
			.add(IcariaBlocks.SUNKETTLE.get())
			.add(IcariaBlocks.SUNSPONGE.get())
			.add(IcariaBlocks.VOIDLILY.get());

		this.tag(BlockTags.STAIRS)
			.add(IcariaBlocks.MARL_ADOBE_STAIRS.get())
			.add(IcariaBlocks.LOAM_BRICK_STAIRS.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_STAIRS.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.GRAINITE_STAIRS.get())
			.add(IcariaBlocks.GRAINITE_BRICK_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_STAIRS.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_STAIRS.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_STAIRS.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_STAIRS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_STAIRS.get())
			.add(IcariaBlocks.BAETYL_ADOBE_STAIRS.get())
			.add(IcariaBlocks.COBBLED_BAETYL_STAIRS.get())
			.add(IcariaBlocks.BAETYL_STAIRS.get())
			.add(IcariaBlocks.BAETYL_BRICK_STAIRS.get())
			.add(IcariaBlocks.RELICSTONE_STAIRS.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE_STAIRS.get())
			.add(IcariaBlocks.RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_STAIRS.get())
			.add(IcariaBlocks.RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_STAIRS.get())
			.add(IcariaBlocks.PLATOSHALE_STAIRS.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_STAIRS.get());

		this.tag(BlockTags.WALLS)
			.add(IcariaBlocks.MARL_ADOBE_WALL.get())
			.add(IcariaBlocks.LOAM_BRICK_WALL.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_WALL.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_WALL.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_WALL.get())
			.add(IcariaBlocks.GRAINITE_WALL.get())
			.add(IcariaBlocks.GRAINITE_BRICK_WALL.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_WALL.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE_WALL.get())
			.add(IcariaBlocks.YELLOWSTONE_WALL.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_WALL.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE_WALL.get())
			.add(IcariaBlocks.SILKSTONE_WALL.get())
			.add(IcariaBlocks.SILKSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_WALL.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE_WALL.get())
			.add(IcariaBlocks.SUNSTONE_WALL.get())
			.add(IcariaBlocks.SUNSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_WALL.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE_WALL.get())
			.add(IcariaBlocks.VOIDSHALE_WALL.get())
			.add(IcariaBlocks.VOIDSHALE_BRICK_WALL.get())
			.add(IcariaBlocks.BAETYL_ADOBE_WALL.get())
			.add(IcariaBlocks.COBBLED_BAETYL_WALL.get())
			.add(IcariaBlocks.BAETYL_WALL.get())
			.add(IcariaBlocks.BAETYL_BRICK_WALL.get())
			.add(IcariaBlocks.RELICSTONE_WALL.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE_WALL.get())
			.add(IcariaBlocks.RELICSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_WALL.get())
			.add(IcariaBlocks.RELICSTONE_TILE_WALL.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_WALL.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_WALL.get())
			.add(IcariaBlocks.PLATOSHALE_WALL.get())
			.add(IcariaBlocks.PLATOSHALE_BRICK_WALL.get())
			.add(IcariaBlocks.QUARTZ_WALL.get());

		this.tag(BlockTags.WOODEN_BUTTONS)
			.add(IcariaBlocks.CYPRESS_BUTTON.get())
			.add(IcariaBlocks.DROUGHTROOT_BUTTON.get())
			.add(IcariaBlocks.FIR_BUTTON.get())
			.add(IcariaBlocks.LAUREL_BUTTON.get())
			.add(IcariaBlocks.OLIVE_BUTTON.get())
			.add(IcariaBlocks.PLANE_BUTTON.get())
			.add(IcariaBlocks.POPULUS_BUTTON.get());

		this.tag(BlockTags.WOODEN_DOORS)
			.add(IcariaBlocks.CYPRESS_DOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_DOOR.get())
			.add(IcariaBlocks.FIR_DOOR.get())
			.add(IcariaBlocks.LAUREL_DOOR.get())
			.add(IcariaBlocks.OLIVE_DOOR.get())
			.add(IcariaBlocks.PLANE_DOOR.get())
			.add(IcariaBlocks.POPULUS_DOOR.get());

		this.tag(BlockTags.WOODEN_FENCES)
			.add(IcariaBlocks.CYPRESS_FENCE.get())
			.add(IcariaBlocks.DROUGHTROOT_FENCE.get())
			.add(IcariaBlocks.FIR_FENCE.get())
			.add(IcariaBlocks.LAUREL_FENCE.get())
			.add(IcariaBlocks.OLIVE_FENCE.get())
			.add(IcariaBlocks.PLANE_FENCE.get())
			.add(IcariaBlocks.POPULUS_FENCE.get());

		this.tag(BlockTags.FENCE_GATES)
			.add(IcariaBlocks.CYPRESS_FENCE_GATE.get())
			.add(IcariaBlocks.DROUGHTROOT_FENCE_GATE.get())
			.add(IcariaBlocks.FIR_FENCE_GATE.get())
			.add(IcariaBlocks.LAUREL_FENCE_GATE.get())
			.add(IcariaBlocks.OLIVE_FENCE_GATE.get())
			.add(IcariaBlocks.PLANE_FENCE_GATE.get())
			.add(IcariaBlocks.POPULUS_FENCE_GATE.get());

		this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
			.add(IcariaBlocks.CYPRESS_PRESSURE_PLATE.get())
			.add(IcariaBlocks.DROUGHTROOT_PRESSURE_PLATE.get())
			.add(IcariaBlocks.FIR_PRESSURE_PLATE.get())
			.add(IcariaBlocks.LAUREL_PRESSURE_PLATE.get())
			.add(IcariaBlocks.OLIVE_PRESSURE_PLATE.get())
			.add(IcariaBlocks.PLANE_PRESSURE_PLATE.get())
			.add(IcariaBlocks.POPULUS_PRESSURE_PLATE.get());

		this.tag(BlockTags.WOODEN_SLABS)
			.add(IcariaBlocks.CYPRESS_SLAB.get())
			.add(IcariaBlocks.DROUGHTROOT_SLAB.get())
			.add(IcariaBlocks.FIR_SLAB.get())
			.add(IcariaBlocks.LAUREL_SLAB.get())
			.add(IcariaBlocks.OLIVE_SLAB.get())
			.add(IcariaBlocks.PLANE_SLAB.get())
			.add(IcariaBlocks.POPULUS_SLAB.get());

		this.tag(BlockTags.WOODEN_STAIRS)
			.add(IcariaBlocks.CYPRESS_STAIRS.get())
			.add(IcariaBlocks.DROUGHTROOT_STAIRS.get())
			.add(IcariaBlocks.FIR_STAIRS.get())
			.add(IcariaBlocks.LAUREL_STAIRS.get())
			.add(IcariaBlocks.OLIVE_STAIRS.get())
			.add(IcariaBlocks.PLANE_STAIRS.get())
			.add(IcariaBlocks.POPULUS_STAIRS.get());

		this.tag(BlockTags.WOODEN_TRAPDOORS)
			.add(IcariaBlocks.CYPRESS_TRAPDOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaBlocks.FIR_TRAPDOOR.get())
			.add(IcariaBlocks.LAUREL_TRAPDOOR.get())
			.add(IcariaBlocks.OLIVE_TRAPDOOR.get())
			.add(IcariaBlocks.PLANE_TRAPDOOR.get())
			.add(IcariaBlocks.POPULUS_TRAPDOOR.get());

		this.tag(Tags.Blocks.BUDDING_BLOCKS)
			.add(IcariaBlocks.BUDDING_CALCITE.get())
			.add(IcariaBlocks.BUDDING_HALITE.get())
			.add(IcariaBlocks.BUDDING_JASPER.get())
			.add(IcariaBlocks.BUDDING_ZIRCON.get());

		this.tag(Tags.Blocks.CHAINS)
			.add(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());

		this.tag(Tags.Blocks.CHESTS_TRAPPED)
			.add(IcariaBlocks.TRAPPED_CHEST.get());

		this.tag(Tags.Blocks.CHESTS_WOODEN)
			.add(IcariaBlocks.CHEST.get())
			.add(IcariaBlocks.TRAPPED_CHEST.get());

		this.tag(Tags.Blocks.FENCE_GATES_WOODEN)
			.add(IcariaBlocks.CYPRESS_FENCE_GATE.get())
			.add(IcariaBlocks.DROUGHTROOT_FENCE_GATE.get())
			.add(IcariaBlocks.FIR_FENCE_GATE.get())
			.add(IcariaBlocks.LAUREL_FENCE_GATE.get())
			.add(IcariaBlocks.OLIVE_FENCE_GATE.get())
			.add(IcariaBlocks.PLANE_FENCE_GATE.get())
			.add(IcariaBlocks.POPULUS_FENCE_GATE.get());

		this.tag(Tags.Blocks.GLASS_BLOCKS_CHEAP)
			.add(IcariaBlocks.GRAINGLASS.get())
			.add(IcariaBlocks.SILKGLASS.get());

		this.tag(Tags.Blocks.GLASS_BLOCKS_COLORLESS)
			.add(IcariaBlocks.GRAINGLASS.get())
			.add(IcariaBlocks.SILKGLASS.get());

		this.tag(Tags.Blocks.GLASS_PANES_COLORLESS)
			.add(IcariaBlocks.GRAINGLASS_PANE.get())
			.add(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get())
			.add(IcariaBlocks.SILKGLASS_PANE.get())
			.add(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get());

		this.tag(Tags.Blocks.ORE_RATES_SINGULAR)
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get())
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get())
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get())
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get())
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get())
			.add(IcariaBlocks.MOLYBDENUM_ORE.get());

		this.tag(Tags.Blocks.ORES)
			.addTag(IcariaBlockTagsProvider.ORES_CHERT)
			.addTag(IcariaBlockTagsProvider.ORES_BONES)
			.addTag(IcariaBlockTagsProvider.ORES_LIGNITE)
			.addTag(IcariaBlockTagsProvider.ORES_CHALKOS)
			.addTag(IcariaBlockTagsProvider.ORES_KASSITEROS)
			.addTag(IcariaBlockTagsProvider.ORES_DOLOMITE)
			.addTag(IcariaBlockTagsProvider.ORES_VANADIUM)
			.addTag(IcariaBlockTagsProvider.ORES_SLIVER)
			.addTag(IcariaBlockTagsProvider.ORES_SIDEROS)
			.addTag(IcariaBlockTagsProvider.ORES_ANTHRACITE)
			.addTag(IcariaBlockTagsProvider.ORES_MOLYBDENUM)
			.addTag(IcariaBlockTagsProvider.ORES_HYLIASTRUM);

		this.tag(Tags.Blocks.PLAYER_WORKSTATIONS_CRAFTING_TABLES)
			.add(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get())
			.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaBlocks.FIR_CRAFTING_TABLE.get())
			.add(IcariaBlocks.LAUREL_CRAFTING_TABLE.get())
			.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.POPULUS_CRAFTING_TABLE.get());

		this.tag(Tags.Blocks.FLOWERS_SMALL)
			.add(IcariaBlocks.BLINDWEED.get())
			.add(IcariaBlocks.CHAMEOMILE.get())
			.add(IcariaBlocks.CHARMONDER.get())
			.add(IcariaBlocks.CLOVER.get())
			.add(IcariaBlocks.FIREHILT.get())
			.add(IcariaBlocks.BLUE_HYDRACINTH.get())
			.add(IcariaBlocks.PURPLE_HYDRACINTH.get())
			.add(IcariaBlocks.LIONFANGS.get())
			.add(IcariaBlocks.SPEARDROPS.get())
			.add(IcariaBlocks.PURPLE_STAGHORN.get())
			.add(IcariaBlocks.YELLOW_STAGHORN.get())
			.add(IcariaBlocks.BLUE_STORMCOTTON.get())
			.add(IcariaBlocks.PINK_STORMCOTTON.get())
			.add(IcariaBlocks.PURPLE_STORMCOTTON.get())
			.add(IcariaBlocks.SUNKETTLE.get())
			.add(IcariaBlocks.SUNSPONGE.get())
			.add(IcariaBlocks.VOIDLILY.get());

		this.tag(Tags.Blocks.STONES)
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE.get());

		this.tag(Tags.Blocks.STORAGE_BLOCKS)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ARISTONE)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ARACHNE_STRING)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_SPELT)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VINE_REED)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ROTTEN_BONES)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_CHALKOS)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_KASSITEROS)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_VANADIUM)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_SIDEROS)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_MOLYBDENUM)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_CALCITE)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_HALITE)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_JASPER)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ZIRCON)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_CHERT)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_LIGNITE)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_CHALKOS)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_KASSITEROS)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ORICHALCUM)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VANADIUM)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_SLIVER)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VANADIUMSTEEL)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_SIDEROS)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ANTHRACITE)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_MOLYBDENUM)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_MOLYBDENUMSTEEL)
			.addTag(IcariaBlockTagsProvider.STORAGE_BLOCKS_BLURIDIUM);

		this.tag(Tags.Blocks.STRIPPED_LOGS)
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(Tags.Blocks.STRIPPED_WOODS)
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());

		this.tag(IcariaBlockTagsProvider.LOGS_CYPRESS)
			.add(IcariaBlocks.CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());

		this.tag(IcariaBlockTagsProvider.LOGS_DROUGHTROOT)
			.add(IcariaBlocks.DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());

		this.tag(IcariaBlockTagsProvider.LOGS_FIR)
			.add(IcariaBlocks.FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.DEAD_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());

		this.tag(IcariaBlockTagsProvider.LOGS_LAUREL)
			.add(IcariaBlocks.LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());

		this.tag(IcariaBlockTagsProvider.LOGS_OLIVE)
			.add(IcariaBlocks.OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());

		this.tag(IcariaBlockTagsProvider.LOGS_PLANE)
			.add(IcariaBlocks.PLANE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get())
			.add(IcariaBlocks.PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_PLANE_LOG.get())
			.add(IcariaBlocks.DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());

		this.tag(IcariaBlockTagsProvider.LOGS_POPULUS)
			.add(IcariaBlocks.POPULUS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaBlocks.POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(IcariaBlockTagsProvider.ORE_BEARING_GROUNDS_MARL)
			.add(IcariaBlocks.MARL.get());

		this.tag(IcariaBlockTagsProvider.ORE_BEARING_GROUNDS_GRAINEL)
			.add(IcariaBlocks.GRAINEL.get());

		this.tag(IcariaBlockTagsProvider.ORE_BEARING_GROUNDS_YELLOWSTONE)
			.add(IcariaBlocks.YELLOWSTONE.get());

		this.tag(IcariaBlockTagsProvider.ORE_BEARING_GROUNDS_SILKSTONE)
			.add(IcariaBlocks.SILKSTONE.get());

		this.tag(IcariaBlockTagsProvider.ORE_BEARING_GROUNDS_SUNSTONE)
			.add(IcariaBlocks.SUNSTONE.get());

		this.tag(IcariaBlockTagsProvider.ORE_BEARING_GROUNDS_VOIDSHALE)
			.add(IcariaBlocks.VOIDSHALE.get());

		this.tag(IcariaBlockTagsProvider.ORE_BEARING_GROUNDS_BAETYL)
			.add(IcariaBlocks.BAETYL.get());

		this.tag(IcariaBlockTagsProvider.ORES_CHERT)
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get());

		this.tag(IcariaBlockTagsProvider.ORES_BONES)
			.add(IcariaBlocks.MARL_BONES.get());

		this.tag(IcariaBlockTagsProvider.ORES_LIGNITE)
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.LIGNITE_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_CHALKOS)
			.add(IcariaBlocks.CHALKOS_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_KASSITEROS)
			.add(IcariaBlocks.KASSITEROS_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_DOLOMITE)
			.add(IcariaBlocks.DOLOMITE_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_VANADIUM)
			.add(IcariaBlocks.VANADIUM_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_SLIVER)
			.add(IcariaBlocks.SLIVER_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_SIDEROS)
			.add(IcariaBlocks.SIDEROS_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_ANTHRACITE)
			.add(IcariaBlocks.ANTHRACITE_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_MOLYBDENUM)
			.add(IcariaBlocks.MOLYBDENUM_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_HYLIASTRUM)
			.add(IcariaBlocks.HYLIASTRUM_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_IN_GROUND_MARL)
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get());

		this.tag(IcariaBlockTagsProvider.ORES_IN_GROUND_GRAINEL)
			.add(IcariaBlocks.GRAINEL_CHERT.get());

		this.tag(IcariaBlockTagsProvider.ORES_IN_GROUND_YELLOWSTONE)
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_IN_GROUND_SILKSTONE)
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_IN_GROUND_SUNSTONE)
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_IN_GROUND_VOIDSHALE)
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get());

		this.tag(IcariaBlockTagsProvider.ORES_IN_GROUND_BAETYL)
			.add(IcariaBlocks.MOLYBDENUM_ORE.get())
			.add(IcariaBlocks.HYLIASTRUM_ORE.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ARISTONE)
			.add(IcariaBlocks.PACKED_ARISTONE.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY)
			.add(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY)
			.add(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY)
			.add(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY)
			.add(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY)
			.add(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ARACHNE_STRING)
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_SPELT)
			.add(IcariaBlocks.SPELT_BALE_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VINE_REED)
			.add(IcariaBlocks.VINE_REED_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ROTTEN_BONES)
			.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_CHALKOS)
			.add(IcariaBlocks.RAW_CHALKOS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_KASSITEROS)
			.add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_VANADIUM)
			.add(IcariaBlocks.RAW_VANADIUM_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_SIDEROS)
			.add(IcariaBlocks.RAW_SIDEROS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_RAW_MOLYBDENUM)
			.add(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_CALCITE)
			.add(IcariaBlocks.CALCITE_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_HALITE)
			.add(IcariaBlocks.HALITE_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_JASPER)
			.add(IcariaBlocks.JASPER_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ZIRCON)
			.add(IcariaBlocks.ZIRCON_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_CHERT)
			.add(IcariaBlocks.CHERT_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_LIGNITE)
			.add(IcariaBlocks.LIGNITE_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_CHALKOS)
			.add(IcariaBlocks.CHALKOS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_KASSITEROS)
			.add(IcariaBlocks.KASSITEROS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ORICHALCUM)
			.add(IcariaBlocks.ORICHALCUM_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VANADIUM)
			.add(IcariaBlocks.VANADIUM_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_SLIVER)
			.add(IcariaBlocks.SLIVER_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_VANADIUMSTEEL)
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_SIDEROS)
			.add(IcariaBlocks.SIDEROS_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_ANTHRACITE)
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_MOLYBDENUM)
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_MOLYBDENUMSTEEL)
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());

		this.tag(IcariaBlockTagsProvider.STORAGE_BLOCKS_BLURIDIUM)
			.add(IcariaBlocks.BLURIDIUM_BLOCK.get());
	}

	@Override
	public String getName() {
		return "Block Tags";
	}

	public static TagKey<Block> cKey(String pName) {
		return IcariaBlockTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Block> icariaKey(String pName) {
		return IcariaBlockTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<Block> createKey(String pName) {
		return TagKey.create(Registries.BLOCK, ResourceLocation.parse(pName));
	}
}
