package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.client.util.IcariaSounds;
import com.axanthic.icaria.common.blocks.*;
import com.axanthic.icaria.common.blocks.LayerBlock;
import com.axanthic.icaria.common.blocks.SandTypeBlock;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault

public class IcariaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IcariaInfo.MODID);

	public static final List<RegistryObject<? extends Block>> BASIC_BLOCKS = new ArrayList<>();

	public static final RegistryObject<Block> MARL_GRASS = register("marl_grass", () -> new MarlGrassBlock(propertiesGrass()));
	public static final RegistryObject<Block> MARL = registerBasic("marl", () -> new DirtTypeBlock(propertiesMarl()));
	public static final RegistryObject<Block> MARL_CHERT = register("marl_chert", () -> new Block(propertiesMarl().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MARL_ROTTEN_BONES = register("marl_rotten_bones", () -> new Block(propertiesMarl().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MARL_LIGNITE = register("marl_lignite", () -> new Block(propertiesMarl().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MARL_COARSE = registerBasic("marl_coarse", () -> new DirtTypeBlock(propertiesMarl()));

	public static final RegistryObject<Block> FARMLAND = register("farmland", () -> new FarmlandBlock(propertiesFarmland()));
	public static final RegistryObject<Block> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new FarmlandFertilizedBlock(propertiesFarmland()));

	public static final RegistryObject<Block> MARL_ADOBE = registerBasic("marl_adobe", () -> new Block(propertiesStone(MaterialColor.COLOR_BROWN)));
	public static final StoneDecoBlocks MARL_ADOBE_DECO = new StoneDecoBlocks("marl_adobe", MARL_ADOBE, propertiesStone(MaterialColor.COLOR_BROWN));

	public static final RegistryObject<Block> LOAM = register("loam", () -> new SandTypeBlock(propertiesLoam()));
	public static final RegistryObject<Block> LOAM_BRICKS = registerBasic("loam_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks LOAM_BRICKS_DECO = new StoneDecoBlocks("loam_bricks", LOAM_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_PINK));

	public static final RegistryObject<Block> DOLOMITE_ADOBE = registerBasic("dolomite_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final StoneDecoBlocks DOLOMITE_ADOBE_DECO = new StoneDecoBlocks("dolomite_adobe", DOLOMITE_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_WHITE));
	public static final RegistryObject<Block> DOLOMITE_SMOOTH = registerBasic("dolomite_smooth", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final StoneDecoBlocks DOLOMITE_SMOOTH_DECO = new StoneDecoBlocks("dolomite_smooth", DOLOMITE_SMOOTH, propertiesStone(MaterialColor.TERRACOTTA_WHITE));
	public static final RegistryObject<Block> DOLOMITE_BRICKS = registerBasic("dolomite_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<RotatedPillarBlock> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new RotatedPillarBlock(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<PillarHeadBlock> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new PillarHeadBlock(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));

	public static final RegistryObject<Block> GRAINEL = registerBasic("grainel", () -> new SandTypeBlock(propertiesGrainel()));
	public static final RegistryObject<Block> GRAINEL_CHERT = register("grainel_chert", () -> new Block(propertiesGrainel().requiresCorrectToolForDrops()));
	public static final RegistryObject<GlassBlock> GRAINGLASS = register("grainglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> GRAINGLASS_PANE = register("grainglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINITE_ADOBE = registerBasic("grainite_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final StoneDecoBlocks GRAINITE_ADOBE_DECO = new StoneDecoBlocks("grainite_adobe", GRAINITE_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_YELLOW));
	public static final RegistryObject<Block> GRAINITE = registerBasic("grainite", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final StoneDecoBlocks GRAINITE_DECO = new StoneDecoBlocks("grainite", GRAINITE, propertiesStone(MaterialColor.TERRACOTTA_YELLOW));
	public static final RegistryObject<Block> GRAINITE_BRICKS = registerBasic("grainite_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final StoneDecoBlocks GRAINITE_BRICKS_DECO = new StoneDecoBlocks("grainite_bricks", GRAINITE_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_YELLOW));
	public static final RegistryObject<Block> GRAINITE_CHISELED = registerBasic("grainite_chiseled", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final RegistryObject<Block> GRAINITE_RUBBLE = register("grainite_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> YELLOWSTONE_ADOBE = registerBasic("yellowstone_adobe", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks YELLOWSTONE_ADOBE_DECO = new StoneDecoBlocks("yellowstone_adobe", YELLOWSTONE_ADOBE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> YELLOWSTONE_COBBLE = registerBasic("yellowstone_cobble", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks YELLOWSTONE_COBBLE_DECO = new StoneDecoBlocks("yellowstone_cobble", YELLOWSTONE_COBBLE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> YELLOWSTONE = register("yellowstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks YELLOWSTONE_DECO = new StoneDecoBlocks("yellowstone", YELLOWSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS = registerBasic("yellowstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks YELLOWSTONE_BRICKS_DECO = new StoneDecoBlocks("yellowstone_bricks", YELLOWSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> YELLOWSTONE_CHISELED = registerBasic("yellowstone_chiseled", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> YELLOWSTONE_RUBBLE = register("yellowstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> SILKSAND = registerBasic("silksand", () -> new SandTypeBlock(propertiesSilksand()));
	public static final RegistryObject<GlassBlock> SILKGLASS = register("silkglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> SILKGLASS_PANE = register("silkglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE = registerBasic("silkstone_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks SILKSTONE_ADOBE_DECO = new StoneDecoBlocks("silkstone_adobe", SILKSTONE_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> SILKSTONE_COBBLE = registerBasic("silkstone_cobble", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks SILKSTONE_COBBLE_DECO = new StoneDecoBlocks("silkstone_cobble", SILKSTONE_COBBLE, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> SILKSTONE = register("silkstone", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks SILKSTONE_DECO = new StoneDecoBlocks("silkstone", SILKSTONE, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> SILKSTONE_BRICKS = registerBasic("silkstone_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks SILKSTONE_BRICKS_DECO = new StoneDecoBlocks("silkstone_bricks", SILKSTONE_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> SILKSTONE_CHISELED = registerBasic("silkstone_chiseled", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final RegistryObject<Block> SILKSTONE_RUBBLE = register("silkstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> SUNSTONE_ADOBE = registerBasic("sunstone_adobe", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SUNSTONE_ADOBE_DECO = new StoneDecoBlocks("sunstone_adobe", SUNSTONE_ADOBE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> SUNSTONE_COBBLE = registerBasic("sunstone_cobble", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SUNSTONE_COBBLE_DECO = new StoneDecoBlocks("sunstone_cobble", SUNSTONE_COBBLE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> SUNSTONE = register("sunstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SUNSTONE_DECO = new StoneDecoBlocks("sunstone", SUNSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> SUNSTONE_BRICKS = registerBasic("sunstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SUNSTONE_BRICKS_DECO = new StoneDecoBlocks("sunstone_bricks", SUNSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> SUNSTONE_CHISELED = registerBasic("sunstone_chiseled", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> SUNSTONE_RUBBLE = register("sunstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> VOIDSHALE_ADOBE = registerBasic("voidshale_adobe", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks VOIDSHALE_ADOBE_DECO = new StoneDecoBlocks("voidshale_adobe", VOIDSHALE_ADOBE, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> VOIDSHALE_COBBLE = registerBasic("voidshale_cobble", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks VOIDSHALE_COBBLE_DECO = new StoneDecoBlocks("voidshale_cobble", VOIDSHALE_COBBLE, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> VOIDSHALE = register("voidshale", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks VOIDSHALE_DECO = new StoneDecoBlocks("voidshale", VOIDSHALE, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> VOIDSHALE_BRICKS = registerBasic("voidshale_bricks", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks VOIDSHALE_BRICKS_DECO = new StoneDecoBlocks("voidshale_bricks", VOIDSHALE_BRICKS, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> VOIDSHALE_CHISELED = registerBasic("voidshale_chiseled", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> VOIDSHALE_RUBBLE = register("voidshale_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> BAETYL_ADOBE = registerBasic("baetyl_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks BAETYL_ADOBE_DECO = new StoneDecoBlocks("baetyl_adobe", BAETYL_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> BAETYL_COBBLE = registerBasic("baetyl_cobble", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks BAETYL_COBBLE_DECO = new StoneDecoBlocks("baetyl_cobble", BAETYL_COBBLE, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> BAETYL = register("baetyl", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks BAETYL_DECO = new StoneDecoBlocks("baetyl", BAETYL, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> BAETYL_BRICKS = registerBasic("baetyl_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks BAETYL_BRICKS_DECO = new StoneDecoBlocks("baetyl_bricks", BAETYL_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> BAETYL_CHISELED = registerBasic("baetyl_chiseled", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final RegistryObject<Block> BAETYL_RUBBLE = register("baetyl_rubble", () -> new GroundDecoBlock(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));

	public static final RegistryObject<Block> RELICSTONE = registerBasic("relicstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_DECO = new StoneDecoBlocks("relicstone", RELICSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_SMOOTH = register("relicstone_smooth", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_SMOOTH_DECO = new StoneDecoBlocks("relicstone_smooth", RELICSTONE_SMOOTH, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_BRICKS = registerBasic("relicstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_BRICKS_DECO = new StoneDecoBlocks("relicstone_bricks", RELICSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_CRACKED = registerBasic("relicstone_bricks_cracked", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_BRICKS_CRACKED_DECO = new StoneDecoBlocks("relicstone_bricks_cracked", RELICSTONE_BRICKS_CRACKED, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_BRICKS_MOSSY = registerBasic("relicstone_bricks_mossy", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_BRICKS_MOSSY_DECO = new StoneDecoBlocks("relicstone_bricks_mossy", RELICSTONE_BRICKS_MOSSY, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_TILES = registerBasic("relicstone_tiles", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_TILES_DECO = new StoneDecoBlocks("relicstone_tiles", RELICSTONE_TILES, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_TILES_CRACKED = registerBasic("relicstone_tiles_cracked", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_TILES_CRACKED_DECO = new StoneDecoBlocks("relicstone_tiles_cracked", RELICSTONE_TILES_CRACKED, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_TILES_MOSSY = registerBasic("relicstone_tiles_mossy", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_TILES_MOSSY_DECO = new StoneDecoBlocks("relicstone_tiles_mossy", RELICSTONE_TILES_MOSSY, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_CHISELED = registerBasic("relicstone_chiseled", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> RELICSTONE_PILLAR = register("relicstone_pillar", () -> new RotatedPillarBlock(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> RELICSTONE_PILLAR_HEAD = register("relicstone_pillar_head", () -> new PillarHeadBlock(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> RELICSTONE_RUBBLE = register("relicstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> QUARTZ_PILLAR_HEAD = register("quartz_pillar_head", () -> new PillarHeadBlock(propertiesQuartz()));

	public static final RegistryObject<Block> LIGNITE_ORE = register("lignite_ore", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> CHALKOS_ORE = register("chalkos_ore", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> KASSITEROS_ORE = register("kassiteros_ore", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final RegistryObject<Block> DOLOMITE_ORE = register("dolomite_ore", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final RegistryObject<Block> VANADIUM_ORE = register("vanadium_ore", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> SLIVER_ORE = register("sliver_ore", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> SIDEROS_ORE = register("sideros_ore", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> ANTHRACITE_ORE = register("anthracite_ore", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> MOLYBDENUM_ORE = register("molybdenum_ore", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final RegistryObject<Block> HYLIASTRUM_ORE = register("hyliastrum_ore", () -> new HyliastrumOreBlock(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));

	public static final RegistryObject<Block> ARISTONE = registerBasic("aristone", () -> new GlassBlock(propertiesAristone()));
	public static final RegistryObject<Block> ARISTONE_PACKED = registerBasic("aristone_packed", () -> new Block(propertiesAristone()));

	public static final RegistryObject<Block> JELLYFISH_JELLY_BLOCK = registerBasic("jellyfish_jelly_block", () -> new SlimeBlock(propertiesJellyfishJellyBlock()));
	public static final RegistryObject<Block> ARACHNE_STRING_BLOCK = registerBasic("arachne_string_block", () -> new Block(propertiesArachneStringBlock()));
	public static final RegistryObject<RotatedPillarBlock> SPELT_BALE_BLOCK = register("spelt_bale_block", () -> new SpeltBaleBlock(propertiesSpeltBaleBlock()));
	public static final RegistryObject<Block> VINE_REED_BLOCK = registerBasic("vine_reed_block", () -> new Block(propertiesVineReedBlock()));
	public static final RegistryObject<Block> VINE_SPROUT_BLOCK = registerBasic("vine_sprout_block", () -> new Block(propertiesVineReedBlock()));
	public static final RegistryObject<Block> ROTTEN_BONES_BLOCK = registerBasic("rotten_bones_block", () -> new Block(propertiesRottenBonesBlock()));

	public static final RegistryObject<Block> CHALKOS_RAW_BLOCK = registerBasic("chalkos_raw_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> KASSITEROS_RAW_BLOCK = registerBasic("kassiteros_raw_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> VANADIUM_RAW_BLOCK = registerBasic("vanadium_raw_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<Block> SIDEROS_RAW_BLOCK = registerBasic("sideros_raw_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> MOLYBDENUM_RAW_BLOCK = registerBasic("molybdenum_raw_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_GRAY)));

	public static final RegistryObject<Block> CALCITE_BLOCK = registerBasic("calcite_block", () -> new HalfTransparentBlock(propertiesCrystalStorageBlock(MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<Block> HALITE_BLOCK = registerBasic("halite_block", () -> new HalfTransparentBlock(propertiesCrystalStorageBlock(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> JASPER_BLOCK = registerBasic("jasper_block", () -> new HalfTransparentBlock(propertiesCrystalStorageBlock(MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> ZIRCON_BLOCK = registerBasic("zircon_block", () -> new HalfTransparentBlock(propertiesCrystalStorageBlock(MaterialColor.COLOR_BLUE)));
	public static final RegistryObject<Block> CHERT_BLOCK = registerBasic("chert_block", () -> new Block(propertiesGemStorageBlock(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> LIGNITE_BLOCK = registerBasic("lignite_block", () -> new Block(propertiesGemStorageBlock(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> CHALKOS_BLOCK = registerBasic("chalkos_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> KASSITEROS_BLOCK = registerBasic("kassiteros_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ORICHALCUM_BLOCK = registerBasic("orichalcum_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> VANADIUM_BLOCK = registerBasic("vanadium_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<Block> VANADIUMSTEEL_BLOCK = registerBasic("vanadiumsteel_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<Block> SLIVER_BLOCK = registerBasic("sliver_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.WOOD)));
	public static final RegistryObject<Block> SIDEROS_BLOCK = registerBasic("sideros_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> ANTHRACITE_BLOCK = registerBasic("anthracite_block", () -> new Block(propertiesGemStorageBlock(MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBasic("molybdenum_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<Block> MOLYBDENUMSTEEL_BLOCK = registerBasic("molybdenumsteel_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_GRAY)));

	public static final RegistryObject<Block> CYPRESS_SAPLING = register("cypress_sapling", () -> new SaplingBlock(new OakTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = register("potted_cypress_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CYPRESS_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> CYPRESS_LEAVES = register("cypress_leaves", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FALLEN_CYPRESS_LEAVES = register("fallen_cypress_leaves", () -> new LayerBlock(propertiesLeaves()));
	public static final RegistryObject<Block> CYPRESS_TWIGS = register("cypress_twigs", () -> new GroundDecoBlock(propertiesTwigs()));
	public static final RegistryObject<RotatedPillarBlock> CYPRESS_WOOD = register("cypress_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CYPRESS_WOOD = register("stripped_cypress_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> CYPRESS_LOG = register("cypress_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CYPRESS_LOG = register("stripped_cypress_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_CYPRESS_LOG = register("dead_cypress_log", () -> new DeadLogBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_CYPRESS_LOG = register("stripped_dead_cypress_log", () -> new DeadLogBlock((propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> CYPRESS_PLANKS = registerBasic("cypress_planks", () -> new Block(propertiesPlanks(MaterialColor.COLOR_BROWN)));
	public static final WoodDecoBlocks CYPRESS_DECO = new WoodDecoBlocks("cypress", CYPRESS_PLANKS, propertiesPlanks(MaterialColor.COLOR_BROWN));
	public static final RegistryObject<DoorBlock> CYPRESS_DOOR = register("cypress_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<TrapDoorBlock> CYPRESS_TRAPDOOR = register("cypress_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> CYPRESS_LADDER = register("cypress_ladder", () -> new LadderBlock(propertiesLadder()));

	public static final RegistryObject<Block> DROUGHTROOT_SAPLING = register("droughtroot_sapling", () -> new SaplingBlock(new OakTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_DROUGHTROOT_SAPLING = register("potted_droughtroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DROUGHTROOT_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> DROUGHTROOT_LEAVES = register("droughtroot_leaves", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FALLEN_DROUGHTROOT_LEAVES = register("fallen_droughtroot_leaves", () -> new LayerBlock(propertiesLeaves()));
	public static final RegistryObject<Block> DROUGHTROOT_TWIGS = register("droughtroot_twigs", () -> new GroundDecoBlock(propertiesTwigs()));
	public static final RegistryObject<RotatedPillarBlock> DROUGHTROOT_WOOD = register("droughtroot_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_BLACK, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_DROUGHTROOT_WOOD = register("stripped_droughtroot_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> DROUGHTROOT_LOG = register("droughtroot_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_DROUGHTROOT_LOG = register("stripped_droughtroot_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> DEAD_DROUGHTROOT_LOG = register("dead_droughtroot_log", () -> new DeadLogBlock(propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_DROUGHTROOT_LOG = register("stripped_dead_droughtroot_log", () -> new DeadLogBlock((propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY))));
	public static final RegistryObject<Block> DROUGHTROOT_PLANKS = registerBasic("droughtroot_planks", () -> new Block(propertiesPlanks(MaterialColor.COLOR_GRAY)));
	public static final WoodDecoBlocks DROUGHTROOT_DECO = new WoodDecoBlocks("droughtroot", DROUGHTROOT_PLANKS, propertiesPlanks(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<DoorBlock> DROUGHTROOT_DOOR = register("droughtroot_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<TrapDoorBlock> DROUGHTROOT_TRAPDOOR = register("droughtroot_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> DROUGHTROOT_LADDER = register("droughtroot_ladder", () -> new LadderBlock(propertiesLadder()));

	public static final RegistryObject<Block> FIR_SAPLING = register("fir_sapling", () -> new SaplingBlock(new OakTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_FIR_SAPLING = register("potted_fir_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FIR_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> FIR_LEAVES = register("fir_leaves", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FALLEN_FIR_LEAVES = register("fallen_fir_leaves", () -> new LayerBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FIR_TWIGS = register("fir_twigs", () -> new GroundDecoBlock(propertiesTwigs()));
	public static final RegistryObject<RotatedPillarBlock> FIR_WOOD = register("fir_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_FIR_WOOD = register("stripped_fir_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> FIR_LOG = register("fir_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_FIR_LOG = register("stripped_fir_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_FIR_LOG = register("dead_fir_log", () -> new DeadLogBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_FIR_LOG = register("stripped_dead_fir_log", () -> new DeadLogBlock((propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> FIR_PLANKS = registerBasic("fir_planks", () -> new Block(propertiesPlanks(MaterialColor.COLOR_ORANGE)));
	public static final WoodDecoBlocks FIR_DECO = new WoodDecoBlocks("fir", FIR_PLANKS, propertiesPlanks(MaterialColor.COLOR_ORANGE));
	public static final RegistryObject<DoorBlock> FIR_DOOR = register("fir_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<TrapDoorBlock> FIR_TRAPDOOR = register("fir_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> FIR_LADDER = register("fir_ladder", () -> new LadderBlock(propertiesLadder()));

	public static final RegistryObject<Block> LAUREL_SAPLING = register("laurel_sapling", () -> new SaplingBlock(new OakTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_LAUREL_SAPLING = register("potted_laurel_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LAUREL_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> LAUREL_LEAVES = register("laurel_leaves", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FALLEN_LAUREL_LEAVES = register("fallen_laurel_leaves", () -> new LayerBlock(propertiesLeaves()));
	public static final RegistryObject<Block> LAUREL_TWIGS = register("laurel_twigs", () -> new GroundDecoBlock(propertiesTwigs()));
	public static final RegistryObject<RotatedPillarBlock> LAUREL_WOOD = register("laurel_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_LAUREL_WOOD = register("stripped_laurel_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> LAUREL_LOG = register("laurel_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_LAUREL_LOG = register("stripped_laurel_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DeadLogBlock> DEAD_LAUREL_LOG = register("dead_laurel_log", () -> new DeadLogBlock(propertiesWood(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_LAUREL_LOG = register("stripped_dead_laurel_log", () -> new DeadLogBlock((propertiesWood(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN))));
	public static final RegistryObject<Block> LAUREL_PLANKS = registerBasic("laurel_planks", () -> new Block(propertiesPlanks(MaterialColor.COLOR_BROWN)));
	public static final WoodDecoBlocks LAUREL_DECO = new WoodDecoBlocks("laurel", LAUREL_PLANKS, propertiesPlanks(MaterialColor.COLOR_BROWN));
	public static final RegistryObject<DoorBlock> LAUREL_DOOR = register("laurel_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<TrapDoorBlock> LAUREL_TRAPDOOR = register("laurel_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> LAUREL_LADDER = register("laurel_ladder", () -> new LadderBlock(propertiesLadder()));

	public static final RegistryObject<Block> OLIVE_SAPLING = register("olive_sapling", () -> new SaplingBlock(new OakTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_OLIVE_SAPLING = register("potted_olive_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, OLIVE_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> OLIVE_LEAVES = register("olive_leaves", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> OLIVE_LEAVES_BLACK = register("olive_leaves_black", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> OLIVE_LEAVES_GREEN = register("olive_leaves_green", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FALLEN_OLIVE_LEAVES = register("fallen_olive_leaves", () -> new LayerBlock(propertiesLeaves()));
	public static final RegistryObject<Block> OLIVE_TWIGS = register("olive_twigs", () -> new GroundDecoBlock(propertiesTwigs()));
	public static final RegistryObject<RotatedPillarBlock> OLIVE_WOOD = register("olive_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_OLIVE_WOOD = register("stripped_olive_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> OLIVE_LOG = register("olive_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_OLIVE_LOG = register("stripped_olive_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_OLIVE_LOG = register("dead_olive_log", () -> new DeadLogBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_OLIVE_LOG = register("stripped_dead_olive_log", () -> new DeadLogBlock((propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> OLIVE_PLANKS = registerBasic("olive_planks", () -> new Block(propertiesPlanks(MaterialColor.COLOR_ORANGE)));
	public static final WoodDecoBlocks OLIVE_DECO = new WoodDecoBlocks("olive", OLIVE_PLANKS, propertiesPlanks(MaterialColor.COLOR_ORANGE));
	public static final RegistryObject<DoorBlock> OLIVE_DOOR = register("olive_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<TrapDoorBlock> OLIVE_TRAPDOOR = register("olive_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> OLIVE_LADDER = register("olive_ladder", () -> new LadderBlock(propertiesLadder()));

	public static final RegistryObject<Block> PLANE_SAPLING = register("plane_sapling", () -> new SaplingBlock(new OakTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_PLANE_SAPLING = register("potted_plane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PLANE_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> PLANE_LEAVES = register("plane_leaves", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FALLEN_PLANE_LEAVES = register("fallen_plane_leaves", () -> new LayerBlock(propertiesLeaves()));
	public static final RegistryObject<Block> PLANE_TWIGS = register("plane_twigs", () -> new GroundDecoBlock(propertiesTwigs()));
	public static final RegistryObject<RotatedPillarBlock> PLANE_WOOD = register("plane_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PLANE_WOOD = register("stripped_plane_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> PLANE_LOG = register("plane_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PLANE_LOG = register("stripped_plane_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_PLANE_LOG = register("dead_plane_log", () -> new DeadLogBlock(propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_PLANE_LOG = register("stripped_dead_plane_log", () -> new DeadLogBlock((propertiesWood(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> PLANE_PLANKS = registerBasic("plane_planks", () -> new Block(propertiesPlanks(MaterialColor.COLOR_BROWN)));
	public static final WoodDecoBlocks PLANE_DECO = new WoodDecoBlocks("plane", PLANE_PLANKS, propertiesPlanks(MaterialColor.COLOR_BROWN));
	public static final RegistryObject<DoorBlock> PLANE_DOOR = register("plane_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<TrapDoorBlock> PLANE_TRAPDOOR = register("plane_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> PLANE_LADDER = register("plane_ladder", () -> new LadderBlock(propertiesLadder()));

	public static final RegistryObject<Block> POPULUS_SAPLING = register("populus_sapling", () -> new SaplingBlock(new OakTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_POPULUS_SAPLING = register("potted_populus_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, POPULUS_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> POPULUS_LEAVES = register("populus_leaves", () -> new LeavesBlock(propertiesLeaves()));
	public static final RegistryObject<Block> FALLEN_POPULUS_LEAVES = register("fallen_populus_leaves", () -> new LayerBlock(propertiesLeaves()));
	public static final RegistryObject<Block> POPULUS_TWIGS = register("populus_twigs", () -> new GroundDecoBlock(propertiesTwigs()));
	public static final RegistryObject<RotatedPillarBlock> POPULUS_WOOD = register("populus_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_POPULUS_WOOD = register("stripped_populus_wood", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<RotatedPillarBlock> POPULUS_LOG = register("populus_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_POPULUS_LOG = register("stripped_populus_log", () -> new RotatedPillarBlock(propertiesWood(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<DeadLogBlock> DEAD_POPULUS_LOG = register("dead_populus_log", () -> new DeadLogBlock(propertiesWood(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_POPULUS_LOG = register("stripped_dead_populus_log", () -> new DeadLogBlock((propertiesWood(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_YELLOW))));
	public static final RegistryObject<Block> POPULUS_PLANKS = registerBasic("populus_planks", () -> new Block(propertiesPlanks(MaterialColor.COLOR_GREEN)));
	public static final WoodDecoBlocks POPULUS_DECO = new WoodDecoBlocks("populus", POPULUS_PLANKS, propertiesPlanks(MaterialColor.COLOR_GREEN));
	public static final RegistryObject<DoorBlock> POPULUS_DOOR = register("populus_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<TrapDoorBlock> POPULUS_TRAPDOOR = register("populus_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<Block> POPULUS_LADDER = register("populus_ladder", () -> new LadderBlock(propertiesLadder()));

	public static final RegistryObject<Block> LIGNITE_TORCH = register("lignite_torch", () -> new TorchBlock(propertiesTorch().lightLevel((pLightEmission) -> 9), ParticleTypes.FLAME));
	public static final RegistryObject<Block> LIGNITE_WALL_TORCH = register("lignite_wall_torch", () -> new WallTorchBlock(propertiesTorch().lightLevel((pLightEmission) -> 9), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_TORCH = register("anthracite_torch", () -> new TorchBlock(propertiesTorch().lightLevel((pLightEmission) -> 14), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_WALL_TORCH = register("anthracite_wall_torch", () -> new WallTorchBlock(propertiesTorch().lightLevel((pLightEmission) -> 14), ParticleTypes.FLAME));

	public static final RegistryObject<Block> FERN = register("fern", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_FERN = register("potted_fern", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FERN, propertiesPot()));

	public static final RegistryObject<Block> SMALL_GRASS = register("small_grass", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MEDIUM_GRASS = register("medium_grass", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> LARGE_GRASS = register("large_grass", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));

	public static final RegistryObject<Block> GRAIN_0 = register("grain_0", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GRAIN_1 = register("grain_1", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GRAIN_2 = register("grain_2", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GRAIN_3 = register("grain_3", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GRAIN_4 = register("grain_4", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GRAIN_5 = register("grain_5", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));

	public static final RegistryObject<Block> BLINDWEED = register("blindweed", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_BLINDWEED = register("potted_blindweed", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLINDWEED, propertiesPot()));
	public static final RegistryObject<Block> CHAMEOMILE = register("chameomile", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_CHAMEOMILE = register("potted_chameomile", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHAMEOMILE, propertiesPot()));
	public static final RegistryObject<Block> CHARMONDER = register("charmonder", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_CHARMONDER = register("potted_charmonder", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHARMONDER, propertiesPot()));
	public static final RegistryObject<Block> CLOVER = register("clover", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_CLOVER = register("potted_clover", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CLOVER, propertiesPot()));
	public static final RegistryObject<Block> FIREHILT = register("firehilt", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_FIREHILT = register("potted_firehilt", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FIREHILT, propertiesPot()));
	public static final RegistryObject<Block> BLUE_HYDRACINTH = register("blue_hydracinth", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_BLUE_HYDRACINTH = register("potted_blue_hydracinth", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_HYDRACINTH, propertiesPot()));
	public static final RegistryObject<Block> PURPLE_HYDRACINTH = register("purple_hydracinth", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PURPLE_HYDRACINTH = register("potted_purple_hydracinth", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_HYDRACINTH, propertiesPot()));
	public static final RegistryObject<Block> LIONFANGS = register("lionfangs", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_LIONFANGS = register("potted_lionfangs", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LIONFANGS, propertiesPot()));
	public static final RegistryObject<Block> SPEARDROPS = register("speardrops", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_SPEARDROPS = register("potted_speardrops", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SPEARDROPS, propertiesPot()));
	public static final RegistryObject<Block> PURPLE_STAGHORN = register("purple_staghorn", () -> new DamagingBushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PURPLE_STAGHORN = register("potted_purple_staghorn", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_STAGHORN, propertiesPot()));
	public static final RegistryObject<Block> YELLOW_STAGHORN = register("yellow_staghorn", () -> new DamagingBushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_YELLOW_STAGHORN = register("potted_yellow_staghorn", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, YELLOW_STAGHORN, propertiesPot()));
	public static final RegistryObject<Block> BLUE_STORMCOTTON = register("blue_stormcotton", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_BLUE_STORMCOTTON = register("potted_blue_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_STORMCOTTON, propertiesPot()));
	public static final RegistryObject<Block> PINK_STORMCOTTON = register("pink_stormcotton", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PINK_STORMCOTTON = register("potted_pink_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PINK_STORMCOTTON, propertiesPot()));
	public static final RegistryObject<Block> PURPLE_STORMCOTTON = register("purple_stormcotton", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PURPLE_STORMCOTTON = register("potted_purple_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_STORMCOTTON, propertiesPot()));
	public static final RegistryObject<Block> SUNKETTLE = register("sunkettle", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_SUNKETTLE = register("potted_sunkettle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNKETTLE, propertiesPot()));
	public static final RegistryObject<Block> SUNSPONGE = register("sunsponge", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_SUNSPONGE = register("potted_sunsponge", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNSPONGE, propertiesPot()));
	public static final RegistryObject<Block> VOIDLILY = register("voidlily", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_VOIDLILY = register("potted_voidlily", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, VOIDLILY, propertiesPot()));

	public static final RegistryObject<Block> BLUE_GROUND_FLOWERS = register("blue_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> CYAN_GROUND_FLOWERS = register("cyan_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> PINK_GROUND_FLOWERS = register("pink_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> PURPLE_GROUND_FLOWERS = register("purple_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> RED_GROUND_FLOWERS = register("red_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> WHITE_GROUND_FLOWERS = register("white_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));

	public static final RegistryObject<Block> MOSS_0 = register("moss_0", () -> new LayerBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_1 = register("moss_1", () -> new LayerBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_2 = register("moss_2", () -> new LayerBlock(propertiesMoss()));

	public static final RegistryObject<Block> PALM_FERN = register("palm_fern", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));

	public static final RegistryObject<Block> WHITE_BROMELIA = register("white_bromelia", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> ORANGE_BROMELIA = register("orange_bromelia", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> PINK_BROMELIA = register("pink_bromelia", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));
	public static final RegistryObject<Block> PURPLE_BROMELIA = register("purple_bromelia", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));

	public static final RegistryObject<Block> STRAWBERRY_BUSH = register("strawberry_bush", () -> new BushTypeBlock(propertiesPlant(MaterialColor.PLANT)));

	public static final RegistryObject<Block> STRAWBERRY_CAKE = register("strawberry_cake", () -> new StrawberryCakeBlock(propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_CANDLE = register("strawberry_cake_candle", () -> new StrawberryCandleCakeBlock(Blocks.CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_WHITE_CANDLE = register("strawberry_cake_white_candle", () -> new StrawberryCandleCakeBlock(Blocks.WHITE_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_ORANGE_CANDLE = register("strawberry_cake_orange_candle", () -> new StrawberryCandleCakeBlock(Blocks.ORANGE_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_MAGENTA_CANDLE = register("strawberry_cake_magenta_candle", () -> new StrawberryCandleCakeBlock(Blocks.MAGENTA_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_LIGHT_BLUE_CANDLE = register("strawberry_cake_light_blue_candle", () -> new StrawberryCandleCakeBlock(Blocks.LIGHT_BLUE_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_YELLOW_CANDLE = register("strawberry_cake_yellow_candle", () -> new StrawberryCandleCakeBlock(Blocks.YELLOW_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_LIME_CANDLE = register("strawberry_cake_lime_candle", () -> new StrawberryCandleCakeBlock(Blocks.LIME_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_PINK_CANDLE = register("strawberry_cake_pink_candle", () -> new StrawberryCandleCakeBlock(Blocks.PINK_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_GRAY_CANDLE = register("strawberry_cake_gray_candle", () -> new StrawberryCandleCakeBlock(Blocks.GRAY_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_LIGHT_GRAY_CANDLE = register("strawberry_cake_light_gray_candle", () -> new StrawberryCandleCakeBlock(Blocks.LIGHT_GRAY_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_CYAN_CANDLE = register("strawberry_cake_cyan_candle", () -> new StrawberryCandleCakeBlock(Blocks.CYAN_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_PURPLE_CANDLE = register("strawberry_cake_purple_candle", () -> new StrawberryCandleCakeBlock(Blocks.PURPLE_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_BLUE_CANDLE = register("strawberry_cake_blue_candle", () -> new StrawberryCandleCakeBlock(Blocks.BLUE_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_BROWN_CANDLE = register("strawberry_cake_brown_candle", () -> new StrawberryCandleCakeBlock(Blocks.BROWN_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_GREEN_CANDLE = register("strawberry_cake_green_candle", () -> new StrawberryCandleCakeBlock(Blocks.GREEN_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_RED_CANDLE = register("strawberry_cake_red_candle", () -> new StrawberryCandleCakeBlock(Blocks.RED_CANDLE, propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE_BLACK_CANDLE = register("strawberry_cake_black_candle", () -> new StrawberryCandleCakeBlock(Blocks.BLACK_CANDLE, propertiesCake()));

	public static final RegistryObject<Block> SPELT_CROP = register("spelt_crop", () -> new SpeltCropBlock(propertiesCrop()));
	public static final RegistryObject<Block> STRAWBERRY_CROP = register("strawberry_crop", () -> new StrawberryCropBlock(propertiesCrop()));
	public static final RegistryObject<Block> PHYSALIS_CROP = register("physalis_crop", () -> new PhysalisCropBlock(propertiesCrop()));
	public static final RegistryObject<Block> ONION_CROP = register("onion_crop", () -> new OnionCropBlock(propertiesCrop()));

	public static final RegistryObject<LiquidBlock> HYLIASTRUM_FLUID = register("hyliastrum_fluid", () -> new LiquidBlock(IcariaFluids.HYLIASTRUM_FLUID_SOURCE, propertiesFluid(MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<LiquidBlock> MEDITERRANEAN_WATER = register("mediterranean_water", () -> new LiquidBlock(IcariaFluids.MEDITERRANEAN_WATER_SOURCE, propertiesFluid(MaterialColor.WATER)));
	public static final RegistryObject<LiquidBlock> UPWARDS_FLUID = register("upwards_fluid", () -> new LiquidBlock(IcariaFluids.UPWARDS_FLUID_SOURCE, propertiesFluid(MaterialColor.WATER)));

	private static Properties propertiesGrass() {
		return Properties.of(Material.GRASS, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).strength(0.6F, 0.6F).randomTicks();
	}

	private static Properties propertiesMarl() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).strength(0.5F, 0.5F);
	}

	private static Properties propertiesFarmland() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).strength(0.6F, 0.6F).randomTicks();
	}

	private static Properties propertiesLoam() {
		return Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.GRAVEL).strength(0.6F, 0.6F);
	}

	private static Properties propertiesGrainel() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.SAND).strength(0.5F, 0.5F);
	}

	private static Properties propertiesGlass() {
		return Properties.of(Material.GLASS, MaterialColor.NONE).sound(SoundType.GLASS).strength(0.3F, 0.3F).noOcclusion();
	}

	private static Properties propertiesSilksand() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.SAND).strength(0.5F, 0.5F);
	}

	private static Properties propertiesStone(MaterialColor pMaterialColor) {
		return Properties.of(Material.STONE, pMaterialColor).sound(SoundType.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesRubble() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.STONE).instabreak().noCollission().noOcclusion();
	}

	private static Properties propertiesQuartz() {
		return Properties.of(Material.STONE, MaterialColor.QUARTZ).sound(SoundType.STONE).strength(0.8F, 0.8F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesAristone() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).sound(IcariaSounds.ARISTONE).strength(0.5F, 0.5F).friction(0.98F).noOcclusion();
	}

	private static Properties propertiesJellyfishJellyBlock() {
		return Properties.of(Material.CLAY, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK).strength(0.5F, 0.5F).friction(0.8F).noOcclusion().instabreak();
	}

	private static Properties propertiesArachneStringBlock() {
		return Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN).sound(SoundType.WOOL).strength(0.8F, 0.8F);
	}

	private static Properties propertiesSpeltBaleBlock() {
		return Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.GRASS).strength(0.5F, 0.5F);
	}

	private static Properties propertiesVineReedBlock() {
		return Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(0.5F, 2.5F);
	}

	private static Properties propertiesRottenBonesBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).sound(SoundType.BONE_BLOCK).strength(2.0F, 2.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesCrystalStorageBlock(MaterialColor pMaterialColor) {
		return Properties.of(Material.GLASS, pMaterialColor).sound(SoundType.GLASS).strength(1.2F, 1.2F).lightLevel((pLightEmission) -> 6).noOcclusion().requiresCorrectToolForDrops();
	}

	private static Properties propertiesGemStorageBlock(MaterialColor pMaterialColor) {
		return Properties.of(Material.STONE, pMaterialColor).sound(SoundType.STONE).strength(5.0F, 6.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesMetalStorageBlock(MaterialColor pMaterialColor) {
		return Properties.of(Material.METAL, pMaterialColor).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesSapling() {
		return Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).instabreak().noCollission().randomTicks();
	}

	private static Properties propertiesPot() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).instabreak().noOcclusion();
	}

	private static Properties propertiesLeaves() {
		return Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).strength(0.2F, 0.2F).isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false).noOcclusion().randomTicks();
	}

	private static Properties propertiesTwigs() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.WOOD).instabreak().noCollission().noOcclusion();
	}

	private static Properties propertiesWood(MaterialColor pMaterialColorEnd, MaterialColor pMaterialColorSide) {
		return Properties.of(Material.WOOD, (pState) -> pState.getValue(RotatedPillarBlock.AXIS) == Axis.Y ? pMaterialColorEnd : pMaterialColorSide).sound(SoundType.WOOD).strength(2.0F, 2.0F).noOcclusion();
	}

	private static Properties propertiesPlanks(MaterialColor pMaterialColor) {
		return Properties.of(Material.WOOD, pMaterialColor).sound(SoundType.WOOD).strength(2.0F, 3.0F);
	}

	private static Properties propertiesDoor(MaterialColor pMaterialColor) {
		return Properties.of(Material.WOOD, pMaterialColor).sound(SoundType.WOOD).strength(3.0F, 3.0F).noOcclusion();
	}

	private static Properties propertiesLadder() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.LADDER).strength(0.4F, 0.4F).noOcclusion();
	}

	private static Properties propertiesTorch() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.METAL).instabreak().noCollission();
	}

	private static Properties propertiesPlant(MaterialColor pMaterialColor) {
		return Properties.of(Material.PLANT, pMaterialColor).sound(SoundType.GRASS).instabreak().noCollission();
	}

	private static Properties propertiesMoss() {
		return Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).strength(0.1F, 0.1F);
	}

	private static Properties propertiesCake() {
		return Properties.of(Material.CAKE, MaterialColor.NONE).sound(SoundType.WOOL).strength(0.5F, 0.5F);
	}

	private static Properties propertiesCrop() {
		return Properties.of(Material.PLANT, MaterialColor.PLANT).sound(SoundType.CROP).instabreak().noCollission().randomTicks();
	}

	private static Properties propertiesFluid(MaterialColor pMaterialColor) {
		return Properties.of(Material.LAVA, pMaterialColor).strength(100.0F, 100.0F).noCollission().noDrops();
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> sup) {
		return BLOCKS.register(name, sup);
	}

	private static <T extends Block> RegistryObject<T> registerBasic(final String name, final Supplier<? extends T> sup) {
		RegistryObject<T> registeredBlock = register(name, sup);
		BASIC_BLOCKS.add(registeredBlock);
		return registeredBlock;
	}

	public static class StoneDecoBlocks {
		public final String name;
		public final RegistryObject<Block> original;
		public final RegistryObject<SlabBlock> SLAB;
		public final RegistryObject<StairBlock> STAIRS;
		public final RegistryObject<WallBlock> WALL;

		public StoneDecoBlocks(String name, RegistryObject<Block> original, Properties properties, boolean slab, boolean stairs, boolean wall) {
			this.name = name;
			this.original = original;
			if (slab)
				SLAB = register(name + "_slab", () -> new SlabBlock(properties));
			else
				SLAB = null;
			if (stairs)
				STAIRS = register(name + "_stairs", () -> new StairBlock(() -> original.get().defaultBlockState(), properties));
			else
				STAIRS = null;
			if (wall)
				WALL = register(name + "_wall", () -> new WallBlock(properties));
			else
				WALL = null;
		}

		public StoneDecoBlocks(String name, RegistryObject<Block> original, Properties properties) {
			this(name, original, properties, true, true, true);
		}
	}

	public static class WoodDecoBlocks {
		public final String name;
		public final RegistryObject<Block> original;
		public final RegistryObject<SlabBlock> SLAB;
		public final RegistryObject<StairBlock> STAIRS;
		public final RegistryObject<FenceBlock> FENCE;
		public final RegistryObject<FenceGateBlock> GATE;

		public WoodDecoBlocks(String name, RegistryObject<Block> original, Properties properties, boolean slab, boolean stairs, boolean fence, boolean gate) {
			this.name = name;
			this.original = original;
			if (slab)
				SLAB = register(name + "_slab", () -> new SlabBlock(properties));
			else
				SLAB = null;
			if (stairs)
				STAIRS = register(name + "_stairs", () -> new StairBlock(() -> original.get().defaultBlockState(), properties));
			else
				STAIRS = null;
			if (fence)
				FENCE = register(name + "_fence", () -> new FenceBlock(properties));
			else
				FENCE = null;
			if (gate)
				GATE = register(name + "_fence_gate", () -> new FenceGateBlock(properties));
			else
				GATE = null;
		}

		public WoodDecoBlocks(String name, RegistryObject<Block> original, Properties properties) {
			this(name, original, properties, true, true, true, true);
		}
	}
}
