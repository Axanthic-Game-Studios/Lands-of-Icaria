package com.axanthic.icaria.datagen;

import com.axanthic.icaria.LandsOfIcariaInfo;
import com.axanthic.icaria.common.registry.LandsOfIcariaBlocks;
import com.axanthic.icaria.common.registry.LandsOfIcariaBlocks.DecoBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaBlockTags extends BlockTagsProvider {

	public static final Tag.Named<Block> ICARIA_TIER = BlockTags.bind(LandsOfIcariaInfo.MODID + ":icaria_tier");
	public static final Tag.Named<Block> NEEDS_CHERT_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_chert_tool");
	public static final Tag.Named<Block> NEEDS_CHALKOS_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_chalkos_tool");
	public static final Tag.Named<Block> NEEDS_KASSITEROS_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_kassiteros_tool");
	public static final Tag.Named<Block> NEEDS_ORICHALCUM_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_orichalcum_tool");
	public static final Tag.Named<Block> NEEDS_VANADIUMSTEEL_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_vanadiumsteel_tool");
	public static final Tag.Named<Block> NEEDS_SIDEROS_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_sideros_tool");
	public static final Tag.Named<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = BlockTags.bind(LandsOfIcariaInfo.MODID + ":needs_molybdenumsteel_tool");

	public static final Tag.Named<Block> MINEABLE_WITH_SCYTHE = BlockTags.bind(LandsOfIcariaInfo.MODID + ":mineable/scythe");

	public IcariaBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, LandsOfIcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		tag(ICARIA_TIER).addTag(NEEDS_CHERT_TOOL).addTag(NEEDS_CHALKOS_TOOL).addTag(NEEDS_KASSITEROS_TOOL).addTag(NEEDS_ORICHALCUM_TOOL).addTag(NEEDS_VANADIUMSTEEL_TOOL).addTag(NEEDS_SIDEROS_TOOL).addTag(NEEDS_MOLYBDENUMSTEEL_TOOL);
		tag(NEEDS_CHERT_TOOL)
		.add(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE.get()).add(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE.get()).add(LandsOfIcariaBlocks.YELLOWSTONE.get()).add(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS.get()).add(LandsOfIcariaBlocks.YELLOWSTONE_CHISELED.get())
		;
		addDecoToTag(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE_DECO, NEEDS_CHERT_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE_DECO, NEEDS_CHERT_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.YELLOWSTONE_DECO, NEEDS_CHERT_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS_DECO, NEEDS_CHERT_TOOL);
		tag(NEEDS_CHALKOS_TOOL)
		.add(LandsOfIcariaBlocks.DOLOMITE_ADOBE.get()).add(LandsOfIcariaBlocks.DOLOMITE_SMOOTH.get()).add(LandsOfIcariaBlocks.DOLOMITE_BRICKS.get()).add(LandsOfIcariaBlocks.DOLOMITE_PILLAR.get()).add(LandsOfIcariaBlocks.DOLOMITE_PILLAR_HEAD.get())
		.add(LandsOfIcariaBlocks.SILKSAND.get()).add(LandsOfIcariaBlocks.SILKGLASS.get()).add(LandsOfIcariaBlocks.SILKGLASS_PANE.get()).add(LandsOfIcariaBlocks.SILKGLASS.get())
		.add(LandsOfIcariaBlocks.SILKSTONE_ADOBE.get()).add(LandsOfIcariaBlocks.SILKSTONE_COBBLE.get()).add(LandsOfIcariaBlocks.SILKSTONE.get()).add(LandsOfIcariaBlocks.SILKSTONE_BRICKS.get()).add(LandsOfIcariaBlocks.SILKSTONE_CHISELED.get())
		;
		addDecoToTag(LandsOfIcariaBlocks.DOLOMITE_ADOBE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.DOLOMITE_SMOOTH_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.SILKSTONE_ADOBE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.SILKSTONE_COBBLE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.SILKSTONE_DECO, NEEDS_CHALKOS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.SILKSTONE_BRICKS_DECO, NEEDS_CHALKOS_TOOL);
		tag(NEEDS_KASSITEROS_TOOL);
		tag(NEEDS_ORICHALCUM_TOOL)
		.add(LandsOfIcariaBlocks.SUNSTONE_ADOBE.get()).add(LandsOfIcariaBlocks.SUNSTONE_COBBLE.get()).add(LandsOfIcariaBlocks.SUNSTONE.get()).add(LandsOfIcariaBlocks.SUNSTONE_BRICKS.get()).add(LandsOfIcariaBlocks.SUNSTONE_CHISELED.get())
		;
		addDecoToTag(LandsOfIcariaBlocks.SUNSTONE_ADOBE_DECO, NEEDS_ORICHALCUM_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.SUNSTONE_COBBLE_DECO, NEEDS_ORICHALCUM_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.SUNSTONE_DECO, NEEDS_ORICHALCUM_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.SUNSTONE_BRICKS_DECO, NEEDS_ORICHALCUM_TOOL);
		tag(NEEDS_VANADIUMSTEEL_TOOL)
		.add(LandsOfIcariaBlocks.VOIDSHALE_ADOBE.get()).add(LandsOfIcariaBlocks.VOIDSHALE_COBBLE.get()).add(LandsOfIcariaBlocks.VOIDSHALE.get()).add(LandsOfIcariaBlocks.VOIDSHALE_BRICKS.get()).add(LandsOfIcariaBlocks.VOIDSHALE_CHISELED.get())
		;
		addDecoToTag(LandsOfIcariaBlocks.VOIDSHALE_ADOBE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.VOIDSHALE_COBBLE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.VOIDSHALE_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.VOIDSHALE_BRICKS_DECO, NEEDS_VANADIUMSTEEL_TOOL);
		tag(NEEDS_SIDEROS_TOOL)
		.add(LandsOfIcariaBlocks.BAETYL_ADOBE.get()).add(LandsOfIcariaBlocks.BAETYL_COBBLE.get()).add(LandsOfIcariaBlocks.BAETYL.get()).add(LandsOfIcariaBlocks.BAETYL_BRICKS.get()).add(LandsOfIcariaBlocks.BAETYL_CHISELED.get())
		.add(LandsOfIcariaBlocks.ANTHRACITE_BLOCK.get())
		;
		addDecoToTag(LandsOfIcariaBlocks.BAETYL_ADOBE_DECO, NEEDS_SIDEROS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.BAETYL_COBBLE_DECO, NEEDS_SIDEROS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.BAETYL_DECO, NEEDS_SIDEROS_TOOL);
		addDecoToTag(LandsOfIcariaBlocks.BAETYL_BRICKS_DECO, NEEDS_SIDEROS_TOOL);
		tag(NEEDS_MOLYBDENUMSTEEL_TOOL);

		tag(MINEABLE_WITH_SCYTHE).addTag(BlockTags.MINEABLE_WITH_HOE).addTag(BlockTags.LEAVES).addTag(BlockTags.CROPS).addTag(BlockTags.REPLACEABLE_PLANTS);
	}

	public void addDecoToTag(DecoBlockCombination deco, Tag.Named<Block> tag) {
		tag(tag).add(deco.SLAB.get()).add(deco.STAIRS.get()).add(deco.WALL.get());
	}
}
