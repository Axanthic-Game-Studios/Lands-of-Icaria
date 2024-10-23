package com.axanthic.icaria.data.models;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.data.model.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.CompositeModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockModels extends BlockModelProvider {
	public IcariaBlockModels(PackOutput pOutput, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pId, pHelper);
	}

	@Override
	public void registerModels() {
		this.registerTemplate();
		this.registerProvider();
	}

	public void registerProvider() {
		this.grassyMarl(IcariaBlocks.GRASSY_MARL.get());
		this.block(IcariaBlocks.MARL.get());
		this.block(IcariaBlocks.MARL_CHERT.get());
		this.surfaceChert(IcariaBlocks.SURFACE_CHERT.get());
		this.block(IcariaBlocks.MARL_BONES.get());
		this.surfaceBones(IcariaBlocks.SURFACE_BONES.get());
		this.block(IcariaBlocks.MARL_LIGNITE.get());
		this.rubble(IcariaBlocks.SURFACE_LIGNITE.get(), IcariaBlocks.LIGNITE_BLOCK.get());
		this.block(IcariaBlocks.COARSE_MARL.get());
		this.block(IcariaBlocks.DRY_LAKE_BED.get());

		this.farmland(IcariaBlocks.FARMLAND.get());
		this.fertilizedFarmland(IcariaBlocks.FERTILIZED_FARMLAND.get());

		this.block(IcariaBlocks.MARL_ADOBE.get());
		this.slab(IcariaBlocks.MARL_ADOBE_DECO.slab.get(), IcariaBlocks.MARL_ADOBE.get());
		this.stairs(IcariaBlocks.MARL_ADOBE_DECO.stairs.get(), IcariaBlocks.MARL_ADOBE.get());
		this.wall(IcariaBlocks.MARL_ADOBE_DECO.wall.get(), IcariaBlocks.MARL_ADOBE.get());

		this.block(IcariaBlocks.LOAM.get());
		this.block(IcariaBlocks.LOAM_BRICKS.get());
		this.slab(IcariaBlocks.LOAM_BRICK_DECO.slab.get(), IcariaBlocks.LOAM_BRICKS.get());
		this.stairs(IcariaBlocks.LOAM_BRICK_DECO.stairs.get(), IcariaBlocks.LOAM_BRICKS.get());
		this.wall(IcariaBlocks.LOAM_BRICK_DECO.wall.get(), IcariaBlocks.LOAM_BRICKS.get());

		this.block(IcariaBlocks.DOLOMITE_ADOBE.get());
		this.slab(IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get(), IcariaBlocks.DOLOMITE_ADOBE.get());
		this.stairs(IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get(), IcariaBlocks.DOLOMITE_ADOBE.get());
		this.wall(IcariaBlocks.DOLOMITE_ADOBE_DECO.wall.get(), IcariaBlocks.DOLOMITE_ADOBE.get());
		this.block(IcariaBlocks.SMOOTH_DOLOMITE.get());
		this.slab(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get(), IcariaBlocks.SMOOTH_DOLOMITE.get());
		this.stairs(IcariaBlocks.SMOOTH_DOLOMITE_DECO.stairs.get(), IcariaBlocks.SMOOTH_DOLOMITE.get());
		this.wall(IcariaBlocks.SMOOTH_DOLOMITE_DECO.wall.get(), IcariaBlocks.SMOOTH_DOLOMITE.get());
		this.block(IcariaBlocks.DOLOMITE_BRICKS.get());
		this.axis(IcariaBlocks.DOLOMITE_PILLAR.get());
		this.dolomitePillarHead(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());

		this.block(IcariaBlocks.GRAINEL.get());
		this.block(IcariaBlocks.GRAINEL_CHERT.get());
		this.blockCutout(IcariaBlocks.GRAINGLASS.get());
		this.pane(IcariaBlocks.GRAINGLASS_PANE.get(), IcariaBlocks.GRAINGLASS.get());
		this.horizontalPane(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get(), IcariaBlocks.GRAINGLASS_PANE.get(), IcariaBlocks.GRAINGLASS.get());
		this.block(IcariaBlocks.GRAINITE_ADOBE.get());
		this.slab(IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get(), IcariaBlocks.GRAINITE_ADOBE.get());
		this.stairs(IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE.get());
		this.wall(IcariaBlocks.GRAINITE_ADOBE_DECO.wall.get(), IcariaBlocks.GRAINITE_ADOBE.get());
		this.block(IcariaBlocks.GRAINITE.get());
		this.slab(IcariaBlocks.GRAINITE_DECO.slab.get(), IcariaBlocks.GRAINITE.get());
		this.stairs(IcariaBlocks.GRAINITE_DECO.stairs.get(), IcariaBlocks.GRAINITE.get());
		this.wall(IcariaBlocks.GRAINITE_DECO.wall.get(), IcariaBlocks.GRAINITE.get());
		this.block(IcariaBlocks.GRAINITE_BRICKS.get());
		this.slab(IcariaBlocks.GRAINITE_BRICK_DECO.slab.get(), IcariaBlocks.GRAINITE_BRICKS.get());
		this.stairs(IcariaBlocks.GRAINITE_BRICK_DECO.stairs.get(), IcariaBlocks.GRAINITE_BRICKS.get());
		this.wall(IcariaBlocks.GRAINITE_BRICK_DECO.wall.get(), IcariaBlocks.GRAINITE_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_GRAINITE.get());
		this.rubble(IcariaBlocks.GRAINITE_RUBBLE.get(), IcariaBlocks.GRAINITE.get());

		this.block(IcariaBlocks.YELLOWSTONE_ADOBE.get());
		this.slab(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get());
		this.stairs(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get());
		this.wall(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.wall.get(), IcariaBlocks.YELLOWSTONE_ADOBE.get());
		this.block(IcariaBlocks.COBBLED_YELLOWSTONE.get());
		this.slab(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.slab.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get());
		this.stairs(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.stairs.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get());
		this.wall(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.wall.get(), IcariaBlocks.COBBLED_YELLOWSTONE.get());
		this.block(IcariaBlocks.YELLOWSTONE.get());
		this.slab(IcariaBlocks.YELLOWSTONE_DECO.slab.get(), IcariaBlocks.YELLOWSTONE.get());
		this.stairs(IcariaBlocks.YELLOWSTONE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE.get());
		this.wall(IcariaBlocks.YELLOWSTONE_DECO.wall.get(), IcariaBlocks.YELLOWSTONE.get());
		this.block(IcariaBlocks.YELLOWSTONE_BRICKS.get());
		this.slab(IcariaBlocks.YELLOWSTONE_BRICK_DECO.slab.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.YELLOWSTONE_BRICK_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get());
		this.wall(IcariaBlocks.YELLOWSTONE_BRICK_DECO.wall.get(), IcariaBlocks.YELLOWSTONE_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_YELLOWSTONE.get());
		this.rubble(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), IcariaBlocks.YELLOWSTONE.get());

		this.block(IcariaBlocks.SILKSAND.get());
		this.blockCutout(IcariaBlocks.SILKGLASS.get());
		this.pane(IcariaBlocks.SILKGLASS_PANE.get(), IcariaBlocks.SILKGLASS.get());
		this.horizontalPane(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get(), IcariaBlocks.SILKGLASS_PANE.get(), IcariaBlocks.SILKGLASS.get());
		this.block(IcariaBlocks.SILKSTONE_ADOBE.get());
		this.slab(IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get(), IcariaBlocks.SILKSTONE_ADOBE.get());
		this.stairs(IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SILKSTONE_ADOBE.get());
		this.wall(IcariaBlocks.SILKSTONE_ADOBE_DECO.wall.get(), IcariaBlocks.SILKSTONE_ADOBE.get());
		this.block(IcariaBlocks.COBBLED_SILKSTONE.get());
		this.slab(IcariaBlocks.COBBLED_SILKSTONE_DECO.slab.get(), IcariaBlocks.COBBLED_SILKSTONE.get());
		this.stairs(IcariaBlocks.COBBLED_SILKSTONE_DECO.stairs.get(), IcariaBlocks.COBBLED_SILKSTONE.get());
		this.wall(IcariaBlocks.COBBLED_SILKSTONE_DECO.wall.get(), IcariaBlocks.COBBLED_SILKSTONE.get());
		this.block(IcariaBlocks.SILKSTONE.get());
		this.slab(IcariaBlocks.SILKSTONE_DECO.slab.get(), IcariaBlocks.SILKSTONE.get());
		this.stairs(IcariaBlocks.SILKSTONE_DECO.stairs.get(), IcariaBlocks.SILKSTONE.get());
		this.wall(IcariaBlocks.SILKSTONE_DECO.wall.get(), IcariaBlocks.SILKSTONE.get());
		this.block(IcariaBlocks.SILKSTONE_BRICKS.get());
		this.slab(IcariaBlocks.SILKSTONE_BRICK_DECO.slab.get(), IcariaBlocks.SILKSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.SILKSTONE_BRICK_DECO.stairs.get(), IcariaBlocks.SILKSTONE_BRICKS.get());
		this.wall(IcariaBlocks.SILKSTONE_BRICK_DECO.wall.get(), IcariaBlocks.SILKSTONE_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_SILKSTONE.get());
		this.rubble(IcariaBlocks.SILKSTONE_RUBBLE.get(), IcariaBlocks.SILKSTONE.get());

		this.block(IcariaBlocks.SUNSTONE_ADOBE.get());
		this.slab(IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get(), IcariaBlocks.SUNSTONE_ADOBE.get());
		this.stairs(IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE.get());
		this.wall(IcariaBlocks.SUNSTONE_ADOBE_DECO.wall.get(), IcariaBlocks.SUNSTONE_ADOBE.get());
		this.block(IcariaBlocks.COBBLED_SUNSTONE.get());
		this.slab(IcariaBlocks.COBBLED_SUNSTONE_DECO.slab.get(), IcariaBlocks.COBBLED_SUNSTONE.get());
		this.stairs(IcariaBlocks.COBBLED_SUNSTONE_DECO.stairs.get(), IcariaBlocks.COBBLED_SUNSTONE.get());
		this.wall(IcariaBlocks.COBBLED_SUNSTONE_DECO.wall.get(), IcariaBlocks.COBBLED_SUNSTONE.get());
		this.block(IcariaBlocks.SUNSTONE.get());
		this.slab(IcariaBlocks.SUNSTONE_DECO.slab.get(), IcariaBlocks.SUNSTONE.get());
		this.stairs(IcariaBlocks.SUNSTONE_DECO.stairs.get(), IcariaBlocks.SUNSTONE.get());
		this.wall(IcariaBlocks.SUNSTONE_DECO.wall.get(), IcariaBlocks.SUNSTONE.get());
		this.block(IcariaBlocks.SUNSTONE_BRICKS.get());
		this.slab(IcariaBlocks.SUNSTONE_BRICK_DECO.slab.get(), IcariaBlocks.SUNSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.SUNSTONE_BRICK_DECO.stairs.get(), IcariaBlocks.SUNSTONE_BRICKS.get());
		this.wall(IcariaBlocks.SUNSTONE_BRICK_DECO.wall.get(), IcariaBlocks.SUNSTONE_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_SUNSTONE.get());
		this.rubble(IcariaBlocks.SUNSTONE_RUBBLE.get(), IcariaBlocks.SUNSTONE.get());

		this.block(IcariaBlocks.VOIDSHALE_ADOBE.get());
		this.slab(IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get(), IcariaBlocks.VOIDSHALE_ADOBE.get());
		this.stairs(IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE.get());
		this.wall(IcariaBlocks.VOIDSHALE_ADOBE_DECO.wall.get(), IcariaBlocks.VOIDSHALE_ADOBE.get());
		this.block(IcariaBlocks.COBBLED_VOIDSHALE.get());
		this.slab(IcariaBlocks.COBBLED_VOIDSHALE_DECO.slab.get(), IcariaBlocks.COBBLED_VOIDSHALE.get());
		this.stairs(IcariaBlocks.COBBLED_VOIDSHALE_DECO.stairs.get(), IcariaBlocks.COBBLED_VOIDSHALE.get());
		this.wall(IcariaBlocks.COBBLED_VOIDSHALE_DECO.wall.get(), IcariaBlocks.COBBLED_VOIDSHALE.get());
		this.block(IcariaBlocks.VOIDSHALE.get());
		this.slab(IcariaBlocks.VOIDSHALE_DECO.slab.get(), IcariaBlocks.VOIDSHALE.get());
		this.stairs(IcariaBlocks.VOIDSHALE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE.get());
		this.wall(IcariaBlocks.VOIDSHALE_DECO.wall.get(), IcariaBlocks.VOIDSHALE.get());
		this.block(IcariaBlocks.VOIDSHALE_BRICKS.get());
		this.slab(IcariaBlocks.VOIDSHALE_BRICK_DECO.slab.get(), IcariaBlocks.VOIDSHALE_BRICKS.get());
		this.stairs(IcariaBlocks.VOIDSHALE_BRICK_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_BRICKS.get());
		this.wall(IcariaBlocks.VOIDSHALE_BRICK_DECO.wall.get(), IcariaBlocks.VOIDSHALE_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_VOIDSHALE.get());
		this.rubble(IcariaBlocks.VOIDSHALE_RUBBLE.get(), IcariaBlocks.VOIDSHALE.get());

		this.block(IcariaBlocks.BAETYL_ADOBE.get());
		this.slab(IcariaBlocks.BAETYL_ADOBE_DECO.slab.get(), IcariaBlocks.BAETYL_ADOBE.get());
		this.stairs(IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get(), IcariaBlocks.BAETYL_ADOBE.get());
		this.wall(IcariaBlocks.BAETYL_ADOBE_DECO.wall.get(), IcariaBlocks.BAETYL_ADOBE.get());
		this.block(IcariaBlocks.COBBLED_BAETYL.get());
		this.slab(IcariaBlocks.COBBLED_BAETYL_DECO.slab.get(), IcariaBlocks.COBBLED_BAETYL.get());
		this.stairs(IcariaBlocks.COBBLED_BAETYL_DECO.stairs.get(), IcariaBlocks.COBBLED_BAETYL.get());
		this.wall(IcariaBlocks.COBBLED_BAETYL_DECO.wall.get(), IcariaBlocks.COBBLED_BAETYL.get());
		this.block(IcariaBlocks.BAETYL.get());
		this.slab(IcariaBlocks.BAETYL_DECO.slab.get(), IcariaBlocks.BAETYL.get());
		this.stairs(IcariaBlocks.BAETYL_DECO.stairs.get(), IcariaBlocks.BAETYL.get());
		this.wall(IcariaBlocks.BAETYL_DECO.wall.get(), IcariaBlocks.BAETYL.get());
		this.block(IcariaBlocks.BAETYL_BRICKS.get());
		this.slab(IcariaBlocks.BAETYL_BRICK_DECO.slab.get(), IcariaBlocks.BAETYL_BRICKS.get());
		this.stairs(IcariaBlocks.BAETYL_BRICK_DECO.stairs.get(), IcariaBlocks.BAETYL_BRICKS.get());
		this.wall(IcariaBlocks.BAETYL_BRICK_DECO.wall.get(), IcariaBlocks.BAETYL_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_BAETYL.get());
		this.rubble(IcariaBlocks.BAETYL_RUBBLE.get(), IcariaBlocks.BAETYL.get());

		this.block(IcariaBlocks.RELICSTONE.get());
		this.slab(IcariaBlocks.RELICSTONE_DECO.slab.get(), IcariaBlocks.RELICSTONE.get());
		this.stairs(IcariaBlocks.RELICSTONE_DECO.stairs.get(), IcariaBlocks.RELICSTONE.get());
		this.wall(IcariaBlocks.RELICSTONE_DECO.wall.get(), IcariaBlocks.RELICSTONE.get());
		this.block(IcariaBlocks.SMOOTH_RELICSTONE.get());
		this.slab(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get(), IcariaBlocks.SMOOTH_RELICSTONE.get());
		this.stairs(IcariaBlocks.SMOOTH_RELICSTONE_DECO.stairs.get(), IcariaBlocks.SMOOTH_RELICSTONE.get());
		this.wall(IcariaBlocks.SMOOTH_RELICSTONE_DECO.wall.get(), IcariaBlocks.SMOOTH_RELICSTONE.get());
		this.block(IcariaBlocks.RELICSTONE_BRICKS.get());
		this.slab(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get(), IcariaBlocks.RELICSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.RELICSTONE_BRICK_DECO.stairs.get(), IcariaBlocks.RELICSTONE_BRICKS.get());
		this.wall(IcariaBlocks.RELICSTONE_BRICK_DECO.wall.get(), IcariaBlocks.RELICSTONE_BRICKS.get());
		this.block(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get());
		this.slab(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.stairs.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get());
		this.wall(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.wall.get(), IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get());
		this.block(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get());
		this.slab(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get());
		this.stairs(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.stairs.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get());
		this.wall(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.wall.get(), IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get());
		this.block(IcariaBlocks.RELICSTONE_TILES.get());
		this.slab(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get(), IcariaBlocks.RELICSTONE_TILES.get());
		this.stairs(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get(), IcariaBlocks.RELICSTONE_TILES.get());
		this.wall(IcariaBlocks.RELICSTONE_TILE_DECO.wall.get(), IcariaBlocks.RELICSTONE_TILES.get());
		this.block(IcariaBlocks.CRACKED_RELICSTONE_TILES.get());
		this.slab(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get());
		this.stairs(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.stairs.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get());
		this.wall(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.wall.get(), IcariaBlocks.CRACKED_RELICSTONE_TILES.get());
		this.block(IcariaBlocks.MOSSY_RELICSTONE_TILES.get());
		this.slab(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get());
		this.stairs(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.stairs.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get());
		this.wall(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.wall.get(), IcariaBlocks.MOSSY_RELICSTONE_TILES.get());
		this.block(IcariaBlocks.CHISELED_RELICSTONE.get());
		this.axis(IcariaBlocks.RELICSTONE_PILLAR.get());
		this.relicstonePillarHead(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get());
		this.rubble(IcariaBlocks.RELICSTONE_RUBBLE.get(), IcariaBlocks.RELICSTONE.get());

		this.block(IcariaBlocks.PLATOSHALE.get());
		this.slab(IcariaBlocks.PLATOSHALE_DECO.slab.get(), IcariaBlocks.PLATOSHALE.get());
		this.stairs(IcariaBlocks.PLATOSHALE_DECO.stairs.get(), IcariaBlocks.PLATOSHALE.get());
		this.wall(IcariaBlocks.PLATOSHALE_DECO.wall.get(), IcariaBlocks.PLATOSHALE.get());
		this.overlayTextureBlock(IcariaBlocks.BLURRED_PLATOSHALE.get());
		this.block(IcariaBlocks.PLATOSHALE_BRICKS.get());
		this.slab(IcariaBlocks.PLATOSHALE_BRICK_DECO.slab.get(), IcariaBlocks.PLATOSHALE_BRICKS.get());
		this.stairs(IcariaBlocks.PLATOSHALE_BRICK_DECO.stairs.get(), IcariaBlocks.PLATOSHALE_BRICKS.get());
		this.wall(IcariaBlocks.PLATOSHALE_BRICK_DECO.wall.get(), IcariaBlocks.PLATOSHALE_BRICKS.get());
		this.overlayTextureBlock(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get());
		this.block(IcariaBlocks.CHISELED_PLATOSHALE.get());

		this.quartzWall(IcariaBlocks.QUARTZ_WALL.get());
		this.quartzPillarHead(IcariaBlocks.QUARTZ_PILLAR_HEAD.get());

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

		this.calciteCrystal(IcariaBlocks.CALCITE_CRYSTAL.get());
		this.haliteCrystal(IcariaBlocks.HALITE_CRYSTAL.get());
		this.jasperCrystal(IcariaBlocks.JASPER_CRYSTAL.get());
		this.zirconCrystal(IcariaBlocks.ZIRCON_CRYSTAL.get());

		this.blockTranslucent(IcariaBlocks.ARISTONE.get());
		this.block(IcariaBlocks.PACKED_ARISTONE.get());

		this.blockTranslucent(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.blockTranslucent(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.blockTranslucent(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.blockTranslucent(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.blockTranslucent(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.block(IcariaBlocks.ARACHNE_STRING_BLOCK.get());
		this.axis(IcariaBlocks.SPELT_BALE_BLOCK.get());
		this.block(IcariaBlocks.VINE_REED_BLOCK.get());
		this.block(IcariaBlocks.ROTTEN_BONES_BLOCK.get());

		this.block(IcariaBlocks.RAW_CHALKOS_BLOCK.get());
		this.block(IcariaBlocks.RAW_KASSITEROS_BLOCK.get());
		this.block(IcariaBlocks.RAW_VANADIUM_BLOCK.get());
		this.block(IcariaBlocks.RAW_SIDEROS_BLOCK.get());
		this.block(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get());

		this.blockTranslucent(IcariaBlocks.CALCITE_BLOCK.get());
		this.blockTranslucent(IcariaBlocks.HALITE_BLOCK.get());
		this.block(IcariaBlocks.JASPER_BLOCK.get());
		this.blockTranslucent(IcariaBlocks.ZIRCON_BLOCK.get());
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
		this.horizontalBars(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get(), IcariaBlocks.VANADIUMSTEEL_BARS.get());

		this.chain(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());

		this.kettle(IcariaBlocks.KETTLE.get());
		this.grinder(IcariaBlocks.GRINDER.get());
		this.kiln(IcariaBlocks.KILN.get());
		this.forge(IcariaBlocks.FORGE.get());

		this.particle(IcariaBlocks.CHEST.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.particle(IcariaBlocks.TRAPPED_CHEST.get(), IcariaBlocks.LAUREL_PLANKS.get());

		this.storageVase(IcariaBlocks.STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.WHITE_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.GRAY_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.BLACK_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.BROWN_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.RED_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.ORANGE_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.YELLOW_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.LIME_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.GREEN_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.CYAN_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.BLUE_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.PURPLE_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.MAGENTA_STORAGE_VASE.get());
		this.storageVase(IcariaBlocks.PINK_STORAGE_VASE.get());

		this.lootVase(IcariaBlocks.RED_LOOT_VASE.get());
		this.lootVase(IcariaBlocks.LOST_LOOT_VASE.get());
		this.lootVase(IcariaBlocks.CYAN_LOOT_VASE.get());

		this.blockCutout(IcariaBlocks.ARACHNE_SPAWNER.get());
		this.blockCutout(IcariaBlocks.REVENANT_SPAWNER.get());

		this.ligniteTorch(IcariaBlocks.LIGNITE_TORCH.get());
		this.ligniteWallTorch(IcariaBlocks.LIGNITE_WALL_TORCH.get());
		this.anthraciteTorch(IcariaBlocks.ANTHRACITE_TORCH.get());
		this.anthraciteWallTorch(IcariaBlocks.ANTHRACITE_WALL_TORCH.get());

		this.cake(IcariaBlocks.LAUREL_CHERRY_CAKE.get());
		this.cake(IcariaBlocks.STRAWBERRY_CAKE.get());
		this.cake(IcariaBlocks.PHYSALIS_CAKE.get());
		this.cake(IcariaBlocks.VINE_BERRY_CAKE.get());
		this.cake(IcariaBlocks.VINE_SPROUT_CAKE.get());

		this.cross(IcariaBlocks.CYPRESS_SAPLING.get());
		this.flowerPotCross(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), IcariaBlocks.CYPRESS_SAPLING.get());
		this.block(IcariaBlocks.CYPRESS_LEAVES.get());
		this.fallenLeaves(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_LEAVES.get());
		this.twigs(IcariaBlocks.CYPRESS_TWIGS.get());
		this.wood(IcariaBlocks.CYPRESS_WOOD.get(), IcariaBlocks.CYPRESS_LOG.get());
		this.wood(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.axis(IcariaBlocks.CYPRESS_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), IcariaBlocks.STEPPE_MOSS.get());
		this.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.block(IcariaBlocks.CYPRESS_PLANKS.get());
		this.slab(IcariaBlocks.CYPRESS_DECO.slab.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.stairs(IcariaBlocks.CYPRESS_DECO.stairs.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.fence(IcariaBlocks.CYPRESS_DECO.fence.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.gate(IcariaBlocks.CYPRESS_DECO.gate.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.simpleRack(IcariaBlocks.SIMPLE_CYPRESS_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.LOADED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.rack(IcariaBlocks.CYPRESS_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.LOADED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.barrel(IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.loadedBarrel(IcariaBlocks.LOADED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.tappedBarrel(IcariaBlocks.TAPPED_CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(), IcariaBlocks.CYPRESS_BARREL.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.trough(IcariaBlocks.CYPRESS_TROUGH.get(), IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.craftingTable(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.door(IcariaBlocks.CYPRESS_DOOR.get());
		this.trapdoor(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		this.ladder(IcariaBlocks.CYPRESS_LADDER.get());
		this.particle(IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.particle(IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaBlocks.CYPRESS_PLANKS.get());
		this.particle(IcariaBlocks.CYPRESS_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.particle(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get());

		this.cross(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.flowerPotCross(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.block(IcariaBlocks.DROUGHTROOT_LEAVES.get());
		this.fallenLeaves(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_LEAVES.get());
		this.twigs(IcariaBlocks.DROUGHTROOT_TWIGS.get());
		this.wood(IcariaBlocks.DROUGHTROOT_WOOD.get(), IcariaBlocks.DROUGHTROOT_LOG.get());
		this.wood(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.axis(IcariaBlocks.DROUGHTROOT_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.deadDroughtrootLog(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.block(IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.slab(IcariaBlocks.DROUGHTROOT_DECO.slab.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.stairs(IcariaBlocks.DROUGHTROOT_DECO.stairs.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.fence(IcariaBlocks.DROUGHTROOT_DECO.fence.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.gate(IcariaBlocks.DROUGHTROOT_DECO.gate.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.simpleRack(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.rack(IcariaBlocks.DROUGHTROOT_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.barrel(IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.loadedBarrel(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.tappedBarrel(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get(), IcariaBlocks.DROUGHTROOT_BARREL.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.trough(IcariaBlocks.DROUGHTROOT_TROUGH.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.craftingTable(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.door(IcariaBlocks.DROUGHTROOT_DOOR.get());
		this.trapdoor(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		this.ladder(IcariaBlocks.DROUGHTROOT_LADDER.get());
		this.particle(IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.particle(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaBlocks.DROUGHTROOT_PLANKS.get());
		this.particle(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.particle(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());

		this.cross(IcariaBlocks.FIR_SAPLING.get());
		this.flowerPotCross(IcariaBlocks.POTTED_FIR_SAPLING.get(), IcariaBlocks.FIR_SAPLING.get());
		this.block(IcariaBlocks.FIR_LEAVES.get());
		this.fallenLeaves(IcariaBlocks.FALLEN_FIR_LEAVES.get(), IcariaBlocks.FIR_LEAVES.get());
		this.twigs(IcariaBlocks.FIR_TWIGS.get());
		this.wood(IcariaBlocks.FIR_WOOD.get(), IcariaBlocks.FIR_LOG.get());
		this.wood(IcariaBlocks.STRIPPED_FIR_WOOD.get(), IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.axis(IcariaBlocks.FIR_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_FIR_LOG.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.STRIPPED_FIR_LOG.get(), IcariaBlocks.FOREST_MOSS.get());
		this.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.block(IcariaBlocks.FIR_PLANKS.get());
		this.slab(IcariaBlocks.FIR_DECO.slab.get(), IcariaBlocks.FIR_PLANKS.get());
		this.stairs(IcariaBlocks.FIR_DECO.stairs.get(), IcariaBlocks.FIR_PLANKS.get());
		this.fence(IcariaBlocks.FIR_DECO.fence.get(), IcariaBlocks.FIR_PLANKS.get());
		this.gate(IcariaBlocks.FIR_DECO.gate.get(), IcariaBlocks.FIR_PLANKS.get());
		this.simpleRack(IcariaBlocks.SIMPLE_FIR_RACK.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.LOADED_FIR_BARREL.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get());
		this.rack(IcariaBlocks.FIR_RACK.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.LOADED_FIR_BARREL.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get());
		this.barrel(IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_PLANKS.get());
		this.loadedBarrel(IcariaBlocks.LOADED_FIR_BARREL.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_PLANKS.get());
		this.tappedBarrel(IcariaBlocks.TAPPED_FIR_BARREL.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_PLANKS.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get(), IcariaBlocks.FIR_BARREL.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get());
		this.trough(IcariaBlocks.FIR_TROUGH.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FIR_PLANKS.get());
		this.craftingTable(IcariaBlocks.FIR_CRAFTING_TABLE.get(), IcariaBlocks.FIR_PLANKS.get());
		this.door(IcariaBlocks.FIR_DOOR.get());
		this.trapdoor(IcariaBlocks.FIR_TRAPDOOR.get());
		this.ladder(IcariaBlocks.FIR_LADDER.get());
		this.particle(IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_PLANKS.get());
		this.particle(IcariaBlocks.FIR_WALL_SIGN.get(), IcariaBlocks.FIR_PLANKS.get());
		this.particle(IcariaBlocks.FIR_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.particle(IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_FIR_LOG.get());

		this.cross(IcariaBlocks.LAUREL_SAPLING.get());
		this.flowerPotCross(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), IcariaBlocks.LAUREL_SAPLING.get());
		this.block(IcariaBlocks.LAUREL_LEAVES.get());
		this.fallenLeaves(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_LEAVES.get());
		this.twigs(IcariaBlocks.LAUREL_TWIGS.get());
		this.wood(IcariaBlocks.LAUREL_WOOD.get(), IcariaBlocks.LAUREL_LOG.get());
		this.wood(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.axis(IcariaBlocks.LAUREL_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get(), IcariaBlocks.SCRUBLAND_MOSS.get());
		this.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.block(IcariaBlocks.LAUREL_PLANKS.get());
		this.slab(IcariaBlocks.LAUREL_DECO.slab.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.stairs(IcariaBlocks.LAUREL_DECO.stairs.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.fence(IcariaBlocks.LAUREL_DECO.fence.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.gate(IcariaBlocks.LAUREL_DECO.gate.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.simpleRack(IcariaBlocks.SIMPLE_LAUREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LOADED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.rack(IcariaBlocks.LAUREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LOADED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.barrel(IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.loadedBarrel(IcariaBlocks.LOADED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.tappedBarrel(IcariaBlocks.TAPPED_LAUREL_BARREL.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), IcariaBlocks.LAUREL_BARREL.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.trough(IcariaBlocks.LAUREL_TROUGH.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.craftingTable(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.door(IcariaBlocks.LAUREL_DOOR.get());
		this.trapdoor(IcariaBlocks.LAUREL_TRAPDOOR.get());
		this.ladder(IcariaBlocks.LAUREL_LADDER.get());
		this.particle(IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.particle(IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaBlocks.LAUREL_PLANKS.get());
		this.particle(IcariaBlocks.LAUREL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.particle(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get());

		this.cross(IcariaBlocks.OLIVE_SAPLING.get());
		this.flowerPotCross(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), IcariaBlocks.OLIVE_SAPLING.get());
		this.oliveLeaves(IcariaBlocks.OLIVE_LEAVES.get());
		this.fallenLeaves(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_LEAVES.get());
		this.twigs(IcariaBlocks.OLIVE_TWIGS.get());
		this.wood(IcariaBlocks.OLIVE_WOOD.get(), IcariaBlocks.OLIVE_LOG.get());
		this.wood(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.axis(IcariaBlocks.OLIVE_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_OLIVE_LOG.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get(), IcariaBlocks.STEPPE_MOSS.get());
		this.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.block(IcariaBlocks.OLIVE_PLANKS.get());
		this.slab(IcariaBlocks.OLIVE_DECO.slab.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.stairs(IcariaBlocks.OLIVE_DECO.stairs.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.fence(IcariaBlocks.OLIVE_DECO.fence.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.gate(IcariaBlocks.OLIVE_DECO.gate.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.simpleRack(IcariaBlocks.SIMPLE_OLIVE_RACK.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.LOADED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.rack(IcariaBlocks.OLIVE_RACK.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.LOADED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.barrel(IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.loadedBarrel(IcariaBlocks.LOADED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.tappedBarrel(IcariaBlocks.TAPPED_OLIVE_BARREL.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get(), IcariaBlocks.OLIVE_BARREL.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.trough(IcariaBlocks.OLIVE_TROUGH.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.craftingTable(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.door(IcariaBlocks.OLIVE_DOOR.get());
		this.trapdoor(IcariaBlocks.OLIVE_TRAPDOOR.get());
		this.ladder(IcariaBlocks.OLIVE_LADDER.get());
		this.particle(IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.particle(IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaBlocks.OLIVE_PLANKS.get());
		this.particle(IcariaBlocks.OLIVE_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.particle(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get());

		this.cross(IcariaBlocks.PLANE_SAPLING.get());
		this.flowerPotCross(IcariaBlocks.POTTED_PLANE_SAPLING.get(), IcariaBlocks.PLANE_SAPLING.get());
		this.block(IcariaBlocks.PLANE_LEAVES.get());
		this.fallenLeaves(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), IcariaBlocks.PLANE_LEAVES.get());
		this.twigs(IcariaBlocks.PLANE_TWIGS.get());
		this.wood(IcariaBlocks.PLANE_WOOD.get(), IcariaBlocks.PLANE_LOG.get());
		this.wood(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.axis(IcariaBlocks.PLANE_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get(), IcariaBlocks.SCRUBLAND_MOSS.get());
		this.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.block(IcariaBlocks.PLANE_PLANKS.get());
		this.slab(IcariaBlocks.PLANE_DECO.slab.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.stairs(IcariaBlocks.PLANE_DECO.stairs.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.fence(IcariaBlocks.PLANE_DECO.fence.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.gate(IcariaBlocks.PLANE_DECO.gate.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.simpleRack(IcariaBlocks.SIMPLE_PLANE_RACK.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.LOADED_PLANE_BARREL.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.rack(IcariaBlocks.PLANE_RACK.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.LOADED_PLANE_BARREL.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.barrel(IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.loadedBarrel(IcariaBlocks.LOADED_PLANE_BARREL.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.tappedBarrel(IcariaBlocks.TAPPED_PLANE_BARREL.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get(), IcariaBlocks.PLANE_BARREL.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.trough(IcariaBlocks.PLANE_TROUGH.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.craftingTable(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.door(IcariaBlocks.PLANE_DOOR.get());
		this.trapdoor(IcariaBlocks.PLANE_TRAPDOOR.get());
		this.ladder(IcariaBlocks.PLANE_LADDER.get());
		this.particle(IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.particle(IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaBlocks.PLANE_PLANKS.get());
		this.particle(IcariaBlocks.PLANE_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.particle(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get());

		this.cross(IcariaBlocks.POPULUS_SAPLING.get());
		this.flowerPotCross(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), IcariaBlocks.POPULUS_SAPLING.get());
		this.block(IcariaBlocks.POPULUS_LEAVES.get());
		this.fallenLeaves(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), IcariaBlocks.POPULUS_LEAVES.get());
		this.twigs(IcariaBlocks.POPULUS_TWIGS.get());
		this.wood(IcariaBlocks.POPULUS_WOOD.get(), IcariaBlocks.POPULUS_LOG.get());
		this.wood(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.axis(IcariaBlocks.POPULUS_LOG.get());
		this.axis(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.deadLog(IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get(), IcariaBlocks.FOREST_MOSS.get());
		this.strippedDeadLog(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.block(IcariaBlocks.POPULUS_PLANKS.get());
		this.slab(IcariaBlocks.POPULUS_DECO.slab.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.stairs(IcariaBlocks.POPULUS_DECO.stairs.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.fence(IcariaBlocks.POPULUS_DECO.fence.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.gate(IcariaBlocks.POPULUS_DECO.gate.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.simpleRack(IcariaBlocks.SIMPLE_POPULUS_RACK.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.LOADED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.rack(IcariaBlocks.POPULUS_RACK.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.LOADED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.barrel(IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.loadedBarrel(IcariaBlocks.LOADED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.tappedBarrel(IcariaBlocks.TAPPED_POPULUS_BARREL.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.tripleBarrelRack(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get(), IcariaBlocks.POPULUS_BARREL.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.trough(IcariaBlocks.POPULUS_TROUGH.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.craftingTable(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.door(IcariaBlocks.POPULUS_DOOR.get());
		this.trapdoor(IcariaBlocks.POPULUS_TRAPDOOR.get());
		this.ladder(IcariaBlocks.POPULUS_LADDER.get());
		this.particle(IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.particle(IcariaBlocks.POPULUS_WALL_SIGN.get(), IcariaBlocks.POPULUS_PLANKS.get());
		this.particle(IcariaBlocks.POPULUS_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.particle(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get());

		this.bloomyVine(IcariaBlocks.BLOOMY_VINE.get());
		this.vineWithOverlayTexture(IcariaBlocks.BRANCHY_VINE.get());
		this.brushyVine(IcariaBlocks.BRUSHY_VINE.get());
		this.vine(IcariaBlocks.DRY_VINE.get());
		this.vineWithOverlayTexture(IcariaBlocks.REEDY_VINE.get());
		this.vine(IcariaBlocks.SWIRLY_VINE.get());
		this.vine(IcariaBlocks.THORNY_VINE.get());

		this.tintedCross(IcariaBlocks.FERN.get());
		this.tintedFlowerPotCross(IcariaBlocks.POTTED_FERN.get(), IcariaBlocks.FERN.get());

		this.tintedCross(IcariaBlocks.SMALL_GRASS.get());
		this.tintedCross(IcariaBlocks.MEDIUM_GRASS.get());
		this.tintedCross(IcariaBlocks.LARGE_GRASS.get());

		this.overlayTextureCrossModel(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		this.overlayTextureCrossModel(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		this.overlayTextureCrossModel(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		this.overlayTextureCrossModel(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		this.overlayTextureCrossModel(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		this.overlayTextureCrossModel(IcariaBlocks.LARGE_BROWN_GRAIN.get());

		this.overlayTextureCrossModel(IcariaBlocks.BLINDWEED.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_BLINDWEED.get(), IcariaBlocks.BLINDWEED.get());
		this.overlayTextureCrossModel(IcariaBlocks.CHAMEOMILE.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_CHAMEOMILE.get(), IcariaBlocks.CHAMEOMILE.get());
		this.overlayTextureCrossModel(IcariaBlocks.CHARMONDER.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_CHARMONDER.get(), IcariaBlocks.CHARMONDER.get());
		this.overlayTextureCrossModel(IcariaBlocks.CLOVER.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_CLOVER.get(), IcariaBlocks.CLOVER.get());
		this.overlayTextureCrossModel(IcariaBlocks.FIREHILT.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_FIREHILT.get(), IcariaBlocks.FIREHILT.get());
		this.overlayTextureCrossModel(IcariaBlocks.BLUE_HYDRACINTH.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), IcariaBlocks.BLUE_HYDRACINTH.get());
		this.overlayTextureCrossModel(IcariaBlocks.PURPLE_HYDRACINTH.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), IcariaBlocks.PURPLE_HYDRACINTH.get());
		this.overlayTextureCrossModel(IcariaBlocks.LIONFANGS.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_LIONFANGS.get(), IcariaBlocks.LIONFANGS.get());
		this.overlayTextureCrossModel(IcariaBlocks.SPEARDROPS.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_SPEARDROPS.get(), IcariaBlocks.SPEARDROPS.get());
		this.overlayTextureCrossModel(IcariaBlocks.PURPLE_STAGHORN.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), IcariaBlocks.PURPLE_STAGHORN.get());
		this.overlayTextureCrossModel(IcariaBlocks.YELLOW_STAGHORN.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), IcariaBlocks.YELLOW_STAGHORN.get());
		this.overlayTextureCrossModel(IcariaBlocks.BLUE_STORMCOTTON.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), IcariaBlocks.BLUE_STORMCOTTON.get());
		this.overlayTextureCrossModel(IcariaBlocks.PINK_STORMCOTTON.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), IcariaBlocks.PINK_STORMCOTTON.get());
		this.overlayTextureCrossModel(IcariaBlocks.PURPLE_STORMCOTTON.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), IcariaBlocks.PURPLE_STORMCOTTON.get());
		this.overlayTextureCrossModel(IcariaBlocks.SUNKETTLE.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_SUNKETTLE.get(), IcariaBlocks.SUNKETTLE.get());
		this.overlayTextureCrossModel(IcariaBlocks.SUNSPONGE.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_SUNSPONGE.get(), IcariaBlocks.SUNSPONGE.get());
		this.overlayTextureCrossModel(IcariaBlocks.VOIDLILY.get());
		this.overlayTextureFlowerPotCrossModel(IcariaBlocks.POTTED_VOIDLILY.get(), IcariaBlocks.VOIDLILY.get());

		this.bolbos(IcariaBlocks.BOLBOS.get());
		this.dathulla(IcariaBlocks.DATHULLA.get());
		this.mondanos(IcariaBlocks.MONDANOS.get());
		this.mothAgaric(IcariaBlocks.MOTH_AGARIC.get());
		this.namdrake(IcariaBlocks.NAMDRAKE.get());
		this.psilocybos(IcariaBlocks.PSILOCYBOS.get());
		this.rowan(IcariaBlocks.ROWAN.get());
		this.wiltedElm(IcariaBlocks.WILTED_ELM.get());

		this.groundFlower(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		this.groundFlower(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		this.groundFlower(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		this.groundFlower(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		this.groundFlower(IcariaBlocks.RED_GROUND_FLOWERS.get());
		this.groundFlower(IcariaBlocks.WHITE_GROUND_FLOWERS.get());

		this.moss(IcariaBlocks.FOREST_MOSS.get());
		this.moss(IcariaBlocks.SCRUBLAND_MOSS.get());
		this.moss(IcariaBlocks.STEPPE_MOSS.get());

		this.palmFern(IcariaBlocks.PALM_FERN.get());
		this.pottedPalmFern(IcariaBlocks.POTTED_PALM_FERN.get(), IcariaBlocks.PALM_FERN.get());

		this.bromelia(IcariaBlocks.WHITE_BROMELIA.get());
		this.pottedBromelia(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), IcariaBlocks.WHITE_BROMELIA.get());
		this.bromelia(IcariaBlocks.ORANGE_BROMELIA.get());
		this.pottedBromelia(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), IcariaBlocks.ORANGE_BROMELIA.get());
		this.bromelia(IcariaBlocks.PINK_BROMELIA.get());
		this.pottedBromelia(IcariaBlocks.POTTED_PINK_BROMELIA.get(), IcariaBlocks.PINK_BROMELIA.get());
		this.bromelia(IcariaBlocks.PURPLE_BROMELIA.get());
		this.pottedBromelia(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), IcariaBlocks.PURPLE_BROMELIA.get());

		this.greenGroundShrooms(IcariaBlocks.GREEN_GROUND_SHROOMS.get());
		this.pottedGreenGroundShrooms(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get(), IcariaBlocks.GREEN_GROUND_SHROOMS.get());
		this.brownGroundShrooms(IcariaBlocks.BROWN_GROUND_SHROOMS.get());
		this.pottedBrownGroundShrooms(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get(), IcariaBlocks.BROWN_GROUND_SHROOMS.get());
		this.largeBrownGroundShrooms(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get());
		this.pottedLargeBrownGroundShrooms(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get(), IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get());

		this.tinderFungusTreeShrooms(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get());
		this.turkeyTailTreeShrooms(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get());
		this.unnamedTreeShrooms(IcariaBlocks.UNNAMED_TREE_SHROOMS.get());

		this.cardonCactus(IcariaBlocks.CARDON_CACTUS.get());
		this.pottedCardonCactus(IcariaBlocks.POTTED_CARDON_CACTUS.get(), IcariaBlocks.CARDON_CACTUS.get());

		this.strawberryBush(IcariaBlocks.STRAWBERRY_BUSH.get());

		this.crop(IcariaBlocks.SPELT_CROP.get());
		this.strawberryCrop(IcariaBlocks.STRAWBERRY_CROP.get());
		this.physalisCrop(IcariaBlocks.PHYSALIS_CROP.get());
		this.crop(IcariaBlocks.ONION_CROP.get());

		this.water(IcariaBlocks.MEDITERRANEAN_WATER.get());

		this.fire(IcariaBlocks.GREEK_FIRE.get());

		this.portal(IcariaBlocks.ICARIA_PORTAL.get());

		this.grinderShaft(IcariaBlocks.GRINDER_SHAFT.get());
		this.grinderStone(IcariaBlocks.GRINDER_STONE.get());
	}

	public void registerTemplate() {
		this.registerSurfaceChert();
		this.registerSurfaceBones();
		this.registerRubble();
		this.registerPaneInventory();
		this.registerHorizontalPane();
		this.registerOverlayTextureBlock();
		this.registerCalciteCrystal();
		this.registerHaliteCrystal();
		this.registerJasperCrystal();
		this.registerZirconCrystal();
		this.registerBarsInventory();
		this.registerHorizontalBars();
		this.registerKettleInventory();
		this.registerKettle();
		this.registerGrinderInventory();
		this.registerGrinder();
		this.registerKilnInventory();
		this.registerKiln();
		this.registerForgeInventory();
		this.registerForge();
		this.registerStorageVase();
		this.registerLootVase();
		this.registerLigniteTorch();
		this.registerLigniteWallTorch();
		this.registerAnthraciteTorch();
		this.registerAnthraciteWallTorch();
		this.registerCake();
		this.registerLayer();
		this.registerTwigs();
		this.registerDeadLog();
		this.registerStrippedDeadLog();
		this.registerSimpleRack();
		this.registerRack();
		this.registerBarrel();
		this.registerTappedBarrel();
		this.registerTripleBarrelRackInventory();
		this.registerTripleBarrelRack();
		this.registerTrough();
		this.registerOverlayTextureVine();
		this.registerDeadVine();
		this.registerOverlayTextureCross();
		this.registerOverlayTextureFlowerPotCross();
		this.registerBolbos();
		this.registerDathulla();
		this.registerMondanos();
		this.registerMothAgaric();
		this.registerNamdrake();
		this.registerPsilocybos();
		this.registerRowan();
		this.registerWiltedElm();
		this.registerGroundFlower();
		this.registerPalmFern();
		this.registerPottedPalmFern();
		this.registerBromelia();
		this.registerPottedBromelia();
		this.registerGreenGroundShrooms();
		this.registerPottedGreenGroundShrooms();
		this.registerBrownGroundShrooms();
		this.registerPottedBrownGroundShrooms();
		this.registerLargeBrownGroundShrooms();
		this.registerPottedLargeBrownGroundShrooms();
		this.registerTinderFungusTreeShrooms();
		this.registerTurkeyTailTreeShrooms();
		this.registerUnnamedTreeShrooms();
		this.registerCardonCactusInventory();
		this.registerCardonCactus();
		this.registerPottedCardonCactus();
		this.registerStrawberryBush();
		this.registerPhysalisCrop();
		this.registerPortal();
		this.registerGrinderShaft();
		this.registerGrinderStone();
	}

	public void registerSurfaceChert() {
		SurfaceChertModel.template(this.getBuilder("template_surface_chert"), this.getVanilla("block"));
	}

	public void registerSurfaceBones() {
		SurfaceBonesModel.template(this.getBuilder("template_surface_bones"), this.getVanilla("block"));
	}

	public void registerRubble() {
		RubbleModel.template0(this.getBuilder("template_rubble_0"), this.getVanilla("block"));
		RubbleModel.template1(this.getBuilder("template_rubble_1"), this.getVanilla("block"));
		RubbleModel.template2(this.getBuilder("template_rubble_2"), this.getVanilla("block"));
		RubbleModel.template3(this.getBuilder("template_rubble_3"), this.getVanilla("block"));
		RubbleModel.template4(this.getBuilder("template_rubble_4"), this.getVanilla("block"));
	}

	public void registerPaneInventory() {
		PaneInventoryModel.template(this.getBuilder("template_pane_inventory"), this.getVanilla("block"));
	}

	public void registerHorizontalPane() {
		HorizontalPaneModel.template(this.getBuilder("template_horizontal_pane"), this.getVanilla("block"));
	}

	public void registerOverlayTextureBlock() {
		OverlayTextureBlockModel.template(this.getBuilder("template_overlay_texture_block"), this.getVanilla("block"));
	}

	public void registerCalciteCrystal() {
		CalciteCrystalModel.template(this.getBuilder("template_calcite_crystal"), this.getVanilla("block"));
	}

	public void registerHaliteCrystal() {
		HaliteCrystalModel.template(this.getBuilder("template_halite_crystal"), this.getVanilla("block"));
	}

	public void registerJasperCrystal() {
		JasperCrystalModel.template(this.getBuilder("template_jasper_crystal"), this.getVanilla("block"));
	}

	public void registerZirconCrystal() {
		ZirconCrystalModel.template(this.getBuilder("template_zircon_crystal"), this.getVanilla("block"));
	}

	public void registerBarsInventory() {
		BarsInventoryModel.template(this.getBuilder("template_bars_inventory"), this.getVanilla("block"));
	}

	public void registerHorizontalBars() {
		HorizontalBarsModel.template(this.getBuilder("template_horizontal_bars"), this.getVanilla("block"));
	}

	public void registerKettleInventory() {
		KettleInventoryModel.template(this.getBuilder("template_kettle_inventory"), this.getVanilla("block"));
	}

	public void registerKettle() {
		KettleModel.lowerSolid(this.getBuilder("template_kettle_lower_solid"), this.getVanilla("block"));
		KettleModel.lowerSolidLit(this.getBuilder("template_kettle_lower_solid_lit"), this.getVanilla("block"));
		KettleModel.lowerGlass(this.getBuilder("template_kettle_lower_glass"), this.getVanilla("block"));
		KettleModel.upperSolid(this.getBuilder("template_kettle_upper_solid"), this.getVanilla("block"));
		KettleModel.upperGlass(this.getBuilder("template_kettle_upper_glass"), this.getVanilla("block"));
	}

	public void registerGrinderInventory() {
		GrinderInventoryModel.template(this.getBuilder("template_grinder_inventory"), this.getVanilla("block"));
	}

	public void registerGrinder() {
		GrinderModel.left(this.getBuilder("template_grinder_left"), this.getVanilla("block"));
		GrinderModel.right(this.getBuilder("template_grinder_right"), this.getVanilla("block"));
	}

	public void registerKilnInventory() {
		KilnInventoryModel.template(this.getBuilder("template_kiln_inventory"), this.getVanilla("block"));
	}

	public void registerKiln() {
		KilnModel.lower(this.getBuilder("template_kiln_lower"), this.getVanilla("block"));
		KilnModel.upper(this.getBuilder("template_kiln_upper"), this.getVanilla("block"));
	}

	public void registerForgeInventory() {
		ForgeInventoryModel.template(this.getBuilder("template_forge_inventory"), this.getVanilla("block"));
	}

	public void registerForge() {
		ForgeModel.bottomBackLeft(this.getBuilder("template_forge_bottom_back_left"), this.getVanilla("block"));
		ForgeModel.bottomBackRight(this.getBuilder("template_forge_bottom_back_right"), this.getVanilla("block"));
		ForgeModel.bottomFrontLeft(this.getBuilder("template_forge_bottom_front_left"), this.getVanilla("block"));
		ForgeModel.bottomFrontRight(this.getBuilder("template_forge_bottom_front_right"), this.getVanilla("block"));
		ForgeModel.bottomFrontRightLit(this.getBuilder("template_forge_bottom_front_right_lit"), this.getVanilla("block"));
		ForgeModel.topBackLeft(this.getBuilder("template_forge_top_back_left"), this.getVanilla("block"));
		ForgeModel.topBackRight(this.getBuilder("template_forge_top_back_right"), this.getVanilla("block"));
		ForgeModel.topFrontLeft(this.getBuilder("template_forge_top_front_left"), this.getVanilla("block"));
		ForgeModel.topFrontRight(this.getBuilder("template_forge_top_front_right"), this.getVanilla("block"));
	}

	public void registerStorageVase() {
		StorageVaseModel.template(this.getBuilder("template_storage_vase"), this.getVanilla("block"));
	}

	public void registerLootVase() {
		LootVaseModel.template0(this.getBuilder("template_loot_vase_0"), this.getVanilla("block"));
		LootVaseModel.template1(this.getBuilder("template_loot_vase_1"), this.getVanilla("block"));
		LootVaseModel.template2(this.getBuilder("template_loot_vase_2"), this.getVanilla("block"));
		LootVaseModel.template3(this.getBuilder("template_loot_vase_3"), this.getVanilla("block"));
		LootVaseModel.template4(this.getBuilder("template_loot_vase_4"), this.getVanilla("block"));
		LootVaseModel.template5(this.getBuilder("template_loot_vase_5"), this.getVanilla("block"));
		LootVaseModel.template6(this.getBuilder("template_loot_vase_6"), this.getVanilla("block"));
		LootVaseModel.template7(this.getBuilder("template_loot_vase_7"), this.getVanilla("block"));
		LootVaseModel.template8(this.getBuilder("template_loot_vase_8"), this.getVanilla("block"));
		LootVaseModel.template9(this.getBuilder("template_loot_vase_9"), this.getVanilla("block"));
	}

	public void registerLigniteTorch() {
		LigniteTorchModel.template(this.getBuilder("template_lignite_torch"), this.getVanilla("block"));
	}

	public void registerLigniteWallTorch() {
		LigniteWallTorchModel.template(this.getBuilder("template_lignite_wall_torch"), this.getVanilla("block"));
	}

	public void registerAnthraciteTorch() {
		AnthraciteTorchModel.template(this.getBuilder("template_anthracite_torch"), this.getVanilla("block"));
	}

	public void registerAnthraciteWallTorch() {
		AnthraciteWallTorchModel.template(this.getBuilder("template_anthracite_wall_torch"), this.getVanilla("block"));
	}

	public void registerCake() {
		IcariaCakeModel.template0(this.getBuilder("template_cake_0"), this.getVanilla("block"));
		IcariaCakeModel.template1(this.getBuilder("template_cake_1"), this.getVanilla("block"));
		IcariaCakeModel.template2(this.getBuilder("template_cake_2"), this.getVanilla("block"));
		IcariaCakeModel.template3(this.getBuilder("template_cake_3"), this.getVanilla("block"));
	}

	public void registerLayer() {
		LayerModel.template0(this.getBuilder("template_layer_1"), this.getVanilla("block"));
		LayerModel.template1(this.getBuilder("template_layer_2"), this.getVanilla("block"));
		LayerModel.template2(this.getBuilder("template_layer_3"), this.getVanilla("block"));
		LayerModel.template3(this.getBuilder("template_layer_4"), this.getVanilla("block"));
		LayerModel.template4(this.getBuilder("template_layer_5"), this.getVanilla("block"));
		LayerModel.template5(this.getBuilder("template_layer_6"), this.getVanilla("block"));
		LayerModel.template6(this.getBuilder("template_layer_7"), this.getVanilla("block"));
		LayerModel.template7(this.getBuilder("template_layer_8"), this.getVanilla("block"));
	}

	public void registerTwigs() {
		TwigsModel.template0(this.getBuilder("template_twigs_0"), this.getVanilla("block"));
		TwigsModel.template1(this.getBuilder("template_twigs_1"), this.getVanilla("block"));
		TwigsModel.template2(this.getBuilder("template_twigs_2"), this.getVanilla("block"));
		TwigsModel.template3(this.getBuilder("template_twigs_3"), this.getVanilla("block"));
		TwigsModel.template4(this.getBuilder("template_twigs_4"), this.getVanilla("block"));
	}

	public void registerDeadLog() {
		DeadLogModel.log0(this.getBuilder("template_dead_log_0"), this.getVanilla("block"));
		DeadLogModel.logHorizontal0(this.getBuilder("template_dead_log_horizontal_0"), this.getVanilla("block"));
		DeadLogModel.log1(this.getBuilder("template_dead_log_1"), this.getVanilla("block"));
		DeadLogModel.logHorizontal1(this.getBuilder("template_dead_log_horizontal_1"), this.getVanilla("block"));
		DeadLogModel.log2(this.getBuilder("template_dead_log_2"), this.getVanilla("block"));
		DeadLogModel.logHorizontal2(this.getBuilder("template_dead_log_horizontal_2"), this.getVanilla("block"));
	}

	public void registerStrippedDeadLog() {
		StrippedDeadLogModel.log0(this.getBuilder("template_stripped_dead_log_0"), this.getVanilla("block"));
		StrippedDeadLogModel.logHorizontal0(this.getBuilder("template_stripped_dead_log_horizontal_0"), this.getVanilla("block"));
		StrippedDeadLogModel.log1(this.getBuilder("template_stripped_dead_log_1"), this.getVanilla("block"));
		StrippedDeadLogModel.logHorizontal1(this.getBuilder("template_stripped_dead_log_horizontal_1"), this.getVanilla("block"));
		StrippedDeadLogModel.log2(this.getBuilder("template_stripped_dead_log_2"), this.getVanilla("block"));
		StrippedDeadLogModel.logHorizontal2(this.getBuilder("template_stripped_dead_log_horizontal_2"), this.getVanilla("block"));
	}

	public void registerSimpleRack() {
		SimpleRackModel.simple(this.getBuilder("template_simple_rack"), this.getVanilla("block"));
		SimpleRackModel.barrel(this.getBuilder("template_simple_barrel_rack"), this.getVanilla("block"));
		SimpleRackModel.tapped(this.getBuilder("template_simple_tapped_rack"), this.getVanilla("block"));
	}

	public void registerRack() {
		RackModel.simple(this.getBuilder("template_rack"), this.getVanilla("block"));
		RackModel.barrel(this.getBuilder("template_barrel_rack"), this.getVanilla("block"));
		RackModel.tapped(this.getBuilder("template_tapped_barrel_rack"), this.getVanilla("block"));
	}

	public void registerBarrel() {
		BarrelModel.barrel(this.getBuilder("template_barrel"), this.getVanilla("block"));
		BarrelModel.standingBarrel(this.getBuilder("template_standing_barrel"), this.getVanilla("block"));
	}

	public void registerTappedBarrel() {
		TappedBarrelModel.barrel(this.getBuilder("template_tapped_barrel"), this.getVanilla("block"));
		TappedBarrelModel.standingBarrel(this.getBuilder("template_standing_tapped_barrel"), this.getVanilla("block"));
	}

	public void registerTripleBarrelRackInventory() {
		TripleBarrelRackInventoryModel.template(this.getBuilder("template_triple_barrel_rack_inventory"), this.getVanilla("block"));
	}

	public void registerTripleBarrelRack() {
		TripleBarrelRackModel.topLeft(this.getBuilder("template_triple_barrel_rack_top_left"), this.getVanilla("block"));
		TripleBarrelRackModel.topRight(this.getBuilder("template_triple_barrel_rack_top_right"), this.getVanilla("block"));
	}

	public void registerTrough() {
		TroughModel.template(this.getBuilder("template_trough"), this.getVanilla("block"));
	}

	public void registerOverlayTextureVine() {
		OverlayTextureVineModel.template(this.getBuilder("template_overlay_texture_vine"), this.getVanilla("block"));
	}

	public void registerDeadVine() {
		DeadVineModel.template(this.getBuilder("template_dead_vine"), this.getVanilla("block"));
	}

	public void registerOverlayTextureCross() {
		OverlayTextureCrossModel.template(this.getBuilder("template_overlay_texture_cross"), this.getVanilla("block"));
	}

	public void registerOverlayTextureFlowerPotCross() {
		OverlayTextureFlowerPotCrossModel.template(this.getBuilder("template_overlay_texture_flower_pot_cross"), this.getVanilla("block"));
	}

	public void registerBolbos() {
		BolbosModel.template(this.getBuilder("template_bolbos"), this.getVanilla("block"));
	}

	public void registerDathulla() {
		DathullaModel.template(this.getBuilder("template_dathulla"), this.getVanilla("block"));
	}

	public void registerMondanos() {
		MondanosModel.template(this.getBuilder("template_mondanos"), this.getVanilla("block"));
	}

	public void registerMothAgaric() {
		MothAgaricModel.template(this.getBuilder("template_moth_agaric"), this.getVanilla("block"));
	}

	public void registerNamdrake() {
		NamdrakeModel.template(this.getBuilder("template_namdrake"), this.getVanilla("block"));
	}

	public void registerPsilocybos() {
		PsilocybosModel.template(this.getBuilder("template_psilocybos"), this.getVanilla("block"));
	}

	public void registerRowan() {
		RowanModel.template(this.getBuilder("template_rowan"), this.getVanilla("block"));
	}

	public void registerWiltedElm() {
		WiltedElmModel.template(this.getBuilder("template_wilted_elm"), this.getVanilla("block"));
	}

	public void registerGroundFlower() {
		GroundFlowerModel.template(this.getBuilder("template_ground_flower"), this.getVanilla("block"));
	}

	public void registerPalmFern() {
		PalmFernModel.template(this.getBuilder("template_palm_fern"), this.getVanilla("block"));
	}

	public void registerPottedPalmFern() {
		PottedPalmFernModel.template(this.getBuilder("template_potted_palm_fern"), this.getVanilla("block"));
	}

	public void registerBromelia() {
		BromeliaModel.template(this.getBuilder("template_bromelia"), this.getVanilla("block"));
	}

	public void registerPottedBromelia() {
		PottedBromeliaModel.template(this.getBuilder("template_potted_bromelia"), this.getVanilla("block"));
	}

	public void registerGreenGroundShrooms() {
		GreenGroundShroomsModel.template0(this.getBuilder("template_green_ground_shrooms_0"), this.getVanilla("block"));
		GreenGroundShroomsModel.template1(this.getBuilder("template_green_ground_shrooms_1"), this.getVanilla("block"));
		GreenGroundShroomsModel.template2(this.getBuilder("template_green_ground_shrooms_2"), this.getVanilla("block"));
	}

	public void registerPottedGreenGroundShrooms() {
		PottedGreenGroundShroomsModel.template(this.getBuilder("template_potted_green_ground_shrooms"), this.getVanilla("block"));
	}

	public void registerBrownGroundShrooms() {
		BrownGroundShroomsModel.template0(this.getBuilder("template_brown_ground_shrooms_0"), this.getVanilla("block"));
		BrownGroundShroomsModel.template1(this.getBuilder("template_brown_ground_shrooms_1"), this.getVanilla("block"));
		BrownGroundShroomsModel.template2(this.getBuilder("template_brown_ground_shrooms_2"), this.getVanilla("block"));
	}

	public void registerPottedBrownGroundShrooms() {
		PottedBrownGroundShroomsModel.template(this.getBuilder("template_potted_brown_ground_shrooms"), this.getVanilla("block"));
	}

	public void registerLargeBrownGroundShrooms() {
		LargeBrownGroundShroomsModel.template0(this.getBuilder("template_large_brown_ground_shrooms_0"), this.getVanilla("block"));
		LargeBrownGroundShroomsModel.template1(this.getBuilder("template_large_brown_ground_shrooms_1"), this.getVanilla("block"));
		LargeBrownGroundShroomsModel.template2(this.getBuilder("template_large_brown_ground_shrooms_2"), this.getVanilla("block"));
	}

	public void registerPottedLargeBrownGroundShrooms() {
		PottedLargeBrownGroundShroomsModel.template(this.getBuilder("template_potted_large_brown_ground_shrooms"), this.getVanilla("block"));
	}

	public void registerTinderFungusTreeShrooms() {
		TinderFungusTreeShroomsModel.template0(this.getBuilder("template_tinder_fungus_tree_shrooms_0"), this.getVanilla("block"));
		TinderFungusTreeShroomsModel.template1(this.getBuilder("template_tinder_fungus_tree_shrooms_1"), this.getVanilla("block"));
		TinderFungusTreeShroomsModel.template2(this.getBuilder("template_tinder_fungus_tree_shrooms_2"), this.getVanilla("block"));
	}

	public void registerTurkeyTailTreeShrooms() {
		TurkeyTailTreeShroomsModel.template0(this.getBuilder("template_turkey_tail_tree_shrooms_0"), this.getVanilla("block"));
		TurkeyTailTreeShroomsModel.template1(this.getBuilder("template_turkey_tail_tree_shrooms_1"), this.getVanilla("block"));
		TurkeyTailTreeShroomsModel.template2(this.getBuilder("template_turkey_tail_tree_shrooms_2"), this.getVanilla("block"));
	}

	public void registerUnnamedTreeShrooms() {
		UnnamedTreeShroomsModel.template0(this.getBuilder("template_unnamed_tree_shrooms_0"), this.getVanilla("block"));
		UnnamedTreeShroomsModel.template1(this.getBuilder("template_unnamed_tree_shrooms_1"), this.getVanilla("block"));
		UnnamedTreeShroomsModel.template2(this.getBuilder("template_unnamed_tree_shrooms_2"), this.getVanilla("block"));
	}

	public void registerCardonCactusInventory() {
		CardonCactusInventoryModel.template(this.getBuilder("template_cardon_cactus_inventory"), this.getVanilla("block"));
	}

	public void registerCardonCactus() {
		CardonCactusModel.cube(this.getBuilder("template_cardon_cactus_cube"), this.getVanilla("block"));
		CardonCactusModel.stem(this.getBuilder("template_cardon_cactus_stem"), this.getVanilla("block"));
	}

	public void registerPottedCardonCactus() {
		PottedCardonCactusModel.template(this.getBuilder("template_potted_cardon_cactus"), this.getVanilla("block"));
	}

	public void registerStrawberryBush() {
		StrawberryBushModel.template(this.getBuilder("template_strawberry_bush"), this.getVanilla("block"));
	}

	public void registerPhysalisCrop() {
		PhysalisCropModel.template0(this.getBuilder("template_physalis_crop_0"), this.getVanilla("block"));
		PhysalisCropModel.template1(this.getBuilder("template_physalis_crop_1"), this.getVanilla("block"));
		PhysalisCropModel.template2(this.getBuilder("template_physalis_crop_2"), this.getVanilla("block"));
		PhysalisCropModel.template3(this.getBuilder("template_physalis_crop_3"), this.getVanilla("block"));
		PhysalisCropModel.template4(this.getBuilder("template_physalis_crop_4"), this.getVanilla("block"));
	}

	public void registerPortal() {
		IcariaPortalModel.x(this.getBuilder("template_portal_x"), this.getVanilla("block"));
		IcariaPortalModel.z(this.getBuilder("template_portal_z"), this.getVanilla("block"));
	}

	public void registerGrinderShaft() {
		GrinderShaftModel.template(this.getBuilder("template_grinder_shaft"), this.getVanilla("block"));
	}

	public void registerGrinderStone() {
		GrinderStoneModel.template(this.getBuilder("template_grinder_stone"), this.getVanilla("block"));
	}

	public void grassyMarl(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "grass_block"))
			.renderType("cutout")
			.texture("bottom", this.file(IcariaIdents.ID, "marl"))
			.texture("overlay", this.file(IcariaIdents.ID, "grassy_marl_side"))
			.texture("side", this.file(IcariaIdents.ID, "marl"))
			.texture("top", this.file(IcariaIdents.ID, "grassy_marl_top"))
			.texture("particle", this.file(IcariaIdents.ID, "marl"));
		this.withExistingParent("forest_moss_marl", this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.ID, "marl"))
			.texture("side", this.file(IcariaIdents.ID, "forest_moss_marl"))
			.texture("top", this.file(IcariaIdents.ID, "forest_moss"))
			.texture("particle", this.file(IcariaIdents.ID, "marl"));
		this.withExistingParent("scrubland_moss_marl", this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.ID, "marl"))
			.texture("side", this.file(IcariaIdents.ID, "scrubland_moss_marl"))
			.texture("top", this.file(IcariaIdents.ID, "scrubland_moss"))
			.texture("particle", this.file(IcariaIdents.ID, "marl"));
		this.withExistingParent("steppe_moss_marl", this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.ID, "marl"))
			.texture("side", this.file(IcariaIdents.ID, "steppe_moss_marl"))
			.texture("top", this.file(IcariaIdents.ID, "steppe_moss"))
			.texture("particle", this.file(IcariaIdents.ID, "marl"));
	}

	public void block(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_all"))
			.texture("all", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void surfaceChert(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_surface_chert"))
			.texture("texture", this.file(IcariaIdents.ID, "surface_chert"))
			.texture("particle", this.file(IcariaIdents.ID, "surface_chert"));
	}

	public void surfaceBones(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_surface_bones"))
			.texture("texture", this.file(IcariaIdents.ID, "surface_bones"))
			.texture("particle", this.file(IcariaIdents.ID, "surface_bones"));
	}

	public void rubble(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName, "0"), this.file(IcariaIdents.ID, "template_rubble_0"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "1"), this.file(IcariaIdents.ID, "template_rubble_1"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "2"), this.file(IcariaIdents.ID, "template_rubble_2"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "3"), this.file(IcariaIdents.ID, "template_rubble_3"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "4"), this.file(IcariaIdents.ID, "template_rubble_4"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void farmland(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "dry"), this.file(IcariaIdents.MC, "farmland"))
			.texture("dirt", this.file(IcariaIdents.ID, "marl"))
			.texture("top", this.file(IcariaIdents.ID, "farmland_dry"))
			.texture("particle", this.file(IcariaIdents.ID, "marl"));
		this.withExistingParent(this.name(pBlock, "wet"), this.file(IcariaIdents.MC, "farmland"))
			.texture("dirt", this.file(IcariaIdents.ID, "marl"))
			.texture("top", this.file(IcariaIdents.ID, "farmland_wet"))
			.texture("particle", this.file(IcariaIdents.ID, "marl"));
	}

	public void fertilizedFarmland(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "farmland"))
			.texture("dirt", this.file(IcariaIdents.ID, "marl"))
			.texture("top", this.file(IcariaIdents.ID, "fertilized_farmland"))
			.texture("particle", this.file(IcariaIdents.ID, "marl"));
	}

	public void slab(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.MC, "slab"))
			.texture("bottom", this.file(pFile))
			.texture("side", this.file(pFile))
			.texture("top", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "top"), this.file(IcariaIdents.MC, "slab_top"))
			.texture("bottom", this.file(pFile))
			.texture("side", this.file(pFile))
			.texture("top", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void stairs(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.MC, "stairs"))
			.texture("bottom", this.file(pFile))
			.texture("side", this.file(pFile))
			.texture("top", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "inner"), this.file(IcariaIdents.MC, "inner_stairs"))
			.texture("bottom", this.file(pFile))
			.texture("side", this.file(pFile))
			.texture("top", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "outer"), this.file(IcariaIdents.MC, "outer_stairs"))
			.texture("bottom", this.file(pFile))
			.texture("side", this.file(pFile))
			.texture("top", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void wall(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName, "inventory"), this.file(IcariaIdents.MC, "wall_inventory"))
			.texture("wall", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "post"), this.file(IcariaIdents.MC, "template_wall_post"))
			.texture("wall", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "side"), this.file(IcariaIdents.MC, "template_wall_side"))
			.texture("wall", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "side_tall"), this.file(IcariaIdents.MC, "template_wall_side_tall"))
			.texture("wall", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void axis(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_column"))
			.texture("end", this.file(pBlock, "top"))
			.texture("side", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "horizontal"), this.file(IcariaIdents.MC, "cube_column_horizontal"))
			.texture("end", this.file(pBlock, "top"))
			.texture("side", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void dolomitePillarHead(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.ID, "dolomite_pillar_top"))
			.texture("side", this.file(IcariaIdents.ID, "dolomite_pillar_head"))
			.texture("top", this.file(IcariaIdents.ID, "smooth_dolomite"))
			.texture("particle", this.file(IcariaIdents.ID, "dolomite_pillar_head"));
		this.withExistingParent(this.name(pBlock, "inverted"), this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.ID, "dolomite_pillar_top"))
			.texture("side", this.file(IcariaIdents.ID, "dolomite_pillar_head_inverted"))
			.texture("top", this.file(IcariaIdents.ID, "smooth_dolomite"))
			.texture("particle", this.file(IcariaIdents.ID, "dolomite_pillar_head_inverted"));
	}

	public void blockCutout(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_all"))
			.renderType("cutout")
			.texture("all", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void pane(Block pEdge, Block pPane) {
		this.withExistingParent(this.name(pEdge, "inventory"), this.file(IcariaIdents.ID, "template_pane_inventory"))
			.texture("edge", this.file(pEdge))
			.texture("pane", this.file(pPane))
			.texture("particle", this.file(pPane));
		this.withExistingParent(this.name(pEdge, "noside"), this.file(IcariaIdents.MC, "template_glass_pane_noside"))
			.renderType("cutout")
			.texture("pane", this.file(pPane))
			.texture("particle", this.file(pPane));
		this.withExistingParent(this.name(pEdge, "noside_alt"), this.file(IcariaIdents.MC, "template_glass_pane_noside_alt"))
			.renderType("cutout")
			.texture("pane", this.file(pPane))
			.texture("particle", this.file(pPane));
		this.withExistingParent(this.name(pEdge, "post"), this.file(IcariaIdents.MC, "template_glass_pane_post"))
			.renderType("cutout")
			.texture("edge", this.file(pEdge))
			.texture("pane", this.file(pPane))
			.texture("particle", this.file(pPane));
		this.withExistingParent(this.name(pEdge, "side"), this.file(IcariaIdents.MC, "template_glass_pane_side"))
			.renderType("cutout")
			.texture("edge", this.file(pEdge))
			.texture("pane", this.file(pPane))
			.texture("particle", this.file(pPane));
		this.withExistingParent(this.name(pEdge, "side_alt"), this.file(IcariaIdents.MC, "template_glass_pane_side_alt"))
			.renderType("cutout")
			.texture("edge", this.file(pEdge))
			.texture("pane", this.file(pPane))
			.texture("particle", this.file(pPane));
	}

	public void horizontalPane(Block pName, Block pEdge, Block pPane) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_horizontal_pane"))
			.renderType("cutout")
			.texture("edge", this.file(pEdge))
			.texture("pane", this.file(pPane))
			.texture("particle", this.file(pPane));
	}

	public void relicstonePillarHead(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.ID, "relicstone_pillar_top"))
			.texture("side", this.file(IcariaIdents.ID, "relicstone_pillar_head"))
			.texture("top", this.file(IcariaIdents.ID, "relicstone_pillar_head_top"))
			.texture("particle", this.file(IcariaIdents.ID, "relicstone_pillar_head"));
		this.withExistingParent(this.name(pBlock, "inverted"), this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.ID, "relicstone_pillar_top"))
			.texture("side", this.file(IcariaIdents.ID, "relicstone_pillar_head_inverted"))
			.texture("top", this.file(IcariaIdents.ID, "relicstone_pillar_head_top"))
			.texture("particle", this.file(IcariaIdents.ID, "relicstone_pillar_head_inverted"));
	}

	public void overlayTextureBlock(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_block"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void quartzWall(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.MC, "wall_inventory"))
			.texture("wall", this.file(IcariaIdents.MC, "quartz_block_side"))
			.texture("particle", this.file(IcariaIdents.MC, "quartz_block_side"));
		this.withExistingParent(this.name(pBlock, "post"), this.file(IcariaIdents.MC, "template_wall_post"))
			.texture("wall", this.file(IcariaIdents.MC, "quartz_block_side"))
			.texture("particle", this.file(IcariaIdents.MC, "quartz_block_side"));
		this.withExistingParent(this.name(pBlock, "side"), this.file(IcariaIdents.MC, "template_wall_side"))
			.texture("wall", this.file(IcariaIdents.MC, "quartz_block_side"))
			.texture("particle", this.file(IcariaIdents.MC, "quartz_block_side"));
		this.withExistingParent(this.name(pBlock, "side_tall"), this.file(IcariaIdents.MC, "template_wall_side_tall"))
			.texture("wall", this.file(IcariaIdents.MC, "quartz_block_side"))
			.texture("particle", this.file(IcariaIdents.MC, "quartz_block_side"));
	}

	public void quartzPillarHead(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.MC, "quartz_pillar_top"))
			.texture("side", this.file(IcariaIdents.ID, "quartz_pillar_head"))
			.texture("top", this.file(IcariaIdents.MC, "chiseled_quartz_block_top"))
			.texture("particle", this.file(IcariaIdents.ID, "quartz_pillar_head"));
		this.withExistingParent(this.name(pBlock, "inverted"), this.file(IcariaIdents.MC, "cube_bottom_top"))
			.texture("bottom", this.file(IcariaIdents.MC, "quartz_pillar_top"))
			.texture("side", this.file(IcariaIdents.ID, "quartz_pillar_head_inverted"))
			.texture("top", this.file(IcariaIdents.MC, "chiseled_quartz_block_top"))
			.texture("particle", this.file(IcariaIdents.ID, "quartz_pillar_head_inverted"));
	}

	public void calciteCrystal(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_calcite_crystal"))
			.texture("texture", this.file(IcariaIdents.ID, "calcite_crystal"))
			.texture("particle", this.file(IcariaIdents.ID, "calcite_crystal"));
	}

	public void haliteCrystal(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_halite_crystal"))
			.texture("texture", this.file(IcariaIdents.ID, "halite_crystal"))
			.texture("particle", this.file(IcariaIdents.ID, "halite_crystal"));
	}

	public void jasperCrystal(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_jasper_crystal"))
			.texture("texture", this.file(IcariaIdents.ID, "jasper_crystal"))
			.texture("particle", this.file(IcariaIdents.ID, "jasper_crystal"));
	}

	public void zirconCrystal(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_zircon_crystal"))
			.texture("texture", this.file(IcariaIdents.ID, "zircon_crystal"))
			.texture("particle", this.file(IcariaIdents.ID, "zircon_crystal"));
	}

	public void blockTranslucent(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_all"))
			.renderType("translucent")
			.texture("all", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void bars(Block pBlock)  {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.ID, "template_bars_inventory"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "cap"), this.file(IcariaIdents.MC, "iron_bars_cap"))
			.renderType("cutout")
			.texture("bars", this.file(pBlock))
			.texture("edge", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "cap_alt"), this.file(IcariaIdents.MC, "iron_bars_cap_alt"))
			.renderType("cutout")
			.texture("bars", this.file(pBlock))
			.texture("edge", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "post"), this.file(IcariaIdents.MC, "iron_bars_post"))
			.renderType("cutout")
			.texture("bars", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "post_ends"), this.file(IcariaIdents.MC, "iron_bars_post_ends"))
			.renderType("cutout")
			.texture("edge", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "side"), this.file(IcariaIdents.MC, "iron_bars_side"))
			.renderType("cutout")
			.texture("bars", this.file(pBlock))
			.texture("edge", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "side_alt"), this.file(IcariaIdents.MC, "iron_bars_side_alt"))
			.renderType("cutout")
			.texture("bars", this.file(pBlock))
			.texture("edge", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void horizontalBars(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_horizontal_bars"))
			.renderType("cutout")
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void chain(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "chain"))
			.renderType("cutout")
			.texture("all", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void kettle(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.ID, "template_kettle_inventory"))
			.renderType("translucent")
			.texture("droughtroot_log", this.file(IcariaIdents.ID, "droughtroot_log"))
			.texture("kettle", this.file(IcariaIdents.ID, "kettle"))
			.texture("laurel_log", this.file(IcariaIdents.ID, "laurel_log"))
			.texture("laurel_planks", this.file(IcariaIdents.ID, "laurel_planks"))
			.texture("red_loot_vase", this.file(IcariaIdents.ID, "red_loot_vase"))
			.texture("yellowstone", this.file(IcariaIdents.ID, "yellowstone"))
			.texture("particle", this.file(IcariaIdents.ID, "laurel_log"));
		this.withExistingParent(this.name(pBlock, "lower_solid"), this.file(IcariaIdents.ID, "template_kettle_lower_solid"))
			.texture("droughtroot_log", this.file(IcariaIdents.ID, "droughtroot_log"))
			.texture("kettle", this.file(IcariaIdents.ID, "kettle"))
			.texture("laurel_log", this.file(IcariaIdents.ID, "laurel_log"))
			.texture("laurel_planks", this.file(IcariaIdents.ID, "laurel_planks"))
			.texture("red_loot_vase", this.file(IcariaIdents.ID, "red_loot_vase"))
			.texture("yellowstone", this.file(IcariaIdents.ID, "yellowstone"))
			.texture("particle", this.file(IcariaIdents.ID, "laurel_log"));
		this.withExistingParent(this.name(pBlock, "lower_solid_lit"), this.file(IcariaIdents.ID, "template_kettle_lower_solid_lit"))
			.texture("kettle", this.file(IcariaIdents.ID, "kettle"))
			.texture("kettle_firewood", this.file(IcariaIdents.ID, "kettle_firewood"))
			.texture("laurel_log", this.file(IcariaIdents.ID, "laurel_log"))
			.texture("laurel_planks", this.file(IcariaIdents.ID, "laurel_planks"))
			.texture("red_loot_vase", this.file(IcariaIdents.ID, "red_loot_vase"))
			.texture("yellowstone", this.file(IcariaIdents.ID, "yellowstone"))
			.texture("particle", this.file(IcariaIdents.ID, "laurel_log"));
		this.withExistingParent(this.name(pBlock, "lower_glass"), this.file(IcariaIdents.ID, "template_kettle_lower_glass"))
			.renderType("translucent")
			.texture("kettle", this.file(IcariaIdents.ID, "kettle"))
			.texture("particle", this.file(IcariaIdents.ID, "laurel_log"));
		this.withExistingParent(this.name(pBlock, "upper_solid"), this.file(IcariaIdents.ID, "template_kettle_upper_solid"))
			.texture("kettle", this.file(IcariaIdents.ID, "kettle"))
			.texture("laurel_log", this.file(IcariaIdents.ID, "laurel_log"))
			.texture("laurel_planks", this.file(IcariaIdents.ID, "laurel_planks"))
			.texture("particle", this.file(IcariaIdents.ID, "laurel_log"));
		this.withExistingParent(this.name(pBlock, "upper_glass"), this.file(IcariaIdents.ID, "template_kettle_upper_glass"))
			.renderType("translucent")
			.texture("kettle", this.file(IcariaIdents.ID, "kettle"))
			.texture("particle", this.file(IcariaIdents.ID, "laurel_log"));
		this.getBuilder(this.name(pBlock, "lower"))
			.parent(this.getExistingFile(this.file(pBlock, "lower_solid")))
			.customLoader(CompositeModelBuilder::begin)
			.child("solid", this.nested().parent(this.getExistingFile(this.file(pBlock, "lower_solid"))))
			.child("glass", this.nested().parent(this.getExistingFile(this.file(pBlock, "lower_glass"))))
			.end();
		this.getBuilder(this.name(pBlock, "lower_lit"))
			.parent(this.getExistingFile(this.file(pBlock, "lower_solid_lit")))
			.customLoader(CompositeModelBuilder::begin)
			.child("solid", this.nested().parent(this.getExistingFile(this.file(pBlock, "lower_solid_lit"))))
			.child("glass", this.nested().parent(this.getExistingFile(this.file(pBlock, "lower_glass"))))
			.end();
		this.getBuilder(this.name(pBlock, "upper"))
			.parent(this.getExistingFile(this.file(pBlock, "upper_solid")))
			.customLoader(CompositeModelBuilder::begin)
			.child("solid", this.nested().parent(this.getExistingFile(this.file(pBlock, "upper_solid"))))
			.child("glass", this.nested().parent(this.getExistingFile(this.file(pBlock, "upper_glass"))))
			.end();
	}

	public void grinder(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.ID, "template_grinder_inventory"))
			.texture("anthracite_block", this.file(IcariaIdents.ID, "anthracite_block"))
			.texture("grinder", this.file(IcariaIdents.ID, "grinder"))
			.texture("grinder_engine", this.file(IcariaIdents.ID, "grinder_engine"))
			.texture("grinder_feeder", this.file(IcariaIdents.ID, "grinder_feeder"))
			.texture("grinder_stone", this.file(IcariaIdents.ID, "grinder_stone"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("static_left_grinder_chain", this.file(IcariaIdents.ID, "static_left_grinder_chain"))
			.texture("static_right_grinder_chain", this.file(IcariaIdents.ID, "static_right_grinder_chain"))
			.texture("sunstone_bricks", this.file(IcariaIdents.ID, "sunstone_bricks"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "sunstone_bricks"));
		this.withExistingParent(this.name(pBlock, "left"), this.file(IcariaIdents.ID, "template_grinder_left"))
			.texture("anthracite_block", this.file(IcariaIdents.ID, "anthracite_block"))
			.texture("grinder", this.file(IcariaIdents.ID, "grinder"))
			.texture("grinder_feeder", this.file(IcariaIdents.ID, "grinder_feeder"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("sunstone_bricks", this.file(IcariaIdents.ID, "sunstone_bricks"))
			.texture("particle", this.file(IcariaIdents.ID, "sunstone_bricks"));
		this.withExistingParent(this.name(pBlock, "right"), this.file(IcariaIdents.ID, "template_grinder_right"))
			.texture("anthracite_block", this.file(IcariaIdents.ID, "anthracite_block"))
			.texture("grinder", this.file(IcariaIdents.ID, "grinder"))
			.texture("grinder_engine", this.file(IcariaIdents.ID, "grinder_engine"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("sunstone_bricks", this.file(IcariaIdents.ID, "sunstone_bricks"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "sunstone_bricks"));
	}

	public void kiln(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.ID, "template_kiln_inventory"))
			.texture("kiln", this.file(IcariaIdents.ID, "kiln"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("laurel_planks", this.file(IcariaIdents.ID, "laurel_planks"))
			.texture("yellowstone_bricks", this.file(IcariaIdents.ID, "yellowstone_bricks"))
			.texture("particle", this.file(IcariaIdents.ID, "yellowstone_bricks"));
		this.withExistingParent(this.name(pBlock, "lower"), this.file(IcariaIdents.ID, "template_kiln_lower"))
			.texture("kiln", this.file(IcariaIdents.ID, "kiln"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("yellowstone_bricks", this.file(IcariaIdents.ID, "yellowstone_bricks"))
			.texture("particle", this.file(IcariaIdents.ID, "yellowstone_bricks"));
		this.withExistingParent(this.name(pBlock, "upper"), this.file(IcariaIdents.ID, "template_kiln_upper"))
			.texture("kiln", this.file(IcariaIdents.ID, "kiln"))
			.texture("laurel_planks", this.file(IcariaIdents.ID, "laurel_planks"))
			.texture("yellowstone_bricks", this.file(IcariaIdents.ID, "yellowstone_bricks"))
			.texture("particle", this.file(IcariaIdents.ID, "yellowstone_bricks"));
	}

	public void forge(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.ID, "template_forge_inventory"))
			.texture("forge", this.file(IcariaIdents.ID, "forge"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("stripped_cypress_log", this.file(IcariaIdents.ID, "stripped_cypress_log"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "bottom_back_left"), this.file(IcariaIdents.ID, "template_forge_bottom_back_left"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "bottom_back_right"), this.file(IcariaIdents.ID, "template_forge_bottom_back_right"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "bottom_front_left"), this.file(IcariaIdents.ID, "template_forge_bottom_front_left"))
			.texture("forge", this.file(IcariaIdents.ID, "forge"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "bottom_front_right"), this.file(IcariaIdents.ID, "template_forge_bottom_front_right"))
			.texture("forge", this.file(IcariaIdents.ID, "forge"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "bottom_front_right_lit"), this.file(IcariaIdents.ID, "template_forge_bottom_front_right_lit"))
			.texture("lava_flow", this.file(IcariaIdents.MC, "lava_flow"))
			.texture("lava_still", this.file(IcariaIdents.MC, "lava_still"))
			.texture("forge", this.file(IcariaIdents.ID, "forge"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "top_back_left"), this.file(IcariaIdents.ID, "template_forge_top_back_left"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "top_back_right"), this.file(IcariaIdents.ID, "template_forge_top_back_right"))
			.texture("forge", this.file(IcariaIdents.ID, "forge"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "top_front_left"), this.file(IcariaIdents.ID, "template_forge_top_front_left"))
			.texture("forge", this.file(IcariaIdents.ID, "forge"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("loam_bricks", this.file(IcariaIdents.ID, "loam_bricks"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
		this.withExistingParent(this.name(pBlock, "top_front_right"), this.file(IcariaIdents.ID, "template_forge_top_front_right"))
			.texture("forge", this.file(IcariaIdents.ID, "forge"))
			.texture("grainite", this.file(IcariaIdents.ID, "grainite"))
			.texture("grainite_bricks", this.file(IcariaIdents.ID, "grainite_bricks"))
			.texture("stripped_cypress_log", this.file(IcariaIdents.ID, "stripped_cypress_log"))
			.texture("particle", this.file(IcariaIdents.ID, "grainite"));
	}

	public void particle(Block pName, Block pFile) {
		this.getBuilder(this.name(pName))
			.texture("particle", this.file(pFile));
	}

	public void storageVase(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_storage_vase"))
			.texture("dark", this.file(pBlock, "dark"))
			.texture("lite", this.file(pBlock, "lite"))
			.texture("neck", this.file(pBlock, "neck"))
			.texture("vase", this.file(pBlock))
			.texture("particle", this.file(pBlock, "dark"));
	}

	public void lootVase(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_loot_vase_0"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_loot_vase_1"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_loot_vase_2"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "3"), this.file(IcariaIdents.ID, "template_loot_vase_3"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "4"), this.file(IcariaIdents.ID, "template_loot_vase_4"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "5"), this.file(IcariaIdents.ID, "template_loot_vase_5"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "6"), this.file(IcariaIdents.ID, "template_loot_vase_6"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "7"), this.file(IcariaIdents.ID, "template_loot_vase_7"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "8"), this.file(IcariaIdents.ID, "template_loot_vase_8"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
		this.withExistingParent(this.name(pBlock, "9"), this.file(IcariaIdents.ID, "template_loot_vase_9"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "particle"));
	}

	public void ligniteTorch(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_lignite_torch"))
			.texture("torch_bone", this.file(IcariaIdents.ID, "torch_bone"))
			.texture("torch_coal", this.file(IcariaIdents.ID, "torch_coal"))
			.texture("particle", this.file(IcariaIdents.ID, "torch_bone"));
	}

	public void ligniteWallTorch(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_lignite_wall_torch"))
			.texture("torch_bone", this.file(IcariaIdents.ID, "torch_bone"))
			.texture("torch_coal", this.file(IcariaIdents.ID, "torch_coal"))
			.texture("torch_metal", this.file(IcariaIdents.ID, "torch_metal"))
			.texture("particle", this.file(IcariaIdents.ID, "torch_bone"));
	}

	public void anthraciteTorch(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_anthracite_torch"))
			.texture("torch_bone", this.file(IcariaIdents.ID, "torch_bone"))
			.texture("torch_coal", this.file(IcariaIdents.ID, "torch_coal"))
			.texture("torch_metal", this.file(IcariaIdents.ID, "torch_metal"))
			.texture("particle", this.file(IcariaIdents.ID, "torch_bone"));
	}

	public void anthraciteWallTorch(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_anthracite_wall_torch"))
			.texture("torch_bone", this.file(IcariaIdents.ID, "torch_bone"))
			.texture("torch_coal", this.file(IcariaIdents.ID, "torch_coal"))
			.texture("torch_metal", this.file(IcariaIdents.ID, "torch_metal"))
			.texture("particle", this.file(IcariaIdents.ID, "torch_bone"));
	}

	public void cake(Block pBlock) {
		this.withExistingParent(this.name("candle", pBlock), this.file(IcariaIdents.MC, "candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("candle", pBlock, "lit"), this.file(IcariaIdents.MC, "candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("white_candle", pBlock), this.file(IcariaIdents.MC, "white_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("white_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "white_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("light_gray_candle", pBlock), this.file(IcariaIdents.MC, "light_gray_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("light_gray_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "light_gray_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("gray_candle", pBlock), this.file(IcariaIdents.MC, "gray_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("gray_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "gray_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("black_candle", pBlock), this.file(IcariaIdents.MC, "black_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("black_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "black_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("brown_candle", pBlock), this.file(IcariaIdents.MC, "brown_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("brown_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "brown_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("red_candle", pBlock), this.file(IcariaIdents.MC, "red_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("red_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "red_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("orange_candle", pBlock), this.file(IcariaIdents.MC, "orange_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("orange_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "orange_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("yellow_candle", pBlock), this.file(IcariaIdents.MC, "yellow_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("yellow_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "yellow_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("lime_candle", pBlock), this.file(IcariaIdents.MC, "lime_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("lime_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "lime_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("green_candle", pBlock), this.file(IcariaIdents.MC, "green_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("green_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "green_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("cyan_candle", pBlock), this.file(IcariaIdents.MC, "cyan_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("cyan_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "cyan_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("light_blue_candle", pBlock), this.file(IcariaIdents.MC, "light_blue_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("light_blue_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "light_blue_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("blue_candle", pBlock), this.file(IcariaIdents.MC, "blue_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("blue_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "blue_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("purple_candle", pBlock), this.file(IcariaIdents.MC, "purple_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("purple_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "purple_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("magenta_candle", pBlock), this.file(IcariaIdents.MC, "magenta_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("magenta_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "magenta_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("pink_candle", pBlock), this.file(IcariaIdents.MC, "pink_candle_cake"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name("pink_candle", pBlock, "lit"), this.file(IcariaIdents.MC, "pink_candle_cake_lit"))
			.texture("bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_cake_0"))
			.texture("cake_bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("cake_side", this.file(pBlock, "side"))
			.texture("cake_top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_cake_1"))
			.texture("cake_bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("cake_inside", this.file(pBlock, "inside"))
			.texture("cake_side", this.file(pBlock, "side"))
			.texture("cake_top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_cake_2"))
			.texture("cake_bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("cake_inside", this.file(pBlock, "inside"))
			.texture("cake_side", this.file(pBlock, "side"))
			.texture("cake_top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name(pBlock, "3"), this.file(IcariaIdents.ID, "template_cake_3"))
			.texture("cake_bottom", this.file(IcariaIdents.ID, "cake_bottom"))
			.texture("cake_inside", this.file(pBlock, "inside"))
			.texture("cake_side", this.file(pBlock, "side"))
			.texture("cake_top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "side"));
	}

	public void cross(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cross"))
			.renderType("cutout")
			.texture("cross", this.file(pBlock));
	}

	public void flowerPotCross(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.MC, "flower_pot_cross"))
			.renderType("cutout")
			.texture("plant", this.file(pFile));
	}

	public void fallenLeaves(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName, "1"), this.file(IcariaIdents.ID, "template_layer_1"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
		this.withExistingParent(this.name(pName, "2"), this.file(IcariaIdents.ID, "template_layer_2"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
		this.withExistingParent(this.name(pName, "3"), this.file(IcariaIdents.ID, "template_layer_3"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
		this.withExistingParent(this.name(pName, "4"), this.file(IcariaIdents.ID, "template_layer_4"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
		this.withExistingParent(this.name(pName, "5"), this.file(IcariaIdents.ID, "template_layer_5"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
		this.withExistingParent(this.name(pName, "6"), this.file(IcariaIdents.ID, "template_layer_6"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
		this.withExistingParent(this.name(pName, "7"), this.file(IcariaIdents.ID, "template_layer_7"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
		this.withExistingParent(this.name(pName, "8"), this.file(IcariaIdents.ID, "template_layer_8"))
			.renderType("cutout")
			.texture("texture", this.file(pFile));
	}

	public void twigs(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_twigs_0"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_twigs_1"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_twigs_2"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "3"), this.file(IcariaIdents.ID, "template_twigs_3"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "4"), this.file(IcariaIdents.ID, "template_twigs_4"))
			.texture("texture", this.file(pBlock));
	}

	public void wood(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.MC, "cube_column"))
			.texture("end", this.file(pFile))
			.texture("side", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "horizontal"), this.file(IcariaIdents.MC, "cube_column_horizontal"))
			.texture("end", this.file(pFile))
			.texture("side", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void deadLog(Block pName, Block pLog, Block pStrippedLog, Block pMoss) {
		this.withExistingParent(this.name(pName, "0"), this.file(IcariaIdents.ID, "template_dead_log_0"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName, "horizontal_0"), this.file(IcariaIdents.ID, "template_dead_log_horizontal_0"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName, "1"), this.file(IcariaIdents.ID, "template_dead_log_1"))
			.texture("brown_ground_shrooms", this.file(IcariaIdents.ID, "brown_ground_shrooms"))
			.texture("stem_ground_shrooms", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("marl", this.file(IcariaIdents.ID, "marl"))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName, "horizontal_1"), this.file(IcariaIdents.ID, "template_dead_log_horizontal_1"))
			.texture("brown_ground_shrooms", this.file(IcariaIdents.ID, "brown_ground_shrooms"))
			.texture("stem_ground_shrooms", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("marl", this.file(IcariaIdents.ID, "marl"))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName, "2"), this.file(IcariaIdents.ID, "template_dead_log_2"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("marl", this.file(IcariaIdents.ID, "marl"))
			.texture("moss", this.file(pMoss))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName, "horizontal_2"), this.file(IcariaIdents.ID, "template_dead_log_horizontal_2"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("marl", this.file(IcariaIdents.ID, "marl"))
			.texture("moss", this.file(pMoss))
			.texture("particle", this.file(pLog));
	}

	public void strippedDeadLog(Block pName, Block pStrippedLog) {
		this.withExistingParent(this.name(pName, "0"), this.file(IcariaIdents.ID, "template_stripped_dead_log_0"))
			.texture("log", this.file(pStrippedLog))
			.texture("log_top", this.file(pStrippedLog, "top"))
			.texture("particle", this.file(pStrippedLog));
		this.withExistingParent(this.name(pName, "horizontal_0"), this.file(IcariaIdents.ID, "template_stripped_dead_log_horizontal_0"))
			.texture("log", this.file(pStrippedLog))
			.texture("log_top", this.file(pStrippedLog, "top"))
			.texture("particle", this.file(pStrippedLog));
		this.withExistingParent(this.name(pName, "1"), this.file(IcariaIdents.ID, "template_stripped_dead_log_1"))
			.texture("log", this.file(pStrippedLog))
			.texture("log_top", this.file(pStrippedLog, "top"))
			.texture("particle", this.file(pStrippedLog));
		this.withExistingParent(this.name(pName, "horizontal_1"), this.file(IcariaIdents.ID, "template_stripped_dead_log_horizontal_1"))
			.texture("log", this.file(pStrippedLog))
			.texture("log_top", this.file(pStrippedLog, "top"))
			.texture("particle", this.file(pStrippedLog));
		this.withExistingParent(this.name(pName, "2"), this.file(IcariaIdents.ID, "template_stripped_dead_log_2"))
			.texture("log", this.file(pStrippedLog))
			.texture("log_top", this.file(pStrippedLog, "top"))
			.texture("particle", this.file(pStrippedLog));
		this.withExistingParent(this.name(pName, "horizontal_2"), this.file(IcariaIdents.ID, "template_stripped_dead_log_horizontal_2"))
			.texture("log", this.file(pStrippedLog))
			.texture("log_top", this.file(pStrippedLog, "top"))
			.texture("particle", this.file(pStrippedLog));
	}

	public void deadDroughtrootLog(Block pName, Block pLog, Block pStrippedLog) {
		this.withExistingParent(this.name(pName, "0"), this.file(IcariaIdents.ID, "template_dead_log_0"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName, "horizontal_0"), this.file(IcariaIdents.ID, "template_dead_log_horizontal_0"))
			.texture("log", this.file(pLog))
			.texture("log_top", this.file(pLog, "top"))
			.texture("stripped_log", this.file(pStrippedLog))
			.texture("particle", this.file(pLog));
	}

	public void fence(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName, "inventory"), this.file(IcariaIdents.MC, "fence_inventory"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "post"), this.file(IcariaIdents.MC, "fence_post"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "side"), this.file(IcariaIdents.MC, "fence_side"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void gate(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.MC, "template_fence_gate"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "open"), this.file(IcariaIdents.MC, "template_fence_gate_open"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "wall"), this.file(IcariaIdents.MC, "template_fence_gate_wall"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
		this.withExistingParent(this.name(pName, "wall_open"), this.file(IcariaIdents.MC, "template_fence_gate_wall_open"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void simpleRack(Block pName, Block pBarrel, Block pLoadedBarrel, Block pLog, Block pPlanks) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_simple_rack"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName).replace("rack", "barrel_rack"), this.file(IcariaIdents.ID, "template_simple_barrel_rack"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pBarrel, "front"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name(pName).replace("simple", "simple_loaded").replace("rack", "barrel_rack"), this.file(IcariaIdents.ID, "template_simple_barrel_rack"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pLoadedBarrel, "front"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name(pName).replace("simple", "simple_tapped").replace("rack", "barrel_rack"), this.file(IcariaIdents.ID, "template_simple_tapped_rack"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
	}

	public void rack(Block pName, Block pBarrel, Block pLoadedBarrel, Block pLog, Block pPlanks) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_rack"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pLog));
		this.withExistingParent(this.name(pName).replace("rack", "barrel_rack"), this.file(IcariaIdents.ID, "template_barrel_rack"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pBarrel, "front"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name("loaded", pName).replace("rack", "barrel_rack"), this.file(IcariaIdents.ID, "template_barrel_rack"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pLoadedBarrel, "front"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name("tapped", pName).replace("rack", "barrel_rack"), this.file(IcariaIdents.ID, "template_tapped_barrel_rack"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
	}

	public void barrel(Block pBarrel, Block pPlanks) {
		this.withExistingParent(this.name(pBarrel), this.file(IcariaIdents.ID, "template_barrel"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pBarrel, "front"))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name("standing", pBarrel), this.file(IcariaIdents.ID, "template_standing_barrel"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pBarrel, "front"))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
	}

	public void loadedBarrel(Block pLoadedBarrel, Block pBarrel, Block pPlanks) {
		this.withExistingParent(this.name(pLoadedBarrel), this.file(IcariaIdents.ID, "template_barrel"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pLoadedBarrel, "front"))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name("standing", pLoadedBarrel), this.file(IcariaIdents.ID, "template_standing_barrel"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pLoadedBarrel, "front"))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
	}

	public void tappedBarrel(Block pTappedBarrel, Block pBarrel, Block pPlanks) {
		this.withExistingParent(this.name(pTappedBarrel), this.file(IcariaIdents.ID, "template_tapped_barrel"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name("standing", pTappedBarrel), this.file(IcariaIdents.ID, "template_standing_tapped_barrel"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pBarrel, "front"))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
	}

	public void tripleBarrelRack(Block pBlock, Block pBarrel, Block pLog, Block pPlanks) {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.ID, "template_triple_barrel_rack_inventory"))
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pBarrel, "front"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name(pBlock, "top_left"), this.file(IcariaIdents.ID, "template_triple_barrel_rack_top_left"))
			.renderType("cutout")
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("barrel_back", this.file(pBarrel, "back"))
			.texture("barrel_front", this.file(pBarrel, "front"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
		this.withExistingParent(this.name(pBlock, "top_right"), this.file(IcariaIdents.ID, "template_triple_barrel_rack_top_right"))
			.renderType("cutout")
			.texture("particle", this.file(pPlanks));
	}

	public void trough(Block pName, Block pLog, Block pPlanks) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_trough"))
			.texture("anvil", this.file(IcariaIdents.MC, "anvil"))
			.texture("log", this.file(pLog))
			.texture("planks", this.file(pPlanks))
			.texture("particle", this.file(pPlanks));
	}

	public void craftingTable(Block pBlock, Block pPlanks) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube"))
			.texture("north", this.file(pBlock, "front"))
			.texture("east", this.file(pBlock, "side"))
			.texture("south", this.file(pBlock, "side"))
			.texture("west", this.file(pBlock, "front"))
			.texture("up", this.file(pBlock, "top"))
			.texture("down", this.file(pPlanks))
			.texture("particle", this.file(pBlock, "front"));
	}

	public void door(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "bottom_left"), this.file(IcariaIdents.MC, "door_bottom_left"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
		this.withExistingParent(this.name(pBlock, "bottom_left_open"), this.file(IcariaIdents.MC, "door_bottom_left_open"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
		this.withExistingParent(this.name(pBlock, "bottom_right"), this.file(IcariaIdents.MC, "door_bottom_right"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
		this.withExistingParent(this.name(pBlock, "bottom_right_open"), this.file(IcariaIdents.MC, "door_bottom_right_open"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
		this.withExistingParent(this.name(pBlock, "top_left"), this.file(IcariaIdents.MC, "door_top_left"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
		this.withExistingParent(this.name(pBlock, "top_left_open"), this.file(IcariaIdents.MC, "door_top_left_open"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
		this.withExistingParent(this.name(pBlock, "top_right"), this.file(IcariaIdents.MC, "door_top_right"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
		this.withExistingParent(this.name(pBlock, "top_right_open"), this.file(IcariaIdents.MC, "door_top_right_open"))
			.renderType("cutout")
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("top", this.file(pBlock, "top"))
			.texture("particle", this.file(pBlock, "bottom"));
	}

	public void trapdoor(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "bottom"), this.file(IcariaIdents.MC, "template_orientable_trapdoor_bottom"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "open"), this.file(IcariaIdents.MC, "template_orientable_trapdoor_open"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "top"), this.file(IcariaIdents.MC, "template_orientable_trapdoor_top"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void ladder(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "ladder"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void oliveLeaves(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "cube_all"))
			.texture("all", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name("black", pBlock), this.file(IcariaIdents.MC, "cube_all"))
			.texture("all", this.file("black", pBlock))
			.texture("particle", this.file("black", pBlock));
		this.withExistingParent(this.name("green", pBlock), this.file(IcariaIdents.MC, "cube_all"))
			.texture("all", this.file("green", pBlock))
			.texture("particle", this.file("green", pBlock));
	}

	public void bloomyVine(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name("blooming", pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file("blooming", pBlock))
			.texture("particle", this.file("blooming", pBlock));
		this.withExistingParent(this.name("dead", pBlock), this.file(IcariaIdents.ID, "template_dead_vine"))
			.renderType("cutout")
			.texture("texture", this.file("dead", pBlock))
			.texture("particle", this.file("dead", pBlock));
		this.withExistingParent(this.name("growing", pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file("growing", pBlock, "overlay"))
			.texture("texture", this.file("growing", pBlock))
			.texture("particle", this.file("growing", pBlock));
		this.withExistingParent(this.name("ripe", pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file("ripe", pBlock))
			.texture("particle", this.file("ripe", pBlock));
	}

	public void vineWithOverlayTexture(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name("dead", pBlock), this.file(IcariaIdents.ID, "template_dead_vine"))
			.renderType("cutout")
			.texture("texture", this.file("dead", pBlock))
			.texture("particle", this.file("dead", pBlock));
		this.withExistingParent(this.name("growing", pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file("growing", pBlock, "overlay"))
			.texture("texture", this.file("growing", pBlock))
			.texture("particle", this.file("growing", pBlock));
	}

	public void brushyVine(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name("dead", pBlock), this.file(IcariaIdents.ID, "template_dead_vine"))
			.renderType("cutout")
			.texture("texture", this.file("dead", pBlock))
			.texture("particle", this.file("dead", pBlock));
		this.withExistingParent(this.name("growing", pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file("growing", pBlock, "overlay"))
			.texture("texture", this.file("growing", pBlock))
			.texture("particle", this.file("growing", pBlock));
		this.withExistingParent(this.name("ripe", pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_vine"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file("ripe", pBlock))
			.texture("particle", this.file("ripe", pBlock));
	}

	public void vine(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "vine"))
			.renderType("cutout")
			.texture("vine", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name("dead", pBlock), this.file(IcariaIdents.MC, "vine"))
			.renderType("cutout")
			.texture("vine", this.file("dead", pBlock))
			.texture("particle", this.file("dead", pBlock));
		this.withExistingParent(this.name("growing", pBlock), this.file(IcariaIdents.MC, "vine"))
			.renderType("cutout")
			.texture("vine", this.file("growing", pBlock))
			.texture("particle", this.file("growing", pBlock));
	}

	public void tintedCross(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.MC, "tinted_cross"))
			.renderType("cutout")
			.texture("cross", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void tintedFlowerPotCross(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.MC, "tinted_flower_pot_cross"))
			.renderType("cutout")
			.texture("plant", this.file(pFile))
			.texture("particle", this.file(pFile));
	}

	public void overlayTextureCrossModel(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_overlay_texture_cross"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "overlay"));
	}

	public void overlayTextureFlowerPotCrossModel(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_overlay_texture_flower_pot_cross"))
			.renderType("cutout")
			.texture("dirt", this.file(IcariaIdents.MC, "dirt"))
			.texture("overlay", this.file(pFile, "overlay"))
			.texture("pot", this.file(IcariaIdents.MC, "flower_pot"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(IcariaIdents.MC, "flower_pot"));
	}

	public void bolbos(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_bolbos"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void dathulla(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_dathulla"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void mondanos(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_mondanos"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void mothAgaric(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_moth_agaric"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void namdrake(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_namdrake"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void psilocybos(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_psilocybos"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void rowan(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_rowan"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void wiltedElm(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_wilted_elm"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void groundFlower(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_ground_flower"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "0"))
			.texture("particle", this.file(pBlock, "0"));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_ground_flower"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "1"))
			.texture("particle", this.file(pBlock, "1"));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_ground_flower"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "2"))
			.texture("particle", this.file(pBlock, "2"));
	}

	public void moss(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_layer_1"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_layer_2"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "3"), this.file(IcariaIdents.ID, "template_layer_3"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "4"), this.file(IcariaIdents.ID, "template_layer_4"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "5"), this.file(IcariaIdents.ID, "template_layer_5"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "6"), this.file(IcariaIdents.ID, "template_layer_6"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "7"), this.file(IcariaIdents.ID, "template_layer_7"))
			.texture("texture", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "8"), this.file(IcariaIdents.ID, "template_layer_8"))
			.texture("texture", this.file(pBlock));
	}

	public void palmFern(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_palm_fern"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "overlay"));
	}

	public void pottedPalmFern(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_potted_palm_fern"))
			.renderType("cutout")
			.texture("dirt", this.file(IcariaIdents.MC, "dirt"))
			.texture("overlay", this.file(pFile, "overlay"))
			.texture("pot", this.file(IcariaIdents.MC, "flower_pot"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(IcariaIdents.MC, "flower_pot"));
	}

	public void bromelia(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_bromelia"))
			.renderType("cutout")
			.texture("overlay", this.file(pBlock, "overlay"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock, "overlay"));
	}

	public void pottedBromelia(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_potted_bromelia"))
			.renderType("cutout")
			.texture("dirt", this.file(IcariaIdents.MC, "dirt"))
			.texture("overlay", this.file(pFile, "overlay"))
			.texture("pot", this.file(IcariaIdents.MC, "flower_pot"))
			.texture("texture", this.file(pFile))
			.texture("particle", this.file(IcariaIdents.MC, "flower_pot"));
	}

	public void greenGroundShrooms(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_green_ground_shrooms_0"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_green_ground_shrooms_1"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_green_ground_shrooms_2"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
	}

	public void pottedGreenGroundShrooms(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_potted_green_ground_shrooms"))
			.texture("dirt", this.file(IcariaIdents.MC, "dirt"))
			.texture("pot", this.file(IcariaIdents.MC, "flower_pot"))
			.texture("shroom", this.file(pFile))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(IcariaIdents.MC, "flower_pot"));
	}

	public void brownGroundShrooms(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_brown_ground_shrooms_0"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_brown_ground_shrooms_1"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_brown_ground_shrooms_2"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
	}

	public void pottedBrownGroundShrooms(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_potted_brown_ground_shrooms"))
			.texture("dirt", this.file(IcariaIdents.MC, "dirt"))
			.texture("pot", this.file(IcariaIdents.MC, "flower_pot"))
			.texture("shroom", this.file(pFile))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(IcariaIdents.MC, "flower_pot"));
	}

	public void largeBrownGroundShrooms(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_large_brown_ground_shrooms_0"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_large_brown_ground_shrooms_1"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_large_brown_ground_shrooms_2"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(pBlock));
	}

	public void pottedLargeBrownGroundShrooms(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_potted_large_brown_ground_shrooms"))
			.texture("dirt", this.file(IcariaIdents.MC, "dirt"))
			.texture("pot", this.file(IcariaIdents.MC, "flower_pot"))
			.texture("shroom", this.file(pFile))
			.texture("stem", this.file(IcariaIdents.ID, "stem_ground_shrooms"))
			.texture("particle", this.file(IcariaIdents.MC, "flower_pot"));
	}

	public void tinderFungusTreeShrooms(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_0"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_1"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_tinder_fungus_tree_shrooms_2"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void turkeyTailTreeShrooms(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_0"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_1"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_turkey_tail_tree_shrooms_2"))
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void unnamedTreeShrooms(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_unnamed_tree_shrooms_0"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_tree_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_unnamed_tree_shrooms_1"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_tree_shrooms"))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_unnamed_tree_shrooms_2"))
			.texture("shroom", this.file(pBlock))
			.texture("stem", this.file(IcariaIdents.ID, "stem_tree_shrooms"))
			.texture("particle", this.file(pBlock));
	}

	public void cardonCactus(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "inventory"), this.file(IcariaIdents.ID, "template_cardon_cactus_inventory"))
			.texture("bottom", this.file(pBlock, "bottom"))
			.texture("side", this.file(pBlock, "side"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name(pBlock, "cube"), this.file(IcariaIdents.ID, "template_cardon_cactus_cube"))
			.texture("texture", this.file(pBlock, "side"))
			.texture("particle", this.file(pBlock, "side"));
		this.withExistingParent(this.name(pBlock, "stem"), this.file(IcariaIdents.ID, "template_cardon_cactus_stem"))
			.texture("texture", this.file(pBlock, "side"))
			.texture("particle", this.file(pBlock, "side"));
	}

	public void pottedCardonCactus(Block pName, Block pFile) {
		this.withExistingParent(this.name(pName), this.file(IcariaIdents.ID, "template_potted_cardon_cactus"))
			.texture("dirt", this.file(IcariaIdents.MC, "dirt"))
			.texture("pot", this.file(IcariaIdents.MC, "flower_pot"))
			.texture("cactus", this.file(pFile, "side"))
			.texture("particle", this.file(IcariaIdents.MC, "flower_pot"));
	}

	public void strawberryBush(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "0"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_0"))
			.texture("particle", this.file(pBlock, "horizontal_0"));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "1"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_1"))
			.texture("particle", this.file(pBlock, "horizontal_1"));
	}

	public void crop(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "0"))
			.texture("particle", this.file(pBlock, "0"));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "1"))
			.texture("particle", this.file(pBlock, "1"));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "2"))
			.texture("particle", this.file(pBlock, "2"));
		this.withExistingParent(this.name(pBlock, "3"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "3"))
			.texture("particle", this.file(pBlock, "3"));
		this.withExistingParent(this.name(pBlock, "4"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "4"))
			.texture("particle", this.file(pBlock, "4"));
		this.withExistingParent(this.name(pBlock, "5"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "5"))
			.texture("particle", this.file(pBlock, "5"));
		this.withExistingParent(this.name(pBlock, "6"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "6"))
			.texture("particle", this.file(pBlock, "6"));
		this.withExistingParent(this.name(pBlock, "7"), this.file(IcariaIdents.MC, "crop"))
			.renderType("cutout")
			.texture("crop", this.file(pBlock, "7"))
			.texture("particle", this.file(pBlock, "7"));
	}

	public void strawberryCrop(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "0"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_0"))
			.texture("particle", this.file(pBlock, "horizontal_0"));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "1"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_1"))
			.texture("particle", this.file(pBlock, "horizontal_1"));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "1"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_1"))
			.texture("particle", this.file(pBlock, "horizontal_1"));
		this.withExistingParent(this.name(pBlock, "3"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "2"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_2"))
			.texture("particle", this.file(pBlock, "horizontal_2"));
		this.withExistingParent(this.name(pBlock, "4"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "2"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_2"))
			.texture("particle", this.file(pBlock, "horizontal_2"));
		this.withExistingParent(this.name(pBlock, "5"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "3"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_3"))
			.texture("particle", this.file(pBlock, "horizontal_3"));
		this.withExistingParent(this.name(pBlock, "6"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "3"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_3"))
			.texture("particle", this.file(pBlock, "horizontal_3"));
		this.withExistingParent(this.name(pBlock, "7"), this.file(IcariaIdents.ID, "template_strawberry_bush"))
			.renderType("cutout")
			.texture("bush", this.file(pBlock, "4"))
			.texture("bush_horizontal", this.file(pBlock, "horizontal_4"))
			.texture("particle", this.file(pBlock, "horizontal_4"));
	}

	public void physalisCrop(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "0"), this.file(IcariaIdents.ID, "template_physalis_crop_0"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "0"))
			.texture("particle", this.file(pBlock, "0"));
		this.withExistingParent(this.name(pBlock, "1"), this.file(IcariaIdents.ID, "template_physalis_crop_1"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "1"))
			.texture("particle", this.file(pBlock, "1"));
		this.withExistingParent(this.name(pBlock, "2"), this.file(IcariaIdents.ID, "template_physalis_crop_1"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "1"))
			.texture("particle", this.file(pBlock, "1"));
		this.withExistingParent(this.name(pBlock, "3"), this.file(IcariaIdents.ID, "template_physalis_crop_2"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "2"))
			.texture("particle", this.file(pBlock, "2"));
		this.withExistingParent(this.name(pBlock, "4"), this.file(IcariaIdents.ID, "template_physalis_crop_2"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "2"))
			.texture("particle", this.file(pBlock, "2"));
		this.withExistingParent(this.name(pBlock, "5"), this.file(IcariaIdents.ID, "template_physalis_crop_3"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "3"))
			.texture("particle", this.file(pBlock, "3"));
		this.withExistingParent(this.name(pBlock, "6"), this.file(IcariaIdents.ID, "template_physalis_crop_3"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "3"))
			.texture("particle", this.file(pBlock, "3"));
		this.withExistingParent(this.name(pBlock, "7"), this.file(IcariaIdents.ID, "template_physalis_crop_4"))
			.renderType("cutout")
			.texture("texture", this.file(pBlock, "4"))
			.texture("particle", this.file(pBlock, "4"));
	}

	public void water(Block pBlock) {
		this.getBuilder(this.name(pBlock));
	}

	public void fire(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "floor_0"), this.file(IcariaIdents.MC, "template_fire_floor"))
			.renderType("cutout")
			.texture("fire", this.file(pBlock, "0"))
			.texture("particle", this.file(pBlock, "0"));
		this.withExistingParent(this.name(pBlock, "floor_1"), this.file(IcariaIdents.MC, "template_fire_floor"))
			.renderType("cutout")
			.texture("fire", this.file(pBlock, "1"))
			.texture("particle", this.file(pBlock, "1"));
		this.withExistingParent(this.name(pBlock, "side_0"), this.file(IcariaIdents.MC, "template_fire_side"))
			.renderType("cutout")
			.texture("fire", this.file(pBlock, "0"))
			.texture("particle", this.file(pBlock, "0"));
		this.withExistingParent(this.name(pBlock, "side_1"), this.file(IcariaIdents.MC, "template_fire_side"))
			.renderType("cutout")
			.texture("fire", this.file(pBlock, "1"))
			.texture("particle", this.file(pBlock, "1"));
		this.withExistingParent(this.name(pBlock, "side_alt_0"), this.file(IcariaIdents.MC, "template_fire_side_alt"))
			.renderType("cutout")
			.texture("fire", this.file(pBlock, "0"))
			.texture("particle", this.file(pBlock, "0"));
		this.withExistingParent(this.name(pBlock, "side_alt_1"), this.file(IcariaIdents.MC, "template_fire_side_alt"))
			.renderType("cutout")
			.texture("fire", this.file(pBlock, "1"))
			.texture("particle", this.file(pBlock, "1"));
	}

	public void portal(Block pBlock) {
		this.withExistingParent(this.name(pBlock, "x"), this.file(IcariaIdents.ID, "template_portal_x"))
			.renderType("translucent")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
		this.withExistingParent(this.name(pBlock, "z"), this.file(IcariaIdents.ID, "template_portal_z"))
			.renderType("translucent")
			.texture("texture", this.file(pBlock))
			.texture("particle", this.file(pBlock));
	}

	public void grinderShaft(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_grinder_shaft"))
			.texture("texture", this.file(IcariaIdents.ID, "grinder"))
			.texture("particle", this.file(IcariaIdents.ID, "grinder"));
	}

	public void grinderStone(Block pBlock) {
		this.withExistingParent(this.name(pBlock), this.file(IcariaIdents.ID, "template_grinder_stone"))
			.texture("grinder_stone", this.file(IcariaIdents.ID, "grinder_stone"))
			.texture("voidshale", this.file(IcariaIdents.ID, "voidshale"))
			.texture("particle", this.file(IcariaIdents.ID, "voidshale"));
	}

	public ModelFile.UncheckedModelFile getVanilla(String pPath) {
		return new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(IcariaIdents.MC, ModelProvider.BLOCK_FOLDER + "/" + pPath));
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

	public String id(Block pBlock) {
		return BuiltInRegistries.BLOCK.getKey(pBlock).getNamespace();
	}

	public String name(Block pBlock) {
		return BuiltInRegistries.BLOCK.getKey(pBlock).getPath();
	}

	public String name(Block pBlock, String pSuffix) {
		return BuiltInRegistries.BLOCK.getKey(pBlock).getPath() + "_" + pSuffix;
	}

	public String name(String pPrefix, Block pBlock) {
		return pPrefix + "_" + BuiltInRegistries.BLOCK.getKey(pBlock).getPath();
	}

	public String name(String pPrefix, Block pBlock, String pSuffix) {
		return pPrefix + "_" + BuiltInRegistries.BLOCK.getKey(pBlock).getPath() + "_" + pSuffix;
	}
}
