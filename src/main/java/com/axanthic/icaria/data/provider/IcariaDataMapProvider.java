package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.map.Freezable;
import com.axanthic.icaria.data.map.GrinderFuel;
import com.axanthic.icaria.data.map.Pottable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.CopyPropertiesProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedStateProvider;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Flammable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Transformable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDataMapProvider extends DataMapProvider {
	public IcariaDataMapProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
		super(pPackOutput, pProvider);
	}

	@Override
	public void gather(HolderLookup.Provider pProvider) {
		this.flammables();
		this.freezables();
		this.grinderFuels();
		this.pottables();
		this.transformables();
	}

	public void flammables() {
		this.flammables(IcariaBlocks.LIGNITE_RUBBLE.get(), 30, 60);
		this.flammables(IcariaBlocks.TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.WHITE_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.LIGHT_GRAY_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.GRAY_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.BLACK_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.BROWN_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.RED_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.ORANGE_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.YELLOW_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.LIME_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.GREEN_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.CYAN_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.LIGHT_BLUE_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.BLUE_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.PURPLE_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.MAGENTA_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.PINK_TERRY_BLOCK.get(), 30, 60);
		this.flammables(IcariaBlocks.TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.WHITE_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.LIGHT_GRAY_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.GRAY_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.BLACK_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.BROWN_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.RED_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.ORANGE_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.YELLOW_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.LIME_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.GREEN_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.CYAN_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.LIGHT_BLUE_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.BLUE_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.PURPLE_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.MAGENTA_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.PINK_TERRY_MAT.get(), 60, 20);
		this.flammables(IcariaBlocks.SPELT_BLOCK.get(), 60, 20);
		this.flammables(IcariaBlocks.VINE_REED_BLOCK.get(), 5, 20);
		this.flammables(IcariaBlocks.LIGNITE_BLOCK.get(), 5, 5);
		this.flammables(IcariaBlocks.ANTHRACITE_BLOCK.get(), 5, 5);
		this.flammables(IcariaBlocks.CYPRESS_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.CYPRESS_TWIGS.get(), 30, 60);
		this.flammables(IcariaBlocks.CYPRESS_FIREWOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.CYPRESS_FIREWOOD_WEDGE.get(), 5, 5);
		this.flammables(IcariaBlocks.CYPRESS_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.CYPRESS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DEAD_CYPRESS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.CYPRESS_PLANKS.get(), 5, 20);
		this.flammables(IcariaBlocks.CYPRESS_STAIRS.get(), 5, 20);
		this.flammables(IcariaBlocks.CYPRESS_SLAB.get(), 5, 20);
		this.flammables(IcariaBlocks.CYPRESS_FENCE.get(), 5, 20);
		this.flammables(IcariaBlocks.CYPRESS_FENCE_GATE.get(), 5, 20);
		this.flammables(IcariaBlocks.CYPRESS_SCROLLSHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.CYPRESS_SHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.DROUGHTROOT_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.DROUGHTROOT_TWIGS.get(), 30, 60);
		this.flammables(IcariaBlocks.DROUGHTROOT_FIREWOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.DROUGHTROOT_FIREWOOD_WEDGE.get(), 5, 5);
		this.flammables(IcariaBlocks.DROUGHTROOT_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.DROUGHTROOT_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DROUGHTROOT_PLANKS.get(), 5, 20);
		this.flammables(IcariaBlocks.DROUGHTROOT_STAIRS.get(), 5, 20);
		this.flammables(IcariaBlocks.DROUGHTROOT_SLAB.get(), 5, 20);
		this.flammables(IcariaBlocks.DROUGHTROOT_FENCE.get(), 5, 20);
		this.flammables(IcariaBlocks.DROUGHTROOT_FENCE_GATE.get(), 5, 20);
		this.flammables(IcariaBlocks.DROUGHTROOT_SCROLLSHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.DROUGHTROOT_SHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.FIR_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FALLEN_FIR_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FIR_TWIGS.get(), 30, 60);
		this.flammables(IcariaBlocks.FIR_FIREWOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.FIR_FIREWOOD_WEDGE.get(), 5, 5);
		this.flammables(IcariaBlocks.FIR_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_FIR_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.FIR_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_FIR_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DEAD_FIR_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.FIR_PLANKS.get(), 5, 20);
		this.flammables(IcariaBlocks.FIR_STAIRS.get(), 5, 20);
		this.flammables(IcariaBlocks.FIR_SLAB.get(), 5, 20);
		this.flammables(IcariaBlocks.FIR_FENCE.get(), 5, 20);
		this.flammables(IcariaBlocks.FIR_FENCE_GATE.get(), 5, 20);
		this.flammables(IcariaBlocks.FIR_SCROLLSHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.FIR_SHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.LAUREL_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.LAUREL_TWIGS.get(), 30, 60);
		this.flammables(IcariaBlocks.LAUREL_FIREWOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.LAUREL_FIREWOOD_WEDGE.get(), 5, 5);
		this.flammables(IcariaBlocks.LAUREL_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.LAUREL_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DEAD_LAUREL_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.LAUREL_PLANKS.get(), 5, 20);
		this.flammables(IcariaBlocks.LAUREL_STAIRS.get(), 5, 20);
		this.flammables(IcariaBlocks.LAUREL_SLAB.get(), 5, 20);
		this.flammables(IcariaBlocks.LAUREL_FENCE.get(), 5, 20);
		this.flammables(IcariaBlocks.LAUREL_FENCE_GATE.get(), 5, 20);
		this.flammables(IcariaBlocks.LAUREL_SCROLLSHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.LAUREL_SHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.OLIVE_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.OLIVE_TWIGS.get(), 30, 60);
		this.flammables(IcariaBlocks.OLIVE_FIREWOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.OLIVE_FIREWOOD_WEDGE.get(), 5, 5);
		this.flammables(IcariaBlocks.OLIVE_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.OLIVE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DEAD_OLIVE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.OLIVE_PLANKS.get(), 5, 20);
		this.flammables(IcariaBlocks.OLIVE_STAIRS.get(), 5, 20);
		this.flammables(IcariaBlocks.OLIVE_SLAB.get(), 5, 20);
		this.flammables(IcariaBlocks.OLIVE_FENCE.get(), 5, 20);
		this.flammables(IcariaBlocks.OLIVE_FENCE_GATE.get(), 5, 20);
		this.flammables(IcariaBlocks.OLIVE_SCROLLSHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.OLIVE_SHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.PLANE_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.PLANE_TWIGS.get(), 30, 60);
		this.flammables(IcariaBlocks.PLANE_FIREWOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.PLANE_FIREWOOD_WEDGE.get(), 5, 5);
		this.flammables(IcariaBlocks.PLANE_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.PLANE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_PLANE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DEAD_PLANE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.PLANE_PLANKS.get(), 5, 20);
		this.flammables(IcariaBlocks.PLANE_STAIRS.get(), 5, 20);
		this.flammables(IcariaBlocks.PLANE_SLAB.get(), 5, 20);
		this.flammables(IcariaBlocks.PLANE_FENCE.get(), 5, 20);
		this.flammables(IcariaBlocks.PLANE_FENCE_GATE.get(), 5, 20);
		this.flammables(IcariaBlocks.PLANE_SCROLLSHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.PLANE_SHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.POPULUS_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), 30, 60);
		this.flammables(IcariaBlocks.POPULUS_TWIGS.get(), 30, 60);
		this.flammables(IcariaBlocks.POPULUS_FIREWOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.POPULUS_FIREWOOD_WEDGE.get(), 5, 5);
		this.flammables(IcariaBlocks.POPULUS_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), 5, 5);
		this.flammables(IcariaBlocks.POPULUS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.DEAD_POPULUS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), 5, 5);
		this.flammables(IcariaBlocks.POPULUS_PLANKS.get(), 5, 20);
		this.flammables(IcariaBlocks.POPULUS_STAIRS.get(), 5, 20);
		this.flammables(IcariaBlocks.POPULUS_SLAB.get(), 5, 20);
		this.flammables(IcariaBlocks.POPULUS_FENCE.get(), 5, 20);
		this.flammables(IcariaBlocks.POPULUS_FENCE_GATE.get(), 5, 20);
		this.flammables(IcariaBlocks.POPULUS_SCROLLSHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.POPULUS_SHELF.get(), 30, 20);
		this.flammables(IcariaBlocks.BLOOMY_VINE.get(), 15, 100);
		this.flammables(IcariaBlocks.BRANCHY_VINE.get(), 15, 100);
		this.flammables(IcariaBlocks.BRUSHY_VINE.get(), 15, 100);
		this.flammables(IcariaBlocks.DRY_VINE.get(), 15, 100);
		this.flammables(IcariaBlocks.REEDY_VINE.get(), 15, 100);
		this.flammables(IcariaBlocks.SWIRLY_VINE.get(), 15, 100);
		this.flammables(IcariaBlocks.THORNY_VINE.get(), 15, 100);
		this.flammables(IcariaBlocks.SMALL_GRASS.get(), 60, 100);
		this.flammables(IcariaBlocks.MEDIUM_GRASS.get(), 60, 100);
		this.flammables(IcariaBlocks.LARGE_GRASS.get(), 60, 100);
		this.flammables(IcariaBlocks.SMALL_MIXED_GRAIN.get(), 60, 100);
		this.flammables(IcariaBlocks.MEDIUM_MIXED_GRAIN.get(), 60, 100);
		this.flammables(IcariaBlocks.MEDIUM_BROWN_GRAIN.get(), 60, 100);
		this.flammables(IcariaBlocks.MEDIUM_WHITE_GRAIN.get(), 60, 100);
		this.flammables(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get(), 60, 100);
		this.flammables(IcariaBlocks.LARGE_BROWN_GRAIN.get(), 60, 100);
		this.flammables(IcariaBlocks.BLINDWEED.get(), 60, 100);
		this.flammables(IcariaBlocks.CHAMEOMILE.get(), 60, 100);
		this.flammables(IcariaBlocks.CHARMONDER.get(), 60, 100);
		this.flammables(IcariaBlocks.CLOVER.get(), 60, 100);
		this.flammables(IcariaBlocks.FIREHILT.get(), 60, 100);
		this.flammables(IcariaBlocks.BLUE_HYDRACINTH.get(), 60, 100);
		this.flammables(IcariaBlocks.PURPLE_HYDRACINTH.get(), 60, 100);
		this.flammables(IcariaBlocks.LIONFANGS.get(), 60, 100);
		this.flammables(IcariaBlocks.SPEARDROPS.get(), 60, 100);
		this.flammables(IcariaBlocks.PURPLE_STAGHORN.get(), 60, 100);
		this.flammables(IcariaBlocks.YELLOW_STAGHORN.get(), 60, 100);
		this.flammables(IcariaBlocks.BLUE_STORMCOTTON.get(), 60, 100);
		this.flammables(IcariaBlocks.PINK_STORMCOTTON.get(), 60, 100);
		this.flammables(IcariaBlocks.PURPLE_STORMCOTTON.get(), 60, 100);
		this.flammables(IcariaBlocks.SUNKETTLE.get(), 60, 100);
		this.flammables(IcariaBlocks.SUNSPONGE.get(), 60, 100);
		this.flammables(IcariaBlocks.VOIDLILY.get(), 60, 100);
		this.flammables(IcariaBlocks.BOLBOS.get(), 60, 100);
		this.flammables(IcariaBlocks.DATHULLA.get(), 60, 100);
		this.flammables(IcariaBlocks.MONDANOS.get(), 60, 100);
		this.flammables(IcariaBlocks.MOTH_AGARIC.get(), 60, 100);
		this.flammables(IcariaBlocks.NAMDRAKE.get(), 60, 100);
		this.flammables(IcariaBlocks.PSILOCYBOS.get(), 60, 100);
		this.flammables(IcariaBlocks.ROWAN.get(), 60, 100);
		this.flammables(IcariaBlocks.WILTED_ELM.get(), 60, 100);
		this.flammables(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), 60, 100);
		this.flammables(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), 60, 100);
		this.flammables(IcariaBlocks.PINK_GROUND_FLOWERS.get(), 60, 100);
		this.flammables(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), 60, 100);
		this.flammables(IcariaBlocks.RED_GROUND_FLOWERS.get(), 60, 100);
		this.flammables(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), 60, 100);
		this.flammables(IcariaBlocks.FOREST_MOSS.get(), 5, 100);
		this.flammables(IcariaBlocks.SCRUBLAND_MOSS.get(), 5, 100);
		this.flammables(IcariaBlocks.STEPPE_MOSS.get(), 5, 100);
		this.flammables(IcariaBlocks.PALM_FERN.get(), 60, 100);
		this.flammables(IcariaBlocks.WHITE_BROMELIA.get(), 60, 100);
		this.flammables(IcariaBlocks.ORANGE_BROMELIA.get(), 60, 100);
		this.flammables(IcariaBlocks.PINK_BROMELIA.get(), 60, 100);
		this.flammables(IcariaBlocks.PURPLE_BROMELIA.get(), 60, 100);
		this.flammables(IcariaBlocks.STRAWBERRY_BUSH.get(), 60, 100);
	}

	public void freezables() {
		this.freezables(Fluids.WATER, Blocks.ICE);
		this.freezables(IcariaFluids.MEDITERRANEAN_WATER.get(), IcariaBlocks.ARISTONE.get());
	}

	public void grinderFuels() {
		this.grinderFuels(IcariaItems.SLIVER_BLOCK.get(), 8000);
		this.grinderFuels(IcariaItems.SLIVER.get(), 800);
	}

	public void pottables() {
		this.pottables(Items.TORCHFLOWER, Blocks.POTTED_TORCHFLOWER);
		this.pottables(Items.OAK_SAPLING, Blocks.POTTED_OAK_SAPLING);
		this.pottables(Items.SPRUCE_SAPLING, Blocks.POTTED_SPRUCE_SAPLING);
		this.pottables(Items.BIRCH_SAPLING, Blocks.POTTED_BIRCH_SAPLING);
		this.pottables(Items.JUNGLE_SAPLING, Blocks.POTTED_JUNGLE_SAPLING);
		this.pottables(Items.ACACIA_SAPLING, Blocks.POTTED_ACACIA_SAPLING);
		this.pottables(Items.CHERRY_SAPLING, Blocks.POTTED_CHERRY_SAPLING);
		this.pottables(Items.DARK_OAK_SAPLING, Blocks.POTTED_DARK_OAK_SAPLING);
		this.pottables(Items.PALE_OAK_SAPLING, Blocks.POTTED_PALE_OAK_SAPLING);
		this.pottables(Items.MANGROVE_PROPAGULE, Blocks.POTTED_MANGROVE_PROPAGULE);
		this.pottables(Items.POPLAR_SAPLING, Blocks.POTTED_POPLAR_SAPLING);
		this.pottables(Items.FERN, Blocks.POTTED_FERN);
		this.pottables(Items.DANDELION, Blocks.POTTED_DANDELION);
		this.pottables(Items.GOLDEN_DANDELION, Blocks.POTTED_GOLDEN_DANDELION);
		this.pottables(Items.POPPY, Blocks.POTTED_POPPY);
		this.pottables(Items.BLUE_ORCHID, Blocks.POTTED_BLUE_ORCHID);
		this.pottables(Items.ALLIUM, Blocks.POTTED_ALLIUM);
		this.pottables(Items.AZURE_BLUET, Blocks.POTTED_AZURE_BLUET);
		this.pottables(Items.RED_TULIP, Blocks.POTTED_RED_TULIP);
		this.pottables(Items.ORANGE_TULIP, Blocks.POTTED_ORANGE_TULIP);
		this.pottables(Items.WHITE_TULIP, Blocks.POTTED_WHITE_TULIP);
		this.pottables(Items.PINK_TULIP, Blocks.POTTED_PINK_TULIP);
		this.pottables(Items.OXEYE_DAISY, Blocks.POTTED_OXEYE_DAISY);
		this.pottables(Items.CORNFLOWER, Blocks.POTTED_CORNFLOWER);
		this.pottables(Items.LILY_OF_THE_VALLEY, Blocks.POTTED_LILY_OF_THE_VALLEY);
		this.pottables(Items.WITHER_ROSE, Blocks.POTTED_WITHER_ROSE);
		this.pottables(Items.RED_MUSHROOM, Blocks.POTTED_RED_MUSHROOM);
		this.pottables(Items.BROWN_MUSHROOM, Blocks.POTTED_BROWN_MUSHROOM);
		this.pottables(Items.DEAD_BUSH, Blocks.POTTED_DEAD_BUSH);
		this.pottables(Items.CACTUS, Blocks.POTTED_CACTUS);
		this.pottables(Items.BAMBOO, Blocks.POTTED_BAMBOO);
		this.pottables(Items.CRIMSON_FUNGUS, Blocks.POTTED_CRIMSON_FUNGUS);
		this.pottables(Items.WARPED_FUNGUS, Blocks.POTTED_WARPED_FUNGUS);
		this.pottables(Items.CRIMSON_ROOTS, Blocks.POTTED_CRIMSON_ROOTS);
		this.pottables(Items.WARPED_ROOTS, Blocks.POTTED_WARPED_ROOTS);
		this.pottables(Items.AZALEA, Blocks.POTTED_AZALEA);
		this.pottables(Items.FLOWERING_AZALEA, Blocks.POTTED_FLOWERING_AZALEA);
		this.pottables(Items.OPEN_EYEBLOSSOM, Blocks.POTTED_OPEN_EYEBLOSSOM);
		this.pottables(Items.CLOSED_EYEBLOSSOM, Blocks.POTTED_CLOSED_EYEBLOSSOM);
		this.pottables(IcariaItems.CYPRESS_SAPLING.get(), IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		this.pottables(IcariaItems.DROUGHTROOT_SAPLING.get(), IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		this.pottables(IcariaItems.FIR_SAPLING.get(), IcariaBlocks.POTTED_FIR_SAPLING.get());
		this.pottables(IcariaItems.LAUREL_SAPLING.get(), IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		this.pottables(IcariaItems.OLIVE_SAPLING.get(), IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		this.pottables(IcariaItems.PLANE_SAPLING.get(), IcariaBlocks.POTTED_PLANE_SAPLING.get());
		this.pottables(IcariaItems.POPULUS_SAPLING.get(), IcariaBlocks.POTTED_POPULUS_SAPLING.get());
		this.pottables(IcariaItems.BLINDWEED.get(), IcariaBlocks.POTTED_BLINDWEED.get());
		this.pottables(IcariaItems.CHAMEOMILE.get(), IcariaBlocks.POTTED_CHAMEOMILE.get());
		this.pottables(IcariaItems.CHARMONDER.get(), IcariaBlocks.POTTED_CHARMONDER.get());
		this.pottables(IcariaItems.CLOVER.get(), IcariaBlocks.POTTED_CLOVER.get());
		this.pottables(IcariaItems.FIREHILT.get(), IcariaBlocks.POTTED_FIREHILT.get());
		this.pottables(IcariaItems.BLUE_HYDRACINTH.get(), IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		this.pottables(IcariaItems.PURPLE_HYDRACINTH.get(), IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		this.pottables(IcariaItems.LIONFANGS.get(), IcariaBlocks.POTTED_LIONFANGS.get());
		this.pottables(IcariaItems.SPEARDROPS.get(), IcariaBlocks.POTTED_SPEARDROPS.get());
		this.pottables(IcariaItems.PURPLE_STAGHORN.get(), IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		this.pottables(IcariaItems.YELLOW_STAGHORN.get(), IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		this.pottables(IcariaItems.BLUE_STORMCOTTON.get(), IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		this.pottables(IcariaItems.PINK_STORMCOTTON.get(), IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		this.pottables(IcariaItems.PURPLE_STORMCOTTON.get(), IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		this.pottables(IcariaItems.SUNKETTLE.get(), IcariaBlocks.POTTED_SUNKETTLE.get());
		this.pottables(IcariaItems.SUNSPONGE.get(), IcariaBlocks.POTTED_SUNSPONGE.get());
		this.pottables(IcariaItems.VOIDLILY.get(), IcariaBlocks.POTTED_VOIDLILY.get());
		this.pottables(IcariaItems.PALM_FERN.get(), IcariaBlocks.POTTED_PALM_FERN.get());
		this.pottables(IcariaItems.WHITE_BROMELIA.get(), IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		this.pottables(IcariaItems.ORANGE_BROMELIA.get(), IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		this.pottables(IcariaItems.PINK_BROMELIA.get(), IcariaBlocks.POTTED_PINK_BROMELIA.get());
		this.pottables(IcariaItems.PURPLE_BROMELIA.get(), IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
		this.pottables(IcariaItems.GREEN_GROUND_SHROOMS.get(), IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get());
		this.pottables(IcariaItems.BROWN_GROUND_SHROOMS.get(), IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get());
		this.pottables(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get(), IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get());
		this.pottables(IcariaItems.CARDON_CACTUS.get(), IcariaBlocks.POTTED_CARDON_CACTUS.get());
	}

	public void transformables() {
		this.transformables(IcariaBlocks.GRASSY_MARL.get(), Map.of(BlockTransformers.HOE, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.GRASSY_MARL.get())), IcariaBlocks.FARMLAND.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.HOE_TILL).build(), BlockTransformers.SHOVEL, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.GRASSY_MARL.get())), IcariaBlocks.MARL_PATH.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.SHOVEL_FLATTEN).build()));
		this.transformables(IcariaBlocks.MARL.get(), Map.of(BlockTransformers.HOE, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.MARL.get())), IcariaBlocks.FARMLAND.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.HOE_TILL).build(), BlockTransformers.SHOVEL, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.MARL.get())), IcariaBlocks.MARL_PATH.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.SHOVEL_FLATTEN).build()));
		this.transformables(IcariaBlocks.COARSE_MARL.get(), Map.of(BlockTransformers.HOE, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.COARSE_MARL.get())), IcariaBlocks.MARL.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.HOE_TILL).build(), BlockTransformers.SHOVEL, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.COARSE_MARL.get())), IcariaBlocks.MARL_PATH.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.SHOVEL_FLATTEN).build()));
		this.transformables(IcariaBlocks.DRY_LAKE_BED.get(), Map.of(BlockTransformers.HOE, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.DRY_LAKE_BED.get())), IcariaBlocks.COARSE_MARL.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.HOE_TILL).build(), BlockTransformers.SHOVEL, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.DRY_LAKE_BED.get())), IcariaBlocks.MARL_PATH.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.SHOVEL_FLATTEN).build()));
		this.transformables(IcariaBlocks.MARL_PATH.get(), Map.of(BlockTransformers.HOE, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.MARL_PATH.get())), IcariaBlocks.FARMLAND.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.HOE_TILL).build()));
		this.transformables(IcariaBlocks.LOAM.get(), Map.of(BlockTransformers.SHOVEL, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.LOAM.get())), IcariaBlocks.LOAM_PATH.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.SHOVEL_FLATTEN).build()));
		this.transformables(IcariaBlocks.GRAINEL.get(), Map.of(BlockTransformers.SHOVEL, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.GRAINEL.get())), IcariaBlocks.GRAINEL_PATH.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.SHOVEL_FLATTEN).build()));
		this.transformables(IcariaBlocks.SILKSAND.get(), Map.of(BlockTransformers.SHOVEL, BlockTransformer.BlockTransformData.builder(BlockPredicate.allOf(BlockPredicate.matchesBlocks(Direction.UP, Blocks.AIR), BlockPredicate.matchesBlocks(IcariaBlocks.SILKSAND.get())), IcariaBlocks.SILKSAND_PATH.get()).disallowedFaces(List.of(Direction.DOWN)).sound(SoundEvents.SHOVEL_FLATTEN).build()));
		this.transformables(IcariaBlocks.CYPRESS_WOOD.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.CYPRESS_WOOD.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.CYPRESS_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.CYPRESS_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_CYPRESS_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DEAD_CYPRESS_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DEAD_CYPRESS_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DROUGHTROOT_WOOD.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DROUGHTROOT_WOOD.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DROUGHTROOT_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DROUGHTROOT_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.FIR_WOOD.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.FIR_WOOD.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_FIR_WOOD.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.FIR_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.FIR_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_FIR_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DEAD_FIR_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DEAD_FIR_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.LAUREL_WOOD.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.LAUREL_WOOD.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_LAUREL_WOOD.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.LAUREL_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.LAUREL_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_LAUREL_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DEAD_LAUREL_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DEAD_LAUREL_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.OLIVE_WOOD.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.OLIVE_WOOD.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_OLIVE_WOOD.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.OLIVE_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.OLIVE_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_OLIVE_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DEAD_OLIVE_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DEAD_OLIVE_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.PLANE_WOOD.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.PLANE_WOOD.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_PLANE_WOOD.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.PLANE_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.PLANE_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_PLANE_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DEAD_PLANE_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DEAD_PLANE_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.POPULUS_WOOD.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.POPULUS_WOOD.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_POPULUS_WOOD.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.POPULUS_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.POPULUS_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_POPULUS_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
		this.transformables(IcariaBlocks.DEAD_POPULUS_LOG.get(), Map.of(BlockTransformers.AXE, BlockTransformer.BlockTransformData.builder(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesBlocks(IcariaBlocks.DEAD_POPULUS_LOG.get()), new CopyPropertiesProvider(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get()))).sound(SoundEvents.AXE_STRIP).build()));
	}

	public void flammables(Block pBlock, int pIgniteOdds, int pBurnOdds) {
		this.builder(NeoForgeDataMaps.FLAMMABLE).add(BuiltInRegistries.BLOCK.getKey(pBlock), new Flammable(pIgniteOdds, pBurnOdds), false);
	}

	public void freezables(Fluid pFluid, Block pBlock) {
		this.builder(IcariaDataMapTypes.FREEZABLES).add(BuiltInRegistries.FLUID.getKey(pFluid), new Freezable(pBlock), false);
	}

	public void grinderFuels(Item pItem, int pBurnTime) {
		this.builder(IcariaDataMapTypes.GRINDER_FUELS).add(BuiltInRegistries.ITEM.getKey(pItem), new GrinderFuel(pBurnTime), false);
	}

	public void pottables(Item pItem, Block pBlock) {
		this.builder(IcariaDataMapTypes.POTTABLES).add(BuiltInRegistries.ITEM.getKey(pItem), new Pottable(pBlock), false);
	}

	public void transformables(Block pBlock, Map<ResourceKey<BlockTransformer>, BlockTransformer.BlockTransformData> pMap) {
		this.builder(NeoForgeDataMaps.TRANSFORMABLES).add(BuiltInRegistries.BLOCK.getKey(pBlock), new Transformable(pMap), false);
	}
}
