package com.axanthic.loi.worldgen.feature;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.BlockRotationProcessor;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenRuins extends WorldGenerator {

	private final PlacementSettings placementsettings;

	public final String[] pillars = new String[] {
			"pillar/pillar2",
			"pillar/pillar3",
			"pillar/pillar4",
			"pillar/pillar5",
			"pillar/pillar6",
			"pillar/pillarv2",
			"pillar/pillarv3",
			"pillar/pillarv4"
	};

	public WorldGenRuins(float integrity) {
		placementsettings = new PlacementSettings().setIntegrity(integrity).setChunk((ChunkPos)null).setReplacedBlock((Block)null);
	}

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		TemplateManager templatemanager = ((WorldServer) worldIn).getStructureTemplateManager();
		Template template = templatemanager.get(worldIn.getMinecraftServer(), new ResourceLocation(ModInformation.ID, pillars[rand.nextInt(pillars.length)]));
		placementsettings.setMirror(Mirror.values()[rand.nextInt(Mirror.values().length)]);
		placementsettings.setRotation(Rotation.values()[rand.nextInt(Rotation.values().length)]);

		addBlocksToWorld(template, worldIn, position.up(), new BlockRotationProcessor(position.up(), placementsettings), placementsettings, 2);
		return true;
	}


	public static void addBlocksToWorld(Template template, World worldIn, BlockPos pos, @Nullable ITemplateProcessor templateProcessor, PlacementSettings placementIn, int flags) {
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
						IBlockState iblockstate = template$blockinfo1.blockState.withMirror(placementIn.getMirror());
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
}