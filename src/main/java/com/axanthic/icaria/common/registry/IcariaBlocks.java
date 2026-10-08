package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.block.*;
import com.axanthic.icaria.common.ids.IcariaBlockIds;
import com.axanthic.icaria.common.ids.IcariaBlockItemIds;
import com.axanthic.icaria.common.properties.Mat;
import com.axanthic.icaria.common.types.SkullBlockTypes;

import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
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
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, IcariaIds.ID);

	public static final DeferredHolder<Block, Block> GRASSY_MARL = IcariaBlocks.register(IcariaBlockItemIds.GRASSY_MARL, IcariaBlocks.propertiesGrassyMarl(MapColor.COLOR_GREEN, SoundType.GRASS), GrassyMarlBlock::new);
	public static final DeferredHolder<Block, Block> MARL = IcariaBlocks.register(IcariaBlockItemIds.MARL, IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL), Block::new);
	public static final DeferredHolder<Block, Block> MARL_BONES = IcariaBlocks.register(IcariaBlockItemIds.MARL_BONES, IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL), Block::new);
	public static final DeferredHolder<Block, Block> BONES = IcariaBlocks.register(IcariaBlockItemIds.BONES, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.BONE_BLOCK), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> MARL_CHERT_ORE = IcariaBlocks.register(IcariaBlockItemIds.MARL_CHERT_ORE, IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL), Block::new);
	public static final DeferredHolder<Block, Block> CHERT_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.CHERT_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> MARL_LIGNITE_ORE = IcariaBlocks.register(IcariaBlockItemIds.MARL_LIGNITE_ORE, IcariaBlocks.propertiesMarlOre(MapColor.COLOR_BROWN, SoundType.GRAVEL), Block::new);
	public static final DeferredHolder<Block, Block> LIGNITE_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.LIGNITE_RUBBLE, IcariaBlocks.propertiesSurfaceLignite(MapColor.NONE, SoundType.STONE), LigniteRubbleBlock::new);
	public static final DeferredHolder<Block, Block> COARSE_MARL = IcariaBlocks.register(IcariaBlockItemIds.COARSE_MARL, IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL), Block::new);
	public static final DeferredHolder<Block, Block> DRY_LAKE_BED = IcariaBlocks.register(IcariaBlockItemIds.DRY_LAKE_BED, IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL), Block::new);
	public static final DeferredHolder<Block, Block> FARMLAND = IcariaBlocks.register(IcariaBlockItemIds.FARMLAND, IcariaBlocks.propertiesFarmland(MapColor.COLOR_BROWN, SoundType.GRAVEL), IcariaFarmlandBlock::new);
	public static final DeferredHolder<Block, Block> FERTILIZED_FARMLAND = IcariaBlocks.register(IcariaBlockItemIds.FERTILIZED_FARMLAND, IcariaBlocks.propertiesFarmland(MapColor.COLOR_BROWN, SoundType.GRAVEL), FertilizedFarmlandBlock::new);
	public static final DeferredHolder<Block, Block> MARL_PATH = IcariaBlocks.register(IcariaBlockItemIds.MARL_PATH, IcariaBlocks.propertiesMarl(MapColor.COLOR_BROWN, SoundType.GRAVEL), properties -> new IcariaPathBlock(IcariaBlocks.MARL.get(), properties));

	public static final DeferredHolder<Block, Block> MARL_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.MARL_ADOBE, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> MARL_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.MARL_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.MARL_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> MARL_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.MARL_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> MARL_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.MARL_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.COLOR_BROWN, SoundType.STONE), IcariaWallBlock::new);

	public static final DeferredHolder<Block, Block> LOAM = IcariaBlocks.register(IcariaBlockItemIds.LOAM, IcariaBlocks.propertiesLoam(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.GRAVEL), Block::new);
	public static final DeferredHolder<Block, Block> LOAM_PATH = IcariaBlocks.register(IcariaBlockItemIds.LOAM_PATH, IcariaBlocks.propertiesLoam(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.GRAVEL), properties -> new IcariaPathBlock(IcariaBlocks.LOAM.get(), properties));
	public static final DeferredHolder<Block, Block> LOAM_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.LOAM_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> LOAM_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.LOAM_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.LOAM_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> LOAM_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.LOAM_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> LOAM_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.LOAM_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.STONE), IcariaWallBlock::new);

	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.DOLOMITE_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> DOLOMITE_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_DOLOMITE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_DOLOMITE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SMOOTH_DOLOMITE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_DOLOMITE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SMOOTH_DOLOMITE_WALL = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_DOLOMITE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> DOLOMITE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> CHISELED_DOLOMITE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_DOLOMITE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> DOLOMITE_PILLAR = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_PILLAR, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> DOLOMITE_PILLAR_HEAD = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_PILLAR_HEAD, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_WHITE, SoundType.STONE), PillarHeadBlock::new);

	public static final DeferredHolder<Block, Block> GRAINEL = IcariaBlocks.register(IcariaBlockItemIds.GRAINEL, IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_YELLOW, SoundType.SAND), IcariaSandBlock::new);
	public static final DeferredHolder<Block, Block> SUSPICIOUS_GRAINEL = IcariaBlocks.register(IcariaBlockItemIds.SUSPICIOUS_GRAINEL, IcariaBlocks.propertiesSuspiciousSand(MapColor.TERRACOTTA_YELLOW, SoundType.SUSPICIOUS_SAND), properties -> new IcariaBrushableBlock(IcariaBlocks.GRAINEL.get(), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, properties));
	public static final DeferredHolder<Block, Block> CHERT_ORE = IcariaBlocks.register(IcariaBlockItemIds.CHERT_ORE, IcariaBlocks.propertiesSandOre(MapColor.TERRACOTTA_YELLOW, SoundType.SAND), Block::new);
	public static final DeferredHolder<Block, Block> GRAINEL_PATH = IcariaBlocks.register(IcariaBlockItemIds.GRAINEL_PATH, IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_YELLOW, SoundType.SAND), properties -> new IcariaPathBlock(IcariaBlocks.GRAINEL.get(), properties));
	public static final DeferredHolder<Block, Block> GRAINGLASS = IcariaBlocks.register(IcariaBlockItemIds.GRAINGLASS, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS), TransparentBlock::new);
	public static final DeferredHolder<Block, Block> GRAINGLASS_PANE = IcariaBlocks.register(IcariaBlockItemIds.GRAINGLASS_PANE, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS), IcariaIronBarsBlock::new);
	public static final DeferredHolder<Block, Block> HORIZONTAL_GRAINGLASS_PANE = IcariaBlocks.register(IcariaBlockItemIds.HORIZONTAL_GRAINGLASS_PANE, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS), HorizontalPaneBlock::new);
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.GRAINITE_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> GRAINITE_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> GRAINITE = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> GRAINITE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.GRAINITE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> GRAINITE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> GRAINITE_WALL = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> GRAINITE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> GRAINITE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.GRAINITE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> GRAINITE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> GRAINITE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CHISELED_GRAINITE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_GRAINITE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> GRAINITE_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.GRAINITE_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);

	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_ADOBE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.YELLOWSTONE_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_YELLOWSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_YELLOWSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_YELLOWSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_YELLOWSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_YELLOWSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_YELLOWSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.YELLOWSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.YELLOWSTONE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CHISELED_YELLOWSTONE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_YELLOWSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> YELLOWSTONE_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.YELLOWSTONE_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);

	public static final DeferredHolder<Block, Block> SILKSAND = IcariaBlocks.register(IcariaBlockItemIds.SILKSAND, IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.SAND), IcariaSandBlock::new);
	public static final DeferredHolder<Block, Block> SUSPICIOUS_SILKSAND = IcariaBlocks.register(IcariaBlockItemIds.SUSPICIOUS_SILKSAND, IcariaBlocks.propertiesSuspiciousSand(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.SUSPICIOUS_SAND), properties -> new IcariaBrushableBlock(IcariaBlocks.SILKSAND.get(), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, properties));
	public static final DeferredHolder<Block, Block> SILKSAND_PATH = IcariaBlocks.register(IcariaBlockItemIds.SILKSAND_PATH, IcariaBlocks.propertiesSand(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.SAND), properties -> new IcariaPathBlock(IcariaBlocks.SILKSAND.get(), properties));
	public static final DeferredHolder<Block, Block> SILKGLASS = IcariaBlocks.register(IcariaBlockItemIds.SILKGLASS, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS), TransparentBlock::new);
	public static final DeferredHolder<Block, Block> SILKGLASS_PANE = IcariaBlocks.register(IcariaBlockItemIds.SILKGLASS_PANE, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS), IcariaIronBarsBlock::new);
	public static final DeferredHolder<Block, Block> HORIZONTAL_SILKGLASS_PANE = IcariaBlocks.register(IcariaBlockItemIds.HORIZONTAL_SILKGLASS_PANE, IcariaBlocks.propertiesGlass(MapColor.NONE, SoundType.GLASS), HorizontalPaneBlock::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SILKSTONE_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SILKSTONE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SILKSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_SILKSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SILKSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_SILKSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SILKSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> SILKSTONE = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SILKSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SILKSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SILKSTONE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CHISELED_SILKSTONE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_SILKSTONE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SILKSTONE_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.SILKSTONE_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);

	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_ADOBE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SUNSTONE_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SUNSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SUNSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_SUNSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SUNSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_SUNSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_SUNSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> SUNSTONE = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SUNSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SUNSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SUNSTONE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CHISELED_SUNSTONE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_SUNSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SUNSTONE_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.SUNSTONE_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);

	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_ADOBE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.VOIDSHALE_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_VOIDSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_VOIDSHALE_STAIRS, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_VOIDSHALE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_VOIDSHALE_SLAB, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_VOIDSHALE_WALL = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_VOIDSHALE_WALL, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_STAIRS, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.VOIDSHALE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> VOIDSHALE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_SLAB, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_WALL = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_WALL, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_BRICKS, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.VOIDSHALE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CHISELED_VOIDSHALE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_VOIDSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> VOIDSHALE_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.VOIDSHALE_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);

	public static final DeferredHolder<Block, Block> BAETYL_ADOBE = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_ADOBE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> BAETYL_ADOBE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_ADOBE_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.BAETYL_ADOBE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> BAETYL_ADOBE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_ADOBE_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> BAETYL_ADOBE_WALL = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_ADOBE_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_BAETYL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_BAETYL_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.COBBLED_BAETYL.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL_SLAB = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_BAETYL_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> COBBLED_BAETYL_WALL = IcariaBlocks.register(IcariaBlockItemIds.COBBLED_BAETYL_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> BAETYL = IcariaBlocks.register(IcariaBlockItemIds.BAETYL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> BAETYL_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.BAETYL.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> BAETYL_SLAB = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> BAETYL_WALL = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> BAETYL_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_BRICKS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> BAETYL_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.BAETYL_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> BAETYL_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> BAETYL_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CHISELED_BAETYL = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_BAETYL, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> BAETYL_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.BAETYL_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);

	public static final DeferredHolder<Block, Block> RELICSTONE = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.RELICSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> RELICSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_RELICSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_RELICSTONE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.SMOOTH_RELICSTONE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_RELICSTONE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> SMOOTH_RELICSTONE_WALL = IcariaBlocks.register(IcariaBlockItemIds.SMOOTH_RELICSTONE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.RELICSTONE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICKS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_TILES = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_TILES, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_TILE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_TILE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.RELICSTONE_TILES.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> RELICSTONE_TILE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_TILE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_TILE_WALL = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_TILE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILES = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_TILES, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_TILE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.CRACKED_RELICSTONE_TILES.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_TILE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> CRACKED_RELICSTONE_TILE_WALL = IcariaBlocks.register(IcariaBlockItemIds.CRACKED_RELICSTONE_TILE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILES = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_TILES, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_TILE_STAIRS, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.MOSSY_RELICSTONE_TILES.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_TILE_SLAB, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> MOSSY_RELICSTONE_TILE_WALL = IcariaBlocks.register(IcariaBlockItemIds.MOSSY_RELICSTONE_TILE_WALL, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> CHISELED_RELICSTONE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_RELICSTONE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_PILLAR = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_PILLAR, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_PILLAR_HEAD = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_PILLAR_HEAD, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), PillarHeadBlock::new);
	public static final DeferredHolder<Block, Block> RELICSTONE_RUBBLE = IcariaBlocks.register(IcariaBlockItemIds.RELICSTONE_RUBBLE, IcariaBlocks.propertiesFloorDecoration(MapColor.NONE, SoundType.STONE), FloorDecorationBlock::new);

	public static final DeferredHolder<Block, Block> PLATOSHALE = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> PLATOSHALE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE_STAIRS, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.PLATOSHALE.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> PLATOSHALE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE_SLAB, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> PLATOSHALE_WALL = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE_WALL, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> BLURRED_PLATOSHALE = IcariaBlocks.register(IcariaBlockItemIds.BLURRED_PLATOSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE_BRICKS, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICK_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE_BRICK_STAIRS, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), properties -> new IcariaStairBlock(IcariaBlocks.PLATOSHALE_BRICKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICK_SLAB = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE_BRICK_SLAB, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> PLATOSHALE_BRICK_WALL = IcariaBlocks.register(IcariaBlockItemIds.PLATOSHALE_BRICK_WALL, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> BLURRED_PLATOSHALE_BRICKS = IcariaBlocks.register(IcariaBlockItemIds.BLURRED_PLATOSHALE_BRICKS, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> CHISELED_PLATOSHALE = IcariaBlocks.register(IcariaBlockItemIds.CHISELED_PLATOSHALE, IcariaBlocks.propertiesStone(MapColor.COLOR_BLACK, SoundType.STONE), Block::new);

	public static final DeferredHolder<Block, Block> QUARTZ_WALL = IcariaBlocks.register(IcariaBlockItemIds.QUARTZ_WALL, IcariaBlocks.propertiesQuartz(MapColor.QUARTZ, SoundType.STONE), IcariaWallBlock::new);
	public static final DeferredHolder<Block, Block> QUARTZ_PILLAR_HEAD = IcariaBlocks.register(IcariaBlockItemIds.QUARTZ_PILLAR_HEAD, IcariaBlocks.propertiesQuartz(MapColor.QUARTZ, SoundType.STONE), PillarHeadBlock::new);

	public static final DeferredHolder<Block, Block> CHIMNEY = IcariaBlocks.register(IcariaBlockItemIds.CHIMNEY, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE).forceSolidOff(), ChimneyBlock::new);
	public static final DeferredHolder<Block, Block> CHIMNEY_BRICK_CROWN = IcariaBlocks.register(IcariaBlockItemIds.CHIMNEY_BRICK_CROWN, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_YELLOW, SoundType.STONE).forceSolidOff(), ChimneyBrickCrownBlock::new);
	public static final DeferredHolder<Block, Block> CHIMNEY_GRATE_CROWN = IcariaBlocks.register(IcariaBlockItemIds.CHIMNEY_GRATE_CROWN, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_ORANGE, SoundType.STONE).forceSolidOff(), ChimneyGrateCrownBlock::new);
	public static final DeferredHolder<Block, Block> CHIMNEY_SLAB = IcariaBlocks.register(IcariaBlockItemIds.CHIMNEY_SLAB, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE).forceSolidOff(), ChimneySlabBlock::new);

	public static final DeferredHolder<Block, Block> LIGNITE_ORE = IcariaBlocks.register(IcariaBlockItemIds.LIGNITE_ORE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> CHALKOS_ORE = IcariaBlocks.register(IcariaBlockItemIds.CHALKOS_ORE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> KASSITEROS_ORE = IcariaBlocks.register(IcariaBlockItemIds.KASSITEROS_ORE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> DOLOMITE_ORE = IcariaBlocks.register(IcariaBlockItemIds.DOLOMITE_ORE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_PINK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> VANADIUM_ORE = IcariaBlocks.register(IcariaBlockItemIds.VANADIUM_ORE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SLIVER_ORE = IcariaBlocks.register(IcariaBlockItemIds.SLIVER_ORE, IcariaBlocks.propertiesStone(MapColor.WOOD, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> SIDEROS_ORE = IcariaBlocks.register(IcariaBlockItemIds.SIDEROS_ORE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> ANTHRACITE_ORE = IcariaBlocks.register(IcariaBlockItemIds.ANTHRACITE_ORE, IcariaBlocks.propertiesStone(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> MOLYBDENUM_ORE = IcariaBlocks.register(IcariaBlockItemIds.MOLYBDENUM_ORE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> HYLIASTRUM_ORE = IcariaBlocks.register(IcariaBlockItemIds.HYLIASTRUM_ORE, IcariaBlocks.propertiesStone(MapColor.TERRACOTTA_CYAN, SoundType.STONE), HyliastrumOreBlock::new);

	public static final DeferredHolder<Block, Block> CALCITE_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.CALCITE_BLOCK, IcariaBlocks.propertiesMineral(MapColor.COLOR_LIGHT_GRAY, SoundType.AMETHYST), Block::new);
	public static final DeferredHolder<Block, Block> BUDDING_CALCITE = IcariaBlocks.register(IcariaBlockItemIds.BUDDING_CALCITE, IcariaBlocks.propertiesBudding(MapColor.COLOR_LIGHT_GRAY, SoundType.AMETHYST), Block::new);
	public static final DeferredHolder<Block, Block> HALITE_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.HALITE_BLOCK, IcariaBlocks.propertiesMineral(MapColor.COLOR_GREEN, SoundType.AMETHYST), Block::new);
	public static final DeferredHolder<Block, Block> BUDDING_HALITE = IcariaBlocks.register(IcariaBlockItemIds.BUDDING_HALITE, IcariaBlocks.propertiesBudding(MapColor.COLOR_GREEN, SoundType.AMETHYST), Block::new);
	public static final DeferredHolder<Block, Block> JASPER_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.JASPER_BLOCK, IcariaBlocks.propertiesMineral(MapColor.COLOR_RED, SoundType.AMETHYST), Block::new);
	public static final DeferredHolder<Block, Block> BUDDING_JASPER = IcariaBlocks.register(IcariaBlockItemIds.BUDDING_JASPER, IcariaBlocks.propertiesBudding(MapColor.COLOR_RED, SoundType.AMETHYST), Block::new);
	public static final DeferredHolder<Block, Block> ZIRCON_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.ZIRCON_BLOCK, IcariaBlocks.propertiesMineral(MapColor.COLOR_BLUE, SoundType.AMETHYST), Block::new);
	public static final DeferredHolder<Block, Block> BUDDING_ZIRCON = IcariaBlocks.register(IcariaBlockItemIds.BUDDING_ZIRCON, IcariaBlocks.propertiesBudding(MapColor.COLOR_BLUE, SoundType.AMETHYST), Block::new);

	public static final DeferredHolder<Block, Block> CALCITE_CLUSTER = IcariaBlocks.register(IcariaBlockItemIds.CALCITE_CLUSTER, IcariaBlocks.propertiesCluster(MapColor.NONE, SoundType.AMETHYST_CLUSTER), ClusterBlock::new);
	public static final DeferredHolder<Block, Block> HALITE_CLUSTER = IcariaBlocks.register(IcariaBlockItemIds.HALITE_CLUSTER, IcariaBlocks.propertiesCluster(MapColor.NONE, SoundType.AMETHYST_CLUSTER), ClusterBlock::new);
	public static final DeferredHolder<Block, Block> JASPER_CLUSTER = IcariaBlocks.register(IcariaBlockItemIds.JASPER_CLUSTER, IcariaBlocks.propertiesCluster(MapColor.NONE, SoundType.AMETHYST_CLUSTER), ClusterBlock::new);
	public static final DeferredHolder<Block, Block> ZIRCON_CLUSTER = IcariaBlocks.register(IcariaBlockItemIds.ZIRCON_CLUSTER, IcariaBlocks.propertiesCluster(MapColor.NONE, SoundType.AMETHYST_CLUSTER), ClusterBlock::new);

	public static final DeferredHolder<Block, Block> ARISTONE = IcariaBlocks.register(IcariaBlockItemIds.ARISTONE, IcariaBlocks.propertiesAristone(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.GLASS), TransparentBlock::new);
	public static final DeferredHolder<Block, Block> PACKED_ARISTONE = IcariaBlocks.register(IcariaBlockItemIds.PACKED_ARISTONE, IcariaBlocks.propertiesPackedAristone(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.GLASS), Block::new);

	public static final DeferredHolder<Block, Block> ENDER_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.ENDER_JELLYFISH_JELLY_BLOCK, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_BLACK, SoundType.HONEY_BLOCK), JellyfishJellyBlock::new);
	public static final DeferredHolder<Block, Block> FIRE_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.FIRE_JELLYFISH_JELLY_BLOCK, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_ORANGE, SoundType.HONEY_BLOCK), JellyfishJellyBlock::new);
	public static final DeferredHolder<Block, Block> NATURE_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.NATURE_JELLYFISH_JELLY_BLOCK, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.WARPED_WART_BLOCK, SoundType.HONEY_BLOCK), JellyfishJellyBlock::new);
	public static final DeferredHolder<Block, Block> VOID_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.VOID_JELLYFISH_JELLY_BLOCK, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_MAGENTA, SoundType.HONEY_BLOCK), JellyfishJellyBlock::new);
	public static final DeferredHolder<Block, Block> WATER_JELLYFISH_JELLY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.WATER_JELLYFISH_JELLY_BLOCK, IcariaBlocks.propertiesJellyfishJellyBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.HONEY_BLOCK), JellyfishJellyBlock::new);

	public static final DeferredHolder<Block, Block> TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.COLOR_BROWN, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> WHITE_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.WHITE_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_WHITE, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> LIGHT_GRAY_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.LIGHT_GRAY_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.DEEPSLATE, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> GRAY_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.GRAY_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_GRAY, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> BLACK_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.BLACK_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.COLOR_BLACK, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> BROWN_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.BROWN_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.PODZOL, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> RED_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.RED_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_RED, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> ORANGE_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.ORANGE_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_ORANGE, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> YELLOW_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.YELLOW_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_YELLOW, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> LIME_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.LIME_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.COLOR_GREEN, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> GREEN_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.GREEN_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> CYAN_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.CYAN_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.GLOW_LICHEN, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> LIGHT_BLUE_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.LIGHT_BLUE_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_LIGHT_BLUE, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> BLUE_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.BLUE_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_BLUE, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> PURPLE_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.COLOR_MAGENTA, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> MAGENTA_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.MAGENTA_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_PURPLE, SoundType.WOOL), Block::new);
	public static final DeferredHolder<Block, Block> PINK_TERRY_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.PINK_TERRY_BLOCK, IcariaBlocks.propertiesTerryBlock(MapColor.TERRACOTTA_MAGENTA, SoundType.WOOL), Block::new);

	public static final DeferredHolder<Block, Block> TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.COLOR_BROWN, SoundType.WOOL), properties -> new MatBlock(Mat.TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> WHITE_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.WHITE_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_WHITE, SoundType.WOOL), properties -> new MatBlock(Mat.WHITE_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> LIGHT_GRAY_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.LIGHT_GRAY_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.DEEPSLATE, SoundType.WOOL), properties -> new MatBlock(Mat.LIGHT_GRAY_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> GRAY_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.GRAY_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_GRAY, SoundType.WOOL), properties -> new MatBlock(Mat.GRAY_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> BLACK_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.BLACK_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.COLOR_BLACK, SoundType.WOOL), properties -> new MatBlock(Mat.BLACK_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> BROWN_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.BROWN_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.PODZOL, SoundType.WOOL), properties -> new MatBlock(Mat.BROWN_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> RED_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.RED_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_RED, SoundType.WOOL), properties -> new MatBlock(Mat.RED_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> ORANGE_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.ORANGE_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_ORANGE, SoundType.WOOL), properties -> new MatBlock(Mat.ORANGE_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> YELLOW_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.YELLOW_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_YELLOW, SoundType.WOOL), properties -> new MatBlock(Mat.YELLOW_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> LIME_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.LIME_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.COLOR_GREEN, SoundType.WOOL), properties -> new MatBlock(Mat.LIME_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> GREEN_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.GREEN_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.WOOL), properties -> new MatBlock(Mat.GREEN_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> CYAN_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.CYAN_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.GLOW_LICHEN, SoundType.WOOL), properties -> new MatBlock(Mat.CYAN_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> LIGHT_BLUE_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.LIGHT_BLUE_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_LIGHT_BLUE, SoundType.WOOL), properties -> new MatBlock(Mat.LIGHT_BLUE_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> BLUE_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.BLUE_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_BLUE, SoundType.WOOL), properties -> new MatBlock(Mat.BLUE_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> PURPLE_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.COLOR_MAGENTA, SoundType.WOOL), properties -> new MatBlock(Mat.PURPLE_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> MAGENTA_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.MAGENTA_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_PURPLE, SoundType.WOOL), properties -> new MatBlock(Mat.MAGENTA_TERRY_MAT, properties));
	public static final DeferredHolder<Block, Block> PINK_TERRY_MAT = IcariaBlocks.register(IcariaBlockItemIds.PINK_TERRY_MAT, IcariaBlocks.propertiesTerryMat(MapColor.TERRACOTTA_MAGENTA, SoundType.WOOL), properties -> new MatBlock(Mat.PINK_TERRY_MAT, properties));

	public static final DeferredHolder<Block, Block> SPELT_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.SPELT_BLOCK, IcariaBlocks.propertiesSpeltBaleBlock(MapColor.TERRACOTTA_YELLOW, SoundType.GRASS), SpeltBlock::new);
	public static final DeferredHolder<Block, Block> VINE_REED_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.VINE_REED_BLOCK, IcariaBlocks.propertiesVineReedBlock(MapColor.WOOD, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> ROTTEN_BONES_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.ROTTEN_BONES_BLOCK, IcariaBlocks.propertiesRottenBonesBlock(MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.BONE_BLOCK), Block::new);

	public static final DeferredHolder<Block, Block> RAW_CHALKOS_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.RAW_CHALKOS_BLOCK, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_GREEN, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> RAW_KASSITEROS_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.RAW_KASSITEROS_BLOCK, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> RAW_VANADIUM_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.RAW_VANADIUM_BLOCK, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> RAW_SIDEROS_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.RAW_SIDEROS_BLOCK, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> RAW_MOLYBDENUM_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.RAW_MOLYBDENUM_BLOCK, IcariaBlocks.propertiesRawMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL), Block::new);

	public static final DeferredHolder<Block, Block> CALCITE_GLASS = IcariaBlocks.register(IcariaBlockItemIds.CALCITE_GLASS, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.GLASS), HalfTransparentBlock::new);
	public static final DeferredHolder<Block, Block> HALITE_GLASS = IcariaBlocks.register(IcariaBlockItemIds.HALITE_GLASS, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_GREEN, SoundType.GLASS), HalfTransparentBlock::new);
	public static final DeferredHolder<Block, Block> JASPER_GLASS = IcariaBlocks.register(IcariaBlockItemIds.JASPER_GLASS, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_RED, SoundType.GLASS), HalfTransparentBlock::new);
	public static final DeferredHolder<Block, Block> ZIRCON_GLASS = IcariaBlocks.register(IcariaBlockItemIds.ZIRCON_GLASS, IcariaBlocks.propertiesCrystalBlock(MapColor.COLOR_BLUE, SoundType.GLASS), HalfTransparentBlock::new);
	public static final DeferredHolder<Block, Block> CHERT_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.CHERT_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_GRAY, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> LIGNITE_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.LIGNITE_BLOCK, IcariaBlocks.propertiesCoalBlock(MapColor.COLOR_BROWN, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> CHALKOS_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.CHALKOS_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_GREEN, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> KASSITEROS_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.KASSITEROS_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> ORICHALCUM_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.ORICHALCUM_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> VANADIUM_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.VANADIUM_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> SLIVER_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.SLIVER_BLOCK, IcariaBlocks.propertiesRawMetalBlock(MapColor.WOOD, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> VANADIUMSTEEL_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.VANADIUMSTEEL_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_YELLOW, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> SIDEROS_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.SIDEROS_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_ORANGE, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> ANTHRACITE_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.ANTHRACITE_BLOCK, IcariaBlocks.propertiesCoalBlock(MapColor.COLOR_BLACK, SoundType.STONE), Block::new);
	public static final DeferredHolder<Block, Block> MOLYBDENUM_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.MOLYBDENUM_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> MOLYBDENUMSTEEL_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.MOLYBDENUMSTEEL_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_GRAY, SoundType.METAL), Block::new);
	public static final DeferredHolder<Block, Block> BLURIDIUM_BLOCK = IcariaBlocks.register(IcariaBlockItemIds.BLURIDIUM_BLOCK, IcariaBlocks.propertiesMetalBlock(MapColor.COLOR_LIGHT_BLUE, SoundType.METAL), Block::new);

	public static final DeferredHolder<Block, Block> VANADIUMSTEEL_BARS = IcariaBlocks.register(IcariaBlockItemIds.VANADIUMSTEEL_BARS, IcariaBlocks.propertiesBars(MapColor.NONE, SoundType.METAL), IcariaIronBarsBlock::new);
	public static final DeferredHolder<Block, Block> HORIZONTAL_VANADIUMSTEEL_BARS = IcariaBlocks.register(IcariaBlockItemIds.HORIZONTAL_VANADIUMSTEEL_BARS, IcariaBlocks.propertiesBars(MapColor.NONE, SoundType.METAL), HorizontalPaneBlock::new);

	public static final DeferredHolder<Block, Block> VANADIUMSTEEL_CHAIN = IcariaBlocks.register(IcariaBlockItemIds.VANADIUMSTEEL_CHAIN, IcariaBlocks.propertiesChain(MapColor.NONE, SoundType.CHAIN), IcariaChainBlock::new);

	public static final DeferredHolder<Block, Block> GRATE_FIREPLACE = IcariaBlocks.register(IcariaBlockItemIds.GRATE_FIREPLACE, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE), properties -> new GrateFireplaceBlock(1.275F, properties));
	public static final DeferredHolder<Block, Block> POT_FIREPLACE = IcariaBlocks.register(IcariaBlockItemIds.POT_FIREPLACE, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE), properties -> new PotFireplaceBlock(1.2425F, properties));

	public static final DeferredHolder<Block, Block> KETTLE = IcariaBlocks.register(IcariaBlockItemIds.KETTLE, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.WOOD), KettleBlock::new);
	public static final DeferredHolder<Block, Block> GRINDER = IcariaBlocks.register(IcariaBlockItemIds.GRINDER, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE), GrinderBlock::new);
	public static final DeferredHolder<Block, Block> KILN = IcariaBlocks.register(IcariaBlockItemIds.KILN, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE), KilnBlock::new);
	public static final DeferredHolder<Block, Block> FORGE = IcariaBlocks.register(IcariaBlockItemIds.FORGE, IcariaBlocks.propertiesWorkstation(MapColor.WOOD, SoundType.STONE), ForgeBlock::new);

	public static final DeferredHolder<Block, Block> CHEST = IcariaBlocks.register(IcariaBlockItemIds.CHEST, IcariaBlocks.propertiesChest(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new IcariaChestBlock(IcariaBlockEntityTypes.CHEST::get, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, properties));
	public static final DeferredHolder<Block, Block> TRAPPED_CHEST = IcariaBlocks.register(IcariaBlockItemIds.TRAPPED_CHEST, IcariaBlocks.propertiesChest(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new IcariaTrappedChestBlock(IcariaBlockEntityTypes.TRAPPED_CHEST::get, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, properties));

	public static final DeferredHolder<Block, Block> STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.TERRACOTTA_PINK, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> WHITE_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.WHITE_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.SNOW, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> LIGHT_GRAY_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.LIGHT_GRAY_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_GRAY, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> GRAY_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.GRAY_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_GRAY, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> BLACK_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.BLACK_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BLACK, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> BROWN_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.BROWN_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BROWN, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> RED_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.RED_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_RED, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> ORANGE_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.ORANGE_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_ORANGE, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> YELLOW_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.YELLOW_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_YELLOW, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> LIME_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.LIME_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_GREEN, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> GREEN_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.GREEN_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_GREEN, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> CYAN_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.CYAN_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_CYAN, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> LIGHT_BLUE_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.LIGHT_BLUE_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_LIGHT_BLUE, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> BLUE_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.BLUE_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_BLUE, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> PURPLE_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_PURPLE, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> MAGENTA_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.MAGENTA_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_MAGENTA, SoundType.DECORATED_POT), StorageVaseBlock::new);
	public static final DeferredHolder<Block, Block> PINK_STORAGE_VASE = IcariaBlocks.register(IcariaBlockItemIds.PINK_STORAGE_VASE, IcariaBlocks.propertiesStorageVase(MapColor.COLOR_PINK, SoundType.DECORATED_POT), StorageVaseBlock::new);

	public static final DeferredHolder<Block, Block> AMPHORA = IcariaBlocks.register(IcariaBlockItemIds.AMPHORA, IcariaBlocks.propertiesAmphora(MapColor.COLOR_LIGHT_GRAY, IcariaSoundTypes.POTTERY), AmphoraBlock::new);

	public static final DeferredHolder<Block, Block> VASE = IcariaBlocks.register(IcariaBlockItemIds.VASE, IcariaBlocks.propertiesVase(MapColor.COLOR_LIGHT_GRAY, IcariaSoundTypes.POTTERY), VaseBlock::new);

	public static final DeferredHolder<Block, Block> RED_LOOT_VASE = IcariaBlocks.register(IcariaBlockItemIds.RED_LOOT_VASE, IcariaBlocks.propertiesLootVase(MapColor.COLOR_RED, IcariaSoundTypes.POTTERY), LootVaseBlock::new);
	public static final DeferredHolder<Block, Block> LOST_LOOT_VASE = IcariaBlocks.register(IcariaBlockItemIds.LOST_LOOT_VASE, IcariaBlocks.propertiesLootVase(MapColor.PODZOL, IcariaSoundTypes.POTTERY), LootVaseBlock::new);
	public static final DeferredHolder<Block, Block> CYAN_LOOT_VASE = IcariaBlocks.register(IcariaBlockItemIds.CYAN_LOOT_VASE, IcariaBlocks.propertiesLootVase(MapColor.COLOR_CYAN, IcariaSoundTypes.POTTERY), LootVaseBlock::new);

	public static final DeferredHolder<Block, Block> ARACHNE_SPAWNER = IcariaBlocks.register(IcariaBlockItemIds.ARACHNE_SPAWNER, IcariaBlocks.propertiesSpawner(MapColor.COLOR_LIGHT_GRAY, SoundType.SPAWNER), SpawnerBlock::new);
	public static final DeferredHolder<Block, Block> REVENANT_SPAWNER = IcariaBlocks.register(IcariaBlockItemIds.REVENANT_SPAWNER, IcariaBlocks.propertiesSpawner(MapColor.COLOR_GREEN, SoundType.SPAWNER), SpawnerBlock::new);

	public static final DeferredHolder<Block, Block> COBWEB = IcariaBlocks.register(IcariaBlockItemIds.COBWEB, IcariaBlocks.propertiesCobweb(MapColor.WOOL, SoundType.COBWEB), CobwebBlock::new);

	public static final DeferredHolder<Block, Block> BONE_LADDER = IcariaBlocks.register(IcariaBlockItemIds.BONE_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.BONE_BLOCK), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> ROTTEN_BONE_LADDER = IcariaBlocks.register(IcariaBlockItemIds.ROTTEN_BONE_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.BONE_BLOCK), RottenLadderBlock::new);

	public static final DeferredHolder<Block, Block> AETERNAE_SKULL = IcariaBlocks.register(IcariaBlockItemIds.AETERNAE_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.AETERNAE, properties));
	public static final DeferredHolder<Block, Block> AETERNAE_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.AETERNAE_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.AETERNAE, properties));
	public static final DeferredHolder<Block, Block> ARGAN_HOUND_SKULL = IcariaBlocks.register(IcariaBlockItemIds.ARGAN_HOUND_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.ARGAN_HOUND, properties));
	public static final DeferredHolder<Block, Block> ARGAN_HOUND_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.ARGAN_HOUND_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.ARGAN_HOUND, properties));
	public static final DeferredHolder<Block, Block> CAPELLA_SKULL = IcariaBlocks.register(IcariaBlockItemIds.CAPELLA_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.CAPELLA, properties));
	public static final DeferredHolder<Block, Block> CAPELLA_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.CAPELLA_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.CAPELLA, properties));
	public static final DeferredHolder<Block, Block> CATOBLEPAS_SKULL = IcariaBlocks.register(IcariaBlockItemIds.CATOBLEPAS_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.CATOBLEPAS, properties));
	public static final DeferredHolder<Block, Block> CATOBLEPAS_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.CATOBLEPAS_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.CATOBLEPAS, properties));
	public static final DeferredHolder<Block, Block> CERVER_SKULL = IcariaBlocks.register(IcariaBlockItemIds.CERVER_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.CERVER, properties));
	public static final DeferredHolder<Block, Block> CERVER_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.CERVER_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.CERVER, properties));
	public static final DeferredHolder<Block, Block> CROCOTTA_SKULL = IcariaBlocks.register(IcariaBlockItemIds.CROCOTTA_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.CROCOTTA, properties));
	public static final DeferredHolder<Block, Block> CROCOTTA_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.CROCOTTA_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.CROCOTTA, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_FOREST_HAG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_FOREST_HAG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.CYPRESS_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_FOREST_HAG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.CYPRESS_FOREST_HAG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.CYPRESS_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FOREST_HAG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_FOREST_HAG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.DROUGHTROOT_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FOREST_HAG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.DROUGHTROOT_FOREST_HAG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.DROUGHTROOT_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> FIR_FOREST_HAG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.FIR_FOREST_HAG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.FIR_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> FIR_FOREST_HAG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.FIR_FOREST_HAG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.FIR_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> LAUREL_FOREST_HAG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_FOREST_HAG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.LAUREL_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> LAUREL_FOREST_HAG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.LAUREL_FOREST_HAG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.LAUREL_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> OLIVE_FOREST_HAG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_FOREST_HAG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.OLIVE_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> OLIVE_FOREST_HAG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.OLIVE_FOREST_HAG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.OLIVE_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> PLANE_FOREST_HAG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.PLANE_FOREST_HAG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.PLANE_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> PLANE_FOREST_HAG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.PLANE_FOREST_HAG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.PLANE_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> POPULUS_FOREST_HAG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_FOREST_HAG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.POPULUS_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> POPULUS_FOREST_HAG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.POPULUS_FOREST_HAG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.POPULUS_FOREST_HAG, properties));
	public static final DeferredHolder<Block, Block> REVENANT_SKULL = IcariaBlocks.register(IcariaBlockItemIds.REVENANT_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.REVENANT, properties));
	public static final DeferredHolder<Block, Block> REVENANT_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.REVENANT_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.REVENANT, properties));
	public static final DeferredHolder<Block, Block> THOG_SKULL = IcariaBlocks.register(IcariaBlockItemIds.THOG_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new SkullBlock(SkullBlockTypes.THOG, properties));
	public static final DeferredHolder<Block, Block> THOG_WALL_SKULL = IcariaBlocks.register(IcariaBlockIds.THOG_WALL_SKULL, IcariaBlocks.propertiesSkull(MapColor.NONE, SoundType.STONE), properties -> new WallSkullBlock(SkullBlockTypes.THOG, properties));

	public static final DeferredHolder<Block, Block> LIGNITE_TORCH = IcariaBlocks.register(IcariaBlockItemIds.LIGNITE_TORCH, IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 10), properties -> new TorchBlock(ParticleTypes.FLAME, properties));
	public static final DeferredHolder<Block, Block> LIGNITE_WALL_TORCH = IcariaBlocks.register(IcariaBlockIds.LIGNITE_WALL_TORCH, IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 10), properties -> new WallTorchBlock(ParticleTypes.FLAME, properties));
	public static final DeferredHolder<Block, Block> ANTHRACITE_TORCH = IcariaBlocks.register(IcariaBlockItemIds.ANTHRACITE_TORCH, IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 14), properties -> new TorchBlock(ParticleTypes.FLAME, properties));
	public static final DeferredHolder<Block, Block> ANTHRACITE_WALL_TORCH = IcariaBlocks.register(IcariaBlockIds.ANTHRACITE_WALL_TORCH, IcariaBlocks.propertiesTorch(MapColor.NONE, SoundType.METAL).lightLevel(blockState -> 14), properties -> new WallTorchBlock(ParticleTypes.FLAME, properties));

	public static final DeferredHolder<Block, Block> LAUREL_CHERRY_CAKE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_CHERRY_CAKE, IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL), properties -> new IcariaCakeBlock(true, 600, IcariaMobEffects.LIFESTEAL, properties));
	public static final DeferredHolder<Block, Block> STRAWBERRY_CAKE = IcariaBlocks.register(IcariaBlockItemIds.STRAWBERRY_CAKE, IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL), properties -> new IcariaCakeBlock(false, 600, MobEffects.FIRE_RESISTANCE, properties));
	public static final DeferredHolder<Block, Block> PHYSALIS_CAKE = IcariaBlocks.register(IcariaBlockItemIds.PHYSALIS_CAKE, IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL), properties -> new IcariaCakeBlock(false, 600, MobEffects.REGENERATION, properties));
	public static final DeferredHolder<Block, Block> VINE_BERRY_CAKE = IcariaBlocks.register(IcariaBlockItemIds.VINE_BERRY_CAKE, IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL), properties -> new IcariaCakeBlock(false, 600, MobEffects.NIGHT_VISION, properties));
	public static final DeferredHolder<Block, Block> VINE_SPROUT_CAKE = IcariaBlocks.register(IcariaBlockItemIds.VINE_SPROUT_CAKE, IcariaBlocks.propertiesCake(MapColor.NONE, SoundType.WOOL), properties -> new IcariaCakeBlock(false, 600, MobEffects.SPEED, properties));

	public static final DeferredHolder<Block, Block> COOKIE_JAR = IcariaBlocks.register(IcariaBlockItemIds.COOKIE_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), CookieJarBlock::new);
	public static final DeferredHolder<Block, Block> GREENPOWDER_JAR = IcariaBlocks.register(IcariaBlockItemIds.GREENPOWDER_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), GreenpowderJarBlock::new);
	public static final DeferredHolder<Block, Block> CALCITE_DUST_JAR = IcariaBlocks.register(IcariaBlockItemIds.CALCITE_DUST_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> HALITE_DUST_JAR = IcariaBlocks.register(IcariaBlockItemIds.HALITE_DUST_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> SPELT_FLOUR_JAR = IcariaBlocks.register(IcariaBlockItemIds.SPELT_FLOUR_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> SUGAR_JAR = IcariaBlocks.register(IcariaBlockItemIds.SUGAR_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> ENDER_JELLYFISH_JELLY_JAR = IcariaBlocks.register(IcariaBlockItemIds.ENDER_JELLYFISH_JELLY_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> FIRE_JELLYFISH_JELLY_JAR = IcariaBlocks.register(IcariaBlockItemIds.FIRE_JELLYFISH_JELLY_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> NATURE_JELLYFISH_JELLY_JAR = IcariaBlocks.register(IcariaBlockItemIds.NATURE_JELLYFISH_JELLY_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> VOID_JELLYFISH_JELLY_JAR = IcariaBlocks.register(IcariaBlockItemIds.VOID_JELLYFISH_JELLY_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);
	public static final DeferredHolder<Block, Block> WATER_JELLYFISH_JELLY_JAR = IcariaBlocks.register(IcariaBlockItemIds.WATER_JELLYFISH_JELLY_JAR, IcariaBlocks.propertiesJar(MapColor.NONE, SoundType.GLASS), JarBlock::new);

	public static final DeferredHolder<Block, Block> FLASK = IcariaBlocks.register(IcariaBlockItemIds.FLASK, IcariaBlocks.propertiesFlask(MapColor.NONE, SoundType.GLASS), FlaskBlock::new);

	public static final DeferredHolder<Block, Block> POT = IcariaBlocks.register(IcariaBlockItemIds.POT, IcariaBlocks.propertiesPot(MapColor.NONE, SoundType.METAL), PotBlock::new);

	public static final DeferredHolder<Block, Block> LARGE_BOWLS = IcariaBlocks.register(IcariaBlockItemIds.LARGE_BOWLS, IcariaBlocks.propertiesTableDecoration(MapColor.NONE, SoundType.STONE), TableDecorationBlock::new);
	public static final DeferredHolder<Block, Block> SMALL_BOWLS = IcariaBlocks.register(IcariaBlockItemIds.SMALL_BOWLS, IcariaBlocks.propertiesTableDecoration(MapColor.NONE, SoundType.STONE), TableDecorationBlock::new);
	public static final DeferredHolder<Block, Block> PLATES = IcariaBlocks.register(IcariaBlockItemIds.PLATES, IcariaBlocks.propertiesTableDecoration(MapColor.NONE, SoundType.STONE), TableDecorationBlock::new);
	public static final DeferredHolder<Block, Block> SUSPICIOUS_SUBSTANCE = IcariaBlocks.register(IcariaBlockItemIds.SUSPICIOUS_SUBSTANCE, IcariaBlocks.propertiesTableDecoration(MapColor.NONE, SoundType.STONE), SuspiciousSubstanceBlock::new);

	public static final DeferredHolder<Block, Block> CHECKERS = IcariaBlocks.register(IcariaBlockItemIds.CHECKERS, IcariaBlocks.propertiesChessboard(MapColor.NONE, SoundType.STONE), ChessboardBlock::new);
	public static final DeferredHolder<Block, Block> CHESS = IcariaBlocks.register(IcariaBlockItemIds.CHESS, IcariaBlocks.propertiesChessboard(MapColor.NONE, SoundType.STONE), ChessboardBlock::new);

	public static final DeferredHolder<Block, Block> CYPRESS_SAPLING = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_SAPLING, IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS), properties -> new SaplingBlock(IcariaTreeGrowers.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> POTTED_CYPRESS_SAPLING = IcariaBlocks.register(IcariaBlockIds.POTTED_CYPRESS_SAPLING, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CYPRESS_SAPLING, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), properties -> new IcariaLeavesBlock(5203730, properties));
	public static final DeferredHolder<Block, Block> FALLEN_CYPRESS_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FALLEN_CYPRESS_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_TWIGS = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_TWIGS, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_FIREWOOD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_FIREWOOD, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_FIREWOOD_WEDGE = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_FIREWOOD_WEDGE, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodWedgeBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_WOOD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_CYPRESS_WOOD = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_CYPRESS_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_LOG = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_CYPRESS_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_CYPRESS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> DEAD_CYPRESS_LOG = IcariaBlocks.register(IcariaBlockItemIds.DEAD_CYPRESS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_CYPRESS_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DEAD_CYPRESS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_PLANKS = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> CYPRESS_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_STAIRS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new IcariaStairBlock(IcariaBlocks.CYPRESS_PLANKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> CYPRESS_SLAB = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_SLAB, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_FENCE = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_FENCE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaFenceBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_FENCE_GATE = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_FENCE_GATE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new FenceGateBlock(IcariaWoodTypes.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> SIMPLE_CYPRESS_RACK = IcariaBlocks.register(IcariaBlockItemIds.SIMPLE_CYPRESS_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_RACK = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_BARREL = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> LOADED_CYPRESS_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LOADED_CYPRESS_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TAPPED_CYPRESS_BARREL = IcariaBlocks.register(IcariaBlockItemIds.TAPPED_CYPRESS_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TRIPLE_CYPRESS_BARREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.TRIPLE_CYPRESS_BARREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), TripleBarrelRackBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_BATHTUB = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_BATHTUB, IcariaBlocks.propertiesBathtub(MapColor.COLOR_BROWN, SoundType.WOOD), BathtubBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_TROUGH = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_TROUGH, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD), TroughBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_STOOL = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_STOOL, IcariaBlocks.propertiesStool(MapColor.COLOR_BROWN, SoundType.WOOD), StoolBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_CUTTING_BOARD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_CUTTING_BOARD, IcariaBlocks.propertiesCuttingBoard(MapColor.NONE, SoundType.WOOD), CuttingBoardBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_HERB_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_HERB_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_PAN_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_PAN_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_POT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_POT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_SPOON_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_SPOON_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_TOWEL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_TOWEL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), TowelHolderBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_CYPRESS_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_CYPRESS_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), BrokenHolderBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CandleCountertopBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_FLOWER_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_FLOWER_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), FlowerPotCountertopBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_MORTAR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_MORTAR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_RAISED_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_RAISED_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_DISH_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_DISH_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_FLASK_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_FLASK_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_POT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_POT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_VASE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_VASE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_CYPRESS_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_CYPRESS_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_HUTCH = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), HutchBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_WALL_HUTCH = IcariaBlocks.register(IcariaBlockIds.CYPRESS_WALL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), WallHutchBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_KITCHEN_TABLE = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_KITCHEN_TABLE, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD), KitchenTableBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_KLINE = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_KLINE, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD), KlineBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_CRAFTING_TABLE = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_CRAFTING_TABLE, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaCraftingTableBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_SCROLLSHELF = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_SCROLLSHELF, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_BROWN, SoundType.WOOD), ScrollshelfBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_DOOR = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_DOOR, IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), properties -> new DoorBlock(IcariaBlockSetTypes.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_TRAPDOOR = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_TRAPDOOR, IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_PRESSURE_PLATE = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_PRESSURE_PLATE, IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new PressurePlateBlock(IcariaBlockSetTypes.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_BUTTON = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_BUTTON, IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD), properties -> new ButtonBlock(IcariaBlockSetTypes.CYPRESS, 30, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_SHELF = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_SHELF, IcariaBlocks.propertiesShelf(MapColor.COLOR_BROWN, SoundType.SHELF), IcariaShelfBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_LADDER = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> CYPRESS_SIGN = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaStandingSignBlock(IcariaWoodTypes.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_WALL_SIGN = IcariaBlocks.register(IcariaBlockIds.CYPRESS_WALL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallSignBlock(IcariaWoodTypes.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_HANGING_SIGN = IcariaBlocks.register(IcariaBlockItemIds.CYPRESS_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.CYPRESS, properties));
	public static final DeferredHolder<Block, Block> CYPRESS_WALL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockIds.CYPRESS_WALL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.CYPRESS, properties));

	public static final DeferredHolder<Block, Block> DROUGHTROOT_SAPLING = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_SAPLING, IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS), properties -> new SaplingBlock(IcariaTreeGrowers.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> POTTED_DROUGHTROOT_SAPLING = IcariaBlocks.register(IcariaBlockIds.POTTED_DROUGHTROOT_SAPLING, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.DROUGHTROOT_SAPLING, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), properties -> new IcariaLeavesBlock(5923354, properties));
	public static final DeferredHolder<Block, Block> FALLEN_DROUGHTROOT_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FALLEN_DROUGHTROOT_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TWIGS = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_TWIGS, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FIREWOOD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_FIREWOOD, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FIREWOOD_WEDGE = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_FIREWOOD_WEDGE, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodWedgeBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_WOOD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DROUGHTROOT_WOOD = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DROUGHTROOT_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_LOG = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DROUGHTROOT_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DROUGHTROOT_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> DEAD_DROUGHTROOT_LOG = IcariaBlocks.register(IcariaBlockItemIds.DEAD_DROUGHTROOT_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BLACK, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_DROUGHTROOT_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DEAD_DROUGHTROOT_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_PLANKS = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_STAIRS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD), properties -> new IcariaStairBlock(IcariaBlocks.DROUGHTROOT_PLANKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SLAB = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_SLAB, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FENCE = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_FENCE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaFenceBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FENCE_GATE = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_FENCE_GATE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GRAY, SoundType.WOOD), properties -> new FenceGateBlock(IcariaWoodTypes.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> SIMPLE_DROUGHTROOT_RACK = IcariaBlocks.register(IcariaBlockItemIds.SIMPLE_DROUGHTROOT_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_RACK = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BARREL = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> LOADED_DROUGHTROOT_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LOADED_DROUGHTROOT_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TAPPED_DROUGHTROOT_BARREL = IcariaBlocks.register(IcariaBlockItemIds.TAPPED_DROUGHTROOT_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TRIPLE_DROUGHTROOT_BARREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.TRIPLE_DROUGHTROOT_BARREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GRAY, IcariaSoundTypes.BARREL), TripleBarrelRackBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BATHTUB = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_BATHTUB, IcariaBlocks.propertiesBathtub(MapColor.COLOR_GRAY, SoundType.WOOD), BathtubBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TROUGH = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_TROUGH, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD), TroughBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_STOOL = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_STOOL, IcariaBlocks.propertiesStool(MapColor.COLOR_GRAY, SoundType.WOOD), StoolBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_CUTTING_BOARD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_CUTTING_BOARD, IcariaBlocks.propertiesCuttingBoard(MapColor.NONE, SoundType.WOOD), CuttingBoardBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_HERB_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_HERB_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_PAN_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_PAN_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_POT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_POT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SPOON_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_SPOON_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TOWEL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_TOWEL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), TowelHolderBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_DROUGHTROOT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_DROUGHTROOT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), BrokenHolderBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CandleCountertopBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FLOWER_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_FLOWER_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), FlowerPotCountertopBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_MORTAR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_MORTAR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_RAISED_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_RAISED_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_DISH_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_DISH_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_FLASK_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_FLASK_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_POT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_POT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_VASE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_VASE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_DROUGHTROOT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_DROUGHTROOT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_HUTCH = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), HutchBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_WALL_HUTCH = IcariaBlocks.register(IcariaBlockIds.DROUGHTROOT_WALL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), WallHutchBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_KITCHEN_TABLE = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_KITCHEN_TABLE, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD), KitchenTableBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_KLINE = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_KLINE, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD), KlineBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_CRAFTING_TABLE = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_CRAFTING_TABLE, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaCraftingTableBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SCROLLSHELF = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_SCROLLSHELF, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_GRAY, SoundType.WOOD), ScrollshelfBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_DOOR = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_DOOR, IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), properties -> new DoorBlock(IcariaBlockSetTypes.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_TRAPDOOR = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_TRAPDOOR, IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_GRAY, SoundType.WOOD), properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_PRESSURE_PLATE = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_PRESSURE_PLATE, IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_GRAY, SoundType.WOOD), properties -> new PressurePlateBlock(IcariaBlockSetTypes.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_BUTTON = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_BUTTON, IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD), properties -> new ButtonBlock(IcariaBlockSetTypes.DROUGHTROOT, 30, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SHELF = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_SHELF, IcariaBlocks.propertiesShelf(MapColor.COLOR_BROWN, SoundType.SHELF), IcariaShelfBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_LADDER = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> DROUGHTROOT_SIGN = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaStandingSignBlock(IcariaWoodTypes.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_WALL_SIGN = IcariaBlocks.register(IcariaBlockIds.DROUGHTROOT_WALL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallSignBlock(IcariaWoodTypes.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_HANGING_SIGN = IcariaBlocks.register(IcariaBlockItemIds.DROUGHTROOT_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.DROUGHTROOT, properties));
	public static final DeferredHolder<Block, Block> DROUGHTROOT_WALL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockIds.DROUGHTROOT_WALL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.DROUGHTROOT, properties));

	public static final DeferredHolder<Block, Block> FIR_SAPLING = IcariaBlocks.register(IcariaBlockItemIds.FIR_SAPLING, IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS), properties -> new SaplingBlock(IcariaTreeGrowers.FIR, properties));
	public static final DeferredHolder<Block, Block> POTTED_FIR_SAPLING = IcariaBlocks.register(IcariaBlockIds.POTTED_FIR_SAPLING, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FIR_SAPLING, properties));
	public static final DeferredHolder<Block, Block> FIR_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FIR_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), properties -> new IcariaLeavesBlock(3498818, properties));
	public static final DeferredHolder<Block, Block> FALLEN_FIR_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FALLEN_FIR_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> FIR_TWIGS = IcariaBlocks.register(IcariaBlockItemIds.FIR_TWIGS, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> FIR_FIREWOOD = IcariaBlocks.register(IcariaBlockItemIds.FIR_FIREWOOD, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodBlock::new);
	public static final DeferredHolder<Block, Block> FIR_FIREWOOD_WEDGE = IcariaBlocks.register(IcariaBlockItemIds.FIR_FIREWOOD_WEDGE, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodWedgeBlock::new);
	public static final DeferredHolder<Block, Block> FIR_WOOD = IcariaBlocks.register(IcariaBlockItemIds.FIR_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_FIR_WOOD = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_FIR_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> FIR_LOG = IcariaBlocks.register(IcariaBlockItemIds.FIR_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_FIR_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_FIR_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> DEAD_FIR_LOG = IcariaBlocks.register(IcariaBlockItemIds.DEAD_FIR_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_FIR_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DEAD_FIR_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> FIR_PLANKS = IcariaBlocks.register(IcariaBlockItemIds.FIR_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> FIR_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.FIR_STAIRS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new IcariaStairBlock(IcariaBlocks.FIR_PLANKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> FIR_SLAB = IcariaBlocks.register(IcariaBlockItemIds.FIR_SLAB, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> FIR_FENCE = IcariaBlocks.register(IcariaBlockItemIds.FIR_FENCE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaFenceBlock::new);
	public static final DeferredHolder<Block, Block> FIR_FENCE_GATE = IcariaBlocks.register(IcariaBlockItemIds.FIR_FENCE_GATE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new FenceGateBlock(IcariaWoodTypes.FIR, properties));
	public static final DeferredHolder<Block, Block> SIMPLE_FIR_RACK = IcariaBlocks.register(IcariaBlockItemIds.SIMPLE_FIR_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> FIR_RACK = IcariaBlocks.register(IcariaBlockItemIds.FIR_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> FIR_BARREL = IcariaBlocks.register(IcariaBlockItemIds.FIR_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> LOADED_FIR_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LOADED_FIR_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TAPPED_FIR_BARREL = IcariaBlocks.register(IcariaBlockItemIds.TAPPED_FIR_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TRIPLE_FIR_BARREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.TRIPLE_FIR_BARREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), TripleBarrelRackBlock::new);
	public static final DeferredHolder<Block, Block> FIR_BATHTUB = IcariaBlocks.register(IcariaBlockItemIds.FIR_BATHTUB, IcariaBlocks.propertiesBathtub(MapColor.COLOR_ORANGE, SoundType.WOOD), BathtubBlock::new);
	public static final DeferredHolder<Block, Block> FIR_TROUGH = IcariaBlocks.register(IcariaBlockItemIds.FIR_TROUGH, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD), TroughBlock::new);
	public static final DeferredHolder<Block, Block> FIR_STOOL = IcariaBlocks.register(IcariaBlockItemIds.FIR_STOOL, IcariaBlocks.propertiesStool(MapColor.COLOR_ORANGE, SoundType.WOOD), StoolBlock::new);
	public static final DeferredHolder<Block, Block> FIR_CUTTING_BOARD = IcariaBlocks.register(IcariaBlockItemIds.FIR_CUTTING_BOARD, IcariaBlocks.propertiesCuttingBoard(MapColor.NONE, SoundType.WOOD), CuttingBoardBlock::new);
	public static final DeferredHolder<Block, Block> FIR_HERB_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.FIR_HERB_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> FIR_PAN_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.FIR_PAN_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> FIR_POT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.FIR_POT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> FIR_SPOON_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.FIR_SPOON_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> FIR_TOWEL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.FIR_TOWEL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), TowelHolderBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_FIR_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_FIR_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), BrokenHolderBlock::new);
	public static final DeferredHolder<Block, Block> FIR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.FIR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CandleCountertopBlock::new);
	public static final DeferredHolder<Block, Block> FIR_FLOWER_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.FIR_FLOWER_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), FlowerPotCountertopBlock::new);
	public static final DeferredHolder<Block, Block> FIR_MORTAR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.FIR_MORTAR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> FIR_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.FIR_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> FIR_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.FIR_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> FIR_RAISED_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.FIR_RAISED_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> FIR_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.FIR_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> FIR_DISH_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.FIR_DISH_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> FIR_FLASK_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.FIR_FLASK_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> FIR_POT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.FIR_POT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> FIR_VASE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.FIR_VASE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_FIR_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_FIR_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> FIR_HUTCH = IcariaBlocks.register(IcariaBlockItemIds.FIR_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), HutchBlock::new);
	public static final DeferredHolder<Block, Block> FIR_WALL_HUTCH = IcariaBlocks.register(IcariaBlockIds.FIR_WALL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), WallHutchBlock::new);
	public static final DeferredHolder<Block, Block> FIR_KITCHEN_TABLE = IcariaBlocks.register(IcariaBlockItemIds.FIR_KITCHEN_TABLE, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD), KitchenTableBlock::new);
	public static final DeferredHolder<Block, Block> FIR_KLINE = IcariaBlocks.register(IcariaBlockItemIds.FIR_KLINE, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD), KlineBlock::new);
	public static final DeferredHolder<Block, Block> FIR_CRAFTING_TABLE = IcariaBlocks.register(IcariaBlockItemIds.FIR_CRAFTING_TABLE, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaCraftingTableBlock::new);
	public static final DeferredHolder<Block, Block> FIR_SCROLLSHELF = IcariaBlocks.register(IcariaBlockItemIds.FIR_SCROLLSHELF, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_ORANGE, SoundType.WOOD), ScrollshelfBlock::new);
	public static final DeferredHolder<Block, Block> FIR_DOOR = IcariaBlocks.register(IcariaBlockItemIds.FIR_DOOR, IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), properties -> new DoorBlock(IcariaBlockSetTypes.FIR, properties));
	public static final DeferredHolder<Block, Block> FIR_TRAPDOOR = IcariaBlocks.register(IcariaBlockItemIds.FIR_TRAPDOOR, IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.FIR, properties));
	public static final DeferredHolder<Block, Block> FIR_PRESSURE_PLATE = IcariaBlocks.register(IcariaBlockItemIds.FIR_PRESSURE_PLATE, IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new PressurePlateBlock(IcariaBlockSetTypes.FIR, properties));
	public static final DeferredHolder<Block, Block> FIR_BUTTON = IcariaBlocks.register(IcariaBlockItemIds.FIR_BUTTON, IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD), properties -> new ButtonBlock(IcariaBlockSetTypes.FIR, 30, properties));
	public static final DeferredHolder<Block, Block> FIR_SHELF = IcariaBlocks.register(IcariaBlockItemIds.FIR_SHELF, IcariaBlocks.propertiesShelf(MapColor.COLOR_BROWN, SoundType.SHELF), IcariaShelfBlock::new);
	public static final DeferredHolder<Block, Block> FIR_LADDER = IcariaBlocks.register(IcariaBlockItemIds.FIR_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> FIR_SIGN = IcariaBlocks.register(IcariaBlockItemIds.FIR_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaStandingSignBlock(IcariaWoodTypes.FIR, properties));
	public static final DeferredHolder<Block, Block> FIR_WALL_SIGN = IcariaBlocks.register(IcariaBlockIds.FIR_WALL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallSignBlock(IcariaWoodTypes.FIR, properties));
	public static final DeferredHolder<Block, Block> FIR_HANGING_SIGN = IcariaBlocks.register(IcariaBlockItemIds.FIR_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.FIR, properties));
	public static final DeferredHolder<Block, Block> FIR_WALL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockIds.FIR_WALL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.FIR, properties));

	public static final DeferredHolder<Block, Block> LAUREL_SAPLING = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_SAPLING, IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS), properties -> new SaplingBlock(IcariaTreeGrowers.LAUREL, properties));
	public static final DeferredHolder<Block, Block> POTTED_LAUREL_SAPLING = IcariaBlocks.register(IcariaBlockIds.POTTED_LAUREL_SAPLING, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LAUREL_SAPLING, properties));
	public static final DeferredHolder<Block, Block> LAUREL_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), properties -> new IcariaLeavesBlock(4347162, properties));
	public static final DeferredHolder<Block, Block> FALLEN_LAUREL_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FALLEN_LAUREL_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_TWIGS = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_TWIGS, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_FIREWOOD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_FIREWOOD, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_FIREWOOD_WEDGE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_FIREWOOD_WEDGE, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodWedgeBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_WOOD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_LAUREL_WOOD = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_LAUREL_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_LOG = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_LAUREL_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_LAUREL_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> DEAD_LAUREL_LOG = IcariaBlocks.register(IcariaBlockItemIds.DEAD_LAUREL_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_LAUREL_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DEAD_LAUREL_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_BROWN, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_PLANKS = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> LAUREL_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_STAIRS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new IcariaStairBlock(IcariaBlocks.LAUREL_PLANKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> LAUREL_SLAB = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_SLAB, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_FENCE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_FENCE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaFenceBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_FENCE_GATE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_FENCE_GATE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new FenceGateBlock(IcariaWoodTypes.LAUREL, properties));
	public static final DeferredHolder<Block, Block> SIMPLE_LAUREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.SIMPLE_LAUREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> LOADED_LAUREL_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LOADED_LAUREL_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TAPPED_LAUREL_BARREL = IcariaBlocks.register(IcariaBlockItemIds.TAPPED_LAUREL_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TRIPLE_LAUREL_BARREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.TRIPLE_LAUREL_BARREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), TripleBarrelRackBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_BATHTUB = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_BATHTUB, IcariaBlocks.propertiesBathtub(MapColor.COLOR_BROWN, SoundType.WOOD), BathtubBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_TROUGH = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_TROUGH, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD), TroughBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_STOOL = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_STOOL, IcariaBlocks.propertiesStool(MapColor.COLOR_BROWN, SoundType.WOOD), StoolBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_CUTTING_BOARD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_CUTTING_BOARD, IcariaBlocks.propertiesCuttingBoard(MapColor.NONE, SoundType.WOOD), CuttingBoardBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_HERB_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_HERB_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_PAN_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_PAN_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_POT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_POT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_SPOON_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_SPOON_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_TOWEL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_TOWEL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), TowelHolderBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_LAUREL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_LAUREL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), BrokenHolderBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CandleCountertopBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_FLOWER_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_FLOWER_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), FlowerPotCountertopBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_MORTAR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_MORTAR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_RAISED_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_RAISED_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_DISH_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_DISH_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_FLASK_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_FLASK_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_POT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_POT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_VASE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_VASE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_LAUREL_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_LAUREL_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_HUTCH = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), HutchBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_WALL_HUTCH = IcariaBlocks.register(IcariaBlockIds.LAUREL_WALL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), WallHutchBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_KITCHEN_TABLE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_KITCHEN_TABLE, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD), KitchenTableBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_KLINE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_KLINE, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD), KlineBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_CRAFTING_TABLE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_CRAFTING_TABLE, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaCraftingTableBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_SCROLLSHELF = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_SCROLLSHELF, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_BROWN, SoundType.WOOD), ScrollshelfBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_DOOR = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_DOOR, IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), properties -> new DoorBlock(IcariaBlockSetTypes.LAUREL, properties));
	public static final DeferredHolder<Block, Block> LAUREL_TRAPDOOR = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_TRAPDOOR, IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.LAUREL, properties));
	public static final DeferredHolder<Block, Block> LAUREL_PRESSURE_PLATE = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_PRESSURE_PLATE, IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new PressurePlateBlock(IcariaBlockSetTypes.LAUREL, properties));
	public static final DeferredHolder<Block, Block> LAUREL_BUTTON = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_BUTTON, IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD), properties -> new ButtonBlock(IcariaBlockSetTypes.LAUREL, 30, properties));
	public static final DeferredHolder<Block, Block> LAUREL_SHELF = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_SHELF, IcariaBlocks.propertiesShelf(MapColor.COLOR_BROWN, SoundType.SHELF), IcariaShelfBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_LADDER = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> LAUREL_SIGN = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaStandingSignBlock(IcariaWoodTypes.LAUREL, properties));
	public static final DeferredHolder<Block, Block> LAUREL_WALL_SIGN = IcariaBlocks.register(IcariaBlockIds.LAUREL_WALL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallSignBlock(IcariaWoodTypes.LAUREL, properties));
	public static final DeferredHolder<Block, Block> LAUREL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockItemIds.LAUREL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.LAUREL, properties));
	public static final DeferredHolder<Block, Block> LAUREL_WALL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockIds.LAUREL_WALL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.LAUREL, properties));

	public static final DeferredHolder<Block, Block> OLIVE_SAPLING = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_SAPLING, IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS), properties -> new SaplingBlock(IcariaTreeGrowers.OLIVE, properties));
	public static final DeferredHolder<Block, Block> POTTED_OLIVE_SAPLING = IcariaBlocks.register(IcariaBlockIds.POTTED_OLIVE_SAPLING, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.OLIVE_SAPLING, properties));
	public static final DeferredHolder<Block, Block> OLIVE_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_YELLOW, SoundType.GRASS), properties -> new OliveLeavesBlock(8485426, properties));
	public static final DeferredHolder<Block, Block> FALLEN_OLIVE_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FALLEN_OLIVE_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_YELLOW, SoundType.GRASS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_TWIGS = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_TWIGS, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_FIREWOOD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_FIREWOOD, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_FIREWOOD_WEDGE = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_FIREWOOD_WEDGE, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodWedgeBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_WOOD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_OLIVE_WOOD = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_OLIVE_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_LOG = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_OLIVE_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_OLIVE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> DEAD_OLIVE_LOG = IcariaBlocks.register(IcariaBlockItemIds.DEAD_OLIVE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_OLIVE_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DEAD_OLIVE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_PLANKS = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> OLIVE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_STAIRS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new IcariaStairBlock(IcariaBlocks.OLIVE_PLANKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> OLIVE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_SLAB, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_FENCE = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_FENCE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaFenceBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_FENCE_GATE = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_FENCE_GATE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new FenceGateBlock(IcariaWoodTypes.OLIVE, properties));
	public static final DeferredHolder<Block, Block> SIMPLE_OLIVE_RACK = IcariaBlocks.register(IcariaBlockItemIds.SIMPLE_OLIVE_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_RACK = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_BARREL = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> LOADED_OLIVE_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LOADED_OLIVE_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TAPPED_OLIVE_BARREL = IcariaBlocks.register(IcariaBlockItemIds.TAPPED_OLIVE_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TRIPLE_OLIVE_BARREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.TRIPLE_OLIVE_BARREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_ORANGE, IcariaSoundTypes.BARREL), TripleBarrelRackBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_BATHTUB = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_BATHTUB, IcariaBlocks.propertiesBathtub(MapColor.COLOR_ORANGE, SoundType.WOOD), BathtubBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_TROUGH = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_TROUGH, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD), TroughBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_STOOL = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_STOOL, IcariaBlocks.propertiesStool(MapColor.COLOR_ORANGE, SoundType.WOOD), StoolBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_CUTTING_BOARD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_CUTTING_BOARD, IcariaBlocks.propertiesCuttingBoard(MapColor.NONE, SoundType.WOOD), CuttingBoardBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_HERB_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_HERB_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_PAN_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_PAN_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_POT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_POT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_SPOON_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_SPOON_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_TOWEL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_TOWEL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), TowelHolderBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_OLIVE_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_OLIVE_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), BrokenHolderBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CandleCountertopBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_FLOWER_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_FLOWER_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), FlowerPotCountertopBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_MORTAR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_MORTAR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_RAISED_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_RAISED_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_DISH_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_DISH_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_FLASK_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_FLASK_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_POT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_POT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_VASE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_VASE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_OLIVE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_OLIVE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_HUTCH = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), HutchBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_WALL_HUTCH = IcariaBlocks.register(IcariaBlockIds.OLIVE_WALL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), WallHutchBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_KITCHEN_TABLE = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_KITCHEN_TABLE, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD), KitchenTableBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_KLINE = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_KLINE, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD), KlineBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_CRAFTING_TABLE = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_CRAFTING_TABLE, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaCraftingTableBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_SCROLLSHELF = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_SCROLLSHELF, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_ORANGE, SoundType.WOOD), ScrollshelfBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_DOOR = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_DOOR, IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), properties -> new DoorBlock(IcariaBlockSetTypes.OLIVE, properties));
	public static final DeferredHolder<Block, Block> OLIVE_TRAPDOOR = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_TRAPDOOR, IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.OLIVE, properties));
	public static final DeferredHolder<Block, Block> OLIVE_PRESSURE_PLATE = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_PRESSURE_PLATE, IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new PressurePlateBlock(IcariaBlockSetTypes.OLIVE, properties));
	public static final DeferredHolder<Block, Block> OLIVE_BUTTON = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_BUTTON, IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD), properties -> new ButtonBlock(IcariaBlockSetTypes.OLIVE, 30, properties));
	public static final DeferredHolder<Block, Block> OLIVE_SHELF = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_SHELF, IcariaBlocks.propertiesShelf(MapColor.COLOR_BROWN, SoundType.SHELF), IcariaShelfBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_LADDER = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> OLIVE_SIGN = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaStandingSignBlock(IcariaWoodTypes.OLIVE, properties));
	public static final DeferredHolder<Block, Block> OLIVE_WALL_SIGN = IcariaBlocks.register(IcariaBlockIds.OLIVE_WALL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallSignBlock(IcariaWoodTypes.OLIVE, properties));
	public static final DeferredHolder<Block, Block> OLIVE_HANGING_SIGN = IcariaBlocks.register(IcariaBlockItemIds.OLIVE_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.OLIVE, properties));
	public static final DeferredHolder<Block, Block> OLIVE_WALL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockIds.OLIVE_WALL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.OLIVE, properties));

	public static final DeferredHolder<Block, Block> PLANE_SAPLING = IcariaBlocks.register(IcariaBlockItemIds.PLANE_SAPLING, IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS), properties -> new SaplingBlock(IcariaTreeGrowers.PLANE, properties));
	public static final DeferredHolder<Block, Block> POTTED_PLANE_SAPLING = IcariaBlocks.register(IcariaBlockIds.POTTED_PLANE_SAPLING, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PLANE_SAPLING, properties));
	public static final DeferredHolder<Block, Block> PLANE_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.PLANE_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), properties -> new IcariaLeavesBlock(5336128, properties));
	public static final DeferredHolder<Block, Block> FALLEN_PLANE_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FALLEN_PLANE_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.COLOR_GREEN, SoundType.GRASS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_TWIGS = IcariaBlocks.register(IcariaBlockItemIds.PLANE_TWIGS, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_FIREWOOD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_FIREWOOD, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_FIREWOOD_WEDGE = IcariaBlocks.register(IcariaBlockItemIds.PLANE_FIREWOOD_WEDGE, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodWedgeBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_WOOD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_PLANE_WOOD = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_PLANE_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_LOG = IcariaBlocks.register(IcariaBlockItemIds.PLANE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_PLANE_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_PLANE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> DEAD_PLANE_LOG = IcariaBlocks.register(IcariaBlockItemIds.DEAD_PLANE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_GRAY, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_PLANE_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DEAD_PLANE_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_ORANGE, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_PLANKS = IcariaBlocks.register(IcariaBlockItemIds.PLANE_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> PLANE_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.PLANE_STAIRS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new IcariaStairBlock(IcariaBlocks.PLANE_PLANKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> PLANE_SLAB = IcariaBlocks.register(IcariaBlockItemIds.PLANE_SLAB, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_FENCE = IcariaBlocks.register(IcariaBlockItemIds.PLANE_FENCE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaFenceBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_FENCE_GATE = IcariaBlocks.register(IcariaBlockItemIds.PLANE_FENCE_GATE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new FenceGateBlock(IcariaWoodTypes.PLANE, properties));
	public static final DeferredHolder<Block, Block> SIMPLE_PLANE_RACK = IcariaBlocks.register(IcariaBlockItemIds.SIMPLE_PLANE_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_RACK = IcariaBlocks.register(IcariaBlockItemIds.PLANE_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_BARREL = IcariaBlocks.register(IcariaBlockItemIds.PLANE_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> LOADED_PLANE_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LOADED_PLANE_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TAPPED_PLANE_BARREL = IcariaBlocks.register(IcariaBlockItemIds.TAPPED_PLANE_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TRIPLE_PLANE_BARREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.TRIPLE_PLANE_BARREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_BROWN, IcariaSoundTypes.BARREL), TripleBarrelRackBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_BATHTUB = IcariaBlocks.register(IcariaBlockItemIds.PLANE_BATHTUB, IcariaBlocks.propertiesBathtub(MapColor.COLOR_BROWN, SoundType.WOOD), BathtubBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_TROUGH = IcariaBlocks.register(IcariaBlockItemIds.PLANE_TROUGH, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD), TroughBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_STOOL = IcariaBlocks.register(IcariaBlockItemIds.PLANE_STOOL, IcariaBlocks.propertiesStool(MapColor.COLOR_BROWN, SoundType.WOOD), StoolBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_CUTTING_BOARD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_CUTTING_BOARD, IcariaBlocks.propertiesCuttingBoard(MapColor.NONE, SoundType.WOOD), CuttingBoardBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_HERB_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.PLANE_HERB_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_PAN_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.PLANE_PAN_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_POT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.PLANE_POT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_SPOON_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.PLANE_SPOON_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_TOWEL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.PLANE_TOWEL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), TowelHolderBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_PLANE_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_PLANE_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), BrokenHolderBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.PLANE_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CandleCountertopBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_FLOWER_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.PLANE_FLOWER_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), FlowerPotCountertopBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_MORTAR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.PLANE_MORTAR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.PLANE_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.PLANE_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_RAISED_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.PLANE_RAISED_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_DISH_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_DISH_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_FLASK_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_FLASK_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_POT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_POT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_VASE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.PLANE_VASE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_PLANE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_PLANE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_HUTCH = IcariaBlocks.register(IcariaBlockItemIds.PLANE_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), HutchBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_WALL_HUTCH = IcariaBlocks.register(IcariaBlockIds.PLANE_WALL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), WallHutchBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_KITCHEN_TABLE = IcariaBlocks.register(IcariaBlockItemIds.PLANE_KITCHEN_TABLE, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD), KitchenTableBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_KLINE = IcariaBlocks.register(IcariaBlockItemIds.PLANE_KLINE, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD), KlineBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_CRAFTING_TABLE = IcariaBlocks.register(IcariaBlockItemIds.PLANE_CRAFTING_TABLE, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_BROWN, SoundType.WOOD), IcariaCraftingTableBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_SCROLLSHELF = IcariaBlocks.register(IcariaBlockItemIds.PLANE_SCROLLSHELF, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_BROWN, SoundType.WOOD), ScrollshelfBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_DOOR = IcariaBlocks.register(IcariaBlockItemIds.PLANE_DOOR, IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), properties -> new DoorBlock(IcariaBlockSetTypes.PLANE, properties));
	public static final DeferredHolder<Block, Block> PLANE_TRAPDOOR = IcariaBlocks.register(IcariaBlockItemIds.PLANE_TRAPDOOR, IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_ORANGE, SoundType.WOOD), properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.PLANE, properties));
	public static final DeferredHolder<Block, Block> PLANE_PRESSURE_PLATE = IcariaBlocks.register(IcariaBlockItemIds.PLANE_PRESSURE_PLATE, IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_BROWN, SoundType.WOOD), properties -> new PressurePlateBlock(IcariaBlockSetTypes.PLANE, properties));
	public static final DeferredHolder<Block, Block> PLANE_BUTTON = IcariaBlocks.register(IcariaBlockItemIds.PLANE_BUTTON, IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD), properties -> new ButtonBlock(IcariaBlockSetTypes.PLANE, 30, properties));
	public static final DeferredHolder<Block, Block> PLANE_SHELF = IcariaBlocks.register(IcariaBlockItemIds.PLANE_SHELF, IcariaBlocks.propertiesShelf(MapColor.COLOR_BROWN, SoundType.SHELF), IcariaShelfBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_LADDER = IcariaBlocks.register(IcariaBlockItemIds.PLANE_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> PLANE_SIGN = IcariaBlocks.register(IcariaBlockItemIds.PLANE_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaStandingSignBlock(IcariaWoodTypes.PLANE, properties));
	public static final DeferredHolder<Block, Block> PLANE_WALL_SIGN = IcariaBlocks.register(IcariaBlockIds.PLANE_WALL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallSignBlock(IcariaWoodTypes.PLANE, properties));
	public static final DeferredHolder<Block, Block> PLANE_HANGING_SIGN = IcariaBlocks.register(IcariaBlockItemIds.PLANE_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.PLANE, properties));
	public static final DeferredHolder<Block, Block> PLANE_WALL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockIds.PLANE_WALL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.PLANE, properties));

	public static final DeferredHolder<Block, Block> POPULUS_SAPLING = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_SAPLING, IcariaBlocks.propertiesSapling(MapColor.NONE, SoundType.GRASS), properties -> new SaplingBlock(IcariaTreeGrowers.POPULUS, properties));
	public static final DeferredHolder<Block, Block> POTTED_POPULUS_SAPLING = IcariaBlocks.register(IcariaBlockIds.POTTED_POPULUS_SAPLING, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.POPULUS_SAPLING, properties));
	public static final DeferredHolder<Block, Block> POPULUS_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.GLOW_LICHEN, SoundType.GRASS), properties -> new IcariaLeavesBlock(4948832, properties));
	public static final DeferredHolder<Block, Block> FALLEN_POPULUS_LEAVES = IcariaBlocks.register(IcariaBlockItemIds.FALLEN_POPULUS_LEAVES, IcariaBlocks.propertiesLeaves(MapColor.GLOW_LICHEN, SoundType.GRASS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_TWIGS = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_TWIGS, IcariaBlocks.propertiesTwigs(MapColor.NONE, SoundType.WOOD), FloorDecorationBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_FIREWOOD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_FIREWOOD, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_FIREWOOD_WEDGE = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_FIREWOOD_WEDGE, IcariaBlocks.propertiesWood(MapColor.NONE, SoundType.WOOD), FirewoodWedgeBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_WOOD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_POPULUS_WOOD = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_POPULUS_WOOD, IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD), RotatedPillarBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_LOG = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_POPULUS_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_POPULUS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD), IcariaLogBlock::new);
	public static final DeferredHolder<Block, Block> DEAD_POPULUS_LOG = IcariaBlocks.register(IcariaBlockItemIds.DEAD_POPULUS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_LIGHT_GRAY, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> STRIPPED_DEAD_POPULUS_LOG = IcariaBlocks.register(IcariaBlockItemIds.STRIPPED_DEAD_POPULUS_LOG, IcariaBlocks.propertiesWood(MapColor.COLOR_YELLOW, SoundType.WOOD), DeadLogBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_PLANKS = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_PLANKS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD), Block::new);
	public static final DeferredHolder<Block, Block> POPULUS_STAIRS = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_STAIRS, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD), properties -> new IcariaStairBlock(IcariaBlocks.POPULUS_PLANKS.get().defaultBlockState(), properties));
	public static final DeferredHolder<Block, Block> POPULUS_SLAB = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_SLAB, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD), IcariaSlabBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_FENCE = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_FENCE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD), IcariaFenceBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_FENCE_GATE = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_FENCE_GATE, IcariaBlocks.propertiesPlanks(MapColor.COLOR_GREEN, SoundType.WOOD), properties -> new FenceGateBlock(IcariaWoodTypes.POPULUS, properties));
	public static final DeferredHolder<Block, Block> SIMPLE_POPULUS_RACK = IcariaBlocks.register(IcariaBlockItemIds.SIMPLE_POPULUS_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_RACK = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, SoundType.WOOD), RackBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_BARREL = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> LOADED_POPULUS_BARREL = IcariaBlocks.register(IcariaBlockItemIds.LOADED_POPULUS_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TAPPED_POPULUS_BARREL = IcariaBlocks.register(IcariaBlockItemIds.TAPPED_POPULUS_BARREL, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL), IcariaBarrelBlock::new);
	public static final DeferredHolder<Block, Block> TRIPLE_POPULUS_BARREL_RACK = IcariaBlocks.register(IcariaBlockItemIds.TRIPLE_POPULUS_BARREL_RACK, IcariaBlocks.propertiesBarrel(MapColor.COLOR_GREEN, IcariaSoundTypes.BARREL), TripleBarrelRackBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_BATHTUB = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_BATHTUB, IcariaBlocks.propertiesBathtub(MapColor.COLOR_GREEN, SoundType.WOOD), BathtubBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_TROUGH = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_TROUGH, IcariaBlocks.propertiesTrough(MapColor.NONE, SoundType.WOOD), TroughBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_STOOL = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_STOOL, IcariaBlocks.propertiesStool(MapColor.COLOR_GREEN, SoundType.WOOD), StoolBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_CUTTING_BOARD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_CUTTING_BOARD, IcariaBlocks.propertiesCuttingBoard(MapColor.NONE, SoundType.WOOD), CuttingBoardBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_HERB_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_HERB_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_PAN_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_PAN_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_POT_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_POT_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_SPOON_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_SPOON_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), HolderBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_TOWEL_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_TOWEL_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), TowelHolderBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_POPULUS_HOLDER = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_POPULUS_HOLDER, IcariaBlocks.propertiesHolder(MapColor.NONE, SoundType.WOOD), BrokenHolderBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CandleCountertopBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_FLOWER_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_FLOWER_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), FlowerPotCountertopBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_MORTAR_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_MORTAR_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_POT_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_POT_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_RAISED_BASIN_COUNTERTOP = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_RAISED_BASIN_COUNTERTOP, IcariaBlocks.propertiesCountertop(MapColor.COLOR_ORANGE, SoundType.WOOD), CountertopBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_DISH_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_DISH_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_FLASK_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_FLASK_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_POT_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_POT_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_VASE_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_VASE_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> BROKEN_POPULUS_CUPBOARD = IcariaBlocks.register(IcariaBlockItemIds.BROKEN_POPULUS_CUPBOARD, IcariaBlocks.propertiesCupboard(MapColor.COLOR_BROWN, SoundType.WOOD), CupboardBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_HUTCH = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), HutchBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_WALL_HUTCH = IcariaBlocks.register(IcariaBlockIds.POPULUS_WALL_HUTCH, IcariaBlocks.propertiesHutch(MapColor.COLOR_BROWN, SoundType.WOOD), WallHutchBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_KITCHEN_TABLE = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_KITCHEN_TABLE, IcariaBlocks.propertiesKitchenTable(MapColor.COLOR_BROWN, SoundType.WOOD), KitchenTableBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_KLINE = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_KLINE, IcariaBlocks.propertiesKline(MapColor.COLOR_BROWN, SoundType.WOOD), KlineBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_CRAFTING_TABLE = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_CRAFTING_TABLE, IcariaBlocks.propertiesCraftingTable(MapColor.COLOR_GREEN, SoundType.WOOD), IcariaCraftingTableBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_SCROLLSHELF = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_SCROLLSHELF, IcariaBlocks.propertiesScrollshelf(MapColor.COLOR_GREEN, SoundType.WOOD), ScrollshelfBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_DOOR = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_DOOR, IcariaBlocks.propertiesDoor(MapColor.NONE, SoundType.WOOD), properties -> new DoorBlock(IcariaBlockSetTypes.POPULUS, properties));
	public static final DeferredHolder<Block, Block> POPULUS_TRAPDOOR = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_TRAPDOOR, IcariaBlocks.propertiesTrapDoor(MapColor.COLOR_YELLOW, SoundType.WOOD), properties -> new IcariaTrapDoorBlock(IcariaBlockSetTypes.POPULUS, properties));
	public static final DeferredHolder<Block, Block> POPULUS_PRESSURE_PLATE = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_PRESSURE_PLATE, IcariaBlocks.propertiesPressurePlate(MapColor.COLOR_GREEN, SoundType.WOOD), properties -> new PressurePlateBlock(IcariaBlockSetTypes.POPULUS, properties));
	public static final DeferredHolder<Block, Block> POPULUS_BUTTON = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_BUTTON, IcariaBlocks.propertiesButton(MapColor.NONE, SoundType.WOOD), properties -> new ButtonBlock(IcariaBlockSetTypes.POPULUS, 30, properties));
	public static final DeferredHolder<Block, Block> POPULUS_SHELF = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_SHELF, IcariaBlocks.propertiesShelf(MapColor.COLOR_BROWN, SoundType.SHELF), IcariaShelfBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_LADDER = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_LADDER, IcariaBlocks.propertiesLadder(MapColor.NONE, SoundType.LADDER), IcariaLadderBlock::new);
	public static final DeferredHolder<Block, Block> POPULUS_SIGN = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaStandingSignBlock(IcariaWoodTypes.POPULUS, properties));
	public static final DeferredHolder<Block, Block> POPULUS_WALL_SIGN = IcariaBlocks.register(IcariaBlockIds.POPULUS_WALL_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallSignBlock(IcariaWoodTypes.POPULUS, properties));
	public static final DeferredHolder<Block, Block> POPULUS_HANGING_SIGN = IcariaBlocks.register(IcariaBlockItemIds.POPULUS_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaCeilingHangingSignBlock(IcariaWoodTypes.POPULUS, properties));
	public static final DeferredHolder<Block, Block> POPULUS_WALL_HANGING_SIGN = IcariaBlocks.register(IcariaBlockIds.POPULUS_WALL_HANGING_SIGN, IcariaBlocks.propertiesSign(MapColor.NONE, SoundType.WOOD), properties -> new IcariaWallHangingSignBlock(IcariaWoodTypes.POPULUS, properties));

	public static final DeferredHolder<Block, Block> BLOOMY_VINE = IcariaBlocks.register(IcariaBlockItemIds.BLOOMY_VINE, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE), IcariaVineBlock::new);
	public static final DeferredHolder<Block, Block> BRANCHY_VINE = IcariaBlocks.register(IcariaBlockItemIds.BRANCHY_VINE, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE), IcariaVineBlock::new);
	public static final DeferredHolder<Block, Block> BRUSHY_VINE = IcariaBlocks.register(IcariaBlockItemIds.BRUSHY_VINE, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE), IcariaVineBlock::new);
	public static final DeferredHolder<Block, Block> DRY_VINE = IcariaBlocks.register(IcariaBlockItemIds.DRY_VINE, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE), IcariaVineBlock::new);
	public static final DeferredHolder<Block, Block> REEDY_VINE = IcariaBlocks.register(IcariaBlockItemIds.REEDY_VINE, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE), IcariaVineBlock::new);
	public static final DeferredHolder<Block, Block> SWIRLY_VINE = IcariaBlocks.register(IcariaBlockItemIds.SWIRLY_VINE, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE), IcariaVineBlock::new);
	public static final DeferredHolder<Block, Block> THORNY_VINE = IcariaBlocks.register(IcariaBlockItemIds.THORNY_VINE, IcariaBlocks.propertiesVine(MapColor.NONE, SoundType.VINE), IcariaVineBlock::new);

	public static final DeferredHolder<Block, Block> SMALL_GRASS = IcariaBlocks.register(IcariaBlockItemIds.SMALL_GRASS, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> MEDIUM_GRASS = IcariaBlocks.register(IcariaBlockItemIds.MEDIUM_GRASS, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> LARGE_GRASS = IcariaBlocks.register(IcariaBlockItemIds.LARGE_GRASS, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);

	public static final DeferredHolder<Block, Block> SMALL_MIXED_GRAIN = IcariaBlocks.register(IcariaBlockItemIds.SMALL_MIXED_GRAIN, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> MEDIUM_MIXED_GRAIN = IcariaBlocks.register(IcariaBlockItemIds.MEDIUM_MIXED_GRAIN, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> MEDIUM_BROWN_GRAIN = IcariaBlocks.register(IcariaBlockItemIds.MEDIUM_BROWN_GRAIN, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> MEDIUM_WHITE_GRAIN = IcariaBlocks.register(IcariaBlockItemIds.MEDIUM_WHITE_GRAIN, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> MEDIUM_YELLOW_GRAIN = IcariaBlocks.register(IcariaBlockItemIds.MEDIUM_YELLOW_GRAIN, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> LARGE_BROWN_GRAIN = IcariaBlocks.register(IcariaBlockItemIds.LARGE_BROWN_GRAIN, IcariaBlocks.propertiesGrass(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);

	public static final DeferredHolder<Block, Block> BLINDWEED = IcariaBlocks.register(IcariaBlockItemIds.BLINDWEED, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_BLINDWEED = IcariaBlocks.register(IcariaBlockIds.POTTED_BLINDWEED, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLINDWEED, properties));
	public static final DeferredHolder<Block, Block> CHAMEOMILE = IcariaBlocks.register(IcariaBlockItemIds.CHAMEOMILE, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_CHAMEOMILE = IcariaBlocks.register(IcariaBlockIds.POTTED_CHAMEOMILE, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CHAMEOMILE, properties));
	public static final DeferredHolder<Block, Block> CHARMONDER = IcariaBlocks.register(IcariaBlockItemIds.CHARMONDER, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_CHARMONDER = IcariaBlocks.register(IcariaBlockIds.POTTED_CHARMONDER, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CHARMONDER, properties));
	public static final DeferredHolder<Block, Block> CLOVER = IcariaBlocks.register(IcariaBlockItemIds.CLOVER, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_CLOVER = IcariaBlocks.register(IcariaBlockIds.POTTED_CLOVER, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CLOVER, properties));
	public static final DeferredHolder<Block, Block> FIREHILT = IcariaBlocks.register(IcariaBlockItemIds.FIREHILT, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_FIREHILT = IcariaBlocks.register(IcariaBlockIds.POTTED_FIREHILT, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.FIREHILT, properties));
	public static final DeferredHolder<Block, Block> BLUE_HYDRACINTH = IcariaBlocks.register(IcariaBlockItemIds.BLUE_HYDRACINTH, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_BLUE_HYDRACINTH = IcariaBlocks.register(IcariaBlockIds.POTTED_BLUE_HYDRACINTH, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLUE_HYDRACINTH, properties));
	public static final DeferredHolder<Block, Block> PURPLE_HYDRACINTH = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_HYDRACINTH, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_HYDRACINTH = IcariaBlocks.register(IcariaBlockIds.POTTED_PURPLE_HYDRACINTH, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_HYDRACINTH, properties));
	public static final DeferredHolder<Block, Block> LIONFANGS = IcariaBlocks.register(IcariaBlockItemIds.LIONFANGS, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_LIONFANGS = IcariaBlocks.register(IcariaBlockIds.POTTED_LIONFANGS, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LIONFANGS, properties));
	public static final DeferredHolder<Block, Block> SPEARDROPS = IcariaBlocks.register(IcariaBlockItemIds.SPEARDROPS, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_SPEARDROPS = IcariaBlocks.register(IcariaBlockIds.POTTED_SPEARDROPS, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SPEARDROPS, properties));
	public static final DeferredHolder<Block, Block> PURPLE_STAGHORN = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_STAGHORN, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), DamagingBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_STAGHORN = IcariaBlocks.register(IcariaBlockIds.POTTED_PURPLE_STAGHORN, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_STAGHORN, properties));
	public static final DeferredHolder<Block, Block> YELLOW_STAGHORN = IcariaBlocks.register(IcariaBlockItemIds.YELLOW_STAGHORN, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), DamagingBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_YELLOW_STAGHORN = IcariaBlocks.register(IcariaBlockIds.POTTED_YELLOW_STAGHORN, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.YELLOW_STAGHORN, properties));
	public static final DeferredHolder<Block, Block> BLUE_STORMCOTTON = IcariaBlocks.register(IcariaBlockItemIds.BLUE_STORMCOTTON, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_BLUE_STORMCOTTON = IcariaBlocks.register(IcariaBlockIds.POTTED_BLUE_STORMCOTTON, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BLUE_STORMCOTTON, properties));
	public static final DeferredHolder<Block, Block> PINK_STORMCOTTON = IcariaBlocks.register(IcariaBlockItemIds.PINK_STORMCOTTON, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_PINK_STORMCOTTON = IcariaBlocks.register(IcariaBlockIds.POTTED_PINK_STORMCOTTON, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PINK_STORMCOTTON, properties));
	public static final DeferredHolder<Block, Block> PURPLE_STORMCOTTON = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_STORMCOTTON, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_STORMCOTTON = IcariaBlocks.register(IcariaBlockIds.POTTED_PURPLE_STORMCOTTON, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_STORMCOTTON, properties));
	public static final DeferredHolder<Block, Block> SUNKETTLE = IcariaBlocks.register(IcariaBlockItemIds.SUNKETTLE, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_SUNKETTLE = IcariaBlocks.register(IcariaBlockIds.POTTED_SUNKETTLE, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SUNKETTLE, properties));
	public static final DeferredHolder<Block, Block> SUNSPONGE = IcariaBlocks.register(IcariaBlockItemIds.SUNSPONGE, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_SUNSPONGE = IcariaBlocks.register(IcariaBlockIds.POTTED_SUNSPONGE, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.SUNSPONGE, properties));
	public static final DeferredHolder<Block, Block> VOIDLILY = IcariaBlocks.register(IcariaBlockItemIds.VOIDLILY, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_VOIDLILY = IcariaBlocks.register(IcariaBlockIds.POTTED_VOIDLILY, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.VOIDLILY, properties));

	public static final DeferredHolder<Block, Block> BOLBOS = IcariaBlocks.register(IcariaBlockItemIds.BOLBOS, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> DATHULLA = IcariaBlocks.register(IcariaBlockItemIds.DATHULLA, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> MONDANOS = IcariaBlocks.register(IcariaBlockItemIds.MONDANOS, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> MOTH_AGARIC = IcariaBlocks.register(IcariaBlockItemIds.MOTH_AGARIC, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> NAMDRAKE = IcariaBlocks.register(IcariaBlockItemIds.NAMDRAKE, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> PSILOCYBOS = IcariaBlocks.register(IcariaBlockItemIds.PSILOCYBOS, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), WaterloggedBushBlock::new);
	public static final DeferredHolder<Block, Block> ROWAN = IcariaBlocks.register(IcariaBlockItemIds.ROWAN, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> WILTED_ELM = IcariaBlocks.register(IcariaBlockItemIds.WILTED_ELM, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);

	public static final DeferredHolder<Block, Block> BLUE_GROUND_FLOWERS = IcariaBlocks.register(IcariaBlockItemIds.BLUE_GROUND_FLOWERS, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS), FlowerBedBlock::new);
	public static final DeferredHolder<Block, Block> CYAN_GROUND_FLOWERS = IcariaBlocks.register(IcariaBlockItemIds.CYAN_GROUND_FLOWERS, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS), FlowerBedBlock::new);
	public static final DeferredHolder<Block, Block> PINK_GROUND_FLOWERS = IcariaBlocks.register(IcariaBlockItemIds.PINK_GROUND_FLOWERS, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS), FlowerBedBlock::new);
	public static final DeferredHolder<Block, Block> PURPLE_GROUND_FLOWERS = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_GROUND_FLOWERS, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS), FlowerBedBlock::new);
	public static final DeferredHolder<Block, Block> RED_GROUND_FLOWERS = IcariaBlocks.register(IcariaBlockItemIds.RED_GROUND_FLOWERS, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS), FlowerBedBlock::new);
	public static final DeferredHolder<Block, Block> WHITE_GROUND_FLOWERS = IcariaBlocks.register(IcariaBlockItemIds.WHITE_GROUND_FLOWERS, IcariaBlocks.propertiesGroundFlower(MapColor.NONE, SoundType.PINK_PETALS), FlowerBedBlock::new);

	public static final DeferredHolder<Block, Block> FOREST_MOSS = IcariaBlocks.register(IcariaBlockItemIds.FOREST_MOSS, IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> SCRUBLAND_MOSS = IcariaBlocks.register(IcariaBlockItemIds.SCRUBLAND_MOSS, IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS), LayerBlock::new);
	public static final DeferredHolder<Block, Block> STEPPE_MOSS = IcariaBlocks.register(IcariaBlockItemIds.STEPPE_MOSS, IcariaBlocks.propertiesMoss(MapColor.TERRACOTTA_LIGHT_GREEN, SoundType.MOSS), LayerBlock::new);

	public static final DeferredHolder<Block, Block> PALM_FERN = IcariaBlocks.register(IcariaBlockItemIds.PALM_FERN, IcariaBlocks.propertiesPalmFern(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_PALM_FERN = IcariaBlocks.register(IcariaBlockIds.POTTED_PALM_FERN, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PALM_FERN, properties));

	public static final DeferredHolder<Block, Block> WHITE_BROMELIA = IcariaBlocks.register(IcariaBlockItemIds.WHITE_BROMELIA, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_WHITE_BROMELIA = IcariaBlocks.register(IcariaBlockIds.POTTED_WHITE_BROMELIA, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.WHITE_BROMELIA, properties));
	public static final DeferredHolder<Block, Block> ORANGE_BROMELIA = IcariaBlocks.register(IcariaBlockItemIds.ORANGE_BROMELIA, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_ORANGE_BROMELIA = IcariaBlocks.register(IcariaBlockIds.POTTED_ORANGE_BROMELIA, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.ORANGE_BROMELIA, properties));
	public static final DeferredHolder<Block, Block> PINK_BROMELIA = IcariaBlocks.register(IcariaBlockItemIds.PINK_BROMELIA, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_PINK_BROMELIA = IcariaBlocks.register(IcariaBlockIds.POTTED_PINK_BROMELIA, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PINK_BROMELIA, properties));
	public static final DeferredHolder<Block, Block> PURPLE_BROMELIA = IcariaBlocks.register(IcariaBlockItemIds.PURPLE_BROMELIA, IcariaBlocks.propertiesPlant(MapColor.NONE, SoundType.GRASS), IcariaBushBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_PURPLE_BROMELIA = IcariaBlocks.register(IcariaBlockIds.POTTED_PURPLE_BROMELIA, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.PURPLE_BROMELIA, properties));

	public static final DeferredHolder<Block, Block> GREEN_GROUND_SHROOMS = IcariaBlocks.register(IcariaBlockItemIds.GREEN_GROUND_SHROOMS, IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS), GroundShroomBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_GREEN_GROUND_SHROOMS = IcariaBlocks.register(IcariaBlockIds.POTTED_GREEN_GROUND_SHROOMS, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.GREEN_GROUND_SHROOMS, properties));
	public static final DeferredHolder<Block, Block> BROWN_GROUND_SHROOMS = IcariaBlocks.register(IcariaBlockItemIds.BROWN_GROUND_SHROOMS, IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS), GroundShroomBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_BROWN_GROUND_SHROOMS = IcariaBlocks.register(IcariaBlockIds.POTTED_BROWN_GROUND_SHROOMS, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.BROWN_GROUND_SHROOMS, properties));
	public static final DeferredHolder<Block, Block> LARGE_BROWN_GROUND_SHROOMS = IcariaBlocks.register(IcariaBlockItemIds.LARGE_BROWN_GROUND_SHROOMS, IcariaBlocks.propertiesGroundShroom(MapColor.NONE, SoundType.GRASS), GroundShroomBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_LARGE_BROWN_GROUND_SHROOMS = IcariaBlocks.register(IcariaBlockIds.POTTED_LARGE_BROWN_GROUND_SHROOMS, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS, properties));

	public static final DeferredHolder<Block, Block> TINDER_FUNGUS_TREE_SHROOMS = IcariaBlocks.register(IcariaBlockItemIds.TINDER_FUNGUS_TREE_SHROOMS, IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS), TreeShroomBlock::new);
	public static final DeferredHolder<Block, Block> TURKEY_TAIL_TREE_SHROOMS = IcariaBlocks.register(IcariaBlockItemIds.TURKEY_TAIL_TREE_SHROOMS, IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS), TreeShroomBlock::new);
	public static final DeferredHolder<Block, Block> UNNAMED_TREE_SHROOMS = IcariaBlocks.register(IcariaBlockItemIds.UNNAMED_TREE_SHROOMS, IcariaBlocks.propertiesTreeShroom(MapColor.NONE, SoundType.GRASS), TreeShroomBlock::new);

	public static final DeferredHolder<Block, Block> CARDON_CACTUS = IcariaBlocks.register(IcariaBlockItemIds.CARDON_CACTUS, IcariaBlocks.propertiesCactus(MapColor.GRASS, SoundType.WOOL), CardonCactusBlock::new);
	public static final DeferredHolder<Block, Block> POTTED_CARDON_CACTUS = IcariaBlocks.register(IcariaBlockIds.POTTED_CARDON_CACTUS, IcariaBlocks.propertiesFlowerPot(MapColor.NONE, SoundType.STONE), properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IcariaBlocks.CARDON_CACTUS, properties));

	public static final DeferredHolder<Block, Block> STRAWBERRY_BUSH = IcariaBlocks.register(IcariaBlockItemIds.STRAWBERRY_BUSH, IcariaBlocks.propertiesBush(MapColor.NONE, SoundType.GRASS), StrawberryBushBlock::new);

	public static final DeferredHolder<Block, Block> ONION = IcariaBlocks.register(IcariaBlockItemIds.ONION, IcariaBlocks.propertiesSeeds(MapColor.NONE, SoundType.CROP), OnionCropBlock::new);
	public static final DeferredHolder<Block, Block> PHYSALIS_SEEDS = IcariaBlocks.register(IcariaBlockItemIds.PHYSALIS_SEEDS, IcariaBlocks.propertiesSeeds(MapColor.NONE, SoundType.CROP), PhysalisCropBlock::new);
	public static final DeferredHolder<Block, Block> SPELT_SEEDS = IcariaBlocks.register(IcariaBlockItemIds.SPELT_SEEDS, IcariaBlocks.propertiesSeeds(MapColor.NONE, SoundType.CROP), SpeltCropBlock::new);
	public static final DeferredHolder<Block, Block> STRAWBERRY_SEEDS = IcariaBlocks.register(IcariaBlockItemIds.STRAWBERRY_SEEDS, IcariaBlocks.propertiesSeeds(MapColor.NONE, SoundType.CROP), StrawberryCropBlock::new);

	public static final DeferredHolder<Block, LiquidBlock> MEDITERRANEAN_WATER = IcariaBlocks.register(IcariaBlockIds.MEDITERRANEAN_WATER, IcariaBlocks.propertiesWater(MapColor.PLANT, SoundType.EMPTY), properties -> new LiquidBlock(IcariaFluids.MEDITERRANEAN_WATER.get(), properties));

	public static final DeferredHolder<Block, Block> GREEK_FIRE = IcariaBlocks.register(IcariaBlockIds.GREEK_FIRE, IcariaBlocks.propertiesFire(MapColor.COLOR_LIGHT_GREEN, SoundType.EMPTY), GreekFireBlock::new);

	public static final DeferredHolder<Block, Block> ICARIA_PORTAL = IcariaBlocks.register(IcariaBlockIds.ICARIA_PORTAL, IcariaBlocks.propertiesPortal(MapColor.NONE, SoundType.GLASS), IcariaPortalBlock::new);

	public static final DeferredHolder<Block, Block> GRINDER_SHAFT = IcariaBlocks.register(IcariaBlockItemIds.GRINDER_SHAFT, IcariaBlocks.propertiesNone(), Block::new);
	public static final DeferredHolder<Block, Block> GRINDER_STONE = IcariaBlocks.register(IcariaBlockItemIds.GRINDER_STONE, IcariaBlocks.propertiesNone(), Block::new);

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

	public static BlockPos postProcessSelf(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return pBlockPos;
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

	public static BlockBehaviour.Properties propertiesFloorDecoration(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision().noOcclusion().replaceable();
	}

	public static BlockBehaviour.Properties propertiesSurfaceLignite(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).ignitedByLava().instabreak().noCollision().noOcclusion().replaceable();
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

	public static BlockBehaviour.Properties propertiesCluster(MapColor pMapColor, SoundType pSoundType) {
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

	public static BlockBehaviour.Properties propertiesTerryBlock(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.GUITAR).mapColor(pMapColor).pushReaction(PushReaction.NORMAL).sound(pSoundType).destroyTime(0.8F).explosionResistance(0.8F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesTerryMat(MapColor pMapColor, SoundType pSoundType) {
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
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesVase(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).instabreak();
	}

	public static BlockBehaviour.Properties propertiesLootVase(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).instabreak().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesSpawner(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(5.0F).explosionResistance(5.0F).noOcclusion().requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesCobweb(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.25F).explosionResistance(0.25F).noCollision();
	}

	public static BlockBehaviour.Properties propertiesLadder(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.4F).explosionResistance(0.4F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesSkull(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F);
	}

	public static BlockBehaviour.Properties propertiesTorch(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesCake(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F);
	}

	public static BlockBehaviour.Properties propertiesJar(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak();
	}

	public static BlockBehaviour.Properties propertiesFlask(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesPot(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).requiresCorrectToolForDrops();
	}

	public static BlockBehaviour.Properties propertiesTableDecoration(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesChessboard(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak();
	}

	public static BlockBehaviour.Properties propertiesSapling(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesFlowerPot(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesLeaves(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.2F).explosionResistance(0.2F).isRedstoneConductor(IcariaBlocks::never).isSuffocating(IcariaBlocks::never).isValidSpawn(IcariaBlocks::never).isViewBlocking(IcariaBlocks::never).ignitedByLava().noOcclusion().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesTwigs(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).ignitedByLava().instabreak().noCollision().noOcclusion().replaceable();
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
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).bounceRestitution(0.75F).destroyTime(2.0F).explosionResistance(3.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesCuttingBoard(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
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

	public static BlockBehaviour.Properties propertiesHutch(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesKitchenTable(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
	}

	public static BlockBehaviour.Properties propertiesKline(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).bounceRestitution(0.75F).destroyTime(1.0F).explosionResistance(1.0F).noOcclusion();
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
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F).forceSolidOn().noCollision();
	}

	public static BlockBehaviour.Properties propertiesButton(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.5F).explosionResistance(0.5F).noCollision();
	}

	public static BlockBehaviour.Properties propertiesSign(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(1.0F).explosionResistance(1.0F).noCollision();
	}

	public static BlockBehaviour.Properties propertiesShelf(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(2.0F).explosionResistance(3.0F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesVine(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.2F).explosionResistance(0.2F).ignitedByLava().noCollision().randomTicks().replaceable();
	}

	public static BlockBehaviour.Properties propertiesGrass(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().instabreak().noCollision().replaceable();
	}

	public static BlockBehaviour.Properties propertiesPlant(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesGroundFlower(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesMoss(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.1F).explosionResistance(0.1F).ignitedByLava();
	}

	public static BlockBehaviour.Properties propertiesPalmFern(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesGroundShroom(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).postProcess(IcariaBlocks::postProcessSelf).instabreak().noCollision().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesTreeShroom(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision();
	}

	public static BlockBehaviour.Properties propertiesCactus(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(0.4F).explosionResistance(0.4F).randomTicks();
	}

	public static BlockBehaviour.Properties propertiesBush(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).offsetType(BlockBehaviour.OffsetType.XZ).instabreak().noCollision().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesSeeds(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).instabreak().noCollision().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesWater(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).destroyTime(100.0F).explosionResistance(100.0F).noCollision().liquid().replaceable();
	}

	public static BlockBehaviour.Properties propertiesFire(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.DESTROY).sound(pSoundType).lightLevel(blockState -> 15).instabreak().noCollision().noTerrainParticles().replaceable();
	}

	public static BlockBehaviour.Properties propertiesPortal(MapColor pMapColor, SoundType pSoundType) {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).mapColor(pMapColor).pushReaction(PushReaction.BLOCK).sound(pSoundType).destroyTime(-1.0F).explosionResistance(-1.0F).lightLevel(blockState -> 11).noCollision().randomTicks();
	}

	public static BlockBehaviour.Properties propertiesNone() {
		return BlockBehaviour.Properties.of();
	}

	public static <T extends Block> DeferredHolder<Block, T> register(BlockItemId pBlockItemId, BlockBehaviour.Properties pProperties, Function<BlockBehaviour.Properties, T> pFunction) {
		return IcariaBlocks.BLOCKS.register(pBlockItemId.block().identifier().getPath(), () -> pFunction.apply(pProperties.setId(pBlockItemId.block())));
	}

	public static <T extends Block> DeferredHolder<Block, T> register(ResourceKey<Block> pResourceKey, BlockBehaviour.Properties pProperties, Function<BlockBehaviour.Properties, T> pFunction) {
		return IcariaBlocks.BLOCKS.register(pResourceKey.identifier().getPath(), () -> pFunction.apply(pProperties.setId(pResourceKey)));
	}
}
