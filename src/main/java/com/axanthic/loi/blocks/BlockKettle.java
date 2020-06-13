package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.tileentity.TileEntityKettle;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockKettle extends Block implements ITileEntityProvider {

	protected static final AxisAlignedBB KETTLE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 15.5D / 16.0D, 1.0D);
	private static boolean keepInventory = false;

	public BlockKettle() {
		super(Material.IRON, MapColor.BLACK_STAINED_HARDENED_CLAY);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(2.0F);
		this.setUnlocalizedName("crafting_kettle");
		this.setRegistryName(ModInformation.ID, "crafting_kettle");
		this.setSoundType(SoundType.STONE);
	}

	public static void setState(IBlockState state, World worldIn, BlockPos pos) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		keepInventory = true;
		worldIn.setBlockState(pos, state, 3);
		worldIn.setBlockState(pos, state, 3);
		keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return KETTLE_AABB;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (keepInventory)
			return;
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityKettle();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			ItemStack heldItem = playerIn.getHeldItem(hand);
			if (!heldItem.isEmpty() && FluidUtil.interactWithFluidHandler(playerIn, hand, worldIn, pos, facing))
				return true;

			if (((TileEntityKettle) worldIn.getTileEntity(pos)).getFluidLevel() == 0)
				return false;

			return ((TileEntityKettle) worldIn.getTileEntity(pos)).addIngredient(playerIn.getHeldItem(hand)) || ((TileEntityKettle) worldIn.getTileEntity(pos)).craft(playerIn, hand);
		}
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		//TODO add comparator compatibility
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		if (face.equals(EnumFacing.UP))
			return BlockFaceShape.BOWL;
		return BlockFaceShape.UNDEFINED;
	}
}
