package com.axanthic.loi.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemResources;
import com.axanthic.loi.tileentity.TileEntityColoredLight;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGem extends BlockSixDirectional implements ITileEntityProvider {

	private String unlocalizedName;
	public static final AxisAlignedBB GEM_AABB = new AxisAlignedBB(0.25D, 0.75D, 0.25D, 0.75D, 0.25D, 0.75D);
	public static final AxisAlignedBB GEM_AABB_UP = GEM_AABB.offset(0.0D, -0.25D, 0.0D);
	public static final AxisAlignedBB GEM_AABB_DOWN = GEM_AABB.offset(0.0D, 0.25D, 0.0D);
	public static final AxisAlignedBB GEM_AABB_NORTH = GEM_AABB.offset(0.0D, 0.0D, 0.25D);
	public static final AxisAlignedBB GEM_AABB_SOUTH = GEM_AABB.offset(0.0D, 0.0D, -0.25D);
	public static final AxisAlignedBB GEM_AABB_WEST = GEM_AABB.offset(0.25D, 0.0D, 0.0D);
	public static final AxisAlignedBB GEM_AABB_EAST = GEM_AABB.offset(-0.25D, 0.0D, 0.0D);

	public BlockGem(String name) {
		super(Material.GLASS, MapColor.AIR);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(0.0F);
		this.fullBlock = false;
		this.setLightOpacity(0);
		this.translucent = true;
		this.setUnlocalizedName(name);
		unlocalizedName = name;
		this.setLightLevel(0.3F);
		this.setRegistryName(ModInformation.ID, name);
		this.setSoundType(SoundType.GLASS);
		this.hasTileEntity = true;//LOIConfig.compat.albedo && Loader.isModLoaded("albedo");
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return this.hasTileEntity;
	}

	@Nullable
	public TileEntity createTileEntity(World world, IBlockState state) {
		EnumFacing offset = (EnumFacing) state.getValue(FACING);
		if (unlocalizedName.equals("calcite"))
			return new TileEntityColoredLight(1.0F * 0.5F, 0.714F * 0.5F, 0.557F * 0.5F).setOffset(offset);
		if (unlocalizedName.equals("halite"))
			return new TileEntityColoredLight(0.565F * 0.5F, 1.0F * 0.5F, 0.757F * 0.5F).setOffset(offset);
		if (unlocalizedName.equals("jasper"))
			return new TileEntityColoredLight(1.0F * 0.5F, 0.318F * 0.5F, 0.396F * 0.5F).setOffset(offset);
		if (unlocalizedName.equals("zircon"))
			return new TileEntityColoredLight(0.361F * 0.5F, 0.467F * 0.5F, 1.0F * 0.5F).setOffset(offset);
		return new TileEntityColoredLight().setOffset(offset);
	}

	@Override
	public String getUnlocalizedName() {
		return "material." + unlocalizedName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
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
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing offset = (EnumFacing) state.getValue(FACING);
		if (offset == EnumFacing.UP)
			return GEM_AABB_UP;
		if (offset == EnumFacing.DOWN)
			return GEM_AABB_DOWN;
		if (offset == EnumFacing.NORTH)
			return GEM_AABB_NORTH;
		if (offset == EnumFacing.SOUTH)
			return GEM_AABB_SOUTH;
		if (offset == EnumFacing.WEST)
			return GEM_AABB_WEST;
		if (offset == EnumFacing.EAST)
			return GEM_AABB_EAST;
		return GEM_AABB;
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		if (unlocalizedName.equals("calcite"))
			return 2;
		if (unlocalizedName.equals("halite"))
			return 3;
		if (unlocalizedName.equals("jasper"))
			return 5;
		if (unlocalizedName.equals("zircon"))
			return 6;
		return 0;
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		ItemStack stack = player.getHeldItemMainhand();
		IBlockState state = world.getBlockState(pos);
		int toolLevel = stack.getItem().getHarvestLevel(stack, "pickaxe", player, state);
		if (stack.getItem().getRegistryName().getResourceDomain().equals(ModInformation.ID)) {
			toolLevel += 2;
		}
		return toolLevel >= this.getHarvestLevel(state);
	}

	@Deprecated
	public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World worldIn, BlockPos pos) {
		return this.canHarvestBlock(worldIn, pos, player) ? super.getPlayerRelativeBlockHardness(state, player, worldIn, pos) : -1.0F;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.resource;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ItemResources.ResourceType.byName(unlocalizedName).toMeta();
	}

	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		for (EnumFacing enumfacing : FACING.getAllowedValues()) {
			if (this.canPlaceBlockOnSide(worldIn, pos, enumfacing)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing facing) {
		BlockPos blockpos = pos.offset(facing.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		Block block = iblockstate.getBlock();
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, blockpos, facing);

		return !isExceptBlockForAttachWithPiston(block) && blockfaceshape == BlockFaceShape.SOLID;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.checkForDrop(worldIn, pos, state);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		this.checkForDrop(worldIn, pos, state);
	}

	public boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state) {
		if (state.getBlock() == this && this.canPlaceBlockOnSide(worldIn, pos, (EnumFacing)state.getValue(FACING))) {
			return true;
		}
		if (worldIn.getBlockState(pos).getBlock() == this) {
			worldIn.destroyBlock(pos, true);
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return this.createTileEntity(worldIn, null);
	}
}
