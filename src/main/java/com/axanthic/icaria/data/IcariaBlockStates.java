package com.axanthic.icaria.data;

import com.axanthic.icaria.common.properties.*;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockStates extends BlockStateProvider {
	public IcariaBlockStates(PackOutput pOutput, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pId, pHelper);
	}

	@Override
	public void registerStatesAndModels() {
		this.grassyMarl(IcariaBlocks.GRASSY_MARL.get());
		this.aRot(IcariaBlocks.MARL.get());
		this.block(IcariaBlocks.MARL_CHERT.get());
		this.yRot(IcariaBlocks.SURFACE_CHERT.get());
		this.block(IcariaBlocks.MARL_BONES.get());
		this.yRot(IcariaBlocks.SURFACE_BONES.get());
		this.block(IcariaBlocks.MARL_LIGNITE.get());
		this.groundDeco(IcariaBlocks.SURFACE_LIGNITE.get());
		this.aRot(IcariaBlocks.COARSE_MARL.get());
		this.aRot(IcariaBlocks.DRY_LAKE_BED.get());

		this.farmland(IcariaBlocks.FARMLAND.get());
		this.block(IcariaBlocks.FERTILIZED_FARMLAND.get());

		this.block(IcariaBlocks.MARL_ADOBE.get());
		this.slab(IcariaBlocks.MARL_ADOBE_DECO.slab.get(), IcariaBlocks.MARL_ADOBE.get());
		this.stairs(IcariaBlocks.MARL_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.MARL_ADOBE_DECO.wall.get());

		this.aRot(IcariaBlocks.LOAM.get());
		this.block(IcariaBlocks.LOAM_BRICKS.get());
		this.slab(IcariaBlocks.LOAM_BRICK_DECO.slab.get(), IcariaBlocks.LOAM_BRICKS.get());
		this.stairs(IcariaBlocks.LOAM_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.LOAM_BRICK_DECO.wall.get());

		this.block(IcariaBlocks.DOLOMITE_ADOBE.get());
		this.slab(IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get(), IcariaBlocks.DOLOMITE_ADOBE.get());
		this.stairs(IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.DOLOMITE_ADOBE_DECO.wall.get());
		this.block(IcariaBlocks.SMOOTH_DOLOMITE.get());
		this.slab(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get(), IcariaBlocks.SMOOTH_DOLOMITE.get());
		this.stairs(IcariaBlocks.SMOOTH_DOLOMITE_DECO.stairs.get());
		this.wall(IcariaBlocks.SMOOTH_DOLOMITE_DECO.wall.get());
		this.block(IcariaBlocks.DOLOMITE_BRICKS.get());
		this.axis(IcariaBlocks.DOLOMITE_PILLAR.get());
		this.pillarHead(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());

		this.aRot(IcariaBlocks.GRAINEL.get());
		this.block(IcariaBlocks.GRAINEL_CHERT.get());
		this.block(IcariaBlocks.GRAINGLASS.get());
		this.pane(IcariaBlocks.GRAINGLASS_PANE.get());
		this.block(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get());
		this.block(IcariaBlocks.GRAINITE_ADOBE.get());
		this.slab(IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get(), IcariaBlocks.GRAINITE_ADOBE.get());
		this.stairs(IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.GRAINITE_ADOBE_DECO.wall.get());
		this.block(IcariaBlocks.GRAINITE.get());
		this.slab(IcariaBlocks.GRAINITE_DECO.slab.get(), IcariaBlocks.GRAINITE.get());
		this.stairs(IcariaBlocks.GRAINITE_DECO.stairs.get());
		this.wall(IcariaBlocks.GRAINITE_DECO.wall.get());
		this.block(IcariaBlocks.GRAINITE_BRICKS.get());
		this.slab(IcariaBlocks.GRAINITE_BRICK_DECO.slab.get(), IcariaBlocks.GRAINITE_BRICKS.get());
		this.stairs(IcariaBlocks.GRAINITE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.GRAINITE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.CHISELED_GRAINITE.get());
		this.groundDeco(IcariaBlocks.GRAINITE_RUBBLE.get());

		this.block(IcariaBlocks.YELLOWSTONE_ADOBE.get());
		this.slab(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get());
		this.stairs(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.wall.get());
		this.block(IcariaBlocks.COBBLED_YELLOWSTONE.get());
		this.slab(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.slab.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get());
		this.stairs(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.wall.get());
		this.block(IcariaBlocks.YELLOWSTONE.get());
		this.slab(IcariaBlocks.YELLOWSTONE_DECO.slab.get(), IcariaBlocks.YELLOWSTONE.get());
		this.stairs(IcariaBlocks.YELLOWSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.YELLOWSTONE_DECO.wall.get());
		this.block(IcariaBlocks.YELLOWSTONE_BRICKS.get());
		this.slab(IcariaBlocks.YELLOWSTONE_BRICK_DECO.slab.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.YELLOWSTONE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.YELLOWSTONE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.CHISELED_YELLOWSTONE.get());
		this.groundDeco(IcariaBlocks.YELLOWSTONE_RUBBLE.get());

		this.aRot(IcariaBlocks.SILKSAND.get());
		this.block(IcariaBlocks.SILKGLASS.get());
		this.pane(IcariaBlocks.SILKGLASS_PANE.get());
		this.block(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get());
		this.block(IcariaBlocks.SILKSTONE_ADOBE.get());
		this.slab(IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get(), IcariaBlocks.SILKSTONE_ADOBE.get());
		this.stairs(IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.SILKSTONE_ADOBE_DECO.wall.get());
		this.block(IcariaBlocks.COBBLED_SILKSTONE.get());
		this.slab(IcariaBlocks.COBBLED_SILKSTONE_DECO.slab.get(), IcariaBlocks.COBBLED_SILKSTONE.get());
		this.stairs(IcariaBlocks.COBBLED_SILKSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.COBBLED_SILKSTONE_DECO.wall.get());
		this.block(IcariaBlocks.SILKSTONE.get());
		this.slab(IcariaBlocks.SILKSTONE_DECO.slab.get(), IcariaBlocks.SILKSTONE.get());
		this.stairs(IcariaBlocks.SILKSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.SILKSTONE_DECO.wall.get());
		this.block(IcariaBlocks.SILKSTONE_BRICKS.get());
		this.slab(IcariaBlocks.SILKSTONE_BRICK_DECO.slab.get(), IcariaBlocks.SILKSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.SILKSTONE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.SILKSTONE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.CHISELED_SILKSTONE.get());
		this.groundDeco(IcariaBlocks.SILKSTONE_RUBBLE.get());

		this.block(IcariaBlocks.SUNSTONE_ADOBE.get());
		this.slab(IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get(), IcariaBlocks.SUNSTONE_ADOBE.get());
		this.stairs(IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.SUNSTONE_ADOBE_DECO.wall.get());
		this.block(IcariaBlocks.COBBLED_SUNSTONE.get());
		this.slab(IcariaBlocks.COBBLED_SUNSTONE_DECO.slab.get(), IcariaBlocks.COBBLED_SUNSTONE.get());
		this.stairs(IcariaBlocks.COBBLED_SUNSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.COBBLED_SUNSTONE_DECO.wall.get());
		this.block(IcariaBlocks.SUNSTONE.get());
		this.slab(IcariaBlocks.SUNSTONE_DECO.slab.get(), IcariaBlocks.SUNSTONE.get());
		this.stairs(IcariaBlocks.SUNSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.SUNSTONE_DECO.wall.get());
		this.block(IcariaBlocks.SUNSTONE_BRICKS.get());
		this.slab(IcariaBlocks.SUNSTONE_BRICK_DECO.slab.get(), IcariaBlocks.SUNSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.SUNSTONE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.SUNSTONE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.CHISELED_SUNSTONE.get());
		this.groundDeco(IcariaBlocks.SUNSTONE_RUBBLE.get());

		this.block(IcariaBlocks.VOIDSHALE_ADOBE.get());
		this.slab(IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get(), IcariaBlocks.VOIDSHALE_ADOBE.get());
		this.stairs(IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.VOIDSHALE_ADOBE_DECO.wall.get());
		this.block(IcariaBlocks.COBBLED_VOIDSHALE.get());
		this.slab(IcariaBlocks.COBBLED_VOIDSHALE_DECO.slab.get(), IcariaBlocks.COBBLED_VOIDSHALE.get());
		this.stairs(IcariaBlocks.COBBLED_VOIDSHALE_DECO.stairs.get());
		this.wall(IcariaBlocks.COBBLED_VOIDSHALE_DECO.wall.get());
		this.block(IcariaBlocks.VOIDSHALE.get());
		this.slab(IcariaBlocks.VOIDSHALE_DECO.slab.get(), IcariaBlocks.VOIDSHALE.get());
		this.stairs(IcariaBlocks.VOIDSHALE_DECO.stairs.get());
		this.wall(IcariaBlocks.VOIDSHALE_DECO.wall.get());
		this.block(IcariaBlocks.VOIDSHALE_BRICKS.get());
		this.slab(IcariaBlocks.VOIDSHALE_BRICK_DECO.slab.get(), IcariaBlocks.VOIDSHALE_BRICKS.get());
		this.stairs(IcariaBlocks.VOIDSHALE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.VOIDSHALE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.CHISELED_VOIDSHALE.get());
		this.groundDeco(IcariaBlocks.VOIDSHALE_RUBBLE.get());

		this.block(IcariaBlocks.BAETYL_ADOBE.get());
		this.slab(IcariaBlocks.BAETYL_ADOBE_DECO.slab.get(), IcariaBlocks.BAETYL_ADOBE.get());
		this.stairs(IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get());
		this.wall(IcariaBlocks.BAETYL_ADOBE_DECO.wall.get());
		this.block(IcariaBlocks.COBBLED_BAETYL.get());
		this.slab(IcariaBlocks.COBBLED_BAETYL_DECO.slab.get(), IcariaBlocks.COBBLED_BAETYL.get());
		this.stairs(IcariaBlocks.COBBLED_BAETYL_DECO.stairs.get());
		this.wall(IcariaBlocks.COBBLED_BAETYL_DECO.wall.get());
		this.block(IcariaBlocks.BAETYL.get());
		this.slab(IcariaBlocks.BAETYL_DECO.slab.get(), IcariaBlocks.BAETYL.get());
		this.stairs(IcariaBlocks.BAETYL_DECO.stairs.get());
		this.wall(IcariaBlocks.BAETYL_DECO.wall.get());
		this.block(IcariaBlocks.BAETYL_BRICKS.get());
		this.slab(IcariaBlocks.BAETYL_BRICK_DECO.slab.get(), IcariaBlocks.BAETYL_BRICKS.get());
		this.stairs(IcariaBlocks.BAETYL_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.BAETYL_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.CHISELED_BAETYL.get());
		this.groundDeco(IcariaBlocks.BAETYL_RUBBLE.get());

		this.block(IcariaBlocks.RELICSTONE.get());
		this.slab(IcariaBlocks.RELICSTONE_DECO.slab.get(), IcariaBlocks.RELICSTONE.get());
		this.stairs(IcariaBlocks.RELICSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.RELICSTONE_DECO.wall.get());
		this.block(IcariaBlocks.SMOOTH_RELICSTONE.get());
		this.slab(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get(), IcariaBlocks.SMOOTH_RELICSTONE.get());
		this.stairs(IcariaBlocks.SMOOTH_RELICSTONE_DECO.stairs.get());
		this.wall(IcariaBlocks.SMOOTH_RELICSTONE_DECO.wall.get());
		this.block(IcariaBlocks.RELICSTONE_BRICKS.get());
		this.slab(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get(), IcariaBlocks.RELICSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.RELICSTONE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.RELICSTONE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get());
		this.slab(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get());
		this.slab(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.RELICSTONE_TILES.get());
		this.slab(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get(), IcariaBlocks.RELICSTONE_TILES.get());
		this.stairs(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get());
		this.wall(IcariaBlocks.RELICSTONE_TILE_DECO.wall.get());
		this.block(IcariaBlocks.CRACKED_RELICSTONE_TILES.get());
		this.slab(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get());
		this.stairs(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.stairs.get());
		this.wall(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.wall.get());
		this.block(IcariaBlocks.MOSSY_RELICSTONE_TILES.get());
		this.slab(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get());
		this.stairs(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.stairs.get());
		this.wall(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.wall.get());
		this.block(IcariaBlocks.CHISELED_RELICSTONE.get());
		this.axis(IcariaBlocks.RELICSTONE_PILLAR.get());
		this.pillarHead(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get());
		this.groundDeco(IcariaBlocks.RELICSTONE_RUBBLE.get());

		this.block(IcariaBlocks.PLATOSHALE.get());
		this.slab(IcariaBlocks.PLATOSHALE_DECO.slab.get(), IcariaBlocks.PLATOSHALE.get());
		this.stairs(IcariaBlocks.PLATOSHALE_DECO.stairs.get());
		this.wall(IcariaBlocks.PLATOSHALE_DECO.wall.get());
		this.block(IcariaBlocks.BLURRED_PLATOSHALE.get());
		this.block(IcariaBlocks.PLATOSHALE_BRICKS.get());
		this.slab(IcariaBlocks.PLATOSHALE_BRICK_DECO.slab.get(), IcariaBlocks.PLATOSHALE_BRICKS.get());
		this.stairs(IcariaBlocks.PLATOSHALE_BRICK_DECO.stairs.get());
		this.wall(IcariaBlocks.PLATOSHALE_BRICK_DECO.wall.get());
		this.block(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_PLATOSHALE.get());

		this.wall(IcariaBlocks.QUARTZ_WALL.get());
		this.pillarHead(IcariaBlocks.QUARTZ_PILLAR_HEAD.get());

		this.block(IcariaBlocks.LIGNITE_ORE.get());
		this.block(IcariaBlocks.CHALKOS_ORE.get());
		this.block(IcariaBlocks.KASSITEROS_ORE.get());
		this.block(IcariaBlocks.DOLOMITE_ORE.get());
		this.block(IcariaBlocks.VANADIUM_ORE.get());
		this.block(IcariaBlocks.SLIVER_ORE.get());
		this.block(IcariaBlocks.SIDEROS_ORE.get());
		this.block(IcariaBlocks.ANTHRACITE_ORE.get());
		this.block(IcariaBlocks.MOLYBDENUM_ORE.get());
		this.block(IcariaBlocks.HYLIASTRUM_ORE.get());

		this.block(IcariaBlocks.CALCITE.get());
		this.block(IcariaBlocks.BUDDING_CALCITE.get());
		this.block(IcariaBlocks.HALITE.get());
		this.block(IcariaBlocks.BUDDING_HALITE.get());
		this.block(IcariaBlocks.JASPER.get());
		this.block(IcariaBlocks.BUDDING_JASPER.get());
		this.block(IcariaBlocks.ZIRCON.get());
		this.block(IcariaBlocks.BUDDING_ZIRCON.get());

		this.directional(IcariaBlocks.CALCITE_CRYSTAL.get());
		this.directional(IcariaBlocks.HALITE_CRYSTAL.get());
		this.directional(IcariaBlocks.JASPER_CRYSTAL.get());
		this.directional(IcariaBlocks.ZIRCON_CRYSTAL.get());

		this.block(IcariaBlocks.ARISTONE.get());
		this.block(IcariaBlocks.PACKED_ARISTONE.get());

		this.block(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.block(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.block(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.block(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.block(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.block(IcariaBlocks.ARACHNE_STRING_BLOCK.get());
		this.axis(IcariaBlocks.SPELT_BALE_BLOCK.get());
		this.block(IcariaBlocks.VINE_REED_BLOCK.get());
		this.block(IcariaBlocks.ROTTEN_BONES_BLOCK.get());

		this.block(IcariaBlocks.RAW_CHALKOS_BLOCK.get());
		this.block(IcariaBlocks.RAW_KASSITEROS_BLOCK.get());
		this.block(IcariaBlocks.RAW_VANADIUM_BLOCK.get());
		this.block(IcariaBlocks.RAW_SIDEROS_BLOCK.get());
		this.block(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get());

		this.block(IcariaBlocks.CALCITE_BLOCK.get());
		this.block(IcariaBlocks.HALITE_BLOCK.get());
		this.block(IcariaBlocks.JASPER_BLOCK.get());
		this.block(IcariaBlocks.ZIRCON_BLOCK.get());
		this.block(IcariaBlocks.CHERT_BLOCK.get());
		this.block(IcariaBlocks.LIGNITE_BLOCK.get());
		this.block(IcariaBlocks.CHALKOS_BLOCK.get());
		this.block(IcariaBlocks.KASSITEROS_BLOCK.get());
		this.block(IcariaBlocks.ORICHALCUM_BLOCK.get());
		this.block(IcariaBlocks.VANADIUM_BLOCK.get());
		this.block(IcariaBlocks.SLIVER_BLOCK.get());
		this.block(IcariaBlocks.VANADIUMSTEEL_BLOCK.get());
		this.block(IcariaBlocks.SIDEROS_BLOCK.get());
		this.block(IcariaBlocks.ANTHRACITE_BLOCK.get());
		this.block(IcariaBlocks.MOLYBDENUM_BLOCK.get());
		this.block(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get());
		this.block(IcariaBlocks.BLURIDIUM_BLOCK.get());

		this.bars(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		this.block(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get());

		this.chain(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());

		this.kettle(IcariaBlocks.KETTLE.get());
		this.grinder(IcariaBlocks.GRINDER.get());
		this.kiln(IcariaBlocks.KILN.get());
		this.forge(IcariaBlocks.FORGE.get());

		this.block(IcariaBlocks.CHEST.get());
		this.block(IcariaBlocks.TRAPPED_CHEST.get());

		this.block(IcariaBlocks.STORAGE_VASE.get());
		this.block(IcariaBlocks.WHITE_STORAGE_VASE.get());
		this.block(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get());
		this.block(IcariaBlocks.GRAY_STORAGE_VASE.get());
		this.block(IcariaBlocks.BLACK_STORAGE_VASE.get());
		this.block(IcariaBlocks.BROWN_STORAGE_VASE.get());
		this.block(IcariaBlocks.RED_STORAGE_VASE.get());
		this.block(IcariaBlocks.ORANGE_STORAGE_VASE.get());
		this.block(IcariaBlocks.YELLOW_STORAGE_VASE.get());
		this.block(IcariaBlocks.LIME_STORAGE_VASE.get());
		this.block(IcariaBlocks.GREEN_STORAGE_VASE.get());
		this.block(IcariaBlocks.CYAN_STORAGE_VASE.get());
		this.block(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get());
		this.block(IcariaBlocks.BLUE_STORAGE_VASE.get());
		this.block(IcariaBlocks.PURPLE_STORAGE_VASE.get());
		this.block(IcariaBlocks.MAGENTA_STORAGE_VASE.get());
		this.block(IcariaBlocks.PINK_STORAGE_VASE.get());

		this.lootVase(IcariaBlocks.RED_LOOT_VASE.get());
		this.lootVase(IcariaBlocks.LOST_LOOT_VASE.get());
		this.lootVase(IcariaBlocks.CYAN_LOOT_VASE.get());

		this.block(IcariaBlocks.ARACHNE_SPAWNER.get());
		this.block(IcariaBlocks.REVENANT_SPAWNER.get());

		this.skull(IcariaBlocks.AETERNAE_SKULL.get());
		this.skull(IcariaBlocks.AETERNAE_WALL_SKULL.get());
		this.skull(IcariaBlocks.ARGAN_HOUND_SKULL.get());
		this.skull(IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get());
		this.skull(IcariaBlocks.CAPELLA_SKULL.get());
		this.skull(IcariaBlocks.CAPELLA_WALL_SKULL.get());
		this.skull(IcariaBlocks.CATOBLEPAS_SKULL.get());
		this.skull(IcariaBlocks.CATOBLEPAS_WALL_SKULL.get());
		this.skull(IcariaBlocks.CERVER_SKULL.get());
		this.skull(IcariaBlocks.CERVER_WALL_SKULL.get());
		this.skull(IcariaBlocks.CROCOTTA_SKULL.get());
		this.skull(IcariaBlocks.CROCOTTA_WALL_SKULL.get());
		this.skull(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get());
		this.skull(IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get());
		this.skull(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get());
		this.skull(IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get());
		this.skull(IcariaBlocks.FIR_FOREST_HAG_SKULL.get());
		this.skull(IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get());
		this.skull(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get());
		this.skull(IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get());
		this.skull(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get());
		this.skull(IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get());
		this.skull(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get());
		this.skull(IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get());
		this.skull(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get());
		this.skull(IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get());
		this.skull(IcariaBlocks.REVENANT_SKULL.get());
		this.skull(IcariaBlocks.REVENANT_WALL_SKULL.get());
		this.skull(IcariaBlocks.SOW_SKULL.get());
		this.skull(IcariaBlocks.SOW_WALL_SKULL.get());

		this.block(IcariaBlocks.LIGNITE_TORCH.get());
		this.horizontal(IcariaBlocks.LIGNITE_WALL_TORCH.get());
		this.block(IcariaBlocks.ANTHRACITE_TORCH.get());
		this.horizontal(IcariaBlocks.ANTHRACITE_WALL_TORCH.get());

		this.cake(IcariaBlocks.LAUREL_CHERRY_CAKE.get());
		this.cake(IcariaBlocks.STRAWBERRY_CAKE.get());
		this.cake(IcariaBlocks.PHYSALIS_CAKE.get());
		this.cake(IcariaBlocks.VINE_BERRY_CAKE.get());
		this.cake(IcariaBlocks.VINE_SPROUT_CAKE.get());

		this.block(IcariaBlocks.CYPRESS_SAPLING.get());
		this.block(IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		this.block(IcariaBlocks.CYPRESS_LEAVES.get());
		this.layer(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		this.groundDeco(IcariaBlocks.CYPRESS_TWIGS.get());
		this.axis(IcariaBlocks.CYPRESS_WOOD.get());
		this.axis(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		this.axis(IcariaBlocks.CYPRESS_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_CYPRESS_LOG.get());
		this.deadLog(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		this.block(IcariaBlocks.CYPRESS_PLANKS.get());
		this.slab(IcariaBlocks.CYPRESS_DECO.slab.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.stairs(IcariaBlocks.CYPRESS_DECO.stairs.get());
		this.fence(IcariaBlocks.CYPRESS_DECO.fence.get());
		this.gate(IcariaBlocks.CYPRESS_DECO.gate.get());
		this.simpleRack(IcariaBlocks.SIMPLE_CYPRESS_RACK.get());
		this.rack(IcariaBlocks.CYPRESS_RACK.get());
		this.barrel(IcariaBlocks.CYPRESS_BARREL.get());
		this.barrel(IcariaBlocks.LOADED_CYPRESS_BARREL.get());
		this.barrel(IcariaBlocks.TAPPED_CYPRESS_BARREL.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get());
		this.horizontal(IcariaBlocks.CYPRESS_TROUGH.get());
		this.block(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get());
		this.door(IcariaBlocks.CYPRESS_DOOR.get());
		this.trapdoor(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		this.horizontal(IcariaBlocks.CYPRESS_LADDER.get());
		this.block(IcariaBlocks.CYPRESS_SIGN.get());
		this.block(IcariaBlocks.CYPRESS_WALL_SIGN.get());
		this.block(IcariaBlocks.CYPRESS_HANGING_SIGN.get());
		this.block(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get());

		this.block(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.block(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		this.block(IcariaBlocks.DROUGHTROOT_LEAVES.get());
		this.layer(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		this.groundDeco(IcariaBlocks.DROUGHTROOT_TWIGS.get());
		this.axis(IcariaBlocks.DROUGHTROOT_WOOD.get());
		this.axis(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		this.axis(IcariaBlocks.DROUGHTROOT_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.deadDroughtrootLog(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get());
		this.deadLog(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		this.block(IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.slab(IcariaBlocks.DROUGHTROOT_DECO.slab.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.stairs(IcariaBlocks.DROUGHTROOT_DECO.stairs.get());
		this.fence(IcariaBlocks.DROUGHTROOT_DECO.fence.get());
		this.gate(IcariaBlocks.DROUGHTROOT_DECO.gate.get());
		this.simpleRack(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get());
		this.rack(IcariaBlocks.DROUGHTROOT_RACK.get());
		this.barrel(IcariaBlocks.DROUGHTROOT_BARREL.get());
		this.barrel(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get());
		this.barrel(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get());
		this.horizontal(IcariaBlocks.DROUGHTROOT_TROUGH.get());
		this.block(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get());
		this.door(IcariaBlocks.DROUGHTROOT_DOOR.get());
		this.trapdoor(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		this.horizontal(IcariaBlocks.DROUGHTROOT_LADDER.get());
		this.block(IcariaBlocks.DROUGHTROOT_SIGN.get());
		this.block(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get());
		this.block(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get());
		this.block(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get());

		this.block(IcariaBlocks.FIR_SAPLING.get());
		this.block(IcariaBlocks.POTTED_FIR_SAPLING.get());
		this.block(IcariaBlocks.FIR_LEAVES.get());
		this.layer(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		this.groundDeco(IcariaBlocks.FIR_TWIGS.get());
		this.axis(IcariaBlocks.FIR_WOOD.get());
		this.axis(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		this.axis(IcariaBlocks.FIR_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_FIR_LOG.get());
		this.deadLog(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		this.block(IcariaBlocks.FIR_PLANKS.get());
		this.slab(IcariaBlocks.FIR_DECO.slab.get(), IcariaBlocks.FIR_PLANKS.get());
		this.stairs(IcariaBlocks.FIR_DECO.stairs.get());
		this.fence(IcariaBlocks.FIR_DECO.fence.get());
		this.gate(IcariaBlocks.FIR_DECO.gate.get());
		this.simpleRack(IcariaBlocks.SIMPLE_FIR_RACK.get());
		this.rack(IcariaBlocks.FIR_RACK.get());
		this.barrel(IcariaBlocks.FIR_BARREL.get());
		this.barrel(IcariaBlocks.LOADED_FIR_BARREL.get());
		this.barrel(IcariaBlocks.TAPPED_FIR_BARREL.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get(), IcariaBlocks.FIR_BARREL.get());
		this.horizontal(IcariaBlocks.FIR_TROUGH.get());
		this.block(IcariaBlocks.FIR_CRAFTING_TABLE.get());
		this.door(IcariaBlocks.FIR_DOOR.get());
		this.trapdoor(IcariaBlocks.FIR_TRAPDOOR.get());
		this.horizontal(IcariaBlocks.FIR_LADDER.get());
		this.block(IcariaBlocks.FIR_SIGN.get());
		this.block(IcariaBlocks.FIR_WALL_SIGN.get());
		this.block(IcariaBlocks.FIR_HANGING_SIGN.get());
		this.block(IcariaBlocks.FIR_WALL_HANGING_SIGN.get());

		this.block(IcariaBlocks.LAUREL_SAPLING.get());
		this.block(IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		this.block(IcariaBlocks.LAUREL_LEAVES.get());
		this.layer(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		this.groundDeco(IcariaBlocks.LAUREL_TWIGS.get());
		this.axis(IcariaBlocks.LAUREL_WOOD.get());
		this.axis(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		this.axis(IcariaBlocks.LAUREL_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_LAUREL_LOG.get());
		this.deadLog(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		this.block(IcariaBlocks.LAUREL_PLANKS.get());
		this.slab(IcariaBlocks.LAUREL_DECO.slab.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.stairs(IcariaBlocks.LAUREL_DECO.stairs.get());
		this.fence(IcariaBlocks.LAUREL_DECO.fence.get());
		this.gate(IcariaBlocks.LAUREL_DECO.gate.get());
		this.simpleRack(IcariaBlocks.SIMPLE_LAUREL_RACK.get());
		this.rack(IcariaBlocks.LAUREL_RACK.get());
		this.barrel(IcariaBlocks.LAUREL_BARREL.get());
		this.barrel(IcariaBlocks.LOADED_LAUREL_BARREL.get());
		this.barrel(IcariaBlocks.TAPPED_LAUREL_BARREL.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get());
		this.horizontal(IcariaBlocks.LAUREL_TROUGH.get());
		this.block(IcariaBlocks.LAUREL_CRAFTING_TABLE.get());
		this.door(IcariaBlocks.LAUREL_DOOR.get());
		this.trapdoor(IcariaBlocks.LAUREL_TRAPDOOR.get());
		this.horizontal(IcariaBlocks.LAUREL_LADDER.get());
		this.block(IcariaBlocks.LAUREL_SIGN.get());
		this.block(IcariaBlocks.LAUREL_WALL_SIGN.get());
		this.block(IcariaBlocks.LAUREL_HANGING_SIGN.get());
		this.block(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get());

		this.block(IcariaBlocks.OLIVE_SAPLING.get());
		this.block(IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		this.oliveLeaves(IcariaBlocks.OLIVE_LEAVES.get());
		this.layer(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		this.groundDeco(IcariaBlocks.OLIVE_TWIGS.get());
		this.axis(IcariaBlocks.OLIVE_WOOD.get());
		this.axis(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		this.axis(IcariaBlocks.OLIVE_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_OLIVE_LOG.get());
		this.deadLog(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		this.block(IcariaBlocks.OLIVE_PLANKS.get());
		this.slab(IcariaBlocks.OLIVE_DECO.slab.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.stairs(IcariaBlocks.OLIVE_DECO.stairs.get());
		this.fence(IcariaBlocks.OLIVE_DECO.fence.get());
		this.gate(IcariaBlocks.OLIVE_DECO.gate.get());
		this.simpleRack(IcariaBlocks.SIMPLE_OLIVE_RACK.get());
		this.rack(IcariaBlocks.OLIVE_RACK.get());
		this.barrel(IcariaBlocks.OLIVE_BARREL.get());
		this.barrel(IcariaBlocks.LOADED_OLIVE_BARREL.get());
		this.barrel(IcariaBlocks.TAPPED_OLIVE_BARREL.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get(), IcariaBlocks.OLIVE_BARREL.get());
		this.horizontal(IcariaBlocks.OLIVE_TROUGH.get());
		this.block(IcariaBlocks.OLIVE_CRAFTING_TABLE.get());
		this.door(IcariaBlocks.OLIVE_DOOR.get());
		this.trapdoor(IcariaBlocks.OLIVE_TRAPDOOR.get());
		this.horizontal(IcariaBlocks.OLIVE_LADDER.get());
		this.block(IcariaBlocks.OLIVE_SIGN.get());
		this.block(IcariaBlocks.OLIVE_WALL_SIGN.get());
		this.block(IcariaBlocks.OLIVE_HANGING_SIGN.get());
		this.block(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get());

		this.block(IcariaBlocks.PLANE_SAPLING.get());
		this.block(IcariaBlocks.POTTED_PLANE_SAPLING.get());
		this.block(IcariaBlocks.PLANE_LEAVES.get());
		this.layer(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		this.groundDeco(IcariaBlocks.PLANE_TWIGS.get());
		this.axis(IcariaBlocks.PLANE_WOOD.get());
		this.axis(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		this.axis(IcariaBlocks.PLANE_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_PLANE_LOG.get());
		this.deadLog(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		this.block(IcariaBlocks.PLANE_PLANKS.get());
		this.slab(IcariaBlocks.PLANE_DECO.slab.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.stairs(IcariaBlocks.PLANE_DECO.stairs.get());
		this.fence(IcariaBlocks.PLANE_DECO.fence.get());
		this.gate(IcariaBlocks.PLANE_DECO.gate.get());
		this.simpleRack(IcariaBlocks.SIMPLE_PLANE_RACK.get());
		this.rack(IcariaBlocks.PLANE_RACK.get());
		this.barrel(IcariaBlocks.PLANE_BARREL.get());
		this.barrel(IcariaBlocks.LOADED_PLANE_BARREL.get());
		this.barrel(IcariaBlocks.TAPPED_PLANE_BARREL.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get(), IcariaBlocks.PLANE_BARREL.get());
		this.horizontal(IcariaBlocks.PLANE_TROUGH.get());
		this.block(IcariaBlocks.PLANE_CRAFTING_TABLE.get());
		this.door(IcariaBlocks.PLANE_DOOR.get());
		this.trapdoor(IcariaBlocks.PLANE_TRAPDOOR.get());
		this.horizontal(IcariaBlocks.PLANE_LADDER.get());
		this.block(IcariaBlocks.PLANE_SIGN.get());
		this.block(IcariaBlocks.PLANE_WALL_SIGN.get());
		this.block(IcariaBlocks.PLANE_HANGING_SIGN.get());
		this.block(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get());

		this.block(IcariaBlocks.POPULUS_SAPLING.get());
		this.block(IcariaBlocks.POTTED_POPULUS_SAPLING.get());
		this.block(IcariaBlocks.POPULUS_LEAVES.get());
		this.layer(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		this.groundDeco(IcariaBlocks.POPULUS_TWIGS.get());
		this.axis(IcariaBlocks.POPULUS_WOOD.get());
		this.axis(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		this.axis(IcariaBlocks.POPULUS_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_POPULUS_LOG.get());
		this.deadLog(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());
		this.block(IcariaBlocks.POPULUS_PLANKS.get());
		this.slab(IcariaBlocks.POPULUS_DECO.slab.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.stairs(IcariaBlocks.POPULUS_DECO.stairs.get());
		this.fence(IcariaBlocks.POPULUS_DECO.fence.get());
		this.gate(IcariaBlocks.POPULUS_DECO.gate.get());
		this.simpleRack(IcariaBlocks.SIMPLE_POPULUS_RACK.get());
		this.rack(IcariaBlocks.POPULUS_RACK.get());
		this.barrel(IcariaBlocks.POPULUS_BARREL.get());
		this.barrel(IcariaBlocks.LOADED_POPULUS_BARREL.get());
		this.barrel(IcariaBlocks.TAPPED_POPULUS_BARREL.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get(), IcariaBlocks.POPULUS_BARREL.get());
		this.horizontal(IcariaBlocks.POPULUS_TROUGH.get());
		this.block(IcariaBlocks.POPULUS_CRAFTING_TABLE.get());
		this.door(IcariaBlocks.POPULUS_DOOR.get());
		this.trapdoor(IcariaBlocks.POPULUS_TRAPDOOR.get());
		this.horizontal(IcariaBlocks.POPULUS_LADDER.get());
		this.block(IcariaBlocks.POPULUS_SIGN.get());
		this.block(IcariaBlocks.POPULUS_WALL_SIGN.get());
		this.block(IcariaBlocks.POPULUS_HANGING_SIGN.get());
		this.block(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get());

		this.bloomyVine(IcariaBlocks.BLOOMY_VINE.get());
		this.vine(IcariaBlocks.BRANCHY_VINE.get());
		this.brushyVine(IcariaBlocks.BRUSHY_VINE.get());
		this.vine(IcariaBlocks.DRY_VINE.get());
		this.vine(IcariaBlocks.REEDY_VINE.get());
		this.vine(IcariaBlocks.SWIRLY_VINE.get());
		this.vine(IcariaBlocks.THORNY_VINE.get());

		this.block(IcariaBlocks.FERN.get());
		this.block(IcariaBlocks.POTTED_FERN.get());

		this.block(IcariaBlocks.SMALL_GRASS.get());
		this.block(IcariaBlocks.MEDIUM_GRASS.get());
		this.block(IcariaBlocks.LARGE_GRASS.get());

		this.block(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		this.block(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		this.block(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		this.block(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		this.block(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		this.block(IcariaBlocks.LARGE_BROWN_GRAIN.get());

		this.block(IcariaBlocks.BLINDWEED.get());
		this.block(IcariaBlocks.POTTED_BLINDWEED.get());
		this.block(IcariaBlocks.CHAMEOMILE.get());
		this.block(IcariaBlocks.POTTED_CHAMEOMILE.get());
		this.block(IcariaBlocks.CHARMONDER.get());
		this.block(IcariaBlocks.POTTED_CHARMONDER.get());
		this.block(IcariaBlocks.CLOVER.get());
		this.block(IcariaBlocks.POTTED_CLOVER.get());
		this.block(IcariaBlocks.FIREHILT.get());
		this.block(IcariaBlocks.POTTED_FIREHILT.get());
		this.block(IcariaBlocks.BLUE_HYDRACINTH.get());
		this.block(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		this.block(IcariaBlocks.PURPLE_HYDRACINTH.get());
		this.block(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		this.block(IcariaBlocks.LIONFANGS.get());
		this.block(IcariaBlocks.POTTED_LIONFANGS.get());
		this.block(IcariaBlocks.SPEARDROPS.get());
		this.block(IcariaBlocks.POTTED_SPEARDROPS.get());
		this.block(IcariaBlocks.PURPLE_STAGHORN.get());
		this.block(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		this.block(IcariaBlocks.YELLOW_STAGHORN.get());
		this.block(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		this.block(IcariaBlocks.BLUE_STORMCOTTON.get());
		this.block(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		this.block(IcariaBlocks.PINK_STORMCOTTON.get());
		this.block(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		this.block(IcariaBlocks.PURPLE_STORMCOTTON.get());
		this.block(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		this.block(IcariaBlocks.SUNKETTLE.get());
		this.block(IcariaBlocks.POTTED_SUNKETTLE.get());
		this.block(IcariaBlocks.SUNSPONGE.get());
		this.block(IcariaBlocks.POTTED_SUNSPONGE.get());
		this.block(IcariaBlocks.VOIDLILY.get());
		this.block(IcariaBlocks.POTTED_VOIDLILY.get());

		this.yRot(IcariaBlocks.BOLBOS.get());
		this.yRot(IcariaBlocks.DATHULLA.get());
		this.yRot(IcariaBlocks.MONDANOS.get());
		this.yRot(IcariaBlocks.MOTH_AGARIC.get());
		this.yRot(IcariaBlocks.NAMDRAKE.get());
		this.yRot(IcariaBlocks.PSILOCYBOS.get());
		this.yRot(IcariaBlocks.ROWAN.get());
		this.yRot(IcariaBlocks.WILTED_ELM.get());

		this.rRot(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		this.rRot(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		this.rRot(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		this.rRot(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		this.rRot(IcariaBlocks.RED_GROUND_FLOWERS.get());
		this.rRot(IcariaBlocks.WHITE_GROUND_FLOWERS.get());

		this.layer(IcariaBlocks.FOREST_MOSS.get());
		this.layer(IcariaBlocks.SCRUBLAND_MOSS.get());
		this.layer(IcariaBlocks.STEPPE_MOSS.get());

		this.block(IcariaBlocks.PALM_FERN.get());
		this.block(IcariaBlocks.POTTED_PALM_FERN.get());

		this.block(IcariaBlocks.WHITE_BROMELIA.get());
		this.block(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		this.block(IcariaBlocks.ORANGE_BROMELIA.get());
		this.block(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		this.block(IcariaBlocks.PINK_BROMELIA.get());
		this.block(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		this.block(IcariaBlocks.PURPLE_BROMELIA.get());
		this.block(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());

		this.rRot(IcariaBlocks.GREEN_GROUND_SHROOMS.get());
		this.block(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get());
		this.rRot(IcariaBlocks.BROWN_GROUND_SHROOMS.get());
		this.block(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get());
		this.rRot(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get());
		this.block(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get());

		this.treeShrooms(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get());
		this.treeShrooms(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get());
		this.treeShrooms(IcariaBlocks.UNNAMED_TREE_SHROOMS.get());

		this.cardonCactus(IcariaBlocks.CARDON_CACTUS.get());
		this.block(IcariaBlocks.POTTED_CARDON_CACTUS.get());

		this.strawberryBush(IcariaBlocks.STRAWBERRY_BUSH.get());

		this.crop(IcariaBlocks.SPELT_CROP.get());
		this.crop(IcariaBlocks.STRAWBERRY_CROP.get());
		this.crop(IcariaBlocks.PHYSALIS_CROP.get());
		this.crop(IcariaBlocks.ONION_CROP.get());

		this.block(IcariaBlocks.MEDITERRANEAN_WATER.get());

		this.fire(IcariaBlocks.GREEK_FIRE.get());

		this.portal(IcariaBlocks.ICARIA_PORTAL.get());

		this.block(IcariaBlocks.GRINDER_SHAFT.get());
		this.block(IcariaBlocks.GRINDER_STONE.get());
	}

	public void grassyMarl(Block pBlock) {
		this.grassyMarl(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(IcariaBlocks.FOREST_MOSS.get(), "marl")),
			this.models().getExistingFile(this.file(IcariaBlocks.SCRUBLAND_MOSS.get(), "marl")),
			this.models().getExistingFile(this.file(IcariaBlocks.STEPPE_MOSS.get(), "marl"))
		);
	}

	public void aRot(Block pBlock) {
		this.aRot(pBlock,
			this.models().getExistingFile(this.file(pBlock))
		);
	}

	public void block(Block pBlock) {
		this.block(pBlock,
			this.models().getExistingFile(this.file(pBlock))
		);
	}

	public void yRot(Block pBlock) {
		this.yRot(pBlock,
			this.models().getExistingFile(this.file(pBlock))
		);
	}

	public void groundDeco(Block pBlock) {
		this.groundDeco(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "2")),
			this.models().getExistingFile(this.file(pBlock, "3")),
			this.models().getExistingFile(this.file(pBlock, "4"))
		);
	}

	public void farmland(Block pBlock) {
		this.farmland(pBlock,
			this.models().getExistingFile(this.file(pBlock, "dry")),
			this.models().getExistingFile(this.file(pBlock, "wet"))
		);
	}

	public void slab(SlabBlock pSlab, Block pBlock) {
		this.slabBlock(pSlab,
			this.models().getExistingFile(this.file(pSlab)),
			this.models().getExistingFile(this.file(pSlab, "top")),
			this.models().getExistingFile(this.file(pBlock))
		);
	}

	public void stairs(StairBlock pBlock) {
		this.stairsBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(pBlock, "inner")),
			this.models().getExistingFile(this.file(pBlock, "outer"))
		);
	}

	public void wall(WallBlock pBlock) {
		this.wallBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock, "post")),
			this.models().getExistingFile(this.file(pBlock, "side")),
			this.models().getExistingFile(this.file(pBlock, "side_tall"))
		);
	}

	public void axis(RotatedPillarBlock pBlock) {
		this.axisBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(pBlock, "horizontal"))
		);
	}

	public void pillarHead(Block pBlock) {
		this.pillarHead(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(pBlock, "inverted"))
		);
	}

	public void pane(IronBarsBlock pBlock) {
		this.paneBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock, "post")),
			this.models().getExistingFile(this.file(pBlock, "side")),
			this.models().getExistingFile(this.file(pBlock, "side_alt")),
			this.models().getExistingFile(this.file(pBlock, "noside")),
			this.models().getExistingFile(this.file(pBlock, "noside_alt"))
		);
	}

	public void directional(Block pBlock) {
		this.directional(pBlock,
			this.models().getExistingFile(this.file(pBlock))
		);
	}

	public void bars(IronBarsBlock pBlock) {
		this.bars(pBlock,
			this.models().getExistingFile(this.file(pBlock, "cap")),
			this.models().getExistingFile(this.file(pBlock, "cap_alt")),
			this.models().getExistingFile(this.file(pBlock, "post")),
			this.models().getExistingFile(this.file(pBlock, "post_ends")),
			this.models().getExistingFile(this.file(pBlock, "side")),
			this.models().getExistingFile(this.file(pBlock, "side_alt"))
		);
	}

	public void chain(RotatedPillarBlock pBlock) {
		this.axisBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(pBlock))
		);
	}

	public void kettle(Block pBlock) {
		this.kettle(pBlock,
			this.models().getExistingFile(this.file(pBlock, "lower")),
			this.models().getExistingFile(this.file(pBlock, "lower_lit")),
			this.models().getExistingFile(this.file(pBlock, "upper"))
		);
	}

	public void grinder(Block pBlock) {
		this.grinder(pBlock,
			this.models().getExistingFile(this.file(pBlock, "left")),
			this.models().getExistingFile(this.file(pBlock, "right"))
		);
	}

	public void kiln(Block pBlock) {
		this.kiln(pBlock,
			this.models().getExistingFile(this.file(pBlock, "upper")),
			this.models().getExistingFile(this.file(pBlock, "lower"))
		);
	}

	public void forge(Block pBlock) {
		this.forge(pBlock,
			this.models().getExistingFile(this.file(pBlock, "bottom_front_left")),
			this.models().getExistingFile(this.file(pBlock, "bottom_front_right")),
			this.models().getExistingFile(this.file(pBlock, "bottom_front_right_lit")),
			this.models().getExistingFile(this.file(pBlock, "bottom_back_left")),
			this.models().getExistingFile(this.file(pBlock, "bottom_back_right")),
			this.models().getExistingFile(this.file(pBlock, "top_front_left")),
			this.models().getExistingFile(this.file(pBlock, "top_front_right")),
			this.models().getExistingFile(this.file(pBlock, "top_back_left")),
			this.models().getExistingFile(this.file(pBlock, "top_back_right"))
		);
	}

	public void lootVase(Block pBlock) {
		this.lootVase(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "2")),
			this.models().getExistingFile(this.file(pBlock, "3")),
			this.models().getExistingFile(this.file(pBlock, "4")),
			this.models().getExistingFile(this.file(pBlock, "5")),
			this.models().getExistingFile(this.file(pBlock, "6")),
			this.models().getExistingFile(this.file(pBlock, "7")),
			this.models().getExistingFile(this.file(pBlock, "8")),
			this.models().getExistingFile(this.file(pBlock, "9"))
		);
	}

	public void skull(Block pBlock) {
		this.skull(pBlock,
			this.models().getExistingFile(this.file(IcariaIdents.MC, "skull"))
		);
	}

	public void horizontal(Block pBlock) {
		this.horizontal(pBlock,
			this.models().getExistingFile(this.file(pBlock))
		);
	}

	public void cake(Block pBlock) {
		this.cake(pBlock,
			this.models().getExistingFile(this.file("candle", pBlock)),
			this.models().getExistingFile(this.file("candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("white_candle", pBlock)),
			this.models().getExistingFile(this.file("white_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("light_gray_candle", pBlock)),
			this.models().getExistingFile(this.file("light_gray_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("gray_candle", pBlock)),
			this.models().getExistingFile(this.file("gray_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("black_candle", pBlock)),
			this.models().getExistingFile(this.file("black_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("brown_candle", pBlock)),
			this.models().getExistingFile(this.file("brown_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("red_candle", pBlock)),
			this.models().getExistingFile(this.file("red_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("orange_candle", pBlock)),
			this.models().getExistingFile(this.file("orange_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("yellow_candle", pBlock)),
			this.models().getExistingFile(this.file("yellow_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("lime_candle", pBlock)),
			this.models().getExistingFile(this.file("lime_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("green_candle", pBlock)),
			this.models().getExistingFile(this.file("green_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("cyan_candle", pBlock)),
			this.models().getExistingFile(this.file("cyan_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("light_blue_candle", pBlock)),
			this.models().getExistingFile(this.file("light_blue_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("blue_candle", pBlock)),
			this.models().getExistingFile(this.file("blue_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("purple_candle", pBlock)),
			this.models().getExistingFile(this.file("purple_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("magenta_candle", pBlock)),
			this.models().getExistingFile(this.file("magenta_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file("pink_candle", pBlock)),
			this.models().getExistingFile(this.file("pink_candle", pBlock, "lit")),
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "2")),
			this.models().getExistingFile(this.file(pBlock, "3"))
		);
	}

	public void layer(Block pBlock) {
		this.layer(pBlock,
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "2")),
			this.models().getExistingFile(this.file(pBlock, "3")),
			this.models().getExistingFile(this.file(pBlock, "4")),
			this.models().getExistingFile(this.file(pBlock, "5")),
			this.models().getExistingFile(this.file(pBlock, "6")),
			this.models().getExistingFile(this.file(pBlock, "7")),
			this.models().getExistingFile(this.file(pBlock, "8"))
		);
	}

	public void deadLog(Block pBlock) {
		this.deadLog(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "horizontal_0")),
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "horizontal_1")),
			this.models().getExistingFile(this.file(pBlock, "2")),
			this.models().getExistingFile(this.file(pBlock, "horizontal_2"))
		);
	}

	public void deadDroughtrootLog(Block pBlock) {
		this.deadLog(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "horizontal_0"))
		);
	}

	public void fence(CrossCollisionBlock pBlock) {
		this.fourWayBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock, "post")),
			this.models().getExistingFile(this.file(pBlock, "side"))
		);
	}

	public void gate(FenceGateBlock pBlock) {
		this.fenceGateBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(pBlock, "open")),
			this.models().getExistingFile(this.file(pBlock, "wall")),
			this.models().getExistingFile(this.file(pBlock, "wall_open"))
		);
	}

	public void simpleRack(Block pBlock) {
		this.rack(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(pBlock, "rack", "barrel_rack")),
			this.models().getExistingFile(this.file(pBlock, "simple", "simple_loaded", "rack", "barrel_rack")),
			this.models().getExistingFile(this.file(pBlock, "simple", "simple_tapped", "rack", "barrel_rack"))
		);
	}

	public void rack(Block pBlock) {
		this.rack(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file(pBlock, "rack", "barrel_rack")),
			this.models().getExistingFile(this.file("loaded", pBlock, "rack", "barrel_rack")),
			this.models().getExistingFile(this.file("tapped", pBlock, "rack", "barrel_rack"))
		);
	}

	public void barrel(Block pBlock) {
		this.barrel(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file("standing", pBlock))
		);
	}

	public void tripleBarrelRack(Block pBlock, Block pBarrel) {
		this.tripleBarrelRack(pBlock,
			this.models().getExistingFile(this.file(pBarrel, "rack")),
			this.models().getExistingFile(this.file(pBlock, "top_left")),
			this.models().getExistingFile(this.file(pBlock, "top_right"))
		);
	}

	public void door(DoorBlock pBlock) {
		this.doorBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock, "bottom_left")),
			this.models().getExistingFile(this.file(pBlock, "bottom_left_open")),
			this.models().getExistingFile(this.file(pBlock, "bottom_right")),
			this.models().getExistingFile(this.file(pBlock, "bottom_right_open")),
			this.models().getExistingFile(this.file(pBlock, "top_left")),
			this.models().getExistingFile(this.file(pBlock, "top_left_open")),
			this.models().getExistingFile(this.file(pBlock, "top_right")),
			this.models().getExistingFile(this.file(pBlock, "top_right_open"))
		);
	}

	public void trapdoor(TrapDoorBlock pBlock) {
		this.trapdoorBlock(pBlock,
			this.models().getExistingFile(this.file(pBlock, "bottom")),
			this.models().getExistingFile(this.file(pBlock, "top")),
			this.models().getExistingFile(this.file(pBlock, "open")),
			true
		);
	}

	public void oliveLeaves(Block pBlock) {
		this.oliveLeaves(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file("black", pBlock)),
			this.models().getExistingFile(this.file("green", pBlock))
		);
	}

	public void bloomyVine(Block pBlock) {
		this.bloomyVine(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file("blooming", pBlock)),
			this.models().getExistingFile(this.file("dead", pBlock)),
			this.models().getExistingFile(this.file("growing", pBlock)),
			this.models().getExistingFile(this.file("ripe", pBlock))
		);
	}

	public void brushyVine(Block pBlock) {
		this.brushyVine(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file("dead", pBlock)),
			this.models().getExistingFile(this.file("growing", pBlock)),
			this.models().getExistingFile(this.file("ripe", pBlock))
		);
	}

	public void vine(Block pBlock) {
		this.vine(pBlock,
			this.models().getExistingFile(this.file(pBlock)),
			this.models().getExistingFile(this.file("dead", pBlock)),
			this.models().getExistingFile(this.file("growing", pBlock))
		);
	}

	public void rRot(Block pBlock) {
		this.rRot(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "2"))
		);
	}

	public void treeShrooms(Block pBlock) {
		this.treeShrooms(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "2"))
		);
	}

	public void cardonCactus(Block pBlock) {
		this.cardonCactus(pBlock,
			this.models().getExistingFile(this.file(pBlock, "cube")),
			this.models().getExistingFile(this.file(pBlock, "stem"))
		);
	}

	public void strawberryBush(Block pBlock) {
		this.strawberryBush(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "1"))
		);
	}

	public void crop(Block pBlock) {
		this.crop(pBlock,
			this.models().getExistingFile(this.file(pBlock, "0")),
			this.models().getExistingFile(this.file(pBlock, "1")),
			this.models().getExistingFile(this.file(pBlock, "2")),
			this.models().getExistingFile(this.file(pBlock, "3")),
			this.models().getExistingFile(this.file(pBlock, "4")),
			this.models().getExistingFile(this.file(pBlock, "5")),
			this.models().getExistingFile(this.file(pBlock, "6")),
			this.models().getExistingFile(this.file(pBlock, "7"))
		);
	}

	public void fire(Block pBlock) {
		this.fire(pBlock,
			this.models().getExistingFile(this.file(pBlock, "floor_0")),
			this.models().getExistingFile(this.file(pBlock, "floor_1")),
			this.models().getExistingFile(this.file(pBlock, "side_0")),
			this.models().getExistingFile(this.file(pBlock, "side_1")),
			this.models().getExistingFile(this.file(pBlock, "side_alt_0")),
			this.models().getExistingFile(this.file(pBlock, "side_alt_1"))
		);
	}

	public void portal(Block pBlock) {
		this.portal(pBlock,
			this.models().getExistingFile(this.file(pBlock, "x")),
			this.models().getExistingFile(this.file(pBlock, "z"))
		);
	}

	public void grassyMarl(Block pBlock, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2, ModelFile pModel3) {
		this.getVariantBuilder(pBlock)
			.partialState().with(IcariaBlockStateProperties.MOSS, Moss.NONE).addModels(ConfiguredModel.allYRotations(pModel0, 0, false))
			.partialState().with(IcariaBlockStateProperties.MOSS, Moss.FOREST).addModels(ConfiguredModel.allYRotations(pModel1, 0, false))
			.partialState().with(IcariaBlockStateProperties.MOSS, Moss.SCRUBLAND).addModels(ConfiguredModel.allYRotations(pModel2, 0, false))
			.partialState().with(IcariaBlockStateProperties.MOSS, Moss.STEPPE).addModels(ConfiguredModel.allYRotations(pModel3, 0, false));
	}

	public void aRot(Block pBlock, ModelFile pModel) {
		this.getVariantBuilder(pBlock)
			.partialState().addModels(ConfiguredModel.allRotations(pModel, false));
	}

	public void block(Block pBlock, ModelFile pModel) {
		this.getVariantBuilder(pBlock)
			.partialState().addModels(new ConfiguredModel(pModel));
	}

	public void yRot(Block pBlock, ModelFile pModel) {
		this.getVariantBuilder(pBlock)
			.partialState().addModels(ConfiguredModel.allYRotations(pModel, 0, false));
	}

	public void groundDeco(Block pBlock, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2, ModelFile pModel3, ModelFile pModel4) {
		this.getVariantBuilder(pBlock)
			.partialState().addModels(ConfiguredModel.allYRotations(pModel0, 0, false))
			.partialState().addModels(ConfiguredModel.allYRotations(pModel1, 0, false))
			.partialState().addModels(ConfiguredModel.allYRotations(pModel2, 0, false))
			.partialState().addModels(ConfiguredModel.allYRotations(pModel3, 0, false))
			.partialState().addModels(ConfiguredModel.allYRotations(pModel4, 0, false));
	}

	public void farmland(Block pBlock, ModelFile pDry, ModelFile pWet) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.MOISTURE, 0).addModels(new ConfiguredModel(pDry))
			.partialState().with(BlockStateProperties.MOISTURE, 1).addModels(new ConfiguredModel(pDry))
			.partialState().with(BlockStateProperties.MOISTURE, 2).addModels(new ConfiguredModel(pDry))
			.partialState().with(BlockStateProperties.MOISTURE, 3).addModels(new ConfiguredModel(pDry))
			.partialState().with(BlockStateProperties.MOISTURE, 4).addModels(new ConfiguredModel(pDry))
			.partialState().with(BlockStateProperties.MOISTURE, 5).addModels(new ConfiguredModel(pDry))
			.partialState().with(BlockStateProperties.MOISTURE, 6).addModels(new ConfiguredModel(pDry))
			.partialState().with(BlockStateProperties.MOISTURE, 7).addModels(new ConfiguredModel(pWet));
	}

	public void pillarHead(Block pBlock, ModelFile pModel, ModelFile pModelInverted) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.FACING, Direction.NORTH).addModels(new ConfiguredModel(pModelInverted, 270, 0, false))
			.partialState().with(BlockStateProperties.FACING, Direction.EAST).addModels(new ConfiguredModel(pModelInverted, 90, 270, false))
			.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).addModels(new ConfiguredModel(pModel, 270, 180, false))
			.partialState().with(BlockStateProperties.FACING, Direction.WEST).addModels(new ConfiguredModel(pModel, 90, 90, false))
			.partialState().with(BlockStateProperties.FACING, Direction.UP).addModels(new ConfiguredModel(pModelInverted, 180, 0, false))
			.partialState().with(BlockStateProperties.FACING, Direction.DOWN).addModels(new ConfiguredModel(pModel, 0, 0, false));
	}

	public void directional(Block pBlock, ModelFile pModel) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(pModel)
			.rotationX(state.getValue(BlockStateProperties.FACING).getAxis().isHorizontal() ? 90 : state.getValue(BlockStateProperties.FACING) == Direction.DOWN ? 180 : 0)
			.rotationY(state.getValue(BlockStateProperties.FACING).getAxis().isVertical() ? 0 : ((state.getValue(BlockStateProperties.FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void bars(IronBarsBlock pBlock, ModelFile pCap, ModelFile pCapAlt, ModelFile pPost, ModelFile pPostEnds, ModelFile pSide, ModelFile pSideAlt) {
		this.getMultipartBuilder(pBlock).part().modelFile(pCap).addModel().condition(BlockStateProperties.NORTH, true).condition(BlockStateProperties.EAST, false).condition(BlockStateProperties.SOUTH, false).condition(BlockStateProperties.WEST, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCap).rotationY(90).addModel().condition(BlockStateProperties.NORTH, false).condition(BlockStateProperties.EAST, true).condition(BlockStateProperties.SOUTH, false).condition(BlockStateProperties.WEST, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCapAlt).addModel().condition(BlockStateProperties.NORTH, false).condition(BlockStateProperties.EAST, false).condition(BlockStateProperties.SOUTH, true).condition(BlockStateProperties.WEST, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCapAlt).rotationY(90).addModel().condition(BlockStateProperties.NORTH, false).condition(BlockStateProperties.EAST, false).condition(BlockStateProperties.SOUTH, false).condition(BlockStateProperties.WEST, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pPost).addModel().condition(BlockStateProperties.NORTH, false).condition(BlockStateProperties.EAST, false).condition(BlockStateProperties.SOUTH, false).condition(BlockStateProperties.WEST, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pPostEnds).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide).addModel().condition(BlockStateProperties.NORTH, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide).rotationY(90).addModel().condition(BlockStateProperties.EAST, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt).addModel().condition(BlockStateProperties.SOUTH, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt).rotationY(90).addModel().condition(BlockStateProperties.WEST, true).end();
	}

	public void kettle(Block pBlock, ModelFile pLower, ModelFile pLowerLit, ModelFile pUpper) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? state.getValue(BlockStateProperties.LIT) ? pLowerLit : pLower : pUpper)
			.rotationY(((state.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), IcariaBlockStateProperties.KETTLE);
	}

	public void grinder(Block pBlock, ModelFile pLeft, ModelFile pRight) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(state.getValue(IcariaBlockStateProperties.SIDE) == Side.LEFT ? pLeft : pRight)
			.rotationY(((state.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), IcariaBlockStateProperties.GRINDER_GRINDING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void kiln(Block pBlock, ModelFile pUpper, ModelFile pLower) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER ? pUpper : pLower)
			.rotationY(((state.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), BlockStateProperties.LIT, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void forge(Block pBlock, ModelFile pBottomFrontLeft, ModelFile pBottomFrontRight, ModelFile pBottomFrontRightLit, ModelFile pBottomBackLeft, ModelFile pBottomBackRight, ModelFile pTopFrontLeft, ModelFile pTopFrontRight, ModelFile pTopBackLeft, ModelFile pTopBackRight) {
		this.getVariantBuilder(pBlock).forAllStatesExcept(
			state -> {
				var corner = state.getValue(IcariaBlockStateProperties.CORNER);
				var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
				var lit = state.getValue(BlockStateProperties.LIT);

				var modelFile = lit ? pBottomFrontRightLit : pBottomFrontRight;

				if (corner == Corner.BOTTOM_FRONT_LEFT) {
					modelFile = pBottomFrontLeft;
				} else if (corner == Corner.BOTTOM_BACK_LEFT) {
					modelFile = pBottomBackLeft;
				} else if (corner == Corner.BOTTOM_BACK_RIGHT) {
					modelFile = pBottomBackRight;
				} else if (corner == Corner.TOP_FRONT_LEFT) {
					modelFile = pTopFrontLeft;
				} else if (corner == Corner.TOP_FRONT_RIGHT) {
					modelFile = pTopFrontRight;
				} else if (corner == Corner.TOP_BACK_LEFT) {
					modelFile = pTopBackLeft;
				} else if (corner == Corner.TOP_BACK_RIGHT) {
					modelFile = pTopBackRight;
				}

				return ConfiguredModel.builder().modelFile(modelFile).rotationY(((facing.get2DDataValue() * 90) + 180) % 360).build();
			}
		);
	}

	public void lootVase(Block pBlock, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2, ModelFile pModel3, ModelFile pModel4, ModelFile pModel5, ModelFile pModel6, ModelFile pModel7, ModelFile pModel8, ModelFile pModel9) {
		this.getVariantBuilder(pBlock).partialState().addModels(
			new ConfiguredModel(pModel0),
			new ConfiguredModel(pModel1),
			new ConfiguredModel(pModel2),
			new ConfiguredModel(pModel3),
			new ConfiguredModel(pModel4),
			new ConfiguredModel(pModel5),
			new ConfiguredModel(pModel6),
			new ConfiguredModel(pModel7),
			new ConfiguredModel(pModel8),
			new ConfiguredModel(pModel9)
		);
	}

	public void skull(Block pBlock, ModelFile pModel) {
		this.getVariantBuilder(pBlock).partialState().addModels(new ConfiguredModel(pModel));
	}

	public void horizontal(Block pBlock, ModelFile pModel) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(pModel)
			.rotationY(((state.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.TROUGH, IcariaBlockStateProperties.TROUGH_FILL, BlockStateProperties.WATERLOGGED);
	}

	public void cake(Block pBlock, ModelFile pCandle, ModelFile pCandleLit, ModelFile pWhiteCandle, ModelFile pWhiteCandleLit, ModelFile pLightGrayCandle, ModelFile pLightGrayCandleLit, ModelFile pGrayCandle, ModelFile pGrayCandleLit, ModelFile pBlackCandle, ModelFile pBlackCandleLit, ModelFile pBrownCandle, ModelFile pBrownCandleLit, ModelFile pRedCandle, ModelFile pRedCandleLit, ModelFile pOrangeCandle, ModelFile pOrangeCandleLit, ModelFile pYellowCandle, ModelFile pYellowCandleLit, ModelFile pLimeCandle, ModelFile pLimeCandleLit, ModelFile pGreenCandle, ModelFile pGreenCandleLit, ModelFile pCyanCandle, ModelFile pCyanCandleLit, ModelFile pLightBlueCandle, ModelFile pLightBlueCandleLit, ModelFile pBlueCandle, ModelFile pBlueCandleLit, ModelFile pPurpleCandle, ModelFile pPurpleCandleLit, ModelFile pMagentaCandle, ModelFile pMagentaCandleLit, ModelFile pPinkCandle, ModelFile pPinkCandleLit, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2, ModelFile pModel3) {
		this.getVariantBuilder(pBlock).forAllStatesExcept(
			state -> {
				var cakeBite = state.getValue(IcariaBlockStateProperties.CAKE_BITE);
				var candle = state.getValue(IcariaBlockStateProperties.CANDLE);
				var lit = state.getValue(BlockStateProperties.LIT);

				var modelFile = cakeBite == 0 ? pModel0 : cakeBite == 1 ? pModel1 : cakeBite == 2 ? pModel2 : pModel3;

				if (candle == Candle.CANDLE) {
					modelFile =  lit ? pCandleLit : pCandle;
				} else if (candle == Candle.WHITE_CANDLE) {
					modelFile =  lit ? pWhiteCandleLit : pWhiteCandle;
				} else if (candle == Candle.LIGHT_GRAY_CANDLE) {
					modelFile =  lit ? pLightGrayCandleLit : pLightGrayCandle;
				} else if (candle == Candle.GRAY_CANDLE) {
					modelFile =  lit ? pGrayCandleLit : pGrayCandle;
				} else if (candle == Candle.BLACK_CANDLE) {
					modelFile =  lit ? pBlackCandleLit : pBlackCandle;
				} else if (candle == Candle.BROWN_CANDLE) {
					modelFile =  lit ? pBrownCandleLit : pBrownCandle;
				} else if (candle == Candle.RED_CANDLE) {
					modelFile =  lit ? pRedCandleLit : pRedCandle;
				} else if (candle == Candle.ORANGE_CANDLE) {
					modelFile =  lit ? pOrangeCandleLit : pOrangeCandle;
				} else if (candle == Candle.YELLOW_CANDLE) {
					modelFile =  lit ? pYellowCandleLit : pYellowCandle;
				} else if (candle == Candle.LIME_CANDLE) {
					modelFile =  lit ? pLimeCandleLit : pLimeCandle;
				} else if (candle == Candle.GREEN_CANDLE) {
					modelFile =  lit ? pGreenCandleLit : pGreenCandle;
				} else if (candle == Candle.CYAN_CANDLE) {
					modelFile =  lit ? pCyanCandleLit : pCyanCandle;
				} else if (candle == Candle.LIGHT_BLUE_CANDLE) {
					modelFile =  lit ? pLightBlueCandleLit : pLightBlueCandle;
				} else if (candle == Candle.BLUE_CANDLE) {
					modelFile =  lit ? pBlueCandleLit : pBlueCandle;
				} else if (candle == Candle.PURPLE_CANDLE) {
					modelFile =  lit ? pPurpleCandleLit : pPurpleCandle;
				} else if (candle == Candle.MAGENTA_CANDLE) {
					modelFile =  lit ? pMagentaCandleLit : pMagentaCandle;
				} else if (candle == Candle.PINK_CANDLE) {
					modelFile =  lit ? pPinkCandleLit : pPinkCandle;
				}

				return ConfiguredModel.builder().modelFile(modelFile).build();
			}
		);
	}

	public void layer(Block pBlock, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2, ModelFile pModel3, ModelFile pModel4, ModelFile pModel5, ModelFile pModel6, ModelFile pModel7) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.LAYERS, 1).addModels(ConfiguredModel.allYRotations(pModel0, 0, false))
			.partialState().with(BlockStateProperties.LAYERS, 2).addModels(ConfiguredModel.allYRotations(pModel1, 0, false))
			.partialState().with(BlockStateProperties.LAYERS, 3).addModels(ConfiguredModel.allYRotations(pModel2, 0, false))
			.partialState().with(BlockStateProperties.LAYERS, 4).addModels(ConfiguredModel.allYRotations(pModel3, 0, false))
			.partialState().with(BlockStateProperties.LAYERS, 5).addModels(ConfiguredModel.allYRotations(pModel4, 0, false))
			.partialState().with(BlockStateProperties.LAYERS, 6).addModels(ConfiguredModel.allYRotations(pModel5, 0, false))
			.partialState().with(BlockStateProperties.LAYERS, 7).addModels(ConfiguredModel.allYRotations(pModel6, 0, false))
			.partialState().with(BlockStateProperties.LAYERS, 8).addModels(ConfiguredModel.allYRotations(pModel7, 0, false));
	}

	public void deadLog(Block pBlock, ModelFile pLog0, ModelFile pLogHorizontal0, ModelFile pLog1, ModelFile pLogHorizontal1, ModelFile pLog2, ModelFile pLogHorizontal2) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).addModels(
				new ConfiguredModel(pLogHorizontal0, 0, 90, false),
				new ConfiguredModel(pLogHorizontal1, 0, 90, false),
				new ConfiguredModel(pLogHorizontal2, 0, 90, false)
			).partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).addModels(
				new ConfiguredModel(pLog0, 0, 0, false),
				new ConfiguredModel(pLog1, 0, 0, false),
				new ConfiguredModel(pLog2, 0, 0, false)
			).partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).addModels(
				new ConfiguredModel(pLogHorizontal0, 0, 0, false),
				new ConfiguredModel(pLogHorizontal1, 0, 0, false),
				new ConfiguredModel(pLogHorizontal2, 0, 0, false)
			);
	}

	public void deadLog(Block pBlock, ModelFile pLog, ModelFile pHorizontalLog) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).addModels(new ConfiguredModel(pHorizontalLog, 0, 90, false))
			.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).addModels(new ConfiguredModel(pLog, 0, 0, false))
			.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).addModels(new ConfiguredModel(pHorizontalLog, 0, 0, false));
	}

	public void rack(Block pBlock, ModelFile pRack, ModelFile pBarrelRack, ModelFile pLoadedBarrelRack, ModelFile pTappedBarrelRack) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(state.getValue(IcariaBlockStateProperties.FULL_RACK) ? state.getValue(IcariaBlockStateProperties.LOADED_BARREL) ? pLoadedBarrelRack : state.getValue(IcariaBlockStateProperties.TAPPED_BARREL) ? pTappedBarrelRack : pBarrelRack : pRack)
			.rotationY(((state.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED
		);
	}

	public void barrel(Block pBlock, ModelFile pBarrel, ModelFile pStandingBarrel) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(state.getValue(IcariaBlockStateProperties.BARREL_FACING) == Direction.UP ? pStandingBarrel : pBarrel)
			.rotationY(((state.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED
		);
	}

	public void tripleBarrelRack(Block pBlock, ModelFile pBarrelRack, ModelFile pTopLeft, ModelFile pTopRight) {
		this.getVariantBuilder(pBlock)
			.forAllStatesExcept(state -> ConfiguredModel.builder()
			.modelFile(state.getValue(IcariaBlockStateProperties.VERTICAL_CORNER) == VerticalCorner.BOTTOM_LEFT || state.getValue(IcariaBlockStateProperties.VERTICAL_CORNER) == VerticalCorner.BOTTOM_RIGHT ? pBarrelRack : state.getValue(IcariaBlockStateProperties.VERTICAL_CORNER) == VerticalCorner.TOP_LEFT ? pTopLeft : pTopRight)
			.rotationY(((state.getValue(BlockStateProperties.HORIZONTAL_FACING).get2DDataValue() * 90) + 180) % 360)
			.build(), IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void oliveLeaves(Block pBlock, ModelFile pModel, ModelFile pBlack, ModelFile pGreen) {
		this.getVariantBuilder(pBlock)
			.partialState().with(IcariaBlockStateProperties.OLIVES, Olives.NONE).addModels(new ConfiguredModel(pModel))
			.partialState().with(IcariaBlockStateProperties.OLIVES, Olives.BLACK).addModels(new ConfiguredModel(pBlack))
			.partialState().with(IcariaBlockStateProperties.OLIVES, Olives.GREEN).addModels(new ConfiguredModel(pGreen))
			.partialState().with(IcariaBlockStateProperties.OLIVES, Olives.LEAVES).addModels(new ConfiguredModel(pModel));
	}

	public void bloomyVine(Block pBlock, ModelFile pVine, ModelFile pBlooming, ModelFile pDead, ModelFile pGrowing, ModelFile pRipe) {
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pBlooming).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.BLOOMING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pBlooming).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.BLOOMING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pBlooming).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.BLOOMING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pBlooming).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.BLOOMING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
	}

	public void brushyVine(Block pBlock, ModelFile pVine, ModelFile pDead, ModelFile pGrowing, ModelFile pRipe) {
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pRipe).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.RIPE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
	}

	public void vine(Block pBlock, ModelFile pVine, ModelFile pDead, ModelFile pGrowing) {
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.NONE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pDead).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.DEAD).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pGrowing).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.GROWING).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pVine).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).condition(IcariaBlockStateProperties.VINE, Vine.VINE).end();
	}

	public void rRot(Block pBlock, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2) {
		this.getVariantBuilder(pBlock)
			.partialState().addModels(ConfiguredModel.allYRotations(pModel0, 0, false))
			.partialState().addModels(ConfiguredModel.allYRotations(pModel1, 0, false))
			.partialState().addModels(ConfiguredModel.allYRotations(pModel2, 0, false));
	}

	public void treeShrooms(Block pBlock, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).addModels(
				new ConfiguredModel(pModel0, 0, 0, false),
				new ConfiguredModel(pModel1, 0, 0, false),
				new ConfiguredModel(pModel2, 0, 0, false)
			).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).addModels(
				new ConfiguredModel(pModel0, 0, 90, false),
				new ConfiguredModel(pModel1, 0, 90, false),
				new ConfiguredModel(pModel2, 0, 90, false)
			).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).addModels(
				new ConfiguredModel(pModel0, 0, 180, false),
				new ConfiguredModel(pModel1, 0, 180, false),
				new ConfiguredModel(pModel2, 0, 180, false)
			).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).addModels(
				new ConfiguredModel(pModel0, 0, 270, false),
				new ConfiguredModel(pModel1, 0, 270, false),
				new ConfiguredModel(pModel2, 0, 270, false)
			);
	}

	public void cardonCactus(Block pBlock, ModelFile pCube, ModelFile pStem) {
		this.getMultipartBuilder(pBlock).part().modelFile(pCube).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCube).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCube).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCube).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCube).rotationX(270).uvLock(true).addModel().condition(BlockStateProperties.UP, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pCube).rotationX(90).uvLock(true).addModel().condition(BlockStateProperties.DOWN, false).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pStem).rotationY(0).uvLock(true).addModel().condition(BlockStateProperties.NORTH, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pStem).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pStem).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pStem).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pStem).rotationX(270).uvLock(true).addModel().condition(BlockStateProperties.UP, true).end();
		this.getMultipartBuilder(pBlock).part().modelFile(pStem).rotationX(90).uvLock(true).addModel().condition(BlockStateProperties.DOWN, true).end();
	}

	public void strawberryBush(Block pBlock, ModelFile pModel0, ModelFile pModel1) {
		this.getVariantBuilder(pBlock)
			.partialState().with(IcariaBlockStateProperties.RIPE, Ripe.NONE).addModels(new ConfiguredModel(pModel0))
			.partialState().with(IcariaBlockStateProperties.RIPE, Ripe.RIPE).addModels(new ConfiguredModel(pModel1));
	}

	public void crop(Block pBlock, ModelFile pModel0, ModelFile pModel1, ModelFile pModel2, ModelFile pModel3, ModelFile pModel4, ModelFile pModel5, ModelFile pModel6, ModelFile pModel7) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.AGE_7, 0).addModels(new ConfiguredModel(pModel0))
			.partialState().with(BlockStateProperties.AGE_7, 1).addModels(new ConfiguredModel(pModel1))
			.partialState().with(BlockStateProperties.AGE_7, 2).addModels(new ConfiguredModel(pModel2))
			.partialState().with(BlockStateProperties.AGE_7, 3).addModels(new ConfiguredModel(pModel3))
			.partialState().with(BlockStateProperties.AGE_7, 4).addModels(new ConfiguredModel(pModel4))
			.partialState().with(BlockStateProperties.AGE_7, 5).addModels(new ConfiguredModel(pModel5))
			.partialState().with(BlockStateProperties.AGE_7, 6).addModels(new ConfiguredModel(pModel6))
			.partialState().with(BlockStateProperties.AGE_7, 7).addModels(new ConfiguredModel(pModel7));
	}

	public void fire(Block pBlock, ModelFile pFloor0, ModelFile pFloor1, ModelFile pSide0, ModelFile pSide1, ModelFile pSideAlt0, ModelFile pSideAlt1) {
		this.getMultipartBuilder(pBlock).part().modelFile(pFloor0).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pFloor1).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide0).rotationY(0).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide1).rotationY(0).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt0).rotationY(0).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt1).rotationY(0).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide0).rotationY(90).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide1).rotationY(90).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt0).rotationY(90).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt1).rotationY(90).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide0).rotationY(180).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide1).rotationY(180).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt0).rotationY(180).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt1).rotationY(180).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide0).rotationY(270).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSide1).rotationY(270).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt0).rotationY(270).addModel().end();
		this.getMultipartBuilder(pBlock).part().modelFile(pSideAlt1).rotationY(270).addModel().end();
	}

	public void portal(Block pBlock, ModelFile pModelX, ModelFile pModelZ) {
		this.getVariantBuilder(pBlock)
			.partialState().with(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X).addModels(new ConfiguredModel(pModelX))
			.partialState().with(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.Z).addModels(new ConfiguredModel(pModelZ));
	}

	public ResourceLocation file(String pId, String pFile) {
		return ResourceLocation.fromNamespaceAndPath(pId, ModelProvider.BLOCK_FOLDER + "/" + pFile);
	}

	public ResourceLocation file(Block pBlock) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + this.name(pBlock));
	}

	public ResourceLocation file(Block pBlock, String pSuffix) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + this.name(pBlock) + "_" + pSuffix);
	}

	public ResourceLocation file(String pPrefix, Block pBlock) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pBlock));
	}

	public ResourceLocation file(String pPrefix, Block pBlock, String pSuffix) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pBlock) + "_" + pSuffix);
	}

	public ResourceLocation file(String pId, String pFile, String pSource, String pTarget) {
		return ResourceLocation.fromNamespaceAndPath(pId, ModelProvider.BLOCK_FOLDER + "/" + pFile.replace(pSource, pTarget));
	}

	public ResourceLocation file(Block pBlock, String pSource, String pTarget) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + this.name(pBlock).replace(pSource, pTarget));
	}

	public ResourceLocation file(Block pBlock, String pSource, String pTarget, String pSuffix) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + this.name(pBlock).replace(pSource, pTarget) + "_" + pSuffix);
	}

	public ResourceLocation file(String pPrefix, Block pBlock, String pSource, String pTarget) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pBlock).replace(pSource, pTarget));
	}

	public ResourceLocation file(String pPrefix, Block pBlock, String pSuffix, String pSource, String pTarget) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pBlock).replace(pSource, pTarget) + "_" + pSuffix);
	}

	public ResourceLocation file(String pId, String pFile, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return ResourceLocation.fromNamespaceAndPath(pId, ModelProvider.BLOCK_FOLDER + "/" + pFile.replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public ResourceLocation file(Block pBlock, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + this.name(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public ResourceLocation file(Block pBlock, String pSuffix, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + this.name(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB) + "_" + pSuffix);
	}

	public ResourceLocation file(String pPrefix, Block pBlock, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public ResourceLocation file(String pPrefix, Block pBlock, String pSuffix, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pBlock), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB) + "_" + pSuffix);
	}

	public String id(Block pBlock) {
		return BuiltInRegistries.BLOCK.getKey(pBlock).getNamespace();
	}

	public String name(Block pBlock) {
		return BuiltInRegistries.BLOCK.getKey(pBlock).getPath();
	}
}
