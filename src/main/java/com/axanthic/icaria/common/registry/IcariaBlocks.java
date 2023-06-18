package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.block.*;
import com.axanthic.icaria.common.block.LayerBlock;
import com.axanthic.icaria.common.block.IcariaSandBlock;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;
import com.axanthic.icaria.common.world.tree.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault

public class IcariaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, IcariaInfo.ID);

	public static final List<RegistryObject<? extends Block>> BASIC_BLOCKS = new ArrayList<>();

	public static final RegistryObject<Block> GRASSY_MARL = register("grassy_marl", () -> new GrassyMarlBlock(propertiesGrass()));
	public static final RegistryObject<Block> MARL = registerBasic("marl", () -> new IcariaDirtBlock(propertiesMarl()));
	public static final RegistryObject<Block> MARL_CHERT = register("marl_chert", () -> new Block(propertiesMarl().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SURFACE_CHERT = register("surface_chert", () -> new GroundDecoBlock(propertiesRubble()));
	public static final RegistryObject<Block> MARL_BONES = register("marl_bones", () -> new Block(propertiesMarl().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SURFACE_BONES = register("surface_bones", () -> new GroundDecoBlock(propertiesRubble()));
	public static final RegistryObject<Block> MARL_LIGNITE = register("marl_lignite", () -> new Block(propertiesMarl().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SURFACE_LIGNITE = register("surface_lignite", () -> new GroundDecoBlock(propertiesRubble()));
	public static final RegistryObject<Block> COARSE_MARL = registerBasic("coarse_marl", () -> new IcariaDirtBlock(propertiesMarl()));
	public static final RegistryObject<Block> DRY_LAKE_BED = registerBasic("dry_lake_bed", () -> new IcariaDirtBlock(propertiesMarl()));

	public static final RegistryObject<Block> FARMLAND = register("farmland", () -> new FarmlandBlock(propertiesFarmland()));
	public static final RegistryObject<Block> FERTILIZED_FARMLAND = register("fertilized_farmland", () -> new FertilizedFarmlandBlock(propertiesFarmland()));

	public static final RegistryObject<Block> MARL_ADOBE = registerBasic("marl_adobe", () -> new Block(propertiesStone(MaterialColor.COLOR_BROWN)));
	public static final StoneDecoBlocks MARL_ADOBE_DECO = new StoneDecoBlocks("marl_adobe", MARL_ADOBE, propertiesStone(MaterialColor.COLOR_BROWN));

	public static final RegistryObject<Block> LOAM = register("loam", () -> new LoamBlock(propertiesLoam()));
	public static final RegistryObject<Block> LOAM_BRICKS = registerBasic("loam_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks LOAM_BRICK_DECO = new StoneDecoBlocks("loam_brick", LOAM_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_PINK));

	public static final RegistryObject<Block> DOLOMITE_ADOBE = registerBasic("dolomite_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final StoneDecoBlocks DOLOMITE_ADOBE_DECO = new StoneDecoBlocks("dolomite_adobe", DOLOMITE_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_WHITE));
	public static final RegistryObject<Block> SMOOTH_DOLOMITE = registerBasic("smooth_dolomite", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final StoneDecoBlocks SMOOTH_DOLOMITE_DECO = new StoneDecoBlocks("smooth_dolomite", SMOOTH_DOLOMITE, propertiesStone(MaterialColor.TERRACOTTA_WHITE));
	public static final RegistryObject<Block> DOLOMITE_BRICKS = registerBasic("dolomite_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<RotatedPillarBlock> DOLOMITE_PILLAR = register("dolomite_pillar", () -> new RotatedPillarBlock(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<PillarHeadBlock> DOLOMITE_PILLAR_HEAD = register("dolomite_pillar_head", () -> new PillarHeadBlock(propertiesStone(MaterialColor.TERRACOTTA_WHITE)));

	public static final RegistryObject<Block> GRAINEL = registerBasic("grainel", () -> new IcariaSandBlock(propertiesGrainel()));
	public static final RegistryObject<Block> GRAINEL_CHERT = register("grainel_chert", () -> new Block(propertiesGrainel().requiresCorrectToolForDrops()));
	public static final RegistryObject<GlassBlock> GRAINGLASS = register("grainglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> GRAINGLASS_PANE = register("grainglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> HORIZONTAL_GRAINGLASS_PANE = register("horizontal_grainglass_pane", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> GRAINITE_ADOBE = registerBasic("grainite_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final StoneDecoBlocks GRAINITE_ADOBE_DECO = new StoneDecoBlocks("grainite_adobe", GRAINITE_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_YELLOW));
	public static final RegistryObject<Block> GRAINITE = registerBasic("grainite", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final StoneDecoBlocks GRAINITE_DECO = new StoneDecoBlocks("grainite", GRAINITE, propertiesStone(MaterialColor.TERRACOTTA_YELLOW));
	public static final RegistryObject<Block> GRAINITE_BRICKS = registerBasic("grainite_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final StoneDecoBlocks GRAINITE_BRICK_DECO = new StoneDecoBlocks("grainite_brick", GRAINITE_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_YELLOW));
	public static final RegistryObject<Block> CHISELED_GRAINITE = registerBasic("chiseled_grainite", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_YELLOW)));
	public static final RegistryObject<Block> GRAINITE_RUBBLE = register("grainite_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> YELLOWSTONE_ADOBE = registerBasic("yellowstone_adobe", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks YELLOWSTONE_ADOBE_DECO = new StoneDecoBlocks("yellowstone_adobe", YELLOWSTONE_ADOBE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> COBBLED_YELLOWSTONE = registerBasic("cobbled_yellowstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks COBBLED_YELLOWSTONE_DECO = new StoneDecoBlocks("cobbled_yellowstone", COBBLED_YELLOWSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> YELLOWSTONE = register("yellowstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks YELLOWSTONE_DECO = new StoneDecoBlocks("yellowstone", YELLOWSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS = registerBasic("yellowstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks YELLOWSTONE_BRICK_DECO = new StoneDecoBlocks("yellowstone_brick", YELLOWSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> CHISELED_YELLOWSTONE = registerBasic("chiseled_yellowstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> YELLOWSTONE_RUBBLE = register("yellowstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> SILKSAND = registerBasic("silksand", () -> new IcariaSandBlock(propertiesSilksand()));
	public static final RegistryObject<GlassBlock> SILKGLASS = register("silkglass", () -> new GlassBlock(propertiesGlass()));
	public static final RegistryObject<IronBarsBlock> SILKGLASS_PANE = register("silkglass_pane", () -> new IronBarsBlock(propertiesGlass()));
	public static final RegistryObject<Block> HORIZONTAL_SILKGLASS_PANE = register("horizontal_silkglass_pane", () -> new HorizontalPaneBlock(propertiesGlass()));
	public static final RegistryObject<Block> SILKSTONE_ADOBE = registerBasic("silkstone_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks SILKSTONE_ADOBE_DECO = new StoneDecoBlocks("silkstone_adobe", SILKSTONE_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> COBBLED_SILKSTONE = registerBasic("cobbled_silkstone", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks COBBLED_SILKSTONE_DECO = new StoneDecoBlocks("cobbled_silkstone", COBBLED_SILKSTONE, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> SILKSTONE = register("silkstone", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks SILKSTONE_DECO = new StoneDecoBlocks("silkstone", SILKSTONE, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> SILKSTONE_BRICKS = registerBasic("silkstone_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final StoneDecoBlocks SILKSTONE_BRICK_DECO = new StoneDecoBlocks("silkstone_brick", SILKSTONE_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_PINK));
	public static final RegistryObject<Block> CHISELED_SILKSTONE = registerBasic("chiseled_silkstone", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_PINK)));
	public static final RegistryObject<Block> SILKSTONE_RUBBLE = register("silkstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> SUNSTONE_ADOBE = registerBasic("sunstone_adobe", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SUNSTONE_ADOBE_DECO = new StoneDecoBlocks("sunstone_adobe", SUNSTONE_ADOBE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> COBBLED_SUNSTONE = registerBasic("cobbled_sunstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks COBBLED_SUNSTONE_DECO = new StoneDecoBlocks("cobbled_sunstone", COBBLED_SUNSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> SUNSTONE = register("sunstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SUNSTONE_DECO = new StoneDecoBlocks("sunstone", SUNSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> SUNSTONE_BRICKS = registerBasic("sunstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SUNSTONE_BRICK_DECO = new StoneDecoBlocks("sunstone_brick", SUNSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> CHISELED_SUNSTONE = registerBasic("chiseled_sunstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> SUNSTONE_RUBBLE = register("sunstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> VOIDSHALE_ADOBE = registerBasic("voidshale_adobe", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks VOIDSHALE_ADOBE_DECO = new StoneDecoBlocks("voidshale_adobe", VOIDSHALE_ADOBE, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> COBBLED_VOIDSHALE = registerBasic("cobbled_voidshale", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks COBBLED_VOIDSHALE_DECO = new StoneDecoBlocks("cobbled_voidshale", COBBLED_VOIDSHALE, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> VOIDSHALE = register("voidshale", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks VOIDSHALE_DECO = new StoneDecoBlocks("voidshale", VOIDSHALE, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> VOIDSHALE_BRICKS = registerBasic("voidshale_bricks", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final StoneDecoBlocks VOIDSHALE_BRICK_DECO = new StoneDecoBlocks("voidshale_brick", VOIDSHALE_BRICKS, propertiesStone(MaterialColor.COLOR_GRAY));
	public static final RegistryObject<Block> CHISELED_VOIDSHALE = registerBasic("chiseled_voidshale", () -> new Block(propertiesStone(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> VOIDSHALE_RUBBLE = register("voidshale_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> BAETYL_ADOBE = registerBasic("baetyl_adobe", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks BAETYL_ADOBE_DECO = new StoneDecoBlocks("baetyl_adobe", BAETYL_ADOBE, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> COBBLED_BAETYL = registerBasic("cobbled_baetyl", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks COBBLED_BAETYL_DECO = new StoneDecoBlocks("cobbled_baetyl", COBBLED_BAETYL, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> BAETYL = register("baetyl", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks BAETYL_DECO = new StoneDecoBlocks("baetyl", BAETYL, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> BAETYL_BRICKS = registerBasic("baetyl_bricks", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final StoneDecoBlocks BAETYL_BRICK_DECO = new StoneDecoBlocks("baetyl_brick", BAETYL_BRICKS, propertiesStone(MaterialColor.TERRACOTTA_CYAN));
	public static final RegistryObject<Block> CHISELED_BAETYL = registerBasic("chiseled_baetyl", () -> new Block(propertiesStone(MaterialColor.TERRACOTTA_CYAN)));
	public static final RegistryObject<Block> BAETYL_RUBBLE = register("baetyl_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> RELICSTONE = registerBasic("relicstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_DECO = new StoneDecoBlocks("relicstone", RELICSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> SMOOTH_RELICSTONE = register("smooth_relicstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks SMOOTH_RELICSTONE_DECO = new StoneDecoBlocks("smooth_relicstone", SMOOTH_RELICSTONE, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_BRICKS = registerBasic("relicstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_BRICK_DECO = new StoneDecoBlocks("relicstone_brick", RELICSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> CRACKED_RELICSTONE_BRICKS = registerBasic("cracked_relicstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks CRACKED_RELICSTONE_BRICK_DECO = new StoneDecoBlocks("cracked_relicstone_brick", CRACKED_RELICSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> MOSSY_RELICSTONE_BRICKS = registerBasic("mossy_relicstone_bricks", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks MOSSY_RELICSTONE_BRICK_DECO = new StoneDecoBlocks("mossy_relicstone_brick", MOSSY_RELICSTONE_BRICKS, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> RELICSTONE_TILES = registerBasic("relicstone_tiles", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks RELICSTONE_TILE_DECO = new StoneDecoBlocks("relicstone_tile", RELICSTONE_TILES, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> CRACKED_RELICSTONE_TILES = registerBasic("cracked_relicstone_tiles", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks CRACKED_RELICSTONE_TILE_DECO = new StoneDecoBlocks("cracked_relicstone_tile", CRACKED_RELICSTONE_TILES, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> MOSSY_RELICSTONE_TILES = registerBasic("mossy_relicstone_tiles", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final StoneDecoBlocks MOSSY_RELICSTONE_TILE_DECO = new StoneDecoBlocks("mossy_relicstone_tile", MOSSY_RELICSTONE_TILES, propertiesStone(MaterialColor.WOOD));
	public static final RegistryObject<Block> CHISELED_RELICSTONE = registerBasic("chiseled_relicstone", () -> new Block(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> RELICSTONE_PILLAR = register("relicstone_pillar", () -> new RotatedPillarBlock(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> RELICSTONE_PILLAR_HEAD = register("relicstone_pillar_head", () -> new PillarHeadBlock(propertiesStone(MaterialColor.WOOD)));
	public static final RegistryObject<Block> RELICSTONE_RUBBLE = register("relicstone_rubble", () -> new GroundDecoBlock(propertiesRubble()));

	public static final RegistryObject<Block> PLATOSHALE = registerBasic("platoshale", () -> new Block(propertiesStone(MaterialColor.COLOR_BLACK)));
	public static final StoneDecoBlocks PLATOSHALE_DECO = new StoneDecoBlocks("platoshale", PLATOSHALE, propertiesStone(MaterialColor.COLOR_BLACK));
	public static final RegistryObject<Block> BLURRED_PLATOSHALE = register("blurred_platoshale", () -> new Block(propertiesStone(MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> PLATOSHALE_BRICKS = registerBasic("platoshale_bricks", () -> new Block(propertiesStone(MaterialColor.COLOR_BLACK)));
	public static final StoneDecoBlocks PLATOSHALE_BRICK_DECO = new StoneDecoBlocks("platoshale_brick", PLATOSHALE_BRICKS, propertiesStone(MaterialColor.COLOR_BLACK));
	public static final RegistryObject<Block> BLURRED_PLATOSHALE_BRICKS = register("blurred_platoshale_bricks", () -> new Block(propertiesStone(MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> CHISELED_PLATOSHALE = registerBasic("chiseled_platoshale", () -> new Block(propertiesStone(MaterialColor.COLOR_BLACK)));

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

	public static final RegistryObject<Block> CALCITE_GEODE_BLOCK = registerBasic("calcite_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<Block> BUDDING_CALCITE_GEODE_BLOCK = registerBasic("budding_calcite_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<Block> HALITE_GEODE_BLOCK = registerBasic("halite_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> BUDDING_HALITE_GEODE_BLOCK = registerBasic("budding_halite_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> JASPER_GEODE_BLOCK = registerBasic("jasper_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> BUDDING_JASPER_GEODE_BLOCK = registerBasic("budding_jasper_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> ZIRCON_GEODE_BLOCK = registerBasic("zircon_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_BLUE)));
	public static final RegistryObject<Block> BUDDING_ZIRCON_GEODE_BLOCK = registerBasic("budding_zircon_geode_block", () -> new AmethystBlock(propertiesGeodeBlock(MaterialColor.COLOR_BLUE)));

	public static final RegistryObject<Block> CALCITE_CRYSTAL = register("calcite_crystal", () -> new CrystalBlock(propertiesCrystalBlock(), 1.0F, 1.0F, 0.5F));
	public static final RegistryObject<Block> HALITE_CRYSTAL = register("halite_crystal", () -> new CrystalBlock(propertiesCrystalBlock(), 0.0F, 1.0F, 0.5F));
	public static final RegistryObject<Block> JASPER_CRYSTAL = register("jasper_crystal", () -> new CrystalBlock(propertiesCrystalBlock(), 1.0F, 0.0F, 0.0F));
	public static final RegistryObject<Block> ZIRCON_CRYSTAL = register("zircon_crystal", () -> new CrystalBlock(propertiesCrystalBlock(), 0.0F, 0.0F, 1.0F));

	public static final RegistryObject<Block> ARISTONE = registerBasic("aristone", () -> new GlassBlock(propertiesAristone()));
	public static final RegistryObject<Block> PACKED_ARISTONE = registerBasic("packed_aristone", () -> new Block(propertiesAristone()));

	public static final RegistryObject<Block> ENDER_JELLYFISH_JELLY_BLOCK = registerBasic("ender_jellyfish_jelly_block", () -> new JellyfishJellyBlock(propertiesJellyfishJellyBlock()));
	public static final RegistryObject<Block> FIRE_JELLYFISH_JELLY_BLOCK = registerBasic("fire_jellyfish_jelly_block", () -> new JellyfishJellyBlock(propertiesJellyfishJellyBlock()));
	public static final RegistryObject<Block> NATURE_JELLYFISH_JELLY_BLOCK = registerBasic("nature_jellyfish_jelly_block", () -> new JellyfishJellyBlock(propertiesJellyfishJellyBlock()));
	public static final RegistryObject<Block> VOID_JELLYFISH_JELLY_BLOCK = registerBasic("void_jellyfish_jelly_block", () -> new JellyfishJellyBlock(propertiesJellyfishJellyBlock()));
	public static final RegistryObject<Block> WATER_JELLYFISH_JELLY_BLOCK = registerBasic("water_jellyfish_jelly_block", () -> new JellyfishJellyBlock(propertiesJellyfishJellyBlock()));
	public static final RegistryObject<Block> ARACHNE_STRING_BLOCK = registerBasic("arachne_string_block", () -> new Block(propertiesArachneStringBlock()));
	public static final RegistryObject<RotatedPillarBlock> SPELT_BALE_BLOCK = register("spelt_bale_block", () -> new SpeltBaleBlock(propertiesSpeltBaleBlock()));
	public static final RegistryObject<Block> VINE_REED_BLOCK = registerBasic("vine_reed_block", () -> new Block(propertiesVineReedBlock()));
	public static final RegistryObject<Block> VINE_SPROUT_BLOCK = registerBasic("vine_sprout_block", () -> new Block(propertiesVineReedBlock()));
	public static final RegistryObject<Block> ROTTEN_BONES_BLOCK = registerBasic("rotten_bones_block", () -> new Block(propertiesRottenBonesBlock()));

	public static final RegistryObject<Block> RAW_CHALKOS_BLOCK = registerBasic("raw_chalkos_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> RAW_KASSITEROS_BLOCK = registerBasic("raw_kassiteros_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> RAW_VANADIUM_BLOCK = registerBasic("raw_vanadium_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<Block> SLIVER_BLOCK = registerBasic("sliver_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.WOOD)));
	public static final RegistryObject<Block> RAW_SIDEROS_BLOCK = registerBasic("raw_sideros_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> RAW_MOLYBDENUM_BLOCK = registerBasic("raw_molybdenum_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_GRAY)));

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
	public static final RegistryObject<Block> SIDEROS_BLOCK = registerBasic("sideros_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> ANTHRACITE_BLOCK = registerBasic("anthracite_block", () -> new Block(propertiesGemStorageBlock(MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBasic("molybdenum_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<Block> MOLYBDENUMSTEEL_BLOCK = registerBasic("molybdenumsteel_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<Block> BLURIDIUM_BLOCK = registerBasic("bluridium_block", () -> new Block(propertiesMetalStorageBlock(MaterialColor.COLOR_LIGHT_BLUE)));

	public static final RegistryObject<IronBarsBlock> VANADIUMSTEEL_BARS = register("vanadiumsteel_bars", () -> new IronBarsBlock(propertiesBars()));
	public static final RegistryObject<Block> HORIZONTAL_VANADIUMSTEEL_BARS = register("horizontal_vanadiumsteel_bars", () -> new HorizontalPaneBlock(propertiesBars()));

	public static final RegistryObject<Block> KETTLE = register("kettle", () -> new KettleBlock(propertiesGrinder()));
	public static final RegistryObject<Block> GRINDER = register("grinder", () -> new GrinderBlock(propertiesGrinder()));
	public static final RegistryObject<Block> KILN = register("kiln", () -> new KilnBlock(propertiesGrinder()));
	public static final RegistryObject<Block> FORGE = register("forge", () -> new ForgeBlock(propertiesGrinder()));

	public static final RegistryObject<Block> CHEST = register("chest", () -> new ChestBlock(propertiesGrinder(), () -> BlockEntityType.CHEST));
	public static final RegistryObject<Block> TRAPPED_CHEST = register("trapped_chest", () -> new TrappedChestBlock(propertiesGrinder()));

	public static final RegistryObject<Block> BARREL = register("barrel", () -> new BarrelBlock(propertiesGrinder()));
	public static final RegistryObject<Block> BARREL_RACK = register("barrel_rack", () -> new BarrelRackBlock(propertiesGrinder()));

	public static final RegistryObject<Block> STORAGE_VASE = register("storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.TERRACOTTA_PINK)));
	public static final RegistryObject<Block> WHITE_STORAGE_VASE = register("white_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.SNOW)));
	public static final RegistryObject<Block> LIGHT_GRAY_STORAGE_VASE = register("light_gray_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_LIGHT_GRAY)));
	public static final RegistryObject<Block> GRAY_STORAGE_VASE = register("gray_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> BLACK_STORAGE_VASE = register("black_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> BROWN_STORAGE_VASE = register("brown_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> RED_STORAGE_VASE = register("red_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> ORANGE_STORAGE_VASE = register("orange_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<Block> YELLOW_STORAGE_VASE = register("yellow_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_YELLOW)));
	public static final RegistryObject<Block> LIME_STORAGE_VASE = register("lime_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_LIGHT_GREEN)));
	public static final RegistryObject<Block> GREEN_STORAGE_VASE = register("green_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> CYAN_STORAGE_VASE = register("cyan_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_CYAN)));
	public static final RegistryObject<Block> LIGHT_BLUE_STORAGE_VASE = register("light_blue_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> BLUE_STORAGE_VASE = register("blue_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_BLUE)));
	public static final RegistryObject<Block> PURPLE_STORAGE_VASE = register("purple_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> MAGENTA_STORAGE_VASE = register("magenta_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_MAGENTA)));
	public static final RegistryObject<Block> PINK_STORAGE_VASE = register("pink_storage_vase", () -> new StorageVaseBlock(propertiesStorageVase(MaterialColor.COLOR_PINK)));

	public static final RegistryObject<Block> RED_LOOT_VASE = register("red_loot_vase", () -> new LootVaseBlock(propertiesLootVase(MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> CYAN_LOOT_VASE = register("cyan_loot_vase", () -> new LootVaseBlock(propertiesLootVase(MaterialColor.COLOR_CYAN)));

	public static final RegistryObject<Block> DUNGEON_SPAWNER = register("dungeon_spawner", () -> new IcariaSpawnerBlock(propertiesSpawners(MaterialColor.COLOR_GRAY, SoundType.METAL)));
	public static final RegistryObject<Block> MYRMEKE_SPAWNER = register("myrmeke_spawner", () -> new IcariaSpawnerBlock(propertiesSpawners(MaterialColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<Block> RUIN_SPAWNER = register("ruin_spawner", () -> new IcariaSpawnerBlock(propertiesSpawners(MaterialColor.COLOR_LIGHT_GRAY, SoundType.METAL)));
	public static final RegistryObject<Block> VILLAGE_SPAWNER = register("village_spawner", () -> new IcariaSpawnerBlock(propertiesSpawners(MaterialColor.COLOR_GREEN, SoundType.METAL)));

	public static final RegistryObject<Block> AETERNAE_SKULL = register("aeternae_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.AETERNAE, propertiesSkull()));
	public static final RegistryObject<Block> AETERNAE_WALL_SKULL = register("aeternae_wall_skull", () -> new IcariaWallSkullBlock(0.03F, IcariaSkullBlockTypes.AETERNAE, propertiesSkull()));
	public static final RegistryObject<Block> ARGAN_HOUND_SKULL = register("argan_hound_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.ARGAN_HOUND, propertiesSkull()));
	public static final RegistryObject<Block> ARGAN_HOUND_WALL_SKULL = register("argan_hound_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.ARGAN_HOUND, propertiesSkull()));
	public static final RegistryObject<Block> CATOBLEPAS_SKULL = register("catoblepas_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.CATOBLEPAS, propertiesSkull()));
	public static final RegistryObject<Block> CATOBLEPAS_WALL_SKULL = register("catoblepas_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.CATOBLEPAS, propertiesSkull()));
	public static final RegistryObject<Block> CERVER_SKULL = register("cerver_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.CERVER, propertiesSkull()));
	public static final RegistryObject<Block> CERVER_WALL_SKULL = register("cerver_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.CERVER, propertiesSkull()));
	public static final RegistryObject<Block> CYPRESS_FOREST_HAG_SKULL = register("cypress_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> CYPRESS_FOREST_HAG_WALL_SKULL = register("cypress_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> DROUGHTROOT_FOREST_HAG_SKULL = register("droughtroot_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> DROUGHTROOT_FOREST_HAG_WALL_SKULL = register("droughtroot_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> FIR_FOREST_HAG_SKULL = register("fir_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.FIR_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> FIR_FOREST_HAG_WALL_SKULL = register("fir_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.FIR_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> LAUREL_FOREST_HAG_SKULL = register("laurel_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.LAUREL_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> LAUREL_FOREST_HAG_WALL_SKULL = register("laurel_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.LAUREL_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> OLIVE_FOREST_HAG_SKULL = register("olive_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.OLIVE_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> OLIVE_FOREST_HAG_WALL_SKULL = register("olive_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.OLIVE_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> PLANE_FOREST_HAG_SKULL = register("plane_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.PLANE_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> PLANE_FOREST_HAG_WALL_SKULL = register("plane_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.PLANE_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> POPULUS_FOREST_HAG_SKULL = register("populus_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.POPULUS_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> POPULUS_FOREST_HAG_WALL_SKULL = register("populus_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.POPULUS_FOREST_HAG, propertiesSkull()));
	public static final RegistryObject<Block> REVENANT_SKULL = register("revenant_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.REVENANT, propertiesSkull()));
	public static final RegistryObject<Block> REVENANT_WALL_SKULL = register("revenant_wall_skull", () -> new IcariaWallSkullBlock(0.0F, IcariaSkullBlockTypes.REVENANT, propertiesSkull()));
	public static final RegistryObject<Block> SOW_SKULL = register("sow_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.SOW, propertiesSkull()));
	public static final RegistryObject<Block> SOW_WALL_SKULL = register("sow_wall_skull", () -> new IcariaWallSkullBlock(0.0F, IcariaSkullBlockTypes.SOW, propertiesSkull()));

	public static final RegistryObject<Block> DIM_TORCH = register("dim_torch", () -> new TorchBlock(propertiesTorch().lightLevel((pBlockState) -> 8), ParticleTypes.SMOKE));
	public static final RegistryObject<Block> DIM_WALL_TORCH = register("dim_wall_torch", () -> new WallTorchBlock(propertiesTorch().lightLevel((pBlockState) -> 8), ParticleTypes.SMOKE));
	public static final RegistryObject<Block> LIGNITE_TORCH = register("lignite_torch", () -> new TorchBlock(propertiesTorch().lightLevel((pBlockState) -> 9), ParticleTypes.FLAME));
	public static final RegistryObject<Block> LIGNITE_WALL_TORCH = register("lignite_wall_torch", () -> new WallTorchBlock(propertiesTorch().lightLevel((pBlockState) -> 9), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_TORCH = register("anthracite_torch", () -> new TorchBlock(propertiesTorch().lightLevel((pBlockState) -> 14), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_WALL_TORCH = register("anthracite_wall_torch", () -> new WallTorchBlock(propertiesTorch().lightLevel((pBlockState) -> 14), ParticleTypes.FLAME));

	public static final RegistryObject<Block> LAUREL_CHERRY_CAKE = register("laurel_cherry_cake", () -> new IcariaCakeBlock(propertiesCake()));
	public static final RegistryObject<Block> STRAWBERRY_CAKE = register("strawberry_cake", () -> new IcariaCakeBlock(propertiesCake()));
	public static final RegistryObject<Block> PHYSALIS_CAKE = register("physalis_cake", () -> new IcariaCakeBlock(propertiesCake()));
	public static final RegistryObject<Block> VINE_BERRY_CAKE = register("vine_berry_cake", () -> new IcariaCakeBlock(propertiesCake()));
	public static final RegistryObject<Block> VINE_SPROUT_CAKE = register("vine_sprout_cake", () -> new IcariaCakeBlock(propertiesCake()));

	public static final RegistryObject<Block> CYPRESS_SAPLING = register("cypress_sapling", () -> new SaplingBlock(new CypressTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = register("potted_cypress_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CYPRESS_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> CYPRESS_LEAVES = register("cypress_leaves", () -> new IcariaLeavesBlock(propertiesLeaves()));
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
	public static final RegistryObject<Block> CYPRESS_CRAFTING_TABLE = register("cypress_crafting_table", () -> new IcariaCraftingTableBlock(propertiesCraftingTable(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DoorBlock> CYPRESS_DOOR = register("cypress_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.CYPRESS));
	public static final RegistryObject<TrapDoorBlock> CYPRESS_TRAPDOOR = register("cypress_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.CYPRESS));
	public static final RegistryObject<Block> CYPRESS_LADDER = register("cypress_ladder", () -> new LadderBlock(propertiesLadder()));
	public static final RegistryObject<Block> CYPRESS_SIGN = register("cypress_sign", () -> new IcariaStandingSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.CYPRESS));
	public static final RegistryObject<Block> CYPRESS_WALL_SIGN = register("cypress_wall_sign", () -> new IcariaWallSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.CYPRESS));

	public static final RegistryObject<Block> DROUGHTROOT_SAPLING = register("droughtroot_sapling", () -> new SaplingBlock(new DroughtrootTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_DROUGHTROOT_SAPLING = register("potted_droughtroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DROUGHTROOT_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> DROUGHTROOT_LEAVES = register("droughtroot_leaves", () -> new IcariaLeavesBlock(propertiesLeaves()));
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
	public static final RegistryObject<Block> DROUGHTROOT_CRAFTING_TABLE = register("droughtroot_crafting_table", () -> new IcariaCraftingTableBlock(propertiesCraftingTable(MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<DoorBlock> DROUGHTROOT_DOOR = register("droughtroot_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_GRAY), IcariaBlockSetTypes.DROUGHTROOT));
	public static final RegistryObject<TrapDoorBlock> DROUGHTROOT_TRAPDOOR = register("droughtroot_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_GRAY), IcariaBlockSetTypes.DROUGHTROOT));
	public static final RegistryObject<Block> DROUGHTROOT_LADDER = register("droughtroot_ladder", () -> new LadderBlock(propertiesLadder()));
	public static final RegistryObject<Block> DROUGHTROOT_SIGN = register("droughtroot_sign", () -> new IcariaStandingSignBlock(propertiesSign(MaterialColor.COLOR_GRAY), IcariaWoodTypes.DROUGHTROOT));
	public static final RegistryObject<Block> DROUGHTROOT_WALL_SIGN = register("droughtroot_wall_sign", () -> new IcariaWallSignBlock(propertiesSign(MaterialColor.COLOR_GRAY), IcariaWoodTypes.DROUGHTROOT));

	public static final RegistryObject<Block> FIR_SAPLING = register("fir_sapling", () -> new SaplingBlock(new FirTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_FIR_SAPLING = register("potted_fir_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FIR_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> FIR_LEAVES = register("fir_leaves", () -> new IcariaLeavesBlock(propertiesLeaves()));
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
	public static final RegistryObject<Block> FIR_CRAFTING_TABLE = register("fir_crafting_table", () -> new IcariaCraftingTableBlock(propertiesCraftingTable(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DoorBlock> FIR_DOOR = register("fir_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.FIR));
	public static final RegistryObject<TrapDoorBlock> FIR_TRAPDOOR = register("fir_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.FIR));
	public static final RegistryObject<Block> FIR_LADDER = register("fir_ladder", () -> new LadderBlock(propertiesLadder()));
	public static final RegistryObject<Block> FIR_SIGN = register("fir_sign", () -> new IcariaStandingSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.FIR));
	public static final RegistryObject<Block> FIR_WALL_SIGN = register("fir_wall_sign", () -> new IcariaWallSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.FIR));

	public static final RegistryObject<Block> LAUREL_SAPLING = register("laurel_sapling", () -> new SaplingBlock(new LaurelTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_LAUREL_SAPLING = register("potted_laurel_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LAUREL_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> LAUREL_LEAVES = register("laurel_leaves", () -> new IcariaLeavesBlock(propertiesLeaves()));
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
	public static final RegistryObject<Block> LAUREL_CRAFTING_TABLE = register("laurel_crafting_table", () -> new IcariaCraftingTableBlock(propertiesCraftingTable(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DoorBlock> LAUREL_DOOR = register("laurel_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_BROWN), IcariaBlockSetTypes.LAUREL));
	public static final RegistryObject<TrapDoorBlock> LAUREL_TRAPDOOR = register("laurel_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_BROWN), IcariaBlockSetTypes.LAUREL));
	public static final RegistryObject<Block> LAUREL_LADDER = register("laurel_ladder", () -> new LadderBlock(propertiesLadder()));
	public static final RegistryObject<Block> LAUREL_SIGN = register("laurel_sign", () -> new IcariaStandingSignBlock(propertiesSign(MaterialColor.COLOR_BROWN), IcariaWoodTypes.LAUREL));
	public static final RegistryObject<Block> LAUREL_WALL_SIGN = register("laurel_wall_sign", () -> new IcariaWallSignBlock(propertiesSign(MaterialColor.COLOR_BROWN), IcariaWoodTypes.LAUREL));

	public static final RegistryObject<Block> OLIVE_SAPLING = register("olive_sapling", () -> new SaplingBlock(new OliveTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_OLIVE_SAPLING = register("potted_olive_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, OLIVE_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> OLIVE_LEAVES = register("olive_leaves", () -> new OliveLeavesBlock(propertiesLeaves()));
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
	public static final RegistryObject<Block> OLIVE_CRAFTING_TABLE = register("olive_crafting_table", () -> new IcariaCraftingTableBlock(propertiesCraftingTable(MaterialColor.COLOR_ORANGE)));
	public static final RegistryObject<DoorBlock> OLIVE_DOOR = register("olive_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.OLIVE));
	public static final RegistryObject<TrapDoorBlock> OLIVE_TRAPDOOR = register("olive_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.OLIVE));
	public static final RegistryObject<Block> OLIVE_LADDER = register("olive_ladder", () -> new LadderBlock(propertiesLadder()));
	public static final RegistryObject<Block> OLIVE_SIGN = register("olive_sign", () -> new IcariaStandingSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.OLIVE));
	public static final RegistryObject<Block> OLIVE_WALL_SIGN = register("olive_wall_sign", () -> new IcariaWallSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.OLIVE));

	public static final RegistryObject<Block> PLANE_SAPLING = register("plane_sapling", () -> new SaplingBlock(new PlaneTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_PLANE_SAPLING = register("potted_plane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PLANE_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> PLANE_LEAVES = register("plane_leaves", () -> new IcariaLeavesBlock(propertiesLeaves()));
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
	public static final RegistryObject<Block> PLANE_CRAFTING_TABLE = register("plane_crafting_table", () -> new IcariaCraftingTableBlock(propertiesCraftingTable(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<DoorBlock> PLANE_DOOR = register("plane_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.PLANE));
	public static final RegistryObject<TrapDoorBlock> PLANE_TRAPDOOR = register("plane_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_ORANGE), IcariaBlockSetTypes.PLANE));
	public static final RegistryObject<Block> PLANE_LADDER = register("plane_ladder", () -> new LadderBlock(propertiesLadder()));
	public static final RegistryObject<Block> PLANE_SIGN = register("plane_sign", () -> new IcariaStandingSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.PLANE));
	public static final RegistryObject<Block> PLANE_WALL_SIGN = register("plane_wall_sign", () -> new IcariaWallSignBlock(propertiesSign(MaterialColor.COLOR_ORANGE), IcariaWoodTypes.PLANE));

	public static final RegistryObject<Block> POPULUS_SAPLING = register("populus_sapling", () -> new SaplingBlock(new PopulusTreeGrower(), propertiesSapling()));
	public static final RegistryObject<Block> POTTED_POPULUS_SAPLING = register("potted_populus_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, POPULUS_SAPLING, propertiesPot()));
	public static final RegistryObject<Block> POPULUS_LEAVES = register("populus_leaves", () -> new IcariaLeavesBlock(propertiesLeaves()));
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
	public static final RegistryObject<Block> POPULUS_CRAFTING_TABLE = register("populus_crafting_table", () -> new IcariaCraftingTableBlock(propertiesCraftingTable(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<DoorBlock> POPULUS_DOOR = register("populus_door", ()-> new DoorBlock(propertiesDoor(MaterialColor.COLOR_YELLOW), IcariaBlockSetTypes.POPULUS));
	public static final RegistryObject<TrapDoorBlock> POPULUS_TRAPDOOR = register("populus_trapdoor", ()-> new TrapDoorBlock(propertiesDoor(MaterialColor.COLOR_YELLOW), IcariaBlockSetTypes.POPULUS));
	public static final RegistryObject<Block> POPULUS_LADDER = register("populus_ladder", () -> new LadderBlock(propertiesLadder()));
	public static final RegistryObject<Block> POPULUS_SIGN = register("populus_sign", () -> new IcariaStandingSignBlock(propertiesSign(MaterialColor.COLOR_GRAY), IcariaWoodTypes.POPULUS));
	public static final RegistryObject<Block> POPULUS_WALL_SIGN = register("populus_wall_sign", () -> new IcariaWallSignBlock(propertiesSign(MaterialColor.COLOR_GRAY), IcariaWoodTypes.POPULUS));

	public static final RegistryObject<Block> DEAD_BLOOMY_VINE = register("dead_bloomy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GROWING_BLOOMY_VINE = register("growing_bloomy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> RIPE_BLOOMY_VINE = register("ripe_bloomy_vine", () -> new IcariaVineBaseBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_BLOOMY_VINE.get(), DEAD_BLOOMY_VINE.get()));
	public static final RegistryObject<Block> BLOOMING_BLOOMY_VINE = register("blooming_bloomy_vine", () -> new IcariaVineStagedBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_BLOOMY_VINE.get(), RIPE_BLOOMY_VINE.get(), DEAD_BLOOMY_VINE.get()));
	public static final RegistryObject<Block> BLOOMY_VINE = register("bloomy_vine", () -> new IcariaVineStagedBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_BLOOMY_VINE.get(), BLOOMING_BLOOMY_VINE.get(), DEAD_BLOOMY_VINE.get()));

	public static final RegistryObject<Block> DEAD_BRANCHY_VINE = register("dead_branchy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GROWING_BRANCHY_VINE = register("growing_branchy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> BRANCHY_VINE = register("branchy_vine", () -> new IcariaVineBaseBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_BRANCHY_VINE.get(), DEAD_BRANCHY_VINE.get()));

	public static final RegistryObject<Block> DEAD_BRUSHY_VINE = register("dead_brushy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GROWING_BRUSHY_VINE = register("growing_brushy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> RIPE_BRUSHY_VINE = register("ripe_brushy_vine", () -> new IcariaVineBaseBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_BRUSHY_VINE.get(), DEAD_BRUSHY_VINE.get()));
	public static final RegistryObject<Block> BRUSHY_VINE = register("brushy_vine", () -> new IcariaVineStagedBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_BRUSHY_VINE.get(), RIPE_BRUSHY_VINE.get(), DEAD_BRUSHY_VINE.get()));

	public static final RegistryObject<Block> DEAD_DRY_VINE = register("dead_dry_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GROWING_DRY_VINE = register("growing_dry_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> DRY_VINE = register("dry_vine", () -> new IcariaVineBaseBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_DRY_VINE.get(), DEAD_DRY_VINE.get()));

	public static final RegistryObject<Block> DEAD_REEDY_VINE = register("dead_reedy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GROWING_REEDY_VINE = register("growing_reedy_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> REEDY_VINE = register("reedy_vine", () -> new IcariaVineBaseBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_REEDY_VINE.get(), DEAD_REEDY_VINE.get()));

	public static final RegistryObject<Block> DEAD_SWIRLY_VINE = register("dead_swirly_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GROWING_SWIRLY_VINE = register("growing_swirly_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> SWIRLY_VINE = register("swirly_vine", () -> new IcariaVineBaseBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_SWIRLY_VINE.get(), DEAD_SWIRLY_VINE.get()));

	public static final RegistryObject<Block> DEAD_THORNY_VINE = register("dead_thorny_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> GROWING_THORNY_VINE = register("growing_thorny_vine", () -> new IcariaVineTailBlock(propertiesVine(MaterialColor.PLANT)));
	public static final RegistryObject<Block> THORNY_VINE = register("thorny_vine", () -> new IcariaVineBaseBlock(propertiesVine(MaterialColor.PLANT).randomTicks(), GROWING_THORNY_VINE.get(), DEAD_THORNY_VINE.get()));

	public static final RegistryObject<Block> FERN = register("fern", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_FERN = register("potted_fern", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FERN, propertiesPot()));

	public static final RegistryObject<Block> SMALL_GRASS = register("small_grass", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MEDIUM_GRASS = register("medium_grass", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> LARGE_GRASS = register("large_grass", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));

	public static final RegistryObject<Block> SMALL_MIXED_GRAIN = register("small_mixed_grain", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MEDIUM_MIXED_GRAIN = register("medium_mixed_grain", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MEDIUM_BROWN_GRAIN = register("medium_brown_grain", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MEDIUM_WHITE_GRAIN = register("medium_white_grain", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MEDIUM_YELLOW_GRAIN = register("medium_yellow_grain", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> LARGE_BROWN_GRAIN = register("large_brown_grain", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));

	public static final RegistryObject<Block> BLINDWEED = register("blindweed", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_BLINDWEED = register("potted_blindweed", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLINDWEED, propertiesPot()));
	public static final RegistryObject<Block> CHAMEOMILE = register("chameomile", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_CHAMEOMILE = register("potted_chameomile", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHAMEOMILE, propertiesPot()));
	public static final RegistryObject<Block> CHARMONDER = register("charmonder", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_CHARMONDER = register("potted_charmonder", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHARMONDER, propertiesPot()));
	public static final RegistryObject<Block> CLOVER = register("clover", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_CLOVER = register("potted_clover", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CLOVER, propertiesPot()));
	public static final RegistryObject<Block> FIREHILT = register("firehilt", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_FIREHILT = register("potted_firehilt", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FIREHILT, propertiesPot()));
	public static final RegistryObject<Block> BLUE_HYDRACINTH = register("blue_hydracinth", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_BLUE_HYDRACINTH = register("potted_blue_hydracinth", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_HYDRACINTH, propertiesPot()));
	public static final RegistryObject<Block> PURPLE_HYDRACINTH = register("purple_hydracinth", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PURPLE_HYDRACINTH = register("potted_purple_hydracinth", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_HYDRACINTH, propertiesPot()));
	public static final RegistryObject<Block> LIONFANGS = register("lionfangs", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_LIONFANGS = register("potted_lionfangs", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LIONFANGS, propertiesPot()));
	public static final RegistryObject<Block> SPEARDROPS = register("speardrops", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_SPEARDROPS = register("potted_speardrops", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SPEARDROPS, propertiesPot()));
	public static final RegistryObject<Block> PURPLE_STAGHORN = register("purple_staghorn", () -> new DamagingBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PURPLE_STAGHORN = register("potted_purple_staghorn", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_STAGHORN, propertiesPot()));
	public static final RegistryObject<Block> YELLOW_STAGHORN = register("yellow_staghorn", () -> new DamagingBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_YELLOW_STAGHORN = register("potted_yellow_staghorn", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, YELLOW_STAGHORN, propertiesPot()));
	public static final RegistryObject<Block> BLUE_STORMCOTTON = register("blue_stormcotton", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_BLUE_STORMCOTTON = register("potted_blue_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_STORMCOTTON, propertiesPot()));
	public static final RegistryObject<Block> PINK_STORMCOTTON = register("pink_stormcotton", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PINK_STORMCOTTON = register("potted_pink_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PINK_STORMCOTTON, propertiesPot()));
	public static final RegistryObject<Block> PURPLE_STORMCOTTON = register("purple_stormcotton", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PURPLE_STORMCOTTON = register("potted_purple_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_STORMCOTTON, propertiesPot()));
	public static final RegistryObject<Block> SUNKETTLE = register("sunkettle", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_SUNKETTLE = register("potted_sunkettle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNKETTLE, propertiesPot()));
	public static final RegistryObject<Block> SUNSPONGE = register("sunsponge", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_SUNSPONGE = register("potted_sunsponge", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNSPONGE, propertiesPot()));
	public static final RegistryObject<Block> VOIDLILY = register("voidlily", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_VOIDLILY = register("potted_voidlily", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, VOIDLILY, propertiesPot()));

	public static final RegistryObject<Block> BOLBOS = register("bolbos", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> DATHULLA = register("dathulla", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MONDANOS = register("mondanos", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> MOTH_AGARIC = register("moth_agaric", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> NAMDRAKE = register("namdrake", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> PSILOCYBOS = register("psilocybos", () -> new WaterloggedBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> ROWAN = register("rowan", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> WILTED_ELM = register("wilted_elm", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));

	public static final RegistryObject<Block> BLUE_GROUND_FLOWERS = register("blue_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> CYAN_GROUND_FLOWERS = register("cyan_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> PINK_GROUND_FLOWERS = register("pink_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> PURPLE_GROUND_FLOWERS = register("purple_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> RED_GROUND_FLOWERS = register("red_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> WHITE_GROUND_FLOWERS = register("white_ground_flowers", () -> new GroundFlowerBlock(propertiesPlant(MaterialColor.NONE)));

	public static final RegistryObject<Block> FOREST_MOSS = register("forest_moss", () -> new LayerBlock(propertiesMoss()));
	public static final RegistryObject<Block> SCRUBLAND_MOSS = register("scrubland_moss", () -> new LayerBlock(propertiesMoss()));
	public static final RegistryObject<Block> STEPPE_MOSS = register("steppe_moss", () -> new LayerBlock(propertiesMoss()));

	public static final RegistryObject<Block> PALM_FERN = register("palm_fern", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PALM_FERN = register("potted_palm_fern", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PALM_FERN, propertiesPot()));

	public static final RegistryObject<Block> WHITE_BROMELIA = register("white_bromelia", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_WHITE_BROMELIA = register("potted_white_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WHITE_BROMELIA, propertiesPot()));
	public static final RegistryObject<Block> ORANGE_BROMELIA = register("orange_bromelia", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_ORANGE_BROMELIA = register("potted_orange_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ORANGE_BROMELIA, propertiesPot()));
	public static final RegistryObject<Block> PINK_BROMELIA = register("pink_bromelia", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PINK_BROMELIA = register("potted_pink_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PINK_BROMELIA, propertiesPot()));
	public static final RegistryObject<Block> PURPLE_BROMELIA = register("purple_bromelia", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_PURPLE_BROMELIA = register("potted_purple_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_BROMELIA, propertiesPot()));

	public static final RegistryObject<Block> GREEN_GROUND_SHROOMS = register("green_ground_shrooms", () -> new GroundShroomBlock(propertiesShroom(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> POTTED_GREEN_GROUND_SHROOMS = register("potted_green_ground_shrooms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, GREEN_GROUND_SHROOMS, propertiesPot()));
	public static final RegistryObject<Block> BROWN_GROUND_SHROOMS = register("brown_ground_shrooms", () -> new GroundShroomBlock(propertiesShroom(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> POTTED_BROWN_GROUND_SHROOMS = register("potted_brown_ground_shrooms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BROWN_GROUND_SHROOMS, propertiesPot()));
	public static final RegistryObject<Block> LARGE_BROWN_GROUND_SHROOMS = register("large_brown_ground_shrooms", () -> new GroundShroomBlock(propertiesShroom(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> POTTED_LARGE_BROWN_GROUND_SHROOMS = register("potted_large_brown_ground_shrooms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LARGE_BROWN_GROUND_SHROOMS, propertiesPot()));

	public static final RegistryObject<Block> TINDER_FUNGUS_TREE_SHROOMS = register("tinder_fungus_tree_shrooms", () -> new TreeShroomBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> TURKEY_TAIL_TREE_SHROOMS = register("turkey_tail_tree_shrooms", () -> new TreeShroomBlock(propertiesPlant(MaterialColor.NONE)));
	public static final RegistryObject<Block> UNNAMED_TREE_SHROOMS = register("unnamed_tree_shrooms", () -> new TreeShroomBlock(propertiesPlant(MaterialColor.NONE)));

	public static final RegistryObject<Block> CARDON_CACTUS = register("cardon_cactus", () -> new CardonCactusBlock(propertiesCactus(MaterialColor.PLANT)));
	public static final RegistryObject<Block> POTTED_CARDON_CACTUS = register("potted_cardon_cactus", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CARDON_CACTUS, propertiesPot()));

	public static final RegistryObject<Block> STRAWBERRY_BUSH = register("strawberry_bush", () -> new IcariaBushBlock(propertiesBush(MaterialColor.PLANT)));

	public static final RegistryObject<Block> SPELT_CROP = register("spelt_crop", () -> new SpeltCropBlock(propertiesCrop()));
	public static final RegistryObject<Block> STRAWBERRY_CROP = register("strawberry_crop", () -> new StrawberryCropBlock(propertiesCrop()));
	public static final RegistryObject<Block> PHYSALIS_CROP = register("physalis_crop", () -> new PhysalisCropBlock(propertiesCrop()));
	public static final RegistryObject<Block> ONION_CROP = register("onion_crop", () -> new OnionCropBlock(propertiesCrop()));

	public static final RegistryObject<LiquidBlock> MEDITERRANEAN_WATER = register("mediterranean_water", () -> new LiquidBlock(IcariaFluids.MEDITERRANEAN_WATER, propertiesFluid(MaterialColor.WATER)));

	public static final RegistryObject<Block> GREEK_FIRE = register("greek_fire", () -> new GreekFireBlock(propertiesGreekFire()));

	public static final RegistryObject<Block> PORTAL = register("portal", () -> new IcariaPortalBlock(propertiesPortal()));

	public static boolean always(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	public static Properties propertiesGrass() {
		return Properties.of(Material.GRASS, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).strength(0.6F, 0.6F).randomTicks();
	}

	public static Properties propertiesMarl() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).strength(0.5F, 0.5F);
	}

	public static Properties propertiesFarmland() {
		return Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.GRAVEL).strength(0.6F, 0.6F).randomTicks();
	}

	public static Properties propertiesLoam() {
		return Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.GRAVEL).strength(0.6F, 0.6F);
	}

	public static Properties propertiesGrainel() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.SAND).strength(0.5F, 0.5F);
	}

	public static Properties propertiesGlass() {
		return Properties.of(Material.GLASS, MaterialColor.NONE).sound(SoundType.GLASS).strength(0.3F, 0.3F).noOcclusion();
	}

	public static Properties propertiesSilksand() {
		return Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.SAND).strength(0.5F, 0.5F);
	}

	public static Properties propertiesStone(MaterialColor pColor) {
		return Properties.of(Material.STONE, pColor).sound(SoundType.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops();
	}

	public static Properties propertiesRubble() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.STONE).instabreak().noCollission().noOcclusion();
	}

	public static Properties propertiesQuartz() {
		return Properties.of(Material.STONE, MaterialColor.QUARTZ).sound(SoundType.STONE).strength(0.8F, 0.8F).requiresCorrectToolForDrops();
	}

	public static Properties propertiesAristone() {
		return Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).sound(IcariaSoundTypes.ARISTONE).strength(0.5F, 0.5F).friction(0.98F).noOcclusion();
	}

	public static Properties propertiesGeodeBlock(MaterialColor pColor) {
		return Properties.of(Material.GLASS, pColor).sound(SoundType.AMETHYST).strength(1.5F, 1.5F).requiresCorrectToolForDrops();
	}

	public static Properties propertiesCrystalBlock() {
		return Properties.of(Material.GLASS, MaterialColor.NONE).sound(SoundType.AMETHYST_CLUSTER).strength(1.5F, 1.5F).lightLevel((pBlockState) -> 5).noOcclusion().requiresCorrectToolForDrops();
	}

	public static Properties propertiesJellyfishJellyBlock() {
		return Properties.of(Material.CLAY, MaterialColor.COLOR_RED).sound(SoundType.SLIME_BLOCK).strength(0.5F, 0.5F).friction(0.8F).noOcclusion();
	}

	public static Properties propertiesArachneStringBlock() {
		return Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN).sound(SoundType.WOOL).strength(0.8F, 0.8F);
	}

	public static Properties propertiesSpeltBaleBlock() {
		return Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.GRASS).strength(0.5F, 0.5F);
	}

	public static Properties propertiesVineReedBlock() {
		return Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(0.5F, 2.5F);
	}

	public static Properties propertiesRottenBonesBlock() {
		return Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).sound(SoundType.BONE_BLOCK).strength(2.0F, 2.0F).requiresCorrectToolForDrops();
	}

	public static Properties propertiesCrystalStorageBlock(MaterialColor pColor) {
		return Properties.of(Material.GLASS, pColor).sound(SoundType.GLASS).strength(1.2F, 1.2F).lightLevel((pBlockState) -> 6).noOcclusion().requiresCorrectToolForDrops();
	}

	public static Properties propertiesGemStorageBlock(MaterialColor pColor) {
		return Properties.of(Material.STONE, pColor).sound(SoundType.STONE).strength(5.0F, 6.0F).requiresCorrectToolForDrops();
	}

	public static Properties propertiesMetalStorageBlock(MaterialColor pColor) {
		return Properties.of(Material.METAL, pColor).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops();
	}

	public static Properties propertiesBars() {
		return Properties.of(Material.METAL, MaterialColor.NONE).sound(SoundType.METAL).strength(5.0F, 6.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static Properties propertiesGrinder() {
		return Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.3F, 1.3F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static Properties propertiesStorageVase(MaterialColor pColor) {
		return Properties.of(Material.STONE, pColor).sound(IcariaSoundTypes.VASE).strength(1.3F, 1.3F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static Properties propertiesLootVase(MaterialColor pColor) {
		return Properties.of(Material.STONE, pColor).sound(IcariaSoundTypes.VASE).instabreak().noOcclusion();
	}

	public static Properties propertiesSpawners(MaterialColor pColor, SoundType pSound) {
		return Properties.of(Material.STONE, pColor).sound(pSound).strength(5.0F, 5.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static Properties propertiesSkull() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).strength(1.0F, 1.0F);
	}

	public static Properties propertiesTorch() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.METAL).instabreak().noCollission();
	}

	public static Properties propertiesCake() {
		return Properties.of(Material.CAKE, MaterialColor.NONE).sound(SoundType.WOOL).strength(0.5F, 0.5F);
	}

	public static Properties propertiesSapling() {
		return Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).instabreak().noCollission().randomTicks();
	}

	public static Properties propertiesPot() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).instabreak().noOcclusion();
	}

	public static Properties propertiesLeaves() {
		return Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).strength(0.2F, 0.2F).isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false).noOcclusion().randomTicks();
	}

	public static Properties propertiesTwigs() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.WOOD).instabreak().noCollission().noOcclusion();
	}

	public static Properties propertiesWood(MaterialColor pColorEnd, MaterialColor pColorSide) {
		return Properties.of(Material.WOOD, (pState) -> pState.getValue(RotatedPillarBlock.AXIS) == Axis.Y ? pColorEnd : pColorSide).sound(SoundType.WOOD).strength(2.0F, 2.0F).noOcclusion();
	}

	public static Properties propertiesPlanks(MaterialColor pColor) {
		return Properties.of(Material.WOOD, pColor).sound(SoundType.WOOD).strength(2.0F, 3.0F);
	}

	public static Properties propertiesCraftingTable(MaterialColor pColor) {
		return Properties.of(Material.WOOD, pColor).sound(SoundType.WOOD).strength(2.5F, 2.5F);
	}

	public static Properties propertiesDoor(MaterialColor pColor) {
		return Properties.of(Material.WOOD, pColor).sound(SoundType.WOOD).strength(3.0F, 3.0F).noOcclusion();
	}

	public static Properties propertiesLadder() {
		return Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.LADDER).strength(0.4F, 0.4F).noOcclusion();
	}

	public static Properties propertiesSign(MaterialColor pColor) {
		return Properties.of(Material.WOOD, pColor).sound(SoundType.WOOD).strength(1.0F, 1.0F).noCollission();
	}

	public static Properties propertiesVine(MaterialColor pColor) {
		return Properties.of(Material.PLANT, pColor).sound(SoundType.VINE).strength(0.2F, 0.2F).noCollission();
	}

	public static Properties propertiesBush(MaterialColor pColor) {
		return Properties.of(Material.PLANT, pColor).sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).instabreak().noCollission();
	}

	public static Properties propertiesPlant(MaterialColor pColor) {
		return Properties.of(Material.PLANT, pColor).sound(SoundType.GRASS).instabreak().noCollission();
	}

	public static Properties propertiesMoss() {
		return Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.GRASS).strength(0.1F, 0.1F);
	}

	public static Properties propertiesShroom(MaterialColor pColor) {
		return Properties.of(Material.PLANT, pColor).sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess(IcariaBlocks::always).instabreak().noCollission().randomTicks();
	}

	public static Properties propertiesCactus(MaterialColor pColor) {
		return Properties.of(Material.CACTUS, pColor).sound(SoundType.WOOL).strength(0.4F, 0.4F).randomTicks();
	}

	public static Properties propertiesCrop() {
		return Properties.of(Material.PLANT, MaterialColor.PLANT).sound(SoundType.CROP).instabreak().noCollission().randomTicks();
	}

	public static Properties propertiesFluid(MaterialColor pColor) {
		return Properties.of(Material.WATER, pColor).strength(100.0F, 100.0F).noCollission().noLootTable();
	}

	public static Properties propertiesGreekFire() {
		return Properties.of(Material.FIRE, MaterialColor.NONE).sound(SoundType.WOOL).lightLevel((pBlockState) -> 15).instabreak().noCollission();
	}

	public static Properties propertiesPortal() {
		return Properties.of(Material.PORTAL, MaterialColor.NONE).sound(SoundType.GLASS).strength(-1.0F, -1.0F).lightLevel((pBlockState) -> 11).noCollission();
	}

	public static <T extends Block> RegistryObject<T> register(String pName, Supplier<? extends T> pSupplier) {
		return IcariaBlocks.BLOCKS.register(pName, pSupplier);
	}

	public static <T extends Block> RegistryObject<T> registerBasic(String pName, Supplier<? extends T> pSupplier) {
		RegistryObject<T> registryObject = register(pName, pSupplier);
		IcariaBlocks.BASIC_BLOCKS.add(registryObject);
		return registryObject;
	}

	public static class StoneDecoBlocks {
		public String name;

		public RegistryObject<Block> block;
		public RegistryObject<StairBlock> stairs;
		public RegistryObject<SlabBlock> slab;
		public RegistryObject<WallBlock> wall;

		public StoneDecoBlocks(String pName, RegistryObject<Block> pBlock, Properties pProperties, boolean pStairs, boolean pSlab, boolean pWall) {
			this.name = pName;
			this.block = pBlock;
			this.stairs = register(pName + "_stairs", () -> new StairBlock(() -> pBlock.get().defaultBlockState(), pProperties));
			this.slab = register(pName + "_slab", () -> new SlabBlock(pProperties));
			this.wall = register(pName + "_wall", () -> new WallBlock(pProperties));
		}

		public StoneDecoBlocks(String pName, RegistryObject<Block> pBlock, Properties pProperties) {
			this(pName, pBlock, pProperties, true, true, true);
		}
	}

	public static class WoodDecoBlocks {
		public String name;

		public RegistryObject<Block> block;
		public RegistryObject<StairBlock> stairs;
		public RegistryObject<SlabBlock> slab;
		public RegistryObject<FenceBlock> fence;
		public RegistryObject<FenceGateBlock> gate;

		public WoodDecoBlocks(String pName, RegistryObject<Block> pBlock, Properties pProperties, boolean pStairs, boolean pSlab, boolean pFence, boolean pGate) {
			this.name = pName;
			this.block = pBlock;
			this.stairs = register(pName + "_stairs", () -> new StairBlock(() -> pBlock.get().defaultBlockState(), pProperties));
			this.slab = register(pName + "_slab", () -> new SlabBlock(pProperties));
			this.fence = register(pName + "_fence", () -> new FenceBlock(pProperties));
			this.gate = register(pName + "_fence_gate", () -> new FenceGateBlock(pProperties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
		}

		public WoodDecoBlocks(String pName, RegistryObject<Block> pBlock, Properties pProperties) {
			this(pName, pBlock, pProperties, true, true, true, true);
		}
	}
}
