package com.axanthic.icaria.data.provider.loot;

import com.axanthic.icaria.common.properties.*;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.predicates.DataComponentPredicates;
import net.minecraft.core.component.predicates.EnchantmentsPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockLootSubProvider extends BlockLootSubProvider {
	public static final float[] CHERRY_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] GARLIC_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] SAPLING_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] SEED_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] STICK_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};

	public IcariaBlockLootSubProvider(HolderLookup.Provider pProvider) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pProvider);
	}

	@Override
	public void generate() {
		this.dropBush();
		this.dropCake();
		this.dropCrop();
		this.dropDoor();
		this.dropElse();
		this.dropGroundFlowers();
		this.dropLaurelLeaves();
		this.dropLayers();
		this.dropLeaves();
		this.dropNone();
		this.dropOliveLeaves();
		this.dropOnionCrop();
		this.dropPotted();
		this.dropRipeVineWithLoot();
		this.dropSeed();
		this.dropSlab();
		this.dropStool();
		this.dropThis();
		this.dropThisWithSilk();
		this.dropThisWithSilkOrBone();
		this.dropThisWithSilkOrElse();
		this.dropVine();
		this.dropVineWithLoot();
	}

	public void dropBush() {
		this.dropBush(IcariaBlocks.STRAWBERRY_BUSH.get(), IcariaItems.STRAWBERRIES.get());
	}

	public void dropCake() {
		this.dropCake(IcariaBlocks.LAUREL_CHERRY_CAKE.get());
		this.dropCake(IcariaBlocks.STRAWBERRY_CAKE.get());
		this.dropCake(IcariaBlocks.PHYSALIS_CAKE.get());
		this.dropCake(IcariaBlocks.VINE_BERRY_CAKE.get());
		this.dropCake(IcariaBlocks.VINE_SPROUT_CAKE.get());
	}

	public void dropCrop() {
		this.dropCrop(IcariaBlocks.SPELT_CROP.get(), IcariaItems.SPELT.get(), IcariaItems.SPELT_SEEDS.get());
		this.dropCrop(IcariaBlocks.STRAWBERRY_CROP.get(), IcariaItems.STRAWBERRIES.get(), IcariaItems.STRAWBERRY_SEEDS.get());
		this.dropCrop(IcariaBlocks.PHYSALIS_CROP.get(), IcariaItems.PHYSALIS.get(), IcariaItems.PHYSALIS_SEEDS.get());
	}

	public void dropDoor() {
		this.dropDoor(IcariaBlocks.CYPRESS_DOOR.get());
		this.dropDoor(IcariaBlocks.DROUGHTROOT_DOOR.get());
		this.dropDoor(IcariaBlocks.FIR_DOOR.get());
		this.dropDoor(IcariaBlocks.LAUREL_DOOR.get());
		this.dropDoor(IcariaBlocks.OLIVE_DOOR.get());
		this.dropDoor(IcariaBlocks.PLANE_DOOR.get());
		this.dropDoor(IcariaBlocks.POPULUS_DOOR.get());
	}

	public void dropElse() {
		this.dropElse(IcariaBlocks.FARMLAND.get(), IcariaItems.MARL.get());
		this.dropElse(IcariaBlocks.FERTILIZED_FARMLAND.get(), IcariaItems.MARL.get());
		this.dropElse(IcariaBlocks.MARL_PATH.get(), IcariaItems.MARL.get());
		this.dropElse(IcariaBlocks.LOAM_PATH.get(), IcariaItems.LOAM.get());
		this.dropElse(IcariaBlocks.GRAINEL_PATH.get(), IcariaItems.GRAINEL.get());
		this.dropElse(IcariaBlocks.SILKSAND_PATH.get(), IcariaItems.SILKSAND.get());
		this.dropElse(IcariaBlocks.AETERNAE_WALL_SKULL.get(), IcariaItems.AETERNAE_SKULL.get());
		this.dropElse(IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), IcariaItems.ARGAN_HOUND_SKULL.get());
		this.dropElse(IcariaBlocks.CAPELLA_WALL_SKULL.get(), IcariaItems.CAPELLA_SKULL.get());
		this.dropElse(IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), IcariaItems.CATOBLEPAS_SKULL.get());
		this.dropElse(IcariaBlocks.CERVER_WALL_SKULL.get(), IcariaItems.CERVER_SKULL.get());
		this.dropElse(IcariaBlocks.CROCOTTA_WALL_SKULL.get(), IcariaItems.CROCOTTA_SKULL.get());
		this.dropElse(IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get(), IcariaItems.CYPRESS_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get(), IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get(), IcariaItems.FIR_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get(), IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get(), IcariaItems.OLIVE_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get(), IcariaItems.PLANE_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get(), IcariaItems.POPULUS_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.REVENANT_WALL_SKULL.get(), IcariaItems.REVENANT_SKULL.get());
		this.dropElse(IcariaBlocks.THOG_WALL_SKULL.get(), IcariaItems.THOG_SKULL.get());
		this.dropElse(IcariaBlocks.LIGNITE_WALL_TORCH.get(), IcariaItems.LIGNITE_TORCH.get());
		this.dropElse(IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), IcariaItems.ANTHRACITE_TORCH.get());
		this.dropElse(IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaItems.CYPRESS_SIGN.get());
		this.dropElse(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), IcariaItems.CYPRESS_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaItems.DROUGHTROOT_SIGN.get());
		this.dropElse(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), IcariaItems.DROUGHTROOT_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.FIR_WALL_SIGN.get(), IcariaItems.FIR_SIGN.get());
		this.dropElse(IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), IcariaItems.FIR_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaItems.LAUREL_SIGN.get());
		this.dropElse(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), IcariaItems.LAUREL_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaItems.OLIVE_SIGN.get());
		this.dropElse(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), IcariaItems.OLIVE_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaItems.PLANE_SIGN.get());
		this.dropElse(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), IcariaItems.PLANE_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.POPULUS_WALL_SIGN.get(), IcariaItems.POPULUS_SIGN.get());
		this.dropElse(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get(), IcariaItems.POPULUS_HANGING_SIGN.get());
	}

	public void dropGroundFlowers() {
		this.dropGroundFlowers(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		this.dropGroundFlowers(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		this.dropGroundFlowers(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		this.dropGroundFlowers(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		this.dropGroundFlowers(IcariaBlocks.RED_GROUND_FLOWERS.get());
		this.dropGroundFlowers(IcariaBlocks.WHITE_GROUND_FLOWERS.get());
	}

	public void dropLaurelLeaves() {
		this.dropLaurelLeaves(IcariaBlocks.LAUREL_LEAVES.get(), IcariaItems.LAUREL_SAPLING.get());
	}

	public void dropLayers() {
		this.dropLayers(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		this.dropLayers(IcariaBlocks.FOREST_MOSS.get());
		this.dropLayers(IcariaBlocks.SCRUBLAND_MOSS.get());
		this.dropLayers(IcariaBlocks.STEPPE_MOSS.get());
	}

	public void dropLeaves() {
		this.dropLeaves(IcariaBlocks.CYPRESS_LEAVES.get(), IcariaItems.CYPRESS_SAPLING.get());
		this.dropLeaves(IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaItems.DROUGHTROOT_SAPLING.get());
		this.dropLeaves(IcariaBlocks.FIR_LEAVES.get(), IcariaItems.FIR_SAPLING.get());
		this.dropLeaves(IcariaBlocks.PLANE_LEAVES.get(), IcariaItems.PLANE_SAPLING.get());
		this.dropLeaves(IcariaBlocks.POPULUS_LEAVES.get(), IcariaItems.POPULUS_SAPLING.get());
	}

	public void dropNone() {
		this.dropNone(IcariaBlocks.SUSPICIOUS_GRAINEL.get());
		this.dropNone(IcariaBlocks.SUSPICIOUS_SILKSAND.get());
		this.dropNone(IcariaBlocks.KETTLE.get());
		this.dropNone(IcariaBlocks.GRINDER.get());
		this.dropNone(IcariaBlocks.KILN.get());
		this.dropNone(IcariaBlocks.FORGE.get());
		this.dropNone(IcariaBlocks.RED_LOOT_VASE.get());
		this.dropNone(IcariaBlocks.LOST_LOOT_VASE.get());
		this.dropNone(IcariaBlocks.CYAN_LOOT_VASE.get());
		this.dropNone(IcariaBlocks.ARACHNE_SPAWNER.get());
		this.dropNone(IcariaBlocks.REVENANT_SPAWNER.get());
		this.dropNone(IcariaBlocks.SIMPLE_CYPRESS_RACK.get());
		this.dropNone(IcariaBlocks.CYPRESS_RACK.get());
		this.dropNone(IcariaBlocks.CYPRESS_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_CYPRESS_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_CYPRESS_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get());
		this.dropNone(IcariaBlocks.DROUGHTROOT_RACK.get());
		this.dropNone(IcariaBlocks.DROUGHTROOT_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_FIR_RACK.get());
		this.dropNone(IcariaBlocks.FIR_RACK.get());
		this.dropNone(IcariaBlocks.FIR_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_FIR_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_FIR_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_LAUREL_RACK.get());
		this.dropNone(IcariaBlocks.LAUREL_RACK.get());
		this.dropNone(IcariaBlocks.LAUREL_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_LAUREL_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_LAUREL_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_OLIVE_RACK.get());
		this.dropNone(IcariaBlocks.OLIVE_RACK.get());
		this.dropNone(IcariaBlocks.OLIVE_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_OLIVE_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_OLIVE_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_PLANE_RACK.get());
		this.dropNone(IcariaBlocks.PLANE_RACK.get());
		this.dropNone(IcariaBlocks.PLANE_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_PLANE_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_PLANE_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_POPULUS_RACK.get());
		this.dropNone(IcariaBlocks.POPULUS_RACK.get());
		this.dropNone(IcariaBlocks.POPULUS_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_POPULUS_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_POPULUS_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.MEDITERRANEAN_WATER.get());
		this.dropNone(IcariaBlocks.GREEK_FIRE.get());
		this.dropNone(IcariaBlocks.ICARIA_PORTAL.get());
		this.dropNone(IcariaBlocks.GRINDER_SHAFT.get());
		this.dropNone(IcariaBlocks.GRINDER_STONE.get());
	}

	public void dropOliveLeaves() {
		this.dropOliveLeaves(IcariaBlocks.OLIVE_LEAVES.get(), IcariaItems.OLIVE_SAPLING.get());
	}

	public void dropOnionCrop() {
		this.dropOnionCrop(IcariaBlocks.ONION_CROP.get(), IcariaItems.ONION.get());
	}

	public void dropPotted() {
		this.dropPotted(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), IcariaItems.CYPRESS_SAPLING.get());
		this.dropPotted(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), IcariaItems.DROUGHTROOT_SAPLING.get());
		this.dropPotted(IcariaBlocks.POTTED_FIR_SAPLING.get(), IcariaItems.FIR_SAPLING.get());
		this.dropPotted(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), IcariaItems.LAUREL_SAPLING.get());
		this.dropPotted(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), IcariaItems.OLIVE_SAPLING.get());
		this.dropPotted(IcariaBlocks.POTTED_PLANE_SAPLING.get(), IcariaItems.PLANE_SAPLING.get());
		this.dropPotted(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), IcariaItems.POPULUS_SAPLING.get());
		this.dropPotted(IcariaBlocks.POTTED_FERN.get(), IcariaItems.FERN.get());
		this.dropPotted(IcariaBlocks.POTTED_BLINDWEED.get(), IcariaItems.BLINDWEED.get());
		this.dropPotted(IcariaBlocks.POTTED_CHAMEOMILE.get(), IcariaItems.CHAMEOMILE.get());
		this.dropPotted(IcariaBlocks.POTTED_CHARMONDER.get(), IcariaItems.CHARMONDER.get());
		this.dropPotted(IcariaBlocks.POTTED_CLOVER.get(), IcariaItems.CLOVER.get());
		this.dropPotted(IcariaBlocks.POTTED_FIREHILT.get(), IcariaItems.FIREHILT.get());
		this.dropPotted(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), IcariaItems.BLUE_HYDRACINTH.get());
		this.dropPotted(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), IcariaItems.PURPLE_HYDRACINTH.get());
		this.dropPotted(IcariaBlocks.POTTED_LIONFANGS.get(), IcariaItems.LIONFANGS.get());
		this.dropPotted(IcariaBlocks.POTTED_SPEARDROPS.get(), IcariaItems.SPEARDROPS.get());
		this.dropPotted(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), IcariaItems.PURPLE_STAGHORN.get());
		this.dropPotted(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), IcariaItems.YELLOW_STAGHORN.get());
		this.dropPotted(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), IcariaItems.BLUE_STORMCOTTON.get());
		this.dropPotted(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), IcariaItems.PINK_STORMCOTTON.get());
		this.dropPotted(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), IcariaItems.PURPLE_STORMCOTTON.get());
		this.dropPotted(IcariaBlocks.POTTED_SUNKETTLE.get(), IcariaItems.SUNKETTLE.get());
		this.dropPotted(IcariaBlocks.POTTED_SUNSPONGE.get(), IcariaItems.SUNSPONGE.get());
		this.dropPotted(IcariaBlocks.POTTED_VOIDLILY.get(), IcariaItems.VOIDLILY.get());
		this.dropPotted(IcariaBlocks.POTTED_PALM_FERN.get(), IcariaItems.PALM_FERN.get());
		this.dropPotted(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), IcariaItems.WHITE_BROMELIA.get());
		this.dropPotted(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), IcariaItems.ORANGE_BROMELIA.get());
		this.dropPotted(IcariaBlocks.POTTED_PINK_BROMELIA.get(), IcariaItems.PINK_BROMELIA.get());
		this.dropPotted(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), IcariaItems.PURPLE_BROMELIA.get());
		this.dropPotted(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get(), IcariaItems.GREEN_GROUND_SHROOMS.get());
		this.dropPotted(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get(), IcariaItems.BROWN_GROUND_SHROOMS.get());
		this.dropPotted(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get(), IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get());
		this.dropPotted(IcariaBlocks.POTTED_CARDON_CACTUS.get(), IcariaItems.CARDON_CACTUS.get());
	}

	public void dropRipeVineWithLoot() {
		this.dropRipeVineWithLoot(IcariaBlocks.BLOOMY_VINE.get(), IcariaItems.VINEBERRIES.get());
		this.dropRipeVineWithLoot(IcariaBlocks.BRUSHY_VINE.get(), IcariaItems.VINE_SPROUT.get());
	}

	public void dropSeed() {
		this.dropSeed(IcariaBlocks.FERN.get());
		this.dropSeed(IcariaBlocks.SMALL_GRASS.get());
		this.dropSeed(IcariaBlocks.MEDIUM_GRASS.get());
		this.dropSeed(IcariaBlocks.LARGE_GRASS.get());
		this.dropSeed(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		this.dropSeed(IcariaBlocks.LARGE_BROWN_GRAIN.get());
	}

	public void dropSlab() {
		this.dropSlab(IcariaBlocks.MARL_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.LOAM_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.DOLOMITE_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get());
		this.dropSlab(IcariaBlocks.GRAINITE_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.GRAINITE_SLAB.get());
		this.dropSlab(IcariaBlocks.GRAINITE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.YELLOWSTONE_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.COBBLED_YELLOWSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.YELLOWSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.YELLOWSTONE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.SILKSTONE_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.COBBLED_SILKSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.SILKSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.SILKSTONE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.SUNSTONE_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.COBBLED_SUNSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.SUNSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.SUNSTONE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.VOIDSHALE_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.COBBLED_VOIDSHALE_SLAB.get());
		this.dropSlab(IcariaBlocks.VOIDSHALE_SLAB.get());
		this.dropSlab(IcariaBlocks.VOIDSHALE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.BAETYL_ADOBE_SLAB.get());
		this.dropSlab(IcariaBlocks.COBBLED_BAETYL_SLAB.get());
		this.dropSlab(IcariaBlocks.BAETYL_SLAB.get());
		this.dropSlab(IcariaBlocks.BAETYL_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.RELICSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.SMOOTH_RELICSTONE_SLAB.get());
		this.dropSlab(IcariaBlocks.RELICSTONE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.CRACKED_RELICSTONE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.MOSSY_RELICSTONE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.RELICSTONE_TILE_SLAB.get());
		this.dropSlab(IcariaBlocks.CRACKED_RELICSTONE_TILE_SLAB.get());
		this.dropSlab(IcariaBlocks.MOSSY_RELICSTONE_TILE_SLAB.get());
		this.dropSlab(IcariaBlocks.PLATOSHALE_SLAB.get());
		this.dropSlab(IcariaBlocks.PLATOSHALE_BRICK_SLAB.get());
		this.dropSlab(IcariaBlocks.CYPRESS_SLAB.get());
		this.dropSlab(IcariaBlocks.DROUGHTROOT_SLAB.get());
		this.dropSlab(IcariaBlocks.FIR_SLAB.get());
		this.dropSlab(IcariaBlocks.LAUREL_SLAB.get());
		this.dropSlab(IcariaBlocks.OLIVE_SLAB.get());
		this.dropSlab(IcariaBlocks.PLANE_SLAB.get());
		this.dropSlab(IcariaBlocks.POPULUS_SLAB.get());
	}

	public void dropStool() {
		this.dropStool(IcariaBlocks.CYPRESS_STOOL.get());
		this.dropStool(IcariaBlocks.DROUGHTROOT_STOOL.get());
		this.dropStool(IcariaBlocks.FIR_STOOL.get());
		this.dropStool(IcariaBlocks.LAUREL_STOOL.get());
		this.dropStool(IcariaBlocks.OLIVE_STOOL.get());
		this.dropStool(IcariaBlocks.PLANE_STOOL.get());
		this.dropStool(IcariaBlocks.POPULUS_STOOL.get());
	}

	public void dropThis() {
		this.dropThis(IcariaBlocks.MARL.get());
		this.dropThis(IcariaBlocks.COARSE_MARL.get());
		this.dropThis(IcariaBlocks.DRY_LAKE_BED.get());
		this.dropThis(IcariaBlocks.MARL_ADOBE.get());
		this.dropThis(IcariaBlocks.MARL_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.MARL_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.LOAM_BRICKS.get());
		this.dropThis(IcariaBlocks.LOAM_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.LOAM_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.DOLOMITE_ADOBE.get());
		this.dropThis(IcariaBlocks.DOLOMITE_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.DOLOMITE_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.SMOOTH_DOLOMITE.get());
		this.dropThis(IcariaBlocks.SMOOTH_DOLOMITE_STAIRS.get());
		this.dropThis(IcariaBlocks.SMOOTH_DOLOMITE_WALL.get());
		this.dropThis(IcariaBlocks.DOLOMITE_BRICKS.get());
		this.dropThis(IcariaBlocks.CHISELED_DOLOMITE.get());
		this.dropThis(IcariaBlocks.DOLOMITE_PILLAR.get());
		this.dropThis(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.GRAINEL.get());
		this.dropThis(IcariaBlocks.GRAINITE_ADOBE.get());
		this.dropThis(IcariaBlocks.GRAINITE_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.GRAINITE_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.GRAINITE.get());
		this.dropThis(IcariaBlocks.GRAINITE_STAIRS.get());
		this.dropThis(IcariaBlocks.GRAINITE_WALL.get());
		this.dropThis(IcariaBlocks.GRAINITE_BRICKS.get());
		this.dropThis(IcariaBlocks.GRAINITE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.GRAINITE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_GRAINITE.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_ADOBE.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.COBBLED_YELLOWSTONE.get());
		this.dropThis(IcariaBlocks.COBBLED_YELLOWSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.COBBLED_YELLOWSTONE_WALL.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_WALL.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_BRICKS.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.YELLOWSTONE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_YELLOWSTONE.get());
		this.dropThis(IcariaBlocks.SILKSAND.get());
		this.dropThis(IcariaBlocks.SILKSTONE_ADOBE.get());
		this.dropThis(IcariaBlocks.SILKSTONE_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.SILKSTONE_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.COBBLED_SILKSTONE.get());
		this.dropThis(IcariaBlocks.COBBLED_SILKSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.COBBLED_SILKSTONE_WALL.get());
		this.dropThis(IcariaBlocks.SILKSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.SILKSTONE_WALL.get());
		this.dropThis(IcariaBlocks.SILKSTONE_BRICKS.get());
		this.dropThis(IcariaBlocks.SILKSTONE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.SILKSTONE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_SILKSTONE.get());
		this.dropThis(IcariaBlocks.SUNSTONE_ADOBE.get());
		this.dropThis(IcariaBlocks.SUNSTONE_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.SUNSTONE_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.COBBLED_SUNSTONE.get());
		this.dropThis(IcariaBlocks.COBBLED_SUNSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.COBBLED_SUNSTONE_WALL.get());
		this.dropThis(IcariaBlocks.SUNSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.SUNSTONE_WALL.get());
		this.dropThis(IcariaBlocks.SUNSTONE_BRICKS.get());
		this.dropThis(IcariaBlocks.SUNSTONE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.SUNSTONE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_SUNSTONE.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_ADOBE.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.COBBLED_VOIDSHALE.get());
		this.dropThis(IcariaBlocks.COBBLED_VOIDSHALE_STAIRS.get());
		this.dropThis(IcariaBlocks.COBBLED_VOIDSHALE_WALL.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_STAIRS.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_WALL.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_BRICKS.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.VOIDSHALE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_VOIDSHALE.get());
		this.dropThis(IcariaBlocks.BAETYL_ADOBE.get());
		this.dropThis(IcariaBlocks.BAETYL_ADOBE_STAIRS.get());
		this.dropThis(IcariaBlocks.BAETYL_ADOBE_WALL.get());
		this.dropThis(IcariaBlocks.COBBLED_BAETYL.get());
		this.dropThis(IcariaBlocks.COBBLED_BAETYL_STAIRS.get());
		this.dropThis(IcariaBlocks.COBBLED_BAETYL_WALL.get());
		this.dropThis(IcariaBlocks.BAETYL_STAIRS.get());
		this.dropThis(IcariaBlocks.BAETYL_WALL.get());
		this.dropThis(IcariaBlocks.BAETYL_BRICKS.get());
		this.dropThis(IcariaBlocks.BAETYL_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.BAETYL_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_BAETYL.get());
		this.dropThis(IcariaBlocks.RELICSTONE.get());
		this.dropThis(IcariaBlocks.RELICSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.RELICSTONE_WALL.get());
		this.dropThis(IcariaBlocks.SMOOTH_RELICSTONE_STAIRS.get());
		this.dropThis(IcariaBlocks.SMOOTH_RELICSTONE_WALL.get());
		this.dropThis(IcariaBlocks.RELICSTONE_BRICKS.get());
		this.dropThis(IcariaBlocks.RELICSTONE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.RELICSTONE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get());
		this.dropThis(IcariaBlocks.CRACKED_RELICSTONE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.CRACKED_RELICSTONE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get());
		this.dropThis(IcariaBlocks.MOSSY_RELICSTONE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.MOSSY_RELICSTONE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.RELICSTONE_TILES.get());
		this.dropThis(IcariaBlocks.RELICSTONE_TILE_STAIRS.get());
		this.dropThis(IcariaBlocks.RELICSTONE_TILE_WALL.get());
		this.dropThis(IcariaBlocks.CRACKED_RELICSTONE_TILES.get());
		this.dropThis(IcariaBlocks.CRACKED_RELICSTONE_TILE_STAIRS.get());
		this.dropThis(IcariaBlocks.CRACKED_RELICSTONE_TILE_WALL.get());
		this.dropThis(IcariaBlocks.MOSSY_RELICSTONE_TILES.get());
		this.dropThis(IcariaBlocks.MOSSY_RELICSTONE_TILE_STAIRS.get());
		this.dropThis(IcariaBlocks.MOSSY_RELICSTONE_TILE_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_RELICSTONE.get());
		this.dropThis(IcariaBlocks.RELICSTONE_PILLAR.get());
		this.dropThis(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.PLATOSHALE.get());
		this.dropThis(IcariaBlocks.PLATOSHALE_STAIRS.get());
		this.dropThis(IcariaBlocks.PLATOSHALE_WALL.get());
		this.dropThis(IcariaBlocks.PLATOSHALE_BRICKS.get());
		this.dropThis(IcariaBlocks.PLATOSHALE_BRICK_STAIRS.get());
		this.dropThis(IcariaBlocks.PLATOSHALE_BRICK_WALL.get());
		this.dropThis(IcariaBlocks.CHISELED_PLATOSHALE.get());
		this.dropThis(IcariaBlocks.QUARTZ_WALL.get());
		this.dropThis(IcariaBlocks.QUARTZ_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.CALCITE.get());
		this.dropThis(IcariaBlocks.BUDDING_CALCITE.get());
		this.dropThis(IcariaBlocks.HALITE.get());
		this.dropThis(IcariaBlocks.BUDDING_HALITE.get());
		this.dropThis(IcariaBlocks.JASPER.get());
		this.dropThis(IcariaBlocks.BUDDING_JASPER.get());
		this.dropThis(IcariaBlocks.ZIRCON.get());
		this.dropThis(IcariaBlocks.BUDDING_ZIRCON.get());
		this.dropThis(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.dropThis(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.dropThis(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.dropThis(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.dropThis(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.dropThis(IcariaBlocks.ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.WHITE_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.GRAY_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.BLACK_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.BROWN_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.RED_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.ORANGE_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.YELLOW_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.LIME_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.GREEN_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.CYAN_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.BLUE_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.PURPLE_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.MAGENTA_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.PINK_ARACHNE_STRING_BLOCK.get());
		this.dropThis(IcariaBlocks.ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.WHITE_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.LIGHT_GRAY_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.GRAY_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.BLACK_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.BROWN_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.RED_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.ORANGE_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.YELLOW_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.LIME_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.GREEN_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.CYAN_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.LIGHT_BLUE_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.BLUE_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.PURPLE_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.MAGENTA_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.PINK_ARACHNE_STRING_CARPET.get());
		this.dropThis(IcariaBlocks.SPELT_BALE_BLOCK.get());
		this.dropThis(IcariaBlocks.VINE_REED_BLOCK.get());
		this.dropThis(IcariaBlocks.ROTTEN_BONES_BLOCK.get());
		this.dropThis(IcariaBlocks.RAW_CHALKOS_BLOCK.get());
		this.dropThis(IcariaBlocks.RAW_KASSITEROS_BLOCK.get());
		this.dropThis(IcariaBlocks.RAW_VANADIUM_BLOCK.get());
		this.dropThis(IcariaBlocks.RAW_SIDEROS_BLOCK.get());
		this.dropThis(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get());
		this.dropThis(IcariaBlocks.CALCITE_BLOCK.get());
		this.dropThis(IcariaBlocks.HALITE_BLOCK.get());
		this.dropThis(IcariaBlocks.JASPER_BLOCK.get());
		this.dropThis(IcariaBlocks.ZIRCON_BLOCK.get());
		this.dropThis(IcariaBlocks.CHERT_BLOCK.get());
		this.dropThis(IcariaBlocks.LIGNITE_BLOCK.get());
		this.dropThis(IcariaBlocks.CHALKOS_BLOCK.get());
		this.dropThis(IcariaBlocks.KASSITEROS_BLOCK.get());
		this.dropThis(IcariaBlocks.ORICHALCUM_BLOCK.get());
		this.dropThis(IcariaBlocks.VANADIUM_BLOCK.get());
		this.dropThis(IcariaBlocks.SLIVER_BLOCK.get());
		this.dropThis(IcariaBlocks.VANADIUMSTEEL_BLOCK.get());
		this.dropThis(IcariaBlocks.SIDEROS_BLOCK.get());
		this.dropThis(IcariaBlocks.ANTHRACITE_BLOCK.get());
		this.dropThis(IcariaBlocks.MOLYBDENUM_BLOCK.get());
		this.dropThis(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());
		this.dropThis(IcariaBlocks.BLURIDIUM_BLOCK.get());
		this.dropThis(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		this.dropThis(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get());
		this.dropThis(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());
		this.dropThis(IcariaBlocks.CHEST.get());
		this.dropThis(IcariaBlocks.TRAPPED_CHEST.get());
		this.dropThis(IcariaBlocks.STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.WHITE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.GRAY_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.BLACK_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.BROWN_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.RED_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.ORANGE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.YELLOW_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.LIME_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.GREEN_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.CYAN_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.BLUE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.PURPLE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.MAGENTA_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.PINK_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.AETERNAE_SKULL.get());
		this.dropThis(IcariaBlocks.ARGAN_HOUND_SKULL.get());
		this.dropThis(IcariaBlocks.CAPELLA_SKULL.get());
		this.dropThis(IcariaBlocks.CATOBLEPAS_SKULL.get());
		this.dropThis(IcariaBlocks.CERVER_SKULL.get());
		this.dropThis(IcariaBlocks.CROCOTTA_SKULL.get());
		this.dropThis(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.FIR_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.REVENANT_SKULL.get());
		this.dropThis(IcariaBlocks.THOG_SKULL.get());
		this.dropThis(IcariaBlocks.LIGNITE_TORCH.get());
		this.dropThis(IcariaBlocks.ANTHRACITE_TORCH.get());
		this.dropThis(IcariaBlocks.CYPRESS_SAPLING.get());
		this.dropThis(IcariaBlocks.CYPRESS_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		this.dropThis(IcariaBlocks.CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.CYPRESS_PLANKS.get());
		this.dropThis(IcariaBlocks.CYPRESS_STAIRS.get());
		this.dropThis(IcariaBlocks.CYPRESS_FENCE.get());
		this.dropThis(IcariaBlocks.CYPRESS_FENCE_GATE.get());
		this.dropThis(IcariaBlocks.CYPRESS_TROUGH.get());
		this.dropThis(IcariaBlocks.CYPRESS_PAN_HOLDER.get());
		this.dropThis(IcariaBlocks.CYPRESS_SPOON_HOLDER.get());
		this.dropThis(IcariaBlocks.CYPRESS_TOWEL_HOLDER.get());
		this.dropThis(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.CYPRESS_SCROLLSHELF.get());
		this.dropThis(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.CYPRESS_PRESSURE_PLATE.get());
		this.dropThis(IcariaBlocks.CYPRESS_BUTTON.get());
		this.dropThis(IcariaBlocks.CYPRESS_LADDER.get());
		this.dropThis(IcariaBlocks.CYPRESS_SIGN.get());
		this.dropThis(IcariaBlocks.CYPRESS_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_STAIRS.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_FENCE.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_FENCE_GATE.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_TROUGH.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_PAN_HOLDER.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SPOON_HOLDER.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_TOWEL_HOLDER.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SCROLLSHELF.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_PRESSURE_PLATE.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_BUTTON.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_LADDER.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SIGN.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.FIR_SAPLING.get());
		this.dropThis(IcariaBlocks.FIR_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		this.dropThis(IcariaBlocks.FIR_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_FIR_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		this.dropThis(IcariaBlocks.FIR_PLANKS.get());
		this.dropThis(IcariaBlocks.FIR_STAIRS.get());
		this.dropThis(IcariaBlocks.FIR_FENCE.get());
		this.dropThis(IcariaBlocks.FIR_FENCE_GATE.get());
		this.dropThis(IcariaBlocks.FIR_TROUGH.get());
		this.dropThis(IcariaBlocks.FIR_PAN_HOLDER.get());
		this.dropThis(IcariaBlocks.FIR_SPOON_HOLDER.get());
		this.dropThis(IcariaBlocks.FIR_TOWEL_HOLDER.get());
		this.dropThis(IcariaBlocks.FIR_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.FIR_SCROLLSHELF.get());
		this.dropThis(IcariaBlocks.FIR_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.FIR_PRESSURE_PLATE.get());
		this.dropThis(IcariaBlocks.FIR_BUTTON.get());
		this.dropThis(IcariaBlocks.FIR_LADDER.get());
		this.dropThis(IcariaBlocks.FIR_SIGN.get());
		this.dropThis(IcariaBlocks.FIR_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.LAUREL_SAPLING.get());
		this.dropThis(IcariaBlocks.LAUREL_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		this.dropThis(IcariaBlocks.LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.LAUREL_PLANKS.get());
		this.dropThis(IcariaBlocks.LAUREL_STAIRS.get());
		this.dropThis(IcariaBlocks.LAUREL_FENCE.get());
		this.dropThis(IcariaBlocks.LAUREL_FENCE_GATE.get());
		this.dropThis(IcariaBlocks.LAUREL_TROUGH.get());
		this.dropThis(IcariaBlocks.LAUREL_PAN_HOLDER.get());
		this.dropThis(IcariaBlocks.LAUREL_SPOON_HOLDER.get());
		this.dropThis(IcariaBlocks.LAUREL_TOWEL_HOLDER.get());
		this.dropThis(IcariaBlocks.LAUREL_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.LAUREL_SCROLLSHELF.get());
		this.dropThis(IcariaBlocks.LAUREL_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.LAUREL_PRESSURE_PLATE.get());
		this.dropThis(IcariaBlocks.LAUREL_BUTTON.get());
		this.dropThis(IcariaBlocks.LAUREL_LADDER.get());
		this.dropThis(IcariaBlocks.LAUREL_SIGN.get());
		this.dropThis(IcariaBlocks.LAUREL_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.OLIVE_SAPLING.get());
		this.dropThis(IcariaBlocks.OLIVE_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		this.dropThis(IcariaBlocks.OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.OLIVE_PLANKS.get());
		this.dropThis(IcariaBlocks.OLIVE_STAIRS.get());
		this.dropThis(IcariaBlocks.OLIVE_FENCE.get());
		this.dropThis(IcariaBlocks.OLIVE_FENCE_GATE.get());
		this.dropThis(IcariaBlocks.OLIVE_TROUGH.get());
		this.dropThis(IcariaBlocks.OLIVE_PAN_HOLDER.get());
		this.dropThis(IcariaBlocks.OLIVE_SPOON_HOLDER.get());
		this.dropThis(IcariaBlocks.OLIVE_TOWEL_HOLDER.get());
		this.dropThis(IcariaBlocks.OLIVE_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.OLIVE_SCROLLSHELF.get());
		this.dropThis(IcariaBlocks.OLIVE_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.OLIVE_PRESSURE_PLATE.get());
		this.dropThis(IcariaBlocks.OLIVE_BUTTON.get());
		this.dropThis(IcariaBlocks.OLIVE_LADDER.get());
		this.dropThis(IcariaBlocks.OLIVE_SIGN.get());
		this.dropThis(IcariaBlocks.OLIVE_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.PLANE_SAPLING.get());
		this.dropThis(IcariaBlocks.PLANE_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		this.dropThis(IcariaBlocks.PLANE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.PLANE_PLANKS.get());
		this.dropThis(IcariaBlocks.PLANE_STAIRS.get());
		this.dropThis(IcariaBlocks.PLANE_FENCE.get());
		this.dropThis(IcariaBlocks.PLANE_FENCE_GATE.get());
		this.dropThis(IcariaBlocks.PLANE_TROUGH.get());
		this.dropThis(IcariaBlocks.PLANE_PAN_HOLDER.get());
		this.dropThis(IcariaBlocks.PLANE_SPOON_HOLDER.get());
		this.dropThis(IcariaBlocks.PLANE_TOWEL_HOLDER.get());
		this.dropThis(IcariaBlocks.PLANE_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.PLANE_SCROLLSHELF.get());
		this.dropThis(IcariaBlocks.PLANE_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.PLANE_PRESSURE_PLATE.get());
		this.dropThis(IcariaBlocks.PLANE_BUTTON.get());
		this.dropThis(IcariaBlocks.PLANE_LADDER.get());
		this.dropThis(IcariaBlocks.PLANE_SIGN.get());
		this.dropThis(IcariaBlocks.PLANE_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.POPULUS_SAPLING.get());
		this.dropThis(IcariaBlocks.POPULUS_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		this.dropThis(IcariaBlocks.POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.POPULUS_PLANKS.get());
		this.dropThis(IcariaBlocks.POPULUS_STAIRS.get());
		this.dropThis(IcariaBlocks.POPULUS_FENCE.get());
		this.dropThis(IcariaBlocks.POPULUS_FENCE_GATE.get());
		this.dropThis(IcariaBlocks.POPULUS_TROUGH.get());
		this.dropThis(IcariaBlocks.POPULUS_PAN_HOLDER.get());
		this.dropThis(IcariaBlocks.POPULUS_SPOON_HOLDER.get());
		this.dropThis(IcariaBlocks.POPULUS_TOWEL_HOLDER.get());
		this.dropThis(IcariaBlocks.POPULUS_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.POPULUS_SCROLLSHELF.get());
		this.dropThis(IcariaBlocks.POPULUS_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.POPULUS_PRESSURE_PLATE.get());
		this.dropThis(IcariaBlocks.POPULUS_BUTTON.get());
		this.dropThis(IcariaBlocks.POPULUS_LADDER.get());
		this.dropThis(IcariaBlocks.POPULUS_SIGN.get());
		this.dropThis(IcariaBlocks.POPULUS_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.BLINDWEED.get());
		this.dropThis(IcariaBlocks.CHAMEOMILE.get());
		this.dropThis(IcariaBlocks.CHARMONDER.get());
		this.dropThis(IcariaBlocks.CLOVER.get());
		this.dropThis(IcariaBlocks.FIREHILT.get());
		this.dropThis(IcariaBlocks.BLUE_HYDRACINTH.get());
		this.dropThis(IcariaBlocks.PURPLE_HYDRACINTH.get());
		this.dropThis(IcariaBlocks.LIONFANGS.get());
		this.dropThis(IcariaBlocks.SPEARDROPS.get());
		this.dropThis(IcariaBlocks.PURPLE_STAGHORN.get());
		this.dropThis(IcariaBlocks.YELLOW_STAGHORN.get());
		this.dropThis(IcariaBlocks.BLUE_STORMCOTTON.get());
		this.dropThis(IcariaBlocks.PINK_STORMCOTTON.get());
		this.dropThis(IcariaBlocks.PURPLE_STORMCOTTON.get());
		this.dropThis(IcariaBlocks.SUNKETTLE.get());
		this.dropThis(IcariaBlocks.SUNSPONGE.get());
		this.dropThis(IcariaBlocks.VOIDLILY.get());
		this.dropThis(IcariaBlocks.BOLBOS.get());
		this.dropThis(IcariaBlocks.DATHULLA.get());
		this.dropThis(IcariaBlocks.MONDANOS.get());
		this.dropThis(IcariaBlocks.MOTH_AGARIC.get());
		this.dropThis(IcariaBlocks.NAMDRAKE.get());
		this.dropThis(IcariaBlocks.PSILOCYBOS.get());
		this.dropThis(IcariaBlocks.ROWAN.get());
		this.dropThis(IcariaBlocks.WILTED_ELM.get());
		this.dropThis(IcariaBlocks.PALM_FERN.get());
		this.dropThis(IcariaBlocks.WHITE_BROMELIA.get());
		this.dropThis(IcariaBlocks.ORANGE_BROMELIA.get());
		this.dropThis(IcariaBlocks.PINK_BROMELIA.get());
		this.dropThis(IcariaBlocks.PURPLE_BROMELIA.get());
		this.dropThis(IcariaBlocks.GREEN_GROUND_SHROOMS.get());
		this.dropThis(IcariaBlocks.BROWN_GROUND_SHROOMS.get());
		this.dropThis(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get());
		this.dropThis(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get());
		this.dropThis(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get());
		this.dropThis(IcariaBlocks.UNNAMED_TREE_SHROOMS.get());
		this.dropThis(IcariaBlocks.CARDON_CACTUS.get());
	}

	public void dropThisWithSilk() {
		this.dropThisWithSilk(IcariaBlocks.GRAINGLASS.get());
		this.dropThisWithSilk(IcariaBlocks.GRAINGLASS_PANE.get());
		this.dropThisWithSilk(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get());
		this.dropThisWithSilk(IcariaBlocks.GRAINITE_RUBBLE.get());
		this.dropThisWithSilk(IcariaBlocks.YELLOWSTONE_RUBBLE.get());
		this.dropThisWithSilk(IcariaBlocks.SILKGLASS.get());
		this.dropThisWithSilk(IcariaBlocks.SILKGLASS_PANE.get());
		this.dropThisWithSilk(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get());
		this.dropThisWithSilk(IcariaBlocks.SILKSTONE_RUBBLE.get());
		this.dropThisWithSilk(IcariaBlocks.SUNSTONE_RUBBLE.get());
		this.dropThisWithSilk(IcariaBlocks.VOIDSHALE_RUBBLE.get());
		this.dropThisWithSilk(IcariaBlocks.BAETYL_RUBBLE.get());
		this.dropThisWithSilk(IcariaBlocks.RELICSTONE_RUBBLE.get());
		this.dropThisWithSilk(IcariaBlocks.HYLIASTRUM_ORE.get());
		this.dropThisWithSilk(IcariaBlocks.ARISTONE.get());
		this.dropThisWithSilk(IcariaBlocks.PACKED_ARISTONE.get());
	}

	public void dropThisWithSilkOrBone() {
		this.dropThisWithSilkOrBone(IcariaBlocks.MARL_BONES.get(), IcariaItems.ROTTEN_BONES.get(), 1.0F, 2);
		this.dropThisWithSilkOrBone(IcariaBlocks.SURFACE_BONES.get(), IcariaItems.BONE_REMAINS.get(), 1.0F, 2);
	}

	public void dropThisWithSilkOrElse() {
		this.dropThisWithSilkOrElse(IcariaBlocks.GRASSY_MARL.get(), IcariaItems.MARL.get(), 1.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.MARL_CHERT.get(), IcariaItems.CHERT.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.SURFACE_CHERT.get(), IcariaItems.CHERT.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.MARL_LIGNITE.get(), IcariaItems.LIGNITE.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.SURFACE_LIGNITE.get(), IcariaItems.LIGNITE.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.LOAM.get(), IcariaItems.LOAM_LUMP.get(), 4.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.GRAINEL_CHERT.get(), IcariaItems.CHERT.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.YELLOWSTONE.get(), IcariaItems.COBBLED_YELLOWSTONE.get(), 1.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.SILKSTONE.get(), IcariaItems.COBBLED_SILKSTONE.get(), 1.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.SUNSTONE.get(), IcariaItems.COBBLED_SUNSTONE.get(), 1.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.VOIDSHALE.get(), IcariaItems.COBBLED_VOIDSHALE.get(), 1.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.BAETYL.get(), IcariaItems.COBBLED_BAETYL.get(), 1.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.SMOOTH_RELICSTONE.get(), IcariaItems.RELICSTONE.get(), 1.0F, 0);
		this.dropThisWithSilkOrElse(IcariaBlocks.BLURRED_PLATOSHALE.get(), IcariaItems.BLURIDIUM_NUGGET.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get(), IcariaItems.BLURIDIUM_NUGGET.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.LIGNITE_ORE.get(), IcariaItems.LIGNITE.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.CHALKOS_ORE.get(), IcariaItems.RAW_CHALKOS.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.KASSITEROS_ORE.get(), IcariaItems.RAW_KASSITEROS.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.DOLOMITE_ORE.get(), IcariaItems.DOLOMITE.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.VANADIUM_ORE.get(), IcariaItems.RAW_VANADIUM.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.SLIVER_ORE.get(), IcariaItems.SLIVER.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.SIDEROS_ORE.get(), IcariaItems.RAW_SIDEROS.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.ANTHRACITE_ORE.get(), IcariaItems.ANTHRACITE.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.MOLYBDENUM_ORE.get(), IcariaItems.RAW_MOLYBDENUM.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaItems.CALCITE_SHARD.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.HALITE_CRYSTAL.get(), IcariaItems.HALITE_SHARD.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.JASPER_CRYSTAL.get(), IcariaItems.JASPER_SHARD.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.ZIRCON_CRYSTAL.get(), IcariaItems.ZIRCON_SHARD.get(), 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.CYPRESS_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.DROUGHTROOT_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.FIR_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.LAUREL_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.OLIVE_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.PLANE_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropThisWithSilkOrElse(IcariaBlocks.POPULUS_TWIGS.get(), Items.STICK, 1.0F, 2);
	}

	public void dropVine() {
		this.dropVine(IcariaBlocks.BRANCHY_VINE.get());
		this.dropVine(IcariaBlocks.DRY_VINE.get());
		this.dropVine(IcariaBlocks.SWIRLY_VINE.get());
		this.dropVine(IcariaBlocks.THORNY_VINE.get());
	}

	public void dropVineWithLoot() {
		this.dropVineWithLoot(IcariaBlocks.REEDY_VINE.get(), IcariaItems.VINE_REED.get());
	}

	public void dropBush(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.RIPE, Ripe.RIPE))))));
	}

	public void dropCake(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.WHITE_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.WHITE_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.LIGHT_GRAY_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.LIGHT_GRAY_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.GRAY_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.GRAY_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.BLACK_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.BLACK_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.BROWN_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.BROWN_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.RED_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.RED_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.ORANGE_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.ORANGE_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.YELLOW_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.YELLOW_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.LIME_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.LIME_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.GREEN_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.GREEN_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.CYAN_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.CYAN_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.LIGHT_BLUE_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.LIGHT_BLUE_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.BLUE_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.BLUE_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.PURPLE_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.PURPLE_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.MAGENTA_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.MAGENTA_CANDLE)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.PINK_CANDLE)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CANDLE, Candle.PINK_CANDLE)))));
	}

	public void dropCrop(Block pBlock, Item pCrop, Item pSeed) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeed))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeed).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pCrop).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))))));
	}

	public void dropDoor(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER))))));
	}

	public void dropElse(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem))));
	}

	public void dropGroundFlowers(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.FLOWER_AMOUNT, 1))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.FLOWER_AMOUNT, 2))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.FLOWER_AMOUNT, 3))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.FLOWER_AMOUNT, 4))))));
	}

	public void dropLaurelLeaves(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shearsOrSilk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.SAPLING_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.STICK).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.STICK_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.LAUREL_CHERRY.get()).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.CHERRY_CHANCES)))));
	}

	public void dropLayers(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 1))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 2))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 3))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 4))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 5))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 6))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 7))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 8))))));
	}

	public void dropLeaves(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shearsOrSilk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.SAPLING_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.STICK).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.STICK_CHANCES)))));
	}

	public void dropNone(Block pBlock) {
		this.add(pBlock, LootTable.lootTable());
	}

	public void dropOliveLeaves(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shearsOrSilk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.SAPLING_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.STICK).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.STICK_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.GREEN_OLIVES.get())).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.GREEN)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.BLACK_OLIVES.get())).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.BLACK)))));
	}

	public void dropOnionCrop(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.GARLIC.get()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.GARLIC_CHANCES)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))))));
	}

	public void dropPotted(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Blocks.FLOWER_POT))));
	}

	public void dropRipeVineWithLoot(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.BLOOMING))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.RIPE))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.RIPE))))));
	}

	public void dropSeed(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.SPELT_SEEDS.get()).when(this.noShears()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.SEED_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.STRAWBERRY_SEEDS.get()).when(this.noShears()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.SEED_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.PHYSALIS_SEEDS.get()).when(this.noShears()).when(BonusLevelTableCondition.bonusLevelFlatChance(this.enchantments().getOrThrow(Enchantments.FORTUNE), IcariaBlockLootSubProvider.SEED_CHANCES)))));
	}

	public void dropSlab(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.SLAB_TYPE, SlabType.TOP))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE))))));
	}

	public void dropStool(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.WHITE_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.WHITE_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.LIGHT_GRAY_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.GRAY_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.GRAY_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.BLACK_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.BLACK_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.BROWN_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.BROWN_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.RED_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.RED_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.ORANGE_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.YELLOW_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.LIME_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.LIME_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.GREEN_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.GREEN_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.CYAN_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.CYAN_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.LIGHT_BLUE_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.BLUE_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.BLUE_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.PURPLE_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.MAGENTA_ARACHNE_STRING_CARPET)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.PINK_ARACHNE_STRING_CARPET.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.CARPET, Carpet.PINK_ARACHNE_STRING_CARPET)))));
	}

	public void dropThis(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock))));
	}

	public void dropThisWithSilk(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.silk()))));
	}

	public void dropThisWithSilkOrBone(Block pBlock, Item pItem, float pCount, int pBonus) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.silk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(pCount))).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), pBonus)).when(this.noSilk()).when(LootItemRandomChanceCondition.randomChance(0.1F)).otherwise(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(ConstantValue.exactly(pCount))).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), pBonus)).when(this.noSilk())))));
	}

	public void dropThisWithSilkOrElse(Block pBlock, Item pItem, float pCount, int pBonus) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.silk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(pCount))).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), pBonus)).when(this.noSilk()))));
	}

	public void dropVine(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))))));
	}

	public void dropVineWithLoot(Block pBlock, Item pItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(this.noShears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).apply(ApplyBonusCount.addUniformBonusCount(this.enchantments().getOrThrow(Enchantments.FORTUNE), 2)).when(this.noShears()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))))));
	}

	public HolderLookup.RegistryLookup<Enchantment> enchantments() {
		return this.registries.lookupOrThrow(Registries.ENCHANTMENT);
	}

	public HolderLookup.RegistryLookup<Item> items() {
		return this.registries.lookupOrThrow(Registries.ITEM);
	}

	@Override
	public Iterable<Block> getKnownBlocks() {
		return BuiltInRegistries.BLOCK.stream().filter((block) -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(IcariaIdents.ID)).collect(Collectors.toList());
	}

	public LootItemCondition.Builder noShears() {
		return this.shears().invert();
	}

	public LootItemCondition.Builder noShearsOrSilk() {
		return this.shearsOrSilk().invert();
	}

	public LootItemCondition.Builder noSilk() {
		return this.silk().invert();
	}

	public LootItemCondition.Builder shears() {
		return MatchTool.toolMatches(ItemPredicate.Builder.item().of(this.items(), Items.SHEARS));
	}

	public LootItemCondition.Builder shearsOrSilk() {
		return this.shears().or(this.silk());
	}

	public LootItemCondition.Builder silk() {
		var enchantmentPredicate = new EnchantmentPredicate(this.enchantments().getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1));
		return MatchTool.toolMatches(ItemPredicate.Builder.item().withComponents(DataComponentMatchers.Builder.components().partial(DataComponentPredicates.ENCHANTMENTS, EnchantmentsPredicate.enchantments(List.of(enchantmentPredicate))).build()));
	}
}
