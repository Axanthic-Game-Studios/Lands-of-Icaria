package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.properties.VerticalCorner;

import com.google.common.collect.ImmutableList;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaProcessorLists {
	public static final ResourceKey<StructureProcessorList> TEMPLE = IcariaProcessorLists.createKey("temple");

	public static final ResourceKey<StructureProcessorList> ERODED_DOLOMITE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/eroded/dolomite");
	public static final ResourceKey<StructureProcessorList> ERODED_SILKSTONE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/eroded/silkstone");
	public static final ResourceKey<StructureProcessorList> ERODED_SUNSTONE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/eroded/sunstone");

	public static final ResourceKey<StructureProcessorList> PRISTINE_DOLOMITE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/pristine/dolomite");
	public static final ResourceKey<StructureProcessorList> PRISTINE_SILKSTONE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/pristine/silkstone");
	public static final ResourceKey<StructureProcessorList> PRISTINE_SUNSTONE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/pristine/sunstone");

	public static final ResourceKey<StructureProcessorList> RUINED_DOLOMITE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/ruined/dolomite");
	public static final ResourceKey<StructureProcessorList> RUINED_SILKSTONE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/ruined/silkstone");
	public static final ResourceKey<StructureProcessorList> RUINED_SUNSTONE_FOREST_VILLAGE = IcariaProcessorLists.createKey("villages/forest/ruined/sunstone");

	public static final ResourceKey<StructureProcessorList> ERODED_SUNSTONE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/eroded/sunstone");
	public static final ResourceKey<StructureProcessorList> ERODED_VOIDSHALE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/eroded/voidshale");
	public static final ResourceKey<StructureProcessorList> ERODED_YELLOWSTONE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/eroded/yellowstone");

	public static final ResourceKey<StructureProcessorList> PRISTINE_SUNSTONE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/pristine/sunstone");
	public static final ResourceKey<StructureProcessorList> PRISTINE_VOIDSHALE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/pristine/voidshale");
	public static final ResourceKey<StructureProcessorList> PRISTINE_YELLOWSTONE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/pristine/yellowstone");

	public static final ResourceKey<StructureProcessorList> RUINED_SUNSTONE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/ruined/sunstone");
	public static final ResourceKey<StructureProcessorList> RUINED_VOIDSHALE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/ruined/voidshale");
	public static final ResourceKey<StructureProcessorList> RUINED_YELLOWSTONE_SCRUBLAND_VILLAGE = IcariaProcessorLists.createKey("villages/scrubland/ruined/yellowstone");

	public static final ResourceKey<StructureProcessorList> ERODED_GRAINITE_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/eroded/grainite");
	public static final ResourceKey<StructureProcessorList> ERODED_MARL_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/eroded/marl");
	public static final ResourceKey<StructureProcessorList> ERODED_YELLOWSTONE_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/eroded/yellowstone");

	public static final ResourceKey<StructureProcessorList> PRISTINE_GRAINITE_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/pristine/grainite");
	public static final ResourceKey<StructureProcessorList> PRISTINE_MARL_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/pristine/marl");
	public static final ResourceKey<StructureProcessorList> PRISTINE_YELLOWSTONE_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/pristine/yellowstone");

	public static final ResourceKey<StructureProcessorList> RUINED_GRAINITE_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/ruined/grainite");
	public static final ResourceKey<StructureProcessorList> RUINED_MARL_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/ruined/marl");
	public static final ResourceKey<StructureProcessorList> RUINED_YELLOWSTONE_STEPPE_VILLAGE = IcariaProcessorLists.createKey("villages/steppe/ruined/yellowstone");

	public static final ResourceKey<StructureProcessorList> ERODED_BAETYL_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/eroded/baetyl");
	public static final ResourceKey<StructureProcessorList> ERODED_GRAINITE_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/eroded/grainite");
	public static final ResourceKey<StructureProcessorList> ERODED_VOIDSHALE_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/eroded/voidshale");

	public static final ResourceKey<StructureProcessorList> PRISTINE_BAETYL_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/pristine/baetyl");
	public static final ResourceKey<StructureProcessorList> PRISTINE_GRAINITE_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/pristine/grainite");
	public static final ResourceKey<StructureProcessorList> PRISTINE_VOIDSHALE_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/pristine/voidshale");

	public static final ResourceKey<StructureProcessorList> RUINED_BAETYL_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/ruined/baetyl");
	public static final ResourceKey<StructureProcessorList> RUINED_GRAINITE_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/ruined/grainite");
	public static final ResourceKey<StructureProcessorList> RUINED_VOIDSHALE_DESERT_VILLAGE = IcariaProcessorLists.createKey("villages/desert/ruined/voidshale");

	public static void bootstrap(BootstrapContext<StructureProcessorList> pContext) {
		pContext.register(IcariaProcessorLists.TEMPLE, IcariaProcessorLists.temple());

		pContext.register(IcariaProcessorLists.ERODED_DOLOMITE_FOREST_VILLAGE, IcariaProcessorLists.erodedForestVillage(IcariaBlocks.DOLOMITE_ADOBE.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_SILKSTONE_FOREST_VILLAGE, IcariaProcessorLists.erodedForestVillage(IcariaBlocks.SILKSTONE_ADOBE.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_SUNSTONE_FOREST_VILLAGE, IcariaProcessorLists.erodedForestVillage(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.PRISTINE_DOLOMITE_FOREST_VILLAGE, IcariaProcessorLists.pristineForestVillage(IcariaBlocks.DOLOMITE_ADOBE.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_SILKSTONE_FOREST_VILLAGE, IcariaProcessorLists.pristineForestVillage(IcariaBlocks.SILKSTONE_ADOBE.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_SUNSTONE_FOREST_VILLAGE, IcariaProcessorLists.pristineForestVillage(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.RUINED_DOLOMITE_FOREST_VILLAGE, IcariaProcessorLists.ruinedForestVillage(IcariaBlocks.DOLOMITE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_SILKSTONE_FOREST_VILLAGE, IcariaProcessorLists.ruinedForestVillage(IcariaBlocks.SILKSTONE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_SUNSTONE_FOREST_VILLAGE, IcariaProcessorLists.ruinedForestVillage(IcariaBlocks.SUNSTONE_ADOBE.get()));

		pContext.register(IcariaProcessorLists.ERODED_SUNSTONE_SCRUBLAND_VILLAGE, IcariaProcessorLists.erodedScrublandVillage(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_VOIDSHALE_SCRUBLAND_VILLAGE, IcariaProcessorLists.erodedScrublandVillage(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_YELLOWSTONE_SCRUBLAND_VILLAGE, IcariaProcessorLists.erodedScrublandVillage(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.PRISTINE_SUNSTONE_SCRUBLAND_VILLAGE, IcariaProcessorLists.pristineScrublandVillage(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_VOIDSHALE_SCRUBLAND_VILLAGE, IcariaProcessorLists.pristineScrublandVillage(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_YELLOWSTONE_SCRUBLAND_VILLAGE, IcariaProcessorLists.pristineScrublandVillage(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.RUINED_SUNSTONE_SCRUBLAND_VILLAGE, IcariaProcessorLists.ruinedScrublandVillage(IcariaBlocks.SUNSTONE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_VOIDSHALE_SCRUBLAND_VILLAGE, IcariaProcessorLists.ruinedScrublandVillage(IcariaBlocks.VOIDSHALE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_YELLOWSTONE_SCRUBLAND_VILLAGE, IcariaProcessorLists.ruinedScrublandVillage(IcariaBlocks.YELLOWSTONE_ADOBE.get()));

		pContext.register(IcariaProcessorLists.ERODED_GRAINITE_STEPPE_VILLAGE, IcariaProcessorLists.erodedSteppeVillage(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_MARL_STEPPE_VILLAGE, IcariaProcessorLists.erodedSteppeVillage(IcariaBlocks.MARL_ADOBE.get(), IcariaBlocks.MARL_ADOBE_DECO.stairs.get(), IcariaBlocks.MARL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_YELLOWSTONE_STEPPE_VILLAGE, IcariaProcessorLists.erodedSteppeVillage(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.PRISTINE_GRAINITE_STEPPE_VILLAGE, IcariaProcessorLists.pristineSteppeVillage(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_MARL_STEPPE_VILLAGE, IcariaProcessorLists.pristineSteppeVillage(IcariaBlocks.MARL_ADOBE.get(), IcariaBlocks.MARL_ADOBE_DECO.stairs.get(), IcariaBlocks.MARL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_YELLOWSTONE_STEPPE_VILLAGE, IcariaProcessorLists.pristineSteppeVillage(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.RUINED_GRAINITE_STEPPE_VILLAGE, IcariaProcessorLists.ruinedSteppeVillage(IcariaBlocks.GRAINITE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_MARL_STEPPE_VILLAGE, IcariaProcessorLists.ruinedSteppeVillage(IcariaBlocks.MARL_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_YELLOWSTONE_STEPPE_VILLAGE, IcariaProcessorLists.ruinedSteppeVillage(IcariaBlocks.YELLOWSTONE_ADOBE.get()));

		pContext.register(IcariaProcessorLists.ERODED_BAETYL_DESERT_VILLAGE, IcariaProcessorLists.erodedDesertVillage(IcariaBlocks.BAETYL_ADOBE.get(), IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get(), IcariaBlocks.BAETYL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_GRAINITE_DESERT_VILLAGE, IcariaProcessorLists.erodedDesertVillage(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.ERODED_VOIDSHALE_DESERT_VILLAGE, IcariaProcessorLists.erodedDesertVillage(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.PRISTINE_BAETYL_DESERT_VILLAGE, IcariaProcessorLists.pristineDesertVillage(IcariaBlocks.BAETYL_ADOBE.get(), IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get(), IcariaBlocks.BAETYL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_GRAINITE_DESERT_VILLAGE, IcariaProcessorLists.pristineDesertVillage(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.PRISTINE_VOIDSHALE_DESERT_VILLAGE, IcariaProcessorLists.pristineDesertVillage(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.RUINED_BAETYL_DESERT_VILLAGE, IcariaProcessorLists.ruinedDesertVillage(IcariaBlocks.BAETYL_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_GRAINITE_DESERT_VILLAGE, IcariaProcessorLists.ruinedDesertVillage(IcariaBlocks.GRAINITE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.RUINED_VOIDSHALE_DESERT_VILLAGE, IcariaProcessorLists.ruinedDesertVillage(IcariaBlocks.VOIDSHALE_ADOBE.get()));
	}

	public static StructureProcessorList temple() {
		return new StructureProcessorList(ImmutableList.of(
			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_BRICKS.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get()),
			IcariaProcessorLists.stairs(IcariaBlocks.RELICSTONE_BRICK_DECO.stairs.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.stairs.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.stairs.get()),
			IcariaProcessorLists.slab(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get()),
			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILES.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_TILES.get()),
			IcariaProcessorLists.stairs(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.stairs.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.stairs.get()),
			IcariaProcessorLists.slab(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get()),
			IcariaProcessorLists.block(IcariaBlocks.RED_LOOT_VASE.get(), 0.1F, IcariaBlocks.CYAN_LOOT_VASE.get(), 0.2F, IcariaBlocks.REVENANT_SPAWNER.get(), 0.2F, Blocks.AIR)
		));
	}

	public static StructureProcessorList erodedForestVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.erodedVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_POPULUS_LOG.get(),
			IcariaBlocks.POPULUS_DECO.stairs.get(),
			IcariaBlocks.POPULUS_DECO.slab.get(),
			IcariaBlocks.SIMPLE_POPULUS_RACK.get(),
			IcariaBlocks.POPULUS_RACK.get(),
			IcariaBlocks.POPULUS_BARREL.get(),
			IcariaBlocks.LOADED_POPULUS_BARREL.get(),
			IcariaBlocks.TAPPED_POPULUS_BARREL.get(),
			IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get(),
			IcariaBlocks.POPULUS_WALL_SIGN.get(),
			IcariaBlocks.FIR_PLANKS.get(),
			IcariaBlocks.FIR_DECO.slab.get(),
			IcariaBlocks.FIR_DECO.fence.get(),
			IcariaBlocks.FIR_CRAFTING_TABLE.get(),
			IcariaBlocks.FIR_DOOR.get(),
			IcariaBlocks.FIR_TRAPDOOR.get(),
			IcariaBlocks.FIR_LADDER.get()
		);
	}

	public static StructureProcessorList pristineForestVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristineVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_POPULUS_LOG.get(),
			IcariaBlocks.POPULUS_DECO.stairs.get(),
			IcariaBlocks.POPULUS_DECO.slab.get(),
			IcariaBlocks.SIMPLE_POPULUS_RACK.get(),
			IcariaBlocks.POPULUS_RACK.get(),
			IcariaBlocks.POPULUS_BARREL.get(),
			IcariaBlocks.LOADED_POPULUS_BARREL.get(),
			IcariaBlocks.TAPPED_POPULUS_BARREL.get(),
			IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get(),
			IcariaBlocks.POPULUS_WALL_SIGN.get(),
			IcariaBlocks.FIR_PLANKS.get(),
			IcariaBlocks.FIR_DECO.slab.get(),
			IcariaBlocks.FIR_DECO.fence.get(),
			IcariaBlocks.FIR_CRAFTING_TABLE.get(),
			IcariaBlocks.FIR_DOOR.get(),
			IcariaBlocks.FIR_TRAPDOOR.get(),
			IcariaBlocks.FIR_LADDER.get()
		);
	}

	public static StructureProcessorList ruinedForestVillage(Block pAdobeBlock) {
		return IcariaProcessorLists.ruinedVillage(pAdobeBlock);
	}

	public static StructureProcessorList erodedScrublandVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.erodedVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_LAUREL_LOG.get(),
			IcariaBlocks.LAUREL_DECO.stairs.get(),
			IcariaBlocks.LAUREL_DECO.slab.get(),
			IcariaBlocks.SIMPLE_LAUREL_RACK.get(),
			IcariaBlocks.LAUREL_RACK.get(),
			IcariaBlocks.LAUREL_BARREL.get(),
			IcariaBlocks.LOADED_LAUREL_BARREL.get(),
			IcariaBlocks.TAPPED_LAUREL_BARREL.get(),
			IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(),
			IcariaBlocks.LAUREL_WALL_SIGN.get(),
			IcariaBlocks.PLANE_PLANKS.get(),
			IcariaBlocks.PLANE_DECO.slab.get(),
			IcariaBlocks.PLANE_DECO.fence.get(),
			IcariaBlocks.PLANE_CRAFTING_TABLE.get(),
			IcariaBlocks.PLANE_DOOR.get(),
			IcariaBlocks.PLANE_TRAPDOOR.get(),
			IcariaBlocks.PLANE_LADDER.get()
		);
	}

	public static StructureProcessorList pristineScrublandVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristineVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_LAUREL_LOG.get(),
			IcariaBlocks.LAUREL_DECO.stairs.get(),
			IcariaBlocks.LAUREL_DECO.slab.get(),
			IcariaBlocks.SIMPLE_LAUREL_RACK.get(),
			IcariaBlocks.LAUREL_RACK.get(),
			IcariaBlocks.LAUREL_BARREL.get(),
			IcariaBlocks.LOADED_LAUREL_BARREL.get(),
			IcariaBlocks.TAPPED_LAUREL_BARREL.get(),
			IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(),
			IcariaBlocks.LAUREL_WALL_SIGN.get(),
			IcariaBlocks.PLANE_PLANKS.get(),
			IcariaBlocks.PLANE_DECO.slab.get(),
			IcariaBlocks.PLANE_DECO.fence.get(),
			IcariaBlocks.PLANE_CRAFTING_TABLE.get(),
			IcariaBlocks.PLANE_DOOR.get(),
			IcariaBlocks.PLANE_TRAPDOOR.get(),
			IcariaBlocks.PLANE_LADDER.get()
		);
	}

	public static StructureProcessorList ruinedScrublandVillage(Block pAdobeBlock) {
		return IcariaProcessorLists.ruinedVillage(pAdobeBlock);
	}

	public static StructureProcessorList erodedSteppeVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.erodedVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_CYPRESS_LOG.get(),
			IcariaBlocks.CYPRESS_DECO.stairs.get(),
			IcariaBlocks.CYPRESS_DECO.slab.get(),
			IcariaBlocks.SIMPLE_CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_BARREL.get(),
			IcariaBlocks.LOADED_CYPRESS_BARREL.get(),
			IcariaBlocks.TAPPED_CYPRESS_BARREL.get(),
			IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(),
			IcariaBlocks.CYPRESS_WALL_SIGN.get(),
			IcariaBlocks.OLIVE_PLANKS.get(),
			IcariaBlocks.OLIVE_DECO.slab.get(),
			IcariaBlocks.OLIVE_DECO.fence.get(),
			IcariaBlocks.OLIVE_CRAFTING_TABLE.get(),
			IcariaBlocks.OLIVE_DOOR.get(),
			IcariaBlocks.OLIVE_TRAPDOOR.get(),
			IcariaBlocks.OLIVE_LADDER.get()
		);
	}

	public static StructureProcessorList pristineSteppeVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristineVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_CYPRESS_LOG.get(),
			IcariaBlocks.CYPRESS_DECO.stairs.get(),
			IcariaBlocks.CYPRESS_DECO.slab.get(),
			IcariaBlocks.SIMPLE_CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_BARREL.get(),
			IcariaBlocks.LOADED_CYPRESS_BARREL.get(),
			IcariaBlocks.TAPPED_CYPRESS_BARREL.get(),
			IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(),
			IcariaBlocks.CYPRESS_WALL_SIGN.get(),
			IcariaBlocks.OLIVE_PLANKS.get(),
			IcariaBlocks.OLIVE_DECO.slab.get(),
			IcariaBlocks.OLIVE_DECO.fence.get(),
			IcariaBlocks.OLIVE_CRAFTING_TABLE.get(),
			IcariaBlocks.OLIVE_DOOR.get(),
			IcariaBlocks.OLIVE_TRAPDOOR.get(),
			IcariaBlocks.OLIVE_LADDER.get()
		);
	}

	public static StructureProcessorList ruinedSteppeVillage(Block pAdobeBlock) {
		return IcariaProcessorLists.ruinedVillage(pAdobeBlock);
	}

	public static StructureProcessorList erodedDesertVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.erodedVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_CYPRESS_LOG.get(),
			IcariaBlocks.CYPRESS_DECO.stairs.get(),
			IcariaBlocks.CYPRESS_DECO.slab.get(),
			IcariaBlocks.SIMPLE_CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_BARREL.get(),
			IcariaBlocks.LOADED_CYPRESS_BARREL.get(),
			IcariaBlocks.TAPPED_CYPRESS_BARREL.get(),
			IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(),
			IcariaBlocks.CYPRESS_WALL_SIGN.get(),
			IcariaBlocks.DROUGHTROOT_PLANKS.get(),
			IcariaBlocks.DROUGHTROOT_DECO.slab.get(),
			IcariaBlocks.DROUGHTROOT_DECO.fence.get(),
			IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(),
			IcariaBlocks.DROUGHTROOT_DOOR.get(),
			IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(),
			IcariaBlocks.DROUGHTROOT_LADDER.get()
		);
	}

	public static StructureProcessorList pristineDesertVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristineVillage(pAdobeBlock, pAdobeStairs, pAdobeSlab,
			IcariaBlocks.STRIPPED_CYPRESS_LOG.get(),
			IcariaBlocks.CYPRESS_DECO.stairs.get(),
			IcariaBlocks.CYPRESS_DECO.slab.get(),
			IcariaBlocks.SIMPLE_CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_RACK.get(),
			IcariaBlocks.CYPRESS_BARREL.get(),
			IcariaBlocks.LOADED_CYPRESS_BARREL.get(),
			IcariaBlocks.TAPPED_CYPRESS_BARREL.get(),
			IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get(),
			IcariaBlocks.CYPRESS_WALL_SIGN.get(),
			IcariaBlocks.DROUGHTROOT_PLANKS.get(),
			IcariaBlocks.DROUGHTROOT_DECO.slab.get(),
			IcariaBlocks.DROUGHTROOT_DECO.fence.get(),
			IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(),
			IcariaBlocks.DROUGHTROOT_DOOR.get(),
			IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(),
			IcariaBlocks.DROUGHTROOT_LADDER.get()
		);
	}

	public static StructureProcessorList ruinedDesertVillage(Block pAdobeBlock) {
		return IcariaProcessorLists.ruinedVillage(pAdobeBlock);
	}

	public static StructureProcessorList erodedVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab, Block pStrippedLog, Block pLaurelStairs, Block pLaurelSlab, Block pSimpleRack, Block pRack, Block pBarrel, Block pLoadedBarrel, Block pTappedBarrel, Block pTripleBarrel, Block pWallSign, Block pPlanePlanks, Block pPlaneSlab, Block pPlaneFence, Block pCraftingTable, Block pDoor, Block pTrapdoor, Block pLadder) {
		return new StructureProcessorList(ImmutableList.of(
			IcariaProcessorLists.block(IcariaBlocks.YELLOWSTONE_ADOBE.get(), pAdobeBlock),
			IcariaProcessorLists.stairs(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), pAdobeStairs),
			IcariaProcessorLists.slab(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), pAdobeSlab),

			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILES.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_TILES.get()),
			IcariaProcessorLists.stairs(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get(), 0.25F, IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.stairs.get(), 0.25F, IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.stairs.get()),

			IcariaProcessorLists.block(IcariaBlocks.RED_LOOT_VASE.get(), 0.25F, IcariaBlocks.REVENANT_SPAWNER.get(), 0.5F, Blocks.AIR),

			IcariaProcessorLists.log(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pStrippedLog),
			IcariaProcessorLists.stairs(IcariaBlocks.LAUREL_DECO.stairs.get(), pLaurelStairs),
			IcariaProcessorLists.slab(IcariaBlocks.LAUREL_DECO.slab.get(), pLaurelSlab),
			IcariaProcessorLists.rack(IcariaBlocks.SIMPLE_LAUREL_RACK.get(), pSimpleRack),
			IcariaProcessorLists.rack(IcariaBlocks.LAUREL_RACK.get(), pRack),
			IcariaProcessorLists.barrel(IcariaBlocks.LAUREL_BARREL.get(), pBarrel),
			IcariaProcessorLists.barrel(IcariaBlocks.LOADED_LAUREL_BARREL.get(), pLoadedBarrel),
			IcariaProcessorLists.barrel(IcariaBlocks.TAPPED_LAUREL_BARREL.get(), pTappedBarrel),
			IcariaProcessorLists.tripleBarrel(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), pTripleBarrel),
			IcariaProcessorLists.wallSign(IcariaBlocks.LAUREL_WALL_SIGN.get(), pWallSign),

			IcariaProcessorLists.block(IcariaBlocks.PLANE_PLANKS.get(), pPlanePlanks),
			IcariaProcessorLists.slab(IcariaBlocks.PLANE_DECO.slab.get(), pPlaneSlab),
			IcariaProcessorLists.fence(IcariaBlocks.PLANE_DECO.fence.get(), pPlaneFence),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), pCraftingTable),
			IcariaProcessorLists.door(IcariaBlocks.PLANE_DOOR.get(), pDoor),
			IcariaProcessorLists.trapdoor(IcariaBlocks.PLANE_TRAPDOOR.get(), pTrapdoor),
			IcariaProcessorLists.ladder(IcariaBlocks.PLANE_LADDER.get(), pLadder)
		));
	}

	public static StructureProcessorList pristineVillage(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab, Block pStrippedLog, Block pLaurelStairs, Block pLaurelSlab, Block pSimpleRack, Block pRack, Block pBarrel, Block pLoadedBarrel, Block pTappedBarrel, Block pTripleBarrel, Block pWallSign, Block pPlanePlanks, Block pPlaneSlab, Block pPlaneFence, Block pCraftingTable, Block pDoor, Block pTrapdoor, Block pLadder) {
		return new StructureProcessorList(ImmutableList.of(
			IcariaProcessorLists.block(IcariaBlocks.YELLOWSTONE_ADOBE.get(), pAdobeBlock),
			IcariaProcessorLists.stairs(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), pAdobeStairs),
			IcariaProcessorLists.slab(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), pAdobeSlab),

			IcariaProcessorLists.block(IcariaBlocks.RED_LOOT_VASE.get(), 0.66F, Blocks.AIR),

			IcariaProcessorLists.log(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), pStrippedLog),
			IcariaProcessorLists.stairs(IcariaBlocks.LAUREL_DECO.stairs.get(), pLaurelStairs),
			IcariaProcessorLists.slab(IcariaBlocks.LAUREL_DECO.slab.get(), pLaurelSlab),
			IcariaProcessorLists.rack(IcariaBlocks.SIMPLE_LAUREL_RACK.get(), pSimpleRack),
			IcariaProcessorLists.rack(IcariaBlocks.LAUREL_RACK.get(), pRack),
			IcariaProcessorLists.barrel(IcariaBlocks.LAUREL_BARREL.get(), pBarrel),
			IcariaProcessorLists.barrel(IcariaBlocks.LOADED_LAUREL_BARREL.get(), pLoadedBarrel),
			IcariaProcessorLists.barrel(IcariaBlocks.TAPPED_LAUREL_BARREL.get(), pTappedBarrel),
			IcariaProcessorLists.tripleBarrel(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), pTripleBarrel),
			IcariaProcessorLists.wallSign(IcariaBlocks.LAUREL_WALL_SIGN.get(), pWallSign),

			IcariaProcessorLists.block(IcariaBlocks.PLANE_PLANKS.get(), pPlanePlanks),
			IcariaProcessorLists.slab(IcariaBlocks.PLANE_DECO.slab.get(), pPlaneSlab),
			IcariaProcessorLists.fence(IcariaBlocks.PLANE_DECO.fence.get(), pPlaneFence),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), pCraftingTable),
			IcariaProcessorLists.door(IcariaBlocks.PLANE_DOOR.get(), pDoor),
			IcariaProcessorLists.trapdoor(IcariaBlocks.PLANE_TRAPDOOR.get(), pTrapdoor),
			IcariaProcessorLists.ladder(IcariaBlocks.PLANE_LADDER.get(), pLadder)
		));
	}

	public static StructureProcessorList ruinedVillage(Block pAdobeBlock) {
		return new StructureProcessorList(ImmutableList.of(
			IcariaProcessorLists.block(Blocks.CHISELED_BOOKSHELF, Blocks.AIR),
			IcariaProcessorLists.block(Blocks.COMPOSTER, Blocks.AIR),
			IcariaProcessorLists.block(Blocks.GRAY_CONCRETE, Blocks.AIR),
			IcariaProcessorLists.block(Blocks.PINK_CONCRETE, Blocks.AIR),

			IcariaProcessorLists.block(IcariaBlocks.SURFACE_LIGNITE.get(), Blocks.AIR),

			IcariaProcessorLists.block(IcariaBlocks.GRAINITE_BRICKS.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.GRAINITE_BRICK_DECO.stairs.get(), Blocks.AIR),

			IcariaProcessorLists.block(IcariaBlocks.YELLOWSTONE_ADOBE.get(), pAdobeBlock),
			IcariaProcessorLists.block(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), Blocks.AIR),

			IcariaProcessorLists.block(pAdobeBlock, 0.25F, Blocks.COBWEB, 0.25F, Blocks.AIR, Direction.Axis.Y), // TODO replace with Arachne web

			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILES.get(), 0.25F, Blocks.COBWEB, 0.25F, Blocks.AIR, Direction.Axis.Y), // TODO replace with Arachne web
			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILES.get(), 0.5F, IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), 0.5F, IcariaBlocks.MOSSY_RELICSTONE_TILES.get()),
			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get(), Blocks.AIR),

			IcariaProcessorLists.block(IcariaBlocks.CHEST.get(), Blocks.AIR),

			IcariaProcessorLists.block(IcariaBlocks.RED_LOOT_VASE.get(), 0.25F, IcariaBlocks.ARACHNE_SPAWNER.get(), 0.5F, Blocks.AIR),

			IcariaProcessorLists.block(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.LAUREL_DECO.stairs.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.LAUREL_DECO.slab.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.SIMPLE_LAUREL_RACK.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.LAUREL_RACK.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.LAUREL_BARREL.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.LOADED_LAUREL_BARREL.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.TAPPED_LAUREL_BARREL.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.LAUREL_WALL_SIGN.get(), Blocks.AIR),

			IcariaProcessorLists.block(IcariaBlocks.PLANE_PLANKS.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_DECO.slab.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_DECO.fence.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_DOOR.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_TRAPDOOR.get(), Blocks.AIR),
			IcariaProcessorLists.block(IcariaBlocks.PLANE_LADDER.get(), Blocks.AIR)
		));
	}

	public static RuleProcessor block(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockMatchTest(pOld), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState())
		));
	}

	public static RuleProcessor block(Block pOld, Block pNew, Direction.Axis pAxis) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockMatchTest(pOld), AlwaysTrueTest.INSTANCE, new AxisAlignedLinearPosTest(0.0F, 1.0F, 0, 8, pAxis), pNew.defaultBlockState())
		));
	}

	public static RuleProcessor block(Block pOld, float pChance, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChance), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState())
		));
	}

	public static RuleProcessor block(Block pOld, float pChance, Block pNew, Direction.Axis pAxis) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChance), AlwaysTrueTest.INSTANCE, new AxisAlignedLinearPosTest(0.0F, 1.0F, 0, 8, pAxis), pNew.defaultBlockState())
		));
	}

	public static RuleProcessor block(Block pOld, float pChanceA, Block pNewA, float pChanceB, Block pNewB) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState()),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState())
		));
	}

	public static RuleProcessor block(Block pOld, float pChanceA, Block pNewA, float pChanceB, Block pNewB, Direction.Axis pAxis) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceA), AlwaysTrueTest.INSTANCE, new AxisAlignedLinearPosTest(0.0F, 1.0F, 0, 8, pAxis), pNewA.defaultBlockState()),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceB), AlwaysTrueTest.INSTANCE, new AxisAlignedLinearPosTest(0.0F, 1.0F, 0, 8, pAxis), pNewB.defaultBlockState())
		));
	}

	public static RuleProcessor block(Block pOld, float pChanceA, Block pNewA, float pChanceB, Block pNewB, float pChanceC, Block pNewC) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState()),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState()),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceC), AlwaysTrueTest.INSTANCE, pNewC.defaultBlockState())
		));
	}

	public static RuleProcessor block(Block pOld, float pChanceA, Block pNewA, float pChanceB, Block pNewB, float pChanceC, Block pNewC, Direction.Axis pAxis) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceA), AlwaysTrueTest.INSTANCE, new AxisAlignedLinearPosTest(0.0F, 1.0F, 0, 8, pAxis), pNewA.defaultBlockState()),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceB), AlwaysTrueTest.INSTANCE, new AxisAlignedLinearPosTest(0.0F, 1.0F, 0, 8, pAxis), pNewB.defaultBlockState()),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChanceC), AlwaysTrueTest.INSTANCE, new AxisAlignedLinearPosTest(0.0F, 1.0F, 0, 8, pAxis), pNewC.defaultBlockState())
		));
	}

	public static RuleProcessor stairs(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT))
		));
	}

	public static RuleProcessor stairs(Block pOld, float pChanceA, Block pNewA, float pChanceB, Block pNewB) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.INNER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_LEFT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.STAIRS_SHAPE, StairsShape.OUTER_RIGHT))
		));
	}

	public static RuleProcessor slab(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE))
		));
	}

	public static RuleProcessor slab(Block pOld, float pChanceA, Block pNewA, float pChanceB, Block pNewB) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE), pChanceA), AlwaysTrueTest.INSTANCE, pNewA.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.TOP)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM)),
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE), pChanceB), AlwaysTrueTest.INSTANCE, pNewB.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE))
		));
	}

	public static RuleProcessor log(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z))
		));
	}

	public static RuleProcessor rack(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.FULL_RACK, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.FULL_RACK, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.FULL_RACK, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.FULL_RACK, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.FULL_RACK, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.FULL_RACK, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.FULL_RACK, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.FULL_RACK, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.LOADED_BARREL, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.FULL_RACK, true).setValue(IcariaBlockStateProperties.TAPPED_BARREL, true))
		));
	}

	public static RuleProcessor barrel(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.UP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.NORTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.EAST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.SOUTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.BARREL_FACING, Direction.WEST))
		));
	}

	public static RuleProcessor tripleBarrel(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT))
		));
	}

	public static RuleProcessor wallSign(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING))
		));
	}

	public static RuleProcessor fence(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState()), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState()),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.NORTH, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.NORTH, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.EAST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.EAST, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SOUTH, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.SOUTH, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.WEST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.WEST, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SOUTH, true).setValue(BlockStateProperties.WEST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.SOUTH, true).setValue(BlockStateProperties.WEST, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.WEST, true).setValue(BlockStateProperties.NORTH, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.WEST, true).setValue(BlockStateProperties.NORTH, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.SOUTH, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.SOUTH, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.WEST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.WEST, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true).setValue(BlockStateProperties.WEST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true).setValue(BlockStateProperties.WEST, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.SOUTH, true).setValue(BlockStateProperties.WEST, true).setValue(BlockStateProperties.NORTH, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.SOUTH  , true).setValue(BlockStateProperties.WEST, true).setValue(BlockStateProperties.NORTH, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.WEST, true).setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.WEST, true).setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true).setValue(BlockStateProperties.WEST, true)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.NORTH, true).setValue(BlockStateProperties.EAST, true).setValue(BlockStateProperties.SOUTH, true).setValue(BlockStateProperties.WEST, true))
		));
	}

	public static RuleProcessor door(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.DOOR_HINGE, DoorHingeSide.RIGHT))
		));
	}

	public static RuleProcessor trapdoor(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.TOP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.TOP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.TOP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.TOP)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.HALF, Half.BOTTOM)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(BlockStateProperties.HALF, Half.BOTTOM)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(BlockStateProperties.HALF, Half.BOTTOM)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(BlockStateProperties.HALF, Half.BOTTOM))
		));
	}

	public static RuleProcessor ladder(Block pOld, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST))
		));
	}

	public static ResourceKey<StructureProcessorList> createKey(String pName) {
		return ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
