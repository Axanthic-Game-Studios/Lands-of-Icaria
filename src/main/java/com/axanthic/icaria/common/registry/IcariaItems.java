package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.item.*;
import com.axanthic.icaria.common.util.IcariaArmorMaterials;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.util.IcariaTier;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;

import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IcariaInfo.MODID);

	public static final List<RegistryObject<? extends Item>> BASIC_ITEMS = new ArrayList<>();
	public static final List<StoneDecoItemBlocks> STONE_DECO = new ArrayList<>();
	public static final List<WoodDecoItemBlocks> WOOD_DECO = new ArrayList<>();
	public static final List<ToolSet> TOOLS = new ArrayList<>();
	public static final List<ArmorSet> ARMOR = new ArrayList<>();

	public static final RegistryObject<Item> MARL_GRASS = register("marl_grass", () -> new BlockItem(IcariaBlocks.MARL_GRASS.get(), new Properties()));
	public static final RegistryObject<Item> MARL = register("marl", () -> new BlockItem(IcariaBlocks.MARL.get(), new Properties()));
	public static final RegistryObject<Item> MARL_CHERT = register("marl_chert", () -> new BlockItem(IcariaBlocks.MARL_CHERT.get(), new Properties()));
	public static final RegistryObject<Item> SURFACE_CHERT = register("surface_chert", () -> new BlockItem(IcariaBlocks.SURFACE_CHERT.get(), new Properties()));
	public static final RegistryObject<Item> MARL_BONES = register("marl_bones", () -> new BlockItem(IcariaBlocks.MARL_BONES.get(), new Properties()));
	public static final RegistryObject<Item> SURFACE_BONES = register("surface_bones", () -> new BlockItem(IcariaBlocks.SURFACE_BONES.get(), new Properties()));
	public static final RegistryObject<Item> MARL_LIGNITE = register("marl_lignite", () -> new BlockItem(IcariaBlocks.MARL_LIGNITE.get(), new Properties()));
	public static final RegistryObject<Item> MARL_COARSE = register("marl_coarse", () -> new BlockItem(IcariaBlocks.MARL_COARSE.get(), new Properties()));

	public static final RegistryObject<Item> FARMLAND = register("farmland", () -> new BlockItem(IcariaBlocks.FARMLAND.get(), new Properties()));
	public static final RegistryObject<Item> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new BlockItem(IcariaBlocks.FARMLAND_FERTILIZED.get(), new Properties()));

	public static final RegistryObject<Item> MARL_ADOBE = register("marl_adobe", () -> new BlockItem(IcariaBlocks.MARL_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks MARL_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.MARL_ADOBE_DECO, MARL_ADOBE);

	public static final RegistryObject<Item> LOAM = register("loam", () -> new BlockItem(IcariaBlocks.LOAM.get(), new Properties()));
	public static final RegistryObject<Item> LOAM_BRICKS = register("loam_bricks", () -> new BlockItem(IcariaBlocks.LOAM_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks LOAM_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.LOAM_BRICKS_DECO, LOAM_BRICKS);

	public static final RegistryObject<Item> DOLOMITE_ADOBE = register("dolomite_adobe", () -> new BlockItem(IcariaBlocks.DOLOMITE_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks DOLOMITE_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.DOLOMITE_ADOBE_DECO, DOLOMITE_ADOBE);
	public static final RegistryObject<Item> DOLOMITE_SMOOTH = register("dolomite_smooth", () -> new BlockItem(IcariaBlocks.DOLOMITE_SMOOTH.get(), new Properties()));
	public static final StoneDecoItemBlocks DOLOMITE_SMOOTH_DECO = new StoneDecoItemBlocks(IcariaBlocks.DOLOMITE_SMOOTH_DECO, DOLOMITE_SMOOTH);
	public static final RegistryObject<Item> DOLOMITE_BRICKS = register("dolomite_bricks", () -> new BlockItem(IcariaBlocks.DOLOMITE_BRICKS.get(), new Properties()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new BlockItem(IcariaBlocks.DOLOMITE_PILLAR.get(), new Properties()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new BlockItem(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), new Properties()));

	public static final RegistryObject<Item> GRAINEL = register("grainel", () -> new BlockItem(IcariaBlocks.GRAINEL.get(), new Properties()));
	public static final RegistryObject<Item> GRAINEL_CHERT = register("grainel_chert", () -> new BlockItem(IcariaBlocks.GRAINEL_CHERT.get(), new Properties()));
	public static final RegistryObject<Item> GRAINGLASS = register("grainglass", () -> new BlockItem(IcariaBlocks.GRAINGLASS.get(), new Properties()));
	public static final RegistryObject<Item> GRAINGLASS_PANE = register("grainglass_pane", () -> new BlockItem(IcariaBlocks.GRAINGLASS_PANE.get(), new Properties()));
	public static final RegistryObject<Item> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", () -> new BlockItem(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), new Properties()));
	public static final RegistryObject<Item> GRAINITE_ADOBE = register("grainite_adobe", () -> new BlockItem(IcariaBlocks.GRAINITE_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks GRAINITE_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.GRAINITE_ADOBE_DECO, GRAINITE_ADOBE);
	public static final RegistryObject<Item> GRAINITE = register("grainite", () -> new BlockItem(IcariaBlocks.GRAINITE.get(), new Properties()));
	public static final StoneDecoItemBlocks GRAINITE_DECO = new StoneDecoItemBlocks(IcariaBlocks.GRAINITE_DECO, GRAINITE);
	public static final RegistryObject<Item> GRAINITE_BRICKS = register("grainite_bricks", () -> new BlockItem(IcariaBlocks.GRAINITE_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks GRAINITE_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.GRAINITE_BRICKS_DECO, GRAINITE_BRICKS);
	public static final RegistryObject<Item> GRAINITE_CHISELED = register("grainite_chiseled", () -> new BlockItem(IcariaBlocks.GRAINITE_CHISELED.get(), new Properties()));
	public static final RegistryObject<Item> GRAINITE_RUBBLE = register("grainite_rubble", () -> new BlockItem(IcariaBlocks.GRAINITE_RUBBLE.get(), new Properties()));

	public static final RegistryObject<Item> YELLOWSTONE_ADOBE = register("yellowstone_adobe", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks YELLOWSTONE_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.YELLOWSTONE_ADOBE_DECO, YELLOWSTONE_ADOBE);
	public static final RegistryObject<Item> YELLOWSTONE_COBBLE = register("yellowstone_cobble", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_COBBLE.get(), new Properties()));
	public static final StoneDecoItemBlocks YELLOWSTONE_COBBLE_DECO = new StoneDecoItemBlocks(IcariaBlocks.YELLOWSTONE_COBBLE_DECO, YELLOWSTONE_COBBLE);
	public static final RegistryObject<Item> YELLOWSTONE = register("yellowstone", () -> new BlockItem(IcariaBlocks.YELLOWSTONE.get(), new Properties()));
	public static final StoneDecoItemBlocks YELLOWSTONE_DECO = new StoneDecoItemBlocks(IcariaBlocks.YELLOWSTONE_DECO, YELLOWSTONE);
	public static final RegistryObject<Item> YELLOWSTONE_BRICKS = register("yellowstone_bricks", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks YELLOWSTONE_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.YELLOWSTONE_BRICKS_DECO, YELLOWSTONE_BRICKS);
	public static final RegistryObject<Item> YELLOWSTONE_CHISELED = register("yellowstone_chiseled", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_CHISELED.get(), new Properties()));
	public static final RegistryObject<Item> YELLOWSTONE_RUBBLE = register("yellowstone_rubble", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), new Properties()));

	public static final RegistryObject<Item> SILKSAND = register("silksand", () -> new BlockItem(IcariaBlocks.SILKSAND.get(), new Properties()));
	public static final RegistryObject<Item> SILKGLASS = register("silkglass", () -> new BlockItem(IcariaBlocks.SILKGLASS.get(), new Properties()));
	public static final RegistryObject<Item> SILKGLASS_PANE = register("silkglass_pane", () -> new BlockItem(IcariaBlocks.SILKGLASS_PANE.get(), new Properties()));
	public static final RegistryObject<Item> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", () -> new BlockItem(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), new Properties()));
	public static final RegistryObject<Item> SILKSTONE_ADOBE = register("silkstone_adobe", () -> new BlockItem(IcariaBlocks.SILKSTONE_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks SILKSTONE_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.SILKSTONE_ADOBE_DECO, SILKSTONE_ADOBE);
	public static final RegistryObject<Item> SILKSTONE_COBBLE = register("silkstone_cobble", () -> new BlockItem(IcariaBlocks.SILKSTONE_COBBLE.get(), new Properties()));
	public static final StoneDecoItemBlocks SILKSTONE_COBBLE_DECO = new StoneDecoItemBlocks(IcariaBlocks.SILKSTONE_COBBLE_DECO, SILKSTONE_COBBLE);
	public static final RegistryObject<Item> SILKSTONE = register("silkstone", () -> new BlockItem(IcariaBlocks.SILKSTONE.get(), new Properties()));
	public static final StoneDecoItemBlocks SILKSTONE_DECO = new StoneDecoItemBlocks(IcariaBlocks.SILKSTONE_DECO, SILKSTONE);
	public static final RegistryObject<Item> SILKSTONE_BRICKS = register("silkstone_bricks", () -> new BlockItem(IcariaBlocks.SILKSTONE_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks SILKSTONE_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.SILKSTONE_BRICKS_DECO, SILKSTONE_BRICKS);
	public static final RegistryObject<Item> SILKSTONE_CHISELED = register("silkstone_chiseled", () -> new BlockItem(IcariaBlocks.SILKSTONE_CHISELED.get(), new Properties()));
	public static final RegistryObject<Item> SILKSTONE_RUBBLE = register("silkstone_rubble", () -> new BlockItem(IcariaBlocks.SILKSTONE_RUBBLE.get(), new Properties()));

	public static final RegistryObject<Item> SUNSTONE_ADOBE = register("sunstone_adobe", () -> new BlockItem(IcariaBlocks.SUNSTONE_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks SUNSTONE_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.SUNSTONE_ADOBE_DECO, SUNSTONE_ADOBE);
	public static final RegistryObject<Item> SUNSTONE_COBBLE = register("sunstone_cobble", () -> new BlockItem(IcariaBlocks.SUNSTONE_COBBLE.get(), new Properties()));
	public static final StoneDecoItemBlocks SUNSTONE_COBBLE_DECO = new StoneDecoItemBlocks(IcariaBlocks.SUNSTONE_COBBLE_DECO, SUNSTONE_COBBLE);
	public static final RegistryObject<Item> SUNSTONE = register("sunstone", () -> new BlockItem(IcariaBlocks.SUNSTONE.get(), new Properties()));
	public static final StoneDecoItemBlocks SUNSTONE_DECO = new StoneDecoItemBlocks(IcariaBlocks.SUNSTONE_DECO, SUNSTONE);
	public static final RegistryObject<Item> SUNSTONE_BRICKS = register("sunstone_bricks", () -> new BlockItem(IcariaBlocks.SUNSTONE_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks SUNSTONE_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.SUNSTONE_BRICKS_DECO, SUNSTONE_BRICKS);
	public static final RegistryObject<Item> SUNSTONE_CHISELED = register("sunstone_chiseled", () -> new BlockItem(IcariaBlocks.SUNSTONE_CHISELED.get(), new Properties()));
	public static final RegistryObject<Item> SUNSTONE_RUBBLE = register("sunstone_rubble", () -> new BlockItem(IcariaBlocks.SUNSTONE_RUBBLE.get(), new Properties()));

	public static final RegistryObject<Item> VOIDSHALE_ADOBE = register("voidshale_adobe", () -> new BlockItem(IcariaBlocks.VOIDSHALE_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks VOIDSHALE_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.VOIDSHALE_ADOBE_DECO, VOIDSHALE_ADOBE);
	public static final RegistryObject<Item> VOIDSHALE_COBBLE = register("voidshale_cobble", () -> new BlockItem(IcariaBlocks.VOIDSHALE_COBBLE.get(), new Properties()));
	public static final StoneDecoItemBlocks VOIDSHALE_COBBLE_DECO = new StoneDecoItemBlocks(IcariaBlocks.VOIDSHALE_COBBLE_DECO, VOIDSHALE_COBBLE);
	public static final RegistryObject<Item> VOIDSHALE = register("voidshale", () -> new BlockItem(IcariaBlocks.VOIDSHALE.get(), new Properties()));
	public static final StoneDecoItemBlocks VOIDSHALE_DECO = new StoneDecoItemBlocks(IcariaBlocks.VOIDSHALE_DECO, VOIDSHALE);
	public static final RegistryObject<Item> VOIDSHALE_BRICKS = register("voidshale_bricks", () -> new BlockItem(IcariaBlocks.VOIDSHALE_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks VOIDSHALE_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.VOIDSHALE_BRICKS_DECO, VOIDSHALE_BRICKS);
	public static final RegistryObject<Item> VOIDSHALE_CHISELED = register("voidshale_chiseled", () -> new BlockItem(IcariaBlocks.VOIDSHALE_CHISELED.get(), new Properties()));
	public static final RegistryObject<Item> VOIDSHALE_RUBBLE = register("voidshale_rubble", () -> new BlockItem(IcariaBlocks.VOIDSHALE_RUBBLE.get(), new Properties()));

	public static final RegistryObject<Item> BAETYL_ADOBE = register("baetyl_adobe", () -> new BlockItem(IcariaBlocks.BAETYL_ADOBE.get(), new Properties()));
	public static final StoneDecoItemBlocks BAETYL_ADOBE_DECO = new StoneDecoItemBlocks(IcariaBlocks.BAETYL_ADOBE_DECO, BAETYL_ADOBE);
	public static final RegistryObject<Item> BAETYL_COBBLE = register("baetyl_cobble", () -> new BlockItem(IcariaBlocks.BAETYL_COBBLE.get(), new Properties()));
	public static final StoneDecoItemBlocks BAETYL_COBBLE_DECO = new StoneDecoItemBlocks(IcariaBlocks.BAETYL_COBBLE_DECO, BAETYL_COBBLE);
	public static final RegistryObject<Item> BAETYL = register("baetyl", () -> new BlockItem(IcariaBlocks.BAETYL.get(), new Properties()));
	public static final StoneDecoItemBlocks BAETYL_DECO = new StoneDecoItemBlocks(IcariaBlocks.BAETYL_DECO, BAETYL);
	public static final RegistryObject<Item> BAETYL_BRICKS = register("baetyl_bricks", () -> new BlockItem(IcariaBlocks.BAETYL_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks BAETYL_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.BAETYL_BRICKS_DECO, BAETYL_BRICKS);
	public static final RegistryObject<Item> BAETYL_CHISELED = register("baetyl_chiseled", () -> new BlockItem(IcariaBlocks.BAETYL_CHISELED.get(), new Properties()));
	public static final RegistryObject<Item> BAETYL_RUBBLE = register("baetyl_rubble", () -> new BlockItem(IcariaBlocks.BAETYL_RUBBLE.get(), new Properties()));

	public static final RegistryObject<Item> RELICSTONE = register("relicstone", () -> new BlockItem(IcariaBlocks.RELICSTONE.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_DECO, RELICSTONE);
	public static final RegistryObject<Item> RELICSTONE_SMOOTH = register("relicstone_smooth", () -> new BlockItem(IcariaBlocks.RELICSTONE_SMOOTH.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_SMOOTH_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_SMOOTH_DECO, RELICSTONE_SMOOTH);
	public static final RegistryObject<Item> RELICSTONE_BRICKS = register("relicstone_bricks", () -> new BlockItem(IcariaBlocks.RELICSTONE_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_BRICKS_DECO, RELICSTONE_BRICKS);
	public static final RegistryObject<Item> RELICSTONE_BRICKS_CRACKED = register("relicstone_bricks_cracked", () -> new BlockItem(IcariaBlocks.RELICSTONE_BRICKS_CRACKED.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_BRICKS_CRACKED_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO, RELICSTONE_BRICKS_CRACKED);
	public static final RegistryObject<Item> RELICSTONE_BRICKS_MOSSY = register("relicstone_bricks_mossy", () -> new BlockItem(IcariaBlocks.RELICSTONE_BRICKS_MOSSY.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_BRICKS_MOSSY_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO, RELICSTONE_BRICKS_MOSSY);
	public static final RegistryObject<Item> RELICSTONE_TILES = register("relicstone_tiles", () -> new BlockItem(IcariaBlocks.RELICSTONE_TILES.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_TILES_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_TILES_DECO, RELICSTONE_TILES);
	public static final RegistryObject<Item> RELICSTONE_TILES_CRACKED = register("relicstone_tiles_cracked", () -> new BlockItem(IcariaBlocks.RELICSTONE_TILES_CRACKED.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_TILES_CRACKED_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_TILES_CRACKED_DECO, RELICSTONE_TILES_CRACKED);
	public static final RegistryObject<Item> RELICSTONE_TILES_MOSSY = register("relicstone_tiles_mossy", () -> new BlockItem(IcariaBlocks.RELICSTONE_TILES_MOSSY.get(), new Properties()));
	public static final StoneDecoItemBlocks RELICSTONE_TILES_MOSSY_DECO = new StoneDecoItemBlocks(IcariaBlocks.RELICSTONE_TILES_MOSSY_DECO, RELICSTONE_TILES_MOSSY);
	public static final RegistryObject<Item> RELICSTONE_CHISELED = register("relicstone_chiseled", () -> new BlockItem(IcariaBlocks.RELICSTONE_CHISELED.get(), new Properties()));
	public static final RegistryObject<Item> RELICSTONE_PILLAR = register("relicstone_pillar", () -> new BlockItem(IcariaBlocks.RELICSTONE_PILLAR.get(), new Properties()));
	public static final RegistryObject<Item> RELICSTONE_PILLAR_HEAD = register("relicstone_pillar_head", () -> new BlockItem(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), new Properties()));
	public static final RegistryObject<Item> RELICSTONE_RUBBLE = register("relicstone_rubble", () -> new BlockItem(IcariaBlocks.RELICSTONE_RUBBLE.get(), new Properties()));

	public static final RegistryObject<Item> PLATOSHALE = register("platoshale", () -> new BlockItem(IcariaBlocks.PLATOSHALE.get(), new Properties()));
	public static final StoneDecoItemBlocks PLATOSHALE_DECO = new StoneDecoItemBlocks(IcariaBlocks.PLATOSHALE_DECO, PLATOSHALE);
	public static final RegistryObject<Item> PLATOSHALE_BLURRED = register("platoshale_blurred", () -> new BlockItem(IcariaBlocks.PLATOSHALE_BLURRED.get(), new Properties()));
	public static final RegistryObject<Item> PLATOSHALE_BRICKS = register("platoshale_bricks", () -> new BlockItem(IcariaBlocks.PLATOSHALE_BRICKS.get(), new Properties()));
	public static final StoneDecoItemBlocks PLATOSHALE_BRICKS_DECO = new StoneDecoItemBlocks(IcariaBlocks.PLATOSHALE_BRICKS_DECO, PLATOSHALE_BRICKS);
	public static final RegistryObject<Item> PLATOSHALE_BRICKS_BLURRED = register("platoshale_bricks_blurred", () -> new BlockItem(IcariaBlocks.PLATOSHALE_BRICKS_BLURRED.get(), new Properties()));
	public static final RegistryObject<Item> PLATOSHALE_CHISELED = register("platoshale_chiseled", () -> new BlockItem(IcariaBlocks.PLATOSHALE_CHISELED.get(), new Properties()));

	public static final RegistryObject<Item> QUARTZ_PILLAR_HEAD = register("quartz_pillar_head", () -> new BlockItem(IcariaBlocks.QUARTZ_PILLAR_HEAD.get(), new Properties()));

	public static final RegistryObject<Item> LIGNITE_ORE = register("lignite_ore", () -> new BlockItem(IcariaBlocks.LIGNITE_ORE.get(), new Properties()));
	public static final RegistryObject<Item> CHALKOS_ORE = register("chalkos_ore", () -> new BlockItem(IcariaBlocks.CHALKOS_ORE.get(), new Properties()));
	public static final RegistryObject<Item> KASSITEROS_ORE = register("kassiteros_ore", () -> new BlockItem(IcariaBlocks.KASSITEROS_ORE.get(), new Properties()));
	public static final RegistryObject<Item> DOLOMITE_ORE = register("dolomite_ore", () -> new BlockItem(IcariaBlocks.DOLOMITE_ORE.get(), new Properties()));
	public static final RegistryObject<Item> VANADIUM_ORE = register("vanadium_ore", () -> new BlockItem(IcariaBlocks.VANADIUM_ORE.get(), new Properties()));
	public static final RegistryObject<Item> SLIVER_ORE = register("sliver_ore", () -> new BlockItem(IcariaBlocks.SLIVER_ORE.get(), new Properties()));
	public static final RegistryObject<Item> SIDEROS_ORE = register("sideros_ore", () -> new BlockItem(IcariaBlocks.SIDEROS_ORE.get(), new Properties()));
	public static final RegistryObject<Item> ANTHRACITE_ORE = register("anthracite_ore", () -> new BlockItem(IcariaBlocks.ANTHRACITE_ORE.get(), new Properties()));
	public static final RegistryObject<Item> MOLYBDENUM_ORE = register("molybdenum_ore", () -> new BlockItem(IcariaBlocks.MOLYBDENUM_ORE.get(), new Properties()));
	public static final RegistryObject<Item> HYLIASTRUM_ORE = register("hyliastrum_ore", () -> new BlockItem(IcariaBlocks.HYLIASTRUM_ORE.get(), new Properties()));

	public static final RegistryObject<Item> CALCITE_GEODE_BLOCK = register("calcite_geode_block", () -> new BlockItem(IcariaBlocks.CALCITE_GEODE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> BUDDING_CALCITE_GEODE_BLOCK = register("budding_calcite_geode_block", () -> new BlockItem(IcariaBlocks.BUDDING_CALCITE_GEODE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> HALITE_GEODE_BLOCK = register("halite_geode_block", () -> new BlockItem(IcariaBlocks.HALITE_GEODE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> BUDDING_HALITE_GEODE_BLOCK = register("budding_halite_geode_block", () -> new BlockItem(IcariaBlocks.BUDDING_HALITE_GEODE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> JASPER_GEODE_BLOCK = register("jasper_geode_block", () -> new BlockItem(IcariaBlocks.JASPER_GEODE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> BUDDING_JASPER_GEODE_BLOCK = register("budding_jasper_geode_block", () -> new BlockItem(IcariaBlocks.BUDDING_JASPER_GEODE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> ZIRCON_GEODE_BLOCK = register("zircon_geode_block", () -> new BlockItem(IcariaBlocks.ZIRCON_GEODE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> BUDDING_ZIRCON_GEODE_BLOCK = register("budding_zircon_geode_block", () -> new BlockItem(IcariaBlocks.BUDDING_ZIRCON_GEODE_BLOCK.get(), new Properties()));

	public static final RegistryObject<Item> CALCITE_CRYSTAL = register("calcite_crystal", () -> new BlockItem(IcariaBlocks.CALCITE_CRYSTAL.get(), new Properties()));
	public static final RegistryObject<Item> HALITE_CRYSTAL = register("halite_crystal", () -> new BlockItem(IcariaBlocks.HALITE_CRYSTAL.get(), new Properties()));
	public static final RegistryObject<Item> JASPER_CRYSTAL = register("jasper_crystal", () -> new BlockItem(IcariaBlocks.JASPER_CRYSTAL.get(), new Properties()));
	public static final RegistryObject<Item> ZIRCON_CRYSTAL = register("zircon_crystal", () -> new BlockItem(IcariaBlocks.ZIRCON_CRYSTAL.get(), new Properties()));

	public static final RegistryObject<Item> ARISTONE = register("aristone", () -> new BlockItem(IcariaBlocks.ARISTONE.get(), new Properties()));
	public static final RegistryObject<Item> ARISTONE_PACKED = register("aristone_packed", () -> new BlockItem(IcariaBlocks.ARISTONE_PACKED.get(), new Properties()));

	public static final RegistryObject<Item> ENDER_JELLYFISH_JELLY_BLOCK = register("ender_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> FIRE_JELLYFISH_JELLY_BLOCK = register("fire_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> NATURE_JELLYFISH_JELLY_BLOCK = register("nature_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> VOID_JELLYFISH_JELLY_BLOCK = register("void_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> WATER_JELLYFISH_JELLY_BLOCK = register("water_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> ARACHNE_STRING_BLOCK = register("arachne_string_block", () -> new FuelBlockItem(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), new Properties(), 100));
	public static final RegistryObject<Item> SPELT_BALE_BLOCK = register("spelt_bale_block", () -> new BlockItem(IcariaBlocks.SPELT_BALE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> VINE_REED_BLOCK = register("vine_reed_block", () -> new BlockItem(IcariaBlocks.VINE_REED_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> VINE_SPROUT_BLOCK = register("vine_sprout_block", () -> new BlockItem(IcariaBlocks.VINE_SPROUT_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> ROTTEN_BONES_BLOCK = register("rotten_bones_block", () -> new BlockItem(IcariaBlocks.ROTTEN_BONES_BLOCK.get(), new Properties()));

	public static final RegistryObject<Item> CHALKOS_RAW_BLOCK = register("chalkos_raw_block", () -> new BlockItem(IcariaBlocks.CHALKOS_RAW_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> KASSITEROS_RAW_BLOCK = register("kassiteros_raw_block", () -> new BlockItem(IcariaBlocks.KASSITEROS_RAW_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> VANADIUM_RAW_BLOCK = register("vanadium_raw_block", () -> new BlockItem(IcariaBlocks.VANADIUM_RAW_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> SLIVER_BLOCK = register("sliver_block", () -> new BlockItem(IcariaBlocks.SLIVER_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> SIDEROS_RAW_BLOCK = register("sideros_raw_block", () -> new BlockItem(IcariaBlocks.SIDEROS_RAW_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> MOLYBDENUM_RAW_BLOCK = register("molybdenum_raw_block", () -> new BlockItem(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get(), new Properties()));

	public static final RegistryObject<Item> CALCITE_BLOCK = register("calcite_block", () -> new BlockItem(IcariaBlocks.CALCITE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> HALITE_BLOCK = register("halite_block", () -> new BlockItem(IcariaBlocks.HALITE_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> JASPER_BLOCK = register("jasper_block", () -> new BlockItem(IcariaBlocks.JASPER_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> ZIRCON_BLOCK = register("zircon_block", () -> new BlockItem(IcariaBlocks.ZIRCON_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> CHERT_BLOCK = register("chert_block", () -> new BlockItem(IcariaBlocks.CHERT_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> LIGNITE_BLOCK = register("lignite_block", () -> new FuelBlockItem(IcariaBlocks.LIGNITE_BLOCK.get(), new Properties(), 7200));
	public static final RegistryObject<Item> CHALKOS_BLOCK = register("chalkos_block", () -> new BlockItem(IcariaBlocks.CHALKOS_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> KASSITEROS_BLOCK = register("kassiteros_block", () -> new BlockItem(IcariaBlocks.KASSITEROS_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> ORICHALCUM_BLOCK = register("orichalcum_block", () -> new BlockItem(IcariaBlocks.ORICHALCUM_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> VANADIUM_BLOCK = register("vanadium_block", () -> new BlockItem(IcariaBlocks.VANADIUM_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> VANADIUMSTEEL_BLOCK = register("vanadiumsteel_block", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> SIDEROS_BLOCK = register("sideros_block", () -> new BlockItem(IcariaBlocks.SIDEROS_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> ANTHRACITE_BLOCK = register("anthracite_block", () -> new FuelBlockItem(IcariaBlocks.ANTHRACITE_BLOCK.get(), new Properties(), 28800));
	public static final RegistryObject<Item> MOLYBDENUM_BLOCK = register("molybdenum_block", () -> new BlockItem(IcariaBlocks.MOLYBDENUM_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> MOLYBDENUMSTEEL_BLOCK = register("molybdenumsteel_block", () -> new BlockItem(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get(), new Properties()));
	public static final RegistryObject<Item> BLURIDIUM_BLOCK = register("bluridium_block", () -> new BlockItem(IcariaBlocks.BLURIDIUM_BLOCK.get(), new Properties()));

	public static final RegistryObject<Item> VANADIUMSTEEL_BARS = register("vanadiumsteel_bars", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_BARS.get(), new Properties()));
	public static final RegistryObject<Item> VANADIUMSTEEL_BARS_HORIZONTAL = register("vanadiumsteel_bars_horizontal", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_BARS_HORIZONTAL.get(), new Properties()));

	public static final RegistryObject<Item> GRINDER = register("grinder", () -> new BlockItem(IcariaBlocks.GRINDER.get(), new Properties()));

	public static final RegistryObject<Item> STORAGE_VASE = register("storage_vase", () -> new BlockItem(IcariaBlocks.STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> WHITE_STORAGE_VASE = register("white_storage_vase", () -> new BlockItem(IcariaBlocks.WHITE_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> LIGHT_GRAY_STORAGE_VASE = register("light_gray_storage_vase", () -> new BlockItem(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> GRAY_STORAGE_VASE = register("gray_storage_vase", () -> new BlockItem(IcariaBlocks.GRAY_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> BLACK_STORAGE_VASE = register("black_storage_vase", () -> new BlockItem(IcariaBlocks.BLACK_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> BROWN_STORAGE_VASE = register("brown_storage_vase", () -> new BlockItem(IcariaBlocks.BROWN_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> RED_STORAGE_VASE = register("red_storage_vase", () -> new BlockItem(IcariaBlocks.RED_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> ORANGE_STORAGE_VASE = register("orange_storage_vase", () -> new BlockItem(IcariaBlocks.ORANGE_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> YELLOW_STORAGE_VASE = register("yellow_storage_vase", () -> new BlockItem(IcariaBlocks.YELLOW_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> LIME_STORAGE_VASE = register("lime_storage_vase", () -> new BlockItem(IcariaBlocks.LIME_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> GREEN_STORAGE_VASE = register("green_storage_vase", () -> new BlockItem(IcariaBlocks.GREEN_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> CYAN_STORAGE_VASE = register("cyan_storage_vase", () -> new BlockItem(IcariaBlocks.CYAN_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> LIGHT_BLUE_STORAGE_VASE = register("light_blue_storage_vase", () -> new BlockItem(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> BLUE_STORAGE_VASE = register("blue_storage_vase", () -> new BlockItem(IcariaBlocks.BLUE_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> PURPLE_STORAGE_VASE = register("purple_storage_vase", () -> new BlockItem(IcariaBlocks.PURPLE_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> MAGENTA_STORAGE_VASE = register("magenta_storage_vase", () -> new BlockItem(IcariaBlocks.MAGENTA_STORAGE_VASE.get(), new Properties()));
	public static final RegistryObject<Item> PINK_STORAGE_VASE = register("pink_storage_vase", () -> new BlockItem(IcariaBlocks.PINK_STORAGE_VASE.get(), new Properties()));

	public static final RegistryObject<Item> AETERNAE_SKULL = register("aeternae_skull", () -> new IcariaSkullItem(IcariaBlocks.AETERNAE_SKULL.get(), IcariaBlocks.AETERNAE_WALL_SKULL.get(), new Properties(), Direction.DOWN));
	public static final RegistryObject<Item> ARGAN_HOUND_SKULL = register("argan_hound_skull", () -> new IcariaSkullItem(IcariaBlocks.ARGAN_HOUND_SKULL.get(), IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), new Properties(), Direction.DOWN));
	public static final RegistryObject<Item> CATOBLEPAS_SKULL = register("catoblepas_skull", () -> new IcariaSkullItem(IcariaBlocks.CATOBLEPAS_SKULL.get(), IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), new Properties(), Direction.DOWN));
	public static final RegistryObject<Item> CERVER_SKULL = register("cerver_skull", () -> new IcariaSkullItem(IcariaBlocks.CERVER_SKULL.get(), IcariaBlocks.CERVER_WALL_SKULL.get(), new Properties(), Direction.DOWN));
	public static final RegistryObject<Item> SOW_SKULL = register("sow_skull", () -> new IcariaSkullItem(IcariaBlocks.SOW_SKULL.get(), IcariaBlocks.SOW_WALL_SKULL.get(), new Properties(), Direction.DOWN));

	public static final RegistryObject<Item> DIM_TORCH = registerBasic("dim_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.DIM_TORCH.get(), IcariaBlocks.DIM_WALL_TORCH.get(), new Properties(), Direction.DOWN));
	public static final RegistryObject<Item> LIGNITE_TORCH = registerBasic("lignite_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.LIGNITE_TORCH.get(), IcariaBlocks.LIGNITE_WALL_TORCH.get(), new Properties(), Direction.DOWN));
	public static final RegistryObject<Item> ANTHRACITE_TORCH = registerBasic("anthracite_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.ANTHRACITE_TORCH.get(), IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), new Properties(), Direction.DOWN));

	public static final RegistryObject<Item> LAUREL_CHERRY_CAKE = registerBasic("laurel_cherry_cake", () -> new BlockItem(IcariaBlocks.LAUREL_CHERRY_CAKE.get(), new Properties()));
	public static final RegistryObject<Item> STRAWBERRY_CAKE = registerBasic("strawberry_cake", () -> new BlockItem(IcariaBlocks.STRAWBERRY_CAKE.get(), new Properties()));
	public static final RegistryObject<Item> PHYSALIS_CAKE = registerBasic("physalis_cake", () -> new BlockItem(IcariaBlocks.PHYSALIS_CAKE.get(), new Properties()));
	public static final RegistryObject<Item> VINE_BERRY_CAKE = registerBasic("vine_berry_cake", () -> new BlockItem(IcariaBlocks.VINE_BERRY_CAKE.get(), new Properties()));
	public static final RegistryObject<Item> VINE_SPROUT_CAKE = registerBasic("vine_sprout_cake", () -> new BlockItem(IcariaBlocks.VINE_SPROUT_CAKE.get(), new Properties()));

	public static final RegistryObject<Item> CYPRESS_SAPLING = register("cypress_sapling", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_SAPLING.get(), new Properties(), 100));
	public static final RegistryObject<Item> CYPRESS_LEAVES = register("cypress_leaves", () -> new BlockItem(IcariaBlocks.CYPRESS_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> FALLEN_CYPRESS_LEAVES = register("fallen_cypress_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> CYPRESS_TWIGS = register("cypress_twigs", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_TWIGS.get(), new Properties(), 100));
	public static final RegistryObject<Item> CYPRESS_WOOD = register("cypress_wood", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_CYPRESS_WOOD = register("stripped_cypress_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> CYPRESS_LOG = register("cypress_log", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_CYPRESS_LOG = register("stripped_cypress_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> DEAD_CYPRESS_LOG = register("dead_cypress_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_CYPRESS_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_CYPRESS_LOG = register("stripped_dead_cypress_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> CYPRESS_PLANKS = register("cypress_planks", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_PLANKS.get(), new Properties(), 300));
	public static final WoodDecoItemBlocks CYPRESS_DECO = new WoodDecoItemBlocks(IcariaBlocks.CYPRESS_DECO, CYPRESS_PLANKS);
	public static final RegistryObject<Item> CYPRESS_CRAFTING_TABLE = register("cypress_crafting_table", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), new Properties(), 300));
	public static final RegistryObject<Item> CYPRESS_DOOR = registerBasic("cypress_door", () -> new BlockItem(IcariaBlocks.CYPRESS_DOOR.get(), new Properties()));
	public static final RegistryObject<Item> CYPRESS_TRAPDOOR = register("cypress_trapdoor", () -> new BlockItem(IcariaBlocks.CYPRESS_TRAPDOOR.get(), new Properties()));
	public static final RegistryObject<Item> CYPRESS_LADDER = registerBasic("cypress_ladder", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_LADDER.get(), new Properties(), 300));
	public static final RegistryObject<Item> CYPRESS_SIGN = registerBasic("cypress_sign", () -> new IcariaSignItem(new Properties(), IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_WALL_SIGN.get()));

	public static final RegistryObject<Item> DROUGHTROOT_SAPLING = register("droughtroot_sapling", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_SAPLING.get(), new Properties(), 100));
	public static final RegistryObject<Item> DROUGHTROOT_LEAVES = register("droughtroot_leaves", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> FALLEN_DROUGHTROOT_LEAVES = register("fallen_droughtroot_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> DROUGHTROOT_TWIGS = register("droughtroot_twigs", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_TWIGS.get(), new Properties(), 100));
	public static final RegistryObject<Item> DROUGHTROOT_WOOD = register("droughtroot_wood", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_DROUGHTROOT_WOOD = register("stripped_droughtroot_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> DROUGHTROOT_LOG = register("droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_DROUGHTROOT_LOG = register("stripped_droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> DEAD_DROUGHTROOT_LOG = register("dead_droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_DROUGHTROOT_LOG = register("stripped_dead_droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> DROUGHTROOT_PLANKS = register("droughtroot_planks", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_PLANKS.get(), new Properties(), 300));
	public static final WoodDecoItemBlocks DROUGHTROOT_DECO = new WoodDecoItemBlocks(IcariaBlocks.DROUGHTROOT_DECO, DROUGHTROOT_PLANKS);
	public static final RegistryObject<Item> DROUGHTROOT_CRAFTING_TABLE = register("droughtroot_crafting_table", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), new Properties(), 300));
	public static final RegistryObject<Item> DROUGHTROOT_DOOR = registerBasic("droughtroot_door", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_DOOR.get(), new Properties()));
	public static final RegistryObject<Item> DROUGHTROOT_TRAPDOOR = register("droughtroot_trapdoor", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), new Properties()));
	public static final RegistryObject<Item> DROUGHTROOT_LADDER = registerBasic("droughtroot_ladder", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_LADDER.get(), new Properties(), 300));
	public static final RegistryObject<Item> DROUGHTROOT_SIGN = registerBasic("droughtroot_sign", () -> new IcariaSignItem(new Properties(), IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_SIGN.get()));

	public static final RegistryObject<Item> FIR_SAPLING = register("fir_sapling", () -> new FuelBlockItem(IcariaBlocks.FIR_SAPLING.get(), new Properties(), 100));
	public static final RegistryObject<Item> FIR_LEAVES = register("fir_leaves", () -> new BlockItem(IcariaBlocks.FIR_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> FALLEN_FIR_LEAVES = register("fallen_fir_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_FIR_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> FIR_TWIGS = register("fir_twigs", () -> new FuelBlockItem(IcariaBlocks.FIR_TWIGS.get(), new Properties(), 100));
	public static final RegistryObject<Item> FIR_WOOD = register("fir_wood", () -> new FuelBlockItem(IcariaBlocks.FIR_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_FIR_WOOD = register("stripped_fir_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_FIR_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> FIR_LOG = register("fir_log", () -> new FuelBlockItem(IcariaBlocks.FIR_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_FIR_LOG = register("stripped_fir_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_FIR_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> DEAD_FIR_LOG = register("dead_fir_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_FIR_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_FIR_LOG = register("stripped_dead_fir_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> FIR_PLANKS = register("fir_planks", () -> new FuelBlockItem(IcariaBlocks.FIR_PLANKS.get(), new Properties(), 300));
	public static final WoodDecoItemBlocks FIR_DECO = new WoodDecoItemBlocks(IcariaBlocks.FIR_DECO, FIR_PLANKS);
	public static final RegistryObject<Item> FIR_CRAFTING_TABLE = register("fir_crafting_table", () -> new FuelBlockItem(IcariaBlocks.FIR_CRAFTING_TABLE.get(), new Properties(), 300));
	public static final RegistryObject<Item> FIR_DOOR = registerBasic("fir_door", () -> new BlockItem(IcariaBlocks.FIR_DOOR.get(), new Properties()));
	public static final RegistryObject<Item> FIR_TRAPDOOR = register("fir_trapdoor", () -> new BlockItem(IcariaBlocks.FIR_TRAPDOOR.get(), new Properties()));
	public static final RegistryObject<Item> FIR_LADDER = registerBasic("fir_ladder", () -> new FuelBlockItem(IcariaBlocks.FIR_LADDER.get(), new Properties(), 300));
	public static final RegistryObject<Item> FIR_SIGN = registerBasic("fir_sign", () -> new IcariaSignItem(new Properties(), IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_WALL_SIGN.get()));

	public static final RegistryObject<Item> LAUREL_SAPLING = register("laurel_sapling", () -> new FuelBlockItem(IcariaBlocks.LAUREL_SAPLING.get(), new Properties(), 100));
	public static final RegistryObject<Item> LAUREL_LEAVES = register("laurel_leaves", () -> new BlockItem(IcariaBlocks.LAUREL_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> FALLEN_LAUREL_LEAVES = register("fallen_laurel_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> LAUREL_TWIGS = register("laurel_twigs", () -> new FuelBlockItem(IcariaBlocks.LAUREL_TWIGS.get(), new Properties(), 100));
	public static final RegistryObject<Item> LAUREL_WOOD = register("laurel_wood", () -> new FuelBlockItem(IcariaBlocks.LAUREL_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_LAUREL_WOOD = register("stripped_laurel_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> LAUREL_LOG = register("laurel_log", () -> new FuelBlockItem(IcariaBlocks.LAUREL_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_LAUREL_LOG = register("stripped_laurel_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> DEAD_LAUREL_LOG = register("dead_laurel_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_LAUREL_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_LAUREL_LOG = register("stripped_dead_laurel_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> LAUREL_PLANKS = register("laurel_planks", () -> new FuelBlockItem(IcariaBlocks.LAUREL_PLANKS.get(), new Properties(), 300));
	public static final WoodDecoItemBlocks LAUREL_DECO = new WoodDecoItemBlocks(IcariaBlocks.LAUREL_DECO, LAUREL_PLANKS);
	public static final RegistryObject<Item> LAUREL_CRAFTING_TABLE = register("laurel_crafting_table", () -> new FuelBlockItem(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), new Properties(), 300));
	public static final RegistryObject<Item> LAUREL_DOOR = registerBasic("laurel_door", () -> new BlockItem(IcariaBlocks.LAUREL_DOOR.get(), new Properties()));
	public static final RegistryObject<Item> LAUREL_TRAPDOOR = register("laurel_trapdoor", () -> new BlockItem(IcariaBlocks.LAUREL_TRAPDOOR.get(), new Properties()));
	public static final RegistryObject<Item> LAUREL_LADDER = registerBasic("laurel_ladder", () -> new FuelBlockItem(IcariaBlocks.LAUREL_LADDER.get(), new Properties(), 300));
	public static final RegistryObject<Item> LAUREL_SIGN = registerBasic("laurel_sign", () -> new IcariaSignItem(new Properties(), IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_WALL_SIGN.get()));

	public static final RegistryObject<Item> OLIVE_SAPLING = register("olive_sapling", () -> new FuelBlockItem(IcariaBlocks.OLIVE_SAPLING.get(), new Properties(), 100));
	public static final RegistryObject<Item> OLIVE_LEAVES = register("olive_leaves", () -> new BlockItem(IcariaBlocks.OLIVE_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> OLIVE_LEAVES_BLACK = register("olive_leaves_black", () -> new BlockItem(IcariaBlocks.OLIVE_LEAVES_BLACK.get(), new Properties()));
	public static final RegistryObject<Item> OLIVE_LEAVES_GREEN = register("olive_leaves_green", () -> new BlockItem(IcariaBlocks.OLIVE_LEAVES_GREEN.get(), new Properties()));
	public static final RegistryObject<Item> FALLEN_OLIVE_LEAVES = register("fallen_olive_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> OLIVE_TWIGS = register("olive_twigs", () -> new FuelBlockItem(IcariaBlocks.OLIVE_TWIGS.get(), new Properties(), 100));
	public static final RegistryObject<Item> OLIVE_WOOD = register("olive_wood", () -> new FuelBlockItem(IcariaBlocks.OLIVE_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_OLIVE_WOOD = register("stripped_olive_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> OLIVE_LOG = register("olive_log", () -> new FuelBlockItem(IcariaBlocks.OLIVE_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_OLIVE_LOG = register("stripped_olive_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> DEAD_OLIVE_LOG = register("dead_olive_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_OLIVE_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_OLIVE_LOG = register("stripped_dead_olive_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> OLIVE_PLANKS = register("olive_planks", () -> new FuelBlockItem(IcariaBlocks.OLIVE_PLANKS.get(), new Properties(), 300));
	public static final WoodDecoItemBlocks OLIVE_DECO = new WoodDecoItemBlocks(IcariaBlocks.OLIVE_DECO, OLIVE_PLANKS);
	public static final RegistryObject<Item> OLIVE_CRAFTING_TABLE = register("olive_crafting_table", () -> new FuelBlockItem(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), new Properties(), 300));
	public static final RegistryObject<Item> OLIVE_DOOR = registerBasic("olive_door", () -> new BlockItem(IcariaBlocks.OLIVE_DOOR.get(), new Properties()));
	public static final RegistryObject<Item> OLIVE_TRAPDOOR = register("olive_trapdoor", () -> new BlockItem(IcariaBlocks.OLIVE_TRAPDOOR.get(), new Properties()));
	public static final RegistryObject<Item> OLIVE_LADDER = registerBasic("olive_ladder", () -> new FuelBlockItem(IcariaBlocks.OLIVE_LADDER.get(), new Properties(), 300));
	public static final RegistryObject<Item> OLIVE_SIGN = registerBasic("olive_sign", () -> new IcariaSignItem(new Properties(), IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_WALL_SIGN.get()));

	public static final RegistryObject<Item> PLANE_SAPLING = register("plane_sapling", () -> new FuelBlockItem(IcariaBlocks.PLANE_SAPLING.get(), new Properties(), 100));
	public static final RegistryObject<Item> PLANE_LEAVES = register("plane_leaves", () -> new BlockItem(IcariaBlocks.PLANE_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> FALLEN_PLANE_LEAVES = register("fallen_plane_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> PLANE_TWIGS = register("plane_twigs", () -> new FuelBlockItem(IcariaBlocks.PLANE_TWIGS.get(), new Properties(), 100));
	public static final RegistryObject<Item> PLANE_WOOD = register("plane_wood", () -> new FuelBlockItem(IcariaBlocks.PLANE_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_PLANE_WOOD = register("stripped_plane_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> PLANE_LOG = register("plane_log", () -> new FuelBlockItem(IcariaBlocks.PLANE_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_PLANE_LOG = register("stripped_plane_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_PLANE_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> DEAD_PLANE_LOG = register("dead_plane_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_PLANE_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_PLANE_LOG = register("stripped_dead_plane_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> PLANE_PLANKS = register("plane_planks", () -> new FuelBlockItem(IcariaBlocks.PLANE_PLANKS.get(), new Properties(), 300));
	public static final WoodDecoItemBlocks PLANE_DECO = new WoodDecoItemBlocks(IcariaBlocks.PLANE_DECO, PLANE_PLANKS);
	public static final RegistryObject<Item> PLANE_CRAFTING_TABLE = register("plane_crafting_table", () -> new FuelBlockItem(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), new Properties(), 300));
	public static final RegistryObject<Item> PLANE_DOOR = registerBasic("plane_door", () -> new BlockItem(IcariaBlocks.PLANE_DOOR.get(), new Properties()));
	public static final RegistryObject<Item> PLANE_TRAPDOOR = register("plane_trapdoor", () -> new BlockItem(IcariaBlocks.PLANE_TRAPDOOR.get(), new Properties()));
	public static final RegistryObject<Item> PLANE_LADDER = registerBasic("plane_ladder", () -> new FuelBlockItem(IcariaBlocks.PLANE_LADDER.get(), new Properties(), 300));
	public static final RegistryObject<Item> PLANE_SIGN = registerBasic("plane_sign", () -> new IcariaSignItem(new Properties(), IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_WALL_SIGN.get()));

	public static final RegistryObject<Item> POPULUS_SAPLING = register("populus_sapling", () -> new FuelBlockItem(IcariaBlocks.POPULUS_SAPLING.get(), new Properties(), 100));
	public static final RegistryObject<Item> POPULUS_LEAVES = register("populus_leaves", () -> new BlockItem(IcariaBlocks.POPULUS_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> FALLEN_POPULUS_LEAVES = register("fallen_populus_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), new Properties()));
	public static final RegistryObject<Item> POPULUS_TWIGS = register("populus_twigs", () -> new FuelBlockItem(IcariaBlocks.POPULUS_TWIGS.get(), new Properties(), 100));
	public static final RegistryObject<Item> POPULUS_WOOD = register("populus_wood", () -> new FuelBlockItem(IcariaBlocks.POPULUS_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_POPULUS_WOOD = register("stripped_populus_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), new Properties(), 300));
	public static final RegistryObject<Item> POPULUS_LOG = register("populus_log", () -> new FuelBlockItem(IcariaBlocks.POPULUS_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_POPULUS_LOG = register("stripped_populus_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), new Properties(), 300));
	public static final RegistryObject<Item> DEAD_POPULUS_LOG = register("dead_populus_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_POPULUS_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_POPULUS_LOG = register("stripped_dead_populus_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), new Properties(), 100));
	public static final RegistryObject<Item> POPULUS_PLANKS = register("populus_planks", () -> new FuelBlockItem(IcariaBlocks.POPULUS_PLANKS.get(), new Properties(), 300));
	public static final WoodDecoItemBlocks POPULUS_DECO = new WoodDecoItemBlocks(IcariaBlocks.POPULUS_DECO, POPULUS_PLANKS);
	public static final RegistryObject<Item> POPULUS_CRAFTING_TABLE = register("populus_crafting_table", () -> new FuelBlockItem(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), new Properties(), 300));
	public static final RegistryObject<Item> POPULUS_DOOR = registerBasic("populus_door", () -> new BlockItem(IcariaBlocks.POPULUS_DOOR.get(), new Properties()));
	public static final RegistryObject<Item> POPULUS_TRAPDOOR = register("populus_trapdoor", () -> new BlockItem(IcariaBlocks.POPULUS_TRAPDOOR.get(), new Properties()));
	public static final RegistryObject<Item> POPULUS_LADDER = registerBasic("populus_ladder", () -> new FuelBlockItem(IcariaBlocks.POPULUS_LADDER.get(), new Properties(), 300));
	public static final RegistryObject<Item> POPULUS_SIGN = registerBasic("populus_sign", () -> new IcariaSignItem(new Properties(), IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_WALL_SIGN.get()));

	public static final RegistryObject<Item> DEAD_BLOOMY_VINE = registerBasic("dead_bloomy_vine", () -> new BlockItem(IcariaBlocks.DEAD_BLOOMY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> GROWING_BLOOMY_VINE = registerBasic("growing_bloomy_vine", () -> new BlockItem(IcariaBlocks.GROWING_BLOOMY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> BLOOMY_VINE = registerBasic("bloomy_vine", () -> new BlockItem(IcariaBlocks.BLOOMY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> BLOOMING_BLOOMY_VINE = registerBasic("blooming_bloomy_vine", () -> new BlockItem(IcariaBlocks.BLOOMING_BLOOMY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> RIPE_BLOOMY_VINE = registerBasic("ripe_bloomy_vine", () -> new BlockItem(IcariaBlocks.RIPE_BLOOMY_VINE.get(), new Properties()));

	public static final RegistryObject<Item> DEAD_BRANCHY_VINE = registerBasic("dead_branchy_vine", () -> new BlockItem(IcariaBlocks.DEAD_BRANCHY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> GROWING_BRANCHY_VINE = registerBasic("growing_branchy_vine", () -> new BlockItem(IcariaBlocks.GROWING_BRANCHY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> BRANCHY_VINE = registerBasic("branchy_vine", () -> new BlockItem(IcariaBlocks.BRANCHY_VINE.get(), new Properties()));

	public static final RegistryObject<Item> DEAD_BRUSHY_VINE = registerBasic("dead_brushy_vine", () -> new BlockItem(IcariaBlocks.DEAD_BRUSHY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> GROWING_BRUSHY_VINE = registerBasic("growing_brushy_vine", () -> new BlockItem(IcariaBlocks.GROWING_BRUSHY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> BRUSHY_VINE = registerBasic("brushy_vine", () -> new BlockItem(IcariaBlocks.BRUSHY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> RIPE_BRUSHY_VINE = registerBasic("ripe_brushy_vine", () -> new BlockItem(IcariaBlocks.RIPE_BRUSHY_VINE.get(), new Properties()));

	public static final RegistryObject<Item> DEAD_DRY_VINE = registerBasic("dead_dry_vine", () -> new BlockItem(IcariaBlocks.DEAD_DRY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> GROWING_DRY_VINE = registerBasic("growing_dry_vine", () -> new BlockItem(IcariaBlocks.GROWING_DRY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> DRY_VINE = registerBasic("dry_vine", () -> new BlockItem(IcariaBlocks.DRY_VINE.get(), new Properties()));

	public static final RegistryObject<Item> DEAD_REEDY_VINE = registerBasic("dead_reedy_vine", () -> new BlockItem(IcariaBlocks.DEAD_REEDY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> GROWING_REEDY_VINE = registerBasic("growing_reedy_vine", () -> new BlockItem(IcariaBlocks.GROWING_REEDY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> REEDY_VINE = registerBasic("reedy_vine", () -> new BlockItem(IcariaBlocks.REEDY_VINE.get(), new Properties()));

	public static final RegistryObject<Item> DEAD_SWIRLY_VINE = registerBasic("dead_swirly_vine", () -> new BlockItem(IcariaBlocks.DEAD_SWIRLY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> GROWING_SWIRLY_VINE = registerBasic("growing_swirly_vine", () -> new BlockItem(IcariaBlocks.GROWING_SWIRLY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> SWIRLY_VINE = registerBasic("swirly_vine", () -> new BlockItem(IcariaBlocks.SWIRLY_VINE.get(), new Properties()));

	public static final RegistryObject<Item> DEAD_THORNY_VINE = registerBasic("dead_thorny_vine", () -> new BlockItem(IcariaBlocks.DEAD_THORNY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> GROWING_THORNY_VINE = registerBasic("growing_thorny_vine", () -> new BlockItem(IcariaBlocks.GROWING_THORNY_VINE.get(), new Properties()));
	public static final RegistryObject<Item> THORNY_VINE = registerBasic("thorny_vine", () -> new BlockItem(IcariaBlocks.THORNY_VINE.get(), new Properties()));

	public static final RegistryObject<Item> FERN = registerBasic("fern", () -> new BlockItem(IcariaBlocks.FERN.get(), new Properties()));

	public static final RegistryObject<Item> SMALL_GRASS = registerBasic("small_grass", () -> new BlockItem(IcariaBlocks.SMALL_GRASS.get(), new Properties()));
	public static final RegistryObject<Item> MEDIUM_GRASS = registerBasic("medium_grass", () -> new BlockItem(IcariaBlocks.MEDIUM_GRASS.get(), new Properties()));
	public static final RegistryObject<Item> LARGE_GRASS = registerBasic("large_grass", () -> new BlockItem(IcariaBlocks.LARGE_GRASS.get(), new Properties()));

	public static final RegistryObject<Item> GRAIN_0 = registerBasic("grain_0", () -> new BlockItem(IcariaBlocks.GRAIN_0.get(), new Properties()));
	public static final RegistryObject<Item> GRAIN_1 = registerBasic("grain_1", () -> new BlockItem(IcariaBlocks.GRAIN_1.get(), new Properties()));
	public static final RegistryObject<Item> GRAIN_2 = registerBasic("grain_2", () -> new BlockItem(IcariaBlocks.GRAIN_2.get(), new Properties()));
	public static final RegistryObject<Item> GRAIN_3 = registerBasic("grain_3", () -> new BlockItem(IcariaBlocks.GRAIN_3.get(), new Properties()));
	public static final RegistryObject<Item> GRAIN_4 = registerBasic("grain_4", () -> new BlockItem(IcariaBlocks.GRAIN_4.get(), new Properties()));
	public static final RegistryObject<Item> GRAIN_5 = registerBasic("grain_5", () -> new BlockItem(IcariaBlocks.GRAIN_5.get(), new Properties()));

	public static final RegistryObject<Item> BLINDWEED = registerBasic("blindweed", () -> new BlockItem(IcariaBlocks.BLINDWEED.get(), new Properties()));
	public static final RegistryObject<Item> CHAMEOMILE = registerBasic("chameomile", () -> new BlockItem(IcariaBlocks.CHAMEOMILE.get(), new Properties()));
	public static final RegistryObject<Item> CHARMONDER = registerBasic("charmonder", () -> new BlockItem(IcariaBlocks.CHARMONDER.get(), new Properties()));
	public static final RegistryObject<Item> CLOVER = registerBasic("clover", () -> new BlockItem(IcariaBlocks.CLOVER.get(), new Properties()));
	public static final RegistryObject<Item> FIREHILT = registerBasic("firehilt", () -> new BlockItem(IcariaBlocks.FIREHILT.get(), new Properties()));
	public static final RegistryObject<Item> BLUE_HYDRACINTH = registerBasic("blue_hydracinth", () -> new BlockItem(IcariaBlocks.BLUE_HYDRACINTH.get(), new Properties()));
	public static final RegistryObject<Item> PURPLE_HYDRACINTH = registerBasic("purple_hydracinth", () -> new BlockItem(IcariaBlocks.PURPLE_HYDRACINTH.get(), new Properties()));
	public static final RegistryObject<Item> LIONFANGS = registerBasic("lionfangs", () -> new BlockItem(IcariaBlocks.LIONFANGS.get(), new Properties()));
	public static final RegistryObject<Item> SPEARDROPS = registerBasic("speardrops", () -> new BlockItem(IcariaBlocks.SPEARDROPS.get(), new Properties()));
	public static final RegistryObject<Item> PURPLE_STAGHORN = registerBasic("purple_staghorn", () -> new BlockItem(IcariaBlocks.PURPLE_STAGHORN.get(), new Properties()));
	public static final RegistryObject<Item> YELLOW_STAGHORN = registerBasic("yellow_staghorn", () -> new BlockItem(IcariaBlocks.YELLOW_STAGHORN.get(), new Properties()));
	public static final RegistryObject<Item> BLUE_STORMCOTTON = registerBasic("blue_stormcotton", () -> new BlockItem(IcariaBlocks.BLUE_STORMCOTTON.get(), new Properties()));
	public static final RegistryObject<Item> PINK_STORMCOTTON = registerBasic("pink_stormcotton", () -> new BlockItem(IcariaBlocks.PINK_STORMCOTTON.get(), new Properties()));
	public static final RegistryObject<Item> PURPLE_STORMCOTTON = registerBasic("purple_stormcotton", () -> new BlockItem(IcariaBlocks.PURPLE_STORMCOTTON.get(), new Properties()));
	public static final RegistryObject<Item> SUNKETTLE = registerBasic("sunkettle", () -> new BlockItem(IcariaBlocks.SUNKETTLE.get(), new Properties()));
	public static final RegistryObject<Item> SUNSPONGE = registerBasic("sunsponge", () -> new BlockItem(IcariaBlocks.SUNSPONGE.get(), new Properties()));
	public static final RegistryObject<Item> VOIDLILY = registerBasic("voidlily", () -> new BlockItem(IcariaBlocks.VOIDLILY.get(), new Properties()));

	public static final RegistryObject<Item> BOLBOS = registerBasic("bolbos", () -> new BlockItem(IcariaBlocks.BOLBOS.get(), new Properties()));
	public static final RegistryObject<Item> DATHULLA = registerBasic("dathulla", () -> new BlockItem(IcariaBlocks.DATHULLA.get(), new Properties()));
	public static final RegistryObject<Item> MONDANOS = registerBasic("mondanos", () -> new BlockItem(IcariaBlocks.MONDANOS.get(), new Properties()));
	public static final RegistryObject<Item> MOTH_AGARIC = registerBasic("moth_agaric", () -> new BlockItem(IcariaBlocks.MOTH_AGARIC.get(), new Properties()));
	public static final RegistryObject<Item> NAMDRAKE = registerBasic("namdrake", () -> new BlockItem(IcariaBlocks.NAMDRAKE.get(), new Properties()));
	public static final RegistryObject<Item> PSILOCYBOS = registerBasic("psilocybos", () -> new BlockItem(IcariaBlocks.PSILOCYBOS.get(), new Properties()));
	public static final RegistryObject<Item> ROWAN = registerBasic("rowan", () -> new BlockItem(IcariaBlocks.ROWAN.get(), new Properties()));

	public static final RegistryObject<Item> BLUE_GROUND_FLOWERS = register("blue_ground_flowers", () -> new BlockItem(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), new Properties()));
	public static final RegistryObject<Item> CYAN_GROUND_FLOWERS = register("cyan_ground_flowers", () -> new BlockItem(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), new Properties()));
	public static final RegistryObject<Item> PINK_GROUND_FLOWERS = register("pink_ground_flowers", () -> new BlockItem(IcariaBlocks.PINK_GROUND_FLOWERS.get(), new Properties()));
	public static final RegistryObject<Item> PURPLE_GROUND_FLOWERS = register("purple_ground_flowers", () -> new BlockItem(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), new Properties()));
	public static final RegistryObject<Item> RED_GROUND_FLOWERS = register("red_ground_flowers", () -> new BlockItem(IcariaBlocks.RED_GROUND_FLOWERS.get(), new Properties()));
	public static final RegistryObject<Item> WHITE_GROUND_FLOWERS = register("white_ground_flowers", () -> new BlockItem(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), new Properties()));

	public static final RegistryObject<Item> MOSS_0 = register("moss_0", () -> new BlockItem(IcariaBlocks.MOSS_0.get(), new Properties()));
	public static final RegistryObject<Item> MOSS_1 = register("moss_1", () -> new BlockItem(IcariaBlocks.MOSS_1.get(), new Properties()));
	public static final RegistryObject<Item> MOSS_2 = register("moss_2", () -> new BlockItem(IcariaBlocks.MOSS_2.get(), new Properties()));

	public static final RegistryObject<Item> PALM_FERN = register("palm_fern", () -> new BlockItem(IcariaBlocks.PALM_FERN.get(), new Properties()));

	public static final RegistryObject<Item> WHITE_BROMELIA = register("white_bromelia", () -> new BlockItem(IcariaBlocks.WHITE_BROMELIA.get(), new Properties()));
	public static final RegistryObject<Item> ORANGE_BROMELIA = register("orange_bromelia", () -> new BlockItem(IcariaBlocks.ORANGE_BROMELIA.get(), new Properties()));
	public static final RegistryObject<Item> PINK_BROMELIA = register("pink_bromelia", () -> new BlockItem(IcariaBlocks.PINK_BROMELIA.get(), new Properties()));
	public static final RegistryObject<Item> PURPLE_BROMELIA = register("purple_bromelia", () -> new BlockItem(IcariaBlocks.PURPLE_BROMELIA.get(), new Properties()));

	public static final RegistryObject<Item> GREEN_GROUND_SHROOMS = register("green_ground_shrooms", () -> new BlockItem(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), new Properties()));
	public static final RegistryObject<Item> BROWN_GROUND_SHROOMS = register("brown_ground_shrooms", () -> new BlockItem(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), new Properties()));
	public static final RegistryObject<Item> LARGE_BROWN_GROUND_SHROOMS = register("large_brown_ground_shrooms", () -> new BlockItem(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), new Properties()));

	public static final RegistryObject<Item> TINDER_FUNGUS_TREE_SHROOMS = register("tinder_fungus_tree_shrooms", () -> new BlockItem(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), new Properties()));
	public static final RegistryObject<Item> TURKEY_TAIL_TREE_SHROOMS = register("turkey_tail_tree_shrooms", () -> new BlockItem(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), new Properties()));
	public static final RegistryObject<Item> UNNAMED_TREE_SHROOMS = register("unnamed_tree_shrooms", () -> new BlockItem(IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), new Properties()));

	public static final RegistryObject<Item> CARDON_CACTUS = register("cardon_cactus", () -> new BlockItem(IcariaBlocks.CARDON_CACTUS.get(), new Properties()));

	public static final RegistryObject<Item> STRAWBERRY_BUSH = register("strawberry_bush", () -> new BlockItem(IcariaBlocks.STRAWBERRY_BUSH.get(), new Properties()));

	public static final RegistryObject<Item> BONE_REMAINS = registerBasic("bone_remains", () -> new Item(new Properties()));
	public static final RegistryObject<Item> LOAM_LUMP = registerBasic("loam_lump", () -> new Item(new Properties()));
	public static final RegistryObject<Item> LOAM_BRICK = registerBasic("loam_brick", () -> new Item(new Properties()));
	public static final RegistryObject<Item> CHERT = registerBasic("chert", () -> new Item(new Properties()));
	public static final RegistryObject<Item> ENDER_JELLYFISH_JELLY = registerBasic("ender_jellyfish_jelly", () -> new Item(new Properties()));
	public static final RegistryObject<Item> FIRE_JELLYFISH_JELLY = registerBasic("fire_jellyfish_jelly", () -> new Item(new Properties()));
	public static final RegistryObject<Item> NATURE_JELLYFISH_JELLY = registerBasic("nature_jellyfish_jelly", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VOID_JELLYFISH_JELLY = registerBasic("void_jellyfish_jelly", () -> new Item(new Properties()));
	public static final RegistryObject<Item> WATER_JELLYFISH_JELLY = registerBasic("water_jellyfish_jelly", () -> new Item(new Properties()));
	public static final RegistryObject<Item> ARACHNE_STRING = registerBasic("arachne_string", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SPELT = registerBasic("spelt", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VINE_REED = registerBasic("vine_reed", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VINE_SPROUT = registerBasic("vine_sprout", () -> new VineSproutItem(new Properties().durability(24).food(foodPropertiesVineSprout(0, 1.0F))));
	public static final RegistryObject<Item> ROTTEN_BONES = registerBasic("rotten_bones", () -> new Item(new Properties()));
	public static final RegistryObject<Item> CALCITE = registerBasic("calcite", () -> new Item(new Properties()));
	public static final RegistryObject<Item> HALITE = registerBasic("halite", () -> new Item(new Properties()));
	public static final RegistryObject<Item> JASPER = registerBasic("jasper", () -> new Item(new Properties()));
	public static final RegistryObject<Item> ZIRCON = registerBasic("zircon", () -> new Item(new Properties()));
	public static final RegistryObject<Item> CALCITE_DUST = registerBasic("calcite_dust", () -> new BoneMealItem(new Properties()));
	public static final RegistryObject<Item> HALITE_DUST = registerBasic("halite_dust", () -> new Item(new Properties()));
	public static final RegistryObject<Item> LIGNITE = registerBasic("lignite", () -> new FuelItem(new Properties(), 800));
	public static final RegistryObject<Item> CHALKOS_RAW = registerBasic("chalkos_raw", () -> new Item(new Properties()));
	public static final RegistryObject<Item> KASSITEROS_RAW = registerBasic("kassiteros_raw", () -> new Item(new Properties()));
	public static final RegistryObject<Item> DOLOMITE = registerBasic("dolomite", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VANADIUM_RAW = registerBasic("vanadium_raw", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SLIVER = registerBasic("sliver", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SIDEROS_RAW = registerBasic("sideros_raw", () -> new Item(new Properties()));
	public static final RegistryObject<Item> ANTHRACITE = registerBasic("anthracite", () -> new FuelItem(new Properties(), 3200));
	public static final RegistryObject<Item> MOLYBDENUM_RAW = registerBasic("molybdenum_raw", () -> new Item(new Properties()));

	public static final RegistryObject<Item> CHALKOS_NUGGET = registerBasic("chalkos_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> KASSITEROS_NUGGET = registerBasic("kassiteros_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> ORICHALCUM_NUGGET = registerBasic("orichalcum_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VANADIUM_NUGGET = registerBasic("vanadium_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VANADIUMSTEEL_NUGGET = registerBasic("vanadiumsteel_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SIDEROS_NUGGET = registerBasic("sideros_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> MOLYBDENUM_NUGGET = registerBasic("molybdenum_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> MOLYBDENUMSTEEL_NUGGET = registerBasic("molybdenumsteel_nugget", () -> new Item(new Properties()));
	public static final RegistryObject<Item> BLURIDIUM_NUGGET = registerBasic("bluridium_nugget", () -> new Item(new Properties()));

	public static final RegistryObject<Item> CHALKOS_INGOT = registerBasic("chalkos_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> KASSITEROS_INGOT = registerBasic("kassiteros_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> ORICHALCUM_INGOT = registerBasic("orichalcum_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VANADIUM_INGOT = registerBasic("vanadium_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VANADIUMSTEEL_INGOT = registerBasic("vanadiumsteel_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SIDEROS_INGOT = registerBasic("sideros_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> MOLYBDENUM_INGOT = registerBasic("molybdenum_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> MOLYBDENUMSTEEL_INGOT = registerBasic("molybdenumsteel_ingot", () -> new Item(new Properties()));
	public static final RegistryObject<Item> BLURIDIUM_INGOT = registerBasic("bluridium_ingot", () -> new Item(new Properties()));

	public static final ToolSet CHERT_TOOLS = new ToolSet(IcariaTiers.CHERT);
	public static final ToolSet CHALKOS_TOOLS = new ToolSet(IcariaTiers.CHALKOS);
	public static final ToolSet KASSITEROS_TOOLS = new ToolSet(IcariaTiers.KASSITEROS);
	public static final ToolSet ORICHALCUM_TOOLS = new ToolSet(IcariaTiers.ORICHALCUM);
	public static final ToolSet VANADIUMSTEEL_TOOLS = new ToolSet(IcariaTiers.VANADIUMSTEEL);
	public static final ToolSet SIDEROS_TOOLS = new ToolSet(IcariaTiers.SIDEROS);
	public static final ToolSet MOLYBDENUMSTEEL_TOOLS = new ToolSet(IcariaTiers.MOLYBDENUMSTEEL);

	public static final ArmorSet AETERNAE_HIDE_ARMOR = new ArmorSet(IcariaArmorMaterials.AETERNAE_HIDE);
	public static final ArmorSet CHALKOS_ARMOR = new ArmorSet(IcariaArmorMaterials.CHALKOS);
	public static final ArmorSet KASSITEROS_ARMOR = new ArmorSet(IcariaArmorMaterials.KASSITEROS);
	public static final RegistryObject<Item> ORICHALCUM_HELMET = registerBasic("orichalcum_helmet", () -> new OrichalcumHelmetItem(IcariaArmorMaterials.ORICHALCUM, EquipmentSlot.HEAD, new Properties()));
	public static final RegistryObject<Item> ORICHALCUM_CHESTPLATE = registerBasic("orichalcum_chestplate", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, EquipmentSlot.CHEST, new Properties()));
	public static final RegistryObject<Item> ORICHALCUM_LEGGINGS = registerBasic("orichalcum_leggings", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, EquipmentSlot.LEGS, new Properties()));
	public static final RegistryObject<Item> ORICHALCUM_BOOTS = registerBasic("orichalcum_boots", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, EquipmentSlot.FEET, new Properties()));
	public static final ArmorSet VANADIUMSTEEL_ARMOR = new ArmorSet(IcariaArmorMaterials.VANADIUMSTEEL);
	public static final RegistryObject<Item> LAUREL_WREATH = registerBasic("laurel_wreath", () -> new ArmorItem(IcariaArmorMaterials.LAUREL, EquipmentSlot.HEAD, new Properties()));

	public static final RegistryObject<Item> GREEK_FIRE_GRENADE = registerBasic("greek_fire_grenade", () -> new GreekFireGrenadeItem(new Properties().stacksTo(1)));

	public static final RegistryObject<TotemItem> TOTEM_OF_PREVENTATION = registerBasic("totem_of_preventation", () -> new TotemItem(new Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_STUFFING = registerBasic("totem_of_stuffing", () -> new TotemItem(new Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNBLINDING = registerBasic("totem_of_unblinding", () -> new TotemItem(new Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNDROWNING = registerBasic("totem_of_undrowning", () -> new TotemItem(new Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNDYING = registerBasic("totem_of_undying", () -> new TotemItem(new Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNSHATTERING = registerBasic("totem_of_unshattering", () -> new TotemItem(new Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNSINKING = registerBasic("totem_of_unsinking", () -> new TotemItem(new Properties().durability(4)));

	public static final RegistryObject<Item> UNFIRED_STORAGE_VASE = registerBasic("unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> WHITE_UNFIRED_STORAGE_VASE = registerBasic("white_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> LIGHT_GRAY_UNFIRED_STORAGE_VASE = registerBasic("light_gray_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GRAY_UNFIRED_STORAGE_VASE = registerBasic("gray_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> BLACK_UNFIRED_STORAGE_VASE = registerBasic("black_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> BROWN_UNFIRED_STORAGE_VASE = registerBasic("brown_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> RED_UNFIRED_STORAGE_VASE = registerBasic("red_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> ORANGE_UNFIRED_STORAGE_VASE = registerBasic("orange_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> YELLOW_UNFIRED_STORAGE_VASE = registerBasic("yellow_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> LIME_UNFIRED_STORAGE_VASE = registerBasic("lime_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GREEN_UNFIRED_STORAGE_VASE = registerBasic("green_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> CYAN_UNFIRED_STORAGE_VASE = registerBasic("cyan_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> LIGHT_BLUE_UNFIRED_STORAGE_VASE = registerBasic("light_blue_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> BLUE_UNFIRED_STORAGE_VASE = registerBasic("blue_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> PURPLE_UNFIRED_STORAGE_VASE = registerBasic("purple_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> MAGENTA_UNFIRED_STORAGE_VASE = registerBasic("magenta_unfired_storage_vase", () -> new Item(new Properties()));
	public static final RegistryObject<Item> PINK_UNFIRED_STORAGE_VASE = registerBasic("pink_unfired_storage_vase", () -> new Item(new Properties()));

	public static final RegistryObject<Item> FLASK_EMPTY = registerBasic("flask_empty", () -> new Item(new Properties()));

	public static final RegistryObject<Item> VIAL_EMPTY = registerBasic("vial_empty", () -> new Item(new Properties()));
	public static final RegistryObject<Item> VIAL_HYLIASTRUM = registerBasic("vial_hyliastrum", () -> new HyliastrumVialItem(new Properties()));

	public static final RegistryObject<Item> GEAR_YELLOWSTONE = registerBasic("gear_yellowstone", () -> new GearItem(new Properties().durability(256)));
	public static final RegistryObject<Item> GEAR_YELLOWSTONE_SMALL = registerBasic("gear_yellowstone_small", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEAR_LOAM_UNFIRED = registerBasic("gear_loam_unfired", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEAR_LOAM = registerBasic("gear_loam", () -> new GearItem(new Properties().durability(512)));
	public static final RegistryObject<Item> GEAR_LOAM_SMALL = registerBasic("gear_loam_small", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEAR_VOIDSHALE = registerBasic("gear_voidshale", () -> new GearItem(new Properties().durability(768)));
	public static final RegistryObject<Item> GEAR_VOIDSHALE_SMALL = registerBasic("gear_voidshale_small", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEAR_VANADIUM = registerBasic("gear_vanadium", () -> new GearItem(new Properties().durability(1024)));
	public static final RegistryObject<Item> GEAR_VANADIUM_SMALL = registerBasic("gear_vanadium_small", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEARFRAGMENT_BLUE = registerBasic("gearfragment_blue", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEARFRAGMENT_GREEN = registerBasic("gearfragment_green", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEARFRAGMENT_YELLOW = registerBasic("gearfragment_yellow", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEAR_DAEDALIAN = registerBasic("gear_daedalian", () -> new Item(new Properties()));
	public static final RegistryObject<Item> GEAR_DAEDALIAN_SMALL = registerBasic("gear_daedalian_small", () -> new Item(new Properties()));

	public static final RegistryObject<Item> AETERNAE_HIDE = registerBasic("aeternae_hide", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SPELT_FLOUR = registerBasic("spelt_flour", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SPELT_BREAD = registerBasic("spelt_bread", () -> new Item(new Properties().food(foodProperties(5, 0.6F))));
	public static final RegistryObject<Item> VINEBERRIES = registerBasic("vineberries", () -> new Item(new Properties().food(foodProperties(2, 0.0F))));
	public static final RegistryObject<Item> STRAWBERRIES = registerBasic("strawberries", () -> new Item(new Properties().food(foodProperties(1, 0.3F))));
	public static final RegistryObject<Item> PHYSALIS = registerBasic("physalis", () -> new Item(new Properties().food(foodProperties(2, 0.5F))));
	public static final RegistryObject<Item> LAUREL_CHERRY = registerBasic("laurel_cherry", () -> new Item(new Properties().food(foodProperties(4, 0.3F))));
	public static final RegistryObject<Item> OLIVES_BLACK = registerBasic("olives_black", () -> new Item(new Properties().food(foodProperties(2, 0.3F))));
	public static final RegistryObject<Item> OLIVES_GREEN = registerBasic("olives_green", () -> new Item(new Properties().food(foodProperties(2, 0.3F))));
	public static final RegistryObject<Item> GARLIC = registerBasic("garlic", () -> new Item(new Properties().food(foodProperties(1, 0.3F))));
	public static final RegistryObject<Item> ONION = registerBasic("onion", () -> new ItemNameBlockItem(IcariaBlocks.ONION_CROP.get(), new Properties().food(foodProperties(1, 0.3F))));
	public static final RegistryObject<Item> RAW_AETERNAE_MEAT = registerBasic("raw_aeternae_meat", () -> new Item(new Properties().food(foodPropertiesMeatEffect(3, 0.3F, MobEffects.HUNGER, 100, 0, 1.0F))));
	public static final RegistryObject<Item> COOKED_AETERNAE_MEAT = registerBasic("cooked_aeternae_meat", () -> new Item(new Properties().food(foodPropertiesMeat(8, 0.8F))));
	public static final RegistryObject<Item> RAW_CATOBLEPAS_MEAT = registerBasic("raw_catoblepas_meat", () -> new Item(new Properties().food(foodPropertiesMeat(2, 0.3F))));
	public static final RegistryObject<Item> COOKED_CATOBLEPAS_MEAT = registerBasic("cooked_catoblepas_meat", () -> new Item(new Properties().food(foodPropertiesMeat(6, 0.8F))));
	public static final RegistryObject<Item> RAW_CERVER_MEAT = registerBasic("raw_cerver_meat", () -> new Item(new Properties().food(foodPropertiesMeatEffect(2, 0.3F, MobEffects.WEAKNESS, 800, 0, 0.4F))));
	public static final RegistryObject<Item> COOKED_CERVER_MEAT = registerBasic("cooked_cerver_meat", () -> new Item(new Properties().food(foodPropertiesMeat(5, 0.8F))));
	public static final RegistryObject<Item> RAW_SOW_MEAT = registerBasic("raw_sow_meat", () -> new Item(new Properties().food(foodPropertiesMeatEffect(2, 0.3F, MobEffects.HUNGER, 400, 0, 1.0F))));
	public static final RegistryObject<Item> COOKED_SOW_MEAT = registerBasic("cooked_sow_meat", () -> new Item(new Properties().food(foodPropertiesMeat(5, 0.8F))));
	public static final RegistryObject<Item> SNULL_CREAM = registerBasic("snull_cream", () -> new Item(new Properties().food(foodPropertiesSnullCream(3, 0.1F, MobEffects.HUNGER, 100, 0, 0.5F, MobEffects.CONFUSION, 200, 0, 0.5F))));

	public static final RegistryObject<Item> LOAM_BOWL_UNFIRED = registerBasic("loam_bowl_unfired", () -> new Item(new Properties()));
	public static final RegistryObject<Item> LOAM_BOWL = registerBasic("loam_bowl", () -> new Item(new Properties()));
	public static final RegistryObject<Item> SALAD_FRUIT = registerBasic("salad_fruit", () -> new IcariaBowlFoodItem(new Properties().stacksTo(1).food(foodPropertiesEffect(7, 1.2F, MobEffects.HEAL, 1 ,0 ,1.0F))));
	public static final RegistryObject<Item> SOUP_ONION = registerBasic("soup_onion", () -> new IcariaBowlFoodItem(new Properties().stacksTo(1).food(foodProperties(4, 1.0F))));
	public static final RegistryObject<Item> STEW_AETERNAE = registerBasic("stew_aeternae", () -> new IcariaBowlFoodItem(new Properties().stacksTo(1).food(foodPropertiesMeat(9, 1.0F))));
	public static final RegistryObject<Item> STEW_CATOBLEPAS = registerBasic("stew_catoblepas", () -> new IcariaBowlFoodItem(new Properties().stacksTo(1).food(foodPropertiesMeat(8, 1.0F))));
	public static final RegistryObject<Item> STEW_CERVER = registerBasic("stew_cerver", () -> new IcariaBowlFoodItem(new Properties().stacksTo(1).food(foodPropertiesMeat(9, 1.0F))));
	public static final RegistryObject<Item> STEW_SOW = registerBasic("stew_sow", () -> new IcariaBowlFoodItem(new Properties().stacksTo(1).food(foodPropertiesMeat(8, 1.0F))));

	public static final RegistryObject<Item> SPELT_SEEDS = registerBasic("spelt_seeds", () -> new ItemNameBlockItem(IcariaBlocks.SPELT_CROP.get(), new Properties()));
	public static final RegistryObject<Item> STRAWBERRY_SEEDS = registerBasic("strawberry_seeds", () -> new ItemNameBlockItem(IcariaBlocks.STRAWBERRY_CROP.get(), new Properties()));
	public static final RegistryObject<Item> PHYSALIS_SEEDS = registerBasic("physalis_seeds", () -> new ItemNameBlockItem(IcariaBlocks.PHYSALIS_CROP.get(), new Properties()));

	public static final RegistryObject<Item> AETERNAE_SPAWN_EGG = register("aeternae_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.AETERNAE, 0x40280B, 0x88581F, new Properties()));
	public static final RegistryObject<Item> ARACHNE_SPAWN_EGG = register("arachne_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.ARACHNE, 0x362E28, 0x6A8C97, new Properties()));
	public static final RegistryObject<Item> ARACHNE_DRONE_SPAWN_EGG = register("arachne_drone_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.ARACHNE_DRONE, 0x382F28, 0x6A8C97, new Properties()));
	public static final RegistryObject<Item> ARGAN_HOUND_SPAWN_EGG = register("argan_hound_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.ARGAN_HOUND, 0x0B0D0E, 0x2C2F36, new Properties()));
	public static final RegistryObject<Item> CATOBLEPAS_SPAWN_EGG = register("catoblepas_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CATOBLEPAS, 0x1D170E, 0x373024, new Properties()));
	public static final RegistryObject<Item> CERVER_SPAWN_EGG = register("cerver_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CERVER, 0x0E0A05, 0x302C26, new Properties()));
	public static final RegistryObject<Item> HYLIASTER_SPAWN_EGG = register("hyliaster_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.HYLIASTER, 0x040706, 0x8B9590, new Properties()));
	public static final RegistryObject<Item> MYRMEKE_DRONE_SPAWN_EGG = register("myrmeke_drone_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.MYRMEKE_DRONE, 0x501814, 0x241E19, new Properties()));
	public static final RegistryObject<Item> MYRMEKE_SOLDIER_SPAWN_EGG = register("myrmeke_soldier_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.MYRMEKE_SOLDIER, 0x501814, 0x402816, new Properties()));
	public static final RegistryObject<Item> MYRMEKE_QUEEN_SPAWN_EGG = register("myrmeke_queen_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.MYRMEKE_QUEEN, 0x501814, 0xAB7E17, new Properties()));
	public static final RegistryObject<Item> SOW_SPAWN_EGG = register("sow_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.SOW, 0x231A13, 0x6E554B, new Properties()));

	public static final RegistryObject<Item> MEDITERRANEAN_WATER_BUCKET = registerBasic("mediterranean_water_bucket", () -> new BucketItem(IcariaFluids.MEDITERRANEAN_WATER_SOURCE, new Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static FoodProperties foodPropertiesVineSprout(int pNutrition, float pSaturation) {
		return new Builder().nutrition(pNutrition).saturationMod(pSaturation).alwaysEat().build();
	}

	public static FoodProperties foodPropertiesEffect(int pNutrition, float pSaturation, MobEffect pEffect, int pDuration, int pAmplifier, float pProbability) {
		return new Builder().nutrition(pNutrition).saturationMod(pSaturation).effect(() -> new MobEffectInstance(pEffect, pDuration, pAmplifier), pProbability).build();
	}

	public static FoodProperties foodProperties(int pNutrition, float pSaturation) {
		return new Builder().nutrition(pNutrition).saturationMod(pSaturation).build();
	}

	public static FoodProperties foodPropertiesMeatEffect(int pNutrition, float pSaturation, MobEffect pEffect, int pDuration, int pAmplifier, float pProbability) {
		return new Builder().nutrition(pNutrition).saturationMod(pSaturation).effect(() -> new MobEffectInstance(pEffect, pDuration, pAmplifier), pProbability).meat().build();
	}

	public static FoodProperties foodPropertiesMeat(int pNutrition, float pSaturation) {
		return new Builder().nutrition(pNutrition).saturationMod(pSaturation).meat().build();
	}

	public static FoodProperties foodPropertiesSnullCream(int pNutrition, float pSaturation, MobEffect pEffectOne, int pDurationOne, int pAmplifierOne, float pProbabilityOne, MobEffect pEffectTwo, int pDurationTwo,int pAmplifierTwo, float pProbabilityTwo) {
		return new Builder().nutrition(pNutrition).saturationMod(pSaturation).effect(() -> new MobEffectInstance(pEffectOne, pDurationOne, pAmplifierOne), pProbabilityOne).effect(() -> new MobEffectInstance(pEffectTwo, pDurationTwo, pAmplifierTwo), pProbabilityTwo).build();
	}

	public static <T extends Item> RegistryObject<T> register(String pName, Supplier<T> pSupplier) {
		return ITEMS.register(pName, pSupplier);
	}

	public static <T extends Item> RegistryObject<T> registerBasic(String pName, Supplier<T> pSupplier) {
		RegistryObject<T> registryObject = register(pName, pSupplier);
		BASIC_ITEMS.add(registryObject);
		return registryObject;
	}

	public static class StoneDecoItemBlocks {
		public IcariaBlocks.StoneDecoBlocks block;

		public RegistryObject<Item> item;
		public RegistryObject<Item> stairs;
		public RegistryObject<Item> slab;
		public RegistryObject<Item> wall;

		public StoneDecoItemBlocks(IcariaBlocks.StoneDecoBlocks pBlock, RegistryObject<Item> pItem) {
			this.block = pBlock;
			this.item = pItem;
			this.stairs = register(pBlock.name + "_stairs", () -> new BlockItem(pBlock.stairs.get(), new Properties()));
			this.slab = register(pBlock.name + "_slab", () -> new BlockItem(pBlock.slab.get(), new Properties()));
			this.wall = register(pBlock.name + "_wall", () -> new BlockItem(pBlock.wall.get(), new Properties()));
			STONE_DECO.add(this);
		}
	}

	public static class WoodDecoItemBlocks {
		public IcariaBlocks.WoodDecoBlocks block;

		public RegistryObject<Item> item;
		public RegistryObject<Item> stairs;
		public RegistryObject<Item> slab;
		public RegistryObject<Item> fence;
		public RegistryObject<Item> gate;

		public WoodDecoItemBlocks(IcariaBlocks.WoodDecoBlocks pBlock, RegistryObject<Item> pItem) {
			this.block = pBlock;
			this.item = pItem;
			this.stairs = register(pBlock.name + "_stairs", () -> new BlockItem(pBlock.stairs.get(), new Properties()));
			this.slab = register(pBlock.name + "_slab", () -> new BlockItem(pBlock.slab.get(), new Properties()));
			this.fence = register(pBlock.name + "_fence", () -> new FuelBlockItem(pBlock.fence.get(), new Properties(), 300));
			this.gate = register(pBlock.name + "_fence_gate", () -> new FuelBlockItem(pBlock.gate.get(), new Properties(), 300));
			WOOD_DECO.add(this);
		}
	}

	public static class ToolSet {
		public IcariaTier tier;

		public RegistryObject<Item> sword;
		public RegistryObject<Item> dagger;
		public RegistryObject<Item> shovel;
		public RegistryObject<Item> pickaxe;
		public RegistryObject<Item> axe;
		public RegistryObject<Item> scythe;
		public RegistryObject<Item> bident;

		public ToolSet(IcariaTier pTier) {
			this.tier = pTier;
			String name = Objects.requireNonNull(TierSortingRegistry.getName(pTier)).getPath();
			this.sword = register(name + "_sword", () -> new SwordItem(pTier, 3, -2.4F, new Properties()));
			this.dagger = register(name + "_dagger", () -> new DaggerItem(pTier, 2, -1.0F, new Properties()));
			this.shovel = register(name + "_shovel", () -> new IcariaShovelItem(pTier, 1.5F, -3.0F, new Properties()));
			this.pickaxe = register(name + "_pickaxe", () -> new IcariaPickaxeItem(pTier, 1, -2.8F, new Properties()));
			this.axe = register(name + "_axe", () -> new IcariaAxeItem(pTier, 6, -3.0F, new Properties()));
			this.scythe = register(name + "_scythe", () -> new ScytheItem(pTier, 4, -2.8F, new Properties()));
			this.bident = register(name + "_bident", () -> new BidentItem(pTier, new Properties()));
			TOOLS.add(this);
		}
	}

	public static class ArmorSet {
		public RegistryObject<Item> helmet;
		public RegistryObject<Item> chestplate;
		public RegistryObject<Item> leggings;
		public RegistryObject<Item> boots;

		public ArmorSet(IcariaArmorMaterials pMaterial) {
			String name = pMaterial.name;
			this.helmet = register(name + "_helmet", () -> new ArmorItem(pMaterial, EquipmentSlot.HEAD, (new Properties())));
			this.chestplate = register(name + "_chestplate", () -> new ArmorItem(pMaterial, EquipmentSlot.CHEST, (new Properties())));
			this.leggings = register(name + "_leggings", () -> new ArmorItem(pMaterial, EquipmentSlot.LEGS, (new Properties())));
			this.boots = register(name + "_boots", () -> new ArmorItem(pMaterial, EquipmentSlot.FEET, (new Properties())));
			ARMOR.add(this);
		}
	}
}
