package com.axanthic.landsoficaria.common.registry;

import java.util.function.Supplier;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.client.util.LandsOfIcariaSounds;
import com.axanthic.landsoficaria.common.blocks.*;
import com.axanthic.landsoficaria.common.blocks.MossBlock;
import com.axanthic.landsoficaria.common.blocks.SandBlock;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LandsOfIcariaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LandsOfIcariaInfo.MODID);

	public static final RegistryObject<Block> MARL_GRASS = register("marl_grass", () -> new MarlGrassBlock(propertiesMarlGrass()));
	public static final RegistryObject<Block> MARL = register("marl", () -> new MarlBlock(propertiesMarl()));
	public static final RegistryObject<Block> MARL_CHERT = register("marl_chert", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_ROTTEN_BONES = register("marl_rotten_bones", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_LIGNITE = register("marl_lignite", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_COARSE = register("marl_coarse", () -> new MarlCoarseBlock(propertiesMarl()));

	public static final RegistryObject<Block> FARMLAND = register("farmland", () -> new FarmlandBlock(propertiesFarmland()));
	public static final RegistryObject<Block> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new FarmlandFertilizedBlock(propertiesFarmland()));

	public static final RegistryObject<Block> MARL_ADOBE = register("marl_adobe", () -> new Block(propertiesMarlAdobe()));
	public static final DecoBlockCombination MARL_ADOBE_DECO = new DecoBlockCombination("marl_adobe", MARL_ADOBE, propertiesMarlAdobe());

	//public static final RegistryObject<Block> MARL_ADOBE_SLAB = register("marl_adobe_slab", () -> new SlabBlock(propertiesMarlAdobe()));
	//public static final RegistryObject<Block> MARL_ADOBE_STAIRS = register("marl_adobe_stairs", () -> new StairBlock(MARL_ADOBE.get().defaultBlockState(), propertiesMarlAdobe()));
	//public static final RegistryObject<Block> MARL_ADOBE_WALL = register("marl_adobe_wall", () -> new WallBlock(propertiesMarlAdobe()));

	public static final RegistryObject<Block> LOAM = register("loam", () -> new SandBlock(propertiesLoam()));
	public static final RegistryObject<Block> LOAM_BRICKS = register("loam_bricks", () -> new Block(propertiesLoamBricks()));
	public static final RegistryObject<Block> LOAM_BRICKS_SLAB = register("loam_bricks_slab", () -> new SlabBlock(propertiesLoamBricks()));
	public static final RegistryObject<Block> LOAM_BRICKS_STAIRS = register("loam_bricks_stairs", () -> new StairBlock(LOAM_BRICKS.get().defaultBlockState(), propertiesLoamBricks()));
	public static final RegistryObject<Block> LOAM_BRICKS_WALL = register("loam_bricks_wall", () -> new WallBlock(propertiesLoamBricks()));

	public static final RegistryObject<Block> DOLOMITE_ADOBE = register("dolomite_adobe", () -> new Block(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_ADOBE_SLAB = register("dolomite_adobe_slab", () -> new SlabBlock(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_ADOBE_STAIRS = register("dolomite_adobe_stairs", () -> new StairBlock(DOLOMITE_ADOBE.get().defaultBlockState(), propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_ADOBE_WALL = register("dolomite_adobe_wall", () -> new WallBlock(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_SMOOTH = register("dolomite_smooth", () -> new Block(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_SMOOTH_SLAB = register("dolomite_smooth_slab", () -> new SlabBlock(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_SMOOTH_STAIRS = register("dolomite_smooth_stairs", () -> new StairBlock(DOLOMITE_SMOOTH.get().defaultBlockState(), propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_SMOOTH_WALL = register("dolomite_smooth_wall", () -> new WallBlock(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_BRICKS = register("dolomite_bricks", () -> new Block(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new AxisBlock(propertiesDolomite()));
	public static final RegistryObject<Block> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new FacingBlock(propertiesDolomite()));

	public static final RegistryObject<Block> GRAINEL = register("grainel", () -> new SandBlock(propertiesGrainel()));
	public static final RegistryObject<Block> GRAINEL_CHERT = register("grainel_chert", () -> new Block(propertiesGrainelOre()));
	public static final RegistryObject<Block> GRAINGLASS = register("grainglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINGLASS_PANE = register("grainglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINITE_ADOBE = register("grainite_adobe", () -> new Block(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_ADOBE_SLAB = register("grainite_adobe_slab", () -> new SlabBlock(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_ADOBE_STAIRS = register("grainite_adobe_stairs", () -> new StairBlock(GRAINITE_ADOBE.get().defaultBlockState(), propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_ADOBE_WALL = register("grainite_adobe_wall", () -> new WallBlock(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE = register("grainite", () -> new Block(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_SLAB = register("grainite_slab", () -> new SlabBlock(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_STAIRS = register("grainite_stairs", () -> new StairBlock(GRAINITE.get().defaultBlockState(), propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_WALL = register("grainite_wall", () -> new WallBlock(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_BRICKS = register("grainite_bricks", () -> new Block(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_BRICKS_SLAB = register("grainite_bricks_slab", () -> new SlabBlock(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_BRICKS_STAIRS = register("grainite_bricks_stairs", () -> new StairBlock(GRAINITE_BRICKS.get().defaultBlockState(), propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_BRICKS_WALL = register("grainite_bricks_wall", () -> new WallBlock(propertiesGrainite()));
	public static final RegistryObject<Block> GRAINITE_CHISELED = register("grainite_chiseled", () -> new Block(propertiesGrainite()));

	public static final RegistryObject<Block> YELLOWSTONE_ADOBE = register("yellowstone_adobe", () -> new Block(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_ADOBE_SLAB = register("yellowstone_adobe_slab", () -> new SlabBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_ADOBE_STAIRS = register("yellowstone_adobe_stairs", () -> new StairBlock(YELLOWSTONE_ADOBE.get().defaultBlockState(), propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_ADOBE_WALL = register("yellowstone_adobe_wall", () -> new WallBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_COBBLE = register("yellowstone_cobble", () -> new Block(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_COBBLE_SLAB = register("yellowstone_cobble_slab", () -> new SlabBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_COBBLE_STAIRS = register("yellowstone_cobble_stairs", () -> new StairBlock(YELLOWSTONE_COBBLE.get().defaultBlockState(), propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_COBBLE_WALL = register("yellowstone_cobble_wall", () -> new WallBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE = register("yellowstone", () -> new Block(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_SLAB = register("yellowstone_slab", () -> new SlabBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_STAIRS = register("yellowstone_stairs", () -> new StairBlock(YELLOWSTONE.get().defaultBlockState(), propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_WALL = register("yellowstone_wall", () -> new WallBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS = register("yellowstone_bricks", () -> new Block(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS_SLAB = register("yellowstone_bricks_slab", () -> new SlabBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS_STAIRS = register("yellowstone_bricks_stairs", () -> new StairBlock(YELLOWSTONE_BRICKS.get().defaultBlockState(), propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS_WALL = register("yellowstone_bricks_wall", () -> new WallBlock(propertiesYellowstone()));
	public static final RegistryObject<Block> YELLOWSTONE_CHISELED = register("yellowstone_chiseled", () -> new Block(propertiesYellowstone()));

	public static final RegistryObject<Block> SILKSAND = register("silksand", () -> new SandBlock(propertiesSilksand()));
	public static final RegistryObject<Block> SILKGLASS = register("silkglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKGLASS_PANE = register("silkglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE = register("silkstone_adobe", () -> new Block(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE_SLAB = register("silkstone_adobe_slab", () -> new SlabBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE_STAIRS = register("silkstone_adobe_stairs", () -> new StairBlock(SILKSTONE_ADOBE.get().defaultBlockState(), propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE_WALL = register("silkstone_adobe_wall", () -> new WallBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_COBBLE = register("silkstone_cobble", () -> new Block(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_COBBLE_SLAB = register("silkstone_cobble_slab", () -> new SlabBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_COBBLE_STAIRS = register("silkstone_cobble_stairs", () -> new StairBlock(SILKSTONE_COBBLE.get().defaultBlockState(), propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_COBBLE_WALL = register("silkstone_cobble_wall", () -> new WallBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE = register("silkstone", () -> new Block(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_SLAB = register("silkstone_slab", () -> new SlabBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_STAIRS = register("silkstone_stairs", () -> new StairBlock(SILKSTONE.get().defaultBlockState(), propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_WALL = register("silkstone_wall", () -> new WallBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_BRICKS = register("silkstone_bricks", () -> new Block(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_BRICKS_SLAB = register("silkstone_bricks_slab", () -> new SlabBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_BRICKS_STAIRS = register("silkstone_bricks_stairs", () -> new StairBlock(SILKSTONE_BRICKS.get().defaultBlockState(), propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_BRICKS_WALL = register("silkstone_bricks_wall", () -> new WallBlock(propertiesSilkstone()));
	public static final RegistryObject<Block> SILKSTONE_CHISELED = register("silkstone_chiseled", () -> new Block(propertiesSilkstone()));

	public static final RegistryObject<Block> SUNSTONE_ADOBE = register("sunstone_adobe", () -> new Block(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_ADOBE_SLAB = register("sunstone_adobe_slab", () -> new SlabBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_ADOBE_STAIRS = register("sunstone_adobe_stairs", () -> new StairBlock(SUNSTONE_ADOBE.get().defaultBlockState(), propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_ADOBE_WALL = register("sunstone_adobe_wall", () -> new WallBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_COBBLE = register("sunstone_cobble", () -> new Block(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_COBBLE_SLAB = register("sunstone_cobble_slab", () -> new SlabBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_COBBLE_STAIRS = register("sunstone_cobble_stairs", () -> new StairBlock(SUNSTONE_COBBLE.get().defaultBlockState(), propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_COBBLE_WALL = register("sunstone_cobble_wall", () -> new WallBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE = register("sunstone", () -> new Block(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_SLAB = register("sunstone_slab", () -> new SlabBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_STAIRS = register("sunstone_stairs", () -> new StairBlock(SUNSTONE.get().defaultBlockState(), propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_WALL = register("sunstone_wall", () -> new WallBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_BRICKS = register("sunstone_bricks", () -> new Block(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_BRICKS_SLAB = register("sunstone_bricks_slab", () -> new SlabBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_BRICKS_STAIRS = register("sunstone_bricks_stairs", () -> new StairBlock(SUNSTONE_BRICKS.get().defaultBlockState(), propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_BRICKS_WALL = register("sunstone_bricks_wall", () -> new WallBlock(propertiesSunstone()));
	public static final RegistryObject<Block> SUNSTONE_CHISELED = register("sunstone_chiseled", () -> new Block(propertiesSunstone()));

	public static final RegistryObject<Block> VOIDSHALE_ADOBE = register("voidshale_adobe", () -> new Block(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_ADOBE_SLAB = register("voidshale_adobe_slab", () -> new SlabBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_ADOBE_STAIRS = register("voidshale_adobe_stairs", () -> new StairBlock(VOIDSHALE_ADOBE.get().defaultBlockState(), propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_ADOBE_WALL = register("voidshale_adobe_wall", () -> new WallBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_COBBLE = register("voidshale_cobble", () -> new Block(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_COBBLE_SLAB = register("voidshale_cobble_slab", () -> new SlabBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_COBBLE_STAIRS = register("voidshale_cobble_stairs", () -> new StairBlock(VOIDSHALE_COBBLE.get().defaultBlockState(), propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_COBBLE_WALL = register("voidshale_cobble_wall", () -> new WallBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE = register("voidshale", () -> new Block(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_SLAB = register("voidshale_slab", () -> new SlabBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_STAIRS = register("voidshale_stairs", () -> new StairBlock(VOIDSHALE.get().defaultBlockState(), propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_WALL = register("voidshale_wall", () -> new WallBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_BRICKS = register("voidshale_bricks", () -> new Block(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_BRICKS_SLAB = register("voidshale_bricks_slab", () -> new SlabBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_BRICKS_STAIRS = register("voidshale_bricks_stairs", () -> new StairBlock(VOIDSHALE_BRICKS.get().defaultBlockState(), propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_BRICKS_WALL = register("voidshale_bricks_wall", () -> new WallBlock(propertiesVoidshale()));
	public static final RegistryObject<Block> VOIDSHALE_CHISELED = register("voidshale_chiseled", () -> new Block(propertiesVoidshale()));

	public static final RegistryObject<Block> BAETYL_ADOBE = register("baetyl_adobe", () -> new Block(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_ADOBE_SLAB = register("baetyl_adobe_slab", () -> new SlabBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_ADOBE_STAIRS = register("baetyl_adobe_stairs", () -> new StairBlock(BAETYL_ADOBE.get().defaultBlockState(), propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_ADOBE_WALL = register("baetyl_adobe_wall", () -> new WallBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_COBBLE = register("baetyl_cobble", () -> new Block(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_COBBLE_SLAB = register("baetyl_cobble_slab", () -> new SlabBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_COBBLE_STAIRS = register("baetyl_cobble_stairs", () -> new StairBlock(BAETYL_COBBLE.get().defaultBlockState(), propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_COBBLE_WALL = register("baetyl_cobble_wall", () -> new WallBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL = register("baetyl", () -> new Block(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_SLAB = register("baetyl_slab", () -> new SlabBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_STAIRS = register("baetyl_stairs", () -> new StairBlock(BAETYL.get().defaultBlockState(), propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_WALL = register("baetyl_wall", () -> new WallBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_BRICKS = register("baetyl_bricks", () -> new Block(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_BRICKS_SLAB = register("baetyl_bricks_slab", () -> new SlabBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_BRICKS_STAIRS = register("baetyl_bricks_stairs", () -> new StairBlock(BAETYL_BRICKS.get().defaultBlockState(), propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_BRICKS_WALL = register("baetyl_bricks_wall", () -> new WallBlock(propertiesBaetyl()));
	public static final RegistryObject<Block> BAETYL_CHISELED = register("baetyl_chiseled", () -> new Block(propertiesBaetyl()));

	public static final RegistryObject<Block> RELICSTONE = register("relicstone", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_SLAB = register("relicstone_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_STAIRS = register("relicstone_stairs", () -> new StairBlock(RELICSTONE.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_WALL = register("relicstone_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_SMOOTH = register("relicstone_smooth", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_SMOOTH_SLAB = register("relicstone_smooth_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_SMOOTH_STAIRS = register("relicstone_smooth_stairs", () -> new StairBlock(RELICSTONE_SMOOTH.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_SMOOTH_WALL = register("relicstone_smooth_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS = register("relicstone_bricks", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_SLAB = register("relicstone_bricks_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_STAIRS = register("relicstone_bricks_stairs", () -> new StairBlock(RELICSTONE_BRICKS.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_WALL = register("relicstone_bricks_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_CRACKED = register("relicstone_bricks_cracked", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_CRACKED_SLAB = register("relicstone_bricks_cracked_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_CRACKED_STAIRS = register("relicstone_bricks_cracked_stairs", () -> new StairBlock(RELICSTONE_BRICKS_CRACKED.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_CRACKED_WALL = register("relicstone_bricks_cracked_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_MOSSY = register("relicstone_bricks_mossy", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_MOSSY_SLAB = register("relicstone_bricks_mossy_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_MOSSY_STAIRS = register("relicstone_bricks_mossy_stairs", () -> new StairBlock(RELICSTONE_BRICKS_MOSSY.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_MOSSY_WALL = register("relicstone_bricks_mossy_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES = register("relicstone_tiles", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_SLAB = register("relicstone_tiles_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_STAIRS = register("relicstone_tiles_stairs", () -> new StairBlock(RELICSTONE_TILES.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_WALL = register("relicstone_tiles_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_CRACKED = register("relicstone_tiles_cracked", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_CRACKED_SLAB = register("relicstone_tiles_cracked_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_CRACKED_STAIRS = register("relicstone_tiles_cracked_stairs", () -> new StairBlock(RELICSTONE_TILES_CRACKED.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_CRACKED_WALL = register("relicstone_tiles_cracked_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_MOSSY = register("relicstone_tiles_mossy", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_MOSSY_SLAB = register("relicstone_tiles_mossy_slab", () -> new SlabBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_MOSSY_STAIRS = register("relicstone_tiles_mossy_stairs", () -> new StairBlock(RELICSTONE_TILES_MOSSY.get().defaultBlockState(), propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_TILES_MOSSY_WALL = register("relicstone_tiles_mossy_wall", () -> new WallBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_CHISELED = register("relicstone_chiseled", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_PILLAR = register("relicstone_pillar", () -> new AxisBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_PILLAR_HEAD = register("relicstone_pillar_head", () -> new FacingBlock(propertiesRelicstone()));

	public static final RegistryObject<Block> ARISTONE = register("aristone", () -> new GlassBlock(propertiesAristone()));
	public static final RegistryObject<Block> ARISTONE_PACKED = register("aristone_packed", () -> new Block(propertiesAristone()));

	public static final RegistryObject<Block> QUARTZ_PILLAR_HEAD = register("quartz_pillar_head", () -> new FacingBlock(propertiesQuartz()));

	public static final RegistryObject<Block> JELLYFISH_JELLY_BLOCK = register("jellyfish_jelly_block", () -> new SlimeBlock(propertiesJellyBlock()));
	public static final RegistryObject<Block> ARACHNE_STRING_BLOCK = register("arachne_string_block", () -> new Block(propertiesArachneStringBlock()));
	public static final RegistryObject<Block> SPELT_BALE_BLOCK = register("spelt_bale_block", () -> new SpeltBaleBlock(propertiesSpeltBlock()));
	public static final RegistryObject<Block> VINE_REED_BLOCK = register("vine_reed_block", () -> new Block(propertiesVineBlock()));
	public static final RegistryObject<Block> VINE_SPROUT_BLOCK = register("vine_sprout_block", () -> new Block(propertiesVineBlock()));
	public static final RegistryObject<Block> ROTTEN_BONES_BLOCK = register("rotten_bones_block", () -> new Block(propertiesRottenBonesBlock()));
	public static final RegistryObject<Block> LIGNITE_BLOCK = register("lignite_block", () -> new Block(propertiesLigniteBlock()));
	public static final RegistryObject<Block> ANTHRACITE_BLOCK = register("anthracite_block", () -> new Block(propertiesAnthraciteBlock()));
	public static final RegistryObject<Block> CHERT_BLOCK = register("chert_block", () -> new Block(propertiesChertBlock()));

	public static final RegistryObject<Block> MOSS_0 = register("moss_0", () -> new MossBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_1 = register("moss_1", () -> new MossBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_2 = register("moss_2", () -> new MossBlock(propertiesMoss()));

	private static Properties propertiesMarlGrass() {
		return Properties.of(Material.GRASS, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).explosionResistance(0.6F).strength(0.6F).randomTicks();
	}

	private static Properties propertiesMarl() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesMarlOre() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.5F).strength(0.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesFarmland() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F).randomTicks();
	}

	private static Properties propertiesMarlAdobe() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesLoam() {
		return Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F);
	}

	private static Properties propertiesLoamBricks() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesDolomite() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesGrainel() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.SAND).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesGrainelOre() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.SAND).explosionResistance(0.5F).strength(0.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesGlass() {
		return Properties.of(Material.GLASS, MaterialColor.NONE).sound(SoundType.GLASS).explosionResistance(0.3F).strength(0.3F).noOcclusion();
	}

	private static Properties propertiesGrainite() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesYellowstone() {
		return Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesSilksand() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.SAND).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesSilkstone() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesSunstone() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesVoidshale() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesBaetyl() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesRelicstone() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(1.5F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesAristone() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).sound(LandsOfIcariaSounds.ARISTONE).explosionResistance(0.5F).strength(0.5F).friction(0.98F).noOcclusion();
	}

	private static Properties propertiesQuartz() {
		return Properties.of(Material.STONE, MaterialColor.QUARTZ).sound(SoundType.STONE).explosionResistance(0.8F).strength(0.8F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesJellyBlock() {
		return Properties.of(Material.CLAY, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK).explosionResistance(0.5F).strength(0.5F).friction(0.8F).noOcclusion().instabreak();
	}

	private static Properties propertiesArachneStringBlock() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOL).explosionResistance(0.8F).strength(0.8F);
	}

	private static Properties propertiesSpeltBlock() {
		return Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.GRASS).explosionResistance(0.5F).strength(0.5F);
	}

	private static Properties propertiesVineBlock() {
		return Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).explosionResistance(2.5F).strength(0.5F);
	}

	private static Properties propertiesRottenBonesBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).sound(SoundType.BONE_BLOCK).explosionResistance(2.0F).strength(2.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesLigniteBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesAnthraciteBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesChertBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesMoss() {
		return Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).explosionResistance(0.1F).strength(0.1F);
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}

	public static class DecoBlockCombination {

		public final String name;
		public final RegistryObject<Block> original;
		public final RegistryObject<Block> SLAB;
		public final RegistryObject<Block> STAIRS;
		public final RegistryObject<Block> WALL;

		public DecoBlockCombination(String name, RegistryObject<Block> original, Properties prop, boolean slab, boolean stairs, boolean wall) {
			this.name = name;
			this.original = original;
			if (slab)
				SLAB = register(name + "_slab", () -> new SlabBlock(prop));
			else
				SLAB = null;
			if (stairs)
				STAIRS = register(name + "_stairs", () -> new StairBlock(() -> original.get().defaultBlockState(), prop));
			else
				STAIRS = null;
			if (wall)
				WALL = register(name + "_wall", () -> new WallBlock(prop));
			else
				WALL = null;
		}

		public DecoBlockCombination(String name, RegistryObject<Block> original, Properties prop) {
			this(name, original, prop, true, true, true);
		}
	}
}
