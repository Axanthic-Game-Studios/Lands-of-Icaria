package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.datamap.Freezable;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDataMapProvider extends DataMapProvider {
	public IcariaDataMapProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
		super(pPackOutput, pProvider);
	}

	@Override
	public void gather(HolderLookup.Provider pProvider) {
		this.compostables();
		this.freezables();
		this.furnaceFuels();
	}

	public void compostables() {
		this.compostables(IcariaItems.SPELT_BALE_BLOCK.get(), 0.85F);
		this.compostables(IcariaItems.VINE_REED_BLOCK.get(), 0.85F);
		this.compostables(IcariaItems.LAUREL_CHERRY_CAKE.get(), 1.0F);
		this.compostables(IcariaItems.STRAWBERRY_CAKE.get(), 1.0F);
		this.compostables(IcariaItems.PHYSALIS_CAKE.get(), 1.0F);
		this.compostables(IcariaItems.VINE_BERRY_CAKE.get(), 1.0F);
		this.compostables(IcariaItems.VINE_SPROUT_CAKE.get(), 1.0F);
		this.compostables(IcariaItems.CYPRESS_SAPLING.get(), 0.3F);
		this.compostables(IcariaItems.CYPRESS_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FALLEN_CYPRESS_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.CYPRESS_TWIGS.get(), 0.3F);
		this.compostables(IcariaItems.DROUGHTROOT_SAPLING.get(), 0.3F);
		this.compostables(IcariaItems.DROUGHTROOT_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FALLEN_DROUGHTROOT_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.DROUGHTROOT_TWIGS.get(), 0.3F);
		this.compostables(IcariaItems.FIR_SAPLING.get(), 0.3F);
		this.compostables(IcariaItems.FIR_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FALLEN_FIR_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FIR_TWIGS.get(), 0.3F);
		this.compostables(IcariaItems.LAUREL_SAPLING.get(), 0.3F);
		this.compostables(IcariaItems.LAUREL_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FALLEN_LAUREL_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.LAUREL_TWIGS.get(), 0.3F);
		this.compostables(IcariaItems.OLIVE_SAPLING.get(), 0.3F);
		this.compostables(IcariaItems.OLIVE_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FALLEN_OLIVE_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.OLIVE_TWIGS.get(), 0.3F);
		this.compostables(IcariaItems.PLANE_SAPLING.get(), 0.3F);
		this.compostables(IcariaItems.PLANE_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FALLEN_PLANE_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.PLANE_TWIGS.get(), 0.3F);
		this.compostables(IcariaItems.POPULUS_SAPLING.get(), 0.3F);
		this.compostables(IcariaItems.POPULUS_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.FALLEN_POPULUS_LEAVES.get(), 0.3F);
		this.compostables(IcariaItems.POPULUS_TWIGS.get(), 0.3F);
		this.compostables(IcariaItems.BLOOMY_VINE.get(), 0.5F);
		this.compostables(IcariaItems.BRANCHY_VINE.get(), 0.5F);
		this.compostables(IcariaItems.BRUSHY_VINE.get(), 0.5F);
		this.compostables(IcariaItems.DRY_VINE.get(), 0.5F);
		this.compostables(IcariaItems.REEDY_VINE.get(), 0.5F);
		this.compostables(IcariaItems.SWIRLY_VINE.get(), 0.5F);
		this.compostables(IcariaItems.THORNY_VINE.get(), 0.5F);
		this.compostables(IcariaItems.FERN.get(), 0.65F);
		this.compostables(IcariaItems.SMALL_GRASS.get(), 0.3F);
		this.compostables(IcariaItems.MEDIUM_GRASS.get(), 0.3F);
		this.compostables(IcariaItems.LARGE_GRASS.get(), 0.3F);
		this.compostables(IcariaItems.SMALL_MIXED_GRAIN.get(), 0.3F);
		this.compostables(IcariaItems.MEDIUM_MIXED_GRAIN.get(), 0.3F);
		this.compostables(IcariaItems.MEDIUM_BROWN_GRAIN.get(), 0.3F);
		this.compostables(IcariaItems.MEDIUM_WHITE_GRAIN.get(), 0.3F);
		this.compostables(IcariaItems.MEDIUM_YELLOW_GRAIN.get(), 0.3F);
		this.compostables(IcariaItems.LARGE_BROWN_GRAIN.get(), 0.3F);
		this.compostables(IcariaItems.BLINDWEED.get(), 0.3F);
		this.compostables(IcariaItems.CHAMEOMILE.get(), 0.3F);
		this.compostables(IcariaItems.CHARMONDER.get(), 0.3F);
		this.compostables(IcariaItems.CLOVER.get(), 0.3F);
		this.compostables(IcariaItems.FIREHILT.get(), 0.3F);
		this.compostables(IcariaItems.BLUE_HYDRACINTH.get(), 0.3F);
		this.compostables(IcariaItems.PURPLE_HYDRACINTH.get(), 0.3F);
		this.compostables(IcariaItems.LIONFANGS.get(), 0.3F);
		this.compostables(IcariaItems.SPEARDROPS.get(), 0.3F);
		this.compostables(IcariaItems.PURPLE_STAGHORN.get(), 0.3F);
		this.compostables(IcariaItems.YELLOW_STAGHORN.get(), 0.3F);
		this.compostables(IcariaItems.BLUE_STORMCOTTON.get(), 0.3F);
		this.compostables(IcariaItems.PINK_STORMCOTTON.get(), 0.3F);
		this.compostables(IcariaItems.PURPLE_STORMCOTTON.get(), 0.3F);
		this.compostables(IcariaItems.SUNKETTLE.get(), 0.3F);
		this.compostables(IcariaItems.SUNSPONGE.get(), 0.3F);
		this.compostables(IcariaItems.VOIDLILY.get(), 0.3F);
		this.compostables(IcariaItems.BOLBOS.get(), 0.65F);
		this.compostables(IcariaItems.DATHULLA.get(), 0.65F);
		this.compostables(IcariaItems.MONDANOS.get(), 0.65F);
		this.compostables(IcariaItems.MOTH_AGARIC.get(), 0.65F);
		this.compostables(IcariaItems.NAMDRAKE.get(), 0.65F);
		this.compostables(IcariaItems.PSILOCYBOS.get(), 0.65F);
		this.compostables(IcariaItems.ROWAN.get(), 0.65F);
		this.compostables(IcariaItems.WILTED_ELM.get(), 0.65F);
		this.compostables(IcariaItems.BLUE_GROUND_FLOWERS.get(), 0.3F);
		this.compostables(IcariaItems.CYAN_GROUND_FLOWERS.get(), 0.3F);
		this.compostables(IcariaItems.PINK_GROUND_FLOWERS.get(), 0.3F);
		this.compostables(IcariaItems.PURPLE_GROUND_FLOWERS.get(), 0.3F);
		this.compostables(IcariaItems.RED_GROUND_FLOWERS.get(), 0.3F);
		this.compostables(IcariaItems.WHITE_GROUND_FLOWERS.get(), 0.3F);
		this.compostables(IcariaItems.FOREST_MOSS.get(), 0.3F);
		this.compostables(IcariaItems.SCRUBLAND_MOSS.get(), 0.3F);
		this.compostables(IcariaItems.STEPPE_MOSS.get(), 0.3F);
		this.compostables(IcariaItems.PALM_FERN.get(), 0.65F);
		this.compostables(IcariaItems.WHITE_BROMELIA.get(), 0.3F);
		this.compostables(IcariaItems.ORANGE_BROMELIA.get(), 0.3F);
		this.compostables(IcariaItems.PINK_BROMELIA.get(), 0.3F);
		this.compostables(IcariaItems.PURPLE_BROMELIA.get(), 0.3F);
		this.compostables(IcariaItems.GREEN_GROUND_SHROOMS.get(), 0.65F);
		this.compostables(IcariaItems.BROWN_GROUND_SHROOMS.get(), 0.65F);
		this.compostables(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get(), 0.65F);
		this.compostables(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get(), 0.65F);
		this.compostables(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get(), 0.65F);
		this.compostables(IcariaItems.UNNAMED_TREE_SHROOMS.get(), 0.65F);
		this.compostables(IcariaItems.CARDON_CACTUS.get(), 0.5F);
		this.compostables(IcariaItems.STRAWBERRY_BUSH.get(), 0.3F);
		this.compostables(IcariaItems.SPELT.get(), 0.65F);
		this.compostables(IcariaItems.VINE_REED.get(), 0.65F);
		this.compostables(IcariaItems.LAUREL_WREATH.get(), 0.3F);
		this.compostables(IcariaItems.SPELT_BREAD.get(), 0.85F);
		this.compostables(IcariaItems.VINE_SPROUT.get(), 0.3F);
		this.compostables(IcariaItems.VINEBERRIES.get(), 0.3F);
		this.compostables(IcariaItems.STRAWBERRIES.get(), 0.3F);
		this.compostables(IcariaItems.PHYSALIS.get(), 0.3F);
		this.compostables(IcariaItems.LAUREL_CHERRY.get(), 0.3F);
		this.compostables(IcariaItems.BLACK_OLIVES.get(), 0.3F);
		this.compostables(IcariaItems.GREEN_OLIVES.get(), 0.3F);
		this.compostables(IcariaItems.GARLIC.get(), 0.65F);
		this.compostables(IcariaItems.ONION.get(), 0.65F);
		this.compostables(IcariaItems.SPELT_SEEDS.get(), 0.3F);
		this.compostables(IcariaItems.STRAWBERRY_SEEDS.get(), 0.3F);
		this.compostables(IcariaItems.PHYSALIS_SEEDS.get(), 0.3F);
	}

	public void freezables() {
		this.freezables(Fluids.WATER, Blocks.ICE);
		this.freezables(IcariaFluids.MEDITERRANEAN_WATER.get(), IcariaBlocks.ARISTONE.get());
	}

	public void furnaceFuels() {
		this.furnaceFuels(IcariaItems.SURFACE_LIGNITE.get(), 800);
		this.furnaceFuels(IcariaItems.ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.WHITE_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.GRAY_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.BLACK_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.BROWN_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.RED_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.ORANGE_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.YELLOW_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.LIME_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.GREEN_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.CYAN_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.BLUE_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.PURPLE_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.MAGENTA_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.PINK_ARACHNE_STRING_BLOCK.get(), 100);
		this.furnaceFuels(IcariaItems.ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.WHITE_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.GRAY_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.BLACK_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.BROWN_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.RED_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.LIME_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.GREEN_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.CYAN_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.BLUE_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.PINK_ARACHNE_STRING_CARPET.get(), 67);
		this.furnaceFuels(IcariaItems.VINE_REED_BLOCK.get(), 300);
		this.furnaceFuels(IcariaItems.LIGNITE_BLOCK.get(), 7200);
		this.furnaceFuels(IcariaItems.ANTHRACITE_BLOCK.get(), 28800);
		this.furnaceFuels(IcariaItems.CHEST.get(), 300);
		this.furnaceFuels(IcariaItems.TRAPPED_CHEST.get(), 300);
		this.furnaceFuels(IcariaItems.CYPRESS_TWIGS.get(), 100);
		this.furnaceFuels(IcariaItems.SIMPLE_CYPRESS_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.CYPRESS_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.CYPRESS_BATHTUB.get(), 600);
		this.furnaceFuels(IcariaItems.CYPRESS_TROUGH.get(), 300);
		this.furnaceFuels(IcariaItems.CYPRESS_STOOL.get(), 300);
		this.furnaceFuels(IcariaItems.CYPRESS_CRAFTING_TABLE.get(), 300);
		this.furnaceFuels(IcariaItems.CYPRESS_SCROLLSHELF.get(), 300);
		this.furnaceFuels(IcariaItems.CYPRESS_LADDER.get(), 300);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_TWIGS.get(), 100);
		this.furnaceFuels(IcariaItems.SIMPLE_DROUGHTROOT_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_BATHTUB.get(), 600);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_TROUGH.get(), 300);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_STOOL.get(), 300);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get(), 300);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_SCROLLSHELF.get(), 300);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_BUTTON.get(), 100);
		this.furnaceFuels(IcariaItems.DROUGHTROOT_LADDER.get(), 300);
		this.furnaceFuels(IcariaItems.FIR_TWIGS.get(), 100);
		this.furnaceFuels(IcariaItems.SIMPLE_FIR_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.FIR_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.FIR_BATHTUB.get(), 600);
		this.furnaceFuels(IcariaItems.FIR_TROUGH.get(), 300);
		this.furnaceFuels(IcariaItems.FIR_STOOL.get(), 300);
		this.furnaceFuels(IcariaItems.FIR_CRAFTING_TABLE.get(), 300);
		this.furnaceFuels(IcariaItems.FIR_SCROLLSHELF.get(), 300);
		this.furnaceFuels(IcariaItems.FIR_BUTTON.get(), 100);
		this.furnaceFuels(IcariaItems.FIR_LADDER.get(), 300);
		this.furnaceFuels(IcariaItems.LAUREL_TWIGS.get(), 100);
		this.furnaceFuels(IcariaItems.SIMPLE_LAUREL_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.LAUREL_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.LAUREL_BATHTUB.get(), 600);
		this.furnaceFuels(IcariaItems.LAUREL_TROUGH.get(), 300);
		this.furnaceFuels(IcariaItems.LAUREL_STOOL.get(), 300);
		this.furnaceFuels(IcariaItems.LAUREL_CRAFTING_TABLE.get(), 300);
		this.furnaceFuels(IcariaItems.LAUREL_SCROLLSHELF.get(), 300);
		this.furnaceFuels(IcariaItems.LAUREL_BUTTON.get(), 100);
		this.furnaceFuels(IcariaItems.LAUREL_LADDER.get(), 300);
		this.furnaceFuels(IcariaItems.OLIVE_TWIGS.get(), 100);
		this.furnaceFuels(IcariaItems.SIMPLE_OLIVE_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.OLIVE_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.OLIVE_BATHTUB.get(), 600);
		this.furnaceFuels(IcariaItems.OLIVE_TROUGH.get(), 300);
		this.furnaceFuels(IcariaItems.OLIVE_STOOL.get(), 300);
		this.furnaceFuels(IcariaItems.OLIVE_CRAFTING_TABLE.get(), 300);
		this.furnaceFuels(IcariaItems.OLIVE_SCROLLSHELF.get(), 300);
		this.furnaceFuels(IcariaItems.OLIVE_BUTTON.get(), 100);
		this.furnaceFuels(IcariaItems.OLIVE_LADDER.get(), 300);
		this.furnaceFuels(IcariaItems.PLANE_TWIGS.get(), 100);
		this.furnaceFuels(IcariaItems.SIMPLE_PLANE_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.PLANE_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.PLANE_BATHTUB.get(), 600);
		this.furnaceFuels(IcariaItems.PLANE_TROUGH.get(), 300);
		this.furnaceFuels(IcariaItems.PLANE_STOOL.get(), 300);
		this.furnaceFuels(IcariaItems.PLANE_CRAFTING_TABLE.get(), 300);
		this.furnaceFuels(IcariaItems.PLANE_SCROLLSHELF.get(), 300);
		this.furnaceFuels(IcariaItems.PLANE_BUTTON.get(), 100);
		this.furnaceFuels(IcariaItems.PLANE_LADDER.get(), 300);
		this.furnaceFuels(IcariaItems.POPULUS_TWIGS.get(), 100);
		this.furnaceFuels(IcariaItems.SIMPLE_POPULUS_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.POPULUS_RACK.get(), 100);
		this.furnaceFuels(IcariaItems.POPULUS_BATHTUB.get(), 600);
		this.furnaceFuels(IcariaItems.POPULUS_TROUGH.get(), 300);
		this.furnaceFuels(IcariaItems.POPULUS_STOOL.get(), 300);
		this.furnaceFuels(IcariaItems.POPULUS_CRAFTING_TABLE.get(), 300);
		this.furnaceFuels(IcariaItems.POPULUS_SCROLLSHELF.get(), 300);
		this.furnaceFuels(IcariaItems.POPULUS_BUTTON.get(), 100);
		this.furnaceFuels(IcariaItems.POPULUS_LADDER.get(), 300);
		this.furnaceFuels(IcariaItems.VINE_REED.get(), 33);
		this.furnaceFuels(IcariaItems.LIGNITE.get(), 800);
		this.furnaceFuels(IcariaItems.ANTHRACITE.get(), 3200);
		this.furnaceFuels(IcariaItems.LAUREL_WREATH.get(), 100);
	}

	public void compostables(Item pItem, float pChance) {
		this.builder(NeoForgeDataMaps.COMPOSTABLES).add(BuiltInRegistries.ITEM.getKey(pItem), new Compostable(pChance), false);
	}

	public void freezables(Fluid pFluid, Block pBlock) {
		this.builder(IcariaDataMapTypes.FREEZABLES).add(BuiltInRegistries.FLUID.getKey(pFluid), new Freezable(pBlock), false);
	}

	public void furnaceFuels(Item pItem, int pBurnTime) {
		this.builder(NeoForgeDataMaps.FURNACE_FUELS).add(BuiltInRegistries.ITEM.getKey(pItem), new FurnaceFuel(pBurnTime), false);
	}
}
