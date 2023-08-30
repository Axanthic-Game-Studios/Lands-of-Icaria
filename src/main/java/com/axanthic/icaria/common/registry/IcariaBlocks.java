package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.block.*;
import com.axanthic.icaria.common.block.LayerBlock;
import com.axanthic.icaria.common.block.IcariaSandBlock;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;
import com.axanthic.icaria.common.world.tree.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault

public class IcariaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, IcariaInfo.ID);

	public static final List<RegistryObject<? extends Block>> SIMPLE_BLOCKS = new ArrayList<>();

	public static final RegistryObject<Block> GRASSY_MARL = IcariaBlocks.register("grassy_marl", () -> new GrassyMarlBlock(IcariaBlocks.propertiesGrassyMarl(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> MARL = IcariaBlocks.registerSimple("marl", () -> new IcariaDirtBlock(IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL)));
	public static final RegistryObject<Block> MARL_CHERT = IcariaBlocks.register("marl_chert", () -> new Block(IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL)));
	public static final RegistryObject<Block> SURFACE_CHERT = IcariaBlocks.register("surface_chert", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> MARL_BONES = IcariaBlocks.register("marl_bones", () -> new Block(IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL)));
	public static final RegistryObject<Block> SURFACE_BONES = IcariaBlocks.register("surface_bones", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.BONE_BLOCK)));
	public static final RegistryObject<Block> MARL_LIGNITE = IcariaBlocks.register("marl_lignite", () -> new Block(IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL)));
	public static final RegistryObject<Block> SURFACE_LIGNITE = IcariaBlocks.register("surface_lignite", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> COARSE_MARL = IcariaBlocks.registerSimple("coarse_marl", () -> new IcariaDirtBlock(IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL)));
	public static final RegistryObject<Block> DRY_LAKE_BED = IcariaBlocks.registerSimple("dry_lake_bed", () -> new IcariaDirtBlock(IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL)));

	public static final RegistryObject<Block> FARMLAND = IcariaBlocks.register("farmland", () -> new FarmlandBlock(IcariaBlocks.propertiesFarmland(MapColor.COLOR_BROWN, SoundType.GRAVEL)));
	public static final RegistryObject<Block> FERTILIZED_FARMLAND = IcariaBlocks.register("fertilized_farmland", () -> new FertilizedFarmlandBlock(IcariaBlocks.propertiesFarmland(MapColor.COLOR_BROWN, SoundType.GRAVEL)));

	public static final RegistryObject<Block> MARL_ADOBE = IcariaBlocks.registerSimple("marl_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks MARL_ADOBE_DECO = new IcariaStoneDecoBlocks("marl_adobe", IcariaBlocks.MARL_ADOBE, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE));

	public static final RegistryObject<Block> LOAM = IcariaBlocks.register("loam", () -> new LoamBlock(IcariaBlocks.propertiesLoam(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.GRAVEL)));
	public static final RegistryObject<Block> LOAM_BRICKS = IcariaBlocks.registerSimple("loam_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks LOAM_BRICK_DECO = new IcariaStoneDecoBlocks("loam_brick", IcariaBlocks.LOAM_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));

	public static final RegistryObject<Block> DOLOMITE_ADOBE = IcariaBlocks.registerSimple("dolomite_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks DOLOMITE_ADOBE_DECO = new IcariaStoneDecoBlocks("dolomite_adobe", IcariaBlocks.DOLOMITE_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final RegistryObject<Block> SMOOTH_DOLOMITE = IcariaBlocks.registerSimple("smooth_dolomite", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SMOOTH_DOLOMITE_DECO = new IcariaStoneDecoBlocks("smooth_dolomite", IcariaBlocks.SMOOTH_DOLOMITE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final RegistryObject<Block> DOLOMITE_BRICKS = IcariaBlocks.registerSimple("dolomite_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE)));
	public static final RegistryObject<RotatedPillarBlock> DOLOMITE_PILLAR = IcariaBlocks.register("dolomite_pillar", () -> new RotatedPillarBlock(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE)));
	public static final RegistryObject<PillarHeadBlock> DOLOMITE_PILLAR_HEAD = IcariaBlocks.register("dolomite_pillar_head", () -> new PillarHeadBlock(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE)));

	public static final RegistryObject<Block> GRAINEL = IcariaBlocks.registerSimple("grainel", () -> new IcariaSandBlock(IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_YELLOW, SoundType.SAND)));
	public static final RegistryObject<Block> GRAINEL_CHERT = IcariaBlocks.register("grainel_chert", () -> new Block(IcariaBlocks.propertiesSandOre(MapColor.TERRACOTTA_YELLOW, SoundType.SAND)));
	public static final RegistryObject<GlassBlock> GRAINGLASS = IcariaBlocks.register("grainglass", () -> new GlassBlock(IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS)));
	public static final RegistryObject<IronBarsBlock> GRAINGLASS_PANE = IcariaBlocks.register("grainglass_pane", () -> new IronBarsBlock(IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS)));
	public static final RegistryObject<Block> HORIZONTAL_GRAINGLASS_PANE = IcariaBlocks.register("horizontal_grainglass_pane", () -> new HorizontalPaneBlock(IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS)));
	public static final RegistryObject<Block> GRAINITE_ADOBE = IcariaBlocks.registerSimple("grainite_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks GRAINITE_ADOBE_DECO = new IcariaStoneDecoBlocks("grainite_adobe", IcariaBlocks.GRAINITE_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final RegistryObject<Block> GRAINITE = IcariaBlocks.registerSimple("grainite", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks GRAINITE_DECO = new IcariaStoneDecoBlocks("grainite", IcariaBlocks.GRAINITE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final RegistryObject<Block> GRAINITE_BRICKS = IcariaBlocks.registerSimple("grainite_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks GRAINITE_BRICK_DECO = new IcariaStoneDecoBlocks("grainite_brick", IcariaBlocks.GRAINITE_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_GRAINITE = IcariaBlocks.registerSimple("chiseled_grainite", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE)));
	public static final RegistryObject<Block> GRAINITE_RUBBLE = IcariaBlocks.register("grainite_rubble", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> YELLOWSTONE_ADOBE = IcariaBlocks.registerSimple("yellowstone_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks YELLOWSTONE_ADOBE_DECO = new IcariaStoneDecoBlocks("yellowstone_adobe", IcariaBlocks.YELLOWSTONE_ADOBE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> COBBLED_YELLOWSTONE = IcariaBlocks.registerSimple("cobbled_yellowstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks COBBLED_YELLOWSTONE_DECO = new IcariaStoneDecoBlocks("cobbled_yellowstone", IcariaBlocks.COBBLED_YELLOWSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> YELLOWSTONE = IcariaBlocks.register("yellowstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks YELLOWSTONE_DECO = new IcariaStoneDecoBlocks("yellowstone", IcariaBlocks.YELLOWSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> YELLOWSTONE_BRICKS = IcariaBlocks.registerSimple("yellowstone_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks YELLOWSTONE_BRICK_DECO = new IcariaStoneDecoBlocks("yellowstone_brick", IcariaBlocks.YELLOWSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_YELLOWSTONE = IcariaBlocks.registerSimple("chiseled_yellowstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> YELLOWSTONE_RUBBLE = IcariaBlocks.register("yellowstone_rubble", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> SILKSAND = IcariaBlocks.registerSimple("silksand", () -> new IcariaSandBlock(IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.SAND)));
	public static final RegistryObject<GlassBlock> SILKGLASS = IcariaBlocks.register("silkglass", () -> new GlassBlock(IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS)));
	public static final RegistryObject<IronBarsBlock> SILKGLASS_PANE = IcariaBlocks.register("silkglass_pane", () -> new IronBarsBlock(IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS)));
	public static final RegistryObject<Block> HORIZONTAL_SILKGLASS_PANE = IcariaBlocks.register("horizontal_silkglass_pane", () -> new HorizontalPaneBlock(IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS)));
	public static final RegistryObject<Block> SILKSTONE_ADOBE = IcariaBlocks.registerSimple("silkstone_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SILKSTONE_ADOBE_DECO = new IcariaStoneDecoBlocks("silkstone_adobe", IcariaBlocks.SILKSTONE_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final RegistryObject<Block> COBBLED_SILKSTONE = IcariaBlocks.registerSimple("cobbled_silkstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks COBBLED_SILKSTONE_DECO = new IcariaStoneDecoBlocks("cobbled_silkstone", IcariaBlocks.COBBLED_SILKSTONE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final RegistryObject<Block> SILKSTONE = IcariaBlocks.register("silkstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SILKSTONE_DECO = new IcariaStoneDecoBlocks("silkstone", IcariaBlocks.SILKSTONE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final RegistryObject<Block> SILKSTONE_BRICKS = IcariaBlocks.registerSimple("silkstone_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SILKSTONE_BRICK_DECO = new IcariaStoneDecoBlocks("silkstone_brick", IcariaBlocks.SILKSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_SILKSTONE = IcariaBlocks.registerSimple("chiseled_silkstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final RegistryObject<Block> SILKSTONE_RUBBLE = IcariaBlocks.register("silkstone_rubble", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> SUNSTONE_ADOBE = IcariaBlocks.registerSimple("sunstone_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SUNSTONE_ADOBE_DECO = new IcariaStoneDecoBlocks("sunstone_adobe", IcariaBlocks.SUNSTONE_ADOBE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> COBBLED_SUNSTONE = IcariaBlocks.registerSimple("cobbled_sunstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks COBBLED_SUNSTONE_DECO = new IcariaStoneDecoBlocks("cobbled_sunstone", IcariaBlocks.COBBLED_SUNSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> SUNSTONE = IcariaBlocks.register("sunstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SUNSTONE_DECO = new IcariaStoneDecoBlocks("sunstone", IcariaBlocks.SUNSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> SUNSTONE_BRICKS = IcariaBlocks.registerSimple("sunstone_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SUNSTONE_BRICK_DECO = new IcariaStoneDecoBlocks("sunstone_brick", IcariaBlocks.SUNSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_SUNSTONE = IcariaBlocks.registerSimple("chiseled_sunstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> SUNSTONE_RUBBLE = IcariaBlocks.register("sunstone_rubble", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> VOIDSHALE_ADOBE = IcariaBlocks.registerSimple("voidshale_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks VOIDSHALE_ADOBE_DECO = new IcariaStoneDecoBlocks("voidshale_adobe", IcariaBlocks.VOIDSHALE_ADOBE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final RegistryObject<Block> COBBLED_VOIDSHALE = IcariaBlocks.registerSimple("cobbled_voidshale", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks COBBLED_VOIDSHALE_DECO = new IcariaStoneDecoBlocks("cobbled_voidshale", IcariaBlocks.COBBLED_VOIDSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final RegistryObject<Block> VOIDSHALE = IcariaBlocks.register("voidshale", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks VOIDSHALE_DECO = new IcariaStoneDecoBlocks("voidshale", IcariaBlocks.VOIDSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final RegistryObject<Block> VOIDSHALE_BRICKS = IcariaBlocks.registerSimple("voidshale_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks VOIDSHALE_BRICK_DECO = new IcariaStoneDecoBlocks("voidshale_brick", IcariaBlocks.VOIDSHALE_BRICKS, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_VOIDSHALE = IcariaBlocks.registerSimple("chiseled_voidshale", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE)));
	public static final RegistryObject<Block> VOIDSHALE_RUBBLE = IcariaBlocks.register("voidshale_rubble", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> BAETYL_ADOBE = IcariaBlocks.registerSimple("baetyl_adobe", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks BAETYL_ADOBE_DECO = new IcariaStoneDecoBlocks("baetyl_adobe", IcariaBlocks.BAETYL_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final RegistryObject<Block> COBBLED_BAETYL = IcariaBlocks.registerSimple("cobbled_baetyl", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks COBBLED_BAETYL_DECO = new IcariaStoneDecoBlocks("cobbled_baetyl", IcariaBlocks.COBBLED_BAETYL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final RegistryObject<Block> BAETYL = IcariaBlocks.register("baetyl", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks BAETYL_DECO = new IcariaStoneDecoBlocks("baetyl", IcariaBlocks.BAETYL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final RegistryObject<Block> BAETYL_BRICKS = IcariaBlocks.registerSimple("baetyl_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks BAETYL_BRICK_DECO = new IcariaStoneDecoBlocks("baetyl_brick", IcariaBlocks.BAETYL_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_BAETYL = IcariaBlocks.registerSimple("chiseled_baetyl", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE)));
	public static final RegistryObject<Block> BAETYL_RUBBLE = IcariaBlocks.register("baetyl_rubble", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> RELICSTONE = IcariaBlocks.registerSimple("relicstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks RELICSTONE_DECO = new IcariaStoneDecoBlocks("relicstone", IcariaBlocks.RELICSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> SMOOTH_RELICSTONE = IcariaBlocks.register("smooth_relicstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks SMOOTH_RELICSTONE_DECO = new IcariaStoneDecoBlocks("smooth_relicstone", IcariaBlocks.SMOOTH_RELICSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> RELICSTONE_BRICKS = IcariaBlocks.registerSimple("relicstone_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks RELICSTONE_BRICK_DECO = new IcariaStoneDecoBlocks("relicstone_brick", IcariaBlocks.RELICSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> CRACKED_RELICSTONE_BRICKS = IcariaBlocks.registerSimple("cracked_relicstone_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks CRACKED_RELICSTONE_BRICK_DECO = new IcariaStoneDecoBlocks("cracked_relicstone_brick", IcariaBlocks.CRACKED_RELICSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> MOSSY_RELICSTONE_BRICKS = IcariaBlocks.registerSimple("mossy_relicstone_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks MOSSY_RELICSTONE_BRICK_DECO = new IcariaStoneDecoBlocks("mossy_relicstone_brick", IcariaBlocks.MOSSY_RELICSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> RELICSTONE_TILES = IcariaBlocks.registerSimple("relicstone_tiles", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks RELICSTONE_TILE_DECO = new IcariaStoneDecoBlocks("relicstone_tile", IcariaBlocks.RELICSTONE_TILES, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> CRACKED_RELICSTONE_TILES = IcariaBlocks.registerSimple("cracked_relicstone_tiles", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks CRACKED_RELICSTONE_TILE_DECO = new IcariaStoneDecoBlocks("cracked_relicstone_tile", IcariaBlocks.CRACKED_RELICSTONE_TILES, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> MOSSY_RELICSTONE_TILES = IcariaBlocks.registerSimple("mossy_relicstone_tiles", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks MOSSY_RELICSTONE_TILE_DECO = new IcariaStoneDecoBlocks("mossy_relicstone_tile", IcariaBlocks.MOSSY_RELICSTONE_TILES, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_RELICSTONE = IcariaBlocks.registerSimple("chiseled_relicstone", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<RotatedPillarBlock> RELICSTONE_PILLAR = IcariaBlocks.register("relicstone_pillar", () -> new RotatedPillarBlock(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> RELICSTONE_PILLAR_HEAD = IcariaBlocks.register("relicstone_pillar_head", () -> new PillarHeadBlock(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> RELICSTONE_RUBBLE = IcariaBlocks.register("relicstone_rubble", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> PLATOSHALE = IcariaBlocks.registerSimple("platoshale", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks PLATOSHALE_DECO = new IcariaStoneDecoBlocks("platoshale", IcariaBlocks.PLATOSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final RegistryObject<Block> BLURRED_PLATOSHALE = IcariaBlocks.register("blurred_platoshale", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE)));
	public static final RegistryObject<Block> PLATOSHALE_BRICKS = IcariaBlocks.registerSimple("platoshale_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE)));
	public static final IcariaStoneDecoBlocks PLATOSHALE_BRICK_DECO = new IcariaStoneDecoBlocks("platoshale_brick", IcariaBlocks.PLATOSHALE_BRICKS, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final RegistryObject<Block> BLURRED_PLATOSHALE_BRICKS = IcariaBlocks.register("blurred_platoshale_bricks", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_PLATOSHALE = IcariaBlocks.registerSimple("chiseled_platoshale", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE)));

	public static final RegistryObject<Block> QUARTZ_PILLAR_HEAD = IcariaBlocks.register("quartz_pillar_head", () -> new PillarHeadBlock(IcariaBlocks.propertiesQuartz(MapColor.QUARTZ, SoundType.STONE)));

	public static final RegistryObject<Block> LIGNITE_ORE = IcariaBlocks.register("lignite_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> CHALKOS_ORE = IcariaBlocks.register("chalkos_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> KASSITEROS_ORE = IcariaBlocks.register("kassiteros_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final RegistryObject<Block> DOLOMITE_ORE = IcariaBlocks.register("dolomite_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE)));
	public static final RegistryObject<Block> VANADIUM_ORE = IcariaBlocks.register("vanadium_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> SLIVER_ORE = IcariaBlocks.register("sliver_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> SIDEROS_ORE = IcariaBlocks.register("sideros_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE)));
	public static final RegistryObject<Block> ANTHRACITE_ORE = IcariaBlocks.register("anthracite_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE)));
	public static final RegistryObject<Block> MOLYBDENUM_ORE = IcariaBlocks.register("molybdenum_ore", () -> new Block(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE)));
	public static final RegistryObject<Block> HYLIASTRUM_ORE = IcariaBlocks.register("hyliastrum_ore", () -> new HyliastrumOreBlock(IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE)));

	public static final RegistryObject<Block> CALCITE = IcariaBlocks.registerSimple("calcite", () -> new AmethystBlock(IcariaBlocks.propertiesMineral(MapColor.COLOR_LIGHT_GRAY, SoundType.AMETHYST)));
	public static final RegistryObject<Block> BUDDING_CALCITE = IcariaBlocks.registerSimple("budding_calcite", () -> new AmethystBlock(IcariaBlocks.propertiesBudding(MapColor.COLOR_LIGHT_GRAY, SoundType.AMETHYST)));
	public static final RegistryObject<Block> HALITE = IcariaBlocks.registerSimple("halite", () -> new AmethystBlock(IcariaBlocks.propertiesMineral(MapColor.COLOR_GREEN, SoundType.AMETHYST)));
	public static final RegistryObject<Block> BUDDING_HALITE = IcariaBlocks.registerSimple("budding_halite", () -> new AmethystBlock(IcariaBlocks.propertiesBudding(MapColor.COLOR_GREEN, SoundType.AMETHYST)));
	public static final RegistryObject<Block> JASPER = IcariaBlocks.registerSimple("jasper", () -> new AmethystBlock(IcariaBlocks.propertiesMineral(MapColor.COLOR_RED, SoundType.AMETHYST)));
	public static final RegistryObject<Block> BUDDING_JASPER = IcariaBlocks.registerSimple("budding_jasper", () -> new AmethystBlock(IcariaBlocks.propertiesBudding(MapColor.COLOR_RED, SoundType.AMETHYST)));
	public static final RegistryObject<Block> ZIRCON = IcariaBlocks.registerSimple("zircon", () -> new AmethystBlock(IcariaBlocks.propertiesMineral(MapColor.COLOR_BLUE, SoundType.AMETHYST)));
	public static final RegistryObject<Block> BUDDING_ZIRCON = IcariaBlocks.registerSimple("budding_zircon", () -> new AmethystBlock(IcariaBlocks.propertiesBudding(MapColor.COLOR_BLUE, SoundType.AMETHYST)));

	public static final RegistryObject<Block> CALCITE_CRYSTAL = IcariaBlocks.register("calcite_crystal", () -> new CrystalBlock(IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER)));
	public static final RegistryObject<Block> HALITE_CRYSTAL = IcariaBlocks.register("halite_crystal", () -> new CrystalBlock(IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER)));
	public static final RegistryObject<Block> JASPER_CRYSTAL = IcariaBlocks.register("jasper_crystal", () -> new CrystalBlock(IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER)));
	public static final RegistryObject<Block> ZIRCON_CRYSTAL = IcariaBlocks.register("zircon_crystal", () -> new CrystalBlock(IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER)));

	public static final RegistryObject<Block> ARISTONE = IcariaBlocks.registerSimple("aristone", () -> new GlassBlock(IcariaBlocks.propertiesAristone(MapColor.TERRACOTTA_LIGHT_GREEN, IcariaSoundTypes.ARISTONE)));
	public static final RegistryObject<Block> PACKED_ARISTONE = IcariaBlocks.registerSimple("packed_aristone", () -> new Block(IcariaBlocks.propertiesPackedAristone(MapColor.TERRACOTTA_LIGHT_GREEN, IcariaSoundTypes.ARISTONE)));

	public static final RegistryObject<Block> ENDER_JELLYFISH_JELLY_BLOCK = IcariaBlocks.registerSimple("ender_jellyfish_jelly_block", () -> new JellyfishJellyBlock(IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_BLACK, SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> FIRE_JELLYFISH_JELLY_BLOCK = IcariaBlocks.registerSimple("fire_jellyfish_jelly_block", () -> new JellyfishJellyBlock(IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_ORANGE, SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> NATURE_JELLYFISH_JELLY_BLOCK = IcariaBlocks.registerSimple("nature_jellyfish_jelly_block", () -> new JellyfishJellyBlock(IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.WARPED_WART_BLOCK, SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> VOID_JELLYFISH_JELLY_BLOCK = IcariaBlocks.registerSimple("void_jellyfish_jelly_block", () -> new JellyfishJellyBlock(IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_MAGENTA, SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> WATER_JELLYFISH_JELLY_BLOCK = IcariaBlocks.registerSimple("water_jellyfish_jelly_block", () -> new JellyfishJellyBlock(IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> ARACHNE_STRING_BLOCK = IcariaBlocks.registerSimple("arachne_string_block", () -> new Block(IcariaBlocks.propertiesArachneStringBlock(MapColor.COLOR_BROWN, SoundType.WOOL)));
	public static final RegistryObject<RotatedPillarBlock> SPELT_BALE_BLOCK = IcariaBlocks.register("spelt_bale_block", () -> new SpeltBaleBlock(IcariaBlocks.propertiesSpeltBaleBlock(MapColor.TERRACOTTA_YELLOW, SoundType.GRASS)));
	public static final RegistryObject<Block> VINE_REED_BLOCK = IcariaBlocks.registerSimple("vine_reed_block", () -> new Block(IcariaBlocks.propertiesVineReedBlock(MapColor.WOOD, SoundType.WOOD)));
	public static final RegistryObject<Block> VINE_SPROUT_BLOCK = IcariaBlocks.registerSimple("vine_sprout_block", () -> new Block(IcariaBlocks.propertiesVineSproutBlock(MapColor.TERRACOTTA_LIGHT_BLUE, SoundType.WOOD)));
	public static final RegistryObject<Block> ROTTEN_BONES_BLOCK = IcariaBlocks.registerSimple("rotten_bones_block", () -> new Block(IcariaBlocks.propertiesRottenBonesBlock(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.BONE_BLOCK)));

	public static final RegistryObject<Block> RAW_CHALKOS_BLOCK = IcariaBlocks.registerSimple("raw_chalkos_block", () -> new Block(IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_GREEN, SoundType.METAL)));
	public static final RegistryObject<Block> RAW_KASSITEROS_BLOCK = IcariaBlocks.registerSimple("raw_kassiteros_block", () -> new Block(IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL)));
	public static final RegistryObject<Block> RAW_VANADIUM_BLOCK = IcariaBlocks.registerSimple("raw_vanadium_block", () -> new Block(IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL)));
	public static final RegistryObject<Block> SLIVER_BLOCK = IcariaBlocks.registerSimple("sliver_block", () -> new Block(IcariaBlocks.propertiesRawMetalBlock(MapColor.WOOD, SoundType.METAL)));
	public static final RegistryObject<Block> RAW_SIDEROS_BLOCK = IcariaBlocks.registerSimple("raw_sideros_block", () -> new Block(IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL)));
	public static final RegistryObject<Block> RAW_MOLYBDENUM_BLOCK = IcariaBlocks.registerSimple("raw_molybdenum_block", () -> new Block(IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL)));

	public static final RegistryObject<Block> CALCITE_BLOCK = IcariaBlocks.registerSimple("calcite_block", () -> new HalfTransparentBlock(IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.GLASS)));
	public static final RegistryObject<Block> HALITE_BLOCK = IcariaBlocks.registerSimple("halite_block", () -> new HalfTransparentBlock(IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_GREEN, SoundType.GLASS)));
	public static final RegistryObject<Block> JASPER_BLOCK = IcariaBlocks.registerSimple("jasper_block", () -> new HalfTransparentBlock(IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_RED, SoundType.GLASS)));
	public static final RegistryObject<Block> ZIRCON_BLOCK = IcariaBlocks.registerSimple("zircon_block", () -> new HalfTransparentBlock(IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_BLUE, SoundType.GLASS)));
	public static final RegistryObject<Block> CHERT_BLOCK = IcariaBlocks.registerSimple("chert_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_GRAY, SoundType.METAL)));
	public static final RegistryObject<Block> LIGNITE_BLOCK = IcariaBlocks.registerSimple("lignite_block", () -> new Block(IcariaBlocks.propertiesCoalBlock(MapColor.COLOR_BROWN, SoundType.STONE)));
	public static final RegistryObject<Block> CHALKOS_BLOCK = IcariaBlocks.registerSimple("chalkos_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_GREEN, SoundType.METAL)));
	public static final RegistryObject<Block> KASSITEROS_BLOCK = IcariaBlocks.registerSimple("kassiteros_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL)));
	public static final RegistryObject<Block> ORICHALCUM_BLOCK = IcariaBlocks.registerSimple("orichalcum_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL)));
	public static final RegistryObject<Block> VANADIUM_BLOCK = IcariaBlocks.registerSimple("vanadium_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL)));
	public static final RegistryObject<Block> VANADIUMSTEEL_BLOCK = IcariaBlocks.registerSimple("vanadiumsteel_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL)));
	public static final RegistryObject<Block> SIDEROS_BLOCK = IcariaBlocks.registerSimple("sideros_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL)));
	public static final RegistryObject<Block> ANTHRACITE_BLOCK = IcariaBlocks.registerSimple("anthracite_block", () -> new Block(IcariaBlocks.propertiesCoalBlock(MapColor.COLOR_BLACK, SoundType.STONE)));
	public static final RegistryObject<Block> MOLYBDENUM_BLOCK = IcariaBlocks.registerSimple("molybdenum_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL)));
	public static final RegistryObject<Block> MOLYBDENUMSTEEL_BLOCK = IcariaBlocks.registerSimple("molybdenumsteel_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL)));
	public static final RegistryObject<Block> BLURIDIUM_BLOCK = IcariaBlocks.registerSimple("bluridium_block", () -> new Block(IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL)));

	public static final RegistryObject<IronBarsBlock> VANADIUMSTEEL_BARS = IcariaBlocks.register("vanadiumsteel_bars", () -> new IronBarsBlock(IcariaBlocks.propertiesBars(MapColor.NONE, SoundType.METAL)));
	public static final RegistryObject<Block> HORIZONTAL_VANADIUMSTEEL_BARS = IcariaBlocks.register("horizontal_vanadiumsteel_bars", () -> new HorizontalPaneBlock(IcariaBlocks.propertiesBars(MapColor.NONE, SoundType.METAL)));

	public static final RegistryObject<Block> VANADIUMSTEEL_CHAIN = IcariaBlocks.register("vanadiumsteel_chain", () -> new IcariaChainBlock(IcariaBlocks.propertiesChain(MapColor.NONE, SoundType.CHAIN)));

	public static final RegistryObject<Block> KETTLE = IcariaBlocks.register("kettle", () -> new KettleBlock(IcariaBlocks.propertiesGrinder(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> GRINDER = IcariaBlocks.register("grinder", () -> new GrinderBlock(IcariaBlocks.propertiesGrinder(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> KILN = IcariaBlocks.register("kiln", () -> new KilnBlock(IcariaBlocks.propertiesKiln(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> FORGE = IcariaBlocks.register("forge", () -> new ForgeBlock(IcariaBlocks.propertiesGrinder(MapColor.WOOD, SoundType.STONE)));

	public static final RegistryObject<Block> CHEST = IcariaBlocks.register("chest", () -> new IcariaChestBlock(IcariaBlocks.propertiesChest(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaBlockEntityTypes.CHEST::get));
	public static final RegistryObject<Block> TRAPPED_CHEST = IcariaBlocks.register("trapped_chest", () -> new IcariaTrappedChestBlock(IcariaBlocks.propertiesChest(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaBlockEntityTypes.TRAPPED_CHEST::get));

	public static final RegistryObject<Block> BARREL = IcariaBlocks.register("barrel", () -> new BarrelBlock(IcariaBlocks.propertiesGrinder(MapColor.WOOD, SoundType.STONE)));
	public static final RegistryObject<Block> BARREL_RACK = IcariaBlocks.register("barrel_rack", () -> new BarrelRackBlock(IcariaBlocks.propertiesGrinder(MapColor.WOOD, SoundType.STONE)));

	public static final RegistryObject<Block> STORAGE_VASE = IcariaBlocks.register("storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.TERRACOTTA_PINK, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> WHITE_STORAGE_VASE = IcariaBlocks.register("white_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.SNOW, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> LIGHT_GRAY_STORAGE_VASE = IcariaBlocks.register("light_gray_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_GRAY, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> GRAY_STORAGE_VASE = IcariaBlocks.register("gray_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_GRAY, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> BLACK_STORAGE_VASE = IcariaBlocks.register("black_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BLACK, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> BROWN_STORAGE_VASE = IcariaBlocks.register("brown_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BROWN, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> RED_STORAGE_VASE = IcariaBlocks.register("red_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_RED, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> ORANGE_STORAGE_VASE = IcariaBlocks.register("orange_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_ORANGE, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> YELLOW_STORAGE_VASE = IcariaBlocks.register("yellow_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_YELLOW, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> LIME_STORAGE_VASE = IcariaBlocks.register("lime_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_GREEN, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> GREEN_STORAGE_VASE = IcariaBlocks.register("green_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_GREEN, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> CYAN_STORAGE_VASE = IcariaBlocks.register("cyan_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_CYAN, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> LIGHT_BLUE_STORAGE_VASE = IcariaBlocks.register("light_blue_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_BLUE, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> BLUE_STORAGE_VASE = IcariaBlocks.register("blue_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BLUE, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> PURPLE_STORAGE_VASE = IcariaBlocks.register("purple_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_PURPLE, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> MAGENTA_STORAGE_VASE = IcariaBlocks.register("magenta_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_MAGENTA, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> PINK_STORAGE_VASE = IcariaBlocks.register("pink_storage_vase", () -> new StorageVaseBlock(IcariaBlocks.propertiesStorageVase(MapColor.COLOR_PINK, IcariaSoundTypes.VASE)));

	public static final RegistryObject<Block> RED_LOOT_VASE = IcariaBlocks.register("red_loot_vase", () -> new LootVaseBlock(IcariaBlocks.propertiesLootVase(MapColor.COLOR_RED, IcariaSoundTypes.VASE)));
	public static final RegistryObject<Block> CYAN_LOOT_VASE = IcariaBlocks.register("cyan_loot_vase", () -> new LootVaseBlock(IcariaBlocks.propertiesLootVase(MapColor.COLOR_CYAN, IcariaSoundTypes.VASE)));

	public static final RegistryObject<Block> DUNGEON_SPAWNER = IcariaBlocks.register("dungeon_spawner", () -> new IcariaSpawnerBlock(IcariaBlocks.propertiesSpawner(MapColor.COLOR_GRAY, SoundType.METAL)));
	public static final RegistryObject<Block> MYRMEKE_SPAWNER = IcariaBlocks.register("myrmeke_spawner", () -> new IcariaSpawnerBlock(IcariaBlocks.propertiesSpawner(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<Block> RUIN_SPAWNER = IcariaBlocks.register("ruin_spawner", () -> new IcariaSpawnerBlock(IcariaBlocks.propertiesSpawner(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL)));
	public static final RegistryObject<Block> VILLAGE_SPAWNER = IcariaBlocks.register("village_spawner", () -> new IcariaSpawnerBlock(IcariaBlocks.propertiesSpawner(MapColor.COLOR_GREEN, SoundType.METAL)));

	public static final RegistryObject<Block> AETERNAE_SKULL = IcariaBlocks.register("aeternae_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.AETERNAE, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> AETERNAE_WALL_SKULL = IcariaBlocks.register("aeternae_wall_skull", () -> new IcariaWallSkullBlock(0.03F, IcariaSkullBlockTypes.AETERNAE, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> ARGAN_HOUND_SKULL = IcariaBlocks.register("argan_hound_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.ARGAN_HOUND, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> ARGAN_HOUND_WALL_SKULL = IcariaBlocks.register("argan_hound_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.ARGAN_HOUND, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CATOBLEPAS_SKULL = IcariaBlocks.register("catoblepas_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.CATOBLEPAS, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CATOBLEPAS_WALL_SKULL = IcariaBlocks.register("catoblepas_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.CATOBLEPAS, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CERVER_SKULL = IcariaBlocks.register("cerver_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.CERVER, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CERVER_WALL_SKULL = IcariaBlocks.register("cerver_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.CERVER, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CYPRESS_FOREST_HAG_SKULL = IcariaBlocks.register("cypress_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CYPRESS_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("cypress_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> DROUGHTROOT_FOREST_HAG_SKULL = IcariaBlocks.register("droughtroot_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> DROUGHTROOT_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("droughtroot_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> FIR_FOREST_HAG_SKULL = IcariaBlocks.register("fir_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.FIR_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> FIR_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("fir_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.FIR_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> LAUREL_FOREST_HAG_SKULL = IcariaBlocks.register("laurel_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.LAUREL_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> LAUREL_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("laurel_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.LAUREL_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> OLIVE_FOREST_HAG_SKULL = IcariaBlocks.register("olive_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.OLIVE_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> OLIVE_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("olive_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.OLIVE_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PLANE_FOREST_HAG_SKULL = IcariaBlocks.register("plane_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.PLANE_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PLANE_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("plane_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.PLANE_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> POPULUS_FOREST_HAG_SKULL = IcariaBlocks.register("populus_forest_hag_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.POPULUS_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> POPULUS_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("populus_forest_hag_wall_skull", () -> new IcariaWallSkullBlock(0.06F, IcariaSkullBlockTypes.POPULUS_FOREST_HAG, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> REVENANT_SKULL = IcariaBlocks.register("revenant_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.REVENANT, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> REVENANT_WALL_SKULL = IcariaBlocks.register("revenant_wall_skull", () -> new IcariaWallSkullBlock(0.0F, IcariaSkullBlockTypes.REVENANT, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> SOW_SKULL = IcariaBlocks.register("sow_skull", () -> new IcariaSkullBlock(0.0F, IcariaSkullBlockTypes.SOW, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> SOW_WALL_SKULL = IcariaBlocks.register("sow_wall_skull", () -> new IcariaWallSkullBlock(0.0F, IcariaSkullBlockTypes.SOW, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> LIGNITE_TORCH = IcariaBlocks.register("lignite_torch", () -> new TorchBlock(IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel((pBlockState) -> 10), ParticleTypes.FLAME));
	public static final RegistryObject<Block> LIGNITE_WALL_TORCH = IcariaBlocks.register("lignite_wall_torch", () -> new WallTorchBlock(IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel((pBlockState) -> 10), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_TORCH = IcariaBlocks.register("anthracite_torch", () -> new TorchBlock(IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel((pBlockState) -> 14), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ANTHRACITE_WALL_TORCH = IcariaBlocks.register("anthracite_wall_torch", () -> new WallTorchBlock(IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel((pBlockState) -> 14), ParticleTypes.FLAME));

	public static final RegistryObject<Block> LAUREL_CHERRY_CAKE = IcariaBlocks.register("laurel_cherry_cake", () -> new IcariaCakeBlock(IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL)));
	public static final RegistryObject<Block> STRAWBERRY_CAKE = IcariaBlocks.register("strawberry_cake", () -> new IcariaCakeBlock(IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL)));
	public static final RegistryObject<Block> PHYSALIS_CAKE = IcariaBlocks.register("physalis_cake", () -> new IcariaCakeBlock(IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL)));
	public static final RegistryObject<Block> VINE_BERRY_CAKE = IcariaBlocks.register("vine_berry_cake", () -> new IcariaCakeBlock(IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL)));
	public static final RegistryObject<Block> VINE_SPROUT_CAKE = IcariaBlocks.register("vine_sprout_cake", () -> new IcariaCakeBlock(IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL)));

	public static final RegistryObject<Block> CYPRESS_SAPLING = IcariaBlocks.register("cypress_sapling", () -> new SaplingBlock(new CypressTreeGrower(), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = IcariaBlocks.register("potted_cypress_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CYPRESS_SAPLING, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CYPRESS_LEAVES = IcariaBlocks.register("cypress_leaves", () -> new IcariaLeavesBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> FALLEN_CYPRESS_LEAVES = IcariaBlocks.register("fallen_cypress_leaves", () -> new LayerBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> CYPRESS_TWIGS = IcariaBlocks.register("cypress_twigs", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> CYPRESS_WOOD = IcariaBlocks.register("cypress_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CYPRESS_WOOD = IcariaBlocks.register("stripped_cypress_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> CYPRESS_LOG = IcariaBlocks.register("cypress_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CYPRESS_LOG = IcariaBlocks.register("stripped_cypress_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> DEAD_CYPRESS_LOG = IcariaBlocks.register("dead_cypress_log", () -> new DeadLogBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_CYPRESS_LOG = IcariaBlocks.register("stripped_dead_cypress_log", () -> new DeadLogBlock((IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD))));
	public static final RegistryObject<Block> CYPRESS_PLANKS = IcariaBlocks.registerSimple("cypress_planks", () -> new Block(IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final IcariaWoodDecoBlocks CYPRESS_DECO = new IcariaWoodDecoBlocks("cypress", IcariaBlocks.CYPRESS_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final RegistryObject<Block> CYPRESS_CRAFTING_TABLE = IcariaBlocks.register("cypress_crafting_table", () -> new IcariaCraftingTableBlock(IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> CYPRESS_DOOR = IcariaBlocks.register("cypress_door", ()-> new DoorBlock(IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), IcariaBlockSetTypes.CYPRESS));
	public static final RegistryObject<TrapDoorBlock> CYPRESS_TRAPDOOR = IcariaBlocks.register("cypress_trapdoor", ()-> new TrapDoorBlock(IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaBlockSetTypes.CYPRESS));
	public static final RegistryObject<Block> CYPRESS_LADDER = IcariaBlocks.register("cypress_ladder", () -> new LadderBlock(IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER)));
	public static final RegistryObject<Block> CYPRESS_SIGN = IcariaBlocks.register("cypress_sign", () -> new IcariaStandingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.CYPRESS));
	public static final RegistryObject<Block> CYPRESS_WALL_SIGN = IcariaBlocks.register("cypress_wall_sign", () -> new IcariaWallSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.CYPRESS));
	public static final RegistryObject<Block> CYPRESS_HANGING_SIGN = IcariaBlocks.register("cypress_hanging_sign", () -> new IcariaCeilingHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.CYPRESS));
	public static final RegistryObject<Block> CYPRESS_WALL_HANGING_SIGN = IcariaBlocks.register("cypress_wall_hanging_sign", () -> new IcariaWallHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.CYPRESS));

	public static final RegistryObject<Block> DROUGHTROOT_SAPLING = IcariaBlocks.register("droughtroot_sapling", () -> new SaplingBlock(new DroughtrootTreeGrower(), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_DROUGHTROOT_SAPLING = IcariaBlocks.register("potted_droughtroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.DROUGHTROOT_SAPLING, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> DROUGHTROOT_LEAVES = IcariaBlocks.register("droughtroot_leaves", () -> new IcariaLeavesBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> FALLEN_DROUGHTROOT_LEAVES = IcariaBlocks.register("fallen_droughtroot_leaves", () -> new LayerBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> DROUGHTROOT_TWIGS = IcariaBlocks.register("droughtroot_twigs", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> DROUGHTROOT_WOOD = IcariaBlocks.register("droughtroot_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_DROUGHTROOT_WOOD = IcariaBlocks.register("stripped_droughtroot_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> DROUGHTROOT_LOG = IcariaBlocks.register("droughtroot_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_DROUGHTROOT_LOG = IcariaBlocks.register("stripped_droughtroot_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> DEAD_DROUGHTROOT_LOG = IcariaBlocks.register("dead_droughtroot_log", () -> new DeadLogBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_DROUGHTROOT_LOG = IcariaBlocks.register("stripped_dead_droughtroot_log", () -> new DeadLogBlock((IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD))));
	public static final RegistryObject<Block> DROUGHTROOT_PLANKS = IcariaBlocks.registerSimple("droughtroot_planks", () -> new Block(IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final IcariaWoodDecoBlocks DROUGHTROOT_DECO = new IcariaWoodDecoBlocks("droughtroot", IcariaBlocks.DROUGHTROOT_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final RegistryObject<Block> DROUGHTROOT_CRAFTING_TABLE = IcariaBlocks.register("droughtroot_crafting_table", () -> new IcariaCraftingTableBlock(IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> DROUGHTROOT_DOOR = IcariaBlocks.register("droughtroot_door", ()-> new DoorBlock(IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), IcariaBlockSetTypes.DROUGHTROOT));
	public static final RegistryObject<TrapDoorBlock> DROUGHTROOT_TRAPDOOR = IcariaBlocks.register("droughtroot_trapdoor", ()-> new TrapDoorBlock(IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaBlockSetTypes.DROUGHTROOT));
	public static final RegistryObject<Block> DROUGHTROOT_LADDER = IcariaBlocks.register("droughtroot_ladder", () -> new LadderBlock(IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER)));
	public static final RegistryObject<Block> DROUGHTROOT_SIGN = IcariaBlocks.register("droughtroot_sign", () -> new IcariaStandingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.DROUGHTROOT));
	public static final RegistryObject<Block> DROUGHTROOT_WALL_SIGN = IcariaBlocks.register("droughtroot_wall_sign", () -> new IcariaWallSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.DROUGHTROOT));
	public static final RegistryObject<Block> DROUGHTROOT_HANGING_SIGN = IcariaBlocks.register("droughtroot_hanging_sign", () -> new IcariaCeilingHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.DROUGHTROOT));
	public static final RegistryObject<Block> DROUGHTROOT_WALL_HANGING_SIGN = IcariaBlocks.register("droughtroot_wall_hanging_sign", () -> new IcariaWallHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.DROUGHTROOT));

	public static final RegistryObject<Block> FIR_SAPLING = IcariaBlocks.register("fir_sapling", () -> new SaplingBlock(new FirTreeGrower(), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_FIR_SAPLING = IcariaBlocks.register("potted_fir_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FIR_SAPLING, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> FIR_LEAVES = IcariaBlocks.register("fir_leaves", () -> new IcariaLeavesBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> FALLEN_FIR_LEAVES = IcariaBlocks.register("fallen_fir_leaves", () -> new LayerBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> FIR_TWIGS = IcariaBlocks.register("fir_twigs", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> FIR_WOOD = IcariaBlocks.register("fir_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_FIR_WOOD = IcariaBlocks.register("stripped_fir_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> FIR_LOG = IcariaBlocks.register("fir_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_FIR_LOG = IcariaBlocks.register("stripped_fir_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> DEAD_FIR_LOG = IcariaBlocks.register("dead_fir_log", () -> new DeadLogBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_FIR_LOG = IcariaBlocks.register("stripped_dead_fir_log", () -> new DeadLogBlock((IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD))));
	public static final RegistryObject<Block> FIR_PLANKS = IcariaBlocks.registerSimple("fir_planks", () -> new Block(IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final IcariaWoodDecoBlocks FIR_DECO = new IcariaWoodDecoBlocks("fir", IcariaBlocks.FIR_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final RegistryObject<Block> FIR_CRAFTING_TABLE = IcariaBlocks.register("fir_crafting_table", () -> new IcariaCraftingTableBlock(IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> FIR_DOOR = IcariaBlocks.register("fir_door", ()-> new DoorBlock(IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), IcariaBlockSetTypes.FIR));
	public static final RegistryObject<TrapDoorBlock> FIR_TRAPDOOR = IcariaBlocks.register("fir_trapdoor", ()-> new TrapDoorBlock(IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaBlockSetTypes.FIR));
	public static final RegistryObject<Block> FIR_LADDER = IcariaBlocks.register("fir_ladder", () -> new LadderBlock(IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER)));
	public static final RegistryObject<Block> FIR_SIGN = IcariaBlocks.register("fir_sign", () -> new IcariaStandingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.FIR));
	public static final RegistryObject<Block> FIR_WALL_SIGN = IcariaBlocks.register("fir_wall_sign", () -> new IcariaWallSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.FIR));
	public static final RegistryObject<Block> FIR_HANGING_SIGN = IcariaBlocks.register("fir_hanging_sign", () -> new IcariaCeilingHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.FIR));
	public static final RegistryObject<Block> FIR_WALL_HANGING_SIGN = IcariaBlocks.register("fir_wall_hanging_sign", () -> new IcariaWallHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.FIR));

	public static final RegistryObject<Block> LAUREL_SAPLING = IcariaBlocks.register("laurel_sapling", () -> new SaplingBlock(new LaurelTreeGrower(), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_LAUREL_SAPLING = IcariaBlocks.register("potted_laurel_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LAUREL_SAPLING, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> LAUREL_LEAVES = IcariaBlocks.register("laurel_leaves", () -> new IcariaLeavesBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> FALLEN_LAUREL_LEAVES = IcariaBlocks.register("fallen_laurel_leaves", () -> new LayerBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> LAUREL_TWIGS = IcariaBlocks.register("laurel_twigs", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> LAUREL_WOOD = IcariaBlocks.register("laurel_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_LAUREL_WOOD = IcariaBlocks.register("stripped_laurel_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> LAUREL_LOG = IcariaBlocks.register("laurel_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_LAUREL_LOG = IcariaBlocks.register("stripped_laurel_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> DEAD_LAUREL_LOG = IcariaBlocks.register("dead_laurel_log", () -> new DeadLogBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_LAUREL_LOG = IcariaBlocks.register("stripped_dead_laurel_log", () -> new DeadLogBlock((IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD))));
	public static final RegistryObject<Block> LAUREL_PLANKS = IcariaBlocks.registerSimple("laurel_planks", () -> new Block(IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final IcariaWoodDecoBlocks LAUREL_DECO = new IcariaWoodDecoBlocks("laurel", IcariaBlocks.LAUREL_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final RegistryObject<Block> LAUREL_CRAFTING_TABLE = IcariaBlocks.register("laurel_crafting_table", () -> new IcariaCraftingTableBlock(IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> LAUREL_DOOR = IcariaBlocks.register("laurel_door", ()-> new DoorBlock(IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), IcariaBlockSetTypes.LAUREL));
	public static final RegistryObject<TrapDoorBlock> LAUREL_TRAPDOOR = IcariaBlocks.register("laurel_trapdoor", ()-> new TrapDoorBlock(IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaBlockSetTypes.LAUREL));
	public static final RegistryObject<Block> LAUREL_LADDER = IcariaBlocks.register("laurel_ladder", () -> new LadderBlock(IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER)));
	public static final RegistryObject<Block> LAUREL_SIGN = IcariaBlocks.register("laurel_sign", () -> new IcariaStandingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.LAUREL));
	public static final RegistryObject<Block> LAUREL_WALL_SIGN = IcariaBlocks.register("laurel_wall_sign", () -> new IcariaWallSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.LAUREL));
	public static final RegistryObject<Block> LAUREL_HANGING_SIGN = IcariaBlocks.register("laurel_hanging_sign", () -> new IcariaCeilingHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.LAUREL));
	public static final RegistryObject<Block> LAUREL_WALL_HANGING_SIGN = IcariaBlocks.register("laurel_wall_hanging_sign", () -> new IcariaWallHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.LAUREL));

	public static final RegistryObject<Block> OLIVE_SAPLING = IcariaBlocks.register("olive_sapling", () -> new SaplingBlock(new OliveTreeGrower(), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_OLIVE_SAPLING = IcariaBlocks.register("potted_olive_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.OLIVE_SAPLING, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> OLIVE_LEAVES = IcariaBlocks.register("olive_leaves", () -> new OliveLeavesBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_YELLOW, SoundType.GRASS)));
	public static final RegistryObject<Block> FALLEN_OLIVE_LEAVES = IcariaBlocks.register("fallen_olive_leaves", () -> new LayerBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_YELLOW, SoundType.GRASS)));
	public static final RegistryObject<Block> OLIVE_TWIGS = IcariaBlocks.register("olive_twigs", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> OLIVE_WOOD = IcariaBlocks.register("olive_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_OLIVE_WOOD = IcariaBlocks.register("stripped_olive_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> OLIVE_LOG = IcariaBlocks.register("olive_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_OLIVE_LOG = IcariaBlocks.register("stripped_olive_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> DEAD_OLIVE_LOG = IcariaBlocks.register("dead_olive_log", () -> new DeadLogBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_OLIVE_LOG = IcariaBlocks.register("stripped_dead_olive_log", () -> new DeadLogBlock((IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD))));
	public static final RegistryObject<Block> OLIVE_PLANKS = IcariaBlocks.registerSimple("olive_planks", () -> new Block(IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final IcariaWoodDecoBlocks OLIVE_DECO = new IcariaWoodDecoBlocks("olive", IcariaBlocks.OLIVE_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final RegistryObject<Block> OLIVE_CRAFTING_TABLE = IcariaBlocks.register("olive_crafting_table", () -> new IcariaCraftingTableBlock(IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> OLIVE_DOOR = IcariaBlocks.register("olive_door", ()-> new DoorBlock(IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), IcariaBlockSetTypes.OLIVE));
	public static final RegistryObject<TrapDoorBlock> OLIVE_TRAPDOOR = IcariaBlocks.register("olive_trapdoor", ()-> new TrapDoorBlock(IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaBlockSetTypes.OLIVE));
	public static final RegistryObject<Block> OLIVE_LADDER = IcariaBlocks.register("olive_ladder", () -> new LadderBlock(IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER)));
	public static final RegistryObject<Block> OLIVE_SIGN = IcariaBlocks.register("olive_sign", () -> new IcariaStandingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.OLIVE));
	public static final RegistryObject<Block> OLIVE_WALL_SIGN = IcariaBlocks.register("olive_wall_sign", () -> new IcariaWallSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.OLIVE));
	public static final RegistryObject<Block> OLIVE_HANGING_SIGN = IcariaBlocks.register("olive_hanging_sign", () -> new IcariaCeilingHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.OLIVE));
	public static final RegistryObject<Block> OLIVE_WALL_HANGING_SIGN = IcariaBlocks.register("olive_wall_hanging_sign", () -> new IcariaWallHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.OLIVE));

	public static final RegistryObject<Block> PLANE_SAPLING = IcariaBlocks.register("plane_sapling", () -> new SaplingBlock(new PlaneTreeGrower(), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PLANE_SAPLING = IcariaBlocks.register("potted_plane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PLANE_SAPLING, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PLANE_LEAVES = IcariaBlocks.register("plane_leaves", () -> new IcariaLeavesBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> FALLEN_PLANE_LEAVES = IcariaBlocks.register("fallen_plane_leaves", () -> new LayerBlock(IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS)));
	public static final RegistryObject<Block> PLANE_TWIGS = IcariaBlocks.register("plane_twigs", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> PLANE_WOOD = IcariaBlocks.register("plane_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PLANE_WOOD = IcariaBlocks.register("stripped_plane_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> PLANE_LOG = IcariaBlocks.register("plane_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PLANE_LOG = IcariaBlocks.register("stripped_plane_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> DEAD_PLANE_LOG = IcariaBlocks.register("dead_plane_log", () -> new DeadLogBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_PLANE_LOG = IcariaBlocks.register("stripped_dead_plane_log", () -> new DeadLogBlock((IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD))));
	public static final RegistryObject<Block> PLANE_PLANKS = IcariaBlocks.registerSimple("plane_planks", () -> new Block(IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final IcariaWoodDecoBlocks PLANE_DECO = new IcariaWoodDecoBlocks("plane", IcariaBlocks.PLANE_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final RegistryObject<Block> PLANE_CRAFTING_TABLE = IcariaBlocks.register("plane_crafting_table", () -> new IcariaCraftingTableBlock(IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> PLANE_DOOR = IcariaBlocks.register("plane_door", ()-> new DoorBlock(IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), IcariaBlockSetTypes.PLANE));
	public static final RegistryObject<TrapDoorBlock> PLANE_TRAPDOOR = IcariaBlocks.register("plane_trapdoor", ()-> new TrapDoorBlock(IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaBlockSetTypes.PLANE));
	public static final RegistryObject<Block> PLANE_LADDER = IcariaBlocks.register("plane_ladder", () -> new LadderBlock(IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER)));
	public static final RegistryObject<Block> PLANE_SIGN = IcariaBlocks.register("plane_sign", () -> new IcariaStandingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.PLANE));
	public static final RegistryObject<Block> PLANE_WALL_SIGN = IcariaBlocks.register("plane_wall_sign", () -> new IcariaWallSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.PLANE));
	public static final RegistryObject<Block> PLANE_HANGING_SIGN = IcariaBlocks.register("plane_hanging_sign", () -> new IcariaCeilingHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.PLANE));
	public static final RegistryObject<Block> PLANE_WALL_HANGING_SIGN = IcariaBlocks.register("plane_wall_hanging_sign", () -> new IcariaWallHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.PLANE));

	public static final RegistryObject<Block> POPULUS_SAPLING = IcariaBlocks.register("populus_sapling", () -> new SaplingBlock(new PopulusTreeGrower(), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_POPULUS_SAPLING = IcariaBlocks.register("potted_populus_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.POPULUS_SAPLING, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> POPULUS_LEAVES = IcariaBlocks.register("populus_leaves", () -> new IcariaLeavesBlock(IcariaBlocks.propertiesLeaves(MapColor.GLOW_LICHEN, SoundType.GRASS)));
	public static final RegistryObject<Block> FALLEN_POPULUS_LEAVES = IcariaBlocks.register("fallen_populus_leaves", () -> new LayerBlock(IcariaBlocks.propertiesLeaves(MapColor.GLOW_LICHEN, SoundType.GRASS)));
	public static final RegistryObject<Block> POPULUS_TWIGS = IcariaBlocks.register("populus_twigs", () -> new GroundDecoBlock(IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> POPULUS_WOOD = IcariaBlocks.register("populus_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_POPULUS_WOOD = IcariaBlocks.register("stripped_populus_wood", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> POPULUS_LOG = IcariaBlocks.register("populus_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_POPULUS_LOG = IcariaBlocks.register("stripped_populus_log", () -> new RotatedPillarBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> DEAD_POPULUS_LOG = IcariaBlocks.register("dead_populus_log", () -> new DeadLogBlock(IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD)));
	public static final RegistryObject<DeadLogBlock> STRIPPED_DEAD_POPULUS_LOG = IcariaBlocks.register("stripped_dead_populus_log", () -> new DeadLogBlock((IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD))));
	public static final RegistryObject<Block> POPULUS_PLANKS = IcariaBlocks.registerSimple("populus_planks", () -> new Block(IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD)));
	public static final IcariaWoodDecoBlocks POPULUS_DECO = new IcariaWoodDecoBlocks("populus", IcariaBlocks.POPULUS_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final RegistryObject<Block> POPULUS_CRAFTING_TABLE = IcariaBlocks.register("populus_crafting_table", () -> new IcariaCraftingTableBlock(IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_GREEN, SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> POPULUS_DOOR = IcariaBlocks.register("populus_door", ()-> new DoorBlock(IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), IcariaBlockSetTypes.POPULUS));
	public static final RegistryObject<TrapDoorBlock> POPULUS_TRAPDOOR = IcariaBlocks.register("populus_trapdoor", ()-> new TrapDoorBlock(IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_YELLOW, SoundType.WOOD), IcariaBlockSetTypes.POPULUS));
	public static final RegistryObject<Block> POPULUS_LADDER = IcariaBlocks.register("populus_ladder", () -> new LadderBlock(IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER)));
	public static final RegistryObject<Block> POPULUS_SIGN = IcariaBlocks.register("populus_sign", () -> new IcariaStandingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.POPULUS));
	public static final RegistryObject<Block> POPULUS_WALL_SIGN = IcariaBlocks.register("populus_wall_sign", () -> new IcariaWallSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.POPULUS));
	public static final RegistryObject<Block> POPULUS_HANGING_SIGN = IcariaBlocks.register("populus_hanging_sign", () -> new IcariaCeilingHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.POPULUS));
	public static final RegistryObject<Block> POPULUS_WALL_HANGING_SIGN = IcariaBlocks.register("populus_wall_hanging_sign", () -> new IcariaWallHangingSignBlock(IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), IcariaWoodTypes.POPULUS));

	public static final RegistryObject<Block> DEAD_BLOOMY_VINE = IcariaBlocks.register("dead_bloomy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> GROWING_BLOOMY_VINE = IcariaBlocks.register("growing_bloomy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> RIPE_BLOOMY_VINE = IcariaBlocks.register("ripe_bloomy_vine", () -> new IcariaVineBaseBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_BLOOMY_VINE.get(), IcariaBlocks.DEAD_BLOOMY_VINE.get()));
	public static final RegistryObject<Block> BLOOMING_BLOOMY_VINE = IcariaBlocks.register("blooming_bloomy_vine", () -> new IcariaVineStagedBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_BLOOMY_VINE.get(), IcariaBlocks.RIPE_BLOOMY_VINE.get(), IcariaBlocks.DEAD_BLOOMY_VINE.get()));
	public static final RegistryObject<Block> BLOOMY_VINE = IcariaBlocks.register("bloomy_vine", () -> new IcariaVineStagedBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_BLOOMY_VINE.get(), IcariaBlocks.BLOOMING_BLOOMY_VINE.get(), IcariaBlocks.DEAD_BLOOMY_VINE.get()));

	public static final RegistryObject<Block> DEAD_BRANCHY_VINE = IcariaBlocks.register("dead_branchy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> GROWING_BRANCHY_VINE = IcariaBlocks.register("growing_branchy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> BRANCHY_VINE = IcariaBlocks.register("branchy_vine", () -> new IcariaVineBaseBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_BRANCHY_VINE.get(), IcariaBlocks.DEAD_BRANCHY_VINE.get()));

	public static final RegistryObject<Block> DEAD_BRUSHY_VINE = IcariaBlocks.register("dead_brushy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> GROWING_BRUSHY_VINE = IcariaBlocks.register("growing_brushy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> RIPE_BRUSHY_VINE = IcariaBlocks.register("ripe_brushy_vine", () -> new IcariaVineBaseBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_BRUSHY_VINE.get(), IcariaBlocks.DEAD_BRUSHY_VINE.get()));
	public static final RegistryObject<Block> BRUSHY_VINE = IcariaBlocks.register("brushy_vine", () -> new IcariaVineStagedBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_BRUSHY_VINE.get(), IcariaBlocks.RIPE_BRUSHY_VINE.get(), IcariaBlocks.DEAD_BRUSHY_VINE.get()));

	public static final RegistryObject<Block> DEAD_DRY_VINE = IcariaBlocks.register("dead_dry_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> GROWING_DRY_VINE = IcariaBlocks.register("growing_dry_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> DRY_VINE = IcariaBlocks.register("dry_vine", () -> new IcariaVineBaseBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_DRY_VINE.get(), IcariaBlocks.DEAD_DRY_VINE.get()));

	public static final RegistryObject<Block> DEAD_REEDY_VINE = IcariaBlocks.register("dead_reedy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> GROWING_REEDY_VINE = IcariaBlocks.register("growing_reedy_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> REEDY_VINE = IcariaBlocks.register("reedy_vine", () -> new IcariaVineBaseBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_REEDY_VINE.get(), IcariaBlocks.DEAD_REEDY_VINE.get()));

	public static final RegistryObject<Block> DEAD_SWIRLY_VINE = IcariaBlocks.register("dead_swirly_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> GROWING_SWIRLY_VINE = IcariaBlocks.register("growing_swirly_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> SWIRLY_VINE = IcariaBlocks.register("swirly_vine", () -> new IcariaVineBaseBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_SWIRLY_VINE.get(), IcariaBlocks.DEAD_SWIRLY_VINE.get()));

	public static final RegistryObject<Block> DEAD_THORNY_VINE = IcariaBlocks.register("dead_thorny_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> GROWING_THORNY_VINE = IcariaBlocks.register("growing_thorny_vine", () -> new IcariaVineTailBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE)));
	public static final RegistryObject<Block> THORNY_VINE = IcariaBlocks.register("thorny_vine", () -> new IcariaVineBaseBlock(IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE).randomTicks(), IcariaBlocks.GROWING_THORNY_VINE.get(), IcariaBlocks.DEAD_THORNY_VINE.get()));

	public static final RegistryObject<Block> FERN = IcariaBlocks.register("fern", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_FERN = IcariaBlocks.register("potted_fern", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FERN, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> SMALL_GRASS = IcariaBlocks.register("small_grass", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> MEDIUM_GRASS = IcariaBlocks.register("medium_grass", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> LARGE_GRASS = IcariaBlocks.register("large_grass", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));

	public static final RegistryObject<Block> SMALL_MIXED_GRAIN = IcariaBlocks.register("small_mixed_grain", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> MEDIUM_MIXED_GRAIN = IcariaBlocks.register("medium_mixed_grain", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> MEDIUM_BROWN_GRAIN = IcariaBlocks.register("medium_brown_grain", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> MEDIUM_WHITE_GRAIN = IcariaBlocks.register("medium_white_grain", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> MEDIUM_YELLOW_GRAIN = IcariaBlocks.register("medium_yellow_grain", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> LARGE_BROWN_GRAIN = IcariaBlocks.register("large_brown_grain", () -> new IcariaBushBlock(IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS)));

	public static final RegistryObject<Block> BLINDWEED = IcariaBlocks.register("blindweed", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_BLINDWEED = IcariaBlocks.register("potted_blindweed", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLINDWEED, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CHAMEOMILE = IcariaBlocks.register("chameomile", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_CHAMEOMILE = IcariaBlocks.register("potted_chameomile", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CHAMEOMILE, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CHARMONDER = IcariaBlocks.register("charmonder", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_CHARMONDER = IcariaBlocks.register("potted_charmonder", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CHARMONDER, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> CLOVER = IcariaBlocks.register("clover", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_CLOVER = IcariaBlocks.register("potted_clover", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CLOVER, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> FIREHILT = IcariaBlocks.register("firehilt", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_FIREHILT = IcariaBlocks.register("potted_firehilt", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FIREHILT, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> BLUE_HYDRACINTH = IcariaBlocks.register("blue_hydracinth", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_BLUE_HYDRACINTH = IcariaBlocks.register("potted_blue_hydracinth", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLUE_HYDRACINTH, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PURPLE_HYDRACINTH = IcariaBlocks.register("purple_hydracinth", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PURPLE_HYDRACINTH = IcariaBlocks.register("potted_purple_hydracinth", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_HYDRACINTH, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> LIONFANGS = IcariaBlocks.register("lionfangs", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_LIONFANGS = IcariaBlocks.register("potted_lionfangs", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LIONFANGS, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> SPEARDROPS = IcariaBlocks.register("speardrops", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_SPEARDROPS = IcariaBlocks.register("potted_speardrops", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SPEARDROPS, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PURPLE_STAGHORN = IcariaBlocks.register("purple_staghorn", () -> new DamagingBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PURPLE_STAGHORN = IcariaBlocks.register("potted_purple_staghorn", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_STAGHORN, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> YELLOW_STAGHORN = IcariaBlocks.register("yellow_staghorn", () -> new DamagingBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_YELLOW_STAGHORN = IcariaBlocks.register("potted_yellow_staghorn", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.YELLOW_STAGHORN, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> BLUE_STORMCOTTON = IcariaBlocks.register("blue_stormcotton", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_BLUE_STORMCOTTON = IcariaBlocks.register("potted_blue_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLUE_STORMCOTTON, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PINK_STORMCOTTON = IcariaBlocks.register("pink_stormcotton", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PINK_STORMCOTTON = IcariaBlocks.register("potted_pink_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PINK_STORMCOTTON, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PURPLE_STORMCOTTON = IcariaBlocks.register("purple_stormcotton", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PURPLE_STORMCOTTON = IcariaBlocks.register("potted_purple_stormcotton", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_STORMCOTTON, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> SUNKETTLE = IcariaBlocks.register("sunkettle", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_SUNKETTLE = IcariaBlocks.register("potted_sunkettle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SUNKETTLE, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> SUNSPONGE = IcariaBlocks.register("sunsponge", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_SUNSPONGE = IcariaBlocks.register("potted_sunsponge", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SUNSPONGE, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> VOIDLILY = IcariaBlocks.register("voidlily", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_VOIDLILY = IcariaBlocks.register("potted_voidlily", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.VOIDLILY, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> BOLBOS = IcariaBlocks.register("bolbos", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> DATHULLA = IcariaBlocks.register("dathulla", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> MONDANOS = IcariaBlocks.register("mondanos", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> MOTH_AGARIC = IcariaBlocks.register("moth_agaric", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> NAMDRAKE = IcariaBlocks.register("namdrake", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> PSILOCYBOS = IcariaBlocks.register("psilocybos", () -> new WaterloggedBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> ROWAN = IcariaBlocks.register("rowan", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> WILTED_ELM = IcariaBlocks.register("wilted_elm", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));

	public static final RegistryObject<Block> BLUE_GROUND_FLOWERS = IcariaBlocks.register("blue_ground_flowers", () -> new GroundFlowerBlock(IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> CYAN_GROUND_FLOWERS = IcariaBlocks.register("cyan_ground_flowers", () -> new GroundFlowerBlock(IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> PINK_GROUND_FLOWERS = IcariaBlocks.register("pink_ground_flowers", () -> new GroundFlowerBlock(IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> PURPLE_GROUND_FLOWERS = IcariaBlocks.register("purple_ground_flowers", () -> new GroundFlowerBlock(IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> RED_GROUND_FLOWERS = IcariaBlocks.register("red_ground_flowers", () -> new GroundFlowerBlock(IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> WHITE_GROUND_FLOWERS = IcariaBlocks.register("white_ground_flowers", () -> new GroundFlowerBlock(IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.GRASS)));

	public static final RegistryObject<Block> FOREST_MOSS = IcariaBlocks.register("forest_moss", () -> new LayerBlock(IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS)));
	public static final RegistryObject<Block> SCRUBLAND_MOSS = IcariaBlocks.register("scrubland_moss", () -> new LayerBlock(IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS)));
	public static final RegistryObject<Block> STEPPE_MOSS = IcariaBlocks.register("steppe_moss", () -> new LayerBlock(IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS)));

	public static final RegistryObject<Block> PALM_FERN = IcariaBlocks.register("palm_fern", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PALM_FERN = IcariaBlocks.register("potted_palm_fern", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PALM_FERN, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> WHITE_BROMELIA = IcariaBlocks.register("white_bromelia", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_WHITE_BROMELIA = IcariaBlocks.register("potted_white_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.WHITE_BROMELIA, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> ORANGE_BROMELIA = IcariaBlocks.register("orange_bromelia", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_ORANGE_BROMELIA = IcariaBlocks.register("potted_orange_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.ORANGE_BROMELIA, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PINK_BROMELIA = IcariaBlocks.register("pink_bromelia", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PINK_BROMELIA = IcariaBlocks.register("potted_pink_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PINK_BROMELIA, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> PURPLE_BROMELIA = IcariaBlocks.register("purple_bromelia", () -> new IcariaBushBlock(IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_PURPLE_BROMELIA = IcariaBlocks.register("potted_purple_bromelia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_BROMELIA, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> GREEN_GROUND_SHROOMS = IcariaBlocks.register("green_ground_shrooms", () -> new GroundShroomBlock(IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_GREEN_GROUND_SHROOMS = IcariaBlocks.register("potted_green_ground_shrooms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.GREEN_GROUND_SHROOMS, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> BROWN_GROUND_SHROOMS = IcariaBlocks.register("brown_ground_shrooms", () -> new GroundShroomBlock(IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_BROWN_GROUND_SHROOMS = IcariaBlocks.register("potted_brown_ground_shrooms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BROWN_GROUND_SHROOMS, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));
	public static final RegistryObject<Block> LARGE_BROWN_GROUND_SHROOMS = IcariaBlocks.register("large_brown_ground_shrooms", () -> new GroundShroomBlock(IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_LARGE_BROWN_GROUND_SHROOMS = IcariaBlocks.register("potted_large_brown_ground_shrooms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> TINDER_FUNGUS_TREE_SHROOMS = IcariaBlocks.register("tinder_fungus_tree_shrooms", () -> new TreeShroomBlock(IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> TURKEY_TAIL_TREE_SHROOMS = IcariaBlocks.register("turkey_tail_tree_shrooms", () -> new TreeShroomBlock(IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS)));
	public static final RegistryObject<Block> UNNAMED_TREE_SHROOMS = IcariaBlocks.register("unnamed_tree_shrooms", () -> new TreeShroomBlock(IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS)));

	public static final RegistryObject<Block> CARDON_CACTUS = IcariaBlocks.register("cardon_cactus", () -> new CardonCactusBlock(IcariaBlocks.propertiesCactus(MapColor.GRASS, SoundType.WOOL)));
	public static final RegistryObject<Block> POTTED_CARDON_CACTUS = IcariaBlocks.register("potted_cardon_cactus", () -> new DamagingFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CARDON_CACTUS, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE)));

	public static final RegistryObject<Block> STRAWBERRY_BUSH = IcariaBlocks.register("strawberry_bush", () -> new StrawberryBushBlock(IcariaBlocks.propertiesBush(MapColor.NONE, SoundType.GRASS)));

	public static final RegistryObject<Block> SPELT_CROP = IcariaBlocks.register("spelt_crop", () -> new SpeltCropBlock(IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP)));
	public static final RegistryObject<Block> STRAWBERRY_CROP = IcariaBlocks.register("strawberry_crop", () -> new StrawberryCropBlock(IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP)));
	public static final RegistryObject<Block> PHYSALIS_CROP = IcariaBlocks.register("physalis_crop", () -> new PhysalisCropBlock(IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP)));
	public static final RegistryObject<Block> ONION_CROP = IcariaBlocks.register("onion_crop", () -> new OnionCropBlock(IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP)));

	public static final RegistryObject<LiquidBlock> MEDITERRANEAN_WATER = IcariaBlocks.register("mediterranean_water", () -> new LiquidBlock(IcariaFluids.MEDITERRANEAN_WATER, IcariaBlocks.propertiesWater(MapColor.PLANT, SoundType.EMPTY)));

	public static final RegistryObject<Block> GREEK_FIRE = IcariaBlocks.register("greek_fire", () -> new GreekFireBlock(IcariaBlocks.propertiesFire(MapColor.COLOR_LIGHT_GREEN, SoundType.EMPTY)));

	public static final RegistryObject<Block> ICARIA_PORTAL = IcariaBlocks.register("icaria_portal", () -> new IcariaPortalBlock(IcariaBlocks.propertiesPortal(MapColor.NONE, SoundType.GLASS)));

	public static boolean always(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	public static boolean always(BlockState pState, BlockGetter pLevel, BlockPos pPos, EntityType<?> pEntity) {
		return true;
	}

	public static boolean never(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return false;
	}

	public static boolean never(BlockState pState, BlockGetter pLevel, BlockPos pPos, EntityType<?> pEntity) {
		return false;
	}

	public static BlockBehaviour.Properties propertiesGrassyMarl(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.6F).explosionResistance(0.6F).randomTicks();
	}

	public static BlockBehaviour.Properties propertiesMarl(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesMarlOre(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesGroundDeco(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noCollission().noOcclusion().replaceable();
	}

	public static BlockBehaviour.Properties propertiesFarmland(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.6F).explosionResistance(0.6F).isSuffocating(IcariaBlocks::always).isViewBlocking(IcariaBlocks::always).randomTicks();
	}

	public static BlockBehaviour.Properties propertiesStone(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(1.5F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesLoam(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.FLUTE).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.6F).explosionResistance(0.6F);
	}

	public static BlockBehaviour.Properties propertiesSand(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesSandOre(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesGlass(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.3F).explosionResistance(0.3F).isRedstoneConductor(IcariaBlocks::never).isSuffocating(IcariaBlocks::never).isValidSpawn(IcariaBlocks::never).isViewBlocking(IcariaBlocks::never).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesQuartz(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.8F).explosionResistance(0.8F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesMineral(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(1.5F).explosionResistance(1.5F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesBudding(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(1.5F).explosionResistance(1.5F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesCrystal(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(1.5F).explosionResistance(1.5F).lightLevel((pBlockState) -> 6).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesAristone(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F).friction(0.98F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesPackedAristone(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CHIME).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F).friction(0.98F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesJellyfishJellyBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F).friction(0.8F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesArachneStringBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.GUITAR).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.8F).explosionResistance(0.8F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesSpeltBaleBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BANJO).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesVineReedBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(2.0F).explosionResistance(3.0F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesVineSproutBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(2.0F).explosionResistance(3.0F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesRottenBonesBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.XYLOPHONE).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(2.0F).explosionResistance(2.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesRawMetalBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(5.0F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesCrystalBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(0.3F).explosionResistance(0.3F).isRedstoneConductor(IcariaBlocks::never).isSuffocating(IcariaBlocks::never).isValidSpawn(IcariaBlocks::never).isViewBlocking(IcariaBlocks::never).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesMetalBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(5.0F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesCoalBlock(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(5.0F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesBars(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(5.0F).explosionResistance(6.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesChain(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(5.0F).explosionResistance(6.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesGrinder(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(1.5F).explosionResistance(6.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesKiln(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(1.5F).explosionResistance(6.0F).lightLevel(IcariaBlocks.litBlockEmission(13)).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesChest(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.BLOCK).sound(pSound).destroyTime(2.5F).explosionResistance(2.5F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesStorageVase(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(1.25F).explosionResistance(4.2F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesLootVase(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesSpawner(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pColor).pushReaction(PushReaction.BLOCK).sound(pSound).destroyTime(5.0F).explosionResistance(5.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesSkull(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(1.0F).explosionResistance(1.0F);
	}

	public static BlockBehaviour.Properties propertiesTorch(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesCake(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesSapling(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesPot(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesLeaves(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(0.2F).explosionResistance(0.2F).isRedstoneConductor(IcariaBlocks::never).isSuffocating(IcariaBlocks::never).isValidSpawn(IcariaBlocks::never).isViewBlocking(IcariaBlocks::never).ignitedByLava().noOcclusion().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesWood(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(2.0F).explosionResistance(2.0F).ignitedByLava().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesPlanks(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(2.0F).explosionResistance(3.0F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesCraftingTable(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(2.5F).explosionResistance(2.5F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesDoor(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(3.0F).explosionResistance(3.0F).ignitedByLava().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesTrapDoor(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.NORMAL).sound(pSound).destroyTime(3.0F).explosionResistance(3.0F).ignitedByLava().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesLadder(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(0.4F).explosionResistance(0.4F).ignitedByLava().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesSign(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pColor).pushReaction(PushReaction.BLOCK).sound(pSound).destroyTime(1.0F).explosionResistance(1.0F).ignitedByLava().noCollission();
	}

	public static BlockBehaviour.Properties propertiesVine(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(0.2F).explosionResistance(0.2F).ignitedByLava().noCollission().randomTicks().replaceable();
	}

	public static BlockBehaviour.Properties propertiesGrass(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().instabreak().noCollission().replaceable();
	}

	public static BlockBehaviour.Properties propertiesPlant(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).offsetType(BlockBehaviour.OffsetType.XZ).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesGroundFlower(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesMoss(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(0.1F).explosionResistance(0.1F);
	}

	public static BlockBehaviour.Properties propertiesGroundShroom(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess(IcariaBlocks::always).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesTreeShroom(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesCactus(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(0.4F).explosionResistance(0.4F).randomTicks();
	}

	public static BlockBehaviour.Properties propertiesBush(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).offsetType(BlockBehaviour.OffsetType.XZ).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesCrop(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesWater(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).destroyTime(100.0F).explosionResistance(100.0F).noCollission().liquid().replaceable();
	}

	public static BlockBehaviour.Properties propertiesFire(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.DESTROY).sound(pSound).lightLevel((pBlockState) -> 15).instabreak().noCollission().noParticlesOnBreak().replaceable();
	}

	public static BlockBehaviour.Properties propertiesPortal(MapColor pColor, SoundType pSound) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pColor).pushReaction(PushReaction.BLOCK).sound(pSound).destroyTime(-1.0F).explosionResistance(-1.0F).lightLevel((pBlockState) -> 11).noCollission().randomTicks();
	}

	public static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
		return (pBlockState) -> pBlockState.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
	}

	public static <T extends Block> RegistryObject<T> register(String pName, Supplier<? extends T> pSupplier) {
		return IcariaBlocks.BLOCKS.register(pName, pSupplier);
	}

	public static <T extends Block> RegistryObject<T> registerSimple(String pName, Supplier<? extends T> pSupplier) {
		RegistryObject<T> registryObject = IcariaBlocks.register(pName, pSupplier);
		IcariaBlocks.SIMPLE_BLOCKS.add(registryObject);
		return registryObject;
	}
}
