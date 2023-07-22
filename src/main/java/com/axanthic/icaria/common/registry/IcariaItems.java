package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.item.*;
import com.axanthic.icaria.common.util.IcariaArmorMaterials;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault

public class IcariaItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaInfo.ID);

	public static final List<RegistryObject<? extends Item>> SIMPLE_ITEMS = new ArrayList<>();

	public static final RegistryObject<Item> GRASSY_MARL = IcariaItems.register("grassy_marl", () -> new BlockItem(IcariaBlocks.GRASSY_MARL.get(), new Item.Properties()));
	public static final RegistryObject<Item> MARL = IcariaItems.register("marl", () -> new BlockItem(IcariaBlocks.MARL.get(), new Item.Properties()));
	public static final RegistryObject<Item> MARL_CHERT = IcariaItems.register("marl_chert", () -> new BlockItem(IcariaBlocks.MARL_CHERT.get(), new Item.Properties()));
	public static final RegistryObject<Item> SURFACE_CHERT = IcariaItems.register("surface_chert", () -> new BlockItem(IcariaBlocks.SURFACE_CHERT.get(), new Item.Properties()));
	public static final RegistryObject<Item> MARL_BONES = IcariaItems.register("marl_bones", () -> new BlockItem(IcariaBlocks.MARL_BONES.get(), new Item.Properties()));
	public static final RegistryObject<Item> SURFACE_BONES = IcariaItems.register("surface_bones", () -> new BlockItem(IcariaBlocks.SURFACE_BONES.get(), new Item.Properties()));
	public static final RegistryObject<Item> MARL_LIGNITE = IcariaItems.register("marl_lignite", () -> new BlockItem(IcariaBlocks.MARL_LIGNITE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SURFACE_LIGNITE = IcariaItems.register("surface_lignite", () -> new BlockItem(IcariaBlocks.SURFACE_LIGNITE.get(), new Item.Properties()));
	public static final RegistryObject<Item> COARSE_MARL = IcariaItems.register("coarse_marl", () -> new BlockItem(IcariaBlocks.COARSE_MARL.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRY_LAKE_BED = IcariaItems.register("dry_lake_bed", () -> new BlockItem(IcariaBlocks.DRY_LAKE_BED.get(), new Item.Properties()));

	public static final RegistryObject<Item> FARMLAND = IcariaItems.register("farmland", () -> new BlockItem(IcariaBlocks.FARMLAND.get(), new Item.Properties()));
	public static final RegistryObject<Item> FERTILIZED_FARMLAND = IcariaItems.register("fertilized_farmland", () -> new BlockItem(IcariaBlocks.FERTILIZED_FARMLAND.get(), new Item.Properties()));

	public static final RegistryObject<Item> MARL_ADOBE = IcariaItems.register("marl_adobe", () -> new BlockItem(IcariaBlocks.MARL_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems MARL_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.MARL_ADOBE_DECO, IcariaItems.MARL_ADOBE);

	public static final RegistryObject<Item> LOAM = IcariaItems.register("loam", () -> new BlockItem(IcariaBlocks.LOAM.get(), new Item.Properties()));
	public static final RegistryObject<Item> LOAM_BRICKS = IcariaItems.register("loam_bricks", () -> new BlockItem(IcariaBlocks.LOAM_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems LOAM_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.LOAM_BRICK_DECO, IcariaItems.LOAM_BRICKS);

	public static final RegistryObject<Item> DOLOMITE_ADOBE = IcariaItems.register("dolomite_adobe", () -> new BlockItem(IcariaBlocks.DOLOMITE_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems DOLOMITE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.DOLOMITE_ADOBE_DECO, IcariaItems.DOLOMITE_ADOBE);
	public static final RegistryObject<Item> SMOOTH_DOLOMITE = IcariaItems.register("smooth_dolomite", () -> new BlockItem(IcariaBlocks.SMOOTH_DOLOMITE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SMOOTH_DOLOMITE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SMOOTH_DOLOMITE_DECO, IcariaItems.SMOOTH_DOLOMITE);
	public static final RegistryObject<Item> DOLOMITE_BRICKS = IcariaItems.register("dolomite_bricks", () -> new BlockItem(IcariaBlocks.DOLOMITE_BRICKS.get(), new Item.Properties()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR = IcariaItems.register("dolomite_pillar", () -> new BlockItem(IcariaBlocks.DOLOMITE_PILLAR.get(), new Item.Properties()));
	public static final RegistryObject<Item> DOLOMITE_PILLAR_HEAD = IcariaItems.register("dolomite_pillar_head", () -> new BlockItem(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), new Item.Properties()));

	public static final RegistryObject<Item> GRAINEL = IcariaItems.register("grainel", () -> new BlockItem(IcariaBlocks.GRAINEL.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRAINEL_CHERT = IcariaItems.register("grainel_chert", () -> new BlockItem(IcariaBlocks.GRAINEL_CHERT.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRAINGLASS = IcariaItems.register("grainglass", () -> new BlockItem(IcariaBlocks.GRAINGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRAINGLASS_PANE = IcariaItems.register("grainglass_pane", () -> new BlockItem(IcariaBlocks.GRAINGLASS_PANE.get(), new Item.Properties()));
	public static final RegistryObject<Item> HORIZONTAL_GRAINGLASS_PANE = IcariaItems.register("horizontal_grainglass_pane", () -> new BlockItem(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRAINITE_ADOBE = IcariaItems.register("grainite_adobe", () -> new BlockItem(IcariaBlocks.GRAINITE_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems GRAINITE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.GRAINITE_ADOBE_DECO, IcariaItems.GRAINITE_ADOBE);
	public static final RegistryObject<Item> GRAINITE = IcariaItems.register("grainite", () -> new BlockItem(IcariaBlocks.GRAINITE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems GRAINITE_DECO = new IcariaStoneDecoItems(IcariaBlocks.GRAINITE_DECO, IcariaItems.GRAINITE);
	public static final RegistryObject<Item> GRAINITE_BRICKS = IcariaItems.register("grainite_bricks", () -> new BlockItem(IcariaBlocks.GRAINITE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems GRAINITE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.GRAINITE_BRICK_DECO, IcariaItems.GRAINITE_BRICKS);
	public static final RegistryObject<Item> CHISELED_GRAINITE = IcariaItems.register("chiseled_grainite", () -> new BlockItem(IcariaBlocks.CHISELED_GRAINITE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRAINITE_RUBBLE = IcariaItems.register("grainite_rubble", () -> new BlockItem(IcariaBlocks.GRAINITE_RUBBLE.get(), new Item.Properties()));

	public static final RegistryObject<Item> YELLOWSTONE_ADOBE = IcariaItems.register("yellowstone_adobe", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems YELLOWSTONE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.YELLOWSTONE_ADOBE_DECO, IcariaItems.YELLOWSTONE_ADOBE);
	public static final RegistryObject<Item> COBBLED_YELLOWSTONE = IcariaItems.register("cobbled_yellowstone", () -> new BlockItem(IcariaBlocks.COBBLED_YELLOWSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems COBBLED_YELLOWSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_YELLOWSTONE_DECO, IcariaItems.COBBLED_YELLOWSTONE);
	public static final RegistryObject<Item> YELLOWSTONE = IcariaItems.register("yellowstone", () -> new BlockItem(IcariaBlocks.YELLOWSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems YELLOWSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.YELLOWSTONE_DECO, IcariaItems.YELLOWSTONE);
	public static final RegistryObject<Item> YELLOWSTONE_BRICKS = IcariaItems.register("yellowstone_bricks", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems YELLOWSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.YELLOWSTONE_BRICK_DECO, IcariaItems.YELLOWSTONE_BRICKS);
	public static final RegistryObject<Item> CHISELED_YELLOWSTONE = IcariaItems.register("chiseled_yellowstone", () -> new BlockItem(IcariaBlocks.CHISELED_YELLOWSTONE.get(), new Item.Properties()));
	public static final RegistryObject<Item> YELLOWSTONE_RUBBLE = IcariaItems.register("yellowstone_rubble", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), new Item.Properties()));

	public static final RegistryObject<Item> SILKSAND = IcariaItems.register("silksand", () -> new BlockItem(IcariaBlocks.SILKSAND.get(), new Item.Properties()));
	public static final RegistryObject<Item> SILKGLASS = IcariaItems.register("silkglass", () -> new BlockItem(IcariaBlocks.SILKGLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> SILKGLASS_PANE = IcariaItems.register("silkglass_pane", () -> new BlockItem(IcariaBlocks.SILKGLASS_PANE.get(), new Item.Properties()));
	public static final RegistryObject<Item> HORIZONTAL_SILKGLASS_PANE = IcariaItems.register("horizontal_silkglass_pane", () -> new BlockItem(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SILKSTONE_ADOBE = IcariaItems.register("silkstone_adobe", () -> new BlockItem(IcariaBlocks.SILKSTONE_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SILKSTONE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SILKSTONE_ADOBE_DECO, IcariaItems.SILKSTONE_ADOBE);
	public static final RegistryObject<Item> COBBLED_SILKSTONE = IcariaItems.register("cobbled_silkstone", () -> new BlockItem(IcariaBlocks.COBBLED_SILKSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems COBBLED_SILKSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_SILKSTONE_DECO, IcariaItems.COBBLED_SILKSTONE);
	public static final RegistryObject<Item> SILKSTONE = IcariaItems.register("silkstone", () -> new BlockItem(IcariaBlocks.SILKSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SILKSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SILKSTONE_DECO, IcariaItems.SILKSTONE);
	public static final RegistryObject<Item> SILKSTONE_BRICKS = IcariaItems.register("silkstone_bricks", () -> new BlockItem(IcariaBlocks.SILKSTONE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SILKSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.SILKSTONE_BRICK_DECO, IcariaItems.SILKSTONE_BRICKS);
	public static final RegistryObject<Item> CHISELED_SILKSTONE = IcariaItems.register("chiseled_silkstone", () -> new BlockItem(IcariaBlocks.CHISELED_SILKSTONE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SILKSTONE_RUBBLE = IcariaItems.register("silkstone_rubble", () -> new BlockItem(IcariaBlocks.SILKSTONE_RUBBLE.get(), new Item.Properties()));

	public static final RegistryObject<Item> SUNSTONE_ADOBE = IcariaItems.register("sunstone_adobe", () -> new BlockItem(IcariaBlocks.SUNSTONE_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SUNSTONE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SUNSTONE_ADOBE_DECO, IcariaItems.SUNSTONE_ADOBE);
	public static final RegistryObject<Item> COBBLED_SUNSTONE = IcariaItems.register("cobbled_sunstone", () -> new BlockItem(IcariaBlocks.COBBLED_SUNSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems COBBLED_SUNSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_SUNSTONE_DECO, IcariaItems.COBBLED_SUNSTONE);
	public static final RegistryObject<Item> SUNSTONE = IcariaItems.register("sunstone", () -> new BlockItem(IcariaBlocks.SUNSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SUNSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SUNSTONE_DECO, IcariaItems.SUNSTONE);
	public static final RegistryObject<Item> SUNSTONE_BRICKS = IcariaItems.register("sunstone_bricks", () -> new BlockItem(IcariaBlocks.SUNSTONE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SUNSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.SUNSTONE_BRICK_DECO, IcariaItems.SUNSTONE_BRICKS);
	public static final RegistryObject<Item> CHISELED_SUNSTONE = IcariaItems.register("chiseled_sunstone", () -> new BlockItem(IcariaBlocks.CHISELED_SUNSTONE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUNSTONE_RUBBLE = IcariaItems.register("sunstone_rubble", () -> new BlockItem(IcariaBlocks.SUNSTONE_RUBBLE.get(), new Item.Properties()));

	public static final RegistryObject<Item> VOIDSHALE_ADOBE = IcariaItems.register("voidshale_adobe", () -> new BlockItem(IcariaBlocks.VOIDSHALE_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems VOIDSHALE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.VOIDSHALE_ADOBE_DECO, IcariaItems.VOIDSHALE_ADOBE);
	public static final RegistryObject<Item> COBBLED_VOIDSHALE = IcariaItems.register("cobbled_voidshale", () -> new BlockItem(IcariaBlocks.COBBLED_VOIDSHALE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems COBBLED_VOIDSHALE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_VOIDSHALE_DECO, IcariaItems.COBBLED_VOIDSHALE);
	public static final RegistryObject<Item> VOIDSHALE = IcariaItems.register("voidshale", () -> new BlockItem(IcariaBlocks.VOIDSHALE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems VOIDSHALE_DECO = new IcariaStoneDecoItems(IcariaBlocks.VOIDSHALE_DECO, IcariaItems.VOIDSHALE);
	public static final RegistryObject<Item> VOIDSHALE_BRICKS = IcariaItems.register("voidshale_bricks", () -> new BlockItem(IcariaBlocks.VOIDSHALE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems VOIDSHALE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.VOIDSHALE_BRICK_DECO, IcariaItems.VOIDSHALE_BRICKS);
	public static final RegistryObject<Item> CHISELED_VOIDSHALE = IcariaItems.register("chiseled_voidshale", () -> new BlockItem(IcariaBlocks.CHISELED_VOIDSHALE.get(), new Item.Properties()));
	public static final RegistryObject<Item> VOIDSHALE_RUBBLE = IcariaItems.register("voidshale_rubble", () -> new BlockItem(IcariaBlocks.VOIDSHALE_RUBBLE.get(), new Item.Properties()));

	public static final RegistryObject<Item> BAETYL_ADOBE = IcariaItems.register("baetyl_adobe", () -> new BlockItem(IcariaBlocks.BAETYL_ADOBE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems BAETYL_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.BAETYL_ADOBE_DECO, IcariaItems.BAETYL_ADOBE);
	public static final RegistryObject<Item> COBBLED_BAETYL = IcariaItems.register("cobbled_baetyl", () -> new BlockItem(IcariaBlocks.COBBLED_BAETYL.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems COBBLED_BAETYL_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_BAETYL_DECO, IcariaItems.COBBLED_BAETYL);
	public static final RegistryObject<Item> BAETYL = IcariaItems.register("baetyl", () -> new BlockItem(IcariaBlocks.BAETYL.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems BAETYL_DECO = new IcariaStoneDecoItems(IcariaBlocks.BAETYL_DECO, IcariaItems.BAETYL);
	public static final RegistryObject<Item> BAETYL_BRICKS = IcariaItems.register("baetyl_bricks", () -> new BlockItem(IcariaBlocks.BAETYL_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems BAETYL_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.BAETYL_BRICK_DECO, IcariaItems.BAETYL_BRICKS);
	public static final RegistryObject<Item> CHISELED_BAETYL = IcariaItems.register("chiseled_baetyl", () -> new BlockItem(IcariaBlocks.CHISELED_BAETYL.get(), new Item.Properties()));
	public static final RegistryObject<Item> BAETYL_RUBBLE = IcariaItems.register("baetyl_rubble", () -> new BlockItem(IcariaBlocks.BAETYL_RUBBLE.get(), new Item.Properties()));

	public static final RegistryObject<Item> RELICSTONE = IcariaItems.register("relicstone", () -> new BlockItem(IcariaBlocks.RELICSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems RELICSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.RELICSTONE_DECO, IcariaItems.RELICSTONE);
	public static final RegistryObject<Item> SMOOTH_RELICSTONE = IcariaItems.register("smooth_relicstone", () -> new BlockItem(IcariaBlocks.SMOOTH_RELICSTONE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems SMOOTH_RELICSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SMOOTH_RELICSTONE_DECO, IcariaItems.SMOOTH_RELICSTONE);
	public static final RegistryObject<Item> RELICSTONE_BRICKS = IcariaItems.register("relicstone_bricks", () -> new BlockItem(IcariaBlocks.RELICSTONE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems RELICSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.RELICSTONE_BRICK_DECO, IcariaItems.RELICSTONE_BRICKS);
	public static final RegistryObject<Item> CRACKED_RELICSTONE_BRICKS = IcariaItems.register("cracked_relicstone_bricks", () -> new BlockItem(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems CRACKED_RELICSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO, IcariaItems.CRACKED_RELICSTONE_BRICKS);
	public static final RegistryObject<Item> MOSSY_RELICSTONE_BRICKS = IcariaItems.register("mossy_relicstone_bricks", () -> new BlockItem(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems MOSSY_RELICSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO, IcariaItems.MOSSY_RELICSTONE_BRICKS);
	public static final RegistryObject<Item> RELICSTONE_TILES = IcariaItems.register("relicstone_tiles", () -> new BlockItem(IcariaBlocks.RELICSTONE_TILES.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems RELICSTONE_TILE_DECO = new IcariaStoneDecoItems(IcariaBlocks.RELICSTONE_TILE_DECO, IcariaItems.RELICSTONE_TILES);
	public static final RegistryObject<Item> CRACKED_RELICSTONE_TILES = IcariaItems.register("cracked_relicstone_tiles", () -> new BlockItem(IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems CRACKED_RELICSTONE_TILE_DECO = new IcariaStoneDecoItems(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO, IcariaItems.CRACKED_RELICSTONE_TILES);
	public static final RegistryObject<Item> MOSSY_RELICSTONE_TILES = IcariaItems.register("mossy_relicstone_tiles", () -> new BlockItem(IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems MOSSY_RELICSTONE_TILE_DECO = new IcariaStoneDecoItems(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO, IcariaItems.MOSSY_RELICSTONE_TILES);
	public static final RegistryObject<Item> CHISELED_RELICSTONE = IcariaItems.register("chiseled_relicstone", () -> new BlockItem(IcariaBlocks.CHISELED_RELICSTONE.get(), new Item.Properties()));
	public static final RegistryObject<Item> RELICSTONE_PILLAR = IcariaItems.register("relicstone_pillar", () -> new BlockItem(IcariaBlocks.RELICSTONE_PILLAR.get(), new Item.Properties()));
	public static final RegistryObject<Item> RELICSTONE_PILLAR_HEAD = IcariaItems.register("relicstone_pillar_head", () -> new BlockItem(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), new Item.Properties()));
	public static final RegistryObject<Item> RELICSTONE_RUBBLE = IcariaItems.register("relicstone_rubble", () -> new BlockItem(IcariaBlocks.RELICSTONE_RUBBLE.get(), new Item.Properties()));

	public static final RegistryObject<Item> PLATOSHALE = IcariaItems.register("platoshale", () -> new BlockItem(IcariaBlocks.PLATOSHALE.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems PLATOSHALE_DECO = new IcariaStoneDecoItems(IcariaBlocks.PLATOSHALE_DECO, IcariaItems.PLATOSHALE);
	public static final RegistryObject<Item> BLURRED_PLATOSHALE = IcariaItems.register("blurred_platoshale", () -> new BlockItem(IcariaBlocks.BLURRED_PLATOSHALE.get(), new Item.Properties()));
	public static final RegistryObject<Item> PLATOSHALE_BRICKS = IcariaItems.register("platoshale_bricks", () -> new BlockItem(IcariaBlocks.PLATOSHALE_BRICKS.get(), new Item.Properties()));
	public static final IcariaStoneDecoItems PLATOSHALE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.PLATOSHALE_BRICK_DECO, IcariaItems.PLATOSHALE_BRICKS);
	public static final RegistryObject<Item> BLURRED_PLATOSHALE_BRICKS = IcariaItems.register("blurred_platoshale_bricks", () -> new BlockItem(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHISELED_PLATOSHALE = IcariaItems.register("chiseled_platoshale", () -> new BlockItem(IcariaBlocks.CHISELED_PLATOSHALE.get(), new Item.Properties()));

	public static final RegistryObject<Item> QUARTZ_PILLAR_HEAD = IcariaItems.register("quartz_pillar_head", () -> new BlockItem(IcariaBlocks.QUARTZ_PILLAR_HEAD.get(), new Item.Properties()));

	public static final RegistryObject<Item> LIGNITE_ORE = IcariaItems.register("lignite_ore", () -> new BlockItem(IcariaBlocks.LIGNITE_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHALKOS_ORE = IcariaItems.register("chalkos_ore", () -> new BlockItem(IcariaBlocks.CHALKOS_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASSITEROS_ORE = IcariaItems.register("kassiteros_ore", () -> new BlockItem(IcariaBlocks.KASSITEROS_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> DOLOMITE_ORE = IcariaItems.register("dolomite_ore", () -> new BlockItem(IcariaBlocks.DOLOMITE_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> VANADIUM_ORE = IcariaItems.register("vanadium_ore", () -> new BlockItem(IcariaBlocks.VANADIUM_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SLIVER_ORE = IcariaItems.register("sliver_ore", () -> new BlockItem(IcariaBlocks.SLIVER_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SIDEROS_ORE = IcariaItems.register("sideros_ore", () -> new BlockItem(IcariaBlocks.SIDEROS_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANTHRACITE_ORE = IcariaItems.register("anthracite_ore", () -> new BlockItem(IcariaBlocks.ANTHRACITE_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> MOLYBDENUM_ORE = IcariaItems.register("molybdenum_ore", () -> new BlockItem(IcariaBlocks.MOLYBDENUM_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> HYLIASTRUM_ORE = IcariaItems.register("hyliastrum_ore", () -> new BlockItem(IcariaBlocks.HYLIASTRUM_ORE.get(), new Item.Properties()));

	public static final RegistryObject<Item> CALCITE = IcariaItems.register("calcite", () -> new BlockItem(IcariaBlocks.CALCITE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BUDDING_CALCITE = IcariaItems.register("budding_calcite", () -> new BlockItem(IcariaBlocks.BUDDING_CALCITE.get(), new Item.Properties()));
	public static final RegistryObject<Item> HALITE = IcariaItems.register("halite", () -> new BlockItem(IcariaBlocks.HALITE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BUDDING_HALITE = IcariaItems.register("budding_halite", () -> new BlockItem(IcariaBlocks.BUDDING_HALITE.get(), new Item.Properties()));
	public static final RegistryObject<Item> JASPER = IcariaItems.register("jasper", () -> new BlockItem(IcariaBlocks.JASPER.get(), new Item.Properties()));
	public static final RegistryObject<Item> BUDDING_JASPER = IcariaItems.register("budding_jasper", () -> new BlockItem(IcariaBlocks.BUDDING_JASPER.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZIRCON = IcariaItems.register("zircon", () -> new BlockItem(IcariaBlocks.ZIRCON.get(), new Item.Properties()));
	public static final RegistryObject<Item> BUDDING_ZIRCON = IcariaItems.register("budding_zircon", () -> new BlockItem(IcariaBlocks.BUDDING_ZIRCON.get(), new Item.Properties()));

	public static final RegistryObject<Item> CALCITE_CRYSTAL = IcariaItems.register("calcite_crystal", () -> new BlockItem(IcariaBlocks.CALCITE_CRYSTAL.get(), new Item.Properties()));
	public static final RegistryObject<Item> HALITE_CRYSTAL = IcariaItems.register("halite_crystal", () -> new BlockItem(IcariaBlocks.HALITE_CRYSTAL.get(), new Item.Properties()));
	public static final RegistryObject<Item> JASPER_CRYSTAL = IcariaItems.register("jasper_crystal", () -> new BlockItem(IcariaBlocks.JASPER_CRYSTAL.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZIRCON_CRYSTAL = IcariaItems.register("zircon_crystal", () -> new BlockItem(IcariaBlocks.ZIRCON_CRYSTAL.get(), new Item.Properties()));

	public static final RegistryObject<Item> ARISTONE = IcariaItems.register("aristone", () -> new BlockItem(IcariaBlocks.ARISTONE.get(), new Item.Properties()));
	public static final RegistryObject<Item> PACKED_ARISTONE = IcariaItems.register("packed_aristone", () -> new BlockItem(IcariaBlocks.PACKED_ARISTONE.get(), new Item.Properties()));

	public static final RegistryObject<Item> ENDER_JELLYFISH_JELLY_BLOCK = IcariaItems.register("ender_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> FIRE_JELLYFISH_JELLY_BLOCK = IcariaItems.register("fire_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> NATURE_JELLYFISH_JELLY_BLOCK = IcariaItems.register("nature_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> VOID_JELLYFISH_JELLY_BLOCK = IcariaItems.register("void_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> WATER_JELLYFISH_JELLY_BLOCK = IcariaItems.register("water_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> ARACHNE_STRING_BLOCK = IcariaItems.register("arachne_string_block", () -> new FuelBlockItem(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> SPELT_BALE_BLOCK = IcariaItems.register("spelt_bale_block", () -> new BlockItem(IcariaBlocks.SPELT_BALE_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> VINE_REED_BLOCK = IcariaItems.register("vine_reed_block", () -> new BlockItem(IcariaBlocks.VINE_REED_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> VINE_SPROUT_BLOCK = IcariaItems.register("vine_sprout_block", () -> new BlockItem(IcariaBlocks.VINE_SPROUT_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> ROTTEN_BONES_BLOCK = IcariaItems.register("rotten_bones_block", () -> new BlockItem(IcariaBlocks.ROTTEN_BONES_BLOCK.get(), new Item.Properties()));

	public static final RegistryObject<Item> RAW_CHALKOS_BLOCK = IcariaItems.register("raw_chalkos_block", () -> new BlockItem(IcariaBlocks.RAW_CHALKOS_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> RAW_KASSITEROS_BLOCK = IcariaItems.register("raw_kassiteros_block", () -> new BlockItem(IcariaBlocks.RAW_KASSITEROS_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> RAW_VANADIUM_BLOCK = IcariaItems.register("raw_vanadium_block", () -> new BlockItem(IcariaBlocks.RAW_VANADIUM_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> SLIVER_BLOCK = IcariaItems.register("sliver_block", () -> new BlockItem(IcariaBlocks.SLIVER_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> RAW_SIDEROS_BLOCK = IcariaItems.register("raw_sideros_block", () -> new BlockItem(IcariaBlocks.RAW_SIDEROS_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> RAW_MOLYBDENUM_BLOCK = IcariaItems.register("raw_molybdenum_block", () -> new BlockItem(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get(), new Item.Properties()));

	public static final RegistryObject<Item> CALCITE_BLOCK = IcariaItems.register("calcite_block", () -> new BlockItem(IcariaBlocks.CALCITE_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> HALITE_BLOCK = IcariaItems.register("halite_block", () -> new BlockItem(IcariaBlocks.HALITE_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> JASPER_BLOCK = IcariaItems.register("jasper_block", () -> new BlockItem(IcariaBlocks.JASPER_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> ZIRCON_BLOCK = IcariaItems.register("zircon_block", () -> new BlockItem(IcariaBlocks.ZIRCON_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHERT_BLOCK = IcariaItems.register("chert_block", () -> new BlockItem(IcariaBlocks.CHERT_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> LIGNITE_BLOCK = IcariaItems.register("lignite_block", () -> new FuelBlockItem(IcariaBlocks.LIGNITE_BLOCK.get(), new Item.Properties(), 7200));
	public static final RegistryObject<Item> CHALKOS_BLOCK = IcariaItems.register("chalkos_block", () -> new BlockItem(IcariaBlocks.CHALKOS_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> KASSITEROS_BLOCK = IcariaItems.register("kassiteros_block", () -> new BlockItem(IcariaBlocks.KASSITEROS_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> ORICHALCUM_BLOCK = IcariaItems.register("orichalcum_block", () -> new BlockItem(IcariaBlocks.ORICHALCUM_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> VANADIUM_BLOCK = IcariaItems.register("vanadium_block", () -> new BlockItem(IcariaBlocks.VANADIUM_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> VANADIUMSTEEL_BLOCK = IcariaItems.register("vanadiumsteel_block", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> SIDEROS_BLOCK = IcariaItems.register("sideros_block", () -> new BlockItem(IcariaBlocks.SIDEROS_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> ANTHRACITE_BLOCK = IcariaItems.register("anthracite_block", () -> new FuelBlockItem(IcariaBlocks.ANTHRACITE_BLOCK.get(), new Item.Properties(), 28800));
	public static final RegistryObject<Item> MOLYBDENUM_BLOCK = IcariaItems.register("molybdenum_block", () -> new BlockItem(IcariaBlocks.MOLYBDENUM_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> MOLYBDENUMSTEEL_BLOCK = IcariaItems.register("molybdenumsteel_block", () -> new BlockItem(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLURIDIUM_BLOCK = IcariaItems.register("bluridium_block", () -> new BlockItem(IcariaBlocks.BLURIDIUM_BLOCK.get(), new Item.Properties()));

	public static final RegistryObject<Item> VANADIUMSTEEL_BARS = IcariaItems.register("vanadiumsteel_bars", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_BARS.get(), new Item.Properties()));
	public static final RegistryObject<Item> HORIZONTAL_VANADIUMSTEEL_BARS = IcariaItems.register("horizontal_vanadiumsteel_bars", () -> new BlockItem(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get(), new Item.Properties()));

	public static final RegistryObject<Item> VANADIUMSTEEL_CHAIN = IcariaItems.registerBasic("vanadiumsteel_chain", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_CHAIN.get(), new Item.Properties()));

	public static final RegistryObject<Item> KETTLE = IcariaItems.register("kettle", () -> new BlockItem(IcariaBlocks.KETTLE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRINDER = IcariaItems.register("grinder", () -> new BlockItem(IcariaBlocks.GRINDER.get(), new Item.Properties()));
	public static final RegistryObject<Item> KILN = IcariaItems.register("kiln", () -> new BlockItem(IcariaBlocks.KILN.get(), new Item.Properties()));
	public static final RegistryObject<Item> FORGE = IcariaItems.register("forge", () -> new BlockItem(IcariaBlocks.FORGE.get(), new Item.Properties()));

	public static final RegistryObject<Item> CHEST = IcariaItems.register("chest", () -> new BlockItem(IcariaBlocks.CHEST.get(), new Item.Properties()));
	public static final RegistryObject<Item> TRAPPED_CHEST = IcariaItems.register("trapped_chest", () -> new BlockItem(IcariaBlocks.TRAPPED_CHEST.get(), new Item.Properties()));

	public static final RegistryObject<Item> BARREL = IcariaItems.register("barrel", () -> new BlockItem(IcariaBlocks.BARREL.get(), new Item.Properties()));
	public static final RegistryObject<Item> BARREL_RACK = IcariaItems.register("barrel_rack", () -> new BlockItem(IcariaBlocks.BARREL_RACK.get(), new Item.Properties()));

	public static final RegistryObject<Item> STORAGE_VASE = IcariaItems.register("storage_vase", () -> new BlockItem(IcariaBlocks.STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> WHITE_STORAGE_VASE = IcariaItems.register("white_storage_vase", () -> new BlockItem(IcariaBlocks.WHITE_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> LIGHT_GRAY_STORAGE_VASE = IcariaItems.register("light_gray_storage_vase", () -> new BlockItem(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRAY_STORAGE_VASE = IcariaItems.register("gray_storage_vase", () -> new BlockItem(IcariaBlocks.GRAY_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLACK_STORAGE_VASE = IcariaItems.register("black_storage_vase", () -> new BlockItem(IcariaBlocks.BLACK_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BROWN_STORAGE_VASE = IcariaItems.register("brown_storage_vase", () -> new BlockItem(IcariaBlocks.BROWN_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> RED_STORAGE_VASE = IcariaItems.register("red_storage_vase", () -> new BlockItem(IcariaBlocks.RED_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> ORANGE_STORAGE_VASE = IcariaItems.register("orange_storage_vase", () -> new BlockItem(IcariaBlocks.ORANGE_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> YELLOW_STORAGE_VASE = IcariaItems.register("yellow_storage_vase", () -> new BlockItem(IcariaBlocks.YELLOW_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> LIME_STORAGE_VASE = IcariaItems.register("lime_storage_vase", () -> new BlockItem(IcariaBlocks.LIME_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GREEN_STORAGE_VASE = IcariaItems.register("green_storage_vase", () -> new BlockItem(IcariaBlocks.GREEN_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CYAN_STORAGE_VASE = IcariaItems.register("cyan_storage_vase", () -> new BlockItem(IcariaBlocks.CYAN_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> LIGHT_BLUE_STORAGE_VASE = IcariaItems.register("light_blue_storage_vase", () -> new BlockItem(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLUE_STORAGE_VASE = IcariaItems.register("blue_storage_vase", () -> new BlockItem(IcariaBlocks.BLUE_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_STORAGE_VASE = IcariaItems.register("purple_storage_vase", () -> new BlockItem(IcariaBlocks.PURPLE_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> MAGENTA_STORAGE_VASE = IcariaItems.register("magenta_storage_vase", () -> new BlockItem(IcariaBlocks.MAGENTA_STORAGE_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> PINK_STORAGE_VASE = IcariaItems.register("pink_storage_vase", () -> new BlockItem(IcariaBlocks.PINK_STORAGE_VASE.get(), new Item.Properties()));

	public static final RegistryObject<Item> RED_LOOT_VASE = IcariaItems.register("red_loot_vase", () -> new BlockItem(IcariaBlocks.RED_LOOT_VASE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CYAN_LOOT_VASE = IcariaItems.register("cyan_loot_vase", () -> new BlockItem(IcariaBlocks.CYAN_LOOT_VASE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DUNGEON_SPAWNER = IcariaItems.register("dungeon_spawner", () -> new BlockItem(IcariaBlocks.DUNGEON_SPAWNER.get(), new Item.Properties()));
	public static final RegistryObject<Item> MYRMEKE_SPAWNER = IcariaItems.register("myrmeke_spawner", () -> new BlockItem(IcariaBlocks.MYRMEKE_SPAWNER.get(), new Item.Properties()));
	public static final RegistryObject<Item> RUIN_SPAWNER = IcariaItems.register("ruin_spawner", () -> new BlockItem(IcariaBlocks.RUIN_SPAWNER.get(), new Item.Properties()));
	public static final RegistryObject<Item> VILLAGE_SPAWNER = IcariaItems.register("village_spawner", () -> new BlockItem(IcariaBlocks.VILLAGE_SPAWNER.get(), new Item.Properties()));

	public static final RegistryObject<Item> AETERNAE_SKULL = IcariaItems.register("aeternae_skull", () -> new IcariaSkullItem(IcariaBlocks.AETERNAE_SKULL.get(), IcariaBlocks.AETERNAE_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> ARGAN_HOUND_SKULL = IcariaItems.register("argan_hound_skull", () -> new IcariaSkullItem(IcariaBlocks.ARGAN_HOUND_SKULL.get(), IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> CATOBLEPAS_SKULL = IcariaItems.register("catoblepas_skull", () -> new IcariaSkullItem(IcariaBlocks.CATOBLEPAS_SKULL.get(), IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> CERVER_SKULL = IcariaItems.register("cerver_skull", () -> new IcariaSkullItem(IcariaBlocks.CERVER_SKULL.get(), IcariaBlocks.CERVER_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> CYPRESS_FOREST_HAG_SKULL = IcariaItems.register("cypress_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get(), IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> DROUGHTROOT_FOREST_HAG_SKULL = IcariaItems.register("droughtroot_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get(), IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> FIR_FOREST_HAG_SKULL = IcariaItems.register("fir_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.FIR_FOREST_HAG_SKULL.get(), IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> LAUREL_FOREST_HAG_SKULL = IcariaItems.register("laurel_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get(), IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> OLIVE_FOREST_HAG_SKULL = IcariaItems.register("olive_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get(), IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> PLANE_FOREST_HAG_SKULL = IcariaItems.register("plane_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get(), IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> POPULUS_FOREST_HAG_SKULL = IcariaItems.register("populus_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get(), IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> REVENANT_SKULL = IcariaItems.register("revenant_skull", () -> new IcariaSkullItem(IcariaBlocks.REVENANT_SKULL.get(), IcariaBlocks.REVENANT_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> SOW_SKULL = IcariaItems.register("sow_skull", () -> new IcariaSkullItem(IcariaBlocks.SOW_SKULL.get(), IcariaBlocks.SOW_WALL_SKULL.get(), new Item.Properties(), Direction.DOWN));

	public static final RegistryObject<Item> DIM_TORCH = IcariaItems.registerBasic("dim_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.DIM_TORCH.get(), IcariaBlocks.DIM_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> LIGNITE_TORCH = IcariaItems.registerBasic("lignite_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.LIGNITE_TORCH.get(), IcariaBlocks.LIGNITE_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> ANTHRACITE_TORCH = IcariaItems.registerBasic("anthracite_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.ANTHRACITE_TORCH.get(), IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));

	public static final RegistryObject<Item> LAUREL_CHERRY_CAKE = IcariaItems.registerBasic("laurel_cherry_cake", () -> new BlockItem(IcariaBlocks.LAUREL_CHERRY_CAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRAWBERRY_CAKE = IcariaItems.registerBasic("strawberry_cake", () -> new BlockItem(IcariaBlocks.STRAWBERRY_CAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> PHYSALIS_CAKE = IcariaItems.registerBasic("physalis_cake", () -> new BlockItem(IcariaBlocks.PHYSALIS_CAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> VINE_BERRY_CAKE = IcariaItems.registerBasic("vine_berry_cake", () -> new BlockItem(IcariaBlocks.VINE_BERRY_CAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> VINE_SPROUT_CAKE = IcariaItems.registerBasic("vine_sprout_cake", () -> new BlockItem(IcariaBlocks.VINE_SPROUT_CAKE.get(), new Item.Properties()));

	public static final RegistryObject<Item> CYPRESS_SAPLING = IcariaItems.register("cypress_sapling", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_SAPLING.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> CYPRESS_LEAVES = IcariaItems.register("cypress_leaves", () -> new BlockItem(IcariaBlocks.CYPRESS_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_CYPRESS_LEAVES = IcariaItems.register("fallen_cypress_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> CYPRESS_TWIGS = IcariaItems.register("cypress_twigs", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_TWIGS.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> CYPRESS_WOOD = IcariaItems.register("cypress_wood", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_CYPRESS_WOOD = IcariaItems.register("stripped_cypress_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> CYPRESS_LOG = IcariaItems.register("cypress_log", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_CYPRESS_LOG = IcariaItems.register("stripped_cypress_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DEAD_CYPRESS_LOG = IcariaItems.register("dead_cypress_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_CYPRESS_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_CYPRESS_LOG = IcariaItems.register("stripped_dead_cypress_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> CYPRESS_PLANKS = IcariaItems.register("cypress_planks", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_PLANKS.get(), new Item.Properties(), 300));
	public static final IcariaWoodDecoItems CYPRESS_DECO = new IcariaWoodDecoItems(IcariaBlocks.CYPRESS_DECO, IcariaItems.CYPRESS_PLANKS);
	public static final RegistryObject<Item> CYPRESS_CRAFTING_TABLE = IcariaItems.register("cypress_crafting_table", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> CYPRESS_DOOR = IcariaItems.registerBasic("cypress_door", () -> new BlockItem(IcariaBlocks.CYPRESS_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> CYPRESS_TRAPDOOR = IcariaItems.register("cypress_trapdoor", () -> new BlockItem(IcariaBlocks.CYPRESS_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> CYPRESS_LADDER = IcariaItems.registerBasic("cypress_ladder", () -> new FuelBlockItem(IcariaBlocks.CYPRESS_LADDER.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> CYPRESS_SIGN = IcariaItems.registerBasic("cypress_sign", () -> new IcariaSignItem(new Item.Properties(), IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_WALL_SIGN.get()));
	public static final RegistryObject<Item> CYPRESS_HANGING_SIGN = IcariaItems.registerBasic("cypress_hanging_sign", () -> new HangingSignItem(IcariaBlocks.CYPRESS_HANGING_SIGN.get(), IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), new Item.Properties()));

	public static final RegistryObject<Item> DROUGHTROOT_SAPLING = IcariaItems.register("droughtroot_sapling", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_SAPLING.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> DROUGHTROOT_LEAVES = IcariaItems.register("droughtroot_leaves", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_DROUGHTROOT_LEAVES = IcariaItems.register("fallen_droughtroot_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> DROUGHTROOT_TWIGS = IcariaItems.register("droughtroot_twigs", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_TWIGS.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> DROUGHTROOT_WOOD = IcariaItems.register("droughtroot_wood", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_DROUGHTROOT_WOOD = IcariaItems.register("stripped_droughtroot_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DROUGHTROOT_LOG = IcariaItems.register("droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_DROUGHTROOT_LOG = IcariaItems.register("stripped_droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DEAD_DROUGHTROOT_LOG = IcariaItems.register("dead_droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_DROUGHTROOT_LOG = IcariaItems.register("stripped_dead_droughtroot_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> DROUGHTROOT_PLANKS = IcariaItems.register("droughtroot_planks", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_PLANKS.get(), new Item.Properties(), 300));
	public static final IcariaWoodDecoItems DROUGHTROOT_DECO = new IcariaWoodDecoItems(IcariaBlocks.DROUGHTROOT_DECO, IcariaItems.DROUGHTROOT_PLANKS);
	public static final RegistryObject<Item> DROUGHTROOT_CRAFTING_TABLE = IcariaItems.register("droughtroot_crafting_table", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DROUGHTROOT_DOOR = IcariaItems.registerBasic("droughtroot_door", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> DROUGHTROOT_TRAPDOOR = IcariaItems.register("droughtroot_trapdoor", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> DROUGHTROOT_LADDER = IcariaItems.registerBasic("droughtroot_ladder", () -> new FuelBlockItem(IcariaBlocks.DROUGHTROOT_LADDER.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DROUGHTROOT_SIGN = IcariaItems.registerBasic("droughtroot_sign", () -> new IcariaSignItem(new Item.Properties(), IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_SIGN.get()));
	public static final RegistryObject<Item> DROUGHTROOT_HANGING_SIGN = IcariaItems.registerBasic("droughtroot_hanging_sign", () -> new HangingSignItem(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), new Item.Properties()));

	public static final RegistryObject<Item> FIR_SAPLING = IcariaItems.register("fir_sapling", () -> new FuelBlockItem(IcariaBlocks.FIR_SAPLING.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> FIR_LEAVES = IcariaItems.register("fir_leaves", () -> new BlockItem(IcariaBlocks.FIR_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_FIR_LEAVES = IcariaItems.register("fallen_fir_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_FIR_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FIR_TWIGS = IcariaItems.register("fir_twigs", () -> new FuelBlockItem(IcariaBlocks.FIR_TWIGS.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> FIR_WOOD = IcariaItems.register("fir_wood", () -> new FuelBlockItem(IcariaBlocks.FIR_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_FIR_WOOD = IcariaItems.register("stripped_fir_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_FIR_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> FIR_LOG = IcariaItems.register("fir_log", () -> new FuelBlockItem(IcariaBlocks.FIR_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_FIR_LOG = IcariaItems.register("stripped_fir_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_FIR_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DEAD_FIR_LOG = IcariaItems.register("dead_fir_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_FIR_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_FIR_LOG = IcariaItems.register("stripped_dead_fir_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> FIR_PLANKS = IcariaItems.register("fir_planks", () -> new FuelBlockItem(IcariaBlocks.FIR_PLANKS.get(), new Item.Properties(), 300));
	public static final IcariaWoodDecoItems FIR_DECO = new IcariaWoodDecoItems(IcariaBlocks.FIR_DECO, IcariaItems.FIR_PLANKS);
	public static final RegistryObject<Item> FIR_CRAFTING_TABLE = IcariaItems.register("fir_crafting_table", () -> new FuelBlockItem(IcariaBlocks.FIR_CRAFTING_TABLE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> FIR_DOOR = IcariaItems.registerBasic("fir_door", () -> new BlockItem(IcariaBlocks.FIR_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> FIR_TRAPDOOR = IcariaItems.register("fir_trapdoor", () -> new BlockItem(IcariaBlocks.FIR_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> FIR_LADDER = IcariaItems.registerBasic("fir_ladder", () -> new FuelBlockItem(IcariaBlocks.FIR_LADDER.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> FIR_SIGN = IcariaItems.registerBasic("fir_sign", () -> new IcariaSignItem(new Item.Properties(), IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_WALL_SIGN.get()));
	public static final RegistryObject<Item> FIR_HANGING_SIGN = IcariaItems.registerBasic("fir_hanging_sign", () -> new HangingSignItem(IcariaBlocks.FIR_HANGING_SIGN.get(), IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), new Item.Properties()));

	public static final RegistryObject<Item> LAUREL_SAPLING = IcariaItems.register("laurel_sapling", () -> new FuelBlockItem(IcariaBlocks.LAUREL_SAPLING.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> LAUREL_LEAVES = IcariaItems.register("laurel_leaves", () -> new BlockItem(IcariaBlocks.LAUREL_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_LAUREL_LEAVES = IcariaItems.register("fallen_laurel_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> LAUREL_TWIGS = IcariaItems.register("laurel_twigs", () -> new FuelBlockItem(IcariaBlocks.LAUREL_TWIGS.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> LAUREL_WOOD = IcariaItems.register("laurel_wood", () -> new FuelBlockItem(IcariaBlocks.LAUREL_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_LAUREL_WOOD = IcariaItems.register("stripped_laurel_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> LAUREL_LOG = IcariaItems.register("laurel_log", () -> new FuelBlockItem(IcariaBlocks.LAUREL_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_LAUREL_LOG = IcariaItems.register("stripped_laurel_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DEAD_LAUREL_LOG = IcariaItems.register("dead_laurel_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_LAUREL_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_LAUREL_LOG = IcariaItems.register("stripped_dead_laurel_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> LAUREL_PLANKS = IcariaItems.register("laurel_planks", () -> new FuelBlockItem(IcariaBlocks.LAUREL_PLANKS.get(), new Item.Properties(), 300));
	public static final IcariaWoodDecoItems LAUREL_DECO = new IcariaWoodDecoItems(IcariaBlocks.LAUREL_DECO, IcariaItems.LAUREL_PLANKS);
	public static final RegistryObject<Item> LAUREL_CRAFTING_TABLE = IcariaItems.register("laurel_crafting_table", () -> new FuelBlockItem(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> LAUREL_DOOR = IcariaItems.registerBasic("laurel_door", () -> new BlockItem(IcariaBlocks.LAUREL_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> LAUREL_TRAPDOOR = IcariaItems.register("laurel_trapdoor", () -> new BlockItem(IcariaBlocks.LAUREL_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> LAUREL_LADDER = IcariaItems.registerBasic("laurel_ladder", () -> new FuelBlockItem(IcariaBlocks.LAUREL_LADDER.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> LAUREL_SIGN = IcariaItems.registerBasic("laurel_sign", () -> new IcariaSignItem(new Item.Properties(), IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_WALL_SIGN.get()));
	public static final RegistryObject<Item> LAUREL_HANGING_SIGN = IcariaItems.registerBasic("laurel_hanging_sign", () -> new HangingSignItem(IcariaBlocks.LAUREL_HANGING_SIGN.get(), IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), new Item.Properties()));

	public static final RegistryObject<Item> OLIVE_SAPLING = IcariaItems.register("olive_sapling", () -> new FuelBlockItem(IcariaBlocks.OLIVE_SAPLING.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> OLIVE_LEAVES = IcariaItems.register("olive_leaves", () -> new BlockItem(IcariaBlocks.OLIVE_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_OLIVE_LEAVES = IcariaItems.register("fallen_olive_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> OLIVE_TWIGS = IcariaItems.register("olive_twigs", () -> new FuelBlockItem(IcariaBlocks.OLIVE_TWIGS.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> OLIVE_WOOD = IcariaItems.register("olive_wood", () -> new FuelBlockItem(IcariaBlocks.OLIVE_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_OLIVE_WOOD = IcariaItems.register("stripped_olive_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> OLIVE_LOG = IcariaItems.register("olive_log", () -> new FuelBlockItem(IcariaBlocks.OLIVE_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_OLIVE_LOG = IcariaItems.register("stripped_olive_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DEAD_OLIVE_LOG = IcariaItems.register("dead_olive_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_OLIVE_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_OLIVE_LOG = IcariaItems.register("stripped_dead_olive_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> OLIVE_PLANKS = IcariaItems.register("olive_planks", () -> new FuelBlockItem(IcariaBlocks.OLIVE_PLANKS.get(), new Item.Properties(), 300));
	public static final IcariaWoodDecoItems OLIVE_DECO = new IcariaWoodDecoItems(IcariaBlocks.OLIVE_DECO, IcariaItems.OLIVE_PLANKS);
	public static final RegistryObject<Item> OLIVE_CRAFTING_TABLE = IcariaItems.register("olive_crafting_table", () -> new FuelBlockItem(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> OLIVE_DOOR = IcariaItems.registerBasic("olive_door", () -> new BlockItem(IcariaBlocks.OLIVE_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> OLIVE_TRAPDOOR = IcariaItems.register("olive_trapdoor", () -> new BlockItem(IcariaBlocks.OLIVE_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> OLIVE_LADDER = IcariaItems.registerBasic("olive_ladder", () -> new FuelBlockItem(IcariaBlocks.OLIVE_LADDER.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> OLIVE_SIGN = IcariaItems.registerBasic("olive_sign", () -> new IcariaSignItem(new Item.Properties(), IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_WALL_SIGN.get()));
	public static final RegistryObject<Item> OLIVE_HANGING_SIGN = IcariaItems.registerBasic("olive_hanging_sign", () -> new HangingSignItem(IcariaBlocks.OLIVE_HANGING_SIGN.get(), IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), new Item.Properties()));

	public static final RegistryObject<Item> PLANE_SAPLING = IcariaItems.register("plane_sapling", () -> new FuelBlockItem(IcariaBlocks.PLANE_SAPLING.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> PLANE_LEAVES = IcariaItems.register("plane_leaves", () -> new BlockItem(IcariaBlocks.PLANE_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_PLANE_LEAVES = IcariaItems.register("fallen_plane_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> PLANE_TWIGS = IcariaItems.register("plane_twigs", () -> new FuelBlockItem(IcariaBlocks.PLANE_TWIGS.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> PLANE_WOOD = IcariaItems.register("plane_wood", () -> new FuelBlockItem(IcariaBlocks.PLANE_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_PLANE_WOOD = IcariaItems.register("stripped_plane_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> PLANE_LOG = IcariaItems.register("plane_log", () -> new FuelBlockItem(IcariaBlocks.PLANE_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_PLANE_LOG = IcariaItems.register("stripped_plane_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_PLANE_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DEAD_PLANE_LOG = IcariaItems.register("dead_plane_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_PLANE_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_PLANE_LOG = IcariaItems.register("stripped_dead_plane_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> PLANE_PLANKS = IcariaItems.register("plane_planks", () -> new FuelBlockItem(IcariaBlocks.PLANE_PLANKS.get(), new Item.Properties(), 300));
	public static final IcariaWoodDecoItems PLANE_DECO = new IcariaWoodDecoItems(IcariaBlocks.PLANE_DECO, IcariaItems.PLANE_PLANKS);
	public static final RegistryObject<Item> PLANE_CRAFTING_TABLE = IcariaItems.register("plane_crafting_table", () -> new FuelBlockItem(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> PLANE_DOOR = IcariaItems.registerBasic("plane_door", () -> new BlockItem(IcariaBlocks.PLANE_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> PLANE_TRAPDOOR = IcariaItems.register("plane_trapdoor", () -> new BlockItem(IcariaBlocks.PLANE_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> PLANE_LADDER = IcariaItems.registerBasic("plane_ladder", () -> new FuelBlockItem(IcariaBlocks.PLANE_LADDER.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> PLANE_SIGN = IcariaItems.registerBasic("plane_sign", () -> new IcariaSignItem(new Item.Properties(), IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_WALL_SIGN.get()));
	public static final RegistryObject<Item> PLANE_HANGING_SIGN = IcariaItems.registerBasic("plane_hanging_sign", () -> new HangingSignItem(IcariaBlocks.PLANE_HANGING_SIGN.get(), IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), new Item.Properties()));

	public static final RegistryObject<Item> POPULUS_SAPLING = IcariaItems.register("populus_sapling", () -> new FuelBlockItem(IcariaBlocks.POPULUS_SAPLING.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> POPULUS_LEAVES = IcariaItems.register("populus_leaves", () -> new BlockItem(IcariaBlocks.POPULUS_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> FALLEN_POPULUS_LEAVES = IcariaItems.register("fallen_populus_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> POPULUS_TWIGS = IcariaItems.register("populus_twigs", () -> new FuelBlockItem(IcariaBlocks.POPULUS_TWIGS.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> POPULUS_WOOD = IcariaItems.register("populus_wood", () -> new FuelBlockItem(IcariaBlocks.POPULUS_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_POPULUS_WOOD = IcariaItems.register("stripped_populus_wood", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> POPULUS_LOG = IcariaItems.register("populus_log", () -> new FuelBlockItem(IcariaBlocks.POPULUS_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> STRIPPED_POPULUS_LOG = IcariaItems.register("stripped_populus_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> DEAD_POPULUS_LOG = IcariaItems.register("dead_populus_log", () -> new FuelBlockItem(IcariaBlocks.DEAD_POPULUS_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> STRIPPED_DEAD_POPULUS_LOG = IcariaItems.register("stripped_dead_populus_log", () -> new FuelBlockItem(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), new Item.Properties(), 100));
	public static final RegistryObject<Item> POPULUS_PLANKS = IcariaItems.register("populus_planks", () -> new FuelBlockItem(IcariaBlocks.POPULUS_PLANKS.get(), new Item.Properties(), 300));
	public static final IcariaWoodDecoItems POPULUS_DECO = new IcariaWoodDecoItems(IcariaBlocks.POPULUS_DECO, IcariaItems.POPULUS_PLANKS);
	public static final RegistryObject<Item> POPULUS_CRAFTING_TABLE = IcariaItems.register("populus_crafting_table", () -> new FuelBlockItem(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> POPULUS_DOOR = IcariaItems.registerBasic("populus_door", () -> new BlockItem(IcariaBlocks.POPULUS_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> POPULUS_TRAPDOOR = IcariaItems.register("populus_trapdoor", () -> new BlockItem(IcariaBlocks.POPULUS_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> POPULUS_LADDER = IcariaItems.registerBasic("populus_ladder", () -> new FuelBlockItem(IcariaBlocks.POPULUS_LADDER.get(), new Item.Properties(), 300));
	public static final RegistryObject<Item> POPULUS_SIGN = IcariaItems.registerBasic("populus_sign", () -> new IcariaSignItem(new Item.Properties(), IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_WALL_SIGN.get()));
	public static final RegistryObject<Item> POPULUS_HANGING_SIGN = IcariaItems.registerBasic("populus_hanging_sign", () -> new HangingSignItem(IcariaBlocks.POPULUS_HANGING_SIGN.get(), IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get(), new Item.Properties()));

	public static final RegistryObject<Item> DEAD_BLOOMY_VINE = IcariaItems.registerBasic("dead_bloomy_vine", () -> new BlockItem(IcariaBlocks.DEAD_BLOOMY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GROWING_BLOOMY_VINE = IcariaItems.registerBasic("growing_bloomy_vine", () -> new BlockItem(IcariaBlocks.GROWING_BLOOMY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLOOMY_VINE = IcariaItems.registerBasic("bloomy_vine", () -> new BlockItem(IcariaBlocks.BLOOMY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLOOMING_BLOOMY_VINE = IcariaItems.registerBasic("blooming_bloomy_vine", () -> new BlockItem(IcariaBlocks.BLOOMING_BLOOMY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> RIPE_BLOOMY_VINE = IcariaItems.registerBasic("ripe_bloomy_vine", () -> new BlockItem(IcariaBlocks.RIPE_BLOOMY_VINE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DEAD_BRANCHY_VINE = IcariaItems.registerBasic("dead_branchy_vine", () -> new BlockItem(IcariaBlocks.DEAD_BRANCHY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GROWING_BRANCHY_VINE = IcariaItems.registerBasic("growing_branchy_vine", () -> new BlockItem(IcariaBlocks.GROWING_BRANCHY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BRANCHY_VINE = IcariaItems.registerBasic("branchy_vine", () -> new BlockItem(IcariaBlocks.BRANCHY_VINE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DEAD_BRUSHY_VINE = IcariaItems.registerBasic("dead_brushy_vine", () -> new BlockItem(IcariaBlocks.DEAD_BRUSHY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GROWING_BRUSHY_VINE = IcariaItems.registerBasic("growing_brushy_vine", () -> new BlockItem(IcariaBlocks.GROWING_BRUSHY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BRUSHY_VINE = IcariaItems.registerBasic("brushy_vine", () -> new BlockItem(IcariaBlocks.BRUSHY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> RIPE_BRUSHY_VINE = IcariaItems.registerBasic("ripe_brushy_vine", () -> new BlockItem(IcariaBlocks.RIPE_BRUSHY_VINE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DEAD_DRY_VINE = IcariaItems.registerBasic("dead_dry_vine", () -> new BlockItem(IcariaBlocks.DEAD_DRY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GROWING_DRY_VINE = IcariaItems.registerBasic("growing_dry_vine", () -> new BlockItem(IcariaBlocks.GROWING_DRY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRY_VINE = IcariaItems.registerBasic("dry_vine", () -> new BlockItem(IcariaBlocks.DRY_VINE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DEAD_REEDY_VINE = IcariaItems.registerBasic("dead_reedy_vine", () -> new BlockItem(IcariaBlocks.DEAD_REEDY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GROWING_REEDY_VINE = IcariaItems.registerBasic("growing_reedy_vine", () -> new BlockItem(IcariaBlocks.GROWING_REEDY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> REEDY_VINE = IcariaItems.registerBasic("reedy_vine", () -> new BlockItem(IcariaBlocks.REEDY_VINE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DEAD_SWIRLY_VINE = IcariaItems.registerBasic("dead_swirly_vine", () -> new BlockItem(IcariaBlocks.DEAD_SWIRLY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GROWING_SWIRLY_VINE = IcariaItems.registerBasic("growing_swirly_vine", () -> new BlockItem(IcariaBlocks.GROWING_SWIRLY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SWIRLY_VINE = IcariaItems.registerBasic("swirly_vine", () -> new BlockItem(IcariaBlocks.SWIRLY_VINE.get(), new Item.Properties()));

	public static final RegistryObject<Item> DEAD_THORNY_VINE = IcariaItems.registerBasic("dead_thorny_vine", () -> new BlockItem(IcariaBlocks.DEAD_THORNY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> GROWING_THORNY_VINE = IcariaItems.registerBasic("growing_thorny_vine", () -> new BlockItem(IcariaBlocks.GROWING_THORNY_VINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> THORNY_VINE = IcariaItems.registerBasic("thorny_vine", () -> new BlockItem(IcariaBlocks.THORNY_VINE.get(), new Item.Properties()));

	public static final RegistryObject<Item> FERN = IcariaItems.registerBasic("fern", () -> new BlockItem(IcariaBlocks.FERN.get(), new Item.Properties()));

	public static final RegistryObject<Item> SMALL_GRASS = IcariaItems.registerBasic("small_grass", () -> new BlockItem(IcariaBlocks.SMALL_GRASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> MEDIUM_GRASS = IcariaItems.registerBasic("medium_grass", () -> new BlockItem(IcariaBlocks.MEDIUM_GRASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> LARGE_GRASS = IcariaItems.registerBasic("large_grass", () -> new BlockItem(IcariaBlocks.LARGE_GRASS.get(), new Item.Properties()));

	public static final RegistryObject<Item> SMALL_MIXED_GRAIN = IcariaItems.registerBasic("small_mixed_grain", () -> new BlockItem(IcariaBlocks.SMALL_MIXED_GRAIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> MEDIUM_MIXED_GRAIN = IcariaItems.registerBasic("medium_mixed_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_MIXED_GRAIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> MEDIUM_BROWN_GRAIN = IcariaItems.registerBasic("medium_brown_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_BROWN_GRAIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> MEDIUM_WHITE_GRAIN = IcariaItems.registerBasic("medium_white_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_WHITE_GRAIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> MEDIUM_YELLOW_GRAIN = IcariaItems.registerBasic("medium_yellow_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get(), new Item.Properties()));
	public static final RegistryObject<Item> LARGE_BROWN_GRAIN = IcariaItems.registerBasic("large_brown_grain", () -> new BlockItem(IcariaBlocks.LARGE_BROWN_GRAIN.get(), new Item.Properties()));

	public static final RegistryObject<Item> BLINDWEED = IcariaItems.registerBasic("blindweed", () -> new BlockItem(IcariaBlocks.BLINDWEED.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHAMEOMILE = IcariaItems.registerBasic("chameomile", () -> new BlockItem(IcariaBlocks.CHAMEOMILE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHARMONDER = IcariaItems.registerBasic("charmonder", () -> new BlockItem(IcariaBlocks.CHARMONDER.get(), new Item.Properties()));
	public static final RegistryObject<Item> CLOVER = IcariaItems.registerBasic("clover", () -> new BlockItem(IcariaBlocks.CLOVER.get(), new Item.Properties()));
	public static final RegistryObject<Item> FIREHILT = IcariaItems.registerBasic("firehilt", () -> new BlockItem(IcariaBlocks.FIREHILT.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLUE_HYDRACINTH = IcariaItems.registerBasic("blue_hydracinth", () -> new BlockItem(IcariaBlocks.BLUE_HYDRACINTH.get(), new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_HYDRACINTH = IcariaItems.registerBasic("purple_hydracinth", () -> new BlockItem(IcariaBlocks.PURPLE_HYDRACINTH.get(), new Item.Properties()));
	public static final RegistryObject<Item> LIONFANGS = IcariaItems.registerBasic("lionfangs", () -> new BlockItem(IcariaBlocks.LIONFANGS.get(), new Item.Properties()));
	public static final RegistryObject<Item> SPEARDROPS = IcariaItems.registerBasic("speardrops", () -> new BlockItem(IcariaBlocks.SPEARDROPS.get(), new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_STAGHORN = IcariaItems.registerBasic("purple_staghorn", () -> new BlockItem(IcariaBlocks.PURPLE_STAGHORN.get(), new Item.Properties()));
	public static final RegistryObject<Item> YELLOW_STAGHORN = IcariaItems.registerBasic("yellow_staghorn", () -> new BlockItem(IcariaBlocks.YELLOW_STAGHORN.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLUE_STORMCOTTON = IcariaItems.registerBasic("blue_stormcotton", () -> new BlockItem(IcariaBlocks.BLUE_STORMCOTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> PINK_STORMCOTTON = IcariaItems.registerBasic("pink_stormcotton", () -> new BlockItem(IcariaBlocks.PINK_STORMCOTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_STORMCOTTON = IcariaItems.registerBasic("purple_stormcotton", () -> new BlockItem(IcariaBlocks.PURPLE_STORMCOTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUNKETTLE = IcariaItems.registerBasic("sunkettle", () -> new BlockItem(IcariaBlocks.SUNKETTLE.get(), new Item.Properties()));
	public static final RegistryObject<Item> SUNSPONGE = IcariaItems.registerBasic("sunsponge", () -> new BlockItem(IcariaBlocks.SUNSPONGE.get(), new Item.Properties()));
	public static final RegistryObject<Item> VOIDLILY = IcariaItems.registerBasic("voidlily", () -> new BlockItem(IcariaBlocks.VOIDLILY.get(), new Item.Properties()));

	public static final RegistryObject<Item> BOLBOS = IcariaItems.registerBasic("bolbos", () -> new BlockItem(IcariaBlocks.BOLBOS.get(), new Item.Properties()));
	public static final RegistryObject<Item> DATHULLA = IcariaItems.registerBasic("dathulla", () -> new BlockItem(IcariaBlocks.DATHULLA.get(), new Item.Properties()));
	public static final RegistryObject<Item> MONDANOS = IcariaItems.registerBasic("mondanos", () -> new BlockItem(IcariaBlocks.MONDANOS.get(), new Item.Properties()));
	public static final RegistryObject<Item> MOTH_AGARIC = IcariaItems.registerBasic("moth_agaric", () -> new BlockItem(IcariaBlocks.MOTH_AGARIC.get(), new Item.Properties()));
	public static final RegistryObject<Item> NAMDRAKE = IcariaItems.registerBasic("namdrake", () -> new BlockItem(IcariaBlocks.NAMDRAKE.get(), new Item.Properties()));
	public static final RegistryObject<Item> PSILOCYBOS = IcariaItems.registerBasic("psilocybos", () -> new BlockItem(IcariaBlocks.PSILOCYBOS.get(), new Item.Properties()));
	public static final RegistryObject<Item> ROWAN = IcariaItems.registerBasic("rowan", () -> new BlockItem(IcariaBlocks.ROWAN.get(), new Item.Properties()));
	public static final RegistryObject<Item> WILTED_ELM = IcariaItems.registerBasic("wilted_elm", () -> new BlockItem(IcariaBlocks.WILTED_ELM.get(), new Item.Properties()));

	public static final RegistryObject<Item> BLUE_GROUND_FLOWERS = IcariaItems.register("blue_ground_flowers", () -> new BlockItem(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CYAN_GROUND_FLOWERS = IcariaItems.register("cyan_ground_flowers", () -> new BlockItem(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), new Item.Properties()));
	public static final RegistryObject<Item> PINK_GROUND_FLOWERS = IcariaItems.register("pink_ground_flowers", () -> new BlockItem(IcariaBlocks.PINK_GROUND_FLOWERS.get(), new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_GROUND_FLOWERS = IcariaItems.register("purple_ground_flowers", () -> new BlockItem(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), new Item.Properties()));
	public static final RegistryObject<Item> RED_GROUND_FLOWERS = IcariaItems.register("red_ground_flowers", () -> new BlockItem(IcariaBlocks.RED_GROUND_FLOWERS.get(), new Item.Properties()));
	public static final RegistryObject<Item> WHITE_GROUND_FLOWERS = IcariaItems.register("white_ground_flowers", () -> new BlockItem(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), new Item.Properties()));

	public static final RegistryObject<Item> FOREST_MOSS = IcariaItems.register("forest_moss", () -> new BlockItem(IcariaBlocks.FOREST_MOSS.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCRUBLAND_MOSS = IcariaItems.register("scrubland_moss", () -> new BlockItem(IcariaBlocks.SCRUBLAND_MOSS.get(), new Item.Properties()));
	public static final RegistryObject<Item> STEPPE_MOSS = IcariaItems.register("steppe_moss", () -> new BlockItem(IcariaBlocks.STEPPE_MOSS.get(), new Item.Properties()));

	public static final RegistryObject<Item> PALM_FERN = IcariaItems.register("palm_fern", () -> new BlockItem(IcariaBlocks.PALM_FERN.get(), new Item.Properties()));

	public static final RegistryObject<Item> WHITE_BROMELIA = IcariaItems.register("white_bromelia", () -> new BlockItem(IcariaBlocks.WHITE_BROMELIA.get(), new Item.Properties()));
	public static final RegistryObject<Item> ORANGE_BROMELIA = IcariaItems.register("orange_bromelia", () -> new BlockItem(IcariaBlocks.ORANGE_BROMELIA.get(), new Item.Properties()));
	public static final RegistryObject<Item> PINK_BROMELIA = IcariaItems.register("pink_bromelia", () -> new BlockItem(IcariaBlocks.PINK_BROMELIA.get(), new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_BROMELIA = IcariaItems.register("purple_bromelia", () -> new BlockItem(IcariaBlocks.PURPLE_BROMELIA.get(), new Item.Properties()));

	public static final RegistryObject<Item> GREEN_GROUND_SHROOMS = IcariaItems.register("green_ground_shrooms", () -> new BlockItem(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), new Item.Properties()));
	public static final RegistryObject<Item> BROWN_GROUND_SHROOMS = IcariaItems.register("brown_ground_shrooms", () -> new BlockItem(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), new Item.Properties()));
	public static final RegistryObject<Item> LARGE_BROWN_GROUND_SHROOMS = IcariaItems.register("large_brown_ground_shrooms", () -> new BlockItem(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), new Item.Properties()));

	public static final RegistryObject<Item> TINDER_FUNGUS_TREE_SHROOMS = IcariaItems.register("tinder_fungus_tree_shrooms", () -> new BlockItem(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), new Item.Properties()));
	public static final RegistryObject<Item> TURKEY_TAIL_TREE_SHROOMS = IcariaItems.register("turkey_tail_tree_shrooms", () -> new BlockItem(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), new Item.Properties()));
	public static final RegistryObject<Item> UNNAMED_TREE_SHROOMS = IcariaItems.register("unnamed_tree_shrooms", () -> new BlockItem(IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), new Item.Properties()));

	public static final RegistryObject<Item> CARDON_CACTUS = IcariaItems.register("cardon_cactus", () -> new BlockItem(IcariaBlocks.CARDON_CACTUS.get(), new Item.Properties()));

	public static final RegistryObject<Item> STRAWBERRY_BUSH = IcariaItems.register("strawberry_bush", () -> new BlockItem(IcariaBlocks.STRAWBERRY_BUSH.get(), new Item.Properties()));

	public static final RegistryObject<Item> BONE_REMAINS = IcariaItems.registerBasic("bone_remains", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LOAM_LUMP = IcariaItems.registerBasic("loam_lump", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LOAM_BRICK = IcariaItems.registerBasic("loam_brick", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CHERT = IcariaItems.registerBasic("chert", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ENDER_JELLYFISH_JELLY = IcariaItems.registerBasic("ender_jellyfish_jelly", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> FIRE_JELLYFISH_JELLY = IcariaItems.registerBasic("fire_jellyfish_jelly", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> NATURE_JELLYFISH_JELLY = IcariaItems.registerBasic("nature_jellyfish_jelly", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VOID_JELLYFISH_JELLY = IcariaItems.registerBasic("void_jellyfish_jelly", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> WATER_JELLYFISH_JELLY = IcariaItems.registerBasic("water_jellyfish_jelly", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ARACHNE_STRING = IcariaItems.registerBasic("arachne_string", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SPELT = IcariaItems.registerBasic("spelt", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VINE_REED = IcariaItems.registerBasic("vine_reed", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VINE_SPROUT = IcariaItems.registerBasic("vine_sprout", () -> new VineSproutItem(new Item.Properties().durability(24).food(IcariaItems.foodPropertiesVineSprout(0, 1.0F))));
	public static final RegistryObject<Item> ROTTEN_BONES = IcariaItems.registerBasic("rotten_bones", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CALCITE_SHARD = IcariaItems.registerBasic("calcite_shard", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HALITE_SHARD = IcariaItems.registerBasic("halite_shard", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> JASPER_SHARD = IcariaItems.registerBasic("jasper_shard", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ZIRCON_SHARD = IcariaItems.registerBasic("zircon_shard", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CALCITE_DUST = IcariaItems.registerBasic("calcite_dust", () -> new BoneMealItem(new Item.Properties()));
	public static final RegistryObject<Item> HALITE_DUST = IcariaItems.registerBasic("halite_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LIGNITE = IcariaItems.registerBasic("lignite", () -> new FuelItem(new Item.Properties(), 800));
	public static final RegistryObject<Item> RAW_CHALKOS = IcariaItems.registerBasic("raw_chalkos", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_KASSITEROS = IcariaItems.registerBasic("raw_kassiteros", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DOLOMITE = IcariaItems.registerBasic("dolomite", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_VANADIUM = IcariaItems.registerBasic("raw_vanadium", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SLIVER = IcariaItems.registerBasic("sliver", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_SIDEROS = IcariaItems.registerBasic("raw_sideros", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ANTHRACITE = IcariaItems.registerBasic("anthracite", () -> new FuelItem(new Item.Properties(), 3200));
	public static final RegistryObject<Item> RAW_MOLYBDENUM = IcariaItems.registerBasic("raw_molybdenum", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> CHALKOS_NUGGET = IcariaItems.registerBasic("chalkos_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> KASSITEROS_NUGGET = IcariaItems.registerBasic("kassiteros_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ORICHALCUM_NUGGET = IcariaItems.registerBasic("orichalcum_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VANADIUM_NUGGET = IcariaItems.registerBasic("vanadium_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VANADIUMSTEEL_NUGGET = IcariaItems.registerBasic("vanadiumsteel_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SIDEROS_NUGGET = IcariaItems.registerBasic("sideros_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MOLYBDENUM_NUGGET = IcariaItems.registerBasic("molybdenum_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MOLYBDENUMSTEEL_NUGGET = IcariaItems.registerBasic("molybdenumsteel_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BLURIDIUM_NUGGET = IcariaItems.registerBasic("bluridium_nugget", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> CHALKOS_INGOT = IcariaItems.registerBasic("chalkos_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> KASSITEROS_INGOT = IcariaItems.registerBasic("kassiteros_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ORICHALCUM_INGOT = IcariaItems.registerBasic("orichalcum_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VANADIUM_INGOT = IcariaItems.registerBasic("vanadium_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VANADIUMSTEEL_INGOT = IcariaItems.registerBasic("vanadiumsteel_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SIDEROS_INGOT = IcariaItems.registerBasic("sideros_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MOLYBDENUM_INGOT = IcariaItems.registerBasic("molybdenum_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MOLYBDENUMSTEEL_INGOT = IcariaItems.registerBasic("molybdenumsteel_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BLURIDIUM_INGOT = IcariaItems.registerBasic("bluridium_ingot", () -> new Item(new Item.Properties()));

	public static final IcariaToolItems CHERT_TOOLS = new IcariaToolItems(IcariaTiers.CHERT);
	public static final IcariaToolItems CHALKOS_TOOLS = new IcariaToolItems(IcariaTiers.CHALKOS);
	public static final IcariaToolItems KASSITEROS_TOOLS = new IcariaToolItems(IcariaTiers.KASSITEROS);
	public static final IcariaToolItems ORICHALCUM_TOOLS = new IcariaToolItems(IcariaTiers.ORICHALCUM);
	public static final IcariaToolItems VANADIUMSTEEL_TOOLS = new IcariaToolItems(IcariaTiers.VANADIUMSTEEL);
	public static final IcariaToolItems SIDEROS_TOOLS = new IcariaToolItems(IcariaTiers.SIDEROS);
	public static final IcariaToolItems MOLYBDENUMSTEEL_TOOLS = new IcariaToolItems(IcariaTiers.MOLYBDENUMSTEEL);

	public static final IcariaArmorItems AETERNAE_HIDE_ARMOR = new IcariaArmorItems(IcariaArmorMaterials.AETERNAE_HIDE);
	public static final IcariaArmorItems CHALKOS_ARMOR = new IcariaArmorItems(IcariaArmorMaterials.CHALKOS);
	public static final IcariaArmorItems KASSITEROS_ARMOR = new IcariaArmorItems(IcariaArmorMaterials.KASSITEROS);
	public static final RegistryObject<Item> ORICHALCUM_HELMET = IcariaItems.registerBasic("orichalcum_helmet", () -> new OrichalcumHelmetItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> ORICHALCUM_CHESTPLATE = IcariaItems.registerBasic("orichalcum_chestplate", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> ORICHALCUM_LEGGINGS = IcariaItems.registerBasic("orichalcum_leggings", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> ORICHALCUM_BOOTS = IcariaItems.registerBasic("orichalcum_boots", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final IcariaArmorItems VANADIUMSTEEL_ARMOR = new IcariaArmorItems(IcariaArmorMaterials.VANADIUMSTEEL);
	public static final RegistryObject<Item> LAUREL_WREATH = IcariaItems.registerBasic("laurel_wreath", () -> new ArmorItem(IcariaArmorMaterials.LAUREL, ArmorItem.Type.HELMET, new Item.Properties()));

	public static final RegistryObject<Item> GREEK_FIRE_GRENADE = IcariaItems.registerBasic("greek_fire_grenade", () -> new GreekFireGrenadeItem(new Item.Properties().stacksTo(1)));

	public static final RegistryObject<TotemItem> TOTEM_OF_PREVENTATION = IcariaItems.registerBasic("totem_of_preventation", () -> new TotemItem(new Item.Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_STUFFING = IcariaItems.registerBasic("totem_of_stuffing", () -> new TotemItem(new Item.Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNBLINDING = IcariaItems.registerBasic("totem_of_unblinding", () -> new TotemItem(new Item.Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNDROWNING = IcariaItems.registerBasic("totem_of_undrowning", () -> new TotemItem(new Item.Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNDYING = IcariaItems.registerBasic("totem_of_undying", () -> new TotemItem(new Item.Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNSHATTERING = IcariaItems.registerBasic("totem_of_unshattering", () -> new TotemItem(new Item.Properties().durability(4)));
	public static final RegistryObject<TotemItem> TOTEM_OF_UNSINKING = IcariaItems.registerBasic("totem_of_unsinking", () -> new TotemItem(new Item.Properties().durability(4)));

	public static final RegistryObject<Item> UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> WHITE_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("white_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LIGHT_GRAY_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("light_gray_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GRAY_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("gray_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BLACK_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("black_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BROWN_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("brown_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RED_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("red_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ORANGE_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("orange_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> YELLOW_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("yellow_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LIME_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("lime_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GREEN_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("green_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CYAN_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("cyan_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LIGHT_BLUE_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("light_blue_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BLUE_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("blue_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PURPLE_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("purple_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MAGENTA_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("magenta_unfired_storage_vase", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PINK_UNFIRED_STORAGE_VASE = IcariaItems.registerBasic("pink_unfired_storage_vase", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> EMPTY_FLASK = IcariaItems.registerBasic("empty_flask", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> EMPTY_VIAL = IcariaItems.registerBasic("empty_vial", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> HYLIASTRUM_VIAL = IcariaItems.registerBasic("hyliastrum_vial", () -> new HyliastrumVialItem(new Item.Properties()));

	public static final RegistryObject<Item> YELLOWSTONE_GEAR = IcariaItems.registerBasic("yellowstone_gear", () -> new GearItem(new Item.Properties().durability(256)));
	public static final RegistryObject<Item> SMALL_YELLOWSTONE_GEAR = IcariaItems.registerBasic("small_yellowstone_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> UNFIRED_LOAM_GEAR = IcariaItems.registerBasic("unfired_loam_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LOAM_GEAR = IcariaItems.registerBasic("loam_gear", () -> new GearItem(new Item.Properties().durability(512)));
	public static final RegistryObject<Item> SMALL_LOAM_GEAR = IcariaItems.registerBasic("small_loam_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VOIDSHALE_GEAR = IcariaItems.registerBasic("voidshale_gear", () -> new GearItem(new Item.Properties().durability(768)));
	public static final RegistryObject<Item> SMALL_VOIDSHALE_GEAR = IcariaItems.registerBasic("small_voidshale_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> VANADIUM_GEAR = IcariaItems.registerBasic("vanadium_gear", () -> new GearItem(new Item.Properties().durability(1024)));
	public static final RegistryObject<Item> SMALL_VANADIUM_GEAR = IcariaItems.registerBasic("small_vanadium_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BLUE_GEARFRAGMENT = IcariaItems.registerBasic("blue_gearfragment", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GREEN_GEARFRAGMENT = IcariaItems.registerBasic("green_gearfragment", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> YELLOW_GEARFRAGMENT = IcariaItems.registerBasic("yellow_gearfragment", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DAEDALIAN_GEAR = IcariaItems.registerBasic("daedalian_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SMALL_DAEDALIAN_GEAR = IcariaItems.registerBasic("small_daedalian_gear", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> AETERNAE_HIDE = IcariaItems.registerBasic("aeternae_hide", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SPELT_FLOUR = IcariaItems.registerBasic("spelt_flour", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SPELT_BREAD = IcariaItems.registerBasic("spelt_bread", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(5, 0.6F))));
	public static final RegistryObject<Item> VINEBERRIES = IcariaItems.registerBasic("vineberries", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(2, 0.0F))));
	public static final RegistryObject<Item> STRAWBERRIES = IcariaItems.registerBasic("strawberries", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(1, 0.3F))));
	public static final RegistryObject<Item> PHYSALIS = IcariaItems.registerBasic("physalis", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(2, 0.5F))));
	public static final RegistryObject<Item> LAUREL_CHERRY = IcariaItems.registerBasic("laurel_cherry", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(4, 0.3F))));
	public static final RegistryObject<Item> BLACK_OLIVES = IcariaItems.registerBasic("black_olives", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(2, 0.3F))));
	public static final RegistryObject<Item> GREEN_OLIVES = IcariaItems.registerBasic("green_olives", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(2, 0.3F))));
	public static final RegistryObject<Item> GARLIC = IcariaItems.registerBasic("garlic", () -> new Item(new Item.Properties().food(IcariaItems.foodProperties(1, 0.3F))));
	public static final RegistryObject<Item> ONION = IcariaItems.registerBasic("onion", () -> new ItemNameBlockItem(IcariaBlocks.ONION_CROP.get(), new Item.Properties().food(IcariaItems.foodProperties(1, 0.3F))));
	public static final RegistryObject<Item> RAW_AETERNAE_MEAT = IcariaItems.registerBasic("raw_aeternae_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeatEffect(3, 0.3F, MobEffects.HUNGER, 100, 0, 1.0F))));
	public static final RegistryObject<Item> COOKED_AETERNAE_MEAT = IcariaItems.registerBasic("cooked_aeternae_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeat(8, 0.8F))));
	public static final RegistryObject<Item> RAW_CATOBLEPAS_MEAT = IcariaItems.registerBasic("raw_catoblepas_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeat(2, 0.3F))));
	public static final RegistryObject<Item> COOKED_CATOBLEPAS_MEAT = IcariaItems.registerBasic("cooked_catoblepas_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeat(6, 0.8F))));
	public static final RegistryObject<Item> RAW_CERVER_MEAT = IcariaItems.registerBasic("raw_cerver_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeatEffect(2, 0.3F, MobEffects.WEAKNESS, 800, 0, 0.4F))));
	public static final RegistryObject<Item> COOKED_CERVER_MEAT = IcariaItems.registerBasic("cooked_cerver_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeat(5, 0.8F))));
	public static final RegistryObject<Item> RAW_SOW_MEAT = IcariaItems.registerBasic("raw_sow_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeatEffect(2, 0.3F, MobEffects.HUNGER, 400, 0, 1.0F))));
	public static final RegistryObject<Item> COOKED_SOW_MEAT = IcariaItems.registerBasic("cooked_sow_meat", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesMeat(5, 0.8F))));
	public static final RegistryObject<Item> MYRMEKE_SCALES = IcariaItems.registerBasic("myrmeke_scales", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SLUG_SCALES = IcariaItems.registerBasic("slug_scales", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SNULL_CREAM = IcariaItems.registerBasic("snull_cream", () -> new Item(new Item.Properties().food(IcariaItems.foodPropertiesSnullCream(3, 0.1F, MobEffects.HUNGER, 100, 0, 0.5F, MobEffects.CONFUSION, 200, 0, 0.5F))));
	public static final RegistryObject<Item> VINEGAR = IcariaItems.registerBasic("vinegar", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> UNFIRED_LOAM_BOWL = IcariaItems.registerBasic("unfired_loam_bowl", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LOAM_BOWL = IcariaItems.registerBasic("loam_bowl", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> FRUIT_SALAD = IcariaItems.registerBasic("fruit_salad", () -> new IcariaBowlFoodItem(new Item.Properties().stacksTo(1).food(IcariaItems.foodPropertiesEffect(7, 1.2F, MobEffects.HEAL, 1 ,0 ,1.0F))));
	public static final RegistryObject<Item> ONION_SOUP = IcariaItems.registerBasic("onion_soup", () -> new IcariaBowlFoodItem(new Item.Properties().stacksTo(1).food(IcariaItems.foodProperties(4, 1.0F))));
	public static final RegistryObject<Item> AETERNAE_STEW = IcariaItems.registerBasic("aeternae_stew", () -> new IcariaBowlFoodItem(new Item.Properties().stacksTo(1).food(IcariaItems.foodPropertiesMeat(9, 1.0F))));
	public static final RegistryObject<Item> CATOBLEPAS_STEW = IcariaItems.registerBasic("catoblepas_stew", () -> new IcariaBowlFoodItem(new Item.Properties().stacksTo(1).food(IcariaItems.foodPropertiesMeat(8, 1.0F))));
	public static final RegistryObject<Item> CERVER_STEW = IcariaItems.registerBasic("cerver_stew", () -> new IcariaBowlFoodItem(new Item.Properties().stacksTo(1).food(IcariaItems.foodPropertiesMeat(9, 1.0F))));
	public static final RegistryObject<Item> SOW_STEW = IcariaItems.registerBasic("sow_stew", () -> new IcariaBowlFoodItem(new Item.Properties().stacksTo(1).food(IcariaItems.foodPropertiesMeat(8, 1.0F))));

	public static final RegistryObject<Item> SPELT_SEEDS = IcariaItems.registerBasic("spelt_seeds", () -> new ItemNameBlockItem(IcariaBlocks.SPELT_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRAWBERRY_SEEDS = IcariaItems.registerBasic("strawberry_seeds", () -> new ItemNameBlockItem(IcariaBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> PHYSALIS_SEEDS = IcariaItems.registerBasic("physalis_seeds", () -> new ItemNameBlockItem(IcariaBlocks.PHYSALIS_CROP.get(), new Item.Properties()));

	public static final RegistryObject<Item> AETERNAE_SPAWN_EGG = IcariaItems.register("aeternae_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.AETERNAE, 0x40280B, 0x88581F, new Item.Properties()));
	public static final RegistryObject<Item> ARACHNE_SPAWN_EGG = IcariaItems.register("arachne_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.ARACHNE, 0x362E28, 0x6A8C97, new Item.Properties()));
	public static final RegistryObject<Item> ARACHNE_DRONE_SPAWN_EGG = IcariaItems.register("arachne_drone_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.ARACHNE_DRONE, 0x382F28, 0x6A8C97, new Item.Properties()));
	public static final RegistryObject<Item> ARGAN_HOUND_SPAWN_EGG = IcariaItems.register("argan_hound_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.ARGAN_HOUND, 0x0B0D0E, 0x2C2F36, new Item.Properties()));
	public static final RegistryObject<Item> CATOBLEPAS_SPAWN_EGG = IcariaItems.register("catoblepas_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CATOBLEPAS, 0x1D170E, 0x373024, new Item.Properties()));
	public static final RegistryObject<Item> CERVER_SPAWN_EGG = IcariaItems.register("cerver_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CERVER, 0x0E0A05, 0x302C26, new Item.Properties()));
	public static final RegistryObject<Item> CYPRESS_FOREST_HAG_SPAWN_EGG = IcariaItems.register("cypress_forest_hag_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CYPRESS_FOREST_HAG, 0x615A52, 0x4F6712, new Item.Properties()));
	public static final RegistryObject<Item> DROUGHTROOT_FOREST_HAG_SPAWN_EGG = IcariaItems.register("droughtroot_forest_hag_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG, 0x302A2D, 0x5A621A, new Item.Properties()));
	public static final RegistryObject<Item> FIR_FOREST_HAG_SPAWN_EGG = IcariaItems.register("fir_forest_hag_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.FIR_FOREST_HAG, 0x574C39, 0x356342, new Item.Properties()));
	public static final RegistryObject<Item> LAUREL_FOREST_HAG_SPAWN_EGG = IcariaItems.register("laurel_forest_hag_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.LAUREL_FOREST_HAG, 0x3D241A, 0x42551A, new Item.Properties()));
	public static final RegistryObject<Item> OLIVE_FOREST_HAG_SPAWN_EGG = IcariaItems.register("olive_forest_hag_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.OLIVE_FOREST_HAG, 0x697162, 0x817B32, new Item.Properties()));
	public static final RegistryObject<Item> PLANE_FOREST_HAG_SPAWN_EGG = IcariaItems.register("plane_forest_hag_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.PLANE_FOREST_HAG, 0x6F716D, 0x516C40, new Item.Properties()));
	public static final RegistryObject<Item> POPULUS_FOREST_HAG_SPAWN_EGG = IcariaItems.register("populus_forest_hag_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.POPULUS_FOREST_HAG, 0xdD0C9C7, 0x4B8360, new Item.Properties()));
	public static final RegistryObject<Item> HYLIASTER_SPAWN_EGG = IcariaItems.register("hyliaster_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.HYLIASTER, 0x040706, 0x8B9590, new Item.Properties()));
	public static final RegistryObject<Item> ENDER_JELLYFISH_SPAWN_EGG = IcariaItems.register("ender_jellyfish_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.ENDER_JELLYFISH, 0X000000, 0xE079FA, new Item.Properties()));
	public static final RegistryObject<Item> FIRE_JELLYFISH_SPAWN_EGG = IcariaItems.register("fire_jellyfish_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.FIRE_JELLYFISH, 0XF07D2A, 0xFFA531, new Item.Properties()));
	public static final RegistryObject<Item> NATURE_JELLYFISH_SPAWN_EGG = IcariaItems.register("nature_jellyfish_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.NATURE_JELLYFISH, 0X00B78B, 0x04FFAC, new Item.Properties()));
	public static final RegistryObject<Item> VOID_JELLYFISH_SPAWN_EGG = IcariaItems.register("void_jellyfish_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.VOID_JELLYFISH, 0X644D91, 0xA080E2, new Item.Properties()));
	public static final RegistryObject<Item> WATER_JELLYFISH_SPAWN_EGG = IcariaItems.register("water_jellyfish_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.WATER_JELLYFISH, 0X45A5BD, 0x5AECFE, new Item.Properties()));
	public static final RegistryObject<Item> MYRMEKE_DRONE_SPAWN_EGG = IcariaItems.register("myrmeke_drone_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.MYRMEKE_DRONE, 0x501814, 0x241E19, new Item.Properties()));
	public static final RegistryObject<Item> MYRMEKE_SOLDIER_SPAWN_EGG = IcariaItems.register("myrmeke_soldier_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.MYRMEKE_SOLDIER, 0x501814, 0x402816, new Item.Properties()));
	public static final RegistryObject<Item> MYRMEKE_QUEEN_SPAWN_EGG = IcariaItems.register("myrmeke_queen_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.MYRMEKE_QUEEN, 0x501814, 0xAB7E17, new Item.Properties()));
	public static final RegistryObject<Item> CAPTAIN_REVENANT_SPAWN_EGG = IcariaItems.register("captain_revenant_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CAPTAIN_REVENANT, 0xCFA919, 0x636363, new Item.Properties()));
	public static final RegistryObject<Item> CIVILIAN_REVENANT_SPAWN_EGG = IcariaItems.register("civilian_revenant_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CIVILIAN_REVENANT, 0x9C9C9C, 0x636363, new Item.Properties()));
	public static final RegistryObject<Item> CRAWLER_REVENANT_SPAWN_EGG = IcariaItems.register("crawler_revenant_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CRAWLER_REVENANT, 0x2D2D19, 0x636363, new Item.Properties()));
	public static final RegistryObject<Item> OVERGROWN_REVENANT_SPAWN_EGG = IcariaItems.register("overgrown_revenant_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.OVERGROWN_REVENANT, 0x535C32, 0x636363, new Item.Properties()));
	public static final RegistryObject<Item> PYROMANCER_REVENANT_SPAWN_EGG = IcariaItems.register("pyromancer_revenant_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.PYROMANCER_REVENANT, 0x3C5E26, 0x636363, new Item.Properties()));
	public static final RegistryObject<Item> NETHER_PYROMANCER_REVENANT_SPAWN_EGG = IcariaItems.register("nether_pyromancer_revenant_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT, 0x5A2017, 0x636363, new Item.Properties()));
	public static final RegistryObject<Item> SOLDIER_REVENANT_SPAWN_EGG = IcariaItems.register("soldier_revenant_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.SOLDIER_REVENANT, 0x6C5757, 0x636363, new Item.Properties()));
	public static final RegistryObject<Item> SCORPION_SPAWN_EGG = IcariaItems.register("scorpion_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.SCORPION, 0x513B24, 0xD8A161, new Item.Properties()));
	public static final RegistryObject<Item> CRYSTAL_SLUG_SPAWN_EGG = IcariaItems.register("crystal_slug_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.CRYSTAL_SLUG, 0x24141A, 0x653D48, new Item.Properties()));
	public static final RegistryObject<Item> FOREST_SNULL_SPAWN_EGG = IcariaItems.register("forest_snull_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.FOREST_SNULL, 0x291306, 0x53641E, new Item.Properties()));
	public static final RegistryObject<Item> SNULL_SPAWN_EGG = IcariaItems.register("snull_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.SNULL, 0x291306, 0x8D694F, new Item.Properties()));
	public static final RegistryObject<Item> SOLIFUGAE_SPAWN_EGG = IcariaItems.register("solifugae_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.SOLIFUGAE, 0xE0CDBC, 0x91673F, new Item.Properties()));
	public static final RegistryObject<Item> SOW_SPAWN_EGG = IcariaItems.register("sow_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.SOW, 0x231A13, 0x6E554B, new Item.Properties()));
	public static final RegistryObject<Item> VINEGAROON_SPAWN_EGG = IcariaItems.register("vinegaroon_spawn_egg", () -> new ForgeSpawnEggItem(IcariaEntityTypes.VINEGAROON, 0x382819, 0xC99559, new Item.Properties()));

	public static final RegistryObject<Item> MEDITERRANEAN_WATER_BUCKET = IcariaItems.registerBasic("mediterranean_water_bucket", () -> new BucketItem(IcariaFluids.MEDITERRANEAN_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static FoodProperties foodPropertiesVineSprout(int pNutrition, float pSaturation) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationMod(pSaturation).alwaysEat().build();
	}

	public static FoodProperties foodPropertiesEffect(int pNutrition, float pSaturation, MobEffect pEffect, int pDuration, int pAmplifier, float pProbability) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationMod(pSaturation).effect(() -> new MobEffectInstance(pEffect, pDuration, pAmplifier), pProbability).build();
	}

	public static FoodProperties foodProperties(int pNutrition, float pSaturation) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationMod(pSaturation).build();
	}

	public static FoodProperties foodPropertiesMeatEffect(int pNutrition, float pSaturation, MobEffect pEffect, int pDuration, int pAmplifier, float pProbability) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationMod(pSaturation).effect(() -> new MobEffectInstance(pEffect, pDuration, pAmplifier), pProbability).meat().build();
	}

	public static FoodProperties foodPropertiesMeat(int pNutrition, float pSaturation) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationMod(pSaturation).meat().build();
	}

	public static FoodProperties foodPropertiesSnullCream(int pNutrition, float pSaturation, MobEffect pEffectOne, int pDurationOne, int pAmplifierOne, float pProbabilityOne, MobEffect pEffectTwo, int pDurationTwo,int pAmplifierTwo, float pProbabilityTwo) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationMod(pSaturation).effect(() -> new MobEffectInstance(pEffectOne, pDurationOne, pAmplifierOne), pProbabilityOne).effect(() -> new MobEffectInstance(pEffectTwo, pDurationTwo, pAmplifierTwo), pProbabilityTwo).build();
	}

	public static <T extends Item> RegistryObject<T> register(String pName, Supplier<T> pSupplier) {
		return IcariaItems.ITEMS.register(pName, pSupplier);
	}

	public static <T extends Item> RegistryObject<T> registerBasic(String pName, Supplier<T> pSupplier) {
		RegistryObject<T> registryObject = IcariaItems.register(pName, pSupplier);
		IcariaItems.SIMPLE_ITEMS.add(registryObject);
		return registryObject;
	}
}
