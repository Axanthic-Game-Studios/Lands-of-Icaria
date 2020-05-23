package com.axanthic.loi.blocks;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.blocks.BlockBasic;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCardonCactus extends BlockBasic implements net.minecraftforge.common.IPlantable {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");

	public BlockCardonCactus() {
		super(Material.CACTUS, 0.7F, "cardon_cactus", MapColor.LIME_STAINED_HARDENED_CLAY);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setSoundType(SoundType.CLOTH);
		this.setTickRandomly(true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(UP, Boolean.valueOf(false)).withProperty(DOWN, Boolean.valueOf(false)).withProperty(AGE, Integer.valueOf(0)));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 1))
			return;
		if (!this.canSurviveAt(worldIn, pos)) {
			worldIn.destroyBlock(pos, true);
			return;
		}
		state = this.getActualState(state, worldIn, pos);
		int j = ((Integer) state.getValue(AGE)).intValue();
		if (worldIn.getBlockState(pos.down()).getBlock() == this && !this.getActualState(worldIn.getBlockState(pos.down()), worldIn, pos.down()).getValue(DOWN)) {
			if (j != 15)
				worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
			return;
		}
		int i;
		for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i);
		if (i > 4)
			return;
		if (state.getValue(DOWN) && worldIn.isAirBlock(pos.up()) && i > 1 && i < 4) {
			for (EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
				if (rand.nextInt(4) == 0) {
					BlockPos blockpos = pos.offset(facing);
					if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).getBlock() != this) {
						if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true)) {
							if (j == 15) {
								worldIn.setBlockState(blockpos, this.getDefaultState());
								IBlockState iblockstate = state.withProperty(AGE, 0);
								worldIn.setBlockState(pos, iblockstate, 4);
								iblockstate.neighborChanged(worldIn, blockpos, this, pos);
								j = 0;
							} else {
								worldIn.setBlockState(pos, state.withProperty(AGE, j + 1), 4);
							}
							net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
						}
					}
					break;
				}
			}
		}
		BlockPos blockpos = pos.up();
		if (worldIn.isAirBlock(blockpos)) {
			if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true)) {
				if (j == 15) {
					worldIn.setBlockState(blockpos, this.getDefaultState());
					IBlockState iblockstate = state.withProperty(AGE, 0);
					worldIn.setBlockState(pos, iblockstate, 4);
					iblockstate.neighborChanged(worldIn, blockpos, this, pos);
				} else {
					worldIn.setBlockState(pos, state.withProperty(AGE, j + 1), 4);
				}
				net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
			}
		}
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		IBlockState stateDown = worldIn.getBlockState(pos.down());
		Boolean down = this.shouldConnectDown(stateDown, worldIn, pos);
		Boolean up = worldIn.getBlockState(pos.up()).getBlock().equals(this);
		Boolean north = worldIn.getBlockState(pos.north()).getBlock().equals(this);
		Boolean east = worldIn.getBlockState(pos.east()).getBlock().equals(this);
		Boolean south = worldIn.getBlockState(pos.south()).getBlock().equals(this);
		Boolean west = worldIn.getBlockState(pos.west()).getBlock().equals(this);
		if (down) {
			north = north && !this.shouldConnectDown(worldIn.getBlockState(pos.north().down()), worldIn, pos.north());
			east = east && !this.shouldConnectDown(worldIn.getBlockState(pos.east().down()), worldIn, pos.east());
			south = south && !this.shouldConnectDown(worldIn.getBlockState(pos.south().down()), worldIn, pos.south());
			west = west && !this.shouldConnectDown(worldIn.getBlockState(pos.west().down()), worldIn, pos.west());
		}
		return state.withProperty(DOWN, down).withProperty(UP, up).withProperty(NORTH, north).withProperty(EAST, east).withProperty(SOUTH, south).withProperty(WEST, west);
	}

	public Boolean shouldConnectDown(IBlockState stateDown, IBlockAccess worldIn, BlockPos pos) {
		return stateDown.getBlock().equals(this) || stateDown.getBlock().canSustainPlant(stateDown, worldIn, pos.down(), EnumFacing.UP, this);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		float f1 = ((Boolean) state.getValue(WEST)).booleanValue() ? 0.0F : 0.25F;
		float f2 = ((Boolean) state.getValue(DOWN)).booleanValue() ? 0.0F : 0.25F;
		float f3 = ((Boolean) state.getValue(NORTH)).booleanValue() ? 0.0F : 0.25F;
		float f4 = ((Boolean) state.getValue(EAST)).booleanValue() ? 1.0F : 0.75F;
		float f5 = ((Boolean) state.getValue(UP)).booleanValue() ? 1.0F : 0.75F;
		float f6 = ((Boolean) state.getValue(SOUTH)).booleanValue() ? 1.0F : 0.75F;
		return new AxisAlignedBB((double) f1, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6);
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
		if (!isActualState)
			state = state.getActualState(worldIn, pos);

		float f = 0.1875F;
		float f1 = 0.8125F;
		addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.25D, 0.25D, 0.25D, 0.75D, 0.75D, 0.75D));

		if (((Boolean) state.getValue(WEST)).booleanValue())
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0D, 0.25D, 0.25D, 0.25D, 0.75D, 0.75D));

		if (((Boolean) state.getValue(EAST)).booleanValue())
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.75D, 0.25D, 0.25D, 1.0D, 0.75D, 0.75D));

		if (((Boolean) state.getValue(UP)).booleanValue())
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.25D, 0.75D, 0.25D, 0.75D, 1.0D, 0.75D));

		if (((Boolean) state.getValue(DOWN)).booleanValue())
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.25D, 0.75D));

		if (((Boolean) state.getValue(NORTH)).booleanValue())
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.25D, 0.25D, 0.0D, 0.75D, 0.75D, 0.25D));

		if (((Boolean) state.getValue(SOUTH)).booleanValue())
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.25D, 0.25D, 0.75D, 0.75D, 0.75D, 1.0D));
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) ? this.canSurviveAt(worldIn, pos) : false;
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!this.canSurviveAt(worldIn, pos)) {
			worldIn.destroyBlock(pos, true);
		}
	}

	public boolean canSurviveAt(World worldIn, BlockPos pos) {
		boolean flag = worldIn.isAirBlock(pos.up());
		boolean flag1 = worldIn.isAirBlock(pos.down());
		IBlockState state = worldIn.getBlockState(pos.down());

		for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
			BlockPos blockpos = pos.offset(enumfacing);
			Block block = worldIn.getBlockState(blockpos).getBlock();

			if (block == this) {
				Block block1 = worldIn.getBlockState(blockpos.down()).getBlock();

				if (block1 == this || state.getBlock().canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this)) {
					return true;
				}
			}
		}

		Block block2 = worldIn.getBlockState(pos.down()).getBlock();
		return block2 == this || state.getBlock().canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { NORTH, EAST, SOUTH, WEST, UP, DOWN, AGE });
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
	}

	@Override
	public net.minecraft.pathfinding.PathNodeType getAiPathNodeType(IBlockState state, IBlockAccess world, BlockPos pos) {
		return net.minecraft.pathfinding.PathNodeType.DAMAGE_CACTUS;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer) state.getValue(AGE)).intValue();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		Block block = blockAccess.getBlockState(pos.offset(side)).getBlock();
		return block != this && (side != EnumFacing.DOWN || block != Blocks.END_STONE);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return net.minecraftforge.common.EnumPlantType.Desert;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return getDefaultState();
	}
}