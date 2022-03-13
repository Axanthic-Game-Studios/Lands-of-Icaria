package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.client.util.IcariaSounds;
import com.axanthic.icaria.common.blocks.*;
import com.axanthic.icaria.common.blocks.MossBlock;
import com.axanthic.icaria.common.blocks.SandTypeBlock;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.*;
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

	public static final RegistryObject<Block> MARL_GRASS = register("marl_grass", () -> new MarlGrassBlock(propertiesMarlGrass()));
	public static final RegistryObject<Block> MARL = registerBasic("marl", () -> new DirtTypeBlock(propertiesMarl()));
	public static final RegistryObject<Block> MARL_CHERT = register("marl_chert", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_ROTTEN_BONES = register("marl_rotten_bones", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_LIGNITE = register("marl_lignite", () -> new Block(propertiesMarlOre()));
	public static final RegistryObject<Block> MARL_COARSE = registerBasic("marl_coarse", () -> new DirtTypeBlock(propertiesMarl()));

	public static final RegistryObject<Block> FARMLAND = register("farmland", () -> new FarmlandBlock(propertiesFarmland()));
	public static final RegistryObject<Block> FARMLAND_FERTILIZED = register("farmland_fertilized", () -> new FarmlandFertilizedBlock(propertiesFarmland()));

	public static final RegistryObject<Block> MARL_ADOBE = registerBasic("marl_adobe", () -> new Block(propertiesMarlAdobe()));
	public static final StoneDecoBlocks MARL_ADOBE_DECO = new StoneDecoBlocks("marl_adobe", MARL_ADOBE, propertiesMarlAdobe());

	public static final RegistryObject<Block> LOAM = register("loam", () -> new SandTypeBlock(propertiesLoam()));
	public static final RegistryObject<Block> LOAM_BRICKS = registerBasic("loam_bricks", () -> new Block(propertiesLoamBricks()));
	public static final StoneDecoBlocks LOAM_BRICKS_DECO = new StoneDecoBlocks("loam_bricks", LOAM_BRICKS, propertiesLoamBricks());

	public static final RegistryObject<Block> DOLOMITE_ADOBE = registerBasic("dolomite_adobe", () -> new Block(propertiesDolomite()));
	public static final StoneDecoBlocks DOLOMITE_ADOBE_DECO = new StoneDecoBlocks("dolomite_adobe", DOLOMITE_ADOBE, propertiesDolomite());
	public static final RegistryObject<Block> DOLOMITE_SMOOTH = registerBasic("dolomite_smooth", () -> new Block(propertiesDolomite()));
	public static final StoneDecoBlocks DOLOMITE_SMOOTH_DECO = new StoneDecoBlocks("dolomite_smooth", DOLOMITE_SMOOTH, propertiesDolomite());
	public static final RegistryObject<Block> DOLOMITE_BRICKS = registerBasic("dolomite_bricks", () -> new Block(propertiesDolomite()));
	public static final RegistryObject<RotatedPillarBlock> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new RotatedPillarBlock(propertiesDolomite()));
	public static final RegistryObject<PillarHeadBlock> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new PillarHeadBlock(propertiesDolomite()));

	public static final RegistryObject<Block> GRAINEL = registerBasic("grainel", () -> new SandTypeBlock(propertiesGrainel()));
	public static final RegistryObject<Block> GRAINEL_CHERT = register("grainel_chert", () -> new Block(propertiesGrainelOre()));
	public static final RegistryObject<Block> GRAINGLASS = register("grainglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> GRAINGLASS_PANE = register("grainglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINGLASS_PANE_HORIZONTAL = register("grainglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINITE_ADOBE = registerBasic("grainite_adobe", () -> new Block(propertiesGrainite()));
	public static final StoneDecoBlocks GRAINITE_ADOBE_DECO = new StoneDecoBlocks("grainite_adobe", GRAINITE_ADOBE, propertiesGrainite());
	public static final RegistryObject<Block> GRAINITE = registerBasic("grainite", () -> new Block(propertiesGrainite()));
	public static final StoneDecoBlocks GRAINITE_DECO = new StoneDecoBlocks("grainite", GRAINITE, propertiesGrainite());
	public static final RegistryObject<Block> GRAINITE_BRICKS = registerBasic("grainite_bricks", () -> new Block(propertiesGrainite()));
	public static final StoneDecoBlocks GRAINITE_BRICKS_DECO = new StoneDecoBlocks("grainite_bricks", GRAINITE_BRICKS, propertiesGrainite());
	public static final RegistryObject<Block> GRAINITE_CHISELED = registerBasic("grainite_chiseled", () -> new Block(propertiesGrainite()));

	public static final RegistryObject<Block> YELLOWSTONE_ADOBE = registerBasic("yellowstone_adobe", () -> new Block(propertiesYellowstone()));
	public static final StoneDecoBlocks YELLOWSTONE_ADOBE_DECO = new StoneDecoBlocks("yellowstone_adobe", YELLOWSTONE_ADOBE, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE_COBBLE = registerBasic("yellowstone_cobble", () -> new Block(propertiesYellowstone()));
	public static final StoneDecoBlocks YELLOWSTONE_COBBLE_DECO = new StoneDecoBlocks("yellowstone_cobble", YELLOWSTONE_COBBLE, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE = register("yellowstone", () -> new Block(propertiesYellowstone()));
	public static final StoneDecoBlocks YELLOWSTONE_DECO = new StoneDecoBlocks("yellowstone", YELLOWSTONE, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS = registerBasic("yellowstone_bricks", () -> new Block(propertiesYellowstone()));
	public static final StoneDecoBlocks YELLOWSTONE_BRICKS_DECO = new StoneDecoBlocks("yellowstone_bricks", YELLOWSTONE_BRICKS, propertiesYellowstone());
	public static final RegistryObject<Block> YELLOWSTONE_CHISELED = registerBasic("yellowstone_chiseled", () -> new Block(propertiesYellowstone()));

	public static final RegistryObject<Block> SILKSAND = registerBasic("silksand", () -> new SandTypeBlock(propertiesSilksand()));
	public static final RegistryObject<Block> SILKGLASS = register("silkglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> SILKGLASS_PANE = register("silkglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKGLASS_PANE_HORIZONTAL = register("silkglass_pane_horizontal", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE = registerBasic("silkstone_adobe", () -> new Block(propertiesSilkstone()));
	public static final StoneDecoBlocks SILKSTONE_ADOBE_DECO = new StoneDecoBlocks("silkstone_adobe", SILKSTONE_ADOBE, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE_COBBLE = registerBasic("silkstone_cobble", () -> new Block(propertiesSilkstone()));
	public static final StoneDecoBlocks SILKSTONE_COBBLE_DECO = new StoneDecoBlocks("silkstone_cobble", SILKSTONE_COBBLE, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE = register("silkstone", () -> new Block(propertiesSilkstone()));
	public static final StoneDecoBlocks SILKSTONE_DECO = new StoneDecoBlocks("silkstone", SILKSTONE, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE_BRICKS = registerBasic("silkstone_bricks", () -> new Block(propertiesSilkstone()));
	public static final StoneDecoBlocks SILKSTONE_BRICKS_DECO = new StoneDecoBlocks("silkstone_bricks", SILKSTONE_BRICKS, propertiesSilkstone());
	public static final RegistryObject<Block> SILKSTONE_CHISELED = registerBasic("silkstone_chiseled", () -> new Block(propertiesSilkstone()));

	public static final RegistryObject<Block> SUNSTONE_ADOBE = registerBasic("sunstone_adobe", () -> new Block(propertiesSunstone()));
	public static final StoneDecoBlocks SUNSTONE_ADOBE_DECO = new StoneDecoBlocks("sunstone_adobe", SUNSTONE_ADOBE, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE_COBBLE = registerBasic("sunstone_cobble", () -> new Block(propertiesSunstone()));
	public static final StoneDecoBlocks SUNSTONE_COBBLE_DECO = new StoneDecoBlocks("sunstone_cobble", SUNSTONE_COBBLE, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE = register("sunstone", () -> new Block(propertiesSunstone()));
	public static final StoneDecoBlocks SUNSTONE_DECO = new StoneDecoBlocks("sunstone", SUNSTONE, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE_BRICKS = registerBasic("sunstone_bricks", () -> new Block(propertiesSunstone()));
	public static final StoneDecoBlocks SUNSTONE_BRICKS_DECO = new StoneDecoBlocks("sunstone_bricks", SUNSTONE_BRICKS, propertiesSunstone());
	public static final RegistryObject<Block> SUNSTONE_CHISELED = registerBasic("sunstone_chiseled", () -> new Block(propertiesSunstone()));

	public static final RegistryObject<Block> VOIDSHALE_ADOBE = registerBasic("voidshale_adobe", () -> new Block(propertiesVoidshale()));
	public static final StoneDecoBlocks VOIDSHALE_ADOBE_DECO = new StoneDecoBlocks("voidshale_adobe", VOIDSHALE_ADOBE, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE_COBBLE = registerBasic("voidshale_cobble", () -> new Block(propertiesVoidshale()));
	public static final StoneDecoBlocks VOIDSHALE_COBBLE_DECO = new StoneDecoBlocks("voidshale_cobble", VOIDSHALE_COBBLE, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE = register("voidshale", () -> new Block(propertiesVoidshale()));
	public static final StoneDecoBlocks VOIDSHALE_DECO = new StoneDecoBlocks("voidshale", VOIDSHALE, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE_BRICKS = registerBasic("voidshale_bricks", () -> new Block(propertiesVoidshale()));
	public static final StoneDecoBlocks VOIDSHALE_BRICKS_DECO = new StoneDecoBlocks("voidshale_bricks", VOIDSHALE_BRICKS, propertiesVoidshale());
	public static final RegistryObject<Block> VOIDSHALE_CHISELED = registerBasic("voidshale_chiseled", () -> new Block(propertiesVoidshale()));

	public static final RegistryObject<Block> BAETYL_ADOBE = registerBasic("baetyl_adobe", () -> new Block(propertiesBaetyl()));
	public static final StoneDecoBlocks BAETYL_ADOBE_DECO = new StoneDecoBlocks("baetyl_adobe", BAETYL_ADOBE, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL_COBBLE = registerBasic("baetyl_cobble", () -> new Block(propertiesBaetyl()));
	public static final StoneDecoBlocks BAETYL_COBBLE_DECO = new StoneDecoBlocks("baetyl_cobble", BAETYL_COBBLE, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL = register("baetyl", () -> new Block(propertiesBaetyl()));
	public static final StoneDecoBlocks BAETYL_DECO = new StoneDecoBlocks("baetyl", BAETYL, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL_BRICKS = registerBasic("baetyl_bricks", () -> new Block(propertiesBaetyl()));
	public static final StoneDecoBlocks BAETYL_BRICKS_DECO = new StoneDecoBlocks("baetyl_bricks", BAETYL_BRICKS, propertiesBaetyl());
	public static final RegistryObject<Block> BAETYL_CHISELED = registerBasic("baetyl_chiseled", () -> new Block(propertiesBaetyl()));

	public static final RegistryObject<Block> RELICSTONE = registerBasic("relicstone", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_DECO = new StoneDecoBlocks("relicstone", RELICSTONE, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_SMOOTH = register("relicstone_smooth", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_SMOOTH_DECO = new StoneDecoBlocks("relicstone_smooth", RELICSTONE_SMOOTH, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_BRICKS = registerBasic("relicstone_bricks", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_BRICKS_DECO = new StoneDecoBlocks("relicstone_bricks", RELICSTONE_BRICKS, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_BRICKS_CRACKED = registerBasic("relicstone_bricks_cracked", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_BRICKS_CRACKED_DECO = new StoneDecoBlocks("relicstone_bricks_cracked", RELICSTONE_BRICKS_CRACKED, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_BRICKS_MOSSY = registerBasic("relicstone_bricks_mossy", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_BRICKS_MOSSY_DECO = new StoneDecoBlocks("relicstone_bricks_mossy", RELICSTONE_BRICKS_MOSSY, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_TILES = registerBasic("relicstone_tiles", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_TILES_DECO = new StoneDecoBlocks("relicstone_tiles", RELICSTONE_TILES, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_TILES_CRACKED = registerBasic("relicstone_tiles_cracked", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_TILES_CRACKED_DECO = new StoneDecoBlocks("relicstone_tiles_cracked", RELICSTONE_TILES_CRACKED, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_TILES_MOSSY = registerBasic("relicstone_tiles_mossy", () -> new Block(propertiesRelicstone()));
	public static final StoneDecoBlocks RELICSTONE_TILES_MOSSY_DECO = new StoneDecoBlocks("relicstone_tiles_mossy", RELICSTONE_TILES_MOSSY, propertiesRelicstone());
	public static final RegistryObject<Block> RELICSTONE_CHISELED = registerBasic("relicstone_chiseled", () -> new Block(propertiesRelicstone()));
	public static final RegistryObject<RotatedPillarBlock> RELICSTONE_PILLAR = register("relicstone_pillar", () -> new RotatedPillarBlock(propertiesRelicstone()));
	public static final RegistryObject<Block> RELICSTONE_PILLAR_HEAD = register("relicstone_pillar_head", () -> new PillarHeadBlock(propertiesRelicstone()));

	public static final RegistryObject<Block> LIGNITE_ORE = register("lignite_ore", () -> new Block(propertiesYellowstone()));
	public static final RegistryObject<Block> CHALKOS_ORE = register("chalkos_ore", () -> new Block(propertiesYellowstone()));
	public static final RegistryObject<Block> KASSITEROS_ORE = register("kassiteros_ore", () -> new Block(propertiesSilkstone()));
	public static final RegistryObject<Block> DOLOMITE_ORE = register("dolomite_ore", () -> new Block(propertiesSilkstone()));
	public static final RegistryObject<Block> VANADIUM_ORE = register("vanadium_ore", () -> new Block(propertiesSunstone()));
	public static final RegistryObject<Block> SLIVER_ORE = register("sliver_ore", () -> new Block(propertiesSunstone()));
	public static final RegistryObject<Block> SIDEROS_ORE = register("sideros_ore", () -> new Block(propertiesVoidshale()));
	public static final RegistryObject<Block> ANTHRACITE_ORE = register("anthracite_ore", () -> new Block(propertiesVoidshale()));
	public static final RegistryObject<Block> MOLYBDENUM_ORE = register("molybdenum_ore", () -> new Block(propertiesBaetyl()));
	public static final RegistryObject<Block> HYLIASTRUM_ORE = register("hyliastrum_ore", () -> new HyliastrumOreBlock(propertiesBaetyl()));

	public static final RegistryObject<Block> ARISTONE = registerBasic("aristone", () -> new GlassBlock(propertiesAristone()));
	public static final RegistryObject<Block> ARISTONE_PACKED = registerBasic("aristone_packed", () -> new Block(propertiesAristone()));

	public static final RegistryObject<Block> QUARTZ_PILLAR_HEAD = register("quartz_pillar_head", () -> new PillarHeadBlock(propertiesQuartz()));

	public static final RegistryObject<Block> JELLYFISH_JELLY_BLOCK = registerBasic("jellyfish_jelly_block", () -> new SlimeBlock(propertiesJellyBlock()));
	public static final RegistryObject<Block> ARACHNE_STRING_BLOCK = registerBasic("arachne_string_block", () -> new Block(propertiesArachneStringBlock()));
	public static final RegistryObject<RotatedPillarBlock> SPELT_BALE_BLOCK = register("spelt_bale_block", () -> new SpeltBaleBlock(propertiesSpeltBlock()));
	public static final RegistryObject<Block> VINE_REED_BLOCK = registerBasic("vine_reed_block", () -> new Block(propertiesVineBlock()));
	public static final RegistryObject<Block> VINE_SPROUT_BLOCK = registerBasic("vine_sprout_block", () -> new Block(propertiesVineBlock()));
	public static final RegistryObject<Block> ROTTEN_BONES_BLOCK = registerBasic("rotten_bones_block", () -> new Block(propertiesRottenBonesBlock()));

	public static final RegistryObject<Block> CHALKOS_RAW_BLOCK = registerBasic("chalkos_raw_block", () -> new Block(propertiesChalkosBlock()));
	public static final RegistryObject<Block> KASSITEROS_RAW_BLOCK = registerBasic("kassiteros_raw_block", () -> new Block(propertiesKassiterosBlock()));
	public static final RegistryObject<Block> VANADIUM_RAW_BLOCK = registerBasic("vanadium_raw_block", () -> new Block(propertiesVanadiumBlock()));
	public static final RegistryObject<Block> SIDEROS_RAW_BLOCK = registerBasic("sideros_raw_block", () -> new Block(propertiesSiderosBlock()));
	public static final RegistryObject<Block> MOLYBDENUM_RAW_BLOCK = registerBasic("molybdenum_raw_block", () -> new Block(propertiesMolybdenumBlock()));

	public static final RegistryObject<Block> CHERT_BLOCK = registerBasic("chert_block", () -> new Block(propertiesChertBlock()));
	public static final RegistryObject<Block> LIGNITE_BLOCK = registerBasic("lignite_block", () -> new Block(propertiesLigniteBlock()));
	public static final RegistryObject<Block> CHALKOS_BLOCK = registerBasic("chalkos_block", () -> new Block(propertiesChalkosBlock()));
	public static final RegistryObject<Block> KASSITEROS_BLOCK = registerBasic("kassiteros_block", () -> new Block(propertiesKassiterosBlock()));
	public static final RegistryObject<Block> ORICHALCUM_BLOCK = registerBasic("orichalcum_block", () -> new Block(propertiesOrichalcumBlock()));
	public static final RegistryObject<Block> VANADIUM_BLOCK = registerBasic("vanadium_block", () -> new Block(propertiesVanadiumBlock()));
	public static final RegistryObject<Block> VANADIUMSTEEL_BLOCK = registerBasic("vanadiumsteel_block", () -> new Block(propertiesVanadiumBlock()));
	public static final RegistryObject<Block> SLIVER_BLOCK = registerBasic("sliver_block", () -> new Block(propertiesSliverBlock()));
	public static final RegistryObject<Block> SIDEROS_BLOCK = registerBasic("sideros_block", () -> new Block(propertiesSiderosBlock()));
	public static final RegistryObject<Block> ANTHRACITE_BLOCK = registerBasic("anthracite_block", () -> new Block(propertiesAnthraciteBlock()));
	public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBasic("molybdenum_block", () -> new Block(propertiesMolybdenumBlock()));
	public static final RegistryObject<Block> MOLYBDENUMSTEEL_BLOCK = registerBasic("molybdenumsteel_block", () -> new Block(propertiesMolybdenumBlock()));

	public static final RegistryObject<RotatedPillarBlock> CYPRESS_WOOD = register("cypress_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CYPRESS_WOOD = register("stripped_cypress_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> CYPRESS_LOG = register("cypress_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CYPRESS_LOG = register("stripped_cypress_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_CYPRESS_LOG = register("dead_cypress_log", () -> new DeadLogBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_CYPRESS_LOG = register("stripped_dead_cypress_log", () -> new DeadLogBlock((propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> CYPRESS_PLANKS = registerBasic("cypress_planks", () -> new Block(propertiesCypressWood()));
	public static final WoodDecoBlocks CYPRESS_DECO = new WoodDecoBlocks("cypress", CYPRESS_PLANKS, propertiesCypressWood());

	public static final RegistryObject<RotatedPillarBlock> DROUGHTROOT_WOOD = register("droughtroot_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_BLACK, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_DROUGHTROOT_WOOD = register("stripped_droughtroot_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> DROUGHTROOT_LOG = register("droughtroot_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_DROUGHTROOT_LOG = register("stripped_droughtroot_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> DEAD_DROUGHTROOT_LOG = register("dead_droughtroot_log", () -> new DeadLogBlock(propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_DROUGHTROOT_LOG = register("stripped_dead_droughtroot_log", () -> new DeadLogBlock((propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY))));
	public static final RegistryObject<Block> DROUGHTROOT_PLANKS = registerBasic("droughtroot_planks", () -> new Block(propertiesDroughtrootWood()));
	public static final WoodDecoBlocks DROUGHTROOT_DECO = new WoodDecoBlocks("droughtroot", DROUGHTROOT_PLANKS, propertiesDroughtrootWood());

	public static final RegistryObject<RotatedPillarBlock> FIR_WOOD = register("fir_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_FIR_WOOD = register("stripped_fir_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> FIR_LOG = register("fir_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_FIR_LOG = register("stripped_fir_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_FIR_LOG = register("dead_fir_log", () -> new DeadLogBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_FIR_LOG = register("stripped_dead_fir_log", () -> new DeadLogBlock((propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> FIR_PLANKS = registerBasic("fir_planks", () -> new Block(propertiesFirWood()));
	public static final WoodDecoBlocks FIR_DECO = new WoodDecoBlocks("fir", FIR_PLANKS, propertiesFirWood());

	public static final RegistryObject<RotatedPillarBlock> LAUREL_WOOD = register("laurel_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_LAUREL_WOOD = register("stripped_laurel_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> LAUREL_LOG = register("laurel_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_LAUREL_LOG = register("stripped_laurel_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DeadLogBlock> DEAD_LAUREL_LOG = register("dead_laurel_log", () -> new DeadLogBlock(propertiesLogs(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_LAUREL_LOG = register("stripped_dead_laurel_log", () -> new DeadLogBlock((propertiesLogs(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN))));
	public static final RegistryObject<Block> LAUREL_PLANKS = registerBasic("laurel_planks", () -> new Block(propertiesLaurelWood()));
	public static final WoodDecoBlocks LAUREL_DECO = new WoodDecoBlocks("laurel", LAUREL_PLANKS, propertiesLaurelWood());

	public static final RegistryObject<RotatedPillarBlock> OLIVE_WOOD = register("olive_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_OLIVE_WOOD = register("stripped_olive_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> OLIVE_LOG = register("olive_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_OLIVE_LOG = register("stripped_olive_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_OLIVE_LOG = register("dead_olive_log", () -> new DeadLogBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_OLIVE_LOG = register("stripped_dead_olive_log", () -> new DeadLogBlock((propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> OLIVE_PLANKS = registerBasic("olive_planks", () -> new Block(propertiesOliveWood()));
	public static final WoodDecoBlocks OLIVE_DECO = new WoodDecoBlocks("olive", OLIVE_PLANKS, propertiesOliveWood());

	public static final RegistryObject<RotatedPillarBlock> PLANE_WOOD = register("plane_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PLANE_WOOD = register("stripped_plane_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<RotatedPillarBlock> PLANE_LOG = register("plane_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PLANE_LOG = register("stripped_plane_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DeadLogBlock> DEAD_PLANE_LOG = register("dead_plane_log", () -> new DeadLogBlock(propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_PLANE_LOG = register("stripped_dead_plane_log", () -> new DeadLogBlock((propertiesLogs(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE))));
	public static final RegistryObject<Block> PLANE_PLANKS = registerBasic("plane_planks", () -> new Block(propertiesPlaneWood()));
	public static final WoodDecoBlocks PLANE_DECO = new WoodDecoBlocks("plane", PLANE_PLANKS, propertiesPlaneWood());

	public static final RegistryObject<RotatedPillarBlock> POPULUS_WOOD = register("populus_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_POPULUS_WOOD = register("stripped_populus_wood", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<RotatedPillarBlock> POPULUS_LOG = register("populus_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_POPULUS_LOG = register("stripped_populus_log", () -> new RotatedPillarBlock(propertiesLogs(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<DeadLogBlock> DEAD_POPULUS_LOG = register("dead_populus_log", () -> new DeadLogBlock(propertiesLogs(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_POPULUS_LOG = register("stripped_dead_populus_log", () -> new DeadLogBlock((propertiesLogs(MaterialColor.COLOR_YELLOW, MaterialColor.COLOR_YELLOW))));
	public static final RegistryObject<Block> POPULUS_PLANKS = registerBasic("populus_planks", () -> new Block(propertiesPopulusWood()));
	public static final WoodDecoBlocks POPULUS_DECO = new WoodDecoBlocks("populus", POPULUS_PLANKS, propertiesPopulusWood());

	public static final RegistryObject<Block> LIGNITE_TORCH = register("lignite_torch", () -> new TorchBlock(propertiesLigniteTorch(), ParticleTypes.FLAME));
	public static final RegistryObject<Block> LIGNITE_WALL_TORCH = register("lignite_wall_torch", () -> new WallTorchBlock(propertiesLigniteTorch(), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_TORCH = register("anthracite_torch", () -> new TorchBlock(propertiesAnthraciteTorch(), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_WALL_TORCH = register("anthracite_wall_torch", () -> new WallTorchBlock(propertiesAnthraciteTorch(), ParticleTypes.FLAME));

	public static final RegistryObject<Block> MOSS_0 = register("moss_0", () -> new MossBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_1 = register("moss_1", () -> new MossBlock(propertiesMoss()));
	public static final RegistryObject<Block> MOSS_2 = register("moss_2", () -> new MossBlock(propertiesMoss()));

	public static final RegistryObject<LiquidBlock> HYLIASTRUM_FLUID = register("hyliastrum_fluid", () -> new LiquidBlock(IcariaFluids.HYLIASTRUM_FLUID_SOURCE, propertiesLavaFluid()));
	public static final RegistryObject<LiquidBlock> MEDITERRANEAN_WATER = register("mediterranean_water", () -> new LiquidBlock(IcariaFluids.MEDITERRANEAN_WATER_SOURCE, propertiesWaterFluid()));
	public static final RegistryObject<LiquidBlock> UPWARDS_FLUID = register("upwards_fluid", () -> new LiquidBlock(IcariaFluids.UPWARDS_FLUID_SOURCE, propertiesWaterFluid()));

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
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).sound(IcariaSounds.ARISTONE).explosionResistance(0.5F).strength(0.5F).friction(0.98F).noOcclusion();
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

	private static Properties propertiesChertBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesLigniteBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesChalkosBlock() {
		return Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).sound(SoundType.METAL).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesKassiterosBlock() {
		return Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.METAL).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesOrichalcumBlock() {
		return Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).sound(SoundType.METAL).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesVanadiumBlock() {
		return Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).sound(SoundType.METAL).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesSiderosBlock() {
		return Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).sound(SoundType.METAL).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesSliverBlock() {
		return Properties.of(Material.METAL, MaterialColor.WOOD).sound(SoundType.METAL).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesAnthraciteBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesMolybdenumBlock() {
		return Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).sound(SoundType.METAL).explosionResistance(6.0F).strength(5.0F).requiresCorrectToolForDrops();
	}

	private static Properties propertiesCypressWood() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).explosionResistance(3.0F).strength(2.0F);
	}

	private static Properties propertiesDroughtrootWood() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).sound(SoundType.WOOD).explosionResistance(3.0F).strength(2.0F);
	}

	private static Properties propertiesFirWood() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).explosionResistance(3.0F).strength(2.0F);
	}

	private static Properties propertiesLaurelWood() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).explosionResistance(3.0F).strength(2.0F);
	}

	private static Properties propertiesOliveWood() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).explosionResistance(3.0F).strength(2.0F);
	}

	private static Properties propertiesPlaneWood() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).explosionResistance(3.0F).strength(2.0F);
	}

	private static Properties propertiesPopulusWood() {
		return Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).sound(SoundType.WOOD).explosionResistance(3.0F).strength(2.0F);
	}

	private static Properties propertiesLogs(MaterialColor colorEnd, MaterialColor colorSide) {
		return Properties.of(Material.WOOD, (pState) -> pState.getValue(RotatedPillarBlock.AXIS) == Axis.Y ? colorEnd : colorSide).sound(SoundType.WOOD).strength(2.0F, 2.0F).noOcclusion();
	}

	private static Properties propertiesMoss() {
		return Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).explosionResistance(0.1F).strength(0.1F);
	}

	private static Properties propertiesLigniteTorch() {
		return Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_152607_) -> 9).sound(SoundType.METAL);
	}

	private static Properties propertiesAnthraciteTorch() {
		return Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_152607_) -> 14).sound(SoundType.METAL);
	}

	private static Properties propertiesLavaFluid() {
		return Properties.of(Material.LAVA).color(MaterialColor.COLOR_BLACK).explosionResistance(100.0F).strength(100.0F).noCollission().noDrops();
	}

	private static Properties propertiesWaterFluid() {
		return Properties.of(Material.WATER).explosionResistance(100.0F).strength(100.0F).noCollission().noDrops();
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> registerBasic(final String name, final Supplier<? extends T> block) {
		RegistryObject<T> registeredBlock = register(name, block);
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
