package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.item.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaIdents.ID);

	public static final List<Supplier<? extends Item>> SIMPLE_ITEMS = new ArrayList<>();

	public static final Supplier<Item> GRASSY_MARL = IcariaItems.register("grassy_marl", () -> new BlockItem(IcariaBlocks.GRASSY_MARL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MARL = IcariaItems.register("marl", () -> new BlockItem(IcariaBlocks.MARL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MARL_CHERT = IcariaItems.register("marl_chert", () -> new BlockItem(IcariaBlocks.MARL_CHERT.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SURFACE_CHERT = IcariaItems.register("surface_chert", () -> new BlockItem(IcariaBlocks.SURFACE_CHERT.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MARL_BONES = IcariaItems.register("marl_bones", () -> new BlockItem(IcariaBlocks.MARL_BONES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SURFACE_BONES = IcariaItems.register("surface_bones", () -> new BlockItem(IcariaBlocks.SURFACE_BONES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MARL_LIGNITE = IcariaItems.register("marl_lignite", () -> new BlockItem(IcariaBlocks.MARL_LIGNITE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SURFACE_LIGNITE = IcariaItems.register("surface_lignite", () -> new BlockItem(IcariaBlocks.SURFACE_LIGNITE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> COARSE_MARL = IcariaItems.register("coarse_marl", () -> new BlockItem(IcariaBlocks.COARSE_MARL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DRY_LAKE_BED = IcariaItems.register("dry_lake_bed", () -> new BlockItem(IcariaBlocks.DRY_LAKE_BED.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> FARMLAND = IcariaItems.register("farmland", () -> new BlockItem(IcariaBlocks.FARMLAND.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FERTILIZED_FARMLAND = IcariaItems.register("fertilized_farmland", () -> new BlockItem(IcariaBlocks.FERTILIZED_FARMLAND.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> MARL_ADOBE = IcariaItems.register("marl_adobe", () -> new BlockItem(IcariaBlocks.MARL_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems MARL_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.MARL_ADOBE_DECO, IcariaItems.MARL_ADOBE);

	public static final Supplier<Item> LOAM = IcariaItems.register("loam", () -> new BlockItem(IcariaBlocks.LOAM.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOAM_BRICKS = IcariaItems.register("loam_bricks", () -> new BlockItem(IcariaBlocks.LOAM_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems LOAM_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.LOAM_BRICK_DECO, IcariaItems.LOAM_BRICKS);

	public static final Supplier<Item> DOLOMITE_ADOBE = IcariaItems.register("dolomite_adobe", () -> new BlockItem(IcariaBlocks.DOLOMITE_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems DOLOMITE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.DOLOMITE_ADOBE_DECO, IcariaItems.DOLOMITE_ADOBE);
	public static final Supplier<Item> SMOOTH_DOLOMITE = IcariaItems.register("smooth_dolomite", () -> new BlockItem(IcariaBlocks.SMOOTH_DOLOMITE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SMOOTH_DOLOMITE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SMOOTH_DOLOMITE_DECO, IcariaItems.SMOOTH_DOLOMITE);
	public static final Supplier<Item> DOLOMITE_BRICKS = IcariaItems.register("dolomite_bricks", () -> new BlockItem(IcariaBlocks.DOLOMITE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DOLOMITE_PILLAR = IcariaItems.register("dolomite_pillar", () -> new BlockItem(IcariaBlocks.DOLOMITE_PILLAR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DOLOMITE_PILLAR_HEAD = IcariaItems.register("dolomite_pillar_head", () -> new BlockItem(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> GRAINEL = IcariaItems.register("grainel", () -> new BlockItem(IcariaBlocks.GRAINEL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRAINEL_CHERT = IcariaItems.register("grainel_chert", () -> new BlockItem(IcariaBlocks.GRAINEL_CHERT.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRAINGLASS = IcariaItems.register("grainglass", () -> new BlockItem(IcariaBlocks.GRAINGLASS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRAINGLASS_PANE = IcariaItems.register("grainglass_pane", () -> new BlockItem(IcariaBlocks.GRAINGLASS_PANE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> HORIZONTAL_GRAINGLASS_PANE = IcariaItems.register("horizontal_grainglass_pane", () -> new BlockItem(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRAINITE_ADOBE = IcariaItems.register("grainite_adobe", () -> new BlockItem(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems GRAINITE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.GRAINITE_ADOBE_DECO, IcariaItems.GRAINITE_ADOBE);
	public static final Supplier<Item> GRAINITE = IcariaItems.register("grainite", () -> new BlockItem(IcariaBlocks.GRAINITE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems GRAINITE_DECO = new IcariaStoneDecoItems(IcariaBlocks.GRAINITE_DECO, IcariaItems.GRAINITE);
	public static final Supplier<Item> GRAINITE_BRICKS = IcariaItems.register("grainite_bricks", () -> new BlockItem(IcariaBlocks.GRAINITE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems GRAINITE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.GRAINITE_BRICK_DECO, IcariaItems.GRAINITE_BRICKS);
	public static final Supplier<Item> CHISELED_GRAINITE = IcariaItems.register("chiseled_grainite", () -> new BlockItem(IcariaBlocks.CHISELED_GRAINITE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRAINITE_RUBBLE = IcariaItems.register("grainite_rubble", () -> new BlockItem(IcariaBlocks.GRAINITE_RUBBLE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> YELLOWSTONE_ADOBE = IcariaItems.register("yellowstone_adobe", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems YELLOWSTONE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.YELLOWSTONE_ADOBE_DECO, IcariaItems.YELLOWSTONE_ADOBE);
	public static final Supplier<Item> COBBLED_YELLOWSTONE = IcariaItems.register("cobbled_yellowstone", () -> new BlockItem(IcariaBlocks.COBBLED_YELLOWSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems COBBLED_YELLOWSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_YELLOWSTONE_DECO, IcariaItems.COBBLED_YELLOWSTONE);
	public static final Supplier<Item> YELLOWSTONE = IcariaItems.register("yellowstone", () -> new BlockItem(IcariaBlocks.YELLOWSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems YELLOWSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.YELLOWSTONE_DECO, IcariaItems.YELLOWSTONE);
	public static final Supplier<Item> YELLOWSTONE_BRICKS = IcariaItems.register("yellowstone_bricks", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems YELLOWSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.YELLOWSTONE_BRICK_DECO, IcariaItems.YELLOWSTONE_BRICKS);
	public static final Supplier<Item> CHISELED_YELLOWSTONE = IcariaItems.register("chiseled_yellowstone", () -> new BlockItem(IcariaBlocks.CHISELED_YELLOWSTONE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> YELLOWSTONE_RUBBLE = IcariaItems.register("yellowstone_rubble", () -> new BlockItem(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> SILKSAND = IcariaItems.register("silksand", () -> new BlockItem(IcariaBlocks.SILKSAND.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SILKGLASS = IcariaItems.register("silkglass", () -> new BlockItem(IcariaBlocks.SILKGLASS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SILKGLASS_PANE = IcariaItems.register("silkglass_pane", () -> new BlockItem(IcariaBlocks.SILKGLASS_PANE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> HORIZONTAL_SILKGLASS_PANE = IcariaItems.register("horizontal_silkglass_pane", () -> new BlockItem(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SILKSTONE_ADOBE = IcariaItems.register("silkstone_adobe", () -> new BlockItem(IcariaBlocks.SILKSTONE_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SILKSTONE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SILKSTONE_ADOBE_DECO, IcariaItems.SILKSTONE_ADOBE);
	public static final Supplier<Item> COBBLED_SILKSTONE = IcariaItems.register("cobbled_silkstone", () -> new BlockItem(IcariaBlocks.COBBLED_SILKSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems COBBLED_SILKSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_SILKSTONE_DECO, IcariaItems.COBBLED_SILKSTONE);
	public static final Supplier<Item> SILKSTONE = IcariaItems.register("silkstone", () -> new BlockItem(IcariaBlocks.SILKSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SILKSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SILKSTONE_DECO, IcariaItems.SILKSTONE);
	public static final Supplier<Item> SILKSTONE_BRICKS = IcariaItems.register("silkstone_bricks", () -> new BlockItem(IcariaBlocks.SILKSTONE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SILKSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.SILKSTONE_BRICK_DECO, IcariaItems.SILKSTONE_BRICKS);
	public static final Supplier<Item> CHISELED_SILKSTONE = IcariaItems.register("chiseled_silkstone", () -> new BlockItem(IcariaBlocks.CHISELED_SILKSTONE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SILKSTONE_RUBBLE = IcariaItems.register("silkstone_rubble", () -> new BlockItem(IcariaBlocks.SILKSTONE_RUBBLE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> SUNSTONE_ADOBE = IcariaItems.register("sunstone_adobe", () -> new BlockItem(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SUNSTONE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SUNSTONE_ADOBE_DECO, IcariaItems.SUNSTONE_ADOBE);
	public static final Supplier<Item> COBBLED_SUNSTONE = IcariaItems.register("cobbled_sunstone", () -> new BlockItem(IcariaBlocks.COBBLED_SUNSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems COBBLED_SUNSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_SUNSTONE_DECO, IcariaItems.COBBLED_SUNSTONE);
	public static final Supplier<Item> SUNSTONE = IcariaItems.register("sunstone", () -> new BlockItem(IcariaBlocks.SUNSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SUNSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SUNSTONE_DECO, IcariaItems.SUNSTONE);
	public static final Supplier<Item> SUNSTONE_BRICKS = IcariaItems.register("sunstone_bricks", () -> new BlockItem(IcariaBlocks.SUNSTONE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SUNSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.SUNSTONE_BRICK_DECO, IcariaItems.SUNSTONE_BRICKS);
	public static final Supplier<Item> CHISELED_SUNSTONE = IcariaItems.register("chiseled_sunstone", () -> new BlockItem(IcariaBlocks.CHISELED_SUNSTONE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SUNSTONE_RUBBLE = IcariaItems.register("sunstone_rubble", () -> new BlockItem(IcariaBlocks.SUNSTONE_RUBBLE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> VOIDSHALE_ADOBE = IcariaItems.register("voidshale_adobe", () -> new BlockItem(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems VOIDSHALE_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.VOIDSHALE_ADOBE_DECO, IcariaItems.VOIDSHALE_ADOBE);
	public static final Supplier<Item> COBBLED_VOIDSHALE = IcariaItems.register("cobbled_voidshale", () -> new BlockItem(IcariaBlocks.COBBLED_VOIDSHALE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems COBBLED_VOIDSHALE_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_VOIDSHALE_DECO, IcariaItems.COBBLED_VOIDSHALE);
	public static final Supplier<Item> VOIDSHALE = IcariaItems.register("voidshale", () -> new BlockItem(IcariaBlocks.VOIDSHALE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems VOIDSHALE_DECO = new IcariaStoneDecoItems(IcariaBlocks.VOIDSHALE_DECO, IcariaItems.VOIDSHALE);
	public static final Supplier<Item> VOIDSHALE_BRICKS = IcariaItems.register("voidshale_bricks", () -> new BlockItem(IcariaBlocks.VOIDSHALE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems VOIDSHALE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.VOIDSHALE_BRICK_DECO, IcariaItems.VOIDSHALE_BRICKS);
	public static final Supplier<Item> CHISELED_VOIDSHALE = IcariaItems.register("chiseled_voidshale", () -> new BlockItem(IcariaBlocks.CHISELED_VOIDSHALE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> VOIDSHALE_RUBBLE = IcariaItems.register("voidshale_rubble", () -> new BlockItem(IcariaBlocks.VOIDSHALE_RUBBLE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> BAETYL_ADOBE = IcariaItems.register("baetyl_adobe", () -> new BlockItem(IcariaBlocks.BAETYL_ADOBE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems BAETYL_ADOBE_DECO = new IcariaStoneDecoItems(IcariaBlocks.BAETYL_ADOBE_DECO, IcariaItems.BAETYL_ADOBE);
	public static final Supplier<Item> COBBLED_BAETYL = IcariaItems.register("cobbled_baetyl", () -> new BlockItem(IcariaBlocks.COBBLED_BAETYL.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems COBBLED_BAETYL_DECO = new IcariaStoneDecoItems(IcariaBlocks.COBBLED_BAETYL_DECO, IcariaItems.COBBLED_BAETYL);
	public static final Supplier<Item> BAETYL = IcariaItems.register("baetyl", () -> new BlockItem(IcariaBlocks.BAETYL.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems BAETYL_DECO = new IcariaStoneDecoItems(IcariaBlocks.BAETYL_DECO, IcariaItems.BAETYL);
	public static final Supplier<Item> BAETYL_BRICKS = IcariaItems.register("baetyl_bricks", () -> new BlockItem(IcariaBlocks.BAETYL_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems BAETYL_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.BAETYL_BRICK_DECO, IcariaItems.BAETYL_BRICKS);
	public static final Supplier<Item> CHISELED_BAETYL = IcariaItems.register("chiseled_baetyl", () -> new BlockItem(IcariaBlocks.CHISELED_BAETYL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BAETYL_RUBBLE = IcariaItems.register("baetyl_rubble", () -> new BlockItem(IcariaBlocks.BAETYL_RUBBLE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> RELICSTONE = IcariaItems.register("relicstone", () -> new BlockItem(IcariaBlocks.RELICSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems RELICSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.RELICSTONE_DECO, IcariaItems.RELICSTONE);
	public static final Supplier<Item> SMOOTH_RELICSTONE = IcariaItems.register("smooth_relicstone", () -> new BlockItem(IcariaBlocks.SMOOTH_RELICSTONE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems SMOOTH_RELICSTONE_DECO = new IcariaStoneDecoItems(IcariaBlocks.SMOOTH_RELICSTONE_DECO, IcariaItems.SMOOTH_RELICSTONE);
	public static final Supplier<Item> RELICSTONE_BRICKS = IcariaItems.register("relicstone_bricks", () -> new BlockItem(IcariaBlocks.RELICSTONE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems RELICSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.RELICSTONE_BRICK_DECO, IcariaItems.RELICSTONE_BRICKS);
	public static final Supplier<Item> CRACKED_RELICSTONE_BRICKS = IcariaItems.register("cracked_relicstone_bricks", () -> new BlockItem(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems CRACKED_RELICSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO, IcariaItems.CRACKED_RELICSTONE_BRICKS);
	public static final Supplier<Item> MOSSY_RELICSTONE_BRICKS = IcariaItems.register("mossy_relicstone_bricks", () -> new BlockItem(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems MOSSY_RELICSTONE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO, IcariaItems.MOSSY_RELICSTONE_BRICKS);
	public static final Supplier<Item> RELICSTONE_TILES = IcariaItems.register("relicstone_tiles", () -> new BlockItem(IcariaBlocks.RELICSTONE_TILES.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems RELICSTONE_TILE_DECO = new IcariaStoneDecoItems(IcariaBlocks.RELICSTONE_TILE_DECO, IcariaItems.RELICSTONE_TILES);
	public static final Supplier<Item> CRACKED_RELICSTONE_TILES = IcariaItems.register("cracked_relicstone_tiles", () -> new BlockItem(IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems CRACKED_RELICSTONE_TILE_DECO = new IcariaStoneDecoItems(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO, IcariaItems.CRACKED_RELICSTONE_TILES);
	public static final Supplier<Item> MOSSY_RELICSTONE_TILES = IcariaItems.register("mossy_relicstone_tiles", () -> new BlockItem(IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems MOSSY_RELICSTONE_TILE_DECO = new IcariaStoneDecoItems(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO, IcariaItems.MOSSY_RELICSTONE_TILES);
	public static final Supplier<Item> CHISELED_RELICSTONE = IcariaItems.register("chiseled_relicstone", () -> new BlockItem(IcariaBlocks.CHISELED_RELICSTONE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RELICSTONE_PILLAR = IcariaItems.register("relicstone_pillar", () -> new BlockItem(IcariaBlocks.RELICSTONE_PILLAR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RELICSTONE_PILLAR_HEAD = IcariaItems.register("relicstone_pillar_head", () -> new BlockItem(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RELICSTONE_RUBBLE = IcariaItems.register("relicstone_rubble", () -> new BlockItem(IcariaBlocks.RELICSTONE_RUBBLE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> PLATOSHALE = IcariaItems.register("platoshale", () -> new BlockItem(IcariaBlocks.PLATOSHALE.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems PLATOSHALE_DECO = new IcariaStoneDecoItems(IcariaBlocks.PLATOSHALE_DECO, IcariaItems.PLATOSHALE);
	public static final Supplier<Item> BLURRED_PLATOSHALE = IcariaItems.register("blurred_platoshale", () -> new BlockItem(IcariaBlocks.BLURRED_PLATOSHALE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLATOSHALE_BRICKS = IcariaItems.register("platoshale_bricks", () -> new BlockItem(IcariaBlocks.PLATOSHALE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaStoneDecoItems PLATOSHALE_BRICK_DECO = new IcariaStoneDecoItems(IcariaBlocks.PLATOSHALE_BRICK_DECO, IcariaItems.PLATOSHALE_BRICKS);
	public static final Supplier<Item> BLURRED_PLATOSHALE_BRICKS = IcariaItems.register("blurred_platoshale_bricks", () -> new BlockItem(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CHISELED_PLATOSHALE = IcariaItems.register("chiseled_platoshale", () -> new BlockItem(IcariaBlocks.CHISELED_PLATOSHALE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> QUARTZ_PILLAR_HEAD = IcariaItems.register("quartz_pillar_head", () -> new BlockItem(IcariaBlocks.QUARTZ_PILLAR_HEAD.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> LIGNITE_ORE = IcariaItems.register("lignite_ore", () -> new BlockItem(IcariaBlocks.LIGNITE_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CHALKOS_ORE = IcariaItems.register("chalkos_ore", () -> new BlockItem(IcariaBlocks.CHALKOS_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> KASSITEROS_ORE = IcariaItems.register("kassiteros_ore", () -> new BlockItem(IcariaBlocks.KASSITEROS_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DOLOMITE_ORE = IcariaItems.register("dolomite_ore", () -> new BlockItem(IcariaBlocks.DOLOMITE_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> VANADIUM_ORE = IcariaItems.register("vanadium_ore", () -> new BlockItem(IcariaBlocks.VANADIUM_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SLIVER_ORE = IcariaItems.register("sliver_ore", () -> new BlockItem(IcariaBlocks.SLIVER_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SIDEROS_ORE = IcariaItems.register("sideros_ore", () -> new BlockItem(IcariaBlocks.SIDEROS_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ANTHRACITE_ORE = IcariaItems.register("anthracite_ore", () -> new BlockItem(IcariaBlocks.ANTHRACITE_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOLYBDENUM_ORE = IcariaItems.register("molybdenum_ore", () -> new BlockItem(IcariaBlocks.MOLYBDENUM_ORE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> HYLIASTRUM_ORE = IcariaItems.register("hyliastrum_ore", () -> new BlockItem(IcariaBlocks.HYLIASTRUM_ORE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> CALCITE = IcariaItems.register("calcite", () -> new BlockItem(IcariaBlocks.CALCITE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BUDDING_CALCITE = IcariaItems.register("budding_calcite", () -> new BlockItem(IcariaBlocks.BUDDING_CALCITE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> HALITE = IcariaItems.register("halite", () -> new BlockItem(IcariaBlocks.HALITE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BUDDING_HALITE = IcariaItems.register("budding_halite", () -> new BlockItem(IcariaBlocks.BUDDING_HALITE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> JASPER = IcariaItems.register("jasper", () -> new BlockItem(IcariaBlocks.JASPER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BUDDING_JASPER = IcariaItems.register("budding_jasper", () -> new BlockItem(IcariaBlocks.BUDDING_JASPER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ZIRCON = IcariaItems.register("zircon", () -> new BlockItem(IcariaBlocks.ZIRCON.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BUDDING_ZIRCON = IcariaItems.register("budding_zircon", () -> new BlockItem(IcariaBlocks.BUDDING_ZIRCON.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> CALCITE_CRYSTAL = IcariaItems.register("calcite_crystal", () -> new BlockItem(IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> HALITE_CRYSTAL = IcariaItems.register("halite_crystal", () -> new BlockItem(IcariaBlocks.HALITE_CRYSTAL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> JASPER_CRYSTAL = IcariaItems.register("jasper_crystal", () -> new BlockItem(IcariaBlocks.JASPER_CRYSTAL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ZIRCON_CRYSTAL = IcariaItems.register("zircon_crystal", () -> new BlockItem(IcariaBlocks.ZIRCON_CRYSTAL.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> ARISTONE = IcariaItems.register("aristone", () -> new BlockItem(IcariaBlocks.ARISTONE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PACKED_ARISTONE = IcariaItems.register("packed_aristone", () -> new BlockItem(IcariaBlocks.PACKED_ARISTONE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> ENDER_JELLYFISH_JELLY_BLOCK = IcariaItems.register("ender_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIRE_JELLYFISH_JELLY_BLOCK = IcariaItems.register("fire_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> NATURE_JELLYFISH_JELLY_BLOCK = IcariaItems.register("nature_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> VOID_JELLYFISH_JELLY_BLOCK = IcariaItems.register("void_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> WATER_JELLYFISH_JELLY_BLOCK = IcariaItems.register("water_jellyfish_jelly_block", () -> new BlockItem(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ARACHNE_STRING_BLOCK = IcariaItems.register("arachne_string_block", () -> new BlockItem(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SPELT_BALE_BLOCK = IcariaItems.register("spelt_bale_block", () -> new BlockItem(IcariaBlocks.SPELT_BALE_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> VINE_REED_BLOCK = IcariaItems.register("vine_reed_block", () -> new BlockItem(IcariaBlocks.VINE_REED_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ROTTEN_BONES_BLOCK = IcariaItems.register("rotten_bones_block", () -> new BlockItem(IcariaBlocks.ROTTEN_BONES_BLOCK.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> RAW_CHALKOS_BLOCK = IcariaItems.register("raw_chalkos_block", () -> new BlockItem(IcariaBlocks.RAW_CHALKOS_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_KASSITEROS_BLOCK = IcariaItems.register("raw_kassiteros_block", () -> new BlockItem(IcariaBlocks.RAW_KASSITEROS_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_VANADIUM_BLOCK = IcariaItems.register("raw_vanadium_block", () -> new BlockItem(IcariaBlocks.RAW_VANADIUM_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_SIDEROS_BLOCK = IcariaItems.register("raw_sideros_block", () -> new BlockItem(IcariaBlocks.RAW_SIDEROS_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_MOLYBDENUM_BLOCK = IcariaItems.register("raw_molybdenum_block", () -> new BlockItem(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> CALCITE_BLOCK = IcariaItems.register("calcite_block", () -> new BlockItem(IcariaBlocks.CALCITE_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> HALITE_BLOCK = IcariaItems.register("halite_block", () -> new BlockItem(IcariaBlocks.HALITE_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> JASPER_BLOCK = IcariaItems.register("jasper_block", () -> new BlockItem(IcariaBlocks.JASPER_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ZIRCON_BLOCK = IcariaItems.register("zircon_block", () -> new BlockItem(IcariaBlocks.ZIRCON_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CHERT_BLOCK = IcariaItems.register("chert_block", () -> new BlockItem(IcariaBlocks.CHERT_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIGNITE_BLOCK = IcariaItems.register("lignite_block", () -> new BlockItem(IcariaBlocks.LIGNITE_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CHALKOS_BLOCK = IcariaItems.register("chalkos_block", () -> new BlockItem(IcariaBlocks.CHALKOS_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> KASSITEROS_BLOCK = IcariaItems.register("kassiteros_block", () -> new BlockItem(IcariaBlocks.KASSITEROS_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ORICHALCUM_BLOCK = IcariaItems.register("orichalcum_block", () -> new BlockItem(IcariaBlocks.ORICHALCUM_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> VANADIUM_BLOCK = IcariaItems.register("vanadium_block", () -> new BlockItem(IcariaBlocks.VANADIUM_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SLIVER_BLOCK = IcariaItems.register("sliver_block", () -> new BlockItem(IcariaBlocks.SLIVER_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> VANADIUMSTEEL_BLOCK = IcariaItems.register("vanadiumsteel_block", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SIDEROS_BLOCK = IcariaItems.register("sideros_block", () -> new BlockItem(IcariaBlocks.SIDEROS_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ANTHRACITE_BLOCK = IcariaItems.register("anthracite_block", () -> new BlockItem(IcariaBlocks.ANTHRACITE_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOLYBDENUM_BLOCK = IcariaItems.register("molybdenum_block", () -> new BlockItem(IcariaBlocks.MOLYBDENUM_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOLYBDENUMSTEEL_BLOCK = IcariaItems.register("molybdenumsteel_block", () -> new BlockItem(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLURIDIUM_BLOCK = IcariaItems.register("bluridium_block", () -> new BlockItem(IcariaBlocks.BLURIDIUM_BLOCK.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> VANADIUMSTEEL_BARS = IcariaItems.register("vanadiumsteel_bars", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_BARS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> HORIZONTAL_VANADIUMSTEEL_BARS = IcariaItems.register("horizontal_vanadiumsteel_bars", () -> new BlockItem(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> VANADIUMSTEEL_CHAIN = IcariaItems.registerSimple("vanadiumsteel_chain", () -> new BlockItem(IcariaBlocks.VANADIUMSTEEL_CHAIN.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> KETTLE = IcariaItems.register("kettle", () -> new BlockItem(IcariaBlocks.KETTLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRINDER = IcariaItems.register("grinder", () -> new BlockItem(IcariaBlocks.GRINDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> KILN = IcariaItems.register("kiln", () -> new BlockItem(IcariaBlocks.KILN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FORGE = IcariaItems.register("forge", () -> new BlockItem(IcariaBlocks.FORGE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> CHEST = IcariaItems.register("chest", () -> new IcariaChestItem(IcariaBlocks.CHEST.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRAPPED_CHEST = IcariaItems.register("trapped_chest", () -> new IcariaChestItem(IcariaBlocks.TRAPPED_CHEST.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> STORAGE_VASE = IcariaItems.register("storage_vase", () -> new BlockItem(IcariaBlocks.STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> WHITE_STORAGE_VASE = IcariaItems.register("white_storage_vase", () -> new BlockItem(IcariaBlocks.WHITE_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIGHT_GRAY_STORAGE_VASE = IcariaItems.register("light_gray_storage_vase", () -> new BlockItem(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRAY_STORAGE_VASE = IcariaItems.register("gray_storage_vase", () -> new BlockItem(IcariaBlocks.GRAY_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLACK_STORAGE_VASE = IcariaItems.register("black_storage_vase", () -> new BlockItem(IcariaBlocks.BLACK_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BROWN_STORAGE_VASE = IcariaItems.register("brown_storage_vase", () -> new BlockItem(IcariaBlocks.BROWN_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RED_STORAGE_VASE = IcariaItems.register("red_storage_vase", () -> new BlockItem(IcariaBlocks.RED_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ORANGE_STORAGE_VASE = IcariaItems.register("orange_storage_vase", () -> new BlockItem(IcariaBlocks.ORANGE_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> YELLOW_STORAGE_VASE = IcariaItems.register("yellow_storage_vase", () -> new BlockItem(IcariaBlocks.YELLOW_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIME_STORAGE_VASE = IcariaItems.register("lime_storage_vase", () -> new BlockItem(IcariaBlocks.LIME_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GREEN_STORAGE_VASE = IcariaItems.register("green_storage_vase", () -> new BlockItem(IcariaBlocks.GREEN_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYAN_STORAGE_VASE = IcariaItems.register("cyan_storage_vase", () -> new BlockItem(IcariaBlocks.CYAN_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIGHT_BLUE_STORAGE_VASE = IcariaItems.register("light_blue_storage_vase", () -> new BlockItem(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLUE_STORAGE_VASE = IcariaItems.register("blue_storage_vase", () -> new BlockItem(IcariaBlocks.BLUE_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PURPLE_STORAGE_VASE = IcariaItems.register("purple_storage_vase", () -> new BlockItem(IcariaBlocks.PURPLE_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MAGENTA_STORAGE_VASE = IcariaItems.register("magenta_storage_vase", () -> new BlockItem(IcariaBlocks.MAGENTA_STORAGE_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PINK_STORAGE_VASE = IcariaItems.register("pink_storage_vase", () -> new BlockItem(IcariaBlocks.PINK_STORAGE_VASE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> RED_LOOT_VASE = IcariaItems.register("red_loot_vase", () -> new BlockItem(IcariaBlocks.RED_LOOT_VASE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYAN_LOOT_VASE = IcariaItems.register("cyan_loot_vase", () -> new BlockItem(IcariaBlocks.CYAN_LOOT_VASE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> ARACHNE_SPAWNER = IcariaItems.register("arachne_spawner", () -> new BlockItem(IcariaBlocks.ARACHNE_SPAWNER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> REVENANT_SPAWNER = IcariaItems.register("revenant_spawner", () -> new BlockItem(IcariaBlocks.REVENANT_SPAWNER.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> AETERNAE_SKULL = IcariaItems.register("aeternae_skull", () -> new IcariaSkullItem(IcariaBlocks.AETERNAE_SKULL.get(), IcariaBlocks.AETERNAE_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> ARGAN_HOUND_SKULL = IcariaItems.register("argan_hound_skull", () -> new IcariaSkullItem(IcariaBlocks.ARGAN_HOUND_SKULL.get(), IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> CATOBLEPAS_SKULL = IcariaItems.register("catoblepas_skull", () -> new IcariaSkullItem(IcariaBlocks.CATOBLEPAS_SKULL.get(), IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> CERVER_SKULL = IcariaItems.register("cerver_skull", () -> new IcariaSkullItem(IcariaBlocks.CERVER_SKULL.get(), IcariaBlocks.CERVER_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> CYPRESS_FOREST_HAG_SKULL = IcariaItems.register("cypress_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get(), IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> DROUGHTROOT_FOREST_HAG_SKULL = IcariaItems.register("droughtroot_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get(), IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> FIR_FOREST_HAG_SKULL = IcariaItems.register("fir_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.FIR_FOREST_HAG_SKULL.get(), IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> LAUREL_FOREST_HAG_SKULL = IcariaItems.register("laurel_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get(), IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> OLIVE_FOREST_HAG_SKULL = IcariaItems.register("olive_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get(), IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> PLANE_FOREST_HAG_SKULL = IcariaItems.register("plane_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get(), IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> POPULUS_FOREST_HAG_SKULL = IcariaItems.register("populus_forest_hag_skull", () -> new IcariaSkullItem(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get(), IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> REVENANT_SKULL = IcariaItems.register("revenant_skull", () -> new IcariaSkullItem(IcariaBlocks.REVENANT_SKULL.get(), IcariaBlocks.REVENANT_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));
	public static final Supplier<Item> SOW_SKULL = IcariaItems.register("sow_skull", () -> new IcariaSkullItem(IcariaBlocks.SOW_SKULL.get(), IcariaBlocks.SOW_WALL_SKULL.get(), IcariaItems.propertiesItem(Rarity.UNCOMMON), Direction.DOWN));

	public static final Supplier<Item> LIGNITE_TORCH = IcariaItems.registerSimple("lignite_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.LIGNITE_TORCH.get(), IcariaBlocks.LIGNITE_WALL_TORCH.get(), IcariaItems.propertiesItem(), Direction.DOWN));
	public static final Supplier<Item> ANTHRACITE_TORCH = IcariaItems.registerSimple("anthracite_torch", () -> new StandingAndWallBlockItem(IcariaBlocks.ANTHRACITE_TORCH.get(), IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), IcariaItems.propertiesItem(), Direction.DOWN));

	public static final Supplier<Item> LAUREL_CHERRY_CAKE = IcariaItems.registerSimple("laurel_cherry_cake", () -> new BlockItem(IcariaBlocks.LAUREL_CHERRY_CAKE.get(), IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> STRAWBERRY_CAKE = IcariaItems.registerSimple("strawberry_cake", () -> new BlockItem(IcariaBlocks.STRAWBERRY_CAKE.get(), IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> PHYSALIS_CAKE = IcariaItems.registerSimple("physalis_cake", () -> new BlockItem(IcariaBlocks.PHYSALIS_CAKE.get(), IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> VINE_BERRY_CAKE = IcariaItems.registerSimple("vine_berry_cake", () -> new BlockItem(IcariaBlocks.VINE_BERRY_CAKE.get(), IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> VINE_SPROUT_CAKE = IcariaItems.registerSimple("vine_sprout_cake", () -> new BlockItem(IcariaBlocks.VINE_SPROUT_CAKE.get(), IcariaItems.propertiesItem(1)));

	public static final Supplier<Item> CYPRESS_SAPLING = IcariaItems.register("cypress_sapling", () -> new BlockItem(IcariaBlocks.CYPRESS_SAPLING.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_LEAVES = IcariaItems.register("cypress_leaves", () -> new BlockItem(IcariaBlocks.CYPRESS_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FALLEN_CYPRESS_LEAVES = IcariaItems.register("fallen_cypress_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_TWIGS = IcariaItems.register("cypress_twigs", () -> new BlockItem(IcariaBlocks.CYPRESS_TWIGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_WOOD = IcariaItems.register("cypress_wood", () -> new BlockItem(IcariaBlocks.CYPRESS_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_CYPRESS_WOOD = IcariaItems.register("stripped_cypress_wood", () -> new BlockItem(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_LOG = IcariaItems.register("cypress_log", () -> new BlockItem(IcariaBlocks.CYPRESS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_CYPRESS_LOG = IcariaItems.register("stripped_cypress_log", () -> new BlockItem(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DEAD_CYPRESS_LOG = IcariaItems.register("dead_cypress_log", () -> new BlockItem(IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DEAD_CYPRESS_LOG = IcariaItems.register("stripped_dead_cypress_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_PLANKS = IcariaItems.register("cypress_planks", () -> new BlockItem(IcariaBlocks.CYPRESS_PLANKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaWoodDecoItems CYPRESS_DECO = new IcariaWoodDecoItems(IcariaBlocks.CYPRESS_DECO, IcariaItems.CYPRESS_PLANKS);
	public static final Supplier<Item> SIMPLE_CYPRESS_RACK = IcariaItems.register("simple_cypress_rack", () -> new BlockItem(IcariaBlocks.SIMPLE_CYPRESS_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_RACK = IcariaItems.register("cypress_rack", () -> new BlockItem(IcariaBlocks.CYPRESS_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_BARREL = IcariaItems.register("cypress_barrel", () -> new BlockItem(IcariaBlocks.CYPRESS_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOADED_CYPRESS_BARREL = IcariaItems.register("loaded_cypress_barrel", () -> new BlockItem(IcariaBlocks.LOADED_CYPRESS_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TAPPED_CYPRESS_BARREL = IcariaItems.register("tapped_cypress_barrel", () -> new BlockItem(IcariaBlocks.TAPPED_CYPRESS_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRIPLE_CYPRESS_BARREL_RACK = IcariaItems.register("triple_cypress_barrel_rack", () -> new BlockItem(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_TROUGH = IcariaItems.register("cypress_trough", () -> new BlockItem(IcariaBlocks.CYPRESS_TROUGH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_CRAFTING_TABLE = IcariaItems.register("cypress_crafting_table", () -> new BlockItem(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_DOOR = IcariaItems.registerSimple("cypress_door", () -> new BlockItem(IcariaBlocks.CYPRESS_DOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_TRAPDOOR = IcariaItems.register("cypress_trapdoor", () -> new BlockItem(IcariaBlocks.CYPRESS_TRAPDOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_LADDER = IcariaItems.registerSimple("cypress_ladder", () -> new BlockItem(IcariaBlocks.CYPRESS_LADDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_SIGN = IcariaItems.registerSimple("cypress_sign", () -> new IcariaSignItem(IcariaItems.propertiesItem(16), IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_WALL_SIGN.get()));
	public static final Supplier<Item> CYPRESS_HANGING_SIGN = IcariaItems.registerSimple("cypress_hanging_sign", () -> new HangingSignItem(IcariaBlocks.CYPRESS_HANGING_SIGN.get(), IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), IcariaItems.propertiesItem(16)));

	public static final Supplier<Item> DROUGHTROOT_SAPLING = IcariaItems.register("droughtroot_sapling", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_SAPLING.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_LEAVES = IcariaItems.register("droughtroot_leaves", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FALLEN_DROUGHTROOT_LEAVES = IcariaItems.register("fallen_droughtroot_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_TWIGS = IcariaItems.register("droughtroot_twigs", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_TWIGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_WOOD = IcariaItems.register("droughtroot_wood", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DROUGHTROOT_WOOD = IcariaItems.register("stripped_droughtroot_wood", () -> new BlockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_LOG = IcariaItems.register("droughtroot_log", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DROUGHTROOT_LOG = IcariaItems.register("stripped_droughtroot_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DEAD_DROUGHTROOT_LOG = IcariaItems.register("dead_droughtroot_log", () -> new BlockItem(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DEAD_DROUGHTROOT_LOG = IcariaItems.register("stripped_dead_droughtroot_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_PLANKS = IcariaItems.register("droughtroot_planks", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_PLANKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaWoodDecoItems DROUGHTROOT_DECO = new IcariaWoodDecoItems(IcariaBlocks.DROUGHTROOT_DECO, IcariaItems.DROUGHTROOT_PLANKS);
	public static final Supplier<Item> SIMPLE_DROUGHTROOT_RACK = IcariaItems.register("simple_droughtroot_rack", () -> new BlockItem(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_RACK = IcariaItems.register("droughtroot_rack", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_BARREL = IcariaItems.register("droughtroot_barrel", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOADED_DROUGHTROOT_BARREL = IcariaItems.register("loaded_droughtroot_barrel", () -> new BlockItem(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TAPPED_DROUGHTROOT_BARREL = IcariaItems.register("tapped_droughtroot_barrel", () -> new BlockItem(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRIPLE_DROUGHTROOT_BARREL_RACK = IcariaItems.register("triple_droughtroot_barrel_rack", () -> new BlockItem(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_TROUGH = IcariaItems.register("droughtroot_trough", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_TROUGH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_CRAFTING_TABLE = IcariaItems.register("droughtroot_crafting_table", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_DOOR = IcariaItems.registerSimple("droughtroot_door", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_DOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_TRAPDOOR = IcariaItems.register("droughtroot_trapdoor", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_LADDER = IcariaItems.registerSimple("droughtroot_ladder", () -> new BlockItem(IcariaBlocks.DROUGHTROOT_LADDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_SIGN = IcariaItems.registerSimple("droughtroot_sign", () -> new IcariaSignItem(IcariaItems.propertiesItem(16), IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_SIGN.get()));
	public static final Supplier<Item> DROUGHTROOT_HANGING_SIGN = IcariaItems.registerSimple("droughtroot_hanging_sign", () -> new HangingSignItem(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), IcariaItems.propertiesItem(16)));

	public static final Supplier<Item> FIR_SAPLING = IcariaItems.register("fir_sapling", () -> new BlockItem(IcariaBlocks.FIR_SAPLING.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_LEAVES = IcariaItems.register("fir_leaves", () -> new BlockItem(IcariaBlocks.FIR_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FALLEN_FIR_LEAVES = IcariaItems.register("fallen_fir_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_FIR_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_TWIGS = IcariaItems.register("fir_twigs", () -> new BlockItem(IcariaBlocks.FIR_TWIGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_WOOD = IcariaItems.register("fir_wood", () -> new BlockItem(IcariaBlocks.FIR_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_FIR_WOOD = IcariaItems.register("stripped_fir_wood", () -> new BlockItem(IcariaBlocks.STRIPPED_FIR_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_LOG = IcariaItems.register("fir_log", () -> new BlockItem(IcariaBlocks.FIR_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_FIR_LOG = IcariaItems.register("stripped_fir_log", () -> new BlockItem(IcariaBlocks.STRIPPED_FIR_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DEAD_FIR_LOG = IcariaItems.register("dead_fir_log", () -> new BlockItem(IcariaBlocks.DEAD_FIR_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DEAD_FIR_LOG = IcariaItems.register("stripped_dead_fir_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_PLANKS = IcariaItems.register("fir_planks", () -> new BlockItem(IcariaBlocks.FIR_PLANKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaWoodDecoItems FIR_DECO = new IcariaWoodDecoItems(IcariaBlocks.FIR_DECO, IcariaItems.FIR_PLANKS);
	public static final Supplier<Item> SIMPLE_FIR_RACK = IcariaItems.register("simple_fir_rack", () -> new BlockItem(IcariaBlocks.SIMPLE_FIR_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_RACK = IcariaItems.register("fir_rack", () -> new BlockItem(IcariaBlocks.FIR_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_BARREL = IcariaItems.register("fir_barrel", () -> new BlockItem(IcariaBlocks.FIR_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOADED_FIR_BARREL = IcariaItems.register("loaded_fir_barrel", () -> new BlockItem(IcariaBlocks.LOADED_FIR_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TAPPED_FIR_BARREL = IcariaItems.register("tapped_fir_barrel", () -> new BlockItem(IcariaBlocks.TAPPED_FIR_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRIPLE_FIR_BARREL_RACK = IcariaItems.register("triple_fir_barrel_rack", () -> new BlockItem(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_TROUGH = IcariaItems.register("fir_trough", () -> new BlockItem(IcariaBlocks.FIR_TROUGH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_CRAFTING_TABLE = IcariaItems.register("fir_crafting_table", () -> new BlockItem(IcariaBlocks.FIR_CRAFTING_TABLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_DOOR = IcariaItems.registerSimple("fir_door", () -> new BlockItem(IcariaBlocks.FIR_DOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_TRAPDOOR = IcariaItems.register("fir_trapdoor", () -> new BlockItem(IcariaBlocks.FIR_TRAPDOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_LADDER = IcariaItems.registerSimple("fir_ladder", () -> new BlockItem(IcariaBlocks.FIR_LADDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_SIGN = IcariaItems.registerSimple("fir_sign", () -> new IcariaSignItem(IcariaItems.propertiesItem(16), IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_WALL_SIGN.get()));
	public static final Supplier<Item> FIR_HANGING_SIGN = IcariaItems.registerSimple("fir_hanging_sign", () -> new HangingSignItem(IcariaBlocks.FIR_HANGING_SIGN.get(), IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), IcariaItems.propertiesItem(16)));

	public static final Supplier<Item> LAUREL_SAPLING = IcariaItems.register("laurel_sapling", () -> new BlockItem(IcariaBlocks.LAUREL_SAPLING.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_LEAVES = IcariaItems.register("laurel_leaves", () -> new BlockItem(IcariaBlocks.LAUREL_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FALLEN_LAUREL_LEAVES = IcariaItems.register("fallen_laurel_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_TWIGS = IcariaItems.register("laurel_twigs", () -> new BlockItem(IcariaBlocks.LAUREL_TWIGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_WOOD = IcariaItems.register("laurel_wood", () -> new BlockItem(IcariaBlocks.LAUREL_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_LAUREL_WOOD = IcariaItems.register("stripped_laurel_wood", () -> new BlockItem(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_LOG = IcariaItems.register("laurel_log", () -> new BlockItem(IcariaBlocks.LAUREL_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_LAUREL_LOG = IcariaItems.register("stripped_laurel_log", () -> new BlockItem(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DEAD_LAUREL_LOG = IcariaItems.register("dead_laurel_log", () -> new BlockItem(IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DEAD_LAUREL_LOG = IcariaItems.register("stripped_dead_laurel_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_PLANKS = IcariaItems.register("laurel_planks", () -> new BlockItem(IcariaBlocks.LAUREL_PLANKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaWoodDecoItems LAUREL_DECO = new IcariaWoodDecoItems(IcariaBlocks.LAUREL_DECO, IcariaItems.LAUREL_PLANKS);
	public static final Supplier<Item> SIMPLE_LAUREL_RACK = IcariaItems.register("simple_laurel_rack", () -> new BlockItem(IcariaBlocks.SIMPLE_LAUREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_RACK = IcariaItems.register("laurel_rack", () -> new BlockItem(IcariaBlocks.LAUREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_BARREL = IcariaItems.register("laurel_barrel", () -> new BlockItem(IcariaBlocks.LAUREL_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOADED_LAUREL_BARREL = IcariaItems.register("loaded_laurel_barrel", () -> new BlockItem(IcariaBlocks.LOADED_LAUREL_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TAPPED_LAUREL_BARREL = IcariaItems.register("tapped_laurel_barrel", () -> new BlockItem(IcariaBlocks.TAPPED_LAUREL_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRIPLE_LAUREL_BARREL_RACK = IcariaItems.register("triple_laurel_barrel_rack", () -> new BlockItem(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_TROUGH = IcariaItems.register("laurel_trough", () -> new BlockItem(IcariaBlocks.LAUREL_TROUGH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_CRAFTING_TABLE = IcariaItems.register("laurel_crafting_table", () -> new BlockItem(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_DOOR = IcariaItems.registerSimple("laurel_door", () -> new BlockItem(IcariaBlocks.LAUREL_DOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_TRAPDOOR = IcariaItems.register("laurel_trapdoor", () -> new BlockItem(IcariaBlocks.LAUREL_TRAPDOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_LADDER = IcariaItems.registerSimple("laurel_ladder", () -> new BlockItem(IcariaBlocks.LAUREL_LADDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_SIGN = IcariaItems.registerSimple("laurel_sign", () -> new IcariaSignItem(IcariaItems.propertiesItem(16), IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_WALL_SIGN.get()));
	public static final Supplier<Item> LAUREL_HANGING_SIGN = IcariaItems.registerSimple("laurel_hanging_sign", () -> new HangingSignItem(IcariaBlocks.LAUREL_HANGING_SIGN.get(), IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), IcariaItems.propertiesItem(16)));

	public static final Supplier<Item> OLIVE_SAPLING = IcariaItems.register("olive_sapling", () -> new BlockItem(IcariaBlocks.OLIVE_SAPLING.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_LEAVES = IcariaItems.register("olive_leaves", () -> new BlockItem(IcariaBlocks.OLIVE_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FALLEN_OLIVE_LEAVES = IcariaItems.register("fallen_olive_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_TWIGS = IcariaItems.register("olive_twigs", () -> new BlockItem(IcariaBlocks.OLIVE_TWIGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_WOOD = IcariaItems.register("olive_wood", () -> new BlockItem(IcariaBlocks.OLIVE_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_OLIVE_WOOD = IcariaItems.register("stripped_olive_wood", () -> new BlockItem(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_LOG = IcariaItems.register("olive_log", () -> new BlockItem(IcariaBlocks.OLIVE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_OLIVE_LOG = IcariaItems.register("stripped_olive_log", () -> new BlockItem(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DEAD_OLIVE_LOG = IcariaItems.register("dead_olive_log", () -> new BlockItem(IcariaBlocks.DEAD_OLIVE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DEAD_OLIVE_LOG = IcariaItems.register("stripped_dead_olive_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_PLANKS = IcariaItems.register("olive_planks", () -> new BlockItem(IcariaBlocks.OLIVE_PLANKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaWoodDecoItems OLIVE_DECO = new IcariaWoodDecoItems(IcariaBlocks.OLIVE_DECO, IcariaItems.OLIVE_PLANKS);
	public static final Supplier<Item> SIMPLE_OLIVE_RACK = IcariaItems.register("simple_olive_rack", () -> new BlockItem(IcariaBlocks.SIMPLE_OLIVE_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_RACK = IcariaItems.register("olive_rack", () -> new BlockItem(IcariaBlocks.OLIVE_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_BARREL = IcariaItems.register("olive_barrel", () -> new BlockItem(IcariaBlocks.OLIVE_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOADED_OLIVE_BARREL = IcariaItems.register("loaded_olive_barrel", () -> new BlockItem(IcariaBlocks.LOADED_OLIVE_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TAPPED_OLIVE_BARREL = IcariaItems.register("tapped_olive_barrel", () -> new BlockItem(IcariaBlocks.TAPPED_OLIVE_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRIPLE_OLIVE_BARREL_RACK = IcariaItems.register("triple_olive_barrel_rack", () -> new BlockItem(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_TROUGH = IcariaItems.register("olive_trough", () -> new BlockItem(IcariaBlocks.OLIVE_TROUGH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_CRAFTING_TABLE = IcariaItems.register("olive_crafting_table", () -> new BlockItem(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_DOOR = IcariaItems.registerSimple("olive_door", () -> new BlockItem(IcariaBlocks.OLIVE_DOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_TRAPDOOR = IcariaItems.register("olive_trapdoor", () -> new BlockItem(IcariaBlocks.OLIVE_TRAPDOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_LADDER = IcariaItems.registerSimple("olive_ladder", () -> new BlockItem(IcariaBlocks.OLIVE_LADDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_SIGN = IcariaItems.registerSimple("olive_sign", () -> new IcariaSignItem(IcariaItems.propertiesItem(16), IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_WALL_SIGN.get()));
	public static final Supplier<Item> OLIVE_HANGING_SIGN = IcariaItems.registerSimple("olive_hanging_sign", () -> new HangingSignItem(IcariaBlocks.OLIVE_HANGING_SIGN.get(), IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), IcariaItems.propertiesItem(16)));

	public static final Supplier<Item> PLANE_SAPLING = IcariaItems.register("plane_sapling", () -> new BlockItem(IcariaBlocks.PLANE_SAPLING.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_LEAVES = IcariaItems.register("plane_leaves", () -> new BlockItem(IcariaBlocks.PLANE_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FALLEN_PLANE_LEAVES = IcariaItems.register("fallen_plane_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_TWIGS = IcariaItems.register("plane_twigs", () -> new BlockItem(IcariaBlocks.PLANE_TWIGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_WOOD = IcariaItems.register("plane_wood", () -> new BlockItem(IcariaBlocks.PLANE_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_PLANE_WOOD = IcariaItems.register("stripped_plane_wood", () -> new BlockItem(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_LOG = IcariaItems.register("plane_log", () -> new BlockItem(IcariaBlocks.PLANE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_PLANE_LOG = IcariaItems.register("stripped_plane_log", () -> new BlockItem(IcariaBlocks.STRIPPED_PLANE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DEAD_PLANE_LOG = IcariaItems.register("dead_plane_log", () -> new BlockItem(IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DEAD_PLANE_LOG = IcariaItems.register("stripped_dead_plane_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_PLANKS = IcariaItems.register("plane_planks", () -> new BlockItem(IcariaBlocks.PLANE_PLANKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaWoodDecoItems PLANE_DECO = new IcariaWoodDecoItems(IcariaBlocks.PLANE_DECO, IcariaItems.PLANE_PLANKS);
	public static final Supplier<Item> SIMPLE_PLANE_RACK = IcariaItems.register("simple_plane_rack", () -> new BlockItem(IcariaBlocks.SIMPLE_PLANE_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_RACK = IcariaItems.register("plane_rack", () -> new BlockItem(IcariaBlocks.PLANE_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_BARREL = IcariaItems.register("plane_barrel", () -> new BlockItem(IcariaBlocks.PLANE_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOADED_PLANE_BARREL = IcariaItems.register("loaded_plane_barrel", () -> new BlockItem(IcariaBlocks.LOADED_PLANE_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TAPPED_PLANE_BARREL = IcariaItems.register("tapped_plane_barrel", () -> new BlockItem(IcariaBlocks.TAPPED_PLANE_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRIPLE_PLANE_BARREL_RACK = IcariaItems.register("triple_plane_barrel_rack", () -> new BlockItem(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_TROUGH = IcariaItems.register("plane_trough", () -> new BlockItem(IcariaBlocks.PLANE_TROUGH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_CRAFTING_TABLE = IcariaItems.register("plane_crafting_table", () -> new BlockItem(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_DOOR = IcariaItems.registerSimple("plane_door", () -> new BlockItem(IcariaBlocks.PLANE_DOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_TRAPDOOR = IcariaItems.register("plane_trapdoor", () -> new BlockItem(IcariaBlocks.PLANE_TRAPDOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_LADDER = IcariaItems.registerSimple("plane_ladder", () -> new BlockItem(IcariaBlocks.PLANE_LADDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_SIGN = IcariaItems.registerSimple("plane_sign", () -> new IcariaSignItem(IcariaItems.propertiesItem(16), IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_WALL_SIGN.get()));
	public static final Supplier<Item> PLANE_HANGING_SIGN = IcariaItems.registerSimple("plane_hanging_sign", () -> new HangingSignItem(IcariaBlocks.PLANE_HANGING_SIGN.get(), IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), IcariaItems.propertiesItem(16)));

	public static final Supplier<Item> POPULUS_SAPLING = IcariaItems.register("populus_sapling", () -> new BlockItem(IcariaBlocks.POPULUS_SAPLING.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_LEAVES = IcariaItems.register("populus_leaves", () -> new BlockItem(IcariaBlocks.POPULUS_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FALLEN_POPULUS_LEAVES = IcariaItems.register("fallen_populus_leaves", () -> new BlockItem(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_TWIGS = IcariaItems.register("populus_twigs", () -> new BlockItem(IcariaBlocks.POPULUS_TWIGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_WOOD = IcariaItems.register("populus_wood", () -> new BlockItem(IcariaBlocks.POPULUS_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_POPULUS_WOOD = IcariaItems.register("stripped_populus_wood", () -> new BlockItem(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_LOG = IcariaItems.register("populus_log", () -> new BlockItem(IcariaBlocks.POPULUS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_POPULUS_LOG = IcariaItems.register("stripped_populus_log", () -> new BlockItem(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DEAD_POPULUS_LOG = IcariaItems.register("dead_populus_log", () -> new BlockItem(IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRIPPED_DEAD_POPULUS_LOG = IcariaItems.register("stripped_dead_populus_log", () -> new BlockItem(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_PLANKS = IcariaItems.register("populus_planks", () -> new BlockItem(IcariaBlocks.POPULUS_PLANKS.get(), IcariaItems.propertiesItem()));
	public static final IcariaWoodDecoItems POPULUS_DECO = new IcariaWoodDecoItems(IcariaBlocks.POPULUS_DECO, IcariaItems.POPULUS_PLANKS);
	public static final Supplier<Item> SIMPLE_POPULUS_RACK = IcariaItems.register("simple_populus_rack", () -> new BlockItem(IcariaBlocks.SIMPLE_POPULUS_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_RACK = IcariaItems.register("populus_rack", () -> new BlockItem(IcariaBlocks.POPULUS_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_BARREL = IcariaItems.register("populus_barrel", () -> new BlockItem(IcariaBlocks.POPULUS_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOADED_POPULUS_BARREL = IcariaItems.register("loaded_populus_barrel", () -> new BlockItem(IcariaBlocks.LOADED_POPULUS_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TAPPED_POPULUS_BARREL = IcariaItems.register("tapped_populus_barrel", () -> new BlockItem(IcariaBlocks.TAPPED_POPULUS_BARREL.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TRIPLE_POPULUS_BARREL_RACK = IcariaItems.register("triple_populus_barrel_rack", () -> new BlockItem(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_TROUGH = IcariaItems.register("populus_trough", () -> new BlockItem(IcariaBlocks.POPULUS_TROUGH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_CRAFTING_TABLE = IcariaItems.register("populus_crafting_table", () -> new BlockItem(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_DOOR = IcariaItems.registerSimple("populus_door", () -> new BlockItem(IcariaBlocks.POPULUS_DOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_TRAPDOOR = IcariaItems.register("populus_trapdoor", () -> new BlockItem(IcariaBlocks.POPULUS_TRAPDOOR.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_LADDER = IcariaItems.registerSimple("populus_ladder", () -> new BlockItem(IcariaBlocks.POPULUS_LADDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_SIGN = IcariaItems.registerSimple("populus_sign", () -> new IcariaSignItem(IcariaItems.propertiesItem(16), IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_WALL_SIGN.get()));
	public static final Supplier<Item> POPULUS_HANGING_SIGN = IcariaItems.registerSimple("populus_hanging_sign", () -> new HangingSignItem(IcariaBlocks.POPULUS_HANGING_SIGN.get(), IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get(), IcariaItems.propertiesItem(16)));

	public static final Supplier<Item> BLOOMY_VINE = IcariaItems.registerSimple("bloomy_vine", () -> new BlockItem(IcariaBlocks.BLOOMY_VINE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BRANCHY_VINE = IcariaItems.registerSimple("branchy_vine", () -> new BlockItem(IcariaBlocks.BRANCHY_VINE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BRUSHY_VINE = IcariaItems.registerSimple("brushy_vine", () -> new BlockItem(IcariaBlocks.BRUSHY_VINE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DRY_VINE = IcariaItems.registerSimple("dry_vine", () -> new BlockItem(IcariaBlocks.DRY_VINE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> REEDY_VINE = IcariaItems.registerSimple("reedy_vine", () -> new BlockItem(IcariaBlocks.REEDY_VINE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SWIRLY_VINE = IcariaItems.registerSimple("swirly_vine", () -> new BlockItem(IcariaBlocks.SWIRLY_VINE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> THORNY_VINE = IcariaItems.registerSimple("thorny_vine", () -> new BlockItem(IcariaBlocks.THORNY_VINE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> FERN = IcariaItems.registerSimple("fern", () -> new BlockItem(IcariaBlocks.FERN.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> SMALL_GRASS = IcariaItems.registerSimple("small_grass", () -> new BlockItem(IcariaBlocks.SMALL_GRASS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MEDIUM_GRASS = IcariaItems.registerSimple("medium_grass", () -> new BlockItem(IcariaBlocks.MEDIUM_GRASS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LARGE_GRASS = IcariaItems.registerSimple("large_grass", () -> new BlockItem(IcariaBlocks.LARGE_GRASS.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> SMALL_MIXED_GRAIN = IcariaItems.registerSimple("small_mixed_grain", () -> new BlockItem(IcariaBlocks.SMALL_MIXED_GRAIN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MEDIUM_MIXED_GRAIN = IcariaItems.registerSimple("medium_mixed_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_MIXED_GRAIN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MEDIUM_BROWN_GRAIN = IcariaItems.registerSimple("medium_brown_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_BROWN_GRAIN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MEDIUM_WHITE_GRAIN = IcariaItems.registerSimple("medium_white_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_WHITE_GRAIN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MEDIUM_YELLOW_GRAIN = IcariaItems.registerSimple("medium_yellow_grain", () -> new BlockItem(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LARGE_BROWN_GRAIN = IcariaItems.registerSimple("large_brown_grain", () -> new BlockItem(IcariaBlocks.LARGE_BROWN_GRAIN.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> BLINDWEED = IcariaItems.registerSimple("blindweed", () -> new BlockItem(IcariaBlocks.BLINDWEED.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CHAMEOMILE = IcariaItems.registerSimple("chameomile", () -> new BlockItem(IcariaBlocks.CHAMEOMILE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CHARMONDER = IcariaItems.registerSimple("charmonder", () -> new BlockItem(IcariaBlocks.CHARMONDER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CLOVER = IcariaItems.registerSimple("clover", () -> new BlockItem(IcariaBlocks.CLOVER.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIREHILT = IcariaItems.registerSimple("firehilt", () -> new BlockItem(IcariaBlocks.FIREHILT.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLUE_HYDRACINTH = IcariaItems.registerSimple("blue_hydracinth", () -> new BlockItem(IcariaBlocks.BLUE_HYDRACINTH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PURPLE_HYDRACINTH = IcariaItems.registerSimple("purple_hydracinth", () -> new BlockItem(IcariaBlocks.PURPLE_HYDRACINTH.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIONFANGS = IcariaItems.registerSimple("lionfangs", () -> new BlockItem(IcariaBlocks.LIONFANGS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SPEARDROPS = IcariaItems.registerSimple("speardrops", () -> new BlockItem(IcariaBlocks.SPEARDROPS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PURPLE_STAGHORN = IcariaItems.registerSimple("purple_staghorn", () -> new BlockItem(IcariaBlocks.PURPLE_STAGHORN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> YELLOW_STAGHORN = IcariaItems.registerSimple("yellow_staghorn", () -> new BlockItem(IcariaBlocks.YELLOW_STAGHORN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLUE_STORMCOTTON = IcariaItems.registerSimple("blue_stormcotton", () -> new BlockItem(IcariaBlocks.BLUE_STORMCOTTON.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PINK_STORMCOTTON = IcariaItems.registerSimple("pink_stormcotton", () -> new BlockItem(IcariaBlocks.PINK_STORMCOTTON.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PURPLE_STORMCOTTON = IcariaItems.registerSimple("purple_stormcotton", () -> new BlockItem(IcariaBlocks.PURPLE_STORMCOTTON.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SUNKETTLE = IcariaItems.registerSimple("sunkettle", () -> new BlockItem(IcariaBlocks.SUNKETTLE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SUNSPONGE = IcariaItems.registerSimple("sunsponge", () -> new BlockItem(IcariaBlocks.SUNSPONGE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> VOIDLILY = IcariaItems.registerSimple("voidlily", () -> new BlockItem(IcariaBlocks.VOIDLILY.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> BOLBOS = IcariaItems.registerSimple("bolbos", () -> new BlockItem(IcariaBlocks.BOLBOS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> DATHULLA = IcariaItems.registerSimple("dathulla", () -> new BlockItem(IcariaBlocks.DATHULLA.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MONDANOS = IcariaItems.registerSimple("mondanos", () -> new BlockItem(IcariaBlocks.MONDANOS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOTH_AGARIC = IcariaItems.registerSimple("moth_agaric", () -> new BlockItem(IcariaBlocks.MOTH_AGARIC.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> NAMDRAKE = IcariaItems.registerSimple("namdrake", () -> new BlockItem(IcariaBlocks.NAMDRAKE.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PSILOCYBOS = IcariaItems.registerSimple("psilocybos", () -> new BlockItem(IcariaBlocks.PSILOCYBOS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ROWAN = IcariaItems.registerSimple("rowan", () -> new BlockItem(IcariaBlocks.ROWAN.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> WILTED_ELM = IcariaItems.registerSimple("wilted_elm", () -> new BlockItem(IcariaBlocks.WILTED_ELM.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> BLUE_GROUND_FLOWERS = IcariaItems.register("blue_ground_flowers", () -> new BlockItem(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYAN_GROUND_FLOWERS = IcariaItems.register("cyan_ground_flowers", () -> new BlockItem(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PINK_GROUND_FLOWERS = IcariaItems.register("pink_ground_flowers", () -> new BlockItem(IcariaBlocks.PINK_GROUND_FLOWERS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PURPLE_GROUND_FLOWERS = IcariaItems.register("purple_ground_flowers", () -> new BlockItem(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> RED_GROUND_FLOWERS = IcariaItems.register("red_ground_flowers", () -> new BlockItem(IcariaBlocks.RED_GROUND_FLOWERS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> WHITE_GROUND_FLOWERS = IcariaItems.register("white_ground_flowers", () -> new BlockItem(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> FOREST_MOSS = IcariaItems.register("forest_moss", () -> new BlockItem(IcariaBlocks.FOREST_MOSS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> SCRUBLAND_MOSS = IcariaItems.register("scrubland_moss", () -> new BlockItem(IcariaBlocks.SCRUBLAND_MOSS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STEPPE_MOSS = IcariaItems.register("steppe_moss", () -> new BlockItem(IcariaBlocks.STEPPE_MOSS.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> PALM_FERN = IcariaItems.register("palm_fern", () -> new BlockItem(IcariaBlocks.PALM_FERN.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> WHITE_BROMELIA = IcariaItems.register("white_bromelia", () -> new BlockItem(IcariaBlocks.WHITE_BROMELIA.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> ORANGE_BROMELIA = IcariaItems.register("orange_bromelia", () -> new BlockItem(IcariaBlocks.ORANGE_BROMELIA.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PINK_BROMELIA = IcariaItems.register("pink_bromelia", () -> new BlockItem(IcariaBlocks.PINK_BROMELIA.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PURPLE_BROMELIA = IcariaItems.register("purple_bromelia", () -> new BlockItem(IcariaBlocks.PURPLE_BROMELIA.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> GREEN_GROUND_SHROOMS = IcariaItems.register("green_ground_shrooms", () -> new BlockItem(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> BROWN_GROUND_SHROOMS = IcariaItems.register("brown_ground_shrooms", () -> new BlockItem(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> LARGE_BROWN_GROUND_SHROOMS = IcariaItems.register("large_brown_ground_shrooms", () -> new BlockItem(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> TINDER_FUNGUS_TREE_SHROOMS = IcariaItems.register("tinder_fungus_tree_shrooms", () -> new BlockItem(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> TURKEY_TAIL_TREE_SHROOMS = IcariaItems.register("turkey_tail_tree_shrooms", () -> new BlockItem(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> UNNAMED_TREE_SHROOMS = IcariaItems.register("unnamed_tree_shrooms", () -> new BlockItem(IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> CARDON_CACTUS = IcariaItems.register("cardon_cactus", () -> new BlockItem(IcariaBlocks.CARDON_CACTUS.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> STRAWBERRY_BUSH = IcariaItems.register("strawberry_bush", () -> new BlockItem(IcariaBlocks.STRAWBERRY_BUSH.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> GRINDER_SHAFT = IcariaItems.register("grinder_shaft", () -> new BlockItem(IcariaBlocks.GRINDER_SHAFT.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRINDER_STONE = IcariaItems.register("grinder_stone", () -> new BlockItem(IcariaBlocks.GRINDER_STONE.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> PAINTING = IcariaItems.registerSimple("painting", () -> new IcariaPaintingItem(IcariaItems.propertiesItem()));

	public static final Supplier<Item> BONE_REMAINS = IcariaItems.registerSimple("bone_remains", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOAM_LUMP = IcariaItems.registerSimple("loam_lump", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOAM_BRICK = IcariaItems.registerSimple("loam_brick", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> CHERT = IcariaItems.registerSimple("chert", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ENDER_JELLYFISH_JELLY = IcariaItems.registerSimple("ender_jellyfish_jelly", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIRE_JELLYFISH_JELLY = IcariaItems.registerSimple("fire_jellyfish_jelly", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> NATURE_JELLYFISH_JELLY = IcariaItems.registerSimple("nature_jellyfish_jelly", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> VOID_JELLYFISH_JELLY = IcariaItems.registerSimple("void_jellyfish_jelly", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> WATER_JELLYFISH_JELLY = IcariaItems.registerSimple("water_jellyfish_jelly", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ARACHNE_STRING = IcariaItems.registerSimple("arachne_string", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SPELT = IcariaItems.registerSimple("spelt", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> VINE_REED = IcariaItems.registerSimple("vine_reed", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ROTTEN_BONES = IcariaItems.registerSimple("rotten_bones", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> GREENPOWDER = IcariaItems.registerSimple("greenpowder", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> CALCITE_SHARD = IcariaItems.registerSimple("calcite_shard", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> HALITE_SHARD = IcariaItems.registerSimple("halite_shard", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> JASPER_SHARD = IcariaItems.registerSimple("jasper_shard", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ZIRCON_SHARD = IcariaItems.registerSimple("zircon_shard", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> CALCITE_DUST = IcariaItems.registerSimple("calcite_dust", () -> new BoneMealItem(IcariaItems.propertiesItem()));
	public static final Supplier<Item> HALITE_DUST = IcariaItems.registerSimple("halite_dust", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIGNITE = IcariaItems.registerSimple("lignite", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_CHALKOS = IcariaItems.registerSimple("raw_chalkos", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_KASSITEROS = IcariaItems.registerSimple("raw_kassiteros", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> DOLOMITE = IcariaItems.registerSimple("dolomite", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_VANADIUM = IcariaItems.registerSimple("raw_vanadium", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SLIVER = IcariaItems.registerSimple("sliver", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_SIDEROS = IcariaItems.registerSimple("raw_sideros", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ANTHRACITE = IcariaItems.registerSimple("anthracite", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> RAW_MOLYBDENUM = IcariaItems.registerSimple("raw_molybdenum", () -> new Item(IcariaItems.propertiesItem()));

	public static final Supplier<Item> CHALKOS_NUGGET = IcariaItems.registerSimple("chalkos_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> KASSITEROS_NUGGET = IcariaItems.registerSimple("kassiteros_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ORICHALCUM_NUGGET = IcariaItems.registerSimple("orichalcum_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> VANADIUM_NUGGET = IcariaItems.registerSimple("vanadium_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> VANADIUMSTEEL_NUGGET = IcariaItems.registerSimple("vanadiumsteel_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SIDEROS_NUGGET = IcariaItems.registerSimple("sideros_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOLYBDENUM_NUGGET = IcariaItems.registerSimple("molybdenum_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOLYBDENUMSTEEL_NUGGET = IcariaItems.registerSimple("molybdenumsteel_nugget", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLURIDIUM_NUGGET = IcariaItems.registerSimple("bluridium_nugget", () -> new Item(IcariaItems.propertiesItem()));

	public static final Supplier<Item> CHALKOS_INGOT = IcariaItems.registerSimple("chalkos_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> KASSITEROS_INGOT = IcariaItems.registerSimple("kassiteros_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ORICHALCUM_INGOT = IcariaItems.registerSimple("orichalcum_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> VANADIUM_INGOT = IcariaItems.registerSimple("vanadium_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> VANADIUMSTEEL_INGOT = IcariaItems.registerSimple("vanadiumsteel_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SIDEROS_INGOT = IcariaItems.registerSimple("sideros_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOLYBDENUM_INGOT = IcariaItems.registerSimple("molybdenum_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> MOLYBDENUMSTEEL_INGOT = IcariaItems.registerSimple("molybdenumsteel_ingot", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLURIDIUM_INGOT = IcariaItems.registerSimple("bluridium_ingot", () -> new Item(IcariaItems.propertiesItem()));

	public static final IcariaToolItems CHERT_TOOLS = new IcariaToolItems("chert", IcariaTiers.CHERT);
	public static final IcariaToolItems CHALKOS_TOOLS = new IcariaToolItems("chalkos", IcariaTiers.CHALKOS);
	public static final IcariaToolItems KASSITEROS_TOOLS = new IcariaToolItems("kassiteros", IcariaTiers.KASSITEROS);
	public static final IcariaToolItems ORICHALCUM_TOOLS = new IcariaToolItems("orichalcum", IcariaTiers.ORICHALCUM);
	public static final IcariaToolItems VANADIUMSTEEL_TOOLS = new IcariaToolItems("vanadiumsteel", IcariaTiers.VANADIUMSTEEL);
	public static final IcariaToolItems SIDEROS_TOOLS = new IcariaToolItems("sideros", IcariaTiers.SIDEROS);
	public static final IcariaToolItems MOLYBDENUMSTEEL_TOOLS = new IcariaToolItems("molybdenumsteel", IcariaTiers.MOLYBDENUMSTEEL);

	public static final IcariaArmorItems AETERNAE_HIDE_ARMOR = new IcariaArmorItems("aeternae_hide", IcariaArmorMaterials.AETERNAE_HIDE, 11);
	public static final IcariaArmorItems CHALKOS_ARMOR = new IcariaArmorItems("chalkos", IcariaArmorMaterials.CHALKOS, 11);
	public static final IcariaArmorItems KASSITEROS_ARMOR = new IcariaArmorItems("kassiteros", IcariaArmorMaterials.KASSITEROS, 15);
	public static final Supplier<Item> ORICHALCUM_HELMET = IcariaItems.registerSimple("orichalcum_helmet", () -> new OrichalcumHelmetItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.HELMET, IcariaItems.propertiesItem().durability(ArmorItem.Type.HELMET.getDurability(24))));
	public static final Supplier<Item> ORICHALCUM_CHESTPLATE = IcariaItems.registerSimple("orichalcum_chestplate", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.CHESTPLATE, IcariaItems.propertiesItem().durability(ArmorItem.Type.CHESTPLATE.getDurability(24))));
	public static final Supplier<Item> ORICHALCUM_LEGGINGS = IcariaItems.registerSimple("orichalcum_leggings", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.LEGGINGS, IcariaItems.propertiesItem().durability(ArmorItem.Type.LEGGINGS.getDurability(24))));
	public static final Supplier<Item> ORICHALCUM_BOOTS = IcariaItems.registerSimple("orichalcum_boots", () -> new ArmorItem(IcariaArmorMaterials.ORICHALCUM, ArmorItem.Type.BOOTS, IcariaItems.propertiesItem().durability(ArmorItem.Type.BOOTS.getDurability(24))));
	public static final IcariaArmorItems VANADIUMSTEEL_ARMOR = new IcariaArmorItems("vanadiumsteel", IcariaArmorMaterials.VANADIUMSTEEL, 27);
	public static final Supplier<Item> LAUREL_WREATH = IcariaItems.registerSimple("laurel_wreath", () -> new ArmorItem(IcariaArmorMaterials.LAUREL, ArmorItem.Type.HELMET, IcariaItems.propertiesItem()));

	public static final Supplier<Item> GREEK_FIRE_GRENADE = IcariaItems.registerSimple("greek_fire_grenade", () -> new GreekFireGrenadeItem(IcariaItems.propertiesItem()));

	public static final Supplier<TotemItem> TOTEM_OF_STUFFING = IcariaItems.registerSimple("totem_of_stuffing", () -> new TotemItem(IcariaItems.propertiesItem(1, 4, Rarity.UNCOMMON)));
	public static final Supplier<TotemItem> TOTEM_OF_UNBLINDING = IcariaItems.registerSimple("totem_of_unblinding", () -> new TotemItem(IcariaItems.propertiesItem(1, 4, Rarity.UNCOMMON)));
	public static final Supplier<TotemItem> TOTEM_OF_UNDROWNING = IcariaItems.registerSimple("totem_of_undrowning", () -> new TotemItem(IcariaItems.propertiesItem(1, 4, Rarity.UNCOMMON)));
	public static final Supplier<TotemItem> TOTEM_OF_UNSHATTERING = IcariaItems.registerSimple("totem_of_unshattering", () -> new TotemItem(IcariaItems.propertiesItem(1, 4, Rarity.UNCOMMON)));
	public static final Supplier<TotemItem> TOTEM_OF_UNSINKING = IcariaItems.registerSimple("totem_of_unsinking", () -> new TotemItem(IcariaItems.propertiesItem(1, 4, Rarity.UNCOMMON)));

	public static final Supplier<Item> UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> WHITE_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("white_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIGHT_GRAY_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("light_gray_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> GRAY_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("gray_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLACK_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("black_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> BROWN_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("brown_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> RED_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("red_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ORANGE_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("orange_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> YELLOW_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("yellow_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIME_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("lime_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> GREEN_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("green_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYAN_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("cyan_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> LIGHT_BLUE_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("light_blue_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> BLUE_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("blue_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> PURPLE_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("purple_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> MAGENTA_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("magenta_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> PINK_UNFIRED_STORAGE_VASE = IcariaItems.registerSimple("pink_unfired_storage_vase", () -> new Item(IcariaItems.propertiesItem()));

	public static final Supplier<Item> ANTI_GRAVITY_SCROLL = IcariaItems.register("anti_gravity_scroll", () -> new ScrollItem(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> FORTIFYING_SCROLL = IcariaItems.register("fortifying_scroll", () -> new ScrollItem(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> HEALING_SCROLL = IcariaItems.register("healing_scroll", () -> new ScrollItem(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> BUBBLE_SCROLL = IcariaItems.register("bubble_scroll", () -> new ScrollItem(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> FREEZING_SCROLL = IcariaItems.register("freezing_scroll", () -> new ScrollItem(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> MAGIC_MISSILE_SCROLL = IcariaItems.register("magic_missile_scroll", () -> new ScrollItem(IcariaItems.propertiesItem(1)));

	public static final Supplier<Item> ANTI_GRAVITY_SPELL = IcariaItems.registerSimple("anti_gravity_spell", () -> new AntiGravitySpellItem(IcariaItems.propertiesItem(), 1.0F, 1.0F, 6919359, 20));
	public static final Supplier<Item> FORTIFYING_SPELL = IcariaItems.registerSimple("fortifying_spell", () -> new FortifyingSpellItem(IcariaItems.propertiesItem(), 1.0F, 1.0F, 6316160, 20));
	public static final Supplier<Item> HEALING_SPELL = IcariaItems.registerSimple("healing_spell", () -> new HealingSpellItem(IcariaItems.propertiesItem(), 1.0F, 1.0F, 16711680, 20));
	public static final Supplier<Item> BUBBLE_SPELL = IcariaItems.registerSimple("bubble_spell", () -> new BubbleSpellItem(IcariaItems.propertiesItem()));
	public static final Supplier<Item> FREEZING_SPELL = IcariaItems.registerSimple("freezing_spell", () -> new FreezingSpellItem(IcariaItems.propertiesItem(), 1.0F, 1.0F, 14277081, 20));
	public static final Supplier<Item> MAGIC_MISSILE_SPELL = IcariaItems.registerSimple("magic_missile_spell", () -> new MagicMissileSpellItem(IcariaItems.propertiesItem(), 0.0F, 2.0F, 6307968, 40));

	public static final Supplier<Item> EMPTY_FLASK = IcariaItems.registerSimple("empty_flask", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ANTI_GRAVITY_FLASK = IcariaItems.registerSimple("anti_gravity_flask", () -> new ConcoctionFlaskItem(IcariaItems.propertiesItem(1), MobEffects.LEVITATION, 600));
	public static final Supplier<Item> FORTIFYING_FLASK = IcariaItems.registerSimple("fortifying_flask", () -> new ConcoctionFlaskItem(IcariaItems.propertiesItem(1), MobEffects.DAMAGE_RESISTANCE, 600));
	public static final Supplier<Item> HEALING_FLASK = IcariaItems.registerSimple("healing_flask", () -> new ConcoctionFlaskItem(IcariaItems.propertiesItem(1), MobEffects.REGENERATION, 600));

	public static final Supplier<Item> EMPTY_VIAL = IcariaItems.registerSimple("empty_vial", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> ARACHNE_VENOM_VIAL = IcariaItems.registerSimple("arachne_venom_vial", () -> new Item(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> HYLIASTRUM_VIAL = IcariaItems.registerSimple("hyliastrum_vial", () -> new HyliastrumVialItem(IcariaItems.propertiesItem(1)));

	public static final Supplier<Item> CHEST_LABEL = IcariaItems.registerSimple("chest_label", () -> new ChestLabelItem(IcariaItems.propertiesItem()));

	public static final Supplier<Item> YELLOWSTONE_GEAR = IcariaItems.registerSimple("yellowstone_gear", () -> new GearItem(IcariaItems.propertiesItem(1, 256)));
	public static final Supplier<Item> UNFIRED_LOAM_GEAR = IcariaItems.registerSimple("unfired_loam_gear", () -> new Item(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> LOAM_GEAR = IcariaItems.registerSimple("loam_gear", () -> new GearItem(IcariaItems.propertiesItem(1, 512)));
	public static final Supplier<Item> VOIDSHALE_GEAR = IcariaItems.registerSimple("voidshale_gear", () -> new GearItem(IcariaItems.propertiesItem(1, 768)));
	public static final Supplier<Item> VANADIUM_GEAR = IcariaItems.registerSimple("vanadium_gear", () -> new GearItem(IcariaItems.propertiesItem(1, 1024)));
	public static final Supplier<Item> BLUE_GEARFRAGMENT = IcariaItems.registerSimple("blue_gearfragment", () -> new Item(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> GREEN_GEARFRAGMENT = IcariaItems.registerSimple("green_gearfragment", () -> new Item(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> YELLOW_GEARFRAGMENT = IcariaItems.registerSimple("yellow_gearfragment", () -> new Item(IcariaItems.propertiesItem(1)));
	public static final Supplier<Item> DAEDALIAN_GEAR = IcariaItems.registerSimple("daedalian_gear", () -> new Item(IcariaItems.propertiesItem(1)));

	public static final Supplier<Item> AETERNAE_HIDE = IcariaItems.registerSimple("aeternae_hide", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SPELT_FLOUR = IcariaItems.registerSimple("spelt_flour", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SPELT_BREAD = IcariaItems.registerSimple("spelt_bread", () -> new Item(IcariaItems.propertiesFood(5, 0.6F)));
	public static final Supplier<Item> VINE_SPROUT = IcariaItems.registerSimple("vine_sprout", () -> new VineSproutItem(IcariaItems.propertiesFood(2, 0.5F, 1, 12)));
	public static final Supplier<Item> VINEBERRIES = IcariaItems.registerSimple("vineberries", () -> new Item(IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> STRAWBERRIES = IcariaItems.registerSimple("strawberries", () -> new Item(IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> PHYSALIS = IcariaItems.registerSimple("physalis", () -> new Item(IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> LAUREL_CHERRY = IcariaItems.registerSimple("laurel_cherry", () -> new Item(IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> BLACK_OLIVES = IcariaItems.registerSimple("black_olives", () -> new Item(IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> GREEN_OLIVES = IcariaItems.registerSimple("green_olives", () -> new Item(IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> GARLIC = IcariaItems.registerSimple("garlic", () -> new Item(IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> ONION = IcariaItems.registerSimple("onion", () -> new ItemNameBlockItem(IcariaBlocks.ONION_CROP.get(), IcariaItems.propertiesFood(2, 0.5F)));
	public static final Supplier<Item> RAW_AETERNAE_MEAT = IcariaItems.registerSimple("raw_aeternae_meat", () -> new Item(IcariaItems.propertiesFood(3, 0.5F, MobEffects.HUNGER, 200, 0, 0.5F)));
	public static final Supplier<Item> COOKED_AETERNAE_MEAT = IcariaItems.registerSimple("cooked_aeternae_meat", () -> new Item(IcariaItems.propertiesFood(8, 1.0F)));
	public static final Supplier<Item> RAW_CATOBLEPAS_MEAT = IcariaItems.registerSimple("raw_catoblepas_meat", () -> new Item(IcariaItems.propertiesFood(2, 0.5F, MobEffects.HUNGER, 200, 0, 0.5F)));
	public static final Supplier<Item> COOKED_CATOBLEPAS_MEAT = IcariaItems.registerSimple("cooked_catoblepas_meat", () -> new Item(IcariaItems.propertiesFood(7, 1.0F)));
	public static final Supplier<Item> RAW_CERVER_MEAT = IcariaItems.registerSimple("raw_cerver_meat", () -> new Item(IcariaItems.propertiesItem().food(IcariaItems.foodProperties(3, 0.5F, MobEffects.HUNGER, 200, 0, 0.5F))));
	public static final Supplier<Item> COOKED_CERVER_MEAT = IcariaItems.registerSimple("cooked_cerver_meat", () -> new Item(IcariaItems.propertiesFood(8, 1.0F)));
	public static final Supplier<Item> RAW_SOW_MEAT = IcariaItems.registerSimple("raw_sow_meat", () -> new Item(IcariaItems.propertiesItem().food(IcariaItems.foodProperties(2, 0.5F, MobEffects.HUNGER, 200, 0, 0.5F))));
	public static final Supplier<Item> COOKED_SOW_MEAT = IcariaItems.registerSimple("cooked_sow_meat", () -> new Item(IcariaItems.propertiesFood(7, 1.0F)));
	public static final Supplier<Item> MYRMEKE_SCALES = IcariaItems.registerSimple("myrmeke_scales", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SLUG_SCALES = IcariaItems.registerSimple("slug_scales", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> SNULL_CREAM = IcariaItems.registerSimple("snull_cream", () -> new Item(IcariaItems.propertiesFood(2, 0.5F, MobEffects.HUNGER, 200, 0, 1.0F, MobEffects.CONFUSION, 200, 0, 1.0F)));
	public static final Supplier<Item> VINEGAR = IcariaItems.registerSimple("vinegar", () -> new Item(IcariaItems.propertiesItem()));

	public static final Supplier<Item> UNFIRED_LOAM_BOWL = IcariaItems.registerSimple("unfired_loam_bowl", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> LOAM_BOWL = IcariaItems.registerSimple("loam_bowl", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> FRUIT_SALAD = IcariaItems.registerSimple("fruit_salad", () -> new IcariaBowlFoodItem(IcariaItems.propertiesFood(8, 1.0F, MobEffects.HEAL, 1, 0, 1.0F, 1)));
	public static final Supplier<Item> ONION_SOUP = IcariaItems.registerSimple("onion_soup", () -> new IcariaBowlFoodItem(IcariaItems.propertiesFood(4, 1.0F, 1)));
	public static final Supplier<Item> AETERNAE_STEW = IcariaItems.registerSimple("aeternae_stew", () -> new IcariaBowlFoodItem(IcariaItems.propertiesFood(9, 1.0F, 1)));
	public static final Supplier<Item> CATOBLEPAS_STEW = IcariaItems.registerSimple("catoblepas_stew", () -> new IcariaBowlFoodItem(IcariaItems.propertiesFood(8, 1.0F, 1)));
	public static final Supplier<Item> CERVER_STEW = IcariaItems.registerSimple("cerver_stew", () -> new IcariaBowlFoodItem(IcariaItems.propertiesFood(9, 1.0F, 1)));
	public static final Supplier<Item> SOW_STEW = IcariaItems.registerSimple("sow_stew", () -> new IcariaBowlFoodItem(IcariaItems.propertiesFood(8, 1.0F, 1)));

	public static final Supplier<Item> SPELT_SEEDS = IcariaItems.registerSimple("spelt_seeds", () -> new ItemNameBlockItem(IcariaBlocks.SPELT_CROP.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> STRAWBERRY_SEEDS = IcariaItems.registerSimple("strawberry_seeds", () -> new ItemNameBlockItem(IcariaBlocks.STRAWBERRY_CROP.get(), IcariaItems.propertiesItem()));
	public static final Supplier<Item> PHYSALIS_SEEDS = IcariaItems.registerSimple("physalis_seeds", () -> new ItemNameBlockItem(IcariaBlocks.PHYSALIS_CROP.get(), IcariaItems.propertiesItem()));

	public static final Supplier<Item> AETERNAE_SPAWN_EGG = IcariaItems.register("aeternae_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.AETERNAE, 0x40280B, 0x88581F, IcariaItems.propertiesItem()));
	public static final Supplier<Item> ARACHNE_SPAWN_EGG = IcariaItems.register("arachne_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.ARACHNE, 0x362E28, 0x6A8C97, IcariaItems.propertiesItem()));
	public static final Supplier<Item> ARACHNE_DRONE_SPAWN_EGG = IcariaItems.register("arachne_drone_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.ARACHNE_DRONE, 0x382F28, 0x6A8C97, IcariaItems.propertiesItem()));
	public static final Supplier<Item> ARGAN_HOUND_SPAWN_EGG = IcariaItems.register("argan_hound_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.ARGAN_HOUND, 0x0B0D0E, 0x2C2F36, IcariaItems.propertiesItem()));
	public static final Supplier<Item> CATOBLEPAS_SPAWN_EGG = IcariaItems.register("catoblepas_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.CATOBLEPAS, 0x1D170E, 0x373024, IcariaItems.propertiesItem()));
	public static final Supplier<Item> CERVER_SPAWN_EGG = IcariaItems.register("cerver_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.CERVER, 0x0E0A05, 0x302C26, IcariaItems.propertiesItem()));
	public static final Supplier<Item> CYPRESS_FOREST_HAG_SPAWN_EGG = IcariaItems.register("cypress_forest_hag_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.CYPRESS_FOREST_HAG, 0x615A52, 0x4F6712, IcariaItems.propertiesItem()));
	public static final Supplier<Item> DROUGHTROOT_FOREST_HAG_SPAWN_EGG = IcariaItems.register("droughtroot_forest_hag_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG, 0x302A2D, 0x5A621A, IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIR_FOREST_HAG_SPAWN_EGG = IcariaItems.register("fir_forest_hag_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.FIR_FOREST_HAG, 0x574C39, 0x356342, IcariaItems.propertiesItem()));
	public static final Supplier<Item> LAUREL_FOREST_HAG_SPAWN_EGG = IcariaItems.register("laurel_forest_hag_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.LAUREL_FOREST_HAG, 0x3D241A, 0x42551A, IcariaItems.propertiesItem()));
	public static final Supplier<Item> OLIVE_FOREST_HAG_SPAWN_EGG = IcariaItems.register("olive_forest_hag_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.OLIVE_FOREST_HAG, 0x697162, 0x817B32, IcariaItems.propertiesItem()));
	public static final Supplier<Item> PLANE_FOREST_HAG_SPAWN_EGG = IcariaItems.register("plane_forest_hag_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.PLANE_FOREST_HAG, 0x6F716D, 0x516C40, IcariaItems.propertiesItem()));
	public static final Supplier<Item> POPULUS_FOREST_HAG_SPAWN_EGG = IcariaItems.register("populus_forest_hag_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.POPULUS_FOREST_HAG, 0xdD0C9C7, 0x4B8360, IcariaItems.propertiesItem()));
	public static final Supplier<Item> HYLIASTER_SPAWN_EGG = IcariaItems.register("hyliaster_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.HYLIASTER, 0x040706, 0x8B9590, IcariaItems.propertiesItem()));
	public static final Supplier<Item> ENDER_JELLYFISH_SPAWN_EGG = IcariaItems.register("ender_jellyfish_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.ENDER_JELLYFISH, 0X000000, 0xE079FA, IcariaItems.propertiesItem()));
	public static final Supplier<Item> FIRE_JELLYFISH_SPAWN_EGG = IcariaItems.register("fire_jellyfish_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.FIRE_JELLYFISH, 0XF07D2A, 0xFFA531, IcariaItems.propertiesItem()));
	public static final Supplier<Item> NATURE_JELLYFISH_SPAWN_EGG = IcariaItems.register("nature_jellyfish_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.NATURE_JELLYFISH, 0X00B78B, 0x04FFAC, IcariaItems.propertiesItem()));
	public static final Supplier<Item> VOID_JELLYFISH_SPAWN_EGG = IcariaItems.register("void_jellyfish_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.VOID_JELLYFISH, 0X644D91, 0xA080E2, IcariaItems.propertiesItem()));
	public static final Supplier<Item> WATER_JELLYFISH_SPAWN_EGG = IcariaItems.register("water_jellyfish_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.WATER_JELLYFISH, 0X45A5BD, 0x5AECFE, IcariaItems.propertiesItem()));
	public static final Supplier<Item> MYRMEKE_DRONE_SPAWN_EGG = IcariaItems.register("myrmeke_drone_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.MYRMEKE_DRONE, 0x501814, 0x241E19, IcariaItems.propertiesItem()));
	public static final Supplier<Item> MYRMEKE_SOLDIER_SPAWN_EGG = IcariaItems.register("myrmeke_soldier_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.MYRMEKE_SOLDIER, 0x501814, 0x402816, IcariaItems.propertiesItem()));
	public static final Supplier<Item> MYRMEKE_QUEEN_SPAWN_EGG = IcariaItems.register("myrmeke_queen_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.MYRMEKE_QUEEN, 0x501814, 0xAB7E17, IcariaItems.propertiesItem()));
	public static final Supplier<Item> CAPTAIN_REVENANT_SPAWN_EGG = IcariaItems.register("captain_revenant_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.CAPTAIN_REVENANT, 0xCFA919, 0x636363, IcariaItems.propertiesItem()));
	public static final Supplier<Item> CIVILIAN_REVENANT_SPAWN_EGG = IcariaItems.register("civilian_revenant_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.CIVILIAN_REVENANT, 0x9C9C9C, 0x636363, IcariaItems.propertiesItem()));
	public static final Supplier<Item> CRAWLER_REVENANT_SPAWN_EGG = IcariaItems.register("crawler_revenant_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.CRAWLER_REVENANT, 0x2D2D19, 0x636363, IcariaItems.propertiesItem()));
	public static final Supplier<Item> OVERGROWN_REVENANT_SPAWN_EGG = IcariaItems.register("overgrown_revenant_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.OVERGROWN_REVENANT, 0x535C32, 0x636363, IcariaItems.propertiesItem()));
	public static final Supplier<Item> PYROMANCER_REVENANT_SPAWN_EGG = IcariaItems.register("pyromancer_revenant_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.PYROMANCER_REVENANT, 0x3C5E26, 0x636363, IcariaItems.propertiesItem()));
	public static final Supplier<Item> NETHER_PYROMANCER_REVENANT_SPAWN_EGG = IcariaItems.register("nether_pyromancer_revenant_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT, 0x5A2017, 0x636363, IcariaItems.propertiesItem()));
	public static final Supplier<Item> SOLDIER_REVENANT_SPAWN_EGG = IcariaItems.register("soldier_revenant_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.SOLDIER_REVENANT, 0x6C5757, 0x636363, IcariaItems.propertiesItem()));
	public static final Supplier<Item> SCORPION_SPAWN_EGG = IcariaItems.register("scorpion_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.SCORPION, 0x513B24, 0xD8A161, IcariaItems.propertiesItem()));
	public static final Supplier<Item> CRYSTAL_SLUG_SPAWN_EGG = IcariaItems.register("crystal_slug_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.CRYSTAL_SLUG, 0x24141A, 0x653D48, IcariaItems.propertiesItem()));
	public static final Supplier<Item> FOREST_SNULL_SPAWN_EGG = IcariaItems.register("forest_snull_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.FOREST_SNULL, 0x291306, 0x53641E, IcariaItems.propertiesItem()));
	public static final Supplier<Item> SNULL_SPAWN_EGG = IcariaItems.register("snull_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.SNULL, 0x291306, 0x8D694F, IcariaItems.propertiesItem()));
	public static final Supplier<Item> SOLIFUGAE_SPAWN_EGG = IcariaItems.register("solifugae_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.SOLIFUGAE, 0xE0CDBC, 0x91673F, IcariaItems.propertiesItem()));
	public static final Supplier<Item> SOW_SPAWN_EGG = IcariaItems.register("sow_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.SOW, 0x231A13, 0x6E554B, IcariaItems.propertiesItem()));
	public static final Supplier<Item> VINEGAROON_SPAWN_EGG = IcariaItems.register("vinegaroon_spawn_egg", () -> new DeferredSpawnEggItem(IcariaEntityTypes.VINEGAROON, 0x382819, 0xC99559, IcariaItems.propertiesItem()));

	public static final Supplier<Item> MEDITERRANEAN_WATER_BUCKET = IcariaItems.registerSimple("mediterranean_water_bucket", () -> new BucketItem(IcariaFluids.MEDITERRANEAN_WATER.get(), IcariaItems.propertiesItem(1).craftRemainder(Items.BUCKET)));

	public static final Supplier<Item> LEFT_GRINDER_CHAIN = IcariaItems.registerSimple("left_grinder_chain", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> STATIC_LEFT_GRINDER_CHAIN = IcariaItems.registerSimple("static_left_grinder_chain", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> RIGHT_GRINDER_CHAIN = IcariaItems.registerSimple("right_grinder_chain", () -> new Item(IcariaItems.propertiesItem()));
	public static final Supplier<Item> STATIC_RIGHT_GRINDER_CHAIN = IcariaItems.registerSimple("static_right_grinder_chain", () -> new Item(IcariaItems.propertiesItem()));

	public static Item.Properties propertiesItem() {
		return new Item.Properties();
	}

	public static Item.Properties propertiesItem(int pSize) {
		return new Item.Properties().stacksTo(pSize);
	}

	public static Item.Properties propertiesItem(Rarity pRarity) {
		return new Item.Properties().rarity(pRarity);
	}

	public static Item.Properties propertiesItem(int pSize, Rarity pRarity) {
		return new Item.Properties().stacksTo(pSize).rarity(pRarity);
	}

	public static Item.Properties propertiesItem(int pSize, int pDurability) {
		return new Item.Properties().stacksTo(pSize).durability(pDurability);
	}

	public static Item.Properties propertiesItem(int pSize, int pDurability, Rarity pRarity) {
		return new Item.Properties().stacksTo(pSize).durability(pDurability).rarity(pRarity);
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, int pSize) {
		return new Item.Properties().stacksTo(pSize).food(IcariaItems.foodProperties(pNutrition, pSaturation));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, Holder<MobEffect> pEffect, int pDuration, int pAmplifier, float pProbability, int pSize) {
		return new Item.Properties().stacksTo(pSize).food(IcariaItems.foodProperties(pNutrition, pSaturation, pEffect, pDuration, pAmplifier, pProbability));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, Holder<MobEffect> pEffectA, int pDurationA, int pAmplifierA, float pProbabilityA, Holder<MobEffect> pEffectB, int pDurationB, int pAmplifierB, float pProbabilityB, int pSize) {
		return new Item.Properties().stacksTo(pSize).food(IcariaItems.foodProperties(pNutrition, pSaturation, pEffectA, pDurationA, pAmplifierA, pProbabilityA, pEffectB, pDurationB, pAmplifierB, pProbabilityB));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, int pSize, int pDurability) {
		return new Item.Properties().stacksTo(pSize).durability(pDurability).food(IcariaItems.foodProperties(pNutrition, pSaturation));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, Holder<MobEffect> pEffect, int pDuration, int pAmplifier, float pProbability, int pSize, int pDurability) {
		return new Item.Properties().stacksTo(pSize).durability(pDurability).food(IcariaItems.foodProperties(pNutrition, pSaturation, pEffect, pDuration, pAmplifier, pProbability));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, Holder<MobEffect> pEffectA, int pDurationA, int pAmplifierA, float pProbabilityA, Holder<MobEffect> pEffectB, int pDurationB, int pAmplifierB, float pProbabilityB, int pSize, int pDurability) {
		return new Item.Properties().stacksTo(pSize).durability(pDurability).food(IcariaItems.foodProperties(pNutrition, pSaturation, pEffectA, pDurationA, pAmplifierA, pProbabilityA, pEffectB, pDurationB, pAmplifierB, pProbabilityB));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation) {
		return new Item.Properties().food(IcariaItems.foodProperties(pNutrition, pSaturation));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, Holder<MobEffect> pEffect, int pDuration, int pAmplifier, float pProbability) {
		return new Item.Properties().food(IcariaItems.foodProperties(pNutrition, pSaturation, pEffect, pDuration, pAmplifier, pProbability));
	}

	public static Item.Properties propertiesFood(int pNutrition, float pSaturation, Holder<MobEffect> pEffectA, int pDurationA, int pAmplifierA, float pProbabilityA, Holder<MobEffect> pEffectB, int pDurationB, int pAmplifierB, float pProbabilityB) {
		return new Item.Properties().food(IcariaItems.foodProperties(pNutrition, pSaturation, pEffectA, pDurationA, pAmplifierA, pProbabilityA, pEffectB, pDurationB, pAmplifierB, pProbabilityB));
	}

	public static FoodProperties foodProperties(int pNutrition, float pSaturation) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationModifier(pSaturation).build();
	}

	public static FoodProperties foodProperties(int pNutrition, float pSaturation, Holder<MobEffect> pEffect, int pDuration, int pAmplifier, float pProbability) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationModifier(pSaturation).effect(() -> new MobEffectInstance(pEffect, pDuration, pAmplifier), pProbability).build();
	}

	public static FoodProperties foodProperties(int pNutrition, float pSaturation, Holder<MobEffect> pEffectA, int pDurationA, int pAmplifierA, float pProbabilityA, Holder<MobEffect> pEffectB, int pDurationB, int pAmplifierB, float pProbabilityB) {
		return new FoodProperties.Builder().nutrition(pNutrition).saturationModifier(pSaturation).effect(() -> new MobEffectInstance(pEffectA, pDurationA, pAmplifierA), pProbabilityA).effect(() -> new MobEffectInstance(pEffectB, pDurationB, pAmplifierB), pProbabilityB).build();
	}

	public static <T extends Item> Supplier<T> register(String pName, Supplier<T> pSupplier) {
		return IcariaItems.ITEMS.register(pName, pSupplier);
	}

	public static <T extends Item> Supplier<T> registerSimple(String pName, Supplier<T> pSupplier) {
		Supplier<T> registryObject = IcariaItems.register(pName, pSupplier);
		IcariaItems.SIMPLE_ITEMS.add(registryObject);
		return registryObject;
	}
}
