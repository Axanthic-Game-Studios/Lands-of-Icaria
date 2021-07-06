package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockGroundCover extends Block
{
	public static final PropertyInteger LAYERS = PropertyInteger.create("layers", 1, 8);
	public static final AxisAlignedBB[] MOSS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};

	public BlockGroundCover(String name)
	{
		super(Material.PLANTS, MapColor.LIME_STAINED_HARDENED_CLAY);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setSoundType(SoundType.SNOW);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LAYERS, 1));
	}

	@Override
	public int getHarvestLevel(IBlockState state)
	{
		return 0;
	}

	@Override
	@Nullable
	public String getHarvestTool(IBlockState state)
	{
		return "shovel";
	}

	@Override
	public boolean canSpawnInBlock()
	{
		return true;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(LAYERS) - 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	@SuppressWarnings("deprecation")
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return MOSS_AABB[state.getValue(LAYERS)];
	}

	@Override
	public BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, LAYERS);
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos).getValue(LAYERS) < 5;
	}

	@Override
	@SuppressWarnings("deprecation")
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(LAYERS, (meta & 7) + 1);
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		BlockFaceShape blockfaceshape = worldIn.getBlockState(pos.down()).getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP);
		return blockfaceshape == BlockFaceShape.SOLID;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!this.canPlaceBlockAt(worldIn, pos))
		{
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	@Nullable
	@SuppressWarnings("deprecation")
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		int i = blockState.getValue(LAYERS) - 1;
		AxisAlignedBB axisalignedbb = blockState.getBoundingBox(worldIn, pos);
		return new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ, axisalignedbb.maxX, (float)i * 0.125F, axisalignedbb.maxZ);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(Block.getBlockFromItem(playerIn.getHeldItem(hand).getItem()) == this)
		{
			for(int i = 1; i < 8; i++)
			{
				if(state == this.getDefaultState().withProperty(LAYERS, i))
				{
					if(facing == EnumFacing.UP)
					{
						worldIn.setBlockState(pos, this.getDefaultState().withProperty(LAYERS, i + 1));
						playerIn.playSound(SoundEvents.BLOCK_SNOW_PLACE, 1.0F, 1.0F);
					}

					if(worldIn.isAirBlock(pos.north()) && !worldIn.isAirBlock(pos.north().down()))
					{
						if (facing == EnumFacing.NORTH)
						{
							worldIn.setBlockState(pos.north(), this.getDefaultState().withProperty(LAYERS, 1));
							playerIn.playSound(SoundEvents.BLOCK_SNOW_PLACE, 1.0F, 1.0F);
						}
					}

					if(worldIn.isAirBlock(pos.south()) && !worldIn.isAirBlock(pos.south().down()))
					{
						if (facing == EnumFacing.SOUTH)
						{
							worldIn.setBlockState(pos.south(), this.getDefaultState().withProperty(LAYERS, 1));
							playerIn.playSound(SoundEvents.BLOCK_SNOW_PLACE, 1.0F, 1.0F);
						}
					}

					if(worldIn.isAirBlock(pos.east()) && !worldIn.isAirBlock(pos.east().down()))
					{
						if (facing == EnumFacing.EAST)
						{
							worldIn.setBlockState(pos.east(), this.getDefaultState().withProperty(LAYERS, 1));
							playerIn.playSound(SoundEvents.BLOCK_SNOW_PLACE, 1.0F, 1.0F);
						}
					}

					if(worldIn.isAirBlock(pos.west()) && !worldIn.isAirBlock(pos.west().down()))
					{
						if (facing == EnumFacing.WEST)
						{
							worldIn.setBlockState(pos.west(), this.getDefaultState().withProperty(LAYERS, 1));
							playerIn.playSound(SoundEvents.BLOCK_SNOW_PLACE, 1.0F, 1.0F);
						}
					}

					return true;
				}
			}
		}

		return false;
	}
}