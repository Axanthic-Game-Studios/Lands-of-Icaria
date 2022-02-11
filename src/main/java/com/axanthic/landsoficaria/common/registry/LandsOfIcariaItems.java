package com.axanthic.landsoficaria.common.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.client.util.LandsOfIcariaTabs;
import com.axanthic.landsoficaria.common.items.FuelBlockItem;
import com.axanthic.landsoficaria.common.items.FuelItem;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaBlocks.DecoBlockCombination;

import com.axanthic.landsoficaria.common.items.VineSproutItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LandsOfIcariaItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LandsOfIcariaInfo.MODID);

	public static final List<DecoItemBlockCombination> DECO_BLOCKS = new ArrayList<DecoItemBlockCombination>();

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
	//public static final RegistryObject<Item> MARL_ADOBE_SLAB = register("marl_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE_SLAB.get(), propertiesBlocks()));
	//public static final RegistryObject<Item> MARL_ADOBE_STAIRS = register("marl_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE_STAIRS.get(), propertiesBlocks()));
	//public static final RegistryObject<Item> MARL_ADOBE_WALL = register("marl_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.MARL_ADOBE_WALL.get(), propertiesBlocks()));

	public static final RegistryObject<Item> LOAM = register("loam", () -> new BlockItem(LandsOfIcariaBlocks.LOAM.get(), propertiesBlocks()));
	public static final RegistryObject<Item> LOAM_BRICKS = register("loam_bricks", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> LOAM_BRICKS_SLAB = register("loam_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> LOAM_BRICKS_STAIRS = register("loam_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> LOAM_BRICKS_WALL = register("loam_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.LOAM_BRICKS_WALL.get(), propertiesBlocks()));

	public static final RegistryObject<Item> DOLOMITE_ADOBE = register("dolomite_adobe", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_ADOBE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_ADOBE_SLAB = register("dolomite_adobe_slab", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_ADOBE_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_ADOBE_STAIRS = register("dolomite_adobe_stairs", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_ADOBE_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_ADOBE_WALL = register("dolomite_adobe_wall", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_ADOBE_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_SMOOTH = register("dolomite_smooth", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_SMOOTH.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_SMOOTH_SLAB = register("dolomite_smooth_slab", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_SMOOTH_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_SMOOTH_STAIRS = register("dolomite_smooth_stairs", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_SMOOTH_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_SMOOTH_WALL = register("dolomite_smooth_wall", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_SMOOTH_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_BRICKS = register("dolomite_bricks", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_BRICKS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_PILLAR.get(), propertiesBlocks()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new BlockItem(LandsOfIcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), propertiesBlocks()));

	public static final RegistryObject<Item> GRAINEL = register("grainel", () -> new BlockItem(LandsOfIcariaBlocks.GRAINEL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINEL_CHERT = register("grainel_chert", () -> new BlockItem(LandsOfIcariaBlocks.GRAINEL_CHERT.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINGLASS = register("grainglass", () -> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINGLASS_PANE = register("grainglass_pane", () -> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS_PANE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", () -> new BlockItem(LandsOfIcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), propertiesBlocks()));
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
	public static final RegistryObject<Item> SILKGLASS_PANE = register("silkglass_pane", () -> new BlockItem(LandsOfIcariaBlocks.SILKGLASS_PANE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", () -> new BlockItem(LandsOfIcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), propertiesBlocks()));
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

	public static final RegistryObject<Item> RELICSTONE = register("relicstone", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_SLAB = register("relicstone_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_STAIRS = register("relicstone_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_WALL = register("relicstone_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_SMOOTH = register("relicstone_smooth", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_SMOOTH.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_SMOOTH_SLAB = register("relicstone_smooth_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_SMOOTH_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_SMOOTH_STAIRS = register("relicstone_smooth_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_SMOOTH_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_SMOOTH_WALL = register("relicstone_smooth_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_SMOOTH_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS = register("relicstone_bricks", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_SLAB = register("relicstone_bricks_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_STAIRS = register("relicstone_bricks_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_WALL = register("relicstone_bricks_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_CRACKED = register("relicstone_bricks_cracked", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_CRACKED.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_CRACKED_SLAB = register("relicstone_bricks_cracked_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_CRACKED_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_CRACKED_STAIRS = register("relicstone_bricks_cracked_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_CRACKED_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_CRACKED_WALL = register("relicstone_bricks_cracked_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_CRACKED_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_MOSSY = register("relicstone_bricks_mossy", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_MOSSY.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_MOSSY_SLAB = register("relicstone_bricks_mossy_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_MOSSY_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_MOSSY_STAIRS = register("relicstone_bricks_mossy_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_MOSSY_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_BRICKS_MOSSY_WALL = register("relicstone_bricks_mossy_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_BRICKS_MOSSY_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES = register("relicstone_tiles", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_SLAB = register("relicstone_tiles_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_STAIRS = register("relicstone_tiles_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_WALL = register("relicstone_tiles_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_CRACKED = register("relicstone_tiles_cracked", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_CRACKED.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_CRACKED_SLAB = register("relicstone_tiles_cracked_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_CRACKED_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_CRACKED_STAIRS = register("relicstone_tiles_cracked_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_CRACKED_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_CRACKED_WALL = register("relicstone_tiles_cracked_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_CRACKED_WALL.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_MOSSY = register("relicstone_tiles_mossy", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_MOSSY.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_MOSSY_SLAB = register("relicstone_tiles_mossy_slab", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_MOSSY_SLAB.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_MOSSY_STAIRS = register("relicstone_tiles_mossy_stairs", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_MOSSY_STAIRS.get(), propertiesBlocks()));
	public static final RegistryObject<Item> RELICSTONE_TILES_MOSSY_WALL = register("relicstone_tiles_mossy_wall", () -> new BlockItem(LandsOfIcariaBlocks.RELICSTONE_TILES_MOSSY_WALL.get(), propertiesBlocks()));
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

	public static final RegistryObject<Item> FLASK_EMPTY = register("flask_empty", () -> new Item(propertiesItems()));
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
}
