package com.axanthic.icaria.datagen;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaBlocks.StoneDecoBlocks;
import com.axanthic.icaria.common.registry.IcariaBlocks.WoodDecoBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.StoneDecoItemBlocks;
import com.axanthic.icaria.common.registry.IcariaItems.WoodDecoItemBlocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockTags extends BlockTagsProvider {

	//tags exclusive to blocks
	public static final Named<Block> ICARIA_TIER = icariaTag("icaria_tier");

	public static final Named<Block> NEEDS_CHERT_TOOL = icariaTag("needs_chert_tool");
	public static final Named<Block> NEEDS_CHALKOS_TOOL = icariaTag("needs_chalkos_tool");
	public static final Named<Block> NEEDS_KASSITEROS_TOOL = icariaTag("needs_kassiteros_tool");
	public static final Named<Block> NEEDS_ORICHALCUM_TOOL = icariaTag("needs_orichalcum_tool");
	public static final Named<Block> NEEDS_VANADIUMSTEEL_TOOL = icariaTag("needs_vanadiumsteel_tool");
	public static final Named<Block> NEEDS_SIDEROS_TOOL = icariaTag("needs_sideros_tool");
	public static final Named<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = icariaTag("needs_molybdenumsteel_tool");

	public static final Named<Block> MINEABLE_WITH_SCYTHE = icariaTag("mineable/scythe");

	//tags shared with items
	public static final Named<Block> STORAGE_BLOCKS_RAW_CHALKOS = forgeTag("storage_blocks/raw_chalkos");
	public static final Named<Block> STORAGE_BLOCKS_RAW_KASSITEROS = forgeTag("storage_blocks/raw_kassiteros");
	public static final Named<Block> STORAGE_BLOCKS_RAW_VANADIUM = forgeTag("storage_blocks/raw_vanadium");
	public static final Named<Block> STORAGE_BLOCKS_RAW_SIDEROS = forgeTag("storage_blocks/raw_sideros");
	public static final Named<Block> STORAGE_BLOCKS_RAW_MOLYBDENUM = forgeTag("storage_blocks/raw_molybdenum");
	public static final Named<Block> STORAGE_BLOCKS_CHERT = forgeTag("storage_blocks/chert");
	public static final Named<Block> STORAGE_BLOCKS_LIGNITE = forgeTag("storage_blocks/lignite");
	public static final Named<Block> STORAGE_BLOCKS_CHALKOS = forgeTag("storage_blocks/chalkos");
	public static final Named<Block> STORAGE_BLOCKS_KASSITEROS = forgeTag("storage_blocks/kassiteros");
	public static final Named<Block> STORAGE_BLOCKS_ORICHALCUM = forgeTag("storage_blocks/orichalcum");
	public static final Named<Block> STORAGE_BLOCKS_VANADIUM = forgeTag("storage_blocks/vanadium");
	public static final Named<Block> STORAGE_BLOCKS_VANADIUMSTEEL = forgeTag("storage_blocks/vanadiumsteel");
	public static final Named<Block> STORAGE_BLOCKS_SLIVER = forgeTag("storage_blocks/sliver");
	public static final Named<Block> STORAGE_BLOCKS_SIDEROS = forgeTag("storage_blocks/sideros");
	public static final Named<Block> STORAGE_BLOCKS_ANTHRACITE = forgeTag("storage_blocks/anthracite");
	public static final Named<Block> STORAGE_BLOCKS_MOLYBDENUM = forgeTag("storage_blocks/molybdenum");
	public static final Named<Block> STORAGE_BLOCKS_MOLYBDENUMSTEEL = forgeTag("storage_blocks/molybdenumsteel");

	public static final Named<Block> ORE_BEARING_GROUND_MARL = forgeTag("ore_bearing_ground/marl");
	public static final Named<Block> ORE_BEARING_GROUND_GRAINEL = forgeTag("ore_bearing_ground/grainel");
	public static final Named<Block> ORE_BEARING_GROUND_YELLOWSTONE = forgeTag("ore_bearing_ground/yellowstone");
	public static final Named<Block> ORE_BEARING_GROUND_SILKSTONE = forgeTag("ore_bearing_ground/silkstone");
	public static final Named<Block> ORE_BEARING_GROUND_SUNSTONE = forgeTag("ore_bearing_ground/sunstone");
	public static final Named<Block> ORE_BEARING_GROUND_VOIDSHALE = forgeTag("ore_bearing_ground/voidshale");
	public static final Named<Block> ORE_BEARING_GROUND_BAETYL = forgeTag("ore_bearing_ground/baetyl");

	public static final Named<Block> ORES_IN_GROUND_MARL = forgeTag("ores_in_ground/marl");
	public static final Named<Block> ORES_IN_GROUND_GRAINEL = forgeTag("ores_in_ground/grainel");
	public static final Named<Block> ORES_IN_GROUND_YELLOWSTONE = forgeTag("ores_in_ground/yellowstone");
	public static final Named<Block> ORES_IN_GROUND_SILKSTONE = forgeTag("ores_in_ground/silkstone");
	public static final Named<Block> ORES_IN_GROUND_SUNSTONE = forgeTag("ores_in_ground/sunstone");
	public static final Named<Block> ORES_IN_GROUND_VOIDSHALE = forgeTag("ores_in_ground/voidshale");
	public static final Named<Block> ORES_IN_GROUND_BAETYL = forgeTag("ores_in_ground/baetyl");

	public static final Named<Block> ORES_ROTTEN_BONES = forgeTag("ores/rotten_bones");
	public static final Named<Block> ORES_CHERT = forgeTag("ores/chert");
	public static final Named<Block> ORES_LIGNITE = forgeTag("ores/lignite");
	public static final Named<Block> ORES_CHALKOS = forgeTag("ores/chalkos");
	public static final Named<Block> ORES_KASSITEROS = forgeTag("ores/kassiteros");
	public static final Named<Block> ORES_DOLOMITE = forgeTag("ores/dolomite");
	public static final Named<Block> ORES_VANADIUM = forgeTag("ores/vanadium");
	public static final Named<Block> ORES_SLIVER = forgeTag("ores/sliver");
	public static final Named<Block> ORES_SIDEROS = forgeTag("ores/sideros");
	public static final Named<Block> ORES_ANTHRACITE = forgeTag("ores/anthracite");
	public static final Named<Block> ORES_MOLYBDENUM = forgeTag("ores/molybdenum");
	public static final Named<Block> ORES_HYLIASTRUM = forgeTag("ores/hyliastrum");

	public static final Named<Block> CYPRESS_LOGS = forgeTag("logs/cypress");
	public static final Named<Block> DROUGHTROOT_LOGS = forgeTag("logs/droughtroot");
	public static final Named<Block> FIR_LOGS = forgeTag("logs/fir");
	public static final Named<Block> LAUREL_LOGS = forgeTag("logs/laurel");
	public static final Named<Block> OLIVE_LOGS = forgeTag("logs/olive");
	public static final Named<Block> PLANE_LOGS = forgeTag("logs/plane");
	public static final Named<Block> POPULUS_LOGS = forgeTag("logs/populus");

	public static final Named<Block> CYPRESS_PLANKS = forgeTag("planks/cypress");
	public static final Named<Block> DROUGHTROOT_PLANKS  = forgeTag("planks/droughtroot");
	public static final Named<Block> FIR_PLANKS  = forgeTag("planks/fir");
	public static final Named<Block> LAUREL_PLANKS  = forgeTag("planks/laurel");
	public static final Named<Block> OLIVE_PLANKS  = forgeTag("planks/olive");
	public static final Named<Block> PLANE_PLANKS  = forgeTag("planks/plane");
	public static final Named<Block> POPULUS_PLANKS  = forgeTag("planks/populus");

	public IcariaBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, IcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
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
			.add(IcariaBlocks.VANADIUM_RAW_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get());

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
			.add(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());

		addStoneDecoToTag(IcariaBlocks.BAETYL_ADOBE_DECO, NEEDS_SIDEROS_TOOL);
		addStoneDecoToTag(IcariaBlocks.BAETYL_COBBLE_DECO, NEEDS_SIDEROS_TOOL);
		addStoneDecoToTag(IcariaBlocks.BAETYL_DECO, NEEDS_SIDEROS_TOOL);
		addStoneDecoToTag(IcariaBlocks.BAETYL_BRICKS_DECO, NEEDS_SIDEROS_TOOL);

		tag(NEEDS_MOLYBDENUMSTEEL_TOOL);

		tag(MINEABLE_WITH_SCYTHE)
			.addTag(BlockTags.MINEABLE_WITH_HOE)
			.addTag(BlockTags.LEAVES)
			.addTag(BlockTags.CROPS)
			.addTag(BlockTags.REPLACEABLE_PLANTS);

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
			.add(IcariaBlocks.DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get())
			.add(IcariaBlocks.DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get())
			.add(IcariaBlocks.DROUGHTROOT_PLANKS.get())
			.add(IcariaBlocks.FIR_WOOD.get())
			.add(IcariaBlocks.STRIPPED_FIR_WOOD.get())
			.add(IcariaBlocks.FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_FIR_LOG.get())
			.add(IcariaBlocks.DEAD_FIR_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get())
			.add(IcariaBlocks.FIR_PLANKS.get())
			.add(IcariaBlocks.LAUREL_WOOD.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get())
			.add(IcariaBlocks.LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get())
			.add(IcariaBlocks.DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get())
			.add(IcariaBlocks.LAUREL_PLANKS.get())
			.add(IcariaBlocks.OLIVE_WOOD.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get())
			.add(IcariaBlocks.OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get())
			.add(IcariaBlocks.DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get())
			.add(IcariaBlocks.OLIVE_PLANKS.get())
			.add(IcariaBlocks.CYPRESS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get())
			.add(IcariaBlocks.CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get())
			.add(IcariaBlocks.DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get())
			.add(IcariaBlocks.PLANE_PLANKS.get())
			.add(IcariaBlocks.POPULUS_WOOD.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get())
			.add(IcariaBlocks.POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get())
			.add(IcariaBlocks.DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get())
			.add(IcariaBlocks.POPULUS_PLANKS.get());
		
		addWoodDecoToTag(IcariaBlocks.CYPRESS_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.DROUGHTROOT_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.FIR_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.LAUREL_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.OLIVE_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.PLANE_DECO, BlockTags.MINEABLE_WITH_AXE);
		addWoodDecoToTag(IcariaBlocks.POPULUS_DECO, BlockTags.MINEABLE_WITH_AXE);
		
		tag(BlockTags.MINEABLE_WITH_HOE).add(IcariaBlocks.SPELT_BALE_BLOCK.get());
		
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
			.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get())
			.add(IcariaBlocks.CHALKOS_RAW_BLOCK.get())
			.add(IcariaBlocks.KASSITEROS_RAW_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_RAW_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_RAW_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get())
			.add(IcariaBlocks.CHERT_BLOCK.get())
			.add(IcariaBlocks.LIGNITE_BLOCK.get())
			.add(IcariaBlocks.CHALKOS_BLOCK.get())
			.add(IcariaBlocks.KASSITEROS_BLOCK.get())
			.add(IcariaBlocks.ORICHALCUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUM_BLOCK.get())
			.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get())
			.add(IcariaBlocks.SLIVER_BLOCK.get())
			.add(IcariaBlocks.SIDEROS_BLOCK.get())
			.add(IcariaBlocks.ANTHRACITE_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUM_BLOCK.get())
			.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());

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
			.add(IcariaBlocks.GRAINEL_CHERT.get())
			.add(IcariaBlocks.MOSS_0.get())
			.add(IcariaBlocks.MOSS_1.get())
			.add(IcariaBlocks.MOSS_2.get());

		//tags shared with items
		for (StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
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

		for (WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
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

		tag(STORAGE_BLOCKS_RAW_CHALKOS).add(IcariaBlocks.CHALKOS_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_KASSITEROS).add(IcariaBlocks.KASSITEROS_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_VANADIUM).add(IcariaBlocks.VANADIUM_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_SIDEROS).add(IcariaBlocks.SIDEROS_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_RAW_MOLYBDENUM).add(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get());
		tag(STORAGE_BLOCKS_CHERT).add(IcariaBlocks.CHERT_BLOCK.get());
		tag(STORAGE_BLOCKS_LIGNITE).add(IcariaBlocks.LIGNITE_BLOCK.get());
		tag(STORAGE_BLOCKS_CHALKOS).add(IcariaBlocks.CHALKOS_BLOCK.get());
		tag(STORAGE_BLOCKS_KASSITEROS).add(IcariaBlocks.KASSITEROS_BLOCK.get());
		tag(STORAGE_BLOCKS_ORICHALCUM).add(IcariaBlocks.ORICHALCUM_BLOCK.get());
		tag(STORAGE_BLOCKS_VANADIUM).add(IcariaBlocks.VANADIUM_BLOCK.get());
		tag(STORAGE_BLOCKS_VANADIUMSTEEL).add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get());
		tag(STORAGE_BLOCKS_SLIVER).add(IcariaBlocks.SLIVER_BLOCK.get());
		tag(STORAGE_BLOCKS_SIDEROS).add(IcariaBlocks.SIDEROS_BLOCK.get());
		tag(STORAGE_BLOCKS_ANTHRACITE).add(IcariaBlocks.ANTHRACITE_BLOCK.get());
		tag(STORAGE_BLOCKS_MOLYBDENUM).add(IcariaBlocks.MOLYBDENUM_BLOCK.get());
		tag(STORAGE_BLOCKS_MOLYBDENUMSTEEL).add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());

		tag(Tags.Blocks.STORAGE_BLOCKS)
			.addTag(STORAGE_BLOCKS_RAW_CHALKOS)
			.addTag(STORAGE_BLOCKS_RAW_KASSITEROS)
			.addTag(STORAGE_BLOCKS_RAW_VANADIUM)
			.addTag(STORAGE_BLOCKS_RAW_SIDEROS)
			.addTag(STORAGE_BLOCKS_RAW_MOLYBDENUM)
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

		tag(CYPRESS_LOGS).add(IcariaBlocks.CYPRESS_LOG.get()).add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get()).add(IcariaBlocks.CYPRESS_WOOD.get()).add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		tag(DROUGHTROOT_LOGS).add(IcariaBlocks.DROUGHTROOT_LOG.get()).add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get()).add(IcariaBlocks.DROUGHTROOT_WOOD.get()).add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		tag(FIR_LOGS).add(IcariaBlocks.FIR_LOG.get()).add(IcariaBlocks.STRIPPED_FIR_LOG.get()).add(IcariaBlocks.FIR_WOOD.get()).add(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		tag(LAUREL_LOGS).add(IcariaBlocks.LAUREL_LOG.get()).add(IcariaBlocks.STRIPPED_LAUREL_LOG.get()).add(IcariaBlocks.LAUREL_WOOD.get()).add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		tag(OLIVE_LOGS).add(IcariaBlocks.OLIVE_LOG.get()).add(IcariaBlocks.STRIPPED_OLIVE_LOG.get()).add(IcariaBlocks.OLIVE_WOOD.get()).add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		tag(PLANE_LOGS).add(IcariaBlocks.PLANE_LOG.get()).add(IcariaBlocks.STRIPPED_PLANE_LOG.get()).add(IcariaBlocks.PLANE_WOOD.get()).add(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		tag(POPULUS_LOGS).add(IcariaBlocks.POPULUS_LOG.get()).add(IcariaBlocks.STRIPPED_POPULUS_LOG.get()).add(IcariaBlocks.POPULUS_WOOD.get()).add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());

		tag(BlockTags.LOGS)
			.addTag(CYPRESS_LOGS)
			.addTag(DROUGHTROOT_LOGS)
			.addTag(FIR_LOGS)
			.addTag(LAUREL_LOGS)
			.addTag(OLIVE_LOGS)
			.addTag(PLANE_LOGS)
			.addTag(POPULUS_LOGS);

		tag(BlockTags.LOGS_THAT_BURN)
			.addTag(CYPRESS_LOGS)
			.addTag(DROUGHTROOT_LOGS)
			.addTag(FIR_LOGS)
			.addTag(LAUREL_LOGS)
			.addTag(OLIVE_LOGS)
			.addTag(PLANE_LOGS)
			.addTag(POPULUS_LOGS);

		tag(CYPRESS_PLANKS).add(IcariaBlocks.CYPRESS_PLANKS.get());
		tag(DROUGHTROOT_PLANKS).add(IcariaBlocks.DROUGHTROOT_PLANKS.get());
		tag(FIR_PLANKS).add(IcariaBlocks.FIR_PLANKS.get());
		tag(LAUREL_PLANKS).add(IcariaBlocks.LAUREL_PLANKS.get());
		tag(OLIVE_PLANKS).add(IcariaBlocks.OLIVE_PLANKS.get());
		tag(PLANE_PLANKS).add(IcariaBlocks.PLANE_PLANKS.get());
		tag(POPULUS_PLANKS).add(IcariaBlocks.POPULUS_PLANKS.get());

		tag(BlockTags.PLANKS)
			.addTag(CYPRESS_PLANKS)
			.addTag(DROUGHTROOT_PLANKS)
			.addTag(FIR_PLANKS)
			.addTag(LAUREL_PLANKS)
			.addTag(OLIVE_PLANKS)
			.addTag(PLANE_PLANKS)
			.addTag(POPULUS_PLANKS);

		tag(ORE_BEARING_GROUND_MARL).add(IcariaBlocks.MARL.get());
		tag(ORE_BEARING_GROUND_GRAINEL).add(IcariaBlocks.GRAINEL.get());
		tag(ORE_BEARING_GROUND_YELLOWSTONE).add(IcariaBlocks.YELLOWSTONE.get());
		tag(ORE_BEARING_GROUND_SILKSTONE).add(IcariaBlocks.SILKSTONE.get());
		tag(ORE_BEARING_GROUND_SUNSTONE).add(IcariaBlocks.SUNSTONE.get());
		tag(ORE_BEARING_GROUND_VOIDSHALE).add(IcariaBlocks.VOIDSHALE.get());
		tag(ORE_BEARING_GROUND_BAETYL).add(IcariaBlocks.BAETYL.get());

		tag(ORES_IN_GROUND_MARL).add(IcariaBlocks.MARL_LIGNITE.get()).add(IcariaBlocks.MARL_ROTTEN_BONES.get()).add(IcariaBlocks.MARL_CHERT.get());
		tag(ORES_IN_GROUND_GRAINEL).add(IcariaBlocks.GRAINEL_CHERT.get());
		tag(ORES_IN_GROUND_YELLOWSTONE).add(IcariaBlocks.LIGNITE_ORE.get()).add(IcariaBlocks.CHALKOS_ORE.get());
		tag(ORES_IN_GROUND_SILKSTONE).add(IcariaBlocks.KASSITEROS_ORE.get()).add(IcariaBlocks.DOLOMITE_ORE.get());
		tag(ORES_IN_GROUND_SUNSTONE).add(IcariaBlocks.VANADIUM_ORE.get()).add(IcariaBlocks.SLIVER_ORE.get());
		tag(ORES_IN_GROUND_VOIDSHALE).add(IcariaBlocks.SIDEROS_ORE.get()).add(IcariaBlocks.ANTHRACITE_ORE.get());
		tag(ORES_IN_GROUND_BAETYL).add(IcariaBlocks.MOLYBDENUM_ORE.get()).add(IcariaBlocks.HYLIASTRUM_ORE.get());

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

		tag(Tags.Blocks.STONE)
			.add(IcariaBlocks.YELLOWSTONE.get())
			.add(IcariaBlocks.SILKSTONE.get())
			.add(IcariaBlocks.SUNSTONE.get())
			.add(IcariaBlocks.VOIDSHALE.get())
			.add(IcariaBlocks.BAETYL.get())
			.add(IcariaBlocks.RELICSTONE_SMOOTH.get());

		tag(Tags.Blocks.COBBLESTONE_NORMAL)
			.add(IcariaBlocks.YELLOWSTONE_COBBLE.get())
			.add(IcariaBlocks.SILKSTONE_COBBLE.get())
			.add(IcariaBlocks.SUNSTONE_COBBLE.get())
			.add(IcariaBlocks.VOIDSHALE_COBBLE.get())
			.add(IcariaBlocks.BAETYL_COBBLE.get())
			.add(IcariaBlocks.RELICSTONE.get());

		tag(BlockTags.STONE_BRICKS)
			.add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
			.add(IcariaBlocks.SILKSTONE_BRICKS.get())
			.add(IcariaBlocks.SUNSTONE_BRICKS.get())
			.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
			.add(IcariaBlocks.BAETYL_BRICKS.get())
			.add(IcariaBlocks.RELICSTONE_BRICKS.get());

		tag(Tags.Blocks.SAND)
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
			.add(IcariaBlocks.SILKGLASS_PANE.get())
			.add(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get())
			.add(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());

		tag(Tags.Blocks.SANDSTONE).add(IcariaBlocks.GRAINITE.get());

		tag(BlockTags.WALL_POST_OVERRIDE)
			.add(IcariaBlocks.LIGNITE_TORCH.get())
			.add(IcariaBlocks.ANTHRACITE_TORCH.get());
	}

	public void addStoneDecoToTag(StoneDecoBlocks deco, Named<Block> tag) {
		tag(tag).add(deco.SLAB.get()).add(deco.STAIRS.get()).add(deco.WALL.get());
	}

	public void addWoodDecoToTag(WoodDecoBlocks deco, Named<Block> tag) {
		tag(tag).add(deco.SLAB.get()).add(deco.STAIRS.get()).add(deco.FENCE.get()).add(deco.GATE.get());
	}

	public static Named<Block> icariaTag(String name) {
		return BlockTags.bind(IcariaInfo.MODID + ":" + name);
	}

	public static Named<Block> forgeTag(String name) {
		return BlockTags.bind("forge:" + name);
	}
}
