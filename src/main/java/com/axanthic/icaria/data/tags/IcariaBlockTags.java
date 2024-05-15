package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockTags extends BlockTagsProvider {
	// BLOCK TAGS
	public static final TagKey<Block> SLUG_HIDE_BLOCKS = IcariaBlockTags.icariaTag("slug_hide_blocks");

	public static final TagKey<Block> MYRMEKE_SUMMONS_ON = IcariaBlockTags.icariaTag("myrmeke_summons_on");
	public static final TagKey<Block> CAPTAIN_SUMMONS_ON = IcariaBlockTags.icariaTag("captain_summons_on");

	public static final TagKey<Block> VILLAGE_REPLACE_BLOCKS = IcariaBlockTags.icariaTag("village_replace_blocks");
	public static final TagKey<Block> RUINED_VILLAGE_REPLACE_BLOCKS = IcariaBlockTags.icariaTag("ruined_village_replace_blocks");

	public static final TagKey<Block> ICARIA_TIER = IcariaBlockTags.icariaTag("icaria_tier");

	public static final TagKey<Block> NEEDS_CHERT_TOOL = IcariaBlockTags.icariaTag("needs_chert_tool");
	public static final TagKey<Block> NEEDS_CHALKOS_TOOL = IcariaBlockTags.icariaTag("needs_chalkos_tool");
	public static final TagKey<Block> NEEDS_KASSITEROS_TOOL = IcariaBlockTags.icariaTag("needs_kassiteros_tool");
	public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = IcariaBlockTags.icariaTag("needs_orichalcum_tool");
	public static final TagKey<Block> NEEDS_VANADIUMSTEEL_TOOL = IcariaBlockTags.icariaTag("needs_vanadiumsteel_tool");
	public static final TagKey<Block> NEEDS_SIDEROS_TOOL = IcariaBlockTags.icariaTag("needs_sideros_tool");
	public static final TagKey<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = IcariaBlockTags.icariaTag("needs_molybdenumsteel_tool");

	public static final TagKey<Block> MINEABLE_WITH_SCYTHE = IcariaBlockTags.icariaTag("mineable/scythe");

	public static final TagKey<Block> ICARIA_COBWEB_BLOCKS = IcariaBlockTags.icariaTag("icaria_cobweb_blocks");
	public static final TagKey<Block> ICARIA_GRASS_BLOCKS = IcariaBlockTags.icariaTag("icaria_grass_blocks");
	public static final TagKey<Block> ICARIA_PORTAL_BLOCKS = IcariaBlockTags.icariaTag("icaria_portal_blocks");

	public static final TagKey<Block> CYPRESS_RACKS = IcariaBlockTags.icariaTag("cypress_racks");
	public static final TagKey<Block> DROUGHTROOT_RACKS = IcariaBlockTags.icariaTag("droughtroot_racks");
	public static final TagKey<Block> FIR_RACKS = IcariaBlockTags.icariaTag("fir_racks");
	public static final TagKey<Block> LAUREL_RACKS = IcariaBlockTags.icariaTag("laurel_racks");
	public static final TagKey<Block> OLIVE_RACKS = IcariaBlockTags.icariaTag("olive_racks");
	public static final TagKey<Block> PLANE_RACKS = IcariaBlockTags.icariaTag("plane_racks");
	public static final TagKey<Block> POPULUS_RACKS = IcariaBlockTags.icariaTag("populus_racks");

	public static final TagKey<Block> LOADED_BARRELS = IcariaBlockTags.icariaTag("loaded_barrels");
	public static final TagKey<Block> TAPPED_BARRELS = IcariaBlockTags.icariaTag("tapped_barrels");

	public static final TagKey<Block> CYPRESS_BARRELS = IcariaBlockTags.icariaTag("cypress_barrels");
	public static final TagKey<Block> DROUGHTROOT_BARRELS = IcariaBlockTags.icariaTag("droughtroot_barrels");
	public static final TagKey<Block> FIR_BARRELS = IcariaBlockTags.icariaTag("fir_barrels");
	public static final TagKey<Block> LAUREL_BARRELS = IcariaBlockTags.icariaTag("laurel_barrels");
	public static final TagKey<Block> OLIVE_BARRELS = IcariaBlockTags.icariaTag("olive_barrels");
	public static final TagKey<Block> PLANE_BARRELS = IcariaBlockTags.icariaTag("plane_barrels");
	public static final TagKey<Block> POPULUS_BARRELS = IcariaBlockTags.icariaTag("populus_barrels");

	// ITEMBLOCK TAGS
	public static final TagKey<Block> ORES_CHERT = IcariaBlockTags.forgeTag("ores/chert");
	public static final TagKey<Block> ORES_LIGNITE = IcariaBlockTags.forgeTag("ores/lignite");
	public static final TagKey<Block> ORES_BLURIDIUM = IcariaBlockTags.forgeTag("ores/bluridium");

	public static final TagKey<Block> ORES_IN_GROUND_MARL = IcariaBlockTags.forgeTag("ores_in_ground/marl");
	public static final TagKey<Block> ORES_IN_GROUND_GRAINEL = IcariaBlockTags.forgeTag("ores_in_ground/grainel");
	public static final TagKey<Block> ORES_IN_GROUND_YELLOWSTONE = IcariaBlockTags.forgeTag("ores_in_ground/yellowstone");
	public static final TagKey<Block> ORES_IN_GROUND_SILKSTONE = IcariaBlockTags.forgeTag("ores_in_ground/silkstone");
	public static final TagKey<Block> ORES_IN_GROUND_SUNSTONE = IcariaBlockTags.forgeTag("ores_in_ground/sunstone");
	public static final TagKey<Block> ORES_IN_GROUND_VOIDSHALE = IcariaBlockTags.forgeTag("ores_in_ground/voidshale");
	public static final TagKey<Block> ORES_IN_GROUND_BAETYL = IcariaBlockTags.forgeTag("ores_in_ground/baetyl");
	public static final TagKey<Block> ORES_IN_GROUND_PLATOSHALE = IcariaBlockTags.forgeTag("ores_in_ground/platoshale");

	public static final TagKey<Block> ORE_BEARING_GROUND_MARL = IcariaBlockTags.forgeTag("ore_bearing_ground/marl");
	public static final TagKey<Block> ORE_BEARING_GROUND_GRAINEL = IcariaBlockTags.forgeTag("ore_bearing_ground/grainel");
	public static final TagKey<Block> ORE_BEARING_GROUND_YELLOWSTONE = IcariaBlockTags.forgeTag("ore_bearing_ground/yellowstone");
	public static final TagKey<Block> ORE_BEARING_GROUND_SILKSTONE = IcariaBlockTags.forgeTag("ore_bearing_ground/silkstone");
	public static final TagKey<Block> ORE_BEARING_GROUND_SUNSTONE = IcariaBlockTags.forgeTag("ore_bearing_ground/sunstone");
	public static final TagKey<Block> ORE_BEARING_GROUND_VOIDSHALE = IcariaBlockTags.forgeTag("ore_bearing_ground/voidshale");
	public static final TagKey<Block> ORE_BEARING_GROUND_BAETYL = IcariaBlockTags.forgeTag("ore_bearing_ground/baetyl");
	public static final TagKey<Block> ORE_BEARING_GROUND_PLATOSHALE = IcariaBlockTags.forgeTag("ore_bearing_ground/platoshale");
	public static final TagKey<Block> ORE_BEARING_GROUND_PLATOSHALE_BRICKS = IcariaBlockTags.forgeTag("ore_bearing_ground/platoshale_bricks");

	public static final TagKey<Block> STORAGE_BLOCKS_PACKED_ARISTONE = IcariaBlockTags.forgeTag("storage_blocks/packed_aristone");
	public static final TagKey<Block> STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY = IcariaBlockTags.forgeTag("storage_blocks/ender_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY = IcariaBlockTags.forgeTag("storage_blocks/fire_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY = IcariaBlockTags.forgeTag("storage_blocks/nature_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_VOID_JELLYFISH_JELLY = IcariaBlockTags.forgeTag("storage_blocks/void_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_WATER_JELLYFISH_JELLY = IcariaBlockTags.forgeTag("storage_blocks/water_jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_ARACHNE_STRING = IcariaBlockTags.forgeTag("storage_blocks/arachne_string");
	public static final TagKey<Block> STORAGE_BLOCKS_SPELT = IcariaBlockTags.forgeTag("storage_blocks/spelt");
	public static final TagKey<Block> STORAGE_BLOCKS_VINE_REED = IcariaBlockTags.forgeTag("storage_blocks/vine_reed");
	public static final TagKey<Block> STORAGE_BLOCKS_VINE_SPROUT = IcariaBlockTags.forgeTag("storage_blocks/vine_sprout");
	public static final TagKey<Block> STORAGE_BLOCKS_ROTTEN_BONES = IcariaBlockTags.forgeTag("storage_blocks/rotten_bones");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_CHALKOS = IcariaBlockTags.forgeTag("storage_blocks/raw_chalkos");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_KASSITEROS = IcariaBlockTags.forgeTag("storage_blocks/raw_kassiteros");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_VANADIUM = IcariaBlockTags.forgeTag("storage_blocks/raw_vanadium");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_SIDEROS = IcariaBlockTags.forgeTag("storage_blocks/raw_sideros");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_MOLYBDENUM = IcariaBlockTags.forgeTag("storage_blocks/raw_molybdenum");
	public static final TagKey<Block> STORAGE_BLOCKS_CALCITE = IcariaBlockTags.forgeTag("storage_blocks/calcite");
	public static final TagKey<Block> STORAGE_BLOCKS_HALITE = IcariaBlockTags.forgeTag("storage_blocks/halite");
	public static final TagKey<Block> STORAGE_BLOCKS_JASPER = IcariaBlockTags.forgeTag("storage_blocks/jasper");
	public static final TagKey<Block> STORAGE_BLOCKS_ZIRCON = IcariaBlockTags.forgeTag("storage_blocks/zircon");
	public static final TagKey<Block> STORAGE_BLOCKS_CHERT = IcariaBlockTags.forgeTag("storage_blocks/chert");
	public static final TagKey<Block> STORAGE_BLOCKS_LIGNITE = IcariaBlockTags.forgeTag("storage_blocks/lignite");
	public static final TagKey<Block> STORAGE_BLOCKS_CHALKOS = IcariaBlockTags.forgeTag("storage_blocks/chalkos");
	public static final TagKey<Block> STORAGE_BLOCKS_KASSITEROS = IcariaBlockTags.forgeTag("storage_blocks/kassiteros");
	public static final TagKey<Block> STORAGE_BLOCKS_ORICHALCUM = IcariaBlockTags.forgeTag("storage_blocks/orichalcum");
	public static final TagKey<Block> STORAGE_BLOCKS_VANADIUM = IcariaBlockTags.forgeTag("storage_blocks/vanadium");
	public static final TagKey<Block> STORAGE_BLOCKS_VANADIUMSTEEL = IcariaBlockTags.forgeTag("storage_blocks/vanadiumsteel");
	public static final TagKey<Block> STORAGE_BLOCKS_SLIVER = IcariaBlockTags.forgeTag("storage_blocks/sliver");
	public static final TagKey<Block> STORAGE_BLOCKS_SIDEROS = IcariaBlockTags.forgeTag("storage_blocks/sideros");
	public static final TagKey<Block> STORAGE_BLOCKS_ANTHRACITE = IcariaBlockTags.forgeTag("storage_blocks/anthracite");
	public static final TagKey<Block> STORAGE_BLOCKS_MOLYBDENUM = IcariaBlockTags.forgeTag("storage_blocks/molybdenum");
	public static final TagKey<Block> STORAGE_BLOCKS_MOLYBDENUMSTEEL = IcariaBlockTags.forgeTag("storage_blocks/molybdenumsteel");
	public static final TagKey<Block> STORAGE_BLOCKS_BLURIDIUM = IcariaBlockTags.forgeTag("storage_blocks/bluridium");

	public static final TagKey<Block> LOGS_CYPRESS = IcariaBlockTags.forgeTag("logs/cypress");
	public static final TagKey<Block> LOGS_DROUGHTROOT = IcariaBlockTags.forgeTag("logs/droughtroot");
	public static final TagKey<Block> LOGS_FIR = IcariaBlockTags.forgeTag("logs/fir");
	public static final TagKey<Block> LOGS_LAUREL = IcariaBlockTags.forgeTag("logs/laurel");
	public static final TagKey<Block> LOGS_OLIVE = IcariaBlockTags.forgeTag("logs/olive");
	public static final TagKey<Block> LOGS_PLANE = IcariaBlockTags.forgeTag("logs/plane");
	public static final TagKey<Block> LOGS_POPULUS = IcariaBlockTags.forgeTag("logs/populus");

	public IcariaBlockTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		// BLOCK TAGS
		this.tag(IcariaBlockTags.SLUG_HIDE_BLOCKS)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get());

		this.tag(IcariaBlockTags.MYRMEKE_SUMMONS_ON)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get());

		this.tag(IcariaBlockTags.CAPTAIN_SUMMONS_ON)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get());

		this.tag(IcariaBlockTags.VILLAGE_REPLACE_BLOCKS)
			.add(Blocks.COBWEB) // TODO: replace with Arachne web
			.add(Blocks.CHISELED_BOOKSHELF)
			.add(Blocks.FLOWER_POT)
			.add(Blocks.COMPOSTER)
			.add(Blocks.DECORATED_POT)
			.add(IcariaBlocks.SURFACE_LIGNITE.get())
			.add(IcariaBlocks.MARL_ADOBE.get())
			.add(IcariaBlocks.MARL_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.MARL_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.GRAINITE_ADOBE.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.GRAINITE_BRICKS.get())
			.add(IcariaBlocks.GRAINITE_BRICK_DECO.stairs.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.BAETYL_ADOBE.get())
			.add(IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get())
			.add(IcariaBlocks.BAETYL_ADOBE_DECO.slab.get())
			.add(IcariaBlocks.RELICSTONE_TILES.get())
			.add(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILES.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.stairs.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILES.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.stairs.get())
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
			.add(IcariaBlocks.CYPRESS_DECO.stairs.get())
			.add(IcariaBlocks.CYPRESS_DECO.slab.get())
			.add(IcariaBlocks.SIMPLE_CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_BARREL.get())
			.add(IcariaBlocks.LOADED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TAPPED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get())
			.add(IcariaBlocks.CYPRESS_WALL_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_PLANKS.get())
			.add(IcariaBlocks.DROUGHTROOT_DECO.slab.get())
			.add(IcariaBlocks.DROUGHTROOT_DECO.fence.get())
			.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaBlocks.DROUGHTROOT_DOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_LADDER.get())
			.add(IcariaBlocks.FIR_PLANKS.get())
			.add(IcariaBlocks.FIR_DECO.slab.get())
			.add(IcariaBlocks.FIR_DECO.fence.get())
			.add(IcariaBlocks.FIR_CRAFTING_TABLE.get())
			.add(IcariaBlocks.FIR_DOOR.get())
			.add(IcariaBlocks.FIR_TRAPDOOR.get())
			.add(IcariaBlocks.FIR_LADDER.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_DECO.stairs.get())
			.add(IcariaBlocks.LAUREL_DECO.slab.get())
			.add(IcariaBlocks.SIMPLE_LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_BARREL.get())
			.add(IcariaBlocks.LOADED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TAPPED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get())
			.add(IcariaBlocks.LAUREL_WALL_SIGN.get())
			.add(IcariaBlocks.OLIVE_PLANKS.get())
			.add(IcariaBlocks.OLIVE_DECO.slab.get())
			.add(IcariaBlocks.OLIVE_DECO.fence.get())
			.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.OLIVE_DOOR.get())
			.add(IcariaBlocks.OLIVE_TRAPDOOR.get())
			.add(IcariaBlocks.OLIVE_LADDER.get())
			.add(IcariaBlocks.PLANE_PLANKS.get())
			.add(IcariaBlocks.PLANE_DECO.slab.get())
			.add(IcariaBlocks.PLANE_DECO.fence.get())
			.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.PLANE_DOOR.get())
			.add(IcariaBlocks.PLANE_TRAPDOOR.get())
			.add(IcariaBlocks.PLANE_LADDER.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_DECO.stairs.get())
			.add(IcariaBlocks.POPULUS_DECO.slab.get())
			.add(IcariaBlocks.SIMPLE_POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_BARREL.get())
			.add(IcariaBlocks.LOADED_POPULUS_BARREL.get())
			.add(IcariaBlocks.TAPPED_POPULUS_BARREL.get())
			.add(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get())
			.add(IcariaBlocks.POPULUS_WALL_SIGN.get());

		this.tag(IcariaBlockTags.RUINED_VILLAGE_REPLACE_BLOCKS)
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

		this.tag(IcariaBlockTags.ICARIA_TIER)
			.addTag(IcariaBlockTags.NEEDS_CHERT_TOOL)
			.addTag(IcariaBlockTags.NEEDS_CHALKOS_TOOL)
			.addTag(IcariaBlockTags.NEEDS_KASSITEROS_TOOL)
			.addTag(IcariaBlockTags.NEEDS_ORICHALCUM_TOOL)
			.addTag(IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(IcariaBlockTags.NEEDS_SIDEROS_TOOL)
			.addTag(IcariaBlockTags.NEEDS_MOLYBDENUMSTEEL_TOOL);

		this.tag(IcariaBlockTags.NEEDS_CHERT_TOOL)
			.add(IcariaBlocks.YELLOWSTONE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_YELLOWSTONE.get())
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get())
			.add(IcariaBlocks.CALCITE_CRYSTAL.get())
			.add(IcariaBlocks.CALCITE.get())
			.add(IcariaBlocks.BUDDING_CALCITE.get())
			.add(IcariaBlocks.RAW_CHALKOS_BLOCK.get())
			.add(IcariaBlocks.CHALKOS_BLOCK.get());

		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHERT_TOOL, IcariaBlocks.YELLOWSTONE_ADOBE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHERT_TOOL, IcariaBlocks.COBBLED_YELLOWSTONE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHERT_TOOL, IcariaBlocks.YELLOWSTONE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHERT_TOOL, IcariaBlocks.YELLOWSTONE_BRICK_DECO);

		this.tag(IcariaBlockTags.NEEDS_CHALKOS_TOOL)
			.add(IcariaBlocks.DOLOMITE_ADOBE.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE.get())
			.add(IcariaBlocks.DOLOMITE_BRICKS.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.SILKGLASS.get())
			.add(IcariaBlocks.SILKGLASS_PANE.get())
			.add(IcariaBlocks.SILKGLASS.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_SILKSTONE.get())
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get())
			.add(IcariaBlocks.HALITE_CRYSTAL.get())
			.add(IcariaBlocks.HALITE.get())
			.add(IcariaBlocks.BUDDING_HALITE.get())
			.add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get())
			.add(IcariaBlocks.KASSITEROS_BLOCK.get());

		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHALKOS_TOOL, IcariaBlocks.DOLOMITE_ADOBE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHALKOS_TOOL, IcariaBlocks.SMOOTH_DOLOMITE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHALKOS_TOOL, IcariaBlocks.SILKSTONE_ADOBE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHALKOS_TOOL, IcariaBlocks.COBBLED_SILKSTONE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHALKOS_TOOL, IcariaBlocks.SILKSTONE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_CHALKOS_TOOL, IcariaBlocks.SILKSTONE_BRICK_DECO);

		this.tag(IcariaBlockTags.NEEDS_KASSITEROS_TOOL)
			.add(IcariaBlocks.ORICHALCUM_BLOCK.get());

		this.tag(IcariaBlockTags.NEEDS_ORICHALCUM_TOOL)
			.add(IcariaBlocks.SUNSTONE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_SUNSTONE.get())
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get())
			.add(IcariaBlocks.JASPER_CRYSTAL.get())
			.add(IcariaBlocks.JASPER.get())
			.add(IcariaBlocks.BUDDING_JASPER.get())
			.add(IcariaBlocks.RAW_VANADIUM_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());

		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_ORICHALCUM_TOOL, IcariaBlocks.SUNSTONE_ADOBE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_ORICHALCUM_TOOL, IcariaBlocks.COBBLED_SUNSTONE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_ORICHALCUM_TOOL, IcariaBlocks.SUNSTONE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_ORICHALCUM_TOOL, IcariaBlocks.SUNSTONE_BRICK_DECO);

		this.tag(IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL)
			.add(IcariaBlocks.VOIDSHALE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_VOIDSHALE.get())
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get())
			.add(IcariaBlocks.RAW_SIDEROS_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_BLOCK.get())
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get());

		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL, IcariaBlocks.VOIDSHALE_ADOBE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL, IcariaBlocks.COBBLED_VOIDSHALE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL, IcariaBlocks.VOIDSHALE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL, IcariaBlocks.VOIDSHALE_BRICK_DECO);

		this.tag(IcariaBlockTags.NEEDS_SIDEROS_TOOL)
			.add(IcariaBlocks.BAETYL_ADOBE.get())
			.add(IcariaBlocks.COBBLED_BAETYL.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.CHISELED_BAETYL.get())
			.add(IcariaBlocks.PLATOSHALE.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.PLATOSHALE_BRICKS.get())
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

		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_SIDEROS_TOOL, IcariaBlocks.BAETYL_ADOBE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_SIDEROS_TOOL, IcariaBlocks.COBBLED_BAETYL_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_SIDEROS_TOOL, IcariaBlocks.BAETYL_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_SIDEROS_TOOL, IcariaBlocks.BAETYL_BRICK_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_SIDEROS_TOOL, IcariaBlocks.PLATOSHALE_DECO);
		this.stoneDecoBlocksTag(IcariaBlockTags.NEEDS_SIDEROS_TOOL, IcariaBlocks.PLATOSHALE_BRICK_DECO);

		this.tag(IcariaBlockTags.NEEDS_MOLYBDENUMSTEEL_TOOL);

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
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get());

		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(IcariaBlocks.MARL_ADOBE.get())
			.add(IcariaBlocks.LOAM_BRICKS.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE.get())
			.add(IcariaBlocks.DOLOMITE_BRICKS.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.GRAINITE_ADOBE.get())
			.add(IcariaBlocks.GRAINITE.get())
			.add(IcariaBlocks.GRAINITE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_GRAINITE.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_YELLOWSTONE.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_SILKSTONE.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_SUNSTONE.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.CHISELED_VOIDSHALE.get())
			.add(IcariaBlocks.BAETYL_ADOBE.get())
			.add(IcariaBlocks.COBBLED_BAETYL.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.CHISELED_BAETYL.get())
			.add(IcariaBlocks.RELICSTONE.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.RELICSTONE_TILES.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILES.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILES.get())
			.add(IcariaBlocks.CHISELED_RELICSTONE.get())
			.add(IcariaBlocks.RELICSTONE_PILLAR.get())
			.add(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get())
			.add(IcariaBlocks.PLATOSHALE.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.PLATOSHALE_BRICKS.get())
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
			.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get())
			.add(IcariaBlocks.RAW_CHALKOS_BLOCK.get())
			.add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get())
			.add(IcariaBlocks.RAW_VANADIUM_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
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
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_BLOCK.get())
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.BLURIDIUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get())
			.add(IcariaBlocks.VANADIUMSTEEL_CHAIN.get())
			.add(IcariaBlocks.KETTLE.get())
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
			.add(IcariaBlocks.ARACHNE_SPAWNER.get())
			.add(IcariaBlocks.REVENANT_SPAWNER.get());

		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.MARL_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.LOAM_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.DOLOMITE_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SMOOTH_DOLOMITE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.GRAINITE_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.GRAINITE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.GRAINITE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.YELLOWSTONE_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.COBBLED_YELLOWSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.YELLOWSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.YELLOWSTONE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SILKSTONE_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.COBBLED_SILKSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SILKSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SILKSTONE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SUNSTONE_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.COBBLED_SUNSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SUNSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SUNSTONE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.VOIDSHALE_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.COBBLED_VOIDSHALE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.VOIDSHALE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.VOIDSHALE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.BAETYL_ADOBE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.COBBLED_BAETYL_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.BAETYL_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.BAETYL_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.RELICSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.SMOOTH_RELICSTONE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.RELICSTONE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.RELICSTONE_TILE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.PLATOSHALE_DECO);
		this.stoneDecoBlocksTag(BlockTags.MINEABLE_WITH_PICKAXE, IcariaBlocks.PLATOSHALE_BRICK_DECO);

		this.tag(BlockTags.MINEABLE_WITH_AXE)
			.add(IcariaBlocks.VINE_REED_BLOCK.get())
			.add(IcariaBlocks.CHEST.get())
			.add(IcariaBlocks.TRAPPED_CHEST.get())
			.add(IcariaBlocks.CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.CYPRESS_PLANKS.get())
			.add(IcariaBlocks.CYPRESS_TROUGH.get())
			.add(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get())
			.add(IcariaBlocks.CYPRESS_DOOR.get())
			.add(IcariaBlocks.CYPRESS_TRAPDOOR.get())
			.add(IcariaBlocks.CYPRESS_LADDER.get())
			.add(IcariaBlocks.CYPRESS_SIGN.get())
			.add(IcariaBlocks.CYPRESS_WALL_SIGN.get())
			.add(IcariaBlocks.CYPRESS_HANGING_SIGN.get())
			.add(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DROUGHTROOT_PLANKS.get())
			.add(IcariaBlocks.DROUGHTROOT_TROUGH.get())
			.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaBlocks.DROUGHTROOT_DOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_LADDER.get())
			.add(IcariaBlocks.DROUGHTROOT_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.DEAD_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get())
			.add(IcariaBlocks.FIR_PLANKS.get())
			.add(IcariaBlocks.FIR_TROUGH.get())
			.add(IcariaBlocks.FIR_CRAFTING_TABLE.get())
			.add(IcariaBlocks.FIR_DOOR.get())
			.add(IcariaBlocks.FIR_TRAPDOOR.get())
			.add(IcariaBlocks.FIR_LADDER.get())
			.add(IcariaBlocks.FIR_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_SIGN.get())
			.add(IcariaBlocks.FIR_HANGING_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_PLANKS.get())
			.add(IcariaBlocks.LAUREL_TROUGH.get())
			.add(IcariaBlocks.LAUREL_CRAFTING_TABLE.get())
			.add(IcariaBlocks.LAUREL_DOOR.get())
			.add(IcariaBlocks.LAUREL_TRAPDOOR.get())
			.add(IcariaBlocks.LAUREL_LADDER.get())
			.add(IcariaBlocks.LAUREL_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_SIGN.get())
			.add(IcariaBlocks.LAUREL_HANGING_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.OLIVE_PLANKS.get())
			.add(IcariaBlocks.OLIVE_TROUGH.get())
			.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.OLIVE_DOOR.get())
			.add(IcariaBlocks.OLIVE_TRAPDOOR.get())
			.add(IcariaBlocks.OLIVE_LADDER.get())
			.add(IcariaBlocks.OLIVE_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_SIGN.get())
			.add(IcariaBlocks.OLIVE_HANGING_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.PLANE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get())
			.add(IcariaBlocks.PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_PLANE_LOG.get())
			.add(IcariaBlocks.DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.PLANE_PLANKS.get())
			.add(IcariaBlocks.PLANE_TROUGH.get())
			.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.PLANE_DOOR.get())
			.add(IcariaBlocks.PLANE_TRAPDOOR.get())
			.add(IcariaBlocks.PLANE_LADDER.get())
			.add(IcariaBlocks.PLANE_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_SIGN.get())
			.add(IcariaBlocks.PLANE_HANGING_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.POPULUS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaBlocks.POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_PLANKS.get())
			.add(IcariaBlocks.POPULUS_TROUGH.get())
			.add(IcariaBlocks.POPULUS_CRAFTING_TABLE.get())
			.add(IcariaBlocks.POPULUS_DOOR.get())
			.add(IcariaBlocks.POPULUS_TRAPDOOR.get())
			.add(IcariaBlocks.POPULUS_LADDER.get())
			.add(IcariaBlocks.POPULUS_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_SIGN.get())
			.add(IcariaBlocks.POPULUS_HANGING_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get());

		this.woodDecoBlocksTag(BlockTags.MINEABLE_WITH_AXE, IcariaBlocks.CYPRESS_DECO);
		this.woodDecoBlocksTag(BlockTags.MINEABLE_WITH_AXE, IcariaBlocks.DROUGHTROOT_DECO);
		this.woodDecoBlocksTag(BlockTags.MINEABLE_WITH_AXE, IcariaBlocks.FIR_DECO);
		this.woodDecoBlocksTag(BlockTags.MINEABLE_WITH_AXE, IcariaBlocks.LAUREL_DECO);
		this.woodDecoBlocksTag(BlockTags.MINEABLE_WITH_AXE, IcariaBlocks.OLIVE_DECO);
		this.woodDecoBlocksTag(BlockTags.MINEABLE_WITH_AXE, IcariaBlocks.PLANE_DECO);
		this.woodDecoBlocksTag(BlockTags.MINEABLE_WITH_AXE, IcariaBlocks.POPULUS_DECO);

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

		this.tag(IcariaBlockTags.MINEABLE_WITH_SCYTHE)
			.addTag(BlockTags.CROPS)
			.addTag(BlockTags.MINEABLE_WITH_HOE)
			.addTag(BlockTags.REPLACEABLE);

		this.tag(IcariaBlockTags.ICARIA_COBWEB_BLOCKS) // TODO: add Arachne web block
			.add(Blocks.COBWEB);

		this.tag(IcariaBlockTags.ICARIA_GRASS_BLOCKS)
			.add(IcariaBlocks.SMALL_GRASS.get())
			.add(IcariaBlocks.MEDIUM_GRASS.get())
			.add(IcariaBlocks.LARGE_GRASS.get());

		this.tag(IcariaBlockTags.ICARIA_PORTAL_BLOCKS)
			.add(Blocks.QUARTZ_SLAB)
			.add(Blocks.SMOOTH_QUARTZ_SLAB)
			.add(Blocks.QUARTZ_PILLAR)
			.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get())
			.add(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.RELICSTONE_DECO.slab.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get())
			.add(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get())
			.add(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get())
			.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get())
			.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get());

		this.tag(BlockTags.SAND)
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get())
			.add(IcariaBlocks.SILKSAND.get());

		this.tag(BlockTags.CRYSTAL_SOUND_BLOCKS)
			.add(IcariaBlocks.CALCITE.get())
			.add(IcariaBlocks.BUDDING_CALCITE.get())
			.add(IcariaBlocks.HALITE.get())
			.add(IcariaBlocks.BUDDING_HALITE.get())
			.add(IcariaBlocks.JASPER.get())
			.add(IcariaBlocks.BUDDING_JASPER.get())
			.add(IcariaBlocks.ZIRCON.get())
			.add(IcariaBlocks.BUDDING_ZIRCON.get());

		this.tag(BlockTags.OCCLUDES_VIBRATION_SIGNALS)
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get());

		this.tag(BlockTags.WALL_POST_OVERRIDE)
			.add(IcariaBlocks.LIGNITE_TORCH.get())
			.add(IcariaBlocks.ANTHRACITE_TORCH.get());

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

		this.tag(IcariaBlockTags.CYPRESS_RACKS)
			.add(IcariaBlocks.SIMPLE_CYPRESS_RACK.get())
			.add(IcariaBlocks.CYPRESS_RACK.get());

		this.tag(IcariaBlockTags.DROUGHTROOT_RACKS)
			.add(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get())
			.add(IcariaBlocks.DROUGHTROOT_RACK.get());

		this.tag(IcariaBlockTags.FIR_RACKS)
			.add(IcariaBlocks.SIMPLE_FIR_RACK.get())
			.add(IcariaBlocks.FIR_RACK.get());

		this.tag(IcariaBlockTags.LAUREL_RACKS)
			.add(IcariaBlocks.SIMPLE_LAUREL_RACK.get())
			.add(IcariaBlocks.LAUREL_RACK.get());

		this.tag(IcariaBlockTags.OLIVE_RACKS)
			.add(IcariaBlocks.SIMPLE_OLIVE_RACK.get())
			.add(IcariaBlocks.OLIVE_RACK.get());

		this.tag(IcariaBlockTags.PLANE_RACKS)
			.add(IcariaBlocks.SIMPLE_PLANE_RACK.get())
			.add(IcariaBlocks.PLANE_RACK.get());

		this.tag(IcariaBlockTags.POPULUS_RACKS)
			.add(IcariaBlocks.SIMPLE_POPULUS_RACK.get())
			.add(IcariaBlocks.POPULUS_RACK.get());

		this.tag(IcariaBlockTags.LOADED_BARRELS)
			.add(IcariaBlocks.LOADED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.LOADED_FIR_BARREL.get())
			.add(IcariaBlocks.LOADED_LAUREL_BARREL.get())
			.add(IcariaBlocks.LOADED_OLIVE_BARREL.get())
			.add(IcariaBlocks.LOADED_PLANE_BARREL.get())
			.add(IcariaBlocks.LOADED_POPULUS_BARREL.get());

		this.tag(IcariaBlockTags.TAPPED_BARRELS)
			.add(IcariaBlocks.TAPPED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.TAPPED_FIR_BARREL.get())
			.add(IcariaBlocks.TAPPED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TAPPED_OLIVE_BARREL.get())
			.add(IcariaBlocks.TAPPED_PLANE_BARREL.get())
			.add(IcariaBlocks.TAPPED_POPULUS_BARREL.get());

		this.tag(IcariaBlockTags.CYPRESS_BARRELS)
			.add(IcariaBlocks.CYPRESS_BARREL.get())
			.add(IcariaBlocks.LOADED_CYPRESS_BARREL.get())
			.add(IcariaBlocks.TAPPED_CYPRESS_BARREL.get());

		this.tag(IcariaBlockTags.DROUGHTROOT_BARRELS)
			.add(IcariaBlocks.DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get())
			.add(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get());

		this.tag(IcariaBlockTags.FIR_BARRELS)
			.add(IcariaBlocks.FIR_BARREL.get())
			.add(IcariaBlocks.LOADED_FIR_BARREL.get())
			.add(IcariaBlocks.TAPPED_FIR_BARREL.get());

		this.tag(IcariaBlockTags.LAUREL_BARRELS)
			.add(IcariaBlocks.LAUREL_BARREL.get())
			.add(IcariaBlocks.LOADED_LAUREL_BARREL.get())
			.add(IcariaBlocks.TAPPED_LAUREL_BARREL.get());

		this.tag(IcariaBlockTags.OLIVE_BARRELS)
			.add(IcariaBlocks.OLIVE_BARREL.get())
			.add(IcariaBlocks.LOADED_OLIVE_BARREL.get())
			.add(IcariaBlocks.TAPPED_OLIVE_BARREL.get());

		this.tag(IcariaBlockTags.PLANE_BARRELS)
			.add(IcariaBlocks.PLANE_BARREL.get())
			.add(IcariaBlocks.LOADED_PLANE_BARREL.get())
			.add(IcariaBlocks.TAPPED_PLANE_BARREL.get());

		this.tag(IcariaBlockTags.POPULUS_BARRELS)
			.add(IcariaBlocks.POPULUS_BARREL.get())
			.add(IcariaBlocks.LOADED_POPULUS_BARREL.get())
			.add(IcariaBlocks.TAPPED_POPULUS_BARREL.get());

		this.tag(BlockTags.CLIMBABLE)
			.add(IcariaBlocks.CYPRESS_LADDER.get())
			.add(IcariaBlocks.DROUGHTROOT_LADDER.get())
			.add(IcariaBlocks.FIR_LADDER.get())
			.add(IcariaBlocks.LAUREL_LADDER.get())
			.add(IcariaBlocks.OLIVE_LADDER.get())
			.add(IcariaBlocks.PLANE_LADDER.get())
			.add(IcariaBlocks.POPULUS_LADDER.get())
			.add(IcariaBlocks.DEAD_BLOOMY_VINE.get())
			.add(IcariaBlocks.GROWING_BLOOMY_VINE.get())
			.add(IcariaBlocks.BLOOMY_VINE.get())
			.add(IcariaBlocks.BLOOMING_BLOOMY_VINE.get())
			.add(IcariaBlocks.RIPE_BLOOMY_VINE.get())
			.add(IcariaBlocks.DEAD_BRANCHY_VINE.get())
			.add(IcariaBlocks.GROWING_BRANCHY_VINE.get())
			.add(IcariaBlocks.BRANCHY_VINE.get())
			.add(IcariaBlocks.DEAD_BRUSHY_VINE.get())
			.add(IcariaBlocks.GROWING_BRUSHY_VINE.get())
			.add(IcariaBlocks.RIPE_BRUSHY_VINE.get())
			.add(IcariaBlocks.BRUSHY_VINE.get())
			.add(IcariaBlocks.DEAD_DRY_VINE.get())
			.add(IcariaBlocks.GROWING_DRY_VINE.get())
			.add(IcariaBlocks.DRY_VINE.get())
			.add(IcariaBlocks.DEAD_REEDY_VINE.get())
			.add(IcariaBlocks.GROWING_REEDY_VINE.get())
			.add(IcariaBlocks.REEDY_VINE.get())
			.add(IcariaBlocks.DEAD_SWIRLY_VINE.get())
			.add(IcariaBlocks.GROWING_SWIRLY_VINE.get())
			.add(IcariaBlocks.SWIRLY_VINE.get())
			.add(IcariaBlocks.DEAD_THORNY_VINE.get())
			.add(IcariaBlocks.GROWING_THORNY_VINE.get())
			.add(IcariaBlocks.THORNY_VINE.get());

		this.tag(BlockTags.STANDING_SIGNS)
			.add(IcariaBlocks.CYPRESS_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_SIGN.get())
			.add(IcariaBlocks.FIR_SIGN.get())
			.add(IcariaBlocks.LAUREL_SIGN.get())
			.add(IcariaBlocks.OLIVE_SIGN.get())
			.add(IcariaBlocks.PLANE_SIGN.get())
			.add(IcariaBlocks.POPULUS_SIGN.get());

		this.tag(BlockTags.WALL_SIGNS)
			.add(IcariaBlocks.CYPRESS_WALL_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_SIGN.get());

		this.tag(BlockTags.CEILING_HANGING_SIGNS)
			.add(IcariaBlocks.CYPRESS_HANGING_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get())
			.add(IcariaBlocks.FIR_HANGING_SIGN.get())
			.add(IcariaBlocks.LAUREL_HANGING_SIGN.get())
			.add(IcariaBlocks.OLIVE_HANGING_SIGN.get())
			.add(IcariaBlocks.PLANE_HANGING_SIGN.get())
			.add(IcariaBlocks.POPULUS_HANGING_SIGN.get());

		this.tag(BlockTags.WALL_HANGING_SIGNS)
			.add(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get());

		this.tag(BlockTags.REPLACEABLE)
			.add(IcariaBlocks.DEAD_BLOOMY_VINE.get())
			.add(IcariaBlocks.GROWING_BLOOMY_VINE.get())
			.add(IcariaBlocks.BLOOMY_VINE.get())
			.add(IcariaBlocks.BLOOMING_BLOOMY_VINE.get())
			.add(IcariaBlocks.RIPE_BLOOMY_VINE.get())
			.add(IcariaBlocks.DEAD_BRANCHY_VINE.get())
			.add(IcariaBlocks.GROWING_BRANCHY_VINE.get())
			.add(IcariaBlocks.BRANCHY_VINE.get())
			.add(IcariaBlocks.DEAD_BRUSHY_VINE.get())
			.add(IcariaBlocks.GROWING_BRUSHY_VINE.get())
			.add(IcariaBlocks.RIPE_BRUSHY_VINE.get())
			.add(IcariaBlocks.BRUSHY_VINE.get())
			.add(IcariaBlocks.DEAD_DRY_VINE.get())
			.add(IcariaBlocks.GROWING_DRY_VINE.get())
			.add(IcariaBlocks.DRY_VINE.get())
			.add(IcariaBlocks.DEAD_REEDY_VINE.get())
			.add(IcariaBlocks.GROWING_REEDY_VINE.get())
			.add(IcariaBlocks.REEDY_VINE.get())
			.add(IcariaBlocks.DEAD_SWIRLY_VINE.get())
			.add(IcariaBlocks.GROWING_SWIRLY_VINE.get())
			.add(IcariaBlocks.SWIRLY_VINE.get())
			.add(IcariaBlocks.DEAD_THORNY_VINE.get())
			.add(IcariaBlocks.GROWING_THORNY_VINE.get())
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
			.add(IcariaBlocks.LARGE_BROWN_GRAIN.get())
			.add(IcariaBlocks.BLUE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.CYAN_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PINK_GROUND_FLOWERS.get())
			.add(IcariaBlocks.PURPLE_GROUND_FLOWERS.get())
			.add(IcariaBlocks.RED_GROUND_FLOWERS.get())
			.add(IcariaBlocks.WHITE_GROUND_FLOWERS.get());

		this.tag(BlockTags.CROPS)
			.add(IcariaBlocks.SPELT_CROP.get())
			.add(IcariaBlocks.STRAWBERRY_CROP.get())
			.add(IcariaBlocks.PHYSALIS_CROP.get())
			.add(IcariaBlocks.ONION_CROP.get());

		this.tag(BlockTags.FIRE)
			.add(IcariaBlocks.GREEK_FIRE.get());

		this.tag(BlockTags.PORTALS)
			.add(IcariaBlocks.ICARIA_PORTAL.get());

		// ITEMBLOCK TAGS
		for (var items : IcariaStoneDecoItems.STONE_DECO_ITEMS) {
			this.tag(BlockTags.STAIRS).add(items.block.stairs.get());
			this.tag(BlockTags.SLABS).add(items.block.slab.get());
			this.tag(BlockTags.WALLS).add(items.block.wall.get());
		}

		for (var items : IcariaWoodDecoItems.WOOD_DECO_ITEMS) {
			this.tag(BlockTags.WOODEN_STAIRS).add(items.block.stairs.get());
			this.tag(BlockTags.WOODEN_SLABS).add(items.block.slab.get());
			this.tag(BlockTags.WOODEN_FENCES).add(items.block.fence.get());
			this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(items.block.gate.get());
		}

		this.tag(BlockTags.DIRT)
			.add(IcariaBlocks.GRASSY_MARL.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.COARSE_MARL.get())
			.add(IcariaBlocks.DRY_LAKE_BED.get())
			.add(IcariaBlocks.LOAM.get());

		this.tag(IcariaBlockTags.ORES_CHERT)
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get());

		this.tag(IcariaBlockTags.ORES_LIGNITE)
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.LIGNITE_ORE.get());

		this.tag(IcariaBlockTags.ORES_BLURIDIUM)
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get());

		this.tag(Tags.Blocks.ORES)
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get())
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get())
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get())
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get())
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get())
			.add(IcariaBlocks.MOLYBDENUM_ORE.get())
			.add(IcariaBlocks.HYLIASTRUM_ORE.get());

		this.tag(Tags.Blocks.ORE_RATES_SINGULAR)
			.add(IcariaBlocks.MARL_CHERT.get())
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

		this.tag(Tags.Blocks.ORE_RATES_DENSE)
			.add(IcariaBlocks.MARL_BONES.get());

		this.tag(Tags.Blocks.ORE_RATES_SPARSE)
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_MARL)
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_GRAINEL)
			.add(IcariaBlocks.GRAINEL_CHERT.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_YELLOWSTONE)
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_SILKSTONE)
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_SUNSTONE)
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_VOIDSHALE)
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_BAETYL)
			.add(IcariaBlocks.MOLYBDENUM_ORE.get())
			.add(IcariaBlocks.HYLIASTRUM_ORE.get());

		this.tag(IcariaBlockTags.ORES_IN_GROUND_PLATOSHALE)
			.add(IcariaBlocks.BLURRED_PLATOSHALE.get())
			.add(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get());

		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_MARL).add(IcariaBlocks.MARL.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_GRAINEL).add(IcariaBlocks.GRAINEL.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_YELLOWSTONE).add(IcariaBlocks.YELLOWSTONE.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_SILKSTONE).add(IcariaBlocks.SILKSTONE.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_SUNSTONE).add(IcariaBlocks.SUNSTONE.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_VOIDSHALE).add(IcariaBlocks.VOIDSHALE.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_BAETYL).add(IcariaBlocks.BAETYL.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_PLATOSHALE).add(IcariaBlocks.PLATOSHALE.get());
		this.tag(IcariaBlockTags.ORE_BEARING_GROUND_PLATOSHALE_BRICKS).add(IcariaBlocks.PLATOSHALE_BRICKS.get());

		this.tag(Tags.Blocks.GLASS_COLORLESS)
			.add(IcariaBlocks.GRAINGLASS.get())
			.add(IcariaBlocks.SILKGLASS.get());

		this.tag(Tags.Blocks.GLASS_PANES_COLORLESS)
			.add(IcariaBlocks.GRAINGLASS_PANE.get())
			.add(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get())
			.add(IcariaBlocks.SILKGLASS_PANE.get())
			.add(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get());

		this.tag(Tags.Blocks.COBBLESTONE_NORMAL)
			.add(IcariaBlocks.COBBLED_YELLOWSTONE.get())
			.add(IcariaBlocks.COBBLED_SILKSTONE.get())
			.add(IcariaBlocks.COBBLED_SUNSTONE.get())
			.add(IcariaBlocks.COBBLED_VOIDSHALE.get())
			.add(IcariaBlocks.COBBLED_BAETYL.get())
			.add(IcariaBlocks.RELICSTONE.get())
			.add(IcariaBlocks.PLATOSHALE.get());

		this.tag(Tags.Blocks.STONE)
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.SMOOTH_RELICSTONE.get());

		this.tag(BlockTags.STONE_BRICKS)
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.PLATOSHALE_BRICKS.get());

		this.tag(IcariaBlockTags.STORAGE_BLOCKS_PACKED_ARISTONE).add(IcariaBlocks.PACKED_ARISTONE.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY).add(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY).add(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY).add(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY).add(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY).add(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_ARACHNE_STRING).add(IcariaBlocks.ARACHNE_STRING_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_SPELT).add(IcariaBlocks.SPELT_BALE_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_VINE_REED).add(IcariaBlocks.VINE_REED_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_ROTTEN_BONES).add(IcariaBlocks.ROTTEN_BONES_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_RAW_CHALKOS).add(IcariaBlocks.RAW_CHALKOS_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_RAW_KASSITEROS).add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_RAW_VANADIUM).add(IcariaBlocks.RAW_VANADIUM_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_SLIVER).add(IcariaBlocks.SLIVER_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_RAW_SIDEROS).add(IcariaBlocks.RAW_SIDEROS_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_RAW_MOLYBDENUM).add(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_CALCITE).add(IcariaBlocks.CALCITE_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_HALITE).add(IcariaBlocks.HALITE_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_JASPER).add(IcariaBlocks.JASPER_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_ZIRCON).add(IcariaBlocks.ZIRCON_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_CHERT).add(IcariaBlocks.CHERT_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_LIGNITE).add(IcariaBlocks.LIGNITE_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_CHALKOS).add(IcariaBlocks.CHALKOS_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_KASSITEROS).add(IcariaBlocks.KASSITEROS_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_ORICHALCUM).add(IcariaBlocks.ORICHALCUM_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_VANADIUM).add(IcariaBlocks.VANADIUM_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_VANADIUMSTEEL).add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_SIDEROS).add(IcariaBlocks.SIDEROS_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_ANTHRACITE).add(IcariaBlocks.ANTHRACITE_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_MOLYBDENUM).add(IcariaBlocks.MOLYBDENUM_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_MOLYBDENUMSTEEL).add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());
		this.tag(IcariaBlockTags.STORAGE_BLOCKS_BLURIDIUM).add(IcariaBlocks.BLURIDIUM_BLOCK.get());

		this.tag(Tags.Blocks.STORAGE_BLOCKS)
			.add(IcariaBlocks.PACKED_ARISTONE.get())
			.add(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get())
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get())
			.add(IcariaBlocks.SPELT_BALE_BLOCK.get())
			.add(IcariaBlocks.VINE_REED_BLOCK.get())
			.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get())
			.add(IcariaBlocks.RAW_CHALKOS_BLOCK.get())
			.add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get())
			.add(IcariaBlocks.RAW_VANADIUM_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
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
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_BLOCK.get())
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.BLURIDIUM_BLOCK.get());

		this.tag(BlockTags.DAMPENS_VIBRATIONS)
			.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get());

		this.tag(Tags.Blocks.CHESTS_WOODEN)
			.add(IcariaBlocks.CHEST.get())
			.add(IcariaBlocks.TRAPPED_CHEST.get());

		this.tag(Tags.Blocks.CHESTS_TRAPPED)
			.add(IcariaBlocks.TRAPPED_CHEST.get());

		this.tag(BlockTags.SAPLINGS)
			.add(IcariaBlocks.CYPRESS_SAPLING.get())
			.add(IcariaBlocks.DROUGHTROOT_SAPLING.get())
			.add(IcariaBlocks.FIR_SAPLING.get())
			.add(IcariaBlocks.LAUREL_SAPLING.get())
			.add(IcariaBlocks.OLIVE_SAPLING.get())
			.add(IcariaBlocks.PLANE_SAPLING.get())
			.add(IcariaBlocks.POPULUS_SAPLING.get());

		this.tag(BlockTags.LEAVES)
			.add(IcariaBlocks.CYPRESS_LEAVES.get())
			.add(IcariaBlocks.DROUGHTROOT_LEAVES.get())
			.add(IcariaBlocks.FIR_LEAVES.get())
			.add(IcariaBlocks.LAUREL_LEAVES.get())
			.add(IcariaBlocks.OLIVE_LEAVES.get())
			.add(IcariaBlocks.PLANE_LEAVES.get())
			.add(IcariaBlocks.POPULUS_LEAVES.get());

		this.tag(IcariaBlockTags.LOGS_CYPRESS)
			.add(IcariaBlocks.CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());

		this.tag(IcariaBlockTags.LOGS_DROUGHTROOT)
			.add(IcariaBlocks.DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());

		this.tag(IcariaBlockTags.LOGS_FIR)
			.add(IcariaBlocks.FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.DEAD_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());

		this.tag(IcariaBlockTags.LOGS_LAUREL)
			.add(IcariaBlocks.LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());

		this.tag(IcariaBlockTags.LOGS_OLIVE)
			.add(IcariaBlocks.OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());

		this.tag(IcariaBlockTags.LOGS_PLANE)
			.add(IcariaBlocks.PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_PLANE_LOG.get())
			.add(IcariaBlocks.PLANE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get())
			.add(IcariaBlocks.DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());

		this.tag(IcariaBlockTags.LOGS_POPULUS)
			.add(IcariaBlocks.POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaBlocks.DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(BlockTags.LOGS_THAT_BURN)
			.add(IcariaBlocks.CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_PLANE_LOG.get())
			.add(IcariaBlocks.PLANE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get())
			.add(IcariaBlocks.POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());

		this.tag(BlockTags.LOGS)
			.add(IcariaBlocks.CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.DEAD_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get())
			.add(IcariaBlocks.LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_PLANE_LOG.get())
			.add(IcariaBlocks.PLANE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get())
			.add(IcariaBlocks.DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaBlocks.DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());

		this.tag(BlockTags.PLANKS)
			.add(IcariaBlocks.CYPRESS_PLANKS.get())
			.add(IcariaBlocks.DROUGHTROOT_PLANKS.get())
			.add(IcariaBlocks.FIR_PLANKS.get())
			.add(IcariaBlocks.LAUREL_PLANKS.get())
			.add(IcariaBlocks.OLIVE_PLANKS.get())
			.add(IcariaBlocks.PLANE_PLANKS.get())
			.add(IcariaBlocks.POPULUS_PLANKS.get());

		this.tag(BlockTags.WOODEN_DOORS)
			.add(IcariaBlocks.CYPRESS_DOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_DOOR.get())
			.add(IcariaBlocks.FIR_DOOR.get())
			.add(IcariaBlocks.LAUREL_DOOR.get())
			.add(IcariaBlocks.OLIVE_DOOR.get())
			.add(IcariaBlocks.PLANE_DOOR.get())
			.add(IcariaBlocks.POPULUS_DOOR.get());

		this.tag(BlockTags.WOODEN_TRAPDOORS)
			.add(IcariaBlocks.CYPRESS_TRAPDOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaBlocks.FIR_TRAPDOOR.get())
			.add(IcariaBlocks.LAUREL_TRAPDOOR.get())
			.add(IcariaBlocks.OLIVE_TRAPDOOR.get())
			.add(IcariaBlocks.PLANE_TRAPDOOR.get())
			.add(IcariaBlocks.POPULUS_TRAPDOOR.get());

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
			.add(IcariaBlocks.VOIDLILY.get())
			.add(IcariaBlocks.WHITE_BROMELIA.get())
			.add(IcariaBlocks.ORANGE_BROMELIA.get())
			.add(IcariaBlocks.PINK_BROMELIA.get())
			.add(IcariaBlocks.PURPLE_BROMELIA.get());
	}

	public void stoneDecoBlocksTag(TagKey<Block> pBlock, IcariaStoneDecoBlocks pDeco) {
		this.tag(pBlock).add(pDeco.slab.get()).add(pDeco.stairs.get()).add(pDeco.wall.get());
	}

	public void woodDecoBlocksTag(TagKey<Block> pBlock, IcariaWoodDecoBlocks pDeco) {
		this.tag(pBlock).add(pDeco.slab.get()).add(pDeco.stairs.get()).add(pDeco.fence.get()).add(pDeco.gate.get());
	}

	public static TagKey<Block> bind(String pName) {
		return TagKey.create(Registries.BLOCK, new ResourceLocation(pName));
	}

	public static TagKey<Block> forgeTag(String pName) {
		return IcariaBlockTags.bind(IcariaInfo.FORGE + ":" + pName);
	}

	public static TagKey<Block> icariaTag(String pName) {
		return IcariaBlockTags.bind(IcariaInfo.ID + ":" + pName);
	}
}
