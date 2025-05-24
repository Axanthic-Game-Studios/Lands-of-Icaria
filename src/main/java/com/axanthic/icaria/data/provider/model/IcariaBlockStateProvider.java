package com.axanthic.icaria.data.provider.model;

import com.axanthic.icaria.common.properties.*;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.*;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockStateProvider {

	public static void register(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.axis(pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(pBlockModelGenerators);
		IcariaBlockStateProvider.bars(pBlockModelGenerators);
		IcariaBlockStateProvider.block(pBlockModelGenerators);
		IcariaBlockStateProvider.bloomyVine(pBlockModelGenerators);
		IcariaBlockStateProvider.brushyVine(pBlockModelGenerators);
		IcariaBlockStateProvider.button(pBlockModelGenerators);
		IcariaBlockStateProvider.cake(pBlockModelGenerators);
		IcariaBlockStateProvider.cardonCactus(pBlockModelGenerators);
		IcariaBlockStateProvider.chain(pBlockModelGenerators);
		IcariaBlockStateProvider.crop(pBlockModelGenerators);
		IcariaBlockStateProvider.deadDroughtrootLog(pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(pBlockModelGenerators);
		IcariaBlockStateProvider.directional(pBlockModelGenerators);
		IcariaBlockStateProvider.door(pBlockModelGenerators);
		IcariaBlockStateProvider.farmland(pBlockModelGenerators);
		IcariaBlockStateProvider.fence(pBlockModelGenerators);
		IcariaBlockStateProvider.fenceGate(pBlockModelGenerators);
		IcariaBlockStateProvider.fire(pBlockModelGenerators);
		IcariaBlockStateProvider.forge(pBlockModelGenerators);
		IcariaBlockStateProvider.grassyMarl(pBlockModelGenerators);
		IcariaBlockStateProvider.grinder(pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(pBlockModelGenerators);
		IcariaBlockStateProvider.kettle(pBlockModelGenerators);
		IcariaBlockStateProvider.kiln(pBlockModelGenerators);
		IcariaBlockStateProvider.layer(pBlockModelGenerators);
		IcariaBlockStateProvider.lootVase(pBlockModelGenerators);
		IcariaBlockStateProvider.oliveLeaves(pBlockModelGenerators);
		IcariaBlockStateProvider.pane(pBlockModelGenerators);
		IcariaBlockStateProvider.pillarHead(pBlockModelGenerators);
		IcariaBlockStateProvider.portal(pBlockModelGenerators);
		IcariaBlockStateProvider.pressurePlate(pBlockModelGenerators);
		IcariaBlockStateProvider.rack(pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(pBlockModelGenerators);
		IcariaBlockStateProvider.randomRotation(pBlockModelGenerators);
		IcariaBlockStateProvider.simpleRack(pBlockModelGenerators);
		IcariaBlockStateProvider.skull(pBlockModelGenerators);
		IcariaBlockStateProvider.slab(pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(pBlockModelGenerators);
		IcariaBlockStateProvider.strawberryBush(pBlockModelGenerators);
		IcariaBlockStateProvider.trapdoor(pBlockModelGenerators);
		IcariaBlockStateProvider.treeShrooms(pBlockModelGenerators);
		IcariaBlockStateProvider.tripleBarrelRack(pBlockModelGenerators);
		IcariaBlockStateProvider.vine(pBlockModelGenerators);
		IcariaBlockStateProvider.wall(pBlockModelGenerators);
	}

	public static void axis(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.axis(IcariaBlocks.DOLOMITE_PILLAR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.RELICSTONE_PILLAR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.SPELT_BALE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.CYPRESS_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.DROUGHTROOT_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.FIR_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_FIR_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.LAUREL_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.OLIVE_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.PLANE_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.POPULUS_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.POPULUS_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.axis(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), pBlockModelGenerators);
	}

	public static void barrel(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.barrel(IcariaBlocks.CYPRESS_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LOADED_CYPRESS_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.TAPPED_CYPRESS_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.DROUGHTROOT_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.FIR_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LOADED_FIR_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.TAPPED_FIR_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LAUREL_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LOADED_LAUREL_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.TAPPED_LAUREL_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.OLIVE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LOADED_OLIVE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.TAPPED_OLIVE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.PLANE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LOADED_PLANE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.TAPPED_PLANE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.POPULUS_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.LOADED_POPULUS_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.barrel(IcariaBlocks.TAPPED_POPULUS_BARREL.get(), pBlockModelGenerators);
	}

	public static void bars(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.bars(IcariaBlocks.VANADIUMSTEEL_BARS.get(), pBlockModelGenerators);
	}

	public static void block(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.block(IcariaBlocks.MARL_CHERT.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MARL_BONES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MARL_LIGNITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FERTILIZED_FARMLAND.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MARL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LOAM_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DOLOMITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SMOOTH_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DOLOMITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRAINEL_CHERT.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRAINGLASS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRAINITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRAINITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.YELLOWSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.COBBLED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.YELLOWSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SILKGLASS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SILKSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.COBBLED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SILKSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SUNSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.COBBLED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SUNSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VOIDSHALE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.COBBLED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VOIDSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BAETYL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.COBBLED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BAETYL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BAETYL_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SMOOTH_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLURRED_PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHISELED_PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LIGNITE_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHALKOS_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.KASSITEROS_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DOLOMITE_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VANADIUM_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SLIVER_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SIDEROS_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ANTHRACITE_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MOLYBDENUM_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.HYLIASTRUM_ORE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CALCITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BUDDING_CALCITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.HALITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BUDDING_HALITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.JASPER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BUDDING_JASPER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ZIRCON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BUDDING_ZIRCON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ARISTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PACKED_ARISTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VINE_REED_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ROTTEN_BONES_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RAW_CHALKOS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RAW_KASSITEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RAW_VANADIUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RAW_SIDEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CALCITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.HALITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.JASPER_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ZIRCON_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHERT_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LIGNITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHALKOS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.KASSITEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ORICHALCUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VANADIUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SLIVER_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VANADIUMSTEEL_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SIDEROS_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ANTHRACITE_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MOLYBDENUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLURIDIUM_BLOCK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHEST.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.TRAPPED_CHEST.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.WHITE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRAY_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLACK_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BROWN_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.RED_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ORANGE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.YELLOW_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LIME_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GREEN_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYAN_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLUE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PURPLE_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MAGENTA_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PINK_STORAGE_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ARACHNE_SPAWNER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.REVENANT_SPAWNER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LIGNITE_TORCH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ANTHRACITE_TORCH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_WALL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_FIR_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_CRAFTING_TABLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_WALL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_WALL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.OLIVE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.OLIVE_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.OLIVE_WALL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.OLIVE_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PLANE_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_WALL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_WALL_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FERN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_FERN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SMALL_GRASS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MEDIUM_GRASS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LARGE_GRASS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SMALL_MIXED_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MEDIUM_MIXED_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MEDIUM_BROWN_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MEDIUM_WHITE_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LARGE_BROWN_GRAIN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLINDWEED.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_BLINDWEED.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHAMEOMILE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_CHAMEOMILE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CHARMONDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_CHARMONDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.CLOVER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_CLOVER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.FIREHILT.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_FIREHILT.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLUE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PURPLE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.LIONFANGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_LIONFANGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SPEARDROPS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_SPEARDROPS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PURPLE_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.YELLOW_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.BLUE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PINK_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PURPLE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SUNKETTLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_SUNKETTLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.SUNSPONGE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_SUNSPONGE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.VOIDLILY.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_VOIDLILY.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PALM_FERN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PALM_FERN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.WHITE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.ORANGE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PINK_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PINK_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.PURPLE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.POTTED_CARDON_CACTUS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.MEDITERRANEAN_WATER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRINDER_SHAFT.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.block(IcariaBlocks.GRINDER_STONE.get(), pBlockModelGenerators);
	}

	public static void bloomyVine(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.bloomyVine(IcariaBlocks.BLOOMY_VINE.get(), pBlockModelGenerators);
	}

	public static void brushyVine(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.brushyVine(IcariaBlocks.BRUSHY_VINE.get(), pBlockModelGenerators);
	}

	public static void button(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.button(IcariaBlocks.CYPRESS_BUTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.button(IcariaBlocks.DROUGHTROOT_BUTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.button(IcariaBlocks.FIR_BUTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.button(IcariaBlocks.LAUREL_BUTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.button(IcariaBlocks.OLIVE_BUTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.button(IcariaBlocks.PLANE_BUTTON.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.button(IcariaBlocks.POPULUS_BUTTON.get(), pBlockModelGenerators);
	}

	public static void cake(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.cake(IcariaBlocks.LAUREL_CHERRY_CAKE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.cake(IcariaBlocks.STRAWBERRY_CAKE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.cake(IcariaBlocks.PHYSALIS_CAKE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.cake(IcariaBlocks.VINE_BERRY_CAKE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.cake(IcariaBlocks.VINE_SPROUT_CAKE.get(), pBlockModelGenerators);
	}

	public static void cardonCactus(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.cardonCactus(IcariaBlocks.CARDON_CACTUS.get(), pBlockModelGenerators);
	}

	public static void chain(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.chain(IcariaBlocks.VANADIUMSTEEL_CHAIN.get(), pBlockModelGenerators);
	}

	public static void crop(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.crop(IcariaBlocks.SPELT_CROP.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.crop(IcariaBlocks.STRAWBERRY_CROP.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.crop(IcariaBlocks.PHYSALIS_CROP.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.crop(IcariaBlocks.ONION_CROP.get(), pBlockModelGenerators);
	}

	public static void deadDroughtrootLog(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.deadDroughtrootLog(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
	}

	public static void deadLog(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.deadLog(IcariaBlocks.DEAD_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.DEAD_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.DEAD_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.DEAD_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.DEAD_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.DEAD_POPULUS_LOG.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.deadLog(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), pBlockModelGenerators);
	}

	public static void directional(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.directional(IcariaBlocks.CALCITE_CRYSTAL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.directional(IcariaBlocks.HALITE_CRYSTAL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.directional(IcariaBlocks.JASPER_CRYSTAL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.directional(IcariaBlocks.ZIRCON_CRYSTAL.get(), pBlockModelGenerators);
	}

	public static void door(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.door(IcariaBlocks.CYPRESS_DOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.door(IcariaBlocks.DROUGHTROOT_DOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.door(IcariaBlocks.FIR_DOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.door(IcariaBlocks.LAUREL_DOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.door(IcariaBlocks.OLIVE_DOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.door(IcariaBlocks.PLANE_DOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.door(IcariaBlocks.POPULUS_DOOR.get(), pBlockModelGenerators);
	}

	public static void farmland(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.farmland(IcariaBlocks.FARMLAND.get(), pBlockModelGenerators);
	}

	public static void fence(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.fence(IcariaBlocks.CYPRESS_FENCE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fence(IcariaBlocks.DROUGHTROOT_FENCE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fence(IcariaBlocks.FIR_FENCE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fence(IcariaBlocks.LAUREL_FENCE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fence(IcariaBlocks.OLIVE_FENCE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fence(IcariaBlocks.PLANE_FENCE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fence(IcariaBlocks.POPULUS_FENCE.get(), pBlockModelGenerators);
	}

	public static void fenceGate(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.fenceGate(IcariaBlocks.CYPRESS_FENCE_GATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fenceGate(IcariaBlocks.DROUGHTROOT_FENCE_GATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fenceGate(IcariaBlocks.FIR_FENCE_GATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fenceGate(IcariaBlocks.LAUREL_FENCE_GATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fenceGate(IcariaBlocks.OLIVE_FENCE_GATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fenceGate(IcariaBlocks.PLANE_FENCE_GATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.fenceGate(IcariaBlocks.POPULUS_FENCE_GATE.get(), pBlockModelGenerators);
	}

	public static void fire(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.fire(IcariaBlocks.GREEK_FIRE.get(), pBlockModelGenerators);
	}

	public static void forge(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.forge(IcariaBlocks.FORGE.get(), pBlockModelGenerators);
	}

	public static void grassyMarl(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.grassyMarl(IcariaBlocks.GRASSY_MARL.get(), pBlockModelGenerators);
	}

	public static void grinder(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.grinder(IcariaBlocks.GRINDER.get(), pBlockModelGenerators);
	}

	public static void horizontal(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.horizontal(IcariaBlocks.LIGNITE_WALL_TORCH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.CYPRESS_TROUGH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.CYPRESS_LADDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.DROUGHTROOT_TROUGH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.DROUGHTROOT_LADDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.FIR_TROUGH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.FIR_LADDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.LAUREL_TROUGH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.LAUREL_LADDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.OLIVE_TROUGH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.OLIVE_LADDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.PLANE_TROUGH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.PLANE_LADDER.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.POPULUS_TROUGH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.horizontal(IcariaBlocks.POPULUS_LADDER.get(), pBlockModelGenerators);
	}

	public static void kettle(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.kettle(IcariaBlocks.KETTLE.get(), pBlockModelGenerators);
	}

	public static void kiln(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.kiln(IcariaBlocks.KILN.get(), pBlockModelGenerators);
	}

	public static void layer(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.layer(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.FALLEN_FIR_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.FOREST_MOSS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.SCRUBLAND_MOSS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.layer(IcariaBlocks.STEPPE_MOSS.get(), pBlockModelGenerators);
	}

	public static void lootVase(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.lootVase(IcariaBlocks.RED_LOOT_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.lootVase(IcariaBlocks.LOST_LOOT_VASE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.lootVase(IcariaBlocks.CYAN_LOOT_VASE.get(), pBlockModelGenerators);
	}

	public static void oliveLeaves(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.oliveLeaves(IcariaBlocks.OLIVE_LEAVES.get(), pBlockModelGenerators);
	}

	public static void pane(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.pane(IcariaBlocks.GRAINGLASS_PANE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pane(IcariaBlocks.SILKGLASS_PANE.get(), pBlockModelGenerators);
	}

	public static void pillarHead(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.pillarHead(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pillarHead(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pillarHead(IcariaBlocks.QUARTZ_PILLAR_HEAD.get(), pBlockModelGenerators);
	}

	public static void portal(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.portal(IcariaBlocks.ICARIA_PORTAL.get(), pBlockModelGenerators);
	}

	public static void pressurePlate(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.pressurePlate(IcariaBlocks.CYPRESS_PRESSURE_PLATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pressurePlate(IcariaBlocks.DROUGHTROOT_PRESSURE_PLATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pressurePlate(IcariaBlocks.FIR_PRESSURE_PLATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pressurePlate(IcariaBlocks.LAUREL_PRESSURE_PLATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pressurePlate(IcariaBlocks.OLIVE_PRESSURE_PLATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pressurePlate(IcariaBlocks.PLANE_PRESSURE_PLATE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.pressurePlate(IcariaBlocks.POPULUS_PRESSURE_PLATE.get(), pBlockModelGenerators);
	}

	public static void rack(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.rack(IcariaBlocks.CYPRESS_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.rack(IcariaBlocks.DROUGHTROOT_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.rack(IcariaBlocks.FIR_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.rack(IcariaBlocks.LAUREL_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.rack(IcariaBlocks.OLIVE_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.rack(IcariaBlocks.PLANE_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.rack(IcariaBlocks.POPULUS_RACK.get(), pBlockModelGenerators);
	}

	public static void randomHorizontal1(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.SURFACE_CHERT.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.SURFACE_BONES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.MARL_PATH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.LOAM_PATH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.GRAINEL_PATH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.SILKSAND_PATH.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.BOLBOS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.DATHULLA.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.MONDANOS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.MOTH_AGARIC.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.NAMDRAKE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.PSILOCYBOS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.ROWAN.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal1(IcariaBlocks.WILTED_ELM.get(), pBlockModelGenerators);
	}

	public static void randomHorizontal3(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.PINK_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.RED_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal3(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void randomHorizontal5(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.SURFACE_LIGNITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.GRAINITE_RUBBLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.SILKSTONE_RUBBLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.SUNSTONE_RUBBLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.VOIDSHALE_RUBBLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.BAETYL_RUBBLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.RELICSTONE_RUBBLE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.CYPRESS_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.DROUGHTROOT_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.FIR_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.LAUREL_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.OLIVE_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.PLANE_TWIGS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomHorizontal5(IcariaBlocks.POPULUS_TWIGS.get(), pBlockModelGenerators);
	}

	public static void randomRotation(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.randomRotation(IcariaBlocks.MARL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomRotation(IcariaBlocks.COARSE_MARL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomRotation(IcariaBlocks.DRY_LAKE_BED.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomRotation(IcariaBlocks.LOAM.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomRotation(IcariaBlocks.GRAINEL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.randomRotation(IcariaBlocks.SILKSAND.get(), pBlockModelGenerators);
	}

	public static void simpleRack(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.simpleRack(IcariaBlocks.SIMPLE_CYPRESS_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.simpleRack(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.simpleRack(IcariaBlocks.SIMPLE_FIR_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.simpleRack(IcariaBlocks.SIMPLE_LAUREL_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.simpleRack(IcariaBlocks.SIMPLE_OLIVE_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.simpleRack(IcariaBlocks.SIMPLE_PLANE_RACK.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.simpleRack(IcariaBlocks.SIMPLE_POPULUS_RACK.get(), pBlockModelGenerators);
	}

	public static void skull(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.skull(IcariaBlocks.AETERNAE_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.AETERNAE_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.ARGAN_HOUND_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CAPELLA_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CAPELLA_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CATOBLEPAS_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CERVER_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CERVER_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CROCOTTA_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CROCOTTA_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.FIR_FOREST_HAG_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.REVENANT_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.REVENANT_WALL_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.SOW_SKULL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.skull(IcariaBlocks.SOW_WALL_SKULL.get(), pBlockModelGenerators);
	}

	public static void slab(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.slab(IcariaBlocks.MARL_ADOBE_SLAB.get(), IcariaBlocks.MARL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.LOAM_BRICK_SLAB.get(), IcariaBlocks.LOAM_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.DOLOMITE_ADOBE_SLAB.get(), IcariaBlocks.DOLOMITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SMOOTH_DOLOMITE_SLAB.get(), IcariaBlocks.SMOOTH_DOLOMITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.GRAINITE_ADOBE_SLAB.get(), IcariaBlocks.GRAINITE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.GRAINITE_SLAB.get(), IcariaBlocks.GRAINITE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.GRAINITE_BRICK_SLAB.get(), IcariaBlocks.GRAINITE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.YELLOWSTONE_ADOBE_SLAB.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.COBBLED_YELLOWSTONE_SLAB.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.YELLOWSTONE_SLAB.get(), IcariaBlocks.YELLOWSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.YELLOWSTONE_BRICK_SLAB.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SILKSTONE_ADOBE_SLAB.get(), IcariaBlocks.SILKSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.COBBLED_SILKSTONE_SLAB.get(), IcariaBlocks.COBBLED_SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SILKSTONE_SLAB.get(), IcariaBlocks.SILKSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SILKSTONE_BRICK_SLAB.get(), IcariaBlocks.SILKSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SUNSTONE_ADOBE_SLAB.get(), IcariaBlocks.SUNSTONE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.COBBLED_SUNSTONE_SLAB.get(), IcariaBlocks.COBBLED_SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SUNSTONE_SLAB.get(), IcariaBlocks.SUNSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SUNSTONE_BRICK_SLAB.get(), IcariaBlocks.SUNSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.VOIDSHALE_ADOBE_SLAB.get(), IcariaBlocks.VOIDSHALE_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.COBBLED_VOIDSHALE_SLAB.get(), IcariaBlocks.COBBLED_VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.VOIDSHALE_SLAB.get(), IcariaBlocks.VOIDSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.VOIDSHALE_BRICK_SLAB.get(), IcariaBlocks.VOIDSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.BAETYL_ADOBE_SLAB.get(), IcariaBlocks.BAETYL_ADOBE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.COBBLED_BAETYL_SLAB.get(), IcariaBlocks.COBBLED_BAETYL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.BAETYL_SLAB.get(), IcariaBlocks.BAETYL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.BAETYL_BRICK_SLAB.get(), IcariaBlocks.BAETYL_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.RELICSTONE_SLAB.get(), IcariaBlocks.RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.SMOOTH_RELICSTONE_SLAB.get(), IcariaBlocks.SMOOTH_RELICSTONE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.RELICSTONE_BRICK_SLAB.get(), IcariaBlocks.RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.CRACKED_RELICSTONE_BRICK_SLAB.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.MOSSY_RELICSTONE_BRICK_SLAB.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.RELICSTONE_TILE_SLAB.get(), IcariaBlocks.RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.CRACKED_RELICSTONE_TILE_SLAB.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.MOSSY_RELICSTONE_TILE_SLAB.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.PLATOSHALE_SLAB.get(), IcariaBlocks.PLATOSHALE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.PLATOSHALE_BRICK_SLAB.get(), IcariaBlocks.PLATOSHALE_BRICKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.CYPRESS_SLAB.get(), IcariaBlocks.CYPRESS_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.DROUGHTROOT_SLAB.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.FIR_SLAB.get(), IcariaBlocks.FIR_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.LAUREL_SLAB.get(), IcariaBlocks.LAUREL_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.OLIVE_SLAB.get(), IcariaBlocks.OLIVE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.PLANE_SLAB.get(), IcariaBlocks.PLANE_PLANKS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.slab(IcariaBlocks.POPULUS_SLAB.get(), IcariaBlocks.POPULUS_PLANKS.get(), pBlockModelGenerators);
	}

	public static void stairs(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.stairs(IcariaBlocks.MARL_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.LOAM_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.DOLOMITE_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SMOOTH_DOLOMITE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.GRAINITE_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.GRAINITE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.GRAINITE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.YELLOWSTONE_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.COBBLED_YELLOWSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.YELLOWSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.YELLOWSTONE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SILKSTONE_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.COBBLED_SILKSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SILKSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SILKSTONE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SUNSTONE_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.COBBLED_SUNSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SUNSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SUNSTONE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.VOIDSHALE_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.COBBLED_VOIDSHALE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.VOIDSHALE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.VOIDSHALE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.BAETYL_ADOBE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.COBBLED_BAETYL_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.BAETYL_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.BAETYL_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.RELICSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.SMOOTH_RELICSTONE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.RELICSTONE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.CRACKED_RELICSTONE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.MOSSY_RELICSTONE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.RELICSTONE_TILE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.CRACKED_RELICSTONE_TILE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.MOSSY_RELICSTONE_TILE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.PLATOSHALE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.PLATOSHALE_BRICK_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.CYPRESS_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.DROUGHTROOT_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.FIR_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.LAUREL_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.OLIVE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.PLANE_STAIRS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.stairs(IcariaBlocks.POPULUS_STAIRS.get(), pBlockModelGenerators);
	}

	public static void strawberryBush(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.strawberryBush(IcariaBlocks.STRAWBERRY_BUSH.get(), pBlockModelGenerators);
	}

	public static void trapdoor(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.trapdoor(IcariaBlocks.CYPRESS_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.trapdoor(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.trapdoor(IcariaBlocks.FIR_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.trapdoor(IcariaBlocks.LAUREL_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.trapdoor(IcariaBlocks.OLIVE_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.trapdoor(IcariaBlocks.PLANE_TRAPDOOR.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.trapdoor(IcariaBlocks.POPULUS_TRAPDOOR.get(), pBlockModelGenerators);
	}

	public static void treeShrooms(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.treeShrooms(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.treeShrooms(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.treeShrooms(IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), pBlockModelGenerators);
	}

	public static void tripleBarrelRack(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get(), IcariaBlocks.FIR_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get(), IcariaBlocks.OLIVE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get(), IcariaBlocks.PLANE_BARREL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.tripleBarrelRack(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get(), IcariaBlocks.POPULUS_BARREL.get(), pBlockModelGenerators);
	}

	public static void vine(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.vine(IcariaBlocks.BRANCHY_VINE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.vine(IcariaBlocks.DRY_VINE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.vine(IcariaBlocks.REEDY_VINE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.vine(IcariaBlocks.SWIRLY_VINE.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.vine(IcariaBlocks.THORNY_VINE.get(), pBlockModelGenerators);
	}

	public static void wall(BlockModelGenerators pBlockModelGenerators) {
		IcariaBlockStateProvider.wall(IcariaBlocks.MARL_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.LOAM_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.DOLOMITE_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SMOOTH_DOLOMITE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.GRAINITE_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.GRAINITE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.GRAINITE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.YELLOWSTONE_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.COBBLED_YELLOWSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.YELLOWSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.YELLOWSTONE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SILKSTONE_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.COBBLED_SILKSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SILKSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SILKSTONE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SUNSTONE_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.COBBLED_SUNSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SUNSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SUNSTONE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.VOIDSHALE_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.COBBLED_VOIDSHALE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.VOIDSHALE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.VOIDSHALE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.BAETYL_ADOBE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.COBBLED_BAETYL_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.BAETYL_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.BAETYL_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.RELICSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.SMOOTH_RELICSTONE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.RELICSTONE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.CRACKED_RELICSTONE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.MOSSY_RELICSTONE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.RELICSTONE_TILE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.CRACKED_RELICSTONE_TILE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.MOSSY_RELICSTONE_TILE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.PLATOSHALE_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.PLATOSHALE_BRICK_WALL.get(), pBlockModelGenerators);
		IcariaBlockStateProvider.wall(IcariaBlocks.QUARTZ_WALL.get(), pBlockModelGenerators);
	}

	public static void bars(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "post_ends"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "post"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cap_alt")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cap_alt"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, true).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cap")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cap"))))
		);
	}

	public static void bloomyVine(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.BLOOMING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blooming", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.BLOOMING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blooming", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.BLOOMING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blooming", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.BLOOMING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blooming", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
		);
	}

	public static void brushyVine(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.RIPE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("ripe", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
		);
	}

	public static void cardonCactus(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cube"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cube")).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "stem")).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cube")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "stem")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cube")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "stem")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "cube")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "stem")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.UP, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "stem")).with(BlockModelGenerators.X_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.DOWN, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "stem")).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
		);
	}

	public static void fence(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "post"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
		);
	}

	public static void fire(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "floor_0"))))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "floor_1"))))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_0"))))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_1"))))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_0"))))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_1"))))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_0")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_1")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_0")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_1")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_0")).with(BlockModelGenerators.Y_ROT_180)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_1")).with(BlockModelGenerators.Y_ROT_180)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_0")).with(BlockModelGenerators.Y_ROT_180)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_1")).with(BlockModelGenerators.Y_ROT_180)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_0")).with(BlockModelGenerators.Y_ROT_270)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_1")).with(BlockModelGenerators.Y_ROT_270)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_0")).with(BlockModelGenerators.Y_ROT_270)))
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt_1")).with(BlockModelGenerators.Y_ROT_270)))
		);
	}

	public static void pane(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "post"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "noside"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "noside_alt"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "noside_alt")).with(BlockModelGenerators.Y_ROT_90)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, false), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "noside")).with(BlockModelGenerators.Y_ROT_270)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_alt")).with(BlockModelGenerators.Y_ROT_90)))
		);
	}

	public static void vine(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.NONE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.DEAD), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("dead", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.GROWING), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("growing", pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(IcariaBlockStateProperties.VINE, Vine.VINE), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
		);
	}

	public static void wall(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiPartGenerator.multiPart(pBlock)
			.with(BlockModelGenerators.condition().term(BlockStateProperties.UP, true), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "post"))))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_tall")).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_tall")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_tall")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
			.with(BlockModelGenerators.condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL), BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "side_tall")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
		);
	}

	public static void axis(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.AXIS)
				.select(Direction.Axis.X, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_90)))
				.select(Direction.Axis.Y, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.Axis.Z, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal")).with(BlockModelGenerators.X_ROT_90)))
			)
		);
	}

	public static void barrel(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.BARREL_FACING)
				.select(Direction.NORTH, Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, Direction.UP, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("standing", pBlock))))
				.select(Direction.EAST, Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Direction.UP, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("standing", pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Direction.UP, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("standing", pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Direction.UP, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("standing", pBlock)).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void block(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)))));
	}

	public static void button(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.ATTACH_FACE, BlockStateProperties.POWERED)
				.select(Direction.NORTH, AttachFace.CEILING, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.NORTH, AttachFace.CEILING, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.NORTH, AttachFace.FLOOR, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, AttachFace.FLOOR, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed"))))
				.select(Direction.NORTH, AttachFace.WALL, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, AttachFace.WALL, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, AttachFace.CEILING, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.EAST, AttachFace.CEILING, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.EAST, AttachFace.FLOOR, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, AttachFace.FLOOR, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, AttachFace.WALL, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, AttachFace.WALL, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, AttachFace.CEILING, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.SOUTH, AttachFace.CEILING, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.SOUTH, AttachFace.FLOOR, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, AttachFace.FLOOR, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, AttachFace.WALL, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, AttachFace.WALL, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, AttachFace.CEILING, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.WEST, AttachFace.CEILING, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.WEST, AttachFace.FLOOR, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, AttachFace.FLOOR, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, AttachFace.WALL, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, AttachFace.WALL, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "pressed")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			)
		);
	}

	public static void cake(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(IcariaBlockStateProperties.CANDLE, IcariaBlockStateProperties.CAKE_BITE, BlockStateProperties.LIT)
				.select(Candle.NONE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0"))))
				.select(Candle.NONE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0"))))
				.select(Candle.NONE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1"))))
				.select(Candle.NONE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1"))))
				.select(Candle.NONE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2"))))
				.select(Candle.NONE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2"))))
				.select(Candle.NONE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3"))))
				.select(Candle.NONE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3"))))
				.select(Candle.CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock))))
				.select(Candle.CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock, "lit"))))
				.select(Candle.CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock))))
				.select(Candle.CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock, "lit"))))
				.select(Candle.CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock))))
				.select(Candle.CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock, "lit"))))
				.select(Candle.CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock))))
				.select(Candle.CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("candle", pBlock, "lit"))))
				.select(Candle.WHITE_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock))))
				.select(Candle.WHITE_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock, "lit"))))
				.select(Candle.WHITE_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock))))
				.select(Candle.WHITE_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock, "lit"))))
				.select(Candle.WHITE_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock))))
				.select(Candle.WHITE_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock, "lit"))))
				.select(Candle.WHITE_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock))))
				.select(Candle.WHITE_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("white_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_GRAY_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock))))
				.select(Candle.LIGHT_GRAY_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_GRAY_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock))))
				.select(Candle.LIGHT_GRAY_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_GRAY_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock))))
				.select(Candle.LIGHT_GRAY_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_GRAY_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock))))
				.select(Candle.LIGHT_GRAY_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_gray_candle", pBlock, "lit"))))
				.select(Candle.GRAY_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock))))
				.select(Candle.GRAY_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit"))))
				.select(Candle.GRAY_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock))))
				.select(Candle.GRAY_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit"))))
				.select(Candle.GRAY_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock))))
				.select(Candle.GRAY_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit"))))
				.select(Candle.GRAY_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock))))
				.select(Candle.GRAY_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("gray_candle", pBlock, "lit"))))
				.select(Candle.BLACK_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock))))
				.select(Candle.BLACK_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock, "lit"))))
				.select(Candle.BLACK_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock))))
				.select(Candle.BLACK_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock, "lit"))))
				.select(Candle.BLACK_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock))))
				.select(Candle.BLACK_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock, "lit"))))
				.select(Candle.BLACK_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock))))
				.select(Candle.BLACK_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black_candle", pBlock, "lit"))))
				.select(Candle.BROWN_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock))))
				.select(Candle.BROWN_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit"))))
				.select(Candle.BROWN_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock))))
				.select(Candle.BROWN_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit"))))
				.select(Candle.BROWN_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock))))
				.select(Candle.BROWN_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit"))))
				.select(Candle.BROWN_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock))))
				.select(Candle.BROWN_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("brown_candle", pBlock, "lit"))))
				.select(Candle.RED_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock))))
				.select(Candle.RED_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock, "lit"))))
				.select(Candle.RED_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock))))
				.select(Candle.RED_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock, "lit"))))
				.select(Candle.RED_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock))))
				.select(Candle.RED_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock, "lit"))))
				.select(Candle.RED_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock))))
				.select(Candle.RED_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("red_candle", pBlock, "lit"))))
				.select(Candle.ORANGE_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock))))
				.select(Candle.ORANGE_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit"))))
				.select(Candle.ORANGE_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock))))
				.select(Candle.ORANGE_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit"))))
				.select(Candle.ORANGE_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock))))
				.select(Candle.ORANGE_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit"))))
				.select(Candle.ORANGE_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock))))
				.select(Candle.ORANGE_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("orange_candle", pBlock, "lit"))))
				.select(Candle.YELLOW_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock))))
				.select(Candle.YELLOW_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit"))))
				.select(Candle.YELLOW_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock))))
				.select(Candle.YELLOW_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit"))))
				.select(Candle.YELLOW_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock))))
				.select(Candle.YELLOW_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit"))))
				.select(Candle.YELLOW_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock))))
				.select(Candle.YELLOW_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("yellow_candle", pBlock, "lit"))))
				.select(Candle.LIME_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock))))
				.select(Candle.LIME_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit"))))
				.select(Candle.LIME_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock))))
				.select(Candle.LIME_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit"))))
				.select(Candle.LIME_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock))))
				.select(Candle.LIME_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit"))))
				.select(Candle.LIME_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock))))
				.select(Candle.LIME_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("lime_candle", pBlock, "lit"))))
				.select(Candle.GREEN_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock))))
				.select(Candle.GREEN_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock, "lit"))))
				.select(Candle.GREEN_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock))))
				.select(Candle.GREEN_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock, "lit"))))
				.select(Candle.GREEN_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock))))
				.select(Candle.GREEN_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock, "lit"))))
				.select(Candle.GREEN_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock))))
				.select(Candle.GREEN_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green_candle", pBlock, "lit"))))
				.select(Candle.CYAN_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock))))
				.select(Candle.CYAN_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit"))))
				.select(Candle.CYAN_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock))))
				.select(Candle.CYAN_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit"))))
				.select(Candle.CYAN_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock))))
				.select(Candle.CYAN_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit"))))
				.select(Candle.CYAN_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock))))
				.select(Candle.CYAN_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("cyan_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_BLUE_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock))))
				.select(Candle.LIGHT_BLUE_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_BLUE_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock))))
				.select(Candle.LIGHT_BLUE_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_BLUE_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock))))
				.select(Candle.LIGHT_BLUE_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit"))))
				.select(Candle.LIGHT_BLUE_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock))))
				.select(Candle.LIGHT_BLUE_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("light_blue_candle", pBlock, "lit"))))
				.select(Candle.BLUE_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock))))
				.select(Candle.BLUE_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit"))))
				.select(Candle.BLUE_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock))))
				.select(Candle.BLUE_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit"))))
				.select(Candle.BLUE_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock))))
				.select(Candle.BLUE_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit"))))
				.select(Candle.BLUE_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock))))
				.select(Candle.BLUE_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("blue_candle", pBlock, "lit"))))
				.select(Candle.PURPLE_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock))))
				.select(Candle.PURPLE_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit"))))
				.select(Candle.PURPLE_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock))))
				.select(Candle.PURPLE_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit"))))
				.select(Candle.PURPLE_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock))))
				.select(Candle.PURPLE_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit"))))
				.select(Candle.PURPLE_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock))))
				.select(Candle.PURPLE_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("purple_candle", pBlock, "lit"))))
				.select(Candle.MAGENTA_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock))))
				.select(Candle.MAGENTA_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit"))))
				.select(Candle.MAGENTA_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock))))
				.select(Candle.MAGENTA_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit"))))
				.select(Candle.MAGENTA_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock))))
				.select(Candle.MAGENTA_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit"))))
				.select(Candle.MAGENTA_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock))))
				.select(Candle.MAGENTA_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("magenta_candle", pBlock, "lit"))))
				.select(Candle.PINK_CANDLE, 0, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock))))
				.select(Candle.PINK_CANDLE, 0, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit"))))
				.select(Candle.PINK_CANDLE, 1, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock))))
				.select(Candle.PINK_CANDLE, 1, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit"))))
				.select(Candle.PINK_CANDLE, 2, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock))))
				.select(Candle.PINK_CANDLE, 2, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit"))))
				.select(Candle.PINK_CANDLE, 3, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock))))
				.select(Candle.PINK_CANDLE, 3, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("pink_candle", pBlock, "lit"))))
			)
		);
	}

	public static void chain(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.AXIS)
				.select(Direction.Axis.X, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_90)))
				.select(Direction.Axis.Y, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.Axis.Z, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_90)))
			)
		);
	}

	public static void crop(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.AGE_7)
				.select(0, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0"))))
				.select(1, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1"))))
				.select(2, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2"))))
				.select(3, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3"))))
				.select(4, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4"))))
				.select(5, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "5"))))
				.select(6, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "6"))))
				.select(7, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "7"))))
			)
		);
	}

	public static void deadDroughtrootLog(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.AXIS)
				.select(Direction.Axis.X, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_0")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.Axis.Y, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0"))))
				.select(Direction.Axis.Z, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_0"))))
			)
		);
	}

	public static void deadLog(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.AXIS)
				.select(Direction.Axis.X, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_0")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_1")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_2")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.Axis.Y, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2"))))
				.select(Direction.Axis.Z, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_0")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_1")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "horizontal_2"))))
			)
		);
	}

	public static void directional(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.FACING)
				.select(Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_90)))
				.select(Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_90)))
				.select(Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_90)))
				.select(Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_90)))
				.select(Direction.UP, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.DOWN, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_180)))
			)
		);
	}

	public static void door(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOOR_HINGE, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.OPEN)
				.select(Direction.NORTH, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.NORTH, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left_open"))))
				.select(Direction.NORTH, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.NORTH, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left_open"))))
				.select(Direction.NORTH, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.NORTH, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right_open")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.NORTH, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.NORTH, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right_open")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.EAST, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left"))))
				.select(Direction.EAST, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left_open")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left"))))
				.select(Direction.EAST, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left_open")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right"))))
				.select(Direction.EAST, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right_open")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.EAST, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right"))))
				.select(Direction.EAST, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right_open")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.SOUTH, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left_open")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left_open")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right_open"))))
				.select(Direction.SOUTH, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right_open"))))
				.select(Direction.WEST, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, DoorHingeSide.LEFT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_left_open")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, DoorHingeSide.LEFT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left_open")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, DoorHingeSide.RIGHT, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_right_open")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.WEST, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, DoorHingeSide.RIGHT, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right_open")).with(BlockModelGenerators.Y_ROT_90)))
			)
		);
	}

	public static void farmland(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.MOISTURE)
				.select(0, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "dry"))))
				.select(1, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "dry"))))
				.select(2, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "dry"))))
				.select(3, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "dry"))))
				.select(4, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "dry"))))
				.select(5, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "dry"))))
				.select(6, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "dry"))))
				.select(7, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wet"))))
			)
		);
	}

	public static void fenceGate(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.IN_WALL, BlockStateProperties.OPEN)
				.select(Direction.NORTH, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall_open")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall_open")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall")).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall_open")).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "wall_open")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
			)
		);
	}

	public static void forge(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.CORNER, BlockStateProperties.LIT)
				.select(Direction.NORTH, Corner.BOTTOM_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left"))))
				.select(Direction.NORTH, Corner.BOTTOM_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left"))))
				.select(Direction.NORTH, Corner.BOTTOM_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right"))))
				.select(Direction.NORTH, Corner.BOTTOM_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right_lit"))))
				.select(Direction.NORTH, Corner.BOTTOM_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left"))))
				.select(Direction.NORTH, Corner.BOTTOM_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left"))))
				.select(Direction.NORTH, Corner.BOTTOM_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right"))))
				.select(Direction.NORTH, Corner.BOTTOM_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right"))))
				.select(Direction.NORTH, Corner.TOP_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left"))))
				.select(Direction.NORTH, Corner.TOP_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left"))))
				.select(Direction.NORTH, Corner.TOP_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right"))))
				.select(Direction.NORTH, Corner.TOP_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right"))))
				.select(Direction.NORTH, Corner.TOP_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left"))))
				.select(Direction.NORTH, Corner.TOP_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left"))))
				.select(Direction.NORTH, Corner.TOP_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right"))))
				.select(Direction.NORTH, Corner.TOP_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right"))))
				.select(Direction.EAST, Corner.BOTTOM_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.BOTTOM_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.BOTTOM_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.BOTTOM_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right_lit")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.BOTTOM_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.BOTTOM_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.BOTTOM_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.BOTTOM_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Corner.TOP_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, Corner.BOTTOM_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.BOTTOM_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.BOTTOM_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.BOTTOM_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right_lit")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.BOTTOM_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.BOTTOM_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.BOTTOM_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.BOTTOM_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Corner.TOP_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, Corner.BOTTOM_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.BOTTOM_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.BOTTOM_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.BOTTOM_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_front_right_lit")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.BOTTOM_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.BOTTOM_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.BOTTOM_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.BOTTOM_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom_back_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_FRONT_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_FRONT_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_FRONT_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_FRONT_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_front_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_BACK_LEFT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_BACK_LEFT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_BACK_RIGHT, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Corner.TOP_BACK_RIGHT, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_back_right")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void grassyMarl(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(IcariaBlockStateProperties.MOSS)
				.select(Moss.NONE, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Moss.FOREST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "forest_moss")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "forest_moss")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "forest_moss")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "forest_moss")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Moss.SCRUBLAND, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "scrubland_moss")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "scrubland_moss")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "scrubland_moss")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "scrubland_moss")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Moss.STEPPE, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "steppe_moss")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "steppe_moss")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "steppe_moss")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "grassy", "steppe_moss")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void grinder(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.SIDE)
				.select(Direction.NORTH, Side.LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "left"))))
				.select(Direction.NORTH, Side.RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "right"))))
				.select(Direction.EAST, Side.LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Side.RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, Side.LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Side.RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, Side.LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Side.RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "right")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void horizontal(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
				.select(Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void kettle(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.LIT)
				.select(Direction.NORTH, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower"))))
				.select(Direction.NORTH, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower_lit"))))
				.select(Direction.NORTH, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper"))))
				.select(Direction.NORTH, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper"))))
				.select(Direction.EAST, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower_lit")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower_lit")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, DoubleBlockHalf.LOWER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, DoubleBlockHalf.LOWER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower_lit")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, DoubleBlockHalf.UPPER, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, DoubleBlockHalf.UPPER, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void kiln(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF)
				.select(Direction.NORTH, DoubleBlockHalf.LOWER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower"))))
				.select(Direction.NORTH, DoubleBlockHalf.UPPER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper"))))
				.select(Direction.EAST, DoubleBlockHalf.LOWER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, DoubleBlockHalf.UPPER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, DoubleBlockHalf.LOWER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, DoubleBlockHalf.UPPER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, DoubleBlockHalf.LOWER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "lower")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, DoubleBlockHalf.UPPER, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "upper")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void layer(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.LAYERS)
				.select(1, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_270)))
				.select(2, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_270)))
				.select(3, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")).with(BlockModelGenerators.Y_ROT_270)))
				.select(4, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")).with(BlockModelGenerators.Y_ROT_270)))
				.select(5, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "5")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "5")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "5")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "5")).with(BlockModelGenerators.Y_ROT_270)))
				.select(6, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "6")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "6")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "6")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "6")).with(BlockModelGenerators.Y_ROT_270)))
				.select(7, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "7")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "7")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "7")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "7")).with(BlockModelGenerators.Y_ROT_270)))
				.select(8, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "8")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "8")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "8")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "8")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void lootVase(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "5")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "6")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "7")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "8")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "9")))));
	}

	public static void oliveLeaves(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(IcariaBlockStateProperties.OLIVES)
				.select(Olives.NONE, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Olives.BLACK, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("black", pBlock))))
				.select(Olives.GREEN, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("green", pBlock))))
				.select(Olives.LEAVES, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
			)
		);
	}

	public static void pillarHead(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.FACING)
				.select(Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inverted")).with(BlockModelGenerators.X_ROT_270)))
				.select(Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inverted")).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_270).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.UP, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inverted")).with(BlockModelGenerators.X_ROT_180)))
				.select(Direction.DOWN, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
			)
		);
	}

	public static void portal(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_AXIS)
				.select(Direction.Axis.X, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "x"))))
				.select(Direction.Axis.Z, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "z"))))
			)
		);
	}

	public static void pressurePlate(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.POWERED)
				.select(false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "down"))))
			)
		);
	}

	public static void rack(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.FULL_RACK, IcariaBlockStateProperties.LOADED_BARREL, IcariaBlockStateProperties.TAPPED_BARREL)
				.select(Direction.NORTH, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("loaded", pBlock, "rack", "barrel_rack"))))
				.select(Direction.NORTH, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("tapped", pBlock, "rack", "barrel_rack"))))
				.select(Direction.NORTH, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack"))))
				.select(Direction.EAST, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("loaded", pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("tapped", pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("loaded", pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("tapped", pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("loaded", pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile("tapped", pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void randomHorizontal1(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270))));
	}

	public static void randomHorizontal3(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_270))));
	}

	public static void randomHorizontal5(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "3")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "4")).with(BlockModelGenerators.Y_ROT_270))));
	}

	public static void randomRotation(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_270))));
	}

	public static void simpleRack(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.FULL_RACK, IcariaBlockStateProperties.LOADED_BARREL, IcariaBlockStateProperties.TAPPED_BARREL)
				.select(Direction.NORTH, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(Direction.NORTH, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_loaded", "rack", "barrel_rack"))))
				.select(Direction.NORTH, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_tapped", "rack", "barrel_rack"))))
				.select(Direction.NORTH, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack"))))
				.select(Direction.EAST, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_loaded", "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_tapped", "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_loaded", "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_tapped", "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, false, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, false, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, false, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, false, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, true, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, true, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_loaded", "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, false, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "simple", "simple_tapped", "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, true, false, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "rack", "barrel_rack")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void skull(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(IcariaIdents.MC, "skull")))));
	}

	public static void slab(Block pSlab, Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pSlab)
			.with(PropertyDispatch.initial(BlockStateProperties.SLAB_TYPE)
				.select(SlabType.BOTTOM, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pSlab))))
				.select(SlabType.DOUBLE, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock))))
				.select(SlabType.TOP, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pSlab, "top"))))
			)
		);
	}

	public static void stairs(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE)
				.select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "inner")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "outer")).with(BlockModelGenerators.Y_ROT_270).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
				.select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock)).with(BlockModelGenerators.Y_ROT_180).with(BlockModelGenerators.X_ROT_180).with(BlockModelGenerators.UV_LOCK)))
			)
		);
	}

	public static void strawberryBush(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(IcariaBlockStateProperties.RIPE)
				.select(Ripe.NONE, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0"))))
				.select(Ripe.RIPE, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1"))))
			)
		);
	}

	public static void trapdoor(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.OPEN)
				.select(Direction.NORTH, Half.BOTTOM, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom"))))
				.select(Direction.NORTH, Half.BOTTOM, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open"))))
				.select(Direction.NORTH, Half.TOP, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top"))))
				.select(Direction.NORTH, Half.TOP, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open"))))
				.select(Direction.EAST, Half.BOTTOM, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom"))))
				.select(Direction.EAST, Half.BOTTOM, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, Half.TOP, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top"))))
				.select(Direction.EAST, Half.TOP, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, Half.BOTTOM, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom"))))
				.select(Direction.SOUTH, Half.BOTTOM, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, Half.TOP, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top"))))
				.select(Direction.SOUTH, Half.TOP, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, Half.BOTTOM, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "bottom"))))
				.select(Direction.WEST, Half.BOTTOM, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, Half.TOP, false, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top"))))
				.select(Direction.WEST, Half.TOP, true, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "open")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}

	public static void treeShrooms(Block pBlock, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
				.select(Direction.NORTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2"))))
				.select(Direction.EAST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_90), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_180), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "0")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "1")).with(BlockModelGenerators.Y_ROT_270), BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "2")).with(BlockModelGenerators.Y_ROT_270))))
		);
	}

	public static void tripleBarrelRack(Block pBlock, Block pBarrel, BlockModelGenerators pBlockModelGenerators) {
		pBlockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(pBlock)
			.with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.VERTICAL_CORNER)
				.select(Direction.NORTH, VerticalCorner.BOTTOM_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack"))))
				.select(Direction.NORTH, VerticalCorner.BOTTOM_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack"))))
				.select(Direction.NORTH, VerticalCorner.TOP_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left"))))
				.select(Direction.NORTH, VerticalCorner.TOP_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right"))))
				.select(Direction.EAST, VerticalCorner.BOTTOM_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, VerticalCorner.BOTTOM_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, VerticalCorner.TOP_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.EAST, VerticalCorner.TOP_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right")).with(BlockModelGenerators.Y_ROT_90)))
				.select(Direction.SOUTH, VerticalCorner.BOTTOM_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, VerticalCorner.BOTTOM_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, VerticalCorner.TOP_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.SOUTH, VerticalCorner.TOP_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right")).with(BlockModelGenerators.Y_ROT_180)))
				.select(Direction.WEST, VerticalCorner.BOTTOM_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, VerticalCorner.BOTTOM_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBarrel, "rack")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, VerticalCorner.TOP_LEFT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_left")).with(BlockModelGenerators.Y_ROT_270)))
				.select(Direction.WEST, VerticalCorner.TOP_RIGHT, BlockModelGenerators.variants(BlockModelGenerators.plainModel(IcariaModelProvider.blockFile(pBlock, "top_right")).with(BlockModelGenerators.Y_ROT_270)))
			)
		);
	}
}
