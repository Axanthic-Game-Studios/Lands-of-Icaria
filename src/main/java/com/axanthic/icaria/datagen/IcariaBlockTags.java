package com.axanthic.icaria.datagen;

import com.axanthic.icaria.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaBlocks.DecoBlockCombination;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.DecoItemBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

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
	public static final Named<Block> STORAGE_BLOCKS_LIGNITE = forgeTag("storage_blocks/lignite");
	public static final Named<Block> STORAGE_BLOCKS_ANTHRACITE = forgeTag("storage_blocks/anthracite");
	public static final Named<Block> STORAGE_BLOCKS_CHERT = forgeTag("storage_blocks/chert");

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

	public static final Named<Block> ORES_LIGNITE = forgeTag("ores/lignite");
	public static final Named<Block> ORES_ROTTEN_BONES = forgeTag("ores/rotten_bones");
	public static final Named<Block> ORES_CHERT = forgeTag("ores/chert");

	public IcariaBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, IcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		tag(ICARIA_TIER).addTag(NEEDS_CHERT_TOOL).addTag(NEEDS_CHALKOS_TOOL).addTag(NEEDS_KASSITEROS_TOOL).addTag(NEEDS_ORICHALCUM_TOOL).addTag(NEEDS_VANADIUMSTEEL_TOOL).addTag(NEEDS_SIDEROS_TOOL).addTag(NEEDS_MOLYBDENUMSTEEL_TOOL);
		tag(NEEDS_CHERT_TOOL)
		.add(IcariaBlocks.YELLOWSTONE_ADOBE.get()).add(IcariaBlocks.YELLOWSTONE_COBBLE.get()).add(IcariaBlocks.YELLOWSTONE.get()).add(IcariaBlocks.YELLOWSTONE_BRICKS.get()).add(IcariaBlocks.YELLOWSTONE_CHISELED.get())
		;
		addDecoToTag(IcariaBlocks.YELLOWSTONE_ADOBE_DECO, NEEDS_CHERT_TOOL);
		addDecoToTag(IcariaBlocks.YELLOWSTONE_COBBLE_DECO, NEEDS_CHERT_TOOL);
		addDecoToTag(IcariaBlocks.YELLOWSTONE_DECO, NEEDS_CHERT_TOOL);
		addDecoToTag(IcariaBlocks.YELLOWSTONE_BRICKS_DECO, NEEDS_CHERT_TOOL);
		tag(NEEDS_CHALKOS_TOOL)
		.add(IcariaBlocks.DOLOMITE_ADOBE.get()).add(IcariaBlocks.DOLOMITE_SMOOTH.get()).add(IcariaBlocks.DOLOMITE_BRICKS.get()).add(IcariaBlocks.DOLOMITE_PILLAR.get()).add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
		.add(IcariaBlocks.SILKSAND.get()).add(IcariaBlocks.SILKGLASS.get()).add(IcariaBlocks.SILKGLASS_PANE.get()).add(IcariaBlocks.SILKGLASS.get())
		.add(IcariaBlocks.SILKSTONE_ADOBE.get()).add(IcariaBlocks.SILKSTONE_COBBLE.get()).add(IcariaBlocks.SILKSTONE.get()).add(IcariaBlocks.SILKSTONE_BRICKS.get()).add(IcariaBlocks.SILKSTONE_CHISELED.get())
		;
		addDecoToTag(IcariaBlocks.DOLOMITE_ADOBE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(IcariaBlocks.DOLOMITE_SMOOTH_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(IcariaBlocks.SILKSTONE_ADOBE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(IcariaBlocks.SILKSTONE_COBBLE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(IcariaBlocks.SILKSTONE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(IcariaBlocks.SILKSTONE_BRICKS_DECO, NEEDS_CHALKOS_TOOL);
		tag(NEEDS_KASSITEROS_TOOL);
		tag(NEEDS_ORICHALCUM_TOOL)
		.add(IcariaBlocks.SUNSTONE_ADOBE.get()).add(IcariaBlocks.SUNSTONE_COBBLE.get()).add(IcariaBlocks.SUNSTONE.get()).add(IcariaBlocks.SUNSTONE_BRICKS.get()).add(IcariaBlocks.SUNSTONE_CHISELED.get())
		;
		addDecoToTag(IcariaBlocks.SUNSTONE_ADOBE_DECO, NEEDS_ORICHALCUM_TOOL);
		addDecoToTag(IcariaBlocks.SUNSTONE_COBBLE_DECO, NEEDS_ORICHALCUM_TOOL);
		addDecoToTag(IcariaBlocks.SUNSTONE_DECO, NEEDS_ORICHALCUM_TOOL);
		addDecoToTag(IcariaBlocks.SUNSTONE_BRICKS_DECO, NEEDS_ORICHALCUM_TOOL);
		tag(NEEDS_VANADIUMSTEEL_TOOL)
		.add(IcariaBlocks.VOIDSHALE_ADOBE.get()).add(IcariaBlocks.VOIDSHALE_COBBLE.get()).add(IcariaBlocks.VOIDSHALE.get()).add(IcariaBlocks.VOIDSHALE_BRICKS.get()).add(IcariaBlocks.VOIDSHALE_CHISELED.get())
		;
		addDecoToTag(IcariaBlocks.VOIDSHALE_ADOBE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addDecoToTag(IcariaBlocks.VOIDSHALE_COBBLE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addDecoToTag(IcariaBlocks.VOIDSHALE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addDecoToTag(IcariaBlocks.VOIDSHALE_BRICKS_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		tag(NEEDS_SIDEROS_TOOL)
		.add(IcariaBlocks.BAETYL_ADOBE.get()).add(IcariaBlocks.BAETYL_COBBLE.get()).add(IcariaBlocks.BAETYL.get()).add(IcariaBlocks.BAETYL_BRICKS.get()).add(IcariaBlocks.BAETYL_CHISELED.get())
		.add(IcariaBlocks.ANTHRACITE_BLOCK.get())
		;
		addDecoToTag(IcariaBlocks.BAETYL_ADOBE_DECO, NEEDS_SIDEROS_TOOL);
		addDecoToTag(IcariaBlocks.BAETYL_COBBLE_DECO, NEEDS_SIDEROS_TOOL);
		addDecoToTag(IcariaBlocks.BAETYL_DECO, NEEDS_SIDEROS_TOOL);
		addDecoToTag(IcariaBlocks.BAETYL_BRICKS_DECO, NEEDS_SIDEROS_TOOL);
		tag(NEEDS_MOLYBDENUMSTEEL_TOOL);

		tag(MINEABLE_WITH_SCYTHE).addTag(BlockTags.MINEABLE_WITH_HOE).addTag(BlockTags.LEAVES).addTag(BlockTags.CROPS).addTag(BlockTags.REPLACEABLE_PLANTS);

		tag(BlockTags.MINEABLE_WITH_AXE).add(IcariaBlocks.VINE_REED_BLOCK.get()).add(IcariaBlocks.VINE_SPROUT_BLOCK.get());
		tag(BlockTags.MINEABLE_WITH_HOE).add(IcariaBlocks.SPELT_BALE_BLOCK.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(IcariaBlocks.MARL_ADOBE.get())
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
		.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get())
		.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get())
		.add(IcariaBlocks.LIGNITE_BLOCK.get())
		.add(IcariaBlocks.ANTHRACITE_BLOCK.get())
		.add(IcariaBlocks.CHERT_BLOCK.get());
		addDecoToTag(IcariaBlocks.MARL_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.LOAM_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.DOLOMITE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.DOLOMITE_SMOOTH_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.GRAINITE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.GRAINITE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.GRAINITE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.YELLOWSTONE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.YELLOWSTONE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.YELLOWSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.YELLOWSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SILKSTONE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SILKSTONE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SILKSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SILKSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SUNSTONE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SUNSTONE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SUNSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.SUNSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.VOIDSHALE_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.VOIDSHALE_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.VOIDSHALE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.VOIDSHALE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.BAETYL_ADOBE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.BAETYL_COBBLE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.BAETYL_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.BAETYL_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_SMOOTH_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_BRICKS_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_TILES_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_TILES_CRACKED_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		addDecoToTag(IcariaBlocks.RELICSTONE_TILES_MOSSY_DECO, BlockTags.MINEABLE_WITH_PICKAXE);
		tag(BlockTags.MINEABLE_WITH_SHOVEL).add(IcariaBlocks.MARL_GRASS.get())
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
		for (DecoItemBlockCombination deco : IcariaItems.DECO_BLOCKS) {
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

		tag(STORAGE_BLOCKS_LIGNITE).add(IcariaBlocks.LIGNITE_BLOCK.get());
		tag(STORAGE_BLOCKS_ANTHRACITE).add(IcariaBlocks.ANTHRACITE_BLOCK.get());
		tag(STORAGE_BLOCKS_CHERT).add(IcariaBlocks.CHERT_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(STORAGE_BLOCKS_LIGNITE).addTag(STORAGE_BLOCKS_ANTHRACITE).addTag(STORAGE_BLOCKS_CHERT);

		tag(ORE_BEARING_GROUND_MARL).add(IcariaBlocks.MARL.get());
		tag(ORE_BEARING_GROUND_GRAINEL).add(IcariaBlocks.GRAINEL.get());
		tag(ORE_BEARING_GROUND_YELLOWSTONE).add(IcariaBlocks.YELLOWSTONE.get());
		tag(ORE_BEARING_GROUND_SILKSTONE).add(IcariaBlocks.SILKSTONE.get());
		tag(ORE_BEARING_GROUND_SUNSTONE).add(IcariaBlocks.SUNSTONE.get());
		tag(ORE_BEARING_GROUND_VOIDSHALE).add(IcariaBlocks.VOIDSHALE.get());
		tag(ORE_BEARING_GROUND_BAETYL).add(IcariaBlocks.BAETYL.get());

		tag(ORES_IN_GROUND_MARL).add(IcariaBlocks.MARL_LIGNITE.get()).add(IcariaBlocks.MARL_ROTTEN_BONES.get()).add(IcariaBlocks.MARL_CHERT.get());
		tag(ORES_IN_GROUND_GRAINEL).add(IcariaBlocks.GRAINEL_CHERT.get());
		tag(ORES_IN_GROUND_YELLOWSTONE);
		tag(ORES_IN_GROUND_SILKSTONE);
		tag(ORES_IN_GROUND_SUNSTONE);
		tag(ORES_IN_GROUND_VOIDSHALE);
		tag(ORES_IN_GROUND_BAETYL);

		tag(ORES_LIGNITE).add(IcariaBlocks.MARL_LIGNITE.get());
		tag(ORES_ROTTEN_BONES).add(IcariaBlocks.MARL_ROTTEN_BONES.get());
		tag(ORES_CHERT).add(IcariaBlocks.MARL_CHERT.get()).add(IcariaBlocks.GRAINEL_CHERT.get());

		tag(Tags.Blocks.ORES).addTag(ORES_LIGNITE).addTag(ORES_ROTTEN_BONES).addTag(ORES_CHERT);
		tag(Tags.Blocks.ORE_RATES_SINGULAR).addTag(ORES_LIGNITE).addTag(ORES_CHERT);
		tag(Tags.Blocks.ORE_RATES_DENSE).addTag(ORES_ROTTEN_BONES);

		tag(Tags.Blocks.STONE).add(IcariaBlocks.YELLOWSTONE.get())
		.add(IcariaBlocks.SILKSTONE.get())
		.add(IcariaBlocks.SUNSTONE.get())
		.add(IcariaBlocks.VOIDSHALE.get())
		.add(IcariaBlocks.BAETYL.get())
		.add(IcariaBlocks.RELICSTONE_SMOOTH.get());

		tag(Tags.Blocks.COBBLESTONE_NORMAL).add(IcariaBlocks.YELLOWSTONE_COBBLE.get())
		.add(IcariaBlocks.SILKSTONE_COBBLE.get())
		.add(IcariaBlocks.SUNSTONE_COBBLE.get())
		.add(IcariaBlocks.VOIDSHALE_COBBLE.get())
		.add(IcariaBlocks.BAETYL_COBBLE.get())
		.add(IcariaBlocks.RELICSTONE.get());

		tag(BlockTags.STONE_BRICKS).add(IcariaBlocks.YELLOWSTONE_BRICKS.get())
		.add(IcariaBlocks.SILKSTONE_BRICKS.get())
		.add(IcariaBlocks.SUNSTONE_BRICKS.get())
		.add(IcariaBlocks.VOIDSHALE_BRICKS.get())
		.add(IcariaBlocks.BAETYL_BRICKS.get())
		.add(IcariaBlocks.RELICSTONE_BRICKS.get());

		tag(Tags.Blocks.SAND).add(IcariaBlocks.GRAINEL.get()).add(IcariaBlocks.SILKSAND.get());
		tag(Tags.Blocks.GLASS_COLORLESS).add(IcariaBlocks.GRAINGLASS.get()).add(IcariaBlocks.SILKGLASS.get());
		tag(Tags.Blocks.GLASS_SILICA).add(IcariaBlocks.GRAINGLASS.get()).add(IcariaBlocks.SILKGLASS.get());
		tag(Tags.Blocks.GLASS_PANES).add(IcariaBlocks.GRAINGLASS_PANE.get()).add(IcariaBlocks.SILKGLASS_PANE.get()).add(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get()).add(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());
		tag(Tags.Blocks.SANDSTONE).add(IcariaBlocks.GRAINITE.get());
	}

	public void addDecoToTag(DecoBlockCombination deco, Named<Block> tag) {
		tag(tag).add(deco.SLAB.get()).add(deco.STAIRS.get()).add(deco.WALL.get());
	}

	public static Named<Block> icariaTag(String name) {
		return BlockTags.bind(IcariaInfo.MODID + ":" + name);
	}

	public static Named<Block> forgeTag(String name) {
		return BlockTags.bind("forge:" + name);
	}
}
