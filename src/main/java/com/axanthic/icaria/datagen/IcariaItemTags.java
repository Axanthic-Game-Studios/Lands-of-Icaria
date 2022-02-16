package com.axanthic.icaria.datagen;

import com.axanthic.icaria.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.DecoItemBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IcariaItemTags extends ItemTagsProvider {

	//block tags to copy
	public static final Named<Item> STORAGE_BLOCKS_LIGNITE = forgeTag("storage_blocks/lignite");
	public static final Named<Item> STORAGE_BLOCKS_ANTHRACITE = forgeTag("storage_blocks/anthracite");
	public static final Named<Item> STORAGE_BLOCKS_CHERT = forgeTag("storage_blocks/chert");

	public static final Named<Item> ORE_BEARING_GROUND_MARL = forgeTag("ore_bearing_ground/marl");
	public static final Named<Item> ORE_BEARING_GROUND_GRAINEL = forgeTag("ore_bearing_ground/grainel");
	public static final Named<Item> ORE_BEARING_GROUND_YELLOWSTONE = forgeTag("ore_bearing_ground/yellowstone");
	public static final Named<Item> ORE_BEARING_GROUND_SILKSTONE = forgeTag("ore_bearing_ground/silkstone");
	public static final Named<Item> ORE_BEARING_GROUND_SUNSTONE = forgeTag("ore_bearing_ground/sunstone");
	public static final Named<Item> ORE_BEARING_GROUND_VOIDSHALE = forgeTag("ore_bearing_ground/voidshale");
	public static final Named<Item> ORE_BEARING_GROUND_BAETYL = forgeTag("ore_bearing_ground/baetyl");

	public static final Named<Item> ORES_IN_GROUND_MARL = forgeTag("ores_in_ground/marl");
	public static final Named<Item> ORES_IN_GROUND_GRAINEL = forgeTag("ores_in_ground/grainel");
	public static final Named<Item> ORES_IN_GROUND_YELLOWSTONE = forgeTag("ores_in_ground/yellowstone");
	public static final Named<Item> ORES_IN_GROUND_SILKSTONE = forgeTag("ores_in_ground/silkstone");
	public static final Named<Item> ORES_IN_GROUND_SUNSTONE = forgeTag("ores_in_ground/sunstone");
	public static final Named<Item> ORES_IN_GROUND_VOIDSHALE = forgeTag("ores_in_ground/voidshale");
	public static final Named<Item> ORES_IN_GROUND_BAETYL = forgeTag("ores_in_ground/baetyl");

	public static final Named<Item> ORES_LIGNITE = forgeTag("ores/lignite");
	public static final Named<Item> ORES_ROTTEN_BONES = forgeTag("ores/rotten_bones");
	public static final Named<Item> ORES_CHERT = forgeTag("ores/chert");

	//item exclusive tags
	public static final Named<Item> SPELT = forgeTag("crops/spelt");
	public static final Named<Item> SMALL_DUST = forgeTag("small_dusts");
	public static final Named<Item> SMALL_DUST_CALCITE = forgeTag("small_dusts/calcite");
	public static final Named<Item> INGOTS_LOAM_BRICK = forgeTag("ingots/loam_brick");
	public static final Named<Item> GEMS_LIGNITE = forgeTag("gems/lignite");
	public static final Named<Item> GEMS_ANTHRACITE = forgeTag("gems/anthracite");
	public static final Named<Item> GEMS_DOLOMITE = forgeTag("gems/dolomite");
	public static final Named<Item> GEMS_CHERT = forgeTag("gems/chert");

	public IcariaItemTags(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
		super(gen, blockTags, IcariaInfo.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		//copying block tags
		for (DecoItemBlockCombination deco : IcariaItems.DECO_BLOCKS) {
			if (deco.SLAB != null) {
				tag(ItemTags.SLABS).add(deco.SLAB.get());
			}
			if (deco.STAIRS != null) {
				tag(ItemTags.STAIRS).add(deco.STAIRS.get());
			}
			if (deco.WALL != null) {
				tag(ItemTags.WALLS).add(deco.WALL.get());
			}
		}

		copy(IcariaBlockTags.STORAGE_BLOCKS_LIGNITE, STORAGE_BLOCKS_LIGNITE);
		copy(IcariaBlockTags.STORAGE_BLOCKS_ANTHRACITE, STORAGE_BLOCKS_ANTHRACITE);
		copy(IcariaBlockTags.STORAGE_BLOCKS_CHERT, STORAGE_BLOCKS_CHERT);
		tag(Tags.Items.STORAGE_BLOCKS).addTag(STORAGE_BLOCKS_LIGNITE).addTag(STORAGE_BLOCKS_ANTHRACITE).addTag(STORAGE_BLOCKS_CHERT);

		copy(IcariaBlockTags.ORE_BEARING_GROUND_MARL, ORE_BEARING_GROUND_MARL);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_GRAINEL, ORE_BEARING_GROUND_GRAINEL);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_YELLOWSTONE, ORE_BEARING_GROUND_YELLOWSTONE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_SILKSTONE, ORE_BEARING_GROUND_SILKSTONE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_SUNSTONE, ORE_BEARING_GROUND_SUNSTONE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_VOIDSHALE, ORE_BEARING_GROUND_VOIDSHALE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_BAETYL, ORE_BEARING_GROUND_BAETYL);

		copy(IcariaBlockTags.ORES_IN_GROUND_MARL, ORES_IN_GROUND_MARL);
		copy(IcariaBlockTags.ORES_IN_GROUND_GRAINEL, ORES_IN_GROUND_GRAINEL);
		copy(IcariaBlockTags.ORES_IN_GROUND_YELLOWSTONE, ORES_IN_GROUND_YELLOWSTONE);
		copy(IcariaBlockTags.ORES_IN_GROUND_SILKSTONE, ORES_IN_GROUND_SILKSTONE);
		copy(IcariaBlockTags.ORES_IN_GROUND_SUNSTONE, ORES_IN_GROUND_SUNSTONE);
		copy(IcariaBlockTags.ORES_IN_GROUND_VOIDSHALE, ORES_IN_GROUND_VOIDSHALE);
		copy(IcariaBlockTags.ORES_IN_GROUND_BAETYL, ORES_IN_GROUND_BAETYL);

		copy(IcariaBlockTags.ORES_LIGNITE, ORES_LIGNITE);
		copy(IcariaBlockTags.ORES_ROTTEN_BONES, ORES_ROTTEN_BONES);
		copy(IcariaBlockTags.ORES_CHERT, ORES_CHERT);

		tag(Tags.Items.ORES).addTag(ORES_LIGNITE).addTag(ORES_ROTTEN_BONES).addTag(ORES_CHERT);
		tag(Tags.Items.ORE_RATES_SINGULAR).addTag(ORES_LIGNITE).addTag(ORES_CHERT);
		tag(Tags.Items.ORE_RATES_DENSE).addTag(ORES_ROTTEN_BONES);

		tag(Tags.Items.STONE).add(IcariaItems.YELLOWSTONE.get())
		.add(IcariaItems.SILKSTONE.get())
		.add(IcariaItems.SUNSTONE.get())
		.add(IcariaItems.VOIDSHALE.get())
		.add(IcariaItems.BAETYL.get())
		.add(IcariaItems.RELICSTONE_SMOOTH.get());

		tag(Tags.Items.COBBLESTONE_NORMAL).add(IcariaItems.YELLOWSTONE_COBBLE.get())
		.add(IcariaItems.SILKSTONE_COBBLE.get())
		.add(IcariaItems.SUNSTONE_COBBLE.get())
		.add(IcariaItems.VOIDSHALE_COBBLE.get())
		.add(IcariaItems.BAETYL_COBBLE.get())
		.add(IcariaItems.RELICSTONE.get());

		tag(ItemTags.STONE_BRICKS).add(IcariaItems.YELLOWSTONE_BRICKS.get())
		.add(IcariaItems.SILKSTONE_BRICKS.get())
		.add(IcariaItems.SUNSTONE_BRICKS.get())
		.add(IcariaItems.VOIDSHALE_BRICKS.get())
		.add(IcariaItems.BAETYL_BRICKS.get())
		.add(IcariaItems.RELICSTONE_BRICKS.get());

		tag(Tags.Items.SAND).add(IcariaItems.GRAINEL.get()).add(IcariaItems.SILKSAND.get());
		tag(Tags.Items.GLASS_COLORLESS).add(IcariaItems.GRAINGLASS.get()).add(IcariaItems.SILKGLASS.get());
		tag(Tags.Items.GLASS_SILICA).add(IcariaItems.GRAINGLASS.get()).add(IcariaItems.SILKGLASS.get());
		tag(Tags.Items.GLASS_PANES).add(IcariaItems.GRAINGLASS_PANE.get()).add(IcariaItems.SILKGLASS_PANE.get()).add(IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get()).add(IcariaItems.SILKGLASS_PANE_HORIZONTAL.get());
		tag(Tags.Items.SANDSTONE).add(IcariaItems.GRAINITE.get());

		//adding item tags
		tag(ItemTags.STONE_CRAFTING_MATERIALS).add(IcariaItems.YELLOWSTONE_COBBLE.get())
		.add(IcariaItems.SILKSTONE_COBBLE.get())
		.add(IcariaItems.SUNSTONE_COBBLE.get())
		.add(IcariaItems.VOIDSHALE_COBBLE.get())
		.add(IcariaItems.BAETYL_COBBLE.get())
		.add(IcariaItems.RELICSTONE.get());
		tag(ItemTags.STONE_TOOL_MATERIALS).add(IcariaItems.YELLOWSTONE_COBBLE.get())
		.add(IcariaItems.SILKSTONE_COBBLE.get())
		.add(IcariaItems.SUNSTONE_COBBLE.get())
		.add(IcariaItems.VOIDSHALE_COBBLE.get())
		.add(IcariaItems.BAETYL_COBBLE.get())
		.add(IcariaItems.RELICSTONE.get());
		tag(Tags.Items.SLIMEBALLS).add(IcariaItems.JELLYFISH_JELLY.get());
		tag(Tags.Items.STRING).add(IcariaItems.ARACHNE_STRING.get());
		tag(Tags.Items.CROPS).addTag(SPELT);
		tag(SPELT).add(IcariaItems.SPELT.get());
		tag(SMALL_DUST).addTag(SMALL_DUST_CALCITE);
		tag(SMALL_DUST_CALCITE).add(IcariaItems.CALCITE_POWDER.get());
		tag(Tags.Items.INGOTS).addTag(INGOTS_LOAM_BRICK);
		tag(INGOTS_LOAM_BRICK).add(IcariaItems.LOAM_BRICK.get());
		tag(Tags.Items.GEMS).addTag(GEMS_LIGNITE).addTag(GEMS_ANTHRACITE).addTag(GEMS_DOLOMITE).addTag(GEMS_CHERT);
		tag(GEMS_LIGNITE).add(IcariaItems.LIGNITE.get());
		tag(GEMS_ANTHRACITE).add(IcariaItems.ANTHRACITE.get());
		tag(GEMS_DOLOMITE).add(IcariaItems.DOLOMITE.get());
		tag(GEMS_CHERT).add(IcariaItems.CHERT.get());
	}

	@SafeVarargs
	public final void addAllTags(Item item, Named<Item>... tags) {
		for (Named<Item> tag : tags) {
			tag(tag).add(item);
		}
	}

	public static Named<Item> icariaTag(String name) {
		return ItemTags.bind(IcariaInfo.MODID + ":" + name);
	}

	public static Named<Item> forgeTag(String name) {
		return ItemTags.bind("forge:" + name);
	}
}
