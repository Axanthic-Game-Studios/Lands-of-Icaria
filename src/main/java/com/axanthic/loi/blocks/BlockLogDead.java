package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockLogDead extends Block implements IBlockMaterial
{
	public BlockPlanks.WoodTypes type;

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public BlockLogDead(BlockPlanks.WoodTypes type)
	{
		this(type, "log_dead");
		this.setRegistryName(ModInformation.ID, "log_dead_" + type.unlocalizedName);
	}

	public BlockLogDead(BlockPlanks.WoodTypes type, String name)
	{
		super(Material.WOOD);
		this.type = type;
		this.setUnlocalizedName(name);
		this.setHardness(2.0F);
		this.setResistance(2.0F);
		this.setSoundType(SoundType.WOOD);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isFullCube(IBlockState state)
	{
		return true;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 5;
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 5;
	}

	@Override
	public int getHarvestLevel(IBlockState state)
	{
		return 0;
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(FACING).getIndex();
	}

	@Override
	@SuppressWarnings("deprecation")
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.SOLID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, FACING);
	}

	@Override
	@SuppressWarnings("deprecation")
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}

	@Override
	@SuppressWarnings("deprecation")
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y)
		{
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	@Nullable
	public String getHarvestTool(IBlockState state)
	{
		return "axe";
	}

	@Override
	public String getName()
	{
		return "material." + type.getName() + ".name";
	}
}