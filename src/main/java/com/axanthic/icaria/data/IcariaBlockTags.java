package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockTags extends BlockTagsProvider {
	// BLOCK TAGS
	public static final TagKey<Block> ICARIA_TIER = icariaTag("icaria_tier");

	public static final TagKey<Block> NEEDS_CHERT_TOOL = icariaTag("needs_chert_tool");
	public static final TagKey<Block> NEEDS_CHALKOS_TOOL = icariaTag("needs_chalkos_tool");
	public static final TagKey<Block> NEEDS_KASSITEROS_TOOL = icariaTag("needs_kassiteros_tool");
	public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = icariaTag("needs_orichalcum_tool");
	public static final TagKey<Block> NEEDS_VANADIUMSTEEL_TOOL = icariaTag("needs_vanadiumsteel_tool");
	public static final TagKey<Block> NEEDS_SIDEROS_TOOL = icariaTag("needs_sideros_tool");
	public static final TagKey<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = icariaTag("needs_molybdenumsteel_tool");

	public static final TagKey<Block> MINEABLE_WITH_SCYTHE = icariaTag("mineable/scythe");

	public static final TagKey<Block> ICARIA_PORTAL_BLOCKS = icariaTag("icaria_portal_blocks");

	// ITEMBLOCK TAGS
	public static final TagKey<Block> ORES_ROTTEN_BONES = forgeTag("ores/rotten_bones");
	public static final TagKey<Block> ORES_CHERT = forgeTag("ores/chert");
	public static final TagKey<Block> ORES_LIGNITE = forgeTag("ores/lignite");
	public static final TagKey<Block> ORES_CHALKOS = forgeTag("ores/chalkos");
	public static final TagKey<Block> ORES_KASSITEROS = forgeTag("ores/kassiteros");
	public static final TagKey<Block> ORES_DOLOMITE = forgeTag("ores/dolomite");
	public static final TagKey<Block> ORES_VANADIUM = forgeTag("ores/vanadium");
	public static final TagKey<Block> ORES_SLIVER = forgeTag("ores/sliver");
	public static final TagKey<Block> ORES_SIDEROS = forgeTag("ores/sideros");
	public static final TagKey<Block> ORES_ANTHRACITE = forgeTag("ores/anthracite");
	public static final TagKey<Block> ORES_MOLYBDENUM = forgeTag("ores/molybdenum");
	public static final TagKey<Block> ORES_HYLIASTRUM = forgeTag("ores/hyliastrum");

	public static final TagKey<Block> ORES_IN_GROUND_MARL = forgeTag("ores_in_ground/marl");
	public static final TagKey<Block> ORES_IN_GROUND_GRAINEL = forgeTag("ores_in_ground/grainel");
	public static final TagKey<Block> ORES_IN_GROUND_YELLOWSTONE = forgeTag("ores_in_ground/yellowstone");
	public static final TagKey<Block> ORES_IN_GROUND_SILKSTONE = forgeTag("ores_in_ground/silkstone");
	public static final TagKey<Block> ORES_IN_GROUND_SUNSTONE = forgeTag("ores_in_ground/sunstone");
	public static final TagKey<Block> ORES_IN_GROUND_VOIDSHALE = forgeTag("ores_in_ground/voidshale");
	public static final TagKey<Block> ORES_IN_GROUND_BAETYL = forgeTag("ores_in_ground/baetyl");

	public static final TagKey<Block> ORE_BEARING_GROUND_MARL = forgeTag("ore_bearing_ground/marl");
	public static final TagKey<Block> ORE_BEARING_GROUND_GRAINEL = forgeTag("ore_bearing_ground/grainel");
	public static final TagKey<Block> ORE_BEARING_GROUND_YELLOWSTONE = forgeTag("ore_bearing_ground/yellowstone");
	public static final TagKey<Block> ORE_BEARING_GROUND_SILKSTONE = forgeTag("ore_bearing_ground/silkstone");
	public static final TagKey<Block> ORE_BEARING_GROUND_SUNSTONE = forgeTag("ore_bearing_ground/sunstone");
	public static final TagKey<Block> ORE_BEARING_GROUND_VOIDSHALE = forgeTag("ore_bearing_ground/voidshale");
	public static final TagKey<Block> ORE_BEARING_GROUND_BAETYL = forgeTag("ore_bearing_ground/baetyl");

	public static final TagKey<Block> STORAGE_BLOCKS_ARISTONE_PACKED = forgeTag("storage_blocks/aristone_packed");
	public static final TagKey<Block> STORAGE_BLOCKS_JELLYFISH_JELLY = forgeTag("storage_blocks/jellyfish_jelly");
	public static final TagKey<Block> STORAGE_BLOCKS_ARACHNE_STRING = forgeTag("storage_blocks/arachne_string");
	public static final TagKey<Block> STORAGE_BLOCKS_SPELT = forgeTag("storage_blocks/spelt");
	public static final TagKey<Block> STORAGE_BLOCKS_VINE_REED = forgeTag("storage_blocks/vine_reed");
	public static final TagKey<Block> STORAGE_BLOCKS_VINE_SPROUT = forgeTag("storage_blocks/vine_sprout");
	public static final TagKey<Block> STORAGE_BLOCKS_ROTTEN_BONES = forgeTag("storage_blocks/rotten_bones");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_CHALKOS = forgeTag("storage_blocks/raw_chalkos");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_KASSITEROS = forgeTag("storage_blocks/raw_kassiteros");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_VANADIUM = forgeTag("storage_blocks/raw_vanadium");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_SIDEROS = forgeTag("storage_blocks/raw_sideros");
	public static final TagKey<Block> STORAGE_BLOCKS_RAW_MOLYBDENUM = forgeTag("storage_blocks/raw_molybdenum");
	public static final TagKey<Block> STORAGE_BLOCKS_CALCITE = forgeTag("storage_blocks/calcite");
	public static final TagKey<Block> STORAGE_BLOCKS_HALITE = forgeTag("storage_blocks/halite");
	public static final TagKey<Block> STORAGE_BLOCKS_JASPER = forgeTag("storage_blocks/jasper");
	public static final TagKey<Block> STORAGE_BLOCKS_ZIRCON = forgeTag("storage_blocks/zircon");
	public static final TagKey<Block> STORAGE_BLOCKS_CHERT = forgeTag("storage_blocks/chert");
	public static final TagKey<Block> STORAGE_BLOCKS_LIGNITE = forgeTag("storage_blocks/lignite");
	public static final TagKey<Block> STORAGE_BLOCKS_CHALKOS = forgeTag("storage_blocks/chalkos");
	public static final TagKey<Block> STORAGE_BLOCKS_KASSITEROS = forgeTag("storage_blocks/kassiteros");
	public static final TagKey<Block> STORAGE_BLOCKS_ORICHALCUM = forgeTag("storage_blocks/orichalcum");
	public static final TagKey<Block> STORAGE_BLOCKS_VANADIUM = forgeTag("storage_blocks/vanadium");
	public static final TagKey<Block> STORAGE_BLOCKS_VANADIUMSTEEL = forgeTag("storage_blocks/vanadiumsteel");
	public static final TagKey<Block> STORAGE_BLOCKS_SLIVER = forgeTag("storage_blocks/sliver");
	public static final TagKey<Block> STORAGE_BLOCKS_SIDEROS = forgeTag("storage_blocks/sideros");
	public static final TagKey<Block> STORAGE_BLOCKS_ANTHRACITE = forgeTag("storage_blocks/anthracite");
	public static final TagKey<Block> STORAGE_BLOCKS_MOLYBDENUM = forgeTag("storage_blocks/molybdenum");
	public static final TagKey<Block> STORAGE_BLOCKS_MOLYBDENUMSTEEL = forgeTag("storage_blocks/molybdenumsteel");

	public static final TagKey<Block> SAPLINGS_CYPRESS = forgeTag("saplings/cypress");
	public static final TagKey<Block> SAPLINGS_DROUGHTROOT = forgeTag("saplings/droughtroot");
	public static final TagKey<Block> SAPLINGS_FIR = forgeTag("saplings/fir");
	public static final TagKey<Block> SAPLINGS_LAUREL = forgeTag("saplings/laurel");
	public static final TagKey<Block> SAPLINGS_OLIVE = forgeTag("saplings/olive");
	public static final TagKey<Block> SAPLINGS_PLANE = forgeTag("saplings/plane");
	public static final TagKey<Block> SAPLINGS_POPULUS = forgeTag("saplings/populus");

	public static final TagKey<Block> LEAVES_CYPRESS = forgeTag("leaves/cypress");
	public static final TagKey<Block> LEAVES_DROUGHTROOT = forgeTag("leaves/droughtroot");
	public static final TagKey<Block> LEAVES_FIR = forgeTag("leaves/fir");
	public static final TagKey<Block> LEAVES_LAUREL = forgeTag("leaves/laurel");
	public static final TagKey<Block> LEAVES_OLIVE = forgeTag("leaves/olive");
	public static final TagKey<Block> LEAVES_PLANE = forgeTag("leaves/plane");
	public static final TagKey<Block> LEAVES_POPULUS = forgeTag("leaves/populus");
	
	public static final TagKey<Block> LOGS_CYPRESS = forgeTag("logs/cypress");
	public static final TagKey<Block> LOGS_DROUGHTROOT = forgeTag("logs/droughtroot");
	public static final TagKey<Block> LOGS_FIR = forgeTag("logs/fir");
	public static final TagKey<Block> LOGS_LAUREL = forgeTag("logs/laurel");
	public static final TagKey<Block> LOGS_OLIVE = forgeTag("logs/olive");
	public static final TagKey<Block> LOGS_PLANE = forgeTag("logs/plane");
	public static final TagKey<Block> LOGS_POPULUS = forgeTag("logs/populus");

	public static final TagKey<Block> PLANKS_CYPRESS = forgeTag("planks/cypress");
	public static final TagKey<Block> PLANKS_DROUGHTROOT = forgeTag("planks/droughtroot");
	public static final TagKey<Block> PLANKS_FIR = forgeTag("planks/fir");
	public static final TagKey<Block> PLANKS_LAUREL = forgeTag("planks/laurel");
	public static final TagKey<Block> PLANKS_OLIVE = forgeTag("planks/olive");
	public static final TagKey<Block> PLANKS_PLANE  = forgeTag("planks/plane");
	public static final TagKey<Block> PLANKS_POPULUS = forgeTag("planks/populus");

	public static final TagKey<Block> WOODEN_DOORS_CYPRESS = forgeTag("wooden_doors/cypress");
	public static final TagKey<Block> WOODEN_DOORS_DROUGHTROOT = forgeTag("wooden_doors/droughtroot");
	public static final TagKey<Block> WOODEN_DOORS_FIR = forgeTag("wooden_doors/fir");
	public static final TagKey<Block> WOODEN_DOORS_LAUREL = forgeTag("wooden_doors/laurel");
	public static final TagKey<Block> WOODEN_DOORS_OLIVE = forgeTag("wooden_doors/olive");
	public static final TagKey<Block> WOODEN_DOORS_PLANE  = forgeTag("wooden_doors/plane");
	public static final TagKey<Block> WOODEN_DOORS_POPULUS = forgeTag("wooden_doors/populus");

	public static final TagKey<Block> WOODEN_TRAPDOORS_CYPRESS = forgeTag("wooden_trapdoors/cypress");
	public static final TagKey<Block> WOODEN_TRAPDOORS_DROUGHTROOT = forgeTag("wooden_trapdoors/droughtroot");
	public static final TagKey<Block> WOODEN_TRAPDOORS_FIR = forgeTag("wooden_trapdoors/fir");
	public static final TagKey<Block> WOODEN_TRAPDOORS_LAUREL = forgeTag("wooden_trapdoors/laurel");
	public static final TagKey<Block> WOODEN_TRAPDOORS_OLIVE = forgeTag("wooden_trapdoors/olive");
	public static final TagKey<Block> WOODEN_TRAPDOORS_PLANE  = forgeTag("wooden_trapdoors/plane");
	public static final TagKey<Block> WOODEN_TRAPDOORS_POPULUS = forgeTag("wooden_trapdoors/populus");

	public IcariaBlockTags(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, IcariaInfo.MODID, helper);
	}

	@Override
	public void addTags() {
		// BLOCK TAGS
		tag(ICARIA_TIER)
			.addTag(NEEDS_CHERT_TOOL)
			.addTag(NEEDS_CHALKOS_TOOL)
			.addTag(NEEDS_KASSITEROS_TOOL)
			.addTag(NEEDS_ORICHALCUM_TOOL)
			.addTag(NEEDS_VANADIUMSTEEL_TOOL)
			.addTag(NEEDS_SIDEROS_TOOL)
			.addTag(NEEDS_MOLYBDENUMSTEEL_TOOL);

		tag(NEEDS_CHERT_TOOL)
			.add(IcariaBlocks.YELLOWSTONE_ADOBE.get())
			.add(IcariaBlocks.YELLOWSTONE_COBBLE.get())
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.YELLOWSTONE_CHISELED.get())
			.add(IcariaBlocks.LIGNITE_ORE.get())
			.add(IcariaBlocks.CHALKOS_ORE.get())
			.add(IcariaBlocks.CALCITE_CRYSTAL.get())
			.add(IcariaBlocks.CHALKOS_RAW_BLOCK.get())
			.add(IcariaBlocks.CHALKOS_BLOCK.get());

		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_ADOBE_DECO, NEEDS_CHERT_TOOL);
		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_COBBLE_DECO, NEEDS_CHERT_TOOL);
		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_DECO, NEEDS_CHERT_TOOL);
		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_BRICKS_DECO, NEEDS_CHERT_TOOL);

		tag(NEEDS_CHALKOS_TOOL)
			.add(IcariaBlocks.DOLOMITE_ADOBE.get())
			.add(IcariaBlocks.DOLOMITE_SMOOTH.get())
			.add(IcariaBlocks.DOLOMITE_BRICKS.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.SILKSAND.get())
			.add(IcariaBlocks.SILKGLASS.get())
			.add(IcariaBlocks.SILKGLASS_PANE.get())
			.add(IcariaBlocks.SILKGLASS.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE.get())
			.add(IcariaBlocks.SILKSTONE_COBBLE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.SILKSTONE_CHISELED.get())
			.add(IcariaBlocks.KASSITEROS_ORE.get())
			.add(IcariaBlocks.DOLOMITE_ORE.get())
			.add(IcariaBlocks.HALITE_CRYSTAL.get())
			.add(IcariaBlocks.KASSITEROS_RAW_BLOCK.get())
			.add(IcariaBlocks.KASSITEROS_BLOCK.get());

		addStoneDecoToTag(IcariaBlocks.DOLOMITE_ADOBE_DECO, NEEDS_CHALKOS_TOOL);
		addStoneDecoToTag(IcariaBlocks.DOLOMITE_SMOOTH_DECO, NEEDS_CHALKOS_TOOL);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_ADOBE_DECO, NEEDS_CHALKOS_TOOL);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_COBBLE_DECO, NEEDS_CHALKOS_TOOL);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_DECO, NEEDS_CHALKOS_TOOL);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_BRICKS_DECO, NEEDS_CHALKOS_TOOL);

		tag(NEEDS_KASSITEROS_TOOL).add(IcariaBlocks.ORICHALCUM_BLOCK.get());

		tag(NEEDS_ORICHALCUM_TOOL)
			.add(IcariaBlocks.SUNSTONE_ADOBE.get())
			.add(IcariaBlocks.SUNSTONE_COBBLE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.SUNSTONE_CHISELED.get())
			.add(IcariaBlocks.VANADIUM_ORE.get())
			.add(IcariaBlocks.SLIVER_ORE.get())
			.add(IcariaBlocks.JASPER_CRYSTAL.get())
			.add(IcariaBlocks.VANADIUM_RAW_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get());

		addStoneDecoToTag(IcariaBlocks.SUNSTONE_ADOBE_DECO, NEEDS_ORICHALCUM_TOOL);
		addStoneDecoToTag(IcariaBlocks.SUNSTONE_COBBLE_DECO, NEEDS_ORICHALCUM_TOOL);
		addStoneDecoToTag(IcariaBlocks.SUNSTONE_DECO, NEEDS_ORICHALCUM_TOOL);
		addStoneDecoToTag(IcariaBlocks.SUNSTONE_BRICKS_DECO, NEEDS_ORICHALCUM_TOOL);

		tag(NEEDS_VANADIUMSTEEL_TOOL)
			.add(IcariaBlocks.VOIDSHALE_ADOBE.get())
			.add(IcariaBlocks.VOIDSHALE_COBBLE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.VOIDSHALE_CHISELED.get())
			.add(IcariaBlocks.SIDEROS_ORE.get())
			.add(IcariaBlocks.ANTHRACITE_ORE.get())
			.add(IcariaBlocks.SIDEROS_RAW_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_BLOCK.get())
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get());

		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_ADOBE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_COBBLE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_BRICKS_DECO, NEEDS_VANADIUMSTEEL_TOOL);

		tag(NEEDS_SIDEROS_TOOL)
			.add(IcariaBlocks.BAETYL_ADOBE.get())
			.add(IcariaBlocks.BAETYL_COBBLE.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.BAETYL_CHISELED.get())
			.add(IcariaBlocks.MOLYBDENUM_ORE.get())
			.add(IcariaBlocks.HYLIASTRUM_ORE.get())
			.add(IcariaBlocks.ZIRCON_CRYSTAL.get())
			.add(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());

		addStoneDecoToTag(IcariaBlocks.BAETYL_ADOBE_DECO, NEEDS_SIDEROS_TOOL);
		addStoneDecoToTag(IcariaBlocks.BAETYL_COBBLE_DECO, NEEDS_SIDEROS_TOOL);
		addStoneDecoToTag(IcariaBlocks.BAETYL_DECO, NEEDS_SIDEROS_TOOL);
		addStoneDecoToTag(IcariaBlocks.BAETYL_BRICKS_DECO, NEEDS_SIDEROS_TOOL);

		tag(NEEDS_MOLYBDENUMSTEEL_TOOL);

		tag(MINEABLE_WITH_SCYTHE)
			.addTag(BlockTags.CROPS)
			.addTag(BlockTags.MINEABLE_WITH_HOE)
			.addTag(BlockTags.REPLACEABLE_PLANTS);

		tag(ICARIA_PORTAL_BLOCKS)
			.add(Blocks.QUARTZ_SLAB)
			.add(Blocks.SMOOTH_QUARTZ_SLAB)
			.add(Blocks.QUARTZ_PILLAR)
			.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get())
			.add(IcariaBlocks.DOLOMITE_SMOOTH_DECO.SLAB.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.RELICSTONE_DECO.SLAB.get())
			.add(IcariaBlocks.RELICSTONE_SMOOTH_DECO.SLAB.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS_DECO.SLAB.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO.SLAB.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO.SLAB.get())
			.add(IcariaBlocks.RELICSTONE_TILES_DECO.SLAB.get())
			.add(IcariaBlocks.RELICSTONE_TILES_CRACKED_DECO.SLAB.get())
			.add(IcariaBlocks.RELICSTONE_TILES_MOSSY_DECO.SLAB.get());

		tag(BlockTags.MINEABLE_WITH_AXE)
			.add(IcariaBlocks.VINE_REED_BLOCK.get())
			.add(IcariaBlocks.VINE_SPROUT_BLOCK.get())
			.add(IcariaBlocks.CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.CYPRESS_PLANKS.get())
			.add(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get())
			.add(IcariaBlocks.CYPRESS_DOOR.get())
			.add(IcariaBlocks.CYPRESS_TRAPDOOR.get())
			.add(IcariaBlocks.CYPRESS_LADDER.get())
			.add(IcariaBlocks.CYPRESS_SIGN.get())
			.add(IcariaBlocks.CYPRESS_WALL_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DROUGHTROOT_PLANKS.get())
			.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get())
			.add(IcariaBlocks.DROUGHTROOT_DOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get())
			.add(IcariaBlocks.DROUGHTROOT_LADDER.get())
			.add(IcariaBlocks.DROUGHTROOT_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get())
			.add(IcariaBlocks.FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.DEAD_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get())
			.add(IcariaBlocks.FIR_PLANKS.get())
			.add(IcariaBlocks.FIR_CRAFTING_TABLE.get())
			.add(IcariaBlocks.FIR_DOOR.get())
			.add(IcariaBlocks.FIR_TRAPDOOR.get())
			.add(IcariaBlocks.FIR_LADDER.get())
			.add(IcariaBlocks.FIR_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_SIGN.get())
			.add(IcariaBlocks.LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_PLANKS.get())
			.add(IcariaBlocks.LAUREL_CRAFTING_TABLE.get())
			.add(IcariaBlocks.LAUREL_DOOR.get())
			.add(IcariaBlocks.LAUREL_TRAPDOOR.get())
			.add(IcariaBlocks.LAUREL_LADDER.get())
			.add(IcariaBlocks.LAUREL_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_SIGN.get())
			.add(IcariaBlocks.OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.OLIVE_PLANKS.get())
			.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.OLIVE_DOOR.get())
			.add(IcariaBlocks.OLIVE_TRAPDOOR.get())
			.add(IcariaBlocks.OLIVE_LADDER.get())
			.add(IcariaBlocks.OLIVE_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_SIGN.get())
			.add(IcariaBlocks.PLANE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get())
			.add(IcariaBlocks.PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_PLANE_LOG.get())
			.add(IcariaBlocks.DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get())
			.add(IcariaBlocks.PLANE_PLANKS.get())
			.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get())
			.add(IcariaBlocks.PLANE_DOOR.get())
			.add(IcariaBlocks.PLANE_TRAPDOOR.get())
			.add(IcariaBlocks.PLANE_LADDER.get())
			.add(IcariaBlocks.PLANE_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_SIGN.get())
			.add(IcariaBlocks.POPULUS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaBlocks.POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_PLANKS.get())
			.add(IcariaBlocks.POPULUS_CRAFTING_TABLE.get())
			.add(IcariaBlocks.POPULUS_DOOR.get())
			.add(IcariaBlocks.POPULUS_TRAPDOOR.get())
			.add(IcariaBlocks.POPULUS_LADDER.get())
			.add(IcariaBlocks.POPULUS_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_SIGN.get());

		addWoodDecoToTag(IcariaBlocks.CYPRESS_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.DROUGHTROOT_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.FIR_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.LAUREL_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.OLIVE_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.PLANE_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.POPULUS_DECO, BlockTags.MINEABLE_WITH_AXE);

		tag(BlockTags.MINEABLE_WITH_HOE)
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
			.add(IcariaBlocks.OLIVE_LEAVES_BLACK.get())
			.add(IcariaBlocks.OLIVE_LEAVES_GREEN.get())
			.add(IcariaBlocks.FALLEN_OLIVE_LEAVES.get())
			.add(IcariaBlocks.PLANE_LEAVES.get())
			.add(IcariaBlocks.FALLEN_PLANE_LEAVES.get())
			.add(IcariaBlocks.POPULUS_LEAVES.get())
			.add(IcariaBlocks.FALLEN_POPULUS_LEAVES.get())
			.add(IcariaBlocks.MOSS_0.get())
			.add(IcariaBlocks.MOSS_1.get())
			.add(IcariaBlocks.MOSS_2.get());

		tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(IcariaBlocks.MARL_ADOBE.get())
			.add(IcariaBlocks.LOAM_BRICKS.get())
			.add(IcariaBlocks.DOLOMITE_ADOBE.get())
			.add(IcariaBlocks.DOLOMITE_SMOOTH.get())
			.add(IcariaBlocks.DOLOMITE_BRICKS.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR.get())
			.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
			.add(IcariaBlocks.GRAINITE_ADOBE.get())
			.add(IcariaBlocks.GRAINITE.get())
			.add(IcariaBlocks.GRAINITE_BRICKS.get())
			.add(IcariaBlocks.GRAINITE_CHISELED.get())
			.add(IcariaBlocks.YELLOWSTONE_ADOBE.get())
			.add(IcariaBlocks.YELLOWSTONE_COBBLE.get())
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.YELLOWSTONE_CHISELED.get())
			.add(IcariaBlocks.SILKSTONE_ADOBE.get())
			.add(IcariaBlocks.SILKSTONE_COBBLE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.SILKSTONE_CHISELED.get())
			.add(IcariaBlocks.SUNSTONE_ADOBE.get())
			.add(IcariaBlocks.SUNSTONE_COBBLE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.SUNSTONE_CHISELED.get())
			.add(IcariaBlocks.VOIDSHALE_ADOBE.get())
			.add(IcariaBlocks.VOIDSHALE_COBBLE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.VOIDSHALE_CHISELED.get())
			.add(IcariaBlocks.BAETYL_ADOBE.get())
			.add(IcariaBlocks.BAETYL_COBBLE.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.BAETYL_CHISELED.get())
			.add(IcariaBlocks.RELICSTONE.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS_CRACKED.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS_MOSSY.get())
			.add(IcariaBlocks.RELICSTONE_TILES.get())
			.add(IcariaBlocks.RELICSTONE_TILES_CRACKED.get())
			.add(IcariaBlocks.RELICSTONE_TILES_MOSSY.get())
			.add(IcariaBlocks.RELICSTONE_CHISELED.get())
			.add(IcariaBlocks.RELICSTONE_PILLAR.get())
			.add(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get())
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
			.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get())
			.add(IcariaBlocks.CALCITE_CRYSTAL.get())
			.add(IcariaBlocks.HALITE_CRYSTAL.get())
			.add(IcariaBlocks.JASPER_CRYSTAL.get())
			.add(IcariaBlocks.ZIRCON_CRYSTAL.get())
			.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get())
			.add(IcariaBlocks.CHALKOS_RAW_BLOCK.get())
			.add(IcariaBlocks.KASSITEROS_RAW_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_RAW_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_RAW_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get())
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
			.add(IcariaBlocks.STORAGE_VASE.get())
			.add(IcariaBlocks.WHITE_STORAGE_VASE.get())
			.add(IcariaBlocks.ORANGE_STORAGE_VASE.get())
			.add(IcariaBlocks.MAGENTA_STORAGE_VASE.get())
			.add(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get())
			.add(IcariaBlocks.YELLOW_STORAGE_VASE.get())
			.add(IcariaBlocks.LIME_STORAGE_VASE.get())
			.add(IcariaBlocks.PINK_STORAGE_VASE.get())
			.add(IcariaBlocks.GRAY_STORAGE_VASE.get())
			.add(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get())
			.add(IcariaBlocks.CYAN_STORAGE_VASE.get())
			.add(IcariaBlocks.PURPLE_STORAGE_VASE.get())
			.add(IcariaBlocks.BLUE_STORAGE_VASE.get())
			.add(IcariaBlocks.BROWN_STORAGE_VASE.get())
			.add(IcariaBlocks.GREEN_STORAGE_VASE.get())
			.add(IcariaBlocks.RED_STORAGE_VASE.get())
			.add(IcariaBlocks.BLACK_STORAGE_VASE.get());

		addStoneDecoToTag(IcariaBlocks.MARL_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.LOAM_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.DOLOMITE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.DOLOMITE_SMOOTH_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.GRAINITE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.GRAINITE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.GRAINITE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.YELLOWSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SILKSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SUNSTONE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SUNSTONE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SUNSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.SUNSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.VOIDSHALE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.BAETYL_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.BAETYL_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.BAETYL_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.BAETYL_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_SMOOTH_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_TILES_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_TILES_CRACKED_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addStoneDecoToTag(IcariaBlocks.RELICSTONE_TILES_MOSSY_DECO, BlockTags.MINEABLE_WITH_PICKAXE);

		tag(BlockTags.MINEABLE_WITH_SHOVEL)
			.add(IcariaBlocks.MARL_GRASS.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_CHERT.get())
			.add(IcariaBlocks.MARL_ROTTEN_BONES.get())
			.add(IcariaBlocks.MARL_LIGNITE.get())
			.add(IcariaBlocks.MARL_COARSE.get())
			.add(IcariaBlocks.FARMLAND.get())
			.add(IcariaBlocks.FARMLAND_FERTILIZED.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.GRAINEL_CHERT.get());

		tag(BlockTags.FLOWER_POTS)
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

		tag(BlockTags.CLIMBABLE)
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

		tag(BlockTags.STANDING_SIGNS)
			.add(IcariaBlocks.CYPRESS_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_SIGN.get())
			.add(IcariaBlocks.FIR_SIGN.get())
			.add(IcariaBlocks.LAUREL_SIGN.get())
			.add(IcariaBlocks.OLIVE_SIGN.get())
			.add(IcariaBlocks.PLANE_SIGN.get())
			.add(IcariaBlocks.POPULUS_SIGN.get());

		tag(BlockTags.WALL_SIGNS)
			.add(IcariaBlocks.CYPRESS_WALL_SIGN.get())
			.add(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get())
			.add(IcariaBlocks.FIR_WALL_SIGN.get())
			.add(IcariaBlocks.LAUREL_WALL_SIGN.get())
			.add(IcariaBlocks.OLIVE_WALL_SIGN.get())
			.add(IcariaBlocks.PLANE_WALL_SIGN.get())
			.add(IcariaBlocks.POPULUS_WALL_SIGN.get());

		tag(BlockTags.WALL_POST_OVERRIDE)
			.add(IcariaBlocks.DIM_TORCH.get())
			.add(IcariaBlocks.LIGNITE_TORCH.get())
			.add(IcariaBlocks.ANTHRACITE_TORCH.get());

		tag(BlockTags.SMALL_FLOWERS)
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

		tag(BlockTags.CANDLE_CAKES)
			.add(IcariaBlocks.STRAWBERRY_CAKE_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_WHITE_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_ORANGE_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_MAGENTA_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_LIGHT_BLUE_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_YELLOW_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_LIME_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_PINK_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_GRAY_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_LIGHT_GRAY_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_CYAN_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_PURPLE_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_BLUE_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_BROWN_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_GREEN_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_RED_CANDLE.get())
			.add(IcariaBlocks.STRAWBERRY_CAKE_BLACK_CANDLE.get());

		tag(BlockTags.CROPS)
			.add(IcariaBlocks.SPELT_CROP.get())
			.add(IcariaBlocks.STRAWBERRY_CROP.get())
			.add(IcariaBlocks.PHYSALIS_CROP.get())
			.add(IcariaBlocks.ONION_CROP.get());

		tag(BlockTags.FIRE)
			.add(IcariaBlocks.GREEK_FIRE.get());

		// ITEMBLOCK TAGS
		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
			if (deco.SLAB != null) {
				tag(BlockTags.SLABS).add(deco.block.SLAB.get());
			}
			if (deco.STAIRS != null) {
				tag(BlockTags.STAIRS).add(deco.block.STAIRS.get());
			}
			if (deco.WALL != null) {
				tag(BlockTags.WALLS).add(deco.block.WALL.get());
			}
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			if (deco.SLAB != null) {
				tag(BlockTags.WOODEN_SLABS).add(deco.block.SLAB.get());
			}
			if (deco.STAIRS != null) {
				tag(BlockTags.WOODEN_STAIRS).add(deco.block.STAIRS.get());
			}
			if (deco.FENCE != null) {
				tag(BlockTags.WOODEN_FENCES).add(deco.block.FENCE.get());
			}
			if (deco.GATE != null) {
				tag(BlockTags.FENCE_GATES).add(deco.block.GATE.get());
			}
		}

		tag(BlockTags.DIRT)
			.add(IcariaBlocks.MARL_GRASS.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_COARSE.get())
			.add(IcariaBlocks.LOAM.get());

		tag(BlockTags.BAMBOO_PLANTABLE_ON)
			.add(IcariaBlocks.MARL_GRASS.get())
			.add(IcariaBlocks.MARL.get())
			.add(IcariaBlocks.MARL_COARSE.get())
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get());

		tag(BlockTags.SAND)
			.add(IcariaBlocks.LOAM.get())
			.add(IcariaBlocks.GRAINEL.get())
			.add(IcariaBlocks.SILKSAND.get());

		tag(Tags.Blocks.GLASS_COLORLESS)
			.add(IcariaBlocks.GRAINGLASS.get())
			.add(IcariaBlocks.SILKGLASS.get());

		tag(Tags.Blocks.GLASS_SILICA)
			.add(IcariaBlocks.GRAINGLASS.get())
			.add(IcariaBlocks.SILKGLASS.get());

		tag(Tags.Blocks.GLASS_PANES)
			.add(IcariaBlocks.GRAINGLASS_PANE.get())
			.add(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get())
			.add(IcariaBlocks.SILKGLASS_PANE.get())
			.add(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());

		tag(Tags.Blocks.SANDSTONE).add(IcariaBlocks.GRAINITE.get());

		tag(Tags.Blocks.COBBLESTONE_NORMAL)
			.add(IcariaBlocks.YELLOWSTONE_COBBLE.get())
			.add(IcariaBlocks.SILKSTONE_COBBLE.get())
			.add(IcariaBlocks.SUNSTONE_COBBLE.get())
			.add(IcariaBlocks.VOIDSHALE_COBBLE.get())
			.add(IcariaBlocks.BAETYL_COBBLE.get())
			.add(IcariaBlocks.RELICSTONE.get());

		tag(Tags.Blocks.STONE)
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.RELICSTONE_SMOOTH.get());

		tag(BlockTags.STONE_BRICKS)
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS.get());

		tag(ORES_ROTTEN_BONES).add(IcariaBlocks.MARL_ROTTEN_BONES.get());
		tag(ORES_CHERT).add(IcariaBlocks.MARL_CHERT.get()).add(IcariaBlocks.GRAINEL_CHERT.get());
		tag(ORES_LIGNITE).add(IcariaBlocks.MARL_LIGNITE.get()).add(IcariaBlocks.LIGNITE_ORE.get());
		tag(ORES_CHALKOS).add(IcariaBlocks.CHALKOS_ORE.get());
		tag(ORES_KASSITEROS).add(IcariaBlocks.KASSITEROS_ORE.get());
		tag(ORES_DOLOMITE).add(IcariaBlocks.DOLOMITE_ORE.get());
		tag(ORES_VANADIUM).add(IcariaBlocks.VANADIUM_ORE.get());
		tag(ORES_SLIVER).add(IcariaBlocks.SLIVER_ORE.get());
		tag(ORES_SIDEROS).add(IcariaBlocks.SIDEROS_ORE.get());
		tag(ORES_ANTHRACITE).add(IcariaBlocks.ANTHRACITE_ORE.get());
		tag(ORES_MOLYBDENUM).add(IcariaBlocks.MOLYBDENUM_ORE.get());
		tag(ORES_HYLIASTRUM).add(IcariaBlocks.HYLIASTRUM_ORE.get());

		tag(Tags.Blocks.ORES)
			.addTag(ORES_ROTTEN_BONES)
			.addTag(ORES_CHERT)
			.addTag(ORES_LIGNITE)
			.addTag(ORES_CHALKOS)
			.addTag(ORES_KASSITEROS)
			.addTag(ORES_DOLOMITE)
			.addTag(ORES_VANADIUM)
			.addTag(ORES_SLIVER)
			.addTag(ORES_SIDEROS)
			.addTag(ORES_ANTHRACITE)
			.addTag(ORES_MOLYBDENUM)
			.addTag(ORES_HYLIASTRUM);

		tag(Tags.Blocks.ORE_RATES_SINGULAR)
			.addTag(ORES_CHERT)
			.addTag(ORES_LIGNITE)
			.addTag(ORES_CHALKOS)
			.addTag(ORES_KASSITEROS)
			.addTag(ORES_DOLOMITE)
			.addTag(ORES_VANADIUM)
			.addTag(ORES_SLIVER)
			.addTag(ORES_SIDEROS)
			.addTag(ORES_ANTHRACITE)
			.addTag(ORES_MOLYBDENUM);

		tag(Tags.Blocks.ORE_RATES_DENSE).addTag(ORES_ROTTEN_BONES);

		tag(ORES_IN_GROUND_MARL).add(IcariaBlocks.MARL_LIGNITE.get()).add(IcariaBlocks.MARL_ROTTEN_BONES.get()).add(IcariaBlocks.MARL_CHERT.get());
		tag(ORES_IN_GROUND_GRAINEL).add(IcariaBlocks.GRAINEL_CHERT.get());
		tag(ORES_IN_GROUND_YELLOWSTONE).add(IcariaBlocks.LIGNITE_ORE.get()).add(IcariaBlocks.CHALKOS_ORE.get());
		tag(ORES_IN_GROUND_SILKSTONE).add(IcariaBlocks.KASSITEROS_ORE.get()).add(IcariaBlocks.DOLOMITE_ORE.get());
		tag(ORES_IN_GROUND_SUNSTONE).add(IcariaBlocks.VANADIUM_ORE.get()).add(IcariaBlocks.SLIVER_ORE.get());
		tag(ORES_IN_GROUND_VOIDSHALE).add(IcariaBlocks.SIDEROS_ORE.get()).add(IcariaBlocks.ANTHRACITE_ORE.get());
		tag(ORES_IN_GROUND_BAETYL).add(IcariaBlocks.MOLYBDENUM_ORE.get()).add(IcariaBlocks.HYLIASTRUM_ORE.get());

		tag(ORE_BEARING_GROUND_MARL).add(IcariaBlocks.MARL.get());
		tag(ORE_BEARING_GROUND_GRAINEL).add(IcariaBlocks.GRAINEL.get());
		tag(ORE_BEARING_GROUND_YELLOWSTONE).add(IcariaBlocks.YELLOWSTONE.get());
		tag(ORE_BEARING_GROUND_SILKSTONE).add(IcariaBlocks.SILKSTONE.get());
		tag(ORE_BEARING_GROUND_SUNSTONE).add(IcariaBlocks.SUNSTONE.get());
		tag(ORE_BEARING_GROUND_VOIDSHALE).add(IcariaBlocks.VOIDSHALE.get());
		tag(ORE_BEARING_GROUND_BAETYL).add(IcariaBlocks.BAETYL.get());

		tag(STORAGE_BLOCKS_ARISTONE_PACKED).add(IcariaBlocks.ARISTONE_PACKED.get());
		tag(STORAGE_BLOCKS_JELLYFISH_JELLY).add(IcariaBlocks.JELLYFISH_JELLY_BLOCK.get());
		tag(STORAGE_BLOCKS_ARACHNE_STRING).add(IcariaBlocks.ARACHNE_STRING_BLOCK.get());
		tag(STORAGE_BLOCKS_SPELT).add(IcariaBlocks.SPELT_BALE_BLOCK.get());
		tag(STORAGE_BLOCKS_VINE_REED).add(IcariaBlocks.VINE_REED_BLOCK.get());
		tag(STORAGE_BLOCKS_VINE_SPROUT).add(IcariaBlocks.VINE_SPROUT_BLOCK.get());
		tag(STORAGE_BLOCKS_ROTTEN_BONES).add(IcariaBlocks.ROTTEN_BONES_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_CHALKOS).add(IcariaBlocks.CHALKOS_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_KASSITEROS).add(IcariaBlocks.KASSITEROS_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_VANADIUM).add(IcariaBlocks.VANADIUM_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_SLIVER).add(IcariaBlocks.SLIVER_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_SIDEROS).add(IcariaBlocks.SIDEROS_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_MOLYBDENUM).add(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_CALCITE).add(IcariaBlocks.CALCITE_BLOCK.get());
		tag(STORAGE_BLOCKS_HALITE).add(IcariaBlocks.HALITE_BLOCK.get());
		tag(STORAGE_BLOCKS_JASPER).add(IcariaBlocks.JASPER_BLOCK.get());
		tag(STORAGE_BLOCKS_ZIRCON).add(IcariaBlocks.ZIRCON_BLOCK.get());
		tag(STORAGE_BLOCKS_CHERT).add(IcariaBlocks.CHERT_BLOCK.get());
		tag(STORAGE_BLOCKS_LIGNITE).add(IcariaBlocks.LIGNITE_BLOCK.get());
		tag(STORAGE_BLOCKS_CHALKOS).add(IcariaBlocks.CHALKOS_BLOCK.get());
		tag(STORAGE_BLOCKS_KASSITEROS).add(IcariaBlocks.KASSITEROS_BLOCK.get());
		tag(STORAGE_BLOCKS_ORICHALCUM).add(IcariaBlocks.ORICHALCUM_BLOCK.get());
		tag(STORAGE_BLOCKS_VANADIUM).add(IcariaBlocks.VANADIUM_BLOCK.get());
		tag(STORAGE_BLOCKS_VANADIUMSTEEL).add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get());
		tag(STORAGE_BLOCKS_SIDEROS).add(IcariaBlocks.SIDEROS_BLOCK.get());
		tag(STORAGE_BLOCKS_ANTHRACITE).add(IcariaBlocks.ANTHRACITE_BLOCK.get());
		tag(STORAGE_BLOCKS_MOLYBDENUM).add(IcariaBlocks.MOLYBDENUM_BLOCK.get());
		tag(STORAGE_BLOCKS_MOLYBDENUMSTEEL).add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());

		tag(Tags.Blocks.STORAGE_BLOCKS)
			.addTag(STORAGE_BLOCKS_ARISTONE_PACKED)
			.addTag(STORAGE_BLOCKS_JELLYFISH_JELLY)
			.addTag(STORAGE_BLOCKS_ARACHNE_STRING)
			.addTag(STORAGE_BLOCKS_SPELT)
			.addTag(STORAGE_BLOCKS_VINE_REED)
			.addTag(STORAGE_BLOCKS_VINE_SPROUT)
			.addTag(STORAGE_BLOCKS_ROTTEN_BONES)
			.addTag(STORAGE_BLOCKS_RAW_CHALKOS)
			.addTag(STORAGE_BLOCKS_RAW_KASSITEROS)
			.addTag(STORAGE_BLOCKS_RAW_VANADIUM)
			.addTag(STORAGE_BLOCKS_RAW_SIDEROS)
			.addTag(STORAGE_BLOCKS_RAW_MOLYBDENUM)
			.addTag(STORAGE_BLOCKS_CALCITE)
			.addTag(STORAGE_BLOCKS_HALITE)
			.addTag(STORAGE_BLOCKS_JASPER)
			.addTag(STORAGE_BLOCKS_ZIRCON)
			.addTag(STORAGE_BLOCKS_CHERT)
			.addTag(STORAGE_BLOCKS_LIGNITE)
			.addTag(STORAGE_BLOCKS_CHALKOS)
			.addTag(STORAGE_BLOCKS_KASSITEROS)
			.addTag(STORAGE_BLOCKS_ORICHALCUM)
			.addTag(STORAGE_BLOCKS_VANADIUM)
			.addTag(STORAGE_BLOCKS_VANADIUMSTEEL)
			.addTag(STORAGE_BLOCKS_SLIVER)
			.addTag(STORAGE_BLOCKS_SIDEROS)
			.addTag(STORAGE_BLOCKS_ANTHRACITE)
			.addTag(STORAGE_BLOCKS_MOLYBDENUM)
			.addTag(STORAGE_BLOCKS_MOLYBDENUMSTEEL);

		tag(SAPLINGS_CYPRESS).add(IcariaBlocks.CYPRESS_SAPLING.get());
		tag(SAPLINGS_DROUGHTROOT).add(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		tag(SAPLINGS_FIR).add(IcariaBlocks.FIR_SAPLING.get());
		tag(SAPLINGS_LAUREL).add(IcariaBlocks.LAUREL_SAPLING.get());
		tag(SAPLINGS_OLIVE).add(IcariaBlocks.OLIVE_SAPLING.get());
		tag(SAPLINGS_PLANE).add(IcariaBlocks.PLANE_SAPLING.get());
		tag(SAPLINGS_POPULUS).add(IcariaBlocks.POPULUS_SAPLING.get());

		tag(BlockTags.SAPLINGS)
			.addTag(SAPLINGS_CYPRESS)
			.addTag(SAPLINGS_DROUGHTROOT)
			.addTag(SAPLINGS_FIR)
			.addTag(SAPLINGS_LAUREL)
			.addTag(SAPLINGS_OLIVE)
			.addTag(SAPLINGS_PLANE)
			.addTag(SAPLINGS_POPULUS);

		tag(LEAVES_CYPRESS).add(IcariaBlocks.CYPRESS_LEAVES.get());
		tag(LEAVES_DROUGHTROOT).add(IcariaBlocks.DROUGHTROOT_LEAVES.get());
		tag(LEAVES_FIR).add(IcariaBlocks.FIR_LEAVES.get());
		tag(LEAVES_LAUREL).add(IcariaBlocks.LAUREL_LEAVES.get());
		tag(LEAVES_OLIVE).add(IcariaBlocks.OLIVE_LEAVES.get()).add(IcariaBlocks.OLIVE_LEAVES_BLACK.get()).add(IcariaBlocks.OLIVE_LEAVES_GREEN.get());
		tag(LEAVES_PLANE).add(IcariaBlocks.PLANE_LEAVES.get());
		tag(LEAVES_POPULUS).add(IcariaBlocks.POPULUS_LEAVES.get());

		tag(BlockTags.LEAVES)
			.addTag(LEAVES_CYPRESS)
			.addTag(LEAVES_DROUGHTROOT)
			.addTag(LEAVES_FIR)
			.addTag(LEAVES_LAUREL)
			.addTag(LEAVES_OLIVE)
			.addTag(LEAVES_PLANE)
			.addTag(LEAVES_POPULUS);

		tag(BlockTags.REPLACEABLE_PLANTS)
			.add(IcariaBlocks.CYPRESS_TWIGS.get())
			.add(IcariaBlocks.DROUGHTROOT_TWIGS.get())
			.add(IcariaBlocks.FIR_TWIGS.get())
			.add(IcariaBlocks.LAUREL_TWIGS.get())
			.add(IcariaBlocks.OLIVE_TWIGS.get())
			.add(IcariaBlocks.PLANE_TWIGS.get())
			.add(IcariaBlocks.POPULUS_TWIGS.get());

		tag(LOGS_CYPRESS).add(IcariaBlocks.CYPRESS_LOG.get()).add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get()).add(IcariaBlocks.CYPRESS_WOOD.get()).add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		tag(LOGS_DROUGHTROOT).add(IcariaBlocks.DROUGHTROOT_LOG.get()).add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get()).add(IcariaBlocks.DROUGHTROOT_WOOD.get()).add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		tag(LOGS_FIR).add(IcariaBlocks.FIR_LOG.get()).add(IcariaBlocks.STRIPPED_FIR_LOG.get()).add(IcariaBlocks.FIR_WOOD.get()).add(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		tag(LOGS_LAUREL).add(IcariaBlocks.LAUREL_LOG.get()).add(IcariaBlocks.STRIPPED_LAUREL_LOG.get()).add(IcariaBlocks.LAUREL_WOOD.get()).add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		tag(LOGS_OLIVE).add(IcariaBlocks.OLIVE_LOG.get()).add(IcariaBlocks.STRIPPED_OLIVE_LOG.get()).add(IcariaBlocks.OLIVE_WOOD.get()).add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		tag(LOGS_PLANE).add(IcariaBlocks.PLANE_LOG.get()).add(IcariaBlocks.STRIPPED_PLANE_LOG.get()).add(IcariaBlocks.PLANE_WOOD.get()).add(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		tag(LOGS_POPULUS).add(IcariaBlocks.POPULUS_LOG.get()).add(IcariaBlocks.STRIPPED_POPULUS_LOG.get()).add(IcariaBlocks.POPULUS_WOOD.get()).add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());

		tag(BlockTags.LOGS)
			.addTag(LOGS_CYPRESS)
			.addTag(LOGS_DROUGHTROOT)
			.addTag(LOGS_FIR)
			.addTag(LOGS_LAUREL)
			.addTag(LOGS_OLIVE)
			.addTag(LOGS_PLANE)
			.addTag(LOGS_POPULUS);

		tag(BlockTags.LOGS_THAT_BURN)
			.addTag(LOGS_CYPRESS)
			.addTag(LOGS_DROUGHTROOT)
			.addTag(LOGS_FIR)
			.addTag(LOGS_LAUREL)
			.addTag(LOGS_OLIVE)
			.addTag(LOGS_PLANE)
			.addTag(LOGS_POPULUS);

		tag(PLANKS_CYPRESS).add(IcariaBlocks.CYPRESS_PLANKS.get());
		tag(PLANKS_DROUGHTROOT).add(IcariaBlocks.DROUGHTROOT_PLANKS.get());
		tag(PLANKS_FIR).add(IcariaBlocks.FIR_PLANKS.get());
		tag(PLANKS_LAUREL).add(IcariaBlocks.LAUREL_PLANKS.get());
		tag(PLANKS_OLIVE).add(IcariaBlocks.OLIVE_PLANKS.get());
		tag(PLANKS_PLANE).add(IcariaBlocks.PLANE_PLANKS.get());
		tag(PLANKS_POPULUS).add(IcariaBlocks.POPULUS_PLANKS.get());

		tag(BlockTags.PLANKS)
			.addTag(PLANKS_CYPRESS)
			.addTag(PLANKS_DROUGHTROOT)
			.addTag(PLANKS_FIR)
			.addTag(PLANKS_LAUREL)
			.addTag(PLANKS_OLIVE)
			.addTag(PLANKS_PLANE)
			.addTag(PLANKS_POPULUS);

		tag(WOODEN_DOORS_CYPRESS).add(IcariaBlocks.CYPRESS_DOOR.get());
		tag(WOODEN_DOORS_DROUGHTROOT).add(IcariaBlocks.DROUGHTROOT_DOOR.get());
		tag(WOODEN_DOORS_FIR).add(IcariaBlocks.FIR_DOOR.get());
		tag(WOODEN_DOORS_LAUREL).add(IcariaBlocks.LAUREL_DOOR.get());
		tag(WOODEN_DOORS_OLIVE).add(IcariaBlocks.OLIVE_DOOR.get());
		tag(WOODEN_DOORS_PLANE).add(IcariaBlocks.PLANE_DOOR.get());
		tag(WOODEN_DOORS_POPULUS).add(IcariaBlocks.POPULUS_DOOR.get());

		tag(BlockTags.WOODEN_DOORS)
			.addTag(WOODEN_DOORS_CYPRESS)
			.addTag(WOODEN_DOORS_DROUGHTROOT)
			.addTag(WOODEN_DOORS_FIR)
			.addTag(WOODEN_DOORS_LAUREL)
			.addTag(WOODEN_DOORS_OLIVE)
			.addTag(WOODEN_DOORS_PLANE)
			.addTag(WOODEN_DOORS_POPULUS);

		tag(WOODEN_TRAPDOORS_CYPRESS).add(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_DROUGHTROOT).add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_FIR).add(IcariaBlocks.FIR_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_LAUREL).add(IcariaBlocks.LAUREL_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_OLIVE).add(IcariaBlocks.OLIVE_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_PLANE).add(IcariaBlocks.PLANE_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_POPULUS).add(IcariaBlocks.POPULUS_TRAPDOOR.get());

		tag(BlockTags.WOODEN_TRAPDOORS)
			.addTag(WOODEN_TRAPDOORS_CYPRESS)
			.addTag(WOODEN_TRAPDOORS_DROUGHTROOT)
			.addTag(WOODEN_TRAPDOORS_FIR)
			.addTag(WOODEN_TRAPDOORS_LAUREL)
			.addTag(WOODEN_TRAPDOORS_OLIVE)
			.addTag(WOODEN_TRAPDOORS_PLANE)
			.addTag(WOODEN_TRAPDOORS_POPULUS);
	}

	public void addStoneDecoToTag(IcariaBlocks.StoneDecoBlocks deco, TagKey<Block> tag) {
		tag(tag).add(deco.SLAB.get()).add(deco.STAIRS.get()).add(deco.WALL.get());
	}

	public void addWoodDecoToTag(IcariaBlocks.WoodDecoBlocks deco, TagKey<Block> tag) {
		tag(tag).add(deco.SLAB.get()).add(deco.STAIRS.get()).add(deco.FENCE.get()).add(deco.GATE.get());
	}

	public static TagKey<Block> bind(String name) {
		return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(name));
	}

	public static TagKey<Block> forgeTag(String name) {
		return IcariaBlockTags.bind("forge:" + name);
	}

	public static TagKey<Block> icariaTag(String name) {
		return IcariaBlockTags.bind(IcariaInfo.MODID + ":" + name);
	}
}
