package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaBlockItemIds;
import com.axanthic.icaria.common.tags.IcariaBlockItemTags;

import java.util.function.Function;

import net.minecraft.data.tags.BlockItemTagsProvider;
import net.minecraft.tags.BlockItemTagId;
import net.minecraft.tags.BlockItemTags;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockItemTagsProvider extends BlockItemTagsProvider {
	public IcariaBlockItemTagsProvider(Function<BlockItemTagId, CombinedAppender> pFunction) {
		super(pFunction);
	}

	@Override
	public void run() {
		this.tag(BlockItemTags.BARS)
			.add(IcariaBlockItemIds.VANADIUMSTEEL_BARS)
			.add(IcariaBlockItemIds.HORIZONTAL_VANADIUMSTEEL_BARS);

		this.tag(BlockItemTags.BEE_FOOD)
			.add(IcariaBlockItemIds.BLINDWEED)
			.add(IcariaBlockItemIds.CHAMEOMILE)
			.add(IcariaBlockItemIds.CHARMONDER)
			.add(IcariaBlockItemIds.CLOVER)
			.add(IcariaBlockItemIds.FIREHILT)
			.add(IcariaBlockItemIds.BLUE_HYDRACINTH)
			.add(IcariaBlockItemIds.PURPLE_HYDRACINTH)
			.add(IcariaBlockItemIds.LIONFANGS)
			.add(IcariaBlockItemIds.SPEARDROPS)
			.add(IcariaBlockItemIds.PURPLE_STAGHORN)
			.add(IcariaBlockItemIds.YELLOW_STAGHORN)
			.add(IcariaBlockItemIds.BLUE_STORMCOTTON)
			.add(IcariaBlockItemIds.PINK_STORMCOTTON)
			.add(IcariaBlockItemIds.PURPLE_STORMCOTTON)
			.add(IcariaBlockItemIds.SUNKETTLE)
			.add(IcariaBlockItemIds.SUNSPONGE)
			.add(IcariaBlockItemIds.VOIDLILY)
			.add(IcariaBlockItemIds.BLUE_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.CYAN_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.PINK_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.PURPLE_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.RED_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.WHITE_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.WHITE_BROMELIA)
			.add(IcariaBlockItemIds.ORANGE_BROMELIA)
			.add(IcariaBlockItemIds.PINK_BROMELIA)
			.add(IcariaBlockItemIds.PURPLE_BROMELIA);

		this.tag(BlockItemTags.CHAINS)
			.add(IcariaBlockItemIds.VANADIUMSTEEL_CHAIN);

		this.tag(BlockItemTags.DAMPENS_VIBRATIONS)
			.addTag(IcariaBlockItemTags.TERRY_BLOCKS)
			.addTag(IcariaBlockItemTags.TERRY_MATS);

		this.tag(BlockItemTags.DIRT)
			.add(IcariaBlockItemIds.MARL)
			.add(IcariaBlockItemIds.COARSE_MARL)
			.add(IcariaBlockItemIds.DRY_LAKE_BED)
			.add(IcariaBlockItemIds.LOAM);

		this.tag(BlockItemTags.FLOWERS)
			.add(IcariaBlockItemIds.BLUE_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.CYAN_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.PINK_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.PURPLE_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.RED_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.WHITE_GROUND_FLOWERS)
			.add(IcariaBlockItemIds.WHITE_BROMELIA)
			.add(IcariaBlockItemIds.ORANGE_BROMELIA)
			.add(IcariaBlockItemIds.PINK_BROMELIA)
			.add(IcariaBlockItemIds.PURPLE_BROMELIA);

		this.tag(BlockItemTags.GRASS_BLOCKS)
			.add(IcariaBlockItemIds.GRASSY_MARL);

		this.tag(BlockItemTags.HANGING_SIGNS)
			.add(IcariaBlockItemIds.CYPRESS_HANGING_SIGN)
			.add(IcariaBlockItemIds.DROUGHTROOT_HANGING_SIGN)
			.add(IcariaBlockItemIds.FIR_HANGING_SIGN)
			.add(IcariaBlockItemIds.LAUREL_HANGING_SIGN)
			.add(IcariaBlockItemIds.OLIVE_HANGING_SIGN)
			.add(IcariaBlockItemIds.PLANE_HANGING_SIGN)
			.add(IcariaBlockItemIds.POPULUS_HANGING_SIGN);

		this.tag(BlockItemTags.LEAVES)
			.add(IcariaBlockItemIds.CYPRESS_LEAVES)
			.add(IcariaBlockItemIds.DROUGHTROOT_LEAVES)
			.add(IcariaBlockItemIds.FIR_LEAVES)
			.add(IcariaBlockItemIds.LAUREL_LEAVES)
			.add(IcariaBlockItemIds.OLIVE_LEAVES)
			.add(IcariaBlockItemIds.PLANE_LEAVES)
			.add(IcariaBlockItemIds.POPULUS_LEAVES);

		this.tag(BlockItemTags.LOGS_THAT_BURN)
			.addTag(IcariaBlockItemTags.LOGS_CYPRESS)
			.addTag(IcariaBlockItemTags.LOGS_DROUGHTROOT)
			.addTag(IcariaBlockItemTags.LOGS_FIR)
			.addTag(IcariaBlockItemTags.LOGS_LAUREL)
			.addTag(IcariaBlockItemTags.LOGS_OLIVE)
			.addTag(IcariaBlockItemTags.LOGS_PLANE)
			.addTag(IcariaBlockItemTags.LOGS_POPULUS);

		this.tag(BlockItemTags.PLANKS)
			.add(IcariaBlockItemIds.CYPRESS_PLANKS)
			.add(IcariaBlockItemIds.DROUGHTROOT_PLANKS)
			.add(IcariaBlockItemIds.FIR_PLANKS)
			.add(IcariaBlockItemIds.LAUREL_PLANKS)
			.add(IcariaBlockItemIds.OLIVE_PLANKS)
			.add(IcariaBlockItemIds.PLANE_PLANKS)
			.add(IcariaBlockItemIds.POPULUS_PLANKS);

		this.tag(BlockItemTags.SAND)
			.add(IcariaBlockItemIds.LOAM)
			.add(IcariaBlockItemIds.GRAINEL)
			.add(IcariaBlockItemIds.SUSPICIOUS_GRAINEL)
			.add(IcariaBlockItemIds.SILKSAND)
			.add(IcariaBlockItemIds.SUSPICIOUS_SILKSAND);

		this.tag(BlockItemTags.SAPLINGS)
			.add(IcariaBlockItemIds.CYPRESS_SAPLING)
			.add(IcariaBlockItemIds.DROUGHTROOT_SAPLING)
			.add(IcariaBlockItemIds.FIR_SAPLING)
			.add(IcariaBlockItemIds.LAUREL_SAPLING)
			.add(IcariaBlockItemIds.OLIVE_SAPLING)
			.add(IcariaBlockItemIds.PLANE_SAPLING)
			.add(IcariaBlockItemIds.POPULUS_SAPLING);

		this.tag(BlockItemTags.SIGNS)
			.add(IcariaBlockItemIds.CYPRESS_SIGN)
			.add(IcariaBlockItemIds.DROUGHTROOT_SIGN)
			.add(IcariaBlockItemIds.FIR_SIGN)
			.add(IcariaBlockItemIds.LAUREL_SIGN)
			.add(IcariaBlockItemIds.OLIVE_SIGN)
			.add(IcariaBlockItemIds.PLANE_SIGN)
			.add(IcariaBlockItemIds.POPULUS_SIGN);

		this.tag(BlockItemTags.SLABS)
			.add(IcariaBlockItemIds.MARL_ADOBE_SLAB)
			.add(IcariaBlockItemIds.LOAM_BRICK_SLAB)
			.add(IcariaBlockItemIds.DOLOMITE_ADOBE_SLAB)
			.add(IcariaBlockItemIds.SMOOTH_DOLOMITE_SLAB)
			.add(IcariaBlockItemIds.GRAINITE_ADOBE_SLAB)
			.add(IcariaBlockItemIds.GRAINITE_SLAB)
			.add(IcariaBlockItemIds.GRAINITE_BRICK_SLAB)
			.add(IcariaBlockItemIds.YELLOWSTONE_ADOBE_SLAB)
			.add(IcariaBlockItemIds.COBBLED_YELLOWSTONE_SLAB)
			.add(IcariaBlockItemIds.YELLOWSTONE_SLAB)
			.add(IcariaBlockItemIds.YELLOWSTONE_BRICK_SLAB)
			.add(IcariaBlockItemIds.SILKSTONE_ADOBE_SLAB)
			.add(IcariaBlockItemIds.COBBLED_SILKSTONE_SLAB)
			.add(IcariaBlockItemIds.SILKSTONE_SLAB)
			.add(IcariaBlockItemIds.SILKSTONE_BRICK_SLAB)
			.add(IcariaBlockItemIds.SUNSTONE_ADOBE_SLAB)
			.add(IcariaBlockItemIds.COBBLED_SUNSTONE_SLAB)
			.add(IcariaBlockItemIds.SUNSTONE_SLAB)
			.add(IcariaBlockItemIds.SUNSTONE_BRICK_SLAB)
			.add(IcariaBlockItemIds.VOIDSHALE_ADOBE_SLAB)
			.add(IcariaBlockItemIds.COBBLED_VOIDSHALE_SLAB)
			.add(IcariaBlockItemIds.VOIDSHALE_SLAB)
			.add(IcariaBlockItemIds.VOIDSHALE_BRICK_SLAB)
			.add(IcariaBlockItemIds.BAETYL_ADOBE_SLAB)
			.add(IcariaBlockItemIds.COBBLED_BAETYL_SLAB)
			.add(IcariaBlockItemIds.BAETYL_SLAB)
			.add(IcariaBlockItemIds.BAETYL_BRICK_SLAB)
			.add(IcariaBlockItemIds.RELICSTONE_SLAB)
			.add(IcariaBlockItemIds.SMOOTH_RELICSTONE_SLAB)
			.add(IcariaBlockItemIds.RELICSTONE_BRICK_SLAB)
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICK_SLAB)
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICK_SLAB)
			.add(IcariaBlockItemIds.RELICSTONE_TILE_SLAB)
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_TILE_SLAB)
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_TILE_SLAB)
			.add(IcariaBlockItemIds.PLATOSHALE_SLAB)
			.add(IcariaBlockItemIds.PLATOSHALE_BRICK_SLAB)
			.add(IcariaBlockItemIds.CHIMNEY_SLAB);

		this.tag(BlockItemTags.SMALL_FLOWERS)
			.add(IcariaBlockItemIds.BLINDWEED)
			.add(IcariaBlockItemIds.CHAMEOMILE)
			.add(IcariaBlockItemIds.CHARMONDER)
			.add(IcariaBlockItemIds.CLOVER)
			.add(IcariaBlockItemIds.FIREHILT)
			.add(IcariaBlockItemIds.BLUE_HYDRACINTH)
			.add(IcariaBlockItemIds.PURPLE_HYDRACINTH)
			.add(IcariaBlockItemIds.LIONFANGS)
			.add(IcariaBlockItemIds.SPEARDROPS)
			.add(IcariaBlockItemIds.PURPLE_STAGHORN)
			.add(IcariaBlockItemIds.YELLOW_STAGHORN)
			.add(IcariaBlockItemIds.BLUE_STORMCOTTON)
			.add(IcariaBlockItemIds.PINK_STORMCOTTON)
			.add(IcariaBlockItemIds.PURPLE_STORMCOTTON)
			.add(IcariaBlockItemIds.SUNKETTLE)
			.add(IcariaBlockItemIds.SUNSPONGE)
			.add(IcariaBlockItemIds.VOIDLILY);

		this.tag(BlockItemTags.STAIRS)
			.add(IcariaBlockItemIds.MARL_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.LOAM_BRICK_STAIRS)
			.add(IcariaBlockItemIds.DOLOMITE_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.SMOOTH_DOLOMITE_STAIRS)
			.add(IcariaBlockItemIds.GRAINITE_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.GRAINITE_STAIRS)
			.add(IcariaBlockItemIds.GRAINITE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.YELLOWSTONE_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.COBBLED_YELLOWSTONE_STAIRS)
			.add(IcariaBlockItemIds.YELLOWSTONE_STAIRS)
			.add(IcariaBlockItemIds.YELLOWSTONE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.SILKSTONE_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.COBBLED_SILKSTONE_STAIRS)
			.add(IcariaBlockItemIds.SILKSTONE_STAIRS)
			.add(IcariaBlockItemIds.SILKSTONE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.SUNSTONE_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.COBBLED_SUNSTONE_STAIRS)
			.add(IcariaBlockItemIds.SUNSTONE_STAIRS)
			.add(IcariaBlockItemIds.SUNSTONE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.VOIDSHALE_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.COBBLED_VOIDSHALE_STAIRS)
			.add(IcariaBlockItemIds.VOIDSHALE_STAIRS)
			.add(IcariaBlockItemIds.VOIDSHALE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.BAETYL_ADOBE_STAIRS)
			.add(IcariaBlockItemIds.COBBLED_BAETYL_STAIRS)
			.add(IcariaBlockItemIds.BAETYL_STAIRS)
			.add(IcariaBlockItemIds.BAETYL_BRICK_STAIRS)
			.add(IcariaBlockItemIds.RELICSTONE_STAIRS)
			.add(IcariaBlockItemIds.SMOOTH_RELICSTONE_STAIRS)
			.add(IcariaBlockItemIds.RELICSTONE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICK_STAIRS)
			.add(IcariaBlockItemIds.RELICSTONE_TILE_STAIRS)
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_TILE_STAIRS)
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_TILE_STAIRS)
			.add(IcariaBlockItemIds.PLATOSHALE_STAIRS)
			.add(IcariaBlockItemIds.PLATOSHALE_BRICK_STAIRS);

		this.tag(BlockItemTags.WALLS)
			.add(IcariaBlockItemIds.MARL_ADOBE_WALL)
			.add(IcariaBlockItemIds.LOAM_BRICK_WALL)
			.add(IcariaBlockItemIds.DOLOMITE_ADOBE_WALL)
			.add(IcariaBlockItemIds.SMOOTH_DOLOMITE_WALL)
			.add(IcariaBlockItemIds.GRAINITE_ADOBE_WALL)
			.add(IcariaBlockItemIds.GRAINITE_WALL)
			.add(IcariaBlockItemIds.GRAINITE_BRICK_WALL)
			.add(IcariaBlockItemIds.YELLOWSTONE_ADOBE_WALL)
			.add(IcariaBlockItemIds.COBBLED_YELLOWSTONE_WALL)
			.add(IcariaBlockItemIds.YELLOWSTONE_WALL)
			.add(IcariaBlockItemIds.YELLOWSTONE_BRICK_WALL)
			.add(IcariaBlockItemIds.SILKSTONE_ADOBE_WALL)
			.add(IcariaBlockItemIds.COBBLED_SILKSTONE_WALL)
			.add(IcariaBlockItemIds.SILKSTONE_WALL)
			.add(IcariaBlockItemIds.SILKSTONE_BRICK_WALL)
			.add(IcariaBlockItemIds.SUNSTONE_ADOBE_WALL)
			.add(IcariaBlockItemIds.COBBLED_SUNSTONE_WALL)
			.add(IcariaBlockItemIds.SUNSTONE_WALL)
			.add(IcariaBlockItemIds.SUNSTONE_BRICK_WALL)
			.add(IcariaBlockItemIds.VOIDSHALE_ADOBE_WALL)
			.add(IcariaBlockItemIds.COBBLED_VOIDSHALE_WALL)
			.add(IcariaBlockItemIds.VOIDSHALE_WALL)
			.add(IcariaBlockItemIds.VOIDSHALE_BRICK_WALL)
			.add(IcariaBlockItemIds.BAETYL_ADOBE_WALL)
			.add(IcariaBlockItemIds.COBBLED_BAETYL_WALL)
			.add(IcariaBlockItemIds.BAETYL_WALL)
			.add(IcariaBlockItemIds.BAETYL_BRICK_WALL)
			.add(IcariaBlockItemIds.RELICSTONE_WALL)
			.add(IcariaBlockItemIds.SMOOTH_RELICSTONE_WALL)
			.add(IcariaBlockItemIds.RELICSTONE_BRICK_WALL)
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICK_WALL)
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICK_WALL)
			.add(IcariaBlockItemIds.RELICSTONE_TILE_WALL)
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_TILE_WALL)
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_TILE_WALL)
			.add(IcariaBlockItemIds.PLATOSHALE_WALL)
			.add(IcariaBlockItemIds.PLATOSHALE_BRICK_WALL)
			.add(IcariaBlockItemIds.QUARTZ_WALL);

		this.tag(BlockItemTags.WOODEN_BUTTONS)
			.add(IcariaBlockItemIds.CYPRESS_BUTTON)
			.add(IcariaBlockItemIds.DROUGHTROOT_BUTTON)
			.add(IcariaBlockItemIds.FIR_BUTTON)
			.add(IcariaBlockItemIds.LAUREL_BUTTON)
			.add(IcariaBlockItemIds.OLIVE_BUTTON)
			.add(IcariaBlockItemIds.PLANE_BUTTON)
			.add(IcariaBlockItemIds.POPULUS_BUTTON);

		this.tag(BlockItemTags.WOODEN_DOORS)
			.add(IcariaBlockItemIds.CYPRESS_DOOR)
			.add(IcariaBlockItemIds.DROUGHTROOT_DOOR)
			.add(IcariaBlockItemIds.FIR_DOOR)
			.add(IcariaBlockItemIds.LAUREL_DOOR)
			.add(IcariaBlockItemIds.OLIVE_DOOR)
			.add(IcariaBlockItemIds.PLANE_DOOR)
			.add(IcariaBlockItemIds.POPULUS_DOOR);

		this.tag(BlockItemTags.WOODEN_FENCES)
			.add(IcariaBlockItemIds.CYPRESS_FENCE)
			.add(IcariaBlockItemIds.DROUGHTROOT_FENCE)
			.add(IcariaBlockItemIds.FIR_FENCE)
			.add(IcariaBlockItemIds.LAUREL_FENCE)
			.add(IcariaBlockItemIds.OLIVE_FENCE)
			.add(IcariaBlockItemIds.PLANE_FENCE)
			.add(IcariaBlockItemIds.POPULUS_FENCE);

		this.tag(BlockItemTags.FENCE_GATES)
			.add(IcariaBlockItemIds.CYPRESS_FENCE_GATE)
			.add(IcariaBlockItemIds.DROUGHTROOT_FENCE_GATE)
			.add(IcariaBlockItemIds.FIR_FENCE_GATE)
			.add(IcariaBlockItemIds.LAUREL_FENCE_GATE)
			.add(IcariaBlockItemIds.OLIVE_FENCE_GATE)
			.add(IcariaBlockItemIds.PLANE_FENCE_GATE)
			.add(IcariaBlockItemIds.POPULUS_FENCE_GATE);

		this.tag(BlockItemTags.WOODEN_PRESSURE_PLATES)
			.add(IcariaBlockItemIds.CYPRESS_PRESSURE_PLATE)
			.add(IcariaBlockItemIds.DROUGHTROOT_PRESSURE_PLATE)
			.add(IcariaBlockItemIds.FIR_PRESSURE_PLATE)
			.add(IcariaBlockItemIds.LAUREL_PRESSURE_PLATE)
			.add(IcariaBlockItemIds.OLIVE_PRESSURE_PLATE)
			.add(IcariaBlockItemIds.PLANE_PRESSURE_PLATE)
			.add(IcariaBlockItemIds.POPULUS_PRESSURE_PLATE);

		this.tag(BlockItemTags.WOODEN_SHELVES)
			.add(IcariaBlockItemIds.CYPRESS_SHELF)
			.add(IcariaBlockItemIds.DROUGHTROOT_SHELF)
			.add(IcariaBlockItemIds.FIR_SHELF)
			.add(IcariaBlockItemIds.LAUREL_SHELF)
			.add(IcariaBlockItemIds.OLIVE_SHELF)
			.add(IcariaBlockItemIds.PLANE_SHELF)
			.add(IcariaBlockItemIds.POPULUS_SHELF);

		this.tag(BlockItemTags.WOODEN_SLABS)
			.add(IcariaBlockItemIds.CYPRESS_SLAB)
			.add(IcariaBlockItemIds.DROUGHTROOT_SLAB)
			.add(IcariaBlockItemIds.FIR_SLAB)
			.add(IcariaBlockItemIds.LAUREL_SLAB)
			.add(IcariaBlockItemIds.OLIVE_SLAB)
			.add(IcariaBlockItemIds.PLANE_SLAB)
			.add(IcariaBlockItemIds.POPULUS_SLAB);

		this.tag(BlockItemTags.WOODEN_STAIRS)
			.add(IcariaBlockItemIds.CYPRESS_STAIRS)
			.add(IcariaBlockItemIds.DROUGHTROOT_STAIRS)
			.add(IcariaBlockItemIds.FIR_STAIRS)
			.add(IcariaBlockItemIds.LAUREL_STAIRS)
			.add(IcariaBlockItemIds.OLIVE_STAIRS)
			.add(IcariaBlockItemIds.PLANE_STAIRS)
			.add(IcariaBlockItemIds.POPULUS_STAIRS);

		this.tag(BlockItemTags.WOODEN_TRAPDOORS)
			.add(IcariaBlockItemIds.CYPRESS_TRAPDOOR)
			.add(IcariaBlockItemIds.DROUGHTROOT_TRAPDOOR)
			.add(IcariaBlockItemIds.FIR_TRAPDOOR)
			.add(IcariaBlockItemIds.LAUREL_TRAPDOOR)
			.add(IcariaBlockItemIds.OLIVE_TRAPDOOR)
			.add(IcariaBlockItemIds.PLANE_TRAPDOOR)
			.add(IcariaBlockItemIds.POPULUS_TRAPDOOR);

		this.tag(IcariaBlockItemTags.BARS_VANADIUMSTEEL)
			.add(IcariaBlockItemIds.VANADIUMSTEEL_BARS)
			.add(IcariaBlockItemIds.HORIZONTAL_VANADIUMSTEEL_BARS);

		this.tag(IcariaBlockItemTags.COBBLESTONES_BAETYL)
			.add(IcariaBlockItemIds.COBBLED_BAETYL);

		this.tag(IcariaBlockItemTags.COBBLESTONES_SILKSTONE)
			.add(IcariaBlockItemIds.COBBLED_SILKSTONE);

		this.tag(IcariaBlockItemTags.COBBLESTONES_SUNSTONE)
			.add(IcariaBlockItemIds.COBBLED_SUNSTONE);

		this.tag(IcariaBlockItemTags.COBBLESTONES_VOIDSHALE)
			.add(IcariaBlockItemIds.COBBLED_VOIDSHALE);

		this.tag(IcariaBlockItemTags.COBBLESTONES_YELLOWSTONE)
			.add(IcariaBlockItemIds.COBBLED_YELLOWSTONE);

		this.tag(IcariaBlockItemTags.LOGS_CYPRESS)
			.add(IcariaBlockItemIds.CYPRESS_WOOD)
			.add(IcariaBlockItemIds.STRIPPED_CYPRESS_WOOD)
			.add(IcariaBlockItemIds.CYPRESS_LOG)
			.add(IcariaBlockItemIds.STRIPPED_CYPRESS_LOG)
			.add(IcariaBlockItemIds.DEAD_CYPRESS_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DEAD_CYPRESS_LOG);

		this.tag(IcariaBlockItemTags.LOGS_DROUGHTROOT)
			.add(IcariaBlockItemIds.DROUGHTROOT_WOOD)
			.add(IcariaBlockItemIds.STRIPPED_DROUGHTROOT_WOOD)
			.add(IcariaBlockItemIds.DROUGHTROOT_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DROUGHTROOT_LOG)
			.add(IcariaBlockItemIds.DEAD_DROUGHTROOT_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DEAD_DROUGHTROOT_LOG);

		this.tag(IcariaBlockItemTags.LOGS_FIR)
			.add(IcariaBlockItemIds.FIR_WOOD)
			.add(IcariaBlockItemIds.STRIPPED_FIR_WOOD)
			.add(IcariaBlockItemIds.FIR_LOG)
			.add(IcariaBlockItemIds.STRIPPED_FIR_LOG)
			.add(IcariaBlockItemIds.DEAD_FIR_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DEAD_FIR_LOG);

		this.tag(IcariaBlockItemTags.LOGS_LAUREL)
			.add(IcariaBlockItemIds.LAUREL_WOOD)
			.add(IcariaBlockItemIds.STRIPPED_LAUREL_WOOD)
			.add(IcariaBlockItemIds.LAUREL_LOG)
			.add(IcariaBlockItemIds.STRIPPED_LAUREL_LOG)
			.add(IcariaBlockItemIds.DEAD_LAUREL_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DEAD_LAUREL_LOG);

		this.tag(IcariaBlockItemTags.LOGS_OLIVE)
			.add(IcariaBlockItemIds.OLIVE_WOOD)
			.add(IcariaBlockItemIds.STRIPPED_OLIVE_WOOD)
			.add(IcariaBlockItemIds.OLIVE_LOG)
			.add(IcariaBlockItemIds.STRIPPED_OLIVE_LOG)
			.add(IcariaBlockItemIds.DEAD_OLIVE_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DEAD_OLIVE_LOG);

		this.tag(IcariaBlockItemTags.LOGS_PLANE)
			.add(IcariaBlockItemIds.PLANE_WOOD)
			.add(IcariaBlockItemIds.STRIPPED_PLANE_WOOD)
			.add(IcariaBlockItemIds.PLANE_LOG)
			.add(IcariaBlockItemIds.STRIPPED_PLANE_LOG)
			.add(IcariaBlockItemIds.DEAD_PLANE_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DEAD_PLANE_LOG);

		this.tag(IcariaBlockItemTags.LOGS_POPULUS)
			.add(IcariaBlockItemIds.POPULUS_WOOD)
			.add(IcariaBlockItemIds.STRIPPED_POPULUS_WOOD)
			.add(IcariaBlockItemIds.POPULUS_LOG)
			.add(IcariaBlockItemIds.STRIPPED_POPULUS_LOG)
			.add(IcariaBlockItemIds.DEAD_POPULUS_LOG)
			.add(IcariaBlockItemIds.STRIPPED_DEAD_POPULUS_LOG);

		this.tag(IcariaBlockItemTags.ORE_BEARING_GROUND_BAETYL)
			.add(IcariaBlockItemIds.BAETYL);

		this.tag(IcariaBlockItemTags.ORE_BEARING_GROUND_GRAINEL)
			.add(IcariaBlockItemIds.GRAINEL);

		this.tag(IcariaBlockItemTags.ORE_BEARING_GROUND_MARL)
			.add(IcariaBlockItemIds.MARL);

		this.tag(IcariaBlockItemTags.ORE_BEARING_GROUND_SILKSTONE)
			.add(IcariaBlockItemIds.SILKSTONE);

		this.tag(IcariaBlockItemTags.ORE_BEARING_GROUND_SUNSTONE)
			.add(IcariaBlockItemIds.SUNSTONE);

		this.tag(IcariaBlockItemTags.ORE_BEARING_GROUND_VOIDSHALE)
			.add(IcariaBlockItemIds.VOIDSHALE);

		this.tag(IcariaBlockItemTags.ORE_BEARING_GROUND_YELLOWSTONE)
			.add(IcariaBlockItemIds.YELLOWSTONE);

		this.tag(IcariaBlockItemTags.ORES_ANTHRACITE)
			.add(IcariaBlockItemIds.ANTHRACITE_ORE);

		this.tag(IcariaBlockItemTags.ORES_BONE)
			.add(IcariaBlockItemIds.MARL_BONES);

		this.tag(IcariaBlockItemTags.ORES_CHALKOS)
			.add(IcariaBlockItemIds.CHALKOS_ORE);

		this.tag(IcariaBlockItemTags.ORES_CHERT)
			.add(IcariaBlockItemIds.MARL_CHERT_ORE)
			.add(IcariaBlockItemIds.CHERT_ORE);

		this.tag(IcariaBlockItemTags.ORES_DOLOMITE)
			.add(IcariaBlockItemIds.DOLOMITE_ORE);

		this.tag(IcariaBlockItemTags.ORES_HYLIASTRUM)
			.add(IcariaBlockItemIds.HYLIASTRUM_ORE);

		this.tag(IcariaBlockItemTags.ORES_KASSITEROS)
			.add(IcariaBlockItemIds.KASSITEROS_ORE);

		this.tag(IcariaBlockItemTags.ORES_LIGNITE)
			.add(IcariaBlockItemIds.MARL_LIGNITE_ORE)
			.add(IcariaBlockItemIds.LIGNITE_ORE);

		this.tag(IcariaBlockItemTags.ORES_MOLYBDENUM)
			.add(IcariaBlockItemIds.MOLYBDENUM_ORE);

		this.tag(IcariaBlockItemTags.ORES_SIDEROS)
			.add(IcariaBlockItemIds.SIDEROS_ORE);

		this.tag(IcariaBlockItemTags.ORES_SLIVER)
			.add(IcariaBlockItemIds.SLIVER_ORE);

		this.tag(IcariaBlockItemTags.ORES_VANADIUM)
			.add(IcariaBlockItemIds.VANADIUM_ORE);

		this.tag(IcariaBlockItemTags.ORES_IN_GROUND_BAETYL)
			.add(IcariaBlockItemIds.MOLYBDENUM_ORE)
			.add(IcariaBlockItemIds.HYLIASTRUM_ORE);

		this.tag(IcariaBlockItemTags.ORES_IN_GROUND_GRAINEL)
			.add(IcariaBlockItemIds.CHERT_ORE);

		this.tag(IcariaBlockItemTags.ORES_IN_GROUND_MARL)
			.add(IcariaBlockItemIds.MARL_BONES)
			.add(IcariaBlockItemIds.MARL_CHERT_ORE)
			.add(IcariaBlockItemIds.MARL_LIGNITE_ORE);

		this.tag(IcariaBlockItemTags.ORES_IN_GROUND_SILKSTONE)
			.add(IcariaBlockItemIds.KASSITEROS_ORE)
			.add(IcariaBlockItemIds.DOLOMITE_ORE);

		this.tag(IcariaBlockItemTags.ORES_IN_GROUND_SUNSTONE)
			.add(IcariaBlockItemIds.VANADIUM_ORE)
			.add(IcariaBlockItemIds.SLIVER_ORE);

		this.tag(IcariaBlockItemTags.ORES_IN_GROUND_VOIDSHALE)
			.add(IcariaBlockItemIds.SIDEROS_ORE)
			.add(IcariaBlockItemIds.ANTHRACITE_ORE);

		this.tag(IcariaBlockItemTags.ORES_IN_GROUND_YELLOWSTONE)
			.add(IcariaBlockItemIds.LIGNITE_ORE)
			.add(IcariaBlockItemIds.CHALKOS_ORE);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_ANTHRACITE)
			.add(IcariaBlockItemIds.ANTHRACITE_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_ARACHNE_STRING)
			.add(IcariaBlockItemIds.TERRY_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_ARISTONE)
			.add(IcariaBlockItemIds.PACKED_ARISTONE);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_BLURIDIUM)
			.add(IcariaBlockItemIds.BLURIDIUM_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_CHALKOS)
			.add(IcariaBlockItemIds.CHALKOS_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_CHERT)
			.add(IcariaBlockItemIds.CHERT_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY)
			.add(IcariaBlockItemIds.ENDER_JELLYFISH_JELLY_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY)
			.add(IcariaBlockItemIds.FIRE_JELLYFISH_JELLY_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_KASSITEROS)
			.add(IcariaBlockItemIds.KASSITEROS_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_LIGNITE)
			.add(IcariaBlockItemIds.LIGNITE_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_MOLYBDENUM)
			.add(IcariaBlockItemIds.MOLYBDENUM_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_MOLYBDENUMSTEEL)
			.add(IcariaBlockItemIds.MOLYBDENUMSTEEL_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY)
			.add(IcariaBlockItemIds.NATURE_JELLYFISH_JELLY_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_ORICHALCUM)
			.add(IcariaBlockItemIds.ORICHALCUM_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_CHALKOS)
			.add(IcariaBlockItemIds.RAW_CHALKOS_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_KASSITEROS)
			.add(IcariaBlockItemIds.RAW_KASSITEROS_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_MOLYBDENUM)
			.add(IcariaBlockItemIds.RAW_MOLYBDENUM_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_SIDEROS)
			.add(IcariaBlockItemIds.RAW_SIDEROS_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_VANADIUM)
			.add(IcariaBlockItemIds.RAW_VANADIUM_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_ROTTEN_BONES)
			.add(IcariaBlockItemIds.ROTTEN_BONES_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_SIDEROS)
			.add(IcariaBlockItemIds.SIDEROS_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_SLIVER)
			.add(IcariaBlockItemIds.SLIVER_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_SPELT)
			.add(IcariaBlockItemIds.SPELT_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_VANADIUM)
			.add(IcariaBlockItemIds.VANADIUM_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_VANADIUMSTEEL)
			.add(IcariaBlockItemIds.VANADIUMSTEEL_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_VINE_REED)
			.add(IcariaBlockItemIds.VINE_REED_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY)
			.add(IcariaBlockItemIds.VOID_JELLYFISH_JELLY_BLOCK);

		this.tag(IcariaBlockItemTags.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY)
			.add(IcariaBlockItemIds.WATER_JELLYFISH_JELLY_BLOCK);

		this.tag(IcariaBlockItemTags.TERRY_BLOCKS)
			.add(IcariaBlockItemIds.TERRY_BLOCK)
			.add(IcariaBlockItemIds.WHITE_TERRY_BLOCK)
			.add(IcariaBlockItemIds.LIGHT_GRAY_TERRY_BLOCK)
			.add(IcariaBlockItemIds.GRAY_TERRY_BLOCK)
			.add(IcariaBlockItemIds.BLACK_TERRY_BLOCK)
			.add(IcariaBlockItemIds.BROWN_TERRY_BLOCK)
			.add(IcariaBlockItemIds.RED_TERRY_BLOCK)
			.add(IcariaBlockItemIds.ORANGE_TERRY_BLOCK)
			.add(IcariaBlockItemIds.YELLOW_TERRY_BLOCK)
			.add(IcariaBlockItemIds.LIME_TERRY_BLOCK)
			.add(IcariaBlockItemIds.GREEN_TERRY_BLOCK)
			.add(IcariaBlockItemIds.CYAN_TERRY_BLOCK)
			.add(IcariaBlockItemIds.LIGHT_BLUE_TERRY_BLOCK)
			.add(IcariaBlockItemIds.BLUE_TERRY_BLOCK)
			.add(IcariaBlockItemIds.PURPLE_TERRY_BLOCK)
			.add(IcariaBlockItemIds.MAGENTA_TERRY_BLOCK)
			.add(IcariaBlockItemIds.PINK_TERRY_BLOCK);

		this.tag(IcariaBlockItemTags.TERRY_MATS)
			.add(IcariaBlockItemIds.TERRY_MAT)
			.add(IcariaBlockItemIds.WHITE_TERRY_MAT)
			.add(IcariaBlockItemIds.LIGHT_GRAY_TERRY_MAT)
			.add(IcariaBlockItemIds.GRAY_TERRY_MAT)
			.add(IcariaBlockItemIds.BLACK_TERRY_MAT)
			.add(IcariaBlockItemIds.BROWN_TERRY_MAT)
			.add(IcariaBlockItemIds.RED_TERRY_MAT)
			.add(IcariaBlockItemIds.ORANGE_TERRY_MAT)
			.add(IcariaBlockItemIds.YELLOW_TERRY_MAT)
			.add(IcariaBlockItemIds.LIME_TERRY_MAT)
			.add(IcariaBlockItemIds.GREEN_TERRY_MAT)
			.add(IcariaBlockItemIds.CYAN_TERRY_MAT)
			.add(IcariaBlockItemIds.LIGHT_BLUE_TERRY_MAT)
			.add(IcariaBlockItemIds.BLUE_TERRY_MAT)
			.add(IcariaBlockItemIds.PURPLE_TERRY_MAT)
			.add(IcariaBlockItemIds.MAGENTA_TERRY_MAT)
			.add(IcariaBlockItemIds.PINK_TERRY_MAT);
	}
}
