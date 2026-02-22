package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.block.*;
import com.axanthic.icaria.common.properties.Carpet;
import com.axanthic.icaria.common.util.IcariaSkullBlockTypes;

import java.util.function.Function;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("deprecation, unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, IcariaIdents.ID);

	public static final DeferredHolder<Block, Block> GRASSY_MARL = IcariaBlocks.register("grassy_marl", GrassyMarlBlock::new, IcariaBlocks.propertiesGrassyMarl(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MARL = IcariaBlocks.register("marl", Block::new, IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> MARL_CHERT = IcariaBlocks.register("marl_chert", Block::new, IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> SURFACE_CHERT = IcariaBlocks.register("surface_chert", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MARL_BONES = IcariaBlocks.register("marl_bones", Block::new, IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> SURFACE_BONES = IcariaBlocks.register("surface_bones", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.BONE_BLOCK));
	public static final DeferredHolder<Block, Block> MARL_LIGNITE = IcariaBlocks.register("marl_lignite", Block::new, IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> SURFACE_LIGNITE = IcariaBlocks.register("surface_lignite", GroundDecoBlock::new, IcariaBlocks.propertiesSurfaceLignite(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COARSE_MARL = IcariaBlocks.register("coarse_marl", Block::new, IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> DRY_LAKE_BED = IcariaBlocks.register("dry_lake_bed", Block::new, IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> FARMLAND = IcariaBlocks.register("farmland", FarmlandBlock::new, IcariaBlocks.propertiesFarmland(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> FERTILIZED_FARMLAND = IcariaBlocks.register("fertilized_farmland", FertilizedFarmlandBlock::new, IcariaBlocks.propertiesFarmland(MapColor.COLOR_BROWN, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> MARL_PATH = IcariaBlocks.register("marl_path", properties -> new IcariaPathBlock(IcariaBlocks.MARL.get(), properties), IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL));

	public static final DeferredHolder<Block, Block> MARL_ADOBE = IcariaBlocks.register("marl_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MARL_ADOBE_STAIRS = IcariaBlocks.register("marl_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.MARL_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MARL_ADOBE_SLAB = IcariaBlocks.register("marl_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MARL_ADOBE_WALL = IcariaBlocks.register("marl_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE));

	public static final DeferredHolder<Block, Block> LOAM = IcariaBlocks.register("loam", Block::new, IcariaBlocks.propertiesLoam(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> LOAM_PATH = IcariaBlocks.register("loam_path", properties -> new IcariaPathBlock(IcariaBlocks.LOAM.get(), properties), IcariaBlocks.propertiesLoam(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.GRAVEL));
	public static final DeferredHolder<Block, Block> LOAM_BRICKS = IcariaBlocks.register("loam_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LOAM_BRICK_STAIRS = IcariaBlocks.register("loam_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.LOAM_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LOAM_BRICK_SLAB = IcariaBlocks.register("loam_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LOAM_BRICK_WALL = IcariaBlocks.register("loam_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.STONE));

	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE = IcariaBlocks.register("dolomite_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE_STAIRS = IcariaBlocks.register("dolomite_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.DOLOMITE_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE_SLAB = IcariaBlocks.register("dolomite_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE_WALL = IcariaBlocks.register("dolomite_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE = IcariaBlocks.register("smooth_dolomite", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE_STAIRS = IcariaBlocks.register("smooth_dolomite_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SMOOTH_DOLOMITE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE_SLAB = IcariaBlocks.register("smooth_dolomite_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE_WALL = IcariaBlocks.register("smooth_dolomite_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DOLOMITE_BRICKS = IcariaBlocks.register("dolomite_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_DOLOMITE = IcariaBlocks.register("chiseled_dolomite", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DOLOMITE_PILLAR = IcariaBlocks.register("dolomite_pillar", RotatedPillarBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DOLOMITE_PILLAR_HEAD = IcariaBlocks.register("dolomite_pillar_head", PillarHeadBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> GRAINEL = IcariaBlocks.register("grainel", IcariaSandBlock::new, IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_YELLOW, SoundType.SAND));
	public static final DeferredHolder<Block, Block> SUSPICIOUS_GRAINEL = IcariaBlocks.register("suspicious_grainel", properties -> new IcariaBrushableBlock(IcariaBlocks.GRAINEL.get(), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, properties), IcariaBlocks.propertiesSuspiciousSand(MapColor.TERRACOTTA_YELLOW, SoundType.SUSPICIOUS_SAND));
	public static final DeferredHolder<Block, Block> GRAINEL_CHERT = IcariaBlocks.register("grainel_chert", Block::new, IcariaBlocks.propertiesSandOre(MapColor.TERRACOTTA_YELLOW, SoundType.SAND));
	public static final DeferredHolder<Block, Block> GRAINEL_PATH = IcariaBlocks.register("grainel_path", properties -> new IcariaPathBlock(IcariaBlocks.GRAINEL.get(), properties), IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_YELLOW, SoundType.SAND));
	public static final DeferredHolder<Block, Block> GRAINGLASS = IcariaBlocks.register("grainglass", TransparentBlock::new, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> GRAINGLASS_PANE = IcariaBlocks.register("grainglass_pane", IcariaIronBarsBlock::new, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> HORIZONTAL_GRAINGLASS_PANE = IcariaBlocks.register("horizontal_grainglass_pane", HorizontalPaneBlock::new, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE = IcariaBlocks.register("grainite_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE_STAIRS = IcariaBlocks.register("grainite_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.GRAINITE_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE_SLAB = IcariaBlocks.register("grainite_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE_WALL = IcariaBlocks.register("grainite_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE = IcariaBlocks.register("grainite", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_STAIRS = IcariaBlocks.register("grainite_stairs", properties -> new IcariaStairBlock(IcariaBlocks.GRAINITE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_SLAB = IcariaBlocks.register("grainite_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_WALL = IcariaBlocks.register("grainite_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_BRICKS = IcariaBlocks.register("grainite_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_BRICK_STAIRS = IcariaBlocks.register("grainite_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.GRAINITE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_BRICK_SLAB = IcariaBlocks.register("grainite_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_BRICK_WALL = IcariaBlocks.register("grainite_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_GRAINITE = IcariaBlocks.register("chiseled_grainite", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE));
	public static final DeferredHolder<Block, Block> GRAINITE_RUBBLE = IcariaBlocks.register("grainite_rubble", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE = IcariaBlocks.register("yellowstone_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE_STAIRS = IcariaBlocks.register("yellowstone_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.YELLOWSTONE_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE_SLAB = IcariaBlocks.register("yellowstone_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE_WALL = IcariaBlocks.register("yellowstone_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE = IcariaBlocks.register("cobbled_yellowstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE_STAIRS = IcariaBlocks.register("cobbled_yellowstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_YELLOWSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE_SLAB = IcariaBlocks.register("cobbled_yellowstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE_WALL = IcariaBlocks.register("cobbled_yellowstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE = IcariaBlocks.register("yellowstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_STAIRS = IcariaBlocks.register("yellowstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.YELLOWSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_SLAB = IcariaBlocks.register("yellowstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_WALL = IcariaBlocks.register("yellowstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICKS = IcariaBlocks.register("yellowstone_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICK_STAIRS = IcariaBlocks.register("yellowstone_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.YELLOWSTONE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICK_SLAB = IcariaBlocks.register("yellowstone_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICK_WALL = IcariaBlocks.register("yellowstone_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_YELLOWSTONE = IcariaBlocks.register("chiseled_yellowstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_RUBBLE = IcariaBlocks.register("yellowstone_rubble", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> SILKSAND = IcariaBlocks.register("silksand", IcariaSandBlock::new, IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.SAND));
	public static final DeferredHolder<Block, Block> SUSPICIOUS_SILKSAND = IcariaBlocks.register("suspicious_silksand", properties -> new IcariaBrushableBlock(IcariaBlocks.SILKSAND.get(), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, properties), IcariaBlocks.propertiesSuspiciousSand(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.SUSPICIOUS_SAND));
	public static final DeferredHolder<Block, Block> SILKSAND_PATH = IcariaBlocks.register("silksand_path", properties -> new IcariaPathBlock(IcariaBlocks.SILKSAND.get(), properties), IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.SAND));
	public static final DeferredHolder<Block, Block> SILKGLASS = IcariaBlocks.register("silkglass", TransparentBlock::new, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> SILKGLASS_PANE = IcariaBlocks.register("silkglass_pane", IcariaIronBarsBlock::new, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> HORIZONTAL_SILKGLASS_PANE = IcariaBlocks.register("horizontal_silkglass_pane", HorizontalPaneBlock::new, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE = IcariaBlocks.register("silkstone_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE_STAIRS = IcariaBlocks.register("silkstone_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SILKSTONE_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE_SLAB = IcariaBlocks.register("silkstone_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE_WALL = IcariaBlocks.register("silkstone_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE = IcariaBlocks.register("cobbled_silkstone", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE_STAIRS = IcariaBlocks.register("cobbled_silkstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_SILKSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE_SLAB = IcariaBlocks.register("cobbled_silkstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE_WALL = IcariaBlocks.register("cobbled_silkstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE = IcariaBlocks.register("silkstone", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_STAIRS = IcariaBlocks.register("silkstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SILKSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_SLAB = IcariaBlocks.register("silkstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_WALL = IcariaBlocks.register("silkstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICKS = IcariaBlocks.register("silkstone_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICK_STAIRS = IcariaBlocks.register("silkstone_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SILKSTONE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICK_SLAB = IcariaBlocks.register("silkstone_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICK_WALL = IcariaBlocks.register("silkstone_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_SILKSTONE = IcariaBlocks.register("chiseled_silkstone", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SILKSTONE_RUBBLE = IcariaBlocks.register("silkstone_rubble", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE = IcariaBlocks.register("sunstone_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE_STAIRS = IcariaBlocks.register("sunstone_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SUNSTONE_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE_SLAB = IcariaBlocks.register("sunstone_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE_WALL = IcariaBlocks.register("sunstone_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE = IcariaBlocks.register("cobbled_sunstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE_STAIRS = IcariaBlocks.register("cobbled_sunstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_SUNSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE_SLAB = IcariaBlocks.register("cobbled_sunstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE_WALL = IcariaBlocks.register("cobbled_sunstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE = IcariaBlocks.register("sunstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_STAIRS = IcariaBlocks.register("sunstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SUNSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_SLAB = IcariaBlocks.register("sunstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_WALL = IcariaBlocks.register("sunstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICKS = IcariaBlocks.register("sunstone_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICK_STAIRS = IcariaBlocks.register("sunstone_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SUNSTONE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICK_SLAB = IcariaBlocks.register("sunstone_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICK_WALL = IcariaBlocks.register("sunstone_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_SUNSTONE = IcariaBlocks.register("chiseled_sunstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSTONE_RUBBLE = IcariaBlocks.register("sunstone_rubble", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE = IcariaBlocks.register("voidshale_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE_STAIRS = IcariaBlocks.register("voidshale_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.VOIDSHALE_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE_SLAB = IcariaBlocks.register("voidshale_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE_WALL = IcariaBlocks.register("voidshale_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE = IcariaBlocks.register("cobbled_voidshale", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE_STAIRS = IcariaBlocks.register("cobbled_voidshale_stairs", properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_VOIDSHALE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE_SLAB = IcariaBlocks.register("cobbled_voidshale_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE_WALL = IcariaBlocks.register("cobbled_voidshale_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE = IcariaBlocks.register("voidshale", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_STAIRS = IcariaBlocks.register("voidshale_stairs", properties -> new IcariaStairBlock(IcariaBlocks.VOIDSHALE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_SLAB = IcariaBlocks.register("voidshale_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_WALL = IcariaBlocks.register("voidshale_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICKS = IcariaBlocks.register("voidshale_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICK_STAIRS = IcariaBlocks.register("voidshale_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.VOIDSHALE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICK_SLAB = IcariaBlocks.register("voidshale_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICK_WALL = IcariaBlocks.register("voidshale_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_VOIDSHALE = IcariaBlocks.register("chiseled_voidshale", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDSHALE_RUBBLE = IcariaBlocks.register("voidshale_rubble", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> BAETYL_ADOBE = IcariaBlocks.register("baetyl_adobe", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_ADOBE_STAIRS = IcariaBlocks.register("baetyl_adobe_stairs", properties -> new IcariaStairBlock(IcariaBlocks.BAETYL_ADOBE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_ADOBE_SLAB = IcariaBlocks.register("baetyl_adobe_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_ADOBE_WALL = IcariaBlocks.register("baetyl_adobe_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL = IcariaBlocks.register("cobbled_baetyl", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL_STAIRS = IcariaBlocks.register("cobbled_baetyl_stairs", properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_BAETYL.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL_SLAB = IcariaBlocks.register("cobbled_baetyl_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL_WALL = IcariaBlocks.register("cobbled_baetyl_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL = IcariaBlocks.register("baetyl", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_STAIRS = IcariaBlocks.register("baetyl_stairs", properties -> new IcariaStairBlock(IcariaBlocks.BAETYL.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_SLAB = IcariaBlocks.register("baetyl_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_WALL = IcariaBlocks.register("baetyl_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_BRICKS = IcariaBlocks.register("baetyl_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_BRICK_STAIRS = IcariaBlocks.register("baetyl_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.BAETYL_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_BRICK_SLAB = IcariaBlocks.register("baetyl_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_BRICK_WALL = IcariaBlocks.register("baetyl_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_BAETYL = IcariaBlocks.register("chiseled_baetyl", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BAETYL_RUBBLE = IcariaBlocks.register("baetyl_rubble", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> RELICSTONE = IcariaBlocks.register("relicstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_STAIRS = IcariaBlocks.register("relicstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.RELICSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_SLAB = IcariaBlocks.register("relicstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_WALL = IcariaBlocks.register("relicstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE = IcariaBlocks.register("smooth_relicstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE_STAIRS = IcariaBlocks.register("smooth_relicstone_stairs", properties -> new IcariaStairBlock(IcariaBlocks.SMOOTH_RELICSTONE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE_SLAB = IcariaBlocks.register("smooth_relicstone_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE_WALL = IcariaBlocks.register("smooth_relicstone_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICKS = IcariaBlocks.register("relicstone_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICK_STAIRS = IcariaBlocks.register("relicstone_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.RELICSTONE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICK_SLAB = IcariaBlocks.register("relicstone_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICK_WALL = IcariaBlocks.register("relicstone_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICKS = IcariaBlocks.register("cracked_relicstone_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICK_STAIRS = IcariaBlocks.register("cracked_relicstone_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICK_SLAB = IcariaBlocks.register("cracked_relicstone_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICK_WALL = IcariaBlocks.register("cracked_relicstone_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICKS = IcariaBlocks.register("mossy_relicstone_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICK_STAIRS = IcariaBlocks.register("mossy_relicstone_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICK_SLAB = IcariaBlocks.register("mossy_relicstone_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICK_WALL = IcariaBlocks.register("mossy_relicstone_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_TILES = IcariaBlocks.register("relicstone_tiles", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_TILE_STAIRS = IcariaBlocks.register("relicstone_tile_stairs", properties -> new IcariaStairBlock(IcariaBlocks.RELICSTONE_TILES.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_TILE_SLAB = IcariaBlocks.register("relicstone_tile_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_TILE_WALL = IcariaBlocks.register("relicstone_tile_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILES = IcariaBlocks.register("cracked_relicstone_tiles", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILE_STAIRS = IcariaBlocks.register("cracked_relicstone_tile_stairs", properties -> new IcariaStairBlock(IcariaBlocks.CRACKED_RELICSTONE_TILES.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILE_SLAB = IcariaBlocks.register("cracked_relicstone_tile_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILE_WALL = IcariaBlocks.register("cracked_relicstone_tile_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILES = IcariaBlocks.register("mossy_relicstone_tiles", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILE_STAIRS = IcariaBlocks.register("mossy_relicstone_tile_stairs", properties -> new IcariaStairBlock(IcariaBlocks.MOSSY_RELICSTONE_TILES.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILE_SLAB = IcariaBlocks.register("mossy_relicstone_tile_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILE_WALL = IcariaBlocks.register("mossy_relicstone_tile_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_RELICSTONE = IcariaBlocks.register("chiseled_relicstone", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_PILLAR = IcariaBlocks.register("relicstone_pillar", RotatedPillarBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_PILLAR_HEAD = IcariaBlocks.register("relicstone_pillar_head", PillarHeadBlock::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> RELICSTONE_RUBBLE = IcariaBlocks.register("relicstone_rubble", GroundDecoBlock::new, IcariaBlocks.propertiesGroundDeco(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> PLATOSHALE = IcariaBlocks.register("platoshale", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLATOSHALE_STAIRS = IcariaBlocks.register("platoshale_stairs", properties -> new IcariaStairBlock(IcariaBlocks.PLATOSHALE.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLATOSHALE_SLAB = IcariaBlocks.register("platoshale_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLATOSHALE_WALL = IcariaBlocks.register("platoshale_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BLURRED_PLATOSHALE = IcariaBlocks.register("blurred_platoshale", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICKS = IcariaBlocks.register("platoshale_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICK_STAIRS = IcariaBlocks.register("platoshale_brick_stairs", properties -> new IcariaStairBlock(IcariaBlocks.PLATOSHALE_BRICKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICK_SLAB = IcariaBlocks.register("platoshale_brick_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICK_WALL = IcariaBlocks.register("platoshale_brick_wall", IcariaWallBlock::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BLURRED_PLATOSHALE_BRICKS = IcariaBlocks.register("blurred_platoshale_bricks", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHISELED_PLATOSHALE = IcariaBlocks.register("chiseled_platoshale", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE));

	public static final DeferredHolder<Block, Block> QUARTZ_WALL = IcariaBlocks.register("quartz_wall", IcariaWallBlock::new, IcariaBlocks.propertiesQuartz(MapColor.QUARTZ, SoundType.STONE));
	public static final DeferredHolder<Block, Block> QUARTZ_PILLAR_HEAD = IcariaBlocks.register("quartz_pillar_head", PillarHeadBlock::new, IcariaBlocks.propertiesQuartz(MapColor.QUARTZ, SoundType.STONE));

	public static final DeferredHolder<Block, Block> CHIMNEY = IcariaBlocks.register("chimney", ChimneyBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE).forceSolidOff());
	public static final DeferredHolder<Block, Block> CHIMNEY_BRICK_CROWN = IcariaBlocks.register("chimney_brick_crown", ChimneyBrickCrownBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE).forceSolidOff());
	public static final DeferredHolder<Block, Block> CHIMNEY_GRATE_CROWN = IcariaBlocks.register("chimney_grate_crown", ChimneyGrateCrownBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_ORANGE, SoundType.STONE).forceSolidOff());
	public static final DeferredHolder<Block, Block> CHIMNEY_SLAB = IcariaBlocks.register("chimney_slab", ChimneySlabBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE).forceSolidOff());

	public static final DeferredHolder<Block, Block> LIGNITE_ORE = IcariaBlocks.register("lignite_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHALKOS_ORE = IcariaBlocks.register("chalkos_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> KASSITEROS_ORE = IcariaBlocks.register("kassiteros_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DOLOMITE_ORE = IcariaBlocks.register("dolomite_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VANADIUM_ORE = IcariaBlocks.register("vanadium_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SLIVER_ORE = IcariaBlocks.register("sliver_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SIDEROS_ORE = IcariaBlocks.register("sideros_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> ANTHRACITE_ORE = IcariaBlocks.register("anthracite_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOLYBDENUM_ORE = IcariaBlocks.register("molybdenum_ore", Block::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> HYLIASTRUM_ORE = IcariaBlocks.register("hyliastrum_ore", HyliastrumOreBlock::new, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE));

	public static final DeferredHolder<Block, Block> CALCITE = IcariaBlocks.register("calcite", Block::new, IcariaBlocks.propertiesMineral(MapColor.COLOR_LIGHT_GRAY, SoundType.AMETHYST));
	public static final DeferredHolder<Block, Block> BUDDING_CALCITE = IcariaBlocks.register("budding_calcite", Block::new, IcariaBlocks.propertiesBudding(MapColor.COLOR_LIGHT_GRAY, SoundType.AMETHYST));
	public static final DeferredHolder<Block, Block> HALITE = IcariaBlocks.register("halite", Block::new, IcariaBlocks.propertiesMineral(MapColor.COLOR_GREEN, SoundType.AMETHYST));
	public static final DeferredHolder<Block, Block> BUDDING_HALITE = IcariaBlocks.register("budding_halite", Block::new, IcariaBlocks.propertiesBudding(MapColor.COLOR_GREEN, SoundType.AMETHYST));
	public static final DeferredHolder<Block, Block> JASPER = IcariaBlocks.register("jasper", Block::new, IcariaBlocks.propertiesMineral(MapColor.COLOR_RED, SoundType.AMETHYST));
	public static final DeferredHolder<Block, Block> BUDDING_JASPER = IcariaBlocks.register("budding_jasper", Block::new, IcariaBlocks.propertiesBudding(MapColor.COLOR_RED, SoundType.AMETHYST));
	public static final DeferredHolder<Block, Block> ZIRCON = IcariaBlocks.register("zircon", Block::new, IcariaBlocks.propertiesMineral(MapColor.COLOR_BLUE, SoundType.AMETHYST));
	public static final DeferredHolder<Block, Block> BUDDING_ZIRCON = IcariaBlocks.register("budding_zircon", Block::new, IcariaBlocks.propertiesBudding(MapColor.COLOR_BLUE, SoundType.AMETHYST));

	public static final DeferredHolder<Block, Block> CALCITE_CRYSTAL = IcariaBlocks.register("calcite_crystal", CrystalBlock::new, IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER));
	public static final DeferredHolder<Block, Block> HALITE_CRYSTAL = IcariaBlocks.register("halite_crystal", CrystalBlock::new, IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER));
	public static final DeferredHolder<Block, Block> JASPER_CRYSTAL = IcariaBlocks.register("jasper_crystal", CrystalBlock::new, IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER));
	public static final DeferredHolder<Block, Block> ZIRCON_CRYSTAL = IcariaBlocks.register("zircon_crystal", CrystalBlock::new, IcariaBlocks.propertiesCrystal(MapColor.NONE, SoundType.AMETHYST_CLUSTER));

	public static final DeferredHolder<Block, Block> ARISTONE = IcariaBlocks.register("aristone", TransparentBlock::new, IcariaBlocks.propertiesAristone(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> PACKED_ARISTONE = IcariaBlocks.register("packed_aristone", Block::new, IcariaBlocks.propertiesPackedAristone(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.GLASS));

	public static final DeferredHolder<Block, Block> ENDER_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register("ender_jellyfish_jelly_block", JellyfishJellyBlock::new, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_BLACK, SoundType.HONEY_BLOCK));
	public static final DeferredHolder<Block, Block> FIRE_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register("fire_jellyfish_jelly_block", JellyfishJellyBlock::new, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_ORANGE, SoundType.HONEY_BLOCK));
	public static final DeferredHolder<Block, Block> NATURE_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register("nature_jellyfish_jelly_block", JellyfishJellyBlock::new, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.WARPED_WART_BLOCK, SoundType.HONEY_BLOCK));
	public static final DeferredHolder<Block, Block> VOID_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register("void_jellyfish_jelly_block", JellyfishJellyBlock::new, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_MAGENTA, SoundType.HONEY_BLOCK));
	public static final DeferredHolder<Block, Block> WATER_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register("water_jellyfish_jelly_block", JellyfishJellyBlock::new, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.HONEY_BLOCK));

	public static final DeferredHolder<Block, Block> ARACHNE_STRING_BLOCK = IcariaBlocks.register("arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.COLOR_BROWN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> WHITE_ARACHNE_STRING_BLOCK = IcariaBlocks.register("white_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_WHITE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> LIGHT_GRAY_ARACHNE_STRING_BLOCK = IcariaBlocks.register("light_gray_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.DEEPSLATE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> GRAY_ARACHNE_STRING_BLOCK = IcariaBlocks.register("gray_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_GRAY, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> BLACK_ARACHNE_STRING_BLOCK = IcariaBlocks.register("black_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.COLOR_BLACK, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> BROWN_ARACHNE_STRING_BLOCK = IcariaBlocks.register("brown_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.PODZOL, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> RED_ARACHNE_STRING_BLOCK = IcariaBlocks.register("red_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_RED, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> ORANGE_ARACHNE_STRING_BLOCK = IcariaBlocks.register("orange_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_ORANGE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> YELLOW_ARACHNE_STRING_BLOCK = IcariaBlocks.register("yellow_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_YELLOW, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> LIME_ARACHNE_STRING_BLOCK = IcariaBlocks.register("lime_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.COLOR_GREEN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> GREEN_ARACHNE_STRING_BLOCK = IcariaBlocks.register("green_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> CYAN_ARACHNE_STRING_BLOCK = IcariaBlocks.register("cyan_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.GLOW_LICHEN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> LIGHT_BLUE_ARACHNE_STRING_BLOCK = IcariaBlocks.register("light_blue_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_LIGHT_BLUE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> BLUE_ARACHNE_STRING_BLOCK = IcariaBlocks.register("blue_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_BLUE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> PURPLE_ARACHNE_STRING_BLOCK = IcariaBlocks.register("purple_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.COLOR_MAGENTA, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> MAGENTA_ARACHNE_STRING_BLOCK = IcariaBlocks.register("magenta_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_PURPLE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> PINK_ARACHNE_STRING_BLOCK = IcariaBlocks.register("pink_arachne_string_block", Block::new, IcariaBlocks.propertiesArachneStringBlock(MapColor.TERRACOTTA_MAGENTA, SoundType.WOOL));

	public static final DeferredHolder<Block, Block> ARACHNE_STRING_CARPET = IcariaBlocks.register("arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.COLOR_BROWN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> WHITE_ARACHNE_STRING_CARPET = IcariaBlocks.register("white_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.WHITE_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_WHITE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> LIGHT_GRAY_ARACHNE_STRING_CARPET = IcariaBlocks.register("light_gray_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.LIGHT_GRAY_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.DEEPSLATE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> GRAY_ARACHNE_STRING_CARPET = IcariaBlocks.register("gray_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.GRAY_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_GRAY, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> BLACK_ARACHNE_STRING_CARPET = IcariaBlocks.register("black_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.BLACK_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.COLOR_BLACK, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> BROWN_ARACHNE_STRING_CARPET = IcariaBlocks.register("brown_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.BROWN_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.PODZOL, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> RED_ARACHNE_STRING_CARPET = IcariaBlocks.register("red_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.RED_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_RED, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> ORANGE_ARACHNE_STRING_CARPET = IcariaBlocks.register("orange_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.ORANGE_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_ORANGE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> YELLOW_ARACHNE_STRING_CARPET = IcariaBlocks.register("yellow_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.YELLOW_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_YELLOW, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> LIME_ARACHNE_STRING_CARPET = IcariaBlocks.register("lime_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.LIME_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.COLOR_GREEN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> GREEN_ARACHNE_STRING_CARPET = IcariaBlocks.register("green_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.GREEN_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> CYAN_ARACHNE_STRING_CARPET = IcariaBlocks.register("cyan_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.CYAN_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.GLOW_LICHEN, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> LIGHT_BLUE_ARACHNE_STRING_CARPET = IcariaBlocks.register("light_blue_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.LIGHT_BLUE_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_LIGHT_BLUE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> BLUE_ARACHNE_STRING_CARPET = IcariaBlocks.register("blue_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.BLUE_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_BLUE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> PURPLE_ARACHNE_STRING_CARPET = IcariaBlocks.register("purple_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.PURPLE_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.COLOR_MAGENTA, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> MAGENTA_ARACHNE_STRING_CARPET = IcariaBlocks.register("magenta_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.MAGENTA_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_PURPLE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> PINK_ARACHNE_STRING_CARPET = IcariaBlocks.register("pink_arachne_string_carpet", properties -> new IcariaCarpetBlock(Carpet.PINK_ARACHNE_STRING_CARPET, properties), IcariaBlocks.propertiesArachneStringCarpet(MapColor.TERRACOTTA_MAGENTA, SoundType.WOOL));

	public static final DeferredHolder<Block, Block> SPELT_BALE_BLOCK = IcariaBlocks.register("spelt_bale_block", SpeltBaleBlock::new, IcariaBlocks.propertiesSpeltBaleBlock(MapColor.TERRACOTTA_YELLOW, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> VINE_REED_BLOCK = IcariaBlocks.register("vine_reed_block", Block::new, IcariaBlocks.propertiesVineReedBlock(MapColor.WOOD, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> ROTTEN_BONES_BLOCK = IcariaBlocks.register("rotten_bones_block", Block::new, IcariaBlocks.propertiesRottenBonesBlock(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.BONE_BLOCK));

	public static final DeferredHolder<Block, Block> RAW_CHALKOS_BLOCK = IcariaBlocks.register("raw_chalkos_block", Block::new, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_GREEN, SoundType.METAL));
	public static final DeferredHolder<Block, Block> RAW_KASSITEROS_BLOCK = IcariaBlocks.register("raw_kassiteros_block", Block::new, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL));
	public static final DeferredHolder<Block, Block> RAW_VANADIUM_BLOCK = IcariaBlocks.register("raw_vanadium_block", Block::new, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL));
	public static final DeferredHolder<Block, Block> RAW_SIDEROS_BLOCK = IcariaBlocks.register("raw_sideros_block", Block::new, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL));
	public static final DeferredHolder<Block, Block> RAW_MOLYBDENUM_BLOCK = IcariaBlocks.register("raw_molybdenum_block", Block::new, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL));

	public static final DeferredHolder<Block, Block> CALCITE_BLOCK = IcariaBlocks.register("calcite_block", HalfTransparentBlock::new, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> HALITE_BLOCK = IcariaBlocks.register("halite_block", HalfTransparentBlock::new, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_GREEN, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> JASPER_BLOCK = IcariaBlocks.register("jasper_block", HalfTransparentBlock::new, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_RED, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> ZIRCON_BLOCK = IcariaBlocks.register("zircon_block", HalfTransparentBlock::new, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_BLUE, SoundType.GLASS));
	public static final DeferredHolder<Block, Block> CHERT_BLOCK = IcariaBlocks.register("chert_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_GRAY, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LIGNITE_BLOCK = IcariaBlocks.register("lignite_block", Block::new, IcariaBlocks.propertiesCoalBlock(MapColor.COLOR_BROWN, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHALKOS_BLOCK = IcariaBlocks.register("chalkos_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_GREEN, SoundType.METAL));
	public static final DeferredHolder<Block, Block> KASSITEROS_BLOCK = IcariaBlocks.register("kassiteros_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL));
	public static final DeferredHolder<Block, Block> ORICHALCUM_BLOCK = IcariaBlocks.register("orichalcum_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL));
	public static final DeferredHolder<Block, Block> VANADIUM_BLOCK = IcariaBlocks.register("vanadium_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL));
	public static final DeferredHolder<Block, Block> SLIVER_BLOCK = IcariaBlocks.register("sliver_block", Block::new, IcariaBlocks.propertiesRawMetalBlock(MapColor.WOOD, SoundType.METAL));
	public static final DeferredHolder<Block, Block> VANADIUMSTEEL_BLOCK = IcariaBlocks.register("vanadiumsteel_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL));
	public static final DeferredHolder<Block, Block> SIDEROS_BLOCK = IcariaBlocks.register("sideros_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL));
	public static final DeferredHolder<Block, Block> ANTHRACITE_BLOCK = IcariaBlocks.register("anthracite_block", Block::new, IcariaBlocks.propertiesCoalBlock(MapColor.COLOR_BLACK, SoundType.STONE));
	public static final DeferredHolder<Block, Block> MOLYBDENUM_BLOCK = IcariaBlocks.register("molybdenum_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL));
	public static final DeferredHolder<Block, Block> MOLYBDENUMSTEEL_BLOCK = IcariaBlocks.register("molybdenumsteel_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL));
	public static final DeferredHolder<Block, Block> BLURIDIUM_BLOCK = IcariaBlocks.register("bluridium_block", Block::new, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL));

	public static final DeferredHolder<Block, Block> VANADIUMSTEEL_BARS = IcariaBlocks.register("vanadiumsteel_bars", IcariaIronBarsBlock::new, IcariaBlocks.propertiesBars(MapColor.NONE, SoundType.METAL));
	public static final DeferredHolder<Block, Block> HORIZONTAL_VANADIUMSTEEL_BARS = IcariaBlocks.register("horizontal_vanadiumsteel_bars", HorizontalPaneBlock::new, IcariaBlocks.propertiesBars(MapColor.NONE, SoundType.METAL));

	public static final DeferredHolder<Block, Block> VANADIUMSTEEL_CHAIN = IcariaBlocks.register("vanadiumsteel_chain", IcariaChainBlock::new, IcariaBlocks.propertiesChain(MapColor.NONE, SoundType.CHAIN));

	public static final DeferredHolder<Block, Block> GRATE_FIREPLACE = IcariaBlocks.register("grate_fireplace", properties -> new GrateFireplaceBlock(1.275F, properties), IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> POT_FIREPLACE = IcariaBlocks.register("pot_fireplace", properties -> new PotFireplaceBlock(1.2425F, properties), IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE));

	public static final DeferredHolder<Block, Block> KETTLE = IcariaBlocks.register("kettle", KettleBlock::new, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> GRINDER = IcariaBlocks.register("grinder", GrinderBlock::new, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> KILN = IcariaBlocks.register("kiln", KilnBlock::new, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE));
	public static final DeferredHolder<Block, Block> FORGE = IcariaBlocks.register("forge", ForgeBlock::new, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE));

	public static final DeferredHolder<Block, Block> CHEST = IcariaBlocks.register("chest", properties -> new IcariaChestBlock(IcariaBlockEntityTypes.CHEST::get, properties), IcariaBlocks.propertiesChest(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> TRAPPED_CHEST = IcariaBlocks.register("trapped_chest", properties -> new IcariaTrappedChestBlock(IcariaBlockEntityTypes.TRAPPED_CHEST::get, properties), IcariaBlocks.propertiesChest(MapColor.COLOR_BROWN, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> STORAGE_VASE = IcariaBlocks.register("storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.TERRACOTTA_PINK, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> WHITE_STORAGE_VASE = IcariaBlocks.register("white_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.SNOW, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> LIGHT_GRAY_STORAGE_VASE = IcariaBlocks.register("light_gray_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_GRAY, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> GRAY_STORAGE_VASE = IcariaBlocks.register("gray_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_GRAY, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> BLACK_STORAGE_VASE = IcariaBlocks.register("black_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BLACK, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> BROWN_STORAGE_VASE = IcariaBlocks.register("brown_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BROWN, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> RED_STORAGE_VASE = IcariaBlocks.register("red_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_RED, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> ORANGE_STORAGE_VASE = IcariaBlocks.register("orange_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_ORANGE, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> YELLOW_STORAGE_VASE = IcariaBlocks.register("yellow_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_YELLOW, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> LIME_STORAGE_VASE = IcariaBlocks.register("lime_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_GREEN, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> GREEN_STORAGE_VASE = IcariaBlocks.register("green_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_GREEN, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> CYAN_STORAGE_VASE = IcariaBlocks.register("cyan_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_CYAN, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> LIGHT_BLUE_STORAGE_VASE = IcariaBlocks.register("light_blue_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_BLUE, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> BLUE_STORAGE_VASE = IcariaBlocks.register("blue_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BLUE, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> PURPLE_STORAGE_VASE = IcariaBlocks.register("purple_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_PURPLE, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> MAGENTA_STORAGE_VASE = IcariaBlocks.register("magenta_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_MAGENTA, SoundType.DECORATED_POT));
	public static final DeferredHolder<Block, Block> PINK_STORAGE_VASE = IcariaBlocks.register("pink_storage_vase", StorageVaseBlock::new, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_PINK, SoundType.DECORATED_POT));

	public static final DeferredHolder<Block, Block> AMPHORA = IcariaBlocks.register("amphora", AmphoraBlock::new, IcariaBlocks.propertiesAmphora(MapColor.COLOR_LIGHT_GRAY, SoundType.DECORATED_POT));

	public static final DeferredHolder<Block, Block> RED_LOOT_VASE = IcariaBlocks.register("red_loot_vase", LootVaseBlock::new, IcariaBlocks.propertiesLootVase(MapColor.COLOR_RED, IcariaSoundTypes.VASE));
	public static final DeferredHolder<Block, Block> LOST_LOOT_VASE = IcariaBlocks.register("lost_loot_vase", LootVaseBlock::new, IcariaBlocks.propertiesLootVase(MapColor.PODZOL, IcariaSoundTypes.VASE));
	public static final DeferredHolder<Block, Block> CYAN_LOOT_VASE = IcariaBlocks.register("cyan_loot_vase", LootVaseBlock::new, IcariaBlocks.propertiesLootVase(MapColor.COLOR_CYAN, IcariaSoundTypes.VASE));

	public static final DeferredHolder<Block, Block> ARACHNE_SPAWNER = IcariaBlocks.register("arachne_spawner", IcariaSpawnerBlock::new, IcariaBlocks.propertiesSpawner(MapColor.COLOR_LIGHT_GRAY, SoundType.SPAWNER));
	public static final DeferredHolder<Block, Block> REVENANT_SPAWNER = IcariaBlocks.register("revenant_spawner", IcariaSpawnerBlock::new, IcariaBlocks.propertiesSpawner(MapColor.COLOR_GREEN, SoundType.SPAWNER));

	public static final DeferredHolder<Block, Block> BONE_LADDER = IcariaBlocks.register("bone_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.BONE_BLOCK));
	public static final DeferredHolder<Block, Block> ROTTEN_BONE_LADDER = IcariaBlocks.register("rotten_bone_ladder", RottenLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.BONE_BLOCK));

	public static final DeferredHolder<Block, Block> AETERNAE_SKULL = IcariaBlocks.register("aeternae_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.AETERNAE, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> AETERNAE_WALL_SKULL = IcariaBlocks.register("aeternae_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.AETERNAE, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> ARGAN_HOUND_SKULL = IcariaBlocks.register("argan_hound_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.ARGAN_HOUND, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> ARGAN_HOUND_WALL_SKULL = IcariaBlocks.register("argan_hound_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.ARGAN_HOUND, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CAPELLA_SKULL = IcariaBlocks.register("capella_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.CAPELLA, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CAPELLA_WALL_SKULL = IcariaBlocks.register("capella_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.CAPELLA, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CATOBLEPAS_SKULL = IcariaBlocks.register("catoblepas_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.CATOBLEPAS, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CATOBLEPAS_WALL_SKULL = IcariaBlocks.register("catoblepas_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.CATOBLEPAS, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CERVER_SKULL = IcariaBlocks.register("cerver_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.CERVER, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CERVER_WALL_SKULL = IcariaBlocks.register("cerver_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.CERVER, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CROCOTTA_SKULL = IcariaBlocks.register("crocotta_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.CROCOTTA, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CROCOTTA_WALL_SKULL = IcariaBlocks.register("crocotta_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.CROCOTTA, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CYPRESS_FOREST_HAG_SKULL = IcariaBlocks.register("cypress_forest_hag_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CYPRESS_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("cypress_forest_hag_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.CYPRESS_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FOREST_HAG_SKULL = IcariaBlocks.register("droughtroot_forest_hag_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("droughtroot_forest_hag_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.DROUGHTROOT_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> FIR_FOREST_HAG_SKULL = IcariaBlocks.register("fir_forest_hag_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.FIR_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> FIR_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("fir_forest_hag_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.FIR_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LAUREL_FOREST_HAG_SKULL = IcariaBlocks.register("laurel_forest_hag_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.LAUREL_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LAUREL_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("laurel_forest_hag_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.LAUREL_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> OLIVE_FOREST_HAG_SKULL = IcariaBlocks.register("olive_forest_hag_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.OLIVE_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> OLIVE_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("olive_forest_hag_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.OLIVE_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLANE_FOREST_HAG_SKULL = IcariaBlocks.register("plane_forest_hag_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.PLANE_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLANE_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("plane_forest_hag_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.PLANE_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> POPULUS_FOREST_HAG_SKULL = IcariaBlocks.register("populus_forest_hag_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.POPULUS_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> POPULUS_FOREST_HAG_WALL_SKULL = IcariaBlocks.register("populus_forest_hag_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.POPULUS_FOREST_HAG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> REVENANT_SKULL = IcariaBlocks.register("revenant_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.REVENANT, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> REVENANT_WALL_SKULL = IcariaBlocks.register("revenant_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.REVENANT, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> THOG_SKULL = IcariaBlocks.register("thog_skull", properties -> new SkullBlock(IcariaSkullBlockTypes.THOG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> THOG_WALL_SKULL = IcariaBlocks.register("thog_wall_skull", properties -> new WallSkullBlock(IcariaSkullBlockTypes.THOG, properties), IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> LIGNITE_TORCH = IcariaBlocks.register("lignite_torch", properties -> new TorchBlock(ParticleTypes.FLAME, properties), IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 10));
	public static final DeferredHolder<Block, Block> LIGNITE_WALL_TORCH = IcariaBlocks.register("lignite_wall_torch", properties -> new WallTorchBlock(ParticleTypes.FLAME, properties), IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 10));
	public static final DeferredHolder<Block, Block> ANTHRACITE_TORCH = IcariaBlocks.register("anthracite_torch", properties -> new TorchBlock(ParticleTypes.FLAME, properties), IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 14));
	public static final DeferredHolder<Block, Block> ANTHRACITE_WALL_TORCH = IcariaBlocks.register("anthracite_wall_torch", properties -> new WallTorchBlock(ParticleTypes.FLAME, properties), IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 14));

	public static final DeferredHolder<Block, Block> LAUREL_CHERRY_CAKE = IcariaBlocks.register("laurel_cherry_cake", properties -> new IcariaCakeBlock(true, 600, IcariaMobEffects.LIFESTEAL, properties), IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> STRAWBERRY_CAKE = IcariaBlocks.register("strawberry_cake", properties -> new IcariaCakeBlock(false, 600, MobEffects.FIRE_RESISTANCE, properties), IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> PHYSALIS_CAKE = IcariaBlocks.register("physalis_cake", properties -> new IcariaCakeBlock(false, 600, MobEffects.REGENERATION, properties), IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> VINE_BERRY_CAKE = IcariaBlocks.register("vine_berry_cake", properties -> new IcariaCakeBlock(false, 600, MobEffects.NIGHT_VISION, properties), IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> VINE_SPROUT_CAKE = IcariaBlocks.register("vine_sprout_cake", properties -> new IcariaCakeBlock(false, 600, MobEffects.SPEED, properties), IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL));

	public static final DeferredHolder<Block, Block> CYPRESS_SAPLING = IcariaBlocks.register("cypress_sapling", properties -> new SaplingBlock(IcariaTreeGrowers.CYPRESS, properties), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_CYPRESS_SAPLING = IcariaBlocks.register("potted_cypress_sapling", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CYPRESS_SAPLING, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CYPRESS_LEAVES = IcariaBlocks.register("cypress_leaves", properties -> new IcariaLeavesBlock(5203730, properties), IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FALLEN_CYPRESS_LEAVES = IcariaBlocks.register("fallen_cypress_leaves", LayerBlock::new, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> CYPRESS_TWIGS = IcariaBlocks.register("cypress_twigs", GroundDecoBlock::new, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_FIREWOOD = IcariaBlocks.register("cypress_firewood", FirewoodBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_FIREWOOD_WEDGE = IcariaBlocks.register("cypress_firewood_wedge", FirewoodWedgeBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_WOOD = IcariaBlocks.register("cypress_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_CYPRESS_WOOD = IcariaBlocks.register("stripped_cypress_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_LOG = IcariaBlocks.register("cypress_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_CYPRESS_LOG = IcariaBlocks.register("stripped_cypress_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DEAD_CYPRESS_LOG = IcariaBlocks.register("dead_cypress_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_CYPRESS_LOG = IcariaBlocks.register("stripped_dead_cypress_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_PLANKS = IcariaBlocks.register("cypress_planks", Block::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_STAIRS = IcariaBlocks.register("cypress_stairs", properties -> new IcariaStairBlock(IcariaBlocks.CYPRESS_PLANKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_SLAB = IcariaBlocks.register("cypress_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_FENCE = IcariaBlocks.register("cypress_fence", IcariaFenceBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_FENCE_GATE = IcariaBlocks.register("cypress_fence_gate", properties -> new FenceGateBlock(IcariaWoodTypes.CYPRESS, properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> SIMPLE_CYPRESS_RACK = IcariaBlocks.register("simple_cypress_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_RACK = IcariaBlocks.register("cypress_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_BARREL = IcariaBlocks.register("cypress_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LOADED_CYPRESS_BARREL = IcariaBlocks.register("loaded_cypress_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TAPPED_CYPRESS_BARREL = IcariaBlocks.register("tapped_cypress_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TRIPLE_CYPRESS_BARREL_RACK = IcariaBlocks.register("triple_cypress_barrel_rack", TripleBarrelRackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> CYPRESS_BATHTUB = IcariaBlocks.register("cypress_bathtub", BathtubBlock::new, IcariaBlocks.propertiesBathtub(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_TROUGH = IcariaBlocks.register("cypress_trough", TroughBlock::new, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_STOOL = IcariaBlocks.register("cypress_stool", StoolBlock::new, IcariaBlocks.propertiesStool(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_HERB_HOLDER = IcariaBlocks.register("cypress_herb_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_PAN_HOLDER = IcariaBlocks.register("cypress_pan_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_POT_HOLDER = IcariaBlocks.register("cypress_pot_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_SPOON_HOLDER = IcariaBlocks.register("cypress_spoon_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_TOWEL_HOLDER = IcariaBlocks.register("cypress_towel_holder", TowelHolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_COUNTERTOP = IcariaBlocks.register("cypress_countertop", CandleCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_FLOWER_POT_COUNTERTOP = IcariaBlocks.register("cypress_flower_pot_countertop", FlowerPotCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_MORTAR_COUNTERTOP = IcariaBlocks.register("cypress_mortar_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_POT_COUNTERTOP = IcariaBlocks.register("cypress_pot_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_BASINS_COUNTERTOP = IcariaBlocks.register("cypress_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_RAISED_BASINS_COUNTERTOP = IcariaBlocks.register("cypress_raised_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_CUPBOARD = IcariaBlocks.register("cypress_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_DISHES_CUPBOARD = IcariaBlocks.register("cypress_dishes_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_FLASKS_CUPBOARD = IcariaBlocks.register("cypress_flasks_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_POTS_CUPBOARD = IcariaBlocks.register("cypress_pots_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_VASE_CUPBOARD = IcariaBlocks.register("cypress_vase_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_KITCHEN_TABLE = IcariaBlocks.register("cypress_kitchen_table", KitchenTableBlock::new, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_KLINE = IcariaBlocks.register("cypress_kline", KlineBlock::new, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_CRAFTING_TABLE = IcariaBlocks.register("cypress_crafting_table", IcariaCraftingTableBlock::new, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_SCROLLSHELF = IcariaBlocks.register("cypress_scrollshelf", ScrollshelfBlock::new, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_DOOR = IcariaBlocks.register("cypress_door", properties -> new DoorBlock(IcariaBlockSetTypes.CYPRESS, properties), IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_TRAPDOOR = IcariaBlocks.register("cypress_trapdoor", properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.CYPRESS, properties), IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_PRESSURE_PLATE = IcariaBlocks.register("cypress_pressure_plate", properties -> new PressurePlateBlock(IcariaBlockSetTypes.CYPRESS, properties), IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_BUTTON = IcariaBlocks.register("cypress_button", properties -> new ButtonBlock(IcariaBlockSetTypes.CYPRESS, 30, properties), IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_LADDER = IcariaBlocks.register("cypress_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER));
	public static final DeferredHolder<Block, Block> CYPRESS_SIGN = IcariaBlocks.register("cypress_sign", properties -> new IcariaStandingSignBlock(IcariaWoodTypes.CYPRESS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_WALL_SIGN = IcariaBlocks.register("cypress_wall_sign", properties -> new IcariaWallSignBlock(IcariaWoodTypes.CYPRESS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_HANGING_SIGN = IcariaBlocks.register("cypress_hanging_sign", properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.CYPRESS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> CYPRESS_WALL_HANGING_SIGN = IcariaBlocks.register("cypress_wall_hanging_sign", properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.CYPRESS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> DROUGHTROOT_SAPLING = IcariaBlocks.register("droughtroot_sapling", properties -> new SaplingBlock(IcariaTreeGrowers.DROUGHTROOT, properties), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_DROUGHTROOT_SAPLING = IcariaBlocks.register("potted_droughtroot_sapling", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.DROUGHTROOT_SAPLING, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_LEAVES = IcariaBlocks.register("droughtroot_leaves", properties -> new IcariaLeavesBlock(5923354, properties), IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FALLEN_DROUGHTROOT_LEAVES = IcariaBlocks.register("fallen_droughtroot_leaves", LayerBlock::new, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TWIGS = IcariaBlocks.register("droughtroot_twigs", GroundDecoBlock::new, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FIREWOOD = IcariaBlocks.register("droughtroot_firewood", FirewoodBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FIREWOOD_WEDGE = IcariaBlocks.register("droughtroot_firewood_wedge", FirewoodWedgeBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_WOOD = IcariaBlocks.register("droughtroot_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DROUGHTROOT_WOOD = IcariaBlocks.register("stripped_droughtroot_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_LOG = IcariaBlocks.register("droughtroot_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DROUGHTROOT_LOG = IcariaBlocks.register("stripped_droughtroot_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DEAD_DROUGHTROOT_LOG = IcariaBlocks.register("dead_droughtroot_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_DROUGHTROOT_LOG = IcariaBlocks.register("stripped_dead_droughtroot_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_PLANKS = IcariaBlocks.register("droughtroot_planks", Block::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_STAIRS = IcariaBlocks.register("droughtroot_stairs", properties -> new IcariaStairBlock(IcariaBlocks.DROUGHTROOT_PLANKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SLAB = IcariaBlocks.register("droughtroot_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FENCE = IcariaBlocks.register("droughtroot_fence", IcariaFenceBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FENCE_GATE = IcariaBlocks.register("droughtroot_fence_gate", properties -> new FenceGateBlock(IcariaWoodTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> SIMPLE_DROUGHTROOT_RACK = IcariaBlocks.register("simple_droughtroot_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_RACK = IcariaBlocks.register("droughtroot_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BARREL = IcariaBlocks.register("droughtroot_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LOADED_DROUGHTROOT_BARREL = IcariaBlocks.register("loaded_droughtroot_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TAPPED_DROUGHTROOT_BARREL = IcariaBlocks.register("tapped_droughtroot_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TRIPLE_DROUGHTROOT_BARREL_RACK = IcariaBlocks.register("triple_droughtroot_barrel_rack", TripleBarrelRackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BATHTUB = IcariaBlocks.register("droughtroot_bathtub", BathtubBlock::new, IcariaBlocks.propertiesBathtub(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TROUGH = IcariaBlocks.register("droughtroot_trough", TroughBlock::new, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_STOOL = IcariaBlocks.register("droughtroot_stool", StoolBlock::new, IcariaBlocks.propertiesStool(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_HERB_HOLDER = IcariaBlocks.register("droughtroot_herb_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_PAN_HOLDER = IcariaBlocks.register("droughtroot_pan_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_POT_HOLDER = IcariaBlocks.register("droughtroot_pot_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SPOON_HOLDER = IcariaBlocks.register("droughtroot_spoon_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TOWEL_HOLDER = IcariaBlocks.register("droughtroot_towel_holder", TowelHolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_COUNTERTOP = IcariaBlocks.register("droughtroot_countertop", CandleCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FLOWER_POT_COUNTERTOP = IcariaBlocks.register("droughtroot_flower_pot_countertop", FlowerPotCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_MORTAR_COUNTERTOP = IcariaBlocks.register("droughtroot_mortar_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_POT_COUNTERTOP = IcariaBlocks.register("droughtroot_pot_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BASINS_COUNTERTOP = IcariaBlocks.register("droughtroot_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_RAISED_BASINS_COUNTERTOP = IcariaBlocks.register("droughtroot_raised_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_CUPBOARD = IcariaBlocks.register("droughtroot_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_DISHES_CUPBOARD = IcariaBlocks.register("droughtroot_dishes_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FLASKS_CUPBOARD = IcariaBlocks.register("droughtroot_flasks_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_POTS_CUPBOARD = IcariaBlocks.register("droughtroot_pots_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_VASE_CUPBOARD = IcariaBlocks.register("droughtroot_vase_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_KITCHEN_TABLE = IcariaBlocks.register("droughtroot_kitchen_table", KitchenTableBlock::new, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_KLINE = IcariaBlocks.register("droughtroot_kline", KlineBlock::new, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_CRAFTING_TABLE = IcariaBlocks.register("droughtroot_crafting_table", IcariaCraftingTableBlock::new, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SCROLLSHELF = IcariaBlocks.register("droughtroot_scrollshelf", ScrollshelfBlock::new, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_DOOR = IcariaBlocks.register("droughtroot_door", properties -> new DoorBlock(IcariaBlockSetTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TRAPDOOR = IcariaBlocks.register("droughtroot_trapdoor", properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_PRESSURE_PLATE = IcariaBlocks.register("droughtroot_pressure_plate", properties -> new PressurePlateBlock(IcariaBlockSetTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BUTTON = IcariaBlocks.register("droughtroot_button", properties -> new ButtonBlock(IcariaBlockSetTypes.DROUGHTROOT, 30, properties), IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_LADDER = IcariaBlocks.register("droughtroot_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SIGN = IcariaBlocks.register("droughtroot_sign", properties -> new IcariaStandingSignBlock(IcariaWoodTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_WALL_SIGN = IcariaBlocks.register("droughtroot_wall_sign", properties -> new IcariaWallSignBlock(IcariaWoodTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_HANGING_SIGN = IcariaBlocks.register("droughtroot_hanging_sign", properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_WALL_HANGING_SIGN = IcariaBlocks.register("droughtroot_wall_hanging_sign", properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.DROUGHTROOT, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> FIR_SAPLING = IcariaBlocks.register("fir_sapling", properties -> new SaplingBlock(IcariaTreeGrowers.FIR, properties), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_FIR_SAPLING = IcariaBlocks.register("potted_fir_sapling", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FIR_SAPLING, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> FIR_LEAVES = IcariaBlocks.register("fir_leaves", properties -> new IcariaLeavesBlock(3498818, properties), IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FALLEN_FIR_LEAVES = IcariaBlocks.register("fallen_fir_leaves", LayerBlock::new, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FIR_TWIGS = IcariaBlocks.register("fir_twigs", GroundDecoBlock::new, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_FIREWOOD = IcariaBlocks.register("fir_firewood", FirewoodBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_FIREWOOD_WEDGE = IcariaBlocks.register("fir_firewood_wedge", FirewoodWedgeBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_WOOD = IcariaBlocks.register("fir_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_FIR_WOOD = IcariaBlocks.register("stripped_fir_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_LOG = IcariaBlocks.register("fir_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_FIR_LOG = IcariaBlocks.register("stripped_fir_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DEAD_FIR_LOG = IcariaBlocks.register("dead_fir_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_FIR_LOG = IcariaBlocks.register("stripped_dead_fir_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_PLANKS = IcariaBlocks.register("fir_planks", Block::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_STAIRS = IcariaBlocks.register("fir_stairs", properties -> new IcariaStairBlock(IcariaBlocks.FIR_PLANKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_SLAB = IcariaBlocks.register("fir_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_FENCE = IcariaBlocks.register("fir_fence", IcariaFenceBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_FENCE_GATE = IcariaBlocks.register("fir_fence_gate", properties -> new FenceGateBlock(IcariaWoodTypes.FIR, properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> SIMPLE_FIR_RACK = IcariaBlocks.register("simple_fir_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_RACK = IcariaBlocks.register("fir_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_BARREL = IcariaBlocks.register("fir_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LOADED_FIR_BARREL = IcariaBlocks.register("loaded_fir_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TAPPED_FIR_BARREL = IcariaBlocks.register("tapped_fir_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TRIPLE_FIR_BARREL_RACK = IcariaBlocks.register("triple_fir_barrel_rack", TripleBarrelRackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> FIR_BATHTUB = IcariaBlocks.register("fir_bathtub", BathtubBlock::new, IcariaBlocks.propertiesBathtub(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_TROUGH = IcariaBlocks.register("fir_trough", TroughBlock::new, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_STOOL = IcariaBlocks.register("fir_stool", StoolBlock::new, IcariaBlocks.propertiesStool(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_HERB_HOLDER = IcariaBlocks.register("fir_herb_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_PAN_HOLDER = IcariaBlocks.register("fir_pan_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_POT_HOLDER = IcariaBlocks.register("fir_pot_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_SPOON_HOLDER = IcariaBlocks.register("fir_spoon_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_TOWEL_HOLDER = IcariaBlocks.register("fir_towel_holder", TowelHolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_COUNTERTOP = IcariaBlocks.register("fir_countertop", CandleCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_FLOWER_POT_COUNTERTOP = IcariaBlocks.register("fir_flower_pot_countertop", FlowerPotCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_MORTAR_COUNTERTOP = IcariaBlocks.register("fir_mortar_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_POT_COUNTERTOP = IcariaBlocks.register("fir_pot_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_BASINS_COUNTERTOP = IcariaBlocks.register("fir_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_RAISED_BASINS_COUNTERTOP = IcariaBlocks.register("fir_raised_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_CUPBOARD = IcariaBlocks.register("fir_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_DISHES_CUPBOARD = IcariaBlocks.register("fir_dishes_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_FLASKS_CUPBOARD = IcariaBlocks.register("fir_flasks_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_POTS_CUPBOARD = IcariaBlocks.register("fir_pots_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_VASE_CUPBOARD = IcariaBlocks.register("fir_vase_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_KITCHEN_TABLE = IcariaBlocks.register("fir_kitchen_table", KitchenTableBlock::new, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_KLINE = IcariaBlocks.register("fir_kline", KlineBlock::new, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_CRAFTING_TABLE = IcariaBlocks.register("fir_crafting_table", IcariaCraftingTableBlock::new, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_SCROLLSHELF = IcariaBlocks.register("fir_scrollshelf", ScrollshelfBlock::new, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_DOOR = IcariaBlocks.register("fir_door", properties -> new DoorBlock(IcariaBlockSetTypes.FIR, properties), IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_TRAPDOOR = IcariaBlocks.register("fir_trapdoor", properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.FIR, properties), IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_PRESSURE_PLATE = IcariaBlocks.register("fir_pressure_plate", properties -> new PressurePlateBlock(IcariaBlockSetTypes.FIR, properties), IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_BUTTON = IcariaBlocks.register("fir_button", properties -> new ButtonBlock(IcariaBlockSetTypes.FIR, 30, properties), IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_LADDER = IcariaBlocks.register("fir_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER));
	public static final DeferredHolder<Block, Block> FIR_SIGN = IcariaBlocks.register("fir_sign", properties -> new IcariaStandingSignBlock(IcariaWoodTypes.FIR, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_WALL_SIGN = IcariaBlocks.register("fir_wall_sign", properties -> new IcariaWallSignBlock(IcariaWoodTypes.FIR, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_HANGING_SIGN = IcariaBlocks.register("fir_hanging_sign", properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.FIR, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> FIR_WALL_HANGING_SIGN = IcariaBlocks.register("fir_wall_hanging_sign", properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.FIR, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> LAUREL_SAPLING = IcariaBlocks.register("laurel_sapling", properties -> new SaplingBlock(IcariaTreeGrowers.LAUREL, properties), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_LAUREL_SAPLING = IcariaBlocks.register("potted_laurel_sapling", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LAUREL_SAPLING, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LAUREL_LEAVES = IcariaBlocks.register("laurel_leaves", properties -> new IcariaLeavesBlock(4347162, properties), IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FALLEN_LAUREL_LEAVES = IcariaBlocks.register("fallen_laurel_leaves", LayerBlock::new, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> LAUREL_TWIGS = IcariaBlocks.register("laurel_twigs", GroundDecoBlock::new, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_FIREWOOD = IcariaBlocks.register("laurel_firewood", FirewoodBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_FIREWOOD_WEDGE = IcariaBlocks.register("laurel_firewood_wedge", FirewoodWedgeBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_WOOD = IcariaBlocks.register("laurel_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_LAUREL_WOOD = IcariaBlocks.register("stripped_laurel_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_LOG = IcariaBlocks.register("laurel_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_LAUREL_LOG = IcariaBlocks.register("stripped_laurel_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DEAD_LAUREL_LOG = IcariaBlocks.register("dead_laurel_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_LAUREL_LOG = IcariaBlocks.register("stripped_dead_laurel_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_PLANKS = IcariaBlocks.register("laurel_planks", Block::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_STAIRS = IcariaBlocks.register("laurel_stairs", properties -> new IcariaStairBlock(IcariaBlocks.LAUREL_PLANKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_SLAB = IcariaBlocks.register("laurel_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_FENCE = IcariaBlocks.register("laurel_fence", IcariaFenceBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_FENCE_GATE = IcariaBlocks.register("laurel_fence_gate", properties -> new FenceGateBlock(IcariaWoodTypes.LAUREL, properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> SIMPLE_LAUREL_RACK = IcariaBlocks.register("simple_laurel_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_RACK = IcariaBlocks.register("laurel_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_BARREL = IcariaBlocks.register("laurel_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LOADED_LAUREL_BARREL = IcariaBlocks.register("loaded_laurel_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TAPPED_LAUREL_BARREL = IcariaBlocks.register("tapped_laurel_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TRIPLE_LAUREL_BARREL_RACK = IcariaBlocks.register("triple_laurel_barrel_rack", TripleBarrelRackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LAUREL_BATHTUB = IcariaBlocks.register("laurel_bathtub", BathtubBlock::new, IcariaBlocks.propertiesBathtub(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_TROUGH = IcariaBlocks.register("laurel_trough", TroughBlock::new, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_STOOL = IcariaBlocks.register("laurel_stool", StoolBlock::new, IcariaBlocks.propertiesStool(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_HERB_HOLDER = IcariaBlocks.register("laurel_herb_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_PAN_HOLDER = IcariaBlocks.register("laurel_pan_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_POT_HOLDER = IcariaBlocks.register("laurel_pot_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_SPOON_HOLDER = IcariaBlocks.register("laurel_spoon_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_TOWEL_HOLDER = IcariaBlocks.register("laurel_towel_holder", TowelHolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_COUNTERTOP = IcariaBlocks.register("laurel_countertop", CandleCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_FLOWER_POT_COUNTERTOP = IcariaBlocks.register("laurel_flower_pot_countertop", FlowerPotCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_MORTAR_COUNTERTOP = IcariaBlocks.register("laurel_mortar_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_POT_COUNTERTOP = IcariaBlocks.register("laurel_pot_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_BASINS_COUNTERTOP = IcariaBlocks.register("laurel_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_RAISED_BASINS_COUNTERTOP = IcariaBlocks.register("laurel_raised_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_CUPBOARD = IcariaBlocks.register("laurel_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_DISHES_CUPBOARD = IcariaBlocks.register("laurel_dishes_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_FLASKS_CUPBOARD = IcariaBlocks.register("laurel_flasks_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_POTS_CUPBOARD = IcariaBlocks.register("laurel_pots_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_VASE_CUPBOARD = IcariaBlocks.register("laurel_vase_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_KITCHEN_TABLE = IcariaBlocks.register("laurel_kitchen_table", KitchenTableBlock::new, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_KLINE = IcariaBlocks.register("laurel_kline", KlineBlock::new, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_CRAFTING_TABLE = IcariaBlocks.register("laurel_crafting_table", IcariaCraftingTableBlock::new, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_SCROLLSHELF = IcariaBlocks.register("laurel_scrollshelf", ScrollshelfBlock::new, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_DOOR = IcariaBlocks.register("laurel_door", properties -> new DoorBlock(IcariaBlockSetTypes.LAUREL, properties), IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_TRAPDOOR = IcariaBlocks.register("laurel_trapdoor", properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.LAUREL, properties), IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_PRESSURE_PLATE = IcariaBlocks.register("laurel_pressure_plate", properties -> new PressurePlateBlock(IcariaBlockSetTypes.LAUREL, properties), IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_BUTTON = IcariaBlocks.register("laurel_button", properties -> new ButtonBlock(IcariaBlockSetTypes.LAUREL, 30, properties), IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_LADDER = IcariaBlocks.register("laurel_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER));
	public static final DeferredHolder<Block, Block> LAUREL_SIGN = IcariaBlocks.register("laurel_sign", properties -> new IcariaStandingSignBlock(IcariaWoodTypes.LAUREL, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_WALL_SIGN = IcariaBlocks.register("laurel_wall_sign", properties -> new IcariaWallSignBlock(IcariaWoodTypes.LAUREL, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_HANGING_SIGN = IcariaBlocks.register("laurel_hanging_sign", properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.LAUREL, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> LAUREL_WALL_HANGING_SIGN = IcariaBlocks.register("laurel_wall_hanging_sign", properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.LAUREL, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> OLIVE_SAPLING = IcariaBlocks.register("olive_sapling", properties -> new SaplingBlock(IcariaTreeGrowers.OLIVE, properties), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_OLIVE_SAPLING = IcariaBlocks.register("potted_olive_sapling", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.OLIVE_SAPLING, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> OLIVE_LEAVES = IcariaBlocks.register("olive_leaves", properties -> new OliveLeavesBlock(8485426, properties), IcariaBlocks.propertiesLeaves(MapColor.COLOR_YELLOW, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FALLEN_OLIVE_LEAVES = IcariaBlocks.register("fallen_olive_leaves", LayerBlock::new, IcariaBlocks.propertiesLeaves(MapColor.COLOR_YELLOW, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> OLIVE_TWIGS = IcariaBlocks.register("olive_twigs", GroundDecoBlock::new, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_FIREWOOD = IcariaBlocks.register("olive_firewood", FirewoodBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_FIREWOOD_WEDGE = IcariaBlocks.register("olive_firewood_wedge", FirewoodWedgeBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_WOOD = IcariaBlocks.register("olive_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_OLIVE_WOOD = IcariaBlocks.register("stripped_olive_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_LOG = IcariaBlocks.register("olive_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_OLIVE_LOG = IcariaBlocks.register("stripped_olive_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DEAD_OLIVE_LOG = IcariaBlocks.register("dead_olive_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_OLIVE_LOG = IcariaBlocks.register("stripped_dead_olive_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_PLANKS = IcariaBlocks.register("olive_planks", Block::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_STAIRS = IcariaBlocks.register("olive_stairs", properties -> new IcariaStairBlock(IcariaBlocks.OLIVE_PLANKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_SLAB = IcariaBlocks.register("olive_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_FENCE = IcariaBlocks.register("olive_fence", IcariaFenceBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_FENCE_GATE = IcariaBlocks.register("olive_fence_gate", properties -> new FenceGateBlock(IcariaWoodTypes.OLIVE, properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> SIMPLE_OLIVE_RACK = IcariaBlocks.register("simple_olive_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_RACK = IcariaBlocks.register("olive_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_BARREL = IcariaBlocks.register("olive_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LOADED_OLIVE_BARREL = IcariaBlocks.register("loaded_olive_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TAPPED_OLIVE_BARREL = IcariaBlocks.register("tapped_olive_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TRIPLE_OLIVE_BARREL_RACK = IcariaBlocks.register("triple_olive_barrel_rack", TripleBarrelRackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> OLIVE_BATHTUB = IcariaBlocks.register("olive_bathtub", BathtubBlock::new, IcariaBlocks.propertiesBathtub(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_TROUGH = IcariaBlocks.register("olive_trough", TroughBlock::new, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_STOOL = IcariaBlocks.register("olive_stool", StoolBlock::new, IcariaBlocks.propertiesStool(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_HERB_HOLDER = IcariaBlocks.register("olive_herb_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_PAN_HOLDER = IcariaBlocks.register("olive_pan_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_POT_HOLDER = IcariaBlocks.register("olive_pot_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_SPOON_HOLDER = IcariaBlocks.register("olive_spoon_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_TOWEL_HOLDER = IcariaBlocks.register("olive_towel_holder", TowelHolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_COUNTERTOP = IcariaBlocks.register("olive_countertop", CandleCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_FLOWER_POT_COUNTERTOP = IcariaBlocks.register("olive_flower_pot_countertop", FlowerPotCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_MORTAR_COUNTERTOP = IcariaBlocks.register("olive_mortar_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_POT_COUNTERTOP = IcariaBlocks.register("olive_pot_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_BASINS_COUNTERTOP = IcariaBlocks.register("olive_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_RAISED_BASINS_COUNTERTOP = IcariaBlocks.register("olive_raised_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_CUPBOARD = IcariaBlocks.register("olive_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_DISHES_CUPBOARD = IcariaBlocks.register("olive_dishes_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_FLASKS_CUPBOARD = IcariaBlocks.register("olive_flasks_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_POTS_CUPBOARD = IcariaBlocks.register("olive_pots_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_VASE_CUPBOARD = IcariaBlocks.register("olive_vase_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_KITCHEN_TABLE = IcariaBlocks.register("olive_kitchen_table", KitchenTableBlock::new, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_KLINE = IcariaBlocks.register("olive_kline", KlineBlock::new, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_CRAFTING_TABLE = IcariaBlocks.register("olive_crafting_table", IcariaCraftingTableBlock::new, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_SCROLLSHELF = IcariaBlocks.register("olive_scrollshelf", ScrollshelfBlock::new, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_DOOR = IcariaBlocks.register("olive_door", properties -> new DoorBlock(IcariaBlockSetTypes.OLIVE, properties), IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_TRAPDOOR = IcariaBlocks.register("olive_trapdoor", properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.OLIVE, properties), IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_PRESSURE_PLATE = IcariaBlocks.register("olive_pressure_plate", properties -> new PressurePlateBlock(IcariaBlockSetTypes.OLIVE, properties), IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_BUTTON = IcariaBlocks.register("olive_button", properties -> new ButtonBlock(IcariaBlockSetTypes.OLIVE, 30, properties), IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_LADDER = IcariaBlocks.register("olive_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER));
	public static final DeferredHolder<Block, Block> OLIVE_SIGN = IcariaBlocks.register("olive_sign", properties -> new IcariaStandingSignBlock(IcariaWoodTypes.OLIVE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_WALL_SIGN = IcariaBlocks.register("olive_wall_sign", properties -> new IcariaWallSignBlock(IcariaWoodTypes.OLIVE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_HANGING_SIGN = IcariaBlocks.register("olive_hanging_sign", properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.OLIVE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> OLIVE_WALL_HANGING_SIGN = IcariaBlocks.register("olive_wall_hanging_sign", properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.OLIVE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> PLANE_SAPLING = IcariaBlocks.register("plane_sapling", properties -> new SaplingBlock(IcariaTreeGrowers.PLANE, properties), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PLANE_SAPLING = IcariaBlocks.register("potted_plane_sapling", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PLANE_SAPLING, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PLANE_LEAVES = IcariaBlocks.register("plane_leaves", properties -> new IcariaLeavesBlock(5336128, properties), IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FALLEN_PLANE_LEAVES = IcariaBlocks.register("fallen_plane_leaves", LayerBlock::new, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> PLANE_TWIGS = IcariaBlocks.register("plane_twigs", GroundDecoBlock::new, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_FIREWOOD = IcariaBlocks.register("plane_firewood", FirewoodBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_FIREWOOD_WEDGE = IcariaBlocks.register("plane_firewood_wedge", FirewoodWedgeBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_WOOD = IcariaBlocks.register("plane_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_PLANE_WOOD = IcariaBlocks.register("stripped_plane_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_LOG = IcariaBlocks.register("plane_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_PLANE_LOG = IcariaBlocks.register("stripped_plane_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DEAD_PLANE_LOG = IcariaBlocks.register("dead_plane_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_PLANE_LOG = IcariaBlocks.register("stripped_dead_plane_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_PLANKS = IcariaBlocks.register("plane_planks", Block::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_STAIRS = IcariaBlocks.register("plane_stairs", properties -> new IcariaStairBlock(IcariaBlocks.PLANE_PLANKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_SLAB = IcariaBlocks.register("plane_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_FENCE = IcariaBlocks.register("plane_fence", IcariaFenceBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_FENCE_GATE = IcariaBlocks.register("plane_fence_gate", properties -> new FenceGateBlock(IcariaWoodTypes.PLANE, properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> SIMPLE_PLANE_RACK = IcariaBlocks.register("simple_plane_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_RACK = IcariaBlocks.register("plane_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_BARREL = IcariaBlocks.register("plane_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LOADED_PLANE_BARREL = IcariaBlocks.register("loaded_plane_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TAPPED_PLANE_BARREL = IcariaBlocks.register("tapped_plane_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TRIPLE_PLANE_BARREL_RACK = IcariaBlocks.register("triple_plane_barrel_rack", TripleBarrelRackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> PLANE_BATHTUB = IcariaBlocks.register("plane_bathtub", BathtubBlock::new, IcariaBlocks.propertiesBathtub(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_TROUGH = IcariaBlocks.register("plane_trough", TroughBlock::new, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_STOOL = IcariaBlocks.register("plane_stool", StoolBlock::new, IcariaBlocks.propertiesStool(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_HERB_HOLDER = IcariaBlocks.register("plane_herb_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_PAN_HOLDER = IcariaBlocks.register("plane_pan_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_POT_HOLDER = IcariaBlocks.register("plane_pot_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_SPOON_HOLDER = IcariaBlocks.register("plane_spoon_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_TOWEL_HOLDER = IcariaBlocks.register("plane_towel_holder", TowelHolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_COUNTERTOP = IcariaBlocks.register("plane_countertop", CandleCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_FLOWER_POT_COUNTERTOP = IcariaBlocks.register("plane_flower_pot_countertop", FlowerPotCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_MORTAR_COUNTERTOP = IcariaBlocks.register("plane_mortar_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_POT_COUNTERTOP = IcariaBlocks.register("plane_pot_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_BASINS_COUNTERTOP = IcariaBlocks.register("plane_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_RAISED_BASINS_COUNTERTOP = IcariaBlocks.register("plane_raised_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_CUPBOARD = IcariaBlocks.register("plane_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_DISHES_CUPBOARD = IcariaBlocks.register("plane_dishes_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_FLASKS_CUPBOARD = IcariaBlocks.register("plane_flasks_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_POTS_CUPBOARD = IcariaBlocks.register("plane_pots_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_VASE_CUPBOARD = IcariaBlocks.register("plane_vase_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_KITCHEN_TABLE = IcariaBlocks.register("plane_kitchen_table", KitchenTableBlock::new, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_KLINE = IcariaBlocks.register("plane_kline", KlineBlock::new, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_CRAFTING_TABLE = IcariaBlocks.register("plane_crafting_table", IcariaCraftingTableBlock::new, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_SCROLLSHELF = IcariaBlocks.register("plane_scrollshelf", ScrollshelfBlock::new, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_DOOR = IcariaBlocks.register("plane_door", properties -> new DoorBlock(IcariaBlockSetTypes.PLANE, properties), IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_TRAPDOOR = IcariaBlocks.register("plane_trapdoor", properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.PLANE, properties), IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_PRESSURE_PLATE = IcariaBlocks.register("plane_pressure_plate", properties -> new PressurePlateBlock(IcariaBlockSetTypes.PLANE, properties), IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_BUTTON = IcariaBlocks.register("plane_button", properties -> new ButtonBlock(IcariaBlockSetTypes.PLANE, 30, properties), IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_LADDER = IcariaBlocks.register("plane_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER));
	public static final DeferredHolder<Block, Block> PLANE_SIGN = IcariaBlocks.register("plane_sign", properties -> new IcariaStandingSignBlock(IcariaWoodTypes.PLANE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_WALL_SIGN = IcariaBlocks.register("plane_wall_sign", properties -> new IcariaWallSignBlock(IcariaWoodTypes.PLANE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_HANGING_SIGN = IcariaBlocks.register("plane_hanging_sign", properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.PLANE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> PLANE_WALL_HANGING_SIGN = IcariaBlocks.register("plane_wall_hanging_sign", properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.PLANE, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> POPULUS_SAPLING = IcariaBlocks.register("populus_sapling", properties -> new SaplingBlock(IcariaTreeGrowers.POPULUS, properties), IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_POPULUS_SAPLING = IcariaBlocks.register("potted_populus_sapling", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.POPULUS_SAPLING, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> POPULUS_LEAVES = IcariaBlocks.register("populus_leaves", properties -> new IcariaLeavesBlock(4948832, properties), IcariaBlocks.propertiesLeaves(MapColor.GLOW_LICHEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> FALLEN_POPULUS_LEAVES = IcariaBlocks.register("fallen_populus_leaves", LayerBlock::new, IcariaBlocks.propertiesLeaves(MapColor.GLOW_LICHEN, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POPULUS_TWIGS = IcariaBlocks.register("populus_twigs", GroundDecoBlock::new, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_FIREWOOD = IcariaBlocks.register("populus_firewood", FirewoodBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_FIREWOOD_WEDGE = IcariaBlocks.register("populus_firewood_wedge", FirewoodWedgeBlock::new, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_WOOD = IcariaBlocks.register("populus_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_POPULUS_WOOD = IcariaBlocks.register("stripped_populus_wood", RotatedPillarBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_LOG = IcariaBlocks.register("populus_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_POPULUS_LOG = IcariaBlocks.register("stripped_populus_log", IcariaLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> DEAD_POPULUS_LOG = IcariaBlocks.register("dead_populus_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_POPULUS_LOG = IcariaBlocks.register("stripped_dead_populus_log", DeadLogBlock::new, IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_PLANKS = IcariaBlocks.register("populus_planks", Block::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_STAIRS = IcariaBlocks.register("populus_stairs", properties -> new IcariaStairBlock(IcariaBlocks.POPULUS_PLANKS.get().defaultBlockState(), properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_SLAB = IcariaBlocks.register("populus_slab", IcariaSlabBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_FENCE = IcariaBlocks.register("populus_fence", IcariaFenceBlock::new, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_FENCE_GATE = IcariaBlocks.register("populus_fence_gate", properties -> new FenceGateBlock(IcariaWoodTypes.POPULUS, properties), IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> SIMPLE_POPULUS_RACK = IcariaBlocks.register("simple_populus_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_RACK = IcariaBlocks.register("populus_rack", RackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_BARREL = IcariaBlocks.register("populus_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> LOADED_POPULUS_BARREL = IcariaBlocks.register("loaded_populus_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TAPPED_POPULUS_BARREL = IcariaBlocks.register("tapped_populus_barrel", IcariaBarrelBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> TRIPLE_POPULUS_BARREL_RACK = IcariaBlocks.register("triple_populus_barrel_rack", TripleBarrelRackBlock::new, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL));
	public static final DeferredHolder<Block, Block> POPULUS_BATHTUB = IcariaBlocks.register("populus_bathtub", BathtubBlock::new, IcariaBlocks.propertiesBathtub(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_TROUGH = IcariaBlocks.register("populus_trough", TroughBlock::new, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_STOOL = IcariaBlocks.register("populus_stool", StoolBlock::new, IcariaBlocks.propertiesStool(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_HERB_HOLDER = IcariaBlocks.register("populus_herb_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_PAN_HOLDER = IcariaBlocks.register("populus_pan_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_POT_HOLDER = IcariaBlocks.register("populus_pot_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_SPOON_HOLDER = IcariaBlocks.register("populus_spoon_holder", HolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_TOWEL_HOLDER = IcariaBlocks.register("populus_towel_holder", TowelHolderBlock::new, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_COUNTERTOP = IcariaBlocks.register("populus_countertop", CandleCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_FLOWER_POT_COUNTERTOP = IcariaBlocks.register("populus_flower_pot_countertop", FlowerPotCountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_MORTAR_COUNTERTOP = IcariaBlocks.register("populus_mortar_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_POT_COUNTERTOP = IcariaBlocks.register("populus_pot_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_BASINS_COUNTERTOP = IcariaBlocks.register("populus_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_RAISED_BASINS_COUNTERTOP = IcariaBlocks.register("populus_raised_basins_countertop", CountertopBlock::new, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_CUPBOARD = IcariaBlocks.register("populus_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_DISHES_CUPBOARD = IcariaBlocks.register("populus_dishes_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_FLASKS_CUPBOARD = IcariaBlocks.register("populus_flasks_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_POTS_CUPBOARD = IcariaBlocks.register("populus_pots_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_VASE_CUPBOARD = IcariaBlocks.register("populus_vase_cupboard", CupboardBlock::new, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_KITCHEN_TABLE = IcariaBlocks.register("populus_kitchen_table", KitchenTableBlock::new, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_KLINE = IcariaBlocks.register("populus_kline", KlineBlock::new, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_CRAFTING_TABLE = IcariaBlocks.register("populus_crafting_table", IcariaCraftingTableBlock::new, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_SCROLLSHELF = IcariaBlocks.register("populus_scrollshelf", ScrollshelfBlock::new, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_DOOR = IcariaBlocks.register("populus_door", properties -> new DoorBlock(IcariaBlockSetTypes.POPULUS, properties), IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_TRAPDOOR = IcariaBlocks.register("populus_trapdoor", properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.POPULUS, properties), IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_YELLOW, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_PRESSURE_PLATE = IcariaBlocks.register("populus_pressure_plate", properties -> new PressurePlateBlock(IcariaBlockSetTypes.POPULUS, properties), IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_GREEN, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_BUTTON = IcariaBlocks.register("populus_button", properties -> new ButtonBlock(IcariaBlockSetTypes.POPULUS, 30, properties), IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_LADDER = IcariaBlocks.register("populus_ladder", IcariaLadderBlock::new, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER));
	public static final DeferredHolder<Block, Block> POPULUS_SIGN = IcariaBlocks.register("populus_sign", properties -> new IcariaStandingSignBlock(IcariaWoodTypes.POPULUS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_WALL_SIGN = IcariaBlocks.register("populus_wall_sign", properties -> new IcariaWallSignBlock(IcariaWoodTypes.POPULUS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_HANGING_SIGN = IcariaBlocks.register("populus_hanging_sign", properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.POPULUS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));
	public static final DeferredHolder<Block, Block> POPULUS_WALL_HANGING_SIGN = IcariaBlocks.register("populus_wall_hanging_sign", properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.POPULUS, properties), IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD));

	public static final DeferredHolder<Block, Block> BLOOMY_VINE = IcariaBlocks.register("bloomy_vine", IcariaVineBlock::new, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE));
	public static final DeferredHolder<Block, Block> BRANCHY_VINE = IcariaBlocks.register("branchy_vine", IcariaVineBlock::new, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE));
	public static final DeferredHolder<Block, Block> BRUSHY_VINE = IcariaBlocks.register("brushy_vine", IcariaVineBlock::new, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE));
	public static final DeferredHolder<Block, Block> DRY_VINE = IcariaBlocks.register("dry_vine", IcariaVineBlock::new, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE));
	public static final DeferredHolder<Block, Block> REEDY_VINE = IcariaBlocks.register("reedy_vine", IcariaVineBlock::new, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE));
	public static final DeferredHolder<Block, Block> SWIRLY_VINE = IcariaBlocks.register("swirly_vine", IcariaVineBlock::new, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE));
	public static final DeferredHolder<Block, Block> THORNY_VINE = IcariaBlocks.register("thorny_vine", IcariaVineBlock::new, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE));

	public static final DeferredHolder<Block, Block> FERN = IcariaBlocks.register("fern", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_FERN = IcariaBlocks.register("potted_fern", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FERN, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> SMALL_GRASS = IcariaBlocks.register("small_grass", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MEDIUM_GRASS = IcariaBlocks.register("medium_grass", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> LARGE_GRASS = IcariaBlocks.register("large_grass", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));

	public static final DeferredHolder<Block, Block> SMALL_MIXED_GRAIN = IcariaBlocks.register("small_mixed_grain", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MEDIUM_MIXED_GRAIN = IcariaBlocks.register("medium_mixed_grain", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MEDIUM_BROWN_GRAIN = IcariaBlocks.register("medium_brown_grain", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MEDIUM_WHITE_GRAIN = IcariaBlocks.register("medium_white_grain", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MEDIUM_YELLOW_GRAIN = IcariaBlocks.register("medium_yellow_grain", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> LARGE_BROWN_GRAIN = IcariaBlocks.register("large_brown_grain", IcariaBushBlock::new, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS));

	public static final DeferredHolder<Block, Block> BLINDWEED = IcariaBlocks.register("blindweed", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_BLINDWEED = IcariaBlocks.register("potted_blindweed", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLINDWEED, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHAMEOMILE = IcariaBlocks.register("chameomile", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_CHAMEOMILE = IcariaBlocks.register("potted_chameomile", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CHAMEOMILE, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CHARMONDER = IcariaBlocks.register("charmonder", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_CHARMONDER = IcariaBlocks.register("potted_charmonder", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CHARMONDER, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> CLOVER = IcariaBlocks.register("clover", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_CLOVER = IcariaBlocks.register("potted_clover", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CLOVER, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> FIREHILT = IcariaBlocks.register("firehilt", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_FIREHILT = IcariaBlocks.register("potted_firehilt", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FIREHILT, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BLUE_HYDRACINTH = IcariaBlocks.register("blue_hydracinth", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_BLUE_HYDRACINTH = IcariaBlocks.register("potted_blue_hydracinth", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLUE_HYDRACINTH, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PURPLE_HYDRACINTH = IcariaBlocks.register("purple_hydracinth", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_HYDRACINTH = IcariaBlocks.register("potted_purple_hydracinth", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_HYDRACINTH, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LIONFANGS = IcariaBlocks.register("lionfangs", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_LIONFANGS = IcariaBlocks.register("potted_lionfangs", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LIONFANGS, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SPEARDROPS = IcariaBlocks.register("speardrops", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_SPEARDROPS = IcariaBlocks.register("potted_speardrops", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SPEARDROPS, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PURPLE_STAGHORN = IcariaBlocks.register("purple_staghorn", DamagingBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_STAGHORN = IcariaBlocks.register("potted_purple_staghorn", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_STAGHORN, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> YELLOW_STAGHORN = IcariaBlocks.register("yellow_staghorn", DamagingBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_YELLOW_STAGHORN = IcariaBlocks.register("potted_yellow_staghorn", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.YELLOW_STAGHORN, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BLUE_STORMCOTTON = IcariaBlocks.register("blue_stormcotton", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_BLUE_STORMCOTTON = IcariaBlocks.register("potted_blue_stormcotton", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLUE_STORMCOTTON, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PINK_STORMCOTTON = IcariaBlocks.register("pink_stormcotton", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PINK_STORMCOTTON = IcariaBlocks.register("potted_pink_stormcotton", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PINK_STORMCOTTON, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PURPLE_STORMCOTTON = IcariaBlocks.register("purple_stormcotton", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_STORMCOTTON = IcariaBlocks.register("potted_purple_stormcotton", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_STORMCOTTON, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNKETTLE = IcariaBlocks.register("sunkettle", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_SUNKETTLE = IcariaBlocks.register("potted_sunkettle", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SUNKETTLE, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> SUNSPONGE = IcariaBlocks.register("sunsponge", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_SUNSPONGE = IcariaBlocks.register("potted_sunsponge", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SUNSPONGE, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> VOIDLILY = IcariaBlocks.register("voidlily", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_VOIDLILY = IcariaBlocks.register("potted_voidlily", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.VOIDLILY, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> BOLBOS = IcariaBlocks.register("bolbos", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> DATHULLA = IcariaBlocks.register("dathulla", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MONDANOS = IcariaBlocks.register("mondanos", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> MOTH_AGARIC = IcariaBlocks.register("moth_agaric", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> NAMDRAKE = IcariaBlocks.register("namdrake", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> PSILOCYBOS = IcariaBlocks.register("psilocybos", WaterloggedBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> ROWAN = IcariaBlocks.register("rowan", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> WILTED_ELM = IcariaBlocks.register("wilted_elm", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));

	public static final DeferredHolder<Block, Block> BLUE_GROUND_FLOWERS = IcariaBlocks.register("blue_ground_flowers", FlowerBedBlock::new, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS));
	public static final DeferredHolder<Block, Block> CYAN_GROUND_FLOWERS = IcariaBlocks.register("cyan_ground_flowers", FlowerBedBlock::new, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS));
	public static final DeferredHolder<Block, Block> PINK_GROUND_FLOWERS = IcariaBlocks.register("pink_ground_flowers", FlowerBedBlock::new, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS));
	public static final DeferredHolder<Block, Block> PURPLE_GROUND_FLOWERS = IcariaBlocks.register("purple_ground_flowers", FlowerBedBlock::new, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS));
	public static final DeferredHolder<Block, Block> RED_GROUND_FLOWERS = IcariaBlocks.register("red_ground_flowers", FlowerBedBlock::new, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS));
	public static final DeferredHolder<Block, Block> WHITE_GROUND_FLOWERS = IcariaBlocks.register("white_ground_flowers", FlowerBedBlock::new, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS));

	public static final DeferredHolder<Block, Block> FOREST_MOSS = IcariaBlocks.register("forest_moss", LayerBlock::new, IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS));
	public static final DeferredHolder<Block, Block> SCRUBLAND_MOSS = IcariaBlocks.register("scrubland_moss", LayerBlock::new, IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS));
	public static final DeferredHolder<Block, Block> STEPPE_MOSS = IcariaBlocks.register("steppe_moss", LayerBlock::new, IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS));

	public static final DeferredHolder<Block, Block> PALM_FERN = IcariaBlocks.register("palm_fern", IcariaBushBlock::new, IcariaBlocks.propertiesPalmFern(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PALM_FERN = IcariaBlocks.register("potted_palm_fern", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PALM_FERN, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> WHITE_BROMELIA = IcariaBlocks.register("white_bromelia", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_WHITE_BROMELIA = IcariaBlocks.register("potted_white_bromelia", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.WHITE_BROMELIA, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> ORANGE_BROMELIA = IcariaBlocks.register("orange_bromelia", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_ORANGE_BROMELIA = IcariaBlocks.register("potted_orange_bromelia", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.ORANGE_BROMELIA, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PINK_BROMELIA = IcariaBlocks.register("pink_bromelia", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PINK_BROMELIA = IcariaBlocks.register("potted_pink_bromelia", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PINK_BROMELIA, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> PURPLE_BROMELIA = IcariaBlocks.register("purple_bromelia", IcariaBushBlock::new, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_BROMELIA = IcariaBlocks.register("potted_purple_bromelia", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_BROMELIA, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> GREEN_GROUND_SHROOMS = IcariaBlocks.register("green_ground_shrooms", GroundShroomBlock::new, IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_GREEN_GROUND_SHROOMS = IcariaBlocks.register("potted_green_ground_shrooms", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.GREEN_GROUND_SHROOMS, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> BROWN_GROUND_SHROOMS = IcariaBlocks.register("brown_ground_shrooms", GroundShroomBlock::new, IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_BROWN_GROUND_SHROOMS = IcariaBlocks.register("potted_brown_ground_shrooms", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BROWN_GROUND_SHROOMS, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));
	public static final DeferredHolder<Block, Block> LARGE_BROWN_GROUND_SHROOMS = IcariaBlocks.register("large_brown_ground_shrooms", GroundShroomBlock::new, IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> POTTED_LARGE_BROWN_GROUND_SHROOMS = IcariaBlocks.register("potted_large_brown_ground_shrooms", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> TINDER_FUNGUS_TREE_SHROOMS = IcariaBlocks.register("tinder_fungus_tree_shrooms", TreeShroomBlock::new, IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> TURKEY_TAIL_TREE_SHROOMS = IcariaBlocks.register("turkey_tail_tree_shrooms", TreeShroomBlock::new, IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS));
	public static final DeferredHolder<Block, Block> UNNAMED_TREE_SHROOMS = IcariaBlocks.register("unnamed_tree_shrooms", TreeShroomBlock::new, IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS));

	public static final DeferredHolder<Block, Block> CARDON_CACTUS = IcariaBlocks.register("cardon_cactus", CardonCactusBlock::new, IcariaBlocks.propertiesCactus(MapColor.GRASS, SoundType.WOOL));
	public static final DeferredHolder<Block, Block> POTTED_CARDON_CACTUS = IcariaBlocks.register("potted_cardon_cactus", properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CARDON_CACTUS, properties), IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.STONE));

	public static final DeferredHolder<Block, Block> STRAWBERRY_BUSH = IcariaBlocks.register("strawberry_bush", StrawberryBushBlock::new, IcariaBlocks.propertiesBush(MapColor.NONE, SoundType.GRASS));

	public static final DeferredHolder<Block, Block> SPELT_CROP = IcariaBlocks.register("spelt_crop", SpeltCropBlock::new, IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP));
	public static final DeferredHolder<Block, Block> STRAWBERRY_CROP = IcariaBlocks.register("strawberry_crop", StrawberryCropBlock::new, IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP));
	public static final DeferredHolder<Block, Block> PHYSALIS_CROP = IcariaBlocks.register("physalis_crop", PhysalisCropBlock::new, IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP));
	public static final DeferredHolder<Block, Block> ONION_CROP = IcariaBlocks.register("onion_crop", OnionCropBlock::new, IcariaBlocks.propertiesCrop(MapColor.NONE, SoundType.CROP));

	public static final DeferredHolder<Block, LiquidBlock> MEDITERRANEAN_WATER = IcariaBlocks.register("mediterranean_water", properties -> new LiquidBlock(IcariaFluids.MEDITERRANEAN_WATER.get(), properties), IcariaBlocks.propertiesWater(MapColor.PLANT, SoundType.EMPTY));

	public static final DeferredHolder<Block, Block> GREEK_FIRE = IcariaBlocks.register("greek_fire", GreekFireBlock::new, IcariaBlocks.propertiesFire(MapColor.COLOR_LIGHT_GREEN, SoundType.EMPTY));

	public static final DeferredHolder<Block, Block> ICARIA_PORTAL = IcariaBlocks.register("icaria_portal", IcariaPortalBlock::new, IcariaBlocks.propertiesPortal(MapColor.NONE, SoundType.GLASS));

	public static final DeferredHolder<Block, Block> GRINDER_SHAFT = IcariaBlocks.register("grinder_shaft", Block::new, IcariaBlocks.propertiesNone());
	public static final DeferredHolder<Block, Block> GRINDER_STONE = IcariaBlocks.register("grinder_stone", Block::new, IcariaBlocks.propertiesNone());

	public static boolean always(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return true;
	}

	public static boolean always(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, EntityType<?> pEntityType) {
		return true;
	}

	public static boolean never(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return false;
	}

	public static boolean never(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, EntityType<?> pEntityType) {
		return false;
	}

	public static BlockBehaviour.Properties propertiesGrassyMarl(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.6F).explosionResistance(0.6F).randomTicks();
	}

	public static BlockBehaviour.Properties propertiesMarl(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesMarlOre(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesGroundDeco(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollission().noOcclusion().replaceable();
	}

	public static BlockBehaviour.Properties propertiesSurfaceLignite(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).ignitedByLava().instabreak().noCollission().noOcclusion().replaceable();
	}

	public static BlockBehaviour.Properties propertiesFarmland(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.6F).explosionResistance(0.6F).isSuffocating(IcariaBlocks::always).isViewBlocking(IcariaBlocks::always).randomTicks();
	}

	public static BlockBehaviour.Properties propertiesStone(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(1.5F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesLoam(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.FLUTE).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.6F).explosionResistance(0.6F);
	}

	public static BlockBehaviour.Properties propertiesSand(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesSuspiciousSand(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.25F).explosionResistance(0.25F);
	}

	public static BlockBehaviour.Properties propertiesSandOre(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesGlass(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.3F).explosionResistance(0.3F).isRedstoneConductor(IcariaBlocks::never).isSuffocating(IcariaBlocks::never).isValidSpawn(IcariaBlocks::never).isViewBlocking(IcariaBlocks::never).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesQuartz(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.8F).explosionResistance(0.8F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesChimney(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(1.5F).explosionResistance(6.0F).forceSolidOff().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesMineral(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(1.5F).explosionResistance(1.5F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesBudding(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.5F).explosionResistance(1.5F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesCrystal(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.5F).explosionResistance(1.5F).lightLevel(blockState -> 6).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesAristone(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F).friction(0.98F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesPackedAristone(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CHIME).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F).friction(0.98F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesJellyfishJellyBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F).friction(0.8F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesArachneStringBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.GUITAR).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.8F).explosionResistance(0.8F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesArachneStringCarpet(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.1F).explosionResistance(0.1F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesSpeltBaleBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BANJO).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesVineReedBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(2.0F).explosionResistance(3.0F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesRottenBonesBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.XYLOPHONE).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(2.0F).explosionResistance(2.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesRawMetalBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(5.0F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesCrystalBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.3F).explosionResistance(0.3F).isRedstoneConductor(IcariaBlocks::never).isSuffocating(IcariaBlocks::never).isValidSpawn(IcariaBlocks::never).isViewBlocking(IcariaBlocks::never).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesMetalBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(5.0F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesCoalBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(5.0F).explosionResistance(6.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesBars(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(5.0F).explosionResistance(6.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesChain(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(5.0F).explosionResistance(6.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesWorkstation(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.5F).explosionResistance(6.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesChest(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(2.5F).explosionResistance(2.5F);
	}

	public static BlockBehaviour.Properties propertiesStorageVase(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.25F).explosionResistance(4.2F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesAmphora(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.25F).explosionResistance(1.25F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesLootVase(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).instabreak().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesSpawner(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(5.0F).explosionResistance(5.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesSkull(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F);
	}

	public static BlockBehaviour.Properties propertiesTorch(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesCake(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesSapling(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesPot(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesLeaves(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.2F).explosionResistance(0.2F).isRedstoneConductor(IcariaBlocks::never).isSuffocating(IcariaBlocks::never).isValidSpawn(IcariaBlocks::never).isViewBlocking(IcariaBlocks::never).ignitedByLava().noOcclusion().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesTwigs(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).ignitedByLava().instabreak().noCollission().noOcclusion().replaceable();
	}

	public static BlockBehaviour.Properties propertiesWood(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(2.0F).explosionResistance(2.0F).ignitedByLava().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesPlanks(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(2.0F).explosionResistance(3.0F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesBarrel(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).instabreak().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesBathtub(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(2.0F).explosionResistance(3.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesTrough(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(2.0F).explosionResistance(3.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesStool(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(2.0F).explosionResistance(3.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesHolder(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesCountertop(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesCupboard(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesKitchenTable(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesKline(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesCraftingTable(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(2.5F).explosionResistance(2.5F);
	}

	public static BlockBehaviour.Properties propertiesScrollshelf(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(1.5F).explosionResistance(1.5F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesDoor(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(3.0F).explosionResistance(3.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesTrapDoor(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(3.0F).explosionResistance(3.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesPressurePlate(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F).forceSolidOn().noCollission();
	}

	public static BlockBehaviour.Properties propertiesButton(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F).noCollission();
	}

	public static BlockBehaviour.Properties propertiesLadder(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.4F).explosionResistance(0.4F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesSign(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noCollission();
	}

	public static BlockBehaviour.Properties propertiesVine(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.2F).explosionResistance(0.2F).ignitedByLava().noCollission().randomTicks().replaceable();
	}

	public static BlockBehaviour.Properties propertiesGrass(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().instabreak().noCollission().replaceable();
	}

	public static BlockBehaviour.Properties propertiesPlant(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesGroundFlower(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesMoss(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.1F).explosionResistance(0.1F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesPalmFern(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesGroundShroom(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess(IcariaBlocks::always).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesTreeShroom(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollission();
	}

	public static BlockBehaviour.Properties propertiesCactus(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.4F).explosionResistance(0.4F).randomTicks();
	}

	public static BlockBehaviour.Properties propertiesBush(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesCrop(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesWater(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(100.0F).explosionResistance(100.0F).noCollission().liquid().replaceable();
	}

	public static BlockBehaviour.Properties propertiesFire(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).lightLevel(blockState -> 15).instabreak().noCollission().noTerrainParticles().replaceable();
	}

	public static BlockBehaviour.Properties propertiesPortal(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(-1.0F).explosionResistance(-1.0F).lightLevel(blockState -> 11).noCollission().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesNone() {
		return BlockBehaviour.Properties.of();
	}

	public static <T extends Block> DeferredHolder<Block, T> register(String pName, Function<BlockBehaviour.Properties, T> pFunction, BlockBehaviour.Properties pProperties) {
		return IcariaBlocks.BLOCKS.register(pName, () -> pFunction.apply(pProperties.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName)))));
	}
}
