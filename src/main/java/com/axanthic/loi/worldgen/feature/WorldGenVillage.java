package com.axanthic.loi.worldgen.feature;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockRock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumFacing;
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
	public static PlacementSettings defaultPlacementSettings = new PlacementSettings().setIntegrity(1).setChunk((ChunkPos)null).setReplacedBlock((Block)null);
	public static IBlockState roadState = Resources.rock.getBlock().getStateFromMeta(BlockRock.StoneTypes.RELICSTONE.getMeta());
	public static IBlockState oldRoadState = Resources.relicstoneRoad.getBlock().getDefaultState();
	public static int range = 5;
	public static int spawnerChance = 9;
	public static int breakingChance = 20;

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
			"village/blacksmith_0",
			"village/blacksmith_1",
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
			int size = rand.nextInt(2) + rand.nextInt(2) + 3;
			int k = 1500;
			boolean damaged = false;
			boolean ruined = false;
			int state = rand.nextInt(2);
			if (state == 0) {
				damaged = true;
			} else if (state == 1) {
				ruined = true;
			}

			this.placeWell(worldIn, rand, new BlockPos(startX, 111, startZ), chunk, size > 4 ? 1 : 0);

			for (int l = 0; l < k / 2; ++l) {
				int addX = rand.nextInt(128) - 64;
				int addZ = rand.nextInt(128) - 64;
				for (int attempt = 0; attempt < attempts; ++attempt) {
					if (this.placeHouse(worldIn, rand, new BlockPos(startX + addX, 111, startZ + addZ), chunk, damaged, ruined))
						break;
				}
			}
			for (int l = 0; l < k; ++l) {
				int addX = rand.nextInt(64) - 32;
				int addZ = rand.nextInt(64) - 32;
				for (int attempt = 0; attempt < attempts; ++attempt) {
					if (this.placeHouse(worldIn, rand, new BlockPos(startX + addX, 111, startZ + addZ), chunk, damaged, ruined))
						break;
				}
			}
		}
	}

	public boolean placeWell(World worldIn, Random rand, BlockPos position, ChunkPos chunk, int type) {
		TemplateManager templatemanager = ((WorldServer) worldIn).getStructureTemplateManager();
		Template template = templatemanager.get(worldIn.getMinecraftServer(), new ResourceLocation(ModInformation.ID, "village/well_" + type));
		//placementsettings.setMirror(Mirror.values()[rand.nextInt(Mirror.values().length)]);
		//placementsettings.setRotation(Rotation.values()[rand.nextInt(Rotation.values().length)]);

		BlockPos offsetPos = position.add(new BlockPos(-(template.getSize().getX() - 1) / 2, 0, -template.getSize().getZ() / 2));

		if (isOutsideChunkBounds(offsetPos.add(-8, 0, -8), chunk, 0)) {
			return false;
		}

		//offsetPos = offsetPos.add(8, 0, 8);

		while (!worldIn.isBlockFullCube(offsetPos)) {
			offsetPos = offsetPos.down();
			if (offsetPos.getY() < 88)
				return false;
		}

		if (type == 0) {
			offsetPos = offsetPos.add(0, -8, 0);
		} else if (type == 1) {
			offsetPos = offsetPos.add(0, -10, 0);
		}

		rand = new Random(rand.nextLong());
		addBlocksToWorldSilently(template, worldIn, offsetPos, new BlockRotationProcessor(offsetPos, defaultPlacementSettings), defaultPlacementSettings, rand, chunk, 2, false, false);
		return true;
	}

	public boolean placeHouse(World worldIn, Random rand, BlockPos position, ChunkPos chunk, boolean damaged, boolean ruined) {
		TemplateManager templatemanager = ((WorldServer) worldIn).getStructureTemplateManager();
		Template template = templatemanager.get(worldIn.getMinecraftServer(), new ResourceLocation(ModInformation.ID, ruins[rand.nextInt(ruins.length)]));
		placementsettings.setMirror(Mirror.values()[rand.nextInt(Mirror.values().length)]);
		placementsettings.setRotation(Rotation.values()[rand.nextInt(Rotation.values().length)]);

		BlockPos outerPos = template.transformedBlockPos(placementsettings, new BlockPos(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1)).add(position);

		if (isOutsideChunkBounds(position, chunk, 0) || isOutsideChunkBounds(outerPos, chunk, 4)) {
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
		addBlocksToWorldSilently(template, worldIn, position, new BlockRotationProcessor(position.up(), placementsettings), placementsettings, rand, chunk, 2, damaged, ruined);
		return true;
	}

	public static boolean isOutsideChunkBounds(BlockPos position, ChunkPos chunk, int margin) {
		return position.getX() > chunk.getXEnd() + margin || position.getX() < chunk.getXStart() - margin || position.getZ() > chunk.getZEnd() + margin || position.getZ() < chunk.getZStart() - margin;
	}

	public boolean canPlaceHouseHere(World worldIn, Random rand, BlockPos position, ChunkPos chunk, Template template) {
		for (BlockPos basePos : BlockPos.getAllInBox(zero, zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1))) { //check the ground under the house
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (!worldIn.isBlockFullCube(pos.down()))
				return false;
			if (worldIn.getBlockState(pos).equals(oldRoadState) || worldIn.getBlockState(pos.down()).equals(oldRoadState) || worldIn.getBlockState(pos).equals(roadState) || worldIn.getBlockState(pos.down()).equals(roadState))
				return false;
		}
		for (BlockPos basePos : BlockPos.getAllInBox(zero.add(0, 0, template.getSize().getZ() - 1), zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1))) { //check the ground at the front of the house
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (!worldIn.isBlockFullCube(pos))
				return false;
		}
		for (BlockPos basePos : BlockPos.getAllInBox(zero.up().add(-1, 0, -1), zero.add(template.getSize().getX(), template.getSize().getY(), template.getSize().getZ()))) { //check if the house isn't obstructed by solid blocks
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (worldIn.isBlockFullCube(pos))
				return false;
		}
		boolean hasRoad = false;
		for (BlockPos basePos : BlockPos.getAllInBox(zero.add(0, 0, template.getSize().getZ()), zero.add(template.getSize().getX() - 1, 0, template.getSize().getZ() + 4))) { //check if the house has a road to connect to
			BlockPos pos = template.transformedBlockPos(placementsettings, basePos).add(position);
			if (isOutsideChunkBounds(pos.add(-8, 0, -8), chunk, 4))
				continue;
			if (worldIn.getBlockState(pos).equals(oldRoadState)) {
				hasRoad = true;
				break;
			}
		}
		if (!hasRoad)
			return false;
		return true;
	}

	public static void addBlocksToWorldSilently(Template template, World worldIn, BlockPos position, @Nullable ITemplateProcessor templateProcessor, PlacementSettings placementIn, Random rand, ChunkPos chunk, int flags, boolean damaged, boolean ruined) {
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

		List brokenCoords = new ArrayList<String>();

		if (!blocks.isEmpty() && template.getSize().getX() >= 1 && template.getSize().getY() >= 1 && template.getSize().getZ() >= 1) {
			Block block = placementIn.getReplacedBlock();
			StructureBoundingBox structureboundingbox = placementIn.getBoundingBox();

			int spawnersPlaced = 0;
			int grindersPlaced = 0;
			int grindersNotPlaced = 0;
			int maxSpawners = 0;
			if (damaged)
				maxSpawners = 2;
			if (ruined)
				maxSpawners = 1;
			Long seed = rand.nextLong();

			for (Template.BlockInfo template$blockinfo : blocks) {
				BlockPos relativePos = template.transformedBlockPos(placementIn, template$blockinfo.pos);
				BlockPos blockpos = relativePos.add(position);

				// Forge: skip processing blocks outside BB to prevent cascading worldgen issues
				if (structureboundingbox != null && !structureboundingbox.isVecInside(blockpos)) continue;
				Template.BlockInfo template$blockinfo1 = templateProcessor != null ? templateProcessor.processBlock(worldIn, blockpos, template$blockinfo) : template$blockinfo;

				if (template$blockinfo1 != null) {
					Block block1 = template$blockinfo1.blockState.getBlock();

					if ((block == null || block != block1) && (!placementIn.getIgnoreStructureBlock() || block1 != Blocks.STRUCTURE_BLOCK) && (structureboundingbox == null || structureboundingbox.isVecInside(blockpos))) {
						IBlockState iblockstate = replaceBlock(template$blockinfo1.blockState.withMirror(placementIn.getMirror()), relativePos.getY() - 1, rand, seed);
						IBlockState iblockstate1 = iblockstate.withRotation(placementIn.getRotation());

						if (ruined) {
							if (worldIn.isAirBlock(blockpos.down()))
								continue;
							if (iblockstate1.getMaterial() != Material.AIR) {
								if (rand.nextInt(breakingChance / (relativePos.getY() + 1) + 1) == 0) {
									brokenCoords.add(blockpos.getX() + "," + blockpos.getZ());
									continue;
								}
								if (brokenCoords.contains(blockpos.getX() + "," + blockpos.getZ()))
									continue;
								if (!iblockstate1.isFullCube() && !iblockstate1.equals(Resources.lootVase.getBlock().getDefaultState()) && !iblockstate1.equals(Resources.lootVase2.getBlock().getDefaultState()))
									continue;
							}
						}

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

						if (iblockstate1.equals(Resources.lootVase.getBlock().getDefaultState()) || iblockstate1.equals(Resources.lootVase2.getBlock().getDefaultState())) {
							int chance = 2;
							if (damaged)
								chance = 5;
							if (ruined)
								chance = 10;

							if (rand.nextInt(chance) != 0) {
								if (spawnersPlaced < maxSpawners && rand.nextInt(spawnerChance) == 0) {
									iblockstate1 = Resources.villageSpawner.getBlock().getDefaultState();
									spawnersPlaced++;
								} else {
									iblockstate1 = Blocks.AIR.getDefaultState();
								}
							}
						}
						if (iblockstate1.equals(Resources.grinder.getBlock().getDefaultState())) {
							if (grindersNotPlaced > 0 || (grindersPlaced < 1 && rand.nextInt(2) == 0)) {
								grindersPlaced++;
							} else {
								grindersNotPlaced++;
								iblockstate1 = Blocks.AIR.getDefaultState();
							}
						}

						if (worldIn.setBlockState(blockpos, iblockstate1, flags)) {
							TileEntity tileentity2 = worldIn.getTileEntity(blockpos);

							if (tileentity2 != null && template$blockinfo1.tileentityData != null) {
								template$blockinfo1.tileentityData.setInteger("x", blockpos.getX());
								template$blockinfo1.tileentityData.setInteger("y", blockpos.getY());
								template$blockinfo1.tileentityData.setInteger("z", blockpos.getZ());
								tileentity2.readFromNBT(template$blockinfo1.tileentityData);
								tileentity2.mirror(placementIn.getMirror());
								tileentity2.rotate(placementIn.getRotation());
							}
							if (tileentity2 instanceof TileEntityMobSpawner) {
								MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity2).getSpawnerBaseLogic();
								mobspawnerbaselogic.setEntityId(new ResourceLocation(ModInformation.ID, "revenant_civilian"));
								tileentity2.markDirty();
							}
						}
					}
				}
			}
			if (damaged)
				for (Template.BlockInfo template$blockinfo : blocks) {
					BlockPos relativePos = template.transformedBlockPos(placementIn, template$blockinfo.pos);
					BlockPos blockpos = relativePos.add(position);
					boolean safe = true;
					int airblocks = 0;
					for (EnumFacing face : EnumFacing.VALUES) {
						if (isOutsideChunkBounds(blockpos.offset(face).add(-8, 0, -8), chunk, 4))
							continue;
						IBlockState state = worldIn.getBlockState(blockpos.offset(face));
						if (!state.isFullCube()) {
							if (state.getBlock().isAir(state, worldIn, blockpos.offset(face))) {
								airblocks++;
								continue;
							}
							safe = false;
							break;
						}
					}
					if (safe && rand.nextInt(14 - airblocks * 2) == 0)
						worldIn.setBlockToAir(blockpos);
				}
			if (ruined)
				for (Template.BlockInfo template$blockinfo : blocks) {
					BlockPos relativePos = template.transformedBlockPos(placementIn, template$blockinfo.pos);
					BlockPos blockpos = relativePos.add(position);
					if (worldIn.getBlockState(blockpos).isFullCube())
						for (EnumFacing face : EnumFacing.VALUES) {
							if (isOutsideChunkBounds(blockpos.offset(face).add(-8, 0, -8), chunk, 4))
								continue;
							if (worldIn.isAirBlock(blockpos.offset(face)) && rand.nextInt(6) == 0) {
								worldIn.setBlockState(blockpos.offset(face), Blocks.WEB.getDefaultState());
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
			if (isOutsideChunkBounds(pos.add(-8, 0, -8), chunk, 4))
				continue;
			if (worldIn.getBlockState(pos).equals(oldRoadState)) {
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
		boolean randBool = false;
		boolean tryTheOtherOne = false;
		boolean triedThatAlready = false;
		while (distX != 0 || distZ != 0) {
			if ((distX == 1 && distZ == 0) || (distX == 0 && distZ == 1) || (distX == -1 && distZ == 0) || (distX == 0 && distZ == -1))
				break;

			if (tryTheOtherOne) {
				if (triedThatAlready) {
					break; //well then I give up
				}
				randBool = !randBool;
				tryTheOtherOne = false;
				triedThatAlready = true;
			} else {
				randBool = rand.nextBoolean();
			}

			if (randBool || distZ == 0) {
				if (distX > 0) {
					if (worldIn.getBlockState(doorLocation.add(-1, 0, 0)).getMaterial().equals(Material.ROCK)) {
						tryTheOtherOne = true;
						continue;
					}
					doorLocation = doorLocation.add(-1, 0, 0);
					worldIn.setBlockState(doorLocation, roadState, flags);
					if (!worldIn.getBlockState(doorLocation.up()).getBlock().equals(Blocks.AIR) && !worldIn.getBlockState(doorLocation.up()).getMaterial().equals(Material.ROCK))
						worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
					distX--;
				} else if (distX < 0) {
					if (worldIn.getBlockState(doorLocation.add(1, 0, 0)).getMaterial().equals(Material.ROCK)) {
						tryTheOtherOne = true;
						continue;
					}
					doorLocation = doorLocation.add(1, 0, 0);
					worldIn.setBlockState(doorLocation, roadState, flags);
					if (!worldIn.getBlockState(doorLocation.up()).getBlock().equals(Blocks.AIR) && !worldIn.getBlockState(doorLocation.up()).getMaterial().equals(Material.ROCK))
						worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
					distX++;
				}
			} else if (distZ > 0) {
				if (worldIn.getBlockState(doorLocation.add(0, 0, -1)).getMaterial().equals(Material.ROCK)) {
					tryTheOtherOne = true;
					continue;
				}
				doorLocation = doorLocation.add(0, 0, -1);
				worldIn.setBlockState(doorLocation, roadState, flags);
				if (!worldIn.getBlockState(doorLocation.up()).getBlock().equals(Blocks.AIR) && !worldIn.getBlockState(doorLocation.up()).getMaterial().equals(Material.ROCK))
					worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
				distZ--;
			} else if (distZ < 0) {
				if (worldIn.getBlockState(doorLocation.add(0, 0, 1)).getMaterial().equals(Material.ROCK)) {
					tryTheOtherOne = true;
					continue;
				}
				doorLocation = doorLocation.add(0, 0, 1);
				worldIn.setBlockState(doorLocation, roadState, flags);
				if (!worldIn.getBlockState(doorLocation.up()).getBlock().equals(Blocks.AIR) && !worldIn.getBlockState(doorLocation.up()).getMaterial().equals(Material.ROCK))
					worldIn.setBlockState(doorLocation.up(), Blocks.AIR.getDefaultState(), flags);
				distZ++;
			}
			triedThatAlready = false;
		}
	}

	private final static Block[] stoneSlabs = new Block[] {Resources.yellowstoneStone.slab.getBlock(), Resources.silkstoneStone.slab.getBlock(), Resources.sunstoneStone.slab.getBlock(), Resources.voidshaleStone.slab.getBlock(), Resources.baetylStone.slab.getBlock()};
	private final static Block[] stoneStairs = new Block[] {Resources.yellowstoneStone.stairs.getBlock(), Resources.silkstoneStone.stairs.getBlock(), Resources.sunstoneStone.stairs.getBlock(), Resources.voidshaleStone.stairs.getBlock(), Resources.baetylStone.stairs.getBlock()};
	private final static IBlockState[] stoneWalls = new IBlockState[] {Resources.yellowstoneStone.wall.getBlock().getDefaultState(), Resources.silkstoneStone.wall.getBlock().getDefaultState(), Resources.sunstoneStone.wall.getBlock().getDefaultState(), Resources.voidshaleStone.wall.getBlock().getDefaultState(), Resources.baetylStone.wall.getBlock().getDefaultState()};
	private final static Block[] brickSlabs = new Block[] {Resources.yellowstoneBrick.slab.getBlock(), Resources.silkstoneBrick.slab.getBlock(), Resources.sunstoneBrick.slab.getBlock(), Resources.voidshaleBrick.slab.getBlock(), Resources.baetylBrick.slab.getBlock()};
	private final static Block[] brickStairs = new Block[] {Resources.yellowstoneBrick.stairs.getBlock(), Resources.silkstoneBrick.stairs.getBlock(), Resources.sunstoneBrick.stairs.getBlock(), Resources.voidshaleBrick.stairs.getBlock(), Resources.baetylBrick.stairs.getBlock()};
	private final static IBlockState[] brickWalls = new IBlockState[] {Resources.yellowstoneBrick.wall.getBlock().getDefaultState(), Resources.silkstoneBrick.wall.getBlock().getDefaultState(), Resources.sunstoneBrick.wall.getBlock().getDefaultState(), Resources.voidshaleBrick.wall.getBlock().getDefaultState(), Resources.baetylBrick.wall.getBlock().getDefaultState()};
	private final static IBlockState[] plants = new IBlockState[] {Resources.flower.getBlock().getStateFromMeta(0), Resources.flower.getBlock().getStateFromMeta(1), Resources.flower.getBlock().getStateFromMeta(2), Resources.flower.getBlock().getStateFromMeta(3), Resources.flower.getBlock().getStateFromMeta(4), Resources.flower.getBlock().getStateFromMeta(5), Resources.flower.getBlock().getStateFromMeta(6), Resources.flower.getBlock().getStateFromMeta(7), Resources.flower.getBlock().getStateFromMeta(8), Resources.flower.getBlock().getStateFromMeta(9), Resources.flower.getBlock().getStateFromMeta(10), Resources.flower.getBlock().getStateFromMeta(11), Resources.flower.getBlock().getStateFromMeta(12), Resources.flower.getBlock().getStateFromMeta(13), Resources.flower.getBlock().getStateFromMeta(14), Resources.flower.getBlock().getStateFromMeta(15), Resources.flower2.getBlock().getStateFromMeta(0),
			Resources.bromelia.getBlock().getStateFromMeta(0), Resources.bromelia.getBlock().getStateFromMeta(1), Resources.bromelia.getBlock().getStateFromMeta(2), Resources.bromelia.getBlock().getStateFromMeta(3),
			Resources.bushStrawberry.getBlock().getDefaultState(), Resources.palmFern.getBlock().getDefaultState()};

	public static IBlockState replaceBlock(IBlockState state, int height, Random rand, Long seed) {
		state = WorldGenStructureBase.replaceBlock(state, height, rand);
		rand = new Random(seed);
		int type = rand.nextInt(5);
		Block block = state.getBlock();
		int meta = block.getMetaFromState(state);
		if (block.equals(Resources.rock.getBlock()) && meta != BlockRock.StoneTypes.RELICSTONE.getMeta()) {
			return Resources.rock.getBlock().getStateFromMeta(type);
		} else if (block.equals(Resources.brick.getBlock()) && meta != BlockRock.StoneTypes.RELICSTONE.getMeta()) {
			return Resources.brick.getBlock().getStateFromMeta(type);
		} else if (block.equals(Resources.sunstoneStone.slab.getBlock())) {
			return stoneSlabs[type].getStateFromMeta(meta);
		} else if (block.equals(Resources.sunstoneStone.stairs.getBlock())) {
			return stoneStairs[type].getStateFromMeta(meta);
		} else if (block.equals(Resources.sunstoneStone.wall.getBlock())) {
			return stoneWalls[type];
		} else if (block.equals(Resources.sunstoneBrick.slab.getBlock())) {
			return brickSlabs[type].getStateFromMeta(meta);
		} else if (block.equals(Resources.sunstoneBrick.stairs.getBlock())) {
			return brickStairs[type].getStateFromMeta(meta);
		} else if (block.equals(Resources.sunstoneBrick.wall.getBlock())) {
			return brickWalls[type];
		} else if (block.equals(Resources.palmFern.getBlock())) {
			return plants[rand.nextInt(plants.length)];
		}
		return state;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		return false;
	}
}