package com.axanthic.icaria.datagen;

import com.axanthic.icaria.util.IcariaInfo;
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
	public static final Named<Item> STORAGE_BLOCKS_RAW_CHALKOS = forgeTag("storage_blocks/raw_chalkos");
	public static final Named<Item> STORAGE_BLOCKS_RAW_KASSITEROS = forgeTag("storage_blocks/raw_kassiteros");
	public static final Named<Item> STORAGE_BLOCKS_RAW_VANADIUM = forgeTag("storage_blocks/raw_vanadium");
	public static final Named<Item> STORAGE_BLOCKS_RAW_SIDEROS = forgeTag("storage_blocks/raw_sideros");
	public static final Named<Item> STORAGE_BLOCKS_RAW_MOLYBDENUM = forgeTag("storage_blocks/raw_molybdenum");

	public static final Named<Item> STORAGE_BLOCKS_CHERT = forgeTag("storage_blocks/chert");
	public static final Named<Item> STORAGE_BLOCKS_LIGNITE = forgeTag("storage_blocks/lignite");
	public static final Named<Item> STORAGE_BLOCKS_CHALKOS = forgeTag("storage_blocks/chalkos");
	public static final Named<Item> STORAGE_BLOCKS_KASSITEROS = forgeTag("storage_blocks/kassiteros");
	public static final Named<Item> STORAGE_BLOCKS_ORICHALCUM = forgeTag("storage_blocks/orichalcum");
	public static final Named<Item> STORAGE_BLOCKS_VANADIUM = forgeTag("storage_blocks/vanadium");
	public static final Named<Item> STORAGE_BLOCKS_VANADIUMSTEEL = forgeTag("storage_blocks/vanadiumsteel");
	public static final Named<Item> STORAGE_BLOCKS_SLIVER = forgeTag("storage_blocks/sliver");
	public static final Named<Item> STORAGE_BLOCKS_SIDEROS = forgeTag("storage_blocks/sideros");
	public static final Named<Item> STORAGE_BLOCKS_ANTHRACITE = forgeTag("storage_blocks/anthracite");
	public static final Named<Item> STORAGE_BLOCKS_MOLYBDENUM = forgeTag("storage_blocks/molybdenum");
	public static final Named<Item> STORAGE_BLOCKS_MOLYBDENUMSTEEL = forgeTag("storage_blocks/molybdenumsteel");

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

	public static final Named<Item> ORES_ROTTEN_BONES = forgeTag("ores/rotten_bones");
	public static final Named<Item> ORES_CHERT = forgeTag("ores/chert");
	public static final Named<Item> ORES_LIGNITE = forgeTag("ores/lignite");
	public static final Named<Item> ORES_CHALKOS = forgeTag("ores/chalkos");
	public static final Named<Item> ORES_KASSITEROS = forgeTag("ores/kassiteros");
	public static final Named<Item> ORES_DOLOMITE = forgeTag("ores/dolomite");
	public static final Named<Item> ORES_VANADIUM = forgeTag("ores/vanadium");
	public static final Named<Item> ORES_SLIVER = forgeTag("ores/sliver");
	public static final Named<Item> ORES_SIDEROS = forgeTag("ores/sideros");
	public static final Named<Item> ORES_ANTHRACITE = forgeTag("ores/anthracite");
	public static final Named<Item> ORES_MOLYBDENUM = forgeTag("ores/molybdenum");
	public static final Named<Item> ORES_HYLIASTRUM = forgeTag("ores/hyliastrum");

	//item exclusive tags
	public static final Named<Item> SPELT = forgeTag("crops/spelt");
	public static final Named<Item> SMALL_DUST = forgeTag("small_dusts");
	public static final Named<Item> SMALL_DUST_CALCITE = forgeTag("small_dusts/calcite");
	public static final Named<Item> NUGGETS_CHALKOS = forgeTag("nuggets/chalkos");
	public static final Named<Item> NUGGETS_KASSITEROS = forgeTag("nuggets/kassiteros");
	public static final Named<Item> NUGGETS_ORICHALCUM = forgeTag("nuggets/orichalcum");
	public static final Named<Item> NUGGETS_VANADIUM = forgeTag("nuggets/vanadium");
	public static final Named<Item> NUGGETS_VANADIUMSTEEL = forgeTag("nuggets/vanadiumsteel");
	public static final Named<Item> NUGGETS_SIDEROS = forgeTag("nuggets/sideros");
	public static final Named<Item> NUGGETS_MOLYBDENUM = forgeTag("nuggets/molybdenum");
	public static final Named<Item> NUGGETS_MOLYBDENUMSTEEL = forgeTag("nuggets/molybdenumsteel");
	public static final Named<Item> INGOTS_LOAM_BRICK = forgeTag("ingots/loam_brick");
	public static final Named<Item> INGOTS_CHALKOS = forgeTag("ingots/chalkos");
	public static final Named<Item> INGOTS_KASSITEROS = forgeTag("ingots/kassiteros");
	public static final Named<Item> INGOTS_ORICHALCUM = forgeTag("ingots/orichalcum");
	public static final Named<Item> INGOTS_VANADIUM = forgeTag("ingots/vanadium");
	public static final Named<Item> INGOTS_VANADIUMSTEEL = forgeTag("ingots/vanadiumsteel");
	public static final Named<Item> INGOTS_SIDEROS = forgeTag("ingots/sideros");
	public static final Named<Item> INGOTS_MOLYBDENUM = forgeTag("ingots/molybdenum");
	public static final Named<Item> INGOTS_MOLYBDENUMSTEEL = forgeTag("ingots/molybdenumsteel");
	public static final Named<Item> GEMS_CHERT = forgeTag("gems/chert");
	public static final Named<Item> GEMS_LIGNITE = forgeTag("gems/lignite");
	public static final Named<Item> GEMS_DOLOMITE = forgeTag("gems/dolomite");
	public static final Named<Item> GEMS_SLIVER = forgeTag("gems/sliver");
	public static final Named<Item> GEMS_ANTHRACITE = forgeTag("gems/anthracite");

	public static final Named<Item> RAW_MATERIALS_CHALKOS = forgeTag("raw_materials/chalkos");
	public static final Named<Item> RAW_MATERIALS_KASSITEROS = forgeTag("raw_materials/kassiteros");
	public static final Named<Item> RAW_MATERIALS_VANADIUM = forgeTag("raw_materials/vanadium");
	public static final Named<Item> RAW_MATERIALS_SIDEROS = forgeTag("raw_materials/sideros");
	public static final Named<Item> RAW_MATERIALS_MOLYBDENUM = forgeTag("raw_materials/molybdenum");

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

		tag(Tags.Items.STORAGE_BLOCKS)
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

		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_CHALKOS, STORAGE_BLOCKS_RAW_CHALKOS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_KASSITEROS, STORAGE_BLOCKS_RAW_KASSITEROS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_VANADIUM, STORAGE_BLOCKS_RAW_VANADIUM);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_SIDEROS, STORAGE_BLOCKS_RAW_SIDEROS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_MOLYBDENUM, STORAGE_BLOCKS_RAW_MOLYBDENUM);
		copy(IcariaBlockTags.STORAGE_BLOCKS_CHERT, STORAGE_BLOCKS_CHERT);
		copy(IcariaBlockTags.STORAGE_BLOCKS_LIGNITE, STORAGE_BLOCKS_LIGNITE);
		copy(IcariaBlockTags.STORAGE_BLOCKS_CHALKOS, STORAGE_BLOCKS_CHALKOS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_KASSITEROS, STORAGE_BLOCKS_KASSITEROS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_ORICHALCUM, STORAGE_BLOCKS_ORICHALCUM);
		copy(IcariaBlockTags.STORAGE_BLOCKS_VANADIUM, STORAGE_BLOCKS_VANADIUM);
		copy(IcariaBlockTags.STORAGE_BLOCKS_VANADIUMSTEEL, STORAGE_BLOCKS_VANADIUMSTEEL);
		copy(IcariaBlockTags.STORAGE_BLOCKS_SLIVER, STORAGE_BLOCKS_SLIVER);
		copy(IcariaBlockTags.STORAGE_BLOCKS_SIDEROS, STORAGE_BLOCKS_SIDEROS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_ANTHRACITE, STORAGE_BLOCKS_ANTHRACITE);
		copy(IcariaBlockTags.STORAGE_BLOCKS_MOLYBDENUM, STORAGE_BLOCKS_MOLYBDENUM);
		copy(IcariaBlockTags.STORAGE_BLOCKS_MOLYBDENUMSTEEL, STORAGE_BLOCKS_MOLYBDENUMSTEEL);

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

		copy(IcariaBlockTags.ORES_ROTTEN_BONES, ORES_ROTTEN_BONES);
		copy(IcariaBlockTags.ORES_CHERT, ORES_CHERT);
		copy(IcariaBlockTags.ORES_LIGNITE, ORES_LIGNITE);
		copy(IcariaBlockTags.ORES_CHALKOS, ORES_CHALKOS);
		copy(IcariaBlockTags.ORES_KASSITEROS, ORES_KASSITEROS);
		copy(IcariaBlockTags.ORES_DOLOMITE, ORES_DOLOMITE);
		copy(IcariaBlockTags.ORES_VANADIUM, ORES_VANADIUM);
		copy(IcariaBlockTags.ORES_SLIVER, ORES_SLIVER);
		copy(IcariaBlockTags.ORES_SIDEROS, ORES_SIDEROS);
		copy(IcariaBlockTags.ORES_ANTHRACITE, ORES_ANTHRACITE);
		copy(IcariaBlockTags.ORES_MOLYBDENUM, ORES_MOLYBDENUM);
		copy(IcariaBlockTags.ORES_HYLIASTRUM, ORES_HYLIASTRUM);

		tag(Tags.Items.ORES)
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

		tag(Tags.Items.ORE_RATES_SINGULAR)
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

		tag(Tags.Items.NUGGETS)
		.addTag(NUGGETS_CHALKOS)
		.addTag(NUGGETS_KASSITEROS)
		.addTag(NUGGETS_ORICHALCUM)
		.addTag(NUGGETS_VANADIUM)
		.addTag(NUGGETS_VANADIUMSTEEL)
		.addTag(NUGGETS_SIDEROS)
		.addTag(NUGGETS_MOLYBDENUM)
		.addTag(NUGGETS_MOLYBDENUMSTEEL);

		tag(NUGGETS_CHALKOS).add(IcariaItems.CHALKOS_NUGGET.get());
		tag(NUGGETS_KASSITEROS).add(IcariaItems.KASSITEROS_NUGGET.get());
		tag(NUGGETS_ORICHALCUM).add(IcariaItems.ORICHALCUM_NUGGET.get());
		tag(NUGGETS_VANADIUM).add(IcariaItems.VANADIUM_NUGGET.get());
		tag(NUGGETS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_NUGGET.get());
		tag(NUGGETS_SIDEROS).add(IcariaItems.SIDEROS_NUGGET.get());
		tag(NUGGETS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_NUGGET.get());
		tag(NUGGETS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		
		tag(Tags.Items.INGOTS)
		.addTag(INGOTS_LOAM_BRICK)
		.addTag(INGOTS_CHALKOS)
		.addTag(INGOTS_KASSITEROS)
		.addTag(INGOTS_ORICHALCUM)
		.addTag(INGOTS_VANADIUM)
		.addTag(INGOTS_VANADIUMSTEEL)
		.addTag(INGOTS_SIDEROS)
		.addTag(INGOTS_MOLYBDENUM)
		.addTag(INGOTS_MOLYBDENUMSTEEL);

		tag(INGOTS_LOAM_BRICK).add(IcariaItems.LOAM_BRICK.get());
		tag(INGOTS_CHALKOS).add(IcariaItems.CHALKOS_INGOT.get());
		tag(INGOTS_KASSITEROS).add(IcariaItems.KASSITEROS_INGOT.get());
		tag(INGOTS_ORICHALCUM).add(IcariaItems.ORICHALCUM_INGOT.get());
		tag(INGOTS_VANADIUM).add(IcariaItems.VANADIUM_INGOT.get());
		tag(INGOTS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_INGOT.get());
		tag(INGOTS_SIDEROS).add(IcariaItems.SIDEROS_INGOT.get());
		tag(INGOTS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_INGOT.get());
		tag(INGOTS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());

		tag(Tags.Items.GEMS)
		.addTag(GEMS_CHERT)
		.addTag(GEMS_LIGNITE)
		.addTag(GEMS_DOLOMITE)
		.addTag(GEMS_SLIVER)
		.addTag(GEMS_ANTHRACITE);

		tag(GEMS_CHERT).add(IcariaItems.CHERT.get());
		tag(GEMS_LIGNITE).add(IcariaItems.LIGNITE.get());
		tag(GEMS_DOLOMITE).add(IcariaItems.DOLOMITE.get());
		tag(GEMS_SLIVER).add(IcariaItems.SLIVER.get());
		tag(GEMS_ANTHRACITE).add(IcariaItems.ANTHRACITE.get());

		tag(Tags.Items.RAW_MATERIALS)
		.addTag(RAW_MATERIALS_CHALKOS)
		.addTag(RAW_MATERIALS_KASSITEROS)
		.addTag(RAW_MATERIALS_VANADIUM)
		.addTag(RAW_MATERIALS_SIDEROS)
		.addTag(RAW_MATERIALS_MOLYBDENUM);

		tag(RAW_MATERIALS_CHALKOS).add(IcariaItems.CHALKOS_RAW.get());
		tag(RAW_MATERIALS_KASSITEROS).add(IcariaItems.KASSITEROS_RAW.get());
		tag(RAW_MATERIALS_VANADIUM).add(IcariaItems.VANADIUM_RAW.get());
		tag(RAW_MATERIALS_SIDEROS).add(IcariaItems.SIDEROS_RAW.get());
		tag(RAW_MATERIALS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_RAW.get());
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
