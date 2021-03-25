package com.axanthic.loi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.worldgen.dimension.TeleporterLOI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockIcariaPortal extends BlockBreakable {

	//actual max width is double this plus 1
	public static int maxWidth = 20;
	public static int maxHeight = 40;
	public static int minHeight = 3;

	public static final PropertyEnum<EnumFacing.Axis> AXIS = BlockPortal.AXIS;
	public static final AxisAlignedBB X_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D);
	public static final AxisAlignedBB Z_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D);

	public static List<IBlockState> validTopSlabs = new ArrayList<IBlockState>();
	public static List<IBlockState> validSideSlabs = new ArrayList<IBlockState>();
	public static List<IBlockState> validPillars = new ArrayList<IBlockState>();
	public static List<IBlockState> validPillarTops = new ArrayList<IBlockState>();

	public BlockIcariaPortal() {
		super(Material.PORTAL, false);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.X));
		this.setHardness(-1.0F);
		this.setSoundType(SoundType.GLASS);
		this.setLightLevel(0.35F);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setUnlocalizedName("icaria_portal");
		this.setRegistryName(ModInformation.ID, "icaria_portal");
	}

	public static void init() {
		validTopSlabs.add(Blocks.STONE_SLAB.getStateFromMeta(7));
		validTopSlabs.add(Resources.smoothDolomite.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneBrick.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneCrackBrick.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneCrackTile.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneDraftBrick.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneDraftTile.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneMossBrick.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneMossTile.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneSmooth.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneStone.slab.getBlock().getStateFromMeta(1));
		validTopSlabs.add(Resources.relicstoneTile.slab.getBlock().getStateFromMeta(1));

		validSideSlabs.add(Blocks.STONE_SLAB.getStateFromMeta(15));
		validSideSlabs.add(Resources.smoothDolomite.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneBrick.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneCrackBrick.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneCrackTile.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneDraftBrick.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneDraftTile.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneMossBrick.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneMossTile.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneSmooth.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneStone.slab.getBlock().getStateFromMeta(0));
		validSideSlabs.add(Resources.relicstoneTile.slab.getBlock().getStateFromMeta(0));

		validPillars.add(Blocks.QUARTZ_BLOCK.getStateFromMeta(2));
		validPillars.add(Resources.dolomitePillar.getBlock().getStateFromMeta(0));
		validPillars.add(Resources.pillar.getBlock().getStateFromMeta(0));

		validPillarTops.add(Resources.quartzPillarHead.getBlock().getStateFromMeta(0));
		validPillarTops.add(Resources.dolomitePillarHead.getBlock().getStateFromMeta(0));
		validPillarTops.add(Resources.pillarHead.getBlock().getStateFromMeta(0));
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch ((EnumFacing.Axis)state.getValue(AXIS)) {
		case X:
		default:
			return X_AABB;
		case Z:
			return Z_AABB;
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos neighborPos) {
		EnumFacing.Axis axis = (EnumFacing.Axis)state.getValue(AXIS);
		EnumFacing direction = EnumFacing.UP;
		for (EnumFacing face : EnumFacing.values())
			if (pos.offset(face).equals(neighborPos))
				direction = face;

		if (axis.equals(direction.getAxis()) || direction.equals(EnumFacing.UP) || direction.equals(EnumFacing.DOWN)) {
			if (!isValid(state, world, pos)) {
				world.setBlockState(pos, Blocks.AIR.getDefaultState());
			}
		}
	}

	public static boolean isValid(IBlockState state, World world, BlockPos pos) {
		EnumFacing.Axis axis = (EnumFacing.Axis)state.getValue(AXIS);
		EnumFacing right = EnumFacing.NORTH;
		if (axis.equals(EnumFacing.Axis.X))
			right = EnumFacing.EAST;

		IBlockState rightState = world.getBlockState(pos.offset(right));
		IBlockState leftState = world.getBlockState(pos.offset(right.getOpposite()));
		IBlockState upState = world.getBlockState(pos.offset(EnumFacing.UP));
		IBlockState downState = world.getBlockState(pos.offset(EnumFacing.DOWN));

		if (rightState == state && leftState == state)
			return true;
		if (rightState == state && validPillars.contains(leftState) && upState == state)
			return true;
		if (leftState == state && validPillars.contains(rightState) && upState == state)
			return true;
		if (rightState == state && validPillarTops.contains(leftState) && validTopSlabs.contains(upState) && downState == state)
			return true;
		if (leftState == state && validPillarTops.contains(rightState) && validTopSlabs.contains(upState) && downState == state)
			return true;
		return false;
	}

	public static boolean tryMakePortal(World world, BlockPos pos) {
		BlockPos[] basePillars = new BlockPos[4];

		//find ground
		if (!world.isSideSolid(pos.down(), EnumFacing.UP)) {
			for (int i = 1; i < maxHeight; ++i) {
				pos = pos.down();
				if (world.isSideSolid(pos.down(), EnumFacing.UP))
					break;
			}
		}
		if (canReplace(world, pos) && world.isSideSolid(pos.down(), EnumFacing.UP)) {
			//find pillar bases
			for (EnumFacing dir : EnumFacing.HORIZONTALS) {
				for (int i = 1; i < maxWidth; ++i) {
					if (!(canReplace(world, pos.offset(dir, i)) && world.isSideSolid(pos.offset(dir, i).down(), EnumFacing.UP))) {
						if (validPillars.contains(world.getBlockState(pos.offset(dir, i)))) {
							basePillars[dir.getHorizontalIndex()] = pos.offset(dir, i);
						}
						break;
					}
				}
			}
			if (basePillars[EnumFacing.NORTH.getHorizontalIndex()] != null && basePillars[EnumFacing.SOUTH.getHorizontalIndex()] != null) {
				int heightNorth = getPillarHeight(world, basePillars[EnumFacing.NORTH.getHorizontalIndex()], EnumFacing.NORTH);
				int heightSouth = getPillarHeight(world, basePillars[EnumFacing.SOUTH.getHorizontalIndex()], EnumFacing.SOUTH);
				if (heightNorth >= minHeight - 1 && heightSouth == heightNorth) {
					boolean isObstructed = false;
					for (BlockPos currentPos : BlockPos.getAllInBox(basePillars[EnumFacing.NORTH.getHorizontalIndex()].south(), basePillars[EnumFacing.SOUTH.getHorizontalIndex()].north().up(heightSouth))) {
						if (!canReplace(world, currentPos)) {
							isObstructed = true;
							break;
						}
					}
					if (!isObstructed) {
						for (BlockPos currentPos : BlockPos.getAllInBox(basePillars[EnumFacing.NORTH.getHorizontalIndex()].south(), basePillars[EnumFacing.SOUTH.getHorizontalIndex()].north().up(heightSouth))) {
							world.setBlockState(currentPos, Resources.portal.getBlock().getDefaultState().withProperty(AXIS, EnumFacing.Axis.Z), 2);
						}
						return true;
					}
				}
			}
			if (basePillars[EnumFacing.WEST.getHorizontalIndex()] != null && basePillars[EnumFacing.EAST.getHorizontalIndex()] != null) {
				int heightWest = getPillarHeight(world, basePillars[EnumFacing.WEST.getHorizontalIndex()], EnumFacing.WEST);
				int heightEast = getPillarHeight(world, basePillars[EnumFacing.EAST.getHorizontalIndex()], EnumFacing.EAST);
				if (heightWest >= minHeight - 1 && heightEast == heightWest) {
					boolean isObstructed = false;
					for (BlockPos currentPos : BlockPos.getAllInBox(basePillars[EnumFacing.WEST.getHorizontalIndex()].east(), basePillars[EnumFacing.EAST.getHorizontalIndex()].west().up(heightEast))) {
						if (!canReplace(world, currentPos)) {
							isObstructed = true;
							break;
						}
					}
					if (!isObstructed) {
						for (BlockPos currentPos : BlockPos.getAllInBox(basePillars[EnumFacing.WEST.getHorizontalIndex()].east(), basePillars[EnumFacing.EAST.getHorizontalIndex()].west().up(heightEast))) {
							world.setBlockState(currentPos, Resources.portal.getBlock().getDefaultState().withProperty(AXIS, EnumFacing.Axis.X), 2);
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean canReplace(World world, BlockPos pos) {
		return world.getBlockState(pos).getBlock().isReplaceable(world, pos);
	}

	public static int getPillarHeight(World world, BlockPos pillarPos, EnumFacing face) {
		for (int i = 1; i < maxHeight; ++i) {
			if (!validPillars.contains(world.getBlockState(pillarPos.up(i)))) {
				if (validPillarTops.contains(world.getBlockState(pillarPos.up(i))) &&
						validTopSlabs.contains(world.getBlockState(pillarPos.up(i + 1))) &&
						validTopSlabs.contains(world.getBlockState(pillarPos.up(i + 1).offset(face.getOpposite()))) &&
						validSideSlabs.contains(world.getBlockState(pillarPos.up(i).offset(face)))) {
					return i;
				}
				return 0;
			}
		}
		return 0;
	}

	public static EnumFacing.Axis otherAxis(EnumFacing.Axis axis) {
		if (axis.equals(EnumFacing.Axis.Z))
			return EnumFacing.Axis.X;
		return EnumFacing.Axis.Z;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (!entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP && entity.timeUntilPortal <= 0) {
			EntityPlayerMP player = (EntityPlayerMP) entity;
			final int dimension = player.dimension == LandsOfIcaria.dimensionId ? DimensionType.OVERWORLD.getId() : LandsOfIcaria.dimensionId;
			changeDimension(world, (EntityPlayerMP) entity, dimension, new TeleporterLOI(player.mcServer.getWorld(dimension)));
		}
	}

	public static void changeDimension(World world, EntityPlayerMP player, int dimension, ITeleporter teleporter) {
		if (!world.isRemote) {
			player.changeDimension(dimension, teleporter);
			player.timeUntilPortal = 300;
			if (player.dimension == LandsOfIcaria.dimensionId) {
				BlockPos playerPos = new BlockPos(player);
				if (world.isAirBlock(playerPos) && world.getBlockState(playerPos).isSideSolid(world, playerPos, EnumFacing.UP)) {
					player.setSpawnChunk(playerPos, true, LandsOfIcaria.dimensionId);
				}
			}
		}
	}

	@Override
	@Nonnull
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@Nonnull
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(AXIS, otherAxis(placer.getHorizontalFacing().getAxis()));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing.Axis axis = (EnumFacing.Axis)state.getValue(AXIS);
		if (axis == EnumFacing.Axis.X)
			return 1;
		return axis == EnumFacing.Axis.Z ? 2 : 0;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch ((EnumFacing.Axis)state.getValue(AXIS)) {
			case X:
				return state.withProperty(AXIS, EnumFacing.Axis.Z);
			case Z:
				return state.withProperty(AXIS, EnumFacing.Axis.X);
			default:
				return state;
			}
		default:
			return state;
		}
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AXIS});
	}
}