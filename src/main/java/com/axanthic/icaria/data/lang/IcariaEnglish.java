package com.axanthic.icaria.data.lang;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaMobEffects;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.data.PackOutput;

import net.minecraftforge.common.data.LanguageProvider;

public class IcariaEnglish extends LanguageProvider {
	public IcariaEnglish(PackOutput pOutput, String pId, String pLanguage) {
		super(pOutput, pId, pLanguage);
	}

	@Override
	public void addTranslations() {
		// BLOCKS
		this.add(IcariaBlocks.MARL_GRASS.get(), "Grassy Marl");
		this.add(IcariaBlocks.MARL.get(), "Marl");
		this.add(IcariaBlocks.MARL_CHERT.get(), "Chert Ore");
		this.add(IcariaBlocks.SURFACE_CHERT.get(), "Chert Rubble");
		this.add(IcariaBlocks.MARL_BONES.get(), "Rotten Bones");
		this.add(IcariaBlocks.SURFACE_BONES.get(), "Bone Remains");
		this.add(IcariaBlocks.MARL_LIGNITE.get(), "Lignite Ore");
		this.add(IcariaBlocks.MARL_COARSE.get(), "Coarse Marl");

		this.add(IcariaBlocks.FARMLAND.get(), "Farmland");
		this.add(IcariaBlocks.FARMLAND_FERTILIZED.get(), "Fertilized Farmland");

		this.add(IcariaBlocks.MARL_ADOBE.get(), "Marl Adobe");
		this.add(IcariaBlocks.MARL_ADOBE_DECO.stairs.get(), "Marl Adobe Stairs");
		this.add(IcariaBlocks.MARL_ADOBE_DECO.slab.get(), "Marl Adobe Slab");
		this.add(IcariaBlocks.MARL_ADOBE_DECO.wall.get(), "Marl Adobe Wall");

		this.add(IcariaBlocks.LOAM.get(), "Loam");
		this.add(IcariaBlocks.LOAM_BRICKS.get(), "Loam Bricks");
		this.add(IcariaBlocks.LOAM_BRICKS_DECO.stairs.get(), "Loam Brick Stairs");
		this.add(IcariaBlocks.LOAM_BRICKS_DECO.slab.get(), "Loam Brick Slab");
		this.add(IcariaBlocks.LOAM_BRICKS_DECO.wall.get(), "Loam Brick Wall");

		this.add(IcariaBlocks.DOLOMITE_ADOBE.get(), "Dolomite Adobe");
		this.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get(), "Dolomite Adobe Stairs");
		this.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get(), "Dolomite Adobe Slab");
		this.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.wall.get(), "Dolomite Adobe Wall");
		this.add(IcariaBlocks.DOLOMITE_SMOOTH.get(), "Smooth Dolomite");
		this.add(IcariaBlocks.DOLOMITE_SMOOTH_DECO.stairs.get(), "Smooth Dolomite Stairs");
		this.add(IcariaBlocks.DOLOMITE_SMOOTH_DECO.slab.get(), "Smooth Dolomite Slab");
		this.add(IcariaBlocks.DOLOMITE_SMOOTH_DECO.wall.get(), "Smooth Dolomite Wall");
		this.add(IcariaBlocks.DOLOMITE_BRICKS.get(), "Dolomite Bricks");
		this.add(IcariaBlocks.DOLOMITE_PILLAR.get(), "Dolomite Pillar");
		this.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), "Dolomite Pillar Head");

		this.add(IcariaBlocks.GRAINEL.get(), "Grainel");
		this.add(IcariaBlocks.GRAINEL_CHERT.get(), "Chert Ore");
		this.add(IcariaBlocks.GRAINGLASS.get(), "Grainglass");
		this.add(IcariaBlocks.GRAINGLASS_PANE.get(), "Grainglass Pane");
		this.add(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get(), "Horizontal Grainglass Pane");
		this.add(IcariaBlocks.GRAINITE_ADOBE.get(), "Grainite Adobe");
		this.add(IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), "Grainite Adobe Stairs");
		this.add(IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get(), "Grainite Adobe Slab");
		this.add(IcariaBlocks.GRAINITE_ADOBE_DECO.wall.get(), "Grainite Adobe Wall");
		this.add(IcariaBlocks.GRAINITE.get(), "Grainite");
		this.add(IcariaBlocks.GRAINITE_DECO.stairs.get(), "Grainite Stairs");
		this.add(IcariaBlocks.GRAINITE_DECO.slab.get(), "Grainite Slab");
		this.add(IcariaBlocks.GRAINITE_DECO.wall.get(), "Grainite Wall");
		this.add(IcariaBlocks.GRAINITE_BRICKS.get(), "Grainite Bricks");
		this.add(IcariaBlocks.GRAINITE_BRICKS_DECO.stairs.get(), "Grainite Brick Stairs");
		this.add(IcariaBlocks.GRAINITE_BRICKS_DECO.slab.get(), "Grainite Brick Slab");
		this.add(IcariaBlocks.GRAINITE_BRICKS_DECO.wall.get(), "Grainite Brick Wall");
		this.add(IcariaBlocks.GRAINITE_CHISELED.get(), "Chiseled Grainite");
		this.add(IcariaBlocks.GRAINITE_RUBBLE.get(), "Grainite Rubble");

		this.add(IcariaBlocks.YELLOWSTONE_ADOBE.get(), "Yellowstone Adobe");
		this.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), "Yellowstone Adobe Stairs");
		this.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), "Yellowstone Adobe Slab");
		this.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.wall.get(), "Yellowstone Adobe Wall");
		this.add(IcariaBlocks.YELLOWSTONE_COBBLE.get(), "Cobbled Yellowstone");
		this.add(IcariaBlocks.YELLOWSTONE_COBBLE_DECO.stairs.get(), "Cobbled Yellowstone Stairs");
		this.add(IcariaBlocks.YELLOWSTONE_COBBLE_DECO.slab.get(), "Cobbled Yellowstone Slab");
		this.add(IcariaBlocks.YELLOWSTONE_COBBLE_DECO.wall.get(), "Cobbled Yellowstone Wall");
		this.add(IcariaBlocks.YELLOWSTONE.get(), "Yellowstone");
		this.add(IcariaBlocks.YELLOWSTONE_DECO.stairs.get(), "Yellowstone Stairs");
		this.add(IcariaBlocks.YELLOWSTONE_DECO.slab.get(), "Yellowstone Slab");
		this.add(IcariaBlocks.YELLOWSTONE_DECO.wall.get(), "Yellowstone Wall");
		this.add(IcariaBlocks.YELLOWSTONE_BRICKS.get(), "Yellowstone Bricks");
		this.add(IcariaBlocks.YELLOWSTONE_BRICKS_DECO.stairs.get(), "Yellowstone Brick Stairs");
		this.add(IcariaBlocks.YELLOWSTONE_BRICKS_DECO.slab.get(), "Yellowstone Brick Slab");
		this.add(IcariaBlocks.YELLOWSTONE_BRICKS_DECO.wall.get(), "Yellowstone Brick Wall");
		this.add(IcariaBlocks.YELLOWSTONE_CHISELED.get(), "Chiseled Yellowstone");
		this.add(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), "Yellowstone Rubble");

		this.add(IcariaBlocks.SILKSAND.get(), "Silksand");
		this.add(IcariaBlocks.SILKGLASS.get(), "Silkglass");
		this.add(IcariaBlocks.SILKGLASS_PANE.get(), "Silkglass Pane");
		this.add(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get(), "Horizontal Silkglass Pane");
		this.add(IcariaBlocks.SILKSTONE_ADOBE.get(), "Silkstone Adobe");
		this.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get(), "Silkstone Adobe Stairs");
		this.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get(), "Silkstone Adobe Slab");
		this.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.wall.get(), "Silkstone Adobe Wall");
		this.add(IcariaBlocks.SILKSTONE_COBBLE.get(), "Cobbled Silkstone");
		this.add(IcariaBlocks.SILKSTONE_COBBLE_DECO.stairs.get(), "Cobbled Silkstone Stairs");
		this.add(IcariaBlocks.SILKSTONE_COBBLE_DECO.slab.get(), "Cobbled Silkstone Slab");
		this.add(IcariaBlocks.SILKSTONE_COBBLE_DECO.wall.get(), "Cobbled Silkstone Wall");
		this.add(IcariaBlocks.SILKSTONE.get(), "Silkstone");
		this.add(IcariaBlocks.SILKSTONE_DECO.stairs.get(), "Silkstone Stairs");
		this.add(IcariaBlocks.SILKSTONE_DECO.slab.get(), "Silkstone Slab");
		this.add(IcariaBlocks.SILKSTONE_DECO.wall.get(), "Silkstone Wall");
		this.add(IcariaBlocks.SILKSTONE_BRICKS.get(), "Silkstone Bricks");
		this.add(IcariaBlocks.SILKSTONE_BRICKS_DECO.stairs.get(), "Silkstone Brick Stairs");
		this.add(IcariaBlocks.SILKSTONE_BRICKS_DECO.slab.get(), "Silkstone Brick Slab");
		this.add(IcariaBlocks.SILKSTONE_BRICKS_DECO.wall.get(), "Silkstone Brick Wall");
		this.add(IcariaBlocks.SILKSTONE_CHISELED.get(), "Chiseled Silkstone");
		this.add(IcariaBlocks.SILKSTONE_RUBBLE.get(), "Silkstone Rubble");

		this.add(IcariaBlocks.SUNSTONE_ADOBE.get(), "Sunstone Adobe");
		this.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), "Sunstone Adobe Stairs");
		this.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get(), "Sunstone Adobe Slab");
		this.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.wall.get(), "Sunstone Adobe Wall");
		this.add(IcariaBlocks.SUNSTONE_COBBLE.get(), "Cobbled Sunstone");
		this.add(IcariaBlocks.SUNSTONE_COBBLE_DECO.stairs.get(), "Cobbled Sunstone Stairs");
		this.add(IcariaBlocks.SUNSTONE_COBBLE_DECO.slab.get(), "Cobbled Sunstone Slab");
		this.add(IcariaBlocks.SUNSTONE_COBBLE_DECO.wall.get(), "Cobbled Sunstone Wall");
		this.add(IcariaBlocks.SUNSTONE.get(), "Sunstone");
		this.add(IcariaBlocks.SUNSTONE_DECO.stairs.get(), "Sunstone Stairs");
		this.add(IcariaBlocks.SUNSTONE_DECO.slab.get(), "Sunstone Slab");
		this.add(IcariaBlocks.SUNSTONE_DECO.wall.get(), "Sunstone Wall");
		this.add(IcariaBlocks.SUNSTONE_BRICKS.get(), "Sunstone Bricks");
		this.add(IcariaBlocks.SUNSTONE_BRICKS_DECO.stairs.get(), "Sunstone Brick Stairs");
		this.add(IcariaBlocks.SUNSTONE_BRICKS_DECO.slab.get(), "Sunstone Brick Slab");
		this.add(IcariaBlocks.SUNSTONE_BRICKS_DECO.wall.get(), "Sunstone Brick Wall");
		this.add(IcariaBlocks.SUNSTONE_CHISELED.get(), "Chiseled Sunstone");
		this.add(IcariaBlocks.SUNSTONE_RUBBLE.get(), "Sunstone Rubble");

		this.add(IcariaBlocks.VOIDSHALE_ADOBE.get(), "Voidshale Adobe");
		this.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), "Voidshale Adobe Stairs");
		this.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get(), "Voidshale Adobe Slab");
		this.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.wall.get(), "Voidshale Adobe Wall");
		this.add(IcariaBlocks.VOIDSHALE_COBBLE.get(), "Cobbled Voidshale");
		this.add(IcariaBlocks.VOIDSHALE_COBBLE_DECO.stairs.get(), "Cobbled Voidshale Stairs");
		this.add(IcariaBlocks.VOIDSHALE_COBBLE_DECO.slab.get(), "Cobbled Voidshale Slab");
		this.add(IcariaBlocks.VOIDSHALE_COBBLE_DECO.wall.get(), "Cobbled Voidshale Wall");
		this.add(IcariaBlocks.VOIDSHALE.get(), "Voidshale");
		this.add(IcariaBlocks.VOIDSHALE_DECO.stairs.get(), "Voidshale Stairs");
		this.add(IcariaBlocks.VOIDSHALE_DECO.slab.get(), "Voidshale Slab");
		this.add(IcariaBlocks.VOIDSHALE_DECO.wall.get(), "Voidshale Wall");
		this.add(IcariaBlocks.VOIDSHALE_BRICKS.get(), "Voidshale Bricks");
		this.add(IcariaBlocks.VOIDSHALE_BRICKS_DECO.stairs.get(), "Voidshale Brick Stairs");
		this.add(IcariaBlocks.VOIDSHALE_BRICKS_DECO.slab.get(), "Voidshale Brick Slab");
		this.add(IcariaBlocks.VOIDSHALE_BRICKS_DECO.wall.get(), "Voidshale Brick Wall");
		this.add(IcariaBlocks.VOIDSHALE_CHISELED.get(), "Chiseled Voidshale");
		this.add(IcariaBlocks.VOIDSHALE_RUBBLE.get(), "Voidshale Rubble");

		this.add(IcariaBlocks.BAETYL_ADOBE.get(), "Baetyl Adobe");
		this.add(IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get(), "Baetyl Adobe Stairs");
		this.add(IcariaBlocks.BAETYL_ADOBE_DECO.slab.get(), "Baetyl Adobe Slab");
		this.add(IcariaBlocks.BAETYL_ADOBE_DECO.wall.get(), "Baetyl Adobe Wall");
		this.add(IcariaBlocks.BAETYL_COBBLE.get(), "Cobbled Baetyl");
		this.add(IcariaBlocks.BAETYL_COBBLE_DECO.stairs.get(), "Cobbled Baetyl Stairs");
		this.add(IcariaBlocks.BAETYL_COBBLE_DECO.slab.get(), "Cobbled Baetyl Slab");
		this.add(IcariaBlocks.BAETYL_COBBLE_DECO.wall.get(), "Cobbled Baetyl Wall");
		this.add(IcariaBlocks.BAETYL.get(), "Baetyl");
		this.add(IcariaBlocks.BAETYL_DECO.stairs.get(), "Baetyl Stairs");
		this.add(IcariaBlocks.BAETYL_DECO.slab.get(), "Baetyl Slab");
		this.add(IcariaBlocks.BAETYL_DECO.wall.get(), "Baetyl Wall");
		this.add(IcariaBlocks.BAETYL_BRICKS.get(), "Baetyl Bricks");
		this.add(IcariaBlocks.BAETYL_BRICKS_DECO.stairs.get(), "Baetyl Brick Stairs");
		this.add(IcariaBlocks.BAETYL_BRICKS_DECO.slab.get(), "Baetyl Brick Slab");
		this.add(IcariaBlocks.BAETYL_BRICKS_DECO.wall.get(), "Baetyl Brick Wall");
		this.add(IcariaBlocks.BAETYL_CHISELED.get(), "Chiseled Baetyl");
		this.add(IcariaBlocks.BAETYL_RUBBLE.get(), "Baetyl Rubble");

		this.add(IcariaBlocks.RELICSTONE.get(), "Relicstone");
		this.add(IcariaBlocks.RELICSTONE_DECO.stairs.get(), "Relicstone Stairs");
		this.add(IcariaBlocks.RELICSTONE_DECO.slab.get(), "Relicstone Slab");
		this.add(IcariaBlocks.RELICSTONE_DECO.wall.get(), "Relicstone Wall");
		this.add(IcariaBlocks.RELICSTONE_SMOOTH.get(), "Smooth Relicstone");
		this.add(IcariaBlocks.RELICSTONE_SMOOTH_DECO.stairs.get(), "Smooth Relicstone Stairs");
		this.add(IcariaBlocks.RELICSTONE_SMOOTH_DECO.slab.get(), "Smooth Relicstone Slab");
		this.add(IcariaBlocks.RELICSTONE_SMOOTH_DECO.wall.get(), "Smooth Relicstone Wall");
		this.add(IcariaBlocks.RELICSTONE_BRICKS.get(), "Relicstone Bricks");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_DECO.stairs.get(), "Relicstone Brick Stairs");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_DECO.slab.get(), "Relicstone Brick Slab");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_DECO.wall.get(), "Relicstone Brick Wall");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_CRACKED.get(), "Cracked Relicstone Bricks");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO.stairs.get(), "Cracked Relicstone Brick Stairs");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO.slab.get(), "Cracked Relicstone Brick Slab");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_CRACKED_DECO.wall.get(), "Cracked Relicstone Brick Wall");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_MOSSY.get(), "Mossy Relicstone Bricks");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO.stairs.get(), "Mossy Relicstone Brick Stairs");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO.slab.get(), "Mossy Relicstone Brick Slab");
		this.add(IcariaBlocks.RELICSTONE_BRICKS_MOSSY_DECO.wall.get(), "Mossy Relicstone Brick Wall");
		this.add(IcariaBlocks.RELICSTONE_TILES.get(), "Relicstone Tiles");
		this.add(IcariaBlocks.RELICSTONE_TILES_DECO.stairs.get(), "Relicstone Tile Stairs");
		this.add(IcariaBlocks.RELICSTONE_TILES_DECO.slab.get(), "Relicstone Tile Slab");
		this.add(IcariaBlocks.RELICSTONE_TILES_DECO.wall.get(), "Relicstone Tile Wall");
		this.add(IcariaBlocks.RELICSTONE_TILES_CRACKED.get(), "Cracked Relicstone Tiles");
		this.add(IcariaBlocks.RELICSTONE_TILES_CRACKED_DECO.stairs.get(), "Cracked Relicstone Tile Stairs");
		this.add(IcariaBlocks.RELICSTONE_TILES_CRACKED_DECO.slab.get(), "Cracked Relicstone Tile Slab");
		this.add(IcariaBlocks.RELICSTONE_TILES_CRACKED_DECO.wall.get(), "Cracked Relicstone Tile Wall");
		this.add(IcariaBlocks.RELICSTONE_TILES_MOSSY.get(), "Mossy Relicstone Tiles");
		this.add(IcariaBlocks.RELICSTONE_TILES_MOSSY_DECO.stairs.get(), "Mossy Relicstone Tile Stairs");
		this.add(IcariaBlocks.RELICSTONE_TILES_MOSSY_DECO.slab.get(), "Mossy Relicstone Tile Slab");
		this.add(IcariaBlocks.RELICSTONE_TILES_MOSSY_DECO.wall.get(), "Mossy Relicstone Tile Wall");
		this.add(IcariaBlocks.RELICSTONE_CHISELED.get(), "Chiseled Relicstone");
		this.add(IcariaBlocks.RELICSTONE_PILLAR.get(), "Relicstone Pillar");
		this.add(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), "Relicstone Pillar Head");
		this.add(IcariaBlocks.RELICSTONE_RUBBLE.get(), "Relicstone Rubble");

		this.add(IcariaBlocks.PLATOSHALE.get(), "Platoshale");
		this.add(IcariaBlocks.PLATOSHALE_DECO.stairs.get(), "Platoshale Stairs");
		this.add(IcariaBlocks.PLATOSHALE_DECO.slab.get(), "Platoshale Slab");
		this.add(IcariaBlocks.PLATOSHALE_DECO.wall.get(), "Platoshale Wall");
		this.add(IcariaBlocks.PLATOSHALE_BLURRED.get(), "Blurred Platoshale");
		this.add(IcariaBlocks.PLATOSHALE_BRICKS.get(), "Platoshale Bricks");
		this.add(IcariaBlocks.PLATOSHALE_BRICKS_DECO.stairs.get(), "Platoshale Brick Stairs");
		this.add(IcariaBlocks.PLATOSHALE_BRICKS_DECO.slab.get(), "Platoshale Brick Slab");
		this.add(IcariaBlocks.PLATOSHALE_BRICKS_DECO.wall.get(), "Platoshale Brick Wall");
		this.add(IcariaBlocks.PLATOSHALE_BRICKS_BLURRED.get(), "Blurred Platoshale Bricks");
		this.add(IcariaBlocks.PLATOSHALE_CHISELED.get(), "Chiseled Platoshale");

		this.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get(), "Quartz Pillar Head");

		this.add(IcariaBlocks.LIGNITE_ORE.get(), "Lignite Ore");
		this.add(IcariaBlocks.CHALKOS_ORE.get(), "Chalkos Ore");
		this.add(IcariaBlocks.KASSITEROS_ORE.get(), "Kassiteros Ore");
		this.add(IcariaBlocks.DOLOMITE_ORE.get(), "Dolomite Ore");
		this.add(IcariaBlocks.VANADIUM_ORE.get(), "Vanadium Ore");
		this.add(IcariaBlocks.SLIVER_ORE.get(), "Sliver Ore");
		this.add(IcariaBlocks.SIDEROS_ORE.get(), "Sideros Ore");
		this.add(IcariaBlocks.ANTHRACITE_ORE.get(), "Anthracite Ore");
		this.add(IcariaBlocks.MOLYBDENUM_ORE.get(), "Molybdenum Ore");
		this.add(IcariaBlocks.HYLIASTRUM_ORE.get(), "Hyliastrum Ore");

		this.add(IcariaBlocks.CALCITE_GEODE_BLOCK.get(), "Block of Calcite");
		this.add(IcariaBlocks.BUDDING_CALCITE_GEODE_BLOCK.get(), "Budding Calcite");
		this.add(IcariaBlocks.HALITE_GEODE_BLOCK.get(), "Block of Halite");
		this.add(IcariaBlocks.BUDDING_HALITE_GEODE_BLOCK.get(), "Budding Halite");
		this.add(IcariaBlocks.JASPER_GEODE_BLOCK.get(), "Block of Jasper");
		this.add(IcariaBlocks.BUDDING_JASPER_GEODE_BLOCK.get(), "Budding Jasper");
		this.add(IcariaBlocks.ZIRCON_GEODE_BLOCK.get(), "Block of Zircon");
		this.add(IcariaBlocks.BUDDING_ZIRCON_GEODE_BLOCK.get(), "Budding Zircon");

		this.add(IcariaBlocks.CALCITE_CRYSTAL.get(), "Calcite Crystal");
		this.add(IcariaBlocks.HALITE_CRYSTAL.get(), "Halite Crystal");
		this.add(IcariaBlocks.JASPER_CRYSTAL.get(), "Jasper Crystal");
		this.add(IcariaBlocks.ZIRCON_CRYSTAL.get(), "Zircon Crystal");

		this.add(IcariaBlocks.ARISTONE.get(), "Aristone");
		this.add(IcariaBlocks.ARISTONE_PACKED.get(), "Packed Aristone");

		this.add(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get(), "Block of Ender Jellyfish Jelly");
		this.add(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get(), "Block of Fire Jellyfish Jelly");
		this.add(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get(), "Block of Nature Jellyfish Jelly");
		this.add(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get(), "Block of Void Jellyfish Jelly");
		this.add(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get(), "Block of Water Jellyfish Jelly");
		this.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), "Block of Arachne String");
		this.add(IcariaBlocks.SPELT_BALE_BLOCK.get(), "Spelt Bale");
		this.add(IcariaBlocks.VINE_REED_BLOCK.get(), "Block of Vine Reed");
		this.add(IcariaBlocks.VINE_SPROUT_BLOCK.get(), "Block of Vine Sprout");
		this.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get(), "Block of Rotten Bones");

		this.add(IcariaBlocks.CHALKOS_RAW_BLOCK.get(), "Block of Raw Chalkos");
		this.add(IcariaBlocks.KASSITEROS_RAW_BLOCK.get(), "Block of Raw Kassiteros");
		this.add(IcariaBlocks.VANADIUM_RAW_BLOCK.get(), "Block of Raw Vanadium");
		this.add(IcariaBlocks.SLIVER_BLOCK.get(), "Block of Raw Sliver");
		this.add(IcariaBlocks.SIDEROS_RAW_BLOCK.get(), "Block of Raw Sideros");
		this.add(IcariaBlocks.MOLYBDENUM_RAW_BLOCK.get(), "Block of Raw Molybdenum");

		this.add(IcariaBlocks.CALCITE_BLOCK.get(), "Block of Calcite");
		this.add(IcariaBlocks.HALITE_BLOCK.get(), "Block of Halite");
		this.add(IcariaBlocks.JASPER_BLOCK.get(), "Block of Jasper");
		this.add(IcariaBlocks.ZIRCON_BLOCK.get(), "Block of Zircon");
		this.add(IcariaBlocks.CHERT_BLOCK.get(), "Block of Chert");
		this.add(IcariaBlocks.LIGNITE_BLOCK.get(), "Block of Lignite");
		this.add(IcariaBlocks.CHALKOS_BLOCK.get(), "Block of Chalkos");
		this.add(IcariaBlocks.KASSITEROS_BLOCK.get(), "Block of Kassiteros");
		this.add(IcariaBlocks.ORICHALCUM_BLOCK.get(), "Block of Orichalcum");
		this.add(IcariaBlocks.VANADIUM_BLOCK.get(), "Block of Vanadium");
		this.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get(), "Block of Vanadiumsteel");
		this.add(IcariaBlocks.SIDEROS_BLOCK.get(), "Block of Sideros");
		this.add(IcariaBlocks.ANTHRACITE_BLOCK.get(), "Block of Anthracite");
		this.add(IcariaBlocks.MOLYBDENUM_BLOCK.get(), "Block of Molybdenum");
		this.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get(), "Block of Molybdenumsteel");
		this.add(IcariaBlocks.BLURIDIUM_BLOCK.get(), "Block of Bluridium");

		this.add(IcariaBlocks.VANADIUMSTEEL_BARS.get(), "Vanadiumsteel Bars");
		this.add(IcariaBlocks.VANADIUMSTEEL_BARS_HORIZONTAL.get(), "Horizontal Vanadiumsteel Bars");

		this.add(IcariaBlocks.GRINDER.get(), "Grinder");

		this.add(IcariaBlocks.STORAGE_VASE.get(), "Storage Vase");
		this.add(IcariaBlocks.WHITE_STORAGE_VASE.get(), "White Storage Vase");
		this.add(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), "Light Gray Storage Vase");
		this.add(IcariaBlocks.GRAY_STORAGE_VASE.get(), "Gray Storage Vase");
		this.add(IcariaBlocks.BLACK_STORAGE_VASE.get(), "Black Storage Vase");
		this.add(IcariaBlocks.BROWN_STORAGE_VASE.get(), "Brown Storage Vase");
		this.add(IcariaBlocks.RED_STORAGE_VASE.get(), "Red Storage Vase");
		this.add(IcariaBlocks.ORANGE_STORAGE_VASE.get(), "Orange Storage Vase");
		this.add(IcariaBlocks.YELLOW_STORAGE_VASE.get(), "Yellow Storage Vase");
		this.add(IcariaBlocks.LIME_STORAGE_VASE.get(), "Lime Storage Vase");
		this.add(IcariaBlocks.GREEN_STORAGE_VASE.get(), "Green Storage Vase");
		this.add(IcariaBlocks.CYAN_STORAGE_VASE.get(), "Cyan Storage Vase");
		this.add(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), "Light Blue Storage Vase");
		this.add(IcariaBlocks.BLUE_STORAGE_VASE.get(), "Blue Storage Vase");
		this.add(IcariaBlocks.PURPLE_STORAGE_VASE.get(), "Purple Storage Vase");
		this.add(IcariaBlocks.MAGENTA_STORAGE_VASE.get(), "Magenta Storage Vase");
		this.add(IcariaBlocks.PINK_STORAGE_VASE.get(), "Pink Storage Vase");

		this.add(IcariaBlocks.AETERNAE_SKULL.get(), "Aeternae Skull");
		this.add(IcariaBlocks.ARGAN_HOUND_SKULL.get(), "Argan Hound Skull");
		this.add(IcariaBlocks.CATOBLEPAS_SKULL.get(), "Catoblepas Skull");
		this.add(IcariaBlocks.CERVER_SKULL.get(), "Cerver Skull");
		this.add(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get(), "Cypress Forest Hag Skull");
		this.add(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get(), "Droughtroot Forest Hag Skull");
		this.add(IcariaBlocks.FIR_FOREST_HAG_SKULL.get(), "Fir Forest Hag Skull");
		this.add(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get(), "Laurel Forest Hag Skull");
		this.add(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get(), "Olive Forest Hag Skull");
		this.add(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get(), "Plane Forest Hag Skull");
		this.add(IcariaBlocks.SOW_SKULL.get(), "Sow Skull");

		this.add(IcariaBlocks.DIM_TORCH.get(), "Dim Torch");
		this.add(IcariaBlocks.LIGNITE_TORCH.get(), "Lignite Torch");
		this.add(IcariaBlocks.ANTHRACITE_TORCH.get(), "Anthracite Torch");

		this.add(IcariaBlocks.LAUREL_CHERRY_CAKE.get(), "Laurel Cherry Cake");
		this.add(IcariaBlocks.STRAWBERRY_CAKE.get(), "Strawberry Cake");
		this.add(IcariaBlocks.PHYSALIS_CAKE.get(), "Physalis Cake");
		this.add(IcariaBlocks.VINE_BERRY_CAKE.get(), "Vine Berry Cake");
		this.add(IcariaBlocks.VINE_SPROUT_CAKE.get(), "Vine Sprout Cake");

		this.add(IcariaBlocks.CYPRESS_SAPLING.get(), "Cypress Sapling");
		this.add(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), "Potted Cypress Sapling");
		this.add(IcariaBlocks.CYPRESS_LEAVES.get(), "Cypress Leaves");
		this.add(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), "Fallen Cypress Leaves");
		this.add(IcariaBlocks.CYPRESS_TWIGS.get(), "Cypress Twigs");
		this.add(IcariaBlocks.CYPRESS_WOOD.get(), "Cypress Wood");
		this.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), "Stripped Cypress Wood");
		this.add(IcariaBlocks.CYPRESS_LOG.get(), "Cypress Log");
		this.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), "Stripped Cypress Log");
		this.add(IcariaBlocks.DEAD_CYPRESS_LOG.get(), "Dead Cypress Log");
		this.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), "Stripped Dead Cypress Log");
		this.add(IcariaBlocks.CYPRESS_PLANKS.get(), "Cypress Planks");
		this.add(IcariaBlocks.CYPRESS_DECO.stairs.get(), "Cypress Stairs");
		this.add(IcariaBlocks.CYPRESS_DECO.slab.get(), "Cypress Slab");
		this.add(IcariaBlocks.CYPRESS_DECO.fence.get(), "Cypress Fence");
		this.add(IcariaBlocks.CYPRESS_DECO.gate.get(), "Cypress Fence Gate");
		this.add(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), "Cypress Crafting Table");
		this.add(IcariaBlocks.CYPRESS_DOOR.get(), "Cypress Door");
		this.add(IcariaBlocks.CYPRESS_TRAPDOOR.get(), "Cypress Trapdoor");
		this.add(IcariaBlocks.CYPRESS_LADDER.get(), "Cypress Ladder");
		this.add(IcariaBlocks.CYPRESS_SIGN.get(), "Cypress Sign");

		this.add(IcariaBlocks.DROUGHTROOT_SAPLING.get(), "Droughtroot Sapling");
		this.add(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), "Potted Droughtroot Sapling");
		this.add(IcariaBlocks.DROUGHTROOT_LEAVES.get(), "Droughtroot Leaves");
		this.add(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), "Fallen Droughtroot Leaves");
		this.add(IcariaBlocks.DROUGHTROOT_TWIGS.get(), "Droughtroot Twigs");
		this.add(IcariaBlocks.DROUGHTROOT_WOOD.get(), "Droughtroot Wood");
		this.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), "Stripped Droughtroot Wood");
		this.add(IcariaBlocks.DROUGHTROOT_LOG.get(), "Droughtroot Log");
		this.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), "Stripped Droughtroot Log");
		this.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), "Dead Droughtroot Log");
		this.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), "Stripped Dead Droughtroot Log");
		this.add(IcariaBlocks.DROUGHTROOT_PLANKS.get(), "Droughtroot Planks");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.stairs.get(), "Droughtroot Stairs");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.slab.get(), "Droughtroot Slab");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.fence.get(), "Droughtroot Fence");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.gate.get(), "Droughtroot Fence Gate");
		this.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), "Droughtroot Crafting Table");
		this.add(IcariaBlocks.DROUGHTROOT_DOOR.get(), "Droughtroot Door");
		this.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), "Droughtroot Trapdoor");
		this.add(IcariaBlocks.DROUGHTROOT_LADDER.get(), "Droughtroot Ladder");
		this.add(IcariaBlocks.DROUGHTROOT_SIGN.get(), "Droughtroot Sign");

		this.add(IcariaBlocks.FIR_SAPLING.get(), "Fir Sapling");
		this.add(IcariaBlocks.POTTED_FIR_SAPLING.get(), "Potted Fir Sapling");
		this.add(IcariaBlocks.FIR_LEAVES.get(), "Fir Leaves");
		this.add(IcariaBlocks.FALLEN_FIR_LEAVES.get(), "Fallen Fir Leaves");
		this.add(IcariaBlocks.FIR_TWIGS.get(), "Fir Twigs");
		this.add(IcariaBlocks.FIR_WOOD.get(), "Fir Wood");
		this.add(IcariaBlocks.STRIPPED_FIR_WOOD.get(), "Stripped Fir Wood");
		this.add(IcariaBlocks.FIR_LOG.get(), "Fir Log");
		this.add(IcariaBlocks.STRIPPED_FIR_LOG.get(), "Stripped Fir Log");
		this.add(IcariaBlocks.DEAD_FIR_LOG.get(), "Dead Fir Log");
		this.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), "Stripped Dead Fir Log");
		this.add(IcariaBlocks.FIR_PLANKS.get(), "Fir Planks");
		this.add(IcariaBlocks.FIR_DECO.stairs.get(), "Fir Stairs");
		this.add(IcariaBlocks.FIR_DECO.slab.get(), "Fir Slab");
		this.add(IcariaBlocks.FIR_DECO.fence.get(), "Fir Fence");
		this.add(IcariaBlocks.FIR_DECO.gate.get(), "Fir Fence Gate");
		this.add(IcariaBlocks.FIR_CRAFTING_TABLE.get(), "Fir Crafting Table");
		this.add(IcariaBlocks.FIR_DOOR.get(), "Fir Door");
		this.add(IcariaBlocks.FIR_TRAPDOOR.get(), "Fir Trapdoor");
		this.add(IcariaBlocks.FIR_LADDER.get(), "Fir Ladder");
		this.add(IcariaBlocks.FIR_SIGN.get(), "Fir Sign");

		this.add(IcariaBlocks.LAUREL_SAPLING.get(), "Laurel Sapling");
		this.add(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), "Potted Laurel Sapling");
		this.add(IcariaBlocks.LAUREL_LEAVES.get(), "Laurel Leaves");
		this.add(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), "Fallen Laurel Leaves");
		this.add(IcariaBlocks.LAUREL_TWIGS.get(), "Laurel Twigs");
		this.add(IcariaBlocks.LAUREL_WOOD.get(), "Laurel Wood");
		this.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), "Stripped Laurel Wood");
		this.add(IcariaBlocks.LAUREL_LOG.get(), "Laurel Log");
		this.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), "Stripped Laurel Log");
		this.add(IcariaBlocks.DEAD_LAUREL_LOG.get(), "Dead Laurel Log");
		this.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), "Stripped Dead Laurel Log");
		this.add(IcariaBlocks.LAUREL_PLANKS.get(), "Laurel Planks");
		this.add(IcariaBlocks.LAUREL_DECO.stairs.get(), "Laurel Stairs");
		this.add(IcariaBlocks.LAUREL_DECO.slab.get(), "Laurel Slab");
		this.add(IcariaBlocks.LAUREL_DECO.fence.get(), "Laurel Fence");
		this.add(IcariaBlocks.LAUREL_DECO.gate.get(), "Laurel Fence Gate");
		this.add(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), "Laurel Crafting Table");
		this.add(IcariaBlocks.LAUREL_DOOR.get(), "Laurel Door");
		this.add(IcariaBlocks.LAUREL_TRAPDOOR.get(), "Laurel Trapdoor");
		this.add(IcariaBlocks.LAUREL_LADDER.get(), "Laurel Ladder");
		this.add(IcariaBlocks.LAUREL_SIGN.get(), "Laurel Sign");

		this.add(IcariaBlocks.OLIVE_SAPLING.get(), "Olive Sapling");
		this.add(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), "Potted Olive Sapling");
		this.add(IcariaBlocks.OLIVE_LEAVES.get(), "Olive Leaves");
		this.add(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), "Fallen Olive Leaves");
		this.add(IcariaBlocks.OLIVE_TWIGS.get(), "Olive Twigs");
		this.add(IcariaBlocks.OLIVE_WOOD.get(), "Olive Wood");
		this.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), "Stripped Olive Wood");
		this.add(IcariaBlocks.OLIVE_LOG.get(), "Olive Log");
		this.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), "Stripped Olive Log");
		this.add(IcariaBlocks.DEAD_OLIVE_LOG.get(), "Dead Olive Log");
		this.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), "Stripped Dead Olive Log");
		this.add(IcariaBlocks.OLIVE_PLANKS.get(), "Olive Planks");
		this.add(IcariaBlocks.OLIVE_DECO.stairs.get(), "Olive Stairs");
		this.add(IcariaBlocks.OLIVE_DECO.slab.get(), "Olive Slab");
		this.add(IcariaBlocks.OLIVE_DECO.fence.get(), "Olive Fence");
		this.add(IcariaBlocks.OLIVE_DECO.gate.get(), "Olive Fence Gate");
		this.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), "Olive Crafting Table");
		this.add(IcariaBlocks.OLIVE_DOOR.get(), "Olive Door");
		this.add(IcariaBlocks.OLIVE_TRAPDOOR.get(), "Olive Trapdoor");
		this.add(IcariaBlocks.OLIVE_LADDER.get(), "Olive Ladder");
		this.add(IcariaBlocks.OLIVE_SIGN.get(), "Olive Sign");

		this.add(IcariaBlocks.PLANE_SAPLING.get(), "Plane Sapling");
		this.add(IcariaBlocks.POTTED_PLANE_SAPLING.get(), "Potted Plane Sapling");
		this.add(IcariaBlocks.PLANE_LEAVES.get(), "Plane Leaves");
		this.add(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), "Fallen Plane Leaves");
		this.add(IcariaBlocks.PLANE_TWIGS.get(), "Plane Twigs");
		this.add(IcariaBlocks.PLANE_WOOD.get(), "Plane Wood");
		this.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), "Stripped Plane Wood");
		this.add(IcariaBlocks.PLANE_LOG.get(), "Plane Log");
		this.add(IcariaBlocks.STRIPPED_PLANE_LOG.get(), "Stripped Plane Log");
		this.add(IcariaBlocks.DEAD_PLANE_LOG.get(), "Dead Plane Log");
		this.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), "Stripped Dead Plane Log");
		this.add(IcariaBlocks.PLANE_PLANKS.get(), "Plane Planks");
		this.add(IcariaBlocks.PLANE_DECO.stairs.get(), "Plane Stairs");
		this.add(IcariaBlocks.PLANE_DECO.slab.get(), "Plane Slab");
		this.add(IcariaBlocks.PLANE_DECO.fence.get(), "Plane Fence");
		this.add(IcariaBlocks.PLANE_DECO.gate.get(), "Plane Fence Gate");
		this.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), "Plane Crafting Table");
		this.add(IcariaBlocks.PLANE_DOOR.get(), "Plane Door");
		this.add(IcariaBlocks.PLANE_TRAPDOOR.get(), "Plane Trapdoor");
		this.add(IcariaBlocks.PLANE_LADDER.get(), "Plane Ladder");
		this.add(IcariaBlocks.PLANE_SIGN.get(), "Plane Sign");

		this.add(IcariaBlocks.POPULUS_SAPLING.get(), "Populus Sapling");
		this.add(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), "Potted Populus Sapling");
		this.add(IcariaBlocks.POPULUS_LEAVES.get(), "Populus Leaves");
		this.add(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), "Fallen Populus Leaves");
		this.add(IcariaBlocks.POPULUS_TWIGS.get(), "Populus Twigs");
		this.add(IcariaBlocks.POPULUS_WOOD.get(), "Populus Wood");
		this.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), "Stripped Populus Wood");
		this.add(IcariaBlocks.POPULUS_LOG.get(), "Populus Log");
		this.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), "Stripped Populus Log");
		this.add(IcariaBlocks.DEAD_POPULUS_LOG.get(), "Dead Populus Log");
		this.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), "Stripped Dead Populus Log");
		this.add(IcariaBlocks.POPULUS_PLANKS.get(), "Populus Planks");
		this.add(IcariaBlocks.POPULUS_DECO.stairs.get(), "Populus Stairs");
		this.add(IcariaBlocks.POPULUS_DECO.slab.get(), "Populus Slab");
		this.add(IcariaBlocks.POPULUS_DECO.fence.get(), "Populus Fence");
		this.add(IcariaBlocks.POPULUS_DECO.gate.get(), "Populus Fence Gate");
		this.add(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), "Populus Crafting Table");
		this.add(IcariaBlocks.POPULUS_DOOR.get(), "Populus Door");
		this.add(IcariaBlocks.POPULUS_TRAPDOOR.get(), "Populus Trapdoor");
		this.add(IcariaBlocks.POPULUS_LADDER.get(), "Populus Ladder");
		this.add(IcariaBlocks.POPULUS_SIGN.get(), "Populus Sign");

		this.add(IcariaBlocks.DEAD_BLOOMY_VINE.get(), "Bloomy Vine");
		this.add(IcariaBlocks.GROWING_BLOOMY_VINE.get(), "Bloomy Vine");
		this.add(IcariaBlocks.RIPE_BLOOMY_VINE.get(), "Bloomy Vine");
		this.add(IcariaBlocks.BLOOMING_BLOOMY_VINE.get(), "Bloomy Vine");
		this.add(IcariaBlocks.BLOOMY_VINE.get(), "Bloomy Vine");

		this.add(IcariaBlocks.DEAD_BRANCHY_VINE.get(), "Branchy Vine");
		this.add(IcariaBlocks.GROWING_BRANCHY_VINE.get(), "Branchy Vine");
		this.add(IcariaBlocks.BRANCHY_VINE.get(), "Branchy Vine");

		this.add(IcariaBlocks.DEAD_BRUSHY_VINE.get(), "Brushy Vine");
		this.add(IcariaBlocks.GROWING_BRUSHY_VINE.get(), "Brushy Vine");
		this.add(IcariaBlocks.RIPE_BRUSHY_VINE.get(), "Brushy Vine");
		this.add(IcariaBlocks.BRUSHY_VINE.get(), "Brushy Vine");

		this.add(IcariaBlocks.DEAD_DRY_VINE.get(), "Dry Vine");
		this.add(IcariaBlocks.GROWING_DRY_VINE.get(), "Dry Vine");
		this.add(IcariaBlocks.DRY_VINE.get(), "Dry Vine");

		this.add(IcariaBlocks.DEAD_REEDY_VINE.get(), "Reedy Vine");
		this.add(IcariaBlocks.GROWING_REEDY_VINE.get(), "Reedy Vine");
		this.add(IcariaBlocks.REEDY_VINE.get(), "Reedy Vine");

		this.add(IcariaBlocks.DEAD_SWIRLY_VINE.get(), "Swirly Vine");
		this.add(IcariaBlocks.GROWING_SWIRLY_VINE.get(), "Swirly Vine");
		this.add(IcariaBlocks.SWIRLY_VINE.get(), "Swirly Vine");

		this.add(IcariaBlocks.DEAD_THORNY_VINE.get(), "Thorny Vine");
		this.add(IcariaBlocks.GROWING_THORNY_VINE.get(), "Thorny Vine");
		this.add(IcariaBlocks.THORNY_VINE.get(), "Thorny Vine");

		this.add(IcariaBlocks.FERN.get(), "Fern");
		this.add(IcariaBlocks.POTTED_FERN.get(), "Potted Fern");

		this.add(IcariaBlocks.SMALL_GRASS.get(), "Small Grass");
		this.add(IcariaBlocks.MEDIUM_GRASS.get(), "Medium Grass");
		this.add(IcariaBlocks.LARGE_GRASS.get(), "Large Grass");

		this.add(IcariaBlocks.GRAIN_0.get(), "Grain");
		this.add(IcariaBlocks.GRAIN_1.get(), "Grain");
		this.add(IcariaBlocks.GRAIN_2.get(), "Grain");
		this.add(IcariaBlocks.GRAIN_3.get(), "Grain");
		this.add(IcariaBlocks.GRAIN_4.get(), "Grain");
		this.add(IcariaBlocks.GRAIN_5.get(), "Grain");

		this.add(IcariaBlocks.BLINDWEED.get(), "Blindweed");
		this.add(IcariaBlocks.POTTED_BLINDWEED.get(), "Potted Blindweed");
		this.add(IcariaBlocks.CHAMEOMILE.get(), "Chameomile");
		this.add(IcariaBlocks.POTTED_CHAMEOMILE.get(), "Potted Chameomile");
		this.add(IcariaBlocks.CHARMONDER.get(), "Charmonder");
		this.add(IcariaBlocks.POTTED_CHARMONDER.get(), "Potted Charmonder");
		this.add(IcariaBlocks.CLOVER.get(), "Clover");
		this.add(IcariaBlocks.POTTED_CLOVER.get(), "Potted Clover");
		this.add(IcariaBlocks.FIREHILT.get(), "Firehilt");
		this.add(IcariaBlocks.POTTED_FIREHILT.get(), "Potted Firehilt");
		this.add(IcariaBlocks.BLUE_HYDRACINTH.get(), "Blue Hydracinth");
		this.add(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), "Potted Blue Hydracinth");
		this.add(IcariaBlocks.PURPLE_HYDRACINTH.get(), "Purple Hydracinth");
		this.add(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), "Potted Purple Hydracinth");
		this.add(IcariaBlocks.LIONFANGS.get(), "Lionfangs");
		this.add(IcariaBlocks.POTTED_LIONFANGS.get(), "Potted Lionfangs");
		this.add(IcariaBlocks.SPEARDROPS.get(), "Speardrops");
		this.add(IcariaBlocks.POTTED_SPEARDROPS.get(), "Potted Speardrops");
		this.add(IcariaBlocks.PURPLE_STAGHORN.get(), "Purple Staghorn");
		this.add(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), "Potted Purple Staghorn");
		this.add(IcariaBlocks.YELLOW_STAGHORN.get(), "Yellow Staghorn");
		this.add(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), "Potted Yellow Staghorn");
		this.add(IcariaBlocks.BLUE_STORMCOTTON.get(), "Blue Stormcotton");
		this.add(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), "Potted Blue Stormcotton");
		this.add(IcariaBlocks.PINK_STORMCOTTON.get(), "Pink Stormcotton");
		this.add(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), "Potted Pink Stormcotton");
		this.add(IcariaBlocks.PURPLE_STORMCOTTON.get(), "Purple Stormcotton");
		this.add(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), "Potted Purple Stormcotton");
		this.add(IcariaBlocks.SUNKETTLE.get(), "Sunkettle");
		this.add(IcariaBlocks.POTTED_SUNKETTLE.get(), "Potted Sunkettle");
		this.add(IcariaBlocks.SUNSPONGE.get(), "Sunsponge");
		this.add(IcariaBlocks.POTTED_SUNSPONGE.get(), "Potted Sunsponge");
		this.add(IcariaBlocks.VOIDLILY.get(), "Voidlily");
		this.add(IcariaBlocks.POTTED_VOIDLILY.get(), "Potted Voidlily");

		this.add(IcariaBlocks.BOLBOS.get(), "Bolbos");
		this.add(IcariaBlocks.DATHULLA.get(), "Dathulla");
		this.add(IcariaBlocks.MONDANOS.get(), "Mondanos");
		this.add(IcariaBlocks.MOTH_AGARIC.get(), "Moth Agaric");
		this.add(IcariaBlocks.NAMDRAKE.get(), "Namdrake");
		this.add(IcariaBlocks.PSILOCYBOS.get(), "Psilocybos");
		this.add(IcariaBlocks.ROWAN.get(), "Rowan");

		this.add(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), "Blue Ground Flowers");
		this.add(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), "Cyan Ground Flowers");
		this.add(IcariaBlocks.PINK_GROUND_FLOWERS.get(), "Pink Ground Flowers");
		this.add(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), "Purple Ground Flowers");
		this.add(IcariaBlocks.RED_GROUND_FLOWERS.get(), "Red Ground Flowers");
		this.add(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), "White Ground Flowers");

		this.add(IcariaBlocks.MOSS_0.get(), "Moss");
		this.add(IcariaBlocks.MOSS_1.get(), "Moss");
		this.add(IcariaBlocks.MOSS_2.get(), "Moss");

		this.add(IcariaBlocks.PALM_FERN.get(), "Palm Fern");
		this.add(IcariaBlocks.POTTED_PALM_FERN.get(), "Potted Palm Fern");

		this.add(IcariaBlocks.WHITE_BROMELIA.get(), "White Bromelia");
		this.add(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), "Potted White Bromelia");
		this.add(IcariaBlocks.ORANGE_BROMELIA.get(), "Orange Bromelia");
		this.add(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), "Potted Orange Bromelia");
		this.add(IcariaBlocks.PINK_BROMELIA.get(), "Pink Bromelia");
		this.add(IcariaBlocks.POTTED_PINK_BROMELIA.get(), "Potted Pink Bromelia");
		this.add(IcariaBlocks.PURPLE_BROMELIA.get(), "Purple Bromelia");
		this.add(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), "Potted Purple Bromelia");

		this.add(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), "Green Shrooms");
		this.add(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get(), "Potted Green Shrooms");
		this.add(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), "Brown Shrooms");
		this.add(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get(), "Potted Brown Shrooms");
		this.add(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), "Large Brown Shrooms");
		this.add(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get(), "Potted Large Brown Shrooms");

		this.add(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), "Tinder Fungus");
		this.add(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), "Turkey Tail");
		this.add(IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), "Unnamed Shrooms");

		this.add(IcariaBlocks.CARDON_CACTUS.get(), "Cardon Cactus");
		this.add(IcariaBlocks.POTTED_CARDON_CACTUS.get(), "Potted Cardon Cactus");

		this.add(IcariaBlocks.STRAWBERRY_BUSH.get(), "Strawberry Bush");

		this.add(IcariaBlocks.SPELT_CROP.get(), "Spelt Crops");
		this.add(IcariaBlocks.STRAWBERRY_CROP.get(), "Strawberry Crops");
		this.add(IcariaBlocks.PHYSALIS_CROP.get(), "Physalis Crops");
		this.add(IcariaBlocks.ONION_CROP.get(), "Onion Crops");

		this.add(IcariaBlocks.MEDITERRANEAN_WATER.get(), "Mediterranean Water");

		this.add(IcariaBlocks.GREEK_FIRE.get(), "Greek Fire");

		this.add(IcariaBlocks.ICARIA_PORTAL.get(), "Icaria Portal");

		// EFFECTS
		this.add(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), "Blindness Immunity");
		this.add(IcariaMobEffects.LIFESTEAL.get(), "Lifesteal");

		// ENTITY TYPES
		this.add(IcariaEntityTypes.AETERNAE.get(), "Aeternae");
		this.add(IcariaEntityTypes.ARACHNE.get(), "Arachne");
		this.add(IcariaEntityTypes.ARACHNE_DRONE.get(), "Arachne Drone");
		this.add(IcariaEntityTypes.ARGAN_HOUND.get(), "Argan Hound");
		this.add(IcariaEntityTypes.BIDENT.get(), "Bident");
		this.add(IcariaEntityTypes.CATOBLEPAS.get(), "Catoblepas");
		this.add(IcariaEntityTypes.CERVER.get(), "Cerver");
		this.add(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), "Cypress Forest Hag");
		this.add(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), "Droughtroot Forest Hag");
		this.add(IcariaEntityTypes.FIR_FOREST_HAG.get(), "Fir Forest Hag");
		this.add(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), "Laurel Forest Hag");
		this.add(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), "Olive Forest Hag");
		this.add(IcariaEntityTypes.PLANE_FOREST_HAG.get(), "Plane Forest Hag");
		this.add(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), "Greek Fire Grenade");
		this.add(IcariaEntityTypes.HYLIASTER.get(), "Hyliaster");
		this.add(IcariaEntityTypes.ENDER_JELLYFISH.get(), "Ender Jellyfish");
		this.add(IcariaEntityTypes.FIRE_JELLYFISH.get(), "Fire Jellyfish");
		this.add(IcariaEntityTypes.NATURE_JELLYFISH.get(), "Nature Jellyfish");
		this.add(IcariaEntityTypes.VOID_JELLYFISH.get(), "Void Jellyfish");
		this.add(IcariaEntityTypes.WATER_JELLYFISH.get(), "Water Jellyfish");
		this.add(IcariaEntityTypes.MYRMEKE_DRONE.get(), "Myrmeke Drone");
		this.add(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), "Myrmeke Soldier");
		this.add(IcariaEntityTypes.MYRMEKE_QUEEN.get(), "Myrmeke Queen");
		this.add(IcariaEntityTypes.CRYSTAL_SLUG.get(), "Crystal Slug");
		this.add(IcariaEntityTypes.FOREST_SNULL.get(), "Forest Snull");
		this.add(IcariaEntityTypes.SNULL.get(), "Snull");
		this.add(IcariaEntityTypes.SOW.get(), "Sow");

		// FLUIDS
		this.add("fluid." + IcariaInfo.MODID + ".mediterranean_water", "Mediterranean Water");

		// ITEMS
		this.add(IcariaItems.BONE_REMAINS.get(), "Bone Remains");
		this.add(IcariaItems.LOAM_LUMP.get(), "Loam Lump");
		this.add(IcariaItems.LOAM_BRICK.get(), "Loam Brick");
		this.add(IcariaItems.CHERT.get(), "Chert");
		this.add(IcariaItems.ENDER_JELLYFISH_JELLY.get(), "Ender Jellyfish Jelly");
		this.add(IcariaItems.FIRE_JELLYFISH_JELLY.get(), "Fire Jellyfish Jelly");
		this.add(IcariaItems.NATURE_JELLYFISH_JELLY.get(), "Nature Jellyfish Jelly");
		this.add(IcariaItems.VOID_JELLYFISH_JELLY.get(), "Void Jellyfish Jelly");
		this.add(IcariaItems.WATER_JELLYFISH_JELLY.get(), "Water Jellyfish Jelly");
		this.add(IcariaItems.ARACHNE_STRING.get(), "Arachne String");
		this.add(IcariaItems.SPELT.get(), "Spelt");
		this.add(IcariaItems.VINE_REED.get(), "Vine Reed");
		this.add(IcariaItems.VINE_SPROUT.get(), "Vine Sprout");
		this.add(IcariaItems.ROTTEN_BONES.get(), "Rotten Bones");
		this.add(IcariaItems.CALCITE.get(), "Calcite");
		this.add(IcariaItems.HALITE.get(), "Halite");
		this.add(IcariaItems.JASPER.get(), "Jasper");
		this.add(IcariaItems.ZIRCON.get(), "Zircon");
		this.add(IcariaItems.CALCITE_DUST.get(), "Calcite Dust");
		this.add(IcariaItems.HALITE_DUST.get(), "Halite Dust");
		this.add(IcariaItems.LIGNITE.get(), "Lignite");
		this.add(IcariaItems.CHALKOS_RAW.get(), "Raw Chalkos");
		this.add(IcariaItems.KASSITEROS_RAW.get(), "Raw Kassiteros");
		this.add(IcariaItems.DOLOMITE.get(), "Dolomite");
		this.add(IcariaItems.VANADIUM_RAW.get(), "Raw Vanadium");
		this.add(IcariaItems.SLIVER.get(), "Sliver");
		this.add(IcariaItems.SIDEROS_RAW.get(), "Raw Sideros");
		this.add(IcariaItems.ANTHRACITE.get(), "Anthracite");
		this.add(IcariaItems.MOLYBDENUM_RAW.get(), "Raw Molybdenum");

		this.add(IcariaItems.CHALKOS_NUGGET.get(), "Chalkos Nugget");
		this.add(IcariaItems.KASSITEROS_NUGGET.get(), "Kassiteros Nugget");
		this.add(IcariaItems.ORICHALCUM_NUGGET.get(), "Orichalcum Nugget");
		this.add(IcariaItems.VANADIUM_NUGGET.get(), "Vanadium Nugget");
		this.add(IcariaItems.VANADIUMSTEEL_NUGGET.get(), "Vanadiumsteel Nugget");
		this.add(IcariaItems.SIDEROS_NUGGET.get(), "Sideros Nugget");
		this.add(IcariaItems.MOLYBDENUM_NUGGET.get(), "Molybdenum Nugget");
		this.add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), "Molybdenum Nugget");
		this.add(IcariaItems.BLURIDIUM_NUGGET.get(), "Bluridium Nugget");

		this.add(IcariaItems.CHALKOS_INGOT.get(), "Chalkos Ingot");
		this.add(IcariaItems.KASSITEROS_INGOT.get(), "Kassiteros Ingot");
		this.add(IcariaItems.ORICHALCUM_INGOT.get(), "Orichalcum Ingot");
		this.add(IcariaItems.VANADIUM_INGOT.get(), "Vanadium Ingot");
		this.add(IcariaItems.VANADIUMSTEEL_INGOT.get(), "Vanadiumsteel Ingot");
		this.add(IcariaItems.SIDEROS_INGOT.get(), "Sideros Ingot");
		this.add(IcariaItems.MOLYBDENUM_INGOT.get(), "Molybdenum Ingot");
		this.add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), "Molybdenum Ingot");
		this.add(IcariaItems.BLURIDIUM_INGOT.get(), "Bluridium Ingot");

		this.add(IcariaItems.CHERT_TOOLS.sword.get(), "Chert Sword");
		this.add(IcariaItems.CHERT_TOOLS.dagger.get(), "Chert Dagger");
		this.add(IcariaItems.CHERT_TOOLS.shovel.get(), "Chert Shovel");
		this.add(IcariaItems.CHERT_TOOLS.pickaxe.get(), "Chert Pickaxe");
		this.add(IcariaItems.CHERT_TOOLS.axe.get(), "Chert Axe");
		this.add(IcariaItems.CHERT_TOOLS.scythe.get(), "Chert Scythe");
		this.add(IcariaItems.CHERT_TOOLS.bident.get(), "Chert Bident");
		this.add(IcariaItems.CHALKOS_TOOLS.sword.get(), "Chalkos Sword");
		this.add(IcariaItems.CHALKOS_TOOLS.dagger.get(), "Chalkos Dagger");
		this.add(IcariaItems.CHALKOS_TOOLS.shovel.get(), "Chalkos Shovel");
		this.add(IcariaItems.CHALKOS_TOOLS.pickaxe.get(), "Chalkos Pickaxe");
		this.add(IcariaItems.CHALKOS_TOOLS.axe.get(), "Chalkos Axe");
		this.add(IcariaItems.CHALKOS_TOOLS.scythe.get(), "Chalkos Scythe");
		this.add(IcariaItems.CHALKOS_TOOLS.bident.get(), "Chalkos Bident");
		this.add(IcariaItems.KASSITEROS_TOOLS.sword.get(), "Kassiteros Sword");
		this.add(IcariaItems.KASSITEROS_TOOLS.dagger.get(), "Kassiteros Dagger");
		this.add(IcariaItems.KASSITEROS_TOOLS.shovel.get(), "Kassiteros Shovel");
		this.add(IcariaItems.KASSITEROS_TOOLS.pickaxe.get(), "Kassiteros Pickaxe");
		this.add(IcariaItems.KASSITEROS_TOOLS.axe.get(), "Kassiteros Axe");
		this.add(IcariaItems.KASSITEROS_TOOLS.scythe.get(), "Kassiteros Scythe");
		this.add(IcariaItems.KASSITEROS_TOOLS.bident.get(), "Kassiteros Bident");
		this.add(IcariaItems.ORICHALCUM_TOOLS.sword.get(), "Orichalcum Sword");
		this.add(IcariaItems.ORICHALCUM_TOOLS.dagger.get(), "Orichalcum Dagger");
		this.add(IcariaItems.ORICHALCUM_TOOLS.shovel.get(), "Orichalcum Shovel");
		this.add(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get(), "Orichalcum Pickaxe");
		this.add(IcariaItems.ORICHALCUM_TOOLS.axe.get(), "Orichalcum Axe");
		this.add(IcariaItems.ORICHALCUM_TOOLS.scythe.get(), "Orichalcum Scythe");
		this.add(IcariaItems.ORICHALCUM_TOOLS.bident.get(), "Orichalcum Bident");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.sword.get(), "Vanadiumsteel Sword");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get(), "Vanadiumsteel Dagger");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get(), "Vanadiumsteel Shovel");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get(), "Vanadiumsteel Pickaxe");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.axe.get(), "Vanadiumsteel Axe");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get(), "Vanadiumsteel Scythe");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get(), "Vanadiumsteel Bident");
		this.add(IcariaItems.SIDEROS_TOOLS.sword.get(), "Sideros Sword");
		this.add(IcariaItems.SIDEROS_TOOLS.dagger.get(), "Sideros Dagger");
		this.add(IcariaItems.SIDEROS_TOOLS.shovel.get(), "Sideros Shovel");
		this.add(IcariaItems.SIDEROS_TOOLS.pickaxe.get(), "Sideros Pickaxe");
		this.add(IcariaItems.SIDEROS_TOOLS.axe.get(), "Sideros Axe");
		this.add(IcariaItems.SIDEROS_TOOLS.scythe.get(), "Sideros Scythe");
		this.add(IcariaItems.SIDEROS_TOOLS.bident.get(), "Sideros Bident");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get(), "Molybdenumsteel Sword");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get(), "Molybdenumsteel Dagger");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get(), "Molybdenumsteel Shovel");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get(), "Molybdenumsteel Pickaxe");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get(), "Molybdenumsteel Axe");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get(), "Molybdenumsteel Scythe");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get(), "Molybdenumsteel Bident");

		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get(), "Aeternae Hide Helmet");
		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get(), "Aeternae Hide Chestplate");
		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get(), "Aeternae Hide Leggings");
		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get(), "Aeternae Hide Boots");
		this.add(IcariaItems.CHALKOS_ARMOR.helmet.get(), "Chalkos Helmet");
		this.add(IcariaItems.CHALKOS_ARMOR.chestplate.get(), "Chalkos Chestplate");
		this.add(IcariaItems.CHALKOS_ARMOR.leggings.get(), "Chalkos Leggings");
		this.add(IcariaItems.CHALKOS_ARMOR.boots.get(), "Chalkos Boots");
		this.add(IcariaItems.KASSITEROS_ARMOR.helmet.get(), "Kassiteros Helmet");
		this.add(IcariaItems.KASSITEROS_ARMOR.chestplate.get(), "Kassiteros Chestplate");
		this.add(IcariaItems.KASSITEROS_ARMOR.leggings.get(), "Kassiteros Leggings");
		this.add(IcariaItems.KASSITEROS_ARMOR.boots.get(), "Kassiteros Boots");
		this.add(IcariaItems.ORICHALCUM_HELMET.get(), "Orichalcum Helmet");
		this.add(IcariaItems.ORICHALCUM_CHESTPLATE.get(), "Orichalcum Chestplate");
		this.add(IcariaItems.ORICHALCUM_LEGGINGS.get(), "Orichalcum Leggings");
		this.add(IcariaItems.ORICHALCUM_BOOTS.get(), "Orichalcum Boots");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get(), "Vanadiumsteel Helmet");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get(), "Vanadiumsteel Chestplate");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get(), "Vanadiumsteel Leggings");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.boots.get(), "Vanadiumsteel Boots");
		this.add(IcariaItems.LAUREL_WREATH.get(), "Laurel Wreath");

		this.add(IcariaItems.GREEK_FIRE_GRENADE.get(), "Greek Fire Grenade");

		this.add(IcariaItems.TOTEM_OF_PREVENTATION.get(), "Totem of Preventation");
		this.add(IcariaItems.TOTEM_OF_STUFFING.get(), "Totem of Stuffing");
		this.add(IcariaItems.TOTEM_OF_UNBLINDING.get(), "Totem of Unblinding");
		this.add(IcariaItems.TOTEM_OF_UNDROWNING.get(), "Totem of Undrowning");
		this.add(IcariaItems.TOTEM_OF_UNDYING.get(), "Totem of Undying");
		this.add(IcariaItems.TOTEM_OF_UNSHATTERING.get(), "Totem of Unshattering");
		this.add(IcariaItems.TOTEM_OF_UNSINKING.get(), "Totem of Unsinking");

		this.add(IcariaItems.UNFIRED_STORAGE_VASE.get(), "Unfired Storage Vase");
		this.add(IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get(), "White Unfired Storage Vase");
		this.add(IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get(), "Light Gray Unfired Storage Vase");
		this.add(IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get(), "Gray Unfired Storage Vase");
		this.add(IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get(), "Black Unfired Storage Vase");
		this.add(IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get(), "Brown Unfired Storage Vase");
		this.add(IcariaItems.RED_UNFIRED_STORAGE_VASE.get(), "Red Unfired Storage Vase");
		this.add(IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get(), "Orange Unfired Storage Vase");
		this.add(IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get(), "Yellow Unfired Storage Vase");
		this.add(IcariaItems.LIME_UNFIRED_STORAGE_VASE.get(), "Lime Unfired Storage Vase");
		this.add(IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get(), "Green Unfired Storage Vase");
		this.add(IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get(), "Cyan Unfired Storage Vase");
		this.add(IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get(), "Light Blue Unfired Storage Vase");
		this.add(IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get(), "Blue Unfired Storage Vase");
		this.add(IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get(), "Purple Unfired Storage Vase");
		this.add(IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get(), "Magenta Unfired Storage Vase");
		this.add(IcariaItems.PINK_UNFIRED_STORAGE_VASE.get(), "Pink Unfired Storage Vase");

		this.add(IcariaItems.FLASK_EMPTY.get(), "Empty Flask");

		this.add(IcariaItems.VIAL_EMPTY.get(), "Empty Vial");
		this.add(IcariaItems.VIAL_HYLIASTRUM.get(), "Hyliastrum Vial");

		this.add(IcariaItems.GEAR_YELLOWSTONE.get(), "Yellowstone Gear");
		this.add(IcariaItems.GEAR_YELLOWSTONE_SMALL.get(), "Small Yellowstone Gear");
		this.add(IcariaItems.GEAR_LOAM_UNFIRED.get(), "Unfired Loam Gear");
		this.add(IcariaItems.GEAR_LOAM.get(), "Loam Gear");
		this.add(IcariaItems.GEAR_LOAM_SMALL.get(), "Small Loam Gear");
		this.add(IcariaItems.GEAR_VOIDSHALE.get(), "Voidshale Gear");
		this.add(IcariaItems.GEAR_VOIDSHALE_SMALL.get(), "Small Voidshale Gear");
		this.add(IcariaItems.GEAR_VANADIUM.get(), "Vanadium Gear");
		this.add(IcariaItems.GEAR_VANADIUM_SMALL.get(), "Small Vanadium Gear");
		this.add(IcariaItems.GEARFRAGMENT_BLUE.get(), "Blue Gearfragment");
		this.add(IcariaItems.GEARFRAGMENT_GREEN.get(), "Green Gearfragment");
		this.add(IcariaItems.GEARFRAGMENT_YELLOW.get(), "Yellow Gearfragment");
		this.add(IcariaItems.GEAR_DAEDALIAN.get(), "Daedalian Gear");
		this.add(IcariaItems.GEAR_DAEDALIAN_SMALL.get(), "Small Daedalian Gear");

		this.add(IcariaItems.AETERNAE_HIDE.get(), "Aeternae Hide");
		this.add(IcariaItems.SPELT_FLOUR.get(), "Spelt Flour");
		this.add(IcariaItems.SPELT_BREAD.get(), "Spelt Bread");
		this.add(IcariaItems.VINEBERRIES.get(), "Vineberries");
		this.add(IcariaItems.STRAWBERRIES.get(), "Strawberries");
		this.add(IcariaItems.PHYSALIS.get(), "Physalis");
		this.add(IcariaItems.LAUREL_CHERRY.get(), "Laurel Cherry");
		this.add(IcariaItems.OLIVES_BLACK.get(), "Black Olives");
		this.add(IcariaItems.OLIVES_GREEN.get(), "Green Olives");
		this.add(IcariaItems.GARLIC.get(), "Garlic");
		this.add(IcariaItems.ONION.get(), "Onion");
		this.add(IcariaItems.RAW_AETERNAE_MEAT.get(), "Raw Aeternae Meat");
		this.add(IcariaItems.COOKED_AETERNAE_MEAT.get(), "Cooked Aeternae Meat");
		this.add(IcariaItems.RAW_CATOBLEPAS_MEAT.get(), "Raw Catoblepas Meat");
		this.add(IcariaItems.COOKED_CATOBLEPAS_MEAT.get(), "Cooked Catoblepas Meat");
		this.add(IcariaItems.RAW_CERVER_MEAT.get(), "Raw Cerver Meat");
		this.add(IcariaItems.COOKED_CERVER_MEAT.get(), "Cooked Cerver Meat");
		this.add(IcariaItems.RAW_SOW_MEAT.get(), "Raw Sow Meat");
		this.add(IcariaItems.COOKED_SOW_MEAT.get(), "Cooked Sow Meat");
		this.add(IcariaItems.MYRMEKE_SCALES.get(), "Myrmeke Scales");
		this.add(IcariaItems.SLUG_SCALES.get(), "Slug Scales");
		this.add(IcariaItems.SNULL_CREAM.get(), "Snull Cream");

		this.add(IcariaItems.LOAM_BOWL_UNFIRED.get(), "Unfired Loam Bowl");
		this.add(IcariaItems.LOAM_BOWL.get(), "Loam Bowl");
		this.add(IcariaItems.SALAD_FRUIT.get(), "Fruit Salad");
		this.add(IcariaItems.SOUP_ONION.get(), "Onion Soup");
		this.add(IcariaItems.STEW_AETERNAE.get(), "Aeternae Stew");
		this.add(IcariaItems.STEW_CATOBLEPAS.get(), "Catoblepas Stew");
		this.add(IcariaItems.STEW_CERVER.get(), "Cerver Stew");
		this.add(IcariaItems.STEW_SOW.get(), "Sow Stew");

		this.add(IcariaItems.SPELT_SEEDS.get(), "Spelt Seeds");
		this.add(IcariaItems.STRAWBERRY_SEEDS.get(), "Strawberry Seeds");
		this.add(IcariaItems.PHYSALIS_SEEDS.get(), "Physalis Seeds");

		this.add(IcariaItems.AETERNAE_SPAWN_EGG.get(), "Aeternae Spawn Egg");
		this.add(IcariaItems.ARACHNE_SPAWN_EGG.get(), "Arachne Spawn Egg");
		this.add(IcariaItems.ARACHNE_DRONE_SPAWN_EGG.get(), "Arachne Drone Spawn Egg");
		this.add(IcariaItems.ARGAN_HOUND_SPAWN_EGG.get(), "Argan Hound Spawn Egg");
		this.add(IcariaItems.CATOBLEPAS_SPAWN_EGG.get(), "Catoblepas Spawn Egg");
		this.add(IcariaItems.CERVER_SPAWN_EGG.get(), "Cerver Spawn Egg");
		this.add(IcariaItems.CYPRESS_FOREST_HAG_SPAWN_EGG.get(), "Cypress Forest Hag Spawn Egg");
		this.add(IcariaItems.DROUGHTROOT_FOREST_HAG_SPAWN_EGG.get(), "Droughtroot Forest Hag Spawn Egg");
		this.add(IcariaItems.FIR_FOREST_HAG_SPAWN_EGG.get(), "Fir Forest Hag Spawn Egg");
		this.add(IcariaItems.LAUREL_FOREST_HAG_SPAWN_EGG.get(), "Laurel Forest Hag Spawn Egg");
		this.add(IcariaItems.OLIVE_FOREST_HAG_SPAWN_EGG.get(), "Olive Forest Hag Spawn Egg");
		this.add(IcariaItems.PLANE_FOREST_HAG_SPAWN_EGG.get(), "Plane Forest Hag Spawn Egg");
		this.add(IcariaItems.HYLIASTER_SPAWN_EGG.get(), "Hyliaster Spawn Egg");
		this.add(IcariaItems.ENDER_JELLYFISH_SPAWN_EGG.get(), "Ender Jellyfish Spawn Egg");
		this.add(IcariaItems.FIRE_JELLYFISH_SPAWN_EGG.get(), "Fire Jellyfish Spawn Egg");
		this.add(IcariaItems.NATURE_JELLYFISH_SPAWN_EGG.get(), "Nature Jellyfish Spawn Egg");
		this.add(IcariaItems.VOID_JELLYFISH_SPAWN_EGG.get(), "Void Jellyfish Spawn Egg");
		this.add(IcariaItems.WATER_JELLYFISH_SPAWN_EGG.get(), "Water Jellyfish Spawn Egg");
		this.add(IcariaItems.MYRMEKE_DRONE_SPAWN_EGG.get(), "Myrmeke Drone Spawn Egg");
		this.add(IcariaItems.MYRMEKE_SOLDIER_SPAWN_EGG.get(), "Myrmeke Soldier Spawn Egg");
		this.add(IcariaItems.MYRMEKE_QUEEN_SPAWN_EGG.get(), "Myrmeke Queen Spawn Egg");
		this.add(IcariaItems.CRYSTAL_SLUG_SPAWN_EGG.get(), "Crystal Slug Spawn Egg");
		this.add(IcariaItems.FOREST_SNULL_SPAWN_EGG.get(), "Forest Snull Spawn Egg");
		this.add(IcariaItems.SNULL_SPAWN_EGG.get(), "Snull Spawn Egg");
		this.add(IcariaItems.SOW_SPAWN_EGG.get(), "Sow Spawn Egg");

		this.add(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get(), "Mediterranean Water Bucket");

		// ITEM GROUPS
		this.add("itemgroup." + IcariaInfo.MODID + ".blocks", "Lands of Icaria Blocks");
		this.add("itemgroup." + IcariaInfo.MODID + ".flora", "Lands of Icaria Flora");
		this.add("itemgroup." + IcariaInfo.MODID + ".items", "Lands of Icaria Items");

		// MENU TYPES
		this.add("menu." + IcariaInfo.MODID + ".grinder", "Grinder");
		this.add("menu." + IcariaInfo.MODID + ".storage_vase", "Storage Vase");
	}
}
