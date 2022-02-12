package com.axanthic.icaria.datagen;

import com.axanthic.icaria.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaBlocks.DecoBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaBlockTags extends BlockTagsProvider {

	public static final Tag.Named<Block> ICARIA_TIER = BlockTags.bind(IcariaInfo.MODID + ":icaria_tier");
	public static final Tag.Named<Block> NEEDS_CHERT_TOOL = BlockTags.bind(IcariaInfo.MODID + ":needs_chert_tool");
	public static final Tag.Named<Block> NEEDS_CHALKOS_TOOL = BlockTags.bind(IcariaInfo.MODID + ":needs_chalkos_tool");
	public static final Tag.Named<Block> NEEDS_KASSITEROS_TOOL = BlockTags.bind(IcariaInfo.MODID + ":needs_kassiteros_tool");
	public static final Tag.Named<Block> NEEDS_ORICHALCUM_TOOL = BlockTags.bind(IcariaInfo.MODID + ":needs_orichalcum_tool");
	public static final Tag.Named<Block> NEEDS_VANADIUMSTEEL_TOOL = BlockTags.bind(IcariaInfo.MODID + ":needs_vanadiumsteel_tool");
	public static final Tag.Named<Block> NEEDS_SIDEROS_TOOL = BlockTags.bind(IcariaInfo.MODID + ":needs_sideros_tool");
	public static final Tag.Named<Block> NEEDS_MOLYBDENUMSTEEL_TOOL = BlockTags.bind(IcariaInfo.MODID + ":needs_molybdenumsteel_tool");

	public static final Tag.Named<Block> MINEABLE_WITH_SCYTHE = BlockTags.bind(IcariaInfo.MODID + ":mineable/scythe");

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
	}

	public void addDecoToTag(DecoBlockCombination deco, Tag.Named<Block> tag) {
		tag(tag).add(deco.SLAB.get()).add(deco.STAIRS.get()).add(deco.WALL.get());
	}
}
