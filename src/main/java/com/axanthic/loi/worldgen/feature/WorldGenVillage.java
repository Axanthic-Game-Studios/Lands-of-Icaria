package com.axanthic.loi.worldgen.feature;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;

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
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.BlockRotationProcessor;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenVillage extends WorldGenStructureBase {

	public static BlockPos zero = new BlockPos(0, 0, 0);
	int range = 5;
	public static IBlockState roadState = Resources.rock.getBlock().getStateFromMeta(5);

	public final String[] ruins = new String[] {
			"village/house_0",
			"village/house_1",
			"village/house_2",
			"village/house_3",
			"village/house_4",
			"village/house_5",
			"village/house_6",
			"village/house_7",
			"village/house_8",
			"village/house_9",
			"village/house_10",
			"village/house_11",
			"village/house_12",
			"village/house_13",
			"village/house_14",
			"village/house_15",
			"village/house_16",
			"village/house_17",
			"village/house_18",
			"village/house_19",
			"village/house_20",
			"village/bakery_0",
			"village/bakery_1",
			/*"village/blacksmith_0",
			"village/blacksmith_1",*/
			"village/greenhouse_0",
			"village/greenhouse_1",
			"village/greenhouse_2",
			"village/lumberjack_0",
			"village/lumberjack_1",
			"village/lumberjack_2",
			"village/lumberjack_3",
			"village/mason_0",
			"village/mason_1",
			"village/pottery_0",
			"village/pottery_1"
	};

	public WorldGenVillage(float integrity) {
		super(integrity);
	}

	public void generate(World worldIn, ChunkPos position) {
		int i = this.range;
		Random rand = new Random();
		rand.setSeed(worldIn.getSeed());
		long j = rand.nextLong();
		long k = rand.nextLong();
		int x = position.x;
		int z = position.z;

		for (int l = x - i; l <= x + i; ++l)
		{
			for (int i1 = z - i; i1 <= z + i; ++i1)
			{
				long j1 = (long)l * j;
				long k1 = (long)i1 * k;
				Random rand2 = new Random();
				rand2.setSeed(j1 ^ k1 ^ worldIn.getSeed());
				this.recursiveGenerate(worldIn, l, i1, x, z, position, rand2);
			}
		}
	}

	int attempts = 6;

	protected void recursiveGenerate(World worldIn, int chunkX, int chunkZ, int originalX, int originalZ, ChunkPos chunk, Random rand) {
		int i = 0;

		if (chunkX % 3 == 0 && chunkZ % 3 == 0 && rand.nextInt(47) == 0) {
			i = 1;
		}

		for (int j = 0; j < i; ++j) {
			int startX = chunkX * 16 + rand.nextInt(16);
			int startZ = chunkZ * 16 + rand.nextInt(16);
			int k = 1500;

			for (int l = 0; l < k / 2; ++l) {
				int addX = rand.nextInt(128) - 64;
				int addZ = rand.nextInt(128) - 64;
				for (int attempt = 0; attempt < attempts; ++attempt) {
					if (this.placeHouse(worldIn, rand, new BlockPos(startX + addX, 111, startZ + addZ), chunk))
						break;
				}
			}
			for (int l = 0; l < k; ++l) {
				int addX = rand.nextInt(64) - 32;
				int addZ = rand.nextInt(64) - 32;
				for (int attempt = 0; attempt < attempts; ++attempt) {
					if (this.placeHouse(worldIn, rand, new BlockPos(startX + addX, 111, startZ + addZ), chunk))
						break;
				}
			}
		}
	}

	public boolean placeHouse(World worldIn, Random rand, BlockPos position, ChunkPos chunk) {
		TemplateManager templatemanager = ((WorldServer) worldIn).getStructureTemplateManager();
		Template template = templatemanager.get(worldIn.getMinecraftServer(), new ResourceLocation(ModInformation.ID, ruins[rand.nextInt(ruins.length)]));
		placementsettings.setMirror(Mirror.values()[rand.nextInt(Mirror.values().length)]);
		placementsettings.setRotation(Rotation.values()[rand.nextInt(Rotation.values().length)]);

		int margin = 0;

		if (position.getX() > chunk.getXEnd() + margin || position.getX() < chunk.getXStart() - margin || position.getZ() > chunk.getZEnd() + margin || position.getZ() < chunk.getZStart() - margin) {
			return false;
		}

		BlockPos outerPos = template.transformedBlockPos(placementsettings, new BlockPos(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1)).add(position);

		if (outerPos.getX() > chunk.getXEnd() + margin || outerPos.getX() < chunk.getXStart() - margin || outerPos.getZ() > chunk.getZEnd() + margin || outerPos.getZ() < chunk.getZStart() - margin) {
			return false;
		}

		position = position.add(8, 0, 8);

		while (!worldIn.isBlockFullCube(position)) {
			position = position.down();
			if (position.getY() < 88)
				return false;
		}

		if (!canPlaceHouseHere(worldIn, rand, position, chunk, template))
			position = position.up();
		if (!canPlaceHouseHere(worldIn, rand, position, chunk, template))
			return false;

		rand = new Random(rand.nextLong());
		addBlocksToWorldSilently(template, worldIn, position, new BlockRotationProcessor(position.up(), placementsettings), placementsettings, rand, 2);
		return true;
	}

	public boolean canPlaceHouseHere(World worldIn, Random rand, BlockPos position, ChunkPos chunk, Template template) {
		for (BlockPos basePos : BlockPos.getAllInBox(zero, zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1))) {
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			boolean flag = !worldIn.isBlockFullCube(pos.down());
			if (!worldIn.isBlockFullCube(pos) && flag)
				return false;
			if (flag)
				return false;
			if (worldIn.getBlockState(pos).equals(roadState) || worldIn.getBlockState(pos.down()).equals(roadState))
				return false;
		}
		for (BlockPos basePos : BlockPos.getAllInBox(zero.add(0, 0, template.getSize().getZ() - 1), zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1))) {
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (!worldIn.isBlockFullCube(pos))
				return false;
		}
		for (BlockPos basePos : BlockPos.getAllInBox(zero.up(), zero.add(template.getSize().getX() - 1, template.getSize().getY(), template.getSize().getZ() - 1))) {
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (worldIn.isBlockFullCube(pos))
				return false;
		}
		boolean hasRoad = false;
		for (BlockPos basePos : BlockPos.getAllInBox(zero.add(0, 0, template.getSize().getZ()), zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() + 4))) {
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (worldIn.getBlockState(pos).equals(roadState)) {
				hasRoad = true;
				break;
			}
		}
		if (!hasRoad)
			return false;
		return true;
	}

	public static void addBlocksToWorldSilently(Template template, World worldIn, BlockPos position, @Nullable ITemplateProcessor templateProcessor, PlacementSettings placementIn, Random rand, int flags) {
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

		//this is for later
		BlockPos doorLocation = null;

		if (!blocks.isEmpty() && template.getSize().getX() >= 1 && template.getSize().getY() >= 1 && template.getSize().getZ() >= 1) {
			Block block = placementIn.getReplacedBlock();
			StructureBoundingBox structureboundingbox = placementIn.getBoundingBox();

			for (Template.BlockInfo template$blockinfo : blocks) {
				BlockPos blockpos = template.transformedBlockPos(placementIn, template$blockinfo.pos).add(position);
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
						if (iblockstate1.equals(roadState))
							doorLocation = blockpos;

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
		//place a path to the door of the the house
		if (doorLocation == null)
			for (BlockPos basePos : BlockPos.getAllInBox(zero.up(), zero.add(template.getSize().getX() - 1, template.getSize().getY(), template.getSize().getZ() - 1))) {
				BlockPos pos = template.transformedBlockPos(placementIn, basePos).add(position);
				if (worldIn.getBlockState(pos).equals(roadState)) {
					doorLocation = pos;
					break;
				}
			}
		if (doorLocation == null) {
			return;
		}

		BlockPos closestRoad = null;
		double closestRoadDist = 100;
		for (BlockPos basePos : BlockPos.getAllInBox(zero.add(0, 0, template.getSize().getZ()), zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() + 4))) {
			BlockPos pos = template.transformedBlockPos(placementIn, basePos).add(position);
			if (worldIn.getBlockState(pos).equals(roadState)) {
				double distance = pos.distanceSq(doorLocation);
				if (distance < closestRoadDist) {
					closestRoadDist = distance;
					closestRoad = pos;
				}
			}
		}
		if (closestRoad == null) {
			return;
		}

		BlockPos difference = doorLocation.subtract(closestRoad);
		int distX = difference.getX();
		int distZ = difference.getZ();
		while (distX != 0 || distZ != 0) {
			if (rand.nextBoolean() || distZ == 0) {
				if (distX > 0) {
					doorLocation = doorLocation.add(-1, 0, 0);
					worldIn.setBlockState(doorLocation, roadState, flags);
					if (worldIn.getBlockState(doorLocation.up()).getBlock().equals(Resources.moss.getBlock()))
						worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
					distX--;
				} else if (distX < 0) {
					doorLocation = doorLocation.add(1, 0, 0);
					worldIn.setBlockState(doorLocation, roadState, flags);
					if (worldIn.getBlockState(doorLocation.up()).getBlock().equals(Resources.moss.getBlock()))
						worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
					distX++;
				}
			} else if (distZ > 0) {
				doorLocation = doorLocation.add(0, 0, -1);
				worldIn.setBlockState(doorLocation, roadState, flags);
				if (worldIn.getBlockState(doorLocation.up()).getBlock().equals(Resources.moss.getBlock()))
					worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
				distZ--;
			} else if (distZ < 0) {
				doorLocation = doorLocation.add(0, 0, 1);
				worldIn.setBlockState(doorLocation, roadState, flags);
				if (worldIn.getBlockState(doorLocation.up()).getBlock().equals(Resources.moss.getBlock()))
					worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
				distZ++;
			}
		}
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		return false;
	}
}