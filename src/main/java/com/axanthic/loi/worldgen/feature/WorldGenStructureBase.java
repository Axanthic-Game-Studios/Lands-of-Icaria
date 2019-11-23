package com.axanthic.loi.worldgen.feature;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockRelicstone;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public abstract class WorldGenStructureBase extends WorldGenerator {

	final PlacementSettings placementsettings;

	public WorldGenStructureBase(float integrity) {
		placementsettings = new PlacementSettings().setIntegrity(integrity).setChunk((ChunkPos)null).setReplacedBlock((Block)null);
	}

	public static void addBlocksToWorldSilently(Template template, World worldIn, BlockPos pos, @Nullable ITemplateProcessor templateProcessor, PlacementSettings placementIn, Random rand, int flags) {
		List<Template.BlockInfo> blocks = null;
		try {
			Field privateStringField;
			privateStringField = Template.class.getDeclaredField("blocks");
			privateStringField.setAccessible(true);
			blocks = (List<Template.BlockInfo>) privateStringField.get(template);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			return;
		}

		if (!blocks.isEmpty() && template.getSize().getX() >= 1 && template.getSize().getY() >= 1 && template.getSize().getZ() >= 1) {
			Block block = placementIn.getReplacedBlock();
			StructureBoundingBox structureboundingbox = placementIn.getBoundingBox();

			for (Template.BlockInfo template$blockinfo : blocks) {
				BlockPos blockpos = template.transformedBlockPos(placementIn, template$blockinfo.pos).add(pos);
				// Forge: skip processing blocks outside BB to prevent cascading worldgen issues
				if (structureboundingbox != null && !structureboundingbox.isVecInside(blockpos)) continue;
				Template.BlockInfo template$blockinfo1 = templateProcessor != null ? templateProcessor.processBlock(worldIn, blockpos, template$blockinfo) : template$blockinfo;

				if (template$blockinfo1 != null) {
					Block block1 = template$blockinfo1.blockState.getBlock();

					if ((block == null || block != block1) && (!placementIn.getIgnoreStructureBlock() || block1 != Blocks.STRUCTURE_BLOCK) && (structureboundingbox == null || structureboundingbox.isVecInside(blockpos))) {
						IBlockState iblockstate = replaceBlock(template$blockinfo1.blockState.withMirror(placementIn.getMirror()), rand);
						IBlockState iblockstate1 = iblockstate.withRotation(placementIn.getRotation());

						if (template$blockinfo1.tileentityData != null) {
							TileEntity tileentity = worldIn.getTileEntity(blockpos);

							if (tileentity != null) {
								if (tileentity instanceof IInventory) {
									((IInventory)tileentity).clear();
								}

								worldIn.setBlockState(blockpos, Blocks.BARRIER.getDefaultState(), 4);
							}
						}

						if (worldIn.setBlockState(blockpos, iblockstate1, flags) && template$blockinfo1.tileentityData != null) {
							TileEntity tileentity2 = worldIn.getTileEntity(blockpos);

							if (tileentity2 != null) {
								template$blockinfo1.tileentityData.setInteger("x", blockpos.getX());
								template$blockinfo1.tileentityData.setInteger("y", blockpos.getY());
								template$blockinfo1.tileentityData.setInteger("z", blockpos.getZ());
								tileentity2.readFromNBT(template$blockinfo1.tileentityData);
								tileentity2.mirror(placementIn.getMirror());
								tileentity2.rotate(placementIn.getRotation());
							}
						}
					}
				}
			}
		}
	}

	private final static IBlockState[] bricks = new IBlockState[] {Resources.brick.getBlock().getStateFromMeta(5), Resources.relicstone.getBlock().getStateFromMeta(1), Resources.relicstone.getBlock().getStateFromMeta(2)};
	private final static IBlockState[] tiles = new IBlockState[] {Resources.relicstone.getBlock().getStateFromMeta(4), Resources.relicstone.getBlock().getStateFromMeta(5), Resources.relicstone.getBlock().getStateFromMeta(6)};
	private final static Block[] brickSlabs = new Block[] {Resources.relicstoneBrick.slab.getBlock(), Resources.relicstoneCrackBrick.slab.getBlock(), Resources.relicstoneMossBrick.slab.getBlock()};
	private final static Block[] brickStairs = new Block[] {Resources.relicstoneBrick.stairs.getBlock(), Resources.relicstoneCrackBrick.stairs.getBlock(), Resources.relicstoneMossBrick.stairs.getBlock()};
	private final static IBlockState[] brickWalls = new IBlockState[] {Resources.relicstoneBrick.wall.getBlock().getDefaultState(), Resources.relicstoneCrackBrick.wall.getBlock().getDefaultState(), Resources.relicstoneMossBrick.wall.getBlock().getDefaultState()};
	private final static Block[] tileSlabs = new Block[] {Resources.relicstoneTile.slab.getBlock(), Resources.relicstoneCrackTile.slab.getBlock(), Resources.relicstoneMossTile.slab.getBlock()};
	private final static Block[] tileStairs = new Block[] {Resources.relicstoneTile.stairs.getBlock(), Resources.relicstoneCrackTile.stairs.getBlock(), Resources.relicstoneMossTile.stairs.getBlock()};

	public static IBlockState replaceBlock(IBlockState state, Random rand) {
		int type = rand.nextInt(3);
		Block block = state.getBlock();
		if (block instanceof BlockRelicstone) {
			int meta = block.getMetaFromState(state);
			if (meta == 3)
				return bricks[type];
			if (meta == 7)
				return tiles[type];
		} else if (block.equals(Resources.relicstoneDraftBrick.slab.getBlock())) {
			return brickSlabs[type].getStateFromMeta(block.getMetaFromState(state));
		} else if (block.equals(Resources.relicstoneDraftBrick.stairs.getBlock())) {
			return brickStairs[type].getStateFromMeta(block.getMetaFromState(state));
		} else if (block.equals(Resources.relicstoneDraftBrick.wall.getBlock())) {
			return brickWalls[type];
		} else if (block.equals(Resources.relicstoneDraftTile.slab.getBlock())) {
			return tileSlabs[type].getStateFromMeta(block.getMetaFromState(state));
		} else if (block.equals(Resources.relicstoneDraftTile.stairs.getBlock())) {
			return tileStairs[type].getStateFromMeta(block.getMetaFromState(state));
		}
		return state;
	}
}