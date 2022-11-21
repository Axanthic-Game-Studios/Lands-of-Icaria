package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemTags extends ItemTagsProvider {
	// ITEM TAGS
	public static final TagKey<Item> SPELT = forgeTag("crops/spelt");
	public static final TagKey<Item> GARLIC = forgeTag("crops/garlic");
	public static final TagKey<Item> ONION = forgeTag("crops/onion");

	public static final TagKey<Item> GEMS_CHERT = forgeTag("gems/chert");
	public static final TagKey<Item> GEMS_LIGNITE = forgeTag("gems/lignite");
	public static final TagKey<Item> GEMS_DOLOMITE = forgeTag("gems/dolomite");
	public static final TagKey<Item> GEMS_SLIVER = forgeTag("gems/sliver");
	public static final TagKey<Item> GEMS_ANTHRACITE = forgeTag("gems/anthracite");
	public static final TagKey<Item> GEMS_CALCITE = forgeTag("gems/calcite");
	public static final TagKey<Item> GEMS_HALITE = forgeTag("gems/halite");
	public static final TagKey<Item> GEMS_JASPER = forgeTag("gems/jasper");
	public static final TagKey<Item> GEMS_ZIRCON = forgeTag("gems/zircon");

	public static final TagKey<Item> SMALL_DUST = forgeTag("small_dusts");
	public static final TagKey<Item> SMALL_DUST_CALCITE = forgeTag("small_dusts/calcite");
	public static final TagKey<Item> SMALL_DUST_HALITE = forgeTag("small_dusts/halite");

	public static final TagKey<Item> RAW_MATERIALS_CHALKOS = forgeTag("raw_materials/chalkos");
	public static final TagKey<Item> RAW_MATERIALS_KASSITEROS = forgeTag("raw_materials/kassiteros");
	public static final TagKey<Item> RAW_MATERIALS_VANADIUM = forgeTag("raw_materials/vanadium");
	public static final TagKey<Item> RAW_MATERIALS_SIDEROS = forgeTag("raw_materials/sideros");
	public static final TagKey<Item> RAW_MATERIALS_MOLYBDENUM = forgeTag("raw_materials/molybdenum");

	public static final TagKey<Item> NUGGETS_CHALKOS = forgeTag("nuggets/chalkos");
	public static final TagKey<Item> NUGGETS_KASSITEROS = forgeTag("nuggets/kassiteros");
	public static final TagKey<Item> NUGGETS_ORICHALCUM = forgeTag("nuggets/orichalcum");
	public static final TagKey<Item> NUGGETS_VANADIUM = forgeTag("nuggets/vanadium");
	public static final TagKey<Item> NUGGETS_VANADIUMSTEEL = forgeTag("nuggets/vanadiumsteel");
	public static final TagKey<Item> NUGGETS_SIDEROS = forgeTag("nuggets/sideros");
	public static final TagKey<Item> NUGGETS_MOLYBDENUM = forgeTag("nuggets/molybdenum");
	public static final TagKey<Item> NUGGETS_MOLYBDENUMSTEEL = forgeTag("nuggets/molybdenumsteel");
	public static final TagKey<Item> NUGGETS_BLURIDIUM = forgeTag("nuggets/bluridium");

	public static final TagKey<Item> INGOTS_LOAM_BRICK = forgeTag("ingots/loam_brick");
	public static final TagKey<Item> INGOTS_CHALKOS = forgeTag("ingots/chalkos");
	public static final TagKey<Item> INGOTS_KASSITEROS = forgeTag("ingots/kassiteros");
	public static final TagKey<Item> INGOTS_ORICHALCUM = forgeTag("ingots/orichalcum");
	public static final TagKey<Item> INGOTS_VANADIUM = forgeTag("ingots/vanadium");
	public static final TagKey<Item> INGOTS_VANADIUMSTEEL = forgeTag("ingots/vanadiumsteel");
	public static final TagKey<Item> INGOTS_SIDEROS = forgeTag("ingots/sideros");
	public static final TagKey<Item> INGOTS_MOLYBDENUM = forgeTag("ingots/molybdenum");
	public static final TagKey<Item> INGOTS_MOLYBDENUMSTEEL = forgeTag("ingots/molybdenumsteel");
	public static final TagKey<Item> INGOTS_BLURIDIUM = forgeTag("ingots/bluridium");

	public static final TagKey<Item> VINES = forgeTag("vines");

	public static final TagKey<Item> LEATHER_AETERNAE_HIDE = forgeTag("leather/aeternae_hide");

	// ITEMBLOCK TAGS
	public static final TagKey<Item> ORES_ROTTEN_BONES = forgeTag("ores/rotten_bones");
	public static final TagKey<Item> ORES_CHERT = forgeTag("ores/chert");
	public static final TagKey<Item> ORES_LIGNITE = forgeTag("ores/lignite");
	public static final TagKey<Item> ORES_CHALKOS = forgeTag("ores/chalkos");
	public static final TagKey<Item> ORES_KASSITEROS = forgeTag("ores/kassiteros");
	public static final TagKey<Item> ORES_DOLOMITE = forgeTag("ores/dolomite");
	public static final TagKey<Item> ORES_VANADIUM = forgeTag("ores/vanadium");
	public static final TagKey<Item> ORES_SLIVER = forgeTag("ores/sliver");
	public static final TagKey<Item> ORES_SIDEROS = forgeTag("ores/sideros");
	public static final TagKey<Item> ORES_ANTHRACITE = forgeTag("ores/anthracite");
	public static final TagKey<Item> ORES_MOLYBDENUM = forgeTag("ores/molybdenum");
	public static final TagKey<Item> ORES_HYLIASTRUM = forgeTag("ores/hyliastrum");
	public static final TagKey<Item> ORES_BLURIDIUM = forgeTag("ores/bluridium");

	public static final TagKey<Item> ORES_IN_GROUND_MARL = forgeTag("ores_in_ground/marl");
	public static final TagKey<Item> ORES_IN_GROUND_GRAINEL = forgeTag("ores_in_ground/grainel");
	public static final TagKey<Item> ORES_IN_GROUND_YELLOWSTONE = forgeTag("ores_in_ground/yellowstone");
	public static final TagKey<Item> ORES_IN_GROUND_SILKSTONE = forgeTag("ores_in_ground/silkstone");
	public static final TagKey<Item> ORES_IN_GROUND_SUNSTONE = forgeTag("ores_in_ground/sunstone");
	public static final TagKey<Item> ORES_IN_GROUND_VOIDSHALE = forgeTag("ores_in_ground/voidshale");
	public static final TagKey<Item> ORES_IN_GROUND_BAETYL = forgeTag("ores_in_ground/baetyl");
	public static final TagKey<Item> ORES_IN_GROUND_PLATOSHALE = forgeTag("ores_in_ground/platoshale");

	public static final TagKey<Item> ORE_BEARING_GROUND_MARL = forgeTag("ore_bearing_ground/marl");
	public static final TagKey<Item> ORE_BEARING_GROUND_GRAINEL = forgeTag("ore_bearing_ground/grainel");
	public static final TagKey<Item> ORE_BEARING_GROUND_YELLOWSTONE = forgeTag("ore_bearing_ground/yellowstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SILKSTONE = forgeTag("ore_bearing_ground/silkstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_SUNSTONE = forgeTag("ore_bearing_ground/sunstone");
	public static final TagKey<Item> ORE_BEARING_GROUND_VOIDSHALE = forgeTag("ore_bearing_ground/voidshale");
	public static final TagKey<Item> ORE_BEARING_GROUND_BAETYL = forgeTag("ore_bearing_ground/baetyl");
	public static final TagKey<Item> ORE_BEARING_GROUND_PLATOSHALE = forgeTag("ore_bearing_ground/platoshale");

	public static final TagKey<Item> STORAGE_BLOCKS_ARISTONE_PACKED = forgeTag("storage_blocks/aristone_packed");
	public static final TagKey<Item> STORAGE_BLOCKS_JELLYFISH_JELLY = forgeTag("storage_blocks/jellyfish_jelly");
	public static final TagKey<Item> STORAGE_BLOCKS_ARACHNE_STRING = forgeTag("storage_blocks/arachne_string");
	public static final TagKey<Item> STORAGE_BLOCKS_SPELT = forgeTag("storage_blocks/spelt");
	public static final TagKey<Item> STORAGE_BLOCKS_VINE_REED = forgeTag("storage_blocks/vine_reed");
	public static final TagKey<Item> STORAGE_BLOCKS_VINE_SPROUT = forgeTag("storage_blocks/vine_sprout");
	public static final TagKey<Item> STORAGE_BLOCKS_ROTTEN_BONES = forgeTag("storage_blocks/rotten_bones");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_CHALKOS = forgeTag("storage_blocks/raw_chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_KASSITEROS = forgeTag("storage_blocks/raw_kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_VANADIUM = forgeTag("storage_blocks/raw_vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_SIDEROS = forgeTag("storage_blocks/raw_sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_RAW_MOLYBDENUM = forgeTag("storage_blocks/raw_molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_CALCITE = forgeTag("storage_blocks/calcite");
	public static final TagKey<Item> STORAGE_BLOCKS_HALITE = forgeTag("storage_blocks/halite");
	public static final TagKey<Item> STORAGE_BLOCKS_JASPER = forgeTag("storage_blocks/jasper");
	public static final TagKey<Item> STORAGE_BLOCKS_ZIRCON = forgeTag("storage_blocks/zircon");
	public static final TagKey<Item> STORAGE_BLOCKS_CHERT = forgeTag("storage_blocks/chert");
	public static final TagKey<Item> STORAGE_BLOCKS_LIGNITE = forgeTag("storage_blocks/lignite");
	public static final TagKey<Item> STORAGE_BLOCKS_CHALKOS = forgeTag("storage_blocks/chalkos");
	public static final TagKey<Item> STORAGE_BLOCKS_KASSITEROS = forgeTag("storage_blocks/kassiteros");
	public static final TagKey<Item> STORAGE_BLOCKS_ORICHALCUM = forgeTag("storage_blocks/orichalcum");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUM = forgeTag("storage_blocks/vanadium");
	public static final TagKey<Item> STORAGE_BLOCKS_VANADIUMSTEEL = forgeTag("storage_blocks/vanadiumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_SLIVER = forgeTag("storage_blocks/sliver");
	public static final TagKey<Item> STORAGE_BLOCKS_SIDEROS = forgeTag("storage_blocks/sideros");
	public static final TagKey<Item> STORAGE_BLOCKS_ANTHRACITE = forgeTag("storage_blocks/anthracite");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUM = forgeTag("storage_blocks/molybdenum");
	public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUMSTEEL = forgeTag("storage_blocks/molybdenumsteel");
	public static final TagKey<Item> STORAGE_BLOCKS_BLURIDIUM = forgeTag("storage_blocks/bluridium");

	public static final TagKey<Item> SAPLINGS_CYPRESS = forgeTag("saplings/cypress");
	public static final TagKey<Item> SAPLINGS_DROUGHTROOT = forgeTag("saplings/droughtroot");
	public static final TagKey<Item> SAPLINGS_FIR = forgeTag("saplings/fir");
	public static final TagKey<Item> SAPLINGS_LAUREL = forgeTag("saplings/laurel");
	public static final TagKey<Item> SAPLINGS_OLIVE = forgeTag("saplings/olive");
	public static final TagKey<Item> SAPLINGS_PLANE = forgeTag("saplings/plane");
	public static final TagKey<Item> SAPLINGS_POPULUS = forgeTag("saplings/populus");

	public static final TagKey<Item> LEAVES_CYPRESS = forgeTag("leaves/cypress");
	public static final TagKey<Item> LEAVES_DROUGHTROOT = forgeTag("leaves/droughtroot");
	public static final TagKey<Item> LEAVES_FIR = forgeTag("leaves/fir");
	public static final TagKey<Item> LEAVES_LAUREL = forgeTag("leaves/laurel");
	public static final TagKey<Item> LEAVES_OLIVE = forgeTag("leaves/olive");
	public static final TagKey<Item> LEAVES_PLANE = forgeTag("leaves/plane");
	public static final TagKey<Item> LEAVES_POPULUS = forgeTag("leaves/populus");

	public static final TagKey<Item> LOGS_CYPRESS = forgeTag("logs/cypress");
	public static final TagKey<Item> LOGS_DROUGHTROOT = forgeTag("logs/droughtroot");
	public static final TagKey<Item> LOGS_FIR = forgeTag("logs/fir");
	public static final TagKey<Item> LOGS_LAUREL = forgeTag("logs/laurel");
	public static final TagKey<Item> LOGS_OLIVE = forgeTag("logs/olive");
	public static final TagKey<Item> LOGS_PLANE = forgeTag("logs/plane");
	public static final TagKey<Item> LOGS_POPULUS = forgeTag("logs/populus");

	public static final TagKey<Item> PLANKS_CYPRESS = forgeTag("planks/cypress");
	public static final TagKey<Item> PLANKS_DROUGHTROOT = forgeTag("planks/droughtroot");
	public static final TagKey<Item> PLANKS_FIR = forgeTag("planks/fir");
	public static final TagKey<Item> PLANKS_LAUREL = forgeTag("planks/laurel");
	public static final TagKey<Item> PLANKS_OLIVE = forgeTag("planks/olive");
	public static final TagKey<Item> PLANKS_PLANE  = forgeTag("planks/plane");
	public static final TagKey<Item> PLANKS_POPULUS = forgeTag("planks/populus");

	public static final TagKey<Item> WOODEN_DOORS_CYPRESS = forgeTag("wooden_doors/cypress");
	public static final TagKey<Item> WOODEN_DOORS_DROUGHTROOT = forgeTag("wooden_doors/droughtroot");
	public static final TagKey<Item> WOODEN_DOORS_FIR = forgeTag("wooden_doors/fir");
	public static final TagKey<Item> WOODEN_DOORS_LAUREL = forgeTag("wooden_doors/laurel");
	public static final TagKey<Item> WOODEN_DOORS_OLIVE = forgeTag("wooden_doors/olive");
	public static final TagKey<Item> WOODEN_DOORS_PLANE  = forgeTag("wooden_doors/plane");
	public static final TagKey<Item> WOODEN_DOORS_POPULUS = forgeTag("wooden_doors/populus");

	public static final TagKey<Item> WOODEN_TRAPDOORS_CYPRESS = forgeTag("wooden_trapdoors/cypress");
	public static final TagKey<Item> WOODEN_TRAPDOORS_DROUGHTROOT = forgeTag("wooden_trapdoors/droughtroot");
	public static final TagKey<Item> WOODEN_TRAPDOORS_FIR = forgeTag("wooden_trapdoors/fir");
	public static final TagKey<Item> WOODEN_TRAPDOORS_LAUREL = forgeTag("wooden_trapdoors/laurel");
	public static final TagKey<Item> WOODEN_TRAPDOORS_OLIVE = forgeTag("wooden_trapdoors/olive");
	public static final TagKey<Item> WOODEN_TRAPDOORS_PLANE  = forgeTag("wooden_trapdoors/plane");
	public static final TagKey<Item> WOODEN_TRAPDOORS_POPULUS = forgeTag("wooden_trapdoors/populus");

	public IcariaItemTags(DataGenerator generator, BlockTagsProvider provider, ExistingFileHelper helper) {
		super(generator, provider, IcariaInfo.MODID, helper);
	}

	@Override
	public void addTags() {
		// ITEM TAGS
		tag(ItemTags.STONE_CRAFTING_MATERIALS)
			.add(IcariaItems.YELLOWSTONE_COBBLE.get())
			.add(IcariaItems.SILKSTONE_COBBLE.get())
			.add(IcariaItems.SUNSTONE_COBBLE.get())
			.add(IcariaItems.VOIDSHALE_COBBLE.get())
			.add(IcariaItems.BAETYL_COBBLE.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		tag(ItemTags.STONE_TOOL_MATERIALS)
			.add(IcariaItems.YELLOWSTONE_COBBLE.get())
			.add(IcariaItems.SILKSTONE_COBBLE.get())
			.add(IcariaItems.SUNSTONE_COBBLE.get())
			.add(IcariaItems.VOIDSHALE_COBBLE.get())
			.add(IcariaItems.BAETYL_COBBLE.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		tag(ItemTags.SIGNS)
			.add(IcariaItems.CYPRESS_SIGN.get())
			.add(IcariaItems.DROUGHTROOT_SIGN.get())
			.add(IcariaItems.FIR_SIGN.get())
			.add(IcariaItems.LAUREL_SIGN.get())
			.add(IcariaItems.OLIVE_SIGN.get())
			.add(IcariaItems.PLANE_SIGN.get())
			.add(IcariaItems.POPULUS_SIGN.get());

		tag(GEMS_CHERT).add(IcariaItems.CHERT.get());
		tag(GEMS_LIGNITE).add(IcariaItems.LIGNITE.get());
		tag(GEMS_DOLOMITE).add(IcariaItems.DOLOMITE.get());
		tag(GEMS_SLIVER).add(IcariaItems.SLIVER.get());
		tag(GEMS_ANTHRACITE).add(IcariaItems.ANTHRACITE.get());
		tag(GEMS_CALCITE).add(IcariaItems.CALCITE.get());
		tag(GEMS_HALITE).add(IcariaItems.HALITE.get());
		tag(GEMS_JASPER).add(IcariaItems.JASPER.get());
		tag(GEMS_ZIRCON).add(IcariaItems.ZIRCON.get());

		tag(Tags.Items.GEMS)
			.addTag(GEMS_CHERT)
			.addTag(GEMS_LIGNITE)
			.addTag(GEMS_DOLOMITE)
			.addTag(GEMS_SLIVER)
			.addTag(GEMS_ANTHRACITE)
			.addTag(GEMS_CALCITE)
			.addTag(GEMS_HALITE)
			.addTag(GEMS_JASPER)
			.addTag(GEMS_ZIRCON);

		tag(Tags.Items.SLIMEBALLS).add(IcariaItems.JELLYFISH_JELLY.get());

		tag(Tags.Items.STRING).add(IcariaItems.ARACHNE_STRING.get());

		tag(SPELT).add(IcariaItems.SPELT.get());
		tag(GARLIC).add(IcariaItems.GARLIC.get());
		tag(ONION).add(IcariaItems.ONION.get());

		tag(Tags.Items.CROPS)
			.addTag(SPELT)
			.addTag(GARLIC)
			.addTag(ONION);

		tag(SMALL_DUST_CALCITE).add(IcariaItems.CALCITE_POWDER.get());
		tag(SMALL_DUST_HALITE).add(IcariaItems.ROCK_SALT.get());

		tag(SMALL_DUST)
			.addTag(SMALL_DUST_CALCITE)
			.addTag(SMALL_DUST_HALITE);

		tag(RAW_MATERIALS_CHALKOS).add(IcariaItems.CHALKOS_RAW.get());
		tag(RAW_MATERIALS_KASSITEROS).add(IcariaItems.KASSITEROS_RAW.get());
		tag(RAW_MATERIALS_VANADIUM).add(IcariaItems.VANADIUM_RAW.get());
		tag(RAW_MATERIALS_SIDEROS).add(IcariaItems.SIDEROS_RAW.get());
		tag(RAW_MATERIALS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_RAW.get());

		tag(Tags.Items.RAW_MATERIALS)
			.addTag(RAW_MATERIALS_CHALKOS)
			.addTag(RAW_MATERIALS_KASSITEROS)
			.addTag(RAW_MATERIALS_VANADIUM)
			.addTag(RAW_MATERIALS_SIDEROS)
			.addTag(RAW_MATERIALS_MOLYBDENUM);

		tag(NUGGETS_CHALKOS).add(IcariaItems.CHALKOS_NUGGET.get());
		tag(NUGGETS_KASSITEROS).add(IcariaItems.KASSITEROS_NUGGET.get());
		tag(NUGGETS_ORICHALCUM).add(IcariaItems.ORICHALCUM_NUGGET.get());
		tag(NUGGETS_VANADIUM).add(IcariaItems.VANADIUM_NUGGET.get());
		tag(NUGGETS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_NUGGET.get());
		tag(NUGGETS_SIDEROS).add(IcariaItems.SIDEROS_NUGGET.get());
		tag(NUGGETS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_NUGGET.get());
		tag(NUGGETS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		tag(NUGGETS_BLURIDIUM).add(IcariaItems.BLURIDIUM_NUGGET.get());

		tag(Tags.Items.NUGGETS)
			.addTag(NUGGETS_CHALKOS)
			.addTag(NUGGETS_KASSITEROS)
			.addTag(NUGGETS_ORICHALCUM)
			.addTag(NUGGETS_VANADIUM)
			.addTag(NUGGETS_VANADIUMSTEEL)
			.addTag(NUGGETS_SIDEROS)
			.addTag(NUGGETS_MOLYBDENUM)
			.addTag(NUGGETS_MOLYBDENUMSTEEL)
			.addTag(NUGGETS_BLURIDIUM);

		tag(INGOTS_LOAM_BRICK).add(IcariaItems.LOAM_BRICK.get());
		tag(INGOTS_CHALKOS).add(IcariaItems.CHALKOS_INGOT.get());
		tag(INGOTS_KASSITEROS).add(IcariaItems.KASSITEROS_INGOT.get());
		tag(INGOTS_ORICHALCUM).add(IcariaItems.ORICHALCUM_INGOT.get());
		tag(INGOTS_VANADIUM).add(IcariaItems.VANADIUM_INGOT.get());
		tag(INGOTS_VANADIUMSTEEL).add(IcariaItems.VANADIUMSTEEL_INGOT.get());
		tag(INGOTS_SIDEROS).add(IcariaItems.SIDEROS_INGOT.get());
		tag(INGOTS_MOLYBDENUM).add(IcariaItems.MOLYBDENUM_INGOT.get());
		tag(INGOTS_MOLYBDENUMSTEEL).add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		tag(INGOTS_BLURIDIUM).add(IcariaItems.BLURIDIUM_INGOT.get());

		tag(Tags.Items.INGOTS)
			.addTag(INGOTS_LOAM_BRICK)
			.addTag(INGOTS_CHALKOS)
			.addTag(INGOTS_KASSITEROS)
			.addTag(INGOTS_ORICHALCUM)
			.addTag(INGOTS_VANADIUM)
			.addTag(INGOTS_VANADIUMSTEEL)
			.addTag(INGOTS_SIDEROS)
			.addTag(INGOTS_MOLYBDENUM)
			.addTag(INGOTS_MOLYBDENUMSTEEL)
			.addTag(INGOTS_BLURIDIUM);

		tag(VINES)
			.add(Items.VINE)
			.add(IcariaItems.BLOOMY_VINE.get())
			.add(IcariaItems.BRANCHY_VINE.get())
			.add(IcariaItems.BRUSHY_VINE.get())
			.add(IcariaItems.DRY_VINE.get())
			.add(IcariaItems.REEDY_VINE.get())
			.add(IcariaItems.SWIRLY_VINE.get())
			.add(IcariaItems.THORNY_VINE.get());

		tag(ItemTags.SMALL_FLOWERS)
			.add(IcariaItems.BLINDWEED.get())
			.add(IcariaItems.CHAMEOMILE.get())
			.add(IcariaItems.CHARMONDER.get())
			.add(IcariaItems.CLOVER.get())
			.add(IcariaItems.FIREHILT.get())
			.add(IcariaItems.BLUE_HYDRACINTH.get())
			.add(IcariaItems.PURPLE_HYDRACINTH.get())
			.add(IcariaItems.LIONFANGS.get())
			.add(IcariaItems.SPEARDROPS.get())
			.add(IcariaItems.PURPLE_STAGHORN.get())
			.add(IcariaItems.YELLOW_STAGHORN.get())
			.add(IcariaItems.BLUE_STORMCOTTON.get())
			.add(IcariaItems.PINK_STORMCOTTON.get())
			.add(IcariaItems.PURPLE_STORMCOTTON.get())
			.add(IcariaItems.SUNKETTLE.get())
			.add(IcariaItems.SUNSPONGE.get())
			.add(IcariaItems.VOIDLILY.get())
			.add(IcariaItems.WHITE_BROMELIA.get())
			.add(IcariaItems.ORANGE_BROMELIA.get())
			.add(IcariaItems.PINK_BROMELIA.get())
			.add(IcariaItems.PURPLE_BROMELIA.get());

		tag(Tags.Items.MUSHROOMS)
			.add(IcariaItems.GREEN_GROUND_SHROOMS.get())
			.add(IcariaItems.BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get())
			.add(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get())
			.add(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get())
			.add(IcariaItems.UNNAMED_TREE_SHROOMS.get());

		tag(LEATHER_AETERNAE_HIDE).add(IcariaItems.AETERNAE_HIDE.get());

		tag(Tags.Items.LEATHER).addTag(LEATHER_AETERNAE_HIDE);

		tag(Tags.Items.SEEDS)
			.add(IcariaItems.SPELT_SEEDS.get())
			.add(IcariaItems.STRAWBERRY_SEEDS.get())
			.add(IcariaItems.PHYSALIS_SEEDS.get())
			.add(IcariaItems.ONION.get());

		tag(Tags.Items.HEADS)
			.add(IcariaItems.ARGAN_HOUND_SKULL.get())
			.add(IcariaItems.CATOBLEPAS_SKULL.get())
			.add(IcariaItems.CERVER_SKULL.get())
			.add(IcariaItems.SOW_SKULL.get());

		// ITEMBLOCK TAGS
		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
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

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			if (deco.SLAB != null) {
				tag(ItemTags.WOODEN_SLABS).add(deco.SLAB.get());
			}
			if (deco.STAIRS != null) {
				tag(ItemTags.WOODEN_STAIRS).add(deco.STAIRS.get());
			}
			if (deco.FENCE != null) {
				tag(ItemTags.WOODEN_FENCES).add(deco.FENCE.get());
			}
			if (deco.GATE != null) {
				tag(Tags.Items.FENCE_GATES_WOODEN).add(deco.GATE.get());
			}
		}

		tag(ItemTags.DIRT)
			.add(IcariaItems.MARL_GRASS.get())
			.add(IcariaItems.MARL.get())
			.add(IcariaItems.MARL_COARSE.get())
			.add(IcariaItems.LOAM.get());

		tag(ItemTags.SAND)
			.add(IcariaItems.GRAINEL.get())
			.add(IcariaItems.SILKSAND.get());

		tag(Tags.Items.GLASS_COLORLESS)
			.add(IcariaItems.GRAINGLASS.get())
			.add(IcariaItems.SILKGLASS.get());

		tag(Tags.Items.GLASS_SILICA)
			.add(IcariaItems.GRAINGLASS.get())
			.add(IcariaItems.SILKGLASS.get());

		tag(Tags.Items.GLASS_PANES_COLORLESS)
			.add(IcariaItems.GRAINGLASS_PANE.get())
			.add(IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get())
			.add(IcariaItems.SILKGLASS_PANE.get())
			.add(IcariaItems.SILKGLASS_PANE_HORIZONTAL.get());

		tag(Tags.Items.SANDSTONE).add(IcariaItems.GRAINITE.get());

		tag(Tags.Items.COBBLESTONE_NORMAL)
			.add(IcariaItems.YELLOWSTONE_COBBLE.get())
			.add(IcariaItems.SILKSTONE_COBBLE.get())
			.add(IcariaItems.SUNSTONE_COBBLE.get())
			.add(IcariaItems.VOIDSHALE_COBBLE.get())
			.add(IcariaItems.BAETYL_COBBLE.get())
			.add(IcariaItems.RELICSTONE.get())
			.add(IcariaItems.PLATOSHALE.get());

		tag(Tags.Items.STONE)
			.add(IcariaItems.YELLOWSTONE.get())
			.add(IcariaItems.SILKSTONE.get())
			.add(IcariaItems.SUNSTONE.get())
			.add(IcariaItems.VOIDSHALE.get())
			.add(IcariaItems.BAETYL.get())
			.add(IcariaItems.RELICSTONE_SMOOTH.get());

		tag(ItemTags.STONE_BRICKS)
			.add(IcariaItems.YELLOWSTONE_BRICKS.get())
			.add(IcariaItems.SILKSTONE_BRICKS.get())
			.add(IcariaItems.SUNSTONE_BRICKS.get())
			.add(IcariaItems.VOIDSHALE_BRICKS.get())
			.add(IcariaItems.BAETYL_BRICKS.get())
			.add(IcariaItems.RELICSTONE_BRICKS.get())
			.add(IcariaItems.PLATOSHALE_BRICKS.get());

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
		copy(IcariaBlockTags.ORES_BLURIDIUM, ORES_BLURIDIUM);

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
			.addTag(ORES_HYLIASTRUM)
			.addTag(ORES_BLURIDIUM);

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
			.addTag(ORES_MOLYBDENUM)
			.addTag(ORES_BLURIDIUM);

		tag(Tags.Items.ORE_RATES_DENSE).addTag(ORES_ROTTEN_BONES);

		copy(IcariaBlockTags.ORES_IN_GROUND_MARL, ORES_IN_GROUND_MARL);
		copy(IcariaBlockTags.ORES_IN_GROUND_GRAINEL, ORES_IN_GROUND_GRAINEL);
		copy(IcariaBlockTags.ORES_IN_GROUND_YELLOWSTONE, ORES_IN_GROUND_YELLOWSTONE);
		copy(IcariaBlockTags.ORES_IN_GROUND_SILKSTONE, ORES_IN_GROUND_SILKSTONE);
		copy(IcariaBlockTags.ORES_IN_GROUND_SUNSTONE, ORES_IN_GROUND_SUNSTONE);
		copy(IcariaBlockTags.ORES_IN_GROUND_VOIDSHALE, ORES_IN_GROUND_VOIDSHALE);
		copy(IcariaBlockTags.ORES_IN_GROUND_BAETYL, ORES_IN_GROUND_BAETYL);
		copy(IcariaBlockTags.ORES_IN_GROUND_PLATOSHALE, ORES_IN_GROUND_PLATOSHALE);

		copy(IcariaBlockTags.ORE_BEARING_GROUND_MARL, ORE_BEARING_GROUND_MARL);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_GRAINEL, ORE_BEARING_GROUND_GRAINEL);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_YELLOWSTONE, ORE_BEARING_GROUND_YELLOWSTONE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_SILKSTONE, ORE_BEARING_GROUND_SILKSTONE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_SUNSTONE, ORE_BEARING_GROUND_SUNSTONE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_VOIDSHALE, ORE_BEARING_GROUND_VOIDSHALE);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_BAETYL, ORE_BEARING_GROUND_BAETYL);
		copy(IcariaBlockTags.ORE_BEARING_GROUND_PLATOSHALE, ORE_BEARING_GROUND_PLATOSHALE);

		copy(IcariaBlockTags.STORAGE_BLOCKS_ARISTONE_PACKED, STORAGE_BLOCKS_ARISTONE_PACKED);
		copy(IcariaBlockTags.STORAGE_BLOCKS_JELLYFISH_JELLY, STORAGE_BLOCKS_JELLYFISH_JELLY);
		copy(IcariaBlockTags.STORAGE_BLOCKS_ARACHNE_STRING, STORAGE_BLOCKS_ARACHNE_STRING);
		copy(IcariaBlockTags.STORAGE_BLOCKS_SPELT, STORAGE_BLOCKS_SPELT);
		copy(IcariaBlockTags.STORAGE_BLOCKS_VINE_REED, STORAGE_BLOCKS_VINE_REED);
		copy(IcariaBlockTags.STORAGE_BLOCKS_VINE_SPROUT, STORAGE_BLOCKS_VINE_SPROUT);
		copy(IcariaBlockTags.STORAGE_BLOCKS_ROTTEN_BONES, STORAGE_BLOCKS_ROTTEN_BONES);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_CHALKOS, STORAGE_BLOCKS_RAW_CHALKOS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_KASSITEROS, STORAGE_BLOCKS_RAW_KASSITEROS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_VANADIUM, STORAGE_BLOCKS_RAW_VANADIUM);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_SIDEROS, STORAGE_BLOCKS_RAW_SIDEROS);
		copy(IcariaBlockTags.STORAGE_BLOCKS_RAW_MOLYBDENUM, STORAGE_BLOCKS_RAW_MOLYBDENUM);
		copy(IcariaBlockTags.STORAGE_BLOCKS_CALCITE, STORAGE_BLOCKS_CALCITE);
		copy(IcariaBlockTags.STORAGE_BLOCKS_HALITE, STORAGE_BLOCKS_HALITE);
		copy(IcariaBlockTags.STORAGE_BLOCKS_JASPER, STORAGE_BLOCKS_JASPER);
		copy(IcariaBlockTags.STORAGE_BLOCKS_ZIRCON, STORAGE_BLOCKS_ZIRCON);
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
		copy(IcariaBlockTags.STORAGE_BLOCKS_BLURIDIUM, STORAGE_BLOCKS_BLURIDIUM);

		tag(Tags.Items.STORAGE_BLOCKS)
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
			.addTag(STORAGE_BLOCKS_MOLYBDENUMSTEEL)
			.addTag(STORAGE_BLOCKS_BLURIDIUM);

		copy(IcariaBlockTags.SAPLINGS_CYPRESS, SAPLINGS_CYPRESS);
		copy(IcariaBlockTags.SAPLINGS_DROUGHTROOT, SAPLINGS_DROUGHTROOT);
		copy(IcariaBlockTags.SAPLINGS_FIR, SAPLINGS_FIR);
		copy(IcariaBlockTags.SAPLINGS_LAUREL, SAPLINGS_LAUREL);
		copy(IcariaBlockTags.SAPLINGS_OLIVE, SAPLINGS_OLIVE);
		copy(IcariaBlockTags.SAPLINGS_PLANE, SAPLINGS_PLANE);
		copy(IcariaBlockTags.SAPLINGS_POPULUS, SAPLINGS_POPULUS);

		tag(ItemTags.SAPLINGS)
			.addTag(SAPLINGS_CYPRESS)
			.addTag(SAPLINGS_DROUGHTROOT)
			.addTag(SAPLINGS_FIR)
			.addTag(SAPLINGS_LAUREL)
			.addTag(SAPLINGS_OLIVE)
			.addTag(SAPLINGS_PLANE)
			.addTag(SAPLINGS_POPULUS);

		copy(IcariaBlockTags.LEAVES_CYPRESS, LEAVES_CYPRESS);
		copy(IcariaBlockTags.LEAVES_DROUGHTROOT, LEAVES_DROUGHTROOT);
		copy(IcariaBlockTags.LEAVES_FIR, LEAVES_FIR);
		copy(IcariaBlockTags.LEAVES_LAUREL, LEAVES_LAUREL);
		copy(IcariaBlockTags.LEAVES_OLIVE, LEAVES_OLIVE);
		copy(IcariaBlockTags.LEAVES_PLANE, LEAVES_PLANE);
		copy(IcariaBlockTags.LEAVES_POPULUS, LEAVES_POPULUS);

		tag(ItemTags.LEAVES)
			.addTag(LEAVES_CYPRESS)
			.addTag(LEAVES_DROUGHTROOT)
			.addTag(LEAVES_FIR)
			.addTag(LEAVES_LAUREL)
			.addTag(LEAVES_OLIVE)
			.addTag(LEAVES_PLANE)
			.addTag(LEAVES_POPULUS);

		copy(IcariaBlockTags.LOGS_CYPRESS, LOGS_CYPRESS);
		copy(IcariaBlockTags.LOGS_DROUGHTROOT, LOGS_DROUGHTROOT);
		copy(IcariaBlockTags.LOGS_FIR, LOGS_FIR);
		copy(IcariaBlockTags.LOGS_LAUREL, LOGS_LAUREL);
		copy(IcariaBlockTags.LOGS_OLIVE, LOGS_OLIVE);
		copy(IcariaBlockTags.LOGS_PLANE, LOGS_PLANE);
		copy(IcariaBlockTags.LOGS_POPULUS, LOGS_POPULUS);

		tag(ItemTags.LOGS)
			.addTag(LOGS_CYPRESS)
			.addTag(LOGS_DROUGHTROOT)
			.addTag(LOGS_FIR)
			.addTag(LOGS_LAUREL)
			.addTag(LOGS_OLIVE)
			.addTag(LOGS_PLANE)
			.addTag(LOGS_POPULUS);

		copy(IcariaBlockTags.PLANKS_CYPRESS, PLANKS_CYPRESS);
		copy(IcariaBlockTags.PLANKS_DROUGHTROOT, PLANKS_DROUGHTROOT);
		copy(IcariaBlockTags.PLANKS_FIR, PLANKS_FIR);
		copy(IcariaBlockTags.PLANKS_LAUREL, PLANKS_LAUREL);
		copy(IcariaBlockTags.PLANKS_OLIVE, PLANKS_OLIVE);
		copy(IcariaBlockTags.PLANKS_PLANE, PLANKS_PLANE);
		copy(IcariaBlockTags.PLANKS_POPULUS, PLANKS_POPULUS);

		tag(ItemTags.PLANKS)
			.addTag(PLANKS_CYPRESS)
			.addTag(PLANKS_DROUGHTROOT)
			.addTag(PLANKS_FIR)
			.addTag(PLANKS_LAUREL)
			.addTag(PLANKS_OLIVE)
			.addTag(PLANKS_PLANE)
			.addTag(PLANKS_POPULUS);

		tag(WOODEN_DOORS_CYPRESS).add(IcariaItems.CYPRESS_DOOR.get());
		tag(WOODEN_DOORS_DROUGHTROOT).add(IcariaItems.DROUGHTROOT_DOOR.get());
		tag(WOODEN_DOORS_FIR).add(IcariaItems.FIR_DOOR.get());
		tag(WOODEN_DOORS_LAUREL).add(IcariaItems.LAUREL_DOOR.get());
		tag(WOODEN_DOORS_OLIVE).add(IcariaItems.OLIVE_DOOR.get());
		tag(WOODEN_DOORS_PLANE).add(IcariaItems.PLANE_DOOR.get());
		tag(WOODEN_DOORS_POPULUS).add(IcariaItems.POPULUS_DOOR.get());

		tag(ItemTags.WOODEN_DOORS)
			.addTag(WOODEN_DOORS_CYPRESS)
			.addTag(WOODEN_DOORS_DROUGHTROOT)
			.addTag(WOODEN_DOORS_FIR)
			.addTag(WOODEN_DOORS_LAUREL)
			.addTag(WOODEN_DOORS_OLIVE)
			.addTag(WOODEN_DOORS_PLANE)
			.addTag(WOODEN_DOORS_POPULUS);

		tag(WOODEN_TRAPDOORS_CYPRESS).add(IcariaItems.CYPRESS_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_DROUGHTROOT).add(IcariaItems.DROUGHTROOT_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_FIR).add(IcariaItems.FIR_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_LAUREL).add(IcariaItems.LAUREL_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_OLIVE).add(IcariaItems.OLIVE_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_PLANE).add(IcariaItems.PLANE_TRAPDOOR.get());
		tag(WOODEN_TRAPDOORS_POPULUS).add(IcariaItems.POPULUS_TRAPDOOR.get());

		tag(ItemTags.WOODEN_TRAPDOORS)
			.addTag(WOODEN_TRAPDOORS_CYPRESS)
			.addTag(WOODEN_TRAPDOORS_DROUGHTROOT)
			.addTag(WOODEN_TRAPDOORS_FIR)
			.addTag(WOODEN_TRAPDOORS_LAUREL)
			.addTag(WOODEN_TRAPDOORS_OLIVE)
			.addTag(WOODEN_TRAPDOORS_PLANE)
			.addTag(WOODEN_TRAPDOORS_POPULUS);
	}

	public static TagKey<Item> bind(String name) {
		return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(name));
	}

	public static TagKey<Item> forgeTag(String name) {
		return IcariaItemTags.bind("forge:" + name);
	}

	public static TagKey<Item> icariaTag(String name) {
		return IcariaItemTags.bind(IcariaInfo.MODID + ":" + name);
	}
}
