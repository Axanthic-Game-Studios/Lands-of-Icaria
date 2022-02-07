package com.axanthic.landsoficaria.common.registry;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.client.LandsOfIcariaTabs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class LandsOfIcariaItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LandsOfIcariaInfo.MODID);

    public static final RegistryObject<Item> MARL_GRASS = register("marl_grass", () -> new BlockItem(LandsOfIcariaBlocks.MARL_GRASS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> MARL = register("marl", () -> new BlockItem(LandsOfIcariaBlocks.MARL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> MARL_ADOBE = register("marl_adobe", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> MARL_ADOBE_SLAB = register("marl_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> MARL_ADOBE_STAIRS = register("marl_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> MARL_ADOBE_WALL = register("marl_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> MARL_COARSE = register("marl_coarse", () -> new BlockItem(LandsOfIcariaBlocks.MARL_COARSE.get(), propertiesBlocks()));

    public static final RegistryObject<Item> FARMLAND = register("farmland", () -> new BlockItem(LandsOfIcariaBlocks.FARMLAND.get(), propertiesBlocks()));
    public static final RegistryObject<Item> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new BlockItem(LandsOfIcariaBlocks.FARMLAND_FERTILIZED.get(), propertiesBlocks()));

    public static final RegistryObject<Item> LOAM = register("loam", () -> new BlockItem(LandsOfIcariaBlocks.LOAM.get(), propertiesBlocks()));
    public static final RegistryObject<Item> LOAM_BRICKS = register("loam_bricks", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> LOAM_BRICKS_SLAB = register("loam_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> LOAM_BRICKS_STAIRS = register("loam_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> LOAM_BRICKS_WALL = register("loam_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS_WALL.get(), propertiesBlocks()));

    public static final RegistryObject<Item> GRAINEL = register("grainel", () -> new BlockItem(LandsOfIcariaBlocks.GRAINEL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINGLASS = register("grainglass", () -> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINGLASS_PANE = register("grainglass_pane", ()-> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS_PANE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", ()-> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_ADOBE = register("grainite_adobe", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_ADOBE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_ADOBE_SLAB = register("grainite_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_ADOBE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_ADOBE_STAIRS = register("grainite_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_ADOBE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_ADOBE_WALL = register("grainite_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_ADOBE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE = register("grainite", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_SLAB = register("grainite_slab", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_STAIRS = register("grainite_stairs", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_WALL = register("grainite_wall", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_BRICKS = register("grainite_bricks", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_BRICKS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_BRICKS_SLAB = register("grainite_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_BRICKS_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_BRICKS_STAIRS = register("grainite_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_BRICKS_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_BRICKS_WALL = register("grainite_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_BRICKS_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> GRAINITE_CHISELED = register("grainite_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.GRAINITE_CHISELED.get(), propertiesBlocks()));

    public static final RegistryObject<Item> YELLOWSTONE_ADOBE = register("yellowstone_adobe", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_ADOBE_SLAB = register("yellowstone_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_ADOBE_STAIRS = register("yellowstone_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_ADOBE_WALL = register("yellowstone_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_ADOBE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_COBBLE = register("yellowstone_cobble", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_COBBLE_SLAB = register("yellowstone_cobble_slab", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_COBBLE_STAIRS = register("yellowstone_cobble_stairs", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_COBBLE_WALL = register("yellowstone_cobble_wall", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_COBBLE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE = register("yellowstone", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_SLAB = register("yellowstone_slab", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_STAIRS = register("yellowstone_stairs", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_WALL = register("yellowstone_wall", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_BRICKS = register("yellowstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_BRICKS_SLAB = register("yellowstone_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_BRICKS_STAIRS = register("yellowstone_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_BRICKS_WALL = register("yellowstone_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_BRICKS_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> YELLOWSTONE_CHISELED = register("yellowstone_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.YELLOWSTONE_CHISELED.get(), propertiesBlocks()));

    public static final RegistryObject<Item> SILKSAND = register("silksand", () -> new BlockItem(LandsOfIcariaBlocks.SILKSAND.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKGLASS = register("silkglass", () -> new BlockItem(LandsOfIcariaBlocks.SILKGLASS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKGLASS_PANE = register("silkglass_pane", ()-> new BlockItem(LandsOfIcariaBlocks.SILKGLASS_PANE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", ()-> new BlockItem(LandsOfIcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_ADOBE = register("silkstone_adobe", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_ADOBE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_ADOBE_SLAB = register("silkstone_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_ADOBE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_ADOBE_STAIRS = register("silkstone_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_ADOBE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_ADOBE_WALL = register("silkstone_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_ADOBE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_COBBLE = register("silkstone_cobble", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_COBBLE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_COBBLE_SLAB = register("silkstone_cobble_slab", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_COBBLE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_COBBLE_STAIRS = register("silkstone_cobble_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_COBBLE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_COBBLE_WALL = register("silkstone_cobble_wall", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_COBBLE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE = register("silkstone", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_SLAB = register("silkstone_slab", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_STAIRS = register("silkstone_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_WALL = register("silkstone_wall", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_BRICKS = register("silkstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_BRICKS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_BRICKS_SLAB = register("silkstone_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_BRICKS_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_BRICKS_STAIRS = register("silkstone_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_BRICKS_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_BRICKS_WALL = register("silkstone_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_BRICKS_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SILKSTONE_CHISELED = register("silkstone_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.SILKSTONE_CHISELED.get(), propertiesBlocks()));

    public static final RegistryObject<Item> SUNSTONE_ADOBE = register("sunstone_adobe", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_ADOBE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_ADOBE_SLAB = register("sunstone_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_ADOBE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_ADOBE_STAIRS = register("sunstone_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_ADOBE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_ADOBE_WALL = register("sunstone_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_ADOBE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_COBBLE = register("sunstone_cobble", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_COBBLE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_COBBLE_SLAB = register("sunstone_cobble_slab", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_COBBLE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_COBBLE_STAIRS = register("sunstone_cobble_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_COBBLE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_COBBLE_WALL = register("sunstone_cobble_wall", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_COBBLE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE = register("sunstone", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_SLAB = register("sunstone_slab", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_STAIRS = register("sunstone_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_WALL = register("sunstone_wall", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_BRICKS = register("sunstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_BRICKS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_BRICKS_SLAB = register("sunstone_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_BRICKS_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_BRICKS_STAIRS = register("sunstone_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_BRICKS_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_BRICKS_WALL = register("sunstone_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_BRICKS_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> SUNSTONE_CHISELED = register("sunstone_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.SUNSTONE_CHISELED.get(), propertiesBlocks()));

    public static final RegistryObject<Item> VOIDSHALE_ADOBE = register("voidshale_adobe", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_ADOBE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_ADOBE_SLAB = register("voidshale_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_ADOBE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_ADOBE_STAIRS = register("voidshale_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_ADOBE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_ADOBE_WALL = register("voidshale_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_ADOBE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_COBBLE = register("voidshale_cobble", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_COBBLE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_COBBLE_SLAB = register("voidshale_cobble_slab", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_COBBLE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_COBBLE_STAIRS = register("voidshale_cobble_stairs", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_COBBLE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_COBBLE_WALL = register("voidshale_cobble_wall", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_COBBLE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE = register("voidshale", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_SLAB = register("voidshale_slab", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_STAIRS = register("voidshale_stairs", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_WALL = register("voidshale_wall", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_BRICKS = register("voidshale_bricks", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_BRICKS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_BRICKS_SLAB = register("voidshale_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_BRICKS_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_BRICKS_STAIRS = register("voidshale_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_BRICKS_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_BRICKS_WALL = register("voidshale_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_BRICKS_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> VOIDSHALE_CHISELED = register("voidshale_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.VOIDSHALE_CHISELED.get(), propertiesBlocks()));

    public static final RegistryObject<Item> BAETYL_ADOBE = register("baetyl_adobe", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_ADOBE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_ADOBE_SLAB = register("baetyl_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_ADOBE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_ADOBE_STAIRS = register("baetyl_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_ADOBE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_ADOBE_WALL = register("baetyl_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_ADOBE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_COBBLE = register("baetyl_cobble", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_COBBLE.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_COBBLE_SLAB = register("baetyl_cobble_slab", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_COBBLE_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_COBBLE_STAIRS = register("baetyl_cobble_stairs", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_COBBLE_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_COBBLE_WALL = register("baetyl_cobble_wall", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_COBBLE_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL = register("baetyl", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_SLAB = register("baetyl_slab", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_STAIRS = register("baetyl_stairs", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_WALL = register("baetyl_wall", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_BRICKS = register("baetyl_bricks", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_BRICKS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_BRICKS_SLAB = register("baetyl_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_BRICKS_SLAB.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_BRICKS_STAIRS = register("baetyl_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_BRICKS_STAIRS.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_BRICKS_WALL = register("baetyl_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_BRICKS_WALL.get(), propertiesBlocks()));
    public static final RegistryObject<Item> BAETYL_CHISELED = register("baetyl_chiseled", () -> new BlockItem(LandsOfIcariaBlocks.BAETYL_CHISELED.get(), propertiesBlocks()));

    public static final RegistryObject<Item> MOSS_0 = register("moss_0", () -> new BlockItem(LandsOfIcariaBlocks.MOSS_0.get(), propertiesFlora()));
    public static final RegistryObject<Item> MOSS_1 = register("moss_1", () -> new BlockItem(LandsOfIcariaBlocks.MOSS_1.get(), propertiesFlora()));
    public static final RegistryObject<Item> MOSS_2 = register("moss_2", () -> new BlockItem(LandsOfIcariaBlocks.MOSS_2.get(), propertiesFlora()));

    public static final RegistryObject<Item> LOAM_LUMP = register("loam_lump", () -> new Item(propertiesItems()));
    public static final RegistryObject<Item> LOAM_BRICK = register("loam_brick", () -> new Item(propertiesItems()));
    public static final RegistryObject<Item> CALCITE_POWDER = register("calcite_powder", () -> new Item(propertiesItems()));
    public static final RegistryObject<Item> FLASK_EMPTY = register("flask_empty", () -> new Item(propertiesItems()));

    private static Properties propertiesBlocks() {
        return new Properties().tab(LandsOfIcariaTabs.creativeBlocks);
    }

    private static Properties propertiesFlora() {
        return new Properties().tab(LandsOfIcariaTabs.creativeFlora);
    }

    private static Properties propertiesItems() {
        return new Properties().tab(LandsOfIcariaTabs.creativeItems);
    }

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
