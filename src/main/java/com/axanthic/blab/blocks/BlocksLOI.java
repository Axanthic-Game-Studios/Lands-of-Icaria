package com.axanthic.blab.blocks;

import javax.annotation.Nullable;

import com.axanthic.blab.Resources;
import com.axanthic.blab.blocks.BlockRock.StoneTypes;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class BlocksLOI {

	public static final Block STONE_LOI;
	public static final IBlockState YELLOWSTONE;
	public static final IBlockState SILKSTONE;
	public static final IBlockState SUNSTONE;
	public static final IBlockState VOIDSHALE;
	public static final IBlockState BAETYL;

	/**
	 * Returns the Block in the blockRegistry with the specified name.
	 */
	@Nullable
	private static Block getRegisteredBlock(final String blockName)
	{
		final Block block = Block.REGISTRY.getObject(new ResourceLocation(blockName));

		if (block == null)
		{
			throw new IllegalStateException("Invalid Block requested: " + blockName);
		}
		else
		{
			return block;
		}
	}

	static {
		STONE_LOI = Resources.rock.getBlock();
		YELLOWSTONE = ((BlockRock)Resources.rock.getBlock()).getStateFromMeta(StoneTypes.SILKSTONE.getMeta());
		SILKSTONE = ((BlockRock)Resources.rock.getBlock()).getStateFromMeta(StoneTypes.SILKSTONE.getMeta());
		SUNSTONE = ((BlockRock)Resources.rock.getBlock()).getStateFromMeta(StoneTypes.SUNSTONE.getMeta());
		VOIDSHALE = ((BlockRock)Resources.rock.getBlock()).getStateFromMeta(StoneTypes.VOIDSHALE.getMeta());
		BAETYL = ((BlockRock)Resources.rock.getBlock()).getStateFromMeta(StoneTypes.BAETYL.getMeta());
	}
}
