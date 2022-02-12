package com.axanthic.icaria.common.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.axanthic.icaria.LandsOfIcariaInfo;
import com.axanthic.icaria.client.util.LandsOfIcariaTabs;
import com.axanthic.icaria.common.items.FuelBlockItem;
import com.axanthic.icaria.common.items.FuelItem;
import com.axanthic.icaria.common.items.IcariaAxeItem;
import com.axanthic.icaria.common.items.IcariaPickaxeItem;
import com.axanthic.icaria.common.items.IcariaScytheItem;
import com.axanthic.icaria.common.items.IcariaShovelItem;
import com.axanthic.icaria.common.items.VineSproutItem;
import com.axanthic.icaria.common.registry.LandsOfIcariaBlocks.DecoBlockCombination;
import com.axanthic.icaria.util.IcariaTier;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LandsOfIcariaItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LandsOfIcariaInfo.MODID);

	public static final List<DecoItemBlockCombination> DECO_BLOCKS = new ArrayList<DecoItemBlockCombination>();
	public static final List<RegistryObject<? extends Item>> BASIC_ITEMS = new ArrayList<RegistryObject<? extends Item>>();
	public static final List<RegistryObject<? extends Item>> TOOL_ITEMS = new ArrayList<RegistryObject<? extends Item>>();

	public static final RegistryObject<Item> MARL_GRASS = register("marl_grass", () -> new BlockItem(LandsOfIcariaBlocks.MARL_GRASS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> MARL = register("marl", () -> new BlockItem(LandsOfIcariaBlocks.MARL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> MARL_CHERT = register("marl_chert", () -> new BlockItem(LandsOfIcariaBlocks.MARL_CHERT.get(), propertiesBlocks()));
	public static final RegistryObject<Item> MARL_ROTTEN_BONES = register("marl_rotten_bones", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ROTTEN_BONES.get(), propertiesBlocks()));
	public static final RegistryObject<Item> MARL_LIGNITE = register("marl_lignite", () -> new BlockItem(LandsOfIcariaBlocks.MARL_LIGNITE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> MARL_COARSE = register("marl_coarse", () -> new BlockItem(LandsOfIcariaBlocks.MARL_COARSE.get(), propertiesBlocks()));

	public static final RegistryObject<Item> FARMLAND = register("farmland", () -> new BlockItem(LandsOfIcariaBlocks.FARMLAND.get(), propertiesBlocks()));
	public static final RegistryObject<Item> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new BlockItem(LandsOfIcariaBlocks.FARMLAND_FERTILIZED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> MARL_ADOBE = register("marl_adobe", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination MARL_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.MARL_ADOBE_DECO, MARL_ADOBE);

	public static final RegistryObject<Item> LOAM = register("loam", () -> new BlockItem(LandsOfIcariaBlocks.LOAM.get(), propertiesBlocks()));
	public static final RegistryObject<Item> LOAM_BRICKS = register("loam_bricks", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination LOAM_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.LOAM_BRICKS_DECO, LOAM_BRICKS);

	public static final RegistryObject<Item> DOLOMITE_ADOBE = register("dolomite_adobe", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination DOLOMITE_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.DOLOMITE_ADOBE_DECO, DOLOMITE_ADOBE);
	public static final RegistryObject<Item> DOLOMITE_SMOOTH = register("dolomite_smooth", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_SMOOTH.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination DOLOMITE_SMOOTH_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.DOLOMITE_SMOOTH_DECO, DOLOMITE_SMOOTH);
	public static final RegistryObject<Item> DOLOMITE_BRICKS = register("dolomite_bricks", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_BRICKS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_PILLAR.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), propertiesBlocks()));

	public static final RegistryObject<Item> GRAINEL = register("grainel", () -> new BlockItem(LandsOfIcariaBlocks.GRAINEL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINEL_CHERT = register("grainel_chert", () -> new BlockItem(LandsOfIcariaBlocks.GRAINEL_CHERT.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINGLASS = register("grainglass", () -> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINGLASS_PANE = register("grainglass_pane", () -> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS_PANE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", () -> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINITE_ADOBE = register("grainite_adobe", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination GRAINITE_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.GRAINITE_ADOBE_DECO, GRAINITE_ADOBE);
	public static final RegistryObject<Item> GRAINITE = register("grainite", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination GRAINITE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.GRAINITE_DECO, GRAINITE);
	public static final RegistryObject<Item> GRAINITE_BRICKS = register("grainite_bricks", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination GRAINITE_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.GRAINITE_BRICKS_DECO, GRAINITE_BRICKS);
	public static final RegistryObject<Item> GRAINITE_CHISELED = register("grainite_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_CHISELED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> YELLOWSTONE_ADOBE = register("yellowstone_adobe", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination YELLOWSTONE_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE_DECO, YELLOWSTONE_ADOBE);
	public static final RegistryObject<Item> YELLOWSTONE_COBBLE = register("yellowstone_cobble", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination YELLOWSTONE_COBBLE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE_DECO, YELLOWSTONE_COBBLE);
	public static final RegistryObject<Item> YELLOWSTONE = register("yellowstone", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination YELLOWSTONE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.YELLOWSTONE_DECO, YELLOWSTONE);
	public static final RegistryObject<Item> YELLOWSTONE_BRICKS = register("yellowstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination YELLOWSTONE_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS_DECO, YELLOWSTONE_BRICKS);
	public static final RegistryObject<Item> YELLOWSTONE_CHISELED = register("yellowstone_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_CHISELED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> SILKSAND = register("silksand", () -> new BlockItem(LandsOfIcariaBlocks.SILKSAND.get(), propertiesBlocks()));
	public static final RegistryObject<Item> SILKGLASS = register("silkglass", () -> new BlockItem(LandsOfIcariaBlocks.SILKGLASS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> SILKGLASS_PANE = register("silkglass_pane", () -> new BlockItem(LandsOfIcariaBlocks.SILKGLASS_PANE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", () -> new BlockItem(LandsOfIcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> SILKSTONE_ADOBE = register("silkstone_adobe", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SILKSTONE_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SILKSTONE_ADOBE_DECO, SILKSTONE_ADOBE);
	public static final RegistryObject<Item> SILKSTONE_COBBLE = register("silkstone_cobble", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_COBBLE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SILKSTONE_COBBLE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SILKSTONE_COBBLE_DECO, SILKSTONE_COBBLE);
	public static final RegistryObject<Item> SILKSTONE = register("silkstone", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SILKSTONE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SILKSTONE_DECO, SILKSTONE);
	public static final RegistryObject<Item> SILKSTONE_BRICKS = register("silkstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SILKSTONE_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SILKSTONE_BRICKS_DECO, SILKSTONE_BRICKS);
	public static final RegistryObject<Item> SILKSTONE_CHISELED = register("silkstone_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_CHISELED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> SUNSTONE_ADOBE = register("sunstone_adobe", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SUNSTONE_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SUNSTONE_ADOBE_DECO, SUNSTONE_ADOBE);
	public static final RegistryObject<Item> SUNSTONE_COBBLE = register("sunstone_cobble", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_COBBLE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SUNSTONE_COBBLE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SUNSTONE_COBBLE_DECO, SUNSTONE_COBBLE);
	public static final RegistryObject<Item> SUNSTONE = register("sunstone", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SUNSTONE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SUNSTONE_DECO, SUNSTONE);
	public static final RegistryObject<Item> SUNSTONE_BRICKS = register("sunstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination SUNSTONE_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.SUNSTONE_BRICKS_DECO, SUNSTONE_BRICKS);
	public static final RegistryObject<Item> SUNSTONE_CHISELED = register("sunstone_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_CHISELED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> VOIDSHALE_ADOBE = register("voidshale_adobe", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination VOIDSHALE_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.VOIDSHALE_ADOBE_DECO, VOIDSHALE_ADOBE);
	public static final RegistryObject<Item> VOIDSHALE_COBBLE = register("voidshale_cobble", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_COBBLE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination VOIDSHALE_COBBLE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.VOIDSHALE_COBBLE_DECO, VOIDSHALE_COBBLE);
	public static final RegistryObject<Item> VOIDSHALE = register("voidshale", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination VOIDSHALE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.VOIDSHALE_DECO, VOIDSHALE);
	public static final RegistryObject<Item> VOIDSHALE_BRICKS = register("voidshale_bricks", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination VOIDSHALE_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.VOIDSHALE_BRICKS_DECO, VOIDSHALE_BRICKS);
	public static final RegistryObject<Item> VOIDSHALE_CHISELED = register("voidshale_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_CHISELED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> BAETYL_ADOBE = register("baetyl_adobe", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_ADOBE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination BAETYL_ADOBE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.BAETYL_ADOBE_DECO, BAETYL_ADOBE);
	public static final RegistryObject<Item> BAETYL_COBBLE = register("baetyl_cobble", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_COBBLE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination BAETYL_COBBLE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.BAETYL_COBBLE_DECO, BAETYL_COBBLE);
	public static final RegistryObject<Item> BAETYL = register("baetyl", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination BAETYL_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.BAETYL_DECO, BAETYL);
	public static final RegistryObject<Item> BAETYL_BRICKS = register("baetyl_bricks", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination BAETYL_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.BAETYL_BRICKS_DECO, BAETYL_BRICKS);
	public static final RegistryObject<Item> BAETYL_CHISELED = register("baetyl_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_CHISELED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> RELICSTONE = register("relicstone", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination RELICSTONE_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_DECO, RELICSTONE);
	public static final RegistryObject<Item> RELICSTONE_SMOOTH = register("relicstone_smooth", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_SMOOTH.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination RELICSTONE_SMOOTH_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_SMOOTH_DECO, RELICSTONE_SMOOTH);
	public static final RegistryObject<Item> RELICSTONE_BRICKS = register("relicstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination RELICSTONE_BRICKS_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_BRICKS_DECO, RELICSTONE_BRICKS);
	public static final RegistryObject<Item> RELICSTONE_BRICKS_CRACKED = register("relicstone_bricks_cracked", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_CRACKED.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination CRACKED = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO, RELICSTONE_BRICKS_CRACKED);
	public static final RegistryObject<Item> RELICSTONE_BRICKS_MOSSY = register("relicstone_bricks_mossy", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_MOSSY.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination RELICSTONE_BRICKS_MOSSY_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO, RELICSTONE_BRICKS_MOSSY);
	public static final RegistryObject<Item> RELICSTONE_TILES = register("relicstone_tiles", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination RELICSTONE_TILES_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_TILES_DECO, RELICSTONE_TILES);
	public static final RegistryObject<Item> RELICSTONE_TILES_CRACKED = register("relicstone_tiles_cracked", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_CRACKED.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination RELICSTONE_TILES_CRACKED_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_TILES_CRACKED_DECO, RELICSTONE_TILES_CRACKED);
	public static final RegistryObject<Item> RELICSTONE_TILES_MOSSY = register("relicstone_tiles_mossy", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_MOSSY.get(), propertiesBlocks()));
	public static final DecoItemBlockCombination RELICSTONE_TILES_MOSSY_DECO = new DecoItemBlockCombination(LandsOfIcariaBlocks.RELICSTONE_TILES_MOSSY_DECO, RELICSTONE_TILES_MOSSY);
	public static final RegistryObject<Item> RELICSTONE_CHISELED = register("relicstone_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_CHISELED.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_PILLAR = register("relicstone_pillar", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_PILLAR.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_PILLAR_HEAD = register("relicstone_pillar_head", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), propertiesBlocks()));

	public static final RegistryObject<Item> ARISTONE = register("aristone", () -> new BlockItem(LandsOfIcariaBlocks.ARISTONE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> ARISTONE_PACKED = register("aristone_packed", () -> new BlockItem(LandsOfIcariaBlocks.ARISTONE_PACKED.get(), propertiesBlocks()));

	public static final RegistryObject<Item> QUARTZ_PILLAR_HEAD = register("quartz_pillar_head", () -> new BlockItem(LandsOfIcariaBlocks.QUARTZ_PILLAR_HEAD.get(), propertiesBlocks()));

	public static final RegistryObject<Item> JELLYFISH_jelly_BLOCK = register("jellyfish_jelly_block", () -> new BlockItem(LandsOfIcariaBlocks.JELLYFISH_JELLY_BLOCK.get(), propertiesBlocks()));
	public static final RegistryObject<Item> ARACHNE_STRING_BLOCK = register("arachne_string_block", () -> new BlockItem(LandsOfIcariaBlocks.ARACHNE_STRING_BLOCK.get(), propertiesBlocks()));
	public static final RegistryObject<Item> SPELT_BALE_BLOCK = register("spelt_bale_block", () -> new BlockItem(LandsOfIcariaBlocks.SPELT_BALE_BLOCK.get(), propertiesBlocks()));
	public static final RegistryObject<Item> VINE_REED_BLOCK = register("vine_reed_block", () -> new BlockItem(LandsOfIcariaBlocks.VINE_REED_BLOCK.get(), propertiesBlocks()));
	public static final RegistryObject<Item> VINE_SPROUT_BLOCK = register("vine_sprout_block", () -> new BlockItem(LandsOfIcariaBlocks.VINE_SPROUT_BLOCK.get(), propertiesBlocks()));
	public static final RegistryObject<Item> ROTTEN_BONES_BLOCK = register("rotten_bones_block", () -> new BlockItem(LandsOfIcariaBlocks.ROTTEN_BONES_BLOCK.get(), propertiesBlocks()));
	public static final RegistryObject<Item> LIGNITE_BLOCK = register("lignite_block", () -> new FuelBlockItem(LandsOfIcariaBlocks.LIGNITE_BLOCK.get(), propertiesBlocks(), 7200));
	public static final RegistryObject<Item> ANTHRACITE_BLOCK = register("anthracite_block", () -> new FuelBlockItem(LandsOfIcariaBlocks.ANTHRACITE_BLOCK.get(), propertiesBlocks(), 28800));
	public static final RegistryObject<Item> CHERT_BLOCK = register("chert_block", () -> new BlockItem(LandsOfIcariaBlocks.CHERT_BLOCK.get(), propertiesBlocks()));

	public static final RegistryObject<Item> MOSS_0 = register("moss_0", () -> new BlockItem(LandsOfIcariaBlocks.MOSS_0.get(), propertiesFlora()));
	public static final RegistryObject<Item> MOSS_1 = register("moss_1", () -> new BlockItem(LandsOfIcariaBlocks.MOSS_1.get(), propertiesFlora()));
	public static final RegistryObject<Item> MOSS_2 = register("moss_2", () -> new BlockItem(LandsOfIcariaBlocks.MOSS_2.get(), propertiesFlora()));

	public static final RegistryObject<Item> FLASK_EMPTY = registerBasic("flask_empty", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> JELLYFISH_JELLY = register("jellyfish_jelly", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> ARACHNE_STRING = register("arachne_string", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> SPELT = register("spelt", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> SPELT_BREAD = register("spelt_bread", () -> new Item(propertiesItems().food(foodPropertiesSpeltBread())));
	public static final RegistryObject<Item> VINE_REED = register("vine_reed", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> VINE_SPROUT = register("vine_sprout", () -> new VineSproutItem(propertiesVineSprout().food(foodPropertiesVineSprout())));
	public static final RegistryObject<Item> ROTTEN_BONES = register("rotten_bones", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> REMAINS = register("remains", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> CALCITE_POWDER = register("calcite_powder", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> LOAM_LUMP = register("loam_lump", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> LOAM_BRICK = register("loam_brick", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> LIGNITE = register("lignite", () -> new FuelItem(propertiesItems(), 800));
	public static final RegistryObject<Item> ANTHRACITE = register("anthracite", () -> new FuelItem(propertiesItems(), 3200));
	public static final RegistryObject<Item> DOLOMITE = register("dolomite", () -> new Item(propertiesItems()));
	public static final RegistryObject<Item> CHERT = register("chert", () -> new Item(propertiesItems()));

	public static final ToolCombination CHERT_TOOLS = new ToolCombination(LandsOfIcariaTiers.CHERT);
	public static final ToolCombination CHALKOS_TOOLS = new ToolCombination(LandsOfIcariaTiers.CHALKOS);
	public static final ToolCombination KASSITEROS_TOOLS = new ToolCombination(LandsOfIcariaTiers.KASSITEROS);
	public static final ToolCombination ORICHALCUM_TOOLS = new ToolCombination(LandsOfIcariaTiers.ORICHALCUM);
	public static final ToolCombination VANADIUMSTEEL_TOOLS = new ToolCombination(LandsOfIcariaTiers.VANADIUMSTEEL);
	public static final ToolCombination SIDEROS_TOOLS = new ToolCombination(LandsOfIcariaTiers.SIDEROS);
	public static final ToolCombination MOLYBDENUMSTEEL_TOOLS = new ToolCombination(LandsOfIcariaTiers.MOLYBDENUMSTEEL);

	private static Properties propertiesBlocks() {
		return new Properties().tab(LandsOfIcariaTabs.creativeBlocks);
	}

	private static Properties propertiesFlora() {
		return new Properties().tab(LandsOfIcariaTabs.creativeFlora);
	}

	private static Properties propertiesItems() {
		return new Properties().tab(LandsOfIcariaTabs.creativeItems);
	}

	private static Properties propertiesVineSprout() {
		return new Properties().tab(LandsOfIcariaTabs.creativeItems).setNoRepair().stacksTo(1).durability(24);
	}

	private static FoodProperties foodPropertiesVineSprout() {
		return new FoodProperties.Builder().nutrition(0).saturationMod(1.0F).alwaysEat().build();
	}

	private static FoodProperties foodPropertiesSpeltBread() {
		return new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build();
	}

	private static <T extends Item> RegistryObject<T> registerBasic(final String name, final Supplier<T> item) {
		RegistryObject<T> registeredItem = register(name, item);
		BASIC_ITEMS.add(registeredItem);
		return registeredItem;
	}

	private static <T extends Item> RegistryObject<T> registerTool(final String name, final Supplier<T> item) {
		RegistryObject<T> registeredItem = register(name, item);
		TOOL_ITEMS.add(registeredItem);
		return registeredItem;
	}

	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}

	public static class DecoItemBlockCombination {

		public final DecoBlockCombination block;
		public final RegistryObject<Item> originalItem;
		public final RegistryObject<Item> SLAB;
		public final RegistryObject<Item> STAIRS;
		public final RegistryObject<Item> WALL;

		public DecoItemBlockCombination(DecoBlockCombination block, RegistryObject<Item> originalItem) {
			this.block = block;
			this.originalItem = originalItem;
			if (block.SLAB != null)
				SLAB = register(block.name + "_slab", () -> new BlockItem(block.SLAB.get(), propertiesBlocks()));
			else
				SLAB = null;
			if (block.STAIRS != null)
				STAIRS = register(block.name + "_stairs", () -> new BlockItem(block.STAIRS.get(), propertiesBlocks()));
			else
				STAIRS = null;
			if (block.WALL != null)
				WALL = register(block.name + "_wall", () -> new BlockItem(block.WALL.get(), propertiesBlocks()));
			else
				WALL = null;
			DECO_BLOCKS.add(this);
		}
	}

	public static class ToolCombination {

		public final IcariaTier tier;
		public final RegistryObject<Item> SWORD;
		public final RegistryObject<Item> SHOVEL;
		public final RegistryObject<Item> PICKAXE;
		public final RegistryObject<Item> AXE;
		public final RegistryObject<Item> SCYTHE;

		public ToolCombination(IcariaTier tier) {
			this.tier = tier;
			String name = TierSortingRegistry.getName(tier).getPath();
			SWORD = registerTool(name + "_sword", () -> new SwordItem(tier, 3, -2.4F, propertiesItems()));
			SHOVEL = registerTool(name + "_shovel", () -> new IcariaShovelItem(tier, 1.5F, -3.0F, propertiesItems()));
			PICKAXE = registerTool(name + "_pickaxe", () -> new IcariaPickaxeItem(tier, 1, -2.8F, propertiesItems()));
			AXE = registerTool(name + "_axe", () -> new IcariaAxeItem(tier, 6.0F, -3.0F, propertiesItems()));
			SCYTHE = registerTool(name + "_scythe", () -> new IcariaScytheItem(tier, 4, -2.8F, propertiesItems()));
		}
	}
}
