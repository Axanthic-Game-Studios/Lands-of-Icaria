package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.properties.Corner;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.ImmutableList;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaProcessorLists {
	// FOREST

	public static final ResourceKey<StructureProcessorList> FOREST_ERODED_DOLOMITE = IcariaProcessorLists.registerKey("villages/forest/eroded/dolomite");
	public static final ResourceKey<StructureProcessorList> FOREST_ERODED_SILKSTONE = IcariaProcessorLists.registerKey("villages/forest/eroded/silkstone");
	public static final ResourceKey<StructureProcessorList> FOREST_ERODED_SUNSTONE = IcariaProcessorLists.registerKey("villages/forest/eroded/sunstone");

	public static final ResourceKey<StructureProcessorList> FOREST_PRISTINE_DOLOMITE = IcariaProcessorLists.registerKey("villages/forest/pristine/dolomite");
	public static final ResourceKey<StructureProcessorList> FOREST_PRISTINE_SILKSTONE = IcariaProcessorLists.registerKey("villages/forest/pristine/silkstone");
	public static final ResourceKey<StructureProcessorList> FOREST_PRISTINE_SUNSTONE = IcariaProcessorLists.registerKey("villages/forest/pristine/sunstone");

	public static final ResourceKey<StructureProcessorList> FOREST_RUINED_DOLOMITE = IcariaProcessorLists.registerKey("villages/forest/ruined/dolomite");
	public static final ResourceKey<StructureProcessorList> FOREST_RUINED_SILKSTONE = IcariaProcessorLists.registerKey("villages/forest/ruined/silkstone");
	public static final ResourceKey<StructureProcessorList> FOREST_RUINED_SUNSTONE = IcariaProcessorLists.registerKey("villages/forest/ruined/sunstone");

	// SCRUBLAND

	public static final ResourceKey<StructureProcessorList> SCRUBLAND_ERODED_SUNSTONE = IcariaProcessorLists.registerKey("villages/scrubland/eroded/sunstone");
	public static final ResourceKey<StructureProcessorList> SCRUBLAND_ERODED_VOIDSHALE = IcariaProcessorLists.registerKey("villages/scrubland/eroded/voidshale");
	public static final ResourceKey<StructureProcessorList> SCRUBLAND_ERODED_YELLOWSTONE = IcariaProcessorLists.registerKey("villages/scrubland/eroded/yellowstone");

	public static final ResourceKey<StructureProcessorList> SCRUBLAND_PRISTINE_SUNSTONE = IcariaProcessorLists.registerKey("villages/scrubland/pristine/sunstone");
	public static final ResourceKey<StructureProcessorList> SCRUBLAND_PRISTINE_VOIDSHALE = IcariaProcessorLists.registerKey("villages/scrubland/pristine/voidshale");
	public static final ResourceKey<StructureProcessorList> SCRUBLAND_PRISTINE_YELLOWSTONE = IcariaProcessorLists.registerKey("villages/scrubland/pristine/yellowstone");

	public static final ResourceKey<StructureProcessorList> SCRUBLAND_RUINED_SUNSTONE = IcariaProcessorLists.registerKey("villages/scrubland/ruined/sunstone");
	public static final ResourceKey<StructureProcessorList> SCRUBLAND_RUINED_VOIDSHALE = IcariaProcessorLists.registerKey("villages/scrubland/ruined/voidshale");
	public static final ResourceKey<StructureProcessorList> SCRUBLAND_RUINED_YELLOWSTONE = IcariaProcessorLists.registerKey("villages/scrubland/ruined/yellowstone");

	// STEPPE

	public static final ResourceKey<StructureProcessorList> STEPPE_ERODED_GRAINITE = IcariaProcessorLists.registerKey("villages/steppe/eroded/grainite");
	public static final ResourceKey<StructureProcessorList> STEPPE_ERODED_MARL = IcariaProcessorLists.registerKey("villages/steppe/eroded/marl");
	public static final ResourceKey<StructureProcessorList> STEPPE_ERODED_YELLOWSTONE = IcariaProcessorLists.registerKey("villages/steppe/eroded/yellowstone");

	public static final ResourceKey<StructureProcessorList> STEPPE_PRISTINE_GRAINITE = IcariaProcessorLists.registerKey("villages/steppe/pristine/grainite");
	public static final ResourceKey<StructureProcessorList> STEPPE_PRISTINE_MARL = IcariaProcessorLists.registerKey("villages/steppe/pristine/marl");
	public static final ResourceKey<StructureProcessorList> STEPPE_PRISTINE_YELLOWSTONE = IcariaProcessorLists.registerKey("villages/steppe/pristine/yellowstone");

	public static final ResourceKey<StructureProcessorList> STEPPE_RUINED_GRAINITE = IcariaProcessorLists.registerKey("villages/steppe/ruined/grainite");
	public static final ResourceKey<StructureProcessorList> STEPPE_RUINED_MARL = IcariaProcessorLists.registerKey("villages/steppe/ruined/marl");
	public static final ResourceKey<StructureProcessorList> STEPPE_RUINED_YELLOWSTONE = IcariaProcessorLists.registerKey("villages/steppe/ruined/yellowstone");

	// DESERT

	public static final ResourceKey<StructureProcessorList> DESERT_ERODED_BAETYL = IcariaProcessorLists.registerKey("villages/desert/eroded/baetyl");
	public static final ResourceKey<StructureProcessorList> DESERT_ERODED_GRAINITE = IcariaProcessorLists.registerKey("villages/desert/eroded/grainite");
	public static final ResourceKey<StructureProcessorList> DESERT_ERODED_VOIDSHALE = IcariaProcessorLists.registerKey("villages/desert/eroded/voidshale");

	public static final ResourceKey<StructureProcessorList> DESERT_PRISTINE_BAETYL = IcariaProcessorLists.registerKey("villages/desert/pristine/baetyl");
	public static final ResourceKey<StructureProcessorList> DESERT_PRISTINE_GRAINITE = IcariaProcessorLists.registerKey("villages/desert/pristine/grainite");
	public static final ResourceKey<StructureProcessorList> DESERT_PRISTINE_VOIDSHALE = IcariaProcessorLists.registerKey("villages/desert/pristine/voidshale");

	public static final ResourceKey<StructureProcessorList> DESERT_RUINED_BAETYL = IcariaProcessorLists.registerKey("villages/desert/ruined/baetyl");
	public static final ResourceKey<StructureProcessorList> DESERT_RUINED_GRAINITE = IcariaProcessorLists.registerKey("villages/desert/ruined/grainite");
	public static final ResourceKey<StructureProcessorList> DESERT_RUINED_VOIDSHALE = IcariaProcessorLists.registerKey("villages/desert/ruined/voidshale");

	public static void bootstrap(BootstapContext<StructureProcessorList> pContext) {
		// FOREST

		pContext.register(IcariaProcessorLists.FOREST_ERODED_DOLOMITE, IcariaProcessorLists.forestEroded(IcariaBlocks.DOLOMITE_ADOBE.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.FOREST_ERODED_SILKSTONE, IcariaProcessorLists.forestEroded(IcariaBlocks.SILKSTONE_ADOBE.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.FOREST_ERODED_SUNSTONE, IcariaProcessorLists.forestEroded(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.FOREST_PRISTINE_DOLOMITE, IcariaProcessorLists.forestPristine(IcariaBlocks.DOLOMITE_ADOBE.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get(), IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.FOREST_PRISTINE_SILKSTONE, IcariaProcessorLists.forestPristine(IcariaBlocks.SILKSTONE_ADOBE.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.FOREST_PRISTINE_SUNSTONE, IcariaProcessorLists.forestPristine(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.FOREST_RUINED_DOLOMITE, IcariaProcessorLists.forestRuined(IcariaBlocks.DOLOMITE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.FOREST_RUINED_SILKSTONE, IcariaProcessorLists.forestRuined(IcariaBlocks.SILKSTONE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.FOREST_RUINED_SUNSTONE, IcariaProcessorLists.forestRuined(IcariaBlocks.SUNSTONE_ADOBE.get()));

		// SCRUBLAND

		pContext.register(IcariaProcessorLists.SCRUBLAND_ERODED_SUNSTONE, IcariaProcessorLists.scrublandEroded(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.SCRUBLAND_ERODED_VOIDSHALE, IcariaProcessorLists.scrublandEroded(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.SCRUBLAND_ERODED_YELLOWSTONE, IcariaProcessorLists.scrublandEroded(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.SCRUBLAND_PRISTINE_SUNSTONE, IcariaProcessorLists.scrublandPristine(IcariaBlocks.SUNSTONE_ADOBE.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.SCRUBLAND_PRISTINE_VOIDSHALE, IcariaProcessorLists.scrublandPristine(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.SCRUBLAND_PRISTINE_YELLOWSTONE, IcariaProcessorLists.scrublandPristine(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.SCRUBLAND_RUINED_SUNSTONE, IcariaProcessorLists.scrublandRuined(IcariaBlocks.SUNSTONE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.SCRUBLAND_RUINED_VOIDSHALE, IcariaProcessorLists.scrublandRuined(IcariaBlocks.VOIDSHALE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.SCRUBLAND_RUINED_YELLOWSTONE, IcariaProcessorLists.scrublandRuined(IcariaBlocks.YELLOWSTONE_ADOBE.get()));

		// STEPPE

		pContext.register(IcariaProcessorLists.STEPPE_ERODED_GRAINITE, IcariaProcessorLists.steppeEroded(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.STEPPE_ERODED_MARL, IcariaProcessorLists.steppeEroded(IcariaBlocks.MARL_ADOBE.get(), IcariaBlocks.MARL_ADOBE_DECO.stairs.get(), IcariaBlocks.MARL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.STEPPE_ERODED_YELLOWSTONE, IcariaProcessorLists.steppeEroded(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.STEPPE_PRISTINE_GRAINITE, IcariaProcessorLists.steppePristine(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.STEPPE_PRISTINE_MARL, IcariaProcessorLists.steppePristine(IcariaBlocks.MARL_ADOBE.get(), IcariaBlocks.MARL_ADOBE_DECO.stairs.get(), IcariaBlocks.MARL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.STEPPE_PRISTINE_YELLOWSTONE, IcariaProcessorLists.steppePristine(IcariaBlocks.YELLOWSTONE_ADOBE.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.STEPPE_RUINED_GRAINITE, IcariaProcessorLists.steppeRuined(IcariaBlocks.GRAINITE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.STEPPE_RUINED_MARL, IcariaProcessorLists.steppeRuined(IcariaBlocks.MARL_ADOBE.get()));
		pContext.register(IcariaProcessorLists.STEPPE_RUINED_YELLOWSTONE, IcariaProcessorLists.steppeRuined(IcariaBlocks.YELLOWSTONE_ADOBE.get()));

		// DESERT

		pContext.register(IcariaProcessorLists.DESERT_ERODED_BAETYL, IcariaProcessorLists.desertEroded(IcariaBlocks.BAETYL_ADOBE.get(), IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get(), IcariaBlocks.BAETYL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.DESERT_ERODED_GRAINITE, IcariaProcessorLists.desertEroded(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.DESERT_ERODED_VOIDSHALE, IcariaProcessorLists.desertEroded(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.DESERT_PRISTINE_BAETYL, IcariaProcessorLists.desertPristine(IcariaBlocks.BAETYL_ADOBE.get(), IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get(), IcariaBlocks.BAETYL_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.DESERT_PRISTINE_GRAINITE, IcariaProcessorLists.desertPristine(IcariaBlocks.GRAINITE_ADOBE.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get()));
		pContext.register(IcariaProcessorLists.DESERT_PRISTINE_VOIDSHALE, IcariaProcessorLists.desertPristine(IcariaBlocks.VOIDSHALE_ADOBE.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get()));

		pContext.register(IcariaProcessorLists.DESERT_RUINED_BAETYL, IcariaProcessorLists.desertRuined(IcariaBlocks.BAETYL_ADOBE.get()));
		pContext.register(IcariaProcessorLists.DESERT_RUINED_GRAINITE, IcariaProcessorLists.desertRuined(IcariaBlocks.GRAINITE_ADOBE.get()));
		pContext.register(IcariaProcessorLists.DESERT_RUINED_VOIDSHALE, IcariaProcessorLists.desertRuined(IcariaBlocks.VOIDSHALE_ADOBE.get()));
	}

	public static StructureProcessorList forestEroded(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.eroded(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList forestPristine(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristine(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList forestRuined(Block pAdobeBlock) {
		return IcariaProcessorLists.ruined(pAdobeBlock);
	}

	public static StructureProcessorList scrublandEroded(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.eroded(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList scrublandPristine(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristine(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList scrublandRuined(Block pAdobeBlock) {
		return IcariaProcessorLists.ruined(pAdobeBlock);
	}

	public static StructureProcessorList steppeEroded(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.eroded(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList steppePristine(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristine(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList steppeRuined(Block pAdobeBlock) {
		return IcariaProcessorLists.ruined(pAdobeBlock);
	}

	public static StructureProcessorList desertEroded(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.eroded(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList desertPristine(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab) {
		return IcariaProcessorLists.pristine(pAdobeBlock, pAdobeStairs, pAdobeSlab,
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

	public static StructureProcessorList desertRuined(Block pAdobeBlock) {
		return IcariaProcessorLists.ruined(pAdobeBlock);
	}

	public static StructureProcessorList eroded(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab, Block pStrippedLog, Block pLaurelStairs, Block pLaurelSlab, Block pSimpleRack, Block pRack, Block pBarrel, Block pLoadedBarrel, Block pTappedBarrel, Block pTripleBarrel, Block pWallSign, Block pPlanePlanks, Block pPlaneSlab, Block pPlaneFence, Block pCraftingTable, Block pDoor, Block pTrapdoor, Block pLadder) {
		return new StructureProcessorList(ImmutableList.of(
			IcariaProcessorLists.block(IcariaBlocks.YELLOWSTONE_ADOBE.get(), pAdobeBlock),
			IcariaProcessorLists.stairs(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), pAdobeStairs),
			IcariaProcessorLists.slab(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), pAdobeSlab),

			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILES.get(), 0.375F, IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), 0.375F, IcariaBlocks.MOSSY_RELICSTONE_TILES.get()),
			IcariaProcessorLists.stairs(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get(), 0.375F, IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.stairs.get(), 0.375F, IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.stairs.get()),

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

	public static StructureProcessorList pristine(Block pAdobeBlock, Block pAdobeStairs, Block pAdobeSlab, Block pStrippedLog, Block pLaurelStairs, Block pLaurelSlab, Block pSimpleRack, Block pRack, Block pBarrel, Block pLoadedBarrel, Block pTappedBarrel, Block pTripleBarrel, Block pWallSign, Block pPlanePlanks, Block pPlaneSlab, Block pPlaneFence, Block pCraftingTable, Block pDoor, Block pTrapdoor, Block pLadder) {
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

	public static StructureProcessorList ruined(Block pAdobeBlock) {
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

			IcariaProcessorLists.block(pAdobeBlock, 0.375F, Blocks.COBWEB, 0.625F, Blocks.AIR, Direction.Axis.Y), // TODO: replace with Arachne web

			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILES.get(), 0.375F, Blocks.COBWEB, 0.625F, Blocks.AIR, Direction.Axis.Y), // TODO: replace with Arachne web
			IcariaProcessorLists.block(IcariaBlocks.RELICSTONE_TILES.get(), 0.375F, IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), 0.375F, IcariaBlocks.MOSSY_RELICSTONE_TILES.get()),
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

	public static RuleProcessor block(Block pOld, float pChance, Block pNew) {
		return new RuleProcessor(ImmutableList.of(
			new ProcessorRule(new RandomBlockStateMatchTest(pOld.defaultBlockState(), pChance), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState())
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
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT)),
			new ProcessorRule(new BlockStateMatchTest(pOld.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT)), AlwaysTrueTest.INSTANCE, pNew.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT))
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

	public static ResourceKey<StructureProcessorList> registerKey(String pName) {
		return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
